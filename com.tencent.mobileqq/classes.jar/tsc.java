import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.ims.QQProtectRisks.QQProtectRisksResponse;
import com.tencent.mobileqq.activity.QQSettingSettingActivity;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;

public class tsc
  extends ProtoUtils.TroopProtocolObserver
{
  public tsc(QQSettingSettingActivity paramQQSettingSettingActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 0;
    if ((paramInt != 0) || (paramArrayOfByte == null)) {}
    for (paramInt = 0;; paramInt = 1)
    {
      if (paramInt != 0) {}
      try
      {
        QQProtectRisks.QQProtectRisksResponse localQQProtectRisksResponse = new QQProtectRisks.QQProtectRisksResponse();
        localQQProtectRisksResponse.mergeFrom(paramArrayOfByte);
        paramInt = i;
        if (localQQProtectRisksResponse.uint32_sec_cmd.has()) {
          paramInt = localQQProtectRisksResponse.uint32_sec_cmd.get();
        }
        if (paramInt == 1)
        {
          long l = 3600L;
          paramArrayOfByte = "";
          if (localQQProtectRisksResponse.uint32_cache_time.has()) {
            l = localQQProtectRisksResponse.uint32_cache_time.get();
          }
          if (localQQProtectRisksResponse.str_risk_exist.has()) {
            paramArrayOfByte = localQQProtectRisksResponse.str_risk_exist.get();
          }
          paramBundle = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte))
          {
            paramBundle = paramArrayOfByte;
            if (localQQProtectRisksResponse.risk_info_list.has())
            {
              paramBundle = paramArrayOfByte;
              if (!localQQProtectRisksResponse.risk_info_list.isEmpty()) {
                paramBundle = this.a.getString(2131436820);
              }
            }
          }
          QQSettingSettingActivity.a(this.a, l, paramBundle);
          this.a.runOnUiThread(new tsd(this, paramBundle));
        }
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return;
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tsc
 * JD-Core Version:    0.7.0.1
 */