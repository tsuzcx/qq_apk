package com.tencent.mobileqq.qipc;

import com.tencent.mobileqq.app.ThreadManager;
import eipc.EIPCThreadEngine;

final class QIPCEnvironmentInit$1
  extends EIPCThreadEngine
{
  public void excute(Runnable paramRunnable)
  {
    ThreadManager.executeOnSubThread(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.qipc.QIPCEnvironmentInit.1
 * JD-Core Version:    0.7.0.1
 */