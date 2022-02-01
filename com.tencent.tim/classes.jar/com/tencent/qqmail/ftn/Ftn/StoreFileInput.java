package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class StoreFileInput
  extends BaseProtoBuf
{
  private static final int fieldNumberFindex = 1;
  private static final int fieldNumberItemlist = 2;
  public String findex;
  public LinkedList<ItemInputStoreFile> itemlist = new LinkedList();
  
  public final int computeSize()
  {
    int i = 0;
    if (this.findex != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.findex);
    }
    return i + ComputeSizeUtil.computeListSize(2, 8, this.itemlist);
  }
  
  public final StoreFileInput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.itemlist.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, StoreFileInput paramStoreFileInput, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramStoreFileInput.findex = paramInputReader.readString(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      ItemInputStoreFile localItemInputStoreFile = new ItemInputStoreFile();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localItemInputStoreFile.populateBuilderWithField((InputReader)localObject, localItemInputStoreFile, getNextFieldNumber((InputReader)localObject))) {}
      paramStoreFileInput.itemlist.add(localItemInputStoreFile);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.findex != null) {
      paramOutputWriter.writeString(1, this.findex);
    }
    paramOutputWriter.writeList(2, 8, this.itemlist);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.StoreFileInput
 * JD-Core Version:    0.7.0.1
 */