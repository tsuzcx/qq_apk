package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemDetailOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberItem = 1;
  public FileInfo item;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.item != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.item.computeSize());
    }
    return i;
  }
  
  public final ItemDetailOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.item == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemDetailOutput paramItemDetailOutput, int paramInt)
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
      FileInfo localFileInfo = new FileInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localFileInfo.populateBuilderWithField((InputReader)localObject, localFileInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramItemDetailOutput.item = localFileInfo;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.item == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.item != null)
    {
      paramOutputWriter.writeMessage(1, this.item.computeSize());
      this.item.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemDetailOutput
 * JD-Core Version:    0.7.0.1
 */