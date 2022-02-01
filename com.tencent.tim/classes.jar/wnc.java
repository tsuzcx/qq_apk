import android.animation.ValueAnimator;
import android.animation.ValueAnimator.AnimatorUpdateListener;
import android.content.Context;
import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ListAdapter;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.ListView;
import mqq.util.WeakReference;

public class wnc
  implements ValueAnimator.AnimatorUpdateListener
{
  private SparseIntArray K = new SparseIntArray();
  private ValueAnimator X;
  private ListView a;
  private WeakReference<BaseChatPie> ab;
  public int bPw = -1;
  private FrameLayout ba;
  private Context mContext;
  private int minHeight;
  
  public wnc(Context paramContext, ListView paramListView, BaseChatPie paramBaseChatPie)
  {
    this.mContext = paramContext;
    this.a = paramListView;
    this.ab = new WeakReference(paramBaseChatPie);
    this.X = new ValueAnimator();
    this.X.addUpdateListener(this);
    this.X.setDuration(300L);
  }
  
  private void Cq(int paramInt)
  {
    if (this.ba == null)
    {
      this.ba = new FrameLayout(this.mContext);
      this.ba.setId(2131362462);
      this.ba.setLayoutParams(new AbsListView.LayoutParams(-1, paramInt));
      this.a.addFooterView(this.ba, null, false);
    }
  }
  
  public wnc a(int paramInt1, int paramInt2)
  {
    int j = 0;
    int k = 0;
    SparseIntArray localSparseIntArray = this.K;
    if (paramInt2 < 1) {}
    try
    {
      this.K.delete(paramInt1);
      for (;;)
      {
        int m = this.K.size();
        if (m <= 0) {
          break;
        }
        int i = 0;
        paramInt1 = k;
        for (;;)
        {
          j = paramInt1;
          if (i >= m) {
            break;
          }
          paramInt1 = Math.max(paramInt1, this.K.valueAt(i));
          i += 1;
        }
        this.K.put(paramInt1, paramInt2);
      }
      this.minHeight = j;
    }
    finally {}
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "setMinHeight newMinHeight=" + paramInt2 + ",minHeight=" + this.minHeight);
    }
    return this;
  }
  
  public void a(View paramView, FrameLayout.LayoutParams paramLayoutParams)
  {
    if (this.ba != null) {
      this.ba.addView(paramView, paramLayoutParams);
    }
  }
  
  public void bZM()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "removeFooterView minHeight=" + this.minHeight + ",listFooter=" + this.ba + ",listView=" + this.a);
    }
    if (this.ba != null) {
      c(Math.max(this.minHeight, 0), false, "removeFooter", 0);
    }
  }
  
  public void c(int paramInt1, boolean paramBoolean, String paramString, int paramInt2)
  {
    if (this.a == null) {
      return;
    }
    ListAdapter localListAdapter = this.a.getAdapter();
    Object localObject = localListAdapter;
    if ((localListAdapter instanceof auts)) {
      localObject = ((auts)localListAdapter).getWrappedAdapter();
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "updateFooterView from=" + paramString + ",newHeight=" + paramInt1 + ",bAnim=" + paramBoolean + ",listFooter=" + this.ba + ",listAdapter=" + localObject);
    }
    this.X.cancel();
    if (this.ba == null)
    {
      this.bPw = paramInt1;
      if (localObject != null) {
        if (this.a.getLastVisiblePosition() == ((ListAdapter)localObject).getCount() - 1 + this.a.getFooterViewsCount())
        {
          this.a.setAdapter(null);
          Cq(paramInt1);
          this.a.setAdapter((ListAdapter)localObject);
          paramInt1 = 1;
        }
      }
    }
    for (;;)
    {
      if (paramInt1 != 0)
      {
        paramString = (BaseChatPie)this.ab.get();
        if (paramString != null)
        {
          paramString.refresh(196608);
          if (QLog.isColorLevel()) {
            QLog.d("AIOFooterViewDetector", 2, "updateFooterView refresh");
          }
        }
      }
      QLog.d("AIOFooterViewDetector", 2, "updateFooterView, footerHeight: " + this.bPw);
      return;
      this.a.getFirstVisiblePosition();
      if (this.a.getChildCount() > 0)
      {
        paramString = this.a.getChildAt(0);
        if (paramString != null) {
          break label309;
        }
      }
      for (;;)
      {
        this.a.setAdapter(null);
        Cq(paramInt1);
        this.a.setAdapter((ListAdapter)localObject);
        break;
        label309:
        paramString.getTop();
      }
      Cq(paramInt1);
      paramInt1 = 0;
      continue;
      paramInt1 = Math.max(this.minHeight, paramInt1);
      this.bPw = paramInt1;
      paramString = (AbsListView.LayoutParams)this.ba.getLayoutParams();
      if (paramString.height == paramInt1) {
        break;
      }
      localObject = this.X;
      if (paramInt2 > 0) {}
      for (long l = paramInt2;; l = 300L)
      {
        ((ValueAnimator)localObject).setDuration(l);
        if (!paramBoolean) {
          break label429;
        }
        this.X.setIntValues(new int[] { paramString.height, paramInt1 });
        this.X.start();
        paramInt1 = 0;
        break;
      }
      label429:
      paramString.height = paramInt1;
      this.ba.requestLayout();
      paramInt1 = 0;
    }
  }
  
  public View d()
  {
    return this.ba;
  }
  
  public void onAnimationUpdate(ValueAnimator paramValueAnimator)
  {
    if (this.ba == null) {
      paramValueAnimator.cancel();
    }
    AbsListView.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = (AbsListView.LayoutParams)this.ba.getLayoutParams();
      localLayoutParams.height = ((Integer)paramValueAnimator.getAnimatedValue()).intValue();
      this.ba.requestLayout();
    } while (!QLog.isColorLevel());
    QLog.d("AIOFooterViewDetector", 2, "onAnimationUpdate, listFooter height=" + localLayoutParams.height);
  }
  
  public void onDestroy()
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOFooterViewDetector", 2, "onDestroy");
    }
    this.X.cancel();
    this.minHeight = 0;
    synchronized (this.K)
    {
      this.K.clear();
      if ((this.a != null) && (this.ba != null)) {
        this.a.removeFooterView(this.ba);
      }
      if (this.ba != null)
      {
        this.ba.removeAllViews();
        this.ba = null;
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnc
 * JD-Core Version:    0.7.0.1
 */