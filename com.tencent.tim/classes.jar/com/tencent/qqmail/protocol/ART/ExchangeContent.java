package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ExchangeContent
  extends BaseProtoBuf
{
  private static final int fieldNumberActivesync_attach_path_ = 23;
  private static final int fieldNumberActivesync_estimate_ = 22;
  private static final int fieldNumberActivesync_options_ = 21;
  private static final int fieldNumberActivesync_updateaccount_ = 25;
  private static final int fieldNumberAttachment_list_ = 19;
  private static final int fieldNumberContact_list_ = 16;
  private static final int fieldNumberCreated_mail_list_ = 4;
  private static final int fieldNumberDeleted_mail_list_ = 5;
  private static final int fieldNumberEnd_of_result_ = 18;
  private static final int fieldNumberEnd_of_sync_ = 3;
  private static final int fieldNumberFailed_mail_list_ = 12;
  private static final int fieldNumberFlag_mail_list_ = 9;
  private static final int fieldNumberFolder_list_ = 1;
  private static final int fieldNumberMail_body_ = 11;
  private static final int fieldNumberRead_mail_list_ = 7;
  private static final int fieldNumberRule_list_ = 17;
  private static final int fieldNumberSearched_mail_list_ = 14;
  private static final int fieldNumberSearched_mail_total_count_ = 15;
  private static final int fieldNumberSubscription_id_ = 20;
  private static final int fieldNumberSync_state_ = 2;
  private static final int fieldNumberUnflag_mail_list_ = 10;
  private static final int fieldNumberUnread_mail_list_ = 8;
  private static final int fieldNumberUpdated_mail_list_ = 6;
  public String activesync_attach_path_;
  public int activesync_estimate_ = -2147483648;
  public ActiveSyncOptions activesync_options_;
  public boolean activesync_updateaccount_;
  public LinkedList<ExchangeMailAttachment> attachment_list_ = new LinkedList();
  public LinkedList<ExchangeContact> contact_list_ = new LinkedList();
  public LinkedList<ExchangeMailSummary> created_mail_list_ = new LinkedList();
  public LinkedList<ExchangeIdentity> deleted_mail_list_ = new LinkedList();
  public boolean end_of_result_;
  public boolean end_of_sync_;
  public LinkedList<ExchangeIdentity> failed_mail_list_ = new LinkedList();
  public LinkedList<ExchangeIdentity> flag_mail_list_ = new LinkedList();
  public LinkedList<ExchangeFolder> folder_list_ = new LinkedList();
  public ExchangeMailBody mail_body_;
  public LinkedList<ExchangeIdentity> read_mail_list_ = new LinkedList();
  public LinkedList<ExchangeRule> rule_list_ = new LinkedList();
  public LinkedList<ExchangeMailSummary> searched_mail_list_ = new LinkedList();
  public int searched_mail_total_count_ = -2147483648;
  public String subscription_id_;
  public String sync_state_;
  public LinkedList<ExchangeIdentity> unflag_mail_list_ = new LinkedList();
  public LinkedList<ExchangeIdentity> unread_mail_list_ = new LinkedList();
  public LinkedList<ExchangeIdentity> updated_mail_list_ = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeListSize(1, 8, this.folder_list_);
    int i = j;
    if (this.sync_state_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.sync_state_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(3, this.end_of_sync_) + ComputeSizeUtil.computeListSize(4, 8, this.created_mail_list_) + ComputeSizeUtil.computeListSize(5, 8, this.deleted_mail_list_) + ComputeSizeUtil.computeListSize(6, 8, this.updated_mail_list_) + ComputeSizeUtil.computeListSize(7, 8, this.read_mail_list_) + ComputeSizeUtil.computeListSize(8, 8, this.unread_mail_list_) + ComputeSizeUtil.computeListSize(9, 8, this.flag_mail_list_) + ComputeSizeUtil.computeListSize(10, 8, this.unflag_mail_list_);
    i = j;
    if (this.mail_body_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(11, this.mail_body_.computeSize());
    }
    j = i + ComputeSizeUtil.computeListSize(12, 8, this.failed_mail_list_) + ComputeSizeUtil.computeListSize(14, 8, this.searched_mail_list_);
    i = j;
    if (this.searched_mail_total_count_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(15, this.searched_mail_total_count_);
    }
    j = i + ComputeSizeUtil.computeListSize(16, 8, this.contact_list_) + ComputeSizeUtil.computeListSize(17, 8, this.rule_list_) + ComputeSizeUtil.computeBooleanSize(18, this.end_of_result_) + ComputeSizeUtil.computeListSize(19, 8, this.attachment_list_);
    i = j;
    if (this.subscription_id_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(20, this.subscription_id_);
    }
    j = i;
    if (this.activesync_options_ != null) {
      j = i + ComputeSizeUtil.computeMessageSize(21, this.activesync_options_.computeSize());
    }
    i = j;
    if (this.activesync_estimate_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(22, this.activesync_estimate_);
    }
    j = i;
    if (this.activesync_attach_path_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(23, this.activesync_attach_path_);
    }
    return j + ComputeSizeUtil.computeBooleanSize(25, this.activesync_updateaccount_);
  }
  
  public final ExchangeContent parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.folder_list_.clear();
    this.created_mail_list_.clear();
    this.deleted_mail_list_.clear();
    this.updated_mail_list_.clear();
    this.read_mail_list_.clear();
    this.unread_mail_list_.clear();
    this.flag_mail_list_.clear();
    this.unflag_mail_list_.clear();
    this.failed_mail_list_.clear();
    this.searched_mail_list_.clear();
    this.contact_list_.clear();
    this.rule_list_.clear();
    this.attachment_list_.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ExchangeContent paramExchangeContent, int paramInt)
    throws IOException
  {
    int i;
    Object localObject2;
    Object localObject1;
    boolean bool;
    switch (paramInt)
    {
    case 13: 
    case 24: 
    default: 
      return false;
    case 1: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeFolder();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeFolder)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeFolder)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.folder_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 2: 
      paramExchangeContent.sync_state_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramExchangeContent.end_of_sync_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeMailSummary();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeMailSummary)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeMailSummary)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.created_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 5: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.deleted_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 6: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.updated_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 7: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.read_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 8: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.unread_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 9: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.flag_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 10: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.unflag_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 11: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeMailBody();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeMailBody)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeMailBody)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.mail_body_ = ((ExchangeMailBody)localObject1);
        paramInt += 1;
      }
      return true;
    case 12: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeIdentity();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeIdentity)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeIdentity)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.failed_mail_list_.add(localObject1);
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
        localObject1 = new ExchangeMailSummary();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeMailSummary)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeMailSummary)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.searched_mail_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 15: 
      paramExchangeContent.searched_mail_total_count_ = paramInputReader.readInteger(paramInt);
      return true;
    case 16: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeContact();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeContact)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeContact)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.contact_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 17: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeRule();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeRule)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeRule)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.rule_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 18: 
      paramExchangeContent.end_of_result_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 19: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeMailAttachment();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeMailAttachment)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeMailAttachment)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.attachment_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 20: 
      paramExchangeContent.subscription_id_ = paramInputReader.readString(paramInt);
      return true;
    case 21: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ActiveSyncOptions();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ActiveSyncOptions)localObject1).populateBuilderWithField((InputReader)localObject2, (ActiveSyncOptions)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramExchangeContent.activesync_options_ = ((ActiveSyncOptions)localObject1);
        paramInt += 1;
      }
      return true;
    case 22: 
      paramExchangeContent.activesync_estimate_ = paramInputReader.readInteger(paramInt);
      return true;
    case 23: 
      paramExchangeContent.activesync_attach_path_ = paramInputReader.readString(paramInt);
      return true;
    }
    paramExchangeContent.activesync_updateaccount_ = paramInputReader.readBoolean(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeList(1, 8, this.folder_list_);
    if (this.sync_state_ != null) {
      paramOutputWriter.writeString(2, this.sync_state_);
    }
    paramOutputWriter.writeBoolean(3, this.end_of_sync_);
    paramOutputWriter.writeList(4, 8, this.created_mail_list_);
    paramOutputWriter.writeList(5, 8, this.deleted_mail_list_);
    paramOutputWriter.writeList(6, 8, this.updated_mail_list_);
    paramOutputWriter.writeList(7, 8, this.read_mail_list_);
    paramOutputWriter.writeList(8, 8, this.unread_mail_list_);
    paramOutputWriter.writeList(9, 8, this.flag_mail_list_);
    paramOutputWriter.writeList(10, 8, this.unflag_mail_list_);
    if (this.mail_body_ != null)
    {
      paramOutputWriter.writeMessage(11, this.mail_body_.computeSize());
      this.mail_body_.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeList(12, 8, this.failed_mail_list_);
    paramOutputWriter.writeList(14, 8, this.searched_mail_list_);
    if (this.searched_mail_total_count_ != -2147483648) {
      paramOutputWriter.writeInteger(15, this.searched_mail_total_count_);
    }
    paramOutputWriter.writeList(16, 8, this.contact_list_);
    paramOutputWriter.writeList(17, 8, this.rule_list_);
    paramOutputWriter.writeBoolean(18, this.end_of_result_);
    paramOutputWriter.writeList(19, 8, this.attachment_list_);
    if (this.subscription_id_ != null) {
      paramOutputWriter.writeString(20, this.subscription_id_);
    }
    if (this.activesync_options_ != null)
    {
      paramOutputWriter.writeMessage(21, this.activesync_options_.computeSize());
      this.activesync_options_.writeFields(paramOutputWriter);
    }
    if (this.activesync_estimate_ != -2147483648) {
      paramOutputWriter.writeInteger(22, this.activesync_estimate_);
    }
    if (this.activesync_attach_path_ != null) {
      paramOutputWriter.writeString(23, this.activesync_attach_path_);
    }
    paramOutputWriter.writeBoolean(25, this.activesync_updateaccount_);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ExchangeContent
 * JD-Core Version:    0.7.0.1
 */