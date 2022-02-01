package com.tencent.biz.pubaccount.readinjoy.engine;

import com.tencent.biz.pubaccount.readinjoy.struct.Kandian210Msg0xeeInfo.NotifyInfo;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import ocp;
import tencent.im.oidb.cmd0x80a.oidb_cmd0x80a.AttributeList;

public class ReadinjoySPEventReport$9
  implements Runnable
{
  public void run()
  {
    ArrayList localArrayList = new ArrayList();
    oidb_cmd0x80a.AttributeList localAttributeList1 = new oidb_cmd0x80a.AttributeList();
    localAttributeList1.att_id.set(1);
    localAttributeList1.att_name.set("FolderStatus");
    localAttributeList1.att_value.set(this.a.folderStatus + "");
    oidb_cmd0x80a.AttributeList localAttributeList2 = new oidb_cmd0x80a.AttributeList();
    localAttributeList2.att_id.set(2);
    localAttributeList2.att_name.set("StrategyID");
    localAttributeList2.att_value.set(this.a.strategyID + "");
    oidb_cmd0x80a.AttributeList localAttributeList3 = new oidb_cmd0x80a.AttributeList();
    localAttributeList3.att_id.set(3);
    localAttributeList3.att_name.set("AlgorithmID");
    localAttributeList3.att_value.set(this.a.algorithmID + "");
    localArrayList.add(localAttributeList1);
    localArrayList.add(localAttributeList2);
    localArrayList.add(localAttributeList3);
    switch (this.val$type)
    {
    default: 
      return;
    }
    for (int i = 17;; i = 16)
    {
      ocp.y(i, localArrayList);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.engine.ReadinjoySPEventReport.9
 * JD-Core Version:    0.7.0.1
 */