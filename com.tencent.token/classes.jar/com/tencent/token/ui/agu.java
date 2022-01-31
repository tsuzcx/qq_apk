package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

final class agu
  implements View.OnClickListener
{
  agu(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public final void onClick(View paramView)
  {
    if (VryMobileForStrategyActivity.access$700(this.a)) {
      return;
    }
    VryMobileForStrategyActivity.access$800(this.a);
    paramView = ((EditText)this.a.findViewById(2131296886)).getText().toString();
    if ((paramView != null) && (paramView.length() > 0))
    {
      VryMobileForStrategyActivity.access$900(this.a);
      VryMobileForStrategyActivity.access$1000(this.a, paramView);
      this.a.showProDialog(this.a, 2131361808, 2131361817, null);
      return;
    }
    this.a.showToast(2131361948);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agu
 * JD-Core Version:    0.7.0.1
 */