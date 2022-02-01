package com.tencent.qqmail.ftn.Ftn;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class CGIOutputHeader
  extends BaseProtoBuf
{
  private static final int fieldNumberRetcode = 2;
  private static final int fieldNumberUin = 1;
  private static final int fieldNumberUpdatetime = 3;
  public int retcode;
  public int uin;
  public int updatetime;
  
  public final int computeSize()
  {
    return 0 + ComputeSizeUtil.computeIntegerSize(1, this.uin) + ComputeSizeUtil.computeIntegerSize(2, this.retcode) + ComputeSizeUtil.computeIntegerSize(3, this.updatetime);
  }
  
  public final CGIOutputHeader parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CGIOutputHeader paramCGIOutputHeader, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCGIOutputHeader.uin = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCGIOutputHeader.retcode = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCGIOutputHeader.updatetime = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.uin);
    paramOutputWriter.writeInteger(2, this.retcode);
    paramOutputWriter.writeInteger(3, this.updatetime);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.ftn.Ftn.CGIOutputHeader
 * JD-Core Version:    0.7.0.1
 */