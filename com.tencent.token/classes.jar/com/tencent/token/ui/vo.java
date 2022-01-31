package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class vo
  implements View.OnClickListener
{
  vo(RealNameGuidActivity paramRealNameGuidActivity) {}
  
  public final void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    case 2131296989: 
    case 2131296990: 
    case 2131296991: 
    default: 
      return;
    case 2131296992: 
      paramView = new Intent(this.a, FacePwdIndexActivity.class);
      this.a.startActivity(paramView);
      return;
    case 2131296986: 
      paramView = new Intent(this.a, RealNameDetailActivity.class);
      paramView.putExtra("index", 0);
      this.a.startActivity(paramView);
      return;
    case 2131296987: 
      paramView = new Intent(this.a, RealNameDetailActivity.class);
      paramView.putExtra("index", 2);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, RealNameDetailActivity.class);
    paramView.putExtra("index", 1);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vo
 * JD-Core Version:    0.7.0.1
 */