import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.VideoInfo;
import com.tencent.biz.pubaccount.VideoInfo.b;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsRecyclerView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

public class mwc
{
  private mtg a;
  private boolean apL;
  private VideoFeedsRecyclerView jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView;
  private kcs jdField_c_of_type_Kcs;
  private VideoInfo j;
  private ArrayList<VideoInfo> lt;
  private BaseActivity mActivity;
  private AppInterface mApp;
  private ArrayList<mwc.a> mListeners = new ArrayList();
  private long wZ;
  
  public mwc(AppInterface paramAppInterface, BaseActivity paramBaseActivity, ArrayList<VideoInfo> paramArrayList, mtg parammtg, VideoFeedsRecyclerView paramVideoFeedsRecyclerView)
  {
    this.mApp = paramAppInterface;
    this.mActivity = paramBaseActivity;
    this.lt = paramArrayList;
    this.a = parammtg;
    this.jdField_c_of_type_ComTencentBizPubaccountReadinjoyVideoVideoFeedsRecyclerView = paramVideoFeedsRecyclerView;
  }
  
  public void G(VideoInfo paramVideoInfo)
  {
    this.j = paramVideoInfo;
    this.apL = false;
    if (QLog.isColorLevel()) {
      QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "切换视频 videoInfo.DynamicTriggerSec = " + this.j.aHg);
    }
  }
  
  public kcs a()
  {
    if (this.jdField_c_of_type_Kcs == null)
    {
      this.jdField_c_of_type_Kcs = new mwc.b(null);
      this.mActivity.addObserver(this.jdField_c_of_type_Kcs);
    }
    return this.jdField_c_of_type_Kcs;
  }
  
  public void a(int paramInt, VideoInfo paramVideoInfo, long paramLong)
  {
    Iterator localIterator = this.lt.iterator();
    VideoInfo localVideoInfo;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localVideoInfo = (VideoInfo)localIterator.next();
    } while ((localVideoInfo.hY() == null) || (!localVideoInfo.hY().equals(paramVideoInfo.hY())));
    for (paramVideoInfo = localVideoInfo;; paramVideoInfo = null)
    {
      if (paramVideoInfo == null) {
        return;
      }
      if (paramVideoInfo.a == null) {
        paramVideoInfo.a = new VideoInfo.b();
      }
      switch (paramInt)
      {
      default: 
        return;
      case 1: 
        paramVideoInfo.a.rF = paramLong;
        return;
      case 2: 
        paramVideoInfo.a.adP = true;
        return;
      case 3: 
        paramVideoInfo.a.isLike = true;
        return;
      }
      paramVideoInfo.a.isComment = true;
      return;
    }
  }
  
  public void a(mwc.a parama)
  {
    this.mListeners.add(parama);
  }
  
  public void doOnDestory()
  {
    this.mListeners.clear();
    this.mApp = null;
    this.mActivity.removeObserver(this.jdField_c_of_type_Kcs);
    this.mActivity = null;
  }
  
  /* Error */
  public void eL(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 62	mwc:apL	Z
    //   6: istore_3
    //   7: iload_3
    //   8: ifeq +6 -> 14
    //   11: aload_0
    //   12: monitorexit
    //   13: return
    //   14: aload_0
    //   15: lload_1
    //   16: putfield 164	mwc:wZ	J
    //   19: aload_0
    //   20: getfield 55	mwc:j	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   23: getfield 85	com/tencent/biz/pubaccount/VideoInfo:aHg	I
    //   26: ifeq -15 -> 11
    //   29: aload_0
    //   30: getfield 164	mwc:wZ	J
    //   33: aload_0
    //   34: getfield 55	mwc:j	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   37: getfield 85	com/tencent/biz/pubaccount/VideoInfo:aHg	I
    //   40: sipush 1000
    //   43: imul
    //   44: i2l
    //   45: lcmp
    //   46: ifle -35 -> 11
    //   49: aload_0
    //   50: iconst_1
    //   51: putfield 62	mwc:apL	Z
    //   54: invokestatic 68	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   57: ifeq +34 -> 91
    //   60: ldc 70
    //   62: iconst_2
    //   63: new 72	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 73	java/lang/StringBuilder:<init>	()V
    //   70: ldc 166
    //   72: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_0
    //   76: getfield 55	mwc:j	Lcom/tencent/biz/pubaccount/VideoInfo;
    //   79: getfield 170	com/tencent/biz/pubaccount/VideoInfo:title	Ljava/lang/String;
    //   82: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: invokevirtual 92	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aload_0
    //   92: getfield 39	mwc:mListeners	Ljava/util/ArrayList;
    //   95: invokevirtual 113	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   98: astore 4
    //   100: aload 4
    //   102: invokeinterface 118 1 0
    //   107: ifeq -96 -> 11
    //   110: aload 4
    //   112: invokeinterface 122 1 0
    //   117: checkcast 6	mwc$a
    //   120: invokeinterface 173 1 0
    //   125: goto -25 -> 100
    //   128: astore 4
    //   130: aload_0
    //   131: monitorexit
    //   132: aload 4
    //   134: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	135	0	this	mwc
    //   0	135	1	paramLong	long
    //   6	2	3	bool	boolean
    //   98	13	4	localIterator	Iterator
    //   128	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	7	128	finally
    //   14	91	128	finally
    //   91	100	128	finally
    //   100	125	128	finally
  }
  
  public VideoInfo h()
  {
    if (this.j != null) {
      return this.j;
    }
    return null;
  }
  
  public String kv()
  {
    for (;;)
    {
      int n;
      try
      {
        localJSONObject1 = new JSONObject();
        localJSONArray = new JSONArray();
        i = 0;
        if (i >= this.lt.size()) {
          break label672;
        }
        if ((((VideoInfo)this.lt.get(i)).hY() == null) || (!((VideoInfo)this.lt.get(i)).hY().equals(this.j.hY()))) {
          break label677;
        }
        k = i;
      }
      catch (Exception localException)
      {
        JSONObject localJSONObject1;
        JSONArray localJSONArray;
        VideoInfo localVideoInfo;
        JSONObject localJSONObject2;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "getRequestHistoryData() ERROR = " + localException.getMessage());
        return null;
      }
      if (m >= 0)
      {
        localVideoInfo = (VideoInfo)this.lt.get(m);
        if (localVideoInfo.a != null)
        {
          localJSONObject2 = new JSONObject();
          localJSONObject2.put("rowkey", localVideoInfo.Wz);
          localJSONObject2.put("video_duration", localVideoInfo.getDuration());
          localJSONObject2.put("watch_duration", (float)localVideoInfo.a.rF / 1000.0F);
          localJSONObject2.put("alg_id", localVideoInfo.algorithmID);
          localJSONObject2.put("video_index", m);
          if (!localVideoInfo.a.adP) {
            break label709;
          }
          n = 1;
          localJSONObject2.put("is_biu", n);
          if (!localVideoInfo.a.isLike) {
            break label715;
          }
          n = 1;
          localJSONObject2.put("is_like", n);
          if (!localVideoInfo.a.isComment) {
            break label721;
          }
          n = 1;
          localJSONObject2.put("is_comment", n);
          localJSONArray.put(localJSONObject2);
          i += 1;
          break label700;
        }
      }
      else
      {
        localJSONObject1.put("play_info", localJSONArray);
        localJSONObject1.put("first_rowkey", ((VideoInfo)this.lt.get(0)).Wz);
        if (((VideoInfo)this.lt.get(0)).a != null)
        {
          localJSONObject1.put("first_watch_duration", (float)((VideoInfo)this.lt.get(0)).a.rF / 1000.0F);
          localJSONObject1.put("first_video_duration", ((VideoInfo)this.lt.get(0)).getDuration());
          localJSONObject1.put("current_rowkey", this.j.Wz);
          localJSONObject1.put("current_watch_duration", (float)this.wZ / 1000.0F);
          localJSONObject1.put("current_video_duration", this.j.getDuration());
          localJSONObject1.put("current_algid", this.j.algorithmID);
          if (this.j.a == null) {
            break label638;
          }
          if (this.j.a.adP)
          {
            i = 1;
            localJSONObject1.put("current_isbiu", i);
            if (!this.j.a.isComment) {
              break label628;
            }
            i = 1;
            localJSONObject1.put("current_iscomment", i);
            if (!this.j.a.isLike) {
              break label633;
            }
            i = 1;
            localJSONObject1.put("current_islike", i);
            localJSONObject1.put("current_video_index", k);
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "触发动态插入 json = " + localJSONObject1.toString());
            }
            return localJSONObject1.toString();
          }
        }
        else
        {
          localJSONObject1.put("first_watch_duration", 0);
          continue;
        }
        i = 0;
        continue;
        label628:
        i = 0;
        continue;
        label633:
        i = 0;
        continue;
        label638:
        localException.put("current_isbiu", 0);
        localException.put("current_iscomment", 0);
        localException.put("current_islike", 0);
        continue;
      }
      break label700;
      label672:
      int k = -1;
      break label684;
      label677:
      i += 1;
      continue;
      label684:
      if (k == -1) {
        return null;
      }
      int m = k - 1;
      int i = 0;
      continue;
      label700:
      if (i >= 10)
      {
        continue;
        label709:
        n = 0;
        continue;
        label715:
        n = 0;
        continue;
        label721:
        n = 0;
      }
      else
      {
        m -= 1;
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void aRU();
    
    public abstract void aRV();
  }
  
  class b
    extends kcs
  {
    private b() {}
    
    protected void o(boolean paramBoolean, Bundle paramBundle)
    {
      int m = 0;
      Object localObject1;
      if (paramBoolean)
      {
        localObject1 = paramBundle.getString("VALUE_REQUEST_VIDEO_ARTICLE_ID");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (((String)localObject1).equals(mwc.a(mwc.this).Wz))) {
          break label42;
        }
      }
      for (;;)
      {
        return;
        label42:
        paramBundle = paramBundle.getParcelableArrayList("VIDEO_RECOMMEND_LIST");
        if ((paramBundle != null) && (paramBundle.size() != 0))
        {
          Object localObject2 = paramBundle.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = (VideoInfo)((Iterator)localObject2).next();
            ((VideoInfo)localObject3).adH = true;
            ((VideoInfo)localObject3).WD = ((String)localObject1);
            if (QLog.isColorLevel()) {
              QLog.d("Q.pubaccount.video.feeds.VideoFeedsRecommendManager", 2, "动态插入视频 title = " + ((VideoInfo)localObject3).title + ", rowkey = " + ((VideoInfo)localObject3).Wz);
            }
          }
          localObject2 = new ArrayList();
          Object localObject3 = new ArrayList();
          int i = 0;
          int j = -1;
          if (i < mwc.a(mwc.this).size())
          {
            int k;
            if (j == -1) {
              if (((VideoInfo)mwc.a(mwc.this).get(i)).hY() == null) {
                k = j;
              }
            }
            for (;;)
            {
              i += 1;
              j = k;
              break;
              k = j;
              if (((VideoInfo)mwc.a(mwc.this).get(i)).hY().equals(mwc.a(mwc.this).hY()))
              {
                k = i;
                continue;
                k = j;
                if (((VideoInfo)mwc.a(mwc.this).get(i)).isAD)
                {
                  ((ArrayList)localObject2).add(Integer.valueOf(i));
                  ((ArrayList)localObject3).add(mwc.a(mwc.this).get(i));
                  k = j;
                }
              }
            }
          }
          if ((!mwc.a(mwc.this).isScrolling()) && (((String)localObject1).equals(mwc.a(mwc.this).Wz)))
          {
            localObject1 = mwc.b(mwc.this).iterator();
            while (((Iterator)localObject1).hasNext()) {
              ((mwc.a)((Iterator)localObject1).next()).aRV();
            }
            i = ((ArrayList)localObject2).size() - 1;
            while (i >= 0)
            {
              mwc.a(mwc.this).remove(((Integer)((ArrayList)localObject2).get(i)).intValue());
              mwc.a(mwc.this).notifyItemRemoved(((Integer)((ArrayList)localObject2).get(i)).intValue());
              i -= 1;
            }
            mwc.a(mwc.this).addAll(j + 1, paramBundle);
            mwc.a(mwc.this).notifyItemRangeInserted(j + 1, paramBundle.size());
            i = m;
            while (i < ((ArrayList)localObject2).size())
            {
              mwc.a(mwc.this).add(((Integer)((ArrayList)localObject2).get(i)).intValue(), ((ArrayList)localObject3).get(i));
              mwc.a(mwc.this).notifyItemInserted(((Integer)((ArrayList)localObject2).get(i)).intValue());
              i += 1;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mwc
 * JD-Core Version:    0.7.0.1
 */