package com.tencent.beacon.event.c;

import com.tencent.beacon.base.net.a.c;
import com.tencent.beacon.base.net.a.c.a;
import com.tencent.beacon.event.EventBean;

public final class b
  extends c.a<EventBean, com.tencent.beacon.event.a.b>
{
  private final b a = new b();
  private final a b = new a();
  
  public static b a()
  {
    return new b();
  }
  
  public c<EventBean, com.tencent.beacon.event.a.b> b()
  {
    return this.b;
  }
  
  public c<com.tencent.beacon.event.a.b, EventBean> c()
  {
    return this.a;
  }
  
  static final class a
    implements c<EventBean, com.tencent.beacon.event.a.b>
  {
    public com.tencent.beacon.event.a.b a(EventBean paramEventBean)
    {
      com.tencent.beacon.event.a.b localb = new com.tencent.beacon.event.a.b();
      localb.b = paramEventBean.getEventTime();
      localb.d = paramEventBean.getAppKey();
      paramEventBean = com.tencent.beacon.base.util.b.a(paramEventBean);
      localb.e = paramEventBean;
      if (paramEventBean != null) {
        localb.c = paramEventBean.length;
      }
      return localb;
    }
  }
  
  static final class b
    implements c<com.tencent.beacon.event.a.b, EventBean>
  {
    public EventBean a(com.tencent.beacon.event.a.b paramb)
    {
      Object localObject = com.tencent.beacon.base.util.b.a(paramb.e);
      if (localObject == null) {
        return null;
      }
      if ((localObject instanceof EventBean))
      {
        localObject = (EventBean)localObject;
        ((EventBean)localObject).setCid(paramb.a);
        return localObject;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.c.b
 * JD-Core Version:    0.7.0.1
 */