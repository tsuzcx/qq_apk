import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.multicard.MultiCardCustomLayout;
import com.tencent.mobileqq.multicard.MultiCardItemFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ajjl
  implements View.OnLongClickListener
{
  public List<View> Dk = new ArrayList();
  public ajjf a;
  private ajjl.a a;
  public WeakReference<MultiCardItemFragment> aE;
  private MultiCardCustomLayout b;
  private boolean coX;
  public FragmentActivity mActivity;
  public QQAppInterface mApp;
  public Bundle mBundle;
  public Context mContext;
  private int mMode = -1;
  public ViewGroup mParentView;
  
  public ajjl() {}
  
  public ajjl(QQAppInterface paramQQAppInterface, FragmentActivity paramFragmentActivity, Context paramContext, ViewGroup paramViewGroup)
  {
    this.mApp = paramQQAppInterface;
    this.mActivity = paramFragmentActivity;
    this.mContext = paramContext;
    this.mParentView = paramViewGroup;
  }
  
  private boolean g(View paramView, float paramFloat1, float paramFloat2)
  {
    if (paramView == null) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      return false;
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      i = arrayOfInt[0];
      j = arrayOfInt[1];
      k = paramView.getMeasuredWidth();
      m = paramView.getMeasuredHeight();
    } while ((paramFloat2 < j) || (paramFloat2 > m + j) || (paramFloat1 < i) || (paramFloat1 > k + i));
    return true;
  }
  
  public boolean L(float paramFloat1, float paramFloat2)
  {
    if (this.Dk.size() == 0) {
      return false;
    }
    Iterator localIterator = this.Dk.iterator();
    while (localIterator.hasNext()) {
      if (g((View)localIterator.next(), paramFloat1, paramFloat2)) {
        return true;
      }
    }
    return false;
  }
  
  public void Mb(boolean paramBoolean)
  {
    this.coX = paramBoolean;
  }
  
  public void Ra(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "onCardModeChanged：" + paramInt);
    }
  }
  
  public ajjf a()
  {
    return this.jdField_a_of_type_Ajjf;
  }
  
  public MultiCardCustomLayout a()
  {
    return this.b;
  }
  
  public void a(ajjf paramajjf)
  {
    this.jdField_a_of_type_Ajjf = paramajjf;
  }
  
  public void a(ajjl.a parama)
  {
    this.jdField_a_of_type_Ajjl$a = parama;
  }
  
  public void a(MultiCardItemFragment paramMultiCardItemFragment)
  {
    this.aE = new WeakReference(paramMultiCardItemFragment);
  }
  
  public void bZt() {}
  
  public void bZu() {}
  
  public View cj()
  {
    return MultiCardItemFragment.ck();
  }
  
  public void cqr() {}
  
  public void cqt() {}
  
  public void da(Bundle paramBundle)
  {
    this.mBundle = paramBundle;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnCreate() called");
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnDestroy");
    }
    this.mParentView = null;
    this.jdField_a_of_type_Ajjf = null;
  }
  
  public void doOnPause()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnPause() called");
    }
  }
  
  public void doOnResume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "doOnResume() called");
    }
  }
  
  public void doOnStart() {}
  
  public void doOnStop() {}
  
  public void dxS()
  {
    this.Dk.clear();
  }
  
  public void e(ViewGroup paramViewGroup, View paramView)
  {
    MultiCardItemFragment.e(paramViewGroup, paramView);
  }
  
  public int getMode()
  {
    return this.mMode;
  }
  
  public void hg(View paramView)
  {
    this.b = ((MultiCardCustomLayout)paramView);
    if ((this.b != null) && (this.b != null)) {
      this.b.setDispatchTouchEventOnLongClickListener(new ajjm(this));
    }
  }
  
  public void hh(View paramView)
  {
    if (paramView == null) {}
    do
    {
      return;
      if (paramView.getParent() != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("MultiCardCustomViewDelegete", 2, "infoview has parent. error!!");
        }
        if ((paramView.getParent() instanceof ViewGroup))
        {
          if (QLog.isColorLevel()) {
            QLog.d("MultiCardCustomViewDelegete", 2, "infoview has parent. remove infoview");
          }
          ((ViewGroup)paramView.getParent()).removeView(paramView);
        }
      }
    } while (this.mParentView == null);
    this.mParentView.addView(paramView);
  }
  
  public void hi(View paramView)
  {
    if (!this.Dk.contains(paramView)) {
      this.Dk.add(paramView);
    }
  }
  
  public String nD()
  {
    if (this.mBundle != null) {
      return this.mBundle.getString("troopuin");
    }
    return null;
  }
  
  public Bundle o()
  {
    return this.mBundle;
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_a_of_type_Ajjl$a != null) {
      this.jdField_a_of_type_Ajjl$a.b(this);
    }
    return true;
  }
  
  public boolean onLongClick(View paramView)
  {
    if (this.jdField_a_of_type_Ajjl$a != null) {
      this.jdField_a_of_type_Ajjl$a.b(this);
    }
    return true;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean) {}
  
  public void setMode(int paramInt)
  {
    if (this.mMode != paramInt)
    {
      this.mMode = paramInt;
      Ra(this.mMode);
    }
  }
  
  public void setParentView(ViewGroup paramViewGroup)
  {
    this.mParentView = paramViewGroup;
  }
  
  public void unInit()
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardCustomViewDelegete", 2, "unInit");
    }
    this.mMode = -1;
    if (this.b != null)
    {
      this.b.Ma(false);
      this.b.setDispatchTouchEventOnLongClickListener(null);
      this.b = null;
    }
    this.mApp = null;
    this.mActivity = null;
    this.mContext = null;
    this.jdField_a_of_type_Ajjf = null;
    this.mParentView = null;
    this.Dk.clear();
    this.mBundle = null;
  }
  
  public static abstract interface a
  {
    public abstract void b(ajjl paramajjl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajjl
 * JD-Core Version:    0.7.0.1
 */