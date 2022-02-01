package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeIdentity
  extends BaseProtoBuf
{
  private static final int fieldNumberChange_key_ = 2;
  private static final int fieldNumberFolder_id_ = 3;
  private static final int fieldNumberId_ = 1;
  private static final int fieldNumberItem_manager_id_ = 5;
  private static final int fieldNumberTitle_ = 6;
  private static final int fieldNumberType_ = 4;
  public String change_key_;
  public String folder_id_;
  public String id_;
  public long item_manager_id_ = -9223372036854775808L;
  public String title_;
  public int type_ = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.id_ != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.id_);
    }
    int i = j;
    if (this.change_key_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.change_key_);
    }
    j = i;
    if (this.folder_id_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.folder_id_);
    }
    i = j;
    if (this.type_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.type_);
    }
    j = i;
    if (this.item_manager_id_ != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(5, this.item_manager_id_);
    }
    i = j;
    if (this.title_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.title_);
    }
    return i;
  }
  
  public final ExchangeIdentity parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeIdentity paramExchangeIdentity, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramExchangeIdentity.id_ = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramExchangeIdentity.change_key_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramExchangeIdentity.folder_id_ = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramExchangeIdentity.type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramExchangeIdentity.item_manager_id_ = paramInputReader.readLong(paramInt);
      return true;
    }
    paramExchangeIdentity.title_ = paramInputReader.readString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.id_ != null) {
      paramOutputWriter.writeString(1, this.id_);
    }
    if (this.change_key_ != null) {
      paramOutputWriter.writeString(2, this.change_key_);
    }
    if (this.folder_id_ != null) {
      paramOutputWriter.writeString(3, this.folder_id_);
    }
    if (this.type_ != -2147483648) {
      paramOutputWriter.writeInteger(4, this.type_);
    }
    if (this.item_manager_id_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(5, this.item_manager_id_);
    }
    if (this.title_ != null) {
      paramOutputWriter.writeString(6, this.title_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeIdentity
 * JD-Core Version:    0.7.0.1
 */