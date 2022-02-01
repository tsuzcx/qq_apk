import android.os.Bundle;
import android.os.Handler;
import com.tencent.mobileqq.emosm.web.MessengerService;
import com.tencent.mobileqq.emosm.web.MessengerService.8.1;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.qphone.base.util.QLog;

public class afiz
  implements amfk
{
  public afiz(MessengerService paramMessengerService) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (this.a.aD != null)
    {
      this.a.aD.putString("cmd", "ipc_signature_setordelete");
      paramRichStatus = new Bundle();
      paramRichStatus.putInt("result", paramInt);
      paramRichStatus.putBoolean("hasTipsInfo", false);
      if ((paramObject instanceof TipsInfo))
      {
        paramObject = (TipsInfo)paramObject;
        if (paramObject.type > 0)
        {
          paramRichStatus.putInt("result", paramObject.ret);
          paramRichStatus.putBoolean("hasTipsInfo", true);
          paramRichStatus.putInt("tips_type", paramObject.type);
          paramRichStatus.putString("tips_titleWording", paramObject.titleWording);
          paramRichStatus.putString("tips_wording", paramObject.wording);
          paramRichStatus.putString("tips_rightBtnWording", paramObject.rightBtnWording);
          paramRichStatus.putString("tips_leftBtnWording", paramObject.leftBtnWording);
          paramRichStatus.putString("tips_vipType", paramObject.vipType);
          paramRichStatus.putInt("tips_vipMonth", paramObject.vipMonth);
          paramRichStatus.putString("tips_url", paramObject.url);
        }
      }
      this.a.aD.putBundle("response", paramRichStatus);
      this.a.cp(this.a.aD);
      this.a.aD = null;
    }
  }
  
  public void aF(int paramInt, boolean paramBoolean)
  {
    if (paramInt == -1) {
      if (this.a.aB != null) {
        this.a.aB.post(new MessengerService.8.1(this));
      }
    }
    while (this.a.aE == null) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("SigImg2Zone", 4, "isSync: " + paramBoolean);
    }
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("isSync", paramBoolean);
    this.a.aE.putBundle("response", localBundle);
    this.a.cp(this.a.aE);
    this.a.aE = null;
  }
  
  public void aG(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afiz
 * JD-Core Version:    0.7.0.1
 */