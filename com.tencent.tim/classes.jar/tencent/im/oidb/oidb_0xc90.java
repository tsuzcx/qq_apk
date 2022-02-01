package tencent.im.oidb;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class oidb_0xc90
{
  public static final class CommunityConfigInfo
    extends MessageMicro<CommunityConfigInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_jump_home_page_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_dynamic_count = PBField.initUInt32(0);
    public final PBUInt32Field uint32_follow_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_community_bid = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 32, 40, 48 }, new String[] { "bytes_jump_home_page_url", "bytes_name", "bytes_pic_url", "uint32_dynamic_count", "uint64_community_bid", "uint32_follow_status" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, Integer.valueOf(0), Long.valueOf(0L), Integer.valueOf(0) }, CommunityConfigInfo.class);
    }
  }
  
  public static final class CommunityWebInfo
    extends MessageMicro<CommunityWebInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24 }, new String[] { "rpt_community_info_item", "uint32_page", "uint32_end" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, CommunityWebInfo.class);
    public final PBRepeatMessageField<oidb_0xc90.CommunityConfigInfo> rpt_community_info_item = PBField.initRepeatMessage(oidb_0xc90.CommunityConfigInfo.class);
    public final PBUInt32Field uint32_end = PBField.initUInt32(0);
    public final PBUInt32Field uint32_page = PBField.initUInt32(0);
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_community_bid", "uint32_page" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, ReqBody.class);
    public final PBUInt32Field uint32_page = PBField.initUInt32(0);
    public final PBRepeatField<Long> uint64_community_bid = PBField.initRepeat(PBUInt64Field.__repeatHelper__);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_community_title_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_community_channel_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_jump_concern_community_url = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_more_url_wording = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<oidb_0xc90.CommunityConfigInfo> rpt_community_info_item = PBField.initRepeatMessage(oidb_0xc90.CommunityConfigInfo.class);
    public oidb_0xc90.CommunityWebInfo rpt_web_community_info = new oidb_0xc90.CommunityWebInfo();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42, 50 }, new String[] { "rpt_community_info_item", "bytes_jump_concern_community_url", "bytes_community_title_wording", "bytes_more_url_wording", "rpt_web_community_info", "bytes_jump_community_channel_url" }, new Object[] { null, localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, null, localByteStringMicro4 }, RspBody.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.oidb_0xc90
 * JD-Core Version:    0.7.0.1
 */