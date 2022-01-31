package com.tencent.token;

import android.os.Handler;
import android.os.HandlerThread;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

final class bq
  extends HandlerThread
{
  private Handler b = new Handler();
  private Map c = Collections.synchronizedMap(new HashMap());
  
  public bq(bn parambn, String paramString)
  {
    super(paramString);
  }
  
  public final void a(fs paramfs)
  {
    this.b.post(new br(this, paramfs));
    this.b.postDelayed(new bs(this, paramfs), paramfs.h);
  }
  
  public final void a(String paramString)
  {
    this.b.post(new bt(this, paramString));
  }
  
  public final void b(fs paramfs)
  {
    this.b.post(new bu(this, paramfs));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.bq
 * JD-Core Version:    0.7.0.1
 */