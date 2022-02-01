import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoRecommendManager.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

public class myp
{
  private myp.a a;
  private int aWl;
  private int aWm = -1;
  private int aWn;
  private String akI;
  private boolean aqw;
  private HashMap<Long, BaseArticleInfo> ep = new HashMap();
  private HashMap<Long, BaseArticleInfo> eq = new HashMap();
  private float kb = -1.0F;
  private BaseArticleInfo l;
  private Activity mActivity;
  
  public myp(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    ThreadManager.post(new VideoRecommendManager.1(this), 10, null, true);
  }
  
  private void P(int paramInt, long paramLong)
  {
    switch (paramInt)
    {
    default: 
      paramInt = 0;
    }
    for (;;)
    {
      JSONObject localJSONObject = new JSONObject();
      try
      {
        localJSONObject.put("dynamic_recommend_strategyid", this.aWl);
        localJSONObject.put("condition", paramInt);
        localJSONObject.put("strategy_duration_limit", this.aWm);
        localJSONObject.put("strategy_duration_percent", this.kb);
        localJSONObject.put("operator", this.aWn);
        if (!TextUtils.isEmpty(this.akI)) {
          localJSONObject.put("video_session_id", this.akI);
        }
        if ((this.mActivity != null) && (this.mActivity.getIntent() != null))
        {
          paramInt = this.mActivity.getIntent().getIntExtra("channel_from", -1);
          kbp.b(null, null, "0X80087C7", "0X80087C7", 0, 0, String.valueOf(0), "", "", new nce.a(kct.d(localJSONObject)).O(paramInt).a().toJsonString(), false);
          return;
          paramInt = 1;
          continue;
          paramInt = 2;
          continue;
          if (paramLong >= this.aWm)
          {
            paramInt = 3;
            continue;
          }
          paramInt = 4;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          continue;
          paramInt = 0;
        }
      }
    }
  }
  
  public void a(int paramInt, BaseArticleInfo paramBaseArticleInfo, long paramLong1, long paramLong2)
  {
    int j = 1;
    if (paramBaseArticleInfo != null) {}
    int i;
    try
    {
      boolean bool = this.ep.containsKey(Long.valueOf(paramBaseArticleInfo.mArticleID));
      if (bool) {}
      for (;;)
      {
        return;
        if ((paramInt != 1) && (paramInt != 2)) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "updateLatestUserAction() action=" + paramInt);
        }
        this.l = paramBaseArticleInfo;
        i = j;
        if ((i != 0) && (this.a != null))
        {
          if (QLog.isColorLevel()) {
            QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "updateLatestUserAction() 触发拉取 articleInfo.mArticleID = " + paramBaseArticleInfo.mArticleID + ", articleInfo.mTitle = " + paramBaseArticleInfo.mTitle);
          }
          P(paramInt, paramLong1);
          this.ep.put(Long.valueOf(this.l.mArticleID), this.l);
          this.a.a(this.aqw, this.l);
        }
      }
      if (paramInt != 0) {
        break label347;
      }
    }
    finally {}
    if (this.aWn == 0)
    {
      if ((paramLong1 < this.aWm) || ((float)paramLong1 <= (float)paramLong2 * this.kb)) {
        break label353;
      }
      i = 1;
    }
    for (;;)
    {
      if (i != 0)
      {
        if (QLog.isColorLevel()) {
          QLog.d("Q.pubaccount.video.feeds.VideoReommendManager", 2, "updateLatestUserAction() action=" + paramInt + ", playDuration=" + paramLong1 + ", totalDuration=" + paramLong2);
        }
        this.l = paramBaseArticleInfo;
        i = j;
        break;
        if (paramLong1 < this.aWm)
        {
          float f1 = (float)paramLong1;
          float f2 = (float)paramLong2;
          float f3 = this.kb;
          if (f1 <= f2 * f3) {}
        }
        else
        {
          i = 1;
          continue;
        }
        i = 0;
        continue;
      }
      label347:
      i = 0;
      break;
      label353:
      i = 0;
    }
  }
  
  public boolean aR(long paramLong)
  {
    return this.eq.containsKey(Long.valueOf(paramLong));
  }
  
  public void cU(List<ArticleInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)paramList.next();
      this.eq.put(Long.valueOf(localArticleInfo.mArticleID), localArticleInfo);
    }
  }
  
  public void nZ(String paramString)
  {
    this.akI = paramString;
  }
  
  public int qi()
  {
    return this.aWl;
  }
  
  public static abstract interface a
  {
    public abstract void a(boolean paramBoolean, BaseArticleInfo paramBaseArticleInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     myp
 * JD-Core Version:    0.7.0.1
 */