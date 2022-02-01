package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdLoginRsp
  extends BaseProtoBuf
{
  private static final int fieldNumberDebug_log = 4;
  private static final int fieldNumberLongconn_sig = 5;
  private static final int fieldNumberRate_us = 3;
  private static final int fieldNumberUma_skey = 1;
  private static final int fieldNumberUpdate_info = 2;
  public DebugLogSetting debug_log;
  public LongConnSig longconn_sig;
  public boolean rate_us;
  public ByteString uma_skey;
  public UpdateInfo update_info;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.uma_skey != null) {
      i = 0 + ComputeSizeUtil.computeByteStringSize(1, this.uma_skey);
    }
    int j = i;
    if (this.update_info != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.update_info.computeSize());
    }
    j += ComputeSizeUtil.computeBooleanSize(3, this.rate_us);
    i = j;
    if (this.debug_log != null) {
      i = j + ComputeSizeUtil.computeMessageSize(4, this.debug_log.computeSize());
    }
    j = i;
    if (this.longconn_sig != null) {
      j = i + ComputeSizeUtil.computeMessageSize(5, this.longconn_sig.computeSize());
    }
    return j;
  }
  
  public final CmdLoginRsp parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdLoginRsp paramCmdLoginRsp, int paramInt)
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
      paramCmdLoginRsp.uma_skey = paramInputReader.readByteString(paramInt);
      return true;
    case 2: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new UpdateInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((UpdateInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (UpdateInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCmdLoginRsp.update_info = ((UpdateInfo)localObject1);
        paramInt += 1;
      }
      return true;
    case 3: 
      paramCmdLoginRsp.rate_us = paramInputReader.readBoolean(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new DebugLogSetting();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((DebugLogSetting)localObject1).populateBuilderWithField((InputReader)localObject2, (DebugLogSetting)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCmdLoginRsp.debug_log = ((DebugLogSetting)localObject1);
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
      localObject1 = new LongConnSig();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((LongConnSig)localObject1).populateBuilderWithField((InputReader)localObject2, (LongConnSig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramCmdLoginRsp.longconn_sig = ((LongConnSig)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.uma_skey != null) {
      paramOutputWriter.writeByteString(1, this.uma_skey);
    }
    if (this.update_info != null)
    {
      paramOutputWriter.writeMessage(2, this.update_info.computeSize());
      this.update_info.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeBoolean(3, this.rate_us);
    if (this.debug_log != null)
    {
      paramOutputWriter.writeMessage(4, this.debug_log.computeSize());
      this.debug_log.writeFields(paramOutputWriter);
    }
    if (this.longconn_sig != null)
    {
      paramOutputWriter.writeMessage(5, this.longconn_sig.computeSize());
      this.longconn_sig.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdLoginRsp
 * JD-Core Version:    0.7.0.1
 */