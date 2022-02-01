package com.tencent.qqmail.protocol.ART;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public class ProtocolResult
  extends BaseProtoBuf
{
  private static final int fieldNumberAs_contact_result_list_ = 21;
  private static final int fieldNumberDetail_code_ = 16;
  private static final int fieldNumberDetail_msg_ = 17;
  private static final int fieldNumberEnd_of_result_ = 7;
  private static final int fieldNumberError_code_ = 1;
  private static final int fieldNumberEws_server_address_ = 12;
  private static final int fieldNumberExchange_content_ = 11;
  private static final int fieldNumberFolder_name_ = 8;
  private static final int fieldNumberFolder_operation_result_ = 22;
  private static final int fieldNumberImap_status_result_ = 19;
  private static final int fieldNumberMail_content_size_ = 13;
  private static final int fieldNumberMail_flags_ = 6;
  private static final int fieldNumberMail_index_ = 3;
  private static final int fieldNumberMail_section_ = 5;
  private static final int fieldNumberMail_uid_ = 4;
  private static final int fieldNumberMail_uid_list_ = 14;
  private static final int fieldNumberPing_response_folder_id_ = 10;
  private static final int fieldNumberProtocol_info_list_ = 20;
  private static final int fieldNumberResult_ = 2;
  private static final int fieldNumberStatus_ = 9;
  private static final int fieldNumberUid_size_list_ = 18;
  private static final int fieldNumberUrl_ = 15;
  public LinkedList<ASContact> as_contact_result_list_ = new LinkedList();
  public int detail_code_ = -2147483648;
  public String detail_msg_;
  public boolean end_of_result_;
  public int error_code_ = -2147483648;
  public String ews_server_address_;
  public ExchangeContent exchange_content_;
  public String folder_name_;
  public FolderOperationResult folder_operation_result_;
  public ImapCommandStatusResult imap_status_result_;
  public String mail_content_size_;
  public int mail_flags_ = -2147483648;
  public int mail_index_ = -2147483648;
  public String mail_section_;
  public String mail_uid_;
  public LinkedList<Integer> mail_uid_list_ = new LinkedList();
  public String ping_response_folder_id_;
  public LinkedList<ProtocolInfo> protocol_info_list_ = new LinkedList();
  public String result_;
  public int status_ = -2147483648;
  public LinkedList<Entry> uid_size_list_ = new LinkedList();
  public String url_;
  
  public final int computeSize()
  {
    int j = 0;
    if (this.error_code_ != -2147483648) {
      j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.error_code_);
    }
    int i = j;
    if (this.result_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(2, this.result_);
    }
    j = i;
    if (this.mail_index_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(3, this.mail_index_);
    }
    i = j;
    if (this.mail_uid_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(4, this.mail_uid_);
    }
    j = i;
    if (this.mail_section_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(5, this.mail_section_);
    }
    i = j;
    if (this.mail_flags_ != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.mail_flags_);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(7, this.end_of_result_);
    i = j;
    if (this.folder_name_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(8, this.folder_name_);
    }
    j = i;
    if (this.status_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(9, this.status_);
    }
    i = j;
    if (this.ping_response_folder_id_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(10, this.ping_response_folder_id_);
    }
    j = i;
    if (this.exchange_content_ != null) {
      j = i + ComputeSizeUtil.computeMessageSize(11, this.exchange_content_.computeSize());
    }
    i = j;
    if (this.ews_server_address_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(12, this.ews_server_address_);
    }
    j = i;
    if (this.mail_content_size_ != null) {
      j = i + ComputeSizeUtil.computeStringSize(13, this.mail_content_size_);
    }
    j += ComputeSizeUtil.computeListSize(14, 2, this.mail_uid_list_);
    i = j;
    if (this.url_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(15, this.url_);
    }
    j = i;
    if (this.detail_code_ != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(16, this.detail_code_);
    }
    i = j;
    if (this.detail_msg_ != null) {
      i = j + ComputeSizeUtil.computeStringSize(17, this.detail_msg_);
    }
    j = i + ComputeSizeUtil.computeListSize(18, 8, this.uid_size_list_);
    i = j;
    if (this.imap_status_result_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(19, this.imap_status_result_.computeSize());
    }
    j = i + ComputeSizeUtil.computeListSize(20, 8, this.protocol_info_list_) + ComputeSizeUtil.computeListSize(21, 8, this.as_contact_result_list_);
    i = j;
    if (this.folder_operation_result_ != null) {
      i = j + ComputeSizeUtil.computeMessageSize(22, this.folder_operation_result_.computeSize());
    }
    return i;
  }
  
  public final ProtocolResult parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.mail_uid_list_.clear();
    this.uid_size_list_.clear();
    this.protocol_info_list_.clear();
    this.as_contact_result_list_.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, ProtocolResult paramProtocolResult, int paramInt)
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
      paramProtocolResult.error_code_ = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramProtocolResult.result_ = paramInputReader.readString(paramInt);
      return true;
    case 3: 
      paramProtocolResult.mail_index_ = paramInputReader.readInteger(paramInt);
      return true;
    case 4: 
      paramProtocolResult.mail_uid_ = paramInputReader.readString(paramInt);
      return true;
    case 5: 
      paramProtocolResult.mail_section_ = paramInputReader.readString(paramInt);
      return true;
    case 6: 
      paramProtocolResult.mail_flags_ = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramProtocolResult.end_of_result_ = paramInputReader.readBoolean(paramInt);
      return true;
    case 8: 
      paramProtocolResult.folder_name_ = paramInputReader.readString(paramInt);
      return true;
    case 9: 
      paramProtocolResult.status_ = paramInputReader.readInteger(paramInt);
      return true;
    case 10: 
      paramProtocolResult.ping_response_folder_id_ = paramInputReader.readString(paramInt);
      return true;
    case 11: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ExchangeContent();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ExchangeContent)localObject1).populateBuilderWithField((InputReader)localObject2, (ExchangeContent)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramProtocolResult.exchange_content_ = ((ExchangeContent)localObject1);
        paramInt += 1;
      }
      return true;
    case 12: 
      paramProtocolResult.ews_server_address_ = paramInputReader.readString(paramInt);
      return true;
    case 13: 
      paramProtocolResult.mail_content_size_ = paramInputReader.readString(paramInt);
      return true;
    case 14: 
      paramProtocolResult.mail_uid_list_.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
      return true;
    case 15: 
      paramProtocolResult.url_ = paramInputReader.readString(paramInt);
      return true;
    case 16: 
      paramProtocolResult.detail_code_ = paramInputReader.readInteger(paramInt);
      return true;
    case 17: 
      paramProtocolResult.detail_msg_ = paramInputReader.readString(paramInt);
      return true;
    case 18: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new Entry();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((Entry)localObject1).populateBuilderWithField((InputReader)localObject2, (Entry)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramProtocolResult.uid_size_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 19: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ImapCommandStatusResult();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ImapCommandStatusResult)localObject1).populateBuilderWithField((InputReader)localObject2, (ImapCommandStatusResult)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramProtocolResult.imap_status_result_ = ((ImapCommandStatusResult)localObject1);
        paramInt += 1;
      }
      return true;
    case 20: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ProtocolInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ProtocolInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (ProtocolInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramProtocolResult.protocol_info_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 21: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ASContact();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ASContact)localObject1).populateBuilderWithField((InputReader)localObject2, (ASContact)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramProtocolResult.as_contact_result_list_.add(localObject1);
        paramInt += 1;
      }
      return true;
    }
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = (byte[])paramInputReader.get(paramInt);
      localObject1 = new FolderOperationResult();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((FolderOperationResult)localObject1).populateBuilderWithField((InputReader)localObject2, (FolderOperationResult)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramProtocolResult.folder_operation_result_ = ((FolderOperationResult)localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.error_code_ != -2147483648) {
      paramOutputWriter.writeInteger(1, this.error_code_);
    }
    if (this.result_ != null) {
      paramOutputWriter.writeString(2, this.result_);
    }
    if (this.mail_index_ != -2147483648) {
      paramOutputWriter.writeInteger(3, this.mail_index_);
    }
    if (this.mail_uid_ != null) {
      paramOutputWriter.writeString(4, this.mail_uid_);
    }
    if (this.mail_section_ != null) {
      paramOutputWriter.writeString(5, this.mail_section_);
    }
    if (this.mail_flags_ != -2147483648) {
      paramOutputWriter.writeInteger(6, this.mail_flags_);
    }
    paramOutputWriter.writeBoolean(7, this.end_of_result_);
    if (this.folder_name_ != null) {
      paramOutputWriter.writeString(8, this.folder_name_);
    }
    if (this.status_ != -2147483648) {
      paramOutputWriter.writeInteger(9, this.status_);
    }
    if (this.ping_response_folder_id_ != null) {
      paramOutputWriter.writeString(10, this.ping_response_folder_id_);
    }
    if (this.exchange_content_ != null)
    {
      paramOutputWriter.writeMessage(11, this.exchange_content_.computeSize());
      this.exchange_content_.writeFields(paramOutputWriter);
    }
    if (this.ews_server_address_ != null) {
      paramOutputWriter.writeString(12, this.ews_server_address_);
    }
    if (this.mail_content_size_ != null) {
      paramOutputWriter.writeString(13, this.mail_content_size_);
    }
    paramOutputWriter.writeList(14, 2, this.mail_uid_list_);
    if (this.url_ != null) {
      paramOutputWriter.writeString(15, this.url_);
    }
    if (this.detail_code_ != -2147483648) {
      paramOutputWriter.writeInteger(16, this.detail_code_);
    }
    if (this.detail_msg_ != null) {
      paramOutputWriter.writeString(17, this.detail_msg_);
    }
    paramOutputWriter.writeList(18, 8, this.uid_size_list_);
    if (this.imap_status_result_ != null)
    {
      paramOutputWriter.writeMessage(19, this.imap_status_result_.computeSize());
      this.imap_status_result_.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeList(20, 8, this.protocol_info_list_);
    paramOutputWriter.writeList(21, 8, this.as_contact_result_list_);
    if (this.folder_operation_result_ != null)
    {
      paramOutputWriter.writeMessage(22, this.folder_operation_result_.computeSize());
      this.folder_operation_result_.writeFields(paramOutputWriter);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.ART.ProtocolResult
 * JD-Core Version:    0.7.0.1
 */