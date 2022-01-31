import android.os.Handler;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserSimpleInfo;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity;
import com.tencent.biz.qqstory.playvideo.QQStoryWatcherListActivity.GetWatcherHelper.1;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class vjb
  extends unj<vbz, vdk>
  implements uzb
{
  int jdField_a_of_type_Int = 0;
  public long a;
  public final QQStoryWatcherListActivity a;
  final String jdField_a_of_type_JavaLangString;
  List<qqstory_struct.UserSimpleInfo> jdField_a_of_type_JavaUtilList;
  final uza jdField_a_of_type_Uza;
  boolean jdField_a_of_type_Boolean = true;
  public long b;
  List<qqstory_struct.UserSimpleInfo> b;
  
  public vjb(QQStoryWatcherListActivity paramQQStoryWatcherListActivity, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity = paramQQStoryWatcherListActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Uza = new uza(this);
  }
  
  private void b()
  {
    if ((this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.isEmpty()))
    {
      QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
      return;
    }
    if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size())
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage return, currentReqSeek = " + this.jdField_a_of_type_Int + ", uinCount = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
      return;
    }
    this.jdField_b_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(this.jdField_a_of_type_Int, Math.min(this.jdField_a_of_type_Int + 20, this.jdField_a_of_type_JavaUtilList.size()));
    int i = this.jdField_b_of_type_JavaUtilList.size();
    if (this.jdField_b_of_type_JavaUtilList.isEmpty())
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage return, because toRequireList.isEmpty(), currentReqSeek = " + this.jdField_a_of_type_Int + ", uinCount = " + this.jdField_a_of_type_JavaUtilList.size());
      }
      QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, true, true, null);
      return;
    }
    Object localObject = (usd)urr.a(2);
    ArrayList localArrayList2 = new ArrayList(i);
    ArrayList localArrayList1 = new ArrayList(i);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8();
      QQUserUIItem localQQUserUIItem = ((usd)localObject).b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList2.add(new usy("", str));
      } else {
        localArrayList1.add(localQQUserUIItem);
      }
    }
    if (localArrayList2.isEmpty())
    {
      if (QLog.isDevelopLevel()) {
        QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage load localData userIDS = " + localArrayList2);
      }
      this.jdField_a_of_type_Int += i;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {}
      for (boolean bool = true;; bool = false)
      {
        QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool, localArrayList1);
        return;
      }
    }
    if (QLog.isDevelopLevel()) {
      QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherByPage requestUserIds = " + localArrayList2);
    }
    this.jdField_a_of_type_Uza.a(1, localArrayList2);
  }
  
  public void a()
  {
    vbz localvbz = new vbz();
    localvbz.b = this.jdField_a_of_type_JavaLangString;
    ung.a().a(localvbz, this);
    if (QLog.isDevelopLevel()) {
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherIds feedId = " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(uzc paramuzc)
  {
    boolean bool = true;
    if (QLog.isDevelopLevel()) {
      QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: onCallback errorInfo = " + paramuzc.a);
    }
    if (paramuzc.a.isSuccess())
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      Object localObject = (usd)urr.a(2);
      paramuzc = new ArrayList(i);
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = ((usd)localObject).b(((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8());
        if (localQQUserUIItem != null) {
          paramuzc.add(localQQUserUIItem);
        }
      }
      this.jdField_a_of_type_Int += i;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {}
      for (bool = true;; bool = false)
      {
        QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool, paramuzc);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_Boolean)
    {
      paramuzc = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {}
      for (;;)
      {
        QQStoryWatcherListActivity.b(paramuzc, false, bool, null);
        return;
        bool = false;
      }
    }
    new Handler(Looper.getMainLooper()).post(new QQStoryWatcherListActivity.GetWatcherHelper.1(this));
  }
  
  public void a(@NonNull vbz paramvbz, @Nullable vdk paramvdk, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: onResponseOnUIThread errorMsg = " + paramErrorMessage);
    }
    if ((paramErrorMessage.isSuccess()) && (paramvdk != null))
    {
      this.jdField_a_of_type_Long = paramvdk.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = paramvdk.jdField_b_of_type_Long;
      if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long) {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      }
      if (this.jdField_b_of_type_Long > 0L) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.setTitle(QQStoryWatcherListActivity.a() + xod.a(this.jdField_b_of_type_Long));
      }
      this.jdField_a_of_type_JavaUtilList = paramvdk.jdField_a_of_type_JavaUtilList;
      if (QLog.isDevelopLevel())
      {
        paramvbz = new StringBuilder().append("GetWatcherHelper: onResponseOnUIThread isSuccess mTotalWatcherCount = ").append(this.jdField_a_of_type_Long).append(", mTotalReadTime = ").append(this.jdField_b_of_type_Long).append(", uinCount = ");
        if (this.jdField_a_of_type_JavaUtilList != null) {
          break label244;
        }
      }
      for (;;)
      {
        QLog.w("Q.qqstory.player.watcherlist.activity", 2, i);
        if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem != null)
        {
          this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem.mViewTotalTime = this.jdField_b_of_type_Long;
          ((wkp)urr.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
        }
        b();
        return;
        label244:
        i = this.jdField_a_of_type_JavaUtilList.size();
      }
    }
    QQStoryWatcherListActivity.b(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity, false, false, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vjb
 * JD-Core Version:    0.7.0.1
 */