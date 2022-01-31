package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import com.tencent.token.core.bean.g;
import com.tencent.token.global.d;
import com.tencent.token.utils.UserTask;

final class ky
  extends UserTask
{
  private g c = null;
  
  ky(kx paramkx, lb paramlb) {}
  
  private void a(d paramd)
  {
    if (this.c == null) {
      return;
    }
    d.a(kx.b(this.b).getResources(), paramd);
    kx.b(this.b).showTipDialog(2131361919, paramd.c);
  }
  
  public final void a()
  {
    if (this.c == null) {}
    do
    {
      return;
      this.c.e = false;
      localObject = new d((byte)0);
      ((d)localObject).a(10024, null, null);
      a((d)localObject);
    } while (kx.a(this.b) == null);
    Object localObject = kx.a(this.b).obtainMessage(3017);
    kx.a(this.b).sendMessage((Message)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ky
 * JD-Core Version:    0.7.0.1
 */