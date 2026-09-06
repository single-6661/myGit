# 登录流程图
<!-- 这是一个文本绘图，源码为：graph TD
首页{首页} --> 登录{登录};
登录 --> 拦截器;
拦截器 -->|验证成功| 操作{可在首页执行操作};
拦截器 -->|验证错误| 提示出错;
拦截器 --> |点击搜索框或评论时未登录| 提示登录;
弹出登录框 --> |返回| 登录;
操作 -->内容框;
内容框  --> 展开全文;
内容框 --> 展开评论;
展开评论 --> 输入评论可以发送并显示;
操作 --> 搜索框;
搜索框 --> 搜索下拉菜单;
搜索下拉菜单 --> |存在| 首页显示内容;
搜索下拉菜单 --> |不存在| 搜索空状态;


 -->
![](https://cdn.nlark.com/yuque/__mermaid_v3/eb3b933bbab76f027ac5a72e6fd9611f.svg)



# 交互逻辑
1. <font style="color:#DF2A3F;">未登录</font>时点击登录，评论，搜索框跳转搜索页面（点击查找 [ ] 的搜索结果）时自动跳转登录页面

已登录则均不可使用

2. 点击返回头部按钮返回头部
3. 点击阅读全文时展开全文
4. 点击评论打开评论框，输入并提交评论可以显示（由于api中没有用户评论，所以一开始为空，仅用户能显示评论）

# 登录用户信息（在后端直接写的，然后导入数据库）
<font style="color:rgb(61, 79, 88);"></font>**<font style="color:rgb(61, 79, 88);">username</font>**

<font style="color:rgb(18, 130, 77);">"大葱"</font>

**<font style="color:rgb(61, 79, 88);">password</font>**

<font style="color:rgb(18, 130, 77);">"123456"</font>

**<font style="color:rgb(61, 79, 88);">mobile</font>**

<font style="color:rgb(18, 130, 77);">"88888888"</font>

<font style="color:rgb(18, 130, 77);"></font>

# 项目工时
1.预估（3天）

2.实际（4-5天）重新复习vue，学做前后端跨域配置，拦截器逻辑，还有学习前端通过eventBus获取全局数据并渲染页面花了很久

# 依赖库
```plain

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mongodb</artifactId>
</dependency>

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-mongodb-test</artifactId>
    <scope>test</scope>
</dependency>
```

```plain

<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.62</version>
</dependency>
```

```plain
<dependency>
    <groupId>com.squareup.okhttp3</groupId>
    <artifactId>okhttp</artifactId>
    <version>4.1.0</version>
</dependency>

<dependency>
    <groupId>com.alibaba</groupId>
    <artifactId>fastjson</artifactId>
    <version>1.2.62</version>
</dependency>
```



# MongoDB数据
## hot（热点信息）
```plain
{
  "code": 200,
  "data": [
    {
      "hot": "深圳全市中小学生校服款式统一，学生家长可自行去商超购买，怎样看待这种模式？你支持全国推广吗？",
      "id": "6a96de1aec71f12a05a26203"
    },
    {
      "hot": "官方通报女子被踢出 845 个群被迫离职，用人单位已履行判决，事件中暴露的问题该如何有效解决？",
      "id": "6a96de1aec71f12a05a26204"
    },
    {
      "hot": "如何看待曝科大讯飞公关副总裁韩煜尘被解除职务？有什么隐情吗？",
      "id": "6a96de1aec71f12a05a26205"
    },
    {
      "hot": "9月1日起外籍个人从外商投资企业取得股息红利不再免征个税，如何解读？会带来多大规模的税收增量？",
      "id": "6a96de1aec71f12a05a26206"
    },
    {
      "hot": "越南批量设立直辖市，这对其经济发展和承接中国产业转移意味着什么？",
      "id": "6a96de1aec71f12a05a26207"
    },
    {
      "hot": "如何评价张一山、李沐宸主演的刑侦剧《重案六组：消失的警号》？",
      "id": "6a96de1aec71f12a05a26208"
    },
    {
      "hot": "如何看待宇树回应「重处罚少奖励」、100 元报销须王兴兴审批，称很多内容不实？公司该如何设计奖惩机制？",
      "id": "6a96de1aec71f12a05a26209"
    },
    {
      "hot": "当你进入金融行业时有什么惊人的发现？",
      "id": "6a96de1aec71f12a05a2620a"
    },
    {
      "hot": "为什么教堂没有功德箱？那教堂的收入从哪里来？",
      "id": "6a96de1aec71f12a05a2620b"
    },
    {
      "hot": "河南 5 人聚餐吃生鱼片确诊肝吸血虫病，如何避免该病？是否有扩散的风险？",
      "id": "6a96de1aec71f12a05a2620c"
    },
    {
      "hot": "高铁二等座变无座，12306 称临时调整无赔偿，此规定合理吗？",
      "id": "6a96de1aec71f12a05a2620d"
    },
    {
      "hot": "如何看待星际圈“九朵退会”引爆的“黄旭东朋友等级论”事件？",
      "id": "6a96de1aec71f12a05a2620e"
    },
    {
      "hot": "2026暑期档票房 124.98 亿，创影史最高场次纪录，《功夫女足》夺冠，如何评价这一成绩？",
      "id": "6a96de1aec71f12a05a2620f"
    },
    {
      "hot": "为什么一斤粮食还没有一瓶瓶装水贵？",
      "id": "6a96de1aec71f12a05a26210"
    },
    {
      "hot": "如何看待研究根据中美两国数据发现工时和消费的相关性，这是「多休息才能多消费」吗？",
      "id": "6a96de1aec71f12a05a26211"
    },
    {
      "hot": "R星确认GTA6每个房间都手工打造，连NPC喝什么、桌上留什么痕迹都精心设计，你看好这种细节投入吗？",
      "id": "6a96de1aec71f12a05a26212"
    },
    {
      "hot": "华为、小米、荣耀等手机品牌正式涨价，涨幅均超 200 元，最高涨千元，将对用户及手机市场带来哪些影响？",
      "id": "6a96de1aec71f12a05a26213"
    },
    {
      "hot": "藏族为啥爱去成都，而不是西宁？",
      "id": "6a96de1aec71f12a05a26214"
    },
    {
      "hot": "《脱口秀和Ta的朋友们》第三季，小奇夺冠算是意外吗？",
      "id": "6a96de1aec71f12a05a26215"
    },
    {
      "hot": "国产编程语言 zlangv0.12.2.0 发布，支持中文编程，这意味着什么？",
      "id": "6a96de1aec71f12a05a26216"
    },
    {
      "hot": "刘翔姚明苏炳添发展轨道大不同，只有刘翔陷入是否买断困境，是赛道不同还是性格和选择造成的？",
      "id": "6a96de1aec71f12a05a26217"
    },
    {
      "hot": "9.1 开学了，送孩子返校的家长和复工的老师们是什么心情？",
      "id": "6a96de1aec71f12a05a26218"
    },
    {
      "hot": "特斯拉在港澳推出更平价版 Model3，最低售价不足18万元，这个价格竞争力如何？会有人愿意买单吗？",
      "id": "6a96de1aec71f12a05a26219"
    },
    {
      "hot": "如何评价半个月不到，天蚕土豆的新书在读从1100多万跌到200万？",
      "id": "6a96de1aec71f12a05a2621a"
    },
    {
      "hot": "日剧里经常出现的障子纸门有什么特别之处，为什么明明容易破但还是延续了几百年？",
      "id": "6a96de1aec71f12a05a2621b"
    },
    {
      "hot": "以双鱼座阿布罗狄的能力他是如何能成黄金圣斗士的？",
      "id": "6a96de1aec71f12a05a2621c"
    },
    {
      "hot": "为什么鲁菜身为八大菜系之首，我们却很少见到鲁菜馆呢？",
      "id": "6a96de1aec71f12a05a2621d"
    },
    {
      "hot": "有人说说，申论的本质是啥？",
      "id": "6a96de1aec71f12a05a2621e"
    },
    {
      "hot": "U23国足亚运会大名单出炉，王钰栋在列，超龄球员吴曦、张玉宁、朱辰杰入选，如何看待这个阵容？",
      "id": "6a96de1aec71f12a05a2621f"
    },
    {
      "hot": "吉林一虎园幼虎疑被饲养员一脚踢昏，园方称饲养员遭幼虎咬住引发本能反应，幼虎咬人有多疼？踢昏它要多大力？",
      "id": "6a96de1aec71f12a05a26220"
    }
  ],
  "msg": "成功"
}
```

## content(帖子数据)
```plain
{
  "code": 200,
  "data": [
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "包含: java 基础, java 部分源码, jvm, spring, spring boot, spring cloud, 数据库原理, mysql, elasticsearch, mongodb, docker, k8s, ci&cd, linux, devops, 分布式, 中间件, 开发工具, git, ide, 源码阅读,读书笔记, 开源项目...",
      "date": "01‑22",
      "id": "6a96de1aec71f12a05a261ef",
      "title": " | java 全栈知识体系",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "这是一个为java学习者提供的学习资源网站,涵盖java基础、面向对象编程、常用框架、项目实战等内容,帮助你快速掌握java开发技能,提升编程能力。",
      "date": "01‑22",
      "id": "6a96de1aec71f12a05a261f0",
      "title": "java学习者",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "实际选择很简单：任务需要返回结果或者可能抛异常就用 Callable，不需要就用 Runnable。但要注意 Callable 配合 FutureTask 使用时，get() 是阻塞的，如果任务卡住了，调用方也会一直等。生产环境最好用带超时的 get(timeout, unit)。\n为什么生产环境要用线程池\n直接 new Thread() 有几个问题：\n1）线程创建和销毁都有开销，每次都 new 一个太浪费。\n2）没法控制并发数量，可能瞬间创建几千个线程把系统搞崩。\n3）没法统一管理，比如优雅关闭、异常处理这些都得自己搞。\n线程池解决了这些问题，提前创建好一批线程，任务来了就分配，执行完了线程还能复用。阿里巴巴 Java 开发手册明确规定不允许直接 new Thread()，必须走线程池。\n虚拟线程：Java 21 的新选择\nJava 21 正式引入了虚拟线程，这是个颠覆性的特性。传统线程是 1:1 映射到操作系统线程的，创建一个 Java 线程就要占用一个 OS 线程，内存开销大概 1MB 左右。虚拟线程是 M:N 模型，几十万个虚拟线程可能只用几十个 OS 线程来调度。\n// Java 21 虚拟线程\nThread.startVirtualThread(() -\u003E {\n    System.out.println(\"虚拟线程执行\");\n});\n\n// 或者用虚拟线程的 ExecutorService\ntry (var executor = Executors.newVirtualThreadPerTaskExecutor()) {\n    executor.submit(() -\u003E System.out.println(\"任务\"));\n}\n虚拟线程特别适合 IO 密集型场景，比如 Web 服务器处理大量请求。以前可能需要复杂的响应式编程，现在直接写同步代码，底层自动帮你异步处理。不过 CPU 密集型任务用虚拟线程没啥优势，因为最终还是要抢 CPU 核心。\nCompletableFuture 的优势\nCompletableFuture 不只是创建线程那么简单，它提供了一套完整的异步编程模型。能用 thenApply、thenCompose、thenCombine 这些方法把多个异步任务串起来或者并行执行，还能统一处理异常。\nCompletableFuture.supplyAsync(() -\u003E fetchUserInfo())\n",
      "date": "01‑18",
      "id": "6a96de1aec71f12a05a261f1",
      "title": "java线程基础? - 知乎",
      "voteUpCount": "3"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "FarmWise 项目复盘 · 第十一篇\n读完这篇文章，你将了解：\n1.一个普通 Java 对象通常在哪里创建；\n2.Young GC 如何回收大量短命对象；\n3.对象为什么会从 Eden 进入 Survivor，再进入 Old；\n4.G1 如何逐步回收年轻代和老年代；\n5.GC 为什么会影响请求延迟。\n引言\n上一篇文章跟着一次 FarmWise 请求走完了 JVM 中的主要运行过程。Controller、Service 和 Mapper 会不断创建 DTO、String、集合和查询结果，请求结束后，栈帧随方法返回而消失，而 Heap 中不再可达的对象则等待 GC 回收。但“等待 GC”之后具体发生了什么，还没有展开。\n假设一次请求中创建：\n对于这样一个普通对象，它可能经历：\n当然，大多数请求对象不会真的活到 Old。FarmWise 中大量 DTO 和临时集合，很可能在第一次 Young GC 时就已经失去作用。\n这一篇就沿着这个对象的生命周期，建立一个基本的 GC 运行模型。\n一、对象通常先进入 Eden\n执行 new SensorDTO() 时，JVM 需要从 Heap 中找到一块空间保存对象。\n在 G1 中，Heap 被划分成许多大小相同的 Region，一部分 Region 会承担 Eden，一部分承担 Survivor 和 Old。新创建的普通对象通常先进入 Eden。\n多线程环境下，如果所有线程都直接竞争同一个 Eden 分配位置，对象创建会产生额外同步开销。因此 HotSpot 通常会给线程划分自己的 TLAB，也就是 Thread Local Allocation Buffer。TLAB 本身仍然属于 Eden，只是由某个线程优先使用。这样大部分对象创建只需要在线程自己的 TLAB 中移动分配指针，速度非常快。\n随着请求不断到来，DTO、String、集合和其他临时对象也不断进入 Eden，直到年轻代空间逐渐不足。\n二、Young GC 只留下还活着的对象\n年轻代空间不足时，JVM 通常会触发 Young GC。\n首先要判断哪些对象仍然存活。\nJVM 会从线程栈、静态字段等 GC Roots 出发进行可达性分析：能够沿引用关系找到的对象仍然存活，无法找到的对象则可以回收。\n请求还没有结束时，线程栈中的 dto 变量还持有 SensorDTO 对象的引用，所以这个 DTO 仍然可达，不能回收。",
      "date": "01‑18",
      "id": "6a96de1aec71f12a05a261f2",
      "title": "Java 对象从创建到被 GC 回收的一生 - 知乎",
      "voteUpCount": "2"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "1",
      "commentInfolist": null,
      "contentText": "生态更好这四个字得分维度看，不能一刀切。Java 在广度、企业存量、中间件这三项是碾压级的；.NET 在语言工程完成度、开发体验、云原生现代化速度这几项追得很狠，有些维度已经反超。所以答案不是谁更好，而是你在哪个维度、哪个场景。\n1. Java 生态的护城河（目前仍领先）：一是存量与人才，国内银行、保险、券商、电信核心系统几乎全是 Java，Spring 全家桶是微服务事实标准；二是中间件与大数据，Dubbo、Nacos、RocketMQ、Seata、ShardingSphere，外加 Hadoop、Spark、Flink，全在 JVM 上长成森林；三是社区厚度，中文资料、面试体系、开源贡献量都是别家比不了的。\n2. .NET 生态的精进（被严重低估）：一是语言一体化体验，C# 加 F#，工具链 Visual Studio / Rider 顶级，NuGet 包管理比 Maven 干净；二是云原生现代化，.NET 6 之后  ASP.NET Core 在 TechEmpower 基准里多次排进前列，相对旧的  ASP.NET 提升近 859 倍，Native AOT 让启动压到毫秒级；三是跨平台彻底成熟，容器镜像小、跨 Windows / Linux 无缝；四是游戏（Unity）和桌面（MAUI / WPF）是 .NET 的独占主场。",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261f3",
      "title": "到现在.NET和Java谁的生态更好? - 知乎",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 天津小橙集团有限公司\n公司地址: 天津河西区网信大厦25层\n所在城市: 天津\n岗位名称: java初级开发工程师\n工资待遇: 8-12K\n经验要求: 1-3年\n学历要求: 本科\n岗位描述: 岗位职责\n\n1、参与业务需求评审,按设计完成接口、后台功能的编码与自测。\n2、维护现有 Java 服务,修复缺陷,协助排查线上问题。\n3、按规范编写接口文档、变更说明和基础单测。\n4、配合产品、测试完成联调、提测和上线。\n5、学习并遵守代码规范、Git 流程和发布规范。\n任职要求\n\n计算机相关专业,本科及以上,1-3年以内 Java 开发经验,优秀应届生亦可。\n熟悉 Java 基础、面向对象、集合、异常处理和多线程基础。\n了解 Spring Boot、MyBatis / MyBatis-Plus,能独立完成简单 CRUD 和接口开发。\n了解 MySQL 基本查询、索引概念;了解 Redis、消息队列者优先。\n会使用 Git,具备基本调试和日志阅读能力。\n沟通配合好,能按期完成任务,愿意在业务系统中持续学习。\n技能要求: Java, MySQL, MyBatis, Redis, Spring",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261f4",
      "title": "java初级开发工程师招聘_天津小橙集团有限公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 山东优势领航数字科技有限公司\n公司地址: 青岛崂山区海游路66号\n所在城市: 青岛\n岗位名称: 高级java开发工程师\n工资待遇: 14-20K\n经验要求: 5-10年\n学历要求: 本科\n岗位描述: 岗位职责:  \n1. 参与系统架构设计与核心功能开发,完成Java应用的编码实现;  \n2. 根据业务需求进行模块开发,配合完成系统集成与接口联调;  \n3. 持续优化系统性能,提升代码质量与系统稳定性;  \n4. 参与技术方案评审,编写相关技术文档;  \n\n任职要求:  \n1. 具备扎实的Java编程基础,熟悉面向对象设计原则;  \n2. 熟练掌握主流开发框架,如Spring、Spring Boot、MyBatis等;  \n3. 熟悉分布式架构及相关中间件技术,了解微服务设计理念;  \n4. 具备良好的逻辑思维能力和团队协作意识,能高效沟通并推进项目进展;  \n5. 能够独立分析和解决复杂技术问题。\n技能要求: Java, 大数据经验, 团队管理经验, 分布式经验, SpringCloud, MySQL, Spring, Oracle",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261f5",
      "title": "高级java开发工程师招聘_山东优势领航数字科技有限公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 浙江徽创信息技术有限公司\n公司地址: 昆明呈贡区白药街3686号\n所在城市: 昆明\n岗位名称: Java开发工程师\n工资待遇: 12-13K\n经验要求: 5-10年\n学历要求: 本科\n岗位描述: 岗位要求\n1、负责核心业务模块的设计与开发,确保系统高性能、高 可用性 2、参与架构设计和技术选型,优化现有系统架构  3、编写高质量、可维护的代码,遵循编码规范 4、设计并实施单元测试、集成测试方案 5、参与系统性能调优和安全加固 \n能力要求\n1、5 年以上 Java 开发经验,扎实的 Java 基础(JVM、多 线程、集合等),同时熟悉 GoLang 开发者优先 2、精通 Spring 全家桶(Spring Boot/Spring Cloud/Spring MVC 等) 能力要求 3、熟悉常用中间件:Redis、RabbitMQ/Kafka、Elasticsearch 等 4、熟练使用 MySQL/Oracle 等关系数据库,了解分库分表 方案 5、熟悉分布式系统设计,了解微服务架构及治理\n经验要求\n1、参与过药品行业系统建设者优先 经验要求 2、有全渠道营销管理开发经验者优先 3、有过低代码平台开发经验者优先\n技能要求: Java, SpringCloud, MySQL, Spring",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261f6",
      "title": "Java开发工程师招聘_浙江徽创信息技术有限公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 某大型计算机软件公司\n公司地址: 西安雁塔区西安环普国际科技园天谷八路211号\n所在城市: 西安\n岗位名称: java\n工资待遇: 15-25K\n经验要求: 3-5年\n学历要求: 大专\n岗位描述: 职位描述\n1、熟练掌握Java及web开发和应用,熟悉java多线程,掌握常用的开发框架,如springboot、Sping cloud等主流框架,能独立承担功能模块的开发 2、熟练掌握Java常用设计模式,熟悉常用的数据架构和算法,并能合理运用。\n3、掌握常见数据库的开发和使用,比如MySQL、gaussdb、redis等,熟练掌握SOL语句及数据库优化方案。\n4、熟悉使用Git进行版本控制\n5、英语口语可以作为工作语言\n技能要求: Java, 多线程, SpringBoot",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261f7",
      "title": "java招聘_某大型计算机软件公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 云南赛远科技管理有限公司\n公司地址: 昆明官渡区东盟农副产品批发城3017号\n所在城市: 昆明\n岗位名称: Java\n工资待遇: 9-10K\n经验要求: 3-5年\n学历要求: 硕士\n岗位描述: 岗位职责:  \n1、负责Java应用系统的设计、开发和维护工作;  \n2、参与软件需求分析和架构设计,确保系统可扩展性和稳定性;  \n3、编写高质量、可维护的代码,持续优化系统性能;  \n4、配合团队完成项目迭代,保障开发进度与交付质量;  \n\n任职要求:  \n1、具备扎实的Java编程基础,熟练掌握核心语法及常用类库;  \n2、熟悉主流Java开发框架,能够独立完成功能模块开发;  \n3、理解面向对象设计原则,具备良好的代码设计能力;  \n4、具备较强的学习能力和团队协作意识,责任心强。\n技能要求: Java, 物联网经验, 团队管理经验, 微服务经验, SpringCloud, Redis, 云计算经验",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261f8",
      "title": "Java招聘_云南赛远科技管理有限公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "1",
      "commentInfolist": null,
      "contentText": "马上研二了，准备找后端开发岗的工作。但老是前学后忘，因此做一份笔记，打算参考小林coding及javaguide二者总结准备一份自己的面经（小林codin感觉部分内容写的很详细，但部分内容跟喝多了在说胡话一样，也许是小老弟造诣太浅，读不懂8。Javaguide感觉内容不太全，并且有不少读源码的解读，有些看不下去）。\n新手上路，总结有问题的地方欢迎老司机指正！\n集合概述\nJava中的集合概览\n这里允许我放一张javaguide当中的原图，很好的展现了容器的派生关系：\nJava容器主要由两大接口派生而来，分别为Collection和Map，其中常用的类以及面试当中设计频率较高的几个容器主要有List、Map、Set。其中List和Map更为高频，尤为重要。\n其中List集合，存储的元素是有序并且可重复的。常见实现List的类有：LinkedList、ArrayList、Vector、Stack。\n・LinkedList本质上是一个双向链表（JDK1.6之前是循环链表，JDK1.7取消了循环），链表实现相对于数组来说，更擅长增加、删除等操作，而对于查询操作就不那么友好，因此LinkedList通常用于需要频繁增删的场景。同时他也是非线程安全的，个人开发的时候几乎用不到LinkedList。\n・ArrayList底层实现是一个数组，是容量可变的非线程安全的列表。数组的实现让他更擅长查找、修改的操作。ArrayList的扩容机制似乎很重要，这里简单提一嘴，可以分为下面几个步骤：计算新的容量（通常为原容量的1.5倍，需要检查是否超过最大容量限制）、创建新的数组、元素赋值、更新引用（ArrayList内部指向原数组的引用指向新数组）、完成扩容。\n・Vector是线程安全的动态数组，他的内部方法基本都经过synchronized修饰，同步时会有额外开销，所以通常不用。扩容方式也同样是创建新的数组、复制、拷贝原有数据。\n・Stack继承自Vector，具有先进后出的特性，这个似乎两个面经中都没咋提到，或许因为不是那么重要的考点8。\nMap则是一个存储键值对的集合，键值对在Map的内部表示为Entry接口。Key无序且唯一；Value不要求有序，且允许重复。常用的实现主要有：HashTable、HashMap、LinkedHashMap、TreeMap、ConcurrentHashMap。\n看了不少面经，似乎Map问的比较多，可能也出于使用场景比较宽泛。",
      "date": "01‑13",
      "id": "6a96de1aec71f12a05a261f9",
      "title": "Java面经—Java集合面试篇 - 知乎",
      "voteUpCount": "6"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 无锡天青元储智能科技有限公司\n公司地址: 无锡新吴区无锡新港集成电路装备零部件产业园\n所在城市: 无锡\n岗位名称: java开发工程师\n工资待遇: 9-14K\n经验要求: 3-5年\n学历要求: 本科\n岗位描述: 岗位职责\n1、 使用Java相关技术开发云端服务,确保接口高性能、稳定性;\n2、 与前端开发人员紧密合作,完成业务接口开发,并输出规范的API文档;\n3、 能够持续不断的优化自身的代码性能,以给客户提供流畅的数据服务;\n4、 良好的学习能力,能够通过不断学习帮助团队产品的功能边界和产品质量向前发展;\n职位要求\n1、985/211本科及以上学历,计算机软件或相关专业,3-5年java开发经验;\n2、 熟练掌握Java、Spring Boot、Spring Cloud;\n3、 熟练掌握Redis、MongoDB、Mysql等数据库工具;\n4、 熟练掌握Kafka等消息队列技术;\n5、 熟练使用常规linux命令;\n6、 注重代码质量,具备良好的编码规范和文档习惯;\n7、 拥有独立解决问题的能力,具备持续学习和自我驱动的精神。\n技能要求: Java, SpringCloud, MySQL, Redis, MongoDB, Spring",
      "date": "01‑18",
      "id": "6a96de1aec71f12a05a261fa",
      "title": "java开发工程师招聘_无锡天青元储智能科技有限公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "公司名称: 中信数字科技集团有限公司\n公司地址: 北京朝阳区骏豪·中央公园广场26\n所在城市: 北京\n岗位名称: Java开发\n工资待遇: 12-18K·14薪\n经验要求: 经验不限\n学历要求: 硕士\n岗位描述: 工作内容\n1、负责Java相关模块的设计、开发与维护工作。\n2、参与系统架构设计,确保代码质量和系统稳定性。\n3、与团队合作,完成项目需求分析及模块划分。\n\n任职要求\n1、具备扎实的Java编程能力,熟悉主流的Java开发框架。\n2、能够独立完成模块开发,具备良好的问题分析和解决能力。\n3、具有良好的团队合作精神,能够有效沟通和协作。",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261fb",
      "title": "Java开发招聘_中信数字科技集团有限公司_BOSS直聘",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "2026年金九银十到了，发现网上很多Java面试题都没有答案，所以花了很长时间搜集整理出来了这套Java面试题大全~\n这套互联网 Java 工程师面试题包括了：MyBatis、ZK、Dubbo、EL、Redis、MySQL、并发编程、Java面试、Spring、微服务、Linux、Springboot、SpringCloud、MQ、Kafka、大数据、大模型面试专题，有需要的可以在文末获取\n一、Java 基础\n1. JDK 和 JRE 有什么区别？\n・JDK：Java Development Kit 的简称，java 开发工具包，提供了 java 的开发环境和运行环境。\n・JRE：Java Runtime Environment 的简称，java 运行环境，为 java 的运行提供了所需环境。\n具体来说 JDK 其实包含了 JRE，同时还包含了编译 java 源码的编译器 javac，还包含了很多 java 程序调试和分析的工具。简单来说：如果你需要运行 java 程序，只需安装 JRE 就可以了，如果你需要编写 java 程序，需要安装 JDK。\n2. == 和 equals 的区别是什么？\n== 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；而 equals 默认情况下是引用比较，只是很多类重新了 equals 方法，比如 String、Integer 等把它变成了值比较，所以一般情况下 equals 比较的是值是否相等。\n3. 两个对象的 hashCode()相同，则 equals()也一定为 true，对吗？\n不对，两个对象的 hashCode()相同，equals()不一定 true。\n代码解读：很显然“通话”和“重地”的 hashCode() 相同，然而 equals() 则为 false，因为在散列表中，hashCode()相等即两个键值对的哈希值相等，然而哈希值相等，并不一定能得出键值对相等。\n4. final 在 java 中有什么作用？\n・final 修饰的类叫最终类，该类不能被继承。\n・final 修饰的方法不能被重写。\n・final 修饰的变量叫常量，常量必须初始化，初始化之后值就不能被修改。\n5. java 中的 Math.round(-1.5) 等于多少？\n等于 -1，因为在数轴上取值时，中间值（0.5）向右取整，所以正 0.5 是往上取整，负 0.5 是直接舍弃。\n",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261fc",
      "title": "Java&AI大模型面试题及答案整理(2026年金九银十最新版,持续更新) - 知乎",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "2",
      "commentInfolist": null,
      "contentText": "// 以前\npublic class OrderService {\n    private UserDao userDao = new UserDaoMySQLImpl();  // 写死了\n}\n\n// Spring\n@Service\npublic class OrderService {\n    @Autowired\n    private UserDao userDao;  // 容器注入，不关心具体实现\n}\n就这么一个变化，让 Java 后端的代码可测试性和可维护性直接上了一个台阶。\n不过早期的 Spring 也有自己的问题，XML 配置太反锁了，一个稍大点的项目，applicationContext.xml 能写几千行，每个 bean 的属性、依赖、作用域全在 XML 里声明。从 EJB 的 XML 噩梦跳到 Spring 的 XML 噩梦，只是程度轻了一些。\n真正让 Spring 封神的是 2014 年出的 Spring Boot\nSpring Boot 把约定大于配置做到了极致，内嵌 Tomcat，不需要外部应用服务器；自动配置，引入 spring-boot-starter-data-jpa 这个依赖，JPA 相关的 bean 就自动配好了；application.yml 几行配置就能跑起来一个生产级别的 Web 服务。以前搭一个 SSM（Spring + Spring MVC + MyBatis）项目要折腾半天的 XML 和依赖版本冲突，Spring Boot 一个 start.spring.io 勾选几下就生成好了。\n这带来的结果是，Java 后端的入门门槛被大幅降低了，同时 Spring 生态变成了一个几乎覆盖所有后端场景的全家桶：Web 用 Spring MVC、数据库用 Spring Data、安全用 Spring Security、微服务用 Spring Cloud、批处理用 Spring Batch、消息队列有 Spring AMQP / Kafka。\n在 Java 后端能碰到的几乎每个场景，Spring 都有对应的方案，而且这些方案之间的集成是无缝的。\n国内的 Java 后端招聘基本就是在招 Spring 开发者，会 Java和会 Spring在实际工作中几乎是等号。\n去看招聘 JD，要求写的不是精通 Java，而是精通 Spring Boot / Spring Cloud。",
      "date": "01‑11",
      "id": "6a96de1aec71f12a05a261fd",
      "title": "Java中的Spring框架有多重要? - 知乎",
      "voteUpCount": "12"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "也正是字节码这套中间层设计，让 Kotlin、Scala、Groovy 等语言也可以编译为字节码运行在 JVM 之上，直接复用 Java 的生态。如今 Kotlin 已是 Android 官方推荐开发语言，底层依旧依托 JVM。\n2、自动内存管理（GC垃圾回收）\n对比 C++ 需要手动申请、释放内存，很容易出现内存泄漏、野指针崩溃。 Java 通过 GC 在后台自动回收无效对象，开发者可以更专注业务逻辑，大幅降低内存出错的概率。\n但 GC 并不是完美无缺。 垃圾回收会存在 Stop‑The‑World，暂停业务线程完成标记清理。在交易、游戏服务器这类对延迟极度敏感的场景，几百毫秒的停顿就会造成业务故障。\n随着版本迭代，诞生了多款 GC 算法。高版本 JDK 的 ZGC、Shenandoah，已经可以把停顿压到 1ms 以内，即便超大堆也不受影响，和手动管理内存的 C++ 差距已经很小。\n 面试高频：GC停顿问题现在解决了吗？低延迟业务可以用 Java 吗？ 新版本基本可以满足。JDK17+ 的 ZGC 已经非常成熟，停顿控制在亚毫秒级别，堆哪怕到 4TB 也不受影响。现在不少交易、游戏服务都采用 Java + ZGC。老版本 CMS、G1 则很难胜任低延迟场景。\n3、极其强大的开发生态\n几乎大部分业务场景，都有成熟开源组件可以直接使用，不用重复造轮子，典型代表就是 Spring 全家桶。 Java 生态之所以繁荣，来源于三点：\n1.企业市场占有率高：银行、电商、电信大量核心系统基于 Java，大厂持续输出开源中间件，例如阿里中间件、Netflix 微服务体系。\n2.极强的向后兼容性：Java 对 API 兼容非常看重，多年前的老代码升级高版本 JDK 大多可以直接运行，企业不用担心升级就崩掉业务。\n3.Apache 基金会的大力推动：Hadoop、Kafka、Flink、Spark 这些大数据主流组件，大多基于 Java/Scala 实现。\n4、工程化友好，适合大型团队协作\nJava 是强类型语言，依托面向对象的封装、继承、多态，代码约束清晰。适合几十上百人的大型团队协同开发，便于维护大型复杂项目。\nJava 的短板，客观看待\n1.启动速度慢 JVM 初始化、类加载、JIT 即时编译都需要耗时，Spring Boot 应用启动十几秒很常见。在 Serverless 场景冷启动会成为硬伤。 \u003E 解决方案：GraalVM Native Image，直接编译成本地二进制可执行文件，跳过 JVM 启动流程，启动时间降到毫秒级，Spring Boot3 已经正式支持该能力。",
      "date": "01‑05",
      "id": "6a96de1aec71f12a05a261fe",
      "title": "JAVA的优势是什么? - 知乎",
      "voteUpCount": "1"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "现代化编程已经是 Kotlin 的天下，而 Java 就算到 Java 21 LTS 也都是老古董了。\n说到 Java 先说 Java 最强势的服务端领域，这几年由于 Spring Boot 和 Spring Cloud 全家桶的臃肿，不少大厂寻求 Golang、Rust 等语言去替代了，编译慢、部署慢、执行效率低、内存占用高都是毛病。\n但是 Golang 根本取代不了 Java，因为 Golang 的语言工程性极差，导致维护和bug在所难免。\n而 Rust 最大的问题就是开发效率低、编译速度慢，维护更新都很不尽人意。\n最后成大器的就是 Kotlin，尤其是发展很多年的 Kotlin Native 性能接近 Rust，开发效率和 Golang 相当，而项目的工程性比 Spring Boot 全家桶还好用！就算是 Spring Boot 4.0 官方的示例默认都是 Kotlin 版本的。\n现在基于 Kotlin Native 的 Neton 框架更是把 Rust、Go、Java 的优势都占据了。",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a261ff",
      "title": "Kotlin比Java差在哪? - 知乎",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "初学Java，常会觉得GC、多线程、synchronized十分神秘。\n但本质上Java仅仅是一套语法与字节码规范，真正干活执行代码的载体，是C++编写的JVM虚拟机。\n❗我们日常安装下载的JDK，并不携带源码\nOpenJDK里JVM全部由C++实现，经过编译器编译为CPU可以直接识别的机器码，打包成为java可执行程序。\n普通JDK包里，只能看到编译完成后的二进制文件，看不到原始C++源代码。\n🧩解释执行：字节码如何跑起来\nJVM内部，提前为每一条字节码opcode，都编写好了对应的handler处理逻辑。\n这些handler会被编译，直接固化在JVM二进制程序当中。\n1. 我们手写的Java源码，经过javac编译输出.class字节码\n2. ⚠️字节码仅仅是数字形式的指令编号，并不是CPU能直接跑的机器码\n程序启动时：\nJVM加载class文件，定位main方法，进入解释主循环。\n逐条读取字节码opcode，拿这个编号当做索引查表，定位到对应handler的机器码地址，通过间接跳转交给CPU执行。",
      "date": "01‑16",
      "id": "6a96de1aec71f12a05a26200",
      "title": "拨开Java的黑盒:解释执行与JIT - 知乎",
      "voteUpCount": "0"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "我刚工作那年被派去维护一个 C# 老系统，后来转 Java 做了八年后端，两边坑都踩过，所以这个问题我有点发言权。\n先说现象为什么是\"Java 比 C# 好\"听得多：因为国内招 Java 的岗位是 C# 的 5～10 倍，你身边十个做后端的八个写 Java，自然满耳朵都是 Java 香。声量不等于事实。\n再说 C# 比 Java 好的地方，确实客观存在：\n1. 语言体验：C# 的 async/await 比 Java 早多年且更顺；值类型（struct）在数值、游戏、金融场景比 Java 的 Object 数组省内存又快；record、pattern matching 也比 Java 的样板代码优雅。",
      "date": "01‑19",
      "id": "6a96de1aec71f12a05a26201",
      "title": "经常听到有说 Java 比 c#好的,却很少听到有说c#比Java好的?所以到底是咋回事呢 ? - 知乎",
      "voteUpCount": "1"
    },
    {
      "authorAvatar": null,
      "authorName": null,
      "commentCount": "0",
      "commentInfolist": null,
      "contentText": "本书是经典 Java开发基础书《Java核心技术》的速学版本。本书首先介绍了Java 语言的基础知识，包含接口、Lambda 表达式、继承、反射、异常处理、断言、日志、泛型编程、容器等关键概念；其次介绍了流、输人和输出处理、并发、注解、日期和时间 API、国际化、编译和脚本、Java 平台模块系统等高级特性。本书不仅可以让读者深入了解 Java 编程的基础知识和核心概念，还可以帮助读者掌握 Java 应用程序开发所需的基本技能。本书涵盖了Java17中更新的内容，提供了许多实用的示例代码，还给出了基于作者实际经验的提示、注意和警告。\n✅适合零基础、有少量编程基础，想要系统掌握现代 Java 语言与核心 API 的学习者。\n读完这本书，能够看懂、写得出业务代码，搞懂 Java“是什么、怎么用”。\n目录：\n2.《Effective Java 中文版（原书第 3 版）》\n本书是Jolt获奖作品Effective Java的第3版，Java 领域公认经典，作者是 JDK 核心类库设计者 Joshua Bloch，对上一版进行了全面更新，涵盖了从Java 5到Java 9的种种特性，是Java开发人员不可缺少的一本参考书。",
      "date": "01‑06",
      "id": "6a96de1aec71f12a05a26202",
      "title": "关于 Java 学习,有哪些值得推荐的书籍或教程? - 知乎",
      "voteUpCount": "5"
    }
  ],
  "msg": "成功"
}
```



