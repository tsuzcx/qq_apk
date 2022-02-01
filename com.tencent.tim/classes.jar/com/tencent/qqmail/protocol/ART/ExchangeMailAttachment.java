package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeMailAttachment
  extends BaseProtoBuf
{
  private static final int fieldNumberBase64_ = 11;
  private static final int fieldNumberContent_ = 4;
  private static final int fieldNumberContent_id_ = 3;
  private static final int fieldNumberContent_location_ = 5;
  private static final int fieldNumberContent_type_ = 6;
  private static final int fieldNumberFilename_ = 2;
  private static final int fieldNumberFilepath_ = 12;
  private static final int fieldNumberIdentity_ = 1;
  private static final int fieldNumberIsInline_ = 8;
  private static final int fieldNumberIsSuccessDownload_ = 9;
  private static final int fieldNumberSize_ = 7;
  private static final int fieldNumberType_ = 10;
  public boolean base64_;
  public ByteString content_;
  public String content_id_;
  public String content_location_;
  public String content_type_;
  public String filename_;
  public String filepath_;
  public ExchangeIdentity identity_;
  public boolean isInline_;
  public boolean isSuccessDownload_;
  public int size_ = -2147483648;
  public int type_ = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.identity_ != null) {
      j = 0 + ComputeSizeUtil.computeMessageSize(1, this.identity_.computeSize());
    }
    int i = j;
    if (this.filename_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.filename_);
    }
    j = i;
    if (this.content_id_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.content_id_);
    }
    i = j;
    if (this.content_ != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(4, this.content_);
    }
    j = i;
    if (this.content_location_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.content_location_);
    }
    i = j;
    if (this.content_type_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.content_type_);
    }
    j = i;
    if (this.size_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(7, this.size_);
    }
    j = j + ComputeSizeUtil.computeBooleanSize(8, this.isInline_) + ComputeSizeUtil.computeBooleanSize(9, this.isSuccessDownload_);
    i = j;
    if (this.type_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(10, this.type_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(11, this.base64_);
    i = j;
    if (this.filepath_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.filepath_);
    }
    return i;
  }
  
  public final ExchangeMailAttachment parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeMailAttachment paramExchangeMailAttachment, int paramInt)
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
        ExchangeIdentity localExchangeIdentity = new ExchangeIdentity();
        localObject = new InputReader((byte[])localObject, unknownTagHandler);
        for (boolean bool = true; bool; bool = localExchangeIdentity.populateBuilderWithField((InputReader)localObject, localExchangeIdentity, getNextFieldNumber((InputReader)localObject))) {}
        paramExchangeMailAttachment.identity_ = localExchangeIdentity;
        paramInt += 1;
      }
      return true;
    case 2: 
      paramExchangeMailAttachment.filename_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramExchangeMailAttachment.content_id_ = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramExchangeMailAttachment.content_ = paramInputReader.readByteString(paramInt);
      return true;
    case 5: 
      paramExchangeMailAttachment.content_location_ = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramExchangeMailAttachment.content_type_ = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramExchangeMailAttachment.size_ = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramExchangeMailAttachment.isInline_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 9: 
      paramExchangeMailAttachment.isSuccessDownload_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 10: 
      paramExchangeMailAttachment.type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 11: 
      paramExchangeMailAttachment.base64_ = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramExchangeMailAttachment.filepath_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.identity_ != null)
    {
      paramOutputWriter.writeMessage(1, this.identity_.computeSize());
      this.identity_.writeFields(paramOutputWriter);
    }
    if (this.filename_ != null) {
      paramOutputWriter.writeString(2, this.filename_);
    }
    if (this.content_id_ != null) {
      paramOutputWriter.writeString(3, this.content_id_);
    }
    if (this.content_ != null) {
      paramOutputWriter.writeByteString(4, this.content_);
    }
    if (this.content_location_ != null) {
      paramOutputWriter.writeString(5, this.content_location_);
    }
    if (this.content_type_ != null) {
      paramOutputWriter.writeString(6, this.content_type_);
    }
    if (this.size_ != -2147483648) {
      paramOutputWriter.writeInteger(7, this.size_);
    }
    paramOutputWriter.writeBoolean(8, this.isInline_);
    paramOutputWriter.writeBoolean(9, this.isSuccessDownload_);
    if (this.type_ != -2147483648) {
      paramOutputWriter.writeInteger(10, this.type_);
    }
    paramOutputWriter.writeBoolean(11, this.base64_);
    if (this.filepath_ != null) {
      paramOutputWriter.writeString(12, this.filepath_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeMailAttachment
 * JD-Core Version:    0.7.0.1
 */