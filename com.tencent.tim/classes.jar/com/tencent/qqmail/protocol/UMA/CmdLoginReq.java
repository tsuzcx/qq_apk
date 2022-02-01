package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdLoginReq
  extends BaseProtoBuf
{
  private static final int fieldNumberDevice_id = 4;
  private static final int fieldNumberDevice_info = 8;
  private static final int fieldNumberIos_realtoken = 7;
  private static final int fieldNumberIos_token = 5;
  private static final int fieldNumberRsp_key = 3;
  private static final int fieldNumberUma_id = 1;
  private static final int fieldNumberUma_psw_md5sum = 2;
  private static final int fieldNumberVerify_code = 6;
  public String device_id;
  public ByteString device_info;
  public ByteString ios_realtoken;
  public ByteString ios_token;
  public ByteString rsp_key;
  public long uma_id = -9223372036854775808L;
  public ByteString uma_psw_md5sum;
  public VerifyCodeAnswer verify_code;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.uma_id != -9223372036854775808L) {
      j = 0 + ComputeSizeUtil.computeLongSize(1, this.uma_id);
    }
    int i = j;
    if (this.uma_psw_md5sum != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(2, this.uma_psw_md5sum);
    }
    j = i;
    if (this.rsp_key != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(3, this.rsp_key);
    }
    i = j;
    if (this.device_id != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.device_id);
    }
    j = i;
    if (this.ios_token != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(5, this.ios_token);
    }
    i = j;
    if (this.verify_code != null) {
      i = j + ComputeSizeUtil.computeMessageSize(6, this.verify_code.computeSize());
    }
    j = i;
    if (this.ios_realtoken != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(7, this.ios_realtoken);
    }
    i = j;
    if (this.device_info != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(8, this.device_info);
    }
    return i;
  }
  
  public final CmdLoginReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdLoginReq paramCmdLoginReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdLoginReq.uma_id = paramInputReader.readLong(paramInt);
      return true;
    case 2: 
      paramCmdLoginReq.uma_psw_md5sum = paramInputReader.readByteString(paramInt);
      return true;
    case 3: 
      paramCmdLoginReq.rsp_key = paramInputReader.readByteString(paramInt);
      return true;
    case 4: 
      paramCmdLoginReq.device_id = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramCmdLoginReq.ios_token = paramInputReader.readByteString(paramInt);
      return true;
    case 6: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      int i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        Object localObject = (byte[])paramInputReader.get(paramInt);
        VerifyCodeAnswer localVerifyCodeAnswer = new VerifyCodeAnswer();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localVerifyCodeAnswer.populateBuilderWithField((InputReader)localObject, localVerifyCodeAnswer, getNextFieldNumber((InputReader)localObject))) {}
        paramCmdLoginReq.verify_code = localVerifyCodeAnswer;
        paramInt += 1;
      }
      return true;
    case 7: 
      paramCmdLoginReq.ios_realtoken = paramInputReader.readByteString(paramInt);
      return true;
    }
    paramCmdLoginReq.device_info = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.uma_id != -9223372036854775808L) {
      paramOutputWriter.writeLong(1, this.uma_id);
    }
    if (this.uma_psw_md5sum != null) {
      paramOutputWriter.writeByteString(2, this.uma_psw_md5sum);
    }
    if (this.rsp_key != null) {
      paramOutputWriter.writeByteString(3, this.rsp_key);
    }
    if (this.device_id != null) {
      paramOutputWriter.writeString(4, this.device_id);
    }
    if (this.ios_token != null) {
      paramOutputWriter.writeByteString(5, this.ios_token);
    }
    if (this.verify_code != null)
    {
      paramOutputWriter.writeMessage(6, this.verify_code.computeSize());
      this.verify_code.writeFields(paramOutputWriter);
    }
    if (this.ios_realtoken != null) {
      paramOutputWriter.writeByteString(7, this.ios_realtoken);
    }
    if (this.device_info != null) {
      paramOutputWriter.writeByteString(8, this.device_info);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdLoginReq
 * JD-Core Version:    0.7.0.1
 */