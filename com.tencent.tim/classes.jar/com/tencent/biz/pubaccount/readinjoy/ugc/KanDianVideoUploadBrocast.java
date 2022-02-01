package com.tencent.biz.pubaccount.readinjoy.ugc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;

public class KanDianVideoUploadBrocast
  extends BroadcastReceiver
{
  ArrayList<String> mTaskList = new ArrayList();
  
  private void a(Context paramContext, int paramInt, CharSequence paramCharSequence)
  {
    if (paramContext == null) {
      return;
    }
    QQToast.a(paramContext, paramInt, paramCharSequence, 0).show(paramContext.getResources().getDimensionPixelSize(2131299627));
  }
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    String str = paramIntent.getStringExtra("mTaskID");
    int i = 0;
    try
    {
      int j = Integer.valueOf(paramIntent.getStringExtra("mState")).intValue();
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.d("KandianVideoUpload", "解析广播状态异常" + localException.toString());
      }
      switch (i)
      {
      case 204: 
      default: 
        return;
      }
    }
    Log.d("KandianVideoUpload", "收到广播taskID  " + str + "  state:" + i + " 当前的taskiD list大小" + this.mTaskList.size());
    if ((!this.mTaskList.isEmpty()) && (!this.mTaskList.contains(str))) {
      return;
    }
    paramIntent = paramIntent.getStringExtra("mfaileMessage");
    if (TextUtils.isEmpty(paramIntent)) {}
    a(paramContext, 1, paramIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.KanDianVideoUploadBrocast
 * JD-Core Version:    0.7.0.1
 */