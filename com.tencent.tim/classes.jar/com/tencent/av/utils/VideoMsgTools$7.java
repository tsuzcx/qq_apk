package com.tencent.av.utils;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import aqji.c;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class VideoMsgTools$7
  extends ResultReceiver
{
  VideoMsgTools$7(Handler paramHandler, boolean paramBoolean, WeakReference paramWeakReference, int paramInt, String paramString1, String paramString2)
  {
    super(paramHandler);
  }
  
  protected void onReceiveResult(int paramInt, Bundle paramBundle)
  {
    AudioHelper.I("selectMemberToStartGAudioChat", paramBundle);
    paramBundle = paramBundle.getParcelableArrayList("result_set");
    StringBuilder localStringBuilder = new StringBuilder().append("selectMemberToStartGAudioChat onReceiveResult, bVideo[").append(this.aan).append("], resultCode[").append(paramInt).append("], chooserList[");
    int i;
    if (paramBundle != null)
    {
      i = paramBundle.size();
      QLog.w("VideoMsgTools", 1, i + "]");
      if (paramBundle == null) {
        break label104;
      }
      i = paramBundle.size();
      label86:
      aqji.c.cf(i, this.aan);
      if (paramBundle != null) {
        break label109;
      }
    }
    label104:
    label109:
    while (paramInt != -1)
    {
      return;
      i = -1;
      break;
      i = 0;
      break label86;
    }
    paramBundle = new VideoMsgTools.7.1(this, paramBundle);
    new Handler(Looper.getMainLooper()).post(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.utils.VideoMsgTools.7
 * JD-Core Version:    0.7.0.1
 */