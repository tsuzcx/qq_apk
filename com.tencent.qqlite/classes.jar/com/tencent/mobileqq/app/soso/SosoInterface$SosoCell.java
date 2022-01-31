package com.tencent.mobileqq.app.soso;

public final class SosoInterface$SosoCell
  implements Comparable
{
  public int a;
  public boolean a;
  public int b;
  public int c;
  public int d;
  public int e;
  
  public SosoInterface$SosoCell(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean)
  {
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
    this.c = paramInt3;
    this.d = paramInt4;
    this.e = paramInt5;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public int a(SosoCell paramSosoCell)
  {
    return this.d - paramSosoCell.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.soso.SosoInterface.SosoCell
 * JD-Core Version:    0.7.0.1
 */