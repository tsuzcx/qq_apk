package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemRarPreviewOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberFileList = 1;
  private static final int fieldNumberInfo = 2;
  public LinkedList<File> fileList = new LinkedList();
  public ItemRarDownloadInfo info;
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 8, this.fileList);
    int i = j;
    if (this.info != null) {
      i = j + ComputeSizeUtil.computeMessageSize(2, this.info.computeSize());
    }
    return i;
  }
  
  public final ItemRarPreviewOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.fileList.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    if (this.info == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemRarPreviewOutput paramItemRarPreviewOutput, int paramInt)
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
        localObject1 = new File();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((File)localObject1).populateBuilderWithField((InputReader)localObject2, (File)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramItemRarPreviewOutput.fileList.add(localObject1);
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
      localObject1 = new ItemRarDownloadInfo();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((ItemRarDownloadInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (ItemRarDownloadInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramItemRarPreviewOutput.info = ((ItemRarDownloadInfo)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.info == null) {
      throw new UninitializedMessageException("Not all required fields were included");
    }
    paramOutputWriter.writeList(1, 8, this.fileList);
    if (this.info != null)
    {
      paramOutputWriter.writeMessage(2, this.info.computeSize());
      this.info.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemRarPreviewOutput
 * JD-Core Version:    0.7.0.1
 */