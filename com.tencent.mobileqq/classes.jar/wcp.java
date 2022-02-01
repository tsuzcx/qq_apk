import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.ShareGroupFeedItem;
import com.tencent.biz.qqstory.storyHome.model.VideoListFeedItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class wcp
  implements wfk<wsi, wun>
{
  wcp(VideoListFeedItem paramVideoListFeedItem, List paramList, wjp paramwjp) {}
  
  public void a(@NonNull wsi paramwsi, @Nullable wun paramwun, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if ((paramwun == null) || (paramErrorMessage.isFail())) {
      bool = true;
    }
    if ((!bool) && (paramwun.a() != null) && (paramwun.a().size() != 1)) {
      bool = true;
    }
    for (;;)
    {
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool) });
      paramwsi = new wcx(false);
      paramwsi.b = false;
      paramwsi.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
      paramErrorMessage = new wcw();
      paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      Object localObject;
      label176:
      StoryVideoItem localStoryVideoItem1;
      if (!bool)
      {
        localObject = (wuo)paramwun.a().get(0);
        if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(((wuo)localObject).b))) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        }
      }
      else
      {
        localObject = this.jdField_a_of_type_JavaUtilList.iterator();
        if (!((Iterator)localObject).hasNext()) {
          break label501;
        }
        localStoryVideoItem1 = (StoryVideoItem)((Iterator)localObject).next();
        if (!bool) {
          break label495;
        }
      }
      label495:
      for (int i = 6;; i = 5)
      {
        localStoryVideoItem1.mUploadStatus = i;
        wcv localwcv = new wcv();
        localwcv.a = this.jdField_a_of_type_Wjp.a(localStoryVideoItem1);
        paramErrorMessage.jdField_a_of_type_JavaUtilArrayList.add(localwcv);
        if (bool) {
          break label176;
        }
        StoryVideoItem localStoryVideoItem2 = new StoryVideoItem();
        localStoryVideoItem2.copy(localStoryVideoItem1);
        List localList = paramwun.a();
        localStoryVideoItem2.mVid = ((String)((wuo)localList.get(0)).a.get(localStoryVideoItem1.sourceVid));
        localStoryVideoItem2.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem2.mVid))
        {
          ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { localStoryVideoItem1.sourceVid, localList });
          zdl.a(localStoryVideoItem2.mVid);
          localStoryVideoItem2.mVid = StoryVideoItem.makeFakeVid();
        }
        localwcv.b = this.jdField_a_of_type_Wjp.a(localStoryVideoItem2);
        break label176;
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = ((wuo)localObject).b;
        if (paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount == 0) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount = 1;
        }
        zdl.a(((wuo)localObject).b);
        localObject = (yck)wjs.a(11);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((yck)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem));
        ((yck)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        break;
      }
      label501:
      paramwsi.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
      wad.a().dispatch(paramwsi);
      ykq.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { paramwsi });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wcp
 * JD-Core Version:    0.7.0.1
 */