package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdGetThumbnailRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberPreparation_progress = 4;
  private static final int fieldNumberThumb_digest = 3;
  private static final int fieldNumberThumb_part = 1;
  private static final int fieldNumberThumb_size = 2;
  public int preparation_progress = -2147483648;
  public DigestInfo thumb_digest;
  public ByteString thumb_part;
  public ByteString thumb_size;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.thumb_part != null) {
      j = 0 + ComputeSizeUtil.computeByteStringSize(1, this.thumb_part);
    }
    int i = j;
    if (this.thumb_size != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.thumb_size);
    }
    j = i;
    if (this.thumb_digest != null) {
      j = i + ComputeSizeUtil.computeMessageSize(3, this.thumb_digest.computeSize());
    }
    i = j;
    if (this.preparation_progress != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.preparation_progress);
    }
    return i;
  }
  
  public final CmdGetThumbnailRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdGetThumbnailRsp paramCmdGetThumbnailRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdGetThumbnailRsp.thumb_part = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramCmdGetThumbnailRsp.thumb_size = paramInputReader.readByteString(paramInt);
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
        paramCmdGetThumbnailRsp.thumb_digest = localDigestInfo;
        paramInt += 1;
      }
      return true;
    }
    paramCmdGetThumbnailRsp.preparation_progress = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.thumb_part != null) {
      paramOutputWriter.writeByteString(1, this.thumb_part);
    }
    if (this.thumb_size != null) {
      paramOutputWriter.writeByteString(2, this.thumb_size);
    }
    if (this.thumb_digest != null)
    {
      paramOutputWriter.writeMessage(3, this.thumb_digest.computeSize());
      this.thumb_digest.writeFields(paramOutputWriter);
    }
    if (this.preparation_progress != -2147483648) {
      paramOutputWriter.writeInteger(4, this.preparation_progress);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdGetThumbnailRsp
 * JD-Core Version:    0.7.0.1
 */