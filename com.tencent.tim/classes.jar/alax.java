import ProfileLogic.QC.readUserInfoRsp;
import ProfileLogic.QC.setUserFlagRsp;
import ProfileLogic.QC.setUserProfileRsp;
import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.profile.CustomCoverFragment;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Vector;

public class alax
  extends aclh
{
  public alax(CustomCoverFragment paramCustomCoverFragment) {}
  
  public void aI(boolean paramBoolean, Object paramObject)
  {
    boolean bool = true;
    int i = 0;
    CustomCoverFragment.a(this.a).dismiss();
    Object localObject = this.a.getActivity();
    if (localObject == null) {}
    label194:
    label334:
    label353:
    label364:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              if (!paramBoolean) {
                break label724;
              }
              if (!(paramObject instanceof readUserInfoRsp)) {
                break label364;
              }
              this.a.stopTitleProgress();
              paramObject = (readUserInfoRsp)paramObject;
              if (CustomCoverFragment.a(this.a))
              {
                localObject = this.a;
                if (paramObject.flag != 1) {
                  break;
                }
                paramBoolean = true;
                CustomCoverFragment.a((CustomCoverFragment)localObject, paramBoolean);
              }
              CustomCoverFragment.a(this.a, paramObject.itemid);
              CustomCoverFragment.b(this.a, paramObject.index);
              CustomCoverFragment.c(this.a, paramObject.listend);
              if (!TextUtils.isEmpty(paramObject.urlprefix)) {
                alco.bVn = paramObject.urlprefix;
              }
              CustomCoverFragment.a(this.a, paramObject.itemlist);
              if (CustomCoverFragment.a(this.a) != null)
              {
                if (CustomCoverFragment.a(this.a).size() != 0) {
                  break label334;
                }
                CustomCoverFragment.a(this.a).setVisibility(8);
                CustomCoverFragment.c(this.a, 2);
              }
              if (CustomCoverFragment.a(this.a) != null) {
                CustomCoverFragment.a(this.a).sendEmptyMessage(101);
              }
            } while (!QLog.isColorLevel());
            localObject = new StringBuilder().append("onDefaultCardRsp: [readUserInfoRsp] selId=").append(CustomCoverFragment.a(this.a)).append(" reqIndex=").append(CustomCoverFragment.b(this.a)).append(" footerState=").append(CustomCoverFragment.c(this.a)).append(" flag=");
            if (paramObject.flag == 1)
            {
              paramBoolean = bool;
              localObject = ((StringBuilder)localObject).append(paramBoolean).append(" itemList=");
              if (paramObject.itemlist != null) {
                break label353;
              }
            }
            for (;;)
            {
              QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, i);
              return;
              paramBoolean = false;
              break;
              CustomCoverFragment.a(this.a).setVisibility(0);
              break label194;
              paramBoolean = false;
              break label293;
              i = paramObject.itemlist.size();
            }
            if (!(paramObject instanceof setUserProfileRsp)) {
              break;
            }
            i = ((setUserProfileRsp)paramObject).ret;
            if (QLog.isColorLevel()) {
              QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserProfileRsp] ret=" + i);
            }
            if (i == 0)
            {
              if (QLog.isColorLevel()) {
                QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserProfileRsp] selId=" + CustomCoverFragment.a(this.a));
              }
              paramObject = new Intent();
              paramObject.putExtra("req_code_key", 2002);
              paramObject.putExtra("card_url_key", this.a.eJ(CustomCoverFragment.d(this.a)));
              ((FragmentActivity)localObject).setResult(-1, paramObject);
              ((FragmentActivity)localObject).finish();
              return;
            }
          } while (this.a.getActivity() == null);
          QQToast.a(this.a.getActivity(), 1, 2131721430, 0).show();
          return;
        } while (!(paramObject instanceof setUserFlagRsp));
        i = ((setUserFlagRsp)paramObject).ret;
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserFlagRsp] ret=" + i);
        }
        if (i != 0) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: [setUserFlagRsp] setFlag=" + CustomCoverFragment.b(this.a));
        }
        CustomCoverFragment.a(this.a, true);
        QQToast.a((Context)localObject, 0, 2131721433, 0).show();
        if (CustomCoverFragment.b(this.a))
        {
          ((FragmentActivity)localObject).finish();
          return;
        }
        CustomCoverFragment.a(this.a, CustomCoverFragment.b(this.a));
      } while (CustomCoverFragment.a(this.a) == null);
      CustomCoverFragment.a(this.a).sendEmptyMessage(101);
      return;
    } while (this.a.getActivity() == null);
    label293:
    QQToast.a(this.a.getActivity(), 1, 2131721430, 0).show();
    return;
    label724:
    if (QLog.isColorLevel()) {
      QLog.d("Q.profilecard.FrdProfileCard.CustomCoverFragment", 2, "onDefaultCardRsp: isSuccess=false, cmd=" + paramObject);
    }
    if ("profilelogic.readUserInfo".equals(paramObject))
    {
      CustomCoverFragment.c(this.a, 1);
      this.a.stopTitleProgress();
      QQToast.a((Context)localObject, 1, 2131721071, 0).show();
      return;
    }
    QQToast.a((Context)localObject, 1, 2131721430, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alax
 * JD-Core Version:    0.7.0.1
 */