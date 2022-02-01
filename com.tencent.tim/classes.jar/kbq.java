import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.1;
import com.tencent.biz.pubaccount.PublicAccountSearchRecommendManager.2;
import com.tencent.mobileqq.ac.ArticleComment.GetRecommendPubAccountRequest;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import mqq.app.MobileQQ;
import mqq.app.NewIntent;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class kbq
{
  private static kbq a;
  private final String TAG = kbq.class.getSimpleName();
  private final String VS = "recommend_title";
  private final String VT = "recommend_cache_time";
  private final String VU = "recommend_fetch_time";
  private final String VV = "recommend_content_list";
  private final String VW = "recommend_is_forbidden";
  private final String VX = "search_history_list";
  private String VY;
  private final int aGS = 8;
  private boolean adx;
  private HashMap<String, kbq.b> cY = new HashMap();
  private ArrayList<kbq.c> jJ = new ArrayList();
  private ArrayList<kbq.b> jK = new ArrayList();
  private boolean mInited;
  private final long rm = 86400000L;
  private final long rn = 3600000L;
  private final long ro = 2592000000L;
  private long rp;
  private long rq;
  
  private void C(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getString("public_account_search_recommend", null);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "loadRecommendListFromLocal->json:" + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = ocp.e(paramQQAppInterface);
          if (paramQQAppInterface != null)
          {
            this.VY = paramQQAppInterface.getString("recommend_title");
            this.rp = paramQQAppInterface.getLong("recommend_cache_time");
            this.rq = paramQQAppInterface.getLong("recommend_fetch_time");
            this.adx = paramQQAppInterface.getBoolean("recommend_is_forbidden");
            paramQQAppInterface = paramQQAppInterface.getJSONArray("recommend_content_list");
            this.jJ.clear();
            int i = 0;
            while (i < paramQQAppInterface.length())
            {
              Object localObject = (JSONObject)paramQQAppInterface.get(i);
              localObject = new kbq.c(((JSONObject)localObject).optString("uin"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optBoolean("isPA", true));
              this.jJ.add(localObject);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "loadRecommendListFromLocal->error:" + paramQQAppInterface);
          }
        }
      }
    }
  }
  
  private void D(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountSearchRecommendManager.1(this, paramQQAppInterface));
  }
  
  private void E(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getApplication().getSharedPreferences("sp_public_account_with_cuin_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    if (paramQQAppInterface != null)
    {
      paramQQAppInterface = paramQQAppInterface.getString("public_account_search_history", null);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "loadHistoryListFromLocal->json:" + paramQQAppInterface);
      }
      if (!TextUtils.isEmpty(paramQQAppInterface)) {
        try
        {
          paramQQAppInterface = ocp.e(paramQQAppInterface);
          if (paramQQAppInterface != null)
          {
            paramQQAppInterface = paramQQAppInterface.getJSONArray("search_history_list");
            this.jK.clear();
            this.cY.clear();
            int i = 0;
            while (i < paramQQAppInterface.length())
            {
              Object localObject = (JSONObject)paramQQAppInterface.get(i);
              localObject = new kbq.b(((JSONObject)localObject).optString("uin"), ((JSONObject)localObject).optString("name"), ((JSONObject)localObject).optLong("time"), ((JSONObject)localObject).optBoolean("isPA", true));
              this.jK.add(localObject);
              this.cY.put(((kbq.b)localObject).mUin, localObject);
              i += 1;
            }
          }
          return;
        }
        catch (JSONException paramQQAppInterface)
        {
          if (QLog.isColorLevel()) {
            QLog.d(this.TAG, 2, "loadHistoryListFromLocal->error:" + paramQQAppInterface);
          }
        }
      }
    }
  }
  
  private void F(QQAppInterface paramQQAppInterface)
  {
    ThreadManager.executeOnFileThread(new PublicAccountSearchRecommendManager.2(this, paramQQAppInterface));
  }
  
  private ArrayList<kbq.c> a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = new ArrayList();
    Iterator localIterator = this.jK.iterator();
    while (localIterator.hasNext())
    {
      kbq.b localb = (kbq.b)localIterator.next();
      paramQQAppInterface.add(new kbq.c(localb.mUin, localb.mName, localb.ady));
    }
    return paramQQAppInterface;
  }
  
  public static kbq a()
  {
    if (a == null) {}
    try
    {
      a = new kbq();
      if (QLog.isColorLevel()) {
        QLog.d(a.TAG, 2, "newInstance!");
      }
      return a;
    }
    finally {}
  }
  
  private void a(QQAppInterface paramQQAppInterface, kbq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getRecommendListFromLocal->mRecommendIsForbidden:" + this.adx);
    }
    if (this.adx)
    {
      parama.b(new ArrayList(), null, true);
      return;
    }
    if (c(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getRecommendListFromLocal->使用推荐内容缓存!");
      }
      parama.b(bb(), this.VY, true);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getRecommendListFromLocal->使用搜索历史!");
    }
    parama.b(a(paramQQAppInterface), null, false);
  }
  
  private void b(QQAppInterface paramQQAppInterface, kbq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequest->begin!");
    }
    NewIntent localNewIntent = new NewIntent(paramQQAppInterface.getApplication().getApplicationContext(), kbs.class);
    localNewIntent.putExtra("cmd", "PubAccountArticleCenter.GetRecommendPubAccount");
    ArticleComment.GetRecommendPubAccountRequest localGetRecommendPubAccountRequest = new ArticleComment.GetRecommendPubAccountRequest();
    localGetRecommendPubAccountRequest.version.set(ocp.getVersionInfo());
    localGetRecommendPubAccountRequest.cuin.set(Long.parseLong(paramQQAppInterface.getCurrentAccountUin()));
    localGetRecommendPubAccountRequest.count.set(8);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequset->versionInfo:" + localGetRecommendPubAccountRequest.version.get() + ", cuin:" + localGetRecommendPubAccountRequest.cuin.get() + ", count:" + localGetRecommendPubAccountRequest.count.get());
    }
    localNewIntent.putExtra("data", localGetRecommendPubAccountRequest.toByteArray());
    localNewIntent.setObserver(new kbr(this, localNewIntent, paramQQAppInterface, parama));
    this.rq = NetConnInfoCenter.getServerTimeMillis();
    paramQQAppInterface.startServlet(localNewIntent);
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "sendGetPublicAccountSearchRecommendRequest->send request, time:" + this.rq);
    }
  }
  
  private boolean b(QQAppInterface paramQQAppInterface)
  {
    if (!this.mInited) {
      B(paramQQAppInterface);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    boolean bool = false;
    if (l - this.rq > 3600000L) {
      bool = true;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkShouldFetchData->now:" + l + ", fetchTime:" + this.rq + ", result:" + bool);
    }
    return bool;
  }
  
  private ArrayList<kbq.c> bb()
  {
    if (this.jJ.size() <= 8) {
      return (ArrayList)this.jJ.clone();
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < 8)
    {
      localArrayList.add(this.jJ.get(i));
      i += 1;
    }
    return (ArrayList)localArrayList.clone();
  }
  
  private boolean c(QQAppInterface paramQQAppInterface)
  {
    if (!this.mInited) {
      B(paramQQAppInterface);
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    int i = this.jJ.size();
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (l - this.rp < 86400000L)
    {
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "checkRecommendCacheValid->now:" + l + ", cacheTime:" + this.rp + ", size:" + i + ", result:" + bool1);
    }
    return bool1;
  }
  
  public void B(QQAppInterface paramQQAppInterface)
  {
    if ((!this.mInited) && (paramQQAppInterface != null))
    {
      C(paramQQAppInterface);
      E(paramQQAppInterface);
      this.mInited = true;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "initFromLocalData!");
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return;
    }
    long l = NetConnInfoCenter.getServerTimeMillis();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem->uin:" + paramString1 + ", name:" + paramString2 + ", isPublicAccount:" + paramBoolean + ", time:" + l);
    }
    if (this.cY.containsKey(paramString1))
    {
      paramString1 = (kbq.b)this.cY.get(paramString1);
      this.jK.remove(paramString1);
      this.jK.add(0, paramString1);
      paramString1.mTime = l;
      paramString1.ady = paramBoolean;
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem update!");
      }
    }
    for (;;)
    {
      F(paramQQAppInterface);
      if (!QLog.isColorLevel()) {
        break;
      }
      paramQQAppInterface = this.jK.iterator();
      while (paramQQAppInterface.hasNext())
      {
        paramString1 = (kbq.b)paramQQAppInterface.next();
        QLog.d(this.TAG, 2, paramString1.toString());
      }
      break;
      paramString2 = new kbq.b(paramString1, paramString2, l, paramBoolean);
      this.jK.add(0, paramString2);
      this.cY.put(paramString1, paramString2);
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem insert!");
      }
      int i = this.jK.size();
      if (i > 8)
      {
        paramString1 = (kbq.b)this.jK.get(i - 1);
        this.jK.remove(paramString1);
        this.cY.remove(paramString1.mUin);
        if (QLog.isColorLevel()) {
          QLog.d(this.TAG, 2, "updatePublicAccountSearchHistoryItem remove lastItem!");
        }
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, boolean paramBoolean, kbq.a parama)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getRecommendList->isFromCreate:" + paramBoolean);
    }
    if (!paramBoolean)
    {
      parama.b(a(paramQQAppInterface), null, false);
      return;
    }
    if (b(paramQQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.TAG, 2, "getRecommendList->sendGetPublicAccountSearchRecommendRequest!");
      }
      b(paramQQAppInterface, parama);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "getRecommendList->getRecommendListFromLocal!");
    }
    a(paramQQAppInterface, parama);
  }
  
  public void reset()
  {
    this.mInited = false;
    this.VY = "";
    this.rp = 0L;
    this.rq = 0L;
    this.jJ.clear();
    this.jK.clear();
    this.cY.clear();
    if (QLog.isColorLevel()) {
      QLog.d(this.TAG, 2, "resetManager!");
    }
  }
  
  public static abstract interface a
  {
    public abstract void b(ArrayList<kbq.c> paramArrayList, String paramString, boolean paramBoolean);
  }
  
  public class b
  {
    public boolean ady;
    public String mName;
    public long mTime;
    public String mUin;
    
    public b(String paramString1, String paramString2, long paramLong, boolean paramBoolean)
    {
      this.mUin = paramString1;
      this.mName = paramString2;
      this.mTime = paramLong;
      this.ady = paramBoolean;
    }
    
    public String toString()
    {
      return "PublicAccountSearchHistoryItem->uin:" + this.mUin + ", name:" + this.mName + ", isPublicAccount:" + this.ady + ", time:" + this.mTime;
    }
  }
  
  public class c
  {
    public boolean ady;
    public String mName;
    public String mUin;
    
    public c(String paramString1, String paramString2, boolean paramBoolean)
    {
      this.mUin = paramString1;
      this.mName = paramString2;
      this.ady = paramBoolean;
    }
    
    public String toString()
    {
      return "PublicAccountSearchRecommendItem->uin:" + this.mUin + ", name:" + this.mName + ", isPublicAccount:" + this.ady;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kbq
 * JD-Core Version:    0.7.0.1
 */