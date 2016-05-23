# spring-boot-fake-data
访问示例：
http://192.168.2.9:8053/zttc/JSON?method=GetBannerList


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
