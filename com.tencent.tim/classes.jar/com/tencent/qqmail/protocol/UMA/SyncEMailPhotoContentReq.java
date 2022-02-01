package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SyncEMailPhotoContentReq
  extends BaseProtoBuf
{
  private static final int fieldNumberInfo = 1;
  public SyncEMailPhotoContentReqInfo info;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.info != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.info.computeSize());
    }
    return i;
  }
  
  public final SyncEMailPhotoContentReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SyncEMailPhotoContentReq paramSyncEMailPhotoContentReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      SyncEMailPhotoContentReqInfo localSyncEMailPhotoContentReqInfo = new SyncEMailPhotoContentReqInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localSyncEMailPhotoContentReqInfo.populateBuilderWithField((InputReader)localObject, localSyncEMailPhotoContentReqInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramSyncEMailPhotoContentReq.info = localSyncEMailPhotoContentReqInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.info != null)
    {
      paramOutputWriter.writeMessage(1, this.info.computeSize());
      this.info.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SyncEMailPhotoContentReq
 * JD-Core Version:    0.7.0.1
 */