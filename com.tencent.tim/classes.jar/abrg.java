import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.apollo.ApolloTextureView;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;

public class abrg
  implements Manager
{
  private abqs jdField_a_of_type_Abqs;
  private abqy jdField_a_of_type_Abqy;
  private abqz jdField_a_of_type_Abqz;
  private abrc jdField_a_of_type_Abrc;
  private abrf jdField_a_of_type_Abrf;
  private abvk jdField_a_of_type_Abvk;
  private SpriteUIHandler jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  private abrh b;
  private abrd c;
  private WeakReference<QQAppInterface> mAppRef;
  private boolean mIsInit;
  private List<WeakReference<abrs>> wv = new ArrayList();
  
  public abrg(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteScriptManager", 2, "SpriteScriptManager constructor.");
    }
    this.jdField_a_of_type_Abrc = new abrc(paramQQAppInterface);
    this.mAppRef = new WeakReference(paramQQAppInterface);
    this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler = new SpriteUIHandler(this.jdField_a_of_type_Abrc);
    this.b = new abrh(this.jdField_a_of_type_Abrc, this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler);
    this.jdField_a_of_type_Abrf = new abrf(this.jdField_a_of_type_Abrc, this.b);
    this.c = new abrd(this.jdField_a_of_type_Abrc);
    this.jdField_a_of_type_Abqz = new abqz(this.jdField_a_of_type_Abrc, this.b, this.c);
    this.jdField_a_of_type_Abrc.a(this.c);
  }
  
  public abqs a()
  {
    return this.jdField_a_of_type_Abqs;
  }
  
  public abqy a()
  {
    return this.jdField_a_of_type_Abqy;
  }
  
  public abqz a()
  {
    return this.jdField_a_of_type_Abqz;
  }
  
  public abrc a()
  {
    return this.jdField_a_of_type_Abrc;
  }
  
  public abrf a()
  {
    return this.jdField_a_of_type_Abrf;
  }
  
  public abrh a()
  {
    return this.b;
  }
  
  public abvk a()
  {
    return this.jdField_a_of_type_Abvk;
  }
  
  public SpriteUIHandler a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqApolloScriptSpriteUIHandler;
  }
  
  public void a(abrs paramabrs)
  {
    if (paramabrs != null)
    {
      paramabrs = new WeakReference(paramabrs);
      this.wv.add(paramabrs);
    }
  }
  
  public void a(ApolloTextureView paramApolloTextureView)
  {
    if (paramApolloTextureView == null) {
      return;
    }
    this.jdField_a_of_type_Abqy = new abqy(this.jdField_a_of_type_Abrc, paramApolloTextureView);
  }
  
  public abrd b()
  {
    return this.c;
  }
  
  public void b(abix paramabix)
  {
    if (paramabix == null) {}
    ApolloCmdChannel localApolloCmdChannel;
    do
    {
      return;
      this.jdField_a_of_type_Abrc.a(paramabix);
      localApolloCmdChannel = ApolloCmdChannel.getChannel(this.jdField_a_of_type_Abrc.getApp());
    } while (localApolloCmdChannel == null);
    localApolloCmdChannel.addRenderRunner(paramabix);
  }
  
  public void bR(int paramInt, String paramString)
  {
    if (!abrj.f(getApp(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = abrj.a(getApp());
      if (paramString != null) {
        paramString.HP(1);
      }
    } while (this.jdField_a_of_type_Abqy == null);
    this.jdField_a_of_type_Abqy.cEx();
  }
  
  public void bS(int paramInt, String paramString)
  {
    if (!abrj.f(getApp(), paramInt, paramString)) {}
    do
    {
      return;
      paramString = abrj.a(getApp());
      if (paramString != null) {
        paramString.HP(2);
      }
    } while (this.jdField_a_of_type_Abqy == null);
    this.jdField_a_of_type_Abqy.cEy();
  }
  
  public void cEA()
  {
    if (this.jdField_a_of_type_Abqz != null) {
      this.jdField_a_of_type_Abqz.cEA();
    }
  }
  
  public void d(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo != null)
    {
      this.jdField_a_of_type_Abrc.gJ(paramSessionInfo.cZ, 0);
      this.jdField_a_of_type_Abrc.mFriendUin = paramSessionInfo.aTl;
    }
  }
  
  public void dj(String paramString, int paramInt)
  {
    QLog.i("cmshow_scripted_SpriteScriptManager", 1, "[onSurfaceReady], aioType:" + paramInt + ",friendUin:" + ApolloUtil.iY(paramString) + ",threadId:" + Thread.currentThread().getId());
    if ((this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abqz == null) || (this.jdField_a_of_type_Abrf == null)) {
      return;
    }
    this.jdField_a_of_type_Abrc.Ec(true);
    int i = abrj.gf(this.jdField_a_of_type_Abrc.cqU);
    this.jdField_a_of_type_Abrc.HT(i);
    if (!this.jdField_a_of_type_Abrc.bEU)
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT init cmshow.");
      return;
    }
    this.jdField_a_of_type_Abrc.gJ(paramInt, 0);
    this.jdField_a_of_type_Abrc.mFriendUin = paramString;
    this.jdField_a_of_type_Abrc.cEC();
    this.jdField_a_of_type_Abrc.cEB();
    if (!abrj.f(getApp(), paramInt, paramString))
    {
      QLog.w("cmshow_scripted_SpriteScriptManager", 1, "can NOT use cmshow.");
      return;
    }
    abwh.gN(i, 200);
    this.jdField_a_of_type_Abqz.a(this.jdField_a_of_type_Abvk);
    this.jdField_a_of_type_Abrf.cED();
    abwh.a(i, 200, 0, new Object[] { "loadBasicScript done" });
    this.jdField_a_of_type_Abrc.Eb(true);
    QQAppInterface localQQAppInterface;
    if (!this.b.d(null))
    {
      abwh.gN(i, 300);
      this.jdField_a_of_type_Abqz.a(this.jdField_a_of_type_Abrc);
      abwh.a(i, 300, 0, new Object[] { "initSprite done" });
      abwh.a(i, 1, 0, new Object[] { "terminal all done" });
      abwh.b(i, null, new int[] { abwg.a(i, false, this.jdField_a_of_type_Abrc.cqS, paramInt, true) });
      this.mIsInit = true;
      localQQAppInterface = getApp();
      if (this.jdField_a_of_type_Abrc.cqT != 1) {
        break label419;
      }
    }
    label419:
    for (i = 1;; i = 0)
    {
      VipUtils.a(localQQAppInterface, "cmshow", "Apollo", "aio_show", i, ApolloUtil.gp(this.jdField_a_of_type_Abrc.cqS), new String[] { Integer.toString(ApolloUtil.gi(paramInt)), "", "", paramString });
      return;
      abwh.b(i, null, new int[] { abwg.a(i, true, this.jdField_a_of_type_Abrc.cqS, paramInt, true) });
      break;
    }
  }
  
  public QQAppInterface getApp()
  {
    if (this.mAppRef == null) {
      return null;
    }
    return (QQAppInterface)this.mAppRef.get();
  }
  
  public void i(int paramInt, ArrayList<String> paramArrayList)
  {
    Object localObject = abrj.a(getApp());
    if (localObject != null) {
      ((abqt)localObject).i(paramInt, paramArrayList);
    }
    localObject = this.wv.iterator();
    while (((Iterator)localObject).hasNext())
    {
      abrs localabrs = (abrs)((WeakReference)((Iterator)localObject).next()).get();
      if (localabrs != null) {
        localabrs.i(paramInt, paramArrayList);
      }
    }
  }
  
  public void i(int paramInt, Object... paramVarArgs)
  {
    if (!this.mIsInit) {
      abwh.a(abrj.gf(this.jdField_a_of_type_Abrc.cqU), 1, paramInt, 0L, paramVarArgs);
    }
    Iterator localIterator = this.wv.iterator();
    while (localIterator.hasNext())
    {
      abrs localabrs = (abrs)((WeakReference)localIterator.next()).get();
      if (localabrs != null) {
        localabrs.i(paramInt, paramVarArgs);
      }
    }
  }
  
  public void onDestroy()
  {
    if (this.c != null) {
      this.c.reset();
    }
    Object localObject = this.jdField_a_of_type_Abrc.a();
    if (localObject != null)
    {
      localObject = ((abix)localObject).getRenderImpl();
      if (localObject != null) {
        ((abii)localObject).onDestroy();
      }
    }
    if (this.jdField_a_of_type_Abvk != null)
    {
      this.jdField_a_of_type_Abvk.destroy();
      this.jdField_a_of_type_Abvk = null;
    }
    if (this.jdField_a_of_type_Abqs != null)
    {
      this.jdField_a_of_type_Abqs.onDestroy();
      this.jdField_a_of_type_Abqs = null;
    }
    if (this.jdField_a_of_type_Abqy != null)
    {
      this.jdField_a_of_type_Abqy.onDestroy();
      this.jdField_a_of_type_Abqy = null;
    }
    this.b.clear();
    this.jdField_a_of_type_Abrf.clear();
    this.jdField_a_of_type_Abqz.clear();
    this.jdField_a_of_type_Abrc.clear();
    this.mIsInit = false;
    QLog.d("cmshow_scripted_SpriteScriptManager", 1, "script info clear");
    localObject = getApp();
    if (localObject == null) {}
    while (this.jdField_a_of_type_Abrc.mPref == null) {
      return;
    }
    this.jdField_a_of_type_Abrc.mPref.edit().remove("is_add_new_game" + ((QQAppInterface)localObject).getCurrentAccountUin()).commit();
  }
  
  public void q(BaseChatPie paramBaseChatPie)
  {
    this.jdField_a_of_type_Abrc.q(paramBaseChatPie);
    paramBaseChatPie = getApp();
    if (paramBaseChatPie != null)
    {
      paramBaseChatPie = (abij)paramBaseChatPie.getManager(232);
      a().a(paramBaseChatPie);
    }
    if (this.jdField_a_of_type_Abvk == null) {
      this.jdField_a_of_type_Abvk = new abvk(this.jdField_a_of_type_Abrc);
    }
    if (this.jdField_a_of_type_Abqs == null) {
      this.jdField_a_of_type_Abqs = new abqs(this.jdField_a_of_type_Abrc);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrg
 * JD-Core Version:    0.7.0.1
 */