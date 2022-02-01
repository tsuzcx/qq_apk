package tencent.im.oidb.hotchat;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public final class oidb_0x8ab
{
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField hotnamecode = PBField.initBytes(ByteStringMicro.EMPTY);
    public LBS.LBSInfo lbs_info = new LBS.LBSInfo();
    public final PBUInt32Field req_flag = PBField.initUInt32(0);
    public final PBUInt32Field version_flag = PBField.initUInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 24, 32 }, new String[] { "lbs_info", "hotnamecode", "req_flag", "version_flag" }, new Object[] { null, localByteStringMicro, Integer.valueOf(0), Integer.valueOf(0) }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16 }, new String[] { "poi_info", "join_poi_status" }, new Object[] { null, Integer.valueOf(0) }, RspBody.class);
    public final PBUInt32Field join_poi_status = PBField.initUInt32(0);
    public Common.WifiPOIInfo poi_info = new Common.WifiPOIInfo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.oidb.hotchat.oidb_0x8ab
 * JD-Core Version:    0.7.0.1
 */