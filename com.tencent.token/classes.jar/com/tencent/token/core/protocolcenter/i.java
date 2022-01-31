package com.tencent.token.core.protocolcenter;

import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.token.ev;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

class i
  extends HandlerThread
{
  private Handler b = new Handler();
  private Map c = Collections.synchronizedMap(new HashMap());
  
  public i(f paramf, String paramString)
  {
    super(paramString);
  }
  
  public void a(ev paramev)
  {
    paramev.l.a(paramev);
    this.b.post(new j(this, paramev));
    this.b.postDelayed(new k(this, paramev), paramev.h);
  }
  
  public void a(String paramString)
  {
    this.b.post(new l(this, paramString));
  }
  
  public void b(ev paramev)
  {
    this.b.post(new m(this, paramev));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.core.protocolcenter.i
 * JD-Core Version:    0.7.0.1
 */