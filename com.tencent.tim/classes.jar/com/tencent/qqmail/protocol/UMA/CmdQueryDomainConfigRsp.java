package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryDomainConfigRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberAvailable = 2;
  private static final int fieldNumberConfig = 1;
  public boolean available;
  public DomainConfig config;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.config != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.config.computeSize());
    }
    return i + ComputeSizeUtil.computeBooleanSize(2, this.available);
  }
  
  public final CmdQueryDomainConfigRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryDomainConfigRsp paramCmdQueryDomainConfigRsp, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        DomainConfig localDomainConfig = new DomainConfig();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localDomainConfig.populateBuilderWithField((InputReader)localObject, localDomainConfig, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdQueryDomainConfigRsp.config = localDomainConfig;
        paramInt += 1;
      }
      return true;
    }
    paramCmdQueryDomainConfigRsp.available = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.config != null)
    {
      paramOutputWriter.writeMessage(1, this.config.computeSize());
      this.config.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeBoolean(2, this.available);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryDomainConfigRsp
 * JD-Core Version:    0.7.0.1
 */