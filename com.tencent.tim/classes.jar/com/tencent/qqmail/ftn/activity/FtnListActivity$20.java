package com.tencent.qqmail.ftn.activity;

import android.content.Intent;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.EditText;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.utilities.ui.QMSearchBar;

class FtnListActivity$20
  implements View.OnTouchListener
{
  FtnListActivity$20(FtnListActivity paramFtnListActivity) {}
  
  public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 1)
    {
      if (FtnListActivity.access$4000(this.this$0).searchInput != null)
      {
        FtnListActivity.access$4000(this.this$0).searchInput.setFocusable(false);
        FtnListActivity.access$4000(this.this$0).searchInput.setFocusableInTouchMode(false);
        FtnListActivity.access$4000(this.this$0).searchInput.clearFocus();
      }
      if (!FtnListActivity.access$4100(this.this$0))
      {
        paramView = new Intent(this.this$0.getActivity(), FtnSearchListActivity.class);
        paramView.putExtra("keyword", "");
        paramView.setFlags(65536);
        paramView.putExtra("extra_uin", FtnListActivity.access$4200(this.this$0).getUin());
        paramView.putExtra("accountid", FtnListActivity.access$4200(this.this$0).getId());
        this.this$0.startActivityForResult(paramView, 8);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.activity.FtnListActivity.20
 * JD-Core Version:    0.7.0.1
 */