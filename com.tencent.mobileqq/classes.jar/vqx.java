import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudRead.StGetFollowListRsp;

class vqx
  implements aaav<FeedCloudRead.StGetFollowListRsp>
{
  vqx(vqu paramvqu, vra paramvra) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, FeedCloudRead.StGetFollowListRsp paramStGetFollowListRsp)
  {
    QLog.d("QCircleSpecialFollowMgr", 1, "loadMoreSpecialFollowList: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    if ((paramBoolean) && (paramLong == 0L) && (paramStGetFollowListRsp != null))
    {
      vqu.a(this.jdField_a_of_type_Vqu).obtainMessage(1004, new vrb(paramStGetFollowListRsp, vra.a(this.jdField_a_of_type_Vra), null)).sendToTarget();
      return;
    }
    vqu.a(this.jdField_a_of_type_Vqu).obtainMessage(1005).sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqx
 * JD-Core Version:    0.7.0.1
 */