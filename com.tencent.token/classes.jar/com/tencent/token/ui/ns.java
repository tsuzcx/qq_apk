package com.tencent.token.ui;

import android.os.Handler;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.token.af;
import com.tencent.token.bf;
import com.tencent.token.core.bean.JLProtectionInfo.ProtectionInfoItem;

final class ns
  implements CompoundButton.OnCheckedChangeListener
{
  private JLProtectionInfo.ProtectionInfoItem b;
  private View c;
  private int d;
  
  public ns(JianLingActivity paramJianLingActivity, int paramInt, JLProtectionInfo.ProtectionInfoItem paramProtectionInfoItem, View paramView)
  {
    this.b = paramProtectionInfoItem;
    this.c = paramView;
    this.d = paramInt;
  }
  
  public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool = false;
    int i = 1;
    if (this.b.type == 2)
    {
      if (this.b.value == 1) {
        bool = true;
      }
      if ((paramBoolean == bool) && (!this.b.busy) && (!this.a.m2VerifyQuerying)) {}
    }
    for (;;)
    {
      return;
      this.a.m2VerifyItem = this.b;
      this.a.m2VerifyQuerying = true;
      this.b.busy = true;
      this.a.initListItem(this.c, this.d);
      bf.a().a(3, this.a.mHandler);
      return;
      if (this.b.value == 1) {}
      for (bool = true; (paramBoolean == bool) && (!this.b.busy); bool = false)
      {
        this.b.busy = true;
        this.a.initListItem(this.c, this.d);
        int j = this.b.id;
        if (this.b.value == 1) {
          i = 0;
        }
        paramCompoundButton = af.a();
        Handler localHandler = this.a.mHandler;
        paramCompoundButton.a(0L, new int[] { j }, new int[] { i }, "", localHandler);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ns
 * JD-Core Version:    0.7.0.1
 */