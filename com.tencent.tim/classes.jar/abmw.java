import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import com.tencent.gdtad.api.banner.GdtBannerAd;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.1;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.2;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.3;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.4;
import com.tencent.mobileqq.apollo.process.ads.CmGameBannerAds.5;
import com.tencent.mobileqq.apollo.process.data.CmGameInitParams;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tencent.gdt.qq_ad_get.QQAdGet;
import tencent.gdt.qq_ad_get.QQAdGet.ContextInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt;
import tencent.gdt.qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo;
import tencent.gdt.qq_ad_get.QQAdGet.UserInfo;

public class abmw
{
  private HashMap<Integer, abmw.a> iq;
  private int mGameId;
  
  public abmw(int paramInt)
  {
    this.mGameId = paramInt;
    this.iq = new HashMap();
  }
  
  private static qq_ad_get.QQAdGet a(long paramLong1, String paramString, long paramLong2, long paramLong3, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "posId:", paramString, ",src:", Integer.valueOf(paramInt1), ",shareRate:", Integer.valueOf(paramInt2) });
    }
    Object localObject1 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_rate.set(paramInt2);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt.ShareInfo)localObject1).share_check.set(tgd.a(paramLong2, paramLong3, paramInt2));
    Object localObject2 = new qq_ad_get.QQAdGet.PositionInfo.PositionExt();
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).share_info.set((MessageMicro)localObject1);
    ((qq_ad_get.QQAdGet.PositionInfo.PositionExt)localObject2).deep_link_version.set(1);
    localObject1 = new qq_ad_get.QQAdGet.PositionInfo();
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_id.set(paramString);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).ad_count.set(1);
    ((qq_ad_get.QQAdGet.PositionInfo)localObject1).pos_ext.set((MessageMicro)localObject2);
    paramString = new qq_ad_get.QQAdGet.ContextInfo();
    paramString.public_id.set(paramLong2);
    paramString.article_id.set(paramLong3);
    paramString.source_from.set(paramInt1);
    localObject2 = new qq_ad_get.QQAdGet.UserInfo();
    ((qq_ad_get.QQAdGet.UserInfo)localObject2).qq.set(paramLong1);
    qq_ad_get.QQAdGet localQQAdGet = new qq_ad_get.QQAdGet();
    localQQAdGet.position_info.add((MessageMicro)localObject1);
    localQQAdGet.context_info.set(paramString);
    localQQAdGet.user_info.set((MessageMicro)localObject2);
    return localQQAdGet;
  }
  
  private CmGameInitParams b()
  {
    abos localabos = abmt.a(this.mGameId);
    if (localabos == null) {
      return null;
    }
    return localabos.c();
  }
  
  private void d(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("bannerId", paramInt1);
      localJSONObject.put("errCode", paramInt3);
      abmt.a().callbackFromRequest(paramLong, paramInt2, "sc.game_ad_banner_load.local", localJSONObject.toString());
      return;
    }
    catch (Throwable localThrowable)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
    }
  }
  
  private String dc(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "[getPosId], viewId:", Integer.valueOf(paramInt) });
    }
    Object localObject = b();
    if (localObject == null) {}
    do
    {
      return null;
      localObject = ((CmGameInitParams)localObject).adForbidPosId;
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).contains("8080135688610643")))
      {
        QLog.i("cmgame_process.CmGameBannerAds", 1, "viewId is in forbidden list.");
        return null;
      }
    } while (paramInt != 1003);
    return "8080135688610643";
  }
  
  private void e(long paramLong, int paramInt1, int paramInt2, int paramInt3)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "[showBannerAd], bannerId:", Integer.valueOf(paramInt1), ",left:", Integer.valueOf(paramInt2), ",top:", Integer.valueOf(paramInt3) });
    }
    ThreadManager.getUIHandler().post(new CmGameBannerAds.5(this, paramInt1, paramInt3, paramInt2, paramLong));
  }
  
  private Activity getActivity()
  {
    abos localabos = abmt.a(this.mGameId);
    if (localabos == null) {
      return null;
    }
    return localabos.q();
  }
  
  private int getParentHeight()
  {
    for (;;)
    {
      try
      {
        Object localObject = abmt.a(this.mGameId);
        if ((localObject == null) || (((abos)localObject).b() == null)) {
          break label107;
        }
        i = ((abos)localObject).b().getMeasuredHeight();
        if (i == 0)
        {
          localObject = getActivity();
          if (localObject != null)
          {
            localObject = (FrameLayout)((Activity)localObject).findViewById(2131367885);
            if (localObject != null)
            {
              i = ((FrameLayout)localObject).getMeasuredHeight();
              if (QLog.isColorLevel()) {
                QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "getParent height from gameview, h:", Integer.valueOf(i) });
              }
              return i;
            }
          }
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("cmgame_process.CmGameBannerAds", 1, localThrowable, new Object[0]);
        return 0;
      }
      return i;
      label107:
      int i = 0;
    }
  }
  
  public void B(long paramLong, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "[loadBannerAd], bannerId:", Integer.valueOf(paramInt2), ",viewId:", Integer.valueOf(paramInt1) });
    }
    ThreadManager.getUIHandler().post(new CmGameBannerAds.4(this, paramInt1, paramLong, paramInt2));
  }
  
  public void HA(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "[hideBanner], bannerId:", Integer.valueOf(paramInt) });
    }
    ThreadManager.getUIHandler().post(new CmGameBannerAds.3(this, paramInt));
  }
  
  public void Hz(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmgame_process.CmGameBannerAds", 2, new Object[] { "[closeBanner], bannerId:", Integer.valueOf(paramInt) });
    }
    ThreadManager.getUIHandler().post(new CmGameBannerAds.2(this, paramInt));
  }
  
  public void e(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    ThreadManager.getUIHandler().post(new CmGameBannerAds.1(this, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5));
  }
  
  public void m(long paramLong, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    int k;
    try
    {
      paramString2 = new JSONObject(paramString2);
      k = paramString2.optInt("bannerId");
      if ("cs.game_ad_banner_close.local".equals(paramString1))
      {
        Hz(k);
        return;
      }
    }
    catch (Throwable paramString1)
    {
      QLog.e("cmgame_process.CmGameBannerAds", 1, paramString1, new Object[0]);
      return;
    }
    if ("cs.game_ad_banner_load.local".equals(paramString1))
    {
      B(paramLong, paramString2.optInt("viewId"), k);
      return;
    }
    int i;
    int j;
    if ("cs.game_ad_banner_show.local".equals(paramString1))
    {
      paramString1 = paramString2.optJSONObject("style");
      if (paramString1 == null) {
        break label208;
      }
      i = paramString1.optInt("x");
      j = paramString1.optInt("y");
    }
    for (;;)
    {
      e(paramLong, k, i, j);
      return;
      if ("cs.game_ad_banner_hide.local".equals(paramString1))
      {
        HA(k);
        return;
      }
      if (!"cs.game_ad_banner_resize.local".equals(paramString1)) {
        break;
      }
      paramString1 = paramString2.optJSONObject("style");
      e(k, paramString1.optInt("x"), paramString1.optInt("y"), paramString1.optInt("w"), paramString1.optInt("h"));
      return;
      label208:
      j = 0;
      i = 0;
    }
  }
  
  public void onDestroy()
  {
    this.iq.clear();
  }
  
  public static class a
  {
    public View AK;
    int cqd;
    public GdtBannerAd d;
    int viewId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abmw
 * JD-Core Version:    0.7.0.1
 */