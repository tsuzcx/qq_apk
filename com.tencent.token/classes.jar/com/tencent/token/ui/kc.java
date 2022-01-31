package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import android.widget.TextView;
import com.tencent.token.core.bean.h;
import com.tencent.token.dr;
import com.tencent.token.global.f;
import com.tencent.token.utils.UserTask;

class kc
  extends UserTask
{
  private h c = null;
  
  kc(kb paramkb, kf paramkf) {}
  
  private void b(f paramf)
  {
    if (this.c == null) {
      return;
    }
    f.a(kb.b(this.b).getResources(), paramf);
    kb.b(this.b).showTipDialog(2131231390, paramf.c);
  }
  
  public f a(h... paramVarArgs)
  {
    if ((this.a == null) || (this.a.a() == null)) {
      return null;
    }
    this.c = this.a.a();
    paramVarArgs = dr.a();
    h localh = this.c;
    if (!this.c.c) {}
    for (boolean bool = true;; bool = false) {
      return paramVarArgs.a(localh, bool);
    }
  }
  
  public void a()
  {
    if (this.c == null) {}
    do
    {
      return;
      this.c.e = false;
      localObject = new f();
      ((f)localObject).b(10024);
      b((f)localObject);
    } while (kb.a(this.b) == null);
    Object localObject = kb.a(this.b).obtainMessage(3017);
    kb.a(this.b).sendMessage((Message)localObject);
  }
  
  public void a(f paramf)
  {
    if ((this.c == null) || (paramf == null)) {
      return;
    }
    this.c.e = false;
    if (paramf.b()) {}
    while ((this.a != null) && (this.a.c() != null) && (this.c.b.equals(this.a.c().getText())))
    {
      this.b.a(this.a, true);
      return;
      b(paramf);
    }
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.kc
 * JD-Core Version:    0.7.0.1
 */