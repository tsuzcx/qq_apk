package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class AppNotNotify
  extends BaseProtoBuf
{
  private static final int fieldNumberPackage_name = 1;
  private static final int fieldNumberPackage_version = 2;
  public ByteString package_name;
  public ByteString package_version;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.package_name != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.package_name);
    }
    int j = i;
    if (this.package_version != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.package_version);
    }
    return j;
  }
  
  public final AppNotNotify parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AppNotNotify paramAppNotNotify, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAppNotNotify.package_name = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramAppNotNotify.package_version = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.package_name != null) {
      paramOutputWriter.writeByteString(1, this.package_name);
    }
    if (this.package_version != null) {
      paramOutputWriter.writeByteString(2, this.package_version);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.AppNotNotify
 * JD-Core Version:    0.7.0.1
 */