package com.tencent.biz.pubaccount.readinjoy.common;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import kya;
import lcm;
import ocp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class WeishiReportUtil$2
  implements Runnable
{
  public WeishiReportUtil$2(int paramInt, String paramString1, long paramLong, String paramString2, String paramString3, String paramString4) {}
  
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(1);
    localAttributeList.att_name.set("ExitType");
    localAttributeList.att_value.set(kya.bh(this.val$from));
    localArrayList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(2);
    localAttributeList.att_name.set("FolderStatus");
    localAttributeList.att_value.set(String.valueOf(this.YW));
    localArrayList.add(localAttributeList);
    localAttributeList = new oidb_cmd0x80a.AttributeList();
    localAttributeList.att_id.set(3);
    localAttributeList.att_name.set("Time");
    localAttributeList.att_value.set(String.valueOf(lcm.B(this.ti) / 1000L));
    localArrayList.add(localAttributeList);
    if (!"1".equals(this.YW))
    {
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(5);
      localAttributeList.att_name.set("StrategyID");
      localAttributeList.att_value.set(this.adG);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(6);
      localAttributeList.att_name.set("AlgorithmID");
      localAttributeList.att_value.set(this.adH);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(7);
      localAttributeList.att_name.set("costtime");
      localAttributeList.att_value.set("" + this.adI);
      localArrayList.add(localAttributeList);
    }
    ocp.y(26, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.common.WeishiReportUtil.2
 * JD-Core Version:    0.7.0.1
 */