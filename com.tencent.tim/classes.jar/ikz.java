import android.graphics.drawable.Drawable;
import android.view.View.OnClickListener;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.business.manager.tips.TipsViewTimerRunnable;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;

public class ikz
  extends ijo
{
  private TipsViewTimerRunnable jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable;
  private volatile iww jdField_a_of_type_Iww;
  private volatile iww b;
  private WeakReference<iyc> bp;
  private WeakReference<iwt> bq;
  
  public ikz(VideoAppInterface paramVideoAppInterface)
  {
    super(paramVideoAppInterface);
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable = new TipsViewTimerRunnable(paramVideoAppInterface);
  }
  
  private void a(iww paramiww)
  {
    if (paramiww == null) {}
    do
    {
      return;
      if (paramiww.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a()))
      {
        ja("hiddenMainTips (avTipsItem.equals(current)) avTipsItem id = " + paramiww.getID());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.anK();
        return;
      }
    } while (!paramiww.equals(this.jdField_a_of_type_Iww));
    ja("hiddenMainTips (avTipsItem.equals(mLastShowResidentMainTipsItem)) avTipsItem id = " + paramiww.getID());
    this.jdField_a_of_type_Iww = null;
  }
  
  private void anF()
  {
    iwt localiwt = a();
    ja("hiddenMainTipsReal");
    if ((localiwt == null) || (!localiwt.vQ())) {
      return;
    }
    localiwt.arB();
  }
  
  private void anG()
  {
    iwt localiwt = a();
    ja("hiddenSubTipsReal");
    if ((localiwt == null) || (!localiwt.vR())) {
      return;
    }
    localiwt.arC();
  }
  
  private void b(iww paramiww)
  {
    if (paramiww == null) {}
    do
    {
      return;
      if (paramiww.equals(this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b()))
      {
        ja("hiddenSubTips (avTipsItem.equals(current)) avTipsItem id = " + paramiww.getID());
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.anL();
        return;
      }
    } while (!paramiww.equals(this.b));
    ja("hiddenSubTips (avTipsItem.equals(mLastShowResidentSubTipsItem)) avTipsItem id = " + paramiww.getID());
    this.b = null;
  }
  
  private boolean b(iww paramiww)
  {
    Object localObject2 = new StringBuilder().append("showSubTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (paramiww != null)
    {
      localObject1 = Integer.valueOf(paramiww.getID());
      ja(localObject1);
      localObject1 = a();
      if ((paramiww != null) && (localObject1 != null) && (((iwt)localObject1).vR())) {
        break label76;
      }
      bool1 = false;
    }
    label76:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "null";
        break;
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.b();
        bool1 = iww.a((iww)localObject2, paramiww);
        ja("showSubTips canShow = " + bool1);
        if ((!bool1) || (!((iwt)localObject1).g(paramiww))) {
          break label184;
        }
        ja("showSubTips ShowSubTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.e(paramiww);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((iww)localObject2).vS());
    if (paramiww.vS())
    {
      this.b = null;
      return true;
    }
    this.b = ((iww)localObject2);
    return true;
    label184:
    return false;
  }
  
  private boolean c(iww paramiww)
  {
    Object localObject2 = new StringBuilder().append("showMainTips begin avTipsItem = ");
    Object localObject1;
    boolean bool1;
    if (paramiww != null)
    {
      localObject1 = Integer.valueOf(paramiww.getID());
      ja(localObject1);
      localObject1 = a();
      if ((paramiww != null) && (localObject1 != null) && (((iwt)localObject1).vQ())) {
        break label76;
      }
      bool1 = false;
    }
    label76:
    do
    {
      boolean bool2;
      do
      {
        return bool1;
        localObject1 = "null";
        break;
        localObject2 = this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.a();
        bool1 = iww.a((iww)localObject2, paramiww);
        ja("showMainTips canShow = " + bool1);
        if (!bool1) {
          break label184;
        }
        if (!((iwt)localObject1).f(paramiww)) {
          break label210;
        }
        ja("showMainTips ShowMainTipsView success");
        this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.d(paramiww);
        bool2 = true;
        bool1 = bool2;
      } while (localObject2 == null);
      bool1 = bool2;
    } while (!((iww)localObject2).vS());
    if (paramiww.vS())
    {
      this.jdField_a_of_type_Iww = null;
      return true;
    }
    this.jdField_a_of_type_Iww = ((iww)localObject2);
    return true;
    label184:
    ja("showMainTips canShow is false current = " + ((iww)localObject2).getID());
    label210:
    return false;
  }
  
  public static void ja(String paramString)
  {
    if (paramString == null) {}
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("NewTipsManager", 2, paramString);
  }
  
  public iwt a()
  {
    if ((this.bq == null) || (this.bq.isEnqueued())) {
      return null;
    }
    return (iwt)this.bq.get();
  }
  
  public void a(iwt paramiwt)
  {
    if (paramiwt == null) {
      return;
    }
    ja("setAvTipsView avTipsView is " + paramiwt.getClass());
    this.bq = new WeakReference(paramiwt);
  }
  
  public void a(iyc paramiyc)
  {
    if (paramiyc == null) {
      return;
    }
    ja("setDeviceTipsController is " + paramiyc.getClass());
    this.bp = new WeakReference(paramiyc);
  }
  
  public boolean a(int paramInt, long paramLong, boolean paramBoolean)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bp != null)
    {
      bool1 = bool2;
      if (this.bp.get() != null)
      {
        ((iyc)this.bp.get()).f(paramInt, paramLong, paramBoolean);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public boolean a(int paramInt1, String paramString, Drawable paramDrawable, int paramInt2, View.OnClickListener paramOnClickListener)
  {
    if (this.mApp == null) {
      return false;
    }
    return a(iwv.a(paramInt1, this.mApp, paramString, 2, paramDrawable, paramInt2, paramOnClickListener));
  }
  
  public boolean a(iww paramiww)
  {
    if (paramiww == null)
    {
      ja("showTips (tipsItem == null)");
      return false;
    }
    switch (paramiww.getShowType())
    {
    default: 
      ja("showTips tipsItem.getShowType() = " + paramiww.getShowType());
      return false;
    case 1: 
      return b(paramiww);
    }
    return c(paramiww);
  }
  
  public void anE()
  {
    ja("RemoveAllTips");
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.anK();
    this.jdField_a_of_type_Iww = null;
    this.jdField_a_of_type_ComTencentAvBusinessManagerTipsTipsViewTimerRunnable.anL();
    this.b = null;
  }
  
  public void anH()
  {
    iwt localiwt = a();
    ja("HiddenViewContainer");
    if ((localiwt == null) || (!localiwt.vR())) {
      return;
    }
    localiwt.arD();
  }
  
  public void anI()
  {
    iwt localiwt = a();
    ja("ShowViewContainer");
    if ((localiwt == null) || (!localiwt.vR())) {
      return;
    }
    localiwt.arE();
  }
  
  public void c(iww paramiww)
  {
    if (paramiww == null) {
      return;
    }
    ja("NotifyHiddenMainTipsByRunner item" + paramiww.getID());
    if ((paramiww.vS()) || (this.jdField_a_of_type_Iww == null))
    {
      anF();
      return;
    }
    c(this.jdField_a_of_type_Iww);
  }
  
  public boolean cl(int paramInt)
  {
    if (this.mApp == null) {
      return false;
    }
    return a(iwv.a(paramInt, this.mApp));
  }
  
  protected boolean cs(String paramString)
  {
    return false;
  }
  
  public void d(iww paramiww)
  {
    if (paramiww == null) {
      return;
    }
    ja("NotifyHiddenSubTipsByRunner item" + paramiww.getID());
    if ((paramiww.vS()) || (this.b == null))
    {
      anG();
      return;
    }
    b(this.b);
  }
  
  public boolean f(int paramInt, String paramString)
  {
    if (this.mApp == null) {
      return false;
    }
    return a(iwv.a(paramInt, this.mApp, paramString));
  }
  
  public boolean h(int paramInt, long paramLong)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.bp != null)
    {
      bool1 = bool2;
      if (this.bp.get() != null)
      {
        ((iyc)this.bp.get()).z(paramInt, paramLong);
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void ii(boolean paramBoolean)
  {
    if ((this.bp != null) && (this.bp.get() != null)) {
      ((iyc)this.bp.get()).jx(paramBoolean);
    }
  }
  
  public void kU(int paramInt)
  {
    if (this.mApp == null)
    {
      ja("HiddenTips (mApp == null)");
      return;
    }
    iww localiww = iwv.a(paramInt, this.mApp);
    if (localiww == null)
    {
      ja("HiddenTips (tipsItem == null)");
      return;
    }
    switch (localiww.getShowType())
    {
    default: 
      ja("HiddenTips tipsItem.getShowType() = " + localiww.getShowType());
      return;
    case 1: 
      b(localiww);
      return;
    }
    a(localiww);
  }
  
  protected void onCreate() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     ikz
 * JD-Core Version:    0.7.0.1
 */