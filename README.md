# spring-boot-with-hibernate
DEPENDENCY::
----------------
//This dependency for hibernate curd opration
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-core</artifactId>
			<version>5.6.4.Final</version>
		</dependency>
		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<version>42.4.3</version>
		</dependency>

//This dependency for hibernate second Level cache
        <dependency>
			<groupId>net.sf.ehcache</groupId>
			<artifactId>ehcache</artifactId>
			<version>2.10.6</version>
		</dependency>
		<dependency>
			<groupId>org.hibernate</groupId>
			<artifactId>hibernate-ehcache</artifactId>
			<version>5.6.4.Final</version>
		</dependency>

hibernate-configuration file::
-------------------------------
<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE hibernate-configuration PUBLIC
        "-//Hibernate/Hibernate Configuration DTD 3.0//EN"
        "http://www.hibernate.org/dtd/hibernate-configuration-3.0.dtd">
 
<hibernate-configuration>
    <session-factory>
        <!-- Connection settings -->
        <property name="hibernate.connection.driver_class">org.postgresql.Driver</property>
        <property name="hibernate.connection.url">jdbc:postgresql://localhost:5432/MYDB</property>
        <property name="hibernate.connection.username">postgres</property>
        <property name="hibernate.connection.password">jitudas</property>
        <!-- SQL dialect -->
        <property name="hibernate.dialect">org.hibernate.dialect.PostgreSQLDialect</property>
 
        <!-- Print executed SQL to stdout -->
        <property name="show_sql">true</property>
 
        <!-- Update database on startup -->
        <property name="hibernate.hbm2ddl.auto">update</property>
 
        <!-- Annotated entity classes -->
      <!--   <mapping class="com.javacodegeeks.example.Car"/> -->
        
    </session-factory>
</hibernate-configuration>


Hibernate Annotation::
----------------------
@Entity//use to mark as a entity
@Table(name="")//if u want customize table name then this annotion use 
@Id //use to mark as column (primary key)
@GenaratedValue//automatic created primary key value
@Column(name ="")//if u want modified the cloumn name
@Transiet//This tell to hibernate not to save porticular field
@Tempral//Over a data field tells hibernate format which in which data needs to save.

 <property name="hibernate.hbm2ddl.auto">create</property>-->if keep create option then every time table is newly crteated if already present then that table droped then create And if u keep update then its not created every time. 
Errors::
--------
if u hibernate-configuration file did not find then below error is coming:
 configuration.configure("hibernate.cfg.xml");//this location is default location under src-:
Exception in thread "main" org.hibernate.internal.util.config.ConfigurationException: Could not locate cfg.xml resource [hibernate.cfg.xml]---->this error generally coming when configuration file spelling mistake or wrong configuration location
configuration.configure("com/jitu/hibernate/hibernate.cfg.xml");//this location is manually location

@Id//if u not use this annotaion in entity class then below exception is coming 
No identifier specified for entity: com.jitu.hibernate.Student





//get()->This egar initilizer,when u call this method first its check chache memory if its there then return other wise later will check DB if DB itself not rthere then its return null object.
	    Student student = (Student)session.get(Student.class, 104);
		Student student1 = (Student)session.get(Student.class, 102);
		System.out.println(student);
//load()->This method is lazy initionlizer when u call this method first its create proxy object if u required this object data then only call to DB if data is not there then throughing Exception in thread "main" org.hibernate.ObjectNotFoundException: No row with the given identifier exists: [com.jitu.hibernate.Student#106] 
		/*Student student = (Student)session.load(Student.class, 106);
		Student student1 = (Student)session.load(Student.class, 103);
		System.out.println(student);*/
		session.close();
		sessionFactory.close();
