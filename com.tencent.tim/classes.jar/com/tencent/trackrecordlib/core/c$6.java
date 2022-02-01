package com.tencent.trackrecordlib.core;

import com.tencent.trackrecordlib.b.a;
import com.tencent.trackrecordlib.b.f;
import com.tencent.trackrecordlib.c.d.a;
import com.tencent.trackrecordlib.enums.UiAction;
import com.tencent.trackrecordlib.enums.UiActionKey;

class c$6
  implements Runnable
{
  c$6(c paramc) {}
  
  public void run()
  {
    Object localObject = f.a(UiActionKey.HOME);
    localObject = new d.a().a(UiAction.KEY).a((a)localObject).h(com.tencent.trackrecordlib.g.b.b()).g(com.tencent.trackrecordlib.g.b.c()).a();
    RecordManager.getInstance().recordEvent((com.tencent.trackrecordlib.c.b)localObject);
    c.a(this.a, (com.tencent.trackrecordlib.c.b)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.core.c.6
 * JD-Core Version:    0.7.0.1
 */