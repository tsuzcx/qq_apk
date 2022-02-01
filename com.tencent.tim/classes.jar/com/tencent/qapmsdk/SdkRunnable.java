package com.tencent.qapmsdk;

import com.tencent.qapmsdk.qapmmanager.QAPMLauncher;

public class SdkRunnable
  implements Runnable
{
  private int userMode = 0;
  
  SdkRunnable(int paramInt)
  {
    this.userMode = paramInt;
  }
  
  public void run()
  {
    QAPMLauncher.INSTANCE.launch(this.userMode);
    QAPMLauncher.INSTANCE.afterLaunch();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.SdkRunnable
 * JD-Core Version:    0.7.0.1
 */