package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;

final class ade
  implements View.OnClickListener
{
  ade(UtilsActivity paramUtilsActivity) {}
  
  public final void onClick(View paramView)
  {
    if ((UtilsActivity.access$1400(this.a) != null) && (UtilsActivity.access$1400(this.a).c() != UserTask.Status.FINISHED)) {
      UtilsActivity.access$1400(this.a).d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ade
 * JD-Core Version:    0.7.0.1
 */