package com.tencent.mobileqq.apollo;

import abhc;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.face.QQHeadDownloadHandler;
import com.tencent.mobileqq.data.Setting;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;

public class ApolloGameArkHandler$1
  implements Runnable
{
  public ApolloGameArkHandler$1(abhc paramabhc, String paramString) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.val$uin)) {}
    Object localObject;
    do
    {
      Setting localSetting;
      do
      {
        do
        {
          return;
          localObject = this.this$0.getApp();
        } while (localObject == null);
        localSetting = ((QQAppInterface)localObject).b(this.val$uin);
      } while ((localSetting == null) || (TextUtils.isEmpty(localSetting.url)));
      localObject = MsfSdkUtils.insertMtype("QQHeadIcon", ((FriendListHandler)((QQAppInterface)localObject).getBusinessHandler(1)).a().a(localSetting.url, localSetting.bFaceFlags, localSetting.bUsrType, 0));
    } while (TextUtils.isEmpty((CharSequence)localObject));
    this.this$0.ei(this.val$uin, (String)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloGameArkHandler.1
 * JD-Core Version:    0.7.0.1
 */