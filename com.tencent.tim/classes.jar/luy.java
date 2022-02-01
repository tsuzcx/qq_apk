import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.pts.lite.PTSLiteItemViewBuilder.2;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.pts.core.itemview.PTSItemView;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class luy
{
  private static IPTSLiteEventListener jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  private static lvb jdField_a_of_type_Lvb;
  private static int aQh;
  private static int aQi;
  private static int aQj;
  private static HashMap<String, Integer> dX = new HashMap();
  private static HashMap<String, ArticleInfo> dY = new HashMap();
  private static HashMap<String, Integer> dZ = new HashMap();
  private Context context;
  private ndi d;
  private List<String> ix;
  
  static
  {
    aQi = 142;
    aQj = aQi;
    aNA();
  }
  
  public luy(Context paramContext, ndi paramndi)
  {
    this.context = paramContext;
    this.d = paramndi;
    this.ix = new ArrayList();
    aNB();
    aQh += 1;
  }
  
  public static boolean E(ArticleInfo paramArticleInfo)
  {
    if (paramArticleInfo == null) {}
    do
    {
      return true;
      if (!Y(paramArticleInfo)) {
        break;
      }
    } while (g(paramArticleInfo) == aQi);
    return false;
    return false;
  }
  
  public static <T extends BaseArticleInfo> boolean Y(T paramT)
  {
    return (paramT != null) && (paramT.mFeedType == 29) && (!TextUtils.isEmpty(paramT.ptsLitePageName));
  }
  
  public static IPTSLiteEventListener a()
  {
    return jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener;
  }
  
  private void a(PTSItemData paramPTSItemData)
  {
    ThreadManager.executeOnSubThread(new PTSLiteItemViewBuilder.2(this, paramPTSItemData));
  }
  
  private static void aNA()
  {
    jdField_a_of_type_Lvb = new lvb.a().a(dX).b(dY).b();
    jdField_a_of_type_ComTencentPtsCoreLiteIPTSLiteEventListener = new luz();
  }
  
  private void aNB()
  {
    dZ.clear();
    Object localObject = lwe.a().E("default_feeds");
    if (localObject == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], pageNameList is null.");
      return;
    }
    aQi = this.d.a().oL() + 142;
    int i = aQi;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      String str = (String)((Iterator)localObject).next();
      int j = i + 1;
      i = j;
      if (!dZ.containsKey(str))
      {
        dZ.put(str, Integer.valueOf(j));
        QLog.i("PTSLiteItemViewBuilder", 1, "[initViewTypeCount], pageName = " + str + ", viewType = " + j);
        i = j;
      }
    }
    aQj = i;
    QLog.i("PTSLiteItemViewBuilder", 1, "[initViewType], type_pts_lite_gone = " + aQi + ", type_pts_lite_end = " + aQj);
  }
  
  public static boolean dx(int paramInt)
  {
    return (paramInt >= aQi) && (paramInt <= aQj);
  }
  
  public static int g(ArticleInfo paramArticleInfo)
  {
    if ((paramArticleInfo == null) || (paramArticleInfo.ptsItemData == null) || (TextUtils.isEmpty(paramArticleInfo.ptsLitePageName))) {
      return aQi;
    }
    paramArticleInfo = (Integer)dZ.get(paramArticleInfo.ptsLitePageName);
    if (paramArticleInfo != null) {
      return paramArticleInfo.intValue();
    }
    return aQi;
  }
  
  public static int getViewTypeCount()
  {
    if (aQj > aQi) {
      return aQj - aQi + 1;
    }
    return 0;
  }
  
  public View a(View paramView, ArticleInfo paramArticleInfo, int paramInt, ndi paramndi)
  {
    if (paramArticleInfo == null)
    {
      QLog.e("PTSLiteItemViewBuilder", 1, "[getView], articleInfo is null.");
      return paramView;
    }
    jdField_a_of_type_Lvb.setAdapter(paramndi);
    paramndi = null;
    PTSItemData localPTSItemData = paramArticleInfo.ptsItemData;
    PTSComposer localPTSComposer = paramArticleInfo.ptsComposer;
    if ((localPTSItemData != null) && (localPTSComposer != null)) {
      if ((paramView instanceof PTSItemView))
      {
        localPTSComposer.layoutToView((PTSItemView)paramView);
        dX.put(paramArticleInfo.innerUniqueID, Integer.valueOf(paramInt));
        dY.put(paramArticleInfo.innerUniqueID, paramArticleInfo);
        a(localPTSItemData);
      }
    }
    for (;;)
    {
      paramndi = paramView;
      if (paramView == null)
      {
        paramndi = new PTSItemView(this.context);
        paramndi.setVisibility(8);
        QLog.i("PTSLiteItemViewBuilder", 1, "[getView] hide the itemView, " + lvd.m(paramArticleInfo));
      }
      paramView = paramndi.getLayoutParams();
      if (paramView != null) {
        paramndi.setLayoutParams(new AbsListView.LayoutParams(paramView));
      }
      paramndi.setTag(2131370016, this.d.f());
      return paramndi;
      paramView = new PTSItemView(this.context);
      break;
      QLog.e("PTSLiteItemViewBuilder", 1, "[getView] error, ptsItemData is null or ptsComposer is null, " + lvd.m(paramArticleInfo));
      paramView = paramndi;
    }
  }
  
  public void destroy()
  {
    this.ix.clear();
    int i = this.d.nh();
    QLog.i("PTSLiteItemViewBuilder", 1, "[destroy] channelId = " + i);
    if ((i == 41505) || (i == 41697))
    {
      lvd.cH(lbz.a().b(Integer.valueOf(41505)));
      lvd.cH(lbz.a().b(Integer.valueOf(41697)));
    }
    for (;;)
    {
      aQh -= 1;
      if (aQh == 0) {
        jdField_a_of_type_Lvb.setAdapter(null);
      }
      return;
      lvd.cH(lbz.a().b(Integer.valueOf(i)));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     luy
 * JD-Core Version:    0.7.0.1
 */