package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.utils.UserTask;
import com.tencent.token.utils.UserTask.Status;

class abq
  implements View.OnClickListener
{
  abq(UtilsActivity paramUtilsActivity) {}
  
  public void onClick(View paramView)
  {
    if ((UtilsActivity.access$2400(this.a) != null) && (UtilsActivity.access$2400(this.a).b() != UserTask.Status.FINISHED)) {
      UtilsActivity.access$2400(this.a).a(true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abq
 * JD-Core Version:    0.7.0.1
 */