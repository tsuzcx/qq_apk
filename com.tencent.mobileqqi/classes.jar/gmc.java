import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.StatusHistoryActivity;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.richstatus.StatusServlet;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.SlideDetectListView;
import java.util.ArrayList;
import mqq.app.NewIntent;

public class gmc
  implements View.OnClickListener
{
  public gmc(StatusHistoryActivity paramStatusHistoryActivity) {}
  
  public void onClick(View paramView)
  {
    int i = 1;
    boolean bool;
    if ((paramView != null) && (paramView.getTag() != null) && ((paramView.getTag() instanceof Integer)))
    {
      if (!NetworkUtil.e(this.a)) {
        QQToast.a(this.a, this.a.getString(2131562452), 0).b(this.a.d());
      }
      int j;
      do
      {
        return;
        j = ((Integer)paramView.getTag()).intValue();
      } while ((StatusHistoryActivity.a(this.a) == null) || (j < 0) || (j >= StatusHistoryActivity.a(this.a).size()));
      StatusHistoryActivity.a(this.a, (RichStatus)StatusHistoryActivity.a(this.a).get(j));
      paramView = this.a;
      if (j != 0) {
        break label271;
      }
      bool = true;
      StatusHistoryActivity.b(paramView, bool);
      StatusHistoryActivity.a(this.a, new QQProgressDialog(this.a, this.a.d()));
      StatusHistoryActivity.a(this.a).a(this.a.getString(2131559283));
      StatusHistoryActivity.a(this.a).show();
      if ((!StatusHistoryActivity.b(this.a)) || (StatusHistoryActivity.a(this.a).size() != 1)) {
        break label277;
      }
      paramView = (StatusManager)this.a.b.getManager(13);
      if (paramView != null) {
        paramView.a(RichStatus.a(), -1);
      }
    }
    label271:
    label277:
    for (;;)
    {
      label250:
      if (StatusHistoryActivity.a(this.a) != null)
      {
        StatusHistoryActivity.a(this.a).d();
        return;
        bool = false;
        break;
        if ((StatusHistoryActivity.a(this.a) != null) && (this.a.b != null) && (StatusHistoryActivity.a(this.a).a != null))
        {
          paramView = new NewIntent(this.a.b.a(), StatusServlet.class);
          paramView.putExtra("k_cmd", 5);
          paramView.putExtra("k_status_key", StatusHistoryActivity.a(this.a).a);
          if (!StatusHistoryActivity.c(this.a)) {
            break label387;
          }
        }
      }
    }
    for (;;)
    {
      paramView.putExtra("k_status_flag", i);
      this.a.b.startServlet(paramView);
      break label250;
      break;
      label387:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gmc
 * JD-Core Version:    0.7.0.1
 */