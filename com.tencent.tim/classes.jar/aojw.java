import android.os.SystemClock;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.3.1;
import com.tencent.mobileqq.transfile.C2CPicUploadProcessor.3.2;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aojw
  implements ITransactionCallback
{
  aojw(aojv paramaojv, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms");
    }
    this.this$0.I(paramHashMap);
    ThreadManager.post(new C2CPicUploadProcessor.3.2(this, l2, l3, l4, l5), 5, null, false);
    this.this$0.a(paramInt, "OnFailed.", "", this.this$0.jdField_b_of_type_Aojn$a);
    this.this$0.onError();
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("C2CPicUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - this.val$startTime) + "ms ,fileSize:" + this.this$0.jdField_b_of_type_Aoko.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
    }
    this.this$0.I(paramHashMap);
    this.this$0.jdField_b_of_type_Aojn$a.dVg();
    this.this$0.jdField_b_of_type_Aojn$a.result = 1;
    aojv.b(this.this$0).dVg();
    aojv.b(this.this$0).result = 1;
    this.this$0.bz = this.this$0.mFileSize;
    this.this$0.cMm = true;
    if (this.this$0.cMl) {
      aojv.a(this.this$0, paramArrayOfByte);
    }
    this.this$0.dDP();
    ThreadManager.executeOnSubThread(new C2CPicUploadProcessor.3.1(this, l2, l3, l4, l5));
    this.this$0.jdField_b_of_type_Aoko.dVw();
    paramArrayOfByte = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    this.this$0.f(true, 0, paramArrayOfByte, paramHashMap);
  }
  
  public void onSwitch2BackupChannel()
  {
    long l = SystemClock.uptimeMillis();
    this.this$0.log("<BDH_LOG> onSwitch2BackupChannel()");
    this.this$0.mM.put("param_switchChannel", String.valueOf(l - this.val$startTime));
  }
  
  public void onTransStart()
  {
    this.this$0.log("<BDH_LOG> onTransStart()");
    this.this$0.jdField_b_of_type_Aojn$a.startTime = 0L;
    this.this$0.jdField_b_of_type_Aojn$a.dVf();
  }
  
  public void onUpdateProgress(int paramInt)
  {
    aojv localaojv = this.this$0;
    aoko localaoko = this.this$0.jdField_b_of_type_Aoko;
    long l = paramInt;
    localaoko.transferedSize = l;
    localaojv.bz = l;
    if ((paramInt < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      if ((this.this$0.cMl) && (paramInt >= aojv.a(this.this$0) * 8192))
      {
        aojv.a(this.this$0).dVg();
        aojv.a(this.this$0).result = 1;
      }
      this.this$0.dUZ();
      if (aojv.a(this.this$0)) {
        axyl.d(aojv.a(this.this$0), 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aojw
 * JD-Core Version:    0.7.0.1
 */