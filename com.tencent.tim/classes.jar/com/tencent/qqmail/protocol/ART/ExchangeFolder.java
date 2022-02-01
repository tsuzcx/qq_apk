package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeFolder
  extends BaseProtoBuf
{
  private static final int fieldNumberChildren_folder_count_ = 9;
  private static final int fieldNumberFolder_type_ = 7;
  private static final int fieldNumberIdentity_ = 1;
  private static final int fieldNumberLocal_folder_id_ = 8;
  private static final int fieldNumberMail_total_count_ = 5;
  private static final int fieldNumberName_ = 2;
  private static final int fieldNumberParent_id_ = 3;
  private static final int fieldNumberSize_ = 6;
  private static final int fieldNumberSync_state_ = 4;
  private static final int fieldNumberUnread_count_ = 10;
  public int children_folder_count_ = -2147483648;
  public int folder_type_ = -2147483648;
  public ExchangeIdentity identity_;
  public int local_folder_id_ = -2147483648;
  public int mail_total_count_ = -2147483648;
  public String name_;
  public String parent_id_;
  public String size_;
  public String sync_state_;
  public int unread_count_ = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.identity_ != null) {
      j = 0 + ComputeSizeUtil.computeMessageSize(1, this.identity_.computeSize());
    }
    int i = j;
    if (this.name_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.name_);
    }
    j = i;
    if (this.parent_id_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(3, this.parent_id_);
    }
    i = j;
    if (this.sync_state_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.sync_state_);
    }
    j = i;
    if (this.mail_total_count_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(5, this.mail_total_count_);
    }
    i = j;
    if (this.size_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.size_);
    }
    j = i;
    if (this.folder_type_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(7, this.folder_type_);
    }
    i = j;
    if (this.local_folder_id_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(8, this.local_folder_id_);
    }
    j = i;
    if (this.children_folder_count_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(9, this.children_folder_count_);
    }
    i = j;
    if (this.unread_count_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(10, this.unread_count_);
    }
    return i;
  }
  
  public final ExchangeFolder parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeFolder paramExchangeFolder, int paramInt)
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
        paramExchangeFolder.identity_ = localExchangeIdentity;
        paramInt += 1;
      }
      return true;
    case 2: 
      paramExchangeFolder.name_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramExchangeFolder.parent_id_ = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramExchangeFolder.sync_state_ = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramExchangeFolder.mail_total_count_ = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramExchangeFolder.size_ = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramExchangeFolder.folder_type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 8: 
      paramExchangeFolder.local_folder_id_ = paramInputReader.readInteger(paramInt);
      return true;
    case 9: 
      paramExchangeFolder.children_folder_count_ = paramInputReader.readInteger(paramInt);
      return true;
    }
    paramExchangeFolder.unread_count_ = paramInputReader.readInteger(paramInt);
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
    if (this.name_ != null) {
      paramOutputWriter.writeString(2, this.name_);
    }
    if (this.parent_id_ != null) {
      paramOutputWriter.writeString(3, this.parent_id_);
    }
    if (this.sync_state_ != null) {
      paramOutputWriter.writeString(4, this.sync_state_);
    }
    if (this.mail_total_count_ != -2147483648) {
      paramOutputWriter.writeInteger(5, this.mail_total_count_);
    }
    if (this.size_ != null) {
      paramOutputWriter.writeString(6, this.size_);
    }
    if (this.folder_type_ != -2147483648) {
      paramOutputWriter.writeInteger(7, this.folder_type_);
    }
    if (this.local_folder_id_ != -2147483648) {
      paramOutputWriter.writeInteger(8, this.local_folder_id_);
    }
    if (this.children_folder_count_ != -2147483648) {
      paramOutputWriter.writeInteger(9, this.children_folder_count_);
    }
    if (this.unread_count_ != -2147483648) {
      paramOutputWriter.writeInteger(10, this.unread_count_);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeFolder
 * JD-Core Version:    0.7.0.1
 */