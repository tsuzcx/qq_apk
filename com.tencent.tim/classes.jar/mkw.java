import android.content.Context;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.ugc.account.RIJUGCAddAccountFragment;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemData.Builder;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class mkw
{
  private lva a;
  private Context context;
  
  public mkw(Context paramContext, ViewGroup paramViewGroup)
  {
    this.context = paramContext;
    this.a = new lva(paramContext);
    aPJ();
    q(paramViewGroup);
  }
  
  private void aPJ()
  {
    this.a.setLiteEventListener(new mkx(this));
  }
  
  private String getJsonData()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("tips", RIJUGCAddAccountFragment.getNickName() + " " + mku.kc());
      localJSONObject.put("edit_profile_text", mku.ke());
      localJSONObject.put("use_origin_account_text", mku.kd());
      localJSONObject.put("accountUin", kxm.getLongAccountUin());
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        QLog.e("RIJUGCPopupPtsLiteBuilder", 1, "[getJsonData] error, e = " + localJSONException);
      }
    }
  }
  
  private void q(ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null) {
      return;
    }
    Object localObject = lwe.a().T("default_feeds", "ugc_account_popup");
    String str = getJsonData();
    localObject = new PTSItemData.Builder().withItemID("RIJUGCPopupPtsLiteBuilder").withPageName("ugc_account_popup").withFrameTreeJson((String)localObject).withJsonData(str).build();
    paramViewGroup.addView(this.a.a(null, (PTSItemData)localObject));
  }
  
  public void destroy()
  {
    this.a.destroy();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mkw
 * JD-Core Version:    0.7.0.1
 */