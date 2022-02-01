import android.graphics.Rect;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation.1;
import com.tencent.mobileqq.activity.aio.anim.SigTlpAnimation.2;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.widget.MutilayoutSlideDetectListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ListView;
import com.tencent.widget.MaxHeightRelativelayout;
import java.io.File;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class wnt
  extends wnw
{
  protected static Rect aZ = new Rect();
  public aqqs.a a;
  private wnt.a jdField_a_of_type_Wnt$a;
  private xmj.a jdField_a_of_type_Xmj$a;
  public String aTv;
  public String aTw;
  protected boolean beG;
  public String[] cA;
  private int mPosition;
  protected Rect rect = new Rect();
  public View view;
  
  public wnt(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.d = null;
    this.handler = new Handler();
  }
  
  public void Cp(int paramInt)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.offsetChildrenTopAndBottom(paramInt);
  }
  
  protected boolean RA()
  {
    if (this.mView != null)
    {
      this.mView.offsetLeftAndRight(this.rect.left);
      this.mView.offsetTopAndBottom(this.rect.top);
      if (QLog.isColorLevel()) {
        QLog.d("SigTlpAnimation", 2, "rect.left=" + this.rect.left + ",rect.top=" + this.rect.top);
      }
      if ((this.beG) && (this.view != null))
      {
        this.view.offsetLeftAndRight(aZ.left);
        this.view.offsetTopAndBottom(aZ.top);
        if (QLog.isColorLevel()) {
          QLog.d("SigTlpAnimation", 2, "rectAio.left=" + aZ.left + ",rectAio.top=" + aZ.top);
        }
      }
    }
    for (;;)
    {
      return true;
      if (this.beG) {
        this.handler.post(new SigTlpAnimation.1(this));
      }
    }
  }
  
  public boolean RB()
  {
    int k = 0;
    Object localObject;
    label160:
    int m;
    int j;
    int i;
    if (this.beG)
    {
      this.jdField_a_of_type_Xmj$a = null;
      this.mPosition = wja.a(Long.valueOf(this.aTv).longValue(), this.l.getAdapter());
      localObject = wja.a(wja.a(this.l, this.mPosition));
      if ((localObject != null) && ((localObject instanceof xmj.a))) {
        this.jdField_a_of_type_Xmj$a = ((xmj.a)localObject);
      }
      while (this.jdField_a_of_type_Xmj$a == null)
      {
        yE(true);
        return false;
        if (QLog.isColorLevel()) {
          QLog.e("SigTlpAnimation", 2, "list view item's tag can not cast to Holder, object:" + localObject + ",mPosition:" + this.mPosition);
        }
      }
      if (this.jdField_a_of_type_Xmj$a.a != null)
      {
        localObject = this.jdField_a_of_type_Xmj$a.a.getItemView();
        if ((this.mView == null) || (localObject == null)) {
          break label643;
        }
        m = ((View)localObject).getLeft();
        j = b((View)localObject, true);
        int n = this.l.getScrollY();
        if (QLog.isColorLevel()) {
          QLog.e("SigTlpAnimation", 2, "getParentTop(mHolder.sigView, true):" + b((View)localObject, true) + ",istview.getScrollY():" + this.l.getScrollY());
        }
        k = ((View)localObject).getWidth();
        i = ((View)localObject).getHeight();
        if (this.view != null) {
          aZ.top = 0;
        }
        j -= n;
      }
    }
    for (;;)
    {
      label280:
      m += (int)(this.jdField_a_of_type_Aqqs$a.posX * k);
      j += (int)(this.jdField_a_of_type_Aqqs$a.posY * i);
      localObject = this.rect;
      float f = this.jdField_a_of_type_Aqqs$a.width;
      k = (int)(k * f);
      f = this.jdField_a_of_type_Aqqs$a.height;
      ((Rect)localObject).set(m, j, k + m, (int)(i * f) + j);
      if (QLog.isColorLevel()) {
        QLog.d("SigTlpAnimation", 2, "bindView top=" + j + ",left=" + m);
      }
      return true;
      localObject = null;
      break label160;
      if (this.view == null)
      {
        this.jdField_a_of_type_Wnt$a = null;
        this.mPosition = SignatureManager.a(this.aTv, this.l.getAdapter());
        localObject = wja.a(wja.a(this.l, this.mPosition));
        if ((localObject != null) && ((localObject instanceof wnt.a)))
        {
          this.jdField_a_of_type_Wnt$a = ((wnt.a)localObject);
          label478:
          if (this.jdField_a_of_type_Wnt$a == null) {
            break label581;
          }
          if (this.mView == null) {
            break label636;
          }
          j = this.jdField_a_of_type_Wnt$a.hs.getRight() - this.jdField_a_of_type_Wnt$a.hs.getLeft();
          i = this.jdField_a_of_type_Wnt$a.hs.getBottom() - this.jdField_a_of_type_Wnt$a.hs.getTop();
        }
      }
      for (;;)
      {
        m = 0;
        k = j;
        j = 0;
        break label280;
        if (!QLog.isColorLevel()) {
          break label478;
        }
        QLog.e("SigTlpAnimation", 2, "list view item's tag can not cast to ItemViewHolder, object:" + localObject);
        break label478;
        label581:
        break;
        m = this.view.getLeft();
        j = this.view.getTop();
        k = this.view.getRight() - this.view.getLeft();
        i = this.view.getBottom() - this.view.getTop();
        break label280;
        label636:
        i = 0;
        j = 0;
      }
      label643:
      i = 0;
      j = 0;
      m = 0;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("SigTlpAnimation", 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    if ((this.beG) && (this.mView != null))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
      at(false);
    }
    return false;
  }
  
  public boolean at(boolean paramBoolean)
  {
    if (this.mView == null) {
      return false;
    }
    if (RB())
    {
      if (paramBoolean) {
        this.mView.setBackgroundDrawable(this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      }
      ViewGroup.LayoutParams localLayoutParams1 = new ViewGroup.LayoutParams(-2, -2);
      localLayoutParams1.height = (this.rect.bottom - this.rect.top);
      localLayoutParams1.width = (this.rect.right - this.rect.left);
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.mView, -1, localLayoutParams1, false);
      if ((this.beG) && (this.view != null))
      {
        ViewGroup.LayoutParams localLayoutParams2 = new ViewGroup.LayoutParams(-2, -2);
        localLayoutParams2.height = (this.view.getBottom() - this.view.getTop());
        localLayoutParams2.width = (this.view.getRight() - this.view.getLeft());
        Object localObject = (View)this.view.getParent();
        if (((this.view instanceof TextView)) && (localObject != null) && ((localObject instanceof RelativeLayout)))
        {
          localObject = (RelativeLayout)this.view.getParent();
          Rect localRect = aZ;
          int i = this.view.getLeft();
          int j = ((RelativeLayout)localObject).getLeft();
          localRect.left = (((View)((RelativeLayout)localObject).getParent()).getLeft() + (j + i));
          ((RelativeLayout)localObject).removeView(this.view);
        }
        if (QLog.isColorLevel()) {
          QLog.d("SigTlpAnimation", 2, "paramButton.width=" + localLayoutParams2.width + ",paramButton.height=" + localLayoutParams2.height);
        }
        this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.view, 1, localLayoutParams2, false);
        this.view.layout(0, 0, localLayoutParams2.width, localLayoutParams2.height);
      }
      this.mView.layout(0, 0, localLayoutParams1.width, localLayoutParams1.height);
      return RA();
    }
    return false;
  }
  
  public int b(View paramView, boolean paramBoolean)
  {
    View localView = (View)paramView.getParent();
    int i = paramView.getTop();
    if (localView == null) {
      return i;
    }
    if (paramBoolean)
    {
      do
      {
        if ((localView instanceof ChatXListView)) {
          break;
        }
        j = localView.getTop() + i;
        paramView = (View)localView.getParent();
        localView = paramView;
        i = j;
      } while (paramView != null);
      return j;
    }
    paramView = localView;
    int j = i;
    if (this.view == null)
    {
      j = i;
      do
      {
        i = j;
        if ((localView instanceof MutilayoutSlideDetectListView)) {
          break;
        }
        i = j + localView.getTop();
        paramView = (View)localView.getParent();
        localView = paramView;
        j = i;
      } while (paramView != null);
      return i;
    }
    do
    {
      i = j;
      if ((paramView instanceof MaxHeightRelativelayout)) {
        break;
      }
      i = j + paramView.getTop();
      localView = (View)paramView.getParent();
      paramView = localView;
      j = i;
    } while (localView != null);
    return i;
    return i;
  }
  
  public void bZL()
  {
    yE(false);
  }
  
  public boolean c(Object... paramVarArgs)
  {
    if (paramVarArgs.length != 7) {
      return false;
    }
    this.view = null;
    String str1 = String.valueOf(paramVarArgs[1]);
    this.aTw = String.valueOf(paramVarArgs[2]);
    String str2 = (String)paramVarArgs[3];
    this.beG = ((Boolean)paramVarArgs[4]).booleanValue();
    if (paramVarArgs[5] != null) {
      this.view = ((View)paramVarArgs[5]);
    }
    this.jdField_a_of_type_Aqqs$a = ((aqqs.a)paramVarArgs[6]);
    ThreadManager.getFileThreadHandler().post(new SigTlpAnimation.2(this, str1, str2));
    return true;
  }
  
  public boolean hB(String paramString)
  {
    boolean bool2 = true;
    Object localObject = new File(paramString);
    boolean bool1;
    if ((localObject == null) || (!((File)localObject).exists()) || (!((File)localObject).isDirectory())) {
      bool1 = false;
    }
    do
    {
      return bool1;
      bool1 = bool2;
    } while (this.cA != null);
    localObject = aqhq.ag(paramString);
    if (((ArrayList)localObject).size() <= 0) {
      return false;
    }
    this.cA = new String[((ArrayList)localObject).size()];
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString).append(File.separator).append("%d.png");
    paramString = ((StringBuilder)localObject).toString();
    int j = this.cA.length;
    int i = 0;
    for (;;)
    {
      bool1 = bool2;
      if (i >= j) {
        break;
      }
      this.cA[i] = String.format(paramString, new Object[] { Integer.valueOf(i + 1) });
      i += 1;
    }
  }
  
  public void pause()
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.setPaused(true);
  }
  
  public void resume()
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.setPaused(false);
  }
  
  public void stop()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.recycle();
    }
  }
  
  public void yE(boolean paramBoolean)
  {
    stop();
    if (this.mView != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.mView);
      this.mView = null;
    }
    if ((paramBoolean) && ((this.view == null) || (this.beG)))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeAllViews();
      this.view = null;
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
  
  public static class a
  {
    public RelativeLayout hs;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnt
 * JD-Core Version:    0.7.0.1
 */