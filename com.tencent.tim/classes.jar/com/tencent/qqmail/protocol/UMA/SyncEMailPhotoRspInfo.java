package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncEMailPhotoRspInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberData = 4;
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberLastmodifytime = 7;
  private static final int fieldNumberQquin = 6;
  private static final int fieldNumberResult = 2;
  private static final int fieldNumberSha = 3;
  private static final int fieldNumberSize = 5;
  public ByteString data;
  public String email;
  public String lastmodifytime;
  public int qquin = -2147483648;
  public int result;
  public String sha;
  public int size;
  
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
    if (this.data != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(4, this.data);
    }
    j += ComputeSizeUtil.computeIntegerSize(5, this.size);
    i = j;
    if (this.qquin != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.qquin);
    }
    j = i;
    if (this.lastmodifytime != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.lastmodifytime);
    }
    return j;
  }
  
  public final SyncEMailPhotoRspInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncEMailPhotoRspInfo paramSyncEMailPhotoRspInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSyncEMailPhotoRspInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramSyncEMailPhotoRspInfo.result = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramSyncEMailPhotoRspInfo.sha = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramSyncEMailPhotoRspInfo.data = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramSyncEMailPhotoRspInfo.size = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramSyncEMailPhotoRspInfo.qquin = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramSyncEMailPhotoRspInfo.lastmodifytime = paramInputReader.readString(paramInt);
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
    if (this.data != null) {
      paramOutputWriter.writeByteString(4, this.data);
    }
    paramOutputWriter.writeInteger(5, this.size);
    if (this.qquin != -2147483648) {
      paramOutputWriter.writeInteger(6, this.qquin);
    }
    if (this.lastmodifytime != null) {
      paramOutputWriter.writeString(7, this.lastmodifytime);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncEMailPhotoRspInfo
 * JD-Core Version:    0.7.0.1
 */