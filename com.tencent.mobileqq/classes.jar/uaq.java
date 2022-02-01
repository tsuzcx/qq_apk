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

public class uaq
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
  
  public uaq()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_d_of_type_Int = BaseApplicationImpl.getApplication().getResources().getColor(2131167124);
    this.jdField_b_of_type_Long = 0L;
  }
  
  public static uaq a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.a(paramQQAppInterface, paramQQAppInterface.getApplication());
    uaq localuaq = new uaq();
    localuaq.jdField_a_of_type_Boolean = true;
    localuaq.jdField_a_of_type_JavaLangString = paramRecentUser.getRecentUserUin();
    localuaq.jdField_b_of_type_Int = paramRecentUser.mUnreadNum;
    localuaq.jdField_c_of_type_Int = paramRecentUser.mAuthenIconId;
    localuaq.jdField_a_of_type_Long = paramRecentUser.mDisplayTime;
    localuaq.jdField_b_of_type_JavaLangString = paramRecentUser.mShowTime;
    localuaq.jdField_b_of_type_Long = paramRecentUser.getLastMsgTime();
    localuaq.jdField_c_of_type_JavaLangString = paramRecentUser.mTitleName;
    localuaq.jdField_a_of_type_JavaLangCharSequence = paramRecentUser.mLastMsg;
    localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(localuaq.jdField_a_of_type_JavaLangString, 1008);
    localuaq.jdField_d_of_type_JavaLangString = uaw.a(paramQQAppInterface, localuaq.jdField_a_of_type_JavaLangString);
    localuaq.jdField_e_of_type_JavaLangString = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localuaq);
    b(paramQQAppInterface, localuaq);
    c(paramQQAppInterface, localuaq);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localuaq.toString());
    }
    return localuaq;
  }
  
  public static uaq a(QQAppInterface paramQQAppInterface, ucy paramucy)
  {
    uaq localuaq = new uaq();
    localuaq.jdField_a_of_type_Boolean = false;
    localuaq.jdField_a_of_type_JavaLangString = paramucy.jdField_a_of_type_JavaLangString;
    localuaq.jdField_b_of_type_Int = paramucy.jdField_b_of_type_Int;
    localuaq.jdField_c_of_type_Int = 0;
    localuaq.jdField_a_of_type_Long = paramucy.jdField_a_of_type_Long;
    localuaq.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramucy.jdField_a_of_type_JavaLangString, paramucy.jdField_a_of_type_Long);
    String str2 = uda.a().a(paramucy.jdField_a_of_type_JavaLangString);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramucy.jdField_a_of_type_JavaLangString;
    }
    localuaq.jdField_c_of_type_JavaLangString = str1;
    if (paramucy.jdField_a_of_type_JavaUtilList.size() > 0) {
      localuaq.jdField_a_of_type_JavaLangCharSequence = ((ucz)paramucy.jdField_a_of_type_JavaUtilList.get(0)).jdField_b_of_type_JavaLangString;
    }
    localuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = paramQQAppInterface.getMessageFacade().getLastMsgForMsgTab(paramucy.jdField_a_of_type_JavaLangString, 1008);
    localuaq.jdField_d_of_type_JavaLangString = uaw.a(paramQQAppInterface, paramucy.jdField_a_of_type_JavaLangString);
    a(paramQQAppInterface, localuaq);
    b(paramQQAppInterface, localuaq);
    c(paramQQAppInterface, localuaq);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localuaq.toString());
    }
    return localuaq;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, uaq paramuaq)
  {
    paramQQAppInterface = (amxz)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramuaq.jdField_a_of_type_JavaLangString);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramuaq.jdField_c_of_type_JavaLangString = localPublicAccountInfo.name;
      }
      paramuaq.jdField_b_of_type_Boolean = localPublicAccountInfo.isVisible();
      paramuaq.jdField_c_of_type_Int = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramuaq.jdField_a_of_type_JavaLangString);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramuaq.jdField_c_of_type_JavaLangString = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramuaq.jdField_b_of_type_Boolean = bool;
      paramuaq.jdField_c_of_type_Int = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, uaq paramuaq)
  {
    int i = paramQQAppInterface.getConversationFacade().g(paramuaq.jdField_a_of_type_JavaLangString, 1008);
    if (paramuaq.jdField_b_of_type_Int > 0)
    {
      if ((paramuaq.jdField_b_of_type_Int != 1) || (i <= 0)) {
        break label40;
      }
      paramuaq.jdField_a_of_type_Int = 2;
    }
    label40:
    do
    {
      return;
      paramuaq.jdField_a_of_type_Int = 1;
    } while (i <= 0);
    paramuaq.jdField_b_of_type_Int -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, uaq paramuaq)
  {
    paramQQAppInterface = paramQQAppInterface.getMessageFacade();
    if (paramQQAppInterface != null)
    {
      paramuaq.jdField_b_of_type_JavaLangCharSequence = null;
      paramQQAppInterface = paramQQAppInterface.getDraftSummaryInfo(paramuaq.jdField_a_of_type_JavaLangString, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramuaq.jdField_a_of_type_Long != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramuaq.jdField_e_of_type_Int = 4;
      }
    }
    label58:
    while ((paramuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord != null) && (paramQQAppInterface.getTime() <= paramuaq.jdField_a_of_type_ComTencentMobileqqDataMessageRecord.time)) {
      return;
    }
    paramuaq.jdField_e_of_type_Int = 4;
    paramuaq.jdField_a_of_type_Long = paramQQAppInterface.getTime();
    paramuaq.jdField_b_of_type_JavaLangString = TimeManager.getInstance().getMsgDisplayTime(paramuaq.jdField_a_of_type_JavaLangString, paramQQAppInterface.getTime());
    paramuaq.jdField_a_of_type_JavaLangCharSequence = paramQQAppInterface.getSummary();
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
 * Qualified Name:     uaq
 * JD-Core Version:    0.7.0.1
 */