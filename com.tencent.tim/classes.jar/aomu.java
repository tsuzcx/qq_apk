import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.TransReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;

class aomu
  implements ITransactionCallback
{
  aomu(aomt paramaomt, String paramString) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    paramArrayOfByte = (String)paramHashMap.get("tc_p:");
    String str1 = (String)paramHashMap.get("rep_bdhTrans");
    String str2 = (String)paramHashMap.get("segspercnt");
    String str3 = (String)paramHashMap.get("param_conf_segSize");
    String str4 = (String)paramHashMap.get("param_conf_segNum");
    String str5 = (String)paramHashMap.get("param_conf_connNum");
    String str6 = (String)paramHashMap.get("param_fin_lost");
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - aomt.a(this.a)) + "ms");
    }
    aomt.a(this.a).put("serverip", paramHashMap.get("ip"));
    aomt.a(this.a).put("param_bdhSrv", paramHashMap.get("ip"));
    aomt.a(this.a).put("param_bdhPort", paramHashMap.get("port"));
    aomt.a(this.a).put("X-piccachetime", paramArrayOfByte);
    aomt.a(this.a).put("param_BdhTrans", str1);
    aomt.a(this.a).put("param_segspercnt", str2);
    aomt.a(this.a).put("param_conf_segSize", str3);
    aomt.a(this.a).put("param_conf_segNum", str4);
    aomt.a(this.a).put("param_conf_connNum", str5);
    aomt.a(this.a).put("param_fin_lost", str6);
    aomt.a(this.a).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
    aomt.a(this.a).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
    aomt.a(this.a).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
    aomt.a(this.a).put("param_retry_code", paramHashMap.get("param_retry_code"));
    aomt.a(this.a).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
    aomt.a(this.a).put("param_ip_index", paramHashMap.get("param_ip_index"));
    aomt.a(this.a).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      aomt.a(this.a, true);
    }
    aomt.a(this.a, paramInt);
    aomt.c(this.a, "sessionKey or sigSession is null");
    aomt.a(this.a).onFailed(paramInt, aomt.b(this.a));
    aomt.a(this.a, false);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          aomt.a(this.a, paramArrayOfByte);
          aomt.a(this.a).onSuccess(paramArrayOfByte);
          if (QLog.isColorLevel()) {
            QLog.d("PtvGuideUploader", 2, "set uuid from BDH ");
          }
        }
      }
      aomt.b(this.a, (String)paramHashMap.get("rep_bdhTrans"));
      paramArrayOfByte = (String)paramHashMap.get("segspercnt");
      String str1 = (String)paramHashMap.get("param_conf_segSize");
      String str2 = (String)paramHashMap.get("param_conf_segNum");
      String str3 = (String)paramHashMap.get("param_conf_connNum");
      String str4 = (String)paramHashMap.get("param_fin_lost");
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - aomt.a(this.a)) + "ms transInfo:" + aomt.a(this.a));
      }
      aomt.a(this.a).put("serverip", paramHashMap.get("ip"));
      aomt.a(this.a).put("param_bdhSrv", paramHashMap.get("ip"));
      aomt.a(this.a).put("param_bdhPort", paramHashMap.get("port"));
      aomt.a(this.a).put("X-piccachetime", String.valueOf(aomt.a(this.a).mTransReport.timeCost_Cache));
      aomt.a(this.a).put("param_BdhTrans", aomt.a(this.a));
      aomt.a(this.a).put("param_segspercnt", paramArrayOfByte);
      aomt.a(this.a).put("param_conf_segSize", str1);
      aomt.a(this.a).put("param_conf_segNum", str2);
      aomt.a(this.a).put("param_conf_connNum", str3);
      aomt.a(this.a).put("param_fin_lost", str4);
      aomt.a(this.a).put("param_retry_seg_count", paramHashMap.get("param_retry_seg_count"));
      aomt.a(this.a).put("param_max_retry_times", paramHashMap.get("param_max_retry_times"));
      aomt.a(this.a).put("param_total_retry_times", paramHashMap.get("param_total_retry_times"));
      aomt.a(this.a).put("param_retry_code", paramHashMap.get("param_retry_code"));
      aomt.a(this.a).put("param_heart_resp", paramHashMap.get("param_heart_resp"));
      aomt.a(this.a).put("param_ip_index", paramHashMap.get("param_ip_index"));
      aomt.a(this.a).put("param_Ip_ConnCost", paramHashMap.get("param_Ip_ConnCost"));
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        aomt.a(this.a, true);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PtvGuideUploader", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      aqhq.deleteFile(this.clQ);
      aomt.a(this.a, true);
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("PtvGuideUploader", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    if (QLog.isColorLevel()) {
      QLog.d("PtvGuideUploader", 2, "<BDH_LOG> onTransStart()");
    }
  }
  
  public void onUpdateProgress(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aomu
 * JD-Core Version:    0.7.0.1
 */