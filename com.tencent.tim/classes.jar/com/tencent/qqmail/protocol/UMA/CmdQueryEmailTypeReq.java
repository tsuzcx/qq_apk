package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryEmailTypeReq
  extends BaseProtoBuf
{
  private static final int fieldNumberInfo = 1;
  public LinkedList<EmailInfo> info = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.info);
  }
  
  public final CmdQueryEmailTypeReq parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.info.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryEmailTypeReq paramCmdQueryEmailTypeReq, int paramInt)
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
      EmailInfo localEmailInfo = new EmailInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localEmailInfo.populateBuilderWithField((InputReader)localObject, localEmailInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramCmdQueryEmailTypeReq.info.add(localEmailInfo);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.info);
  }
  
  public static final class EmailInfo
    extends BaseProtoBuf
  {
    private static final int fieldNumberFrom = 1;
    private static final int fieldNumberId = 4;
    private static final int fieldNumberIp = 2;
    private static final int fieldNumberSubject = 3;
    public String from;
    public long id = -9223372036854775808L;
    public String ip;
    public String subject;
    
    public final int computeSize()
    {
      int j = 0;
      if (this.from != null) {
        j = 0 + ComputeSizeUtil.computeStringSize(1, this.from);
      }
      int i = j;
      if (this.ip != null) {
        i = j + ComputeSizeUtil.computeStringSize(2, this.ip);
      }
      j = i;
      if (this.subject != null) {
        j = i + ComputeSizeUtil.computeStringSize(3, this.subject);
      }
      i = j;
      if (this.id != -9223372036854775808L) {
        i = j + ComputeSizeUtil.computeLongSize(4, this.id);
      }
      return i;
    }
    
    public final EmailInfo parseFrom(byte[] paramArrayOfByte)
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
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, EmailInfo paramEmailInfo, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramEmailInfo.from = paramInputReader.readString(paramInt);
        return true;
      case 2: 
        paramEmailInfo.ip = paramInputReader.readString(paramInt);
        return true;
      case 3: 
        paramEmailInfo.subject = paramInputReader.readString(paramInt);
        return true;
      }
      paramEmailInfo.id = paramInputReader.readLong(paramInt);
      return true;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      if (this.from != null) {
        paramOutputWriter.writeString(1, this.from);
      }
      if (this.ip != null) {
        paramOutputWriter.writeString(2, this.ip);
      }
      if (this.subject != null) {
        paramOutputWriter.writeString(3, this.subject);
      }
      if (this.id != -9223372036854775808L) {
        paramOutputWriter.writeLong(4, this.id);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryEmailTypeReq
 * JD-Core Version:    0.7.0.1
 */