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

public abstract class vkr<INFO extends FeedBasePlayInfo>
  extends vli
{
  private static List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  final INFO jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  public wkl a;
  
  public vkr(INFO paramINFO)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramINFO;
    xmh.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
  }
  
  private static int b(vks paramvks, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    int i = 0;
    int j = 0;
    if (paramvks.a == null) {
      return j;
    }
    j = paramvks.a.b;
    if (j == -1) {
      if (!xmq.a(paramvks.a.c)) {}
    }
    for (;;)
    {
      j = i;
      if (!paramFeedBasePlayInfo.mForcePlayVidFromOld2New) {
        break;
      }
      j = i;
      if (!paramvks.equals(new vks(paramFeedBasePlayInfo.mFeedFeedId, null))) {
        break;
      }
      return 1;
      i = 1;
      continue;
      i = j;
    }
  }
  
  @NonNull
  static List<vld> b(List<wkh> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wkh localwkh = (wkh)paramList.next();
      if (localwkh.jdField_a_of_type_Boolean) {
        localArrayList.add(new vks(localwkh.jdField_a_of_type_JavaLangString, localwkh));
      } else {
        wsv.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localwkh.jdField_a_of_type_JavaLangString });
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private static vle b(List<StoryVideoItem> paramList, String paramString, vks paramvks)
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
    paramList = new vle(paramvks);
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_JavaUtilMap = localHashMap;
    wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return group=%s vid %d, list %s", paramvks, Integer.valueOf(localArrayList.size()), localArrayList);
    return paramList;
  }
  
  public List<vlk> a(List<vld> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new vkt((vks)paramList.next(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo));
    }
    return localArrayList;
  }
  
  public vlg a()
  {
    Object localObject4 = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId)) {}
    for (vks localvks = new vks(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId));; localvks = null)
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
          FeedVideoInfo localFeedVideoInfo = ((wkv)urr.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, 1);
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
        wsv.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start vid:%s feedId:%s", new Object[] { localObject5, localObject1 });
        localObject2 = localObject1;
        localObject1 = localObject5;
        localObject3 = localObject4;
        if (localvks != null)
        {
          localObject3 = localObject4;
          if (localvks.a != null)
          {
            int i = b(localvks, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
            localObject5 = ((wkv)urr.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, i);
            localObject3 = localObject4;
            if (localObject5 != null)
            {
              localObject3 = localObject4;
              if (((FeedVideoInfo)localObject5).mIsVideoEnd)
              {
                localObject3 = localObject4;
                if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache)
                {
                  localObject3 = b(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, localvks);
                  wsv.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
                }
              }
            }
          }
        }
        localObject1 = new vlg(localvks, (String)localObject1, localObject2);
        ((vlg)localObject1).a = ((vle)localObject3);
        return localObject1;
        label348:
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId;
        continue;
        label359:
        localObject1 = localObject3;
      }
    }
  }
  
  public wkh a(String paramString)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, vlj paramvlj)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Int += 1;
      a(bool, paramInt, paramvlj);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, vlj paramvlj);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vkr
 * JD-Core Version:    0.7.0.1
 */