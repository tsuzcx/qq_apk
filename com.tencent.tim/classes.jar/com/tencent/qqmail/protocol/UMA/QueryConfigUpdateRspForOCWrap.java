package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import java.io.IOException;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class QueryConfigUpdateRspForOCWrap
  extends BaseProtoBuf
{
  private static final int fieldNumberAdbw_list = 15;
  private static final int fieldNumberApp_misc_config = 13;
  private static final int fieldNumberApp_not_notify = 21;
  private static final int fieldNumberApp_not_to_open_file = 22;
  private static final int fieldNumberAvailable = 2;
  private static final int fieldNumberClientIpBelog = 17;
  private static final int fieldNumberConfig_type = 1;
  private static final int fieldNumberDomain_config_list = 7;
  private static final int fieldNumberEmail_account_state_list = 9;
  private static final int fieldNumberEmail_type_rule = 14;
  private static final int fieldNumberHolidaypic_list = 11;
  private static final int fieldNumberNew_config_digest = 4;
  private static final int fieldNumberNew_config_part_pos = 6;
  private static final int fieldNumberNew_config_size = 5;
  private static final int fieldNumberNew_config_version = 3;
  private static final int fieldNumberPopularize_list = 16;
  private static final int fieldNumberPush_config_list = 19;
  private static final int fieldNumberQuery_call_record_list = 18;
  private static final int fieldNumberSpreadresult_list = 12;
  private static final int fieldNumberTest_flight = 20;
  private static final int fieldNumberUpdateinfo_list = 10;
  private static final int fieldNumberUser_setting_list = 8;
  public ADBWList adbw_list;
  public AppMiscConfig app_misc_config;
  public LinkedList<AppNotNotify> app_not_notify = new LinkedList();
  public LinkedList<AppNotToOpenFile> app_not_to_open_file = new LinkedList();
  public boolean available;
  public QueryClientIpBelong clientIpBelog;
  public int config_type;
  public LinkedList<DomainConfig> domain_config_list = new LinkedList();
  public LinkedList<EmailAccountState> email_account_state_list = new LinkedList();
  public String email_type_rule;
  public LinkedList<HolidayPicConfig> holidaypic_list = new LinkedList();
  public DigestInfo new_config_digest;
  public int new_config_part_pos = -2147483648;
  public int new_config_size = -2147483648;
  public String new_config_version;
  public LinkedList<PopularizeConfig> popularize_list = new LinkedList();
  public LinkedList<PushConfig> push_config_list = new LinkedList();
  public LinkedList<PhoneCallRecordConfigDomain> query_call_record_list = new LinkedList();
  public LinkedList<SpreadResult> spreadresult_list = new LinkedList();
  public TestFlight test_flight;
  public LinkedList<UpdateInfo> updateinfo_list = new LinkedList();
  public LinkedList<UserSetting> user_setting_list = new LinkedList();
  
  public final int computeSize()
  {
    int j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.config_type) + ComputeSizeUtil.computeBooleanSize(2, this.available);
    int i = j;
    if (this.new_config_version != null) {
      i = j + ComputeSizeUtil.computeStringSize(3, this.new_config_version);
    }
    j = i;
    if (this.new_config_digest != null) {
      j = i + ComputeSizeUtil.computeMessageSize(4, this.new_config_digest.computeSize());
    }
    i = j;
    if (this.new_config_size != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(5, this.new_config_size);
    }
    j = i;
    if (this.new_config_part_pos != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(6, this.new_config_part_pos);
    }
    j = j + ComputeSizeUtil.computeListSize(7, 8, this.domain_config_list) + ComputeSizeUtil.computeListSize(8, 8, this.user_setting_list) + ComputeSizeUtil.computeListSize(9, 8, this.email_account_state_list) + ComputeSizeUtil.computeListSize(10, 8, this.updateinfo_list) + ComputeSizeUtil.computeListSize(11, 8, this.holidaypic_list) + ComputeSizeUtil.computeListSize(12, 8, this.spreadresult_list);
    i = j;
    if (this.app_misc_config != null) {
      i = j + ComputeSizeUtil.computeMessageSize(13, this.app_misc_config.computeSize());
    }
    j = i;
    if (this.email_type_rule != null) {
      j = i + ComputeSizeUtil.computeStringSize(14, this.email_type_rule);
    }
    i = j;
    if (this.adbw_list != null) {
      i = j + ComputeSizeUtil.computeMessageSize(15, this.adbw_list.computeSize());
    }
    j = i + ComputeSizeUtil.computeListSize(16, 8, this.popularize_list);
    i = j;
    if (this.clientIpBelog != null) {
      i = j + ComputeSizeUtil.computeMessageSize(17, this.clientIpBelog.computeSize());
    }
    j = i + ComputeSizeUtil.computeListSize(18, 8, this.query_call_record_list) + ComputeSizeUtil.computeListSize(19, 8, this.push_config_list);
    i = j;
    if (this.test_flight != null) {
      i = j + ComputeSizeUtil.computeMessageSize(20, this.test_flight.computeSize());
    }
    return i + ComputeSizeUtil.computeListSize(21, 8, this.app_not_notify) + ComputeSizeUtil.computeListSize(22, 8, this.app_not_to_open_file);
  }
  
  public final QueryConfigUpdateRspForOCWrap parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.domain_config_list.clear();
    this.user_setting_list.clear();
    this.email_account_state_list.clear();
    this.updateinfo_list.clear();
    this.holidaypic_list.clear();
    this.spreadresult_list.clear();
    this.popularize_list.clear();
    this.query_call_record_list.clear();
    this.push_config_list.clear();
    this.app_not_notify.clear();
    this.app_not_to_open_file.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, QueryConfigUpdateRspForOCWrap paramQueryConfigUpdateRspForOCWrap, int paramInt)
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
      paramQueryConfigUpdateRspForOCWrap.config_type = paramInputReader.readInteger(paramInt);
      return true;
    case 2: 
      paramQueryConfigUpdateRspForOCWrap.available = paramInputReader.readBoolean(paramInt);
      return true;
    case 3: 
      paramQueryConfigUpdateRspForOCWrap.new_config_version = paramInputReader.readString(paramInt);
      return true;
    case 4: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new DigestInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((DigestInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (DigestInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.new_config_digest = ((DigestInfo)localObject1);
        paramInt += 1;
      }
      return true;
    case 5: 
      paramQueryConfigUpdateRspForOCWrap.new_config_size = paramInputReader.readInteger(paramInt);
      return true;
    case 6: 
      paramQueryConfigUpdateRspForOCWrap.new_config_part_pos = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new DomainConfig();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((DomainConfig)localObject1).populateBuilderWithField((InputReader)localObject2, (DomainConfig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.domain_config_list.add(localObject1);
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
        localObject1 = new UserSetting();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((UserSetting)localObject1).populateBuilderWithField((InputReader)localObject2, (UserSetting)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.user_setting_list.add(localObject1);
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
        localObject1 = new EmailAccountState();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((EmailAccountState)localObject1).populateBuilderWithField((InputReader)localObject2, (EmailAccountState)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.email_account_state_list.add(localObject1);
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
        localObject1 = new UpdateInfo();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((UpdateInfo)localObject1).populateBuilderWithField((InputReader)localObject2, (UpdateInfo)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.updateinfo_list.add(localObject1);
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
        localObject1 = new HolidayPicConfig();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((HolidayPicConfig)localObject1).populateBuilderWithField((InputReader)localObject2, (HolidayPicConfig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.holidaypic_list.add(localObject1);
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
        localObject1 = new SpreadResult();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((SpreadResult)localObject1).populateBuilderWithField((InputReader)localObject2, (SpreadResult)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.spreadresult_list.add(localObject1);
        paramInt += 1;
      }
      return true;
    case 13: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new AppMiscConfig();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((AppMiscConfig)localObject1).populateBuilderWithField((InputReader)localObject2, (AppMiscConfig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.app_misc_config = ((AppMiscConfig)localObject1);
        paramInt += 1;
      }
      return true;
    case 14: 
      paramQueryConfigUpdateRspForOCWrap.email_type_rule = paramInputReader.readString(paramInt);
      return true;
    case 15: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new ADBWList();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((ADBWList)localObject1).populateBuilderWithField((InputReader)localObject2, (ADBWList)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.adbw_list = ((ADBWList)localObject1);
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
        localObject1 = new PopularizeConfig();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((PopularizeConfig)localObject1).populateBuilderWithField((InputReader)localObject2, (PopularizeConfig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.popularize_list.add(localObject1);
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
        localObject1 = new QueryClientIpBelong();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((QueryClientIpBelong)localObject1).populateBuilderWithField((InputReader)localObject2, (QueryClientIpBelong)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.clientIpBelog = ((QueryClientIpBelong)localObject1);
        paramInt += 1;
      }
      return true;
    case 18: 
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new PhoneCallRecordConfigDomain();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((PhoneCallRecordConfigDomain)localObject1).populateBuilderWithField((InputReader)localObject2, (PhoneCallRecordConfigDomain)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.query_call_record_list.add(localObject1);
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
        localObject1 = new PushConfig();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((PushConfig)localObject1).populateBuilderWithField((InputReader)localObject2, (PushConfig)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.push_config_list.add(localObject1);
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
        localObject1 = new TestFlight();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((TestFlight)localObject1).populateBuilderWithField((InputReader)localObject2, (TestFlight)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.test_flight = ((TestFlight)localObject1);
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
        localObject1 = new AppNotNotify();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((AppNotNotify)localObject1).populateBuilderWithField((InputReader)localObject2, (AppNotNotify)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramQueryConfigUpdateRspForOCWrap.app_not_notify.add(localObject1);
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
      localObject1 = new AppNotToOpenFile();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((AppNotToOpenFile)localObject1).populateBuilderWithField((InputReader)localObject2, (AppNotToOpenFile)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramQueryConfigUpdateRspForOCWrap.app_not_to_open_file.add(localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    paramOutputWriter.writeInteger(1, this.config_type);
    paramOutputWriter.writeBoolean(2, this.available);
    if (this.new_config_version != null) {
      paramOutputWriter.writeString(3, this.new_config_version);
    }
    if (this.new_config_digest != null)
    {
      paramOutputWriter.writeMessage(4, this.new_config_digest.computeSize());
      this.new_config_digest.writeFields(paramOutputWriter);
    }
    if (this.new_config_size != -2147483648) {
      paramOutputWriter.writeInteger(5, this.new_config_size);
    }
    if (this.new_config_part_pos != -2147483648) {
      paramOutputWriter.writeInteger(6, this.new_config_part_pos);
    }
    paramOutputWriter.writeList(7, 8, this.domain_config_list);
    paramOutputWriter.writeList(8, 8, this.user_setting_list);
    paramOutputWriter.writeList(9, 8, this.email_account_state_list);
    paramOutputWriter.writeList(10, 8, this.updateinfo_list);
    paramOutputWriter.writeList(11, 8, this.holidaypic_list);
    paramOutputWriter.writeList(12, 8, this.spreadresult_list);
    if (this.app_misc_config != null)
    {
      paramOutputWriter.writeMessage(13, this.app_misc_config.computeSize());
      this.app_misc_config.writeFields(paramOutputWriter);
    }
    if (this.email_type_rule != null) {
      paramOutputWriter.writeString(14, this.email_type_rule);
    }
    if (this.adbw_list != null)
    {
      paramOutputWriter.writeMessage(15, this.adbw_list.computeSize());
      this.adbw_list.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeList(16, 8, this.popularize_list);
    if (this.clientIpBelog != null)
    {
      paramOutputWriter.writeMessage(17, this.clientIpBelog.computeSize());
      this.clientIpBelog.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeList(18, 8, this.query_call_record_list);
    paramOutputWriter.writeList(19, 8, this.push_config_list);
    if (this.test_flight != null)
    {
      paramOutputWriter.writeMessage(20, this.test_flight.computeSize());
      this.test_flight.writeFields(paramOutputWriter);
    }
    paramOutputWriter.writeList(21, 8, this.app_not_notify);
    paramOutputWriter.writeList(22, 8, this.app_not_to_open_file);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.QueryConfigUpdateRspForOCWrap
 * JD-Core Version:    0.7.0.1
 */