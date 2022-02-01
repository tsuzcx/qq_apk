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

public class tty
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
  
  public tty()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131167092);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static tty a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    tty localtty = new tty();
    localtty.jdField_a_of_type_Boolean = true;
    localtty.jdField_a_of_type_JavaLangString = paramRecentUser.getRecentUserUin();
    localtty.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localtty.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localtty.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localtty.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localtty.jdField_b_of_type_Long = paramRecentUser.getLastMsgTime();
    localtty.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localtty.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(localtty.jdField_a_of_type_JavaLangString, 1008);
    localtty.jdField_d_of_type_JavaLangString = tue.a(paramQQAppInterface, localtty.jdField_a_of_type_JavaLangString);
    localtty.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localtty);
    b(paramQQAppInterface, localtty);
    c(paramQQAppInterface, localtty);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localtty.toString());
    }
    return localtty;
  }
  
  public static tty a(QQAppInterface paramQQAppInterface, twg paramtwg)
  {
    tty localtty = new tty();
    localtty.jdField_a_of_type_Boolean = false;
    localtty.jdField_a_of_type_JavaLangString = paramtwg.jdField_a_of_type_JavaLangString;
    localtty.jdField_b_of_type_Int = paramtwg.jdField_b_of_type_Int;
    localtty.jdField_c_of_type_Int = 0;
    localtty.jdField_a_of_type_Long = paramtwg.jdField_a_of_type_Long;
    localtty.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramtwg.jdField_a_of_type_JavaLangString, paramtwg.jdField_a_of_type_Long);
    String str2 = twi.a().a(paramtwg.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramtwg.jdField_a_of_type_JavaLangString;
    }
    localtty.jdField_c_of_type_JavaLangString = str1;
    if (paramtwg.jdField_a_of_type_JavaUtilList.size() > 0) {
      localtty.jdField_a_of_type_JavaLangCharSequence = ((twh)paramtwg.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.a().b(paramtwg.jdField_a_of_type_JavaLangString, 1008);
    localtty.jdField_d_of_type_JavaLangString = tue.a(paramQQAppInterface, paramtwg.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localtty);
    b(paramQQAppInterface, localtty);
    c(paramQQAppInterface, localtty);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localtty.toString());
    }
    return localtty;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, tty paramtty)
  {
    paramQQAppInterface = (anrs)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramtty.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramtty.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramtty.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramtty.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramtty.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramtty.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramtty.jdField_b_of_type_Boolean = bool;
      paramtty.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, tty paramtty)
  {
    int i = paramQQAppInterface.a().g(paramtty.jdField_a_of_type_JavaLangString, 1008);
    if (paramtty.jdField_b_of_type_Int > 0)
    {
      if ((paramtty.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramtty.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramtty.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramtty.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, tty paramtty)
  {
    paramQQAppInterface = paramQQAppInterface.a();
    if (paramQQAppInterface != null)
    {
      paramtty.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramtty.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramtty.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramtty.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramtty.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramtty.jdField_e_of_type_Int = 4;
    paramtty.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramtty.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramtty.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramtty.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
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
 * Qualified Name:     tty
 * JD-Core Version:    0.7.0.1
 */