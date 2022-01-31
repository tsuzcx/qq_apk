package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import dgd;
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
  private EmoticonLinearLayout.EmoticonAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter;
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
    if ((this.s == 0) && (this.t == 0)) {}
    do
    {
      return 2003;
      if ((this.s == 0) || (this.t != 0)) {
        break;
      }
      if (paramInt == 0) {
        return 2009;
      }
    } while (paramInt == 1);
    return -1;
    return 2009;
  }
  
  public Drawable a(Context paramContext)
  {
    Drawable localDrawable = paramContext.getResources().getDrawable(2130839030);
    paramContext = paramContext.getResources().getDrawable(2130839031);
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
        return;
        i = a(paramInt);
        if (i != 2009) {
          break;
        }
      } while (paramInt >= b());
      a(false);
    } while ((this.s == 0) && (this.t == 0));
    List localList;
    if ((this.s != 0) && (this.t == 0))
    {
      if (paramInt != 0) {
        break label208;
      }
      localList = this.jdField_a_of_type_JavaUtilList;
      paramInt = 0;
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter = new dgd(this, 2009);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.b(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.d(false);
        this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.c(false);
      }
      paramView = (EmoticonLinearLayout)paramView;
      paramView.setCallBack(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback);
      paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(2, 4);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(paramInt);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a(localList);
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$EmoticonAdapter.a();
      return;
      if (paramInt == 0)
      {
        localList = this.jdField_a_of_type_JavaUtilList;
        paramInt = 0;
      }
      else
      {
        localList = this.b;
        paramInt -= 1;
        continue;
        if (i != 2003) {
          break;
        }
        return;
        label208:
        localList = null;
        paramInt = 0;
      }
    }
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
    int i = 1;
    a(false);
    if ((this.s == 0) && (this.t == 0)) {}
    int j;
    do
    {
      return i;
      if ((this.s != 0) && (this.t == 0)) {
        return 2;
      }
      j = 1 + this.t / 8;
      i = j;
    } while (this.t % 8 == 0);
    return j + 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.RecentAndFavPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */