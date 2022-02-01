package com.tencent.mobileqq.cuckoo;

import android.util.Log;

final class Cuckoo$1
  extends ClassLoadCallback
{
  protected void onClassLoadCallbackFileLoadHook(Class paramClass)
  {
    Log.d("Cuckoo", paramClass.getName() + "  ClassLoad FileLoadHook");
  }
  
  protected void onClassLoadCallbackFirst(Class paramClass)
  {
    Log.d("Cuckoo", paramClass.getName() + "  ClassLoad First");
  }
  
  protected void onClassLoadCallbackPrepare(Class paramClass)
  {
    Log.d("Cuckoo", paramClass.getName() + "  ClassLoad Prepare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.cuckoo.Cuckoo.1
 * JD-Core Version:    0.7.0.1
 */