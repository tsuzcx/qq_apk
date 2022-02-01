package tencent.im.oidb.cmd0xbd3;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.articlesummary.feeds_info.BiuMultiLevel;
import tencent.im.oidb.articlesummary.feeds_info.SocializeFeedsExtInfo;

public final class oidb_cmd0xbd3
{
  public static final class FeedParam
    extends MessageMicro<FeedParam>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_subscribe_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public feeds_info.SocializeFeedsExtInfo feed_ext_info = new feeds_info.SocializeFeedsExtInfo();
    public final PBEnumField feed_type = PBField.initEnum(0);
    public feeds_info.BiuMultiLevel multi_level_info = new feeds_info.BiuMultiLevel();
    public final PBUInt32Field uint32_share_type = PBField.initUInt32(0);
    public final PBUInt64Field uint64_feed_id = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 48, 58 }, new String[] { "feed_type", "uint64_feed_id", "bytes_subscribe_name", "multi_level_info", "uint64_uin", "uint32_share_type", "feed_ext_info" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro, null, Long.valueOf(0L), Integer.valueOf(0), null }, FeedParam.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_feed_param" }, new Object[] { null }, ReqBody.class);
    public final PBRepeatMessageField<oidb_cmd0xbd3.FeedParam> rpt_feed_param = PBField.initRepeatMessage(oidb_cmd0xbd3.FeedParam.class);
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "rpt_share_info" }, new Object[] { null }, RspBody.class);
    public final PBRepeatMessageField<oidb_cmd0xbd3.ShareInfo> rpt_share_info = PBField.initRepeatMessage(oidb_cmd0xbd3.ShareInfo.class);
  }
  
  public static final class ShareInfo
    extends MessageMicro<ShareInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_share_json = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_share_json" }, new Object[] { localByteStringMicro }, ShareInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xbd3.oidb_cmd0xbd3
 * JD-Core Version:    0.7.0.1
 */