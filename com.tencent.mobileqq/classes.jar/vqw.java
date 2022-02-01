import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

class vqw
  implements aaav<FeedCloudRead.StGetFollowListRsp>
{
  vqw(vqu paramvqu, int paramInt) {}
  
  public void a(boolean paramBoolean, long paramLong, String arg4, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    QLog.d("QCircleSpecialFollowMgr", 1, "updateSpecialFollowList: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + ???);
    synchronized (this.jdField_a_of_type_Vqu)
    {
      if (vqu.b(this.jdField_a_of_type_Vqu) != this.jdField_a_of_type_Int)
      {
        this.jdField_a_of_type_Vqu.b();
        return;
      }
      vqu.a(this.jdField_a_of_type_Vqu, false);
      if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowListRsp != null))
      {
        vqu.a(this.jdField_a_of_type_Vqu).obtainMessage(1003, new vrb(paramStGetFollowListRsp, this.jdField_a_of_type_Int, null)).sendToTarget();
        return;
      }
    }
    vqu.a(this.jdField_a_of_type_Vqu).obtainMessage(1005).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqw
 * JD-Core Version:    0.7.0.1
 */