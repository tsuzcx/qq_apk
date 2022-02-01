import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ExtendFriendUserInfo;
import com.tencent.mobileqq.extendfriend.utils.ExtendFriendSendMsgHelper.2;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class afxx
{
  private static volatile afxx jdField_a_of_type_Afxx;
  private long XS;
  private afxx.a jdField_a_of_type_Afxx$a;
  private QQAppInterface app;
  afsr d = new afxy(this);
  
  private afxx(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      this.app = paramQQAppInterface;
      this.app.removeObserver(this.d);
      this.app.addObserver(this.d);
    }
  }
  
  public static void A(Context paramContext, String paramString1, String paramString2)
  {
    if (paramContext == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "enterAio() context is null just return");
      return;
    }
    Intent localIntent = new Intent(paramContext, ChatActivity.class);
    localIntent.putExtra("uin", paramString1);
    localIntent.putExtra("uinname", paramString2);
    localIntent.putExtra("entrance", 23);
    localIntent.putExtra("uintype", 1045);
    localIntent.putExtras(new Bundle());
    paramContext.startActivity(localIntent);
  }
  
  public static afxx a(QQAppInterface paramQQAppInterface)
  {
    if (jdField_a_of_type_Afxx == null) {}
    try
    {
      if (jdField_a_of_type_Afxx == null) {
        jdField_a_of_type_Afxx = new afxx(paramQQAppInterface);
      }
      return jdField_a_of_type_Afxx;
    }
    finally {}
  }
  
  public static void a(BaseActivity paramBaseActivity, boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialog() activity is null just return");
      return;
    }
    aqha.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131701191)).setNegativeButton(paramBaseActivity.getString(2131701189), new afyb()).setPositiveButton(paramBaseActivity.getString(2131701190), new afya(paramBoolean, paramBaseActivity, paramInt, paramString1, paramString2)).show();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, aftr paramaftr)
  {
    aine.ai(paramQQAppInterface, paramaftr.bFC);
    aine.a(paramQQAppInterface, paramaftr, paramaftr.timeStamp, 2, paramInt);
    String str1 = paramaftr.bFC;
    paramInt = paramaftr.tagId;
    String str2 = paramaftr.tagName;
    if (!TextUtils.isEmpty(paramaftr.tipsWording)) {}
    for (boolean bool = true;; bool = false)
    {
      aine.a(paramQQAppInterface, str1, paramInt, str2, bool);
      if (paramaftr.tagId >= 2)
      {
        paramQQAppInterface = (alur)paramQQAppInterface.getManager(285);
        paramQQAppInterface.Pa(paramaftr.bFC);
        paramQQAppInterface.dJR();
      }
      return;
    }
  }
  
  public static boolean aA(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogBySendMsg-> currentUin = " + paramQQAppInterface.getCurrentAccountUin());
    }
    if ((aB(paramQQAppInterface)) && (!aD(paramQQAppInterface))) {
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogBySendMsg-> false ");
    }
    return false;
  }
  
  public static boolean aB(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isStudent-> return " + paramQQAppInterface.ajY());
    }
    return paramQQAppInterface.ajY();
  }
  
  public static boolean aC(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (!TextUtils.isEmpty(paramQQAppInterface.uH()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "hasWriteSchoolName-> return false");
    }
    return false;
  }
  
  public static boolean aD(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> mExtendFriendManager is null then return false");
      }
      return false;
    }
    if (paramQQAppInterface.DA() == 2)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> return true");
      }
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "hasVerifySchool-> return false");
    }
    return false;
  }
  
  public static void b(BaseActivity paramBaseActivity, String paramString)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showToast() activity is null just return");
      return;
    }
    QQToast.a(paramBaseActivity, paramString, 0).show(paramBaseActivity.getTitleBarHeight());
  }
  
  public static boolean b(BaseActivity paramBaseActivity)
  {
    if ((paramBaseActivity == null) || (paramBaseActivity.app == null))
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "isNeedShowSchoolVerifyDialogByMathChat-> null == mActivity || null == mActivity.app then return true");
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogByMathChat->");
    }
    if ((aB(paramBaseActivity.app)) && (!aC(paramBaseActivity.app)))
    {
      q(paramBaseActivity);
      return true;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "isNeedShowSchoolVerifyDialogByMathChat-> is not student ");
    }
    return false;
  }
  
  public static boolean c(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null) {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusVerifyDialogForPublish() activity is null just return");
    }
    while (!aA(paramBaseActivity.app)) {
      return false;
    }
    aldd localaldd = ((afsi)paramBaseActivity.app.getManager(264)).a();
    boolean bool = aC(paramBaseActivity.app);
    aqha.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131701149)).setNegativeButton(paramBaseActivity.getString(2131701189), new afyd()).setPositiveButton(paramBaseActivity.getString(2131701190), new afyc(paramBaseActivity, bool, localaldd)).show();
    return true;
  }
  
  public static void i(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    ((afsi)paramQQAppInterface.getManager(264)).O(paramString1, paramString2, paramInt);
  }
  
  public static void p(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showMatchCountDialog() activity is null just return");
      return;
    }
    aqha.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131701193)).setPositiveButton(paramBaseActivity.getString(2131701192), new afxz()).show();
  }
  
  public static void q(BaseActivity paramBaseActivity)
  {
    if (paramBaseActivity == null)
    {
      QLog.d("ExtendFriendSendMsgHelper", 1, "showCampusWriteDialog() activity is null just return");
      return;
    }
    aqha.a(paramBaseActivity, 230).setMessage(paramBaseActivity.getString(2131701149)).setNegativeButton(paramBaseActivity.getString(2131701189), new afyf()).setPositiveButton(paramBaseActivity.getString(2131701148), new afye(paramBaseActivity)).show();
  }
  
  public static String u(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
    if (paramQQAppInterface == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> mExtendFriendManager is null then return 0");
      }
      paramQQAppInterface = "";
    }
    String str;
    do
    {
      return paramQQAppInterface;
      if (paramQQAppInterface.a() == null) {
        break;
      }
      str = paramQQAppInterface.uH();
      paramQQAppInterface = str;
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> schoolName = " + str);
    return str;
    if (QLog.isColorLevel()) {
      QLog.d("ExtendFriendSendMsgHelper", 2, "getSchoolName-> has not school schoolName ");
    }
    return "";
  }
  
  public void a(QQAppInterface paramQQAppInterface, ProfileActivity.AllInOne paramAllInOne, afxx.a parama)
  {
    String str1;
    if (paramAllInOne != null)
    {
      str1 = paramAllInOne.uin;
      String str2 = paramAllInOne.nickname;
      byte[] arrayOfByte = paramAllInOne.ch;
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, String.format("sendMsg uin=%s nickName=%s voiceCode=%s", new Object[] { str1, str2, arrayOfByte }));
      }
      a(paramQQAppInterface, str1, str2, arrayOfByte, ExtendFriendUserInfo.subIDToFromType(paramAllInOne.subSourceId), parama);
      i = afxv.DR();
      if ((i == 1) || (i == 2)) {
        if (i != 1) {
          break label127;
        }
      }
    }
    label127:
    for (int i = 2;; i = 4)
    {
      afxv.a().c(i, str1, "", afxv.uQ(), afxv.uR(), afxv.uS());
      return;
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, byte[] paramArrayOfByte, int paramInt, afxx.a parama)
  {
    if ((paramQQAppInterface == null) || (parama == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg appInterface = " + paramQQAppInterface + " sendMsgInterface = " + parama);
      }
    }
    do
    {
      return;
      if (aA(paramQQAppInterface)) {
        break label143;
      }
      if (System.currentTimeMillis() - this.XS >= 1000L) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ExtendFriendSendMsgHelper", 2, "sendMsg is fast Click");
    return;
    this.XS = System.currentTimeMillis();
    this.jdField_a_of_type_Afxx$a = parama;
    ((afsg)paramQQAppInterface.getBusinessHandler(127)).a(paramQQAppInterface.getCurrentAccountUin(), paramString1, paramString2, paramArrayOfByte);
    ThreadManager.getSubThreadHandler().post(new ExtendFriendSendMsgHelper.2(this, paramInt, paramString1));
    return;
    label143:
    paramString1 = (afsi)paramQQAppInterface.getManager(264);
    paramString2 = paramString1.a();
    if ((paramString2 == null) || (TextUtils.isEmpty(paramString2.bVO)))
    {
      parama.d(false, -1, paramString1.uG(), "");
      return;
    }
    parama.d(aC(paramQQAppInterface), paramString2.drZ, paramString2.bVO, paramString2.bVN);
  }
  
  public void destroy()
  {
    if (this.app != null)
    {
      this.app.removeObserver(this.d);
      this.app = null;
    }
    this.jdField_a_of_type_Afxx$a = null;
    jdField_a_of_type_Afxx = null;
    this.d = null;
  }
  
  public static abstract interface a
  {
    public abstract void bPe();
    
    public abstract void d(boolean paramBoolean, int paramInt, String paramString1, String paramString2);
    
    public abstract void dk(String paramString1, String paramString2);
    
    public abstract void showToast(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afxx
 * JD-Core Version:    0.7.0.1
 */