import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.language.SelectLanguageActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

public class emh
  implements View.OnClickListener
{
  public emh(SelectLanguageActivity paramSelectLanguageActivity) {}
  
  public void onClick(View paramView)
  {
    LocaleUtil.b(this.a.getApplicationContext(), LocaleUtil.a[SelectLanguageActivity.a(this.a)]);
    LocaleUtil.a(this.a.getApplicationContext(), SelectLanguageActivity.a(this.a));
    paramView = new HashMap();
    paramView.put("external_" + LocaleUtil.a[SelectLanguageActivity.a(this.a)].toString(), Integer.valueOf(1));
    StatisticCollector.a(BaseApplication.getContext()).b(this.a.b, this.a.b.a(), paramView);
    this.a.b.p();
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     emh
 * JD-Core Version:    0.7.0.1
 */