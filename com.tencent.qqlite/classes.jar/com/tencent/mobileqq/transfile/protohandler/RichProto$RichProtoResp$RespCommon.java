package com.tencent.mobileqq.transfile.protohandler;

public class RichProto$RichProtoResp$RespCommon
{
  public RichProto.RichProtoReq a;
  public int c = -1;
  public int d;
  public String d;
  public int e;
  public String e;
  public int f;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("res:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(" errCode:");
    localStringBuilder.append(this.jdField_d_of_type_Int);
    localStringBuilder.append(" errStr:");
    localStringBuilder.append(this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(" reason:");
    localStringBuilder.append(this.jdField_e_of_type_JavaLangString);
    localStringBuilder.append(" succCnt:");
    localStringBuilder.append(this.jdField_e_of_type_Int);
    localStringBuilder.append(" failCnt");
    localStringBuilder.append(this.f);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon
 * JD-Core Version:    0.7.0.1
 */