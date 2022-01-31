package com.tencent.mobileqq.service.message;

import android.util.SparseArray;

public class DecodeProtoPkgContext
  extends PBDecodeContext
{
  public static final int a = 1000;
  public static final int b = 1001;
  public long a;
  private SparseArray a;
  public boolean a;
  public long b;
  public boolean b = false;
  public long c;
  public boolean c = false;
  public long d;
  public boolean d = false;
  public boolean e;
  public boolean f = false;
  public boolean g = true;
  public boolean h = false;
  
  public DecodeProtoPkgContext(long paramLong1, long paramLong2, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_e_of_type_Long = paramLong2;
    this.jdField_a_of_type_Boolean = paramBoolean1;
    this.b = paramBoolean2;
    this.c = paramBoolean3;
    this.d = paramBoolean4;
  }
  
  public Object a(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      return this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
    }
    return null;
  }
  
  public void a(int paramInt, Object paramObject)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
    }
    this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.service.message.DecodeProtoPkgContext
 * JD-Core Version:    0.7.0.1
 */