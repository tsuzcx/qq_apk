import android.os.SystemClock;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import java.util.HashMap;

class aono
  implements ITransactionCallback
{
  aono(aonn paramaonn, String paramString, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.a(paramInt, paramHashMap, this.val$startTime);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    this.this$0.a(paramArrayOfByte, paramHashMap, this.clQ, this.val$startTime);
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
    aonn localaonn = this.this$0;
    aoko localaoko = this.this$0.jdField_b_of_type_Aoko;
    long l = paramInt;
    localaoko.transferedSize = l;
    localaonn.bz = l;
    if ((paramInt < this.this$0.mFileSize) && (!this.this$0.mIsCancel) && (!this.this$0.mIsPause))
    {
      this.this$0.dUZ();
      if (this.this$0.isStoryVideo) {
        axyl.d(this.this$0.a, 1002, this.this$0.getProgress());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aono
 * JD-Core Version:    0.7.0.1
 */