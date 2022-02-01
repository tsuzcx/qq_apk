package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncEMailPhotoReqInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberSha = 2;
  private static final int fieldNumberSize = 3;
  public String email;
  public String sha;
  public int size;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.email != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int j = i;
    if (this.sha != null) {
      j = i + ComputeSizeUtil.computeStringSize(2, this.sha);
    }
    return j + ComputeSizeUtil.computeIntegerSize(3, this.size);
  }
  
  public final SyncEMailPhotoReqInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncEMailPhotoReqInfo paramSyncEMailPhotoReqInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSyncEMailPhotoReqInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramSyncEMailPhotoReqInfo.sha = paramInputReader.readString(paramInt);
      return true;
    }
    paramSyncEMailPhotoReqInfo.size = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    if (this.sha != null) {
      paramOutputWriter.writeString(2, this.sha);
    }
    paramOutputWriter.writeInteger(3, this.size);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncEMailPhotoReqInfo
 * JD-Core Version:    0.7.0.1
 */