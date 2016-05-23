# spring-boot-fake-data
一个使用spring boot搭建的假数据返回应用，使用maven管理项目，war包方式运行.

使用假数据层，可以进行用户界面开发并降低对其他团队的依赖





# 快速使用
将JSON文件放到指定目录中，按照约定名称命名。 如首页轮播图的JSON数据，命名为GetBannerList.txt 

访问示例：
http://192.168.2.9:8053/zttc/JSON?method=GetBannerList





# spring-boot-fake-data 详细说明
使用方式：
http://192.168.2.9:8053/zttc/JSON?method=xxx
method对应的xxx是文件名  例如： method=GetBannerList 对应的为GetBannerList.txt

*.txt 文件添加, 可添加子文件夹，如课程相关，放到course目录下 注意：文件名不能重复

Windows访问
运行里输入   \\192.168.2.9   账号： stone-share   密码： 123456

Mac访问
打开Finder 前往服务器  192.168.2.9  输入用户名密码进入   账号： stone-share   密码： 123456



POST数据支持  POST参数  method 值为 txt的文件名
示例：http://192.168.2.9:8053/zttc/POSTJSON
