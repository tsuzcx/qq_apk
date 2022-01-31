import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class tkb
  extends tjx
  implements IEventReceiver
{
  private int jdField_a_of_type_Int;
  private final MemoriesFeedPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected swl a;
  private tjy jdField_a_of_type_Tjy;
  private tkc jdField_a_of_type_Tkc;
  
  public tkb(MemoriesFeedPlayInfo paramMemoriesFeedPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo = paramMemoriesFeedPlayInfo;
  }
  
  @NonNull
  public static List<tjt> b(List<VideoCollectionItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem != null) && (localVideoCollectionItem.collectionType == 1))
      {
        Object localObject = new tkd(localVideoCollectionItem.feedId);
        ((tkd)localObject).a = new uiw(localVideoCollectionItem.feedId, 0, localVideoCollectionItem.uin, String.valueOf(localVideoCollectionItem.collectionTime));
        localObject = new tjt((tjs)localObject);
        localArrayList.add(localObject);
        ((tjt)localObject).jdField_a_of_type_JavaUtilList = localVideoCollectionItem.videoVidList;
        Iterator localIterator = ((tjt)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((tjt)localObject).jdField_a_of_type_JavaUtilMap.put(str, localVideoCollectionItem.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public List<tjz> a(List<tjs> paramList)
  {
    return null;
  }
  
  public tjv a()
  {
    tkd localtkd = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId)) {
      localtkd = new tkd(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
    }
    return new tjv(localtkd, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType == 0) {}
    for (this.jdField_a_of_type_Swl = new swm(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext);; this.jdField_a_of_type_Swl = new tzf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext))
    {
      this.jdField_a_of_type_Tkc = new tkc(this);
      sgi.a().registerSubscriber(this.jdField_a_of_type_Tkc);
      vkw.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo);
      return;
    }
  }
  
  public void a(int paramInt, tjy paramtjy)
  {
    b(paramInt, paramtjy);
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b()
  {
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tkc);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(int paramInt, tjy paramtjy)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size() > 0))
    {
      spt localspt = (spt)sqg.a(19);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size());
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localspt.a((String)localIterator.next()));
      }
      paramtjy.b(new ErrorMessage(), b(localArrayList), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mIsEnd);
      return;
    }
    this.jdField_a_of_type_Tjy = paramtjy;
    this.jdField_a_of_type_Swl.c();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tkb
 * JD-Core Version:    0.7.0.1
 */