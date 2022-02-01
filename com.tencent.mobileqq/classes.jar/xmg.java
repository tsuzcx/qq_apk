import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.entrance.FeedBasePlayInfo;
import com.tencent.biz.qqstory.storyHome.model.FeedVideoInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public abstract class xmg<INFO extends FeedBasePlayInfo>
  extends xmx
{
  private static List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  final INFO jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  public yma a;
  
  public xmg(INFO paramINFO)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramINFO;
    znw.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
  }
  
  private static int b(xmh paramxmh, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    int i = 0;
    int j = 0;
    if (paramxmh.a == null) {
      return j;
    }
    j = paramxmh.a.b;
    if (j == -1) {
      if (!zof.a(paramxmh.a.c)) {}
    }
    for (;;)
    {
      j = i;
      if (!paramFeedBasePlayInfo.mForcePlayVidFromOld2New) {
        break;
      }
      j = i;
      if (!paramxmh.equals(new xmh(paramFeedBasePlayInfo.mFeedFeedId, null))) {
        break;
      }
      return 1;
      i = 1;
      continue;
      i = j;
    }
  }
  
  @NonNull
  static List<xms> b(List<ylw> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ylw localylw = (ylw)paramList.next();
      if (localylw.jdField_a_of_type_Boolean) {
        localArrayList.add(new xmh(localylw.jdField_a_of_type_JavaLangString, localylw));
      } else {
        yuk.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localylw.jdField_a_of_type_JavaLangString });
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private static xmt b(List<StoryVideoItem> paramList, String paramString, xmh paramxmh)
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
    paramList = new xmt(paramxmh);
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_JavaUtilMap = localHashMap;
    yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return group=%s vid %d, list %s", paramxmh, Integer.valueOf(localArrayList.size()), localArrayList);
    return paramList;
  }
  
  public List<xmz> a(List<xms> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new xmi((xmh)paramList.next(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo));
    }
    return localArrayList;
  }
  
  public xmv a()
  {
    Object localObject4 = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId)) {}
    for (xmh localxmh = new xmh(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId));; localxmh = null)
    {
      Object localObject5 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mStartVid;
      Object localObject3 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mStartVideoFeedId;
      Object localObject2 = localObject3;
      Object localObject1 = localObject5;
      if (TextUtils.isEmpty((CharSequence)localObject5))
      {
        localObject2 = localObject3;
        localObject1 = localObject5;
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForcePlayVidFromOld2New)
        {
          FeedVideoInfo localFeedVideoInfo = ((ymk)wth.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, 1);
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
        yuk.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start vid:%s feedId:%s", new Object[] { localObject5, localObject1 });
        localObject2 = localObject1;
        localObject1 = localObject5;
        localObject3 = localObject4;
        if (localxmh != null)
        {
          localObject3 = localObject4;
          if (localxmh.a != null)
          {
            int i = b(localxmh, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
            localObject5 = ((ymk)wth.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, i);
            localObject3 = localObject4;
            if (localObject5 != null)
            {
              localObject3 = localObject4;
              if (((FeedVideoInfo)localObject5).mIsVideoEnd)
              {
                localObject3 = localObject4;
                if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache)
                {
                  localObject3 = b(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, localxmh);
                  yuk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
                }
              }
            }
          }
        }
        localObject1 = new xmv(localxmh, (String)localObject1, localObject2);
        ((xmv)localObject1).a = ((xmt)localObject3);
        return localObject1;
        label348:
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId;
        continue;
        label359:
        localObject1 = localObject3;
      }
    }
  }
  
  public ylw a(String paramString)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, xmy paramxmy)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Int += 1;
      a(bool, paramInt, paramxmy);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, xmy paramxmy);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xmg
 * JD-Core Version:    0.7.0.1
 */