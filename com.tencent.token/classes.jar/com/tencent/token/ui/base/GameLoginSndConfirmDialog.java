package com.tencent.token.ui.base;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.os.Handler;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.global.e;
import com.tencent.token.r;

public class GameLoginSndConfirmDialog
  extends Dialog
{
  private Activity a;
  private GameLoginSndConfirmView b;
  private boolean c = false;
  private ProDialog d;
  private Handler e = new af(this);
  
  public GameLoginSndConfirmDialog(Activity paramActivity)
  {
    super(paramActivity, 2131427401);
    this.a = paramActivity;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.b = new GameLoginSndConfirmView(this.a);
    this.b.a(new aj(this));
    if (!this.b.a(this.a))
    {
      dismiss();
      e.a("Dual initView failed!");
      return;
    }
    this.b.a(r.a(RqdApplication.i()).d());
    setContentView(this.b);
    setOnDismissListener(new an(this));
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    if ((paramBoolean) && (!this.c))
    {
      this.c = true;
      this.b.a();
    }
    super.onWindowFocusChanged(paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.GameLoginSndConfirmDialog
 * JD-Core Version:    0.7.0.1
 */