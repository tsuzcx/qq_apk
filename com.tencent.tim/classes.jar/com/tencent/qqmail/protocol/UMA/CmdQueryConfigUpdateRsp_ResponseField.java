package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryConfigUpdateRsp_ResponseField
  extends BaseProtoBuf
{
  private static final int fieldNumberAvailable = 1;
  private static final int fieldNumberConfig_type = 7;
  private static final int fieldNumberNew_config_digest = 3;
  private static final int fieldNumberNew_config_part = 6;
  private static final int fieldNumberNew_config_part_pos = 5;
  private static final int fieldNumberNew_config_size = 4;
  private static final int fieldNumberNew_config_version = 2;
  public boolean available;
  public int config_type;
  public DigestInfo new_config_digest;
  public ByteString new_config_part;
  public int new_config_part_pos = -2147483648;
  public int new_config_size = -2147483648;
  public String new_config_version;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.available);
    int i = j;
    if (this.new_config_version != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.new_config_version);
    }
    j = i;
    if (this.new_config_digest != null) {
      j = i + ComputeSizeUtil.computeMessageSize(3, this.new_config_digest.computeSize());
    }
    i = j;
    if (this.new_config_size != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.new_config_size);
    }
    j = i;
    if (this.new_config_part_pos != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.new_config_part_pos);
    }
    i = j;
    if (this.new_config_part != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(6, this.new_config_part);
    }
    return i + ComputeSizeUtil.computeIntegerSize(7, this.config_type);
  }
  
  public final CmdQueryConfigUpdateRsp_ResponseField parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryConfigUpdateRsp_ResponseField paramCmdQueryConfigUpdateRsp_ResponseField, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdQueryConfigUpdateRsp_ResponseField.available = paramInputReader.readBoolean(paramInt);
      return true;
    case 2: 
      paramCmdQueryConfigUpdateRsp_ResponseField.new_config_version = paramInputReader.readString(paramInt);
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
        paramCmdQueryConfigUpdateRsp_ResponseField.new_config_digest = localDigestInfo;
        paramInt += 1;
      }
      return true;
    case 4: 
      paramCmdQueryConfigUpdateRsp_ResponseField.new_config_size = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramCmdQueryConfigUpdateRsp_ResponseField.new_config_part_pos = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramCmdQueryConfigUpdateRsp_ResponseField.new_config_part = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCmdQueryConfigUpdateRsp_ResponseField.config_type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeBoolean(1, this.available);
    if (this.new_config_version != null) {
      paramOutputWriter.writeString(2, this.new_config_version);
    }
    if (this.new_config_digest != null)
    {
      paramOutputWriter.writeMessage(3, this.new_config_digest.computeSize());
      this.new_config_digest.writeFields(paramOutputWriter);
    }
    if (this.new_config_size != -2147483648) {
      paramOutputWriter.writeInteger(4, this.new_config_size);
    }
    if (this.new_config_part_pos != -2147483648) {
      paramOutputWriter.writeInteger(5, this.new_config_part_pos);
    }
    if (this.new_config_part != null) {
      paramOutputWriter.writeByteString(6, this.new_config_part);
    }
    paramOutputWriter.writeInteger(7, this.config_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateRsp_ResponseField
 * JD-Core Version:    0.7.0.1
 */