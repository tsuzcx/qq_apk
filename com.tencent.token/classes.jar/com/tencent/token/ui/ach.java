package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.base.TitleOptionMenu;

class ach
  implements View.OnClickListener
{
  ach(UtilsGameLockActivity paramUtilsGameLockActivity) {}
  
  public void onClick(View paramView)
  {
    if (UtilsGameLockActivity.access$600(this.a).getVisibility() == 0)
    {
      UtilsGameLockActivity.access$600(this.a).b();
      return;
    }
    UtilsGameLockActivity.access$600(this.a).setOnItemClickedListener(new aci(this));
    UtilsGameLockActivity.access$600(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ach
 * JD-Core Version:    0.7.0.1
 */