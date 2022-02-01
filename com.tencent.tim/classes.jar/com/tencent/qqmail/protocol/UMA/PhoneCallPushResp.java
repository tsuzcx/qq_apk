package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhoneCallPushResp
  extends BaseProtoBuf
{
  private static final int fieldNumberCatalog = 2;
  private static final int fieldNumberInfoitem = 1;
  public ByteString catalog;
  public PushInfo infoitem;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.infoitem != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.infoitem.computeSize());
    }
    int j = i;
    if (this.catalog != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(2, this.catalog);
    }
    return j;
  }
  
  public final PhoneCallPushResp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhoneCallPushResp paramPhoneCallPushResp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        PushInfo localPushInfo = new PushInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localPushInfo.populateBuilderWithField((InputReader)localObject, localPushInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramPhoneCallPushResp.infoitem = localPushInfo;
        paramInt += 1;
      }
      return true;
    }
    paramPhoneCallPushResp.catalog = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.infoitem != null)
    {
      paramOutputWriter.writeMessage(1, this.infoitem.computeSize());
      this.infoitem.writeFields(paramOutputWriter);
    }
    if (this.catalog != null) {
      paramOutputWriter.writeByteString(2, this.catalog);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhoneCallPushResp
 * JD-Core Version:    0.7.0.1
 */