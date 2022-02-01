package com.tencent.mobileqq.msf.core.net;

import com.tencent.mobileqq.msf.core.quicksend.f;
import com.tencent.qphone.base.remote.ToServiceMsg;

public abstract interface b
{
  public abstract void a(int paramInt);
  
  public abstract void a(Object paramObject);
  
  public abstract boolean a();
  
  public abstract boolean a(String paramString1, int paramInt, String paramString2, f paramf);
  
  public abstract byte[] a(ToServiceMsg paramToServiceMsg, byte[] paramArrayOfByte, String paramString, f paramf);
  
  public abstract boolean b();
  
  public abstract void c();
  
  public abstract void d();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.msf.core.net.b
 * JD-Core Version:    0.7.0.1
 */