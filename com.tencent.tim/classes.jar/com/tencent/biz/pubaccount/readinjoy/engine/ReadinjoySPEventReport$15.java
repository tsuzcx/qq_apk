package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import java.util.List;
import lcm;
import ocp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public final class ReadinjoySPEventReport$15
  implements Runnable
{
  public ReadinjoySPEventReport$15(List paramList, int paramInt1, int paramInt2) {}
  
  public void run()
  {
    int j = 0;
    long l2;
    ArrayList localArrayList;
    oidb_cmd0x80a.AttributeList localAttributeList;
    PBStringField localPBStringField;
    if (lcm.access$000(60))
    {
      long l1 = lcm.cz();
      l2 = lcm.B(l1 * 1000L) / 1000L;
      int k = this.hl.size() - 1;
      int i = 0;
      if (k >= 0)
      {
        localObject = (ChatMessage)this.hl.get(k);
        if (((ChatMessage)localObject).time > l1)
        {
          if (((ChatMessage)localObject).isSendFromLocal())
          {
            i = j;
            j = 1;
          }
          for (;;)
          {
            int m = k - 1;
            k = j;
            j = i;
            i = k;
            k = m;
            break;
            m = 1;
            j = i;
            i = m;
          }
        }
      }
      localArrayList = new ArrayList();
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(1);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("aiotype");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set(String.valueOf(lcm.df(this.aNq)));
      localArrayList.add(localObject);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(2);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("unreadmsg");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + this.aNr);
      localArrayList.add(localObject);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(3);
      localAttributeList.att_name.set("hassendmsg");
      localPBStringField = localAttributeList.att_value;
      if (i == 0) {
        break label441;
      }
      localObject = "1";
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localAttributeList = new oidb_cmd0x80a.AttributeList();
      localAttributeList.att_id.set(4);
      localAttributeList.att_name.set("hasrecvmsg");
      localPBStringField = localAttributeList.att_value;
      if (j == 0) {
        break label448;
      }
    }
    label441:
    label448:
    for (Object localObject = "1";; localObject = "0")
    {
      localPBStringField.set((String)localObject);
      localArrayList.add(localAttributeList);
      localObject = new oidb_cmd0x80a.AttributeList();
      ((oidb_cmd0x80a.AttributeList)localObject).att_id.set(5);
      ((oidb_cmd0x80a.AttributeList)localObject).att_name.set("costtime");
      ((oidb_cmd0x80a.AttributeList)localObject).att_value.set("" + l2);
      localArrayList.add(localObject);
      ocp.y(60, localArrayList);
      return;
      localObject = "0";
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.15
 * JD-Core Version:    0.7.0.1
 */