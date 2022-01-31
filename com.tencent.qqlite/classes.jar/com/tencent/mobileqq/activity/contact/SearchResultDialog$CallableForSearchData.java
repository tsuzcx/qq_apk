package com.tencent.mobileqq.activity.contact;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.FriendManager;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

public class SearchResultDialog$CallableForSearchData
  implements Callable
{
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private SearchResultDialog jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public SearchResultDialog$CallableForSearchData(SearchResultDialog paramSearchResultDialog, Context paramContext, QQAppInterface paramQQAppInterface, long paramLong, int paramInt)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog = paramSearchResultDialog;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public List a()
  {
    ArrayList localArrayList = new ArrayList();
    if ((FriendManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(8) == null) {
      return localArrayList;
    }
    if (34359738368L == this.jdField_a_of_type_Long) {
      localArrayList.addAll(SearchResultDialog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, false, null));
    }
    for (;;)
    {
      return localArrayList;
      if (30064771072L == this.jdField_a_of_type_Long)
      {
        localArrayList.addAll(SearchResultDialog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long));
      }
      else if (25769803776L == this.jdField_a_of_type_Long)
      {
        localArrayList.addAll(SearchResultDialog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Long, this.jdField_a_of_type_Int, null, this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.a()));
      }
      else if (17179869184L == this.jdField_a_of_type_Long)
      {
        localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.b(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 17179869184L, this.jdField_a_of_type_Int));
        localArrayList.addAll(this.jdField_a_of_type_ComTencentMobileqqActivityContactSearchResultDialog.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 17179869184L, this.jdField_a_of_type_Int));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contact.SearchResultDialog.CallableForSearchData
 * JD-Core Version:    0.7.0.1
 */