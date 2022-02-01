package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdUploadAttachReq
  extends BaseProtoBuf
{
  private static final int fieldNumberDigest = 2;
  private static final int fieldNumberName = 1;
  private static final int fieldNumberPart_bin = 5;
  private static final int fieldNumberPart_pos = 4;
  private static final int fieldNumberSize = 3;
  public LinkedList<DigestInfo> digest = new LinkedList();
  public String name;
  public ByteString part_bin;
  public int part_pos = -2147483648;
  public int size = -2147483648;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.name != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.name);
    }
    int j = i + ComputeSizeUtil.computeListSize(2, 8, this.digest);
    i = j;
    if (this.size != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(3, this.size);
    }
    j = i;
    if (this.part_pos != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(4, this.part_pos);
    }
    i = j;
    if (this.part_bin != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(5, this.part_bin);
    }
    return i;
  }
  
  public final CmdUploadAttachReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.digest.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdUploadAttachReq paramCmdUploadAttachReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdUploadAttachReq.name = paramInputReader.readString(paramInt);
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
        paramCmdUploadAttachReq.digest.add(localDigestInfo);
        paramInt += 1;
      }
      return true;
    case 3: 
      paramCmdUploadAttachReq.size = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramCmdUploadAttachReq.part_pos = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdUploadAttachReq.part_bin = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.name != null) {
      paramOutputWriter.writeString(1, this.name);
    }
    paramOutputWriter.writeList(2, 8, this.digest);
    if (this.size != -2147483648) {
      paramOutputWriter.writeInteger(3, this.size);
    }
    if (this.part_pos != -2147483648) {
      paramOutputWriter.writeInteger(4, this.part_pos);
    }
    if (this.part_bin != null) {
      paramOutputWriter.writeByteString(5, this.part_bin);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdUploadAttachReq
 * JD-Core Version:    0.7.0.1
 */