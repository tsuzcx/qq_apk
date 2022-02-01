import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.data.search.FileSearchActivity;
import com.tencent.mobileqq.search.activity.UniteSearchActivity;
import com.tencent.mobileqq.search.report.ReportModelDC02528;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class agnx
  implements ampw
{
  public static final String TAG = agnx.class.getSimpleName();
  public static final String bID = acfp.m(2131707072);
  List<ampx> Bu;
  String keyword;
  int mFromType = -1;
  
  public agnx(List<ampx> paramList, String paramString, int paramInt)
  {
    this.Bu = paramList;
    this.keyword = paramString;
    this.mFromType = paramInt;
  }
  
  public int Ex()
  {
    return 3;
  }
  
  public List<ampx> eX()
  {
    return this.Bu;
  }
  
  public void gJ(View paramView)
  {
    amkl.a locala;
    QQAppInterface localQQAppInterface;
    JSONObject localJSONObject;
    if (((paramView.getContext() instanceof UniteSearchActivity)) && (amkl.mT.containsKey(this)))
    {
      locala = (amkl.a)amkl.mT.get(this);
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      localJSONObject = new JSONObject();
    }
    try
    {
      localJSONObject.put("project", amub.zn());
      localJSONObject.put("event_src", "client");
      localJSONObject.put("obj_lct", locala.index);
      localJSONObject.put("get_src", "native");
      amub.a(null, new ReportModelDC02528().module("all_result").action("clk_item").obj1(locala.ajO + "").obj2(locala.caE).ver1(locala.key).ver2(amub.eZ(UniteSearchActivity.dCK)).ver7(localJSONObject.toString()).session_id(localQQAppInterface.getCurrentAccountUin() + amkl.ajN));
      amxk.a(this.keyword, 100, 0, paramView);
      ahau.JH("0X8006061");
      amub.a(null, 0, this.mFromType, "0x8009D5B", 0, 0, null, null);
      FileSearchActivity.a(paramView.getContext(), this.keyword, this.Bu, true, this.mFromType);
      return;
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e(TAG, 2, "e = " + localJSONException);
      }
    }
  }
  
  public String getGroupName()
  {
    return acfp.m(2131707054);
  }
  
  public String getKeyword()
  {
    if (this.Bu.size() > Ex()) {
      amub.a(null, 0, this.mFromType, "0x8009D5A", 0, 0, null, null);
    }
    return this.keyword;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agnx
 * JD-Core Version:    0.7.0.1
 */