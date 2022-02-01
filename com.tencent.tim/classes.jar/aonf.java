import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.UploadPicExtInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class aonf
  implements ITransactionCallback
{
  aonf(aone paramaone, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
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
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms");
    }
    this.a.mM.put("X-piccachetime", paramArrayOfByte);
    this.a.mM.put("param_BdhTrans", str1);
    this.a.mM.put("param_segspercnt", str2);
    this.a.mM.put("param_conf_segSize", str3);
    this.a.mM.put("param_conf_segNum", str4);
    this.a.mM.put("param_conf_connNum", paramHashMap);
    this.a.e(l2, l3, l4, l5);
    this.a.a(paramInt, "OnFailed.", "", this.a.jdField_b_of_type_Aojn$a);
    this.a.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
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
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms ,fileSize:" + this.a.jdField_b_of_type_Aoko.fileSize + " transInfo:" + str2);
    }
    this.a.mM.put("X-piccachetime", str1);
    this.a.mM.put("param_BdhTrans", str2);
    this.a.mM.put("param_segspercnt", str3);
    this.a.mM.put("param_conf_segSize", str4);
    this.a.mM.put("param_conf_segNum", str5);
    this.a.mM.put("param_conf_connNum", paramHashMap);
    this.a.jdField_b_of_type_Aojn$a.dVg();
    this.a.jdField_b_of_type_Aojn$a.result = 1;
    this.a.bz = this.a.mFileSize;
    paramHashMap = new Bdh_extinfo.UploadPicExtInfo();
    try
    {
      paramHashMap.mergeFrom(paramArrayOfByte, 0, paramArrayOfByte.length);
      aone.a(this.a, paramHashMap.bytes_download_url.get().toStringUtf8());
      if (aone.a(this.a) == null)
      {
        this.a.a(-1, "URL IS NULL", "", this.a.jdField_b_of_type_Aojn$a);
        this.a.onError();
        this.a.e(l2, l3, l4, l5);
        this.a.jdField_b_of_type_Aoko.dVw();
        return;
      }
    }
    catch (InvalidProtocolBufferMicroException paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        continue;
        aone.a(this.a);
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    this.a.log("<BDH_LOG> onTransStart()");
    this.a.jdField_b_of_type_Aojn$a.dVf();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    aone localaone = this.a;
    aoko localaoko = this.a.jdField_b_of_type_Aoko;
    long l = paramInt;
    localaoko.transferedSize = l;
    localaone.bz = l;
    if ((paramInt <= this.a.mFileSize) && (!this.a.mIsCancel) && (!this.a.mIsPause)) {
      this.a.dUZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aonf
 * JD-Core Version:    0.7.0.1
 */