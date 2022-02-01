package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.UninitializedMessageException;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class RarExchangeOutput
  extends BaseProtoBuf
{
  private static final int fieldNumberInfo = 1;
  public ItemRarDownloadInfo info;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.info != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.info.computeSize());
    }
    return i;
  }
  
  public final RarExchangeOutput parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, RarExchangeOutput paramRarExchangeOutput, int paramInt)
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
      ItemRarDownloadInfo localItemRarDownloadInfo = new ItemRarDownloadInfo();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localItemRarDownloadInfo.populateBuilderWithField((InputReader)localObject, localItemRarDownloadInfo, getNextFieldNumber((InputReader)localObject))) {}
      paramRarExchangeOutput.info = localItemRarDownloadInfo;
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
    if (this.info != null)
    {
      paramOutputWriter.writeMessage(1, this.info.computeSize());
      this.info.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.RarExchangeOutput
 * JD-Core Version:    0.7.0.1
 */