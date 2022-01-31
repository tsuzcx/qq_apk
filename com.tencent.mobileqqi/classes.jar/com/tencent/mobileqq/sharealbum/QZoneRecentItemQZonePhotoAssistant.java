package com.tencent.mobileqq.sharealbum;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.MsgSummary;
import com.tencent.mobileqq.activity.recent.data.RecentUserBaseData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class QZoneRecentItemQZonePhotoAssistant
  extends RecentUserBaseData
{
  private static final String f = "RecentItemQZonePhotoAssistant";
  
  public QZoneRecentItemQZonePhotoAssistant(RecentUser paramRecentUser)
  {
    super(paramRecentUser);
  }
  
  public QZoneRecentItemQZonePhotoAssistant(RecentUser paramRecentUser, QQAppInterface paramQQAppInterface, Context paramContext)
  {
    super(paramRecentUser);
    a(paramQQAppInterface, paramContext);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext)
  {
    if ((paramQQAppInterface == null) || (paramContext == null)) {
      return;
    }
    a(paramQQAppInterface);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) {
      this.jdField_a_of_type_JavaLangString = paramQQAppInterface.getApplication().getApplicationContext().getString(2131562911);
    }
    this.A = QZoneShareAlbumAssistantManager.a().a();
    this.jdField_a_of_type_Long = QZoneShareAlbumAssistantManager.a().b();
    MsgSummary localMsgSummary = new MsgSummary();
    localMsgSummary.b = QZoneShareAlbumAssistantManager.a().a();
    if (TextUtils.isEmpty(localMsgSummary.b)) {
      localMsgSummary.b = " ";
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("RecentItemQZonePhotoAssistant", 4, "ShareAlbum time:" + this.jdField_a_of_type_Long + " text:" + localMsgSummary.b + " mUnreadNum:" + this.A);
    }
    a(paramQQAppInterface);
    a(paramQQAppInterface, localMsgSummary);
    a(paramQQAppInterface, paramContext, localMsgSummary);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.sharealbum.QZoneRecentItemQZonePhotoAssistant
 * JD-Core Version:    0.7.0.1
 */