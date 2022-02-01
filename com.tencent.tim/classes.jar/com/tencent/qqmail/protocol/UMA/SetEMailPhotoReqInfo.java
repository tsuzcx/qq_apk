package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class SetEMailPhotoReqInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberData = 4;
  private static final int fieldNumberEmail = 1;
  private static final int fieldNumberInfo = 2;
  private static final int fieldNumberType = 3;
  public ByteString data;
  public String email;
  public EmailProtocolInfo info;
  public int type;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.email != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.email);
    }
    int j = i;
    if (this.info != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.info.computeSize());
    }
    j += ComputeSizeUtil.computeIntegerSize(3, this.type);
    i = j;
    if (this.data != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.data);
    }
    return i;
  }
  
  public final SetEMailPhotoReqInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, SetEMailPhotoReqInfo paramSetEMailPhotoReqInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramSetEMailPhotoReqInfo.email = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        EmailProtocolInfo localEmailProtocolInfo = new EmailProtocolInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localEmailProtocolInfo.populateBuilderWithField((InputReader)localObject, localEmailProtocolInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramSetEMailPhotoReqInfo.info = localEmailProtocolInfo;
        paramInt += 1;
      }
      return true;
    case 3: 
      paramSetEMailPhotoReqInfo.type = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramSetEMailPhotoReqInfo.data = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.email != null) {
      paramOutputWriter.writeString(1, this.email);
    }
    if (this.info != null)
    {
      paramOutputWriter.writeMessage(2, this.info.computeSize());
      this.info.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeInteger(3, this.type);
    if (this.data != null) {
      paramOutputWriter.writeByteString(4, this.data);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.SetEMailPhotoReqInfo
 * JD-Core Version:    0.7.0.1
 */