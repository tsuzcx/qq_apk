package com.tencent.qqprotect.singleupdate;

import java.util.TimerTask;

public class QPSingleUpdTimerTask
  extends TimerTask
{
  private String jdField_a_of_type_JavaLangString;
  private Thread jdField_a_of_type_JavaLangThread = null;
  
  public QPSingleUpdTimerTask(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void run()
  {
    this.jdField_a_of_type_JavaLangThread = new QPSingleUpdThread(this.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_JavaLangThread.start();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.qqprotect.singleupdate.QPSingleUpdTimerTask
 * JD-Core Version:    0.7.0.1
 */