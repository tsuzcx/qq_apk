package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhotoParseReq
  extends BaseProtoBuf
{
  private static final int fieldNumberPhoto = 2;
  private static final int fieldNumberPhototype = 3;
  private static final int fieldNumberType = 1;
  public ByteString photo;
  public int phototype = -2147483648;
  public int type = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.type != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.type);
    }
    int i = j;
    if (this.photo != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.photo);
    }
    j = i;
    if (this.phototype != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.phototype);
    }
    return j;
  }
  
  public final PhotoParseReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhotoParseReq paramPhotoParseReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhotoParseReq.type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramPhotoParseReq.photo = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramPhotoParseReq.phototype = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.type != -2147483648) {
      paramOutputWriter.writeInteger(1, this.type);
    }
    if (this.photo != null) {
      paramOutputWriter.writeByteString(2, this.photo);
    }
    if (this.phototype != -2147483648) {
      paramOutputWriter.writeInteger(3, this.phototype);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhotoParseReq
 * JD-Core Version:    0.7.0.1
 */