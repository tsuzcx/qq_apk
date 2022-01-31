package com.tencent.mobileqq.transfile;

import java.util.HashMap;

public class FileMsg$StepTransInfo
  extends FileMsg.StepBaseInfo
{
  public HashMap a;
  public String b;
  public String c;
  public boolean c;
  public long d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public String e;
  public boolean e;
  public long f = 0L;
  
  public FileMsg$StepTransInfo()
  {
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Long = 0L;
    this.jdField_e_of_type_Long = 0L;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Int = 0;
    this.jdField_e_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public String a()
  {
    if (a())
    {
      long l1 = this.jdField_d_of_type_Long;
      long l2 = this.jdField_e_of_type_Long;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("result:" + this.jdField_a_of_type_Boolean);
      localStringBuilder.append(",elapsed:" + a());
      localStringBuilder.append(",errCode:" + this.jdField_a_of_type_Int);
      localStringBuilder.append(",retryCount:" + this.b);
      localStringBuilder.append(",flow:" + (l1 + l2));
      localStringBuilder.append(",isStream:" + this.jdField_d_of_type_Boolean);
      localStringBuilder.append(",httpCode:" + this.jdField_e_of_type_Int);
      localStringBuilder.append(",serverExist:" + this.jdField_c_of_type_Boolean);
      localStringBuilder.append(",isBigChannel:" + this.jdField_e_of_type_Boolean);
      if (this.jdField_c_of_type_Long != 9223372036854775807L) {
        localStringBuilder.append(",detailError:" + this.jdField_c_of_type_Long);
      }
      localStringBuilder.append(",firstIp:" + this.jdField_c_of_type_JavaLangString);
      localStringBuilder.append(",lastUseIp:" + this.jdField_d_of_type_JavaLangString);
      localStringBuilder.append(",respHeader:" + this.jdField_e_of_type_JavaLangString);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
  
  public String b()
  {
    if (a())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("{");
      localStringBuilder.append("elapsed:" + a());
      localStringBuilder.append(",tryCount:" + this.b);
      localStringBuilder.append("}");
      return localStringBuilder.toString();
    }
    return "{}";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.FileMsg.StepTransInfo
 * JD-Core Version:    0.7.0.1
 */