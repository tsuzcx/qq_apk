package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.JLProtectionInfo;

final class nq
  implements View.OnClickListener
{
  nq(JianLingActivity paramJianLingActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, JLFindItems.class);
    paramView.putExtra("is_xy", this.a.mInfo.is_xy);
    paramView.putExtra("detail_max", this.a.mInfo.detail_max);
    paramView.putExtra("detail_min", this.a.mInfo.detail_min);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.nq
 * JD-Core Version:    0.7.0.1
 */