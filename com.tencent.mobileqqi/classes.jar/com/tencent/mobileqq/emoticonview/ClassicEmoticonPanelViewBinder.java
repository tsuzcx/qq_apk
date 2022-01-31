package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import java.util.List;

public class ClassicEmoticonPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private static final String jdField_a_of_type_JavaLangString = "ClassicEmoticonPanelViewBinder";
  private static final int o = 3;
  private static final int p = 7;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonGridViewAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  
  public ClassicEmoticonPanelViewBinder(Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 7, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  protected int a(int paramInt)
  {
    return 2007;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839153);
    paramContext = paramContext.getResources().getDrawable(2130839154);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    int i;
    do
    {
      return;
      i = a(paramInt);
    } while ((i != 2007) || (paramInt >= b()));
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = SystemAndEmojiEmoticonInfo.a();
    }
    paramView = (GridView)paramView;
    paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
    float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
    paramInt = (int)(4.0F * f);
    int j = (int)(f * 46.0F);
    paramView.setPadding(paramInt, 0, paramInt, 0);
    paramView.setNumColumns(-1);
    paramView.setColumnWidth(j);
    paramView.setGravity(17);
    paramView.setStretchMode(2);
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter = new EmoticonGridViewAdapter(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
    }
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.d(i);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter);
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.ClassicEmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */