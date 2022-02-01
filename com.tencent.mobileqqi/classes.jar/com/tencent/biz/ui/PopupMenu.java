package com.tencent.biz.ui;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.PopupWindow;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import bod;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.international.LocaleString;
import java.util.ArrayList;
import java.util.List;

public class PopupMenu
  extends PopupWindows
{
  public static final int a = 1;
  public static final int b = 2;
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  private LayoutInflater jdField_a_of_type_AndroidViewLayoutInflater;
  private ViewGroup jdField_a_of_type_AndroidViewViewGroup;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  public CustomMenuBar.OnMenuItemClickListener a;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private int f;
  private int g;
  
  public PopupMenu(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidViewLayoutInflater = ((LayoutInflater)paramContext.getSystemService("layout_inflater"));
    a(2130903225);
    this.g = 4;
    this.f = 0;
  }
  
  private void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int i = this.jdField_a_of_type_AndroidWidgetImageView.getMeasuredWidth();
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_AndroidWidgetImageView.getLayoutParams();
    if (paramInt3 > paramInt1)
    {
      if (paramInt3 > paramInt2 * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 - i / 2);
        return;
      }
      if (paramInt3 > (paramInt4 - paramInt2) * 2)
      {
        localLayoutParams.leftMargin = (paramInt2 + paramInt3 - paramInt4 - i / 2);
        return;
      }
      localLayoutParams.addRule(14);
      return;
    }
    localLayoutParams.addRule(14);
  }
  
  private void a(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    switch (this.g)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidWidgetPopupWindow.setAnimationStyle(2131624162);
  }
  
  public MenuItem a(int paramInt)
  {
    return (MenuItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_AndroidViewView = ((ViewGroup)this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(paramInt, null));
    this.jdField_a_of_type_AndroidViewViewGroup = ((ViewGroup)this.jdField_a_of_type_AndroidViewView.findViewById(2131231672));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)this.jdField_a_of_type_AndroidViewView.findViewById(2131231673));
    this.jdField_a_of_type_AndroidViewView.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
    super.b(this.jdField_a_of_type_AndroidViewView);
  }
  
  public void a(View paramView)
  {
    a();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    Rect localRect = new Rect(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    this.jdField_a_of_type_AndroidViewView.measure(-2, -2);
    int i = this.jdField_a_of_type_AndroidViewView.getMeasuredWidth();
    int j = this.jdField_a_of_type_AndroidViewView.getMeasuredHeight();
    int k = this.jdField_a_of_type_AndroidViewWindowManager.getDefaultDisplay().getWidth();
    int m = arrayOfInt[0];
    int n = (paramView.getWidth() - i) / 2;
    int i1 = localRect.top;
    a(paramView.getWidth(), localRect.centerX(), i, k);
    a(k, localRect.centerX(), true);
    this.jdField_a_of_type_AndroidWidgetPopupWindow.showAtLocation(paramView, 0, m + n, i1 - j);
  }
  
  public void a(CustomMenuBar.OnMenuItemClickListener paramOnMenuItemClickListener)
  {
    this.jdField_a_of_type_ComTencentBizUiCustomMenuBar$OnMenuItemClickListener = paramOnMenuItemClickListener;
  }
  
  public void a(MenuItem paramMenuItem)
  {
    this.jdField_a_of_type_JavaUtilList.add(paramMenuItem);
    String str = paramMenuItem.a();
    Drawable localDrawable = paramMenuItem.a();
    if (this.f != 0)
    {
      localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
      ((ImageView)localObject1).setBackgroundResource(2130837985);
      localObject2 = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    Object localObject1 = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2130903224, null);
    ImageView localImageView = (ImageView)((View)localObject1).findViewById(2131231668);
    Object localObject2 = (TextView)((View)localObject1).findViewById(2131231669);
    if (localDrawable != null)
    {
      localImageView.setImageDrawable(localDrawable);
      if (str == null) {
        break label249;
      }
      str = LocaleString.o(this.jdField_a_of_type_AndroidContentContext, str);
      if (SubString.a(str) <= 18) {
        break label240;
      }
      ((TextView)localObject2).setText(SubString.a(str, 18, "..."));
    }
    for (;;)
    {
      ((View)localObject1).setOnClickListener(new bod(this, paramMenuItem.b(), paramMenuItem.a()));
      ((View)localObject1).setFocusable(true);
      ((View)localObject1).setClickable(true);
      paramMenuItem = new LinearLayout.LayoutParams(-1, -2, 1.0F);
      paramMenuItem.gravity = 17;
      ((View)localObject1).setLayoutParams(paramMenuItem);
      this.jdField_a_of_type_AndroidViewViewGroup.addView((View)localObject1);
      this.f += 1;
      return;
      localImageView.setVisibility(8);
      break;
      label240:
      ((TextView)localObject2).setText(str);
      continue;
      label249:
      ((TextView)localObject2).setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.biz.ui.PopupMenu
 * JD-Core Version:    0.7.0.1
 */