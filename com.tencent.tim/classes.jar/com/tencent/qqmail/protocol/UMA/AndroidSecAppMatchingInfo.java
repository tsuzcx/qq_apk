package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class AndroidSecAppMatchingInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberContent_provider = 3;
  private static final int fieldNumberIdentity = 1;
  private static final int fieldNumberIntent = 2;
  public ByteString content_provider;
  public ByteString identity;
  public ByteString intent;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.identity != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.identity);
    }
    int i = j;
    if (this.intent != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.intent);
    }
    j = i;
    if (this.content_provider != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.content_provider);
    }
    return j;
  }
  
  public final AndroidSecAppMatchingInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AndroidSecAppMatchingInfo paramAndroidSecAppMatchingInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAndroidSecAppMatchingInfo.identity = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramAndroidSecAppMatchingInfo.intent = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramAndroidSecAppMatchingInfo.content_provider = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.identity != null) {
      paramOutputWriter.writeByteString(1, this.identity);
    }
    if (this.intent != null) {
      paramOutputWriter.writeByteString(2, this.intent);
    }
    if (this.content_provider != null) {
      paramOutputWriter.writeByteString(3, this.content_provider);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.AndroidSecAppMatchingInfo
 * JD-Core Version:    0.7.0.1
 */