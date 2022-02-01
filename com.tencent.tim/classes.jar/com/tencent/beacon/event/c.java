package com.tencent.beacon.event;

import com.tencent.beacon.base.net.call.Callback;

class c
  implements Callback<byte[]>
{
  c(d paramd, EventBean paramEventBean, String paramString) {}
  
  public void a(byte[] paramArrayOfByte)
  {
    com.tencent.beacon.base.util.c.a("[EventManager]", "convert to report by beacon socket success, eventCode = %s, logId = %s", new Object[] { this.a.getEventCode(), this.b });
  }
  
  public void onFailure(com.tencent.beacon.base.net.d paramd)
  {
    com.tencent.beacon.base.util.c.e("convert to report by beacon socket also fail, failure = %s", new Object[] { paramd.toString() });
    com.tencent.beacon.a.b.d.b().a("464", paramd.toString());
    this.c.b(this.b, this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.event.c
 * JD-Core Version:    0.7.0.1
 */