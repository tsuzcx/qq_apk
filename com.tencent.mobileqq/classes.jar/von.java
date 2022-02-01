import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

class von
  implements zxa<FeedCloudRead.StGetFollowListRsp>
{
  von(vol paramvol, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String arg4, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    QLog.d("QCircleSpecialFollowMgr", 1, "updateSpecialFollowList: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + ???);
    synchronized (this.jdField_a_of_type_Vol)
    {
      if (vol.b(this.jdField_a_of_type_Vol) != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Vol.b();
        return;
      }
      vol.a(this.jdField_a_of_type_Vol, false);
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowListRsp != null))
      {
        vol.a(this.jdField_a_of_type_Vol).obtainMessage(1003, new vos(paramStGetFollowListRsp, this.jdField_a_of_type_Int, null)).sendToTarget();
        return;
      }
    }
    vol.a(this.jdField_a_of_type_Vol).obtainMessage(1005).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     von
 * JD-Core Version:    0.7.0.1
 */