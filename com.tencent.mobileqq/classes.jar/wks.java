import NS_COMM.COMM.StCommonExt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class wks
  implements View.OnClickListener
{
  wks(wkq paramwkq) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder(wip.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (this.a.a() != null) {}
    for (;;)
    {
      try
      {
        paramView.append(URLEncoder.encode(this.a.a().attachInfo.get(), "UTF-8"));
        xhe.b("auth_follow", "clk_more", 0, 0, new String[0]);
        wiv.a(paramView.toString());
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d(wkq.a, 0, "jump more recommend H5 page with no attach info!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wks
 * JD-Core Version:    0.7.0.1
 */