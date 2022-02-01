package com.tencent.mobileqq.vas;

import affz;
import android.os.Bundle;
import aqpt;
import com.tencent.mobileqq.emosm.Client.b;

public class ColorRingPlayer$8
  implements Runnable
{
  public ColorRingPlayer$8(aqpt paramaqpt, String paramString1, String paramString2, long paramLong, int paramInt) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("subAction", this.VN);
    localBundle.putString("actionName", this.val$actionName);
    localBundle.putLong("id", this.val$id);
    localBundle.putInt("result", this.val$result);
    localBundle = affz.a("reportColorRing", "", this.this$0.b.key, localBundle);
    this.this$0.dw(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingPlayer.8
 * JD-Core Version:    0.7.0.1
 */