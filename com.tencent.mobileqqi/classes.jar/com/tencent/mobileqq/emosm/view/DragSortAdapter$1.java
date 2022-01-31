package com.tencent.mobileqq.emosm.view;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressCircle;

class DragSortAdapter$1
  implements View.OnClickListener
{
  DragSortAdapter$1(DragSortAdapter paramDragSortAdapter, EmoticonPackage paramEmoticonPackage, ProgressCircle paramProgressCircle) {}
  
  public void onClick(View paramView)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.this$0.mContext).getAppRuntime();
    if (this.val$pkg != null)
    {
      EmoticonController.a(localQQAppInterface).a(this.val$pkg, true);
      paramView.setVisibility(8);
      this.val$progressCircle.setVisibility(0);
      ReportController.b(localQQAppInterface, "CliOper", "", localQQAppInterface.a(), "ep_mall", "Clk_updatepkg_mine", 0, 0, this.val$pkg.epId, "" + this.val$pkg.localVersion, "" + this.val$pkg.latestVersion, "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.1
 * JD-Core Version:    0.7.0.1
 */