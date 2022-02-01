package com.tencent.mobileqq.apollo;

import aafz;
import abhh;
import abis;
import ablf;
import abqt;
import abwh;
import abwi.a;
import abxe;
import abxh;
import abxi;
import android.content.SharedPreferences;
import android.text.TextUtils;
import aqhq;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.apollo.process.chanel.CmGameCmdChannel;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Timer;

public class ApolloManager$2
  implements Runnable
{
  public ApolloManager$2(abhh paramabhh) {}
  
  public void run()
  {
    boolean bool2 = false;
    Object localObject;
    boolean bool1;
    if (this.this$0.mApp != null)
    {
      long l = 0L;
      if (QLog.isColorLevel()) {
        l = System.currentTimeMillis();
      }
      abhh.a(this.this$0);
      abhh.b(this.this$0);
      aqhq.UD(abxi.bim + "/.nomedia");
      this.this$0.cBG();
      abwh.a(new abwi.a().a(1).a(this.this$0.mApp.getCurrentAccountUin()).a());
      new abqt(0, null);
      abhh.aV(this.this$0.mApp.getApplication());
      abhh.DB(false);
      localObject = BaseApplicationImpl.getApplication().getSharedPreferences("apollo_pet_sp", 0);
      this.this$0.bfZ = ((SharedPreferences)localObject).getString("pet_config", null);
      if (QLog.isColorLevel()) {
        QLog.d("ApolloManager", 2, "init apollo data from db done cost: " + (System.currentTimeMillis() - l) + ", mApp: " + this.this$0.mApp);
      }
      ablf.loadConfig();
      abxe.cj(this.this$0.mApp);
      abhh.bCA = true;
      this.this$0.cBT();
      ApolloUtil.a();
      abis.a().a(this.this$0.mApp, 0, false);
      if (this.this$0.mApp != null)
      {
        localObject = this.this$0.b(this.this$0.mApp.getCurrentAccountUin());
        if (localObject != null)
        {
          ((ApolloBaseInfo)localObject).getApolloDress();
          ((ApolloBaseInfo)localObject).getApolloDress3D();
          ((ApolloBaseInfo)localObject).getApolloPetDress();
        }
      }
      CmGameCmdChannel.a(this.this$0.mApp);
      new File(abxi.biu).mkdirs();
      localObject = aafz.getEMUIVersion();
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        if (!((String)localObject).contains("EmotionUI ")) {
          break label422;
        }
        if (abxh.q(((String)localObject).substring("EmotionUI ".length()), "10") < 0) {
          break label460;
        }
        bool1 = true;
      }
    }
    for (;;)
    {
      if (bool1) {
        this.this$0.z = new Timer();
      }
      QLog.i("ApolloManager", 1, "emui:" + (String)localObject + " emui10Plus:" + bool1);
      return;
      label422:
      bool1 = bool2;
      if (((String)localObject).contains("EmotionUI_"))
      {
        bool1 = bool2;
        if (abxh.q(((String)localObject).substring("EmotionUI ".length()), "10") >= 0)
        {
          bool1 = true;
          continue;
          label460:
          bool1 = false;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.2
 * JD-Core Version:    0.7.0.1
 */