package com.tencent.open.agent;

import android.os.Message;
import arsc;
import java.util.ArrayList;

public class OpenSdkFriendService$1
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = this.this$0.ef();
    Message.obtain(this.dP, 888802, localArrayList).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.1
 * JD-Core Version:    0.7.0.1
 */