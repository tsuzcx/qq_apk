package com.tencent.mobileqq.troopinfo;

import java.util.ArrayList;

public class GroupCatalogBean
{
  public int a;
  public GroupCatalogBean a;
  public String a;
  public ArrayList a;
  public String b;
  
  private GroupCatalogBean() {}
  
  public GroupCatalogBean(int paramInt, String paramString1, String paramString2)
  {
    this.jdField_a_of_type_Int = paramInt;
    this.b = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
  }
  
  public String a()
  {
    String str = this.jdField_a_of_type_JavaLangString;
    GroupCatalogBean localGroupCatalogBean = this;
    while (localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean != null)
    {
      localGroupCatalogBean = localGroupCatalogBean.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean;
      str = localGroupCatalogBean.jdField_a_of_type_JavaLangString + "-" + str;
    }
    return str;
  }
  
  public void a(GroupCatalogBean paramGroupCatalogBean)
  {
    if (this.jdField_a_of_type_JavaUtilArrayList == null) {
      this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    }
    this.jdField_a_of_type_JavaUtilArrayList.add(paramGroupCatalogBean);
  }
  
  public boolean a(GroupCatalogBean paramGroupCatalogBean)
  {
    if ((paramGroupCatalogBean != null) && (paramGroupCatalogBean.jdField_a_of_type_Int + 1 == this.jdField_a_of_type_Int))
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopinfoGroupCatalogBean = paramGroupCatalogBean;
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.troopinfo.GroupCatalogBean
 * JD-Core Version:    0.7.0.1
 */