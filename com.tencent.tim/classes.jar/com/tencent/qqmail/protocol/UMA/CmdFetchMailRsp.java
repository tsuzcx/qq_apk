package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdFetchMailRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberMime_section_digest = 3;
  private static final int fieldNumberMime_section_part = 1;
  private static final int fieldNumberMime_section_size = 2;
  private static final int fieldNumberPreparation_progress = 4;
  public DigestInfo mime_section_digest;
  public ByteString mime_section_part;
  public String mime_section_size;
  public int preparation_progress = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.mime_section_part != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.mime_section_part);
    }
    int i = j;
    if (this.mime_section_size != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.mime_section_size);
    }
    j = i;
    if (this.mime_section_digest != null) {
      j = i + ComputeSizeUtil.computeMessageSize(3, this.mime_section_digest.computeSize());
    }
    i = j;
    if (this.preparation_progress != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.preparation_progress);
    }
    return i;
  }
  
  public final CmdFetchMailRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdFetchMailRsp paramCmdFetchMailRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdFetchMailRsp.mime_section_part = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramCmdFetchMailRsp.mime_section_size = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        DigestInfo localDigestInfo = new DigestInfo();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localDigestInfo.populateBuilderWithField((InputReader)localObject, localDigestInfo, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdFetchMailRsp.mime_section_digest = localDigestInfo;
        paramInt += 1;
      }
      return true;
    }
    paramCmdFetchMailRsp.preparation_progress = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.mime_section_part != null) {
      paramOutputWriter.writeByteString(1, this.mime_section_part);
    }
    if (this.mime_section_size != null) {
      paramOutputWriter.writeString(2, this.mime_section_size);
    }
    if (this.mime_section_digest != null)
    {
      paramOutputWriter.writeMessage(3, this.mime_section_digest.computeSize());
      this.mime_section_digest.writeFields(paramOutputWriter);
    }
    if (this.preparation_progress != -2147483648) {
      paramOutputWriter.writeInteger(4, this.preparation_progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdFetchMailRsp
 * JD-Core Version:    0.7.0.1
 */