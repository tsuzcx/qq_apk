import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.activity.language.SelectTransLangActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.international.LocaleUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class eho
  implements AdapterView.OnItemClickListener
{
  public eho(SelectTransLangActivity paramSelectTransLangActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    QLog.i("SelectTransLangActivity", 2, "position:" + paramInt + "current:" + SelectTransLangActivity.a(this.a) + "language:" + (String)SelectTransLangActivity.a(this.a).get(paramInt));
    SelectTransLangActivity.a(this.a, paramInt);
    paramAdapterView = (ehq)paramView.getTag();
    SelectTransLangActivity.a(this.a, paramAdapterView.a);
    LocaleUtil.a(this.a.b.a(), this.a, (String)SelectTransLangActivity.a(this.a).get(SelectTransLangActivity.a(this.a)));
    SelectTransLangActivity.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     eho
 * JD-Core Version:    0.7.0.1
 */