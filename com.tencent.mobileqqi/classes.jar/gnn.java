import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.NearbyPeoplePhotoUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.nio.ByteBuffer;
import java.util.HashMap;

public class gnn
  implements ITransactionCallback
{
  public gnn(NearbyPeoplePhotoUploadProcessor paramNearbyPeoplePhotoUploadProcessor, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    String str1 = (String)paramHashMap.get("tc_p:");
    String str2 = (String)paramHashMap.get("rep_bdhTrans");
    String str3 = (String)paramHashMap.get("segspercnt");
    String str4 = (String)paramHashMap.get("param_conf_segSize");
    String str5 = (String)paramHashMap.get("param_conf_segNum");
    paramHashMap = (String)paramHashMap.get("param_conf_connNum");
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + str2);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", paramHashMap);
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.h = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.f;
    paramHashMap = ByteBuffer.wrap((byte[])paramArrayOfByte);
    int i = paramHashMap.get();
    if (QLog.isColorLevel()) {
      QLog.d("NearbyPeoplePhotoUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.ITransactionCallback.onSuccess(), business result code = " + i);
    }
    if (i == 0)
    {
      i = paramHashMap.get();
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.V = new String(paramArrayOfByte, 2, i & 0xFF);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.e();
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.a(l2, l3, l4, l5);
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
      return;
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.d(1005);
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.c("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    NearbyPeoplePhotoUploadProcessor localNearbyPeoplePhotoUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.d = l;
    localNearbyPeoplePhotoUploadProcessor.h = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.f) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.e) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.c)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileNearbyPeoplePhotoUploadProcessor.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gnn
 * JD-Core Version:    0.7.0.1
 */