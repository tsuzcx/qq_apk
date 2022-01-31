import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.List;

public class wkv
  implements uqz
{
  private uhb<String, FeedVideoInfo> a = new uhb(300);
  
  private String a(String paramString, int paramInt)
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
        FeedVideoInfo localFeedVideoInfo = (FeedVideoInfo)this.a.a(a(paramString1, paramInt3));
        if (wsv.a()) {
          wsv.b("Q.qqstory.home.data.FeedVideoManager", "**before** update feed video list:" + localFeedVideoInfo);
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
          this.a.a(a(paramString1, paramInt3), paramList);
          if (!paramBoolean1) {
            continue;
          }
          if (paramInt3 != 0) {
            break label430;
          }
          paramInt2 = 1;
          paramString2 = (FeedVideoInfo)this.a.a(a(paramString1, paramInt2));
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
        this.a.a(a(paramString1, paramInt2), paramString2);
        paramString1 = new wkw(paramString1, paramInt1);
        uht.a().dispatch(paramString1);
        if (wsv.a()) {
          wsv.a("Q.qqstory.home.data.FeedVideoManager", "**after** update feed video list:%s", paramList);
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
    //   3: getfield 20	wkv:a	Luhb;
    //   6: aload_0
    //   7: aload_1
    //   8: iload_2
    //   9: invokespecial 68	wkv:a	(Ljava/lang/String;I)Ljava/lang/String;
    //   12: invokevirtual 71	uhb:a	(Ljava/lang/Object;)Luha;
    //   15: checkcast 41	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo
    //   18: astore_1
    //   19: aload_1
    //   20: ifnonnull +7 -> 27
    //   23: aload_0
    //   24: monitorexit
    //   25: aload_1
    //   26: areturn
    //   27: new 41	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo
    //   30: dup
    //   31: invokespecial 88	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:<init>	()V
    //   34: astore_3
    //   35: aload_3
    //   36: aload_1
    //   37: invokevirtual 101	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:copy	(Ljava/lang/Object;)V
    //   40: aload_3
    //   41: new 103	java/util/ArrayList
    //   44: dup
    //   45: aload_1
    //   46: getfield 53	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:mVideoItemList	Ljava/util/List;
    //   49: invokespecial 147	java/util/ArrayList:<init>	(Ljava/util/Collection;)V
    //   52: putfield 53	com/tencent/biz/qqstory/storyHome/model/FeedVideoInfo:mVideoItemList	Ljava/util/List;
    //   55: invokestatic 76	wsv:a	()Z
    //   58: ifeq +27 -> 85
    //   61: ldc 78
    //   63: new 24	java/lang/StringBuilder
    //   66: dup
    //   67: invokespecial 25	java/lang/StringBuilder:<init>	()V
    //   70: ldc 149
    //   72: invokevirtual 29	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   75: aload_1
    //   76: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   79: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   82: invokestatic 87	wsv:b	(Ljava/lang/String;Ljava/lang/String;)V
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
    //   0	95	0	this	wkv
    //   0	95	1	paramString	String
    //   0	95	2	paramInt	int
    //   34	52	3	localFeedVideoInfo	FeedVideoInfo
    // Exception table:
    //   from	to	target	type
    //   2	19	90	finally
    //   27	85	90	finally
  }
  
  public void a() {}
  
  public void a(FeedVideoInfo paramFeedVideoInfo)
  {
    if (paramFeedVideoInfo == null) {}
    while ((paramFeedVideoInfo.mIsVideoEnd) || (VideoListFeedItem.isFakeFeedId(paramFeedVideoInfo.feedId)) || (paramFeedVideoInfo.mVideoItemList.size() >= 5)) {
      return;
    }
    new wes(4, paramFeedVideoInfo).c();
    wsv.d("Q.qqstory.home.data.FeedVideoManager", "triggerSyncVideoList for %s", new Object[] { paramFeedVideoInfo });
  }
  
  public void a(String paramString, int paramInt, StoryVideoItem paramStoryVideoItem)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramStoryVideoItem == null)) {}
    do
    {
      return;
      paramString = (FeedVideoInfo)this.a.a(a(paramString, paramInt));
    } while ((paramString == null) || (paramString.mVideoItemList == null));
    paramString.mVideoItemList.remove(paramStoryVideoItem);
  }
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wkv
 * JD-Core Version:    0.7.0.1
 */