# aws labmda java demo

## 一、脚本方式

1. 前置条件

   安装 AWS CLI 并配置访问密钥：

       pip3 install aws
       aws configure

2. 构建Jar包

       mvn clean package

3. 创建Lambda函数

       bash ./1-create.sh

4. 更新Lambda函数

       bash ./2-deploy.sh

5. 触发Lambda函数 - 脚本方式（函数输入在`event.json`文件）

       bash ./3-invoke.sh

6. 触发Lambda函数 - Java JDK

       mvn clean package exec:java -Dexec.mainClass="com.example.myproject.trigger.HelloTrigger"

## 二、手动方式

2. 创建lambda函数
    1. 进入 [AWS Lambda控制台](https://us-east-2.console.aws.amazon.com/lambda/home?region=us-east-2#/functions)

       ![img.png](img.png)
    2. `创建函数`
        1. 填写函数名称,`HelloJava`
        2. 选择运行时，`Java8 on Amazon Linux1`
        3. 完成创建

           ![img_1.png](img_1.png)

    3. 在 `代码源` 上传Jar包

       ![img_2.png](img_2.png)

    4. 编辑运行时设置，修改 `处理程序` ，填入lambda函数完整的包名路径

       ![img_3.png](img_3.png)
       ![img_4.png](img_4.png)

    5. 测试lambda函数

       ![img_5.png](img_5.png)
