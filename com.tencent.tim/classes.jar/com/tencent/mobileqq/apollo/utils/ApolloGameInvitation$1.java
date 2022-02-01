package com.tencent.mobileqq.apollo.utils;

import abxi;
import abxy;
import abxz;
import acfp;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import apzg;
import aqcu;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.view.ApolloPanel.b;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URLEncoder;
import org.json.JSONObject;

public class ApolloGameInvitation$1
  implements Runnable
{
  public ApolloGameInvitation$1(abxy paramabxy) {}
  
  public void run()
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(abxi.biF).append(abxy.a(this.this$0).gameId).append("/inviteIcon.png");
    try
    {
      if (new File(((StringBuilder)localObject1).toString()).exists()) {
        localObject1 = BitmapFactory.decodeFile(((StringBuilder)localObject1).toString());
      } else {
        localObject1 = aqcu.f(BaseApplicationImpl.getApplication().getResources(), 2130838700);
      }
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, oom happens, errInfo->" + localOutOfMemoryError.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("ApolloGameInvitation", 1, "fail to invite wxFriend, error happens, errInfo->" + localThrowable.getMessage());
      return;
    }
    while (localException != null)
    {
      Bitmap localBitmap = apzg.R(localThrowable);
      abxy.a(this.this$0, String.valueOf(System.currentTimeMillis()));
      String str1 = acfp.m(2131702516) + abxy.a(this.this$0).gameName;
      Object localObject2 = new JSONObject();
      try
      {
        ((JSONObject)localObject2).put("gameId", abxy.a(this.this$0).gameId);
        ((JSONObject)localObject2).put("roomId", abxy.a(this.this$0).roomId);
        ((JSONObject)localObject2).put("gameMode", abxy.a(this.this$0).gameMode);
        ((JSONObject)localObject2).put("extendInfo", abxy.a(this.this$0).gameExtendJson);
        localObject2 = URLEncoder.encode(((JSONObject)localObject2).toString(), "UTF-8");
        String str2 = URLEncoder.encode(str1, "UTF-8");
        StringBuilder localStringBuilder = new StringBuilder("https://cmshow.qq.com/apollo/html/redirect/mqqapi_cmshow.html");
        localStringBuilder.append("?").append("cmd=game_invite&title=").append(str2).append("&data=").append((String)localObject2);
        WXShareHelper.a().a(new abxz(this));
        WXShareHelper.a().c(abxy.a(this.this$0), str1, localBitmap, abxy.b(this.this$0), localStringBuilder.toString(), 1);
        return;
      }
      catch (Exception localException)
      {
        QLog.w("ApolloGameInvitation", 1, "[inviteWeChatFriend], errInfo->" + localException.getMessage());
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.utils.ApolloGameInvitation.1
 * JD-Core Version:    0.7.0.1
 */