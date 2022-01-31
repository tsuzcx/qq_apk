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

public abstract class tjg<INFO extends FeedBasePlayInfo>
  extends tjx
{
  private static List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  final INFO jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  public uja a;
  
  public tjg(INFO paramINFO)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramINFO;
    vkw.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
  }
  
  private static int b(tjh paramtjh, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    int i = 0;
    int j = 0;
    if (paramtjh.a == null) {
      return j;
    }
    j = paramtjh.a.b;
    if (j == -1) {
      if (!vlf.a(paramtjh.a.c)) {}
    }
    for (;;)
    {
      j = i;
      if (!paramFeedBasePlayInfo.mForcePlayVidFromOld2New) {
        break;
      }
      j = i;
      if (!paramtjh.equals(new tjh(paramFeedBasePlayInfo.mFeedFeedId, null))) {
        break;
      }
      return 1;
      i = 1;
      continue;
      i = j;
    }
  }
  
  @NonNull
  static List<tjs> b(List<uiw> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      uiw localuiw = (uiw)paramList.next();
      if (localuiw.jdField_a_of_type_Boolean) {
        localArrayList.add(new tjh(localuiw.jdField_a_of_type_JavaLangString, localuiw));
      } else {
        urk.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localuiw.jdField_a_of_type_JavaLangString });
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private static tjt b(List<StoryVideoItem> paramList, String paramString, tjh paramtjh)
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
    paramList = new tjt(paramtjh);
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_JavaUtilMap = localHashMap;
    urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return group=%s vid %d, list %s", paramtjh, Integer.valueOf(localArrayList.size()), localArrayList);
    return paramList;
  }
  
  public List<tjz> a(List<tjs> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new tji((tjh)paramList.next(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo));
    }
    return localArrayList;
  }
  
  public tjv a()
  {
    Object localObject4 = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId)) {}
    for (tjh localtjh = new tjh(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId));; localtjh = null)
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
          FeedVideoInfo localFeedVideoInfo = ((ujk)sqg.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, 1);
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
        urk.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start vid:%s feedId:%s", new Object[] { localObject5, localObject1 });
        localObject2 = localObject1;
        localObject1 = localObject5;
        localObject3 = localObject4;
        if (localtjh != null)
        {
          localObject3 = localObject4;
          if (localtjh.a != null)
          {
            int i = b(localtjh, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
            localObject5 = ((ujk)sqg.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, i);
            localObject3 = localObject4;
            if (localObject5 != null)
            {
              localObject3 = localObject4;
              if (((FeedVideoInfo)localObject5).mIsVideoEnd)
              {
                localObject3 = localObject4;
                if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache)
                {
                  localObject3 = b(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, localtjh);
                  urk.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
                }
              }
            }
          }
        }
        localObject1 = new tjv(localtjh, (String)localObject1, localObject2);
        ((tjv)localObject1).a = ((tjt)localObject3);
        return localObject1;
        label348:
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId;
        continue;
        label359:
        localObject1 = localObject3;
      }
    }
  }
  
  public uiw a(String paramString)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, tjy paramtjy)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Int += 1;
      a(bool, paramInt, paramtjy);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, tjy paramtjy);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tjg
 * JD-Core Version:    0.7.0.1
 */