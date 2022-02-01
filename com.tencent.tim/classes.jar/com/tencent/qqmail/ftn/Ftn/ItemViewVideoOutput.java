package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewVideoOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberInfo = 1;
  private static final int fieldNumberStatus = 2;
  public ItemViewVideoInfo info;
  public ItemViewVideoInfoStatus status;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.info != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.info.computeSize());
    }
    int j = i;
    if (this.status != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.status.computeSize());
    }
    return j;
  }
  
  public final ItemViewVideoOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if ((this.info == null) || (this.status == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewVideoOutput paramItemViewVideoOutput, int paramInt)
    throws IOException
  {
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ItemViewVideoInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ItemViewVideoInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (ItemViewVideoInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramItemViewVideoOutput.info = ((ItemViewVideoInfo)localObject1);
        paramInt += 1;
      }
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = (byte[])paramInputReader.get(paramInt);
      localObject1 = new ItemViewVideoInfoStatus();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((ItemViewVideoInfoStatus)localObject1).populateBuilderWithField((InputReader)localObject2, (ItemViewVideoInfoStatus)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramItemViewVideoOutput.status = ((ItemViewVideoInfoStatus)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if ((this.info == null) || (this.status == null)) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.info != null)
    {
      paramOutputWriter.writeMessage(1, this.info.computeSize());
      this.info.writeFields(paramOutputWriter);
    }
    if (this.status != null)
    {
      paramOutputWriter.writeMessage(2, this.status.computeSize());
      this.status.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewVideoOutput
 * JD-Core Version:    0.7.0.1
 */