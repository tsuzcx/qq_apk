package com.tencent.map.location;

import android.content.Context;
import android.location.GpsSatellite;
import android.location.GpsStatus;
import android.location.GpsStatus.Listener;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import java.util.Iterator;

public final class e
{
  private static float jdField_a_of_type_Float = 0.0F;
  private static LocationManager jdField_a_of_type_AndroidLocationLocationManager = null;
  private int jdField_a_of_type_Int = 1024;
  private long jdField_a_of_type_Long = 0L;
  private Context jdField_a_of_type_AndroidContentContext = null;
  private a jdField_a_of_type_ComTencentMapLocationE$a = null;
  private b jdField_a_of_type_ComTencentMapLocationE$b = null;
  private c jdField_a_of_type_ComTencentMapLocationE$c = null;
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private int jdField_b_of_type_Int = 0;
  private boolean jdField_b_of_type_Boolean = false;
  private int c = 0;
  
  private void b()
  {
    this.c = 0;
    this.jdField_b_of_type_Int = 0;
    Object localObject = jdField_a_of_type_AndroidLocationLocationManager.getGpsStatus(null);
    if (localObject == null) {}
    for (;;)
    {
      return;
      int i = ((GpsStatus)localObject).getMaxSatellites();
      localObject = ((GpsStatus)localObject).getSatellites().iterator();
      if (localObject != null) {
        while ((((Iterator)localObject).hasNext()) && (this.jdField_b_of_type_Int <= i))
        {
          this.jdField_b_of_type_Int += 1;
          if (((GpsSatellite)((Iterator)localObject).next()).usedInFix()) {
            this.c += 1;
          }
        }
      }
    }
  }
  
  public final void a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if ((jdField_a_of_type_AndroidLocationLocationManager != null) && (this.jdField_a_of_type_ComTencentMapLocationE$a != null))
      {
        jdField_a_of_type_AndroidLocationLocationManager.removeGpsStatusListener(this.jdField_a_of_type_ComTencentMapLocationE$a);
        jdField_a_of_type_AndroidLocationLocationManager.removeUpdates(this.jdField_a_of_type_ComTencentMapLocationE$a);
      }
      this.jdField_a_of_type_Boolean = false;
      return;
    }
  }
  
  public final boolean a(c paramc, Context paramContext)
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      if ((paramContext == null) || (paramc == null)) {
        return false;
      }
      this.jdField_a_of_type_AndroidContentContext = paramContext;
      this.jdField_a_of_type_ComTencentMapLocationE$c = paramc;
      try
      {
        jdField_a_of_type_AndroidLocationLocationManager = (LocationManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("location");
        this.jdField_a_of_type_ComTencentMapLocationE$a = new a((byte)0);
        if (jdField_a_of_type_AndroidLocationLocationManager != null)
        {
          paramc = this.jdField_a_of_type_ComTencentMapLocationE$a;
          if (paramc != null) {}
        }
        else
        {
          return false;
        }
      }
      catch (Exception paramc)
      {
        return false;
      }
      try
      {
        jdField_a_of_type_AndroidLocationLocationManager.requestLocationUpdates("gps", 1000L, 0.0F, this.jdField_a_of_type_ComTencentMapLocationE$a);
        jdField_a_of_type_AndroidLocationLocationManager.addGpsStatusListener(this.jdField_a_of_type_ComTencentMapLocationE$a);
        if (jdField_a_of_type_AndroidLocationLocationManager.isProviderEnabled("gps")) {}
        for (this.jdField_a_of_type_Int = 4;; this.jdField_a_of_type_Int = 0)
        {
          this.jdField_a_of_type_Boolean = true;
          return this.jdField_a_of_type_Boolean;
        }
        paramc = finally;
      }
      catch (Exception paramc)
      {
        return false;
      }
    }
  }
  
  final class a
    implements GpsStatus.Listener, LocationListener
  {
    private a() {}
    
    public final void onGpsStatusChanged(int paramInt)
    {
      switch (paramInt)
      {
      }
      for (;;)
      {
        e.a(e.this);
        return;
        e.a(e.this, 1);
        continue;
        e.a(e.this, 0);
        continue;
        e.a(e.this, 2);
      }
    }
    
    public final void onLocationChanged(Location paramLocation)
    {
      int j = 0;
      double d1;
      double d2;
      int i;
      if (paramLocation != null)
      {
        d1 = paramLocation.getLatitude();
        d2 = paramLocation.getLongitude();
        i = j;
        if (d1 != 29.999998211860657D)
        {
          if (d2 != 103.99999916553497D) {
            break label49;
          }
          i = j;
        }
        if (i != 0) {
          break label136;
        }
      }
      label49:
      do
      {
        return;
        i = j;
        if (Math.abs(d1) < 1.0E-008D) {
          break;
        }
        i = j;
        if (Math.abs(d2) < 1.0E-008D) {
          break;
        }
        i = j;
        if (d1 < -90.0D) {
          break;
        }
        i = j;
        if (d1 > 90.0D) {
          break;
        }
        i = j;
        if (d2 < -180.0D) {
          break;
        }
        i = j;
        if (d2 > 180.0D) {
          break;
        }
        i = 1;
        break;
        e.a(e.this, System.currentTimeMillis());
        e.a(e.this);
        e.a(e.this, 2);
        e.a(e.this, new e.b(e.this, paramLocation, e.a(e.this), e.b(e.this), e.c(e.this), e.a(e.this)));
      } while (e.a(e.this) == null);
      label136:
      e.a(e.this).a(e.a(e.this));
    }
    
    public final void onProviderDisabled(String paramString)
    {
      if (paramString != null) {}
      try
      {
        boolean bool = paramString.equals("gps");
        if (!bool) {}
        do
        {
          return;
          e.b(e.this, e.c(e.this, 0));
          e.d(e.this, 0);
        } while (e.a(e.this) == null);
        e.a(e.this).a(e.c(e.this));
        return;
      }
      catch (Exception paramString) {}
    }
    
    public final void onProviderEnabled(String paramString)
    {
      if (paramString != null) {}
      try
      {
        boolean bool = paramString.equals("gps");
        if (!bool) {}
        do
        {
          return;
          e.d(e.this, 4);
        } while (e.a(e.this) == null);
        e.a(e.this).a(e.c(e.this));
        return;
      }
      catch (Exception paramString) {}
    }
    
    public final void onStatusChanged(String paramString, int paramInt, Bundle paramBundle) {}
  }
  
  public final class b
    implements Cloneable
  {
    private int jdField_a_of_type_Int = 0;
    private long jdField_a_of_type_Long = 0L;
    private Location jdField_a_of_type_AndroidLocationLocation = null;
    
    public b(Location paramLocation, int paramInt1, int paramInt2, int paramInt3, long paramLong)
    {
      if (paramLocation != null)
      {
        this.jdField_a_of_type_AndroidLocationLocation = new Location(paramLocation);
        this.jdField_a_of_type_Int = paramInt2;
        this.jdField_a_of_type_Long = paramLong;
      }
    }
    
    public final Location a()
    {
      return this.jdField_a_of_type_AndroidLocationLocation;
    }
    
    public final boolean a()
    {
      if (this.jdField_a_of_type_AndroidLocationLocation == null) {}
      while (((this.jdField_a_of_type_Int > 0) && (this.jdField_a_of_type_Int < 3)) || (System.currentTimeMillis() - this.jdField_a_of_type_Long > 30000L)) {
        return false;
      }
      return true;
    }
    
    public final Object clone()
    {
      try
      {
        b localb = (b)super.clone();
        if (this.jdField_a_of_type_AndroidLocationLocation != null) {
          localb.jdField_a_of_type_AndroidLocationLocation = new Location(this.jdField_a_of_type_AndroidLocationLocation);
        }
        return localb;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Object localObject = null;
        }
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(int paramInt);
    
    public abstract void a(e.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.map.location.e
 * JD-Core Version:    0.7.0.1
 */