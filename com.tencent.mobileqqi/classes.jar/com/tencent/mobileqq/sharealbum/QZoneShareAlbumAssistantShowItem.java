package com.tencent.mobileqq.sharealbum;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.TimeFormatterUtils;
import com.tencent.qphone.base.util.QLog;

public class QZoneShareAlbumAssistantShowItem
  extends RecentBaseData
{
  private static final String f = "ShareAlbumAssistantShowItem";
  public QZoneShareAlbumAssistantItemData a;
  
  public QZoneShareAlbumAssistantShowItem(QZoneShareAlbumAssistantItemData paramQZoneShareAlbumAssistantItemData, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if (paramQZoneShareAlbumAssistantItemData == null) {
      throw new NullPointerException("ShareAlbumAssistantItemData is null");
    }
    this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData = paramQZoneShareAlbumAssistantItemData;
    a(paramQQAppInterface, paramContext);
  }
  
  public int a()
  {
    return 0;
  }
  
  public int a(QZoneShareAlbumAssistantShowItem paramQZoneShareAlbumAssistantShowItem)
  {
    return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.compareTo(paramQZoneShareAlbumAssistantShowItem.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData);
  }
  
  public long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.albumID;
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null) || (this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData == null)) {
      return;
    }
    this.d = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.url;
    this.A = ((int)this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.unreadCount);
    this.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.albumName;
    this.jdField_a_of_type_Long = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.lastmsgtime;
    this.e = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.users;
    this.E = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.userCount;
    MsgSummary localMsgSummary = new MsgSummary();
    localMsgSummary.jdField_b_of_type_JavaLangCharSequence = this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.desc;
    if (TextUtils.isEmpty(localMsgSummary.jdField_b_of_type_JavaLangCharSequence))
    {
      this.jdField_a_of_type_Long = 0L;
      localMsgSummary.jdField_b_of_type_JavaLangCharSequence = "";
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShareAlbumAssistantShowItem", 2, "ShareAlbum time:" + this.jdField_a_of_type_Long + " text:" + localMsgSummary.jdField_b_of_type_JavaLangCharSequence + " url:" + this.jdField_a_of_type_ComTencentMobileqqSharealbumQZoneShareAlbumAssistantItemData.url);
    }
    a(paramQQAppInterface, localMsgSummary);
    a(paramQQAppInterface, paramContext, localMsgSummary);
  }
  
  protected void a(QQAppInterface paramQQAppInterface, Context paramContext, MsgSummary paramMsgSummary)
  {
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = a();
    }
    if (paramMsgSummary != null) {
      this.jdField_b_of_type_JavaLangCharSequence = paramMsgSummary.a(paramContext);
    }
    if ((this.jdField_a_of_type_Long > 0L) && (this.jdField_a_of_type_Long != 9223372036854775806L)) {
      this.jdField_b_of_type_JavaLangString = TimeFormatterUtils.a(this.jdField_a_of_type_Long * 1000L);
    }
  }
  
  public boolean a()
  {
    return false;
  }
  
  public long b()
  {
    return 0L;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      return true;
      if ((paramObject == null) || (!(paramObject instanceof QZoneShareAlbumAssistantShowItem))) {
        return false;
      }
    } while (a((QZoneShareAlbumAssistantShowItem)paramObject) == 0);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneShareAlbumAssistantShowItem
 * JD-Core Version:    0.7.0.1
 */