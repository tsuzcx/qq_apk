package tencent.im.oidb.lbspack;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.olympic.MqqLbs.LBSInfo;

public final class MqqLbsPack
{
  public static final class CFT_AR_INFO
    extends MessageMicro<CFT_AR_INFO>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 26, 32, 40 }, new String[] { "msg_lbs_sig", "uint32_qa", "uint32_attempt_num" }, new Object[] { null, Integer.valueOf(0), Integer.valueOf(0) }, CFT_AR_INFO.class);
    public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
    public final PBUInt32Field uint32_attempt_num = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
  }
  
  public static final class LBSSig
    extends MessageMicro<LBSSig>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_verify_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBUInt32Field uint32_time = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34 }, new String[] { "int32_lat", "int32_lon", "uint32_time", "bytes_verify_key" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(0), localByteStringMicro }, LBSSig.class);
    }
  }
  
  public static final class LbsPackInfo
    extends MessageMicro<LbsPackInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_auth_key = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_cft_pack_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public MqqLbsPack.SelectedUinInfo uin_grp_dis_info = new MqqLbsPack.SelectedUinInfo();
    public final PBUInt32Field uint32_priority = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_set_pack_poi = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 26, 32, 40, 48, 58, 160, 170, 178, 242 }, new String[] { "bytes_pid", "uint64_uin", "bytes_cft_pack_id", "uint32_status", "uint32_priority", "uint32_qa", "uin_grp_dis_info", "uint64_set_pack_poi", "bytes_name", "bytes_addr", "bytes_auth_key" }, new Object[] { localByteStringMicro1, Long.valueOf(0L), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), null, Long.valueOf(0L), localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, LbsPackInfo.class);
    }
  }
  
  public static final class POIRPInfo
    extends MessageMicro<POIRPInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32, 42 }, new String[] { "uint64_poi_id", "int32_lat", "int32_lon", "uint32_total_num", "lbs_pack_info" }, new Object[] { Long.valueOf(0L), Integer.valueOf(900000000), Integer.valueOf(900000000), Integer.valueOf(0), null }, POIRPInfo.class);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public final PBRepeatMessageField<MqqLbsPack.LbsPackInfo> lbs_pack_info = PBField.initRepeatMessage(MqqLbsPack.LbsPackInfo.class);
    public final PBUInt32Field uint32_total_num = PBField.initUInt32(0);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
  }
  
  public static final class PoiInfo
    extends MessageMicro<PoiInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_addr = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_name = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_lat = PBField.initInt32(0);
    public final PBInt32Field int32_lon = PBField.initInt32(0);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 34, 42 }, new String[] { "uint64_poi_id", "int32_lat", "int32_lon", "bytes_name", "bytes_addr" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2 }, PoiInfo.class);
    }
  }
  
  public static final class ReqGetLBSPID
    extends MessageMicro<ReqGetLBSPID>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
    public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
    public MqqLbsPack.PoiInfo msg_poi_info = new MqqLbsPack.PoiInfo();
    public MqqLbsPack.SelectedUinInfo uin_grp_dis_info = new MqqLbsPack.SelectedUinInfo();
    public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_qa = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 82, 90, 96, 106 }, new String[] { "int32_lat", "int32_lon", "msg_poi_info", "uin_grp_dis_info", "uint32_qa", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), null, null, Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro }, ReqGetLBSPID.class);
    }
  }
  
  public static final class ReqGetLBSRPInfo
    extends MessageMicro<ReqGetLBSRPInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint64_poi_id", "bytes_pid" }, new Object[] { Long.valueOf(0L), localByteStringMicro }, ReqGetLBSRPInfo.class);
    }
  }
  
  public static final class ReqGetLBSRPList
    extends MessageMicro<ReqGetLBSRPList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
    public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
    public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
    public final PBUInt32Field uint32_req_occasion = PBField.initUInt32(0);
    public final PBUInt64Field uint64_adcode = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 34, 40, 50, 56, 64, 82, 90, 96, 106 }, new String[] { "int32_lat", "int32_lon", "bytes_cookie", "bytes_pid", "uint64_poi_id", "bytes_page_cookie", "uint64_adcode", "uint32_req_occasion", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), localByteStringMicro1, localByteStringMicro2, Long.valueOf(0L), localByteStringMicro3, Long.valueOf(0L), Integer.valueOf(0), null, null, Integer.valueOf(0), localByteStringMicro4 }, ReqGetLBSRPList.class);
    }
  }
  
  public static final class ReqGetPOIList
    extends MessageMicro<ReqGetPOIList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_encrypt_sig = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_lat = PBField.initInt32(900000000);
    public final PBInt32Field int32_lon = PBField.initInt32(900000000);
    public MqqLbs.LBSInfo msg_lbs_info = new MqqLbs.LBSInfo();
    public MqqLbsPack.LBSSig msg_lbs_sig = new MqqLbsPack.LBSSig();
    public final PBUInt32Field uint32_lbs_accuracy = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 82, 90, 96, 106 }, new String[] { "int32_lat", "int32_lon", "msg_lbs_sig", "msg_lbs_info", "uint32_lbs_accuracy", "bytes_encrypt_sig" }, new Object[] { Integer.valueOf(900000000), Integer.valueOf(900000000), null, null, Integer.valueOf(0), localByteStringMicro }, ReqGetPOIList.class);
    }
  }
  
  public static final class ReqOpenLBSRPReport
    extends MessageMicro<ReqOpenLBSRPReport>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    public final PBUInt64Field uint64_poi_id = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24 }, new String[] { "uint64_poi_id", "bytes_pid", "uint32_status" }, new Object[] { Long.valueOf(0L), localByteStringMicro, Integer.valueOf(0) }, ReqOpenLBSRPReport.class);
    }
  }
  
  public static final class RspGetLBSPID
    extends MessageMicro<RspGetLBSPID>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "msg_head", "bytes_pid" }, new Object[] { null, localByteStringMicro }, RspGetLBSPID.class);
    }
  }
  
  public static final class RspGetLBSRPInfo
    extends MessageMicro<RspGetLBSRPInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_pid = PBField.initBytes(ByteStringMicro.EMPTY);
    public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
    public final PBUInt32Field uint32_status = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24 }, new String[] { "msg_head", "bytes_pid", "uint32_status" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0) }, RspGetLBSRPInfo.class);
    }
  }
  
  public static final class RspGetLBSRPList
    extends MessageMicro<RspGetLBSRPList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_page_cookie = PBField.initBytes(ByteStringMicro.EMPTY);
    public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
    public final PBRepeatMessageField<MqqLbsPack.POIRPInfo> rpt_poi_info_list = PBField.initRepeatMessage(MqqLbsPack.POIRPInfo.class);
    public final PBUInt32Field uint32_flush_dist = PBField.initUInt32(0);
    public final PBUInt32Field uint32_flush_time = PBField.initUInt32(0);
    public final PBUInt32Field uint32_get_award_range = PBField.initUInt32(0);
    public final PBUInt32Field uint32_lbs_interval = PBField.initUInt32(0);
    public final PBUInt32Field uint32_patch_button_stat = PBField.initUInt32(0);
    public final PBUInt32Field uint32_show_map_grid = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 80, 88, 98, 104, 112, 120, 128 }, new String[] { "msg_head", "rpt_poi_info_list", "bytes_page_cookie", "uint32_flush_dist", "uint32_flush_time", "bytes_cookie", "uint32_lbs_interval", "uint32_show_map_grid", "uint32_patch_button_stat", "uint32_get_award_range" }, new Object[] { null, null, localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), localByteStringMicro2, Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0), Integer.valueOf(0) }, RspGetLBSRPList.class);
    }
  }
  
  public static final class RspGetPOIList
    extends MessageMicro<RspGetPOIList>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_search_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
    public final PBRepeatMessageField<MqqLbsPack.PoiInfo> rpt_msg_poi_info_list = PBField.initRepeatMessage(MqqLbsPack.PoiInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "msg_head", "rpt_msg_poi_info_list", "bytes_search_id" }, new Object[] { null, null, localByteStringMicro }, RspGetPOIList.class);
    }
  }
  
  public static final class RspHead
    extends MessageMicro<RspHead>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_err_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_result = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "uint32_result", "bytes_err_msg" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, RspHead.class);
    }
  }
  
  public static final class RspOpenLBSRPReport
    extends MessageMicro<RspOpenLBSRPReport>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "msg_head" }, new Object[] { null }, RspOpenLBSRPReport.class);
    public MqqLbsPack.RspHead msg_head = new MqqLbsPack.RspHead();
  }
  
  public static final class SelectedUinInfo
    extends MessageMicro<SelectedUinInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 24, 32 }, new String[] { "uint32_all_frd", "uint64_uin", "uint64_group_code", "uint64_discuss_uin" }, new Object[] { Integer.valueOf(0), Long.valueOf(0L), Long.valueOf(0L), Long.valueOf(0L) }, SelectedUinInfo.class);
    public final PBUInt32Field uint32_all_frd = PBField.initUInt32(0);
    public final PBUInt64Field uint64_discuss_uin = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_group_code = PBField.initUInt64(0L);
    public final PBUInt64Field uint64_uin = PBField.initUInt64(0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.lbspack.MqqLbsPack
 * JD-Core Version:    0.7.0.1
 */