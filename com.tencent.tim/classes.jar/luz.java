import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.pts.core.lite.IPTSLiteEventListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

final class luz
  implements IPTSLiteEventListener
{
  public void onExposureTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView) {}
  
  public void onTapEventTriggered(String paramString, HashMap<String, String> paramHashMap, View paramView)
  {
    if ((QLog.isDebugVersion()) || (QLog.isColorLevel()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("identifier = ").append(paramString).append("\n");
      if (paramHashMap != null)
      {
        Iterator localIterator = paramHashMap.entrySet().iterator();
        while (localIterator.hasNext())
        {
          Map.Entry localEntry = (Map.Entry)localIterator.next();
          localStringBuilder.append("dataSet [ ").append((String)localEntry.getKey()).append(" ] =").append((String)localEntry.getValue()).append("\n");
        }
      }
      QLog.i("PTSLiteItemViewBuilder", 2, "[onTapEventTriggered], " + localStringBuilder.toString());
    }
    if ((paramHashMap == null) || (TextUtils.isEmpty(paramString)) || (luy.access$000() == null)) {
      return;
    }
    if ((ArticleInfo)luy.access$000().get(paramString) == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], articleInfo is null.");
      return;
    }
    if (luy.a() == null)
    {
      QLog.i("PTSLiteItemViewBuilder", 1, "[onTapEventTriggered], ptsLiteTapEventDispatcher is null.");
      return;
    }
    luy.a().a(paramString, paramHashMap, paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     luz
 * JD-Core Version:    0.7.0.1
 */