package com.tencent.mobileqq.activity;

import anot;
import com.tencent.qphone.base.util.QLog;
import java.util.Collections;
import java.util.List;

class TroopAssistantActivity$18
  implements Runnable
{
  TroopAssistantActivity$18(TroopAssistantActivity paramTroopAssistantActivity) {}
  
  public void run()
  {
    try
    {
      List localList = this.this$0.cJ();
      StringBuilder localStringBuilder = new StringBuilder().append("refreshTroopList -- data.size():");
      int i;
      if (localList == null) {
        i = 0;
      }
      for (;;)
      {
        QLog.e("TroopAssistantActivity", 2, i);
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder().append("data|size");
          if (localList != null) {
            break label118;
          }
          i = 0;
          QLog.i("TroopAssistantActivity", 2, i);
        }
        try
        {
          Collections.sort(localList, this.this$0.mComparator);
          this.this$0.runOnUiThread(new TroopAssistantActivity.18.1(this, localList));
          return;
          i = localList.size();
          continue;
          label118:
          i = localList.size();
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e("TroopAssistantActivity", 2, "Collections.sort error ..., msg: " + localException2.getMessage());
            }
          }
        }
      }
      return;
    }
    catch (Exception localException1)
    {
      anot.a(this.this$0.app, "P_CliOper", "BizTechReport", "", "troop_assistant", "load_data_failed", 0, 0, localException1.toString(), "", "", "");
      if (QLog.isColorLevel()) {
        QLog.i("TroopAssistantActivity", 2, "refreshTroopList exception:" + localException1.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.TroopAssistantActivity.18
 * JD-Core Version:    0.7.0.1
 */