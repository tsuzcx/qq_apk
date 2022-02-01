import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class qvi
  implements psj
{
  private plv<String, FeedVideoInfo> j = new plv(300);
  
  private String J(String paramString, int paramInt)
  {
    return paramString + ":" + paramInt;
  }
  
  public FeedVideoInfo a(int paramInt, FeedVideoInfo paramFeedVideoInfo, boolean paramBoolean)
  {
    try
    {
      paramFeedVideoInfo = a(paramInt, paramFeedVideoInfo.feedId, paramFeedVideoInfo.mVideoSeq, paramFeedVideoInfo.mVideoItemList, paramFeedVideoInfo.mVideoNextCookie, paramFeedVideoInfo.mIsVideoEnd, paramFeedVideoInfo.mVideoPullType, paramBoolean);
      return paramFeedVideoInfo;
    }
    finally
    {
      paramFeedVideoInfo = finally;
      throw paramFeedVideoInfo;
    }
  }
  
  public FeedVideoInfo a(int paramInt1, String paramString1, int paramInt2, List<StoryVideoItem> paramList, String paramString2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2)
  {
    if ((paramInt3 != 0) && (paramInt3 != 1))
    {
      paramString1 = null;
      return paramString1;
    }
    for (;;)
    {
      try
      {
        FeedVideoInfo localFeedVideoInfo = (FeedVideoInfo)this.j.a(J(paramString1, paramInt3));
        if (ram.isColorLevel()) {
          ram.d("Q.qqstory.home.data.FeedVideoManager", "**before** update feed video list:" + localFeedVideoInfo);
        }
        if (localFeedVideoInfo == null)
        {
          localFeedVideoInfo = new FeedVideoInfo();
          localFeedVideoInfo.feedId = paramString1;
          localFeedVideoInfo.mVideoSeq = paramInt2;
          localFeedVideoInfo.mVideoItemList.addAll(paramList);
          paramList = localFeedVideoInfo;
          paramList.feedId = paramString1;
          paramList.mVideoNextCookie = paramString2;
          paramList.mIsVideoEnd = paramBoolean1;
          paramList.mVideoPullType = paramInt3;
          this.j.a(J(paramString1, paramInt3), paramList);
          if (!paramBoolean1) {
            continue;
          }
          if (paramInt3 != 0) {
            break label430;
          }
          paramInt2 = 1;
          paramString2 = (FeedVideoInfo)this.j.a(J(paramString1, paramInt2));
          if (paramString2 != null) {
            break label427;
          }
          paramString2 = new FeedVideoInfo();
          paramString2.copy(paramList);
          paramString2.mVideoPullType = paramInt2;
          paramString2.mVideoItemList = new ArrayList(paramList.mVideoItemList.size());
          paramInt3 = paramList.mVideoItemList.size();
          if (paramInt3 > 0)
          {
            paramString2.mVideoItemList.add(paramList.mVideoItemList.get(paramInt3 - 1));
            paramInt3 -= 1;
            continue;
          }
        }
        else
        {
          if (localFeedVideoInfo.mVideoSeq == paramInt2)
          {
            if (paramBoolean2) {
              localFeedVideoInfo.mVideoItemList.clear();
            }
            localFeedVideoInfo.mVideoItemList.addAll(paramList);
            paramList = localFeedVideoInfo;
            continue;
          }
          localFeedVideoInfo.mVideoSeq = paramInt2;
          localFeedVideoInfo.mVideoItemList.clear();
          localFeedVideoInfo.mVideoItemList.addAll(paramList);
          paramList = localFeedVideoInfo;
          continue;
        }
        this.j.a(J(paramString1, paramInt2), paramString2);
        paramString1 = new qvi.a(paramString1, paramInt1);
        pmi.a().dispatch(paramString1);
        if (ram.isColorLevel()) {
          ram.b("Q.qqstory.home.data.FeedVideoManager", "**after** update feed video list:%s", paramList);
        }
        paramString1 = paramList;
        break;
      }
      finally {}
      label427:
      continue;
      label430:
      paramInt2 = 0;
    }
  }
  
  /* Error */
  @android.support.annotation.Nullable
  public FeedVideoInfo a(String paramString, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 23	qvi:j	Lplv;
    //   6: aload_0
    //   7: aload_1
    //   8: iload_2
    //   9: invokespecial 72	qvi:J	(Ljava/lang/String;I)Ljava/lang/String;
    //   12: invokevirtual 75	plv:a	(Ljava/lang/Object;)Lplu;
    //   15: checkcast 45	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +7 -> 27
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: new 45	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo
    //   30: dup
    //   31: invokespecial 93	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: aload_1
    //   37: invokevirtual 106	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:copy	(Ljava/lang/Object;)V
    //   40: aload_3
    //   41: new 108	java/util/ArrayList
    //   44: dup
    //   45: aload_1
    //   46: getfield 57	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:mVideoItemList	Ljava/util/List;
    //   49: invokespecial 151	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   52: putfield 57	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:mVideoItemList	Ljava/util/List;
    //   55: invokestatic 81	ram:isColorLevel	()Z
    //   58: ifeq +27 -> 85
    //   61: ldc 83
    //   63: new 28	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 29	java/lang/StringBuilder:<init>	()V
    //   70: ldc 153
    //   72: invokevirtual 33	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 88	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 42	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 92	ram:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   85: aload_3
    //   86: astore_1
    //   87: goto -64 -> 23
    //   90: astore_1
    //   91: aload_0
    //   92: monitorexit
    //   93: aload_1
    //   94: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	95	0	this	qvi
    //   0	95	1	paramString	String
    //   0	95	2	paramInt	int
    //   34	52	3	localFeedVideoInfo	FeedVideoInfo
    // Exception table:
    //   from	to	target	type
    //   2	19	90	finally
    //   27	85	90	finally
  }
  
  public void a(FeedVideoInfo paramFeedVideoInfo)
  {
    if (paramFeedVideoInfo == null) {}
    while ((paramFeedVideoInfo.mIsVideoEnd) || (VideoListFeedItem.isFakeFeedId(paramFeedVideoInfo.feedId)) || (paramFeedVideoInfo.mVideoItemList.size() >= 5)) {
      return;
    }
    new qrz(4, paramFeedVideoInfo).aPh();
    ram.w("Q.qqstory.home.data.FeedVideoManager", "triggerSyncVideoList for %s", new Object[] { paramFeedVideoInfo });
  }
  
  public void a(String paramString, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramStoryVideoItem == null)) {}
    do
    {
      return;
      paramString = (FeedVideoInfo)this.j.a(J(paramString, paramInt));
    } while ((paramString == null) || (paramString.mVideoItemList == null));
    paramString.mVideoItemList.remove(paramStoryVideoItem);
  }
  
  public void onDestroy() {}
  
  public void onInit() {}
  
  public static class a
    extends plt
  {
    public int bnP;
    public String mFeedId;
    
    public a(@NonNull String paramString, int paramInt)
    {
      this.mFeedId = paramString;
      this.bnP = paramInt;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qvi
 * JD-Core Version:    0.7.0.1
 */