import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.entrance.MemoriesFeedPlayInfo;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

public class qha
  extends qgz.a
  implements IEventReceiver
{
  private final MemoriesFeedPlayInfo jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo;
  protected pxf a;
  private qgz.b jdField_a_of_type_Qgz$b;
  private qha.a jdField_a_of_type_Qha$a;
  private AtomicBoolean mIsDestroy = new AtomicBoolean(false);
  private int pageCount;
  
  public qha(MemoriesFeedPlayInfo paramMemoriesFeedPlayInfo)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo = paramMemoriesFeedPlayInfo;
  }
  
  @NonNull
  public static List<qgy.d> as(List<VideoCollectionItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      VideoCollectionItem localVideoCollectionItem = (VideoCollectionItem)paramList.next();
      if ((localVideoCollectionItem != null) && (localVideoCollectionItem.collectionType == 1))
      {
        Object localObject = new qha.b(localVideoCollectionItem.feedId);
        ((qha.b)localObject).a = new qvd(localVideoCollectionItem.feedId, 0, localVideoCollectionItem.uin, String.valueOf(localVideoCollectionItem.collectionTime));
        localObject = new qgy.d((qgy.c)localObject);
        localArrayList.add(localObject);
        ((qgy.d)localObject).nv = localVideoCollectionItem.videoVidList;
        Iterator localIterator = ((qgy.d)localObject).nv.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          ((qgy.d)localObject).fR.put(str, localVideoCollectionItem.feedId);
        }
      }
    }
    return localArrayList;
  }
  
  public void a(int paramInt, qgz.b paramb)
  {
    b(paramInt, paramb);
    this.pageCount += 1;
  }
  
  public List<qgz.c> ap(List<qgy.c> paramList)
  {
    return null;
  }
  
  public qgy.f b()
  {
    qha.b localb = null;
    if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId)) {
      localb = new qha.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
    }
    return new qgy.f(localb, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartVid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mStartFeedId);
  }
  
  public void b(int paramInt, qgz.b paramb)
  {
    if ((this.pageCount == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size() > 0))
    {
      psn localpsn = (psn)psx.a(19);
      ArrayList localArrayList = new ArrayList(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.size());
      Iterator localIterator = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mKeyList.iterator();
      while (localIterator.hasNext()) {
        localArrayList.add(localpsn.a((String)localIterator.next()));
      }
      paramb.b(new ErrorMessage(), as(localArrayList), this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mIsEnd);
      return;
    }
    this.jdField_a_of_type_Qgz$b = paramb;
    this.jdField_a_of_type_Pxf.aPh();
  }
  
  public void create()
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType == 0) {}
    for (this.jdField_a_of_type_Pxf = new pxg(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext);; this.jdField_a_of_type_Pxf = new qpu(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mUid, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mDataType, this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo.mContext))
    {
      this.jdField_a_of_type_Qha$a = new qha.a(this);
      pmi.a().registerSubscriber(this.jdField_a_of_type_Qha$a);
      rom.checkNotNull(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoEntranceMemoriesFeedPlayInfo);
      return;
    }
  }
  
  public void destroy()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qha$a);
    this.mIsDestroy.set(true);
  }
  
  public boolean isValidate()
  {
    return !this.mIsDestroy.get();
  }
  
  static class a
    extends QQUIEventReceiver<qha, pxg.b>
  {
    public a(@NonNull qha paramqha)
    {
      super();
    }
    
    public void a(@NonNull qha paramqha, @NonNull pxg.b paramb)
    {
      if ((!TextUtils.equals(qha.a(paramqha).mContext, paramb.context)) || (qha.a(paramqha) == null)) {
        return;
      }
      if (paramb.b.isFail())
      {
        ram.b(this.TAG, "pull feedId list fail %s", paramb.b.errorMsg);
        qha.a(paramqha).a(new ErrorMessage(paramb.b.errorCode, paramb.b.errorMsg), null, false);
        return;
      }
      qha.a(paramqha).mIsEnd = paramb.isEnd;
      qha.a(paramqha).b(new ErrorMessage(), qha.as(paramb.mL), paramb.isEnd);
    }
    
    public Class acceptEventClass()
    {
      return pxg.b.class;
    }
  }
  
  public static class b
    extends qgy.c
  {
    public qvd a;
    
    public b(String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qha
 * JD-Core Version:    0.7.0.1
 */