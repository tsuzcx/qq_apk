package com.tencent.tim.cloudfile;

import athq;

public class CloudFileSendRecvSyncer$2$1
  implements Runnable
{
  public CloudFileSendRecvSyncer$2$1(athq paramathq) {}
  
  public void run()
  {
    CloudFileSendRecvSyncer.a(this.a.this$0, CloudFileSendRecvSyncer.SyncState.SyncState_finish);
    CloudFileSendRecvSyncer.a(this.a.this$0);
    CloudFileSendRecvSyncer.b(this.a.this$0);
    this.a.this$0.notifyObservers(new Object[] { Integer.valueOf(1), { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) } });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.cloudfile.CloudFileSendRecvSyncer.2.1
 * JD-Core Version:    0.7.0.1
 */