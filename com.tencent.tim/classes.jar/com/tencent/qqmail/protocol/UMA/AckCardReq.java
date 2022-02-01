package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class AckCardReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCardid = 1;
  private static final int fieldNumberCode = 3;
  private static final int fieldNumberEmail = 5;
  private static final int fieldNumberFrom = 2;
  private static final int fieldNumberType = 6;
  private static final int fieldNumberUin = 4;
  public ByteString cardid;
  public ByteString code;
  public ByteString email;
  public int from;
  public int type;
  public long uin = -9223372036854775808L;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.cardid != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.cardid);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.from);
    i = j;
    if (this.code != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(3, this.code);
    }
    j = i;
    if (this.uin != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(4, this.uin);
    }
    i = j;
    if (this.email != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(5, this.email);
    }
    return i + ComputeSizeUtil.computeIntegerSize(6, this.type);
  }
  
  public final AckCardReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AckCardReq paramAckCardReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAckCardReq.cardid = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramAckCardReq.from = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramAckCardReq.code = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramAckCardReq.uin = paramInputReader.readLong(paramInt);
      return true;
    case 5: 
      paramAckCardReq.email = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramAckCardReq.type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.cardid != null) {
      paramOutputWriter.writeByteString(1, this.cardid);
    }
    paramOutputWriter.writeInteger(2, this.from);
    if (this.code != null) {
      paramOutputWriter.writeByteString(3, this.code);
    }
    if (this.uin != -9223372036854775808L) {
      paramOutputWriter.writeLong(4, this.uin);
    }
    if (this.email != null) {
      paramOutputWriter.writeByteString(5, this.email);
    }
    paramOutputWriter.writeInteger(6, this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.AckCardReq
 * JD-Core Version:    0.7.0.1
 */