import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.transfile.BaseTransProcessor.StepInfo;
import com.tencent.mobileqq.transfile.FileMsg;
import com.tencent.mobileqq.transfile.GroupPicUploadProcessor;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class eij
  implements ITransactionCallback
{
  public eij(GroupPicUploadProcessor paramGroupPicUploadProcessor) {}
  
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
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - GroupPicUploadProcessor.a(this.a)) + "ms");
    }
    this.a.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", paramArrayOfByte);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", str1);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str2);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str3);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str4);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str5);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str6);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.a.a(l2, l3, l4, l5);
    this.a.a(paramInt, "OnFailed.", "", this.a.b);
    this.a.d();
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
      QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - GroupPicUploadProcessor.a(this.a)) + "ms" + " ,fileSize:" + this.a.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long + " transInfo:" + paramArrayOfByte);
    }
    this.a.e = this.a.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.timeCost_Ht;
    this.a.g = this.a.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.timeCost_Cache;
    this.a.jdField_a_of_type_JavaUtilHashMap.put("X-piccachetime", String.valueOf(this.a.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.timeCost_Cache));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_BdhTrans", paramArrayOfByte);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_segspercnt", str1);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segSize", str2);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_segNum", str3);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_conf_connNum", str4);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_fin_lost", str5);
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    this.a.jdField_a_of_type_JavaUtilHashMap.put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    this.a.b.b();
    this.a.b.a = 1;
    this.a.jdField_h_of_type_Long = this.a.jdField_a_of_type_Long;
    this.a.t();
    this.a.a(l2, l3, l4, l5);
    this.a.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b();
  }
  
  public void onSwitch2BackupChannel()
  {
    switch (this.a.aM)
    {
    case 0: 
    case 2: 
    default: 
      return;
    }
    this.a.aM = 2;
    this.a.s();
  }
  
  public void onTransStart()
  {
    this.a.b.a();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    GroupPicUploadProcessor localGroupPicUploadProcessor = this.a;
    FileMsg localFileMsg = this.a.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg;
    long l = paramInt;
    localFileMsg.e = l;
    localGroupPicUploadProcessor.jdField_h_of_type_Long = l;
    if ((paramInt < this.a.jdField_a_of_type_Long) && (!this.a.jdField_h_of_type_Boolean) && (!this.a.d)) {
      this.a.f();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     eij
 * JD-Core Version:    0.7.0.1
 */