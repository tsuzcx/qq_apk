import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.profile.ProfileCardBrowserActivity;
import com.tencent.mobileqq.profile.ProfileCardTemplate;
import com.tencent.mobileqq.profile.ProfileCardTemplateInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class gej
  implements AdapterView.OnItemClickListener
{
  public gej(ProfileCardBrowserActivity paramProfileCardBrowserActivity) {}
  
  public void onItemClick(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramLong = System.currentTimeMillis();
    if (paramLong - this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.get() > 1000L)
    {
      this.a.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicLong.set(paramLong);
      if (NetworkUtil.e(this.a)) {
        break label76;
      }
      QQToast.a(this.a, this.a.getString(2131562452), 0).b(this.a.d());
    }
    label405:
    label409:
    for (;;)
    {
      return;
      label76:
      int i;
      if (this.a.jdField_a_of_type_JavaUtilList != null)
      {
        paramAdapterView = ((ProfileCardTemplateInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt)).jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate;
        if (paramAdapterView != null) {
          if ((paramAdapterView.c.equals("2")) || (paramAdapterView.c.equals("3")))
          {
            if ((this.a.jdField_a_of_type_Boolean) || (this.a.b)) {
              break label405;
            }
            this.a.z = 1;
            if (this.a.y == 1)
            {
              this.a.F = 1;
              label181:
              this.a.f();
              i = 0;
            }
          }
        }
      }
      for (;;)
      {
        if (i == 0) {
          break label409;
        }
        paramAdapterView = (ProfileCardTemplateInfo)this.a.jdField_a_of_type_JavaUtilList.get(paramInt);
        if ((paramAdapterView.jdField_a_of_type_Int == 0) || (paramAdapterView.jdField_a_of_type_Int == -1))
        {
          paramAdapterView.jdField_a_of_type_Int = 1;
          ProfileCardBrowserActivity.a(this.a, paramAdapterView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a, paramInt);
          this.a.a(paramView.getTag(), 2);
          return;
          this.a.F = 3;
          break label181;
          if (paramAdapterView.c.equals("4"))
          {
            if (this.a.b) {
              break label405;
            }
            this.a.z = 2;
            if (this.a.y == 1) {}
            for (this.a.F = 4;; this.a.F = 6)
            {
              this.a.f();
              i = 0;
              break;
            }
          }
          if (!paramAdapterView.c.equals("5")) {
            break label405;
          }
          i = 0;
          continue;
        }
        if (paramAdapterView.jdField_a_of_type_Int != 2) {
          break;
        }
        paramAdapterView.jdField_a_of_type_Int = 3;
        ProfileCardBrowserActivity.a(this.a, paramAdapterView.jdField_a_of_type_ComTencentMobileqqProfileProfileCardTemplate.a, paramInt);
        this.a.a(paramView.getTag(), 1);
        return;
        i = 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     gej
 * JD-Core Version:    0.7.0.1
 */