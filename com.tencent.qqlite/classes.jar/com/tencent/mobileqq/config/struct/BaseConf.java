package com.tencent.mobileqq.config.struct;

import com.tencent.mobileqq.config.ConfigManager;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseConf
{
  public static final String a = "NearbyBannerPic";
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static final int m_ = 1;
  public long a;
  protected ArrayList a;
  public short a;
  private boolean a;
  public byte a_ = -1;
  public long b = -1L;
  public long c = -1L;
  private final int i = ConfigManager.a();
  
  public BaseConf(short paramShort, byte paramByte)
  {
    this.jdField_a_of_type_Short = 0;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Short = paramShort;
    this.a_ = paramByte;
  }
  
  public final int a()
  {
    return this.i;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilArrayList;
  }
  
  public final short a()
  {
    return this.jdField_a_of_type_Short;
  }
  
  public abstract void a();
  
  public void a(int paramInt)
  {
    if (paramInt >= this.jdField_a_of_type_JavaUtilArrayList.size()) {
      return;
    }
    this.jdField_a_of_type_JavaUtilArrayList.remove(paramInt);
  }
  
  public abstract void a(DataInputStream paramDataInputStream);
  
  public abstract void a(DataOutputStream paramDataOutputStream);
  
  public void a(Object paramObject)
  {
    this.jdField_a_of_type_JavaUtilArrayList.add(paramObject);
  }
  
  public final void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public final boolean a()
  {
    return (this.c > 0L) && (this.c <= System.currentTimeMillis());
  }
  
  public final int b()
  {
    return this.jdField_a_of_type_JavaUtilArrayList.size();
  }
  
  public void b()
  {
    this.jdField_a_of_type_JavaUtilArrayList.clear();
  }
  
  public void b(String paramString)
  {
    if ((paramString == null) || (paramString.trim().equals(""))) {}
    label85:
    for (;;)
    {
      return;
      int j = 0;
      if (j < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        PicAndAdConf.PicStruct localPicStruct = (PicAndAdConf.PicStruct)this.jdField_a_of_type_JavaUtilArrayList.get(j);
        if ((localPicStruct.d == null) || (!localPicStruct.d.contains(paramString))) {}
      }
      for (;;)
      {
        if (j == -1) {
          break label85;
        }
        this.jdField_a_of_type_JavaUtilArrayList.remove(j);
        return;
        j += 1;
        break;
        j = -1;
      }
    }
  }
  
  public final boolean b()
  {
    return this.b > System.currentTimeMillis();
  }
  
  public final boolean c()
  {
    return this.jdField_a_of_type_Boolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.struct.BaseConf
 * JD-Core Version:    0.7.0.1
 */