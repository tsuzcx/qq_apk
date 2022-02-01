package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CardPara
  extends BaseProtoBuf
{
  private static final int fieldNumberDefault_value = 4;
  private static final int fieldNumberDomid = 6;
  private static final int fieldNumberKey = 1;
  private static final int fieldNumberLimit_count = 5;
  private static final int fieldNumberName = 2;
  private static final int fieldNumberType = 7;
  private static final int fieldNumberValue = 3;
  public ByteString default_value;
  public ByteString domid;
  public ByteString key;
  public int limit_count = -2147483648;
  public ByteString name;
  public int type;
  public ByteString value;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.key != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.key);
    }
    int i = j;
    if (this.name != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.name);
    }
    j = i;
    if (this.value != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.value);
    }
    i = j;
    if (this.default_value != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.default_value);
    }
    j = i;
    if (this.limit_count != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.limit_count);
    }
    i = j;
    if (this.domid != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.domid);
    }
    return i + ComputeSizeUtil.computeIntegerSize(7, this.type);
  }
  
  public final CardPara parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CardPara paramCardPara, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCardPara.key = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramCardPara.name = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramCardPara.value = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramCardPara.default_value = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramCardPara.limit_count = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramCardPara.domid = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCardPara.type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.key != null) {
      paramOutputWriter.writeByteString(1, this.key);
    }
    if (this.name != null) {
      paramOutputWriter.writeByteString(2, this.name);
    }
    if (this.value != null) {
      paramOutputWriter.writeByteString(3, this.value);
    }
    if (this.default_value != null) {
      paramOutputWriter.writeByteString(4, this.default_value);
    }
    if (this.limit_count != -2147483648) {
      paramOutputWriter.writeInteger(5, this.limit_count);
    }
    if (this.domid != null) {
      paramOutputWriter.writeByteString(6, this.domid);
    }
    paramOutputWriter.writeInteger(7, this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CardPara
 * JD-Core Version:    0.7.0.1
 */