package com.tencent.pb.oac;

import com.tencent.mobileqq.mp.mobileqq_mp.GetPublicAccountMenuResponse;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class OACProfilePb
{
  public static final class BaseData
    extends MessageMicro<BaseData>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 48, 56, 64, 72, 80, 240, 248, 256 }, new String[] { "puin", "name", "display_number", "summary", "unified_account_descrpition", "is_recv_msg", "is_recv_push", "account_type", "follow_type", "is_show_follow_button", "account_flag", "account_flag2", "account_flag3" }, new Object[] { Long.valueOf(0L), "", "", "", "", Boolean.valueOf(false), Boolean.valueOf(false), Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L) }, BaseData.class);
    public final PBUInt32Field account_flag = PBField.initUInt32(0);
    public final PBUInt64Field account_flag2 = PBField.initUInt64(0L);
    public final PBUInt64Field account_flag3 = PBField.initUInt64(0L);
    public final PBUInt32Field account_type = PBField.initUInt32(0);
    public final PBStringField display_number = PBField.initString("");
    public final PBUInt32Field follow_type = PBField.initUInt32(0);
    public final PBBoolField is_recv_msg = PBField.initBool(false);
    public final PBBoolField is_recv_push = PBField.initBool(false);
    public final PBBoolField is_show_follow_button = PBField.initBool(false);
    public final PBStringField name = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0L);
    public final PBStringField summary = PBField.initString("");
    public final PBStringField unified_account_descrpition = PBField.initString("");
  }
  
  public static final class ProfileDataReq
    extends MessageMicro<ProfileDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "puin", "attachinfo" }, new Object[] { Long.valueOf(0L), "" }, ProfileDataReq.class);
    public final PBStringField attachinfo = PBField.initString("");
    public final PBUInt64Field puin = PBField.initUInt64(0L);
  }
  
  public static final class ProfileDataRsp
    extends MessageMicro<ProfileDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 34 }, new String[] { "base_data", "common_follower_count", "menu_rsp", "attachinfo" }, new Object[] { null, Integer.valueOf(0), null, "" }, ProfileDataRsp.class);
    public final PBStringField attachinfo = PBField.initString("");
    public OACProfilePb.BaseData base_data = new OACProfilePb.BaseData();
    public final PBUInt32Field common_follower_count = PBField.initUInt32(0);
    public mobileqq_mp.GetPublicAccountMenuResponse menu_rsp = new mobileqq_mp.GetPublicAccountMenuResponse();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.pb.oac.OACProfilePb
 * JD-Core Version:    0.7.0.1
 */