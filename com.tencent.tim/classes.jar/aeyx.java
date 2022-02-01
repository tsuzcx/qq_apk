import android.annotation.TargetApi;
import android.widget.LinearLayout;
import com.tencent.ark.ArkViewImplement.LoadCallback;
import com.tencent.mobileqq.data.ArkBabyqCardInfo;
import com.tencent.qphone.base.util.QLog;

public class aeyx
  implements ArkViewImplement.LoadCallback
{
  public aeyx(ArkBabyqCardInfo paramArkBabyqCardInfo, adrd.a parama, adrd paramadrd, wyv paramwyv, int paramInt) {}
  
  @TargetApi(14)
  public void onLoadFailed(int paramInt1, int paramInt2, String paramString, boolean paramBoolean)
  {
    onLoadState(paramInt1);
  }
  
  @TargetApi(14)
  public void onLoadState(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ArkBabyqCardInfo", 2, "attachArkView onLoadFinish ArkBabyqCardInfo state=" + paramInt);
    }
    if (paramInt == 1)
    {
      this.jdField_a_of_type_Adrd$a.he.setVisibility(0);
      this.jdField_a_of_type_Adrd.a(this.jdField_a_of_type_Adrd$a, this.jdField_a_of_type_ComTencentMobileqqDataArkBabyqCardInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Adrd.a(this.jdField_a_of_type_Wyv, this.val$position);
      return;
      this.jdField_a_of_type_Adrd$a.he.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeyx
 * JD-Core Version:    0.7.0.1
 */