package com.tencent.open.agent;

import arsc;
import arsc.d;
import java.util.ArrayList;

public class OpenSdkFriendService$GetFriendListCallback$1
  implements Runnable
{
  public OpenSdkFriendService$GetFriendListCallback$1(arsc.d paramd, ArrayList paramArrayList, String paramString) {}
  
  public void run()
  {
    if ("action_invite".equals(this.a.this$0.mAction))
    {
      this.a.this$0.nk(this.val$groups);
      this.a.this$0.WV(this.cBR);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.OpenSdkFriendService.GetFriendListCallback.1
 * JD-Core Version:    0.7.0.1
 */