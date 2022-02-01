import android.os.Handler;
import android.os.Message;
import com.tencent.biz.lebasearch.LebaSearchPluginManagerActivity;
import com.tencent.mobileqq.data.LebaPluginInfo;
import com.tencent.mobileqq.widget.QQToast;

public class jsi
  extends Handler
{
  public jsi(LebaSearchPluginManagerActivity paramLebaSearchPluginManagerActivity) {}
  
  public void handleMessage(Message paramMessage)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramMessage.what)
    {
    case -1: 
    default: 
      return;
    case 0: 
      this.a.a.bo = 0;
      LebaSearchPluginManagerActivity.a(this.a);
      localStringBuilder.append(this.a.getString(2131698215));
      localStringBuilder.append(this.a.getString(2131698213));
      localStringBuilder.append(this.a.a.a.strResName);
      QQToast.a(this.a, 2, localStringBuilder.toString(), 1).show(this.a.getTitleBarHeight());
      return;
    }
    this.a.a.bo = 1;
    LebaSearchPluginManagerActivity.a(this.a);
    localStringBuilder.append(this.a.getString(2131698215));
    localStringBuilder.append(this.a.getString(2131698209));
    localStringBuilder.append(this.a.a.a.strResName);
    QQToast.a(this.a, 2, localStringBuilder.toString(), 1).show(this.a.getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jsi
 * JD-Core Version:    0.7.0.1
 */