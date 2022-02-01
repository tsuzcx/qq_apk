import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.3.1;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.a;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaBaseView.b;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.viola.core.ViolaEnvironment;

public class nxi
  implements ViolaBaseView.a
{
  public nxi(ViolaBaseView paramViolaBaseView, boolean paramBoolean, long paramLong) {}
  
  public void bbs()
  {
    ViolaBaseView.a(this.this$0, 5, this.avr);
  }
  
  public void oD(String paramString)
  {
    if (TextUtils.isEmpty(ViolaBaseView.a(this.this$0)))
    {
      if (!TextUtils.isEmpty(paramString))
      {
        ViolaBaseView.a(this.this$0, paramString);
        if (this.avr)
        {
          ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.KEY_MAIN, ViolaEnvironment.MAIN_END_NET);
          ViolaBaseView.a(this.this$0).addReportData(ViolaEnvironment.TIME_MAIN_JS_NET, Long.toString(System.currentTimeMillis() - this.val$start));
          ViolaBaseView.a(this.this$0).sendEmptyMessageDelayed(3, 0L);
        }
        ThreadManager.post(new ViolaBaseView.3.1(this), 8, null, true);
      }
    }
    else {
      return;
    }
    ViolaBaseView.a(this.this$0, 10, this.avr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxi
 * JD-Core Version:    0.7.0.1
 */