package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.TitleOptionMenu;

final class eb
  implements View.OnClickListener
{
  eb(FacePKActivity paramFacePKActivity) {}
  
  public final void onClick(View paramView)
  {
    e.a("FacePKActivityOnclick");
    if (this.a.mTitleMenu.getVisibility() == 0)
    {
      this.a.mTitleMenu.a();
      return;
    }
    this.a.mTitleMenu.a(new ec(this));
    paramView = this.a.mTitleMenu;
    Object localObject = paramView.getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    paramView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.eb
 * JD-Core Version:    0.7.0.1
 */