package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdAddAccountReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_info = 1;
  private static final int fieldNumberVerify_code = 2;
  public EmailAccountInfo account_info;
  public VerifyCodeAnswer verify_code;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.account_info != null) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.account_info.computeSize());
    }
    int j = i;
    if (this.verify_code != null) {
      j = i + ComputeSizeUtil.computeMessageSize(2, this.verify_code.computeSize());
    }
    return j;
  }
  
  public final CmdAddAccountReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdAddAccountReq paramCmdAddAccountReq, int paramInt)
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
        localObject1 = new EmailAccountInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((EmailAccountInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (EmailAccountInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramCmdAddAccountReq.account_info = ((EmailAccountInfo)localObject1);
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
      localObject1 = new VerifyCodeAnswer();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((VerifyCodeAnswer)localObject1).populateBuilderWithField((InputReader)localObject2, (VerifyCodeAnswer)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramCmdAddAccountReq.verify_code = ((VerifyCodeAnswer)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_info != null)
    {
      paramOutputWriter.writeMessage(1, this.account_info.computeSize());
      this.account_info.writeFields(paramOutputWriter);
    }
    if (this.verify_code != null)
    {
      paramOutputWriter.writeMessage(2, this.verify_code.computeSize());
      this.verify_code.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdAddAccountReq
 * JD-Core Version:    0.7.0.1
 */