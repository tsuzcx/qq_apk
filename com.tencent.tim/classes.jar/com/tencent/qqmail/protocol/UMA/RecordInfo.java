package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class RecordInfo
  extends BaseProtoBuf
{
  private static final int fieldNumberAddress = 6;
  private static final int fieldNumberConversation_id = 4;
  private static final int fieldNumberConversation_time = 5;
  private static final int fieldNumberFriend_address = 8;
  private static final int fieldNumberFriend_avatar = 10;
  private static final int fieldNumberFriend_name = 9;
  private static final int fieldNumberIsdeleted = 13;
  private static final int fieldNumberMail_id = 12;
  private static final int fieldNumberMail_subject = 11;
  private static final int fieldNumberName = 7;
  private static final int fieldNumberRecord_id = 1;
  private static final int fieldNumberRecord_type = 2;
  private static final int fieldNumberStart_time = 3;
  public String address;
  public String conversation_id;
  public double conversation_time = 4.9E-324D;
  public String friend_address;
  public String friend_avatar;
  public String friend_name;
  public boolean isdeleted;
  public String mail_id;
  public String mail_subject;
  public String name;
  public String record_id;
  public int record_type = -2147483648;
  public double start_time = 4.9E-324D;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.record_id != null) {
      j = 0 + ComputeSizeUtil.computeStringSize(1, this.record_id);
    }
    int i = j;
    if (this.record_type != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(2, this.record_type);
    }
    j = i;
    if (this.start_time != 4.9E-324D) {
      j = i + ComputeSizeUtil.computeDoubleSize(3, this.start_time);
    }
    i = j;
    if (this.conversation_id != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.conversation_id);
    }
    j = i;
    if (this.conversation_time != 4.9E-324D) {
      j = i + ComputeSizeUtil.computeDoubleSize(5, this.conversation_time);
    }
    i = j;
    if (this.address != null) {
      i = j + ComputeSizeUtil.computeStringSize(6, this.address);
    }
    j = i;
    if (this.name != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.name);
    }
    i = j;
    if (this.friend_address != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.friend_address);
    }
    j = i;
    if (this.friend_name != null) {
      j = i + ComputeSizeUtil.computeStringSize(9, this.friend_name);
    }
    i = j;
    if (this.friend_avatar != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.friend_avatar);
    }
    j = i;
    if (this.mail_subject != null) {
      j = i + ComputeSizeUtil.computeStringSize(11, this.mail_subject);
    }
    i = j;
    if (this.mail_id != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.mail_id);
    }
    return i + ComputeSizeUtil.computeBooleanSize(13, this.isdeleted);
  }
  
  public final RecordInfo parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, RecordInfo paramRecordInfo, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramRecordInfo.record_id = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramRecordInfo.record_type = paramInputReader.readInteger(paramInt);
      return true;
    case 3: 
      paramRecordInfo.start_time = paramInputReader.readDouble(paramInt);
      return true;
    case 4: 
      paramRecordInfo.conversation_id = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramRecordInfo.conversation_time = paramInputReader.readDouble(paramInt);
      return true;
    case 6: 
      paramRecordInfo.address = paramInputReader.readString(paramInt);
      return true;
    case 7: 
      paramRecordInfo.name = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramRecordInfo.friend_address = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramRecordInfo.friend_name = paramInputReader.readString(paramInt);
      return true;
    case 10: 
      paramRecordInfo.friend_avatar = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramRecordInfo.mail_subject = paramInputReader.readString(paramInt);
      return true;
    case 12: 
      paramRecordInfo.mail_id = paramInputReader.readString(paramInt);
      return true;
    }
    paramRecordInfo.isdeleted = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.record_id != null) {
      paramOutputWriter.writeString(1, this.record_id);
    }
    if (this.record_type != -2147483648) {
      paramOutputWriter.writeInteger(2, this.record_type);
    }
    if (this.start_time != 4.9E-324D) {
      paramOutputWriter.writeDouble(3, this.start_time);
    }
    if (this.conversation_id != null) {
      paramOutputWriter.writeString(4, this.conversation_id);
    }
    if (this.conversation_time != 4.9E-324D) {
      paramOutputWriter.writeDouble(5, this.conversation_time);
    }
    if (this.address != null) {
      paramOutputWriter.writeString(6, this.address);
    }
    if (this.name != null) {
      paramOutputWriter.writeString(7, this.name);
    }
    if (this.friend_address != null) {
      paramOutputWriter.writeString(8, this.friend_address);
    }
    if (this.friend_name != null) {
      paramOutputWriter.writeString(9, this.friend_name);
    }
    if (this.friend_avatar != null) {
      paramOutputWriter.writeString(10, this.friend_avatar);
    }
    if (this.mail_subject != null) {
      paramOutputWriter.writeString(11, this.mail_subject);
    }
    if (this.mail_id != null) {
      paramOutputWriter.writeString(12, this.mail_id);
    }
    paramOutputWriter.writeBoolean(13, this.isdeleted);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.RecordInfo
 * JD-Core Version:    0.7.0.1
 */