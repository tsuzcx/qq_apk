import PersonalState.UserProfile;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.SameStatusActivity;
import com.tencent.mobileqq.richstatus.SameStatusActivity.ItemViewHolder;
import com.tencent.mobileqq.richstatus.SameStatusActivity.MoreViewHolder;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.util.FaceDecoder;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.HashSet;

public class ghp
  extends BaseAdapter
{
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  
  private ghp(SameStatusActivity paramSameStatusActivity) {}
  
  public int getCount()
  {
    int i = 1;
    int j = SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).size();
    if (j == 0) {
      return 1;
    }
    if (SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity) != 0) {}
    for (;;)
    {
      return i + j;
      i = 0;
    }
  }
  
  public Object getItem(int paramInt)
  {
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return getItemViewType(paramInt);
  }
  
  public int getItemViewType(int paramInt)
  {
    int i = SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).size();
    if (i == 0) {
      return 2;
    }
    if (paramInt < i) {
      return 0;
    }
    return 1;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    int i = getItemViewType(paramInt);
    if (i == 2)
    {
      SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).setLayoutParams(new AbsListView.LayoutParams(SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).getWidth(), SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).getHeight()));
      return SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity);
    }
    if (i == 0)
    {
      paramViewGroup = paramView;
      if (paramView == null)
      {
        paramViewGroup = LayoutInflater.from(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).inflate(2130903991, null);
        paramView = new SameStatusActivity.ItemViewHolder();
        paramView.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131234531));
        paramView.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131234533));
        paramView.jdField_a_of_type_AndroidViewView = paramViewGroup.findViewById(2131234532);
        paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131234534));
        paramView.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131232032));
        paramView.jdField_c_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131234536));
        paramView.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)paramViewGroup.findViewById(2131234528));
        paramView.d = ((TextView)paramViewGroup.findViewById(2131234529));
        paramViewGroup.setTag(paramView);
      }
      SameStatusActivity.ItemViewHolder localItemViewHolder = (SameStatusActivity.ItemViewHolder)paramViewGroup.getTag();
      paramView = (UserProfile)SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).get(paramInt);
      Object localObject;
      if ((localItemViewHolder.jdField_a_of_type_PersonalStateUserProfile != paramView) || (SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).contains(Long.valueOf(paramView.lEctID))))
      {
        SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).remove(Long.valueOf(paramView.lEctID));
        localItemViewHolder.jdField_a_of_type_PersonalStateUserProfile = paramView;
        localItemViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(paramView.strNick);
        localItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(0);
        if (paramView.bSex != 0) {
          break label560;
        }
        localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839663);
        localItemViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(paramView.strDesc);
        if ((TextUtils.isEmpty(paramView.strDesc)) && (paramView.bSex != 0) && (paramView.bSex != 1)) {
          localItemViewHolder.jdField_a_of_type_AndroidViewView.setVisibility(8);
        }
        localObject = localItemViewHolder.jdField_c_of_type_AndroidWidgetTextView;
        if (paramView.nPicNum <= 0L) {
          break label594;
        }
        paramInt = 2130840221;
        label378:
        ((TextView)localObject).setCompoundDrawablesWithIntrinsicBounds(0, 0, paramInt, 0);
        localObject = paramView.getRichStatus();
        if (TextUtils.isEmpty(((RichStatus)localObject).c)) {
          break label599;
        }
        localItemViewHolder.jdField_a_of_type_Int = ((RichStatus)localObject).b;
        localItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity.getResources(), SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).a(((RichStatus)localObject).b, 200), false, false));
      }
      for (;;)
      {
        localItemViewHolder.d.setText(((RichStatus)localObject).a("     "));
        String str = Long.toString(paramView.lEctID);
        localObject = SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).a(1, str);
        paramView = (View)localObject;
        if (localObject == null)
        {
          if (SameStatusActivity.b(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity) != 2) {
            SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity).a(str, 1, false, (byte)1);
          }
          if (this.jdField_a_of_type_AndroidGraphicsBitmap == null) {
            this.jdField_a_of_type_AndroidGraphicsBitmap = ImageUtil.a();
          }
          paramView = this.jdField_a_of_type_AndroidGraphicsBitmap;
        }
        localItemViewHolder.jdField_b_of_type_AndroidWidgetImageView.setImageBitmap(paramView);
        return paramViewGroup;
        label560:
        if (paramView.bSex == 1)
        {
          localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageResource(2130839656);
          break;
        }
        localItemViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(null);
        break;
        label594:
        paramInt = 0;
        break label378;
        label599:
        localItemViewHolder.jdField_a_of_type_Int = 0;
        localItemViewHolder.jdField_c_of_type_AndroidWidgetImageView.setVisibility(8);
      }
    }
    paramViewGroup = paramView;
    if (paramView == null)
    {
      paramViewGroup = this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity.getLayoutInflater().inflate(2130903283, null);
      paramView = new SameStatusActivity.MoreViewHolder();
      paramViewGroup.setTag(paramView);
      paramView.jdField_a_of_type_AndroidWidgetProgressBar = ((ProgressBar)paramViewGroup.findViewById(2131231066));
      paramViewGroup.findViewById(2131231868).setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramViewGroup.findViewById(2131231869));
    }
    if (SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity) == 1)
    {
      SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity, 2);
      this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity.a(false, false);
    }
    paramView = (SameStatusActivity.MoreViewHolder)paramViewGroup.getTag();
    if (SameStatusActivity.a(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity) == 3)
    {
      paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
      paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity.getString(2131559273));
      return paramViewGroup;
    }
    paramView.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    paramView.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_ComTencentMobileqqRichstatusSameStatusActivity.getString(2131559274));
    return paramViewGroup;
  }
  
  public int getViewTypeCount()
  {
    return 3;
  }
  
  public boolean isEnabled(int paramInt)
  {
    return 2 != getItemViewType(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     ghp
 * JD-Core Version:    0.7.0.1
 */