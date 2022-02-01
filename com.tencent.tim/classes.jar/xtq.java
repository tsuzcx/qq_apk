import android.app.Activity;
import android.content.res.Resources;
import android.os.IBinder;
import android.text.TextUtils;
import android.view.View;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.widget.QQToast;
import cooperation.qzone.LocalMultiProcConfig;
import cooperation.qzone.QZoneClickReport;
import java.util.ArrayList;

class xtq
  implements ausj.a
{
  xtq(xtp paramxtp, ausj paramausj) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    if (paramView != null)
    {
      paramView = this.val$actionSheet.getContent(paramInt);
      if (paramView == null) {
        return;
      }
      if (!TextUtils.isEmpty(paramView))
      {
        if (!paramView.equals(xtp.a(this.this$0).getResources().getString(2131690171))) {
          break label195;
        }
        paramInt = this.this$0.ww();
        if (paramInt != 1) {
          break label94;
        }
        this.this$0.bKm();
        this.this$0.reportData("Multi_Forward_Contacts", this.this$0.dQ.size());
      }
    }
    label195:
    for (;;)
    {
      this.val$actionSheet.dismiss();
      return;
      label94:
      if ((paramInt == 2) && (!this.this$0.dQ.isEmpty()) && (this.this$0.b.asBinder().pingBinder()))
      {
        paramView = (AIOShortVideoData)((xuf)this.this$0.dQ.get(0)).e;
        paramView = this.this$0.b.getForwardData(paramView.id, paramView.subId, this.this$0.mCurType);
        ahgq.P(xtp.b(this.this$0), paramView);
        continue;
        if (paramView.equals(xtp.c(this.this$0).getResources().getString(2131694753)))
        {
          if (LocalMultiProcConfig.getInt4Uin(this.this$0.aWf + "__qzone_pic_permission__" + this.this$0.QE, -1, Long.valueOf(this.this$0.aWf).longValue()) == 0)
          {
            paramView = new aqju(xtp.d(this.this$0), 2131756467);
            paramView.setContentView(2131559151);
            paramView.setTitle(xtp.e(this.this$0).getString(2131699885));
            paramView.setMessage(xtp.f(this.this$0).getString(2131699883));
            paramView.setNegativeButton(xtp.g(this.this$0).getString(2131699884), new xtr(this));
            paramView.setCanceledOnTouchOutside(false);
            paramView.setCancelable(false);
            paramView.show();
            QZoneClickReport.startReportImediately(this.this$0.aWf, "40", "1");
          }
          else if (this.this$0.dQ.size() > 20)
          {
            QQToast.a(xtp.i(this.this$0), 2131694002, 0).show();
          }
          else
          {
            this.this$0.ceO();
          }
        }
        else if (paramView.equals(xtp.j(this.this$0).getResources().getString(2131694765))) {
          if (this.this$0.dQ.size() > 20) {
            QQToast.a(xtp.k(this.this$0), 2131694002, 0).show();
          } else {
            this.this$0.ceP();
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xtq
 * JD-Core Version:    0.7.0.1
 */