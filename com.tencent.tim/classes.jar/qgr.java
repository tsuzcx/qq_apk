import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class qgr<INFO extends FeedBasePlayInfo>
  extends qgz.a
{
  private static List<StoryVideoItem> nN;
  final INFO a;
  public qve.b a;
  private int pageCount;
  
  public qgr(INFO paramINFO)
  {
    this.a = paramINFO;
    rom.checkNotNull(this.a);
  }
  
  private static int a(qgr.a parama, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    int i = 0;
    int j = 0;
    if (parama.a == null) {
      return j;
    }
    j = parama.a.bls;
    if (j == -1) {
      if (!roq.fo(parama.a.ayV)) {}
    }
    for (;;)
    {
      j = i;
      if (!paramFeedBasePlayInfo.mForcePlayVidFromOld2New) {
        break;
      }
      j = i;
      if (!parama.equals(new qgr.a(paramFeedBasePlayInfo.mFeedFeedId, null))) {
        break;
      }
      return 1;
      i = 1;
      continue;
      i = j;
    }
  }
  
  @NonNull
  private static qgy.d a(List<StoryVideoItem> paramList, String paramString, qgr.a parama)
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    int i = 0;
    if (i < paramList.size())
    {
      StoryVideoItem localStoryVideoItem = (StoryVideoItem)paramList.get(i);
      String str = localStoryVideoItem.mVid;
      localArrayList.add(str);
      if (!TextUtils.isEmpty(localStoryVideoItem.mAttachedFeedId)) {
        localHashMap.put(str, localStoryVideoItem.mAttachedFeedId);
      }
      for (;;)
      {
        i += 1;
        break;
        localHashMap.put(str, paramString);
      }
    }
    paramList = new qgy.d(parama);
    paramList.nv = localArrayList;
    paramList.fR = localHashMap;
    ram.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return group=%s vid %d, list %s", parama, Integer.valueOf(localArrayList.size()), localArrayList);
    return paramList;
  }
  
  @NonNull
  static List<qgy.c> aq(List<qvd> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qvd localqvd = (qvd)paramList.next();
      if (localqvd.aFH) {
        localArrayList.add(new qgr.a(localqvd.mFeedId, localqvd));
      } else {
        ram.w("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localqvd.mFeedId });
      }
    }
    return localArrayList;
  }
  
  public qvd a(String paramString)
  {
    return null;
  }
  
  public void a(int paramInt, qgz.b paramb)
  {
    if (this.pageCount == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.pageCount += 1;
      a(bool, paramInt, paramb);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, qgz.b paramb);
  
  public List<qgz.c> ap(List<qgy.c> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new qgr.b((qgr.a)paramList.next(), this.a));
    }
    return localArrayList;
  }
  
  public qgy.f b()
  {
    Object localObject4 = null;
    if (!TextUtils.isEmpty(this.a.mFeedFeedId)) {}
    for (qgr.a locala = new qgr.a(this.a.mFeedFeedId, a(this.a.mFeedFeedId));; locala = null)
    {
      Object localObject5 = this.a.mStartVid;
      Object localObject3 = this.a.mStartVideoFeedId;
      Object localObject2 = localObject3;
      Object localObject1 = localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (this.a.mForcePlayVidFromOld2New)
        {
          FeedVideoInfo localFeedVideoInfo = ((qvi)psx.a(12)).a(this.a.mFeedFeedId, 1);
          localObject2 = localObject3;
          localObject1 = localObject5;
          if (localFeedVideoInfo != null)
          {
            localObject5 = ((StoryVideoItem)localFeedVideoInfo.mVideoItemList.get(0)).mVid;
            if (!TextUtils.isEmpty((CharSequence)localObject3)) {
              break label359;
            }
            if (TextUtils.isEmpty(((StoryVideoItem)localFeedVideoInfo.mVideoItemList.get(0)).mAttachedFeedId)) {
              break label348;
            }
            localObject1 = ((StoryVideoItem)localFeedVideoInfo.mVideoItemList.get(0)).mAttachedFeedId;
          }
        }
      }
      for (;;)
      {
        ram.w("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start vid:%s feedId:%s", new Object[] { localObject5, localObject1 });
        localObject2 = localObject1;
        localObject1 = localObject5;
        localObject3 = localObject4;
        if (locala != null)
        {
          localObject3 = localObject4;
          if (locala.a != null)
          {
            int i = a(locala, this.a);
            localObject5 = ((qvi)psx.a(12)).a(this.a.mFeedFeedId, i);
            localObject3 = localObject4;
            if (localObject5 != null)
            {
              localObject3 = localObject4;
              if (((FeedVideoInfo)localObject5).mIsVideoEnd)
              {
                localObject3 = localObject4;
                if (!this.a.mForceNotUseVidCache)
                {
                  localObject3 = a(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, locala);
                  ram.b("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
                }
              }
            }
          }
        }
        localObject1 = new qgy.f(locala, (String)localObject1, localObject2);
        ((qgy.f)localObject1).a = ((qgy.d)localObject3);
        return localObject1;
        label348:
        localObject1 = this.a.mFeedFeedId;
        continue;
        label359:
        localObject1 = localObject3;
      }
    }
  }
  
  public void create() {}
  
  public void destroy() {}
  
  public static class a
    extends qgy.c
  {
    @Nullable
    public qvd a;
    
    public a(String paramString, @Nullable qvd paramqvd)
    {
      super();
      this.a = paramqvd;
    }
  }
  
  static class b
    implements qgz.c
  {
    private final qgr.a jdField_a_of_type_Qgr$a;
    private qgz.c.a jdField_a_of_type_Qgz$c$a;
    private qrz jdField_a_of_type_Qrz;
    protected final qvi a;
    private final FeedBasePlayInfo b;
    private int mRequestCount;
    
    public b(qgr.a parama, FeedBasePlayInfo paramFeedBasePlayInfo)
    {
      this.b = paramFeedBasePlayInfo;
      this.jdField_a_of_type_Qgr$a = parama;
      this.jdField_a_of_type_Qvi = ((qvi)psx.a(12));
    }
    
    private void a(ErrorMessage paramErrorMessage, qgy.c paramc)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(paramc);
      this.jdField_a_of_type_Qgz$c$a.b(paramErrorMessage, localArrayList);
    }
    
    private void a(List<StoryVideoItem> paramList, FeedVideoInfo paramFeedVideoInfo)
    {
      if (this.jdField_a_of_type_Qgr$a.a == null)
      {
        a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Qgr$a);
        return;
      }
      if (paramFeedVideoInfo == null) {}
      for (this.jdField_a_of_type_Qrz = new qrz(1, this.jdField_a_of_type_Qgr$a.a.mFeedId, 0, -1);; this.jdField_a_of_type_Qrz = new qrz(1, paramFeedVideoInfo))
      {
        this.jdField_a_of_type_Qrz.a(new qgs(this, paramList));
        this.jdField_a_of_type_Qrz.aPh();
        ram.b("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d, %s", Integer.valueOf(this.mRequestCount), this.jdField_a_of_type_Qgr$a);
        return;
        paramList.addAll(paramFeedVideoInfo.mVideoItemList);
      }
    }
    
    private void a(List<StoryVideoItem> paramList, qrz.b paramb)
    {
      if (!paramb.b.isSuccess())
      {
        b(paramList, paramb);
        return;
      }
      if (paramb.isFirstPage) {
        paramList.clear();
      }
      paramList.addAll(paramb.oj);
      ram.b("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add video size:%d", Integer.valueOf(paramb.oj.size()));
      if ((!paramb.isEnd) && (this.mRequestCount < 20))
      {
        this.mRequestCount += 1;
        ram.b("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "request from net, count:%d", Integer.valueOf(this.mRequestCount));
        this.jdField_a_of_type_Qrz.aPh();
        return;
      }
      b(paramList, paramb);
    }
    
    private void b(List<StoryVideoItem> paramList, qrz.b paramb)
    {
      if (this.jdField_a_of_type_Qgr$a.a == null)
      {
        a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Qgr$a);
        return;
      }
      if (paramb.a == null)
      {
        n(paramList, paramb.mFeedId);
        return;
      }
      Iterator localIterator;
      StoryVideoItem localStoryVideoItem;
      if (QQStoryContext.a().eU(this.jdField_a_of_type_Qgr$a.a.mUnionId))
      {
        if (qgr.nN == null) {
          qgr.ar(((psu)psx.a(5)).g(true));
        }
        if (qgr.nN.size() != 0)
        {
          localIterator = qgr.nN.iterator();
          while (localIterator.hasNext())
          {
            localStoryVideoItem = (StoryVideoItem)localIterator.next();
            if (localStoryVideoItem.mPublishDate.equals(this.jdField_a_of_type_Qgr$a.a.ayV))
            {
              ram.b("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "add fail video %s", localStoryVideoItem);
              paramList.add(localStoryVideoItem);
            }
          }
          if (paramb.a.mVideoPullType != 1) {
            break label264;
          }
        }
      }
      label264:
      for (boolean bool = true;; bool = false)
      {
        Collections.sort(paramList, new qwc.b(bool));
        localIterator = paramList.iterator();
        paramList = new ArrayList(paramList.size());
        while (localIterator.hasNext())
        {
          localStoryVideoItem = (StoryVideoItem)localIterator.next();
          if (!paramList.contains(localStoryVideoItem)) {
            paramList.add(localStoryVideoItem);
          }
        }
      }
      paramb.a = ((qvi)psx.a(12)).a(1, paramb.a.feedId, paramb.a.mVideoSeq, paramList, paramb.a.mVideoNextCookie, paramb.isEnd, paramb.a.mVideoPullType, true);
      n(paramList, paramb.mFeedId);
    }
    
    private void n(List<StoryVideoItem> paramList, String paramString)
    {
      paramList = qgr.b(paramList, paramString, this.jdField_a_of_type_Qgr$a);
      paramString = new ArrayList();
      paramString.add(paramList);
      this.jdField_a_of_type_Qgz$c$a.C(paramString, true);
    }
    
    public void a(qgz.c.a parama)
    {
      if (this.jdField_a_of_type_Qgr$a.a == null)
      {
        a(new ErrorMessage(940001, "group info is null"), this.jdField_a_of_type_Qgr$a);
        return;
      }
      this.jdField_a_of_type_Qgz$c$a = parama;
      int i = qgr.b(this.jdField_a_of_type_Qgr$a, this.b);
      Object localObject = new ArrayList();
      parama = this.jdField_a_of_type_Qvi.a(this.jdField_a_of_type_Qgr$a.a.mFeedId, i);
      if ((parama != null) && (parama.mIsVideoEnd) && (!this.b.mForceNotUseVidCache))
      {
        localObject = parama.mVideoItemList;
        parama = parama.feedId;
        ram.b("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return from cache %s", parama);
        n((List)localObject, parama);
        return;
      }
      a((List)localObject, parama);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qgr
 * JD-Core Version:    0.7.0.1
 */