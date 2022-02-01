package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeMailSummary
  extends BaseProtoBuf
{
  private static final int fieldNumberAbstract_ = 9;
  private static final int fieldNumberAttachments_list_ = 25;
  private static final int fieldNumberCc_ = 10;
  private static final int fieldNumberDate_time_sent_ = 6;
  private static final int fieldNumberDisplay_to_ = 7;
  private static final int fieldNumberDuration_ = 17;
  private static final int fieldNumberEnd_time_ = 16;
  private static final int fieldNumberFlag_status_ = 23;
  private static final int fieldNumberHas_attachments_ = 5;
  private static final int fieldNumberIdentity_ = 1;
  private static final int fieldNumberIs_cancelled_ = 20;
  private static final int fieldNumberIs_out_of_date_ = 14;
  private static final int fieldNumberIs_read_ = 13;
  private static final int fieldNumberIs_read_receipt_request_ = 24;
  private static final int fieldNumberIs_response_requested_ = 21;
  private static final int fieldNumberLocation_ = 19;
  private static final int fieldNumberMeeting_response_ = 22;
  private static final int fieldNumberMessage_id_ = 11;
  private static final int fieldNumberSender_ = 12;
  private static final int fieldNumberSize_ = 3;
  private static final int fieldNumberStart_time_ = 15;
  private static final int fieldNumberSubject_ = 2;
  private static final int fieldNumberTime_zone_ = 18;
  private static final int fieldNumberTo_ = 8;
  private static final int fieldNumberType_ = 4;
  public String abstract_;
  public LinkedList<ExchangeMailAttachment> attachments_list_ = new LinkedList();
  public LinkedList<MailAddr> cc_ = new LinkedList();
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
  public MailAddr sender_;
  public int size_ = -2147483648;
  public long start_time_ = -9223372036854775808L;
  public String subject_;
  public String time_zone_;
  public LinkedList<MailAddr> to_ = new LinkedList();
  public int type_ = -2147483648;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.identity_ != null) {
      j = 0 + ComputeSizeUtil.computeMessageSize(1, this.identity_.computeSize());
    }
    int i = j;
    if (this.subject_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.subject_);
    }
    j = i;
    if (this.size_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.size_);
    }
    i = j;
    if (this.type_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(4, this.type_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(5, this.has_attachments_);
    i = j;
    if (this.date_time_sent_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(6, this.date_time_sent_);
    }
    j = i;
    if (this.display_to_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.display_to_);
    }
    j += ComputeSizeUtil.computeListSize(8, 8, this.to_);
    i = j;
    if (this.abstract_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(9, this.abstract_);
    }
    j = i + ComputeSizeUtil.computeListSize(10, 8, this.cc_);
    i = j;
    if (this.message_id_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(11, this.message_id_);
    }
    j = i;
    if (this.sender_ != null) {
      j = i + ComputeSizeUtil.computeMessageSize(12, this.sender_.computeSize());
    }
    j = j + ComputeSizeUtil.computeBooleanSize(13, this.is_read_) + ComputeSizeUtil.computeBooleanSize(14, this.is_out_of_date_);
    i = j;
    if (this.start_time_ != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(15, this.start_time_);
    }
    j = i;
    if (this.end_time_ != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(16, this.end_time_);
    }
    i = j;
    if (this.duration_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(17, this.duration_);
    }
    j = i;
    if (this.time_zone_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(18, this.time_zone_);
    }
    i = j;
    if (this.location_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(19, this.location_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(20, this.is_cancelled_) + ComputeSizeUtil.computeBooleanSize(21, this.is_response_requested_);
    i = j;
    if (this.meeting_response_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(22, this.meeting_response_);
    }
    j = i;
    if (this.flag_status_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(23, this.flag_status_);
    }
    return j + ComputeSizeUtil.computeBooleanSize(24, this.is_read_receipt_request_) + ComputeSizeUtil.computeListSize(25, 8, this.attachments_list_);
  }
  
  public final ExchangeMailSummary parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.to_.clear();
    this.cc_.clear();
    this.attachments_list_.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeMailSummary paramExchangeMailSummary, int paramInt)
    throws IOException
  {
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
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
        paramExchangeMailSummary.identity_ = ((ExchangeIdentity)localObject1);
        paramInt += 1;
      }
      return true;
    case 2: 
      paramExchangeMailSummary.subject_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramExchangeMailSummary.size_ = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramExchangeMailSummary.type_ = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramExchangeMailSummary.has_attachments_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 6: 
      paramExchangeMailSummary.date_time_sent_ = paramInputReader.readLong(paramInt);
      return true;
    case 7: 
      paramExchangeMailSummary.display_to_ = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailSummary.to_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 9: 
      paramExchangeMailSummary.abstract_ = paramInputReader.readString(paramInt);
      return true;
    case 10: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailSummary.cc_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 11: 
      paramExchangeMailSummary.message_id_ = paramInputReader.readString(paramInt);
      return true;
    case 12: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new MailAddr();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((MailAddr)localObject1).populateBuilderWithField((InputReader)localObject2, (MailAddr)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeMailSummary.sender_ = ((MailAddr)localObject1);
        paramInt += 1;
      }
      return true;
    case 13: 
      paramExchangeMailSummary.is_read_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 14: 
      paramExchangeMailSummary.is_out_of_date_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 15: 
      paramExchangeMailSummary.start_time_ = paramInputReader.readLong(paramInt);
      return true;
    case 16: 
      paramExchangeMailSummary.end_time_ = paramInputReader.readLong(paramInt);
      return true;
    case 17: 
      paramExchangeMailSummary.duration_ = paramInputReader.readString(paramInt);
      return true;
    case 18: 
      paramExchangeMailSummary.time_zone_ = paramInputReader.readString(paramInt);
      return true;
    case 19: 
      paramExchangeMailSummary.location_ = paramInputReader.readString(paramInt);
      return true;
    case 20: 
      paramExchangeMailSummary.is_cancelled_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 21: 
      paramExchangeMailSummary.is_response_requested_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 22: 
      paramExchangeMailSummary.meeting_response_ = paramInputReader.readInteger(paramInt);
      return true;
    case 23: 
      paramExchangeMailSummary.flag_status_ = paramInputReader.readInteger(paramInt);
      return true;
    case 24: 
      paramExchangeMailSummary.is_read_receipt_request_ = paramInputReader.readBoolean(paramInt);
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = (byte[])paramInputReader.get(paramInt);
      localObject1 = new ExchangeMailAttachment();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((ExchangeMailAttachment)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeMailAttachment)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramExchangeMailSummary.attachments_list_.add(localObject1);
      paramInt += 1;
    }
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
      paramOutputWriter.writeString(2, this.subject_);
    }
    if (this.size_ != -2147483648) {
      paramOutputWriter.writeInteger(3, this.size_);
    }
    if (this.type_ != -2147483648) {
      paramOutputWriter.writeInteger(4, this.type_);
    }
    paramOutputWriter.writeBoolean(5, this.has_attachments_);
    if (this.date_time_sent_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(6, this.date_time_sent_);
    }
    if (this.display_to_ != null) {
      paramOutputWriter.writeString(7, this.display_to_);
    }
    paramOutputWriter.writeList(8, 8, this.to_);
    if (this.abstract_ != null) {
      paramOutputWriter.writeString(9, this.abstract_);
    }
    paramOutputWriter.writeList(10, 8, this.cc_);
    if (this.message_id_ != null) {
      paramOutputWriter.writeString(11, this.message_id_);
    }
    if (this.sender_ != null)
    {
      paramOutputWriter.writeMessage(12, this.sender_.computeSize());
      this.sender_.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeBoolean(13, this.is_read_);
    paramOutputWriter.writeBoolean(14, this.is_out_of_date_);
    if (this.start_time_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(15, this.start_time_);
    }
    if (this.end_time_ != -9223372036854775808L) {
      paramOutputWriter.writeLong(16, this.end_time_);
    }
    if (this.duration_ != null) {
      paramOutputWriter.writeString(17, this.duration_);
    }
    if (this.time_zone_ != null) {
      paramOutputWriter.writeString(18, this.time_zone_);
    }
    if (this.location_ != null) {
      paramOutputWriter.writeString(19, this.location_);
    }
    paramOutputWriter.writeBoolean(20, this.is_cancelled_);
    paramOutputWriter.writeBoolean(21, this.is_response_requested_);
    if (this.meeting_response_ != -2147483648) {
      paramOutputWriter.writeInteger(22, this.meeting_response_);
    }
    if (this.flag_status_ != -2147483648) {
      paramOutputWriter.writeInteger(23, this.flag_status_);
    }
    paramOutputWriter.writeBoolean(24, this.is_read_receipt_request_);
    paramOutputWriter.writeList(25, 8, this.attachments_list_);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeMailSummary
 * JD-Core Version:    0.7.0.1
 */