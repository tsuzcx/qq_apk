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

public class foe
  implements EmoticonLinearLayout.DataObserver
{
  private int jdField_a_of_type_Int;
  private boolean jdField_a_of_type_Boolean;
  private int b;
  
  public foe(EmoticonLinearLayout paramEmoticonLinearLayout) {}
  
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
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout onDataChanged, bindView duration: " + (System.currentTimeMillis() - l) + ", type=" + EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Int == paramInt1) && (this.b == paramInt2) && (this.jdField_a_of_type_Boolean == true)) {}
    long l1;
    label266:
    do
    {
      return;
      this.jdField_a_of_type_Int = paramInt1;
      this.b = paramInt2;
      l1 = System.currentTimeMillis();
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.removeAllViews();
      paramInt1 = 0;
      paramInt2 = 0;
      while (paramInt2 < this.jdField_a_of_type_Int)
      {
        LinearLayout localLinearLayout = new LinearLayout(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
        LinearLayout.LayoutParams localLayoutParams1 = new LinearLayout.LayoutParams(-1, -1);
        localLayoutParams1.weight = 1.0F;
        localLinearLayout.setOrientation(0);
        int i = 0;
        if (i < this.b)
        {
          long l2 = System.currentTimeMillis();
          LinearLayout.LayoutParams localLayoutParams2 = new LinearLayout.LayoutParams(-1, -1);
          localLayoutParams2.weight = 1.0F;
          RelativeLayout localRelativeLayout = null;
          if (paramInt1 < this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.size()) {
            localRelativeLayout = (RelativeLayout)this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.jdField_a_of_type_JavaUtilList.get(paramInt1);
          }
          Object localObject1;
          if (localRelativeLayout == null)
          {
            localRelativeLayout = new RelativeLayout(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            localObject1 = new URLImageView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((URLImageView)localObject1).setId(2131230814);
            switch (EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout))
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
            if (QLog.isColorLevel()) {
              QLog.d("EmoticonLinearLayout", 2, "[Performance] element create duration: " + (System.currentTimeMillis() - l2));
            }
            i += 1;
            break;
            Object localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label266;
            localObject2 = new TextView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((TextView)localObject2).setVisibility(8);
            ((TextView)localObject2).setId(2131230816);
            ((TextView)localObject2).setTextColor(EmoticonLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((TextView)localObject2).setTextSize(12.0F);
            Object localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(12);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new RelativeLayout(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131230816);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject1).setVisibility(8);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            localObject1 = new ImageView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((ImageView)localObject1).setVisibility(8);
            ((ImageView)localObject1).setId(2131230815);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(7, 2131230814);
            ((RelativeLayout.LayoutParams)localObject3).addRule(8, 2131230814);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            break label266;
            localObject2 = new ImageView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((ImageView)localObject2).setId(2131230818);
            float f = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout.getContext().getResources().getDisplayMetrics().density;
            localObject3 = new RelativeLayout.LayoutParams((int)(67.0F * f), (int)(f * 67.0F));
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
            ((ImageView)localObject2).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new TextView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((TextView)localObject2).setVisibility(8);
            ((TextView)localObject2).setId(2131230816);
            ((TextView)localObject2).setTextColor(EmoticonLinearLayout.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((TextView)localObject2).setTextSize(12.0F);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(12);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject2 = new RelativeLayout(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            localObject3 = new RelativeLayout.LayoutParams(-1, -1);
            ((RelativeLayout.LayoutParams)localObject3).addRule(2, 2131230816);
            ((RelativeLayout.LayoutParams)localObject3).addRule(14);
            localRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
            localObject3 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject3).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            ((RelativeLayout)localObject2).addView((View)localObject1, (ViewGroup.LayoutParams)localObject3);
            localObject1 = new ImageView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((ImageView)localObject1).setId(2131230817);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131230818);
            ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131230818);
            localObject3 = new ProgressBar(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((ProgressBar)localObject3).setVisibility(8);
            ((ProgressBar)localObject3).setId(2131230819);
            ((ProgressBar)localObject3).setIndeterminateDrawable(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout).getResources().getDrawable(2130837856));
            int j = AIOUtils.a(16.0F, EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout).getResources());
            RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(j, j);
            localLayoutParams.addRule(13, 2131230818);
            localRelativeLayout.addView((View)localObject3, localLayoutParams);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label266;
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(13, -1);
            ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.FIT_XY);
            ((URLImageView)localObject1).setAdjustViewBounds(false);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = new ImageView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((ImageView)localObject1).setId(2131230815);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(7, 2131230814);
            ((RelativeLayout.LayoutParams)localObject2).addRule(8, 2131230814);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            localObject1 = new ImageView(EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
            ((ImageView)localObject1).setId(2131230817);
            localObject2 = new RelativeLayout.LayoutParams(-2, -2);
            ((RelativeLayout.LayoutParams)localObject2).addRule(5, 2131230818);
            ((RelativeLayout.LayoutParams)localObject2).addRule(6, 2131230818);
            localRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
            break label266;
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
    QLog.d("EmoticonLinearLayout", 2, "[Performance] EmoticonLinearLayout create duration: " + (System.currentTimeMillis() - l1) + ", type=" + EmoticonLinearLayout.a(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     foe
 * JD-Core Version:    0.7.0.1
 */