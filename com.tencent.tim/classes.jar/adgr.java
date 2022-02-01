import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;

class adgr
  implements ITransactionCallback
{
  adgr(adgp paramadgp, adhv paramadhv, long paramLong) {}
  
  public void onFailed(int paramInt, byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    String str = "";
    for (;;)
    {
      synchronized (adgp.a(this.jdField_a_of_type_Adgp))
      {
        if (adgp.a(this.jdField_a_of_type_Adgp) != null)
        {
          int i = 0;
          if (i < adgp.a(this.jdField_a_of_type_Adgp).size())
          {
            if (((adgp.c)adgp.a(this.jdField_a_of_type_Adgp).get(i)).b.sessionId.equals(this.jdField_a_of_type_Adhv.sessionId))
            {
              paramArrayOfByte = ((adgp.c)adgp.a(this.jdField_a_of_type_Adgp).get(i)).a;
              str = ((adgp.c)adgp.a(this.jdField_a_of_type_Adgp).get(i)).b.sessionId;
              adgp.a(this.jdField_a_of_type_Adgp).remove(i);
              QLog.i("AREngine_ARCloudFileUpload", 1, "Upload failed. retCode = " + paramInt + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str);
              if (paramArrayOfByte != null) {
                paramArrayOfByte.a(paramInt, str, null);
              }
              return;
            }
            i += 1;
          }
        }
      }
      paramArrayOfByte = null;
    }
  }
  
  public void onSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap)
  {
    Object localObject2 = null;
    String str2 = "";
    Object localObject3 = adgp.a(this.jdField_a_of_type_Adgp);
    String str1 = str2;
    Object localObject1 = localObject2;
    for (;;)
    {
      try
      {
        if (adgp.a(this.jdField_a_of_type_Adgp) != null)
        {
          i = 0;
          str1 = str2;
          localObject1 = localObject2;
          if (i < adgp.a(this.jdField_a_of_type_Adgp).size())
          {
            if (!((adgp.c)adgp.a(this.jdField_a_of_type_Adgp).get(i)).b.sessionId.equals(this.jdField_a_of_type_Adhv.sessionId)) {
              continue;
            }
            localObject1 = ((adgp.c)adgp.a(this.jdField_a_of_type_Adgp).get(i)).a;
            str1 = ((adgp.c)adgp.a(this.jdField_a_of_type_Adgp).get(i)).b.sessionId;
            adgp.a(this.jdField_a_of_type_Adgp).remove(i);
          }
        }
        paramArrayOfByte = adgp.a(this.jdField_a_of_type_Adgp, paramArrayOfByte, this.jdField_a_of_type_Adhv);
        if (paramArrayOfByte == null)
        {
          QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 9058 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1 + ". deserialize pb failed.");
          i = 9058;
          if (localObject1 != null) {
            ((adgp.a)localObject1).a(i, str1, paramArrayOfByte);
          }
          return;
          i += 1;
          continue;
        }
        QLog.i("AREngine_ARCloudFileUpload", 1, "Upload successfully. retCode = " + 0 + ", IP = " + (String)paramHashMap.get("ip") + ", sessionId = " + str1);
      }
      finally {}
      int i = 0;
    }
  }
  
  public void onSwitch2BackupChannel() {}
  
  public void onTransStart()
  {
    QLog.i("AREngine_ARCloudFileUpload", 1, "Upload start. sessionId = " + this.jdField_a_of_type_Adhv.sessionId);
  }
  
  public void onUpdateProgress(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AREngine_ARCloudFileUpload", 2, "onUpdateProgress. sessionId = " + this.jdField_a_of_type_Adhv.sessionId + ". total size = " + this.val$totalSize + ", transfered size = " + paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adgr
 * JD-Core Version:    0.7.0.1
 */