package org.pjsip.pjsua;

public class PjsuaAppCallback
{
  protected boolean swigCMemOwn;
  private long swigCPtr;
  
  public PjsuaAppCallback()
  {
    this(pjsuaJNI.new_PjsuaAppCallback(), true);
    pjsuaJNI.PjsuaAppCallback_director_connect(this, this.swigCPtr, this.swigCMemOwn, true);
  }
  
  protected PjsuaAppCallback(long paramLong, boolean paramBoolean)
  {
    this.swigCMemOwn = paramBoolean;
    this.swigCPtr = paramLong;
  }
  
  protected static long getCPtr(PjsuaAppCallback paramPjsuaAppCallback)
  {
    if (paramPjsuaAppCallback == null) {
      return 0L;
    }
    return paramPjsuaAppCallback.swigCPtr;
  }
  
  public void delete()
  {
    try
    {
      if (this.swigCPtr != 0L)
      {
        if (this.swigCMemOwn)
        {
          this.swigCMemOwn = false;
          pjsuaJNI.delete_PjsuaAppCallback(this.swigCPtr);
        }
        this.swigCPtr = 0L;
      }
      return;
    }
    finally {}
  }
  
  protected void finalize()
  {
    delete();
  }
  
  public void onCallState(int paramInt1, int paramInt2)
  {
    if (getClass() == PjsuaAppCallback.class)
    {
      pjsuaJNI.PjsuaAppCallback_onCallState(this.swigCPtr, this, paramInt1, paramInt2);
      return;
    }
    pjsuaJNI.PjsuaAppCallback_onCallStateSwigExplicitPjsuaAppCallback(this.swigCPtr, this, paramInt1, paramInt2);
  }
  
  public void onRegState(int paramInt1, int paramInt2, int paramInt3)
  {
    if (getClass() == PjsuaAppCallback.class)
    {
      pjsuaJNI.PjsuaAppCallback_onRegState(this.swigCPtr, this, paramInt1, paramInt2, paramInt3);
      return;
    }
    pjsuaJNI.PjsuaAppCallback_onRegStateSwigExplicitPjsuaAppCallback(this.swigCPtr, this, paramInt1, paramInt2, paramInt3);
  }
  
  public void onRequestLog(String paramString)
  {
    if (getClass() == PjsuaAppCallback.class)
    {
      pjsuaJNI.PjsuaAppCallback_onRequestLog(this.swigCPtr, this, paramString);
      return;
    }
    pjsuaJNI.PjsuaAppCallback_onRequestLogSwigExplicitPjsuaAppCallback(this.swigCPtr, this, paramString);
  }
  
  protected void swigDirectorDisconnect()
  {
    this.swigCMemOwn = false;
    delete();
  }
  
  public void swigReleaseOwnership()
  {
    this.swigCMemOwn = false;
    pjsuaJNI.PjsuaAppCallback_change_ownership(this, this.swigCPtr, false);
  }
  
  public void swigTakeOwnership()
  {
    this.swigCMemOwn = true;
    pjsuaJNI.PjsuaAppCallback_change_ownership(this, this.swigCPtr, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     org.pjsip.pjsua.PjsuaAppCallback
 * JD-Core Version:    0.7.0.1
 */