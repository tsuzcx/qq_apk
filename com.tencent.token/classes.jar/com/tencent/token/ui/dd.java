package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;
import com.tencent.token.ui.base.TitleOptionMenu;

final class dd
  implements View.OnClickListener
{
  dd(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public final void onClick(View paramView)
  {
    e.a("BaseActivityonItemClicked");
    if (this.a.mTitleMenu.getVisibility() == 0)
    {
      this.a.mTitleMenu.a();
      return;
    }
    this.a.mTitleMenu.a(new de(this));
    paramView = this.a.mTitleMenu;
    Object localObject = paramView.getTag();
    if (localObject != null) {
      ((View)localObject).setSelected(true);
    }
    paramView.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dd
 * JD-Core Version:    0.7.0.1
 */