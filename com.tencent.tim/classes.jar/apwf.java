import com.tencent.mobileqq.troop.widget.WheelPickerLayout;
import com.tencent.mobileqq.troop.widget.WheelPickerLayout.e;
import com.tencent.qphone.base.util.QLog;
import java.util.Arrays;
import java.util.Calendar;

class apwf
  implements WheelPickerLayout.e
{
  apwf(apwe paramapwe) {}
  
  public void w(int paramInt1, int paramInt2)
  {
    if (apwe.a(this.a) != null)
    {
      if (paramInt1 != 0) {
        break label212;
      }
      if (apwe.a(this.a) == null) {
        break label288;
      }
      paramInt1 = apwe.a(this.a).a(apwe.a(this.a), paramInt2);
      int i = apwe.a(this.a).a(apwe.a(this.a), paramInt2, paramInt1);
      paramInt2 = paramInt1;
      paramInt1 = i;
    }
    for (;;)
    {
      apwe.a(this.a).setSelection(1, paramInt2);
      apwe.a(this.a).LV(1);
      apwe.a(this.a).setSelection(2, paramInt1);
      apwe.a(this.a).LV(2);
      label212:
      do
      {
        apwe.a(this.a, apwe.a(this.a).a(new int[] { apwe.a(this.a).ha(0), apwe.a(this.a).ha(1), apwe.a(this.a).ha(2) }));
        if (QLog.isColorLevel()) {
          QLog.i("TroopPickerViewHelper", 2, Arrays.toString(apwe.a(this.a).c(apwe.a(this.a).getTimeInMillis())));
        }
        return;
      } while (paramInt1 != 1);
      if (apwe.a(this.a) != null) {}
      for (paramInt1 = apwe.a(this.a).a(apwe.a(this.a), apwe.a(this.a).ha(0), paramInt2);; paramInt1 = 0)
      {
        apwe.a(this.a).setSelection(2, paramInt1);
        apwe.a(this.a).LV(2);
        break;
      }
      label288:
      paramInt1 = 0;
      paramInt2 = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apwf
 * JD-Core Version:    0.7.0.1
 */