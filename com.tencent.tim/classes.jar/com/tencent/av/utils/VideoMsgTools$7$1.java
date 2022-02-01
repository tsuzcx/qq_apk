package com.tencent.av.utils;

import android.content.Context;
import android.os.Bundle;
import aqji;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

class VideoMsgTools$7$1
  implements Runnable
{
  VideoMsgTools$7$1(VideoMsgTools.7 param7, ArrayList paramArrayList) {}
  
  public void run()
  {
    Context localContext = (Context)this.this$0.bS.get();
    if (localContext == null) {
      return;
    }
    Bundle localBundle = new Bundle();
    if (this.this$0.alR == 3000) {}
    for (int i = 1;; i = 10)
    {
      localBundle.putInt("MultiAVType", i);
      if (this.this$0.aan) {
        localBundle.putBoolean("isVideo", true);
      }
      QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (this.je != null) {
        localBundle.putParcelableArrayList("invitelist", this.je);
      }
      if (this.this$0.alR == 1) {
        localBundle.putBoolean("enableInvite", aqji.a("selectMemberToStartGAudioChat", localQQAppInterface, this.this$0.val$groupUin));
      }
      localBundle.putString("Fromwhere", this.this$0.SV);
      ChatActivityUtils.a(localQQAppInterface, localContext, this.this$0.alR, this.this$0.val$groupUin, true, true, null, localBundle);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.7.1
 * JD-Core Version:    0.7.0.1
 */