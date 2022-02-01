package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class GetShareUrlInput
  extends BaseProtoBuf
{
  private static final int fieldNumberPath = 2;
  private static final int fieldNumberShareUrlInputList = 1;
  public int path;
  public LinkedList<ShareUrlItemInput> shareUrlInputList = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.shareUrlInputList) + ComputeSizeUtil.computeIntegerSize(2, this.path);
  }
  
  public final GetShareUrlInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.shareUrlInputList.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, GetShareUrlInput paramGetShareUrlInput, int paramInt)
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
        ShareUrlItemInput localShareUrlItemInput = new ShareUrlItemInput();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localShareUrlItemInput.populateBuilderWithField((InputReader)localObject, localShareUrlItemInput, getNextFieldNumber((InputReader)localObject))) {}
        paramGetShareUrlInput.shareUrlInputList.add(localShareUrlItemInput);
        paramInt += 1;
      }
      return true;
    }
    paramGetShareUrlInput.path = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.shareUrlInputList);
    paramOutputWriter.writeInteger(2, this.path);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.GetShareUrlInput
 * JD-Core Version:    0.7.0.1
 */