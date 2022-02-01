import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareActivity;
import com.tencent.mobileqq.activity.specialcare.QvipSpecialCareManager;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class esd
  implements CompoundButton.OnCheckedChangeListener
{
  public esd(QvipSpecialCareActivity paramQvipSpecialCareActivity) {}
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    paramCompoundButton = new ArrayList();
    paramCompoundButton.add(QvipSpecialCareActivity.a(this.a));
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("1");
    if (paramBoolean) {
      if (!QvipSpecialCareActivity.a(this.a).a(QvipSpecialCareActivity.a(this.a))) {}
    }
    while (!QvipSpecialCareActivity.a(this.a).a(QvipSpecialCareActivity.a(this.a)))
    {
      return;
      if (!NetworkUtil.e(this.a))
      {
        QvipSpecialCareActivity.a(this.a, this.a.getString(2131562488));
        QvipSpecialCareActivity.a(this.a);
        return;
      }
      if (VipUtils.a(this.a.b))
      {
        if (QvipSpecialCareActivity.a(this.a).c() < QvipSpecialCareActivity.a(this.a).b())
        {
          QvipSpecialCareActivity.c(this.a);
          QvipSpecialCareActivity.b(this.a);
          QvipSpecialCareActivity.a(this.a).a(paramCompoundButton, 2, localArrayList);
          return;
        }
        paramCompoundButton = String.format(this.a.getString(2131562994), new Object[] { Integer.valueOf(QvipSpecialCareActivity.a(this.a).b()) });
        QvipSpecialCareActivity.b(this.a, paramCompoundButton);
        QvipSpecialCareActivity.a(this.a).setChecked(false);
        return;
      }
      if (QvipSpecialCareActivity.a(this.a).c() < QvipSpecialCareActivity.a(this.a).a())
      {
        QvipSpecialCareActivity.d(this.a);
        QvipSpecialCareActivity.b(this.a);
        QvipSpecialCareActivity.a(this.a).a(paramCompoundButton, 2, localArrayList);
        return;
      }
      paramCompoundButton = String.format(this.a.getString(2131562138), new Object[] { Integer.valueOf(QvipSpecialCareActivity.a(this.a).a()), Integer.valueOf(QvipSpecialCareActivity.a(this.a).b()) });
      QvipSpecialCareActivity.a(this.a, paramCompoundButton, 2131562229);
      QvipSpecialCareActivity.a(this.a).setChecked(false);
      return;
    }
    if (!NetworkUtil.e(this.a))
    {
      QvipSpecialCareActivity.a(this.a, this.a.getString(2131562488));
      QvipSpecialCareActivity.a(this.a);
      return;
    }
    QvipSpecialCareActivity.e(this.a);
    QvipSpecialCareActivity.b(this.a);
    QvipSpecialCareActivity.a(this.a).a(paramCompoundButton, 4, localArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     esd
 * JD-Core Version:    0.7.0.1
 */