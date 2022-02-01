package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StSubscribeMessage;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.mini.app.AuthorizeCenter;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

class SubMsgPermissionSettingFragment$2
  implements CompoundButton.OnCheckedChangeListener
{
  SubMsgPermissionSettingFragment$2(SubMsgPermissionSettingFragment paramSubMsgPermissionSettingFragment) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    if (SubMsgPermissionSettingFragment.access$000(this.this$0)) {
      SubMsgPermissionSettingFragment.access$002(this.this$0, false);
    }
    while (!(paramCompoundButton.getTag() instanceof INTERFACE.StSubscribeMessage))
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
    }
    INTERFACE.StSubscribeMessage localStSubscribeMessage = (INTERFACE.StSubscribeMessage)paramCompoundButton.getTag();
    Object localObject = localStSubscribeMessage.authState;
    if (paramBoolean) {}
    for (int i = 1;; i = 2)
    {
      ((PBInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((ArrayList)localObject).add(localStSubscribeMessage);
      this.this$0.authorizeCenter.updateOnceSubMsgSetting(paramBoolean, (List)localObject, new SubMsgPermissionSettingFragment.2.1(this, localStSubscribeMessage, paramBoolean, paramCompoundButton));
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.SubMsgPermissionSettingFragment.2
 * JD-Core Version:    0.7.0.1
 */