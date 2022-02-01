import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONArray;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.GetRankListReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReportScoreReqBody;
import tencent.im.oidb.cmd0xb85.Oidb_0xb85.ReqBody;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ExtraParam;
import tencent.im.oidb.ranklist_comm.ranklist_comm.ReportItem;

public class uaa
  extends tzh
{
  public static final String TAG = "DoraemonOpenAPI." + uaa.class.getSimpleName();
  private final String aKn = "OidbSvc.0xb85";
  
  private void a(JSONObject paramJSONObject, tzd paramtzd)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG + ".getRankingList", 2, "params = " + paramJSONObject);
    }
    int i = paramJSONObject.optInt("rankingID", 0);
    int j = paramJSONObject.optInt("topCount", 10);
    String str = paramJSONObject.optString("rankKey", "");
    int k = paramJSONObject.optInt("rankValueType", 0);
    int m = paramJSONObject.optInt("rankOrderType", 0);
    if (i <= 0)
    {
      ubu.a(paramtzd, -100, "rankingID must be bigger than 0");
      return;
    }
    Object localObject = (uag)this.b.a(uag.class, false);
    if (localObject == null)
    {
      ubu.a(paramtzd, -10, "internal error, try again.");
      return;
    }
    Oidb_0xb85.ReqBody localReqBody = new Oidb_0xb85.ReqBody();
    localObject = ((uag)localObject).a();
    localReqBody.appid.set(Integer.valueOf(this.b.mAppid).intValue());
    localReqBody.service_id.set(this.b.bDo);
    localReqBody.openid.set(((uag.a)localObject).openid);
    localReqBody.openkey.set(((uag.a)localObject).openKey);
    Oidb_0xb85.GetRankListReqBody localGetRankListReqBody = new Oidb_0xb85.GetRankListReqBody();
    localGetRankListReqBody.ranklist_id.set(i);
    localGetRankListReqBody.top_count.set(j);
    if (!TextUtils.isEmpty(str)) {
      localGetRankListReqBody.rank_key.set(str);
    }
    localGetRankListReqBody.rank_value_type.set(k);
    localGetRankListReqBody.rank_order_type.set(m);
    localReqBody.get_ranklist_req.set(localGetRankListReqBody);
    jnm.a(BaseApplicationImpl.getApplication().getRuntime(), new uab(this, (uag.a)localObject, paramJSONObject, paramtzd), localReqBody.toByteArray(), "OidbSvc.0xb85", 2949, 2, null, 0L);
  }
  
  private void b(JSONObject paramJSONObject, tzd paramtzd)
  {
    if (QLog.isColorLevel()) {
      QLog.i(TAG + ".reportScore", 2, "params = " + paramJSONObject);
    }
    int i = paramJSONObject.optInt("rankingID", 0);
    JSONArray localJSONArray = paramJSONObject.optJSONArray("scoreList");
    if (i <= 0)
    {
      ubu.a(paramtzd, -100, "rankingID 没有传或者值小于等于0");
      return;
    }
    Object localObject1 = (uag)this.b.a(uag.class, false);
    Oidb_0xb85.ReqBody localReqBody = new Oidb_0xb85.ReqBody();
    localObject1 = ((uag)localObject1).a();
    localReqBody.appid.set(Integer.valueOf(this.b.mAppid).intValue());
    localReqBody.service_id.set(this.b.bDo);
    localReqBody.openid.set(((uag.a)localObject1).openid);
    localReqBody.openkey.set(((uag.a)localObject1).openKey);
    Oidb_0xb85.ReportScoreReqBody localReportScoreReqBody = new Oidb_0xb85.ReportScoreReqBody();
    localReportScoreReqBody.ranklist_id.set(i);
    try
    {
      int k = localJSONArray.length();
      i = 0;
      while (i < k)
      {
        Object localObject2 = localJSONArray.getJSONObject(i);
        ranklist_comm.ReportItem localReportItem = new ranklist_comm.ReportItem();
        localReportItem.openid.set(((JSONObject)localObject2).getString("openid"));
        localReportItem.score.set(((JSONObject)localObject2).getInt("score"));
        localObject2 = ((JSONObject)localObject2).optJSONArray("extraList");
        if (localObject2 != null)
        {
          int j = 0;
          int m = ((JSONArray)localObject2).length();
          while (j < m)
          {
            JSONObject localJSONObject = ((JSONArray)localObject2).getJSONObject(j);
            ranklist_comm.ExtraParam localExtraParam = new ranklist_comm.ExtraParam();
            localExtraParam.param_key.set(localJSONObject.getString("key"));
            localExtraParam.param_value.set(localJSONObject.getInt("value"));
            localExtraParam.param_type.set(localJSONObject.getInt("type"));
            localReportItem.rpt_extra_param.add(localExtraParam);
            j += 1;
          }
        }
        localReportScoreReqBody.rpt_report_item.add(localReportItem);
        i += 1;
      }
      localReqBody.report_score_req.set(localReportScoreReqBody);
    }
    catch (Exception paramJSONObject)
    {
      ubu.a(paramtzd, -101, "参数处理错误, 是否是类型不对? 查看一下文档吧. \nerrorMsg: " + paramJSONObject.getMessage());
      return;
    }
    jnm.a(BaseApplicationImpl.getApplication().getRuntime(), new uac(this, (uag.a)localObject1, paramJSONObject, paramtzd), localReqBody.toByteArray(), "OidbSvc.0xb85", 2949, 1, null, 0L);
  }
  
  public boolean a(int paramInt, String paramString, JSONObject paramJSONObject, @NonNull tzd paramtzd)
  {
    switch (paramInt)
    {
    default: 
      return false;
    case 8: 
      a(paramJSONObject, paramtzd);
    }
    for (;;)
    {
      return true;
      b(paramJSONObject, paramtzd);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uaa
 * JD-Core Version:    0.7.0.1
 */