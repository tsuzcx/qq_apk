package com.tencent.android.tpush.d;

import android.content.Context;
import android.content.Intent;
import com.jg.JgClassChecked;
import com.tencent.android.tpush.XGPushConfig;
import com.tencent.android.tpush.common.BroadcastAgent;
import com.tencent.android.tpush.common.i;
import com.tencent.android.tpush.encrypt.Rijndael;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.CommonWorkingThread;

@JgClassChecked(author=1, fComment="确认已进行安全校验", lastDate="20160810", reviewer=3, vComment={com.jg.EType.RECEIVERCHECK, com.jg.EType.INTENTCHECK})
public class b
{
  public static void a(Context paramContext)
  {
    if (paramContext == null)
    {
      TLogger.ee("OtherPushClient", "updateToken Error: context is null");
      return;
    }
    CommonWorkingThread.getInstance().execute(new b.1(paramContext));
  }
  
  private static void c(Context paramContext)
  {
    String str1 = XGPushConfig.getToken(paramContext);
    if (str1 == null)
    {
      TLogger.i("OtherPushClient", "updateToken: TPNS Token has not registered");
      return;
    }
    long l = XGPushConfig.getAccessId(paramContext);
    String str2 = XGPushConfig.getAccessKey(paramContext);
    String str3 = d.a(paramContext).i();
    String str4 = d.a(paramContext).f();
    TLogger.ii("OtherPushClient", "handleUpdateToken other push token is : " + str4 + " other push type: " + str3);
    if ((i.b(str3)) || (i.b(str4)))
    {
      TLogger.ww("OtherPushClient", "updateToken Error: get otherPushType or otherPushToken is null");
      return;
    }
    try
    {
      Intent localIntent = new Intent(paramContext.getPackageName() + "com.tencent.android.xg.vip.action.UPDATE_OTHER_PUSH_TOKEN.V4");
      localIntent.putExtra("accId", Rijndael.encrypt("" + l));
      localIntent.putExtra("accKey", Rijndael.encrypt("" + str2));
      localIntent.putExtra("token", Rijndael.encrypt(str1));
      localIntent.putExtra("other_push_type", Rijndael.encrypt(str3));
      localIntent.putExtra("other_push_token", Rijndael.encrypt(str4));
      BroadcastAgent.sendBroadcast(paramContext, localIntent);
      return;
    }
    catch (Throwable paramContext)
    {
      TLogger.e("OtherPushClient", "sendBroadcast action ACTION_UPDATE_OTHER_PUSH_TOKEN error", paramContext);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.android.tpush.d.b
 * JD-Core Version:    0.7.0.1
 */