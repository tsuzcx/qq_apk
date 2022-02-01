package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class AppMiscConfig
  extends BaseProtoBuf
{
  private static final int fieldNumberAndroid_alarm_control = 22;
  private static final int fieldNumberAndroid_conn_type = 11;
  private static final int fieldNumberAndroid_httpdns_control = 25;
  private static final int fieldNumberBottle_entry = 4;
  private static final int fieldNumberCheck_app_install = 7;
  private static final int fieldNumberCheck_link_url = 1;
  private static final int fieldNumberClear_cache_config = 26;
  private static final int fieldNumberDisable_mail_proc = 2;
  private static final int fieldNumberEnable_deadlock_report = 18;
  private static final int fieldNumberEnable_memory_report = 16;
  private static final int fieldNumberEnable_score_tips = 5;
  private static final int fieldNumberEnable_sql_report = 17;
  private static final int fieldNumberGmail_error_message = 8;
  private static final int fieldNumberMisc_flag = 6;
  private static final int fieldNumberMiscversion = 12;
  private static final int fieldNumberNetwork_static_report = 20;
  private static final int fieldNumberPhone_call_off2on_check_freq = 10;
  private static final int fieldNumberPhone_call_on2off_check_freq = 9;
  private static final int fieldNumberPush_ack_mobile_freq = 14;
  private static final int fieldNumberPush_ack_wifi_freq = 13;
  private static final int fieldNumberReceive_mail_tips_interval = 24;
  private static final int fieldNumberReceive_mail_tips_times = 23;
  private static final int fieldNumberReport_unread_count_detail = 3;
  private static final int fieldNumberShow_splash_history_list = 15;
  private static final int fieldNumberSyncadapter_control = 21;
  private static final int fieldNumberTranslation_hint = 19;
  public String android_alarm_control;
  public int android_conn_type = -2147483648;
  public String android_httpdns_control;
  public int bottle_entry;
  public String check_app_install;
  public String check_link_url;
  public ByteString clear_cache_config;
  public boolean disable_mail_proc;
  public boolean enable_deadlock_report = false;
  public boolean enable_memory_report = false;
  public boolean enable_score_tips;
  public boolean enable_sql_report = false;
  public ByteString gmail_error_message;
  public int misc_flag = -2147483648;
  public int miscversion = -2147483648;
  public String network_static_report;
  public int phone_call_off2on_check_freq = -2147483648;
  public int phone_call_on2off_check_freq = -2147483648;
  public long push_ack_mobile_freq = -9223372036854775808L;
  public long push_ack_wifi_freq = -9223372036854775808L;
  public long receive_mail_tips_interval = -9223372036854775808L;
  public int receive_mail_tips_times = -2147483648;
  public boolean report_unread_count_detail;
  public boolean show_splash_history_list;
  public String syncadapter_control;
  public ByteString translation_hint;
  
  public final int computeSize()
  {
    int i = 0;
    if (this.check_link_url != null) {
      i = 0 + ComputeSizeUtil.computeStringSize(1, this.check_link_url);
    }
    int j = i + ComputeSizeUtil.computeBooleanSize(2, this.disable_mail_proc) + ComputeSizeUtil.computeBooleanSize(3, this.report_unread_count_detail) + ComputeSizeUtil.computeIntegerSize(4, this.bottle_entry) + ComputeSizeUtil.computeBooleanSize(5, this.enable_score_tips);
    i = j;
    if (this.misc_flag != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(6, this.misc_flag);
    }
    j = i;
    if (this.check_app_install != null) {
      j = i + ComputeSizeUtil.computeStringSize(7, this.check_app_install);
    }
    i = j;
    if (this.gmail_error_message != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(8, this.gmail_error_message);
    }
    j = i;
    if (this.phone_call_on2off_check_freq != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(9, this.phone_call_on2off_check_freq);
    }
    i = j;
    if (this.phone_call_off2on_check_freq != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(10, this.phone_call_off2on_check_freq);
    }
    j = i;
    if (this.android_conn_type != -2147483648) {
      j = i + ComputeSizeUtil.computeIntegerSize(11, this.android_conn_type);
    }
    i = j;
    if (this.miscversion != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(12, this.miscversion);
    }
    j = i;
    if (this.push_ack_wifi_freq != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(13, this.push_ack_wifi_freq);
    }
    i = j;
    if (this.push_ack_mobile_freq != -9223372036854775808L) {
      i = j + ComputeSizeUtil.computeLongSize(14, this.push_ack_mobile_freq);
    }
    j = i + ComputeSizeUtil.computeBooleanSize(15, this.show_splash_history_list) + ComputeSizeUtil.computeBooleanSize(16, this.enable_memory_report) + ComputeSizeUtil.computeBooleanSize(17, this.enable_sql_report) + ComputeSizeUtil.computeBooleanSize(18, this.enable_deadlock_report);
    i = j;
    if (this.translation_hint != null) {
      i = j + ComputeSizeUtil.computeByteStringSize(19, this.translation_hint);
    }
    j = i;
    if (this.network_static_report != null) {
      j = i + ComputeSizeUtil.computeStringSize(20, this.network_static_report);
    }
    i = j;
    if (this.syncadapter_control != null) {
      i = j + ComputeSizeUtil.computeStringSize(21, this.syncadapter_control);
    }
    j = i;
    if (this.android_alarm_control != null) {
      j = i + ComputeSizeUtil.computeStringSize(22, this.android_alarm_control);
    }
    i = j;
    if (this.receive_mail_tips_times != -2147483648) {
      i = j + ComputeSizeUtil.computeIntegerSize(23, this.receive_mail_tips_times);
    }
    j = i;
    if (this.receive_mail_tips_interval != -9223372036854775808L) {
      j = i + ComputeSizeUtil.computeLongSize(24, this.receive_mail_tips_interval);
    }
    i = j;
    if (this.android_httpdns_control != null) {
      i = j + ComputeSizeUtil.computeStringSize(25, this.android_httpdns_control);
    }
    j = i;
    if (this.clear_cache_config != null) {
      j = i + ComputeSizeUtil.computeByteStringSize(26, this.clear_cache_config);
    }
    return j;
  }
  
  public final AppMiscConfig parseFrom(byte[] paramArrayOfByte)
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
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, AppMiscConfig paramAppMiscConfig, int paramInt)
    throws IOException
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
      paramAppMiscConfig.check_link_url = paramInputReader.readString(paramInt);
      return true;
    case 2: 
      paramAppMiscConfig.disable_mail_proc = paramInputReader.readBoolean(paramInt);
      return true;
    case 3: 
      paramAppMiscConfig.report_unread_count_detail = paramInputReader.readBoolean(paramInt);
      return true;
    case 4: 
      paramAppMiscConfig.bottle_entry = paramInputReader.readInteger(paramInt);
      return true;
    case 5: 
      paramAppMiscConfig.enable_score_tips = paramInputReader.readBoolean(paramInt);
      return true;
    case 6: 
      paramAppMiscConfig.misc_flag = paramInputReader.readInteger(paramInt);
      return true;
    case 7: 
      paramAppMiscConfig.check_app_install = paramInputReader.readString(paramInt);
      return true;
    case 8: 
      paramAppMiscConfig.gmail_error_message = paramInputReader.readByteString(paramInt);
      return true;
    case 9: 
      paramAppMiscConfig.phone_call_on2off_check_freq = paramInputReader.readInteger(paramInt);
      return true;
    case 10: 
      paramAppMiscConfig.phone_call_off2on_check_freq = paramInputReader.readInteger(paramInt);
      return true;
    case 11: 
      paramAppMiscConfig.android_conn_type = paramInputReader.readInteger(paramInt);
      return true;
    case 12: 
      paramAppMiscConfig.miscversion = paramInputReader.readInteger(paramInt);
      return true;
    case 13: 
      paramAppMiscConfig.push_ack_wifi_freq = paramInputReader.readLong(paramInt);
      return true;
    case 14: 
      paramAppMiscConfig.push_ack_mobile_freq = paramInputReader.readLong(paramInt);
      return true;
    case 15: 
      paramAppMiscConfig.show_splash_history_list = paramInputReader.readBoolean(paramInt);
      return true;
    case 16: 
      paramAppMiscConfig.enable_memory_report = paramInputReader.readBoolean(paramInt);
      return true;
    case 17: 
      paramAppMiscConfig.enable_sql_report = paramInputReader.readBoolean(paramInt);
      return true;
    case 18: 
      paramAppMiscConfig.enable_deadlock_report = paramInputReader.readBoolean(paramInt);
      return true;
    case 19: 
      paramAppMiscConfig.translation_hint = paramInputReader.readByteString(paramInt);
      return true;
    case 20: 
      paramAppMiscConfig.network_static_report = paramInputReader.readString(paramInt);
      return true;
    case 21: 
      paramAppMiscConfig.syncadapter_control = paramInputReader.readString(paramInt);
      return true;
    case 22: 
      paramAppMiscConfig.android_alarm_control = paramInputReader.readString(paramInt);
      return true;
    case 23: 
      paramAppMiscConfig.receive_mail_tips_times = paramInputReader.readInteger(paramInt);
      return true;
    case 24: 
      paramAppMiscConfig.receive_mail_tips_interval = paramInputReader.readLong(paramInt);
      return true;
    case 25: 
      paramAppMiscConfig.android_httpdns_control = paramInputReader.readString(paramInt);
      return true;
    }
    paramAppMiscConfig.clear_cache_config = paramInputReader.readByteString(paramInt);
    return true;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (this.check_link_url != null) {
      paramOutputWriter.writeString(1, this.check_link_url);
    }
    paramOutputWriter.writeBoolean(2, this.disable_mail_proc);
    paramOutputWriter.writeBoolean(3, this.report_unread_count_detail);
    paramOutputWriter.writeInteger(4, this.bottle_entry);
    paramOutputWriter.writeBoolean(5, this.enable_score_tips);
    if (this.misc_flag != -2147483648) {
      paramOutputWriter.writeInteger(6, this.misc_flag);
    }
    if (this.check_app_install != null) {
      paramOutputWriter.writeString(7, this.check_app_install);
    }
    if (this.gmail_error_message != null) {
      paramOutputWriter.writeByteString(8, this.gmail_error_message);
    }
    if (this.phone_call_on2off_check_freq != -2147483648) {
      paramOutputWriter.writeInteger(9, this.phone_call_on2off_check_freq);
    }
    if (this.phone_call_off2on_check_freq != -2147483648) {
      paramOutputWriter.writeInteger(10, this.phone_call_off2on_check_freq);
    }
    if (this.android_conn_type != -2147483648) {
      paramOutputWriter.writeInteger(11, this.android_conn_type);
    }
    if (this.miscversion != -2147483648) {
      paramOutputWriter.writeInteger(12, this.miscversion);
    }
    if (this.push_ack_wifi_freq != -9223372036854775808L) {
      paramOutputWriter.writeLong(13, this.push_ack_wifi_freq);
    }
    if (this.push_ack_mobile_freq != -9223372036854775808L) {
      paramOutputWriter.writeLong(14, this.push_ack_mobile_freq);
    }
    paramOutputWriter.writeBoolean(15, this.show_splash_history_list);
    paramOutputWriter.writeBoolean(16, this.enable_memory_report);
    paramOutputWriter.writeBoolean(17, this.enable_sql_report);
    paramOutputWriter.writeBoolean(18, this.enable_deadlock_report);
    if (this.translation_hint != null) {
      paramOutputWriter.writeByteString(19, this.translation_hint);
    }
    if (this.network_static_report != null) {
      paramOutputWriter.writeString(20, this.network_static_report);
    }
    if (this.syncadapter_control != null) {
      paramOutputWriter.writeString(21, this.syncadapter_control);
    }
    if (this.android_alarm_control != null) {
      paramOutputWriter.writeString(22, this.android_alarm_control);
    }
    if (this.receive_mail_tips_times != -2147483648) {
      paramOutputWriter.writeInteger(23, this.receive_mail_tips_times);
    }
    if (this.receive_mail_tips_interval != -9223372036854775808L) {
      paramOutputWriter.writeLong(24, this.receive_mail_tips_interval);
    }
    if (this.android_httpdns_control != null) {
      paramOutputWriter.writeString(25, this.android_httpdns_control);
    }
    if (this.clear_cache_config != null) {
      paramOutputWriter.writeByteString(26, this.clear_cache_config);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.AppMiscConfig
 * JD-Core Version:    0.7.0.1
 */