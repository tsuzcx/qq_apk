import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.common.download.OfflineDownloader;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.config.QQMapConstants;
import com.tencent.mobileqq.filemanager.util.UniformDownloadUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SelectPicPopupWindow;
import java.io.File;

public class bdm
  implements View.OnClickListener
{
  public bdm(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    int i = QQMapActivity.b(this.a).getDimensionPixelSize(2131492887);
    int j = paramView.getId();
    if (j == 2131297795) {
      if (new File(QQMapConstants.i).exists())
      {
        this.a.p = true;
        UniformDownloadUtil.a(QQMapConstants.i);
      }
    }
    label409:
    do
    {
      boolean bool;
      do
      {
        return;
        if (!NetworkUtil.e(this.a.getApplicationContext()))
        {
          QQToast.a(this.a, 1, this.a.getString(2131362607), 1).b(i);
          return;
        }
        if (NetworkUtil.g(this.a.getApplicationContext()))
        {
          this.a.i();
          return;
        }
        this.a.j();
        return;
        if (j != 2131297792) {
          break;
        }
        if (this.a.a.a == null)
        {
          QQToast.a(this.a, 1, this.a.getString(2131362609), 1).b(i);
          return;
        }
        paramView = (String)this.a.a.a.getTag();
        this.a.b(paramView);
        bool = QQMapActivity.a(this.a, paramView);
        this.a.a.dismiss();
      } while (bool);
      QQToast.a(this.a, 1, this.a.getString(2131362606), 1).b(i);
      return;
      if (j == 2131297793)
      {
        if (this.a.a.a == null)
        {
          QQToast.a(this.a, 1, this.a.getString(2131362609), 1).b(i);
          return;
        }
        if (!this.a.a(this.a.a(), true))
        {
          OfflineDownloader.d(this.a.r);
          if (!new File(QQMapConstants.i).exists()) {
            break label409;
          }
        }
        for (paramView = this.a.getString(2131362615);; paramView = this.a.getString(2131362614))
        {
          this.a.a.a(paramView);
          paramView = (String)this.a.a.a.getTag();
          if (QQMapActivity.a(this.a, paramView)) {
            break;
          }
          QQToast.a(this.a, 1, this.a.getString(2131362606), 1).b(i);
          this.a.a.dismiss();
          return;
        }
      }
    } while ((!(paramView.getTag() instanceof Integer)) || (((Integer)paramView.getTag()).intValue() != 1));
    paramView = (ImageView)paramView.findViewById(2131297796);
    if (this.a.a.a != null) {
      this.a.a.a.setVisibility(8);
    }
    this.a.a.a = paramView;
    this.a.a.a.setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdm
 * JD-Core Version:    0.7.0.1
 */