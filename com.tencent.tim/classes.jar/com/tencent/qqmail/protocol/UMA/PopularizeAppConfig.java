package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class PopularizeAppConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberPriority = 1;
  private static final int fieldNumberSub_items = 2;
  public int priority = -2147483648;
  public LinkedList<PopularizeSubItem> sub_items = new LinkedList();
  
  public final int computeSize()
  {
    int i = 0;
    if (this.priority != -2147483648) {
      i = 0 + ComputeSizeUtil.computeIntegerSize(1, this.priority);
    }
    return i + ComputeSizeUtil.computeListSize(2, 8, this.sub_items);
  }
  
  public final PopularizeAppConfig parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.sub_items.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PopularizeAppConfig paramPopularizeAppConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramPopularizeAppConfig.priority = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      PopularizeSubItem localPopularizeSubItem = new PopularizeSubItem();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localPopularizeSubItem.populateBuilderWithField((InputReader)localObject, localPopularizeSubItem, getNextFieldNumber((InputReader)localObject))) {}
      paramPopularizeAppConfig.sub_items.add(localPopularizeSubItem);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.priority != -2147483648) {
      paramOutputWriter.writeInteger(1, this.priority);
    }
    paramOutputWriter.writeList(2, 8, this.sub_items);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.PopularizeAppConfig
 * JD-Core Version:    0.7.0.1
 */