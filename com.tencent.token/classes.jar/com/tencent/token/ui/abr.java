package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.base.TitleOptionMenu;

class abr
  implements View.OnClickListener
{
  abr(UtilsActivity paramUtilsActivity) {}
  
  public void onClick(View paramView)
  {
    if (UtilsActivity.access$300(this.a).getVisibility() == 0)
    {
      UtilsActivity.access$300(this.a).b();
      return;
    }
    UtilsActivity.access$300(this.a).setOnItemClickedListener(new abs(this));
    UtilsActivity.access$300(this.a).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abr
 * JD-Core Version:    0.7.0.1
 */