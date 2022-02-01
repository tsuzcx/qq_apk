import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

class voo
  implements zxa<FeedCloudRead.StGetFollowListRsp>
{
  voo(vol paramvol, vor paramvor) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    QLog.d("QCircleSpecialFollowMgr", 1, "loadMoreSpecialFollowList: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowListRsp != null))
    {
      vol.a(this.jdField_a_of_type_Vol).obtainMessage(1004, new vos(paramStGetFollowListRsp, vor.a(this.jdField_a_of_type_Vor), null)).sendToTarget();
      return;
    }
    vol.a(this.jdField_a_of_type_Vol).obtainMessage(1005).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     voo
 * JD-Core Version:    0.7.0.1
 */