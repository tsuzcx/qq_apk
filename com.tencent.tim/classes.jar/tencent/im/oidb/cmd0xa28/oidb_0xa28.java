package tencent.im.oidb.cmd0xa28;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xa28
{
  public static final class Achievement
    extends MessageMicro<Achievement>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_score = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_mvp_level = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_round = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_super = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32 }, new String[] { "uint64_mvp_level", "uint64_super", "bytes_score", "uint64_round" }, new Object[] { Long.valueOf(0L), Long.valueOf(0L), localByteStringMicro, Long.valueOf(0L) }, Achievement.class);
    }
  }
  
  public static final class HonourInfo
    extends MessageMicro<HonourInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_achieve_info", "msg_role_list" }, new Object[] { null, null }, HonourInfo.class);
    public oidb_0xa28.Achievement msg_achieve_info = new oidb_0xa28.Achievement();
    public final PBRepeatMessageField<oidb_0xa28.RoleInfo> msg_role_list = PBField.initRepeatMessage(oidb_0xa28.RoleInfo.class);
  }
  
  public static final class Profile
    extends MessageMicro<Profile>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_common_info = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_game_level = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_game_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_qq_nick = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_bg_url = PBField.initString("");
    public final PBUInt32Field uint32_gender = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 34, 42, 50 }, new String[] { "bytes_game_nick", "bytes_qq_nick", "uint32_gender", "bytes_game_level", "bytes_common_info", "str_bg_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, Integer.valueOf(0), localByteStringMicro3, localByteStringMicro4, "" }, Profile.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24 }, new String[] { "uint64_request_uin", "uint32_sourceID", "uint32_sourceSubID" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_sourceID = PBField.initUInt32(0);
    public final PBUInt32Field uint32_sourceSubID = PBField.initUInt32(0);
    public final PBUInt64Field uint64_request_uin = PBField.initUInt64(0L);
  }
  
  public static final class RoleInfo
    extends MessageMicro<RoleInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_role_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_role_score = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBStringField str_role_url = PBField.initString("");
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "bytes_role_name", "bytes_role_score", "str_role_url" }, new Object[] { localByteStringMicro1, localByteStringMicro2, "" }, RoleInfo.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_profile_info", "msg_game_info" }, new Object[] { null, null }, RspBody.class);
    public oidb_0xa28.HonourInfo msg_game_info = new oidb_0xa28.HonourInfo();
    public oidb_0xa28.Profile msg_profile_info = new oidb_0xa28.Profile();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xa28.oidb_0xa28
 * JD-Core Version:    0.7.0.1
 */