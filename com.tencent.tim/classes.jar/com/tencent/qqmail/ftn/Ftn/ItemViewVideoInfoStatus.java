package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ItemViewVideoInfoStatus
  extends BaseProtoBuf
{
  private static final int fieldNumberProgress = 2;
  private static final int fieldNumberRemaintime = 3;
  private static final int fieldNumberStatus = 1;
  public int progress;
  public int remaintime;
  public int status;
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeIntegerSize(1, this.status) + ComputeSizeUtil.computeIntegerSize(2, this.progress) + ComputeSizeUtil.computeIntegerSize(3, this.remaintime);
  }
  
  public final ItemViewVideoInfoStatus parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ItemViewVideoInfoStatus paramItemViewVideoInfoStatus, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramItemViewVideoInfoStatus.status = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramItemViewVideoInfoStatus.progress = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramItemViewVideoInfoStatus.remaintime = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.status);
    paramOutputWriter.writeInteger(2, this.progress);
    paramOutputWriter.writeInteger(3, this.remaintime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.ItemViewVideoInfoStatus
 * JD-Core Version:    0.7.0.1
 */