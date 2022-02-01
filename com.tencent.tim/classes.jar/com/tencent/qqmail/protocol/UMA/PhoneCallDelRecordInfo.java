package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PhoneCallDelRecordInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberDel_key = 1;
  private static final int fieldNumberDel_type = 2;
  public LinkedList<String> del_key = new LinkedList();
  public int del_type;
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 1, this.del_key) + ComputeSizeUtil.computeIntegerSize(2, this.del_type);
  }
  
  public final PhoneCallDelRecordInfo parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.del_key.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PhoneCallDelRecordInfo paramPhoneCallDelRecordInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPhoneCallDelRecordInfo.del_key.add(paramInputReader.readString(paramInt));
      return true;
    }
    paramPhoneCallDelRecordInfo.del_type = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.del_key);
    paramOutputWriter.writeInteger(2, this.del_type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PhoneCallDelRecordInfo
 * JD-Core Version:    0.7.0.1
 */