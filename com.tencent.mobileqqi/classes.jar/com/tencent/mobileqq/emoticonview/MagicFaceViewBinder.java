package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.GridView;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.emoticon.EmoticonController;
import java.util.Iterator;
import java.util.List;

public class MagicFaceViewBinder
  extends EmoticonPanelViewBinder
{
  private static final String jdField_a_of_type_JavaLangString = "MagicFaceViewBinder";
  public static final int o = 2;
  public static final int p = 4;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private EmoticonCallback jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback;
  private EmoticonGridViewAdapter jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter;
  private List jdField_a_of_type_JavaUtilList = null;
  private boolean jdField_a_of_type_Boolean;
  
  public MagicFaceViewBinder(QQAppInterface paramQQAppInterface, Context paramContext, EmoticonCallback paramEmoticonCallback, int paramInt)
  {
    super(paramContext, 9, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonCallback = paramEmoticonCallback;
    paramQQAppInterface = EmoticonUtils.a(paramQQAppInterface);
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_Boolean = paramQQAppInterface.getBoolean("plusbutton", false);
    }
  }
  
  private void f()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    EmoticonController localEmoticonController = EmoticonController.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    if (localIterator.hasNext())
    {
      PicEmoticonInfo localPicEmoticonInfo = (PicEmoticonInfo)localIterator.next();
      float f = localEmoticonController.a(localPicEmoticonInfo.a.epId);
      if ((f >= 0.0F) && (f != 1.0F)) {}
      for (boolean bool = true;; bool = false)
      {
        localPicEmoticonInfo.b = bool;
        break;
      }
    }
  }
  
  protected int a(int paramInt)
  {
    return 2008;
  }
  
  public Drawable a(Context paramContext)
  {
    return null;
  }
  
  public List a()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    return this.jdField_a_of_type_JavaUtilList;
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
      return;
      i = a(paramInt);
    } while ((i != 2008) || (paramInt >= b()));
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
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.d(i);
    paramView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter);
  }
  
  public int b()
  {
    int k = 0;
    if (this.jdField_a_of_type_JavaUtilList == null) {
      this.jdField_a_of_type_JavaUtilList = EmoticonUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    }
    int j = this.jdField_a_of_type_JavaUtilList.size() + 1;
    int i = j;
    if (this.jdField_a_of_type_Boolean) {
      i = j + 1;
    }
    j = k;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      j = k;
      if (i > 0)
      {
        k = 0 + i / 8;
        j = k;
        if (i % 8 != 0) {
          return k + 1;
        }
      }
    }
    return j;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) {}
    while (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter == null) {
      return;
    }
    f();
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
  }
  
  public void c()
  {
    this.jdField_a_of_type_JavaUtilList = EmoticonUtils.d(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
  }
  
  public void d()
  {
    f();
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonGridViewAdapter.a(this.jdField_a_of_type_JavaUtilList);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.MagicFaceViewBinder
 * JD-Core Version:    0.7.0.1
 */