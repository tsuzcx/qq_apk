package com.tencent.biz.pubaccount.readinjoy.engine;

import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.view.View;
import awit;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.redtouch.RedTouch;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kxm;
import lcm;
import ocp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$14
  implements Runnable
{
  public void run()
  {
    if (lcm.access$000(24))
    {
      ArrayList localArrayList = new ArrayList();
      Object localObject1 = BaseActivity.sTopActivity;
      if ((localObject1 != null) && ((localObject1 instanceof SplashActivity))) {}
      for (;;)
      {
        try
        {
          Object localObject2 = (MainFragment)((SplashActivity)localObject1).getSupportFragmentManager().findFragmentByTag(MainFragment.class.getName());
          localObject1 = (View)((MainFragment)localObject2).y().get(MainFragment.aOe + "_num");
          if (localObject1 == null) {
            return;
          }
          int i = ((View)localObject1).getVisibility();
          oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(1);
          localAttributeList.att_name.set("MsgRedStatus");
          PBStringField localPBStringField = localAttributeList.att_value;
          if (i != 0) {
            continue;
          }
          localObject1 = String.valueOf(1);
          localPBStringField.set((String)localObject1);
          localArrayList.add(localAttributeList);
          boolean bool = ((MainFragment)localObject2).a(MainFragment.aOf).aux();
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(2);
          localAttributeList.att_name.set("ContactsRedStatus");
          localPBStringField = localAttributeList.att_value;
          if (!bool) {
            continue;
          }
          localObject1 = String.valueOf(1);
          localPBStringField.set((String)localObject1);
          localArrayList.add(localAttributeList);
          bool = ((MainFragment)localObject2).a(MainFragment.aOg).aux();
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(3);
          localAttributeList.att_name.set("TrendsRedStatus");
          localPBStringField = localAttributeList.att_value;
          if (!bool) {
            continue;
          }
          localObject1 = String.valueOf(1);
          localPBStringField.set((String)localObject1);
          localArrayList.add(localAttributeList);
          if (awit.Vs())
          {
            localObject1 = ((MainFragment)localObject2).a(MainFragment.aOh);
            if (localObject1 != null)
            {
              bool = ((RedTouch)localObject1).aux();
              localAttributeList = new oidb_cmd0x80a.AttributeList();
              localAttributeList.att_id.set(4);
              localAttributeList.att_name.set("KandianRedStatus");
              localPBStringField = localAttributeList.att_value;
              if (!bool) {
                continue;
              }
              localObject1 = String.valueOf(1);
              localPBStringField.set((String)localObject1);
              localArrayList.add(localAttributeList);
            }
          }
          localObject1 = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject1).att_id.set(5);
          ((oidb_cmd0x80a.AttributeList)localObject1).att_name.set("tab");
          i = lcm.dg(((MainFragment)localObject2).getCurrentTab());
          ((oidb_cmd0x80a.AttributeList)localObject1).att_value.set("" + i);
          localArrayList.add(localObject1);
          localObject1 = kxm.be(1008);
          if ((i == 1) && (!TextUtils.isEmpty((CharSequence)localObject1)))
          {
            localObject2 = new oidb_cmd0x80a.AttributeList();
            ((oidb_cmd0x80a.AttributeList)localObject2).att_id.set(6);
            ((oidb_cmd0x80a.AttributeList)localObject2).att_name.set("FuncRed");
            ((oidb_cmd0x80a.AttributeList)localObject2).att_value.set((String)localObject1);
            localArrayList.add(localObject2);
          }
        }
        catch (Exception localException)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ReadinjoySPEventReport", 2, "reportTabExposure_ERROR : ", localException);
          continue;
        }
        ocp.y(24, localArrayList);
        return;
        localObject1 = String.valueOf(0);
        continue;
        localObject1 = String.valueOf(0);
        continue;
        localObject1 = String.valueOf(0);
        continue;
        localObject1 = String.valueOf(0);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.14
 * JD-Core Version:    0.7.0.1
 */