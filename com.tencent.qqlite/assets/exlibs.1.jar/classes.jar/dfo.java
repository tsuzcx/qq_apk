import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.DataObserver;
import com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class dfo
  implements EmoticonLinearLayout.DataObserver
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public dfo(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
  public void a()
  {
    long l = System.currentTimeMillis();
    int m = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b();
    int n = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c();
    int j = 0;
    int i = 0;
    int k;
    if (j < n)
    {
      k = 0;
      label41:
      if (k < m) {
        if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size() > i) {}
      }
    }
    do
    {
      return;
      RelativeLayout localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(i);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(i, localRelativeLayout, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout);
      i += 1;
      k += 1;
      break label41;
      j += 1;
      break;
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout onDataChanged, bindView duration: " + (System.currentTimeMillis() - l) + ", type=" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int);
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == paramInt1) && (this.b == paramInt2) && (this.jdField_a_of_type_Boolean == true)) {}
    long l;
    label262:
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      l = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.removeAllViews();
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Int)
      {
        LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams1.weight = 1.0F;
        localLinearLayout.setOrientation(0);
        int i = 0;
        if (i < this.b)
        {
          System.currentTimeMillis();
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams2.weight = 1.0F;
          RelativeLayout localRelativeLayout = null;
          if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size()) {
            localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(paramInt1);
          }
          Object localObject1;
          if (localRelativeLayout == null)
          {
            localRelativeLayout = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject1 = new URLImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((URLImageView)localObject1).setId(2131296344);
            switch (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int)
            {
            default: 
              if (QLog.isColorLevel()) {
                QLog.e("EmoticonLinearLayout", 2, "Should not reach here, check your code!!!");
              }
              this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.add(localRelativeLayout);
            }
          }
          for (;;)
          {
            localLinearLayout.addView(localRelativeLayout, localLayoutParams2);
            paramInt1 += 1;
            i += 1;
            break;
            Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label262;
            localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((TextView)localObject2).setVisibility(8);
            ((TextView)localObject2).setId(2131296346);
            ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.b);
            ((TextView)localObject2).setTextSize(12.0F);
            Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(12);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131296346);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject1).setVisibility(8);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject1).setVisibility(8);
            ((ImageView)localObject1).setId(2131296345);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131296344);
            ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131296344);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            break label262;
            localObject2 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject2).setId(2131296348);
            float f = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getContext().getResources().getDisplayMetrics().density;
            localObject3 = new RelativeLayout.LayoutParams((int)(63.0F * f), (int)(f * 63.0F));
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((ImageView)localObject2).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new TextView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((TextView)localObject2).setVisibility(8);
            ((TextView)localObject2).setId(2131296346);
            ((TextView)localObject2).setTextColor(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.b);
            ((TextView)localObject2).setTextSize(12.0F);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(12);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new RelativeLayout(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131296346);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject1).setVisibility(8);
            ((ImageView)localObject1).setId(2131296345);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(2, 2131296346);
            ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296348);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject1).setId(2131296347);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296348);
            ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131296348);
            localObject3 = new ProgressBar(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ProgressBar)localObject3).setVisibility(8);
            ((ProgressBar)localObject3).setId(2131296349);
            ((ProgressBar)localObject3).setIndeterminateDrawable(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130837924));
            int j = AIOUtils.a(16.0F, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext.getResources());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
            localLayoutParams.addRule(13, 2131296348);
            localRelativeLayout.addView((View)localObject3, localLayoutParams);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label262;
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject1).setId(2131296345);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131296344);
            ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131296344);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = new ImageView(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_AndroidContentContext);
            ((ImageView)localObject1).setId(2131296347);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131296348);
            ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131296348);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label262;
            localObject1 = (ViewGroup)localRelativeLayout.getParent();
            if (localObject1 != null) {
              ((ViewGroup)localObject1).removeAllViews();
            }
          }
        }
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.addView(localLinearLayout, localLayoutParams1);
        paramInt2 += 1;
      }
      this.jdField_a_of_type_Boolean = true;
    } while (!QLog.isColorLevel());
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l) + ", type=" + this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfo
 * JD-Core Version:    0.7.0.1
 */