package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import lcm;
import lcm.d;
import ocp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$3
  implements Runnable
{
  public ReadinjoySPEventReport$3(boolean paramBoolean) {}
  
  public void run()
  {
    if ((!this.ajk) && (!lcm.access$300())) {}
    label285:
    label293:
    label299:
    label304:
    for (;;)
    {
      return;
      if (this.ajk)
      {
        lcm.access$402(System.currentTimeMillis());
        lcm.p(true);
      }
      lcm.access$302(this.ajk);
      Object localObject;
      if (lcm.access$000(9))
      {
        ArrayList localArrayList = new ArrayList();
        oidb_cmd0x80a.AttributeList localAttributeList = new oidb_cmd0x80a.AttributeList();
        localAttributeList.att_id.set(1);
        localAttributeList.att_name.set("isOn");
        PBStringField localPBStringField = localAttributeList.att_value;
        if (!this.ajk) {
          break label285;
        }
        localObject = String.valueOf(1);
        localPBStringField.set((String)localObject);
        localArrayList.add(localAttributeList);
        if (!this.ajk)
        {
          long l = lcm.access$400();
          l = (System.currentTimeMillis() - l) / 1000L;
          localObject = new oidb_cmd0x80a.AttributeList();
          ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
          ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("time");
          ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(l));
          localArrayList.add(localObject);
          localAttributeList = new oidb_cmd0x80a.AttributeList();
          localAttributeList.att_id.set(3);
          localAttributeList.att_name.set("isScreenTime");
          localPBStringField = localAttributeList.att_value;
          if (!lcm.access$500()) {
            break label293;
          }
          localObject = "1";
          label231:
          localPBStringField.set((String)localObject);
          localArrayList.add(localAttributeList);
        }
        ocp.y(9, localArrayList);
        if (!this.ajk) {
          break label299;
        }
        lcm.C(System.currentTimeMillis());
        lcm.dh(0);
      }
      for (;;)
      {
        if (lcm.d.aNy != 1) {
          break label304;
        }
        lcm.nk(false);
        return;
        localObject = String.valueOf(0);
        break;
        localObject = "0";
        break label231;
        lcm.os();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.3
 * JD-Core Version:    0.7.0.1
 */