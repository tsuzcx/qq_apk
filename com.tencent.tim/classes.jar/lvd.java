import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.pts.core.PTSComposer;
import com.tencent.pts.core.itemview.PTSItemData;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lvd
{
  public static void cG(List<? extends BaseArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] articleInfoList is empty.");
    }
    for (;;)
    {
      return;
      if (!lvl.a().CM())
      {
        QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] pts lite so is not ready.");
        return;
      }
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (!luy.Y(localBaseArticleInfo))
        {
          QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo], articleInfo is not valid.");
        }
        else
        {
          f(localBaseArticleInfo);
          String str1 = localBaseArticleInfo.ptsLitePageName;
          String str2 = lwe.a().T("default_feeds", str1);
          if (TextUtils.isEmpty(str2))
          {
            QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo], frameTreeJson is empty.");
          }
          else
          {
            localBaseArticleInfo.ptsComposer = PTSComposer.buildComposer(str1, str2, localBaseArticleInfo.ptsItemData.getJSONData(), luy.a());
            QLog.i("PTSPreLayoutHandler", 1, "[preHandleArticleInfo] succeed, " + m(localBaseArticleInfo));
          }
        }
      }
    }
  }
  
  public static void cH(List<? extends BaseArticleInfo> paramList)
  {
    if ((paramList == null) || (paramList.size() <= 0)) {
      QLog.i("PTSPreLayoutHandler", 1, "[destroy] articleInfoList is null.");
    }
    for (;;)
    {
      return;
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        BaseArticleInfo localBaseArticleInfo = (BaseArticleInfo)paramList.next();
        if (!luy.Y(localBaseArticleInfo)) {
          QLog.i("PTSPreLayoutHandler", 1, "[destroy], articleInfo is not valid.");
        } else {
          f(localBaseArticleInfo);
        }
      }
    }
  }
  
  public static <T extends BaseArticleInfo> void f(T paramT)
  {
    if ((paramT == null) || (paramT.ptsComposer == null)) {
      return;
    }
    paramT.ptsComposer.destroy();
    paramT.ptsComposer = null;
    QLog.i("PTSPreLayoutHandler", 1, "[destroy] succeed, " + m(paramT));
  }
  
  public static String m(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo == null) {
      return "null";
    }
    return " title = " + paramBaseArticleInfo.mTitle + ", rowKey = " + paramBaseArticleInfo.innerUniqueID + ", pageName = " + paramBaseArticleInfo.ptsLitePageName;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lvd
 * JD-Core Version:    0.7.0.1
 */