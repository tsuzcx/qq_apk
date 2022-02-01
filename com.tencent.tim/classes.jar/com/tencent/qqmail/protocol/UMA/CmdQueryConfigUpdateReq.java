package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryConfigUpdateReq
  extends BaseProtoBuf
{
  private static final int fieldNumberCall_scene = 2;
  private static final int fieldNumberRequest = 1;
  public int call_scene = -2147483648;
  public LinkedList<RequestField> request = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 8, this.request);
    int i = j;
    if (this.call_scene != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.call_scene);
    }
    return i;
  }
  
  public final CmdQueryConfigUpdateReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.request.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryConfigUpdateReq paramCmdQueryConfigUpdateReq, int paramInt)
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
        RequestField localRequestField = new RequestField();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localRequestField.populateBuilderWithField((InputReader)localObject, localRequestField, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdQueryConfigUpdateReq.request.add(localRequestField);
        paramInt += 1;
      }
      return true;
    }
    paramCmdQueryConfigUpdateReq.call_scene = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.request);
    if (this.call_scene != -2147483648) {
      paramOutputWriter.writeInteger(2, this.call_scene);
    }
  }
  
  public static final class RequestField
    extends BaseProtoBuf
  {
    private static final int fieldNumberConfig_type = 1;
    private static final int fieldNumberCur_config_version = 2;
    private static final int fieldNumberExtra_param = 5;
    private static final int fieldNumberNew_config_part_len = 4;
    private static final int fieldNumberNew_config_part_pos = 3;
    public int config_type;
    public String cur_config_version;
    public ByteString extra_param;
    public int new_config_part_len = -2147483648;
    public int new_config_part_pos = -2147483648;
    
    public final int computeSize()
    {
      int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.config_type);
      int i = j;
      if (this.cur_config_version != null) {
        i = j + ComputeSizeUtil.computeStringSize(2, this.cur_config_version);
      }
      j = i;
      if (this.new_config_part_pos != -2147483648) {
        j = i + ComputeSizeUtil.computeIntegerSize(3, this.new_config_part_pos);
      }
      i = j;
      if (this.new_config_part_len != -2147483648) {
        i = j + ComputeSizeUtil.computeIntegerSize(4, this.new_config_part_len);
      }
      j = i;
      if (this.extra_param != null) {
        j = i + ComputeSizeUtil.computeByteStringSize(5, this.extra_param);
      }
      return j;
    }
    
    public final RequestField parseFrom(byte[] paramArrayOfByte)
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
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, RequestField paramRequestField, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramRequestField.config_type = paramInputReader.readInteger(paramInt);
        return true;
      case 2: 
        paramRequestField.cur_config_version = paramInputReader.readString(paramInt);
        return true;
      case 3: 
        paramRequestField.new_config_part_pos = paramInputReader.readInteger(paramInt);
        return true;
      case 4: 
        paramRequestField.new_config_part_len = paramInputReader.readInteger(paramInt);
        return true;
      }
      paramRequestField.extra_param = paramInputReader.readByteString(paramInt);
      return true;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      paramOutputWriter.writeInteger(1, this.config_type);
      if (this.cur_config_version != null) {
        paramOutputWriter.writeString(2, this.cur_config_version);
      }
      if (this.new_config_part_pos != -2147483648) {
        paramOutputWriter.writeInteger(3, this.new_config_part_pos);
      }
      if (this.new_config_part_len != -2147483648) {
        paramOutputWriter.writeInteger(4, this.new_config_part_len);
      }
      if (this.extra_param != null) {
        paramOutputWriter.writeByteString(5, this.extra_param);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateReq
 * JD-Core Version:    0.7.0.1
 */