package com.tencent.qqmail.protocol;

import com.tencent.qqmail.protobuf.BaseProtoBuf;

public abstract interface ARTConvert
{
  public abstract void ART_ParseProto(BaseProtoBuf paramBaseProtoBuf);
  
  public abstract void ART_ToProto(BaseProtoBuf paramBaseProtoBuf);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ARTConvert
 * JD-Core Version:    0.7.0.1
 */