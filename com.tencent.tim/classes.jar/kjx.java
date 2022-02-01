import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.biz.pubaccount.readinjoy.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoy.ad.data.ProteusInnerData;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.BaseData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class kjx
{
  public static GradientDrawable a(Context paramContext, String paramString1, float paramFloat1, float paramFloat2, String paramString2)
  {
    GradientDrawable localGradientDrawable = new GradientDrawable();
    localGradientDrawable.setCornerRadius(wja.dp2px(paramFloat1, paramContext.getResources()));
    if (!TextUtils.isEmpty(paramString2)) {
      localGradientDrawable.setStroke(wja.dp2px(paramFloat2, paramContext.getResources()), Color.parseColor(paramString2));
    }
    if (!TextUtils.isEmpty(paramString1)) {
      localGradientDrawable.setColor(Color.parseColor(paramString1));
    }
    return localGradientDrawable;
  }
  
  public static void a(Activity paramActivity, ArrayList<kjt> paramArrayList, jzi paramjzi, CommonAdBar paramCommonAdBar, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramjzi == null) || (paramCommonAdBar == null) || (paramList == null)) {
      return;
    }
    for (paramjzi = paramList.iterator();; paramjzi = (ProteusInnerData)paramList) {
      for (;;)
      {
        label26:
        if (paramjzi.hasNext())
        {
          paramList = (BaseData)paramjzi.next();
          if (((paramList instanceof ProteusInnerData)) && (paramList.ato)) {
            if (!((ProteusInnerData)paramList).zH()) {
              break;
            }
          }
        }
      }
    }
    for (;;)
    {
      label79:
      a(paramCommonAdBar, paramjzi);
      paramList = kkl.a(paramActivity, paramjzi);
      if (paramList == null) {
        break;
      }
      paramCommonAdBar.a(paramList);
      mrm localmrm = mrm.a(paramjzi);
      if (localmrm == null) {
        break;
      }
      paramArrayList = paramArrayList.iterator();
      do
      {
        if (!paramArrayList.hasNext()) {
          break;
        }
        paramActivity = (kjt)paramArrayList.next();
      } while ((paramActivity.b == null) || (!paramActivity.b.mPackageName.equals(localmrm.mPackageName)));
      for (;;)
      {
        if (paramActivity == null) {
          break label216;
        }
        paramList.a(paramActivity);
        paramList.a(paramjzi);
        if (Build.VERSION.SDK_INT < 21) {
          break;
        }
        paramCommonAdBar.setElevation(9.0F);
        return;
        if (!((ProteusInnerData)paramList).zI()) {
          break label26;
        }
        paramjzi = (ProteusInnerData)paramList;
        break label79;
        paramActivity = null;
      }
      label216:
      break;
      paramjzi = null;
    }
  }
  
  public static void a(Activity paramActivity, ArrayList<kjt> paramArrayList, jzi paramjzi, List<BaseData> paramList)
  {
    if ((paramActivity == null) || (paramjzi == null) || (paramList == null)) {}
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseData localBaseData = (BaseData)paramList.next();
        if ((localBaseData instanceof AdData))
        {
          AdvertisementInfo localAdvertisementInfo = kne.a((AdData)localBaseData);
          mrm localmrm = mrm.a((AdData)localBaseData);
          kjt localkjt = new kjt();
          localkjt.a(paramActivity).a(paramjzi).a(localmrm).a(localAdvertisementInfo).a((AdData)localBaseData);
          paramArrayList.add(localkjt);
        }
      }
    }
  }
  
  public static void a(CommonAdBar paramCommonAdBar, AdData paramAdData)
  {
    if ((paramCommonAdBar == null) || (paramAdData == null)) {
      return;
    }
    paramCommonAdBar.aDM();
    ViewGroup.LayoutParams localLayoutParams = paramCommonAdBar.getLayoutParams();
    GradientDrawable localGradientDrawable;
    if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).zI()))
    {
      localLayoutParams.height = wja.dp2px(64.0F, paramCommonAdBar.getResources());
      localGradientDrawable = a(paramCommonAdBar.getContext(), "#ffffff", 2.0F, 0.0F, "");
      paramAdData = localGradientDrawable;
      if (!(localLayoutParams instanceof RelativeLayout.LayoutParams)) {
        break label208;
      }
      ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = wja.dp2px(12.0F, paramCommonAdBar.getResources());
      ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = wja.dp2px(12.0F, paramCommonAdBar.getResources());
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
      if (((paramAdData instanceof ProteusInnerData)) && (((ProteusInnerData)paramAdData).zH()))
      {
        localLayoutParams.height = wja.dp2px(46.0F, paramCommonAdBar.getResources());
        localGradientDrawable = a(paramCommonAdBar.getContext(), "#f7f7f7", 3.0F, 0.0F, "");
        paramAdData = localGradientDrawable;
        if ((localLayoutParams instanceof RelativeLayout.LayoutParams))
        {
          ((RelativeLayout.LayoutParams)localLayoutParams).leftMargin = wja.dp2px(7.0F, paramCommonAdBar.getResources());
          ((RelativeLayout.LayoutParams)localLayoutParams).rightMargin = wja.dp2px(7.0F, paramCommonAdBar.getResources());
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
  
  public static boolean a(kkk paramkkk)
  {
    if ((paramkkk instanceof kkg)) {
      return true;
    }
    return paramkkk instanceof kkc;
  }
  
  public static boolean a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    return (!paramBoolean1) && (paramBoolean2) && (!paramBoolean3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjx
 * JD-Core Version:    0.7.0.1
 */