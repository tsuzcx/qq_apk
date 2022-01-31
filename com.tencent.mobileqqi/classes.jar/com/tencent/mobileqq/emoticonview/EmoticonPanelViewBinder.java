package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import com.tencent.qphone.base.util.QLog;

public abstract class EmoticonPanelViewBinder
  extends EmoticonViewBinder
{
  private static EmoticonPanelViewPool jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool;
  private static final String jdField_a_of_type_JavaLangString = "EmoticonPanelViewBinder";
  public int a;
  public Context a;
  protected SparseArray a;
  protected int b;
  
  public EmoticonPanelViewBinder(Context paramContext, int paramInt1, int paramInt2)
  {
    super(paramInt1);
    if (paramContext == null) {
      throw new IllegalArgumentException("Context MUST NOT be null!!!");
    }
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
  }
  
  private boolean a(int paramInt)
  {
    switch (paramInt)
    {
    case 2002: 
    case 2003: 
    case 2004: 
    case 2005: 
    default: 
      return false;
    }
    return true;
  }
  
  public static void e()
  {
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool != null)
    {
      jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool.a();
      jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool = null;
    }
  }
  
  public int a()
  {
    return b();
  }
  
  protected abstract int a(int paramInt);
  
  protected View a(int paramInt)
  {
    Object localObject = null;
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, " createEmoticonPanelView, type=" + paramInt);
    }
    long l = System.currentTimeMillis();
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPanelViewBinder", 2, "[Performance] createEmoticonPanelView, type=" + paramInt + ",duration=" + (System.currentTimeMillis() - l));
      }
      return localObject;
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903234, null);
      try
      {
        ((ImageView)((View)localObject).findViewById(2131231702)).setImageResource(2130837629);
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        if (QLog.isColorLevel()) {
          QLog.e("EmoticonPanelViewBinder", 2, "load image error: " + localOutOfMemoryError.getMessage());
        }
      }
      continue;
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903665, null);
      continue;
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903666, null);
      continue;
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903213, null);
      continue;
      localObject = LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2130903662, null);
      continue;
      localObject = new GridView(this.jdField_a_of_type_AndroidContentContext);
    }
  }
  
  public void a()
  {
    this.jdField_a_of_type_AndroidContentContext = null;
    if (this.jdField_a_of_type_AndroidUtilSparseArray != null) {
      this.jdField_a_of_type_AndroidUtilSparseArray.clear();
    }
  }
  
  protected abstract void a(View paramView, int paramInt);
  
  protected View b(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPanelViewBinder", 2, "getEmoticonPanelView, pageIndex=" + paramInt + ",viewBinder=" + this);
    }
    int i = a(paramInt);
    View localView1 = null;
    if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool != null) {
      localView1 = jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool.a(i);
    }
    View localView2 = localView1;
    if (localView1 == null) {
      localView2 = a(i);
    }
    if (localView2 != null)
    {
      if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
        this.jdField_a_of_type_AndroidUtilSparseArray = new SparseArray();
      }
      this.jdField_a_of_type_AndroidUtilSparseArray.put(paramInt, localView2);
      a(localView2, paramInt);
    }
    return localView2;
  }
  
  public void b(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {}
    View localView;
    do
    {
      do
      {
        do
        {
          return;
          localView = (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
        } while (localView == null);
        this.jdField_a_of_type_AndroidUtilSparseArray.remove(paramInt);
        paramInt = a(paramInt);
      } while (!a(paramInt));
      if (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool == null) {
        jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool = new EmoticonPanelViewPool();
      }
    } while (jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonPanelViewPool.a(paramInt, localView));
  }
  
  protected View c(int paramInt)
  {
    if (this.jdField_a_of_type_AndroidUtilSparseArray == null) {
      return null;
    }
    return (View)this.jdField_a_of_type_AndroidUtilSparseArray.get(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelViewBinder
 * JD-Core Version:    0.7.0.1
 */