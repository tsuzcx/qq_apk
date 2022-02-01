package cooperation.qzone.contentbox;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import avtd;
import avtr;
import java.util.ArrayList;

public class FootNavigationLayout
  extends LinearLayout
{
  private static final int[] tH = { 4, 5, 6 };
  private View[] A;
  private ViewGroup container;
  private ViewGroup[] f;
  private ImageView[] jdField_v_of_type_ArrayOfAndroidWidgetImageView;
  private TextView[] jdField_v_of_type_ArrayOfAndroidWidgetTextView;
  
  public FootNavigationLayout(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public FootNavigationLayout(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    LayoutInflater.from(getContext()).inflate(2131562593, this);
    this.container = ((ViewGroup)findViewById(2131369551));
    this.f = new ViewGroup[] { (ViewGroup)findViewById(2131367119), (ViewGroup)findViewById(2131377889), (ViewGroup)findViewById(2131379618) };
    this.jdField_v_of_type_ArrayOfAndroidWidgetImageView = new ImageView[] { (ImageView)findViewById(2131367120), (ImageView)findViewById(2131377890), (ImageView)findViewById(2131379619) };
    this.jdField_v_of_type_ArrayOfAndroidWidgetTextView = new TextView[] { (TextView)findViewById(2131367122), (TextView)findViewById(2131377892), (TextView)findViewById(2131379621) };
    this.A = new View[] { null, findViewById(2131365992), findViewById(2131365993) };
  }
  
  public void setArrowVisible(int paramInt)
  {
    ImageView[] arrayOfImageView = this.jdField_v_of_type_ArrayOfAndroidWidgetImageView;
    int j = arrayOfImageView.length;
    int i = 0;
    while (i < j)
    {
      ImageView localImageView = arrayOfImageView[i];
      if (localImageView != null) {
        localImageView.setVisibility(paramInt);
      }
      i += 1;
    }
  }
  
  public void setNightMode(boolean paramBoolean)
  {
    int k = 0;
    int j = 0;
    Object localObject2;
    if (paramBoolean)
    {
      this.container.setBackgroundColor(-15263977);
      localObject1 = this.jdField_v_of_type_ArrayOfAndroidWidgetTextView;
      k = localObject1.length;
      i = 0;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setTextColor(-1);
        }
        i += 1;
      }
      localObject1 = this.jdField_v_of_type_ArrayOfAndroidWidgetImageView;
      k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        if (localObject2 != null) {
          localObject2.setBackgroundResource(2130849325);
        }
        i += 1;
      }
    }
    this.container.setBackgroundColor(-1);
    Object localObject1 = this.jdField_v_of_type_ArrayOfAndroidWidgetTextView;
    j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setTextColor(-16777216);
      }
      i += 1;
    }
    localObject1 = this.jdField_v_of_type_ArrayOfAndroidWidgetImageView;
    j = localObject1.length;
    i = k;
    while (i < j)
    {
      localObject2 = localObject1[i];
      if (localObject2 != null) {
        localObject2.setBackgroundResource(2130849324);
      }
      i += 1;
    }
  }
  
  public void updateData(ArrayList<avtr> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0))
    {
      setVisibility(8);
      return;
    }
    int i = 0;
    label20:
    ViewGroup localViewGroup;
    TextView localTextView;
    View localView;
    if (i < 3)
    {
      localViewGroup = this.f[i];
      localTextView = this.jdField_v_of_type_ArrayOfAndroidWidgetTextView[i];
      localView = this.A[i];
      if (i < paramArrayList.size()) {
        break label85;
      }
      if (localViewGroup != null) {
        localViewGroup.setVisibility(8);
      }
      if (localView != null) {
        localView.setVisibility(8);
      }
    }
    for (;;)
    {
      i += 1;
      break label20;
      break;
      label85:
      avtr localavtr = (avtr)paramArrayList.get(i);
      if ((localavtr == null) || (TextUtils.isEmpty(localavtr.content)) || (TextUtils.isEmpty(localavtr.content.trim())))
      {
        if (localViewGroup != null) {
          localViewGroup.setVisibility(8);
        }
        if (localView != null) {
          localView.setVisibility(8);
        }
      }
      else
      {
        if (localViewGroup != null)
        {
          localViewGroup.setVisibility(0);
          if (localTextView != null) {
            localTextView.setText(localavtr.content);
          }
          localViewGroup.setOnClickListener(new avtd(this, localavtr, i));
        }
        if (localView != null) {
          localView.setVisibility(0);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.FootNavigationLayout
 * JD-Core Version:    0.7.0.1
 */