package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncEMailPhotoContentReqInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberLastmodifytime = 4;
  private static final int fieldNumberSha = 2;
  private static final int fieldNumberSize = 3;
  public String email;
  public String lastmodifytime;
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
    j += ComputeSizeUtil.computeIntegerSize(3, this.size);
    i = j;
    if (this.lastmodifytime != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.lastmodifytime);
    }
    return i;
  }
  
  public final SyncEMailPhotoContentReqInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncEMailPhotoContentReqInfo paramSyncEMailPhotoContentReqInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSyncEMailPhotoContentReqInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramSyncEMailPhotoContentReqInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramSyncEMailPhotoContentReqInfo.size = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramSyncEMailPhotoContentReqInfo.lastmodifytime = paramInputReader.readString(paramInt);
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
    if (this.lastmodifytime != null) {
      paramOutputWriter.writeString(4, this.lastmodifytime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReqInfo
 * JD-Core Version:    0.7.0.1
 */