import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.apollo.script.SpriteTaskHandler.1;
import com.tencent.mobileqq.apollo.script.SpriteTaskParam;
import com.tencent.mobileqq.apollo.script.SpriteUIHandler;
import com.tencent.mobileqq.apollo.utils.ApolloUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingDeque;
import mqq.os.MqqHandler;

public class abrh
  implements abrk, abro
{
  private static int cqZ;
  private CopyOnWriteArrayList<SpriteTaskParam> M;
  private CopyOnWriteArrayList<abrp> N;
  private long Oo;
  private abrc jdField_a_of_type_Abrc;
  private abrq jdField_a_of_type_Abrq;
  private BlockingDeque<SpriteTaskParam> b;
  private int cra;
  private Runnable fB = new SpriteTaskHandler.1(this);
  
  public abrh(abrc paramabrc, abrq paramabrq)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "SpriteTaskHandler constructor.");
    }
    this.jdField_a_of_type_Abrc = paramabrc;
    this.jdField_a_of_type_Abrq = paramabrq;
    this.M = new CopyOnWriteArrayList();
    this.b = new LinkedBlockingDeque(50);
    cqZ = 0;
    this.N = new CopyOnWriteArrayList();
  }
  
  public void Z(String paramString, int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onCompleteAction], taskId:", Integer.valueOf(paramInt1), ",type:", Integer.valueOf(paramInt2) });
    }
    paramString = a(paramInt1);
    if (paramString == null) {
      return;
    }
    if (this.jdField_a_of_type_Abrq != null) {
      this.jdField_a_of_type_Abrq.a(paramString, paramString.mMsgId, paramInt2);
    }
    paramString.mStatus = 6;
    Iterator localIterator = this.N.iterator();
    while (localIterator.hasNext())
    {
      abrp localabrp = (abrp)localIterator.next();
      if (localabrp != null) {
        localabrp.a(paramString, paramString.mMsgId, paramInt2);
      }
    }
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
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTask], task NOT found in queue");
    }
    return null;
  }
  
  public SpriteTaskParam a(long paramLong)
  {
    if ((this.M == null) || (this.M.size() == 0)) {
      return null;
    }
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if (localSpriteTaskParam.mMsgId == paramLong) {
        return localSpriteTaskParam;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[findTaskByTaskId], task NOT found in queue");
    }
    return null;
  }
  
  public SpriteTaskParam a(long paramLong, int paramInt)
  {
    Object localObject;
    if ((this.M == null) || (this.M.size() == 0)) {
      localObject = null;
    }
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return localObject;
      localObject = this.M.iterator();
      do
      {
        if (!((Iterator)localObject).hasNext()) {
          break;
        }
        localSpriteTaskParam = (SpriteTaskParam)((Iterator)localObject).next();
      } while ((localSpriteTaskParam == null) || (localSpriteTaskParam.mMsgId != paramLong) || (paramInt != 2));
      localObject = localSpriteTaskParam;
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[stopTask], msgId:", Long.valueOf(paramLong), ",taskId:", Integer.valueOf(localSpriteTaskParam.mTaskId) });
    return localSpriteTaskParam;
    return null;
  }
  
  public void a(abrp paramabrp)
  {
    if ((paramabrp != null) && (this.N != null))
    {
      if (this.N.contains(paramabrp)) {
        QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addActionCallback], repeat callback.");
      }
    }
    else {
      return;
    }
    this.N.add(paramabrp);
  }
  
  public boolean bD(long paramLong)
  {
    if ((this.M == null) || (this.M.size() == 0)) {}
    SpriteTaskParam localSpriteTaskParam;
    do
    {
      return false;
      localSpriteTaskParam = a(paramLong);
    } while ((localSpriteTaskParam == null) || (localSpriteTaskParam.mStatus != 3));
    return true;
  }
  
  public void c(SpriteTaskParam paramSpriteTaskParam)
  {
    if ((paramSpriteTaskParam == null) || (this.M == null) || (this.jdField_a_of_type_Abrc == null)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[addTask], fail. null param");
    }
    do
    {
      return;
      if ((1 == this.jdField_a_of_type_Abrc.cqT) && (paramSpriteTaskParam.crd != 1))
      {
        this.M.add(0, paramSpriteTaskParam);
        if ((this.jdField_a_of_type_Abrq instanceof SpriteUIHandler)) {
          ((SpriteUIHandler)this.jdField_a_of_type_Abrq).j(false, true, null);
        }
        localObject1 = this.jdField_a_of_type_Abrc.getApp();
        localObject2 = Integer.toString(ApolloUtil.gi(this.jdField_a_of_type_Abrc.mAioType));
        if (paramSpriteTaskParam.crd == 2) {}
        for (paramSpriteTaskParam = "1";; paramSpriteTaskParam = "2")
        {
          VipUtils.a((AppInterface)localObject1, "cmshow", "Apollo", "aio_double_show_clk", 0, 0, new String[] { localObject2, paramSpriteTaskParam });
          return;
        }
      }
      if (!c(paramSpriteTaskParam)) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[addTask], same task. discard it.");
    return;
    Object localObject1 = a(paramSpriteTaskParam.mMsgId, paramSpriteTaskParam.crd);
    if (localObject1 == null)
    {
      this.b.offerLast(paramSpriteTaskParam);
      long l = System.currentTimeMillis();
      if ((l - this.Oo > 500L) || (!Zg()))
      {
        paramSpriteTaskParam = (SpriteTaskParam)this.b.pollLast();
        this.b.clear();
        this.Oo = l;
        if (paramSpriteTaskParam == null) {
          QLog.e("cmshow_scripted_SpriteTaskHandler", 1, "[addTask] poll task from deque failed");
        }
      }
      else
      {
        ThreadManager.getSubThreadHandler().removeCallbacks(this.fB);
        ThreadManager.getSubThreadHandler().postDelayed(this.fB, 500L);
        return;
      }
      paramSpriteTaskParam.mStatus = 1;
      i = cqZ + 1;
      cqZ = i;
      paramSpriteTaskParam.mTaskId = i;
      this.M.add(0, paramSpriteTaskParam);
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[addTask], size:", Integer.valueOf(this.M.size()), ",taskId:", Integer.valueOf(paramSpriteTaskParam.mTaskId) });
      }
      d((SpriteTaskParam)localObject1);
      return;
    }
    ((SpriteTaskParam)localObject1).mStatus = 5;
    Object localObject2 = this.jdField_a_of_type_Abrc.getApp();
    int i = ApolloUtil.gi(this.jdField_a_of_type_Abrc.mAioType);
    String str = Integer.toString(paramSpriteTaskParam.mActionId);
    if (paramSpriteTaskParam.mIsSend) {}
    for (paramSpriteTaskParam = "0";; paramSpriteTaskParam = "1")
    {
      VipUtils.a((AppInterface)localObject2, "cmshow", "Apollo", "msg_paly_stop", i, 0, new String[] { str, paramSpriteTaskParam });
      break;
    }
  }
  
  public boolean c(SpriteTaskParam paramSpriteTaskParam)
  {
    if (paramSpriteTaskParam == null) {
      return false;
    }
    if ((this.M == null) || (this.M.size() == 0)) {
      return false;
    }
    Iterator localIterator = this.M.iterator();
    while (localIterator.hasNext())
    {
      SpriteTaskParam localSpriteTaskParam = (SpriteTaskParam)localIterator.next();
      if ((localSpriteTaskParam != null) && (localSpriteTaskParam.mMsgId == paramSpriteTaskParam.mMsgId) && (localSpriteTaskParam.crd != 2) && (localSpriteTaskParam.crd != 3)) {
        return true;
      }
    }
    return false;
  }
  
  public void clear()
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[clear]");
    }
    if (this.M != null) {
      this.M.clear();
    }
    if (this.N != null) {
      this.N.clear();
    }
    if ((this.cra > 0) && (this.jdField_a_of_type_Abrc != null)) {
      VipUtils.a(this.jdField_a_of_type_Abrc.getApp(), "cmshow", "Apollo", "play_times", ApolloUtil.gi(this.jdField_a_of_type_Abrc.mAioType), 0, new String[] { Integer.toString(this.cra), this.jdField_a_of_type_Abrc.mFriendUin });
    }
    this.b.clear();
    this.cra = 0;
  }
  
  public boolean d(SpriteTaskParam paramSpriteTaskParam)
  {
    boolean bool = true;
    if ((this.jdField_a_of_type_Abrc == null) || (!this.jdField_a_of_type_Abrc.isSurfaceReady()))
    {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "surfaceview is NOT ready.");
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
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[execSpriteTask], taskId:", Integer.valueOf(localSpriteTaskParam.mTaskId), ",actionId:", Integer.valueOf(localSpriteTaskParam.mActionId) });
      }
    } while (localSpriteTaskParam.a == null);
    localSpriteTaskParam.a.b(localSpriteTaskParam);
    return true;
  }
  
  public void dk(String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[onStartAction], taskId:", Integer.valueOf(paramInt) });
    }
    paramString = a(paramInt);
    if (paramString == null) {
      return;
    }
    paramString.mStatus = 3;
    if (this.jdField_a_of_type_Abrq != null) {
      this.jdField_a_of_type_Abrq.a(paramString, paramString.mMsgId);
    }
    Iterator localIterator = this.N.iterator();
    while (localIterator.hasNext())
    {
      abrp localabrp = (abrp)localIterator.next();
      if (localabrp != null) {
        localabrp.a(paramString, paramString.mMsgId);
      }
    }
    this.cra += 1;
  }
  
  public void removeTask(int paramInt)
  {
    if ((this.M == null) || (this.M.size() == 0)) {
      QLog.w("cmshow_scripted_SpriteTaskHandler", 1, "[removeTask], fail. NO task. taskId:" + paramInt);
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("cmshow_scripted_SpriteTaskHandler", 2, new Object[] { "[removeTask], total task num:", Integer.valueOf(this.M.size()), ",taskId:", Integer.valueOf(paramInt) });
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
    QLog.d("cmshow_scripted_SpriteTaskHandler", 2, "[removeTask], task NOT found in queue");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abrh
 * JD-Core Version:    0.7.0.1
 */