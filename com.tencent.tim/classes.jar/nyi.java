import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.imcore.message.QQMessageFacade;
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

public class nyi
{
  public String aoL;
  public boolean avC;
  public MessageRecord d;
  public int mAuthenIconId;
  public long mDisplayTime;
  @notColumn
  public CharSequence mDraft;
  public int mExtraInfoColor = BaseApplicationImpl.getApplication().getResources().getColor(2131167410);
  public boolean mIsVisible = true;
  public String mReportKeyBytesOacMsgxtend;
  public String mShowTime;
  @notColumn
  public int mStatus;
  public String mTitleName;
  public String mUin;
  public int mUnreadFlag = 0;
  public int mUnreadNum;
  public CharSequence v;
  public long yo = 0L;
  
  public static nyi a(QQAppInterface paramQQAppInterface, RecentUser paramRecentUser)
  {
    paramRecentUser = new RecentItemPublicAccountChatMsgData(paramRecentUser);
    paramRecentUser.c(paramQQAppInterface, paramQQAppInterface.getApplication());
    nyi localnyi = new nyi();
    localnyi.avC = true;
    localnyi.mUin = paramRecentUser.qx();
    localnyi.mUnreadNum = paramRecentUser.mUnreadNum;
    localnyi.mAuthenIconId = paramRecentUser.mAuthenIconId;
    localnyi.mDisplayTime = paramRecentUser.mDisplayTime;
    localnyi.mShowTime = paramRecentUser.mShowTime;
    localnyi.yo = paramRecentUser.eI();
    localnyi.mTitleName = paramRecentUser.mTitleName;
    localnyi.v = paramRecentUser.mLastMsg;
    localnyi.d = paramQQAppInterface.b().d(localnyi.mUin, 1008);
    localnyi.aoL = nyn.e(paramQQAppInterface, localnyi.mUin);
    localnyi.mReportKeyBytesOacMsgxtend = paramRecentUser.mReportKeyBytesOacMsgxtend;
    a(paramQQAppInterface, localnyi);
    b(paramQQAppInterface, localnyi);
    c(paramQQAppInterface, localnyi);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromRecentUser->" + localnyi.toString());
    }
    return localnyi;
  }
  
  public static nyi a(QQAppInterface paramQQAppInterface, oal paramoal)
  {
    nyi localnyi = new nyi();
    localnyi.avC = false;
    localnyi.mUin = paramoal.mUin;
    localnyi.mUnreadNum = paramoal.aOr;
    localnyi.mAuthenIconId = 0;
    localnyi.mDisplayTime = paramoal.yu;
    localnyi.mShowTime = aale.a().t(paramoal.mUin, paramoal.yu);
    String str2 = oan.a().getNickName(paramoal.mUin);
    String str1 = str2;
    if ("".equals(str2)) {
      str1 = paramoal.mUin;
    }
    localnyi.mTitleName = str1;
    if (paramoal.mItems.size() > 0) {
      localnyi.v = ((oam)paramoal.mItems.get(0)).title;
    }
    localnyi.d = paramQQAppInterface.b().d(paramoal.mUin, 1008);
    localnyi.aoL = nyn.e(paramQQAppInterface, paramoal.mUin);
    a(paramQQAppInterface, localnyi);
    b(paramQQAppInterface, localnyi);
    c(paramQQAppInterface, localnyi);
    if (QLog.isColorLevel()) {
      QLog.d("ServiceAccountFolderFeed", 2, "createFromSubscriptionFeed->" + localnyi.toString());
    }
    return localnyi;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, nyi paramnyi)
  {
    paramQQAppInterface = (acja)paramQQAppInterface.getManager(56);
    if (paramQQAppInterface != null)
    {
      PublicAccountInfo localPublicAccountInfo = paramQQAppInterface.b(paramnyi.mUin);
      if (localPublicAccountInfo == null) {
        break label59;
      }
      if (!TextUtils.isEmpty(localPublicAccountInfo.name)) {
        paramnyi.mTitleName = localPublicAccountInfo.name;
      }
      paramnyi.mIsVisible = localPublicAccountInfo.isVisible();
      paramnyi.mAuthenIconId = 0;
    }
    label59:
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.a(paramnyi.mUin);
    } while (paramQQAppInterface == null);
    if (!TextUtils.isEmpty(paramQQAppInterface.name)) {
      paramnyi.mTitleName = paramQQAppInterface.name;
    }
    if (1 == paramQQAppInterface.showFlag) {}
    for (boolean bool = true;; bool = false)
    {
      paramnyi.mIsVisible = bool;
      paramnyi.mAuthenIconId = 0;
      return;
    }
  }
  
  private static void b(QQAppInterface paramQQAppInterface, nyi paramnyi)
  {
    int i = paramQQAppInterface.a().G(paramnyi.mUin, 1008);
    if (paramnyi.mUnreadNum > 0)
    {
      if ((paramnyi.mUnreadNum != 1) || (i <= 0)) {
        break label40;
      }
      paramnyi.mUnreadFlag = 2;
    }
    label40:
    do
    {
      return;
      paramnyi.mUnreadFlag = 1;
    } while (i <= 0);
    paramnyi.mUnreadNum -= 1;
  }
  
  private static void c(QQAppInterface paramQQAppInterface, nyi paramnyi)
  {
    paramQQAppInterface = paramQQAppInterface.b();
    if (paramQQAppInterface != null)
    {
      paramnyi.mDraft = null;
      paramQQAppInterface = paramQQAppInterface.a(paramnyi.mUin, 1008);
      if ((paramQQAppInterface != null) && (!TextUtils.isEmpty(paramQQAppInterface.getSummary())))
      {
        if (paramnyi.mDisplayTime != paramQQAppInterface.getTime()) {
          break label58;
        }
        paramnyi.mStatus = 4;
      }
    }
    label58:
    while ((paramnyi.d != null) && (paramQQAppInterface.getTime() <= paramnyi.d.time)) {
      return;
    }
    paramnyi.mStatus = 4;
    paramnyi.mDisplayTime = paramQQAppInterface.getTime();
    paramnyi.mShowTime = aale.a().t(paramnyi.mUin, paramQQAppInterface.getTime());
    paramnyi.v = paramQQAppInterface.getSummary();
  }
  
  public final boolean Gq()
  {
    return (this.mUnreadFlag == 1) || (this.mUnreadFlag == 4);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ServiceAccountFolderFeed content->");
    localStringBuilder.append("mIsCreateFromMessageTab:" + this.avC);
    localStringBuilder.append(", mUin:" + this.mUin);
    localStringBuilder.append(", mUnreadFlag:" + this.mUnreadFlag);
    localStringBuilder.append(", mUnreadNum:" + this.mUnreadNum);
    localStringBuilder.append(", mAuthenIconId:" + this.mAuthenIconId);
    localStringBuilder.append(", mShowTime:" + this.mShowTime);
    localStringBuilder.append(", mTitleName:" + this.mTitleName);
    localStringBuilder.append(", mMsgBrief:" + this.v);
    localStringBuilder.append(", mMsgExtraInfo:" + this.aoL);
    localStringBuilder.append(", mDraft:" + this.mDraft);
    localStringBuilder.append(", mStatus:" + this.mStatus);
    localStringBuilder.append(", mDisplayTime:" + this.mDisplayTime);
    localStringBuilder.append(", mOperationTime:" + this.yo);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nyi
 * JD-Core Version:    0.7.0.1
 */