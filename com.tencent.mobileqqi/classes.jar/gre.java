import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class gre
  implements ITransactionCallback
{
  public gre(C2CPicUploadProcessor paramC2CPicUploadProcessor, long paramLong) {}
  
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
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms");
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.a(paramInt, "OnFailed.", "", this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.d();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    paramArrayOfByte = (String)paramHashMap.get("rep_bdhTrans");
    String str1 = (String)paramHashMap.get("segspercnt");
    String str2 = (String)paramHashMap.get("param_conf_segSize");
    String str3 = (String)paramHashMap.get("param_conf_segNum");
    String str4 = (String)paramHashMap.get("param_conf_connNum");
    String str5 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.jdField_a_of_type_Long) + "ms" + " ,fileSize:" + this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + paramArrayOfByte);
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("serverip", paramHashMap.get("ip"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor).mTransReport.timeCost_Cache));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_code", paramHashMap.get("param_retry_code"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_ip_index", paramHashMap.get("param_ip_index"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.h = this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.f;
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.s();
    C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
  }
  
  public void onSwitch2BackupChannel()
  {
    switch (C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor))
    {
    default: 
      return;
    case 0: 
      C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, "<BDH_LOG> onSwitch2BackupChannel() BUT current status is INIT");
      return;
    case 2: 
      C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, "<BDH_LOG> onSwitch2BackupChannel() BUT current status is HTTP");
      return;
    }
    C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, "<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
    C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, 2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.r();
  }
  
  public void onTransStart()
  {
    C2CPicUploadProcessor.a(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor, "<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    C2CPicUploadProcessor localC2CPicUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.d = l;
    localC2CPicUploadProcessor.h = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.f) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.e) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.c)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     gre
 * JD-Core Version:    0.7.0.1
 */