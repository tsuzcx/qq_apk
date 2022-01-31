package com.tencent.mobileqq.transfile.protohandler;

import java.util.ArrayList;

public class RichProto$RichProtoResp$GroupPicUpResp
  extends RichProto.RichProtoResp.RespCommon
{
  public int a;
  public long a;
  public String a;
  public ArrayList a;
  public boolean a;
  public int b;
  public boolean b = false;
  
  public RichProto$RichProtoResp$GroupPicUpResp()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(super.toString());
    localStringBuilder.append(" fileID:");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(" isExist:");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append(" blockSize:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(" netChg:");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp
 * JD-Core Version:    0.7.0.1
 */