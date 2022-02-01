package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class CmdGetThumbnailReq
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount_id = 1;
  private static final int fieldNumberHeight_limit = 6;
  private static final int fieldNumberMail_url = 2;
  private static final int fieldNumberMime_section = 3;
  private static final int fieldNumberThumb_len = 9;
  private static final int fieldNumberThumb_pos = 8;
  private static final int fieldNumberThumb_rule = 7;
  private static final int fieldNumberThumb_type = 4;
  private static final int fieldNumberWidth_limit = 5;
  public int account_id = -2147483648;
  public int height_limit = -2147483648;
  public String mail_url;
  public String mime_section;
  public int thumb_len = -2147483648;
  public int thumb_pos = -2147483648;
  public int thumb_rule;
  public String thumb_type;
  public int width_limit = -2147483648;
  
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
    if (this.thumb_type != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.thumb_type);
    }
    j = i;
    if (this.width_limit != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.width_limit);
    }
    i = j;
    if (this.height_limit != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.height_limit);
    }
    j = i + ComputeSizeUtil.computeIntegerSize(7, this.thumb_rule);
    i = j;
    if (this.thumb_pos != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(8, this.thumb_pos);
    }
    j = i;
    if (this.thumb_len != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(9, this.thumb_len);
    }
    return j;
  }
  
  public final CmdGetThumbnailReq parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, CmdGetThumbnailReq paramCmdGetThumbnailReq, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramCmdGetThumbnailReq.account_id = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramCmdGetThumbnailReq.mail_url = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramCmdGetThumbnailReq.mime_section = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramCmdGetThumbnailReq.thumb_type = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramCmdGetThumbnailReq.width_limit = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramCmdGetThumbnailReq.height_limit = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramCmdGetThumbnailReq.thumb_rule = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramCmdGetThumbnailReq.thumb_pos = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramCmdGetThumbnailReq.thumb_len = paramInputReader.readInteger(paramInt);
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
    if (this.thumb_type != null) {
      paramOutputWriter.writeString(4, this.thumb_type);
    }
    if (this.width_limit != -2147483648) {
      paramOutputWriter.writeInteger(5, this.width_limit);
    }
    if (this.height_limit != -2147483648) {
      paramOutputWriter.writeInteger(6, this.height_limit);
    }
    paramOutputWriter.writeInteger(7, this.thumb_rule);
    if (this.thumb_pos != -2147483648) {
      paramOutputWriter.writeInteger(8, this.thumb_pos);
    }
    if (this.thumb_len != -2147483648) {
      paramOutputWriter.writeInteger(9, this.thumb_len);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.CmdGetThumbnailReq
 * JD-Core Version:    0.7.0.1
 */