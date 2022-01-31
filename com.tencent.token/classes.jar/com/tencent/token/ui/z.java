package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;

final class z
  implements View.OnClickListener
{
  z(AccountPageActivity paramAccountPageActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = (Integer)paramView.getTag();
    if (paramView == null) {}
    while ((paramView.intValue() != 3004) && (paramView.intValue() != 3003)) {
      return;
    }
    AccountPageActivity.access$100(this.a, null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.z
 * JD-Core Version:    0.7.0.1
 */