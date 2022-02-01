package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class ADBWList
  extends BaseProtoBuf
{
  private static final int fieldNumberBlack_email = 1;
  private static final int fieldNumberWhite_email = 2;
  public LinkedList<String> black_email = new LinkedList();
  public LinkedList<String> white_email = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 1, this.black_email) + ComputeSizeUtil.computeListSize(2, 1, this.white_email);
  }
  
  public final ADBWList parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.black_email.clear();
    this.white_email.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ADBWList paramADBWList, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramADBWList.black_email.add(paramInputReader.readString(paramInt));
      return true;
    }
    paramADBWList.white_email.add(paramInputReader.readString(paramInt));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.black_email);
    paramOutputWriter.writeList(2, 1, this.white_email);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.ADBWList
 * JD-Core Version:    0.7.0.1
 */