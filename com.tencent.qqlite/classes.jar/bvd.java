import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.GrayTipsItemBuilder;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.open.downloadnew.DownloadApi;
import com.tencent.open.downloadnew.DownloadConstants;
import com.tencent.qphone.base.util.QLog;

public class bvd
  extends ClickableSpan
{
  public bvd(GrayTipsItemBuilder paramGrayTipsItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if ((GrayTipsItemBuilder.l(this.a) instanceof Activity))
    {
      if (NetworkUtil.e(GrayTipsItemBuilder.m(this.a))) {
        break label59;
      }
      QQToast.a(GrayTipsItemBuilder.o(this.a), 2131362785, 0).b(GrayTipsItemBuilder.n(this.a).getResources().getDimensionPixelSize(2131492887));
    }
    label59:
    long l;
    do
    {
      return;
      l = System.currentTimeMillis();
      if ((GrayTipsItemBuilder.a(this.a) == 0L) || (l <= GrayTipsItemBuilder.a(this.a)) || (l - GrayTipsItemBuilder.a(this.a) > 800L)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("GrayTipsItemBuilder", 2, "click too often...ignore click envent");
    return;
    GrayTipsItemBuilder.a(this.a, l);
    if (NetworkUtil.g(GrayTipsItemBuilder.p(this.a)))
    {
      paramView = new Bundle();
      paramView.putString(DownloadConstants.a, "100868074");
      paramView.putString(DownloadConstants.i, "http://shouji.sogou.com/proxy/linkto.php?site=20141110sogouinputapk");
      paramView.putString(DownloadConstants.e, "com.sohu.inputmethod.sogou");
      paramView.putInt(DownloadConstants.j, 2);
      paramView.putString(DownloadConstants.h, "ANDROIDQQ.MSG.SOUGOU");
      paramView.putString(DownloadConstants.k, "搜狗输入法");
      paramView.putBoolean(DownloadConstants.w, false);
      DownloadApi.a((Activity)GrayTipsItemBuilder.q(this.a), paramView, 0, null, 0);
    }
    for (;;)
    {
      ReportController.b(GrayTipsItemBuilder.i(this.a), "CliOper", "", "", "0X80047CF", "0X80047CF", 0, 0, "", "", "", "");
      return;
      paramView = "qapp://detail?param=" + GrayTipsItemBuilder.a("id=100868074&channelId=2800&packageName=com.sohu.inputmethod.sogou&via=MSG.SOUGOU");
      paramView = JumpParser.a(GrayTipsItemBuilder.h(this.a), GrayTipsItemBuilder.r(this.a), paramView);
      if (paramView != null) {
        paramView.b();
      }
    }
  }
  
  public void updateDrawState(TextPaint paramTextPaint)
  {
    paramTextPaint.setColor(Color.rgb(26, 144, 240));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     bvd
 * JD-Core Version:    0.7.0.1
 */