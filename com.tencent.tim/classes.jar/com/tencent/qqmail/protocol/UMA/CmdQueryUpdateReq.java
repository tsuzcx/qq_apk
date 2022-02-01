package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdQueryUpdateReq
  extends BaseProtoBuf
{
  private static final int fieldNumberDevice_id = 1;
  private static final int fieldNumberRsp_key = 2;
  private static final int fieldNumberUser_triggered = 4;
  private static final int fieldNumberVerify_code = 3;
  public String device_id;
  public ByteString rsp_key;
  public boolean user_triggered;
  public VerifyCodeAnswer verify_code;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.device_id != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.device_id);
    }
    int i = j;
    if (this.rsp_key != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.rsp_key);
    }
    j = i;
    if (this.verify_code != null) {
      j = i + ComputeSizeUtil.computeMessageSize(3, this.verify_code.computeSize());
    }
    return j + ComputeSizeUtil.computeBooleanSize(4, this.user_triggered);
  }
  
  public final CmdQueryUpdateReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdQueryUpdateReq paramCmdQueryUpdateReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdQueryUpdateReq.device_id = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramCmdQueryUpdateReq.rsp_key = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        VerifyCodeAnswer localVerifyCodeAnswer = new VerifyCodeAnswer();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localVerifyCodeAnswer.populateBuilderWithField((InputReader)localObject, localVerifyCodeAnswer, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdQueryUpdateReq.verify_code = localVerifyCodeAnswer;
        paramInt += 1;
      }
      return true;
    }
    paramCmdQueryUpdateReq.user_triggered = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.device_id != null) {
      paramOutputWriter.writeString(1, this.device_id);
    }
    if (this.rsp_key != null) {
      paramOutputWriter.writeByteString(2, this.rsp_key);
    }
    if (this.verify_code != null)
    {
      paramOutputWriter.writeMessage(3, this.verify_code.computeSize());
      this.verify_code.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeBoolean(4, this.user_triggered);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdQueryUpdateReq
 * JD-Core Version:    0.7.0.1
 */