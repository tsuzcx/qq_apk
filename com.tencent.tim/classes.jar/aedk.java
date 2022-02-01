import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;

public class aedk
  implements aedn
{
  public String getTitle()
  {
    return ((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()).getApp().getResources().getString(2131693453);
  }
  
  public void onHeaderClick(View paramView, int paramInt)
  {
    boolean bool2 = true;
    Context localContext = paramView.getContext();
    boolean bool1;
    if (!((BaseActivity)paramView.getContext()).isInMultiWindow())
    {
      bool1 = true;
      if (!(localContext instanceof BaseActivity)) {
        break label121;
      }
      if (((BaseActivity)localContext).isInMultiWindow()) {
        break label116;
      }
      bool1 = bool2;
    }
    label116:
    label121:
    for (;;)
    {
      paramView = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      avja.a((Activity)localContext, paramView.getAccount(), null, -1, bool1);
      avjg.b(paramView, 6, 0);
      avjj.ZS(paramView.getCurrentAccountUin());
      anot.a(null, "dc00898", "", "", "0X800AA81", "0X800AA81", 2, 0, "", "", "", "");
      return;
      bool1 = false;
      break;
      bool1 = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedk
 * JD-Core Version:    0.7.0.1
 */