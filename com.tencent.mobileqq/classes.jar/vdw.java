import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import feedcloud.FeedCloudMeta.StUser;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class vdw
  implements aaav<QQCircleRight.SetCircleUnCareRsp>
{
  vdw(vdv paramvdv) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCirclePersonalTitleBar", 1, "black person: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      QQToast.a(this.a.a.a(), 2, 2131697168, 0).a();
      this.a.a.a(vdr.a(this.a.a).id.get());
      return;
    }
    QQToast.a(this.a.a.a(), 1, 2131697280, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdw
 * JD-Core Version:    0.7.0.1
 */