import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import java.util.HashMap;

public class lvb
{
  private ndi d;
  private HashMap<String, Integer> dX;
  private HashMap<String, ArticleInfo> dY;
  
  private void a(String paramString, View paramView, ArticleInfo paramArticleInfo)
  {
    paramString = (Integer)this.dX.get(paramString);
    if (paramString != null) {}
    int j;
    for (int i = paramString.intValue();; i = -1)
    {
      localObject = (ArticleInfo)this.d.getItem(i + 1);
      j = luy.g(paramArticleInfo);
      paramString = w(i);
      if ((i != -1) && (paramArticleInfo != null) && (paramString != null)) {
        break;
      }
      QLog.e("PTSLiteTapEventDispatcher", 1, "[doDislikeClick] error, position = " + i + " ,or articleInfo is null or cellContainer is null");
      return;
    }
    paramArticleInfo = new lis(this.d.getActivity(), paramArticleInfo, j, this.d.nh(), this.d.qx(), i, this.d.akw, this.d.getCount(), (ArticleInfo)localObject, this.d);
    Object localObject = new lyy(this.d.getActivity(), this.d.a(), this.d);
    ((lyy)localObject).a(paramArticleInfo);
    ((lyy)localObject).a(paramString);
    ((lyy)localObject).cE(paramView);
  }
  
  private void d(ArticleInfo paramArticleInfo, String paramString)
  {
    kxm.a(this.d.getActivity(), paramArticleInfo, paramString);
    odv.a.l(paramArticleInfo, this.d.nh());
    paramString = odv.aB(this.d.nh());
    if (!TextUtils.isEmpty(paramString)) {
      kbp.a(null, kxm.f(paramArticleInfo), paramString, paramString, 0, 0, ndi.ay(paramArticleInfo.mFeedId), String.valueOf(paramArticleInfo.mArticleID), String.valueOf(paramArticleInfo.mStrategyId), lwd.k(paramArticleInfo), false);
    }
    lux.x(paramArticleInfo);
    this.d.notifyDataSetChanged();
  }
  
  private View w(int paramInt)
  {
    if ((this.d == null) || (this.d.b() == null)) {
      return null;
    }
    ListView localListView = this.d.b();
    return localListView.getChildAt(paramInt - localListView.getFirstVisiblePosition());
  }
  
  public void a(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramHashMap == null) || (paramView == null) || (this.d == null) || (this.dX == null) || (this.dY == null)) {
      QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, something is null.");
    }
    for (;;)
    {
      return;
      ArticleInfo localArticleInfo = (ArticleInfo)this.dY.get(paramString);
      if (localArticleInfo == null)
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, articleInfo is null.");
        return;
      }
      String str1 = (String)paramHashMap.get("eventType");
      String str2 = (String)paramHashMap.get("jumpUrl");
      paramHashMap = (String)paramHashMap.get("clickReportName");
      if (TextUtils.isEmpty(str1))
      {
        QLog.e("PTSLiteTapEventDispatcher", 1, "[handleTapEvent] error, eventType is null or empty.");
        return;
      }
      if (TextUtils.equals(str1, "allInOneJump"))
      {
        QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], allInOneJump, jumpUrl = " + str2);
        d(localArticleInfo, str2);
      }
      while (!TextUtils.isEmpty(paramHashMap))
      {
        kbp.a(null, kxm.f(localArticleInfo), paramHashMap, paramHashMap, 0, 0, ndi.ay(localArticleInfo.mFeedId), String.valueOf(localArticleInfo.mArticleID), String.valueOf(localArticleInfo.mStrategyId), lwd.k(localArticleInfo), false);
        return;
        if (TextUtils.equals(str1, "dislikeClick"))
        {
          QLog.i("PTSLiteTapEventDispatcher", 1, "[handleTapEvent], dislikeClick.");
          a(paramString, paramView, localArticleInfo);
        }
      }
    }
  }
  
  public void setAdapter(ndi paramndi)
  {
    QLog.i("PTSLiteTapEventDispatcher", 1, "[setAdapter], adapter = " + paramndi);
    this.d = paramndi;
  }
  
  public static class a
  {
    private ndi d;
    private HashMap<String, Integer> dX;
    private HashMap<String, ArticleInfo> dY;
    
    public a a(HashMap<String, Integer> paramHashMap)
    {
      this.dX = paramHashMap;
      return this;
    }
    
    public a b(HashMap<String, ArticleInfo> paramHashMap)
    {
      this.dY = paramHashMap;
      return this;
    }
    
    public lvb b()
    {
      lvb locallvb = new lvb(null);
      lvb.a(locallvb, this.d);
      lvb.a(locallvb, this.dX);
      lvb.b(locallvb, this.dY);
      return locallvb;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvb
 * JD-Core Version:    0.7.0.1
 */