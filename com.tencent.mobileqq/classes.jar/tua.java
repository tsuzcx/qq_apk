import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class tua
{
  public int a;
  public long a;
  public MessageRecord a;
  public CharSequence a;
  public String a;
  public boolean a;
  public int b;
  public long b;
  @notColumn
  public CharSequence b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public int d;
  public String d;
  @notColumn
  public int e;
  public String e;
  
  public tua()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131167102);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static tua a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    tua localtua = new tua();
    localtua.jdField_a_of_type_Boolean = true;
    localtua.jdField_a_of_type_JavaLangString = paramRecentUser.getRecentUserUin();
    localtua.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localtua.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localtua.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localtua.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localtua.jdField_b_of_type_Long = paramRecentUser.getLastMsgTime();
    localtua.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localtua.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localtua.jdField_a_of_type_JavaLangString, 1008);
    localtua.jdField_d_of_type_JavaLangString = tug.a(paramQQAppInterface, localtua.jdField_a_of_type_JavaLangString);
    localtua.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localtua);
    b(paramQQAppInterface, localtua);
    c(paramQQAppInterface, localtua);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localtua.toString());
    }
    return localtua;
  }
  
  public static tua a(QQAppInterface paramQQAppInterface, twi paramtwi)
  {
    tua localtua = new tua();
    localtua.jdField_a_of_type_Boolean = false;
    localtua.jdField_a_of_type_JavaLangString = paramtwi.jdField_a_of_type_JavaLangString;
    localtua.jdField_b_of_type_Int = paramtwi.jdField_b_of_type_Int;
    localtua.jdField_c_of_type_Int = 0;
    localtua.jdField_a_of_type_Long = paramtwi.jdField_a_of_type_Long;
    localtua.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramtwi.jdField_a_of_type_JavaLangString, paramtwi.jdField_a_of_type_Long);
    String str2 = twk.a().a(paramtwi.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramtwi.jdField_a_of_type_JavaLangString;
    }
    localtua.jdField_c_of_type_JavaLangString = str1;
    if (paramtwi.jdField_a_of_type_JavaUtilList.size() > 0) {
      localtua.jdField_a_of_type_JavaLangCharSequence = ((twj)paramtwi.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramtwi.jdField_a_of_type_JavaLangString, 1008);
    localtua.jdField_d_of_type_JavaLangString = tug.a(paramQQAppInterface, paramtwi.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localtua);
    b(paramQQAppInterface, localtua);
    c(paramQQAppInterface, localtua);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localtua.toString());
    }
    return localtua;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, tua paramtua)
  {
    paramQQAppInterface = (aody)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramtua.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramtua.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramtua.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramtua.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramtua.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramtua.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramtua.jdField_b_of_type_Boolean = bool;
      paramtua.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, tua paramtua)
  {
    int i = paramQQAppInterface.a().g(paramtua.jdField_a_of_type_JavaLangString, 1008);
    if (paramtua.jdField_b_of_type_Int > 0)
    {
      if ((paramtua.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramtua.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramtua.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramtua.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, tua paramtua)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramtua.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramtua.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramtua.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramtua.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramtua.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramtua.jdField_e_of_type_Int = 4;
    paramtua.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramtua.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramtua.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramtua.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
  }
  
  public final boolean a()
  {
    return (this.jdField_a_of_type_Int == 1) || (this.jdField_a_of_type_Int == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServiceAccountFolderFeed content->");
    localStringBuilder.append("mIsCreateFromMessageTab:" + this.jdField_a_of_type_Boolean);
    localStringBuilder.append(", mUin:" + this.jdField_a_of_type_JavaLangString);
    localStringBuilder.append(", mUnreadFlag:" + this.jdField_a_of_type_Int);
    localStringBuilder.append(", mUnreadNum:" + this.jdField_b_of_type_Int);
    localStringBuilder.append(", mAuthenIconId:" + this.jdField_c_of_type_Int);
    localStringBuilder.append(", mShowTime:" + this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mTitleName:" + this.jdField_c_of_type_JavaLangString);
    localStringBuilder.append(", mMsgBrief:" + this.jdField_a_of_type_JavaLangCharSequence);
    localStringBuilder.append(", mMsgExtraInfo:" + this.jdField_d_of_type_JavaLangString);
    localStringBuilder.append(", mDraft:" + this.jdField_b_of_type_JavaLangCharSequence);
    localStringBuilder.append(", mStatus:" + this.jdField_e_of_type_Int);
    localStringBuilder.append(", mDisplayTime:" + this.jdField_a_of_type_Long);
    localStringBuilder.append(", mOperationTime:" + this.jdField_b_of_type_Long);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tua
 * JD-Core Version:    0.7.0.1
 */