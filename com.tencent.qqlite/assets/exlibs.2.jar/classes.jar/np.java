import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.lebasearch.SearchActivity;
import com.tencent.biz.lebasearch.SearchProtocol;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemClickListener;
import org.json.JSONObject;

public class np
  implements AdapterView.OnItemClickListener
{
  public np(SearchActivity paramSearchActivity) {}
  
  public void a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Intent localIntent;
    if (paramView.getTag() != null)
    {
      paramAdapterView = (oa)paramView.getTag();
      if (paramAdapterView.d != 2) {
        break label334;
      }
      paramView = ((JSONObject)paramAdapterView.jdField_a_of_type_JavaLangObject).optString("jump_url");
      if (!TextUtils.isEmpty(paramView))
      {
        paramView = paramView.trim();
        if ((!paramView.startsWith("http:")) && (!paramView.startsWith("https:"))) {
          break label215;
        }
        localIntent = new Intent(this.a, QQBrowserActivity.class);
        localIntent.putExtra("url", paramView);
        this.a.startActivity(localIntent);
        if (QLog.isColorLevel()) {
          QLog.d("DynamicSearch", 2, "click detail : jumpUrl = " + paramView);
        }
      }
      if (SearchActivity.b(this.a) != 2) {
        break label254;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, null, "" + SearchActivity.b(this.a), paramAdapterView.jdField_a_of_type_JavaLangString, "" + SearchProtocol.a);
    }
    label215:
    label254:
    while (paramAdapterView.d != 3)
    {
      for (;;)
      {
        return;
        localIntent = new Intent();
        localIntent.setData(Uri.parse(paramView));
        localIntent.setAction("android.intent.action.VIEW");
        this.a.startActivity(localIntent);
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, SearchActivity.a(this.a), "" + SearchActivity.b(this.a), paramAdapterView.jdField_a_of_type_JavaLangString, "" + SearchProtocol.a);
      return;
    }
    label334:
    paramView = (String)paramAdapterView.jdField_a_of_type_JavaLangObject;
    if (!TextUtils.isEmpty(paramView))
    {
      paramView = paramView.trim();
      if ((!paramView.startsWith("http:")) && (!paramView.startsWith("https:"))) {
        break label529;
      }
      localIntent = new Intent(this.a, QQBrowserActivity.class);
      localIntent.putExtra("url", paramView);
      this.a.startActivity(localIntent);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("DynamicSearch", 2, "click more: jump_url = " + paramView);
      }
      if (SearchActivity.b(this.a) != 2) {
        break;
      }
      ReportController.b(this.a.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, null, "" + SearchActivity.b(this.a), paramAdapterView.jdField_a_of_type_JavaLangString, "" + SearchProtocol.a);
      return;
      label529:
      localIntent = new Intent();
      localIntent.setData(Uri.parse(paramView));
      localIntent.setAction("android.intent.action.VIEW");
      this.a.startActivity(localIntent);
    }
    ReportController.b(this.a.app, "CliOper", "", "", "0X8004B24", "0X8004B24", 0, 0, SearchActivity.a(this.a), "" + SearchActivity.b(this.a), paramAdapterView.jdField_a_of_type_JavaLangString, "" + SearchProtocol.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     np
 * JD-Core Version:    0.7.0.1
 */