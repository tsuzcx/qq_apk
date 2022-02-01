package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class DownloadUrlListOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberDownloadUrlListOutput = 1;
  public LinkedList<ItemGetDownloadUrlOutput> downloadUrlListOutput = new LinkedList();
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeListSize(1, 8, this.downloadUrlListOutput);
  }
  
  public final DownloadUrlListOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.downloadUrlListOutput.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, DownloadUrlListOutput paramDownloadUrlListOutput, int paramInt)
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
      ItemGetDownloadUrlOutput localItemGetDownloadUrlOutput = new ItemGetDownloadUrlOutput();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localItemGetDownloadUrlOutput.populateBuilderWithField((InputReader)localObject, localItemGetDownloadUrlOutput, getNextFieldNumber((InputReader)localObject))) {}
      paramDownloadUrlListOutput.downloadUrlListOutput.add(localItemGetDownloadUrlOutput);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.downloadUrlListOutput);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.DownloadUrlListOutput
 * JD-Core Version:    0.7.0.1
 */