package com.tencent.mobileqq.contactsync;

import android.content.ContentProviderOperation;
import android.content.ContentProviderOperation.Builder;
import android.content.ContentValues;
import android.net.Uri;
import android.net.Uri.Builder;
import android.provider.ContactsContract.Data;
import android.provider.ContactsContract.RawContacts;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import java.util.List;

public class ContactOperation
{
  private static String jdField_a_of_type_JavaLangString = Constants.e;
  private static final boolean jdField_a_of_type_Boolean = true;
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  private ContentValues jdField_a_of_type_AndroidContentContentValues;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private List jdField_a_of_type_JavaUtilList;
  private boolean b;
  
  private ContactOperation(QQAppInterface paramQQAppInterface, List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContentValues = new ContentValues();
  }
  
  private ContactOperation(QQAppInterface paramQQAppInterface, List paramList, long paramLong)
  {
    this(paramQQAppInterface, paramList);
    this.jdField_a_of_type_Long = paramLong;
    this.b = false;
  }
  
  private ContactOperation(QQAppInterface paramQQAppInterface, List paramList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    this(paramQQAppInterface, paramList);
    this.b = true;
    this.jdField_a_of_type_Int = paramList.size();
    paramQQAppInterface = ContentProviderOperation.newInsert(ContactsContract.RawContacts.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", "true").build()).withValue("aggregation_mode", Integer.valueOf(0)).withValue("account_type", "com.tencent.mobileqqi.account").withValue("account_name", paramString1).withValue("sourceid", paramString2).withValue("sync1", paramString3).withValue("sync2", paramString4).withValue("sync3", Integer.valueOf(paramInt1));
    this.jdField_a_of_type_JavaUtilList.add(paramQQAppInterface.build());
  }
  
  private static ContentProviderOperation.Builder a()
  {
    return ContentProviderOperation.newInsert(ContactsContract.Data.CONTENT_URI.buildUpon().appendQueryParameter("caller_is_syncadapter", jdField_a_of_type_JavaLangString).build()).withYieldAllowed(true);
  }
  
  private static ContentProviderOperation.Builder a(Uri paramUri)
  {
    return ContentProviderOperation.newUpdate(paramUri.buildUpon().appendQueryParameter("caller_is_syncadapter", jdField_a_of_type_JavaLangString).build()).withYieldAllowed(true);
  }
  
  public static ContactOperation a(QQAppInterface paramQQAppInterface, List paramList, long paramLong)
  {
    return new ContactOperation(paramQQAppInterface, paramList, paramLong);
  }
  
  public static ContactOperation a(QQAppInterface paramQQAppInterface, List paramList, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt1, int paramInt2)
  {
    return new ContactOperation(paramQQAppInterface, paramList, paramString1, paramString2, paramString3, paramString4, paramInt1, paramInt2);
  }
  
  private void a()
  {
    if (!this.b) {
      this.jdField_a_of_type_AndroidContentContentValues.put("raw_contact_id", Long.valueOf(this.jdField_a_of_type_Long));
    }
    ContentProviderOperation.Builder localBuilder = a();
    localBuilder.withValues(this.jdField_a_of_type_AndroidContentContentValues);
    if (this.b) {
      localBuilder.withValueBackReference("raw_contact_id", this.jdField_a_of_type_Int);
    }
    this.jdField_a_of_type_JavaUtilList.add(localBuilder.build());
  }
  
  private void a(Uri paramUri)
  {
    paramUri = a(paramUri);
    paramUri.withValues(this.jdField_a_of_type_AndroidContentContentValues);
    this.jdField_a_of_type_JavaUtilList.add(paramUri.build());
  }
  
  public ContactOperation a(String paramString)
  {
    this.jdField_a_of_type_AndroidContentContentValues.clear();
    this.jdField_a_of_type_AndroidContentContentValues.put("mimetype", "vnd.android.cursor.item/phone_v2");
    this.jdField_a_of_type_AndroidContentContentValues.put("data1", paramString);
    a();
    return this;
  }
  
  public ContactOperation a(String paramString, Uri paramUri)
  {
    this.jdField_a_of_type_AndroidContentContentValues.clear();
    this.jdField_a_of_type_AndroidContentContentValues.put("data1", paramString);
    a(paramUri);
    return this;
  }
  
  public ContactOperation b(String paramString)
  {
    this.jdField_a_of_type_AndroidContentContentValues.clear();
    this.jdField_a_of_type_AndroidContentContentValues.put("mimetype", "vnd.android.cursor.item/name");
    this.jdField_a_of_type_AndroidContentContentValues.put("data1", paramString);
    a();
    return this;
  }
  
  public ContactOperation c(String paramString)
  {
    this.jdField_a_of_type_AndroidContentContentValues.clear();
    this.jdField_a_of_type_AndroidContentContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mobileqq.zchat");
    this.jdField_a_of_type_AndroidContentContentValues.put("data1", paramString);
    this.jdField_a_of_type_AndroidContentContentValues.put("data2", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562389));
    this.jdField_a_of_type_AndroidContentContentValues.put("data3", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131561796));
    a();
    return this;
  }
  
  public ContactOperation d(String paramString)
  {
    this.jdField_a_of_type_AndroidContentContentValues.clear();
    this.jdField_a_of_type_AndroidContentContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mobileqq.voicecall.profile");
    this.jdField_a_of_type_AndroidContentContentValues.put("data1", paramString);
    this.jdField_a_of_type_AndroidContentContentValues.put("data2", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562389));
    this.jdField_a_of_type_AndroidContentContentValues.put("data3", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563193));
    a();
    return this;
  }
  
  public ContactOperation e(String paramString)
  {
    this.jdField_a_of_type_AndroidContentContentValues.clear();
    this.jdField_a_of_type_AndroidContentContentValues.put("mimetype", "vnd.android.cursor.item/vnd.com.tencent.mobileqq.pstn");
    this.jdField_a_of_type_AndroidContentContentValues.put("data1", paramString);
    this.jdField_a_of_type_AndroidContentContentValues.put("data2", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131562389));
    this.jdField_a_of_type_AndroidContentContentValues.put("data3", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getString(2131563194));
    a();
    return this;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.ContactOperation
 * JD-Core Version:    0.7.0.1
 */