import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class uxx
  extends BaseAdapter
{
  public uxx(uxv paramuxv) {}
  
  public uyf a(int paramInt)
  {
    if (uxv.a != null) {
      return (uyf)uxv.a.get(paramInt);
    }
    return null;
  }
  
  public int getCount()
  {
    if (uxv.a != null) {
      return uxv.a.size();
    }
    return 0;
  }
  
  public long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView;
    Object localObject1;
    Object localObject2;
    int i;
    if (paramView == null)
    {
      localView = LayoutInflater.from(uxv.a()).inflate(2131559595, paramViewGroup, false);
      paramView = new uxy(this);
      localObject1 = localView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject1).height = ((uxv.b() - agej.a(110.0F, uxv.a().getResources())) / 3);
      localView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of item is" + ((ViewGroup.LayoutParams)localObject1).height);
      }
      paramView.jdField_a_of_type_ComTencentImageURLImageView = ((URLImageView)localView.findViewById(2131376335));
      localObject2 = paramView.jdField_a_of_type_ComTencentImageURLImageView.getLayoutParams();
      ((ViewGroup.LayoutParams)localObject2).width = ((uxv.c() - agej.a(2.0F, uxv.a().getResources())) / 2);
      ((ViewGroup.LayoutParams)localObject2).height = (((ViewGroup.LayoutParams)localObject2).width * 9 / 16);
      paramView.jdField_a_of_type_ComTencentImageURLImageView.setLayoutParams((ViewGroup.LayoutParams)localObject2);
      if (QLog.isColorLevel()) {
        QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "height of image is" + ((ViewGroup.LayoutParams)localObject2).height);
      }
      paramView.jdField_a_of_type_AndroidWidgetTextView = ((TextView)localView.findViewById(2131376351));
      if (((ViewGroup.LayoutParams)localObject1).height - ((ViewGroup.LayoutParams)localObject2).height - agej.a(40.0F, uxv.a().getResources()) > agej.a(16.0F, uxv.a().getResources()))
      {
        i = 2;
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, " number is" + i);
        }
        if ((Build.MANUFACTURER.toLowerCase().contains("meizu")) && (Build.VERSION.SDK_INT <= 16))
        {
          if (QLog.isColorLevel()) {
            QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "this is meizu");
          }
          localObject1 = new LinearLayout.LayoutParams(-1, -2);
          ((LinearLayout.LayoutParams)localObject1).setMargins(12, 0, 12, 1);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setLayoutParams((ViewGroup.LayoutParams)localObject1);
          paramView.jdField_a_of_type_AndroidWidgetTextView.setTextSize(1, 10.0F);
        }
        paramView.jdField_a_of_type_AndroidWidgetTextView.setMaxLines(i);
        localView.setTag(paramView);
      }
    }
    for (;;)
    {
      localObject1 = a(paramInt);
      if (localObject1 != null)
      {
        localObject2 = ((uyf)localObject1).a;
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        ColorDrawable localColorDrawable = new ColorDrawable(Color.parseColor("#000000"));
        localURLDrawableOptions.mLoadingDrawable = localColorDrawable;
        localURLDrawableOptions.mFailedDrawable = localColorDrawable;
        localObject2 = URLDrawable.getDrawable((String)localObject2, localURLDrawableOptions);
        if ((localObject2 != null) && (((URLDrawable)localObject2).getStatus() == 2)) {
          ((URLDrawable)localObject2).restartDownload();
        }
        paramView.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject2);
        paramView.jdField_a_of_type_AndroidWidgetTextView.setText(((uyf)localObject1).b);
        if (QLog.isColorLevel()) {
          QLog.d("PublicAccountImageCollectionRecommendViewWrapper", 2, "recommendInfo position = " + paramInt + "; url =" + localObject2 + "; title = " + ((uyf)localObject1).b);
        }
      }
      EventCollector.getInstance().onListGetView(paramInt, localView, paramViewGroup, getItemId(paramInt));
      return localView;
      i = 1;
      break;
      localObject1 = (uxy)paramView.getTag();
      localView = paramView;
      paramView = (View)localObject1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uxx
 * JD-Core Version:    0.7.0.1
 */