import com.tencent.mobileqq.activity.aio.photo.ICompressionCallBack.Stub;
import com.tencent.mobileqq.activity.aio.rebuild.DeviceMsgChatPie;
import com.tencent.mobileqq.pic.CompressInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.XPanelContainer;
import java.lang.ref.WeakReference;

public class vpd
  extends ICompressionCallBack.Stub
{
  final String jdField_a_of_type_JavaLangString = DeviceMsgChatPie.class.getSimpleName();
  WeakReference jdField_a_of_type_JavaLangRefWeakReference;
  
  public vpd(DeviceMsgChatPie paramDeviceMsgChatPie)
  {
    this.jdField_a_of_type_JavaLangRefWeakReference = new WeakReference(paramDeviceMsgChatPie);
  }
  
  public void a(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress success, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void b(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress fail, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void c(CompressInfo paramCompressInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "DeviceMsgChatPie, compress complete, localUUID:" + paramCompressInfo.jdField_a_of_type_JavaLangString);
    }
    DeviceMsgChatPie localDeviceMsgChatPie = (DeviceMsgChatPie)this.jdField_a_of_type_JavaLangRefWeakReference.get();
    if (localDeviceMsgChatPie == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCompressComplete, error: activity is null");
      }
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.e(this.jdField_a_of_type_JavaLangString, 2, "onCompressComplete, new path:" + paramCompressInfo.e);
    }
    localDeviceMsgChatPie.e(paramCompressInfo.e);
    DeviceMsgChatPie.a(localDeviceMsgChatPie).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vpd
 * JD-Core Version:    0.7.0.1
 */