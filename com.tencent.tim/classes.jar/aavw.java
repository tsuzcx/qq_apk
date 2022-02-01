import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.WindowManager;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryC2CAllFragment;
import com.tencent.mobileqq.activity.history.ChatHistoryTroopAllFragment;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;

public final class aavw
  implements aawa, wvs
{
  private static final int clC = aqnm.dpToPx(50.0F);
  private static int clQ = -1;
  private long MN = -1L;
  private boolean bAw;
  private boolean bAx;
  private int clR = -1;
  private int clS = -1;
  private final int[] jM = new int[2];
  private final WeakReference<Fragment> mFragment;
  private int mPreState;
  
  public aavw(Fragment paramFragment)
  {
    this.mFragment = new WeakReference(paramFragment);
    if (clQ == -1)
    {
      int i = ViewConfiguration.get(paramFragment.getActivity()).getScaledTouchSlop();
      clQ = i * i;
    }
  }
  
  private void a(View paramView, Fragment paramFragment)
  {
    aavp localaavp = aavp.a();
    if ((localaavp.isSelected()) && (!localaavp.Xy()))
    {
      View localView = localaavp.bK();
      if (localView != null)
      {
        localView.getLocationInWindow(this.jM);
        if (this.jM[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() >= clC + ImmersiveUtils.statusHeight) {
          break label76;
        }
        localaavp.detach();
      }
    }
    return;
    label76:
    if (paramView != null)
    {
      int i = this.jM[1];
      paramView.getLocationInWindow(this.jM);
      if (i > this.jM[1])
      {
        localaavp.detach();
        return;
      }
      localaavp.gf(paramView);
      return;
    }
    if (Build.VERSION.SDK_INT >= 17)
    {
      paramView = new DisplayMetrics();
      paramFragment.getActivity().getWindowManager().getDefaultDisplay().getRealMetrics(paramView);
      localaavp.GH(paramView.heightPixels);
      return;
    }
    localaavp.czz();
  }
  
  public int[] C()
  {
    return new int[] { 5, 9, 12, 16, 14, 15 };
  }
  
  public void Ck(int paramInt)
  {
    Object localObject2 = (Fragment)this.mFragment.get();
    Object localObject1 = null;
    if ((localObject2 instanceof ChatHistoryC2CAllFragment)) {
      localObject1 = ((ChatHistoryC2CAllFragment)localObject2).a;
    }
    switch (paramInt)
    {
    }
    do
    {
      do
      {
        do
        {
          return;
          localObject2 = aavp.a();
          ((aavp)localObject2).a(this);
          this.bAx = true;
        } while ((((aavp)localObject2).bK() == null) || (!((aavp)localObject2).isSelected()) || (((aavp)localObject2).Xy()));
        ((aavp)localObject2).gf((View)localObject1);
        return;
        aavp.a().b(this);
        this.bAx = false;
        return;
        localObject1 = aavp.a();
      } while (!((aawe)localObject1).isSelected());
      ((aawe)localObject1).detach();
      return;
      a((View)localObject1, (Fragment)localObject2);
      return;
      localObject1 = aavp.a();
    } while ((((aavp)localObject1).bK() == null) || (!((aavp)localObject1).isSelected()) || (!((aavp)localObject1).Xy()));
    ((aavp)localObject1).czA();
  }
  
  public void W(MotionEvent paramMotionEvent)
  {
    boolean bool = true;
    aavp localaavp = aavp.a();
    if ((!localaavp.isSelected()) || (!this.bAx)) {}
    int i;
    label102:
    do
    {
      do
      {
        int j;
        int k;
        do
        {
          return;
          i = paramMotionEvent.getAction();
          j = (int)paramMotionEvent.getRawX();
          k = (int)paramMotionEvent.getRawY();
          if (i == 0)
          {
            if (!localaavp.aC(j, k))
            {
              this.bAw = bool;
              this.MN = localaavp.MM;
              if (!this.bAw) {
                break label102;
              }
              this.clR = j;
            }
            for (this.clS = k;; this.clS = -1)
            {
              this.mPreState = 0;
              return;
              bool = false;
              break;
              this.clR = -1;
            }
          }
          if (i != 2) {
            break;
          }
        } while ((!this.bAw) || (Math.pow(this.clR - j, 2.0D) + Math.pow(this.clS - k, 2.0D) <= clQ));
        this.mPreState = 2;
      } while (!QLog.isColorLevel());
      QLog.d("ChatPieSelectableHelper", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.bAw));
    if (this.mPreState == 0)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ChatPieSelectableHelper", 0, "detect taping.");
      }
      long l = localaavp.MM;
      if ((this.MN == -1L) || (l == -1L)) {
        break label281;
      }
      if (this.MN == l) {
        localaavp.detach();
      }
    }
    for (;;)
    {
      this.mPreState = 1;
      this.bAw = false;
      this.MN = -1L;
      return;
      label281:
      localaavp.detach();
    }
  }
  
  public void a(@NonNull aawe paramaawe)
  {
    boolean bool = paramaawe.isSelected();
    paramaawe = (Fragment)this.mFragment.get();
    if ((paramaawe instanceof ChatHistoryC2CAllFragment)) {
      paramaawe = ((ChatHistoryC2CAllFragment)paramaawe).d;
    }
    for (;;)
    {
      if (paramaawe != null) {
        paramaawe.requestDisallowInterceptTouchEvent(bool);
      }
      return;
      if ((paramaawe instanceof ChatHistoryTroopAllFragment)) {
        paramaawe = ((ChatHistoryTroopAllFragment)paramaawe).d;
      } else if ((paramaawe instanceof ChatHistoryBubbleListForTroopFragment)) {
        paramaawe = ((ChatHistoryBubbleListForTroopFragment)paramaawe).d;
      } else {
        paramaawe = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavw
 * JD-Core Version:    0.7.0.1
 */