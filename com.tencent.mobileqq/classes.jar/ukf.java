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

final class ukf
  implements uni<vah, vcm>
{
  ukf(VideoListFeedItem paramVideoListFeedItem, List paramList, uro paramuro) {}
  
  public void a(@NonNull vah paramvah, @Nullable vcm paramvcm, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if ((paramvcm == null) || (paramErrorMessage.isFail())) {
      bool = true;
    }
    if ((!bool) && (paramvcm.a() != null) && (paramvcm.a().size() != 1)) {
      bool = true;
    }
    for (;;)
    {
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool) });
      paramvah = new ukn(false);
      paramvah.b = false;
      paramvah.jdField_a_of_type_JavaUtilArrayList = new ArrayList(1);
      paramErrorMessage = new ukm();
      paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      Object localObject;
      label176:
      StoryVideoItem localStoryVideoItem1;
      if (!bool)
      {
        localObject = (vcn)paramvcm.a().get(0);
        if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(((vcn)localObject).b))) {
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
        ukl localukl = new ukl();
        localukl.a = this.jdField_a_of_type_Uro.a(localStoryVideoItem1);
        paramErrorMessage.jdField_a_of_type_JavaUtilArrayList.add(localukl);
        if (bool) {
          break label176;
        }
        StoryVideoItem localStoryVideoItem2 = new StoryVideoItem();
        localStoryVideoItem2.copy(localStoryVideoItem1);
        List localList = paramvcm.a();
        localStoryVideoItem2.mVid = ((String)((vcn)localList.get(0)).a.get(localStoryVideoItem1.sourceVid));
        localStoryVideoItem2.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem2.mVid))
        {
          wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { localStoryVideoItem1.sourceVid, localList });
          xmh.a(localStoryVideoItem2.mVid);
          localStoryVideoItem2.mVid = StoryVideoItem.makeFakeVid();
        }
        localukl.b = this.jdField_a_of_type_Uro.a(localStoryVideoItem2);
        break label176;
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = new ShareGroupFeedItem();
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.copy(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId = ((vcn)localObject).b;
        if (paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount == 0) {
          paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.videoCount = 1;
        }
        xmh.a(((vcn)localObject).b);
        localObject = (wkp)urr.a(11);
        paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem = ((ShareGroupFeedItem)((wkp)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem));
        ((wkp)localObject).a(paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.ownerId, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.date, paramErrorMessage.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelShareGroupFeedItem.feedId);
        break;
      }
      label501:
      paramvah.jdField_a_of_type_JavaUtilArrayList.add(paramErrorMessage);
      uht.a().dispatch(paramvah);
      wsv.d("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { paramvah });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ukf
 * JD-Core Version:    0.7.0.1
 */