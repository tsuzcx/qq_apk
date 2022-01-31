import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.EmosmDetailActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import java.util.ArrayList;
import java.util.List;

public class clc
  extends BaseAdapter
{
  public static final int a = 8;
  private float jdField_a_of_type_Float;
  private List jdField_a_of_type_JavaUtilList;
  private int b = 0;
  
  public clc(EmosmDetailActivity paramEmosmDetailActivity, ArrayList paramArrayList)
  {
    if (paramArrayList.size() <= 8) {}
    for (this.jdField_a_of_type_JavaUtilList = paramArrayList;; this.jdField_a_of_type_JavaUtilList = paramArrayList.subList(0, 8))
    {
      this.jdField_a_of_type_Float = paramEmosmDetailActivity.a.getResources().getDisplayMetrics().density;
      return;
    }
  }
  
  public int getCount()
  {
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public Object getItem(int paramInt)
  {
    return this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramInt == 0) {}
    for (this.b += 1; this.b > 1; this.b = 0)
    {
      paramViewGroup = paramView;
      if (paramView == null) {
        paramViewGroup = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.a);
      }
      return paramViewGroup;
    }
    if (paramView == null) {
      paramView = new ImageView(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.a);
    }
    for (;;)
    {
      paramView = (ImageView)paramView;
      paramView.setLayoutParams(new AbsListView.LayoutParams(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.d, this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.e));
      paramViewGroup = (Emoticon)getItem(paramInt);
      PicEmoticonInfo localPicEmoticonInfo = new PicEmoticonInfo(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.b.a());
      localPicEmoticonInfo.a = paramViewGroup;
      paramViewGroup = localPicEmoticonInfo.b(this.jdField_a_of_type_ComTencentMobileqqActivityEmosmDetailActivity.a, this.jdField_a_of_type_Float);
      if ((paramViewGroup instanceof URLDrawable)) {
        ((URLDrawable)paramViewGroup).setURLDrawableListener(new cld(this, paramView));
      }
      paramView.setImageDrawable(paramViewGroup);
      return paramView;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     clc
 * JD-Core Version:    0.7.0.1
 */