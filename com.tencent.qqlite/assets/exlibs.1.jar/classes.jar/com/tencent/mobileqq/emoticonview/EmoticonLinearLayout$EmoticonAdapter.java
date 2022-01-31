package com.tencent.mobileqq.emoticonview;

import android.view.ViewGroup;
import android.widget.RelativeLayout;
import java.util.List;

public abstract class EmoticonLinearLayout$EmoticonAdapter
{
  int jdField_a_of_type_Int;
  EmoticonInfo jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  EmoticonLinearLayout.DataObserver jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver;
  List jdField_a_of_type_JavaUtilList;
  boolean jdField_a_of_type_Boolean;
  int jdField_b_of_type_Int;
  EmoticonInfo jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  boolean jdField_b_of_type_Boolean;
  int jdField_c_of_type_Int;
  EmoticonInfo jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  boolean jdField_c_of_type_Boolean;
  int jdField_d_of_type_Int;
  boolean jdField_d_of_type_Boolean;
  boolean e;
  
  public int a()
  {
    return this.jdField_c_of_type_Int;
  }
  
  public int a(int paramInt)
  {
    int j = -3;
    int i;
    if (this.jdField_a_of_type_Boolean) {
      if ((paramInt + 1) % this.jdField_d_of_type_Int == 0) {
        i = -1;
      }
    }
    do
    {
      do
      {
        return i;
        return this.jdField_c_of_type_Int * (this.jdField_d_of_type_Int - 1) + paramInt;
        if ((this.jdField_c_of_type_Boolean) && (this.jdField_c_of_type_Int * this.jdField_d_of_type_Int + paramInt - this.jdField_a_of_type_JavaUtilList.size() == 0)) {
          return -2;
        }
        if ((!this.jdField_c_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
          break;
        }
        i = j;
      } while (1 == this.jdField_c_of_type_Int * this.jdField_d_of_type_Int + paramInt - this.jdField_a_of_type_JavaUtilList.size());
      if ((this.jdField_c_of_type_Boolean) || (!this.jdField_b_of_type_Boolean)) {
        break;
      }
      i = j;
    } while (this.jdField_c_of_type_Int * this.jdField_d_of_type_Int + paramInt - this.jdField_a_of_type_JavaUtilList.size() == 0);
    return this.jdField_c_of_type_Int * this.jdField_d_of_type_Int + paramInt;
  }
  
  public EmoticonInfo a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  }
  
  public EmoticonInfo a(int paramInt)
  {
    paramInt = a(paramInt);
    if (paramInt == -1) {
      return this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
    }
    if (paramInt == -2) {
      return this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
    }
    if (paramInt == -3) {
      return this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
    }
    if ((this.jdField_a_of_type_JavaUtilList != null) && (paramInt < this.jdField_a_of_type_JavaUtilList.size())) {
      return (EmoticonInfo)this.jdField_a_of_type_JavaUtilList.get(paramInt);
    }
    return null;
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver != null) {
      this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver.a();
    }
  }
  
  public void a(int paramInt)
  {
    this.jdField_c_of_type_Int = paramInt;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Int = paramInt1;
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_d_of_type_Int = (paramInt2 * paramInt1);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver.a(paramInt1, paramInt2);
  }
  
  public abstract void a(int paramInt, RelativeLayout paramRelativeLayout, ViewGroup paramViewGroup);
  
  public void a(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
  }
  
  void a(EmoticonLinearLayout.DataObserver paramDataObserver)
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewEmoticonLinearLayout$DataObserver = paramDataObserver;
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_d_of_type_Boolean = paramBoolean;
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public int b()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public EmoticonInfo b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  }
  
  public void b(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_b_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
  }
  
  public void b(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public boolean b()
  {
    return this.jdField_b_of_type_Boolean;
  }
  
  public int c()
  {
    return this.jdField_b_of_type_Int;
  }
  
  public EmoticonInfo c()
  {
    return this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo;
  }
  
  public void c(EmoticonInfo paramEmoticonInfo)
  {
    this.jdField_c_of_type_ComTencentMobileqqEmoticonviewEmoticonInfo = paramEmoticonInfo;
  }
  
  public void c(boolean paramBoolean)
  {
    this.jdField_b_of_type_Boolean = paramBoolean;
  }
  
  public boolean c()
  {
    return this.jdField_c_of_type_Boolean;
  }
  
  public void d(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonLinearLayout.EmoticonAdapter
 * JD-Core Version:    0.7.0.1
 */