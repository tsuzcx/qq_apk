package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class MailItemBodyStructureInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAttachId_ = 2;
  private static final int fieldNumberBody_id_ = 6;
  private static final int fieldNumberContent_description_ = 10;
  private static final int fieldNumberContent_disposition_ = 13;
  private static final int fieldNumberContent_line_size_ = 12;
  private static final int fieldNumberContent_subtype_ = 8;
  private static final int fieldNumberContent_transfer_encoding_ = 11;
  private static final int fieldNumberContent_type_ = 7;
  private static final int fieldNumberContent_type_params_ = 9;
  private static final int fieldNumberId_ = 3;
  private static final int fieldNumberItem_type_ = 5;
  private static final int fieldNumberItemid_ = 4;
  private static final int fieldNumberMailId_ = 1;
  public long attachId_ = -9223372036854775808L;
  public String body_id_;
  public String content_description_;
  public String content_disposition_;
  public String content_line_size_;
  public String content_subtype_;
  public String content_transfer_encoding_;
  public String content_type_;
  public String content_type_params_;
  public long id_ = -9223372036854775808L;
  public String item_type_;
  public long itemid_ = -9223372036854775808L;
  public long mailId_ = -9223372036854775808L;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.mailId_ != -9223372036854775808L) {
      j = 0 + ComputeSizeUtil.computeLongSize(1, this.mailId_);
    }
    int i = j;
    if (this.attachId_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(2, this.attachId_);
    }
    j = i;
    if (this.id_ != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(3, this.id_);
    }
    i = j;
    if (this.itemid_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(4, this.itemid_);
    }
    j = i;
    if (this.item_type_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.item_type_);
    }
    i = j;
    if (this.body_id_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.body_id_);
    }
    j = i;
    if (this.content_type_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.content_type_);
    }
    i = j;
    if (this.content_subtype_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.content_subtype_);
    }
    j = i;
    if (this.content_type_params_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(9, this.content_type_params_);
    }
    i = j;
    if (this.content_description_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.content_description_);
    }
    j = i;
    if (this.content_transfer_encoding_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(11, this.content_transfer_encoding_);
    }
    i = j;
    if (this.content_line_size_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.content_line_size_);
    }
    j = i;
    if (this.content_disposition_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(13, this.content_disposition_);
    }
    return j;
  }
  
  public final MailItemBodyStructureInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, MailItemBodyStructureInfo paramMailItemBodyStructureInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramMailItemBodyStructureInfo.mailId_ = paramInputReader.readLong(paramInt);
      return true;
    case 2: 
      paramMailItemBodyStructureInfo.attachId_ = paramInputReader.readLong(paramInt);
      return true;
    case 3: 
      paramMailItemBodyStructureInfo.id_ = paramInputReader.readLong(paramInt);
      return true;
    case 4: 
      paramMailItemBodyStructureInfo.itemid_ = paramInputReader.readLong(paramInt);
      return true;
    case 5: 
      paramMailItemBodyStructureInfo.item_type_ = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramMailItemBodyStructureInfo.body_id_ = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramMailItemBodyStructureInfo.content_type_ = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramMailItemBodyStructureInfo.content_subtype_ = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramMailItemBodyStructureInfo.content_type_params_ = paramInputReader.readString(paramInt);
      return true;
    case 10: 
      paramMailItemBodyStructureInfo.content_description_ = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramMailItemBodyStructureInfo.content_transfer_encoding_ = paramInputReader.readString(paramInt);
      return true;
    case 12: 
      paramMailItemBodyStructureInfo.content_line_size_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramMailItemBodyStructureInfo.content_disposition_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.mailId_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(1, this.mailId_);
    }
    if (this.attachId_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(2, this.attachId_);
    }
    if (this.id_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(3, this.id_);
    }
    if (this.itemid_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(4, this.itemid_);
    }
    if (this.item_type_ != null) {
      paramOutputWriter.writeString(5, this.item_type_);
    }
    if (this.body_id_ != null) {
      paramOutputWriter.writeString(6, this.body_id_);
    }
    if (this.content_type_ != null) {
      paramOutputWriter.writeString(7, this.content_type_);
    }
    if (this.content_subtype_ != null) {
      paramOutputWriter.writeString(8, this.content_subtype_);
    }
    if (this.content_type_params_ != null) {
      paramOutputWriter.writeString(9, this.content_type_params_);
    }
    if (this.content_description_ != null) {
      paramOutputWriter.writeString(10, this.content_description_);
    }
    if (this.content_transfer_encoding_ != null) {
      paramOutputWriter.writeString(11, this.content_transfer_encoding_);
    }
    if (this.content_line_size_ != null) {
      paramOutputWriter.writeString(12, this.content_line_size_);
    }
    if (this.content_disposition_ != null) {
      paramOutputWriter.writeString(13, this.content_disposition_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.MailItemBodyStructureInfo
 * JD-Core Version:    0.7.0.1
 */