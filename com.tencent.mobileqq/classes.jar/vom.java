import android.os.Handler;
import android.os.Message;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudWrite.StDoFollowRsp;

class vom
  implements zxa<FeedCloudWrite.StDoFollowRsp>
{
  vom(vol paramvol, boolean paramBoolean, String paramString) {}
  
  public void a(boolean paramBoolean, long paramLong, String arg4, FeedCloudWrite.StDoFollowRsp paramStDoFollowRsp)
  {
    QLog.d("QCircleSpecialFollowMgr", 1, "doSpecialFollow: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + ???);
    if ((paramBoolean) && (paramLong == 0L)) {}
    for (int i = 1; i == 0; i = 0)
    {
      vol.a(this.jdField_a_of_type_Vol, "设置失败", false);
      return;
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Vol)
      {
        vol.a(this.jdField_a_of_type_Vol);
        vol.a(this.jdField_a_of_type_Vol, "设置成功", true);
        ??? = vol.a(this.jdField_a_of_type_Vol);
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
 * Qualified Name:     vom
 * JD-Core Version:    0.7.0.1
 */