package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class GetCardListReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCount = 4;
  private static final int fieldNumberMaxid = 3;
  private static final int fieldNumberSynkey = 2;
  private static final int fieldNumberType = 1;
  public int count = -2147483648;
  public long maxid = -9223372036854775808L;
  public ByteString synkey;
  public int type = 0;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.type != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    }
    int i = j;
    if (this.synkey != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.synkey);
    }
    j = i;
    if (this.maxid != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(3, this.maxid);
    }
    i = j;
    if (this.count != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.count);
    }
    return i;
  }
  
  public final GetCardListReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, GetCardListReq paramGetCardListReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramGetCardListReq.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramGetCardListReq.synkey = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramGetCardListReq.maxid = paramInputReader.readLong(paramInt);
      return true;
    }
    paramGetCardListReq.count = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(1, this.type);
    }
    if (this.synkey != null) {
      paramOutputWriter.writeByteString(2, this.synkey);
    }
    if (this.maxid != -9223372036854775808L) {
      paramOutputWriter.writeLong(3, this.maxid);
    }
    if (this.count != -2147483648) {
      paramOutputWriter.writeInteger(4, this.count);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.GetCardListReq
 * JD-Core Version:    0.7.0.1
 */