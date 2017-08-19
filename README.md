# Spring-Whoops [![Build Status](https://travis-ci.org/jstumpp/spring-whoops.svg?branch=master)](https://travis-ci.org/jstumpp/spring-whoops)

Pretty error page for Spring Boot that helps you debug your web application in the browser. Because Spring stacktraces can be hard to read in the console!
 * See request parameters, headers, route, session and response status
 * Full Stacktrace
 * Source Code preview
 * Open file in IntelliJ IDEA exactly where the exception was thrown

![image](img/screenshot.png)

## Dependency
### Maven
```xml
<dependency>
    <groupId>com.github.jstumpp</groupId>
    <artifactId>spring-whoops</artifactId>
    <version>0.1.0</version>
</dependency>
```
### Gradle
```groovy
compile('com.github.jstumpp:spring-whoops:0.1.0')
```

## Usage
To utilize, implement an ErrorController in your project:
```java
import com.github.jstumpp.spring.whoops.Whoops;
import com.mitchellbosecke.pebble.error.PebbleException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class DefaultErrorController implements ErrorController {

    private static final String PATH = "/error";

    @Autowired
    private ErrorAttributes errorAttributes;

    private Whoops whoops = new Whoops();

    @RequestMapping(value = PATH)
    public String error(HttpServletRequest request, HttpServletResponse response) throws IOException, PebbleException {
        return whoops.prettyPage(errorAttributes, request, response);
    }

    @Override
    public String getErrorPath() {
        return PATH;
    }
}
```

## Notes:

* This handler reveals server internals and possibly code. Only install it when you are developing and make sure to disable it before pushing to production.
* Finding code snippets is an imperfect art since the original file locations are not preserved in the compiled bytecode. Thus, by default code snippets will only be displayed if the Java source file for the corresponding exception stack frame is available within the working directory under `src/main/java` or `src/main/test` and you are properly following the Java naming and directory structure conventions.

## Credits:

By [jstumpp](https://github.com/jstumpp/). Based on [jooby/whoops](https://github.com/jooby-project/jooby/tree/master/modules/jooby-whoops) and [filp/whoops](http://filp.github.io/whoops/).