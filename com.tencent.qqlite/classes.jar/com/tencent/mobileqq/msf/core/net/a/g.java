package com.tencent.mobileqq.msf.core.net.a;

import com.tencent.qphone.base.util.QLog;

class g
  implements a.a
{
  g(e parame) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Object paramObject)
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
    paramInt2 = e.a(this.a, paramInt2);
    e.a(this.a, paramInt2, (String)paramObject);
    e.b(this.a, 1 << paramInt1);
    if (e.a(this.a) == 0) {
      this.a.d();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.a.g
 * JD-Core Version:    0.7.0.1
 */