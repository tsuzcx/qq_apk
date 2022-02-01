package com.tencent.mobileqq.vashealth;

import android.content.Context;
import android.text.TextUtils;
import aqtw;
import aqtz;
import aque;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.msf.sdk.utils.SignUtils;
import com.tencent.qphone.base.util.QLog;
import kds;
import mqq.app.NewIntent;

public class StepServiceAsync
  extends AsyncStep
{
  public int od()
  {
    if (QLog.isColorLevel()) {
      QLog.i("StepServiceAsync", 2, "StepServiceAsync call!");
    }
    Object localObject = (kds)this.a.app.getBusinessHandler(139);
    ((kds)localObject).Bu = true;
    ((kds)localObject).rO = System.currentTimeMillis();
    ((kds)localObject).a(null, null, false, null);
    localObject = BaseApplicationImpl.getApplication().getApplicationContext();
    if (!aqtz.aFD())
    {
      QLog.i("StepServiceAsync", 1, "step counter unsupported model.");
      return super.od();
    }
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.health_ban.name(), "");
    QLog.i("StepServiceAsync", 1, "ban_info:" + str);
    if ((!TextUtils.isEmpty(str)) && (Integer.parseInt(str) == 0))
    {
      localObject = new NewIntent((Context)localObject, aque.class);
      ((NewIntent)localObject).putExtra("msf_cmd_type", "cmd_health_switch");
      ((NewIntent)localObject).putExtra("isOpen", false);
      this.a.app.startServlet((NewIntent)localObject);
      QLog.e("StepServiceAsync", 1, "step counter found current model banned!");
      return super.od();
    }
    if (!SignUtils.isSupportKeyStore()) {}
    for (boolean bool = true;; bool = false)
    {
      aqtw.cWe = bool;
      localObject = (aqtz)this.a.app.getManager(260);
      if (aqtw.mG(1)) {
        ((aqtz)localObject).VI("login");
      }
      ((aqtz)localObject).efE();
      return 7;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vashealth.StepServiceAsync
 * JD-Core Version:    0.7.0.1
 */