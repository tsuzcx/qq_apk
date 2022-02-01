import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

class vqv
  implements aaav<FeedCloudWrite.StDoFollowRsp>
{
  vqv(vqu paramvqu, boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String arg4, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.d("QCircleSpecialFollowMgr", 1, "doSpecialFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + ???);
    if ((paramBoolean) && (paramLong == 0L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      vqu.a(this.jdField_a_of_type_Vqu, "设置失败", false);
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Vqu)
      {
        vqu.a(this.jdField_a_of_type_Vqu);
        vqu.a(this.jdField_a_of_type_Vqu, "设置成功", true);
        ??? = vqu.a(this.jdField_a_of_type_Vqu);
        if (this.jdField_a_of_type_Boolean)
        {
          i = 1001;
          ???.obtainMessage(i, this.jdField_a_of_type_JavaLangString).sendToTarget();
          return;
        }
      }
      i = 1002;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vqv
 * JD-Core Version:    0.7.0.1
 */