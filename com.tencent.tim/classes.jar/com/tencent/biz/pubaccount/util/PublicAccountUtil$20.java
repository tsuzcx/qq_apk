package com.tencent.biz.pubaccount.util;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import lcm;
import ljc;
import lun;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;
import wja;

public final class PublicAccountUtil$20
  implements Runnable
{
  public PublicAccountUtil$20(List paramList, int paramInt) {}
  
  public void run()
  {
    try
    {
      ljc localljc = new ljc(null, null, null, lun.a(), null);
      this.kT.addAll(lcm.a().j(this.Tt));
      String str = "KDreportPushEffectEvent info : eventId:" + Integer.toString(this.Tt) + "; AttributeList:[";
      Iterator localIterator = this.kT.iterator();
      while (localIterator.hasNext())
      {
        oidb_cmd0x80a.AttributeList localAttributeList = (oidb_cmd0x80a.AttributeList)localIterator.next();
        str = str + "{ att_id:" + Integer.toString(localAttributeList.att_id.get()) + "; att_name:" + localAttributeList.att_name.get() + "; att_value:" + localAttributeList.att_value.get() + " },";
      }
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountUtil", 2, str);
      }
      localljc.a(this.Tt, "", this.kT);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("PublicAccountUtil", 1, "reportPushEffectEvent", localException);
      wja.a("PublicAccountUtil", localException.toString(), localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.util.PublicAccountUtil.20
 * JD-Core Version:    0.7.0.1
 */