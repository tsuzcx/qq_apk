package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ui.base.TitleOptionMenu;

final class adt
  implements View.OnClickListener
{
  adt(UtilsGameLockActivity paramUtilsGameLockActivity) {}
  
  public final void onClick(View paramView)
  {
    if (UtilsGameLockActivity.access$600(this.a).getVisibility() == 0)
    {
      UtilsGameLockActivity.access$600(this.a).a();
      return;
    }
    UtilsGameLockActivity.access$600(this.a).a(new adu(this));
    paramView = UtilsGameLockActivity.access$600(this.a);
    Object localObject = paramView.getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    paramView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adt
 * JD-Core Version:    0.7.0.1
 */