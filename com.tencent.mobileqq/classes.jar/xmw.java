import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.mobileqq.activity.registerGuideLogin.LoginView;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.NewStyleDropdownView;
import com.tencent.qphone.base.remote.SimpleAccount;
import java.util.List;

public class xmw
  extends ArrayAdapter
  implements View.OnClickListener
{
  Filter jdField_a_of_type_AndroidWidgetFilter;
  
  public xmw(LoginView paramLoginView, Context paramContext)
  {
    super(paramContext, 2130968588, 2131362746, paramLoginView.jdField_a_of_type_JavaUtilList);
  }
  
  public String a(int paramInt)
  {
    String str = ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {
      return str;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.b(str);
  }
  
  public String b(int paramInt)
  {
    return ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin();
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.size() == 0) {
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(8);
    }
    for (;;)
    {
      return super.getCount();
      this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqWidgetNewStyleDropdownView.b().setVisibility(0);
    }
  }
  
  public Filter getFilter()
  {
    if (this.jdField_a_of_type_AndroidWidgetFilter == null) {
      this.jdField_a_of_type_AndroidWidgetFilter = new xmx(this);
    }
    return this.jdField_a_of_type_AndroidWidgetFilter;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    paramView = super.getView(paramInt, paramView, paramViewGroup);
    paramViewGroup = (LinearLayout)paramView.findViewById(2131362745);
    ImageView localImageView = (ImageView)paramView.findViewById(2131362747);
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.a(((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin(), false);
    if ((localObject instanceof Bitmap)) {
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    for (;;)
    {
      localImageView = (ImageView)paramView.findViewById(2131362748);
      localImageView.setTag(Integer.valueOf(paramInt));
      localImageView.setOnClickListener(this);
      localImageView.setContentDescription(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131427442));
      paramView.setContentDescription(String.format(this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getString(2131433198) + "%s", new Object[] { ((SimpleAccount)this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_JavaUtilList.get(paramInt)).getUin() }));
      paramViewGroup.setOnClickListener(new xmy(this, paramInt));
      return paramView;
      localImageView.setImageResource(2130839300);
    }
  }
  
  public void onClick(View paramView)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_Int = ((Integer)paramView.getTag()).intValue();
    this.jdField_a_of_type_ComTencentMobileqqActivityRegisterGuideLoginLoginView.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.showDialog(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xmw
 * JD-Core Version:    0.7.0.1
 */