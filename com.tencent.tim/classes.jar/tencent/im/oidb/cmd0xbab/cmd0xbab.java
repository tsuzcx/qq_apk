package tencent.im.oidb.cmd0xbab;

import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class cmd0xbab
{
  public static final class GroupGetReq
    extends MessageMicro<GroupGetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "group_code", "doc_url" }, new Object[] { Long.valueOf(0L), "" }, GroupGetReq.class);
    public final PBStringField doc_url = PBField.initString("");
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
  }
  
  public static final class GroupGetRsp
    extends MessageMicro<GroupGetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48, 56, 64 }, new String[] { "policy", "user_list", "total_members", "privilege_members", "member_number", "exp_remain_time", "exp_set_time", "privilege_flag" }, new Object[] { Integer.valueOf(0), null, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, GroupGetRsp.class);
    public final PBUInt32Field exp_remain_time = PBField.initUInt32(0);
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
    public final PBUInt32Field member_number = PBField.initUInt32(0);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
    public final PBUInt32Field privilege_members = PBField.initUInt32(0);
    public final PBUInt32Field total_members = PBField.initUInt32(0);
    public final PBRepeatMessageField<cmd0xbab.UserInfo> user_list = PBField.initRepeatMessage(cmd0xbab.UserInfo.class);
  }
  
  public static final class GroupSetReq
    extends MessageMicro<GroupSetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "group_code", "doc_url", "privilege_flag", "policy", "only", "exp_set_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, GroupSetReq.class);
    public final PBStringField doc_url = PBField.initString("");
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
    public final PBUInt64Field group_code = PBField.initUInt64(0L);
    public final PBBoolField only = PBField.initBool(false);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
  }
  
  public static final class GroupSetRsp
    extends MessageMicro<GroupSetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], GroupSetRsp.class);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "user_get_req", "user_set_req", "group_get_req", "group_set_req" }, new Object[] { null, null, null, null }, ReqBody.class);
    public cmd0xbab.GroupGetReq group_get_req = new cmd0xbab.GroupGetReq();
    public cmd0xbab.GroupSetReq group_set_req = new cmd0xbab.GroupSetReq();
    public cmd0xbab.UserGetReq user_get_req = new cmd0xbab.UserGetReq();
    public cmd0xbab.UserSetReq user_set_req = new cmd0xbab.UserSetReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34 }, new String[] { "user_get_rsp", "user_set_rsp", "group_get_rsp", "group_set_rsp" }, new Object[] { null, null, null, null }, RspBody.class);
    public cmd0xbab.GroupGetRsp group_get_rsp = new cmd0xbab.GroupGetRsp();
    public cmd0xbab.GroupSetRsp group_set_rsp = new cmd0xbab.GroupSetRsp();
    public cmd0xbab.UserGetRsp user_get_rsp = new cmd0xbab.UserGetRsp();
    public cmd0xbab.UserSetRsp user_set_rsp = new cmd0xbab.UserSetRsp();
  }
  
  public static final class UserGetReq
    extends MessageMicro<UserGetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uin", "doc_url" }, new Object[] { Long.valueOf(0L), "" }, UserGetReq.class);
    public final PBStringField doc_url = PBField.initString("");
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class UserGetRsp
    extends MessageMicro<UserGetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 40 }, new String[] { "policy", "privilege_flag", "member_number", "exp_remain_time", "exp_set_time" }, new Object[] { Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, UserGetRsp.class);
    public final PBUInt32Field exp_remain_time = PBField.initUInt32(0);
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
    public final PBUInt32Field member_number = PBField.initUInt32(0);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
  }
  
  public static final class UserInfo
    extends MessageMicro<UserInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uin", "privilege_flag" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, UserInfo.class);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class UserSetReq
    extends MessageMicro<UserSetReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 32, 40, 48 }, new String[] { "uin", "doc_url", "privilege_flag", "policy", "only", "exp_set_time" }, new Object[] { Long.valueOf(0L), "", Integer.valueOf(0), Integer.valueOf(0), Boolean.valueOf(false), Integer.valueOf(0) }, UserSetReq.class);
    public final PBStringField doc_url = PBField.initString("");
    public final PBUInt32Field exp_set_time = PBField.initUInt32(0);
    public final PBBoolField only = PBField.initBool(false);
    public final PBUInt32Field policy = PBField.initUInt32(0);
    public final PBUInt32Field privilege_flag = PBField.initUInt32(0);
    public final PBUInt64Field uin = PBField.initUInt64(0L);
  }
  
  public static final class UserSetRsp
    extends MessageMicro<UserSetRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], UserSetRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbab.cmd0xbab
 * JD-Core Version:    0.7.0.1
 */