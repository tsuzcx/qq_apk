import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.agent.AuthorityControlAppDetailsFragment;
import com.tencent.open.model.AppInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class arpg
  extends asau
{
  public arpg(AuthorityControlAppDetailsFragment paramAuthorityControlAppDetailsFragment) {}
  
  protected void W(boolean paramBoolean, List<AppInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.i("AuthorityControlAppDetailsActivity", 2, "onDelApp: invoked.  isSuccess: " + paramBoolean + " infos: " + paramList);
    }
    Object localObject;
    if (paramBoolean)
    {
      localObject = acfp.m(2131702934) + AuthorityControlAppDetailsFragment.a(this.a).getName() + acfp.m(2131702932);
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.a), 2, (CharSequence)localObject, 0).show();
      localObject = new Intent();
      if ((paramList != null) && (paramList.size() == 1))
      {
        ((Intent)localObject).putExtra("KEY_DELETED_INFO", (Parcelable)paramList.get(0));
        AuthorityControlAppDetailsFragment.a(this.a).setResult(-1, (Intent)localObject);
      }
      AuthorityControlAppDetailsFragment.a(this.a).finish();
      localObject = AuthorityControlAppDetailsFragment.a(this.a);
      if (!paramBoolean) {
        break label236;
      }
    }
    label236:
    for (paramList = "0";; paramList = "1")
    {
      anot.a((QQAppInterface)localObject, "dc00898", "", "", "0X8009E1C", "0X8009E1C", 0, 0, paramList, "", String.valueOf(AuthorityControlAppDetailsFragment.a(this.a).getId()), "");
      return;
      QQToast.a(AuthorityControlAppDetailsFragment.a(this.a), 1, acfp.m(2131702933), 0).show();
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arpg
 * JD-Core Version:    0.7.0.1
 */