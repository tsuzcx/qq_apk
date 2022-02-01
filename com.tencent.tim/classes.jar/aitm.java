import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aitm
  implements aiqs.b
{
  aitm(aitg paramaitg, LocationRoom.Venue paramVenue) {}
  
  public void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] setVenue: onResult. roomKey: " + paramb + " venue: " + paramVenue + " mRoomKey: " + aitg.a(this.jdField_b_of_type_Aitg) + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramb.equals(aitg.a(this.jdField_b_of_type_Aitg))) || (paramVenue == null)) {
      return;
    }
    aitg.a(this.jdField_b_of_type_Aitg).setVenueOprating(false);
    aitg.a(this.jdField_b_of_type_Aitg).setVisibility(8);
    if (paramBoolean)
    {
      aitg.a(this.jdField_b_of_type_Aitg).setVenue(this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
      QQToast.a(aitg.a(this.jdField_b_of_type_Aitg), 2, "集合点设置成功", 0).show();
      anot.a(null, "CliOper", "", "", "0X800A964", "0X800A964", 0, 0, "0", "0", "0", "");
      return;
    }
    switch (paramInt2)
    {
    default: 
      QQToast.a(aitg.a(this.jdField_b_of_type_Aitg), 1, "设置失败，请稍后重试", 0).show();
      if (aitg.a(this.jdField_b_of_type_Aitg).a() != null) {
        aitg.a(this.jdField_b_of_type_Aitg);
      }
      break;
    }
    for (;;)
    {
      if ((paramInt2 != 10001) && (paramInt2 != 10003) && (paramInt2 != 10004) && (paramInt2 != 10100)) {
        break label389;
      }
      anot.a(null, "CliOper", "", "", "0X800A965", "0X800A965", 2, 0, "0", "0", "0", "");
      return;
      QQToast.a(aitg.a(this.jdField_b_of_type_Aitg), 1, "你已离开共享会话", 0).show();
      aitg.a(this.jdField_b_of_type_Aitg).finish();
      break;
      QQToast.a(aitg.a(this.jdField_b_of_type_Aitg), 1, "已有人设置集合点", 0).show();
      break;
      aitg.b(this.jdField_b_of_type_Aitg);
    }
    label389:
    anot.a(null, "CliOper", "", "", "0X800A965", "0X800A965", 1, 0, "0", "0", "0", "");
  }
  
  public Pair<LocationRoom.b, LocationRoom.Venue> p()
  {
    return new Pair(aitg.a(this.jdField_b_of_type_Aitg), this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitm
 * JD-Core Version:    0.7.0.1
 */