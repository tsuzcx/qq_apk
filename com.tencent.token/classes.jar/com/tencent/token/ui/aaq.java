package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class aaq
  implements View.OnClickListener
{
  aaq(StartPwdUpdateInfoActivity paramStartPwdUpdateInfoActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, StartPwdGestureModifyActivity.class);
    if (StartPwdUpdateInfoActivity.access$000(this.a) == StartPwdUpdateInfoActivity.SOURCE_FROM_PSW_MANAGER) {
      paramView.putExtra(StartPwdUpdateInfoActivity.SOURCE_TO_START_PSW, StartPwdUpdateInfoActivity.SOURCE_FROM_PSW_MANAGER);
    }
    this.a.startActivityForResult(paramView, 258);
    if (StartPwdUpdateInfoActivity.access$000(this.a) == StartPwdUpdateInfoActivity.SOURCE_FROM_PSW_MANAGER) {
      this.a.finish();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aaq
 * JD-Core Version:    0.7.0.1
 */