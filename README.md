# dataAnalyst


This application uses: Java 21, maven and Junit 5 for testing.  So, for running this app you’ll need to run the latest Java version available today. 

This app is divided  in 5 parts that are the most important: Sources, Watchers, Processors, Documents and Analytics.

But the classes that are the most important are the following:

LocalWatcherService: its main function is to keep track of every event generated in the folder that is going to be monitored by the app.  When the watch method is invoked it keeps listening to new events and sending those events to the appropriate classes to handle it. 

LocalWatchService also contains a method called processExistingFiles to process the documents that were before in the folder before  the monitor started. It will run when its constructor is being called. So, Ideally, will run before the watch method is invoked. 

DocumentTypeFactory this class is used to create the documents record objects that are going to be processed. This class implements the factory pattern to create instance. 

To make the app run smoothly I also did a variant of the NullObject Pattern with UnSupportedDocument. When an  Unsupported documents comes in to the system would be represented as this and we are avoiding to process the document. 

Another important class is FileProcessorManager this class is in charge of executing the appropriate file processor for the document to be processed. 

Analytics package contains the Analytics available at the moment to apply to a document. 

I tried to make the code as much  stateless as possible. This makes the code easier to test and easy to debug.  For that reason many of the classes only contains static methods, those classes does not contains state, so, no need to create objects from those classes. 

Sadly, I couldn’t add more test, but test are really important. I like to write them. 

There are another classes that I could move to another packages or I could split some helper method from LocalWatchService but I didn’t want to over complex this example app.

Thanks for the opportunity. 
