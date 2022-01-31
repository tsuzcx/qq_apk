package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;
import com.tencent.token.ui.base.TitleOptionMenu;

class dz
  implements View.OnClickListener
{
  dz(EmbedWebBaseActivity paramEmbedWebBaseActivity) {}
  
  public void onClick(View paramView)
  {
    h.a("BaseActivityonItemClicked");
    if (this.a.mTitleMenu.getVisibility() == 0)
    {
      this.a.mTitleMenu.b();
      return;
    }
    this.a.mTitleMenu.setOnItemClickedListener(new ea(this));
    this.a.mTitleMenu.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dz
 * JD-Core Version:    0.7.0.1
 */