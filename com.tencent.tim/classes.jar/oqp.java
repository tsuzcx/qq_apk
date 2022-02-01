import UserGrowth.stSimpleGetFeedListRsp;
import UserGrowth.stSimpleMetaFeed;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.weishi_new.push.WSRedDotPushMsg;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.data.WSVerticalDataManager.2;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.ttpic.baseutils.collection.CollectionUtils;
import cooperation.qzone.LocalMultiProcConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class oqp
{
  private static String aqt = "";
  private volatile String arc = "";
  private volatile String mAttachInfo = "";
  
  public static oqp a()
  {
    return oqp.a.b();
  }
  
  private void a(stSimpleGetFeedListRsp paramstSimpleGetFeedListRsp, oqm paramoqm)
  {
    if ((paramoqm instanceof oso))
    {
      paramoqm = (WSVerticalPageFragment)((oso)paramoqm).a;
      if ((paramoqm != null) && (paramoqm.getActivity() != null) && (!paramoqm.getActivity().isFinishing())) {
        ohy.a().a(paramstSimpleGetFeedListRsp.config, "global_key_video_layer");
      }
    }
  }
  
  private static void d(JSONObject paramJSONObject1, JSONObject paramJSONObject2)
  {
    if ((paramJSONObject1 == null) || (paramJSONObject2 == null)) {
      return;
    }
    try
    {
      paramJSONObject1.put("deep_link_version", 1);
      paramJSONObject2.put("device_info", paramJSONObject1);
      aqt = paramJSONObject2.toString();
      return;
    }
    catch (JSONException paramJSONObject1)
    {
      tkw.e("WSVerticalDataManagerLog", "onResult", paramJSONObject1);
    }
  }
  
  public static void setGdtArgs(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      try
      {
        paramString = new JSONObject();
        paramString.put("gdt_pageindex", 0);
        aqt = paramString.toString();
        String str = LocalMultiProcConfig.getString("cache_key_gdt_args", "");
        if (!TextUtils.isEmpty(str))
        {
          d(new JSONObject(str), paramString);
          return;
        }
      }
      catch (JSONException paramString)
      {
        tkw.e("WSVerticalDataManagerLog", "setGdtArgs", paramString);
      }
    }
    for (;;)
    {
      ThreadManager.executeOnSubThread(new WSVerticalDataManager.2());
      return;
      aqt = paramString;
    }
  }
  
  public void a(int paramInt, boolean paramBoolean1, boolean paramBoolean2, String paramString, List<oqr> paramList, oqm paramoqm, long paramLong)
  {
    ArrayList localArrayList = new ArrayList();
    String str = "";
    if ((paramList != null) && (paramBoolean2))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        oqr localoqr = (oqr)paramList.next();
        if ((localoqr != null) && ((localoqr.B() instanceof stSimpleMetaFeed))) {
          localArrayList.add(((stSimpleMetaFeed)localoqr.B()).id);
        }
      }
    }
    paramList = null;
    if (TextUtils.equals(paramString, "aio_new_msg"))
    {
      paramList = opn.b();
      paramString = opn.a();
      if (paramString != null) {
        paramString.aI(null);
      }
      opn.bfZ();
    }
    paramString = str;
    if (paramList != null)
    {
      paramString = str;
      if (paramBoolean2) {
        paramString = paramList.mMsgData;
      }
    }
    paramoqm = new oqq(this, paramLong, paramBoolean2, paramoqm);
    byte b1;
    if (paramBoolean1)
    {
      paramList = "";
      if (!paramBoolean1) {
        break label247;
      }
      b1 = 1;
      label180:
      if (!paramBoolean2) {
        break label253;
      }
    }
    label247:
    label253:
    for (byte b2 = 1;; b2 = 0)
    {
      paramString = new okz(new onz(paramList, b1, b2, localArrayList, paramInt, aqt, "", this.arc, paramString), null, paramoqm, 1001);
      oks.a().b(paramString);
      return;
      paramList = this.mAttachInfo;
      break;
      b1 = 0;
      break label180;
    }
  }
  
  public List<oqr> e(ArrayList paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (!CollectionUtils.isEmpty(paramArrayList))
    {
      int i = 0;
      while (i < paramArrayList.size())
      {
        if ((paramArrayList.get(i) instanceof stSimpleMetaFeed))
        {
          stSimpleMetaFeed localstSimpleMetaFeed = (stSimpleMetaFeed)paramArrayList.get(i);
          oqr localoqr = new oqr();
          if ((localstSimpleMetaFeed != null) && (localstSimpleMetaFeed.gdt_ad_type == 1) && (localstSimpleMetaFeed.gdt_ad_info != null))
          {
            oqs.f(localstSimpleMetaFeed);
            oqs.e(localstSimpleMetaFeed);
            localoqr.a(oqs.a(localstSimpleMetaFeed));
          }
          localoqr.ad(localstSimpleMetaFeed);
          localArrayList.add(localoqr);
        }
        i += 1;
      }
    }
    return localArrayList;
  }
  
  public void reset()
  {
    this.mAttachInfo = "";
    this.arc = "";
    aqt = "";
  }
  
  static class a
  {
    private static final oqp b = new oqp(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oqp
 * JD-Core Version:    0.7.0.1
 */