import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import java.util.ArrayList;
import tencent.im.msg.im_msg_body.CustomFace;

public class aooo
  extends aokv
{
  public im_msg_body.CustomFace a;
  
  public aooo(aooi paramaooi, aool paramaool)
  {
    super(paramaooi, paramaool);
  }
  
  void dDP()
  {
    if (this.h.b != null)
    {
      dWt();
      akyf.a locala = new akyf.a();
      locala.size = this.mFileSize;
      locala.md5 = this.clf;
      locala.uuid = this.mFileName;
      locala.path = this.h.dQ;
      locala.groupFileID = this.jdField_app_of_type_Long;
      locala.data = this.a;
      this.h.b.b(locala);
      doReport(true);
    }
  }
  
  protected void dWt()
  {
    im_msg_body.CustomFace localCustomFace = new im_msg_body.CustomFace();
    localCustomFace.uint32_file_id.set((int)this.jdField_app_of_type_Long);
    if ((this.xp != null) && (this.xp.size() > 0))
    {
      localObject = (aonh)this.xp.get(0);
      localCustomFace.uint32_server_ip.set(eD(((aonh)localObject).mIp));
      localCustomFace.uint32_server_port.set(((aonh)localObject).port);
    }
    localCustomFace.uint32_file_type.set(Integer.valueOf(66).intValue());
    localCustomFace.uint32_useful.set(1);
    if (this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getSessionKey() != null) {
      localCustomFace.bytes_signature.set(ByteStringMicro.copyFrom(this.jdField_app_of_type_ComTencentMobileqqAppQQAppInterface.getSessionKey()));
    }
    localCustomFace.bytes_md5.set(ByteStringMicro.copyFrom(this.bL));
    localCustomFace.str_file_path.set(this.mFileName);
    Object localObject = localCustomFace.uint32_origin;
    if (this.cLX) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localCustomFace.uint32_width.set(this.mWidth);
      localCustomFace.uint32_height.set(this.mHeight);
      localCustomFace.uint32_size.set((int)this.mFileSize);
      localCustomFace.uint32_source.set(200);
      this.a = localCustomFace;
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aooo
 * JD-Core Version:    0.7.0.1
 */