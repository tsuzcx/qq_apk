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

final class pnz
  implements ppv.b<pyh, pzx>
{
  pnz(VideoListFeedItem paramVideoListFeedItem, List paramList, psu parampsu) {}
  
  public void a(@NonNull pyh parampyh, @Nullable pzx parampzx, @NonNull ErrorMessage paramErrorMessage)
  {
    boolean bool = false;
    if ((parampzx == null) || (paramErrorMessage.isFail())) {
      bool = true;
    }
    if ((!bool) && (parampzx.bN() != null) && (parampzx.bN().size() != 1)) {
      bool = true;
    }
    for (;;)
    {
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "add share group fail:%b", new Object[] { Boolean.valueOf(bool) });
      parampyh = new pnx.d(false);
      parampyh.aAU = false;
      parampyh.my = new ArrayList(1);
      paramErrorMessage = new pnx.c();
      paramErrorMessage.b = this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem;
      Object localObject;
      label176:
      StoryVideoItem localStoryVideoItem1;
      if (!bool)
      {
        localObject = (pzx.a)parampzx.bN().get(0);
        if (((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem instanceof ShareGroupFeedItem)) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.feedId.equals(((pzx.a)localObject).feedId))) {
          paramErrorMessage.a = ((ShareGroupFeedItem)this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        }
      }
      else
      {
        localObject = this.mq.iterator();
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
        pnx.b localb = new pnx.b();
        localb.b = this.jdField_a_of_type_Psu.a(localStoryVideoItem1);
        paramErrorMessage.hq.add(localb);
        if (bool) {
          break label176;
        }
        StoryVideoItem localStoryVideoItem2 = new StoryVideoItem();
        localStoryVideoItem2.copy(localStoryVideoItem1);
        List localList = parampzx.bN();
        localStoryVideoItem2.mVid = ((String)((pzx.a)localList.get(0)).fN.get(localStoryVideoItem1.sourceVid));
        localStoryVideoItem2.mVideoIndex = 0L;
        if (TextUtils.isEmpty(localStoryVideoItem2.mVid))
        {
          ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "cannot find true vid for sourceVid=%s, %s", new Object[] { localStoryVideoItem1.sourceVid, localList });
          rom.sF(localStoryVideoItem2.mVid);
          localStoryVideoItem2.mVid = StoryVideoItem.makeFakeVid();
        }
        localb.c = this.jdField_a_of_type_Psu.a(localStoryVideoItem2);
        break label176;
        paramErrorMessage.a = new ShareGroupFeedItem();
        paramErrorMessage.a.copy(paramErrorMessage.b);
        paramErrorMessage.a.feedId = ((pzx.a)localObject).feedId;
        if (paramErrorMessage.a.videoCount == 0) {
          paramErrorMessage.a.videoCount = 1;
        }
        rom.sF(((pzx.a)localObject).feedId);
        localObject = (qvf)psx.a(11);
        paramErrorMessage.a = ((ShareGroupFeedItem)((qvf)localObject).a(paramErrorMessage.a));
        ((qvf)localObject).O(paramErrorMessage.a.ownerId, paramErrorMessage.a.date, paramErrorMessage.a.feedId);
        break;
      }
      label501:
      parampyh.my.add(paramErrorMessage);
      pmi.a().dispatch(parampyh);
      ram.w("Q.qqstory.publish.upload:StoryVideoUploadManager", "add shareGroup video return: %s", new Object[] { parampyh });
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     pnz
 * JD-Core Version:    0.7.0.1
 */