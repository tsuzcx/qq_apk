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

public abstract class xcm<INFO extends FeedBasePlayInfo>
  extends xdd
{
  private static List<StoryVideoItem> jdField_a_of_type_JavaUtilList;
  private int jdField_a_of_type_Int;
  final INFO jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo;
  public ycg a;
  
  public xcm(INFO paramINFO)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo = paramINFO;
    zdl.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
  }
  
  private static int b(xcn paramxcn, FeedBasePlayInfo paramFeedBasePlayInfo)
  {
    int i = 0;
    int j = 0;
    if (paramxcn.a == null) {
      return j;
    }
    j = paramxcn.a.b;
    if (j == -1) {
      if (!zdu.a(paramxcn.a.c)) {}
    }
    for (;;)
    {
      j = i;
      if (!paramFeedBasePlayInfo.mForcePlayVidFromOld2New) {
        break;
      }
      j = i;
      if (!paramxcn.equals(new xcn(paramFeedBasePlayInfo.mFeedFeedId, null))) {
        break;
      }
      return 1;
      i = 1;
      continue;
      i = j;
    }
  }
  
  @NonNull
  static List<xcy> b(List<ycc> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ycc localycc = (ycc)paramList.next();
      if (localycc.jdField_a_of_type_Boolean) {
        localArrayList.add(new xcn(localycc.jdField_a_of_type_JavaLangString, localycc));
      } else {
        ykq.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "ignore feed:%s for not playable", new Object[] { localycc.jdField_a_of_type_JavaLangString });
      }
    }
    return localArrayList;
  }
  
  @NonNull
  private static xcz b(List<StoryVideoItem> paramList, String paramString, xcn paramxcn)
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
    paramList = new xcz(paramxcn);
    paramList.jdField_a_of_type_JavaUtilList = localArrayList;
    paramList.jdField_a_of_type_JavaUtilMap = localHashMap;
    ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "return group=%s vid %d, list %s", paramxcn, Integer.valueOf(localArrayList.size()), localArrayList);
    return paramList;
  }
  
  public List<xdf> a(List<xcy> paramList)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    paramList = paramList.iterator();
    while (paramList.hasNext()) {
      localArrayList.add(new xco((xcn)paramList.next(), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo));
    }
    return localArrayList;
  }
  
  public xdb a()
  {
    Object localObject4 = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId)) {}
    for (xcn localxcn = new xcn(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId));; localxcn = null)
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
          FeedVideoInfo localFeedVideoInfo = ((ycq)wjs.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, 1);
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
        ykq.d("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start vid:%s feedId:%s", new Object[] { localObject5, localObject1 });
        localObject2 = localObject1;
        localObject1 = localObject5;
        localObject3 = localObject4;
        if (localxcn != null)
        {
          localObject3 = localObject4;
          if (localxcn.a != null)
          {
            int i = b(localxcn, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo);
            localObject5 = ((ycq)wjs.a(12)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId, i);
            localObject3 = localObject4;
            if (localObject5 != null)
            {
              localObject3 = localObject4;
              if (((FeedVideoInfo)localObject5).mIsVideoEnd)
              {
                localObject3 = localObject4;
                if (!this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mForceNotUseVidCache)
                {
                  localObject3 = b(((FeedVideoInfo)localObject5).mVideoItemList, ((FeedVideoInfo)localObject5).feedId, localxcn);
                  ykq.a("Q.qqstory.player.data.FeedIdBasePlayPageLoader", "fast start hit group info cache %s", localObject3);
                }
              }
            }
          }
        }
        localObject1 = new xdb(localxcn, (String)localObject1, localObject2);
        ((xdb)localObject1).a = ((xcz)localObject3);
        return localObject1;
        label348:
        localObject1 = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceFeedBasePlayInfo.mFeedFeedId;
        continue;
        label359:
        localObject1 = localObject3;
      }
    }
  }
  
  public ycc a(String paramString)
  {
    return null;
  }
  
  public void a() {}
  
  public void a(int paramInt, xde paramxde)
  {
    if (this.jdField_a_of_type_Int == 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Int += 1;
      a(bool, paramInt, paramxde);
      return;
    }
  }
  
  public abstract void a(boolean paramBoolean, int paramInt, xde paramxde);
  
  public void b() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xcm
 * JD-Core Version:    0.7.0.1
 */