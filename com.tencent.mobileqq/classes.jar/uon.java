import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.recent.TimeManager;
import com.tencent.mobileqq.activity.recent.data.RecentItemPublicAccountChatMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.mobileqq.data.DraftSummaryInfo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PublicAccountInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.persistence.notColumn;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class uon
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
  
  public uon()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131167138);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static uon a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    uon localuon = new uon();
    localuon.jdField_a_of_type_Boolean = true;
    localuon.jdField_a_of_type_JavaLangString = paramRecentUser.getRecentUserUin();
    localuon.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localuon.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localuon.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localuon.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localuon.jdField_b_of_type_Long = paramRecentUser.getLastMsgTime();
    localuon.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localuon.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(localuon.jdField_a_of_type_JavaLangString, 1008);
    localuon.jdField_d_of_type_JavaLangString = uot.a(paramQQAppInterface, localuon.jdField_a_of_type_JavaLangString);
    localuon.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localuon);
    b(paramQQAppInterface, localuon);
    c(paramQQAppInterface, localuon);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localuon.toString());
    }
    return localuon;
  }
  
  public static uon a(QQAppInterface paramQQAppInterface, uqv paramuqv)
  {
    uon localuon = new uon();
    localuon.jdField_a_of_type_Boolean = false;
    localuon.jdField_a_of_type_JavaLangString = paramuqv.jdField_a_of_type_JavaLangString;
    localuon.jdField_b_of_type_Int = paramuqv.jdField_b_of_type_Int;
    localuon.jdField_c_of_type_Int = 0;
    localuon.jdField_a_of_type_Long = paramuqv.jdField_a_of_type_Long;
    localuon.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramuqv.jdField_a_of_type_JavaLangString, paramuqv.jdField_a_of_type_Long);
    String str2 = uqx.a().a(paramuqv.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramuqv.jdField_a_of_type_JavaLangString;
    }
    localuon.jdField_c_of_type_JavaLangString = str1;
    if (paramuqv.jdField_a_of_type_JavaUtilList.size() > 0) {
      localuon.jdField_a_of_type_JavaLangCharSequence = ((uqw)paramuqv.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramuqv.jdField_a_of_type_JavaLangString, 1008);
    localuon.jdField_d_of_type_JavaLangString = uot.a(paramQQAppInterface, paramuqv.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localuon);
    b(paramQQAppInterface, localuon);
    c(paramQQAppInterface, localuon);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localuon.toString());
    }
    return localuon;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, uon paramuon)
  {
    paramQQAppInterface = (aoan)paramQQAppInterface.getManager(QQManagerFactory.PUBLICACCOUNTDATA_MANAGER);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramuon.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label60;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramuon.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramuon.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramuon.jdField_c_of_type_Int = 0;
    }
    label60:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramuon.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramuon.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramuon.jdField_b_of_type_Boolean = bool;
      paramuon.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, uon paramuon)
  {
    int i = paramQQAppInterface.getConversationFacade().g(paramuon.jdField_a_of_type_JavaLangString, 1008);
    if (paramuon.jdField_b_of_type_Int > 0)
    {
      if ((paramuon.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramuon.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramuon.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramuon.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, uon paramuon)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null)
    {
      paramuon.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramuon.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramuon.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramuon.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramuon.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramuon.jdField_e_of_type_Int = 4;
    paramuon.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramuon.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramuon.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramuon.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uon
 * JD-Core Version:    0.7.0.1
 */