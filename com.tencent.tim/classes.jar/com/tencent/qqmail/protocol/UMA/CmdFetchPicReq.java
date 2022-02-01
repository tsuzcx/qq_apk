package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdFetchPicReq
  extends BaseProtoBuf
{
  private static final int fieldNumberPic_column = 3;
  private static final int fieldNumberPic_ratio = 2;
  private static final int fieldNumberPic_row = 4;
  private static final int fieldNumberPic_url = 1;
  public int pic_column = -2147483648;
  public int pic_ratio = -2147483648;
  public int pic_row = -2147483648;
  public String pic_url;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.pic_url != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.pic_url);
    }
    int i = j;
    if (this.pic_ratio != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.pic_ratio);
    }
    j = i;
    if (this.pic_column != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.pic_column);
    }
    i = j;
    if (this.pic_row != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.pic_row);
    }
    return i;
  }
  
  public final CmdFetchPicReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdFetchPicReq paramCmdFetchPicReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdFetchPicReq.pic_url = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramCmdFetchPicReq.pic_ratio = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramCmdFetchPicReq.pic_column = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdFetchPicReq.pic_row = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.pic_url != null) {
      paramOutputWriter.writeString(1, this.pic_url);
    }
    if (this.pic_ratio != -2147483648) {
      paramOutputWriter.writeInteger(2, this.pic_ratio);
    }
    if (this.pic_column != -2147483648) {
      paramOutputWriter.writeInteger(3, this.pic_column);
    }
    if (this.pic_row != -2147483648) {
      paramOutputWriter.writeInteger(4, this.pic_row);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdFetchPicReq
 * JD-Core Version:    0.7.0.1
 */