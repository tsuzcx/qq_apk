package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class GrantFileInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFids = 1;
  private static final int fieldNumberUins = 2;
  public LinkedList<String> fids = new LinkedList();
  public LinkedList<Integer> uins = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 1, this.fids) + ComputeSizeUtil.computeListSize(2, 2, this.uins);
  }
  
  public final GrantFileInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.fids.clear();
    this.uins.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, GrantFileInput paramGrantFileInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramGrantFileInput.fids.add(paramInputReader.readString(paramInt));
      return true;
    }
    paramGrantFileInput.uins.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 1, this.fids);
    paramOutputWriter.writeList(2, 2, this.uins);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.GrantFileInput
 * JD-Core Version:    0.7.0.1
 */