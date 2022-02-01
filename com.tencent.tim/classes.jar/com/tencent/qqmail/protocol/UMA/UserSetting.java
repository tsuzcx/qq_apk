package com.tencent.qqmail.protocol.UMA;

import com.tencent.qqmail.protobuf.BaseProtoBuf;
import com.tencent.qqmail.protobuf.ByteString;
import java.io.IOException;
import java.util.BitSet;
import java.util.LinkedList;
import net.jarlehansen.protobuf.ComputeSizeUtil;
import net.jarlehansen.protobuf.input.InputReader;
import net.jarlehansen.protobuf.output.OutputWriter;

public final class UserSetting
  extends BaseProtoBuf
{
  private static final int fieldNumberAccount = 2;
  private static final int fieldNumberGlobal = 1;
  private LinkedList<Account> account = new LinkedList();
  private final BitSet bit = new BitSet();
  private Global global;
  
  private boolean hasBit(int paramInt)
  {
    return this.bit.get(paramInt);
  }
  
  private void setBit(int paramInt)
  {
    this.bit.set(paramInt);
  }
  
  public final LinkedList<Account> account()
  {
    return this.account;
  }
  
  public final int computeSize()
  {
    int i = 0;
    if (has_global()) {
      i = 0 + ComputeSizeUtil.computeMessageSize(1, this.global.computeSize());
    }
    int j = i;
    if (has_account()) {
      j = i + ComputeSizeUtil.computeListSize(2, 8, this.account);
    }
    return j;
  }
  
  public final Global global()
  {
    return this.global;
  }
  
  public final boolean has_account()
  {
    return hasBit(2);
  }
  
  public final boolean has_global()
  {
    return hasBit(1);
  }
  
  public final UserSetting parseFrom(byte[] paramArrayOfByte)
    throws IOException
  {
    this.account.clear();
    paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
    for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
      if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
        paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
      }
    }
    return this;
  }
  
  public final boolean populateBuilderWithField(InputReader paramInputReader, UserSetting paramUserSetting, int paramInt)
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
      paramUserSetting.setBit(paramInt);
      paramInputReader = paramInputReader.readMessages(paramInt);
      i = paramInputReader.size();
      paramInt = 0;
      while (paramInt < i)
      {
        localObject2 = (byte[])paramInputReader.get(paramInt);
        localObject1 = new Global();
        localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
        for (bool = true; bool; bool = ((Global)localObject1).populateBuilderWithField((InputReader)localObject2, (Global)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
        paramUserSetting.global = ((Global)localObject1);
        paramInt += 1;
      }
      return true;
    }
    paramUserSetting.setBit(paramInt);
    paramInputReader = paramInputReader.readMessages(paramInt);
    int i = paramInputReader.size();
    paramInt = 0;
    while (paramInt < i)
    {
      localObject2 = (byte[])paramInputReader.get(paramInt);
      localObject1 = new Account();
      localObject2 = new InputReader((byte[])localObject2, unknownTagHandler);
      for (bool = true; bool; bool = ((Account)localObject1).populateBuilderWithField((InputReader)localObject2, (Account)localObject1, getNextFieldNumber((InputReader)localObject2))) {}
      paramUserSetting.account.add(localObject1);
      paramInt += 1;
    }
    return true;
  }
  
  public final void set_account(LinkedList<Account> paramLinkedList)
  {
    setBit(2);
    this.account = paramLinkedList;
  }
  
  public final void set_global(Global paramGlobal)
  {
    setBit(1);
    this.global = paramGlobal;
  }
  
  public final void writeFields(OutputWriter paramOutputWriter)
    throws IOException
  {
    if (has_global())
    {
      paramOutputWriter.writeMessage(1, this.global.computeSize());
      this.global.writeFields(paramOutputWriter);
    }
    if (has_account()) {
      paramOutputWriter.writeList(2, 8, this.account);
    }
  }
  
  public static final class Account
    extends BaseProtoBuf
  {
    private static final int fieldNumberAccount_id = 1;
    private static final int fieldNumberAggregate_bysubject = 9;
    private static final int fieldNumberGet_newmail_freq = 8;
    private static final int fieldNumberNewmail_push_way = 5;
    private static final int fieldNumberNotify_calstorage = 4;
    private static final int fieldNumberNotify_newmail = 3;
    private static final int fieldNumberOnly_notify_inbox = 2;
    private static final int fieldNumberPersonal_signature = 7;
    private static final int fieldNumberSync_mail_count = 6;
    private int account_id = -2147483648;
    private boolean aggregate_bysubject = true;
    private final BitSet bit = new BitSet();
    private int get_newmail_freq = 0;
    private int newmail_push_way = 0;
    private boolean notify_calstorage = true;
    private boolean notify_newmail = true;
    private boolean only_notify_inbox;
    private String personal_signature = "";
    private int sync_mail_count = 0;
    
    private boolean hasBit(int paramInt)
    {
      return this.bit.get(paramInt);
    }
    
    private void setBit(int paramInt)
    {
      this.bit.set(paramInt);
    }
    
    public final int account_id()
    {
      return this.account_id;
    }
    
    public final boolean aggregate_bysubject()
    {
      return this.aggregate_bysubject;
    }
    
    public final int computeSize()
    {
      int j = 0;
      if (has_account_id()) {
        j = 0 + ComputeSizeUtil.computeIntegerSize(1, this.account_id);
      }
      int i = j;
      if (has_only_notify_inbox()) {
        i = j + ComputeSizeUtil.computeBooleanSize(2, this.only_notify_inbox);
      }
      j = i;
      if (has_notify_newmail()) {
        j = i + ComputeSizeUtil.computeBooleanSize(3, this.notify_newmail);
      }
      i = j;
      if (has_notify_calstorage()) {
        i = j + ComputeSizeUtil.computeBooleanSize(4, this.notify_calstorage);
      }
      j = i;
      if (has_newmail_push_way()) {
        j = i + ComputeSizeUtil.computeIntegerSize(5, this.newmail_push_way);
      }
      i = j;
      if (has_sync_mail_count()) {
        i = j + ComputeSizeUtil.computeIntegerSize(6, this.sync_mail_count);
      }
      j = i;
      if (has_personal_signature()) {
        j = i + ComputeSizeUtil.computeStringSize(7, this.personal_signature);
      }
      i = j;
      if (has_get_newmail_freq()) {
        i = j + ComputeSizeUtil.computeIntegerSize(8, this.get_newmail_freq);
      }
      j = i;
      if (has_aggregate_bysubject()) {
        j = i + ComputeSizeUtil.computeBooleanSize(9, this.aggregate_bysubject);
      }
      return j;
    }
    
    public final int get_newmail_freq()
    {
      return this.get_newmail_freq;
    }
    
    public final boolean has_account_id()
    {
      return hasBit(1);
    }
    
    public final boolean has_aggregate_bysubject()
    {
      return hasBit(9);
    }
    
    public final boolean has_get_newmail_freq()
    {
      return hasBit(8);
    }
    
    public final boolean has_newmail_push_way()
    {
      return hasBit(5);
    }
    
    public final boolean has_notify_calstorage()
    {
      return hasBit(4);
    }
    
    public final boolean has_notify_newmail()
    {
      return hasBit(3);
    }
    
    public final boolean has_only_notify_inbox()
    {
      return hasBit(2);
    }
    
    public final boolean has_personal_signature()
    {
      return hasBit(7);
    }
    
    public final boolean has_sync_mail_count()
    {
      return hasBit(6);
    }
    
    public final int newmail_push_way()
    {
      return this.newmail_push_way;
    }
    
    public final boolean notify_calstorage()
    {
      return this.notify_calstorage;
    }
    
    public final boolean notify_newmail()
    {
      return this.notify_newmail;
    }
    
    public final boolean only_notify_inbox()
    {
      return this.only_notify_inbox;
    }
    
    public final Account parseFrom(byte[] paramArrayOfByte)
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
    
    public final String personal_signature()
    {
      return this.personal_signature;
    }
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, Account paramAccount, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramAccount.setBit(paramInt);
        paramAccount.account_id = paramInputReader.readInteger(paramInt);
        return true;
      case 2: 
        paramAccount.setBit(paramInt);
        paramAccount.only_notify_inbox = paramInputReader.readBoolean(paramInt);
        return true;
      case 3: 
        paramAccount.setBit(paramInt);
        paramAccount.notify_newmail = paramInputReader.readBoolean(paramInt);
        return true;
      case 4: 
        paramAccount.setBit(paramInt);
        paramAccount.notify_calstorage = paramInputReader.readBoolean(paramInt);
        return true;
      case 5: 
        paramAccount.setBit(paramInt);
        paramAccount.newmail_push_way = paramInputReader.readInteger(paramInt);
        return true;
      case 6: 
        paramAccount.setBit(paramInt);
        paramAccount.sync_mail_count = paramInputReader.readInteger(paramInt);
        return true;
      case 7: 
        paramAccount.setBit(paramInt);
        paramAccount.personal_signature = paramInputReader.readString(paramInt);
        return true;
      case 8: 
        paramAccount.setBit(paramInt);
        paramAccount.get_newmail_freq = paramInputReader.readInteger(paramInt);
        return true;
      }
      paramAccount.setBit(paramInt);
      paramAccount.aggregate_bysubject = paramInputReader.readBoolean(paramInt);
      return true;
    }
    
    public final void set_account_id(int paramInt)
    {
      setBit(1);
      this.account_id = paramInt;
    }
    
    public final void set_aggregate_bysubject(boolean paramBoolean)
    {
      setBit(9);
      this.aggregate_bysubject = paramBoolean;
    }
    
    public final void set_get_newmail_freq(int paramInt)
    {
      setBit(8);
      this.get_newmail_freq = paramInt;
    }
    
    public final void set_newmail_push_way(int paramInt)
    {
      setBit(5);
      this.newmail_push_way = paramInt;
    }
    
    public final void set_notify_calstorage(boolean paramBoolean)
    {
      setBit(4);
      this.notify_calstorage = paramBoolean;
    }
    
    public final void set_notify_newmail(boolean paramBoolean)
    {
      setBit(3);
      this.notify_newmail = paramBoolean;
    }
    
    public final void set_only_notify_inbox(boolean paramBoolean)
    {
      setBit(2);
      this.only_notify_inbox = paramBoolean;
    }
    
    public final void set_personal_signature(String paramString)
    {
      setBit(7);
      this.personal_signature = paramString;
    }
    
    public final void set_sync_mail_count(int paramInt)
    {
      setBit(6);
      this.sync_mail_count = paramInt;
    }
    
    public final int sync_mail_count()
    {
      return this.sync_mail_count;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      if (has_account_id()) {
        paramOutputWriter.writeInteger(1, this.account_id);
      }
      if (has_only_notify_inbox()) {
        paramOutputWriter.writeBoolean(2, this.only_notify_inbox);
      }
      if (has_notify_newmail()) {
        paramOutputWriter.writeBoolean(3, this.notify_newmail);
      }
      if (has_notify_calstorage()) {
        paramOutputWriter.writeBoolean(4, this.notify_calstorage);
      }
      if (has_newmail_push_way()) {
        paramOutputWriter.writeInteger(5, this.newmail_push_way);
      }
      if (has_sync_mail_count()) {
        paramOutputWriter.writeInteger(6, this.sync_mail_count);
      }
      if (has_personal_signature()) {
        paramOutputWriter.writeString(7, this.personal_signature);
      }
      if (has_get_newmail_freq()) {
        paramOutputWriter.writeInteger(8, this.get_newmail_freq);
      }
      if (has_aggregate_bysubject()) {
        paramOutputWriter.writeBoolean(9, this.aggregate_bysubject);
      }
    }
  }
  
  public static final class Global
    extends BaseProtoBuf
  {
    private static final int fieldNumberAggregate_ad_mail = 8;
    private static final int fieldNumberAggregate_subscribed_mail = 5;
    private static final int fieldNumberApplication_in_home = 22;
    private static final int fieldNumberAppversion = 24;
    private static final int fieldNumberEnable_incremental_unread_count = 23;
    private static final int fieldNumberEnable_notify_detail = 25;
    private static final int fieldNumberEnable_osslog = 10;
    private static final int fieldNumberEnable_realTimeCall = 21;
    private static final int fieldNumberEnable_send_sound = 16;
    private static final int fieldNumberEnable_sound = 9;
    private static final int fieldNumberFont_size = 20;
    private static final int fieldNumberGesture_password = 14;
    private static final int fieldNumberIncoming_sound = 6;
    private static final int fieldNumberLoad_pic_function = 13;
    private static final int fieldNumberMaillist_icon = 12;
    private static final int fieldNumberNewmail_shake_onusing = 15;
    private static final int fieldNumberNotify_admail = 11;
    private static final int fieldNumberNotify_newmail = 4;
    private static final int fieldNumberOnly_notify_vip = 1;
    private static final int fieldNumberPlp_bind_uin = 17;
    private static final int fieldNumberSys_config = 19;
    private static final int fieldNumberTimezone = 3;
    private static final int fieldNumberUa_config = 18;
    private static final int fieldNumberUse_night_mode = 2;
    private static final int fieldNumberVip_incoming_sound = 7;
    private boolean aggregate_ad_mail = true;
    private boolean aggregate_subscribed_mail = true;
    private LinkedList<Integer> application_in_home = new LinkedList();
    private ByteString appversion;
    private final BitSet bit = new BitSet();
    private boolean enable_incremental_unread_count = true;
    private boolean enable_notify_detail = true;
    private boolean enable_osslog = true;
    private boolean enable_realTimeCall = true;
    private boolean enable_send_sound = true;
    private boolean enable_sound = true;
    private int font_size = 0;
    private String gesture_password = "";
    private String incoming_sound = "default";
    private int load_pic_function = 0;
    private boolean maillist_icon = false;
    private boolean newmail_shake_onusing = true;
    private boolean notify_admail = true;
    private boolean notify_newmail = true;
    private boolean only_notify_vip = false;
    private long plp_bind_uin = 0L;
    private String sys_config;
    private int timezone = 8;
    private String ua_config;
    private boolean use_night_mode = true;
    private String vip_incoming_sound = "default";
    
    private boolean hasBit(int paramInt)
    {
      return this.bit.get(paramInt);
    }
    
    private void setBit(int paramInt)
    {
      this.bit.set(paramInt);
    }
    
    public final boolean aggregate_ad_mail()
    {
      return this.aggregate_ad_mail;
    }
    
    public final boolean aggregate_subscribed_mail()
    {
      return this.aggregate_subscribed_mail;
    }
    
    public final LinkedList<Integer> application_in_home()
    {
      return this.application_in_home;
    }
    
    public final ByteString appversion()
    {
      return this.appversion;
    }
    
    public final int computeSize()
    {
      int j = 0;
      if (has_only_notify_vip()) {
        j = 0 + ComputeSizeUtil.computeBooleanSize(1, this.only_notify_vip);
      }
      int i = j;
      if (has_use_night_mode()) {
        i = j + ComputeSizeUtil.computeBooleanSize(2, this.use_night_mode);
      }
      j = i;
      if (has_timezone()) {
        j = i + ComputeSizeUtil.computeIntegerSize(3, this.timezone);
      }
      i = j;
      if (has_notify_newmail()) {
        i = j + ComputeSizeUtil.computeBooleanSize(4, this.notify_newmail);
      }
      j = i;
      if (has_aggregate_subscribed_mail()) {
        j = i + ComputeSizeUtil.computeBooleanSize(5, this.aggregate_subscribed_mail);
      }
      i = j;
      if (has_incoming_sound()) {
        i = j + ComputeSizeUtil.computeStringSize(6, this.incoming_sound);
      }
      j = i;
      if (has_vip_incoming_sound()) {
        j = i + ComputeSizeUtil.computeStringSize(7, this.vip_incoming_sound);
      }
      i = j;
      if (has_aggregate_ad_mail()) {
        i = j + ComputeSizeUtil.computeBooleanSize(8, this.aggregate_ad_mail);
      }
      j = i;
      if (has_enable_sound()) {
        j = i + ComputeSizeUtil.computeBooleanSize(9, this.enable_sound);
      }
      i = j;
      if (has_enable_osslog()) {
        i = j + ComputeSizeUtil.computeBooleanSize(10, this.enable_osslog);
      }
      j = i;
      if (has_notify_admail()) {
        j = i + ComputeSizeUtil.computeBooleanSize(11, this.notify_admail);
      }
      i = j;
      if (has_maillist_icon()) {
        i = j + ComputeSizeUtil.computeBooleanSize(12, this.maillist_icon);
      }
      j = i;
      if (has_load_pic_function()) {
        j = i + ComputeSizeUtil.computeIntegerSize(13, this.load_pic_function);
      }
      i = j;
      if (has_gesture_password()) {
        i = j + ComputeSizeUtil.computeStringSize(14, this.gesture_password);
      }
      j = i;
      if (has_newmail_shake_onusing()) {
        j = i + ComputeSizeUtil.computeBooleanSize(15, this.newmail_shake_onusing);
      }
      i = j;
      if (has_enable_send_sound()) {
        i = j + ComputeSizeUtil.computeBooleanSize(16, this.enable_send_sound);
      }
      j = i;
      if (has_plp_bind_uin()) {
        j = i + ComputeSizeUtil.computeLongSize(17, this.plp_bind_uin);
      }
      i = j;
      if (has_ua_config()) {
        i = j + ComputeSizeUtil.computeStringSize(18, this.ua_config);
      }
      j = i;
      if (has_sys_config()) {
        j = i + ComputeSizeUtil.computeStringSize(19, this.sys_config);
      }
      i = j;
      if (has_font_size()) {
        i = j + ComputeSizeUtil.computeIntegerSize(20, this.font_size);
      }
      j = i;
      if (has_enable_realTimeCall()) {
        j = i + ComputeSizeUtil.computeBooleanSize(21, this.enable_realTimeCall);
      }
      i = j;
      if (has_application_in_home()) {
        i = j + ComputeSizeUtil.computeListSize(22, 2, this.application_in_home);
      }
      j = i;
      if (has_enable_incremental_unread_count()) {
        j = i + ComputeSizeUtil.computeBooleanSize(23, this.enable_incremental_unread_count);
      }
      i = j;
      if (has_appversion()) {
        i = j + ComputeSizeUtil.computeByteStringSize(24, this.appversion);
      }
      j = i;
      if (has_enable_notify_detail()) {
        j = i + ComputeSizeUtil.computeBooleanSize(25, this.enable_notify_detail);
      }
      return j;
    }
    
    public final boolean enable_incremental_unread_count()
    {
      return this.enable_incremental_unread_count;
    }
    
    public final boolean enable_notify_detail()
    {
      return this.enable_notify_detail;
    }
    
    public final boolean enable_osslog()
    {
      return this.enable_osslog;
    }
    
    public final boolean enable_realTimeCall()
    {
      return this.enable_realTimeCall;
    }
    
    public final boolean enable_send_sound()
    {
      return this.enable_send_sound;
    }
    
    public final boolean enable_sound()
    {
      return this.enable_sound;
    }
    
    public final int font_size()
    {
      return this.font_size;
    }
    
    public final String gesture_password()
    {
      return this.gesture_password;
    }
    
    public final boolean has_aggregate_ad_mail()
    {
      return hasBit(8);
    }
    
    public final boolean has_aggregate_subscribed_mail()
    {
      return hasBit(5);
    }
    
    public final boolean has_application_in_home()
    {
      return hasBit(22);
    }
    
    public final boolean has_appversion()
    {
      return hasBit(24);
    }
    
    public final boolean has_enable_incremental_unread_count()
    {
      return hasBit(23);
    }
    
    public final boolean has_enable_notify_detail()
    {
      return hasBit(25);
    }
    
    public final boolean has_enable_osslog()
    {
      return hasBit(10);
    }
    
    public final boolean has_enable_realTimeCall()
    {
      return hasBit(21);
    }
    
    public final boolean has_enable_send_sound()
    {
      return hasBit(16);
    }
    
    public final boolean has_enable_sound()
    {
      return hasBit(9);
    }
    
    public final boolean has_font_size()
    {
      return hasBit(20);
    }
    
    public final boolean has_gesture_password()
    {
      return hasBit(14);
    }
    
    public final boolean has_incoming_sound()
    {
      return hasBit(6);
    }
    
    public final boolean has_load_pic_function()
    {
      return hasBit(13);
    }
    
    public final boolean has_maillist_icon()
    {
      return hasBit(12);
    }
    
    public final boolean has_newmail_shake_onusing()
    {
      return hasBit(15);
    }
    
    public final boolean has_notify_admail()
    {
      return hasBit(11);
    }
    
    public final boolean has_notify_newmail()
    {
      return hasBit(4);
    }
    
    public final boolean has_only_notify_vip()
    {
      return hasBit(1);
    }
    
    public final boolean has_plp_bind_uin()
    {
      return hasBit(17);
    }
    
    public final boolean has_sys_config()
    {
      return hasBit(19);
    }
    
    public final boolean has_timezone()
    {
      return hasBit(3);
    }
    
    public final boolean has_ua_config()
    {
      return hasBit(18);
    }
    
    public final boolean has_use_night_mode()
    {
      return hasBit(2);
    }
    
    public final boolean has_vip_incoming_sound()
    {
      return hasBit(7);
    }
    
    public final String incoming_sound()
    {
      return this.incoming_sound;
    }
    
    public final int load_pic_function()
    {
      return this.load_pic_function;
    }
    
    public final boolean maillist_icon()
    {
      return this.maillist_icon;
    }
    
    public final boolean newmail_shake_onusing()
    {
      return this.newmail_shake_onusing;
    }
    
    public final boolean notify_admail()
    {
      return this.notify_admail;
    }
    
    public final boolean notify_newmail()
    {
      return this.notify_newmail;
    }
    
    public final boolean only_notify_vip()
    {
      return this.only_notify_vip;
    }
    
    public final Global parseFrom(byte[] paramArrayOfByte)
      throws IOException
    {
      this.application_in_home.clear();
      paramArrayOfByte = new InputReader(paramArrayOfByte, unknownTagHandler);
      for (int i = getNextFieldNumber(paramArrayOfByte); i > 0; i = getNextFieldNumber(paramArrayOfByte)) {
        if (!populateBuilderWithField(paramArrayOfByte, this, i)) {
          paramArrayOfByte.getPreviousTagDataTypeAndReadContent();
        }
      }
      return this;
    }
    
    public final long plp_bind_uin()
    {
      return this.plp_bind_uin;
    }
    
    public final boolean populateBuilderWithField(InputReader paramInputReader, Global paramGlobal, int paramInt)
      throws IOException
    {
      switch (paramInt)
      {
      default: 
        return false;
      case 1: 
        paramGlobal.setBit(paramInt);
        paramGlobal.only_notify_vip = paramInputReader.readBoolean(paramInt);
        return true;
      case 2: 
        paramGlobal.setBit(paramInt);
        paramGlobal.use_night_mode = paramInputReader.readBoolean(paramInt);
        return true;
      case 3: 
        paramGlobal.setBit(paramInt);
        paramGlobal.timezone = paramInputReader.readInteger(paramInt);
        return true;
      case 4: 
        paramGlobal.setBit(paramInt);
        paramGlobal.notify_newmail = paramInputReader.readBoolean(paramInt);
        return true;
      case 5: 
        paramGlobal.setBit(paramInt);
        paramGlobal.aggregate_subscribed_mail = paramInputReader.readBoolean(paramInt);
        return true;
      case 6: 
        paramGlobal.setBit(paramInt);
        paramGlobal.incoming_sound = paramInputReader.readString(paramInt);
        return true;
      case 7: 
        paramGlobal.setBit(paramInt);
        paramGlobal.vip_incoming_sound = paramInputReader.readString(paramInt);
        return true;
      case 8: 
        paramGlobal.setBit(paramInt);
        paramGlobal.aggregate_ad_mail = paramInputReader.readBoolean(paramInt);
        return true;
      case 9: 
        paramGlobal.setBit(paramInt);
        paramGlobal.enable_sound = paramInputReader.readBoolean(paramInt);
        return true;
      case 10: 
        paramGlobal.setBit(paramInt);
        paramGlobal.enable_osslog = paramInputReader.readBoolean(paramInt);
        return true;
      case 11: 
        paramGlobal.setBit(paramInt);
        paramGlobal.notify_admail = paramInputReader.readBoolean(paramInt);
        return true;
      case 12: 
        paramGlobal.setBit(paramInt);
        paramGlobal.maillist_icon = paramInputReader.readBoolean(paramInt);
        return true;
      case 13: 
        paramGlobal.setBit(paramInt);
        paramGlobal.load_pic_function = paramInputReader.readInteger(paramInt);
        return true;
      case 14: 
        paramGlobal.setBit(paramInt);
        paramGlobal.gesture_password = paramInputReader.readString(paramInt);
        return true;
      case 15: 
        paramGlobal.setBit(paramInt);
        paramGlobal.newmail_shake_onusing = paramInputReader.readBoolean(paramInt);
        return true;
      case 16: 
        paramGlobal.setBit(paramInt);
        paramGlobal.enable_send_sound = paramInputReader.readBoolean(paramInt);
        return true;
      case 17: 
        paramGlobal.setBit(paramInt);
        paramGlobal.plp_bind_uin = paramInputReader.readLong(paramInt);
        return true;
      case 18: 
        paramGlobal.setBit(paramInt);
        paramGlobal.ua_config = paramInputReader.readString(paramInt);
        return true;
      case 19: 
        paramGlobal.setBit(paramInt);
        paramGlobal.sys_config = paramInputReader.readString(paramInt);
        return true;
      case 20: 
        paramGlobal.setBit(paramInt);
        paramGlobal.font_size = paramInputReader.readInteger(paramInt);
        return true;
      case 21: 
        paramGlobal.setBit(paramInt);
        paramGlobal.enable_realTimeCall = paramInputReader.readBoolean(paramInt);
        return true;
      case 22: 
        paramGlobal.setBit(paramInt);
        paramGlobal.application_in_home.add(Integer.valueOf(paramInputReader.readInteger(paramInt)));
        return true;
      case 23: 
        paramGlobal.setBit(paramInt);
        paramGlobal.enable_incremental_unread_count = paramInputReader.readBoolean(paramInt);
        return true;
      case 24: 
        paramGlobal.setBit(paramInt);
        paramGlobal.appversion = paramInputReader.readByteString(paramInt);
        return true;
      }
      paramGlobal.setBit(paramInt);
      paramGlobal.enable_notify_detail = paramInputReader.readBoolean(paramInt);
      return true;
    }
    
    public final void set_aggregate_ad_mail(boolean paramBoolean)
    {
      setBit(8);
      this.aggregate_ad_mail = paramBoolean;
    }
    
    public final void set_aggregate_subscribed_mail(boolean paramBoolean)
    {
      setBit(5);
      this.aggregate_subscribed_mail = paramBoolean;
    }
    
    public final void set_application_in_home(LinkedList<Integer> paramLinkedList)
    {
      setBit(22);
      this.application_in_home = paramLinkedList;
    }
    
    public final void set_appversion(ByteString paramByteString)
    {
      setBit(24);
      this.appversion = paramByteString;
    }
    
    public final void set_enable_incremental_unread_count(boolean paramBoolean)
    {
      setBit(23);
      this.enable_incremental_unread_count = paramBoolean;
    }
    
    public final void set_enable_notify_detail(boolean paramBoolean)
    {
      setBit(25);
      this.enable_notify_detail = paramBoolean;
    }
    
    public final void set_enable_osslog(boolean paramBoolean)
    {
      setBit(10);
      this.enable_osslog = paramBoolean;
    }
    
    public final void set_enable_realTimeCall(boolean paramBoolean)
    {
      setBit(21);
      this.enable_realTimeCall = paramBoolean;
    }
    
    public final void set_enable_send_sound(boolean paramBoolean)
    {
      setBit(16);
      this.enable_send_sound = paramBoolean;
    }
    
    public final void set_enable_sound(boolean paramBoolean)
    {
      setBit(9);
      this.enable_sound = paramBoolean;
    }
    
    public final void set_font_size(int paramInt)
    {
      setBit(20);
      this.font_size = paramInt;
    }
    
    public final void set_gesture_password(String paramString)
    {
      setBit(14);
      this.gesture_password = paramString;
    }
    
    public final void set_incoming_sound(String paramString)
    {
      setBit(6);
      this.incoming_sound = paramString;
    }
    
    public final void set_load_pic_function(int paramInt)
    {
      setBit(13);
      this.load_pic_function = paramInt;
    }
    
    public final void set_maillist_icon(boolean paramBoolean)
    {
      setBit(12);
      this.maillist_icon = paramBoolean;
    }
    
    public final void set_newmail_shake_onusing(boolean paramBoolean)
    {
      setBit(15);
      this.newmail_shake_onusing = paramBoolean;
    }
    
    public final void set_notify_admail(boolean paramBoolean)
    {
      setBit(11);
      this.notify_admail = paramBoolean;
    }
    
    public final void set_notify_newmail(boolean paramBoolean)
    {
      setBit(4);
      this.notify_newmail = paramBoolean;
    }
    
    public final void set_only_notify_vip(boolean paramBoolean)
    {
      setBit(1);
      this.only_notify_vip = paramBoolean;
    }
    
    public final void set_plp_bind_uin(long paramLong)
    {
      setBit(17);
      this.plp_bind_uin = paramLong;
    }
    
    public final void set_sys_config(String paramString)
    {
      setBit(19);
      this.sys_config = paramString;
    }
    
    public final void set_timezone(int paramInt)
    {
      setBit(3);
      this.timezone = paramInt;
    }
    
    public final void set_ua_config(String paramString)
    {
      setBit(18);
      this.ua_config = paramString;
    }
    
    public final void set_use_night_mode(boolean paramBoolean)
    {
      setBit(2);
      this.use_night_mode = paramBoolean;
    }
    
    public final void set_vip_incoming_sound(String paramString)
    {
      setBit(7);
      this.vip_incoming_sound = paramString;
    }
    
    public final String sys_config()
    {
      return this.sys_config;
    }
    
    public final int timezone()
    {
      return this.timezone;
    }
    
    public final String ua_config()
    {
      return this.ua_config;
    }
    
    public final boolean use_night_mode()
    {
      return this.use_night_mode;
    }
    
    public final String vip_incoming_sound()
    {
      return this.vip_incoming_sound;
    }
    
    public final void writeFields(OutputWriter paramOutputWriter)
      throws IOException
    {
      if (has_only_notify_vip()) {
        paramOutputWriter.writeBoolean(1, this.only_notify_vip);
      }
      if (has_use_night_mode()) {
        paramOutputWriter.writeBoolean(2, this.use_night_mode);
      }
      if (has_timezone()) {
        paramOutputWriter.writeInteger(3, this.timezone);
      }
      if (has_notify_newmail()) {
        paramOutputWriter.writeBoolean(4, this.notify_newmail);
      }
      if (has_aggregate_subscribed_mail()) {
        paramOutputWriter.writeBoolean(5, this.aggregate_subscribed_mail);
      }
      if (has_incoming_sound()) {
        paramOutputWriter.writeString(6, this.incoming_sound);
      }
      if (has_vip_incoming_sound()) {
        paramOutputWriter.writeString(7, this.vip_incoming_sound);
      }
      if (has_aggregate_ad_mail()) {
        paramOutputWriter.writeBoolean(8, this.aggregate_ad_mail);
      }
      if (has_enable_sound()) {
        paramOutputWriter.writeBoolean(9, this.enable_sound);
      }
      if (has_enable_osslog()) {
        paramOutputWriter.writeBoolean(10, this.enable_osslog);
      }
      if (has_notify_admail()) {
        paramOutputWriter.writeBoolean(11, this.notify_admail);
      }
      if (has_maillist_icon()) {
        paramOutputWriter.writeBoolean(12, this.maillist_icon);
      }
      if (has_load_pic_function()) {
        paramOutputWriter.writeInteger(13, this.load_pic_function);
      }
      if (has_gesture_password()) {
        paramOutputWriter.writeString(14, this.gesture_password);
      }
      if (has_newmail_shake_onusing()) {
        paramOutputWriter.writeBoolean(15, this.newmail_shake_onusing);
      }
      if (has_enable_send_sound()) {
        paramOutputWriter.writeBoolean(16, this.enable_send_sound);
      }
      if (has_plp_bind_uin()) {
        paramOutputWriter.writeLong(17, this.plp_bind_uin);
      }
      if (has_ua_config()) {
        paramOutputWriter.writeString(18, this.ua_config);
      }
      if (has_sys_config()) {
        paramOutputWriter.writeString(19, this.sys_config);
      }
      if (has_font_size()) {
        paramOutputWriter.writeInteger(20, this.font_size);
      }
      if (has_enable_realTimeCall()) {
        paramOutputWriter.writeBoolean(21, this.enable_realTimeCall);
      }
      if (has_application_in_home()) {
        paramOutputWriter.writeList(22, 2, this.application_in_home);
      }
      if (has_enable_incremental_unread_count()) {
        paramOutputWriter.writeBoolean(23, this.enable_incremental_unread_count);
      }
      if (has_appversion()) {
        paramOutputWriter.writeByteString(24, this.appversion);
      }
      if (has_enable_notify_detail()) {
        paramOutputWriter.writeBoolean(25, this.enable_notify_detail);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.protocol.UMA.UserSetting
 * JD-Core Version:    0.7.0.1
 */