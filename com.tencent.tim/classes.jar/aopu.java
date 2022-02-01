import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.transfile.ProtoReqManager.c;
import tencent.im.cs.cmd0x352.cmd0x352.ReqBody;
import tencent.im.cs.cmd0x352.cmd0x352.TryUpImgReq;

public class aopu
  extends aopy
{
  void a(int paramInt, aoql.a.k paramk, cmd0x352.ReqBody paramReqBody)
  {
    paramk = (aoql.a.i)paramk;
    cmd0x352.TryUpImgReq localTryUpImgReq = new cmd0x352.TryUpImgReq();
    localTryUpImgReq.uint64_file_id.set(paramInt);
    localTryUpImgReq.setHasFlag(true);
    localTryUpImgReq.uint64_src_uin.set(Long.valueOf(paramk.selfUin).longValue());
    localTryUpImgReq.uint64_file_size.set(paramk.fileSize);
    localTryUpImgReq.bytes_file_md5.set(ByteStringMicro.copyFrom(paramk.md5));
    localTryUpImgReq.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramk.fileName));
    localTryUpImgReq.uint32_src_term.set(5);
    localTryUpImgReq.bool_address_book.set(paramk.cNW);
    localTryUpImgReq.uint32_platform_type.set(9);
    localTryUpImgReq.uint32_bu_type.set(1);
    localTryUpImgReq.bool_pic_original.set(paramk.cMs);
    localTryUpImgReq.uint32_pic_width.set(paramk.width);
    localTryUpImgReq.uint32_pic_height.set(paramk.height);
    localTryUpImgReq.uint32_pic_type.set(paramk.picType);
    localTryUpImgReq.bytes_build_ver.set(ByteStringMicro.copyFromUtf8(aonc.getVersionCode()));
    localTryUpImgReq.bool_reject_tryfast.set(true);
    paramReqBody.rpt_msg_tryup_img_req.add(localTryUpImgReq);
  }
  
  public void a(aoql.a parama)
  {
    if ((parama != null) && (parama.He != null) && (parama.a != null))
    {
      ProtoReqManager.c localc = new ProtoReqManager.c();
      localc.clW = "LongConn.ArtisticFilter";
      localc.fW = b(parama.He);
      localc.fi = parama;
      localc.a = this;
      a(parama, localc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aopu
 * JD-Core Version:    0.7.0.1
 */