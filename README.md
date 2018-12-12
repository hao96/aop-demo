# spring-aop
spring aop 学习体会
-----------------------------
简单理解，更详细信息，看官网[https://docs.spring.io/spring/docs/2.5.x/reference/aop.html]

#### spring aop 对于实现接口的类，则使用JDK的动态代理；对于未实现接口的类，则使用CGLIB来实现。
#### AspectJ(静态织入)依赖于特定的编译器（ajc编译器），将AspectJ的代码在编译时织入到class文件中（javac无法识别AspectJ代码）。
### aop 的概念：
        ascept : @Aspect 定义切面类
        join point : 在Spring aop中切点必须为`method`
        advice : 切面中特定切点的行为，在aop框架中，每个advice被封装成了拦截器，最终成为一条围绕某个切点的拦截器链条
        pointcut : advice会与被pointcut表达式匹配的join point联系到一起，在Spring aop中pointcut表达式默认使用AspectJ的表达式
        introduction : 引用，可以理解为 为匹配到的类实现指定的接口（配置一个接口的实现类）
        target object : 在Spring aop中，是被产生的代理类
        AOP proxy : Spring aop使用的是JDK的动态代理和CGLIB代理
        weaving : 将切面与应用类型或对象联系到一起并创建一个advise object,在Spring aop中是在运行时进行的（另外两种分别是：在编译时织入，加载时织入)
#### @Pointcut(value="",argNames="")
        `value:`切点表达式（规则），符合该表达式的所有方法都看作成切点。被定义成切点的方法的返回值类型为`void`
### 提供5种注解类型的通知函数：
        @Before(value="",argName="")
        `value:`指定切点
        调用方法之前执行，但无法阻止执行流到join point中。
        @AfterReturning(value = "",pointcut = "",returning = "",argNames = "")
        `value:`指定切点，`pointcut:`指定切点，如果使用该属性则代替value，`returning:`指定一变量名去存储返回的对象。
        该advice要被执行，必须要join point正常返回。
        @Around(value = "",argNames = "")
        `value:`指定切点
        @After(value = "" ,argNames = "")
        `value:`指定切点
        无论join point 正常返回，该advice都被执行
        @AfterThrowing(value="",pointcut="",throwing="",argNames="")
        throwing : 可以设置一个变量与join point中抛出的异常进行绑定。
