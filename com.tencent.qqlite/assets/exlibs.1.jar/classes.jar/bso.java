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

public class bso
  extends GridListView.GridListAdapter
{
  public int a;
  LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  public String a;
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = false;
  
  public bso(VisitorsActivity paramVisitorsActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903222, paramViewGroup, false);
    bsm localbsm = new bsm();
    localbsm.jdField_a_of_type_AndroidWidgetLinearLayout = ((LinearLayout)paramViewGroup.findViewById(2131297249));
    localbsm.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131296456));
    localbsm.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297250));
    localbsm.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131296848));
    localbsm.c = ((TextView)paramViewGroup.findViewById(2131297252));
    localbsm.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297251));
    localbsm.d = ((TextView)paramViewGroup.findViewById(2131297253));
    paramViewGroup.setTag(localbsm);
    return paramViewGroup;
  }
  
  private void a(int paramInt, bsm parambsm)
  {
    CardProfile localCardProfile = (CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    String str = String.valueOf(localCardProfile.getLEctID());
    Object localObject = StringUtil.e(String.valueOf(localCardProfile.getStrNick()));
    parambsm.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
    int i;
    if (localCardProfile.getBAge() > 0)
    {
      parambsm.jdField_b_of_type_AndroidWidgetTextView.setText(String.valueOf(localCardProfile.getBAge()));
      localObject = parambsm.jdField_b_of_type_AndroidWidgetTextView;
      if (localCardProfile.getBSex() != 0) {
        break label254;
      }
      i = 2130838102;
      label85:
      ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      if (localCardProfile.getBSex() != 0) {
        break label260;
      }
      parambsm.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838761);
      label111:
      if (localCardProfile.getBConstellation() != 0) {
        break label272;
      }
      parambsm.c.setVisibility(8);
      label128:
      a(parambsm, localCardProfile);
      PeopleAroundAdapter.a(localCardProfile.stVipInfo, parambsm.jdField_b_of_type_AndroidWidgetImageView, parambsm.jdField_a_of_type_AndroidWidgetTextView);
      localObject = (RelativeLayout.LayoutParams)parambsm.d.getLayoutParams();
      if (parambsm.jdField_b_of_type_AndroidWidgetTextView.getVisibility() != 0) {
        break label307;
      }
      ((RelativeLayout.LayoutParams)localObject).addRule(3, parambsm.jdField_b_of_type_AndroidWidgetTextView.getId());
    }
    for (;;)
    {
      parambsm.d.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a.put(str, parambsm.jdField_a_of_type_AndroidWidgetImageView);
      parambsm.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, localCardProfile.getWFace(), parambsm.jdField_a_of_type_AndroidWidgetImageView);
      return;
      parambsm.jdField_b_of_type_AndroidWidgetTextView.setText("");
      break;
      label254:
      i = 2130838097;
      break label85;
      label260:
      parambsm.jdField_b_of_type_AndroidWidgetTextView.setBackgroundResource(2130838760);
      break label111;
      label272:
      parambsm.c.setText(ProfileCardUtil.a(localCardProfile.getBConstellation()));
      parambsm.c.setBackgroundResource(2130838763);
      parambsm.c.setVisibility(0);
      break label128;
      label307:
      if (parambsm.c.getVisibility() == 0) {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parambsm.c.getId());
      } else {
        ((RelativeLayout.LayoutParams)localObject).addRule(3, parambsm.jdField_a_of_type_AndroidWidgetLinearLayout.getId());
      }
    }
  }
  
  private void a(bsm parambsm, CardProfile paramCardProfile)
  {
    TextView localTextView = parambsm.d;
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localTextView.getLayoutParams();
    if (parambsm.jdField_b_of_type_AndroidWidgetTextView.getVisibility() == 0)
    {
      localLayoutParams.addRule(3, parambsm.jdField_b_of_type_AndroidWidgetTextView.getId());
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
      parambsm.jdField_a_of_type_Int = paramCardProfile.b;
      localTextView.setText(paramCardProfile.a(null));
      localTextView.setVisibility(0);
      return;
      if (parambsm.c.getVisibility() == 0)
      {
        localLayoutParams.addRule(3, parambsm.c.getId());
        break;
      }
      localLayoutParams.addRule(3, parambsm.jdField_a_of_type_AndroidWidgetTextView.getId());
      break;
      label146:
      localTextView.setCompoundDrawables(null, null, null, null);
    }
    label157:
    parambsm.jdField_a_of_type_Int = 0;
    localTextView.setVisibility(8);
  }
  
  private void a(bsn parambsn)
  {
    int j = 8;
    Object localObject = parambsn.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131364192;
      ((TextView)localObject).setText(i);
      localObject = parambsn.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label73;
      }
      i = 0;
      label40:
      ((ProgressBar)localObject).setVisibility(i);
      parambsn = parambsn.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label79;
      }
    }
    label73:
    label79:
    for (int i = j;; i = 0)
    {
      parambsn.setVisibility(i);
      return;
      i = 2131363206;
      break;
      i = 8;
      break label40;
    }
  }
  
  private View b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903239, null);
    bsn localbsn = new bsn();
    localbsn.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131297311));
    localbsn.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131296561));
    localbsn.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131297310));
    paramViewGroup.setTag(localbsn);
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
      a(paramInt, (bsm)localView.getTag());
      return localView;
    case 1: 
      localView = paramView;
      if (paramView == null) {
        localView = b(paramViewGroup, paramInt);
      }
      a((bsn)localView.getTag());
      return localView;
    }
    View localView = paramView;
    if (paramView == null)
    {
      if (this.jdField_a_of_type_AndroidViewLayoutInflater == null) {
        this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramViewGroup.getContext().getSystemService("layout_inflater"));
      }
      localView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903517, null);
    }
    ((TextView)localView.findViewById(2131298345)).setText(this.jdField_a_of_type_JavaLangString);
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
 * Qualified Name:     bso
 * JD-Core Version:    0.7.0.1
 */