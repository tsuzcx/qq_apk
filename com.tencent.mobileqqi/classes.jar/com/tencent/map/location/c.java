package com.tencent.map.location;

import android.net.wifi.ScanResult;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

public final class c
{
  private static c jdField_a_of_type_ComTencentMapLocationC;
  private long jdField_a_of_type_Long = 0L;
  private String jdField_a_of_type_JavaLangString;
  private List<a> jdField_a_of_type_JavaUtilList = new ArrayList();
  private List<b> b = new ArrayList();
  
  public static c a()
  {
    if (jdField_a_of_type_ComTencentMapLocationC == null) {
      jdField_a_of_type_ComTencentMapLocationC = new c();
    }
    return jdField_a_of_type_ComTencentMapLocationC;
  }
  
  private static boolean a(StringBuffer paramStringBuffer)
  {
    boolean bool = false;
    try
    {
      double d = new JSONObject(paramStringBuffer.toString()).getJSONObject("location").getDouble("accuracy");
      if (d < 5000.0D) {
        bool = true;
      }
      return bool;
    }
    catch (Exception paramStringBuffer) {}
    return false;
  }
  
  private boolean a(List<ScanResult> paramList)
  {
    if (paramList == null) {}
    label113:
    do
    {
      return false;
      int k;
      if (this.b != null)
      {
        int j = 0;
        i = 0;
        k = i;
        if (j < this.b.size())
        {
          String str = ((b)this.b.get(j)).jdField_a_of_type_JavaLangString;
          int m = 0;
          for (;;)
          {
            k = i;
            if (str != null)
            {
              k = i;
              if (m < paramList.size())
              {
                if (!str.equals(((ScanResult)paramList.get(m)).BSSID)) {
                  break label113;
                }
                k = i + 1;
              }
            }
            j += 1;
            i = k;
            break;
            m += 1;
          }
        }
      }
      else
      {
        k = 0;
      }
      int i = paramList.size();
      if ((i >= 6) && (k >= i / 2 + 1)) {
        return true;
      }
      if ((i < 6) && (k >= 2)) {
        return true;
      }
    } while ((this.b.size() > 2) || (paramList.size() > 2) || (Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long) > 30000L));
    return true;
  }
  
  public final String a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<ScanResult> paramList)
  {
    if ((this.jdField_a_of_type_JavaLangString == null) || (this.jdField_a_of_type_JavaLangString.length() < 10)) {}
    label241:
    label255:
    do
    {
      return null;
      String str = this.jdField_a_of_type_JavaLangString;
      Object localObject;
      if ((str == null) || (paramList == null)) {
        localObject = null;
      }
      for (;;)
      {
        this.jdField_a_of_type_JavaLangString = ((String)localObject);
        if (this.jdField_a_of_type_JavaLangString == null) {
          break;
        }
        if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() <= 0)) {
          break label255;
        }
        localObject = (a)this.jdField_a_of_type_JavaUtilList.get(0);
        if ((((a)localObject).a != paramInt1) || (((a)localObject).b != paramInt2) || (((a)localObject).c != paramInt3) || (((a)localObject).d != paramInt4)) {
          break;
        }
        if (((this.b != null) && (this.b.size() != 0)) || ((paramList != null) && (paramList.size() != 0))) {
          break label241;
        }
        return this.jdField_a_of_type_JavaLangString;
        long l = Math.abs(System.currentTimeMillis() - this.jdField_a_of_type_Long);
        if (((l <= 30000L) || (paramList.size() <= 2)) && ((l <= 45000L) || (paramList.size() > 2)))
        {
          localObject = str;
          if (a(new StringBuffer(str))) {}
        }
        else
        {
          localObject = null;
        }
      }
      if (a(paramList)) {
        return this.jdField_a_of_type_JavaLangString;
      }
    } while (!a(paramList));
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public final void a()
  {
    this.jdField_a_of_type_JavaLangString = null;
  }
  
  public final void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, List<ScanResult> paramList)
  {
    this.jdField_a_of_type_Long = System.currentTimeMillis();
    this.jdField_a_of_type_JavaLangString = null;
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject = new a((byte)0);
    ((a)localObject).a = paramInt1;
    ((a)localObject).b = paramInt2;
    ((a)localObject).c = paramInt3;
    ((a)localObject).d = paramInt4;
    this.jdField_a_of_type_JavaUtilList.add(localObject);
    if (paramList != null)
    {
      this.b.clear();
      paramInt1 = 0;
      while (paramInt1 < paramList.size())
      {
        localObject = new b((byte)0);
        ((b)localObject).jdField_a_of_type_JavaLangString = ((ScanResult)paramList.get(paramInt1)).BSSID;
        paramInt2 = ((ScanResult)paramList.get(paramInt1)).level;
        this.b.add(localObject);
        paramInt1 += 1;
      }
    }
  }
  
  public final void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  static final class a
  {
    public int a = -1;
    public int b = -1;
    public int c = -1;
    public int d = -1;
  }
  
  static final class b
  {
    public String a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.map.location.c
 * JD-Core Version:    0.7.0.1
 */