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

class saq
  implements View.OnClickListener
{
  saq(sao paramsao) {}
  
  public void onClick(View paramView)
  {
    StringBuilder localStringBuilder = new StringBuilder(ryy.gv(BaseApplicationImpl.getApplication().getRuntime().getAccount()));
    if (this.b.b() != null) {}
    for (;;)
    {
      try
      {
        localStringBuilder.append(URLEncoder.encode(this.b.b().attachInfo.get(), "UTF-8"));
        sqn.d("auth_follow", "clk_more", 0, 0, new String[0]);
        rzd.sW(localStringBuilder.toString());
        EventCollector.getInstance().onViewClicked(paramView);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        localUnsupportedEncodingException.printStackTrace();
        continue;
      }
      QLog.d(sao.TAG, 0, "jump more recommend H5 page with no attach info!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     saq
 * JD-Core Version:    0.7.0.1
 */