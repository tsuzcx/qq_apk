import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class egq
  implements ITransactionCallback
{
  public egq(C2CPicUploadProcessor paramC2CPicUploadProcessor, long paramLong) {}
  
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
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.a(l2, l3, l4, l5);
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
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.timeCost_Cache));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", paramArrayOfByte);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str1);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str2);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str3);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str4);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b.b();
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b.a = 1;
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_h_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_Long;
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.t();
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.a(l2, l3, l4, l5);
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    switch (this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.aM)
    {
    default: 
      return;
    case 0: 
      this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.c("<BDH_LOG> onSwitch2BackupChannel() BUT current status is INIT");
      return;
    case 2: 
      this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.c("<BDH_LOG> onSwitch2BackupChannel() BUT current status is HTTP");
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.c("<BDH_LOG> onSwitch2BackupChannel() switch to HTTP channel");
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.aM = 2;
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_JavaUtilHashMap.put("param_switchChannel", String.valueOf(l - this.jdField_a_of_type_Long));
    StatisticCollector.a(BaseApplication.getContext()).a(null, "actSwitchChnl", true, l - this.jdField_a_of_type_Long, this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_Long, null, "");
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.s();
  }
  
  public void onTransStart()
  {
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.c("<BDH_LOG> onTransStart()");
    this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    C2CPicUploadProcessor localC2CPicUploadProcessor = this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor;
    FileMsg localFileMsg = this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.e = l;
    localC2CPicUploadProcessor.jdField_h_of_type_Long = l;
    if ((paramInt < this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_a_of_type_Long) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.jdField_h_of_type_Boolean) && (!this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.d)) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileC2CPicUploadProcessor.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     egq
 * JD-Core Version:    0.7.0.1
 */