import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.bmqq.profile.BmqqProfileCardActivity;
import com.tencent.mobileqq.activity.ProfileCardMoreActivity;
import com.tencent.mobileqq.data.BmqqUserSimpleInfo;

public class lg
  implements View.OnClickListener
{
  private static final long b = 1000L;
  private long jdField_a_of_type_Long = 0L;
  
  public lg(BmqqProfileCardActivity paramBmqqProfileCardActivity) {}
  
  public void onClick(View paramView)
  {
    if (paramView == null) {
      break label4;
    }
    label4:
    do
    {
      do
      {
        return;
      } while (!(paramView.getTag() instanceof Integer));
      int i = ((Integer)paramView.getTag()).intValue();
      long l = System.currentTimeMillis();
      if (Math.abs(l - this.jdField_a_of_type_Long) < 1000L) {
        break;
      }
      this.jdField_a_of_type_Long = l;
      switch (i)
      {
      default: 
        return;
      case 0: 
        paramView = new Intent(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity, ProfileCardMoreActivity.class);
        paramView.putExtra("AllInOne", BmqqProfileCardActivity.a(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity));
        paramView.addFlags(536870912);
        this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity.startActivityForResult(paramView, 1012);
        return;
      case 1: 
        this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity.finish();
        return;
      case 32: 
        BmqqProfileCardActivity.c(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity);
        return;
      case 30: 
        BmqqProfileCardActivity.d(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity);
        return;
      case 8: 
        BmqqProfileCardActivity.a(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity, 1);
        return;
      case 7: 
        BmqqProfileCardActivity.a(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity, 4);
        return;
      }
    } while ((this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity.a == null) || (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity.a.mBmqqEmail)));
    BmqqProfileCardActivity.b(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity, this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity.a.mBmqqEmail);
    return;
    BmqqProfileCardActivity.e(this.jdField_a_of_type_ComTencentBizBmqqProfileBmqqProfileCardActivity);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     lg
 * JD-Core Version:    0.7.0.1
 */