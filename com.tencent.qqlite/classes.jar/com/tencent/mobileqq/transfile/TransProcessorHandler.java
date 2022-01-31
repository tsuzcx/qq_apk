package com.tencent.mobileqq.transfile;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;

public class TransProcessorHandler
  extends Handler
{
  private ArrayList filterList = new ArrayList();
  
  public TransProcessorHandler()
  {
    this.filterList.clear();
  }
  
  public TransProcessorHandler(Looper paramLooper)
  {
    super(paramLooper);
    this.filterList.clear();
  }
  
  public void addFilter(Class... paramVarArgs)
  {
    int i = 0;
    while (i < paramVarArgs.length)
    {
      this.filterList.add(paramVarArgs[i]);
      i += 1;
    }
  }
  
  public ArrayList getFilter()
  {
    return this.filterList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.TransProcessorHandler
 * JD-Core Version:    0.7.0.1
 */