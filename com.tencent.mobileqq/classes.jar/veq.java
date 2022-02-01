import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

class veq
  implements aaav<QQCircleProfile.SetUserSwitchRsp>
{
  veq(vep paramvep, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetUserSwitchRsp paramSetUserSwitchRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      vws.a(paramLong, this.jdField_a_of_type_Vep.a.a(), paramString, 0);
      return;
    }
    aaak.a().a(new QCircleGoToCardSettingEvent(this.jdField_a_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     veq
 * JD-Core Version:    0.7.0.1
 */