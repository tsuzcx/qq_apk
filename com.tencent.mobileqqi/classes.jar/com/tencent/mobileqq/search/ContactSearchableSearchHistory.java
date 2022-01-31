package com.tencent.mobileqq.search;

import android.graphics.drawable.Drawable;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.SearchHistory;

public class ContactSearchableSearchHistory
  extends IContactSearchable
{
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private SearchHistory jdField_a_of_type_ComTencentMobileqqDataSearchHistory;
  
  public ContactSearchableSearchHistory(QQAppInterface paramQQAppInterface, SearchHistory paramSearchHistory)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory = paramSearchHistory;
  }
  
  public int a()
  {
    return 0;
  }
  
  public Drawable a()
  {
    return null;
  }
  
  public SearchHistory a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.extralInfo;
  }
  
  public void a(String paramString) {}
  
  public int b()
  {
    switch (this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.type)
    {
    default: 
      return 1;
    case 3000: 
      return 101;
    case 1: 
      return 4;
    }
    return 11;
  }
  
  public String b()
  {
    return null;
  }
  
  public String c()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.displayName;
  }
  
  public String d()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.uin;
  }
  
  public String e()
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataSearchHistory.key;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.search.ContactSearchableSearchHistory
 * JD-Core Version:    0.7.0.1
 */