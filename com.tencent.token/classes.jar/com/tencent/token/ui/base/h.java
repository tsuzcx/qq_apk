package com.tencent.token.ui.base;

import com.tencent.token.core.bean.a;
import com.tencent.token.dk;
import com.tencent.token.dm;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

class h
  extends UserTask
{
  h(DualMsgShowDialog paramDualMsgShowDialog, a parama, int paramInt) {}
  
  public f a(String... paramVarArgs)
  {
    if (DualMsgShowDialog.d(this.c) == 0) {
      return dm.a().a(this.a, this.b);
    }
    return dk.a().a(this.a, this.b);
  }
  
  public void a(f paramf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.base.h
 * JD-Core Version:    0.7.0.1
 */