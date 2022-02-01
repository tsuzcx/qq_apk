import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zvx
  extends BaseAdapter
{
  public static final int[] a;
  public static final int[] b;
  public static final int[] c = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
  private final int jdField_a_of_type_Int = 2130839103;
  private Context jdField_a_of_type_AndroidContentContext;
  zwb jdField_a_of_type_Zwb;
  private Integer[] jdField_a_of_type_ArrayOfJavaLangInteger;
  private int b;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 43, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105 };
    jdField_b_of_type_ArrayOfInt = new int[] { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 43, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141 };
  }
  
  public zvx(Context paramContext, int paramInt1, int paramInt2, int paramInt3, int paramInt4, zwb paramzwb)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ArrayOfJavaLangInteger = new Integer[paramInt3];
    this.jdField_a_of_type_Zwb = paramzwb;
    this.jdField_b_of_type_Int = paramInt4;
    paramInt4 = 0;
    if (paramInt4 < paramInt3)
    {
      int i;
      if (paramInt4 < paramInt2)
      {
        i = jdField_b_of_type_ArrayOfInt[((paramInt1 - 1) * (paramInt3 - 1) + paramInt4)];
        int j = c[((paramInt1 - 1) * (paramInt3 - 1) + paramInt4)];
        paramContext = "f_static_";
        if (j == 1) {
          paramContext = "f";
        }
        if (i < 10)
        {
          paramContext = paramContext + "00" + i;
          label130:
          if ((i < 0) || (i >= 107)) {
            break label278;
          }
          this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt4] = Integer.valueOf(zwg.jdField_b_of_type_ArrayOfInt[i]);
          QLog.d("CommentInputPopupWindow", 2, "step1 has current id :" + this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt4] + " " + paramContext + "  ");
        }
      }
      for (;;)
      {
        paramInt4 += 1;
        break;
        if (i < 100)
        {
          paramContext = paramContext + "0" + i;
          break label130;
        }
        paramContext = paramContext + "10" + (i - 100);
        break label130;
        label278:
        this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt4] = Integer.valueOf(0);
        continue;
        this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt4] = Integer.valueOf(0);
      }
    }
    this.jdField_a_of_type_ArrayOfJavaLangInteger[(paramInt3 - 1)] = Integer.valueOf(2130839103);
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_ArrayOfJavaLangInteger.length;
  }
  
  public Object getItem(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    ImageView localImageView;
    LinearLayout localLinearLayout;
    if (paramView == null)
    {
      localImageView = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      int i = AIOUtils.dp2px(35.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
      Object localObject = new LinearLayout.LayoutParams(i, i);
      ((LinearLayout.LayoutParams)localObject).setMargins(i / 5, i / 5, i / 5, i / 5);
      localImageView.setAdjustViewBounds(false);
      localImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localLinearLayout = new LinearLayout(this.jdField_a_of_type_AndroidContentContext);
      localLinearLayout.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
      localLinearLayout.setGravity(17);
      localLinearLayout.addView(localImageView, (ViewGroup.LayoutParams)localObject);
      localObject = new zvz(this, null);
      ((zvz)localObject).a = localImageView;
      localLinearLayout.setTag(localObject);
    }
    for (;;)
    {
      localImageView = ((zvz)localLinearLayout.getTag()).a;
      try
      {
        if (this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt].intValue() != 0)
        {
          localImageView.setImageResource(this.jdField_a_of_type_ArrayOfJavaLangInteger[paramInt].intValue());
          localImageView.setVisibility(0);
        }
        for (;;)
        {
          label192:
          localImageView.setOnClickListener(new zvy(this, paramInt));
          EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
          return localLinearLayout;
          localLinearLayout = (LinearLayout)paramView;
          break;
          localImageView.setVisibility(8);
          QLog.d("CommentInputPopupWindow", 2, "set gone because of 000:");
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label192;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zvx
 * JD-Core Version:    0.7.0.1
 */