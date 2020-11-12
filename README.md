# baseDesignPatterns
design patterns notes

## 设计原则
1. 单一职责(Single Responsibility Principle | SRP)
2. 里氏替换(Liskov Substitution Principle | LSP )
3. 依赖倒置(Dependence Inversion Principle | DIP | 面向接口编程)
4. 接口隔离(Interface Segregation Principle | ISP | depend on the smallest possible interface) 
5. 迪米特法则(Law of Demeter | LOD | The Least Knowledge Principle)
6. 开闭原则(Open Closed Principle | OCP | 对扩展开放，对修改关闭)

------
设计模式
------
> ☁️ 类模式: 类与子类的关系 | 编译即确定 \
> ☁️ 模式中可以意图不同但是UML图相似 | Composite和Decorator \
> ☁️ 相同接口 不同实现 运行时刻 连接 -> 动态绑定 \
> ☁️ 相同接口 可替换不同实现 -> 多态(polymorphism) \

## 创建型模式(五种)：
 - [x] 抽象工厂模式
 - [x] 建造者模式
 - [x] 工厂方法模式(类)
 - [x] 原型模式
 - [x] 单例模式

## 结构型模式(组合|七种)：
> decorator 旨在添加职责 \
> proxy 为访问受限的实体提供替代者

 - [x] 适配器模式/包装器(对象|类)
 - [x] 桥接模式
 - [x] 组合模式
 - [x] 装饰器模式
 - [x] 外观模式
 - [x] 享元模式
 - [x] 代理模式

## 行为型模式(交互|十一种)：
 - [x] 责任链模式
 - [x] 命令模式
 - [x] 解释器模式(类)
 - [x] 迭代模式
 - [x] 中介者模式
 - [x] 备忘录模式
 - [x] 观察者模式
 - [x] 状态模式
 - [x] 策略模式
 - [x] 模板方法模式(类)
 - [x] 访问者模式
 
 
 ----------
 UML
 -----------
 > ① 实空为继承 \ 
 > ② 虚空为实现  \
 > ③ 普通箭头虚线为依赖(方法参数，局部变量) \ 
 > ④ 普通箭头实线为关联(成员变量，老师,学生,课程) \
 > ⑤ 空心菱形加实线是聚合(成员变量，公司与员工) \
 > ⑥ 实心菱形加实现使组合(成员变量，鸟与翅膀) \
 > ⑦ +(public)/-(private)/#(protected)/~(package) \
 


 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
   