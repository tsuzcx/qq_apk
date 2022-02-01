package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CardType
  extends BaseProtoBuf
{
  private static final int fieldNumberAvatar = 3;
  private static final int fieldNumberEmptyTip = 6;
  private static final int fieldNumberIsdefault = 5;
  private static final int fieldNumberName = 2;
  private static final int fieldNumberPriority = 4;
  private static final int fieldNumberType = 1;
  public ByteString avatar;
  public ByteString emptyTip;
  public boolean isdefault;
  public ByteString name;
  public double priority = 4.9E-324D;
  public int type = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.type != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    }
    int i = j;
    if (this.name != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.name);
    }
    j = i;
    if (this.avatar != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.avatar);
    }
    i = j;
    if (this.priority != 4.9E-324D) {
      i = j + ComputeSizeUtil.computeDoubleSize(4, this.priority);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(5, this.isdefault);
    i = j;
    if (this.emptyTip != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.emptyTip);
    }
    return i;
  }
  
  public final CardType parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CardType paramCardType, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCardType.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCardType.name = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramCardType.avatar = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramCardType.priority = paramInputReader.readDouble(paramInt);
      return true;
    case 5: 
      paramCardType.isdefault = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramCardType.emptyTip = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(1, this.type);
    }
    if (this.name != null) {
      paramOutputWriter.writeByteString(2, this.name);
    }
    if (this.avatar != null) {
      paramOutputWriter.writeByteString(3, this.avatar);
    }
    if (this.priority != 4.9E-324D) {
      paramOutputWriter.writeDouble(4, this.priority);
    }
    paramOutputWriter.writeBoolean(5, this.isdefault);
    if (this.emptyTip != null) {
      paramOutputWriter.writeByteString(6, this.emptyTip);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CardType
 * JD-Core Version:    0.7.0.1
 */