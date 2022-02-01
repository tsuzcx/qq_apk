package com.tencent.qqmail.protocol;

import com.tencent.qqmail.protobuf.BaseProtoBuf;

public class ASContact
  implements ARTConvert
{
  public String display_name_;
  public String email_address_;
  
  public void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf)
  {
    paramBaseProtoBuf = (com.tencent.qqmail.protocol.ART.ASContact)paramBaseProtoBuf;
    this.display_name_ = paramBaseProtoBuf.display_name_;
    this.email_address_ = paramBaseProtoBuf.email_address_;
  }
  
  public void ART_ToProto(BaseProtoBuf paramBaseProtoBuf) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ASContact
 * JD-Core Version:    0.7.0.1
 */