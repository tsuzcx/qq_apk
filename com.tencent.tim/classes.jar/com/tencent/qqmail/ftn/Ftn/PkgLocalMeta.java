package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class PkgLocalMeta
  extends BaseProtoBuf
{
  private static final int fieldNumberImageIndex = 2;
  private static final int fieldNumberPreviewOutput = 1;
  public ItemRarImageIndex imageIndex;
  public ItemRarPreviewOutput previewOutput;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.previewOutput != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.previewOutput.computeSize());
    }
    int j = i;
    if (this.imageIndex != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.imageIndex.computeSize());
    }
    return j;
  }
  
  public final PkgLocalMeta parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.previewOutput == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, PkgLocalMeta paramPkgLocalMeta, int paramInt)
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
        localObject1 = new ItemRarPreviewOutput();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ItemRarPreviewOutput)localObject1).populateBuilderWithField((InputReader)localObject2, (ItemRarPreviewOutput)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramPkgLocalMeta.previewOutput = ((ItemRarPreviewOutput)localObject1);
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
      localObject1 = new ItemRarImageIndex();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((ItemRarImageIndex)localObject1).populateBuilderWithField((InputReader)localObject2, (ItemRarImageIndex)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramPkgLocalMeta.imageIndex = ((ItemRarImageIndex)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.previewOutput == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    if (this.previewOutput != null)
    {
      paramOutputWriter.writeMessage(1, this.previewOutput.computeSize());
      this.previewOutput.writeFields(paramOutputWriter);
    }
    if (this.imageIndex != null)
    {
      paramOutputWriter.writeMessage(2, this.imageIndex.computeSize());
      this.imageIndex.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.PkgLocalMeta
 * JD-Core Version:    0.7.0.1
 */