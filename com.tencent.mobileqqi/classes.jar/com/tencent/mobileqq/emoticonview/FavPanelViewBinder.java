package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class FavPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private static final String jdField_a_of_type_JavaLangString = "FavPanelViewBinder";
  private static final int p = 2;
  private static final int q = 4;
  private static final int r = 140;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonGridViewAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  private int o;
  private int s;
  
  public FavPanelViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, EmoticonCallback paramEmoticonCallback, int paramInt2)
  {
    super(paramContext, 4, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.o = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public int a()
  {
    a(false);
    return b();
  }
  
  protected int a(int paramInt)
  {
    a(true);
    if (this.s == 0) {
      return 2003;
    }
    return 2010;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839156);
    paramContext = paramContext.getResources().getDrawable(2130839157);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842913 }, paramContext);
    localStateListDrawable.addState(new int[0], localDrawable);
    return localStateListDrawable;
  }
  
  public void a()
  {
    super.a();
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = null;
  }
  
  protected void a(View paramView, int paramInt)
  {
    if (paramView == null) {}
    int i;
    do
    {
      do
      {
        do
        {
          return;
          i = a(paramInt);
          if (i != 2010) {
            break;
          }
        } while (paramInt >= b());
        a(true);
      } while (this.s == 0);
      List localList = this.jdField_a_of_type_JavaUtilList;
      paramView = (GridView)paramView;
      paramView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
      float f = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density;
      paramInt = (int)(4.0F * f);
      paramView.setPadding(paramInt, 0, paramInt, 0);
      paramView.setNumColumns(-1);
      paramView.setColumnWidth((int)(f * 82.0F));
      paramView.setGravity(17);
      paramView.setStretchMode(2);
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter == null) {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter = new EmoticonGridViewAdapter(paramView, this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      }
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(localList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.d(i);
      paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter);
      return;
    } while (i != 2003);
  }
  
  public void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramBoolean))
    {
      this.jdField_a_of_type_JavaUtilList = FavoriteEmoticonInfo.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      if (this.jdField_a_of_type_JavaUtilList.size() > 140) {
        this.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList.subList(0, 140);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.s = this.jdField_a_of_type_JavaUtilList.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FavPanelViewBinder", 2, "[Performance] updateData, duration=" + (System.currentTimeMillis() - l));
    }
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */