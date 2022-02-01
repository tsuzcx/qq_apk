package tencent.im.oidb.cmd0xcd5;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_cmd0xcd5
{
  public static final class CheckReplyReq
    extends MessageMicro<CheckReplyReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], CheckReplyReq.class);
  }
  
  public static final class CheckReplyRsp
    extends MessageMicro<CheckReplyRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "auto_reply_flag" }, new Object[] { Integer.valueOf(0) }, CheckReplyRsp.class);
    public final PBUInt32Field auto_reply_flag = PBField.initUInt32(0);
  }
  
  public static final class GetDataReq
    extends MessageMicro<GetDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8 }, new String[] { "query_type" }, new Object[] { Integer.valueOf(0) }, GetDataReq.class);
    public final PBUInt32Field query_type = PBField.initUInt32(0);
  }
  
  public static final class GetDataRsp
    extends MessageMicro<GetDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBUInt32Field flag = PBField.initUInt32(0);
    public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "flag", "pb_data" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, GetDataRsp.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "service_type", "getdata_req", "setdata_req", "check_req" }, new Object[] { Integer.valueOf(0), null, null, null }, ReqBody.class);
    public oidb_cmd0xcd5.CheckReplyReq check_req = new oidb_cmd0xcd5.CheckReplyReq();
    public oidb_cmd0xcd5.GetDataReq getdata_req = new oidb_cmd0xcd5.GetDataReq();
    public final PBUInt32Field service_type = PBField.initUInt32(0);
    public oidb_cmd0xcd5.SetDataReq setdata_req = new oidb_cmd0xcd5.SetDataReq();
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34 }, new String[] { "servicetype", "getdata_rsp", "setdata_rsp", "check_rsp" }, new Object[] { Integer.valueOf(0), null, null, null }, RspBody.class);
    public oidb_cmd0xcd5.CheckReplyRsp check_rsp = new oidb_cmd0xcd5.CheckReplyRsp();
    public oidb_cmd0xcd5.GetDataRsp getdata_rsp = new oidb_cmd0xcd5.GetDataRsp();
    public final PBUInt32Field servicetype = PBField.initUInt32(0);
    public oidb_cmd0xcd5.SetDataRsp setdata_rsp = new oidb_cmd0xcd5.SetDataRsp();
  }
  
  public static final class SetDataReq
    extends MessageMicro<SetDataReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField pb_data = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "pb_data" }, new Object[] { localByteStringMicro }, SetDataReq.class);
    }
  }
  
  public static final class SetDataRsp
    extends MessageMicro<SetDataRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[0], new String[0], new Object[0], SetDataRsp.class);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.cmd0xcd5.oidb_cmd0xcd5
 * JD-Core Version:    0.7.0.1
 */