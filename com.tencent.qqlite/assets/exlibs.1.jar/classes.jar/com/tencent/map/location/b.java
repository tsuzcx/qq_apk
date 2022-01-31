package com.tencent.map.location;

import android.location.Location;
import com.tencent.mapsdk.net.HttpUtil;
import com.tencent.mapsdk.net.NetResponse;

public final class b
{
  private static b jdField_a_of_type_ComTencentMapLocationB;
  private double jdField_a_of_type_Double = 0.0D;
  private a jdField_a_of_type_ComTencentMapLocationB$a;
  private b jdField_a_of_type_ComTencentMapLocationB$b = null;
  public String a;
  private boolean jdField_a_of_type_Boolean = false;
  private double b = 0.0D;
  private double c = 0.0D;
  private double d = 0.0D;
  private double e = 0.0D;
  private double f = 0.0D;
  
  public b()
  {
    this.jdField_a_of_type_JavaLangString = "";
  }
  
  public static b a()
  {
    if (jdField_a_of_type_ComTencentMapLocationB == null) {
      jdField_a_of_type_ComTencentMapLocationB = new b();
    }
    return jdField_a_of_type_ComTencentMapLocationB;
  }
  
  public final void a(double paramDouble1, double paramDouble2, a parama)
  {
    this.jdField_a_of_type_ComTencentMapLocationB$a = parama;
    if ((this.e != 0.0D) && (this.f != 0.0D))
    {
      parama = new float[10];
      Location.distanceBetween(paramDouble1, paramDouble2, this.jdField_a_of_type_Double, this.b, parama);
      if (parama[0] < 1500.0F) {
        this.jdField_a_of_type_ComTencentMapLocationB$a.a(this.e + paramDouble1, this.f + paramDouble2);
      }
    }
    while (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_JavaLangString = ("{\"source\":101,\"access_token\":\"160e7bd42dec9428721034e0146fc6dd\",\"location\":{\"latitude\":" + paramDouble1 + ",\"longitude\":" + paramDouble2 + "}\t}");
    this.c = paramDouble1;
    this.d = paramDouble2;
    this.jdField_a_of_type_ComTencentMapLocationB$b = new b();
    this.jdField_a_of_type_ComTencentMapLocationB$b.start();
  }
  
  public static abstract interface a
  {
    public abstract void a(double paramDouble1, double paramDouble2);
  }
  
  public final class b
    extends Thread
  {
    public b() {}
    
    public final void run()
    {
      try
      {
        Object localObject = j.a(b.this.a.getBytes());
        b.a(b.this, true);
        localObject = HttpUtil.sendSyncPostRequest("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", (byte[])localObject);
        b.a(b.this, false);
        arrayOfByte = j.b(((NetResponse)localObject).data);
        b.a(b.this, arrayOfByte, ((NetResponse)localObject).charset);
        return;
      }
      catch (Exception localException1)
      {
        do
        {
          byte[] arrayOfByte;
          int i = 0;
          for (;;)
          {
            i += 1;
            if (i > 3) {
              break;
            }
            try
            {
              sleep(2000L);
              NetResponse localNetResponse = HttpUtil.sendSyncPostRequest("http://ls.map.soso.com/deflect?c=1", "SOSO MAP LBS SDK", j.a(b.this.a.getBytes()));
              b.a(b.this, false);
              arrayOfByte = j.b(localNetResponse.data);
              b.a(b.this, arrayOfByte, localNetResponse.charset);
              return;
            }
            catch (Exception localException2) {}
          }
          b.a(b.this, false);
        } while (b.a(b.this) == null);
        b.a(b.this).a(360.0D, 360.0D);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.map.location.b
 * JD-Core Version:    0.7.0.1
 */