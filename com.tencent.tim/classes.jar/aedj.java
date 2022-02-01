import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import cooperation.comic.VipComicJumpActivity;
import cooperation.comic.VipComicJumpActivity.b;

public class aedj
  implements aedn
{
  public String getTitle()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131690945);
  }
  
  public void onHeaderClick(View paramView, int paramInt)
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
    Object localObject = new Intent("android.intent.action.MAIN");
    paramView = paramView.getContext();
    localObject = VipComicJumpActivity.a((Intent)localObject);
    if (VipComicJumpActivity.a(localQQAppInterface, (Activity)paramView, (VipComicJumpActivity.b)localObject)) {
      VipComicJumpActivity.d(localQQAppInterface, true);
    }
    anot.a(null, "dc00898", "", "", "0X800AA81", "0X800AA81", aebs.gW(paramInt), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedj
 * JD-Core Version:    0.7.0.1
 */