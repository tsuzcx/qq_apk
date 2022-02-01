package com.tencent.av.redpacket.config;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.os.RemoteException;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import irz;
import itw;
import java.io.File;
import jgu;
import jgx;
import jgy;
import jik;

public class AVRedPacketConfigManager$2
  implements Runnable
{
  public AVRedPacketConfigManager$2(irz paramirz, int paramInt1, String paramString1, String paramString2, int paramInt2, String paramString3) {}
  
  public void run()
  {
    boolean bool2 = false;
    QLog.d("AVRedPacketConfigManger", 1, "onDownloadFinish,subHandler runnable start,threadName = " + Thread.currentThread().getName());
    boolean bool1;
    Object localObject;
    SharedPreferences localSharedPreferences;
    if (this.val$errCode == 0)
    {
      bool1 = true;
      localObject = new File(this.val$path);
      localSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("avredpacket_sp", 4);
      if ((bool1) && (((File)localObject).exists()))
      {
        long l1 = localSharedPreferences.getLong(this.val$md5, -1L);
        long l2 = ((File)localObject).lastModified();
        if ((l1 != -1L) && (l1 != l2)) {
          localSharedPreferences.edit().putInt("pcm_" + this.val$md5, 0).commit();
        }
        if ((this.Zi == 2) && (l1 != l2))
        {
          jgu localjgu = jgu.a();
          if ((localjgu == null) || (localjgu.azi != 1) || (!jgy.cG(this.val$md5))) {
            break label689;
          }
          irz.a(this.this$0).removeMessages(100);
          irz.a(this.this$0).sendEmptyMessageDelayed(100, 60000L);
          l2 = System.currentTimeMillis();
          jgy.kx(this.val$path);
          long l3 = System.currentTimeMillis();
          irz.a(this.this$0).removeMessages(100);
          jgx.ea(l3 - l2);
        }
        label264:
        l2 = ((File)localObject).lastModified();
        localSharedPreferences.edit().putLong(this.val$md5, l2).commit();
        if (QLog.isColorLevel()) {
          QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + this.val$url + ",md5 = " + this.val$md5 + ",errCode = " + this.val$errCode + ",path = " + this.val$path + ",modifyTime = " + l2 + ", spModifiedTime=" + l1);
        }
      }
      if (this.this$0.b != null)
      {
        if (this.Zi != 1) {
          break label700;
        }
        this.this$0.UE = true;
        this.this$0.resPath = this.val$path;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("AVRedPacketConfigManger", 2, "onDownloadFinish,url =   " + this.val$url + ",md5 = " + this.val$md5 + ",errCode = " + this.val$errCode + ",path = " + this.val$path + ",downloadBgMusicFinish = " + this.this$0.UF + ",downloadResFinish = " + this.this$0.UE + ",downloadCallBack = " + this.this$0.b);
      }
      if ((this.this$0.UE) && (this.this$0.UF)) {}
      for (;;)
      {
        try
        {
          jik.setResPath(this.this$0.resPath);
          localObject = jik.ho();
          if (aqhq.fileExistsAndNotEmpty(this.val$path)) {
            continue;
          }
          QLog.w("AVRedPacketConfigManger", 1, "onDownloadFinish, !exist, mp4[" + (String)localObject + "]");
          bool1 = bool2;
        }
        catch (RemoteException localRemoteException1)
        {
          localRemoteException1.printStackTrace();
          continue;
          continue;
        }
        try
        {
          this.this$0.b.d(bool1, this.this$0.resPath, this.this$0.Qp);
          if (bool1) {
            localSharedPreferences.edit().putBoolean("res_exist", true).commit();
          }
          this.this$0.b = null;
          this.this$0.jy("onDownloadFinish");
          return;
        }
        catch (RemoteException localRemoteException2) {}
      }
      bool1 = false;
      break;
      label689:
      QLog.i("AVRedPacketConfigManger", 1, "convertMp3ToPcm dpc != 1 or is rubbish device");
      break label264;
      label700:
      if (this.Zi == 2)
      {
        this.this$0.UF = true;
        this.this$0.Qp = this.val$path;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.redpacket.config.AVRedPacketConfigManager.2
 * JD-Core Version:    0.7.0.1
 */