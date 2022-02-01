package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class MailAttachment
  extends BaseProtoBuf
{
  private static final int fieldNumberAttachment_id_ = 2;
  private static final int fieldNumberBody_structure_helper_ = 14;
  private static final int fieldNumberCid_ = 11;
  private static final int fieldNumberData_ = 9;
  private static final int fieldNumberDisplay_name_ = 7;
  private static final int fieldNumberExchange_file_uid_ = 12;
  private static final int fieldNumberFile_content_type_ = 13;
  private static final int fieldNumberFile_download_size_ = 4;
  private static final int fieldNumberFile_exist_ = 5;
  private static final int fieldNumberFile_name_ = 6;
  private static final int fieldNumberFile_size_ = 3;
  private static final int fieldNumberMailId_ = 1;
  private static final int fieldNumberType_ = 8;
  private static final int fieldNumberUrl_ = 10;
  public long attachment_id_ = -9223372036854775808L;
  public ItemBodyStructureHelper body_structure_helper_;
  public String cid_;
  public ByteString data_;
  public String display_name_;
  public String exchange_file_uid_;
  public String file_content_type_;
  public long file_download_size_ = -9223372036854775808L;
  public int file_exist_ = -2147483648;
  public String file_name_;
  public long file_size_ = -9223372036854775808L;
  public long mailId_ = -9223372036854775808L;
  public String type_;
  public String url_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.mailId_ != -9223372036854775808L) {
      j = 0 + ComputeSizeUtil.computeLongSize(1, this.mailId_);
    }
    int i = j;
    if (this.attachment_id_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.attachment_id_);
    }
    j = i;
    if (this.file_size_ != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(3, this.file_size_);
    }
    i = j;
    if (this.file_download_size_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(4, this.file_download_size_);
    }
    j = i;
    if (this.file_exist_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.file_exist_);
    }
    i = j;
    if (this.file_name_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.file_name_);
    }
    j = i;
    if (this.display_name_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.display_name_);
    }
    i = j;
    if (this.type_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.type_);
    }
    j = i;
    if (this.data_ != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(9, this.data_);
    }
    i = j;
    if (this.url_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.url_);
    }
    j = i;
    if (this.cid_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(11, this.cid_);
    }
    i = j;
    if (this.exchange_file_uid_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.exchange_file_uid_);
    }
    j = i;
    if (this.file_content_type_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(13, this.file_content_type_);
    }
    i = j;
    if (this.body_structure_helper_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(14, this.body_structure_helper_.computeSize());
    }
    return i;
  }
  
  public final MailAttachment parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, MailAttachment paramMailAttachment, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramMailAttachment.mailId_ = paramInputReader.readLong(paramInt);
      return true;
    case 2: 
      paramMailAttachment.attachment_id_ = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramMailAttachment.file_size_ = paramInputReader.readLong(paramInt);
      return true;
    case 4: 
      paramMailAttachment.file_download_size_ = paramInputReader.readLong(paramInt);
      return true;
    case 5: 
      paramMailAttachment.file_exist_ = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramMailAttachment.file_name_ = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramMailAttachment.display_name_ = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramMailAttachment.type_ = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramMailAttachment.data_ = paramInputReader.readByteString(paramInt);
      return true;
    case 10: 
      paramMailAttachment.url_ = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramMailAttachment.cid_ = paramInputReader.readString(paramInt);
      return true;
    case 12: 
      paramMailAttachment.exchange_file_uid_ = paramInputReader.readString(paramInt);
      return true;
    case 13: 
      paramMailAttachment.file_content_type_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      Object localObject = (byte[])paramInputReader.get(paramInt);
      ItemBodyStructureHelper localItemBodyStructureHelper = new ItemBodyStructureHelper();
      localObject = new InputReader((byte[])localObject, unknownTagHandler);
      for (boolean bool = true; bool; bool = localItemBodyStructureHelper.populateBuilderWithField((InputReader)localObject, localItemBodyStructureHelper, getNextFieldNumber((InputReader)localObject))) {}
      paramMailAttachment.body_structure_helper_ = localItemBodyStructureHelper;
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.mailId_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(1, this.mailId_);
    }
    if (this.attachment_id_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.attachment_id_);
    }
    if (this.file_size_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(3, this.file_size_);
    }
    if (this.file_download_size_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(4, this.file_download_size_);
    }
    if (this.file_exist_ != -2147483648) {
      paramOutputWriter.writeInteger(5, this.file_exist_);
    }
    if (this.file_name_ != null) {
      paramOutputWriter.writeString(6, this.file_name_);
    }
    if (this.display_name_ != null) {
      paramOutputWriter.writeString(7, this.display_name_);
    }
    if (this.type_ != null) {
      paramOutputWriter.writeString(8, this.type_);
    }
    if (this.data_ != null) {
      paramOutputWriter.writeByteString(9, this.data_);
    }
    if (this.url_ != null) {
      paramOutputWriter.writeString(10, this.url_);
    }
    if (this.cid_ != null) {
      paramOutputWriter.writeString(11, this.cid_);
    }
    if (this.exchange_file_uid_ != null) {
      paramOutputWriter.writeString(12, this.exchange_file_uid_);
    }
    if (this.file_content_type_ != null) {
      paramOutputWriter.writeString(13, this.file_content_type_);
    }
    if (this.body_structure_helper_ != null)
    {
      paramOutputWriter.writeMessage(14, this.body_structure_helper_.computeSize());
      this.body_structure_helper_.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.MailAttachment
 * JD-Core Version:    0.7.0.1
 */