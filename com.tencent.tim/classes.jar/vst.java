import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.ims.QQProtectRisks.QQProtectRisksResponse;
import com.tencent.ims.QQProtectRisks.RiskInfo;
import com.tencent.mobileqq.activity.RiskInfoActivity;
import com.tencent.mobileqq.activity.RiskInfoItem;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Map;

public class vst
  extends jnm.d
{
  public vst(RiskInfoActivity paramRiskInfoActivity) {}
  
  public void a(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    boolean bool1;
    boolean bool2;
    if ((paramInt != 0) || (paramArrayOfByte == null))
    {
      if (QLog.isColorLevel()) {
        QLog.i("RiskInfoDetails", 2, "request risks info,onResult error=" + paramInt + " data=" + paramArrayOfByte);
      }
      bool1 = false;
      paramBundle = new HashMap();
      bool2 = bool1;
      if (!bool1) {}
    }
    for (;;)
    {
      try
      {
        QQProtectRisks.QQProtectRisksResponse localQQProtectRisksResponse = new QQProtectRisks.QQProtectRisksResponse();
        localQQProtectRisksResponse.mergeFrom(paramArrayOfByte);
        paramInt = 0;
        if (localQQProtectRisksResponse.uint32_sec_cmd.has()) {
          paramInt = localQQProtectRisksResponse.uint32_sec_cmd.get();
        }
        bool2 = bool1;
        if (paramInt == 1)
        {
          bool2 = bool1;
          if (localQQProtectRisksResponse.risk_info_list.has())
          {
            bool2 = bool1;
            if (!localQQProtectRisksResponse.risk_info_list.isEmpty())
            {
              paramInt = 0;
              bool2 = bool1;
              if (paramInt < localQQProtectRisksResponse.risk_info_list.size())
              {
                new QQProtectRisks.RiskInfo();
                paramArrayOfByte = (QQProtectRisks.RiskInfo)localQQProtectRisksResponse.risk_info_list.get(paramInt);
                if ((paramArrayOfByte.uint32_item_type.has()) && (paramArrayOfByte.uint32_item_type.get() == 1)) {
                  break label511;
                }
                RiskInfoItem localRiskInfoItem = new RiskInfoItem();
                localRiskInfoItem.Qv = paramArrayOfByte.str_left_text.get();
                localRiskInfoItem.aPK = paramArrayOfByte.str_jump_target.get();
                if ((TextUtils.isEmpty(localRiskInfoItem.Qv)) || (TextUtils.isEmpty(localRiskInfoItem.aPK))) {
                  break label511;
                }
                localRiskInfoItem.aPJ = paramArrayOfByte.str_right_text.get();
                localRiskInfoItem.Vf = paramArrayOfByte.str_desc_text.get();
                localRiskInfoItem.bKE = paramArrayOfByte.uint32_click_report_id.get();
                if (paramArrayOfByte.uint32_item_id.has()) {
                  localRiskInfoItem.mItemId = paramArrayOfByte.uint32_item_id.get();
                }
                if (paramArrayOfByte.str_right_text_open.has()) {
                  localRiskInfoItem.aPL = paramArrayOfByte.str_right_text_open.get();
                }
                paramArrayOfByte = String.format("%d", new Object[] { Integer.valueOf(localRiskInfoItem.mItemId) });
                if (localRiskInfoItem.mItemId == 0) {
                  paramArrayOfByte = localRiskInfoItem.aPK;
                }
                paramBundle.put(paramArrayOfByte, localRiskInfoItem);
                QLog.d("RiskInfoDetails", 1, String.format("%s, %s, %s, %s, %d, %d, %s", new Object[] { localRiskInfoItem.Qv, localRiskInfoItem.aPJ, localRiskInfoItem.Vf, localRiskInfoItem.aPK, Integer.valueOf(localRiskInfoItem.bKE), Integer.valueOf(localRiskInfoItem.mItemId), localRiskInfoItem.aPL }));
              }
            }
          }
        }
      }
      catch (InvalidProtocolBufferMicroException paramArrayOfByte)
      {
        QLog.d("RiskInfoDetails", 1, "error protobuf content");
        bool2 = false;
        RiskInfoActivity.a(this.a, paramBundle, bool2);
        return;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        bool2 = bool1;
        continue;
      }
      bool1 = true;
      break;
      label511:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vst
 * JD-Core Version:    0.7.0.1
 */