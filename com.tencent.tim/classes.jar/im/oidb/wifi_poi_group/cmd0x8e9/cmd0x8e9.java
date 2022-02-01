package im.oidb.wifi_poi_group.cmd0x8e9;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.hotchat.Common.WifiPOIInfo;

public final class cmd0x8e9
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_uid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<cmd0x8e9.VisitorInfo> rpt_req_visitor_info = PBField.initRepeatMessage(cmd0x8e9.VisitorInfo.class);
    public final PBUInt32Field uint32_max_visitor_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_judge_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40 }, new String[] { "bytes_uid", "uint64_group_code", "rpt_req_visitor_info", "uint32_max_visitor_num", "uint64_judge_uin" }, new Object[] { localByteStringMicro, Long.valueOf(0L), null, Integer.valueOf(0), Long.valueOf(0L) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "poi_info", "rpt_rsp_visitor_info" }, new Object[] { null, null }, RspBody.class);
    public Common.WifiPOIInfo poi_info = new Common.WifiPOIInfo();
    public final PBRepeatMessageField<cmd0x8e9.VisitorInfo> rpt_rsp_visitor_info = PBField.initRepeatMessage(cmd0x8e9.VisitorInfo.class);
  }
  
  public static final class VisitorInfo
    extends MessageMicro<VisitorInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16 }, new String[] { "uint64_visitor_uin", "uint32_visitor_status" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0) }, VisitorInfo.class);
    public final PBUInt32Field uint32_visitor_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_visitor_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     im.oidb.wifi_poi_group.cmd0x8e9.cmd0x8e9
 * JD-Core Version:    0.7.0.1
 */