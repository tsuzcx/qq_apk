package com.tencent.mobileqq.transfile.protohandler;

import java.util.ArrayList;

public class RichProto$RichProtoResp$C2CPicUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public boolean a;
  public String b;
  public boolean b = false;
  public String c;
  public boolean c = false;
  public boolean d = false;
  
  public RichProto$RichProtoResp$C2CPicUpResp()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_a_of_type_Long = 0L;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" mResid:");
    localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" startOffset:").append(this.jdField_a_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.C2CPicUpResp
 * JD-Core Version:    0.7.0.1
 */