package com.tencent.qqprotect.singleupdate;

public class QPSingleUpdThread
  extends Thread
{
  QPSingleUpdEngine jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine = null;
  String jdField_a_of_type_JavaLangString;
  
  public QPSingleUpdThread(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    super.run();
    this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine = new QPSingleUpdEngine(this.jdField_a_of_type_JavaLangString);
    try
    {
      this.jdField_a_of_type_ComTencentQqprotectSingleupdateQPSingleUpdEngine.a();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdThread
 * JD-Core Version:    0.7.0.1
 */