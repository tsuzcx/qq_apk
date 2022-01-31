package com.tencent.mobileqq.emosm.view;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.ProgressCircle;

class DragSortAdapter$2
  implements View.OnClickListener
{
  DragSortAdapter$2(DragSortAdapter paramDragSortAdapter, Button paramButton, EmoticonPackage paramEmoticonPackage, ProgressCircle paramProgressCircle, View paramView) {}
  
  public void onClick(View paramView)
  {
    if (this.val$updateBtn.getText().toString().equals(this.this$0.mContext.getResources().getString(2131364044))) {}
    do
    {
      do
      {
        DragSortAdapter.access$002(this.this$0, "down");
        for (;;)
        {
          QQAppInterface localQQAppInterface = (QQAppInterface)((BaseActivity)this.this$0.mContext).getAppRuntime();
          if (this.val$pkg.valid)
          {
            if (!"update".equals(DragSortAdapter.access$000(this.this$0))) {
              break;
            }
            if (this.val$pkg != null)
            {
              ((EmojiManager)localQQAppInterface.getManager(39)).a(this.val$pkg, true);
              paramView.setVisibility(8);
              this.val$progressCircle.setVisibility(0);
              ReportController.b(localQQAppInterface, "CliOper", "", localQQAppInterface.a(), "ep_mall", "Clk_updatepkg_mine", 0, 0, this.val$pkg.epId, "" + this.val$pkg.localVersion, "" + this.val$pkg.latestVersion, "");
            }
          }
          return;
          if (this.val$updateBtn.getText().toString().equals(this.this$0.mContext.getResources().getString(2131364043))) {
            DragSortAdapter.access$002(this.this$0, "update");
          }
        }
      } while (!"down".equals(DragSortAdapter.access$000(this.this$0)));
      if (!NetworkUtil.b(this.this$0.mContext))
      {
        DialogUtil.a(this.this$0.mContext, 230).setTitle(this.this$0.mContext.getString(2131362935)).setMessage(this.this$0.mContext.getString(2131364093)).setPositiveButton(this.this$0.mContext.getString(2131363272), new DragSortAdapter.2.2(this, paramView)).setNegativeButton(this.this$0.mContext.getString(2131363273), new DragSortAdapter.2.1(this)).show();
        return;
      }
    } while (!NetworkUtil.b(this.this$0.mContext));
    DragSortAdapter.access$100(this.this$0, this.val$pkg, this.val$updateLayout, this.val$progressCircle, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.view.DragSortAdapter.2
 * JD-Core Version:    0.7.0.1
 */