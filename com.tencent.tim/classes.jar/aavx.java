import android.annotation.SuppressLint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewConfiguration;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.AnimationTextView;
import com.tencent.mobileqq.widget.ContainerView;
import java.lang.ref.WeakReference;

public class aavx<T extends BaseActivity>
  implements View.OnClickListener
{
  private static int clQ = -1;
  private long MN = -1L;
  protected aawk a;
  private aavr b;
  protected aavv b;
  private boolean bAw;
  private boolean bAx;
  private int clR = -1;
  private int clS = -1;
  public String content;
  private Point e = new Point();
  protected WeakReference<T> mActivity;
  private int mPreState;
  protected WeakReference<QQAppInterface> n;
  
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
      } while (!com.tencent.TMG.utils.QLog.isColorLevel());
      com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect scrolling.");
      return;
    } while (((i != 1) && (i != 3)) || (!this.bAw));
    if (this.mPreState == 0)
    {
      if (com.tencent.TMG.utils.QLog.isColorLevel()) {
        com.tencent.TMG.utils.QLog.d("CommonSelectableMenu", 0, "detect taping.");
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
  
  public void a(T paramT, ContainerView paramContainerView)
  {
    this.content = paramContainerView.getText();
    this.a = new aawk();
    this.n = new WeakReference(paramT.app);
    this.mActivity = new WeakReference(paramT);
    a(paramContainerView);
    if (clQ == -1)
    {
      int i = ViewConfiguration.get(paramT).getScaledTouchSlop();
      clQ = i * i;
    }
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  protected void a(ContainerView paramContainerView)
  {
    paramContainerView.e.setOnTouchListener(new aavy(this));
    paramContainerView.e.setOnLongClickListener(new aavz(this, paramContainerView));
  }
  
  protected void a(ContainerView paramContainerView, View paramView)
  {
    if ((paramView instanceof aawc))
    {
      aawc localaawc = (aawc)paramView;
      if (paramView.getContext() != null)
      {
        aqoa localaqoa = new aqoa();
        d(localaqoa);
        if (this.jdField_b_of_type_Aavv == null)
        {
          this.jdField_b_of_type_Aavv = new aawj();
          this.jdField_b_of_type_Aavv.setOnClickListener(this);
        }
        int i = this.e.y - wja.dp2px(10.0F, paramView.getResources());
        int j = this.e.x - aqnm.dpToPx(14.0F);
        this.jdField_b_of_type_Aavv.a(localaqoa, false);
        this.jdField_b_of_type_Aavv.GI(j);
        this.jdField_b_of_type_Aavv.GJ(i);
        this.jdField_b_of_type_Aavv.clV = i;
        this.jdField_b_of_type_Aavv.clW = j;
        if (com.tencent.qphone.base.util.QLog.isColorLevel()) {
          com.tencent.qphone.base.util.QLog.d("CommonSelectableMenu", 2, "showMenuView: pointY -> " + i + ", lastShowX -> " + this.e.x);
        }
        if (this.jdField_b_of_type_Aavr == null) {
          this.jdField_b_of_type_Aavr = new aavr();
        }
        this.jdField_b_of_type_Aavr.a(localaawc);
        this.jdField_b_of_type_Aavr.a(paramContainerView, paramContainerView);
        this.jdField_b_of_type_Aavr.a(this.jdField_b_of_type_Aavv);
        this.a.a(paramView, this.jdField_b_of_type_Aavv);
      }
    }
  }
  
  public void b(ContainerView paramContainerView)
  {
    if ((paramContainerView != null) && (paramContainerView.e != null))
    {
      paramContainerView.e.setOnLongClickListener(null);
      paramContainerView.e.setOnClickListener(null);
    }
    if (this.jdField_b_of_type_Aavr != null)
    {
      this.jdField_b_of_type_Aavr.detach();
      this.jdField_b_of_type_Aavr = null;
    }
    if (this.jdField_b_of_type_Aavv != null)
    {
      this.jdField_b_of_type_Aavv.setOnClickListener(null);
      this.jdField_b_of_type_Aavv = null;
    }
    this.a = null;
  }
  
  protected void d(aqoa paramaqoa)
  {
    paramaqoa.Z(2131365509, acfp.m(2131704243), 2130839077);
    paramaqoa.Z(2131367523, acfp.m(2131704241), 2130839086);
    paramaqoa.Z(2131366733, acfp.m(2131704242), 2130839085);
  }
  
  protected String getContent()
  {
    if (aavp.a().isSelected()) {
      return aavp.a().qL();
    }
    return this.content;
  }
  
  public boolean onBackPress()
  {
    return false;
  }
  
  public void onClick(View paramView) {}
  
  public void onPause()
  {
    this.bAx = false;
    aavp localaavp = aavp.a();
    if ((localaavp.isSelected()) && (localaavp.Xy())) {
      localaavp.detach();
    }
  }
  
  public void onResume()
  {
    this.bAx = true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavx
 * JD-Core Version:    0.7.0.1
 */