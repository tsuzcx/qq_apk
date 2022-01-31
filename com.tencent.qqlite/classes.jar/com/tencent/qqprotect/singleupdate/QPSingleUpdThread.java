package com.tencent.qqprotect.singleupdate;

import com.tencent.qphone.base.util.QLog;

public class QPSingleUpdThread
  extends Thread
{
  QPSingleUpdEngine jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine = null;
  String jdField_a_of_type_JavaLangString;
  final String b = "QPSingleUpdEngine";
  
  public QPSingleUpdThread(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    super.run();
    int i = 1;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine = new QPSingleUpdEngine(this.jdField_a_of_type_JavaLangString);
        this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine.a();
        return;
      }
      catch (Exception localException)
      {
        if (i >= 3) {
          QLog.i("QPSingleUpdEngine", 0, "QPSingleUpdThread.run() Exception 3 times!!!");
        }
        i += 1;
        QLog.i("QPSingleUpdEngine", 0, "QPSingleUpdThread.run() Exception !!!");
        try
        {
          Thread.sleep(10000L);
        }
        catch (InterruptedException localInterruptedException)
        {
          localInterruptedException.printStackTrace();
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdThread
 * JD-Core Version:    0.7.0.1
 */