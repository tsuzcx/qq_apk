import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class ampg
  extends amrc
{
  public long ajO;
  public boolean cDQ = true;
  public String cbj;
  public String cbk;
  public String cbr = "xiaoweiba";
  
  public ampg(String paramString1, String paramString2, long paramLong)
  {
    this.cbj = paramString1;
    this.cbk = paramString2;
    this.ajO = paramLong;
  }
  
  public void hD(View paramView)
  {
    QQAppInterface localQQAppInterface;
    Object localObject;
    if (!TextUtils.isEmpty(this.cbk))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localObject = aqik.c(localQQAppInterface, paramView.getContext(), this.cbk);
      if (localObject == null) {
        break label173;
      }
      ((aqhv)localObject).ace();
    }
    for (;;)
    {
      paramView = new JSONObject();
      try
      {
        paramView.put("project", amub.zn());
        paramView.put("event_src", "client");
        paramView.put("get_src", "web");
        amub.a(null, new ReportModelDC02528().module("all_result").action("clk_tail").obj1(this.ajO + "").ver1(UniteSearchActivity.caM).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(paramView.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
        return;
        label173:
        if ((!this.cbk.startsWith("http://")) && (!this.cbk.startsWith("https://"))) {
          continue;
        }
        paramView = paramView.getContext();
        localObject = new Intent(paramView, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.cbk);
        paramView.startActivity((Intent)localObject);
      }
      catch (JSONException localJSONException)
      {
        for (;;)
        {
          QLog.e("Q.uniteSearch.SearchResultGroupModelImpl", 2, "e = " + localJSONException);
        }
      }
    }
  }
  
  public void setVisibility(boolean paramBoolean)
  {
    this.cDQ = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ampg
 * JD-Core Version:    0.7.0.1
 */