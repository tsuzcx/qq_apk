package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeMailBody
  extends BaseProtoBuf
{
  private static final int fieldNumberAttachments_list_ = 30;
  private static final int fieldNumberAvatar_code_ = 32;
  private static final int fieldNumberBcc_ = 15;
  private static final int fieldNumberBody_ = 8;
  private static final int fieldNumberCc_ = 14;
  private static final int fieldNumberCharset_ = 9;
  private static final int fieldNumberDate_time_sent_ = 7;
  private static final int fieldNumberDisplay_to_ = 18;
  private static final int fieldNumberDuration_ = 22;
  private static final int fieldNumberEnd_time_ = 21;
  private static final int fieldNumberFlag_status_ = 28;
  private static final int fieldNumberHas_attachments_ = 6;
  private static final int fieldNumberIdentity_ = 1;
  private static final int fieldNumberIs_cancelled_ = 25;
  private static final int fieldNumberIs_out_of_date_ = 19;
  private static final int fieldNumberIs_read_ = 12;
  private static final int fieldNumberIs_read_receipt_request_ = 33;
  private static final int fieldNumberIs_response_requested_ = 26;
  private static final int fieldNumberLocation_ = 24;
  private static final int fieldNumberMeeting_response_ = 27;
  private static final int fieldNumberMessage_id_ = 10;
  private static final int fieldNumberMime_header_ = 31;
  private static final int fieldNumberReference_ = 17;
  private static final int fieldNumberReply_to_ = 16;
  private static final int fieldNumberSender_ = 11;
  private static final int fieldNumberSize_ = 4;
  private static final int fieldNumberStart_time_ = 20;
  private static final int fieldNumberSubject_ = 3;
  private static final int fieldNumberTime_zone_ = 23;
  private static final int fieldNumberTo_ = 13;
  private static final int fieldNumberType_ = 5;
  private static final int fieldNumberVisible_content_ = 29;
  public LinkedList<ExchangeMailAttachment> attachments_list_ = new LinkedList();
  public String avatar_code_;
  public LinkedList<MailAddr> bcc_ = new LinkedList();
  public String body_;
  public LinkedList<MailAddr> cc_ = new LinkedList();
  public String charset_;
  public long date_time_sent_ = -9223372036854775808L;
  public String display_to_;
  public String duration_;
  public long end_time_ = -9223372036854775808L;
  public int flag_status_ = -2147483648;
  public boolean has_attachments_;
  public ExchangeIdentity identity_;
  public boolean is_cancelled_;
  public boolean is_out_of_date_;
  public boolean is_read_;
  public boolean is_read_receipt_request_;
  public boolean is_response_requested_;
  public String location_;
  public int meeting_response_ = -2147483648;
  public String message_id_;
  public String mime_header_;
  public String reference_;
  public LinkedList<MailAddr> reply_to_ = new LinkedList();
  public MailAddr sender_;
  public int size_ = -2147483648;
  public long start_time_ = -9223372036854775808L;
  public String subject_;
  public String time_zone_;
  public LinkedList<MailAddr> to_ = new LinkedList();
  public int type_ = -2147483648;
  public String visible_content_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.identity_ != null) {
      j = 0 + ComputeSizeUtil.computeMessageSize(1, this.identity_.computeSize());
    }
    int i = j;
    if (this.subject_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.subject_);
    }
    j = i;
    if (this.size_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(4, this.size_);
    }
    i = j;
    if (this.type_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(5, this.type_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(6, this.has_attachments_);
    i = j;
    if (this.date_time_sent_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(7, this.date_time_sent_);
    }
    j = i;
    if (this.body_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(8, this.body_);
    }
    i = j;
    if (this.charset_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(9, this.charset_);
    }
    j = i;
    if (this.message_id_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(10, this.message_id_);
    }
    i = j;
    if (this.sender_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(11, this.sender_.computeSize());
    }
    j = i + ComputeSizeUtil.computeBooleanSize(12, this.is_read_) + ComputeSizeUtil.computeListSize(13, 8, this.to_) + ComputeSizeUtil.computeListSize(14, 8, this.cc_) + ComputeSizeUtil.computeListSize(15, 8, this.bcc_) + ComputeSizeUtil.computeListSize(16, 8, this.reply_to_);
    i = j;
    if (this.reference_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(17, this.reference_);
    }
    j = i;
    if (this.display_to_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(18, this.display_to_);
    }
    j += ComputeSizeUtil.computeBooleanSize(19, this.is_out_of_date_);
    i = j;
    if (this.start_time_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(20, this.start_time_);
    }
    j = i;
    if (this.end_time_ != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(21, this.end_time_);
    }
    i = j;
    if (this.duration_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(22, this.duration_);
    }
    j = i;
    if (this.time_zone_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(23, this.time_zone_);
    }
    i = j;
    if (this.location_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(24, this.location_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(25, this.is_cancelled_) + ComputeSizeUtil.computeBooleanSize(26, this.is_response_requested_);
    i = j;
    if (this.meeting_response_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(27, this.meeting_response_);
    }
    j = i;
    if (this.flag_status_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(28, this.flag_status_);
    }
    i = j;
    if (this.visible_content_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(29, this.visible_content_);
    }
    j = i + ComputeSizeUtil.computeListSize(30, 8, this.attachments_list_);
    i = j;
    if (this.mime_header_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(31, this.mime_header_);
    }
    j = i;
    if (this.avatar_code_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(32, this.avatar_code_);
    }
    return j + ComputeSizeUtil.computeBooleanSize(33, this.is_read_receipt_request_);
  }
  
  public final ExchangeMailBody parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.to_.clear();
    this.cc_.clear();
    this.bcc_.clear();
    this.reply_to_.clear();
    this.attachments_list_.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeMailBody paramExchangeMailBody, int paramInt)
    throws IOException
  {
    int i;
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    case 2: 
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.identity_ = ((ExchangeIdentity)localObject1);
        paramInt += 1;
      }
      return true;
    case 3: 
      paramExchangeMailBody.subject_ = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramExchangeMailBody.size_ = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramExchangeMailBody.type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramExchangeMailBody.has_attachments_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 7: 
      paramExchangeMailBody.date_time_sent_ = paramInputReader.readLong(paramInt);
      return true;
    case 8: 
      paramExchangeMailBody.body_ = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramExchangeMailBody.charset_ = paramInputReader.readString(paramInt);
      return true;
    case 10: 
      paramExchangeMailBody.message_id_ = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.sender_ = ((MailAddr)localObject1);
        paramInt += 1;
      }
      return true;
    case 12: 
      paramExchangeMailBody.is_read_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 13: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.to_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 14: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.cc_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 15: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.bcc_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 16: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.reply_to_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 17: 
      paramExchangeMailBody.reference_ = paramInputReader.readString(paramInt);
      return true;
    case 18: 
      paramExchangeMailBody.display_to_ = paramInputReader.readString(paramInt);
      return true;
    case 19: 
      paramExchangeMailBody.is_out_of_date_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 20: 
      paramExchangeMailBody.start_time_ = paramInputReader.readLong(paramInt);
      return true;
    case 21: 
      paramExchangeMailBody.end_time_ = paramInputReader.readLong(paramInt);
      return true;
    case 22: 
      paramExchangeMailBody.duration_ = paramInputReader.readString(paramInt);
      return true;
    case 23: 
      paramExchangeMailBody.time_zone_ = paramInputReader.readString(paramInt);
      return true;
    case 24: 
      paramExchangeMailBody.location_ = paramInputReader.readString(paramInt);
      return true;
    case 25: 
      paramExchangeMailBody.is_cancelled_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 26: 
      paramExchangeMailBody.is_response_requested_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 27: 
      paramExchangeMailBody.meeting_response_ = paramInputReader.readInteger(paramInt);
      return true;
    case 28: 
      paramExchangeMailBody.flag_status_ = paramInputReader.readInteger(paramInt);
      return true;
    case 29: 
      paramExchangeMailBody.visible_content_ = paramInputReader.readString(paramInt);
      return true;
    case 30: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeMailAttachment();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeMailAttachment)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeMailAttachment)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailBody.attachments_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 31: 
      paramExchangeMailBody.mime_header_ = paramInputReader.readString(paramInt);
      return true;
    case 32: 
      paramExchangeMailBody.avatar_code_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramExchangeMailBody.is_read_receipt_request_ = paramInputReader.readBoolean(paramInt);
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
    if (this.subject_ != null) {
      paramOutputWriter.writeString(3, this.subject_);
    }
    if (this.size_ != -2147483648) {
      paramOutputWriter.writeInteger(4, this.size_);
    }
    if (this.type_ != -2147483648) {
      paramOutputWriter.writeInteger(5, this.type_);
    }
    paramOutputWriter.writeBoolean(6, this.has_attachments_);
    if (this.date_time_sent_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(7, this.date_time_sent_);
    }
    if (this.body_ != null) {
      paramOutputWriter.writeString(8, this.body_);
    }
    if (this.charset_ != null) {
      paramOutputWriter.writeString(9, this.charset_);
    }
    if (this.message_id_ != null) {
      paramOutputWriter.writeString(10, this.message_id_);
    }
    if (this.sender_ != null)
    {
      paramOutputWriter.writeMessage(11, this.sender_.computeSize());
      this.sender_.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeBoolean(12, this.is_read_);
    paramOutputWriter.writeList(13, 8, this.to_);
    paramOutputWriter.writeList(14, 8, this.cc_);
    paramOutputWriter.writeList(15, 8, this.bcc_);
    paramOutputWriter.writeList(16, 8, this.reply_to_);
    if (this.reference_ != null) {
      paramOutputWriter.writeString(17, this.reference_);
    }
    if (this.display_to_ != null) {
      paramOutputWriter.writeString(18, this.display_to_);
    }
    paramOutputWriter.writeBoolean(19, this.is_out_of_date_);
    if (this.start_time_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(20, this.start_time_);
    }
    if (this.end_time_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(21, this.end_time_);
    }
    if (this.duration_ != null) {
      paramOutputWriter.writeString(22, this.duration_);
    }
    if (this.time_zone_ != null) {
      paramOutputWriter.writeString(23, this.time_zone_);
    }
    if (this.location_ != null) {
      paramOutputWriter.writeString(24, this.location_);
    }
    paramOutputWriter.writeBoolean(25, this.is_cancelled_);
    paramOutputWriter.writeBoolean(26, this.is_response_requested_);
    if (this.meeting_response_ != -2147483648) {
      paramOutputWriter.writeInteger(27, this.meeting_response_);
    }
    if (this.flag_status_ != -2147483648) {
      paramOutputWriter.writeInteger(28, this.flag_status_);
    }
    if (this.visible_content_ != null) {
      paramOutputWriter.writeString(29, this.visible_content_);
    }
    paramOutputWriter.writeList(30, 8, this.attachments_list_);
    if (this.mime_header_ != null) {
      paramOutputWriter.writeString(31, this.mime_header_);
    }
    if (this.avatar_code_ != null) {
      paramOutputWriter.writeString(32, this.avatar_code_);
    }
    paramOutputWriter.writeBoolean(33, this.is_read_receipt_request_);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeMailBody
 * JD-Core Version:    0.7.0.1
 */