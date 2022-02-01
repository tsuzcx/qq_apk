import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusInnerData;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class tqp
{
  public static GradientDrawable a(Context paramContext, String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(AIOUtils.dp2px(paramFloat1, paramContext.getResources()));
    if (!TextUtils.isEmpty(paramString2)) {
      localGradientDrawable.setStroke(AIOUtils.dp2px(paramFloat2, paramContext.getResources()), Color.parseColor(paramString2));
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localGradientDrawable.setColor(Color.parseColor(paramString1));
    }
    return localGradientDrawable;
  }
  
  public static void a(Activity paramActivity, ArrayList<tql> paramArrayList, oau paramoau, CommonAdBar paramCommonAdBar, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramoau == null) || (paramCommonAdBar == null) || (paramList == null)) {
      return;
    }
    for (paramoau = paramList.iterator();; paramoau = (ProteusInnerData)paramList) {
      for (;;)
      {
        label26:
        if (paramoau.hasNext())
        {
          paramList = (BaseData)paramoau.next();
          if (((paramList instanceof ProteusInnerData)) && (paramList.d)) {
            if (!((ProteusInnerData)paramList).f()) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      label79:
      a(paramCommonAdBar, paramoau);
      paramList = tre.a(paramActivity, paramoau);
      if (paramList == null) {
        break;
      }
      paramCommonAdBar.a(paramList);
      txh localtxh = txh.a(paramoau);
      if (localtxh == null) {
        break;
      }
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        paramActivity = (tql)paramArrayList.next();
      } while ((paramActivity.a == null) || (!paramActivity.a.d.equals(localtxh.d)));
      for (;;)
      {
        if (paramActivity == null) {
          break label216;
        }
        paramList.a(paramActivity);
        paramList.a(paramoau);
        if (Build.VERSION.SDK_INT < 21) {
          break;
        }
        paramCommonAdBar.setElevation(9.0F);
        return;
        if (!((ProteusInnerData)paramList).g()) {
          break label26;
        }
        paramoau = (ProteusInnerData)paramList;
        break label79;
        paramActivity = null;
      }
      label216:
      break;
      paramoau = null;
    }
  }
  
  public static void a(Activity paramActivity, ArrayList<tql> paramArrayList, oau paramoau, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramoau == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseData localBaseData = (BaseData)paramList.next();
        if ((localBaseData instanceof AdData))
        {
          AdvertisementInfo localAdvertisementInfo = tws.a((AdData)localBaseData);
          txh localtxh = txh.a((AdData)localBaseData);
          tql localtql = new tql();
          localtql.a(paramActivity).a(paramoau).a(localtxh).a(localAdvertisementInfo).a((AdData)localBaseData);
          paramArrayList.add(localtql);
        }
      }
    }
  }
  
  public static void a(CommonAdBar paramCommonAdBar, AdData paramAdData)
  {
    if ((paramCommonAdBar == null) || (paramAdData == null)) {
      return;
    }
    paramCommonAdBar.a();
    ViewGroup.LayoutParams localLayoutParams = paramCommonAdBar.getLayoutParams();
    GradientDrawable localGradientDrawable;
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).g()))
    {
      localLayoutParams.height = AIOUtils.dp2px(64.0F, paramCommonAdBar.getResources());
      localGradientDrawable = a(paramCommonAdBar.getContext(), "#ffffff", 2.0F, 0.0F, "");
      paramAdData = localGradientDrawable;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label208;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = AIOUtils.dp2px(12.0F, paramCommonAdBar.getResources());
      ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = AIOUtils.dp2px(12.0F, paramCommonAdBar.getResources());
      paramAdData = localGradientDrawable;
    }
    for (;;)
    {
      paramCommonAdBar.setLayoutParams(localLayoutParams);
      if (paramAdData == null) {
        break;
      }
      paramCommonAdBar.setBackgroundDrawable(paramAdData);
      return;
      if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).f()))
      {
        localLayoutParams.height = AIOUtils.dp2px(46.0F, paramCommonAdBar.getResources());
        localGradientDrawable = a(paramCommonAdBar.getContext(), "#f7f7f7", 3.0F, 0.0F, "");
        paramAdData = localGradientDrawable;
        if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
        {
          ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = AIOUtils.dp2px(7.0F, paramCommonAdBar.getResources());
          ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = AIOUtils.dp2px(7.0F, paramCommonAdBar.getResources());
          paramAdData = localGradientDrawable;
        }
      }
      else
      {
        label208:
        paramAdData = null;
      }
    }
  }
  
  public static boolean a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean2) && (!paramBoolean3) && (paramBoolean1) && ((paramInt3 == 0) || (paramInt1 <= paramInt3)) && (paramInt1 * 2 >= paramInt2 * 3);
  }
  
  public static boolean a(trd paramtrd)
  {
    if ((paramtrd instanceof tqz)) {
      return true;
    }
    return paramtrd instanceof tqv;
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean1) && (paramBoolean2) && (!paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tqp
 * JD-Core Version:    0.7.0.1
 */