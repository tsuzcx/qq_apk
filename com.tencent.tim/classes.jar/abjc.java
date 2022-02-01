import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController;
import com.tencent.mobileqq.apollo.SettingMeApolloViewController.5.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.os.MqqHandler;

public class abjc
  implements abrm
{
  public abjc(SettingMeApolloViewController paramSettingMeApolloViewController) {}
  
  public void A(int paramInt1, int paramInt2, String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SettingMeApolloViewController", 2, new Object[] { "[onApolloClick] ", "apolloStatus:", Integer.valueOf(paramInt1), ",clickPart:", Integer.valueOf(paramInt2), ",apolloId:", paramString });
    }
    Object localObject = (QQSettingMe)SettingMeApolloViewController.a(this.this$0).get();
    if (localObject == null) {}
    ViewGroup localViewGroup;
    do
    {
      do
      {
        return;
        localObject = ((QQSettingMe)localObject).getApp();
      } while (localObject == null);
      localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.this$0).get();
    } while ((localViewGroup == null) || (paramInt1 == 0));
    ThreadManager.getUIHandler().post(new SettingMeApolloViewController.5.1(this, paramInt2, localViewGroup, (QQAppInterface)localObject, paramString));
  }
  
  public void TI()
  {
    if (this.this$0.a == null) {}
    Object localObject;
    ViewGroup localViewGroup;
    do
    {
      do
      {
        do
        {
          return;
          localObject = (QQSettingMe)SettingMeApolloViewController.a(this.this$0).get();
        } while (localObject == null);
        localObject = ((QQSettingMe)localObject).getApp();
      } while (localObject == null);
      localViewGroup = (ViewGroup)SettingMeApolloViewController.b(this.this$0).get();
    } while ((localViewGroup == null) || (this.this$0.a.a(SettingMeApolloViewController.a(this.this$0), this.this$0.mRoleId, (AppInterface)localObject, localViewGroup.getContext()) != 0));
    this.this$0.a.a(SettingMeApolloViewController.a(this.this$0), localViewGroup.getContext(), (QQAppInterface)localObject, this.this$0.mRoleId);
  }
  
  public void cCk()
  {
    this.this$0.bHo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abjc
 * JD-Core Version:    0.7.0.1
 */