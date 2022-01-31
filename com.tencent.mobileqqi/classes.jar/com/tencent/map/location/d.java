package com.tencent.map.location;

import android.content.Context;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.PhoneStateListener;
import android.telephony.TelephonyManager;
import android.telephony.gsm.GsmCellLocation;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

public final class d
{
  private Context jdField_a_of_type_AndroidContentContext = null;
  private TelephonyManager jdField_a_of_type_AndroidTelephonyTelephonyManager = null;
  private a jdField_a_of_type_ComTencentMapLocationD$a = null;
  private b jdField_a_of_type_ComTencentMapLocationD$b = null;
  private c jdField_a_of_type_ComTencentMapLocationD$c = null;
  private List<NeighboringCellInfo> jdField_a_of_type_JavaUtilList = new LinkedList();
  private boolean jdField_a_of_type_Boolean = false;
  private byte[] jdField_a_of_type_ArrayOfByte = new byte[0];
  private boolean jdField_b_of_type_Boolean = false;
  private byte[] jdField_b_of_type_ArrayOfByte = new byte[0];
  
  private int a(int paramInt)
  {
    String str = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getNetworkOperator();
    if ((str != null) && (str.length() >= 3)) {}
    int i;
    for (;;)
    {
      try
      {
        i = Integer.valueOf(str.substring(0, 3)).intValue();
        if ((paramInt != 2) || (i != -1)) {
          break;
        }
        return 0;
      }
      catch (Exception localException) {}
      i = -1;
    }
    return i;
  }
  
  public final List<NeighboringCellInfo> a()
  {
    LinkedList localLinkedList = null;
    synchronized (this.jdField_b_of_type_ArrayOfByte)
    {
      if (this.jdField_a_of_type_JavaUtilList != null)
      {
        localLinkedList = new LinkedList();
        localLinkedList.addAll(this.jdField_a_of_type_JavaUtilList);
      }
      return localLinkedList;
    }
  }
  
  public final void a()
  {
    synchronized (this.jdField_a_of_type_ArrayOfByte)
    {
      if (!this.jdField_a_of_type_Boolean) {
        return;
      }
      if (this.jdField_a_of_type_AndroidTelephonyTelephonyManager != null)
      {
        a locala = this.jdField_a_of_type_ComTencentMapLocationD$a;
        if (locala == null) {}
      }
    }
    try
    {
      this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_ComTencentMapLocationD$a, 0);
      this.jdField_a_of_type_Boolean = false;
      return;
      localObject = finally;
      throw localObject;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.jdField_a_of_type_Boolean = false;
      }
    }
  }
  
  public final boolean a(Context paramContext, c paramc)
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
      this.jdField_a_of_type_ComTencentMapLocationD$c = paramc;
      try
      {
        this.jdField_a_of_type_AndroidTelephonyTelephonyManager = ((TelephonyManager)this.jdField_a_of_type_AndroidContentContext.getSystemService("phone"));
        paramContext = this.jdField_a_of_type_AndroidTelephonyTelephonyManager;
        if (paramContext == null) {
          return false;
        }
        int i = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getPhoneType();
        this.jdField_a_of_type_ComTencentMapLocationD$a = new a(a(i), i);
        paramContext = this.jdField_a_of_type_ComTencentMapLocationD$a;
        if (paramContext == null) {
          return false;
        }
        paramContext = this.jdField_a_of_type_AndroidTelephonyTelephonyManager.getCellLocation();
        if (paramContext != null) {
          this.jdField_a_of_type_ComTencentMapLocationD$a.onCellLocationChanged(paramContext);
        }
        this.jdField_a_of_type_AndroidTelephonyTelephonyManager.listen(this.jdField_a_of_type_ComTencentMapLocationD$a, 18);
        this.jdField_a_of_type_Boolean = true;
        return this.jdField_a_of_type_Boolean;
      }
      catch (Exception paramContext)
      {
        return false;
      }
    }
  }
  
  public final class a
    extends PhoneStateListener
  {
    private int jdField_a_of_type_Int = 0;
    private Method jdField_a_of_type_JavaLangReflectMethod = null;
    private int jdField_b_of_type_Int = 0;
    private Method jdField_b_of_type_JavaLangReflectMethod = null;
    private int jdField_c_of_type_Int = 0;
    private Method jdField_c_of_type_JavaLangReflectMethod = null;
    private int jdField_d_of_type_Int = 0;
    private Method jdField_d_of_type_JavaLangReflectMethod = null;
    private int jdField_e_of_type_Int = 0;
    private Method jdField_e_of_type_JavaLangReflectMethod = null;
    private int f = -1;
    private int g = 2147483647;
    private int h = 2147483647;
    
    public a(int paramInt1, int paramInt2)
    {
      this.jdField_b_of_type_Int = paramInt1;
      this.jdField_a_of_type_Int = paramInt2;
    }
    
    public final void onCellLocationChanged(CellLocation paramCellLocation)
    {
      this.f = -1;
      this.jdField_e_of_type_Int = -1;
      this.jdField_d_of_type_Int = -1;
      this.jdField_c_of_type_Int = -1;
      if (paramCellLocation != null) {
        switch (this.jdField_a_of_type_Int)
        {
        }
      }
      for (;;)
      {
        d.a(d.this, new d.b(d.this, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.f, this.g, this.h));
        if (d.a(d.this) != null) {
          d.a(d.this).a(d.a(d.this));
        }
        return;
        for (;;)
        {
          try
          {
            localObject = (GsmCellLocation)paramCellLocation;
            paramCellLocation = (CellLocation)localObject;
          }
          catch (Exception paramCellLocation)
          {
            label234:
            paramCellLocation = null;
          }
          for (;;)
          {
            try
            {
              if (((GsmCellLocation)localObject).getLac() <= 0)
              {
                paramCellLocation = (CellLocation)localObject;
                if (((GsmCellLocation)localObject).getCid() <= 0) {
                  paramCellLocation = (GsmCellLocation)d.a(d.this).getCellLocation();
                }
              }
              i = 1;
              if ((i == 0) || (paramCellLocation == null)) {
                break;
              }
              localObject = d.a(d.this).getNetworkOperator();
              if (localObject == null) {}
            }
            catch (Exception paramCellLocation)
            {
              paramCellLocation = (CellLocation)localObject;
              continue;
            }
            try
            {
              if (((String)localObject).length() > 3) {
                this.jdField_c_of_type_Int = Integer.valueOf(((String)localObject).substring(3)).intValue();
              }
              this.jdField_d_of_type_Int = paramCellLocation.getLac();
              this.jdField_e_of_type_Int = paramCellLocation.getCid();
            }
            catch (Exception paramCellLocation)
            {
              this.jdField_e_of_type_Int = -1;
              this.jdField_d_of_type_Int = -1;
              this.jdField_c_of_type_Int = -1;
              break label234;
            }
          }
          d.a(d.this);
          break;
          int i = 0;
        }
        if (paramCellLocation != null) {
          try
          {
            if (this.jdField_a_of_type_JavaLangReflectMethod == null)
            {
              this.jdField_a_of_type_JavaLangReflectMethod = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationId", new Class[0]);
              this.jdField_b_of_type_JavaLangReflectMethod = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getSystemId", new Class[0]);
              this.jdField_c_of_type_JavaLangReflectMethod = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getNetworkId", new Class[0]);
              this.jdField_d_of_type_JavaLangReflectMethod = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationLatitude", new Class[0]);
              this.jdField_e_of_type_JavaLangReflectMethod = Class.forName("android.telephony.cdma.CdmaCellLocation").getMethod("getBaseStationLongitude", new Class[0]);
            }
            this.jdField_c_of_type_Int = ((Integer)this.jdField_b_of_type_JavaLangReflectMethod.invoke(paramCellLocation, new Object[0])).intValue();
            this.jdField_d_of_type_Int = ((Integer)this.jdField_c_of_type_JavaLangReflectMethod.invoke(paramCellLocation, new Object[0])).intValue();
            this.jdField_e_of_type_Int = ((Integer)this.jdField_a_of_type_JavaLangReflectMethod.invoke(paramCellLocation, new Object[0])).intValue();
            this.g = ((Integer)this.jdField_d_of_type_JavaLangReflectMethod.invoke(paramCellLocation, new Object[0])).intValue();
            this.h = ((Integer)this.jdField_e_of_type_JavaLangReflectMethod.invoke(paramCellLocation, new Object[0])).intValue();
          }
          catch (Exception paramCellLocation)
          {
            this.jdField_e_of_type_Int = -1;
            this.jdField_d_of_type_Int = -1;
            this.jdField_c_of_type_Int = -1;
            this.g = 2147483647;
            this.h = 2147483647;
          }
        }
      }
    }
    
    public final void onSignalStrengthChanged(int paramInt)
    {
      if (this.jdField_a_of_type_Int == 1) {
        d.a(d.this);
      }
      if (Math.abs(paramInt - (this.f + 113) / 2) > 3)
      {
        if (this.f != -1) {
          break label52;
        }
        this.f = ((paramInt << 1) - 113);
      }
      label52:
      do
      {
        return;
        this.f = ((paramInt << 1) - 113);
        d.a(d.this, new d.b(d.this, this.jdField_a_of_type_Int, this.jdField_b_of_type_Int, this.jdField_c_of_type_Int, this.jdField_d_of_type_Int, this.jdField_e_of_type_Int, this.f, this.g, this.h));
      } while (d.a(d.this) == null);
      d.a(d.this).a(d.a(d.this));
    }
  }
  
  public final class b
    implements Cloneable
  {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = 2147483647;
    public int h = 2147483647;
    
    public b(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      this.a = paramInt1;
      this.b = paramInt2;
      this.c = paramInt3;
      this.d = paramInt4;
      this.e = paramInt5;
      this.f = paramInt6;
      this.g = paramInt7;
      this.h = paramInt8;
    }
    
    public final Object clone()
    {
      try
      {
        b localb = (b)super.clone();
        return localb;
      }
      catch (Exception localException) {}
      return null;
    }
  }
  
  public static abstract interface c
  {
    public abstract void a(d.b paramb);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.map.location.d
 * JD-Core Version:    0.7.0.1
 */