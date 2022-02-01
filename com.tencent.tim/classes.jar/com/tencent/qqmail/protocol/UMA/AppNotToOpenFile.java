package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class AppNotToOpenFile
  extends BaseProtoBuf
{
  private static final int fieldNumberMimetype_list = 2;
  private static final int fieldNumberPackage_name = 1;
  public LinkedList<ByteString> mimetype_list = new LinkedList();
  public ByteString package_name;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.package_name != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.package_name);
    }
    return i + ComputeSizeUtil.computeListSize(2, 6, this.mimetype_list);
  }
  
  public final AppNotToOpenFile parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.mimetype_list.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AppNotToOpenFile paramAppNotToOpenFile, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAppNotToOpenFile.package_name = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramAppNotToOpenFile.mimetype_list.add(paramInputReader.readByteString(paramInt));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.package_name != null) {
      paramOutputWriter.writeByteString(1, this.package_name);
    }
    paramOutputWriter.writeList(2, 6, this.mimetype_list);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.AppNotToOpenFile
 * JD-Core Version:    0.7.0.1
 */