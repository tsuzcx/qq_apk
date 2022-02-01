import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.av.VideoController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

class ize
  implements View.OnClickListener
{
  ize(izc paramizc) {}
  
  public void onClick(View paramView)
  {
    boolean bool = false;
    Object localObject = (izc.a)paramView.getTag();
    if (((izc.a)localObject).Pk) {
      if (this.a.aqx == 1)
      {
        anot.a(null, "CliOper", "", "", "0X8005C2A", "0X8005C2A", 0, 0, "", "", "", "");
        if ((!((izc.a)localObject).Pk) || (!((izc.a)localObject).Pl)) {
          break label242;
        }
        QQToast.a((Context)this.a.mContext.get(), 2131697895, 1).show();
        if (this.a.aqx != 1) {
          break label235;
        }
        localObject = "0x8007CB5";
        label108:
        imr.iF((String)localObject);
      }
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (this.a.aqx != 2) {
        break;
      }
      anot.a(null, "CliOper", "", "", "0X8005C25", "0X8005C25", 0, 0, "", "", "", "");
      break;
      if (this.a.aqx == 1)
      {
        anot.a(null, "CliOper", "", "", "0X8005C29", "0X8005C29", 0, 0, "", "", "", "");
        break;
      }
      if (this.a.aqx != 2) {
        break;
      }
      anot.a(null, "CliOper", "", "", "0X8005C24", "0X8005C24", 0, 0, "", "", "", "");
      break;
      label235:
      localObject = "0x8007CB6";
      break label108;
      label242:
      VideoController localVideoController = this.a.a;
      long l = ((izc.a)localObject).uin;
      if (!((izc.a)localObject).Pk) {
        bool = true;
      }
      if ((localVideoController.setMicByAdmin(l, bool)) && (((izc.a)localObject).Pk)) {
        QQToast.a((Context)this.a.mContext.get(), 2131697740, 1).show();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ize
 * JD-Core Version:    0.7.0.1
 */