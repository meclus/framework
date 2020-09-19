# framework

mickey's simple java framework

![Dev Build status](https://github.com/meclus/framework/workflows/Dev%20Build/badge.svg "Dev Build")

updated to spring boot 2.1.8

框架主要功能有：

1. 根据po自动建表
2. 通用service、mapper
3. 文件存储对接COS

---

## 1. po自动建表使用

配置文件中打开自动建表配置

```properties
org.mickey.framework.db-inspector.enabled=true
```

po类继承与BasePo或CommonPo，例如

```java
@Data
@Table(name = "mick_user")
public class UserPo extends BasePo {
    @ApiModelProperty(value = "length: 50 ; user name", required = true)
    @NotNull(message = "用户名不能为空", groups = {Groups.Insert.class, Groups.Update.class})
    @Column(columnDefinition = "varchar(50) comment 'user name'")
    private String userName;
}
```

## 2. 通用mapper使用，继承与BaseMapper，并指明对应的po类

```java
public interface OsFileMapper extends BaseMapper<OsFilePo> {
}
```

通用service使用，service接口继承与IBaseService，并指明对应的po类；service实现类，继承与通用的service实现类GenericService<M extends BaseMapper<T>, T extends AbstractCommonPo>，实现类已实现通用的S C U D F操作

```java
public interface IOsFileService extends IBaseService<OsFilePo> {
}

@Service
public class OsFileServiceImpl extends GenericService<OsFileMapper, OsFilePo> implements IOsFileService {
}
```

## 3. 文件存储服务需要后续测试

```linshi
https://github-production-release-asset-2e65be.s3.amazonaws.com/140419044/1e1d4580-c6b0-11ea-8fc5-fe49e88b5674?X-Amz-Algorithm=AWS4-HMAC-SHA256&X-Amz-Credential=AKIAIWNJYAX4CSVEH53A%2F20200919%2Fus-east-1%2Fs3%2Faws4_request&X-Amz-Date=20200919T150212Z&X-Amz-Expires=300&X-Amz-Signature=d3f1f593d24b044050d98f34d71f2bfc86e63626c35c9b0aae697e0838c49d61&X-Amz-SignedHeaders=host&actor_id=12285105&key_id=0&repo_id=140419044&response-content-disposition=attachment%3B%20filename%3DOpenJDK11U-jdk_x64_mac_hotspot_11.0.8_10.pkg&response-content-type=application%2Foctet-stream
```
