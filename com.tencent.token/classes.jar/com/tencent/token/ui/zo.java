package com.tencent.token.ui;

import android.content.Intent;
import android.os.SystemClock;
import android.view.View;
import android.view.View.OnClickListener;

final class zo
  implements View.OnClickListener
{
  zo(SettingPageActivity paramSettingPageActivity, long[] paramArrayOfLong) {}
  
  public final void onClick(View paramView)
  {
    System.arraycopy(this.a, 1, this.a, 0, this.a.length - 1);
    this.a[(this.a.length - 1)] = SystemClock.uptimeMillis();
    if (this.a[0] >= SystemClock.uptimeMillis() - 500L)
    {
      paramView = new Intent(this.b, EnvirChangeListviewActivity.class);
      this.b.startActivity(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zo
 * JD-Core Version:    0.7.0.1
 */