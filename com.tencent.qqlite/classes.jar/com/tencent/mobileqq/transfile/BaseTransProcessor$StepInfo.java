package com.tencent.mobileqq.transfile;

public class BaseTransProcessor$StepInfo
{
  public int a;
  public long a;
  public int b;
  public long b;
  public int c = 0;
  
  public BaseTransProcessor$StepInfo()
  {
    this.jdField_a_of_type_Int = -1;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 0L;
    this.jdField_b_of_type_Int = 0;
  }
  
  public String a(int paramInt)
  {
    long l2 = 0L;
    long l1 = l2;
    if (this.jdField_a_of_type_Int != -1)
    {
      l1 = l2;
      if (this.jdField_a_of_type_Long != 0L)
      {
        l1 = l2;
        if (this.jdField_b_of_type_Long != 0L) {
          l1 = (this.jdField_b_of_type_Long - this.jdField_a_of_type_Long) / 1000000L;
        }
      }
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramInt).append("_").append(this.jdField_a_of_type_Int).append("_").append(this.jdField_b_of_type_Int).append("_").append(this.c).append("_").append(l1);
    return localStringBuilder.toString();
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_Long == 0L) {
      this.jdField_a_of_type_Long = System.nanoTime();
    }
  }
  
  public void b()
  {
    long l = System.nanoTime();
    if (l > this.jdField_b_of_type_Long) {
      this.jdField_b_of_type_Long = l;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo
 * JD-Core Version:    0.7.0.1
 */