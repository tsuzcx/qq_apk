import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SignTextEditFragment;
import com.tencent.mobileqq.richstatus.SignTextEditFragment.7.1;
import com.tencent.mobileqq.richstatus.TipsInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;

public class amfw
  implements amfk
{
  public amfw(SignTextEditFragment paramSignTextEditFragment) {}
  
  public void a(int paramInt, RichStatus paramRichStatus, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.i("SignTextEditFragment", 2, String.format("onChangeStatus reslut=%d status=%s", new Object[] { Integer.valueOf(paramInt), paramRichStatus }));
    }
    if ((paramRichStatus == null) || (paramRichStatus == RichStatus.getEmptyStatus())) {
      if (paramInt == 100) {
        QQToast.a(BaseApplication.context, 2, acfp.m(2131714583), 0).show();
      }
    }
    for (int i = 0;; i = 1)
    {
      if ((paramObject instanceof TipsInfo))
      {
        paramRichStatus = (TipsInfo)paramObject;
        SignTextEditFragment.b(this.a, paramRichStatus.errorDesc);
        if (TextUtils.isEmpty(SignTextEditFragment.a(this.a))) {
          SignTextEditFragment.b(this.a, paramRichStatus.wording);
        }
      }
      if (paramInt == 100)
      {
        SignTextEditFragment.a(this.a, false);
        this.a.cCr = true;
        this.a.c = new RichStatus(null);
        this.a.c.copyFrom(SignTextEditFragment.a(this.a).a(true));
        paramObject = this.a.mApp.getAccount();
        paramRichStatus = paramObject;
        if (paramObject == null) {
          paramRichStatus = "noLogin";
        }
        this.a.mApp.getApp().getSharedPreferences(paramRichStatus, 4).edit().putString("sign_location_id_" + this.a.mApp.getCurrentAccountUin(), SignTextEditFragment.b(this.a)).commit();
        if (this.a.isAdded()) {
          SignTextEditFragment.a(this.a, false);
        }
        paramRichStatus = BaseApplicationImpl.getApplication().getSharedPreferences("mobileQQ", 4);
        paramRichStatus.edit().putBoolean(this.a.mApp.getCurrentAccountUin() + "edit_signature_version_826", true);
        j = i;
        if (3 == this.a.fromType)
        {
          amhd.a().addObserver(this.a.g);
          paramObject = amhd.a().a(this.a.c.tplId);
          if ((Integer.parseInt(paramObject.id) != this.a.c.tplId) && (paramObject.er.get()))
          {
            SignTextEditFragment.a(this.a).set(true);
            this.a.mUIHandler.postDelayed(new SignTextEditFragment.7.1(this), 1500L);
          }
        }
      }
      while (i == 0)
      {
        return;
        QQToast.a(BaseApplication.context, 1, acfp.m(2131714575), 0).show();
        break;
        int j = i;
        if (Integer.parseInt(paramObject.id) > 0)
        {
          j = i;
          if (paramObject.materialVersion < 2)
          {
            j = i;
            if (paramRichStatus.getBoolean(this.a.mApp.getCurrentAccountUin() + "new_signature_version_826", true))
            {
              aqnl.a(this.a.getActivity(), this.a.getActivity().app, 0, "signature_chouti");
              j = 0;
            }
          }
        }
        if (j != 0) {
          this.a.dF(paramInt, SignTextEditFragment.a(this.a));
        }
        this.a.onBackEvent();
        return;
      }
      this.a.dF(paramInt, SignTextEditFragment.a(this.a));
      return;
    }
  }
  
  public void aF(int paramInt, boolean paramBoolean) {}
  
  public void aG(int paramInt, boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amfw
 * JD-Core Version:    0.7.0.1
 */