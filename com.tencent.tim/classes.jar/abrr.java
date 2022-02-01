import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.1;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.2;
import com.tencent.mobileqq.apollo.script.drawerInfo.SpriteDrawerInfoBridge.3;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import mqq.os.MqqHandler;

public class abrr
  implements abrl
{
  private abrc jdField_a_of_type_Abrc;
  private abrd jdField_a_of_type_Abrd;
  private abrf jdField_a_of_type_Abrf;
  private abro jdField_a_of_type_Abro;
  private String bhu;
  
  public abrr(abrc paramabrc, abro paramabro, abrd paramabrd, abrf paramabrf)
  {
    this.jdField_a_of_type_Abrc = paramabrc;
    this.jdField_a_of_type_Abro = paramabro;
    this.jdField_a_of_type_Abrd = paramabrd;
    this.jdField_a_of_type_Abrf = paramabrf;
  }
  
  private boolean aD(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_Abrc == null) || (this.jdField_a_of_type_Abrc.getApp() == null)) {}
    while (this.jdField_a_of_type_Abrf.a(paramInt1, paramInt2) == null) {
      return false;
    }
    return true;
  }
  
  public void a(abrc paramabrc)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, "[initSprite]");
    }
    if ((this.jdField_a_of_type_Abrd == null) || (paramabrc == null) || (!paramabrc.isSurfaceReady())) {
      if (paramabrc != null) {
        abwh.a(paramabrc.zM(), 300, 160, new Object[] { "glview is not ready" });
      }
    }
    String str;
    abqt localabqt;
    do
    {
      do
      {
        return;
        if (aD(0, -1)) {
          break;
        }
        QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[initSprite], fail to load script.");
      } while (paramabrc.cqU != 1);
      ThreadManager.getUIHandler().post(new SpriteDrawerInfoBridge.2(this, paramabrc));
      return;
      if (TextUtils.isEmpty(this.bhu))
      {
        str = this.jdField_a_of_type_Abrd.rj();
        QLog.d("CmShowStatUtil", 1, "drawer get spriteJs");
      }
      while (TextUtils.isEmpty(str))
      {
        abwh.a(paramabrc.zM(), 300, 301, new Object[] { "spriteJs is empty" });
        return;
        str = this.bhu;
        QLog.d("CmShowStatUtil", 1, "drawer spriteJs from cache");
        this.bhu = null;
      }
      localabqt = (abqt)this.jdField_a_of_type_Abrf.a(0);
    } while (localabqt == null);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("initDrawerInfoSprite('").append(str).append("');");
    abwh.gN(this.jdField_a_of_type_Abrc.zM(), 350);
    localabqt.CN(localStringBuilder.toString());
    ThreadManager.executeOnSubThread(new SpriteDrawerInfoBridge.3(this, localabqt, paramabrc));
  }
  
  public void a(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return;
    }
    ThreadManager.excute(new SpriteDrawerInfoBridge.1(this, paramSpriteTaskParam), 192, null, true);
  }
  
  public void b(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((paramSpriteTaskParam == null) || (this.jdField_a_of_type_Abrd == null) || (this.jdField_a_of_type_Abrc == null) || (!this.jdField_a_of_type_Abrc.isSurfaceReady())) {
      return;
    }
    this.jdField_a_of_type_Abrd.a(paramSpriteTaskParam);
    if (!aD(paramSpriteTaskParam.mActionType, paramSpriteTaskParam.mActionId))
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "[playAction], fail to load script.");
      paramSpriteTaskParam.mStatus = 4;
      return;
    }
    Object localObject = this.jdField_a_of_type_Abrd.b(paramSpriteTaskParam);
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      paramSpriteTaskParam.mStatus = 4;
      return;
    }
    abqu localabqu = this.jdField_a_of_type_Abrf.a(paramSpriteTaskParam.mActionType);
    if (localabqu == null)
    {
      QLog.w("cmshow_scripted_SpriteDrawerInfoBridge", 1, "actionScript == null.");
      paramSpriteTaskParam.mStatus = 4;
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteDrawerInfoBridge", 2, new Object[] { "[playAction], ready to play, actionId:", Integer.valueOf(paramSpriteTaskParam.mActionId) });
    }
    paramSpriteTaskParam.mStatus = 2;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("playDrawerInfoAction ('").append((String)localObject).append("');");
    localabqu.CN(localStringBuilder.toString());
    localabqu.bv(paramSpriteTaskParam.mSenderUin, false);
    localabqu.bv(paramSpriteTaskParam.bbE, false);
    localObject = this.jdField_a_of_type_Abrc.getApp();
    if (!TextUtils.isEmpty(paramSpriteTaskParam.bhv)) {}
    for (;;)
    {
      abvg.a((QQAppInterface)localObject, paramSpriteTaskParam, bool, paramSpriteTaskParam.bEW);
      return;
      bool = false;
    }
  }
  
  public void cEA()
  {
    this.bhu = this.jdField_a_of_type_Abrd.rj();
  }
  
  public void clear() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrr
 * JD-Core Version:    0.7.0.1
 */