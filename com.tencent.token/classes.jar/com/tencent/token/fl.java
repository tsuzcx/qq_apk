package com.tencent.token;

import android.text.TextUtils;
import android.util.Log;
import btmsdkobf.ad;
import btmsdkobf.cp;
import btmsdkobf.z;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.base.utils.ConvertUtil;
import java.util.ArrayList;

final class fl
  extends ConchService.IConchPushListener
{
  public void onRecvPush(ConchService.ConchPushInfo paramConchPushInfo)
  {
    if ((paramConchPushInfo == null) || (paramConchPushInfo.mConch == null)) {
      return;
    }
    Log.i("SecureGuideUtil", "receive cmd " + paramConchPushInfo.mConch.cmdId);
    int i;
    Object localObject2;
    int j;
    switch (paramConchPushInfo.mConch.cmdId)
    {
    default: 
      return;
    case 6275: 
      localObject1 = (ad)cp.a(paramConchPushInfo.mConch.aZ, new ad(), false);
      if ((((ad)localObject1).bm != null) && (((ad)localObject1).bm.size() >= 6))
      {
        i = ConvertUtil.stringToInt((String)((ad)localObject1).bm.get(0));
        localObject2 = (String)((ad)localObject1).bm.get(1);
        String str1 = (String)((ad)localObject1).bm.get(2);
        String str2 = (String)((ad)localObject1).bm.get(3);
        String str3 = (String)((ad)localObject1).bm.get(4);
        j = ConvertUtil.stringToInt((String)((ad)localObject1).bm.get(5));
        fk.a("guide_qqpimsecure_dialog_ison", i);
        Log.i("SecureGuideUtil", "cloud data: ison- " + i);
        fk.a("guide_qqpimsecure_dialog_line1", (String)localObject2);
        Log.i("SecureGuideUtil", "cloud data: line1- " + (String)localObject2);
        fk.a("guide_qqpimsecure_dialog_line2", str1);
        Log.i("SecureGuideUtil", "cloud data: line2- " + str1);
        fk.a("guide_qqpimsecure_dialog_line3", str2);
        Log.i("SecureGuideUtil", "cloud data: line3- " + str2);
        fk.a("guide_qqpimsecure_dialog_line4", str3);
        Log.i("SecureGuideUtil", "cloud data: line4- " + str3);
        fk.a("guide_qqpimsecure_dialog_limit_hour", j);
        Log.i("SecureGuideUtil", "cloud data: hour limit- " + j);
      }
      ConchServiceProxy.getInstance().reportConchResult(paramConchPushInfo, 10, 1);
      TMSDKContext.saveActionData(1150099);
      return;
    case 6277: 
      localObject2 = (ad)cp.a(paramConchPushInfo.mConch.aZ, new ad(), false);
      if ((((ad)localObject2).bm != null) && (((ad)localObject2).bm.size() >= 2))
      {
        i = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(0));
        j = ConvertUtil.stringToInt((String)((ad)localObject2).bm.get(1));
        fk.a("guide_qqpimsecure_tips_ison", i);
        Log.i("SecureGuideUtil", "cloud data: ison- " + i);
        fk.a("guide_qqpimsecure_tips_limit_hour", j);
        Log.i("SecureGuideUtil", "cloud data: hour limit- " + j);
        if (((ad)localObject2).bm.size() >= 4)
        {
          localObject1 = (String)((ad)localObject2).bm.get(2);
          localObject2 = (String)((ad)localObject2).bm.get(3);
          fk.a("guide_qqpimsecure_tips_line1", (String)localObject1);
          Log.i("SecureGuideUtil", "cloud data: line1- " + (String)localObject1);
          fk.a("guide_qqpimsecure_tips_line2", (String)localObject2);
          Log.i("SecureGuideUtil", "cloud data: line2- " + (String)localObject2);
        }
      }
      ConchServiceProxy.getInstance().reportConchResult(paramConchPushInfo, 10, 1);
      TMSDKContext.saveActionData(1150100);
      return;
    }
    Object localObject1 = (ad)cp.a(paramConchPushInfo.mConch.aZ, new ad(), false);
    if ((((ad)localObject1).bm != null) && (((ad)localObject1).bm.size() >= 1))
    {
      i = ConvertUtil.stringToInt((String)((ad)localObject1).bm.get(0));
      if (i > 0) {
        fk.a("privacy_dialog_agree_time", -1L);
      }
      Log.i("SecureGuideUtil", "cloud data: ison- " + i);
      if (((ad)localObject1).bm.size() >= 2)
      {
        localObject1 = (String)((ad)localObject1).bm.get(1);
        if (!TextUtils.isEmpty((CharSequence)localObject1)) {
          fk.a("privacy_dialog_line2_wording", (String)localObject1);
        }
        Log.i("SecureGuideUtil", "cloud data: line2- " + (String)localObject1);
      }
    }
    ConchServiceProxy.getInstance().reportConchResult(paramConchPushInfo, 10, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.fl
 * JD-Core Version:    0.7.0.1
 */