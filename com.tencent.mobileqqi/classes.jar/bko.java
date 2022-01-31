import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.av.VideoController;
import com.tencent.av.app.SessionInfo;
import com.tencent.av.ui.MultiVideoMembersHolderUI;
import com.tencent.av.ui.MultiVideoMembersHolderUI.Holder;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class bko
  extends BaseAdapter
{
  private int jdField_a_of_type_Int = 0;
  
  public bko(MultiVideoMembersHolderUI paramMultiVideoMembersHolderUI, Context paramContext, int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
    paramMultiVideoMembersHolderUI.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
  }
  
  View a(View paramView, bkp parambkp, boolean paramBoolean)
  {
    ImageView localImageView = (ImageView)paramView.findViewById(2131232241);
    TextView localTextView = (TextView)paramView.findViewById(2131232243);
    MultiVideoMembersHolderUI.Holder localHolder = new MultiVideoMembersHolderUI.Holder(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI);
    localHolder.jdField_a_of_type_AndroidWidgetImageView = localImageView;
    localHolder.jdField_a_of_type_AndroidWidgetTextView = localTextView;
    localHolder.jdField_a_of_type_Long = parambkp.jdField_a_of_type_Long;
    localHolder.jdField_b_of_type_Boolean = paramBoolean;
    localHolder.jdField_a_of_type_Boolean = parambkp.jdField_a_of_type_Boolean;
    localHolder.jdField_b_of_type_Int = 0;
    localHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131232242));
    localHolder.c = ((ImageView)paramView.findViewById(2131232244));
    paramView.setTag(localHolder);
    if (parambkp.jdField_a_of_type_JavaLangString != null) {
      localHolder.jdField_a_of_type_AndroidWidgetTextView.setText(parambkp.jdField_a_of_type_JavaLangString);
    }
    if (parambkp.jdField_a_of_type_AndroidGraphicsBitmap != null)
    {
      localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(parambkp.jdField_a_of_type_AndroidGraphicsBitmap);
      label151:
      if (!localHolder.jdField_a_of_type_Boolean) {
        break label337;
      }
      localHolder.c.setVisibility(0);
      localHolder.jdField_b_of_type_Int = 5;
      label174:
      if (!parambkp.c) {
        break label350;
      }
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
      localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838289);
      localHolder.jdField_b_of_type_Int = 2;
      label206:
      if (localHolder.jdField_b_of_type_Boolean)
      {
        if ((!parambkp.c) || (!parambkp.jdField_b_of_type_Boolean)) {
          break label489;
        }
        if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int != 1) {
          break label398;
        }
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838273);
        localHolder.jdField_b_of_type_Int = 3;
      }
    }
    for (;;)
    {
      switch (localHolder.jdField_b_of_type_Int)
      {
      default: 
        paramView.setContentDescription(null);
        return paramView;
        localHolder.jdField_a_of_type_AndroidWidgetImageView.setImageBitmap(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a());
        break label151;
        label337:
        localHolder.c.setVisibility(8);
        break label174;
        label350:
        if (parambkp.jdField_b_of_type_Boolean)
        {
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838258);
          localHolder.jdField_b_of_type_Int = 1;
          break label206;
        }
        localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
        break label206;
        label398:
        if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int == 2)
        {
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838270);
          localHolder.jdField_b_of_type_Int = 4;
        }
        else if (QLog.isColorLevel())
        {
          QLog.e("MultiVideoMembersHolderUI", 2, "assembleConvertView-->Wrong Type of VideoSrc.VideoSrc=" + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int);
          continue;
          label489:
          if (parambkp.c)
          {
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838273);
            localHolder.jdField_b_of_type_Int = 4;
          }
          else if (parambkp.jdField_b_of_type_Boolean)
          {
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
            localHolder.jdField_b_of_type_AndroidWidgetImageView.setImageResource(2130838270);
            localHolder.jdField_b_of_type_Int = 3;
          }
          else if (QLog.isColorLevel())
          {
            QLog.e("MultiVideoMembersHolderUI", 2, "assembleConvertView-->Wrong Type of VideoSrc.VideoSrc=" + this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Int);
          }
        }
        break;
      }
    }
    paramView.setContentDescription(null);
    return paramView;
    paramView.setContentDescription(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_AndroidContentResResources.getString(2131560178));
    return paramView;
    paramView.setContentDescription(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_AndroidContentResResources.getString(2131560177));
    return paramView;
    paramView.setContentDescription(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_AndroidContentResResources.getString(2131560176));
    return paramView;
    paramView.setContentDescription(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_AndroidContentResResources.getString(2131560175));
    return paramView;
    paramView.setContentDescription(this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_AndroidContentResResources.getString(2131560179));
    return paramView;
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_b_of_type_Int == 0) {
      if (QLog.isColorLevel()) {
        QLog.e("MultiVideoMembersHolderUI", 2, "mTotalPageNum == 0!!!Why?");
      }
    }
    do
    {
      return 0;
      if (this.jdField_a_of_type_Int != this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_b_of_type_Int - 1) {
        break;
      }
    } while (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_JavaUtilArrayList.size() == 0);
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_JavaUtilArrayList.size() % this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d == 0) {
      return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d;
    }
    return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_JavaUtilArrayList.size() % this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d;
    return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d;
  }
  
  public Object getItem(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_JavaUtilArrayList != null)
    {
      int i = this.jdField_a_of_type_Int;
      int j = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d;
      return this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_JavaUtilArrayList.get(i * j + paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return this.jdField_a_of_type_Int * this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d + paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    boolean bool = true;
    int i = this.jdField_a_of_type_Int;
    int j = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.d;
    paramView = (bkp)this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_JavaUtilArrayList.get(i * j + paramInt);
    paramViewGroup = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903351, null);
    if ((paramView.jdField_a_of_type_JavaLangString == null) || (paramView.jdField_a_of_type_AndroidGraphicsBitmap == null) || (!paramView.d))
    {
      Object localObject = String.valueOf(paramView.jdField_a_of_type_Long);
      paramView.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a((String)localObject);
      if (paramView.jdField_a_of_type_JavaLangString.compareTo((String)localObject) != 0)
      {
        paramView.d = true;
        localObject = this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.a(String.valueOf(paramView.jdField_a_of_type_Long));
        if (localObject == null) {
          break label178;
        }
        paramView.jdField_a_of_type_AndroidGraphicsBitmap = ((Bitmap)localObject);
      }
    }
    else
    {
      label140:
      if (paramView.jdField_a_of_type_Long != this.jdField_a_of_type_ComTencentAvUiMultiVideoMembersHolderUI.jdField_a_of_type_ComTencentAvVideoController.a().jdField_c_of_type_Long) {
        break label191;
      }
    }
    for (;;)
    {
      return a(paramViewGroup, paramView, bool);
      paramView.d = false;
      break;
      label178:
      paramView.jdField_a_of_type_AndroidGraphicsBitmap = null;
      paramView.d = false;
      break label140;
      label191:
      bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     bko
 * JD-Core Version:    0.7.0.1
 */