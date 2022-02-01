package tencent.im.selfgif;

import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.MessageMicro.FieldMap;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBField;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;

public final class CameraEmotionRoaming_sso
{
  public static final class DelReq
    extends MessageMicro<DelReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatField<ByteStringMicro> bytes_resource_id = PBField.initRepeat(PBBytesField.__repeatHelper__);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "bytes_resource_id" }, new Object[] { localByteStringMicro }, DelReq.class);
    }
  }
  
  public static final class DelRet
    extends MessageMicro<DelRet>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_del_ret = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_del_ret", "bytes_resource_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, DelRet.class);
    }
  }
  
  public static final class DelRsp
    extends MessageMicro<DelRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso.DelRet> del_ret = PBField.initRepeatMessage(CameraEmotionRoaming_sso.DelRet.class);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso.ImgInfo> rpt_img_info = PBField.initRepeatMessage(CameraEmotionRoaming_sso.ImgInfo.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26 }, new String[] { "client_timestamp_version", "del_ret", "rpt_img_info" }, new Object[] { localByteStringMicro, null, null }, DelRsp.class);
    }
  }
  
  public static final class GetListReq
    extends MessageMicro<GetListReq>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField client_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "client_timestamp_version" }, new Object[] { localByteStringMicro }, GetListReq.class);
    }
  }
  
  public static final class GetListRsp
    extends MessageMicro<GetListRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBRepeatMessageField<CameraEmotionRoaming_sso.ImgInfo> rpt_img_info = PBField.initRepeatMessage(CameraEmotionRoaming_sso.ImgInfo.class);
    public final PBBytesField server_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "server_timestamp_version", "rpt_img_info" }, new Object[] { localByteStringMicro, null }, GetListRsp.class);
    }
  }
  
  public static final class ImgInfo
    extends MessageMicro<ImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_text = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_widget_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField url = PBField.initBytes(ByteStringMicro.EMPTY);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18, 26, 34, 42 }, new String[] { "bytes_resource_id", "bytes_text", "url", "bytes_md5", "bytes_widget_id" }, new Object[] { localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, ImgInfo.class);
    }
  }
  
  public static final class ReqBody
    extends MessageMicro<ReqBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public CameraEmotionRoaming_sso.DelReq del_req = new CameraEmotionRoaming_sso.DelReq();
    public CameraEmotionRoaming_sso.GetListReq get_list_req = new CameraEmotionRoaming_sso.GetListReq();
    public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
    public final PBUInt32Field uint32_src_term = PBField.initUInt32(0);
    public final PBUInt64Field uint64_src_uin = PBField.initUInt64(0L);
    public CameraEmotionRoaming_sso.UpLoadReq upLoad_req = new CameraEmotionRoaming_sso.UpLoadReq();
    public CameraEmotionRoaming_sso.UpLoadStateReq upLoad_state_req = new CameraEmotionRoaming_sso.UpLoadStateReq();
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 16, 26, 32, 42, 50, 58, 66 }, new String[] { "uint64_src_uin", "uint32_src_term", "bytes_version", "uint32_cmd_type", "upLoad_req", "upLoad_state_req", "get_list_req", "del_req" }, new Object[] { Long.valueOf(0L), Integer.valueOf(0), localByteStringMicro, Integer.valueOf(0), null, null, null, null }, ReqBody.class);
    }
  }
  
  public static final class RspBody
    extends MessageMicro<RspBody>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_fail_msg = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_rsp_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public CameraEmotionRoaming_sso.DelRsp del_rsp = new CameraEmotionRoaming_sso.DelRsp();
    public CameraEmotionRoaming_sso.GetListRsp get_list_rsp = new CameraEmotionRoaming_sso.GetListRsp();
    public final PBInt32Field int32_result = PBField.initInt32(0);
    public final PBUInt32Field uint32_cmd_type = PBField.initUInt32(0);
    public CameraEmotionRoaming_sso.UpLoadRsp upLoad_rsp = new CameraEmotionRoaming_sso.UpLoadRsp();
    public CameraEmotionRoaming_sso.UpLoadStateRsp upLoad_state_rsp = new CameraEmotionRoaming_sso.UpLoadStateRsp();
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 24, 34, 42, 50, 58, 66 }, new String[] { "int32_result", "bytes_fail_msg", "uint32_cmd_type", "upLoad_rsp", "upLoad_state_rsp", "get_list_rsp", "del_rsp", "bytes_rsp_other" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, Integer.valueOf(0), null, null, null, null, localByteStringMicro2 }, RspBody.class);
    }
  }
  
  public static final class UpLoadReq
    extends MessageMicro<UpLoadReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "img_info" }, new Object[] { null }, UpLoadReq.class);
    public CameraEmotionRoaming_sso.UploadImgInfo img_info = new CameraEmotionRoaming_sso.UploadImgInfo();
  }
  
  public static final class UpLoadRsp
    extends MessageMicro<UpLoadRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_is_upload = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_is_upload", "bytes_resource_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro }, UpLoadRsp.class);
    }
  }
  
  public static final class UpLoadState
    extends MessageMicro<UpLoadState>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_pic_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_resource_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatField<ByteStringMicro> bytes_text = PBField.initRepeat(PBBytesField.__repeatHelper__);
    public final PBBytesField bytes_widget_id = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBInt32Field int32_upload_state = PBField.initInt32(0);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro3 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro4 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro5 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18, 26, 34, 42, 50 }, new String[] { "int32_upload_state", "bytes_resource_id", "bytes_text", "bytes_pic_version", "bytes_other", "bytes_widget_id" }, new Object[] { Integer.valueOf(0), localByteStringMicro1, localByteStringMicro2, localByteStringMicro3, localByteStringMicro4, localByteStringMicro5 }, UpLoadState.class);
    }
  }
  
  public static final class UpLoadStateReq
    extends MessageMicro<UpLoadStateReq>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10 }, new String[] { "upload_state" }, new Object[] { null }, UpLoadStateReq.class);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso.UpLoadState> upload_state = PBField.initRepeatMessage(CameraEmotionRoaming_sso.UpLoadState.class);
  }
  
  public static final class UpLoadStateRet
    extends MessageMicro<UpLoadStateRet>
  {
    static final MessageMicro.FieldMap __fieldMap__ = MessageMicro.initFieldMap(new int[] { 8, 18 }, new String[] { "int32_upload_state_ret", "img_info" }, new Object[] { Integer.valueOf(0), null }, UpLoadStateRet.class);
    public CameraEmotionRoaming_sso.ImgInfo img_info = new CameraEmotionRoaming_sso.ImgInfo();
    public final PBInt32Field int32_upload_state_ret = PBField.initInt32(0);
  }
  
  public static final class UpLoadStateRsp
    extends MessageMicro<UpLoadStateRsp>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField server_timestamp_version = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBRepeatMessageField<CameraEmotionRoaming_sso.UpLoadStateRet> upload_state_ret = PBField.initRepeatMessage(CameraEmotionRoaming_sso.UpLoadStateRet.class);
    
    static
    {
      ByteStringMicro localByteStringMicro = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 18 }, new String[] { "upload_state_ret", "server_timestamp_version" }, new Object[] { null, localByteStringMicro }, UpLoadStateRsp.class);
    }
  }
  
  public static final class UploadImgInfo
    extends MessageMicro<UploadImgInfo>
  {
    static final MessageMicro.FieldMap __fieldMap__;
    public final PBBytesField bytes_img_md5 = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBBytesField bytes_img_other = PBField.initBytes(ByteStringMicro.EMPTY);
    public final PBUInt32Field uint32_img_height = PBField.initUInt32(0);
    public final PBUInt32Field uint32_img_width = PBField.initUInt32(0);
    public final PBUInt64Field uint64_img_size = PBField.initUInt64(0L);
    
    static
    {
      ByteStringMicro localByteStringMicro1 = ByteStringMicro.EMPTY;
      ByteStringMicro localByteStringMicro2 = ByteStringMicro.EMPTY;
      __fieldMap__ = MessageMicro.initFieldMap(new int[] { 10, 16, 24, 32, 42 }, new String[] { "bytes_img_md5", "uint32_img_width", "uint32_img_height", "uint64_img_size", "bytes_img_other" }, new Object[] { localByteStringMicro1, Integer.valueOf(0), Integer.valueOf(0), Long.valueOf(0L), localByteStringMicro2 }, UploadImgInfo.class);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tencent.im.selfgif.CameraEmotionRoaming_sso
 * JD-Core Version:    0.7.0.1
 */