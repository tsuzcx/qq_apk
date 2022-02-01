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

final class wlv
  implements woy<xbx, xec>
{
  wlv(VideoListFeedItem paramVideoListFeedItem, List paramList, wte paramwte) {}
  
  public void a(@NonNull xbx paramxbx, @Nullable xec paramxec, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if ((paramxec == null) || (paramErrorMessage.isFail())) {
      bool = true;
    }
    if ((!bool) && (paramxec.a() != null) && (paramxec.a().size() != 1)) {
      bool = true;
    }
    for (;;)
    {
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool) });
      paramxbx = new wmd(false);
      paramxbx.b = false;
      paramxbx.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
      paramErrorMessage = new wmc();
      paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      Object localObject;
      label176:
      StoryVideoItem localStoryVideoItem1;
      if (!bool)
      {
        localObject = (xed)paramxec.a().get(0);
        if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(((xed)localObject).b))) {
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
        wmb localwmb = new wmb();
        localwmb.a = this.jdField_a_of_type_Wte.a(localStoryVideoItem1);
        paramErrorMessage.jdField_a_of_type_JavaUtilArrayList.add(localwmb);
        if (bool) {
          break label176;
        }
        StoryVideoItem localStoryVideoItem2 = new StoryVideoItem();
        localStoryVideoItem2.copy(localStoryVideoItem1);
        List localList = paramxec.a();
        localStoryVideoItem2.mVid = ((String)((xed)localList.get(0)).a.get(localStoryVideoItem1.sourceVid));
        localStoryVideoItem2.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem2.mVid))
        {
          yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { localStoryVideoItem1.sourceVid, localList });
          znw.a(localStoryVideoItem2.mVid);
          localStoryVideoItem2.mVid = StoryVideoItem.makeFakeVid();
        }
        localwmb.b = this.jdField_a_of_type_Wte.a(localStoryVideoItem2);
        break label176;
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = ((xed)localObject).b;
        if (paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount == 0) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount = 1;
        }
        znw.a(((xed)localObject).b);
        localObject = (yme)wth.a(11);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((yme)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem));
        ((yme)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        break;
      }
      label501:
      paramxbx.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
      wjj.a().dispatch(paramxbx);
      yuk.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { paramxbx });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     wlv
 * JD-Core Version:    0.7.0.1
 */