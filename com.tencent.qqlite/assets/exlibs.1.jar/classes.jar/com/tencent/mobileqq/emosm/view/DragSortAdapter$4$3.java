package com.tencent.mobileqq.emosm.view;

import android.view.View;
import android.widget.Button;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.ProgressCircle;
import com.tencent.qphone.base.util.QLog;

class DragSortAdapter$4$3
  implements Runnable
{
  DragSortAdapter$4$3(DragSortAdapter.4 param4, int paramInt, EmoticonPackage paramEmoticonPackage) {}
  
  public void run()
  {
    if (this.val$resultCode == 0)
    {
      this.this$1.val$progressCircle.setVisibility(8);
      this.this$1.val$updateLayout.setVisibility(8);
      ReportController.b((QQAppInterface)((BaseActivity)this.this$1.this$0.mContext).getAppRuntime(), "CliOper", "", "", "ep_mall", "Clk_pkg_download_aio-mine", 0, 0, this.val$ep.epId, "", "", "");
      if (QLog.isColorLevel()) {
        QLog.d("DragSortAdapter", 2, "===========report============" + this.val$ep.epId);
      }
    }
    Button localButton;
    do
    {
      return;
      this.this$1.val$progressCircle.setProgress(0);
      this.this$1.val$progressCircle.setVisibility(8);
      localButton = (Button)this.this$1.val$updateLayout.findViewById(2131297085);
    } while (localButton == null);
    localButton.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.4.3
 * JD-Core Version:    0.7.0.1
 */