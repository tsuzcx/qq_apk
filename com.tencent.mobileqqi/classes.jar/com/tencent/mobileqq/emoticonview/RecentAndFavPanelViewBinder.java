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

public class RecentAndFavPanelViewBinder
  extends EmoticonPanelViewBinder
{
  private static final String jdField_a_of_type_JavaLangString = "RecentAndFavPanelViewBinder";
  private static final int p = 2;
  private static final int q = 4;
  private static final int r = 140;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonGridViewAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  private List b = null;
  private int o;
  private int s;
  private int t;
  
  public RecentAndFavPanelViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, EmoticonCallback paramEmoticonCallback, int paramInt2)
  {
    super(paramContext, 4, paramInt2);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.o = paramInt1;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
  }
  
  public int a()
  {
    a(false);
    if ((this.s == 0) && (this.t == 0)) {
      return 0;
    }
    return b();
  }
  
  protected int a(int paramInt)
  {
    a(false);
    return 2009;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839158);
    paramContext = paramContext.getResources().getDrawable(2130839159);
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
      List localList;
      do
      {
        do
        {
          return;
          i = a(paramInt);
          if (i != 2009) {
            break;
          }
        } while (paramInt >= b());
        a(true);
        localList = null;
      } while ((this.s == 0) && (this.t == 0));
      if ((this.s != 0) && (this.t == 0)) {
        if (paramInt == 0) {
          localList = this.jdField_a_of_type_JavaUtilList;
        }
      }
      for (;;)
      {
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
        if (paramInt == 0) {
          localList = this.jdField_a_of_type_JavaUtilList;
        } else {
          localList = this.b;
        }
      }
    } while (i != 2003);
  }
  
  public void a(boolean paramBoolean)
  {
    long l = System.currentTimeMillis();
    if ((this.jdField_a_of_type_JavaUtilList == null) || (paramBoolean)) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.o);
    }
    if ((this.b == null) || (paramBoolean))
    {
      this.b = FavoriteEmoticonInfo.a((BaseActivity)this.jdField_a_of_type_AndroidContentContext);
      if (this.b.size() > 140) {
        this.b = this.b.subList(0, 140);
      }
    }
    if (this.jdField_a_of_type_JavaUtilList != null) {
      this.s = this.jdField_a_of_type_JavaUtilList.size();
    }
    if (this.b != null) {
      this.t = this.b.size();
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentAndFavPanelViewBinder", 2, "[Performance] updateData, duration=" + (System.currentTimeMillis() - l));
    }
  }
  
  public int b()
  {
    return 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecentAndFavPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */