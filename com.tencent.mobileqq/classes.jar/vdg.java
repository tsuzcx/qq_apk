import com.tencent.TMG.utils.QLog;
import com.tencent.biz.qqcircle.events.QCircleFeedEvent;
import com.tencent.mobileqq.widget.QQToast;
import qqcircle.QQCircleRight.SetCircleUnCareRsp;

class vdg
  implements zxa<QQCircleRight.SetCircleUnCareRsp>
{
  vdg(vde paramvde, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleRight.SetCircleUnCareRsp paramSetCircleUnCareRsp)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QCircleSharePart", 1, "uncare person: isSuccess" + paramBoolean + "retCode:" + paramLong + "    errMsg:" + paramString);
    }
    if ((paramBoolean) && (paramLong == 0L))
    {
      if (this.jdField_a_of_type_Boolean) {
        QQToast.a(this.jdField_a_of_type_Vde.a(), 2, 2131697134, 0).a();
      }
      zwp.a().a(new QCircleFeedEvent("", 6));
      return;
    }
    QQToast.a(this.jdField_a_of_type_Vde.a(), 1, 2131697212, 0).a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vdg
 * JD-Core Version:    0.7.0.1
 */