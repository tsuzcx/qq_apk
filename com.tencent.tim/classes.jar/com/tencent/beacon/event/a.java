package com.tencent.beacon.event;

import com.tencent.beacon.base.util.c;

class a
  implements Runnable
{
  a(d paramd, EventBean paramEventBean) {}
  
  public void run()
  {
    if (d.a(this.b).a(this.a.getEventType()))
    {
      com.tencent.beacon.a.b.d.b().a("602", "type: " + com.tencent.beacon.event.c.d.a(this.a.getEventType()) + " max db count!");
      c.a("[EventModule]", 2, "event: %s. insert to DB false. reason: DB count max!", new Object[] { this.a.getEventCode() });
    }
    boolean bool;
    do
    {
      return;
      bool = d.a(this.b).a(this.a);
      c.a("[EventModule]", 2, "event: %s. insert to DB %s", new Object[] { this.a.getEventCode(), Boolean.valueOf(bool) });
    } while (!bool);
    this.b.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.a
 * JD-Core Version:    0.7.0.1
 */