# AppStart
# 这个库的功能：
为安卓提供，类似java的main方法环境，

# 如何使用

1. 在app 或者library 入口函数调用

```


public class DemoApplication extends Application {

    private static final List<OnAppCreateMethod> ON_APP_CREATE_METHODS = Arrays.asList(
            new OnAppCreateMethod(ClassNameToastUtil.class)
    );

    @Override
    public void onCreate() {
        super.onCreate();
        AppStarter
                .newBuilder(this)
                .supportAndroidManifest()
                .addAppInjectorList(ON_APP_CREATE_METHODS)
                .build()
                .dispatchAppCreate(this);
    }
}

```


2.入口方法，需要被OnAppCreate 注解标记

```
@OnAppCreate
public static void onAppCreate(Application app){
// do what you want when application on create method invoked

}


```





注入方式:
1. 支持在application 填写全类名

```
    private static final List<OnAppCreateMethod> ON_APP_CREATE_METHODS = Arrays.asList(
            new OnAppCreateMethod(ClassNameToastUtil.class)
    );
```

2. 支持android manifest 配置


```
<meta-data android:name:"appStarter://{类名}" android:value="参数列表，逗号分割"/>
```
3. 支持maven 远程依赖的方式,也是使用方式三实现的



