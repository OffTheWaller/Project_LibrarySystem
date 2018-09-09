## 后台图书管理系统的一套CURD

- 数据库名：library

- 数据表book

- | bid     | bname   | bprice | bimage  | bdate   | b_ishot | bdesc   | cid     |
  | ------- | ------- | ------ | ------- | ------- | ------- | ------- | ------- |
  | varchar | varchar | double | varchar | varchar | int     | varchar | varchar |


- 数据表category

- | cid     | cname   |
  | ------- | ------- |
  | varchar | varchar |


- 后台访问地址:http://localhost:8080/library-system/admin/
- 数据库文件：db.sql。导入MySQL即可