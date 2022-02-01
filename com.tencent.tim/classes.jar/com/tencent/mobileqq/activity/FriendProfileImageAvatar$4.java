package com.tencent.mobileqq.activity;

import afka;
import ahbj;
import ajrk;
import android.os.Message;
import aqep;
import com.tencent.mobileqq.msf.sdk.MsfSdkUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;
import vbg;

public class FriendProfileImageAvatar$4
  implements Runnable
{
  public FriendProfileImageAvatar$4(vbg paramvbg, String paramString1, byte paramByte, String paramString2) {}
  
  public void run()
  {
    Object localObject2 = aqep.pf(String.valueOf(this.val$uin));
    if (ahbj.isFileExists((String)localObject2)) {
      if (ajrk.isDevelopLevel()) {
        ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar hd avatar file exist 2", new Object[0]);
      }
    }
    for (;;)
    {
      return;
      if (this.this$0.SR)
      {
        if (!ajrk.isDevelopLevel()) {
          continue;
        }
        ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar is downloading and return 2", new Object[0]);
        return;
      }
      this.this$0.SR = true;
      int i;
      label86:
      Object localObject1;
      if ((this.aL & 0x20) != 0)
      {
        i = 0;
        localObject1 = this.val$url + i;
      }
      try
      {
        this.this$0.l = new URL((String)localObject1);
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.Avatar", 2, "downloadHDAvatar()  uin=" + this.val$uin + ", mgSize=" + i + ", url = " + (String)localObject1);
        }
        localObject2 = new File((String)localObject2);
        File localFile = new File(((File)localObject2).getPath() + Long.toString(System.currentTimeMillis()));
        if (HttpDownloadUtil.a(this.this$0.app, new afka(MsfSdkUtils.insertMtype("friendlist", (String)localObject1), localFile, 0), this.this$0) == 0)
        {
          bool1 = true;
          boolean bool2 = bool1;
          if (bool1) {
            bool2 = localFile.renameTo((File)localObject2);
          }
          if (this.this$0.g != null)
          {
            localObject1 = Message.obtain();
            ((Message)localObject1).what = 3;
            if (!bool2) {
              break label429;
            }
            i = 1;
            ((Message)localObject1).arg1 = i;
            this.this$0.g.sendMessage((Message)localObject1);
          }
          this.this$0.SR = false;
          if (!ajrk.isDevelopLevel()) {
            continue;
          }
          ajrk.f("Q.profilecard.Avatar", "downloadHDAvatar end of downloading", new Object[0]);
          return;
          if ((this.aL & 0x10) != 0)
          {
            i = 640;
            break label86;
          }
          if ((this.aL & 0x8) != 0)
          {
            i = 140;
            break label86;
          }
          if ((this.aL & 0x4) != 0)
          {
            i = 100;
            break label86;
          }
          i = 40;
        }
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          boolean bool1;
          if (QLog.isColorLevel())
          {
            QLog.e("Q.profilecard.Avatar", 2, localMalformedURLException.toString());
            continue;
            bool1 = false;
            continue;
            label429:
            i = 0;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.FriendProfileImageAvatar.4
 * JD-Core Version:    0.7.0.1
 */