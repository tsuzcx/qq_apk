import android.net.Uri;
import android.text.TextUtils;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.qnreading.PreLoader.1;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONObject;

public class lwg
{
  private static String TAG = "PreLoader";
  private static boolean alI = true;
  private Set<String> W = Collections.synchronizedSet(new HashSet());
  private boolean alG;
  private boolean alH;
  private boolean alJ;
  private boolean alK;
  private Map<String, String> cache = new ConcurrentHashMap();
  
  private boolean CS()
  {
    QLog.d(TAG, 1, "isNeedPreload isNeedCheckPreload: " + this.alH + " isConfigNeedPreload: " + this.alG + " isInstalledKB:" + this.alJ);
    return (this.alH) && (this.alG) && (this.alJ);
  }
  
  public static lwg a()
  {
    return lwg.a.b();
  }
  
  private void f(Set<String> paramSet)
  {
    ThreadManager.executeOnNetWorkThread(new PreLoader.1(this, paramSet));
  }
  
  private void g(BaseArticleInfo paramBaseArticleInfo)
  {
    if (paramBaseArticleInfo.proteusItemsData != null) {}
    try
    {
      paramBaseArticleInfo = new JSONObject(paramBaseArticleInfo.proteusItemsData).optString("article_jump_url");
      if ((!TextUtils.isEmpty(paramBaseArticleInfo)) && (paramBaseArticleInfo.startsWith("mqqapi://readinjoy/open?src_type=internal&target=4")))
      {
        paramBaseArticleInfo = aurr.getArgumentsFromURL(paramBaseArticleInfo);
        String str = (String)paramBaseArticleInfo.get("appSchema");
        if (("com.tencent.reading".equals(paramBaseArticleInfo.get("appPackageName"))) && (str != null))
        {
          paramBaseArticleInfo = (String)aurr.getArgumentsFromURL(Uri.decode(str)).get("rowkey");
          if (!this.cache.containsKey(paramBaseArticleInfo))
          {
            this.W.add(paramBaseArticleInfo);
            QLog.d(TAG, 1, "searchKBArticleId cache: " + paramBaseArticleInfo);
          }
        }
      }
      return;
    }
    catch (Exception paramBaseArticleInfo)
    {
      QLog.e(TAG, 1, paramBaseArticleInfo, new Object[] { "" });
    }
  }
  
  private void init()
  {
    boolean bool = true;
    if (this.alK) {}
    AladdinConfig localAladdinConfig;
    do
    {
      return;
      localAladdinConfig = Aladdin.getConfig(209);
    } while (localAladdinConfig == null);
    if (localAladdinConfig.getIntegerFromString("is_preload_open", 0) == 1) {}
    for (;;)
    {
      this.alG = bool;
      if (!alI) {
        break;
      }
      this.alJ = aqiz.isAppInstalled(BaseApplicationImpl.getApplication(), "com.tencent.reading");
      alI = false;
      return;
      bool = false;
    }
  }
  
  private void y(boolean paramBoolean, String paramString)
  {
    if (paramBoolean) {
      try
      {
        paramString = new JSONObject(paramString);
        if (paramString.getInt("ret") == 0)
        {
          paramString = paramString.getJSONArray("fullnews");
          int i = 0;
          while (i < paramString.length())
          {
            JSONObject localJSONObject = (JSONObject)paramString.get(i);
            String str = localJSONObject.getString("id");
            this.cache.put(str, Uri.encode(localJSONObject.toString()));
            this.W.remove(str);
            i += 1;
          }
        }
        return;
      }
      catch (Exception paramString)
      {
        QLog.e(TAG, 1, paramString, new Object[] { "" });
      }
    }
  }
  
  public void cI(List<ArticleInfo> paramList)
  {
    if (paramList == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.addAll(paramList);
    cJ(localArrayList);
  }
  
  public void cJ(List<BaseArticleInfo> paramList)
  {
    if (!CS()) {}
    do
    {
      return;
      if (paramList == null)
      {
        QLog.d(TAG, 1, "startRequest articleInfos == null");
        return;
      }
      QLog.d(TAG, 1, "startRequest");
      paramList = paramList.iterator();
      while (paramList.hasNext()) {
        g((BaseArticleInfo)paramList.next());
      }
    } while (this.W.size() <= 0);
    f(this.W);
  }
  
  public String eO(String paramString)
  {
    if (!CS()) {}
    String str;
    do
    {
      return paramString;
      str = (String)aurr.getArgumentsFromURL(paramString).get("rowkey");
      str = (String)this.cache.get(str);
    } while (TextUtils.isEmpty(str));
    paramString = paramString + "&item=" + str;
    QLog.e(TAG, 1, "item=" + str.length());
    return paramString;
  }
  
  public void onCreate()
  {
    QLog.d(TAG, 1, "onCreate");
    this.alH = true;
    init();
  }
  
  public void onDestroy()
  {
    QLog.d(TAG, 1, "onDestroy");
    this.alH = false;
    this.cache.clear();
    this.W.clear();
  }
  
  public void x(int paramInt, List<Long> paramList)
  {
    if (!CS()) {
      return;
    }
    cJ(lbz.a().a(Integer.valueOf(paramInt), paramList));
  }
  
  static class a
  {
    private static final lwg a = new lwg();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lwg
 * JD-Core Version:    0.7.0.1
 */