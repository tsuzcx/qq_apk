package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdComposeSendReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 1;
  private static final int fieldNumberMime_digest = 2;
  private static final int fieldNumberMime_part_bin = 5;
  private static final int fieldNumberMime_part_pos = 4;
  private static final int fieldNumberMime_size = 3;
  public int account_id = -2147483648;
  public DigestInfo mime_digest;
  public ByteString mime_part_bin;
  public int mime_part_pos = -2147483648;
  public int mime_size = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.account_id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.account_id);
    }
    int i = j;
    if (this.mime_digest != null) {
      i = j + ComputeSizeUtil.computeMessageSize(2, this.mime_digest.computeSize());
    }
    j = i;
    if (this.mime_size != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.mime_size);
    }
    i = j;
    if (this.mime_part_pos != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.mime_part_pos);
    }
    j = i;
    if (this.mime_part_bin != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.mime_part_bin);
    }
    return j;
  }
  
  public final CmdComposeSendReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdComposeSendReq paramCmdComposeSendReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdComposeSendReq.account_id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        DigestInfo localDigestInfo = new DigestInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localDigestInfo.populateBuilderWithField((InputReader)localObject, localDigestInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdComposeSendReq.mime_digest = localDigestInfo;
        paramInt += 1;
      }
      return true;
    case 3: 
      paramCmdComposeSendReq.mime_size = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramCmdComposeSendReq.mime_part_pos = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdComposeSendReq.mime_part_bin = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.account_id);
    }
    if (this.mime_digest != null)
    {
      paramOutputWriter.writeMessage(2, this.mime_digest.computeSize());
      this.mime_digest.writeFields(paramOutputWriter);
    }
    if (this.mime_size != -2147483648) {
      paramOutputWriter.writeInteger(3, this.mime_size);
    }
    if (this.mime_part_pos != -2147483648) {
      paramOutputWriter.writeInteger(4, this.mime_part_pos);
    }
    if (this.mime_part_bin != null) {
      paramOutputWriter.writeByteString(5, this.mime_part_bin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdComposeSendReq
 * JD-Core Version:    0.7.0.1
 */