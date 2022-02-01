import android.text.TextUtils;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.CommFileExtRsp;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class jlv
  implements ITransactionCallback
{
  long lastLogTime = 0L;
  
  jlv(jlu paramjlu, String paramString, long paramLong, byte[] paramArrayOfByte, jlu.a parama) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    QLog.w(this.jdField_a_of_type_Jlu.TAG, 1, "onFailed, sessionId[" + this.val$sessionId + "], retCode[" + paramInt + "]");
    paramArrayOfByte = aqhs.bytes2HexStr(this.bg);
    this.jdField_a_of_type_Jlu$a.d(paramInt, this.val$sessionId, "", paramArrayOfByte);
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str2 = "";
    String str1;
    if (paramArrayOfByte != null) {
      str1 = str2;
    }
    for (;;)
    {
      int i;
      try
      {
        localObject2 = new Bdh_extinfo.CommFileExtRsp();
        str1 = str2;
        ((Bdh_extinfo.CommFileExtRsp)localObject2).mergeFrom(paramArrayOfByte);
        str1 = str2;
        str2 = ((Bdh_extinfo.CommFileExtRsp)localObject2).bytes_download_url.get().toStringUtf8();
        str1 = str2;
        boolean bool = TextUtils.isEmpty(str2);
        if (!bool) {
          continue;
        }
        i = -10010;
        str1 = str2;
      }
      catch (Exception localException2)
      {
        Object localObject2;
        StringBuilder localStringBuilder;
        i = -10012;
        continue;
        paramArrayOfByte = null;
        continue;
      }
      str2 = aqhs.bytes2HexStr(this.bg);
      localObject2 = this.jdField_a_of_type_Jlu.TAG;
      localStringBuilder = new StringBuilder().append("onSuccess, sessionId[").append(this.val$sessionId).append("], respData[");
      Object localObject1;
      if (paramArrayOfByte != null)
      {
        paramArrayOfByte = Integer.valueOf(paramArrayOfByte.length);
        QLog.w((String)localObject2, 1, paramArrayOfByte + "], retCode[" + i + "], md5[" + str2 + "], url[" + str1 + "]");
        AudioHelper.b(this.jdField_a_of_type_Jlu.TAG, paramHashMap, false);
        this.jdField_a_of_type_Jlu$a.d(i, this.val$sessionId, str1, str2);
        return;
        try
        {
          if (QLog.isDevelopLevel()) {
            QLog.w(this.jdField_a_of_type_Jlu.TAG, 1, "onSuccess, sessionId[" + this.val$sessionId + "], 原始url[" + str2 + "]");
          }
          str1 = aurr.encodeUrl(str2);
          i = 0;
        }
        catch (Exception localException1)
        {
          i = -10011;
          localObject1 = str2;
        }
      }
      else
      {
        i = 0;
        localObject1 = localException2;
      }
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    QLog.w(this.jdField_a_of_type_Jlu.TAG, 1, "onTransStart, sessionId[" + this.val$sessionId + "]");
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel())
    {
      long l = System.currentTimeMillis();
      if (this.lastLogTime < l)
      {
        QLog.w(this.jdField_a_of_type_Jlu.TAG, 1, "onUpdateProgress, sessionId[" + this.val$sessionId + "], transferedSize[" + paramInt + "], totalSize[" + this.val$totalSize + "]");
        this.lastLogTime = (l + 2000L);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jlv
 * JD-Core Version:    0.7.0.1
 */