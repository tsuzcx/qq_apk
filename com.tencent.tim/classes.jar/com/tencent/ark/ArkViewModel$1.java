package com.tencent.ark;

final class ArkViewModel$1
  implements Runnable
{
  public void run()
  {
    long l1 = System.currentTimeMillis();
    if (ArkViewModelBase.ENV.isHardwareAcceleration()) {
      ArkEGLContextManager.getManager(1).createContext("global");
    }
    long l2 = System.currentTimeMillis();
    ArkViewModelBase.ENV.logI("ArkApp.ArkViewModel", String.format("precreateOfflineContext, used-time=%d", new Object[] { Long.valueOf(l2 - l1) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.ark.ArkViewModel.1
 * JD-Core Version:    0.7.0.1
 */