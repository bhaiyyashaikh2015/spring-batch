
==
Spring Batch
=============

1) What is Spring Batch & Why 

2) Real Time use cases

3) Spring Batch Architecture

4) Spring Batch Project Development (POC)

5) Spring Scheduling

6) Q & A

==
Spring Batch use case
=============

![image](https://github.com/user-attachments/assets/f52af2f8-6f83-411f-9688-7e99419fb2fe)

==
Spring Batch Architecture
=============

![image](https://github.com/user-attachments/assets/9b6a4cdf-e562-4088-91f5-5fd879677aa0)


==
Introduction
==============

=> Spring Framework

		a) core   (IOC & DI)
		b) context (configuration)
		c) aop (cross cutting)
		d) dao  (data access)
		e) web mvc (web app & rest apis)
		f) security (authentication & Authorization)
		g) data  (data jpa, data rest, data redis)
		h) cloud  (microservices)

		i) batch (to  process large volumes of data)


=> Batch Operations ===> Bulk operations		

=> Spring Batch is a framework within the "Spring ecosystem".

=> It is designed for batch processing in Java applications.

=> It provides reusable functions for processing large volumes of records

==
Batch Processing Usecases
===========================

Spring Batch is particularly useful for tasks like reading large amounts of data, processing it, and writing it to a destination (e.g., a database or file).

1) bulk sms

2) bulk email

3) sending salaries to emps (banking)

4) Sending bank account statement to account holder every month

		SBI ==> 50cr ppl

		1) read all accounts details
		2) read each account tx history
		3) prepare account statement in pdf format
		4) send account stmt to acc-holder email

5) sending post paid mobile bill every month

6) Credit Card bill statement generation

7) Sending Reminder to customers regarding their insurance plan renewal

8) Payment Reminders

==		
Spring Batch Architecture
==========================

1) Job Launcher

2) Job

3) Step

4) Job Repository

5) ItemReader

6) ItemProcessor

7) ItemWriter


ItemReader : It is used to read data from the source 

ItemProcessor : It is used to process the data

ItemWriter : It is used to write the data to destination

Step : It represents sequence of our batch execution (reader + processor + writer)

Job : It is used to represents set of steps for batch processing

JobRepository : To maintain job execution history and steps related info

JobLauncher: It is used to start the job exeuction.


Spring Batch Documentation : https://spring.io/guides/gs/batch-processing


==
Spring Scheduling
==================

=> Spring Scheduler is a feature provided by the Spring Framework that allows you to schedule tasks to run at specific times or intervals

=> It is particularly useful for automating repetitive tasks, such as sending emails, generating reports, or performing database cleanup....

execue my method every day @7:00 AM IST

execute method every month last working day @8:00 PM

execute method (mon-fri) @ 9:00 AM

Execute method on Dec 31st @ 12:00 PM


@SpringBootApplication
@EnableScheduling
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Scheduled(fixedRate = 5000)
	public void demo1() {
		System.out.println(" Task Executed : " + new Date());
	}

	@Scheduled(cron = "0 0 12 * * MON-FRI")
	public void demo2() {
		System.out.println(" Task Executed : " + new Date());
	}

	// every hour at the start of the hour : 0 0 * * * *

	// every day mrng 8:00 AM : 0 0 8 * * *

	// Every week day at 12:00 PM : 0 0 12 * * MON-FRI
}

