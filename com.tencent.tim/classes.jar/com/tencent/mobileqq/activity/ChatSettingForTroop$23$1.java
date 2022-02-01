package com.tencent.mobileqq.activity;

import anot;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatSettingForTroop$23$1
  implements Runnable
{
  ChatSettingForTroop$23$1(ChatSettingForTroop.23 param23, ArrayList paramArrayList) {}
  
  public void run()
  {
    if (this.a.this$0.qC != null)
    {
      Iterator localIterator = this.a.this$0.qC.iterator();
      while (localIterator.hasNext())
      {
        oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)localIterator.next();
        if (!this.eg.contains(localmemberlist.uint64_member_uin.get() + "")) {
          this.eg.add(localmemberlist.uint64_member_uin.get() + "");
        }
      }
    }
    ChatSettingForTroop.a(this.a.this$0, this.a.this$0.a.troopUin, this.a.this$0.a.isOwnerOrAdim(), this.eg);
    this.a.this$0.report("Grp", "Clk_invite_new", "0");
    anot.a(this.a.this$0.app, "dc00899", "Grp_create", "", "search", "grpedit_grpcreate_clk", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.23.1
 * JD-Core Version:    0.7.0.1
 */