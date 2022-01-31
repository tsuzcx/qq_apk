package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.base.TitleOptionMenu;

final class adf
  implements View.OnClickListener
{
  adf(UtilsActivity paramUtilsActivity) {}
  
  public final void onClick(View paramView)
  {
    if (UtilsActivity.access$100(this.a).getVisibility() == 0)
    {
      UtilsActivity.access$100(this.a).a();
      return;
    }
    UtilsActivity.access$100(this.a).a(new adg(this));
    paramView = UtilsActivity.access$100(this.a);
    Object localObject = paramView.getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    paramView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adf
 * JD-Core Version:    0.7.0.1
 */