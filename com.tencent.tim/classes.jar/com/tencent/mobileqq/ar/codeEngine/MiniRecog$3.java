package com.tencent.mobileqq.ar.codeEngine;

import adjp;
import com.tencent.qphone.base.util.QLog;

public class MiniRecog$3
  implements Runnable
{
  public MiniRecog$3(adjp paramadjp) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QRSession.MiniRecog", 2, "[------ onDetectReady------]");
    }
    this.this$0.bNU = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.codeEngine.MiniRecog.3
 * JD-Core Version:    0.7.0.1
 */