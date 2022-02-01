import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Card;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class afwh
  implements Manager
{
  static Object dF = new Object();
  private static final Object mLock = new Object();
  private afsr jdField_a_of_type_Afsr = new afwi(this);
  afwx jdField_a_of_type_Afwx;
  public afxd.a a;
  afxd jdField_a_of_type_Afxd;
  private aftr b;
  public String bFL;
  private String bFM;
  private String bFN;
  private String bFO;
  private boolean bld = true;
  private boolean cbt = true;
  private boolean cbu;
  private boolean cbv;
  private WeakReference<afwh.a> gN;
  protected SharedPreferences k;
  private QQAppInterface mApp;
  
  public afwh(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_Afxd$a = new afwj(this);
    this.mApp = paramQQAppInterface;
    this.mApp.addObserver(this.jdField_a_of_type_Afsr);
    this.k = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getAccount(), 0);
  }
  
  public static int K(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp with null app");
      return 0;
    }
    Card localCard = ((acff)paramQQAppInterface.getManager(51)).a(paramQQAppInterface.getCurrentAccountUin());
    int i;
    if (localCard == null)
    {
      QLog.i("ExtendFriendLimitChatManager", 2, "获取自己的资料卡性别，缓存中未获取到，使用默认值随机");
      i = 0;
      return paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getInt("sp_match_sex_type", i);
    }
    if (localCard.shGender == 0) {
      i = 2;
    }
    for (;;)
    {
      QLog.i("ExtendFriendLimitChatManager", 2, "获取自己的资料卡性别，defaultSex:" + i);
      break;
      if (localCard.shGender == 1) {
        i = 1;
      } else {
        i = 0;
      }
    }
  }
  
  public static Boolean a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSwitchOpenFromSp with null app");
      return Boolean.valueOf(true);
    }
    return Boolean.valueOf(paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("sp_match_switch_type", false));
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSwitchToSp with null app");
    }
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putBoolean("sp_match_switch_type", paramBoolean.booleanValue()).apply();
  }
  
  public static Boolean b(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null)
    {
      QLog.e("ExtendFriendLimitChatManager", 2, "getMatchSwitchFlagFromSp with null app");
      return Boolean.valueOf(false);
    }
    paramQQAppInterface = Boolean.valueOf(paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).getBoolean("sp_voice_match_switch_flag", false));
    QLog.d("ExtendFriendLimitChatManager", 2, "getVoiceMatch " + paramQQAppInterface);
    return paramQQAppInterface;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Boolean paramBoolean)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setVoiceMatchSwitchFlagToSp with null app");
    }
    do
    {
      return;
      QLog.d("ExtendFriendLimitChatManager", 2, "setVoiceMatch " + paramBoolean);
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putBoolean("sp_voice_match_switch_flag", paramBoolean.booleanValue()).apply();
  }
  
  private void ddf()
  {
    Object localObject1 = this.mApp;
    if (localObject1 == null) {}
    do
    {
      return;
      Object localObject2;
      try
      {
        localObject1 = ((QQAppInterface)localObject1).a().a();
        Object localObject3 = ((acxw)localObject1).q(false);
        localObject2 = new ArrayList();
        if ((localObject3 != null) && (((List)localObject3).size() > 0))
        {
          localObject3 = ((List)localObject3).iterator();
          while (((Iterator)localObject3).hasNext())
          {
            RecentUser localRecentUser = (RecentUser)((Iterator)localObject3).next();
            if ((localRecentUser.getType() == 1044) && (!localRecentUser.uin.equals(acbn.blR))) {
              ((List)localObject2).add(localRecentUser);
            }
          }
          QLog.i("ExtendFriendLimitChatManager", 1, "[initLimitChatBox] toBeRemoved.size:" + ((List)localObject2).size());
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("ExtendFriendLimitChatManager", 1, localThrowable, new Object[0]);
        return;
      }
      if (((List)localObject2).size() > 0)
      {
        long l = ((RecentUser)((List)localObject2).get(0)).lastmsgtime;
        localObject2 = ((List)localObject2).iterator();
        while (((Iterator)localObject2).hasNext()) {
          localThrowable.f((RecentUser)((Iterator)localObject2).next());
        }
      }
    } while (this.k == null);
    this.k.edit().putBoolean("init_matchchat_folder", false).commit();
  }
  
  public static void g(QQAppInterface paramQQAppInterface, ArrayList<afub> paramArrayList)
  {
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setTaglistToSp with null app");
    }
    do
    {
      return;
      paramArrayList = afub.r(paramArrayList);
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while ((paramArrayList == null) || (paramQQAppInterface == null));
    paramQQAppInterface.putString("sp_tagList", paramArrayList).apply();
  }
  
  public static void z(QQAppInterface paramQQAppInterface, int paramInt)
  {
    QLog.i("ExtendFriendLimitChatManager", 2, "getMatchSexTypeFromSp : " + paramInt);
    if (paramQQAppInterface == null) {
      QLog.e("ExtendFriendLimitChatManager", 2, "setMatchSexTypeToSp with null app");
    }
    do
    {
      return;
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    } while (paramQQAppInterface == null);
    paramQQAppInterface.putInt("sp_match_sex_type", paramInt).apply();
  }
  
  public void IE(boolean paramBoolean)
  {
    this.bld = paramBoolean;
  }
  
  public void Nx(int paramInt)
  {
    a().hW(101, paramInt);
  }
  
  public afwx a()
  {
    if (this.jdField_a_of_type_Afwx != null) {
      return this.jdField_a_of_type_Afwx;
    }
    synchronized (mLock)
    {
      if (this.jdField_a_of_type_Afwx != null)
      {
        afwx localafwx1 = this.jdField_a_of_type_Afwx;
        return localafwx1;
      }
    }
    this.jdField_a_of_type_Afwx = new afwx(this);
    afwx localafwx2 = this.jdField_a_of_type_Afwx;
    return localafwx2;
  }
  
  public afxd a()
  {
    if (this.jdField_a_of_type_Afxd != null) {
      return this.jdField_a_of_type_Afxd;
    }
    synchronized (dF)
    {
      if (this.jdField_a_of_type_Afxd != null)
      {
        afxd localafxd1 = this.jdField_a_of_type_Afxd;
        return localafxd1;
      }
    }
    this.jdField_a_of_type_Afxd = new afxd(this.mApp);
    this.jdField_a_of_type_Afxd.a(this.jdField_a_of_type_Afxd$a);
    afxd localafxd2 = this.jdField_a_of_type_Afxd;
    return localafxd2;
  }
  
  public void a(afub paramafub)
  {
    int i = 1;
    if (paramafub != null) {
      i = paramafub.tagId;
    }
    a().hW(102, i);
  }
  
  public void a(afwh.a parama)
  {
    if (this.gN != null) {
      this.gN.clear();
    }
    this.gN = new WeakReference(parama);
  }
  
  public void a(boolean paramBoolean, aftq paramaftq)
  {
    QLog.i("ExtendFriendLimitChat", 2, "handleGetSquareStrangerList onGetMatchFeedInfo success = " + paramBoolean);
  }
  
  public boolean aku()
  {
    if (this.mApp == null) {}
    while (this.k == null) {
      return false;
    }
    return this.k.getBoolean("init_matchchat_folder", true);
  }
  
  public void apK()
  {
    a().Ny(103);
  }
  
  public boolean bl(Context paramContext)
  {
    if (paramContext == null) {
      return false;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ExtendFriendLimitChatManager", 2, "showRealNameAuthDialog");
    }
    if ((!this.bld) && (this.cbv))
    {
      if (TextUtils.isEmpty(this.bFM)) {
        this.bFM = paramContext.getString(2131701571);
      }
      if (TextUtils.isEmpty(this.bFN)) {
        this.bFN = paramContext.getString(2131701569);
      }
      if (TextUtils.isEmpty(this.bFO)) {
        this.bFO = "https://ti.qq.com/realname/index.html";
      }
      paramContext = aqha.a(paramContext, 230, this.bFM, this.bFN, paramContext.getString(2131701570), paramContext.getString(2131701572), new afwk(this, paramContext), new afwl(this));
      paramContext.setCancelable(false);
      paramContext.show();
      return true;
    }
    return false;
  }
  
  public Boolean c(QQAppInterface paramQQAppInterface)
  {
    boolean bool = false;
    if (paramQQAppInterface != null)
    {
      bool = b(paramQQAppInterface).booleanValue();
      if (!bool) {
        break label69;
      }
      paramQQAppInterface = (afsi)paramQQAppInterface.getManager(264);
      if (paramQQAppInterface == null) {
        break label81;
      }
      bool = paramQQAppInterface.akc();
    }
    label69:
    label81:
    for (;;)
    {
      QLog.d("ExtendFriendLimitChatManager", 2, "is voiceMatch ShowToUser " + bool);
      return Boolean.valueOf(bool);
      QLog.d("ExtendFriendLimitChatManager", 2, "is voiceMatchShowToUser xinyong not enough  ");
    }
  }
  
  public void dde()
  {
    this.b = null;
  }
  
  public int getState()
  {
    return a().DK();
  }
  
  public void h(boolean paramBoolean, String paramString1, String paramString2, String paramString3)
  {
    this.cbv = paramBoolean;
    this.bFM = paramString1;
    this.bFN = paramString2;
    this.bFO = paramString3;
  }
  
  public void initManager()
  {
    QLog.i("ExtendFriendLimitChatManager", 1, "[initManager], threadId:" + Thread.currentThread().getId());
    if (aku()) {
      ddf();
    }
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_Afxd != null)
    {
      this.jdField_a_of_type_Afxd.Clear();
      this.jdField_a_of_type_Afxd = null;
    }
    this.mApp.removeObserver(this.jdField_a_of_type_Afsr);
    if (this.gN != null)
    {
      this.gN.clear();
      this.gN = null;
    }
    this.b = null;
  }
  
  public String uK()
  {
    if (this.b != null) {
      return this.b.bFC;
    }
    return "";
  }
  
  public static abstract interface a
  {
    public abstract void b(int paramInt, aftr paramaftr, String paramString1, String paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afwh
 * JD-Core Version:    0.7.0.1
 */