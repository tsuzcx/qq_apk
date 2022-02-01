import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.widget.ListView;
import com.tencent.widget.immersive.ImmersiveUtils;

public final class aavt
  implements aawa, wvs
{
  private static final int clC = aqnm.dpToPx(50.0F);
  private static int clQ = -1;
  private long MN = -1L;
  private boolean bAw;
  private boolean bAx;
  private int clR = -1;
  private int clS = -1;
  private final BaseChatPie f;
  private final int[] jM = new int[2];
  private int mPreState;
  
  public aavt(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
    if (clQ == -1)
    {
      int i = ViewConfiguration.get(paramBaseChatPie.mContext).getScaledTouchSlop();
      clQ = i * i;
    }
  }
  
  public int[] C()
  {
    return new int[] { 5, 9, 12, 16, 14, 15 };
  }
  
  public void Ck(int paramInt)
  {
    switch (paramInt)
    {
    }
    aavp localaavp;
    do
    {
      View localView;
      do
      {
        do
        {
          do
          {
            do
            {
              return;
              localaavp = aavp.a();
              localaavp.a(this);
              this.bAx = true;
            } while ((!localaavp.isSelected()) || (localaavp.Xy()));
            localaavp.j(this.f);
            return;
            aavp.a().b(this);
            this.bAx = false;
            return;
            localaavp = aavp.a();
          } while (!localaavp.isSelected());
          localaavp.detach();
          return;
          localaavp = aavp.a();
        } while ((!localaavp.isSelected()) || (localaavp.Xy()));
        localView = localaavp.bK();
      } while (localView == null);
      localView.getLocationInWindow(this.jM);
      if (this.jM[1] + localView.getMeasuredHeight() - localView.getPaddingBottom() < clC + ImmersiveUtils.statusHeight)
      {
        localaavp.detach();
        return;
      }
      if ((this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout != null) && (this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getVisibility() == 0))
      {
        paramInt = this.jM[1];
        this.f.jdField_a_of_type_ComTencentMobileqqActivityAioInputLinearLayout.getLocationInWindow(this.jM);
        if (paramInt > this.jM[1])
        {
          localaavp.detach();
          return;
        }
        localaavp.j(this.f);
        return;
      }
      localaavp.j(this.f);
      return;
      localaavp = aavp.a();
    } while ((!localaavp.isSelected()) || (!localaavp.Xy()));
    localaavp.czA();
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
  
  public boolean XE()
  {
    if (aavp.a().isSelected())
    {
      aavp.a().detach();
      return true;
    }
    return false;
  }
  
  public void a(@NonNull aawe paramaawe)
  {
    boolean bool = paramaawe.isSelected();
    if ((this.f instanceof ybl)) {}
    for (paramaawe = ((ybl)this.f).b();; paramaawe = this.f.b)
    {
      if (paramaawe != null) {
        paramaawe.requestDisallowInterceptTouchEvent(bool);
      }
      return;
    }
  }
  
  public void czI()
  {
    aavp localaavp = aavp.a();
    if (localaavp.isSelected()) {
      localaavp.detach();
    }
  }
  
  public void czJ()
  {
    if (this.f.jdField_a_of_type_Wki != null)
    {
      if (ThemeUtil.isNowThemeIsNight(this.f.app, false, null)) {
        this.f.jdField_a_of_type_Wki.a.clP = 1;
      }
    }
    else {
      return;
    }
    if ("2101".equals(ThemeUtil.getCurrentThemeId()))
    {
      this.f.jdField_a_of_type_Wki.a.clP = 2;
      return;
    }
    this.f.jdField_a_of_type_Wki.a.clP = 0;
  }
  
  public boolean isSelected()
  {
    return aavp.a().isSelected();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavt
 * JD-Core Version:    0.7.0.1
 */