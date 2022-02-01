import android.text.TextUtils;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.sdk.CmShowRenderView.a;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class absj
  implements abrk, abro
{
  private static int cqZ;
  private CopyOnWriteArrayList<SpriteTaskParam> M;
  private CopyOnWriteArrayList<abrp> N;
  private abse a;
  private int cra;
  public CmShowRenderView.a d;
  
  public absj(abse paramabse)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.a = paramabse;
    this.M = new CopyOnWriteArrayList();
    cqZ = 0;
    this.N = new CopyOnWriteArrayList();
  }
  
  public void Z(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", paramInt2 + " uin:" + paramString });
    }
    SpriteTaskParam localSpriteTaskParam = a(paramInt1);
    if (localSpriteTaskParam == null) {}
    do
    {
      do
      {
        return;
        localSpriteTaskParam.mStatus = 6;
        Iterator localIterator = this.N.iterator();
        while (localIterator.hasNext())
        {
          abrp localabrp = (abrp)localIterator.next();
          if (localabrp != null) {
            localabrp.a(localSpriteTaskParam, localSpriteTaskParam.mMsgId, paramInt2);
          }
        }
      } while ((this.d == null) || (TextUtils.isEmpty(paramString)) || (!paramString.equals(localSpriteTaskParam.mSenderUin)));
      this.d.b(localSpriteTaskParam.mSenderUin, localSpriteTaskParam.mActionId, localSpriteTaskParam.mTaskId, localSpriteTaskParam.cri, localSpriteTaskParam.av);
    } while (localSpriteTaskParam.crj == 1);
    removeTask(paramInt1);
  }
  
  public boolean Zg()
  {
    if ((this.M == null) || (this.M.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.mStatus == 3)) {
        return true;
      }
    }
    return false;
  }
  
  public SpriteTaskParam a()
  {
    if ((this.M == null) || (this.M.size() == 0)) {
      return null;
    }
    return (SpriteTaskParam)this.M.get(0);
  }
  
  public SpriteTaskParam a(int paramInt)
  {
    if ((this.M == null) || (this.M.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.mTaskId == paramInt) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public void b(CmShowRenderView.a parama)
  {
    this.d = parama;
  }
  
  public void c(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.M == null) || (this.a == null))
    {
      QLog.w("CmShow_SpriteDrawerInfoTaskHandler", 1, "[addTask], fail. null param");
      return;
    }
    paramSpriteTaskParam.mStatus = 1;
    this.M.add(0, paramSpriteTaskParam);
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.M.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.mTaskId) });
    }
    d(null);
  }
  
  public void clear()
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "[clear]");
    }
    if (this.M != null) {
      this.M.clear();
    }
    if (this.N != null) {
      this.N.clear();
    }
    if ((this.cra > 0) && (this.a != null)) {
      VipUtils.a(null, "cmshow", "Apollo", "play_times", ApolloUtil.gi(this.a.mAioType), 0, new String[] { Integer.toString(this.cra), this.a.mFriendUin });
    }
    this.cra = 0;
  }
  
  public boolean d(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((this.a == null) || (!this.a.isSurfaceReady()))
    {
      QLog.w("CmShow_SpriteDrawerInfoTaskHandler", 1, "surfaceview is NOT ready.");
      bool = false;
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return bool;
      localSpriteTaskParam = paramSpriteTaskParam;
      if (paramSpriteTaskParam == null) {
        localSpriteTaskParam = a();
      }
      if ((localSpriteTaskParam == null) || (localSpriteTaskParam.mStatus == 2)) {
        return false;
      }
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localSpriteTaskParam.mTaskId), ",actionId:", Integer.valueOf(localSpriteTaskParam.mActionId) });
      }
    } while (localSpriteTaskParam.a == null);
    localSpriteTaskParam.a.b(localSpriteTaskParam);
    return true;
  }
  
  public void dk(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    SpriteTaskParam localSpriteTaskParam = a(paramInt);
    if (localSpriteTaskParam == null) {
      return;
    }
    localSpriteTaskParam.mStatus = 3;
    Iterator localIterator = this.N.iterator();
    while (localIterator.hasNext())
    {
      abrp localabrp = (abrp)localIterator.next();
      if (localabrp != null) {
        localabrp.a(localSpriteTaskParam, localSpriteTaskParam.mMsgId);
      }
    }
    if ((this.d != null) && (!TextUtils.isEmpty(paramString)) && (paramString.equals(localSpriteTaskParam.mSenderUin))) {
      this.d.f(localSpriteTaskParam.mSenderUin, localSpriteTaskParam.mActionId, localSpriteTaskParam.mTaskId);
    }
    this.cra += 1;
  }
  
  public void removeTask(int paramInt)
  {
    if ((this.M == null) || (this.M.size() == 0)) {
      QLog.w("CmShow_SpriteDrawerInfoTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.M.size()), ",taskId:", Integer.valueOf(paramInt) });
      }
      Iterator localIterator = this.M.iterator();
      while (localIterator.hasNext())
      {
        SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
        if (localSpriteTaskParam.mTaskId == paramInt)
        {
          this.M.remove(localSpriteTaskParam);
          return;
        }
      }
    } while (!QLog.isColorLevel());
    QLog.d("CmShow_SpriteDrawerInfoTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     absj
 * JD-Core Version:    0.7.0.1
 */