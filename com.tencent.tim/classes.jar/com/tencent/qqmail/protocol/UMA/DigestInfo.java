package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class DigestInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberData_len = 4;
  private static final int fieldNumberData_pos = 3;
  private static final int fieldNumberDigest = 2;
  private static final int fieldNumberType = 1;
  public int data_len = -2147483648;
  public int data_pos = -2147483648;
  public ByteString digest;
  public int type;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    int i = j;
    if (this.digest != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.digest);
    }
    j = i;
    if (this.data_pos != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.data_pos);
    }
    i = j;
    if (this.data_len != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.data_len);
    }
    return i;
  }
  
  public final DigestInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DigestInfo paramDigestInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramDigestInfo.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramDigestInfo.digest = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramDigestInfo.data_pos = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramDigestInfo.data_len = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.type);
    if (this.digest != null) {
      paramOutputWriter.writeByteString(2, this.digest);
    }
    if (this.data_pos != -2147483648) {
      paramOutputWriter.writeInteger(3, this.data_pos);
    }
    if (this.data_len != -2147483648) {
      paramOutputWriter.writeInteger(4, this.data_len);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.DigestInfo
 * JD-Core Version:    0.7.0.1
 */