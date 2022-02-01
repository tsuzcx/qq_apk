import com.tencent.biz.qqcircle.events.QCircleGoToCardSettingEvent;
import qqcircle.QQCircleProfile.SetUserSwitchRsp;

class vcn
  implements zxa<QQCircleProfile.SetUserSwitchRsp>
{
  vcn(vcm paramvcm, boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, long paramLong, String paramString, QQCircleProfile.SetUserSwitchRsp paramSetUserSwitchRsp)
  {
    if ((!paramBoolean) || (paramLong != 0L))
    {
      vtt.a(paramLong, this.jdField_a_of_type_Vcm.a.a(), paramString, 0);
      return;
    }
    zwp.a().a(new QCircleGoToCardSettingEvent(this.jdField_a_of_type_Boolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vcn
 * JD-Core Version:    0.7.0.1
 */