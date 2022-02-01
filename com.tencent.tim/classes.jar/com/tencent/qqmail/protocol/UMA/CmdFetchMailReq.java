package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdFetchMailReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 1;
  private static final int fieldNumberMail_url = 2;
  private static final int fieldNumberMime_section = 3;
  private static final int fieldNumberPart_len = 5;
  private static final int fieldNumberPart_pos = 4;
  public int account_id = -2147483648;
  public String mail_url;
  public String mime_section;
  public int part_len = -2147483648;
  public int part_pos = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.account_id != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.account_id);
    }
    int i = j;
    if (this.mail_url != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.mail_url);
    }
    j = i;
    if (this.mime_section != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.mime_section);
    }
    i = j;
    if (this.part_pos != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.part_pos);
    }
    j = i;
    if (this.part_len != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.part_len);
    }
    return j;
  }
  
  public final CmdFetchMailReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdFetchMailReq paramCmdFetchMailReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdFetchMailReq.account_id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCmdFetchMailReq.mail_url = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramCmdFetchMailReq.mime_section = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramCmdFetchMailReq.part_pos = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdFetchMailReq.part_len = paramInputReader.readInteger(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.account_id != -2147483648) {
      paramOutputWriter.writeInteger(1, this.account_id);
    }
    if (this.mail_url != null) {
      paramOutputWriter.writeString(2, this.mail_url);
    }
    if (this.mime_section != null) {
      paramOutputWriter.writeString(3, this.mime_section);
    }
    if (this.part_pos != -2147483648) {
      paramOutputWriter.writeInteger(4, this.part_pos);
    }
    if (this.part_len != -2147483648) {
      paramOutputWriter.writeInteger(5, this.part_len);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdFetchMailReq
 * JD-Core Version:    0.7.0.1
 */