package com.tencent.av.core;

class VcControllerImpl$4
  implements Runnable
{
  VcControllerImpl$4(VcControllerImpl paramVcControllerImpl, boolean paramBoolean) {}
  
  public void run()
  {
    ??? = this.this$0;
    int i;
    if (this.Sx) {
      i = this.this$0.stopAudioSend();
    }
    for (;;)
    {
      VcControllerImpl.access$602((VcControllerImpl)???, i);
      synchronized (VcControllerImpl.access$700(this.this$0))
      {
        VcControllerImpl.access$700(this.this$0).notify();
        return;
        i = this.this$0.startAudioSend();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.core.VcControllerImpl.4
 * JD-Core Version:    0.7.0.1
 */