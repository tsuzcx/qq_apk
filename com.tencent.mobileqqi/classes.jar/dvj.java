import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.activity.VisitorsActivity;
import com.tencent.mobileqq.data.CardProfile;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.GridListView.GridListAdapter;
import com.tencent.sc.utils.DateUtil;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

public class dvj
  extends GridListView.GridListAdapter
{
  private ArrayList jdField_a_of_type_JavaUtilArrayList;
  public boolean a;
  private boolean b = false;
  
  public dvj(VisitorsActivity paramVisitorsActivity, ArrayList paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private View a(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903267, paramViewGroup, false);
    dvh localdvh = new dvh();
    localdvh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(16908294));
    localdvh.b = ((TextView)paramViewGroup.findViewById(16908309));
    localdvh.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(16908308));
    localdvh.c = ((TextView)paramViewGroup.findViewById(2131231881));
    localdvh.d = ((TextView)paramViewGroup.findViewById(2131231882));
    localdvh.e = ((TextView)paramViewGroup.findViewById(2131231883));
    localdvh.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131231879);
    paramViewGroup.setTag(localdvh);
    return paramViewGroup;
  }
  
  private void a(int paramInt, dvh paramdvh)
  {
    CardProfile localCardProfile = (CardProfile)this.jdField_a_of_type_JavaUtilArrayList.get(paramInt);
    String str = String.valueOf(localCardProfile.getLEctID());
    Object localObject2 = StringUtil.e(String.valueOf(localCardProfile.getStrNick()));
    switch (getItemViewType(paramInt))
    {
    case 1: 
    default: 
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_JavaUtilHashMap.put(str, paramdvh.jdField_a_of_type_AndroidWidgetImageView);
      paramdvh.jdField_a_of_type_AndroidWidgetImageView.setTag(Integer.valueOf(paramInt));
      this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.a(str, localCardProfile.getWFace(), paramdvh.jdField_a_of_type_AndroidWidgetImageView);
      return;
    case 0: 
      Object localObject1;
      if (localObject2 != null)
      {
        localObject1 = localObject2;
        if (!"".equals(localObject2)) {}
      }
      else
      {
        localObject1 = String.valueOf(localCardProfile.getLEctID());
      }
      label182:
      label188:
      long l;
      if (paramdvh.c != null)
      {
        if (!this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.c) {
          break label372;
        }
        localObject2 = paramdvh.c;
        if (paramInt < this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.jdField_a_of_type_Long)
        {
          i = 0;
          ((TextView)localObject2).setVisibility(i);
        }
      }
      else
      {
        paramdvh.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
        l = localCardProfile.getLTime();
        if ((-1L != l) && (0L != l)) {
          break label404;
        }
        paramdvh.b.setVisibility(8);
        label230:
        paramdvh.d.setText(localCardProfile.getBAge() + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131561415));
        localObject1 = paramdvh.d;
        if (localCardProfile.getBSex() != 0) {
          break label434;
        }
        i = 2130838069;
        label284:
        ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
        if (localCardProfile.getVIntroContent() == null) {
          break label482;
        }
      }
      for (;;)
      {
        try
        {
          localObject1 = new String(localCardProfile.getVIntroContent(), "utf-8");
          if (TextUtils.isEmpty((CharSequence)localObject1))
          {
            paramdvh.e.setVisibility(8);
            if (paramdvh.jdField_a_of_type_AndroidViewView == null) {
              break;
            }
            localObject1 = paramdvh.jdField_a_of_type_AndroidViewView;
            if (localCardProfile.nFaceNum <= 0) {
              break label502;
            }
            i = 0;
            ((View)localObject1).setVisibility(i);
            break;
            i = 8;
            break label182;
            label372:
            localObject2 = paramdvh.c;
            if (1 == localCardProfile.getBVote())
            {
              i = 0;
              ((TextView)localObject2).setVisibility(i);
              break label188;
            }
            i = 8;
            continue;
            label404:
            localObject1 = DateUtil.a(new Date(l * 1000L));
            paramdvh.b.setText((CharSequence)localObject1);
            break label230;
            label434:
            i = 2130838068;
            break label284;
          }
          paramdvh.e.setText((CharSequence)localObject1);
          paramdvh.e.setVisibility(0);
          continue;
        }
        catch (UnsupportedEncodingException localUnsupportedEncodingException)
        {
          paramdvh.e.setText(null);
          paramdvh.e.setVisibility(8);
          continue;
        }
        label482:
        paramdvh.e.setText(null);
        paramdvh.e.setVisibility(8);
        continue;
        label502:
        i = 4;
      }
    }
    TextView localTextView = paramdvh.b;
    if (localCardProfile.getBSex() == 0) {}
    for (int i = 2130838069;; i = 2130838068)
    {
      localTextView.setCompoundDrawablesWithIntrinsicBounds(i, 0, 0, 0);
      paramdvh.b.setVisibility(0);
      paramdvh.b.setText(localCardProfile.getBAge() + this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getString(2131561415));
      break;
    }
  }
  
  private void a(dvi paramdvi)
  {
    int j = 8;
    Object localObject = paramdvi.jdField_a_of_type_AndroidWidgetTextView;
    if (this.jdField_a_of_type_Boolean)
    {
      i = 2131562334;
      ((TextView)localObject).setText(i);
      localObject = paramdvi.jdField_a_of_type_AndroidWidgetProgressBar;
      if (!this.jdField_a_of_type_Boolean) {
        break label72;
      }
      i = 0;
      label40:
      ((ProgressBar)localObject).setVisibility(i);
      paramdvi = paramdvi.jdField_a_of_type_AndroidWidgetImageView;
      if (!this.jdField_a_of_type_Boolean) {
        break label78;
      }
    }
    label72:
    label78:
    for (int i = j;; i = 0)
    {
      paramdvi.setVisibility(i);
      return;
      i = 2131562926;
      break;
      i = 8;
      break label40;
    }
  }
  
  private View b(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903266, paramViewGroup, false);
    dvh localdvh = new dvh();
    localdvh.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(16908294));
    localdvh.b = ((TextView)paramViewGroup.findViewById(16908309));
    paramViewGroup.setTag(localdvh);
    return paramViewGroup;
  }
  
  private View c(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903283, null);
    dvi localdvi = new dvi();
    localdvi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231868));
    localdvi.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131231066));
    localdvi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131231867));
    paramViewGroup.setTag(localdvi);
    return paramViewGroup;
  }
  
  private View d(ViewGroup paramViewGroup, int paramInt)
  {
    paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.getLayoutInflater().inflate(2130903264, paramViewGroup, false);
    dvi localdvi = new dvi();
    localdvi.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231868));
    localdvi.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131231066));
    localdvi.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131231867));
    paramViewGroup.setTag(localdvi);
    return paramViewGroup;
  }
  
  public int a()
  {
    return 2;
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
    int j = this.jdField_a_of_type_JavaUtilArrayList.size();
    if (this.b) {}
    for (int i = 1;; i = 0) {
      return i + j;
    }
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
    if (paramInt > this.jdField_a_of_type_JavaUtilArrayList.size() - 1) {
      i = 1;
    }
    paramInt = i;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVisitorsActivity.b) {
      paramInt = i + 2;
    }
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    switch (getItemViewType(paramInt))
    {
    default: 
      return paramView;
    case 0: 
      localView = paramView;
      if (paramView == null) {
        localView = a(paramViewGroup, paramInt);
      }
      a(paramInt, (dvh)localView.getTag());
      return localView;
    case 1: 
      localView = paramView;
      if (paramView == null) {
        localView = c(paramViewGroup, paramInt);
      }
      a((dvi)localView.getTag());
      return localView;
    case 3: 
      localView = paramView;
      if (paramView == null) {
        localView = d(paramViewGroup, paramInt);
      }
      a((dvi)localView.getTag());
      return localView;
    }
    View localView = paramView;
    if (paramView == null) {
      localView = b(paramViewGroup, paramInt);
    }
    a(paramInt, (dvh)localView.getTag());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     dvj
 * JD-Core Version:    0.7.0.1
 */