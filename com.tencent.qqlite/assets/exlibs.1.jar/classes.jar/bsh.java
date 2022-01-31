import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.adapter.PeopleAroundAdapter;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class bsh
  extends GridListView.GridListAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = false;
  
  public bsh(VisitorsActivity paramVisitorsActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903222, paramViewGroup, false);
    bsf localbsf = new bsf();
    localbsf.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131297253));
    localbsf.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296453));
    localbsf.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297254));
    localbsf.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296851));
    localbsf.c = ((TextView)paramViewGroup.findViewById(2131297256));
    localbsf.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297255));
    localbsf.d = ((TextView)paramViewGroup.findViewById(2131297257));
    paramViewGroup.setTag(localbsf);
    return paramViewGroup;
  }
  
  private void a(int paramInt, bsf parambsf)
  {
    CardProfile localCardProfile = (CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    String str = String.valueOf(localCardProfile.getLEctID());
    Object localObject = StringUtil.e(String.valueOf(localCardProfile.getStrNick()));
    parambsf.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (localCardProfile.getBAge() > 0)
    {
      parambsf.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localCardProfile.getBAge()));
      localObject = parambsf.jdField_b_of_type_AndroidWidgetTextView;
      if (localCardProfile.getBSex() != 0) {
        break label254;
      }
      i = 2130838089;
      label85:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (localCardProfile.getBSex() != 0) {
        break label260;
      }
      parambsf.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838759);
      label111:
      if (localCardProfile.getBConstellation() != 0) {
        break label272;
      }
      parambsf.c.setVisibility(8);
      label128:
      a(parambsf, localCardProfile);
      PeopleAroundAdapter.a(localCardProfile.stVipInfo, parambsf.jdField_b_of_type_AndroidWidgetImageView, parambsf.jdField_a_of_type_AndroidWidgetTextView);
      localObject = (RelativeLayout.LayoutParams)parambsf.d.getLayoutParams();
      if (parambsf.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label307;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, parambsf.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      parambsf.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.put(str, parambsf.jdField_a_of_type_AndroidWidgetImageView);
      parambsf.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, localCardProfile.getWFace(), parambsf.jdField_a_of_type_AndroidWidgetImageView);
      return;
      parambsf.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label254:
      i = 2130838084;
      break label85;
      label260:
      parambsf.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838758);
      break label111;
      label272:
      parambsf.c.setText(ProfileCardUtil.a(localCardProfile.getBConstellation()));
      parambsf.c.setBackgroundResource(2130838761);
      parambsf.c.setVisibility(0);
      break label128;
      label307:
      if (parambsf.c.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parambsf.c.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parambsf.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  private void a(bsf parambsf, CardProfile paramCardProfile)
  {
    TextView localTextView = parambsf.d;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (parambsf.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      localLayoutParams.addRule(3, parambsf.jdField_b_of_type_AndroidWidgetTextView.getId());
      localTextView.setLayoutParams(localLayoutParams);
      paramCardProfile = paramCardProfile.getRichStatus();
      if ((paramCardProfile == null) || (paramCardProfile.a())) {
        break label157;
      }
      if (TextUtils.isEmpty(paramCardProfile.c)) {
        break label146;
      }
      VisitorsActivity.a(this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity, localTextView, paramCardProfile.b);
    }
    for (;;)
    {
      parambsf.jdField_a_of_type_Int = paramCardProfile.b;
      localTextView.setText(paramCardProfile.a(null));
      localTextView.setVisibility(0);
      return;
      if (parambsf.c.getVisibility() == 0)
      {
        localLayoutParams.addRule(3, parambsf.c.getId());
        break;
      }
      localLayoutParams.addRule(3, parambsf.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
      label146:
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    label157:
    parambsf.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
  }
  
  private void a(bsg parambsg)
  {
    int j = 8;
    Object localObject = parambsg.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131364196;
      ((TextView)localObject).setText(i);
      localObject = parambsg.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label73;
      }
      i = 0;
      label40:
      ((ProgressBar)localObject).setVisibility(i);
      parambsg = parambsg.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label79;
      }
    }
    label73:
    label79:
    for (int i = j;; i = 0)
    {
      parambsg.setVisibility(i);
      return;
      i = 2131363193;
      break;
      i = 8;
      break label40;
    }
  }
  
  private View b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903239, null);
    bsg localbsg = new bsg();
    localbsg.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297315));
    localbsg.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296558));
    localbsg.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297314));
    paramViewGroup.setTag(localbsg);
    return paramViewGroup;
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public void a(ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)paramArrayList.clone());
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    return this.b;
  }
  
  public int b(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getCount()
  {
    int i = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (i == 0) {
      return 0;
    }
    return i + 1;
  }
  
  public Object getItem(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return null;
    }
    return this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return -1L;
    }
    return ((CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt)).lEctID;
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = 0;
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1)
    {
      if (this.b) {
        i = 1;
      }
    }
    else {
      return i;
    }
    return 2;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      if (paramInt > this.jdField_a_of_type_Int) {
        this.jdField_a_of_type_Int = paramInt;
      }
      localView = paramView;
      if (paramView == null) {
        localView = a(paramViewGroup, paramInt);
      }
      a(paramInt, (bsf)localView.getTag());
      return localView;
    case 1: 
      localView = paramView;
      if (paramView == null) {
        localView = b(paramViewGroup, paramInt);
      }
      a((bsg)localView.getTag());
      return localView;
    }
    View localView = paramView;
    if (paramView == null)
    {
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903522, null);
    }
    ((TextView)localView.findViewById(2131298367)).setText(this.jdField_a_of_type_JavaLangString);
    return localView;
  }
  
  public int getViewTypeCount()
  {
    return 4;
  }
  
  public boolean isEnabled(int paramInt)
  {
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      return !this.jdField_a_of_type_Boolean;
    }
    return super.isEnabled(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bsh
 * JD-Core Version:    0.7.0.1
 */