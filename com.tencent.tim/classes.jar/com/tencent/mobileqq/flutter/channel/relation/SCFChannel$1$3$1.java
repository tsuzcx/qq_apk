package com.tencent.mobileqq.flutter.channel.relation;

import com.tencent.mobileqq.data.SpecialCareInfo;
import com.tencent.mobileqq.flutter.channel.model.SCFSwitchs;
import io.flutter.plugin.common.MethodChannel.Result;

class SCFChannel$1$3$1
  implements Runnable
{
  SCFChannel$1$3$1(SCFChannel.1.3 param3, SpecialCareInfo paramSpecialCareInfo, boolean paramBoolean) {}
  
  public void run()
  {
    boolean bool2 = true;
    Object localObject = new SCFSwitchs();
    if (this.b != null)
    {
      if (this.b.qzoneSwitch != 1) {
        break label89;
      }
      bool1 = true;
      ((SCFSwitchs)localObject).isQzoneNotify = Boolean.valueOf(bool1);
      if (this.b.globalSwitch != 1) {
        break label94;
      }
    }
    label89:
    label94:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((SCFSwitchs)localObject).isSpecialCare = Boolean.valueOf(bool1);
      ((SCFSwitchs)localObject).isVoiceNewFlag = Boolean.valueOf(this.cgy);
      localObject = SCFSwitchs.toMap((SCFSwitchs)localObject);
      this.a.val$result.success(localObject);
      return;
      bool1 = false;
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.flutter.channel.relation.SCFChannel.1.3.1
 * JD-Core Version:    0.7.0.1
 */