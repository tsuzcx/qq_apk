import android.os.Bundle;
import android.os.Message;
import android.text.TextUtils;
import com.tencent.ims.QQProtectRisks.QQProtectRisksResponse;
import com.tencent.ims.QQProtectRisks.RiskInfo;
import com.tencent.mobileqq.activity.LoginInfoActivity;
import com.tencent.mobileqq.activity.RiskInfoItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class vgi
  extends jnm.d
{
  public vgi(LoginInfoActivity paramLoginInfoActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    int i = 1;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("LoginInfoActivity.AccDevSec", 2, "request risks info,onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      i = 0;
    }
    paramInt = i;
    if (i != 0) {}
    for (;;)
    {
      try
      {
        localObject = new QQProtectRisks.QQProtectRisksResponse();
        ((QQProtectRisks.QQProtectRisksResponse)localObject).mergeFrom(paramArrayOfByte);
        paramInt = 0;
        if (((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_sec_cmd.has()) {
          paramInt = ((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_sec_cmd.get();
        }
        if (paramInt == 1)
        {
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).str_no_risk_text.has())
          {
            paramArrayOfByte = ((QQProtectRisks.QQProtectRisksResponse)localObject).str_no_risk_text.get();
            if (!TextUtils.isEmpty(paramArrayOfByte)) {
              LoginInfoActivity.a(this.this$0, paramArrayOfByte);
            }
          }
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_tip_text.has())
          {
            paramArrayOfByte = ((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_tip_text.get();
            if (!TextUtils.isEmpty(paramArrayOfByte)) {
              LoginInfoActivity.b(this.this$0, paramArrayOfByte + "　");
            }
          }
          if ((((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.has()) && (!((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.isEmpty()))
          {
            paramInt = 0;
            if (paramInt < ((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.size())
            {
              new QQProtectRisks.RiskInfo();
              paramArrayOfByte = (QQProtectRisks.RiskInfo)((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.get(paramInt);
              if ((paramArrayOfByte.uint32_item_type.has()) && (paramArrayOfByte.uint32_item_type.get() == 1)) {
                break label906;
              }
              paramBundle = new RiskInfoItem();
              paramBundle.Qv = paramArrayOfByte.str_left_text.get();
              paramBundle.aPK = paramArrayOfByte.str_jump_target.get();
              if ((TextUtils.isEmpty(paramBundle.Qv)) || (TextUtils.isEmpty(paramBundle.aPK))) {
                break label906;
              }
              paramBundle.aPJ = paramArrayOfByte.str_right_text.get();
              paramBundle.Vf = paramArrayOfByte.str_desc_text.get();
              paramBundle.bKE = paramArrayOfByte.uint32_click_report_id.get();
              if (paramArrayOfByte.uint32_item_id.has()) {
                paramBundle.mItemId = paramArrayOfByte.uint32_item_id.get();
              }
              if (paramArrayOfByte.str_right_text_open.has()) {
                paramBundle.aPL = paramArrayOfByte.str_right_text_open.get();
              }
              if (!LoginInfoActivity.c(this.this$0)) {
                LoginInfoActivity.a(this.this$0).add(paramBundle);
              }
              QLog.d("LoginInfoActivity.AccDevSec", 1, String.format("%s, %s, %s, %s, %d, %d, %s", new Object[] { paramBundle.Qv, paramBundle.aPJ, paramBundle.Vf, paramBundle.aPK, Integer.valueOf(paramBundle.bKE), Integer.valueOf(paramBundle.mItemId), paramBundle.aPL }));
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        Object localObject;
        QLog.d("LoginInfoActivity.AccDevSec", 1, "error protobuf content");
        paramInt = 0;
        if ((LoginInfoActivity.a(this.this$0) != null) && (!LoginInfoActivity.a(this.this$0).isEmpty()))
        {
          if (TextUtils.isEmpty(LoginInfoActivity.a(this.this$0)))
          {
            paramArrayOfByte = ((RiskInfoItem)LoginInfoActivity.a(this.this$0).get(0)).Qv;
            i = LoginInfoActivity.a(this.this$0).size();
            paramBundle = this.this$0.getString(2131717233);
            LoginInfoActivity.b(this.this$0, String.format(paramBundle, new Object[] { paramArrayOfByte, Integer.valueOf(i) }));
          }
          paramArrayOfByte = LoginInfoActivity.a(this.this$0);
          bool = false;
          if (paramInt == 0) {
            paramArrayOfByte = this.this$0.getString(2131717235);
          }
          LoginInfoActivity.b(this.this$0, bool);
          paramBundle = LoginInfoActivity.a(this.this$0).obtainMessage(20170211);
          localObject = new Bundle();
          ((Bundle)localObject).putBoolean("bSafe", bool);
          ((Bundle)localObject).putString("TipText", paramArrayOfByte);
          paramBundle.setData((Bundle)localObject);
          LoginInfoActivity.a(this.this$0).sendMessageDelayed(paramBundle, 2000L);
          return;
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_qpim_switches.has())
          {
            paramInt = ((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_qpim_switches.get();
            LoginInfoActivity.b(this.this$0, paramInt);
          }
          long l = 3600L;
          paramArrayOfByte = "";
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_cache_time.has()) {
            l = ((QQProtectRisks.QQProtectRisksResponse)localObject).uint32_cache_time.get();
          }
          if (((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_exist.has()) {
            paramArrayOfByte = ((QQProtectRisks.QQProtectRisksResponse)localObject).str_risk_exist.get();
          }
          paramBundle = paramArrayOfByte;
          if (TextUtils.isEmpty(paramArrayOfByte))
          {
            paramBundle = paramArrayOfByte;
            if (((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.has())
            {
              paramBundle = paramArrayOfByte;
              if (!((QQProtectRisks.QQProtectRisksResponse)localObject).risk_info_list.isEmpty()) {
                paramBundle = this.this$0.getString(2131701611);
              }
            }
          }
          LoginInfoActivity.a(this.this$0, l, paramBundle);
          paramInt = i;
          continue;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        paramInt = i;
        continue;
        if (TextUtils.isEmpty(LoginInfoActivity.b(this.this$0))) {
          LoginInfoActivity.a(this.this$0, this.this$0.getString(2131717236));
        }
        paramArrayOfByte = LoginInfoActivity.b(this.this$0);
        boolean bool = true;
        continue;
      }
      label906:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vgi
 * JD-Core Version:    0.7.0.1
 */