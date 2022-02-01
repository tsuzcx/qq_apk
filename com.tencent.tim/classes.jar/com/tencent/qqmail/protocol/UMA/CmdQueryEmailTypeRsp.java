package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryEmailTypeRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberType_info = 1;
  public LinkedList<EmailTypeInfo> type_info = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.type_info);
  }
  
  public final CmdQueryEmailTypeRsp parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.type_info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryEmailTypeRsp paramCmdQueryEmailTypeRsp, int paramInt)
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
      EmailTypeInfo localEmailTypeInfo = new EmailTypeInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localEmailTypeInfo.populateBuilderWithField((InputReader)localObject, localEmailTypeInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdQueryEmailTypeRsp.type_info.add(localEmailTypeInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.type_info);
  }
  
  public static final class EmailTypeInfo
    extends BaseProtoBuf
  {
    private static final int fieldNumberId = 1;
    private static final int fieldNumberRule_key = 5;
    private static final int fieldNumberRule_mode = 4;
    private static final int fieldNumberRule_value = 3;
    private static final int fieldNumberType = 2;
    public long id = -9223372036854775808L;
    public String rule_key;
    public String rule_mode;
    public String rule_value;
    public String type;
    
    public final int computeSize()
    {
      int j = 0;
      if (this.id != -9223372036854775808L) {
        j = 0 + ComputeSizeUtil.computeLongSize(1, this.id);
      }
      int i = j;
      if (this.type != null) {
        i = j + ComputeSizeUtil.computeStringSize(2, this.type);
      }
      j = i;
      if (this.rule_value != null) {
        j = i + ComputeSizeUtil.computeStringSize(3, this.rule_value);
      }
      i = j;
      if (this.rule_mode != null) {
        i = j + ComputeSizeUtil.computeStringSize(4, this.rule_mode);
      }
      j = i;
      if (this.rule_key != null) {
        j = i + ComputeSizeUtil.computeStringSize(5, this.rule_key);
      }
      return j;
    }
    
    public final EmailTypeInfo parseFrom(byte[] paramArrayOfByte)
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
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, EmailTypeInfo paramEmailTypeInfo, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramEmailTypeInfo.id = paramInputReader.readLong(paramInt);
        return true;
      case 2: 
        paramEmailTypeInfo.type = paramInputReader.readString(paramInt);
        return true;
      case 3: 
        paramEmailTypeInfo.rule_value = paramInputReader.readString(paramInt);
        return true;
      case 4: 
        paramEmailTypeInfo.rule_mode = paramInputReader.readString(paramInt);
        return true;
      }
      paramEmailTypeInfo.rule_key = paramInputReader.readString(paramInt);
      return true;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      if (this.id != -9223372036854775808L) {
        paramOutputWriter.writeLong(1, this.id);
      }
      if (this.type != null) {
        paramOutputWriter.writeString(2, this.type);
      }
      if (this.rule_value != null) {
        paramOutputWriter.writeString(3, this.rule_value);
      }
      if (this.rule_mode != null) {
        paramOutputWriter.writeString(4, this.rule_mode);
      }
      if (this.rule_key != null) {
        paramOutputWriter.writeString(5, this.rule_key);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeRsp
 * JD-Core Version:    0.7.0.1
 */