package com.tencent.mobileqq.teamworkforgroup;

import android.view.View;
import aoeq;
import com.tencent.qphone.base.util.QLog;

public class TroopTeamWorkFileSearchDialog$11
  implements Runnable
{
  public TroopTeamWorkFileSearchDialog$11(aoeq paramaoeq, View paramView, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.val$view != null) {
      this.val$view.setDrawingCacheEnabled(this.cLp);
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("mBlurBackground == null :");
      if (aoeq.a(this.this$0) != null) {
        break label64;
      }
    }
    label64:
    for (boolean bool = true;; bool = false)
    {
      QLog.d("TroopTeamWorkFileSearchDialog", 2, bool);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.teamworkforgroup.TroopTeamWorkFileSearchDialog.11
 * JD-Core Version:    0.7.0.1
 */