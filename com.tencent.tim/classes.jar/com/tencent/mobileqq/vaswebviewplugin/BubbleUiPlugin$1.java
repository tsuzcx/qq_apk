package com.tencent.mobileqq.vaswebviewplugin;

import affz;
import afjy;
import android.os.Bundle;
import com.tencent.mobileqq.emosm.Client.b;

class BubbleUiPlugin$1
  implements Runnable
{
  BubbleUiPlugin$1(BubbleUiPlugin paramBubbleUiPlugin) {}
  
  public void run()
  {
    Bundle localBundle = new Bundle();
    localBundle.putString("optype", "Bubble");
    localBundle.putString("opname", "Clk_bubble_setting");
    localBundle = affz.a("reportActionCount", "", this.this$0.mOnRemoteResp.key, localBundle);
    afjy.a().cq(localBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vaswebviewplugin.BubbleUiPlugin.1
 * JD-Core Version:    0.7.0.1
 */