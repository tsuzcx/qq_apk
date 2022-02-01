package com.tencent.mobileqq.activity;

import acfp;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.List;
import tencent.im.oidb.cmd0x899.oidb_0x899.memberlist;

class ChatSettingForTroop$43$1
  implements Runnable
{
  ChatSettingForTroop$43$1(ChatSettingForTroop.43 param43) {}
  
  public void run()
  {
    ArrayList localArrayList = this.a.val$data.getExtras().getStringArrayList("deleted_members");
    if (localArrayList != null)
    {
      if (this.a.this$0.tR != null) {
        this.a.this$0.tR.setText(this.a.this$0.a.wMemberNum + acfp.m(2131703739));
      }
      int i = localArrayList.size() - 1;
      while (i >= 0)
      {
        int j = this.a.this$0.qC.size() - 1;
        if (j >= 0)
        {
          oidb_0x899.memberlist localmemberlist = (oidb_0x899.memberlist)this.a.this$0.qC.get(j);
          if ((localmemberlist == null) || (!localmemberlist.uint64_member_uin.has())) {}
          while (!String.valueOf(localmemberlist.uint64_member_uin.get()).equals(localArrayList.get(i)))
          {
            j -= 1;
            break;
          }
          this.a.this$0.qC.remove(j);
        }
        i -= 1;
      }
    }
    this.a.this$0.fH(this.a.this$0.qC);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.43.1
 * JD-Core Version:    0.7.0.1
 */