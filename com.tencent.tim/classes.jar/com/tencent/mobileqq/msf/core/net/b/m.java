package com.tencent.mobileqq.msf.core.net.b;

import com.tencent.qphone.base.util.QLog;

class m
  implements a.a
{
  m(k paramk) {}
  
  public void a(a parama, int paramInt1, int paramInt2, String paramString, Object paramObject)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.length() > 10) {
        str = paramString.substring(0, 10);
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("WifiDetector", 2, "WIFI detect onEchoResult, taskId: " + paramInt1 + " result: " + paramInt2 + " actualContent: " + str);
    }
    paramInt2 = k.a(this.a, paramInt2);
    k.a(this.a, paramInt2, (String)paramObject);
    k.b(this.a, k.a(this.a) - (1 << paramInt1));
    if (k.a(this.a) == 0)
    {
      parama = (String)parama.g;
      this.a.b(parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b.m
 * JD-Core Version:    0.7.0.1
 */