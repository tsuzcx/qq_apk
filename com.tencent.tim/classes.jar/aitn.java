import android.util.Pair;
import android.view.View;
import com.tencent.mobileqq.location.data.LocationRoom.Venue;
import com.tencent.mobileqq.location.data.LocationRoom.b;
import com.tencent.mobileqq.location.ui.MapWidget;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;

class aitn
  implements aiqs.b
{
  aitn(aitg paramaitg, LocationRoom.Venue paramVenue) {}
  
  public void b(LocationRoom.b paramb, LocationRoom.Venue paramVenue, int paramInt1, boolean paramBoolean, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LocationShareController", 2, new Object[] { "[venue] removeVenue: onResult. roomKey: " + paramb + " optType: " + paramInt1, " isSuccess: " + paramBoolean + " errorCode: " + paramInt2 });
    }
    if ((!paramb.equals(aitg.a(this.jdField_b_of_type_Aitg))) || (aitg.a(this.jdField_b_of_type_Aitg).a() == null) || (paramVenue == null) || (!aitg.a(this.jdField_b_of_type_Aitg).a().equals(paramVenue))) {
      return;
    }
    aitg.a(this.jdField_b_of_type_Aitg).setVenueOprating(false);
    aitg.a(this.jdField_b_of_type_Aitg).setVisibility(8);
    if (paramBoolean)
    {
      aitg.a(this.jdField_b_of_type_Aitg).setVenue(null);
      aitg.b(this.jdField_b_of_type_Aitg);
      anot.a(null, "CliOper", "", "", "0X800A969", "0X800A969", 0, 0, "0", "0", "0", "");
      return;
    }
    QQToast.a(aitg.a(this.jdField_b_of_type_Aitg), 1, "移除失败，请稍后重试", 0).show();
    if ((paramInt2 == 10001) || (paramInt2 == 10003) || (paramInt2 == 10004) || (paramInt2 == 10100))
    {
      anot.a(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 2, 0, "0", "0", "0", "");
      return;
    }
    anot.a(null, "CliOper", "", "", "0X800A96A", "0X800A96A", 1, 0, "0", "0", "0", "");
  }
  
  public Pair<LocationRoom.b, LocationRoom.Venue> p()
  {
    return new Pair(aitg.a(this.jdField_b_of_type_Aitg), this.jdField_b_of_type_ComTencentMobileqqLocationDataLocationRoom$Venue);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aitn
 * JD-Core Version:    0.7.0.1
 */