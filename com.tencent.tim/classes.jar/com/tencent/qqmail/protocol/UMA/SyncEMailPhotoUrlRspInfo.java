package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncEMailPhotoUrlRspInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberQquin = 6;
  private static final int fieldNumberResult = 2;
  private static final int fieldNumberSha = 3;
  private static final int fieldNumberSize = 5;
  private static final int fieldNumberUrl = 4;
  public String email;
  public int qquin = -2147483648;
  public int result;
  public String sha;
  public int size;
  public String url;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.email != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int j = i + ComputeSizeUtil.computeIntegerSize(2, this.result);
    i = j;
    if (this.sha != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.sha);
    }
    j = i;
    if (this.url != null) {
      j = i + ComputeSizeUtil.computeStringSize(4, this.url);
    }
    j += ComputeSizeUtil.computeIntegerSize(5, this.size);
    i = j;
    if (this.qquin != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.qquin);
    }
    return i;
  }
  
  public final SyncEMailPhotoUrlRspInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncEMailPhotoUrlRspInfo paramSyncEMailPhotoUrlRspInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSyncEMailPhotoUrlRspInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramSyncEMailPhotoUrlRspInfo.result = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramSyncEMailPhotoUrlRspInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramSyncEMailPhotoUrlRspInfo.url = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramSyncEMailPhotoUrlRspInfo.size = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramSyncEMailPhotoUrlRspInfo.qquin = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    paramOutputWriter.writeInteger(2, this.result);
    if (this.sha != null) {
      paramOutputWriter.writeString(3, this.sha);
    }
    if (this.url != null) {
      paramOutputWriter.writeString(4, this.url);
    }
    paramOutputWriter.writeInteger(5, this.size);
    if (this.qquin != -2147483648) {
      paramOutputWriter.writeInteger(6, this.qquin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncEMailPhotoUrlRspInfo
 * JD-Core Version:    0.7.0.1
 */