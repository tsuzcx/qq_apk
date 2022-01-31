package com.tencent.token.ui;

import com.tencent.token.dm;
import com.tencent.token.global.f;
import com.tencent.token.ui.base.DualMsgShowDialog;
import com.tencent.token.utils.UserTask;

class abp
  extends UserTask
{
  abp(UtilsActivity paramUtilsActivity) {}
  
  public f a(String... paramVarArgs)
  {
    return dm.a().a(dm.f, 0L);
  }
  
  public void a()
  {
    super.a();
    UtilsActivity.access$2302(this.a, false);
  }
  
  public void a(f paramf)
  {
    UtilsActivity.access$2302(this.a, false);
    if (this.a.isFinishing()) {
      return;
    }
    this.a.dismissDialog();
    if (110 == paramf.a)
    {
      this.a.showUserDialog(9);
      return;
    }
    if (paramf.b())
    {
      if (dm.a().b() > 0)
      {
        new DualMsgShowDialog(this.a, 2131362156, 0, false, 0L).show();
        return;
      }
      this.a.showOrangeToast(2131231269, 0);
      return;
    }
    f.a(this.a.getResources(), paramf);
    this.a.showUserDialog(paramf.c);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abp
 * JD-Core Version:    0.7.0.1
 */