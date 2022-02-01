package com.huawei.updatesdk.a.b.d.a;

public class d
  extends b
{
  public static final int ERROR = 1;
  public static final int NETWORK_ERROR = 3;
  public static final int OK = 0;
  public static final int PROGUARD_ERROR = 6;
  public static final int REQ_PARAM_ERROR = 5;
  public static final int RTN_CODE_OK = 0;
  public static final int TIMEOUT = 2;
  private a errCause = a.a;
  private int httpRespondeCode = 0;
  private String reason;
  private int responseCode = 1;
  private int rtnCode_ = 0;
  
  public int a()
  {
    return this.responseCode;
  }
  
  public void a(int paramInt)
  {
    this.responseCode = paramInt;
  }
  
  public void a(a parama)
  {
    this.errCause = parama;
  }
  
  public void a(String paramString)
  {
    this.reason = paramString;
  }
  
  public int b()
  {
    return this.httpRespondeCode;
  }
  
  public void b(int paramInt)
  {
    this.httpRespondeCode = paramInt;
  }
  
  public int c()
  {
    return this.rtnCode_;
  }
  
  public a d()
  {
    return this.errCause;
  }
  
  public String e()
  {
    return this.reason;
  }
  
  public String toString()
  {
    return getClass().getName() + " { \n\tresponseCode: " + a() + "\n\trtnCode_: " + c() + "\n\terrCause: " + d() + "\n}";
  }
  
  public static enum a
  {
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.b.d.a.d
 * JD-Core Version:    0.7.0.1
 */