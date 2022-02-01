import com.tencent.biz.qqcircle.events.QCircleSyncToTroopSettingEvent;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

class ves
  implements aaav<QQCircleProfile.SetUserSwitchRsp>
{
  ves(ver paramver, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetUserSwitchRsp paramSetUserSwitchRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      vws.a(paramLong, this.jdField_a_of_type_Ver.a.a(), paramString, 0);
      return;
    }
    aaak.a().a(new QCircleSyncToTroopSettingEvent(this.jdField_a_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ves
 * JD-Core Version:    0.7.0.1
 */