import NS_COMM.COMM.StCommonExt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class ydr
  implements View.OnClickListener
{
  ydr(ydp paramydp) {}
  
  public void onClick(View paramView)
  {
    paramView = new StringBuilder(ybn.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (this.a.a() != null) {}
    for (;;)
    {
      try
      {
        paramView.append(URLEncoder.encode(this.a.a().attachInfo.get(), "UTF-8"));
        zaj.b("auth_follow", "clk_more", 0, 0, new String[0]);
        ybt.a(paramView.toString());
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d(ydp.a, 0, "jump more recommend H5 page with no attach info!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ydr
 * JD-Core Version:    0.7.0.1
 */