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

public class twu
  extends twq
  implements IEventReceiver
{
  private int jdField_a_of_type_Int;
  private final MemoriesFeedPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo;
  private AtomicBoolean jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean = new AtomicBoolean(false);
  protected tje a;
  private twr jdField_a_of_type_Twr;
  private twv jdField_a_of_type_Twv;
  
  public twu(MemoriesFeedPlayInfo paramMemoriesFeedPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo = paramMemoriesFeedPlayInfo;
  }
  
  @NonNull
  public static List<twm> b(List<VideoCollectionItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem != null) && (localVideoCollectionItem.collectionType == 1))
      {
        Object localObject = new tww(localVideoCollectionItem.feedId);
        ((tww)localObject).a = new uvp(localVideoCollectionItem.feedId, 0, localVideoCollectionItem.uin, String.valueOf(localVideoCollectionItem.collectionTime));
        localObject = new twm((twl)localObject);
        localArrayList.add(localObject);
        ((twm)localObject).jdField_a_of_type_JavaUtilList = localVideoCollectionItem.videoVidList;
        Iterator localIterator = ((twm)localObject).jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((twm)localObject).jdField_a_of_type_JavaUtilMap.put(str, localVideoCollectionItem.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public List<tws> a(List<twl> paramList)
  {
    return null;
  }
  
  public two a()
  {
    tww localtww = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId)) {
      localtww = new tww(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
    }
    return new two(localtww, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType == 0) {}
    for (this.jdField_a_of_type_Tje = new tjf(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext);; this.jdField_a_of_type_Tje = new uly(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext))
    {
      this.jdField_a_of_type_Twv = new twv(this);
      stb.a().registerSubscriber(this.jdField_a_of_type_Twv);
      vxp.a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo);
      return;
    }
  }
  
  public void a(int paramInt, twr paramtwr)
  {
    b(paramInt, paramtwr);
    this.jdField_a_of_type_Int += 1;
  }
  
  public void b()
  {
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Twv);
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.set(true);
  }
  
  public void b(int paramInt, twr paramtwr)
  {
    if ((this.jdField_a_of_type_Int == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size() > 0))
    {
      tcm localtcm = (tcm)tcz.a(19);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size());
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localtcm.a((String)localIterator.next()));
      }
      paramtwr.b(new ErrorMessage(), b(localArrayList), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mIsEnd);
      return;
    }
    this.jdField_a_of_type_Twr = paramtwr;
    this.jdField_a_of_type_Tje.c();
  }
  
  public boolean isValidate()
  {
    return !this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicBoolean.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twu
 * JD-Core Version:    0.7.0.1
 */