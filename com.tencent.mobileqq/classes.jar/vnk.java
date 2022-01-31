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

public final class vnk
  extends urs<vgi, vht>
  implements vdk
{
  int jdField_a_of_type_Int = 0;
  public long a;
  public final QQStoryWatcherListActivity a;
  final String jdField_a_of_type_JavaLangString;
  List<qqstory_struct.UserSimpleInfo> jdField_a_of_type_JavaUtilList;
  final vdj jdField_a_of_type_Vdj;
  boolean jdField_a_of_type_Boolean = true;
  public long b;
  List<qqstory_struct.UserSimpleInfo> b;
  
  public vnk(QQStoryWatcherListActivity paramQQStoryWatcherListActivity, String paramString)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity = paramQQStoryWatcherListActivity;
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_Vdj = new vdj(this);
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
    Object localObject = (uwm)uwa.a(2);
    ArrayList localArrayList2 = new ArrayList(i);
    ArrayList localArrayList1 = new ArrayList(i);
    Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext())
    {
      String str = ((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8();
      QQUserUIItem localQQUserUIItem = ((uwm)localObject).b(str);
      if ((localQQUserUIItem == null) || (!localQQUserUIItem.isAvailable())) {
        localArrayList2.add(new uxh("", str));
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
    this.jdField_a_of_type_Vdj.a(1, localArrayList2);
  }
  
  public void a()
  {
    vgi localvgi = new vgi();
    localvgi.b = this.jdField_a_of_type_JavaLangString;
    urp.a().a(localvgi, this);
    if (QLog.isDevelopLevel()) {
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: requireWatcherIds feedId = " + this.jdField_a_of_type_JavaLangString);
    }
  }
  
  public void a(vdl paramvdl)
  {
    boolean bool = true;
    if (QLog.isDevelopLevel()) {
      QLog.e("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: onCallback errorInfo = " + paramvdl.a);
    }
    if (paramvdl.a.isSuccess())
    {
      int i = this.jdField_b_of_type_JavaUtilList.size();
      Object localObject = (uwm)uwa.a(2);
      paramvdl = new ArrayList(i);
      Iterator localIterator = this.jdField_b_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        QQUserUIItem localQQUserUIItem = ((uwm)localObject).b(((qqstory_struct.UserSimpleInfo)localIterator.next()).union_id.get().toStringUtf8());
        if (localQQUserUIItem != null) {
          paramvdl.add(localQQUserUIItem);
        }
      }
      this.jdField_a_of_type_Int += i;
      localObject = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {}
      for (bool = true;; bool = false)
      {
        QQStoryWatcherListActivity.b((QQStoryWatcherListActivity)localObject, true, bool, paramvdl);
        return;
      }
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_Boolean)
    {
      paramvdl = this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity;
      if (this.jdField_a_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {}
      for (;;)
      {
        QQStoryWatcherListActivity.b(paramvdl, false, bool, null);
        return;
        bool = false;
      }
    }
    new Handler(Looper.getMainLooper()).post(new QQStoryWatcherListActivity.GetWatcherHelper.1(this));
  }
  
  public void a(@NonNull vgi paramvgi, @Nullable vht paramvht, @NonNull ErrorMessage paramErrorMessage)
  {
    int i = 0;
    if (QLog.isDevelopLevel()) {
      QLog.w("Q.qqstory.player.watcherlist.activity", 2, "GetWatcherHelper: onResponseOnUIThread errorMsg = " + paramErrorMessage);
    }
    if ((paramErrorMessage.isSuccess()) && (paramvht != null))
    {
      this.jdField_a_of_type_Long = paramvht.jdField_a_of_type_Long;
      this.jdField_b_of_type_Long = paramvht.jdField_b_of_type_Long;
      if (this.jdField_b_of_type_Long < this.jdField_a_of_type_Long) {
        this.jdField_b_of_type_Long = this.jdField_a_of_type_Long;
      }
      if (this.jdField_b_of_type_Long > 0L) {
        this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.setTitle(QQStoryWatcherListActivity.a() + xsm.a(this.jdField_b_of_type_Long));
      }
      this.jdField_a_of_type_JavaUtilList = paramvht.jdField_a_of_type_JavaUtilList;
      if (QLog.isDevelopLevel())
      {
        paramvgi = new StringBuilder().append("GetWatcherHelper: onResponseOnUIThread isSuccess mTotalWatcherCount = ").append(this.jdField_a_of_type_Long).append(", mTotalReadTime = ").append(this.jdField_b_of_type_Long).append(", uinCount = ");
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
          ((woy)uwa.a(11)).a(this.jdField_a_of_type_ComTencentBizQqstoryPlayvideoQQStoryWatcherListActivity.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelVideoListFeedItem);
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
 * Qualified Name:     vnk
 * JD-Core Version:    0.7.0.1
 */