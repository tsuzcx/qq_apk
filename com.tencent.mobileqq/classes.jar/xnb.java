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

public class xnb
  extends xmx
  implements IEventReceiver
{
  private int jdField_a_of_type_Int;
  private final MemoriesFeedPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected wzm a;
  private xmy jdField_a_of_type_Xmy;
  private xnc jdField_a_of_type_Xnc;
  
  public xnb(MemoriesFeedPlayInfo paramMemoriesFeedPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo = paramMemoriesFeedPlayInfo;
  }
  
  @NonNull
  public static List<xmt> b(List<VideoCollectionItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem != null) && (localVideoCollectionItem.collectionType == 1))
      {
        Object localObject = new xnd(localVideoCollectionItem.feedId);
        ((xnd)localObject).a = new ylw(localVideoCollectionItem.feedId, 0, localVideoCollectionItem.uin, String.valueOf(localVideoCollectionItem.collectionTime));
        localObject = new xmt((xms)localObject);
        localArrayList.add(localObject);
        ((xmt)localObject).jdField_a_of_type_JavaUtilList = localVideoCollectionItem.videoVidList;
        Iterator localIterator = ((xmt)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((xmt)localObject).jdField_a_of_type_JavaUtilMap.put(str, localVideoCollectionItem.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public List<xmz> a(List<xms> paramList)
  {
    return null;
  }
  
  public xmv a()
  {
    xnd localxnd = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId)) {
      localxnd = new xnd(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
    }
    return new xmv(localxnd, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType == 0) {}
    for (this.jdField_a_of_type_Wzm = new wzn(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext);; this.jdField_a_of_type_Wzm = new ycf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext))
    {
      this.jdField_a_of_type_Xnc = new xnc(this);
      wjj.a().registerSubscriber(this.jdField_a_of_type_Xnc);
      znw.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo);
      return;
    }
  }
  
  public void a(int paramInt, xmy paramxmy)
  {
    b(paramInt, paramxmy);
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b()
  {
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xnc);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(int paramInt, xmy paramxmy)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size() > 0))
    {
      wsu localwsu = (wsu)wth.a(19);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size());
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localwsu.a((String)localIterator.next()));
      }
      paramxmy.b(new ErrorMessage(), b(localArrayList), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mIsEnd);
      return;
    }
    this.jdField_a_of_type_Xmy = paramxmy;
    this.jdField_a_of_type_Wzm.c();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xnb
 * JD-Core Version:    0.7.0.1
 */