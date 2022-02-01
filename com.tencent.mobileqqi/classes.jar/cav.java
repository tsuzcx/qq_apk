import android.content.Context;
import android.os.Environment;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity.PicInfo;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

class cav
  implements View.OnClickListener
{
  cav(cau paramcau) {}
  
  public void onClick(View paramView)
  {
    if (!Environment.getExternalStorageState().equals("mounted")) {
      Toast.makeText(this.a.a.a, this.a.a.getBaseContext().getString(2131562496), 0).show();
    }
    String str;
    do
    {
      return;
      paramView = (ChatBackgroundSettingActivity.PicInfo)((View)paramView.getParent()).getTag();
      str = AppConstants.aW + paramView.b + ".png";
    } while (new File(str).exists());
    if (!NetworkUtil.e(BaseApplication.getContext()))
    {
      Toast.makeText(this.a.a.a, this.a.a.getBaseContext().getString(2131562947), 0).show();
      return;
    }
    this.a.a.b.a().a(paramView.c, str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     cav
 * JD-Core Version:    0.7.0.1
 */