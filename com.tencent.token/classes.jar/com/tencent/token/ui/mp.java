package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.ax;
import com.tencent.token.ui.base.SlidingMenuView;

final class mp
  implements DialogInterface.OnClickListener
{
  mp(mo parammo) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    IndexActivity.access$1400(this.a.a, this.a.a.curruser);
    ax.a().n();
    this.a.a.slidingMenuView.a(1);
    paramDialogInterface = new Intent(this.a.a, IndexActivity.class);
    paramDialogInterface.putExtra("index_from", 16);
    this.a.a.startActivity(paramDialogInterface);
    this.a.a.remsumeMenu();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.mp
 * JD-Core Version:    0.7.0.1
 */