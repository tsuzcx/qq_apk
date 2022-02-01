import NS_COMM.COMM.StCommonExt;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import mqq.app.AppRuntime;

class zsh
  implements View.OnClickListener
{
  zsh(zsg paramzsg) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder(zqg.b(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (this.a.a() != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(this.a.a().attachInfo.get(), "UTF-8"));
        aanb.b("auth_follow", "clk_more", 0, 0, new String[0]);
        zqm.a(localStringBuilder.toString());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d(zsg.a, 0, "jump more recommend H5 page with no attach info!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zsh
 * JD-Core Version:    0.7.0.1
 */