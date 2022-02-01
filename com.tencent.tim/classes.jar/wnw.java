import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.view.View;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.a;
import com.tencent.mobileqq.activity.aio.anim.VipPngPlayAnimationDrawable;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.1;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.2;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.3;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.4;
import com.tencent.mobileqq.activity.aio.anim.XBubbleAnimation.5;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import com.tencent.widget.ListView;
import java.io.IOException;

public class wnw
  extends AIOAnimationConatiner.a
{
  private long Il;
  public adxp.a b;
  private Rect bb = new Rect();
  private boolean beH = true;
  public adxp.a c;
  private BaseBubbleBuilder.e c;
  public VipPngPlayAnimationDrawable c;
  public VipPngPlayAnimationDrawable d;
  public Handler handler;
  public boolean mIsStart;
  public boolean mIsStop;
  protected int mType;
  public View mView;
  private View wr;
  
  public wnw(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.d = new VipPngPlayAnimationDrawable(paramListView.getResources());
    this.handler = new Handler();
  }
  
  private int[] a(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    switch (paramInt1)
    {
    default: 
      paramInt1 = 0;
      paramInt2 = 0;
      return new int[] { paramInt2, paramInt1 };
    case 0: 
      if (paramBoolean) {}
      for (paramInt1 = this.bb.right;; paramInt1 = this.bb.left)
      {
        paramInt3 = this.bb.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 1: 
      if (paramBoolean) {}
      for (paramInt1 = this.bb.right;; paramInt1 = this.bb.left)
      {
        paramInt3 = this.bb.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 2: 
      if (paramBoolean) {}
      for (paramInt1 = this.bb.right;; paramInt1 = this.bb.left)
      {
        paramInt3 = (int)(this.bb.bottom - this.bb.height() / 2.0F - paramInt3 / 2.0F);
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 3: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.bb.right + this.bb.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.bb.left + this.bb.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.bb.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 4: 
      if (paramBoolean) {}
      for (paramInt1 = (int)(this.bb.right + this.bb.width() / 2 - paramInt2 / 2.0F);; paramInt1 = (int)(this.bb.left + this.bb.width() / 2 - paramInt2 / 2.0F))
      {
        paramInt3 = this.bb.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 5: 
      if (paramBoolean) {}
      for (paramInt1 = this.bb.left;; paramInt1 = this.bb.right)
      {
        paramInt3 = this.bb.top;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    case 6: 
      if (paramBoolean) {}
      for (paramInt1 = this.bb.left;; paramInt1 = this.bb.right)
      {
        paramInt3 = this.bb.bottom;
        paramInt2 = paramInt1;
        paramInt1 = paramInt3;
        break;
      }
    }
    if (paramBoolean) {}
    for (paramInt1 = this.bb.left;; paramInt1 = this.bb.right)
    {
      paramInt3 = (int)(this.bb.bottom - this.bb.height() / 2.0F - paramInt3 / 2.0F);
      paramInt2 = paramInt1;
      paramInt1 = paramInt3;
      break;
    }
  }
  
  public void Cp(int paramInt)
  {
    int j = 0;
    if (this.mView != null)
    {
      this.mView.offsetTopAndBottom(paramInt);
      if ((!this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mFinished) && (this.mView.getBottom() > 0)) {}
    }
    for (int i = 1;; i = 0)
    {
      if (this.wr != null)
      {
        this.wr.offsetTopAndBottom(paramInt);
        if (!this.d.mFinished)
        {
          paramInt = j;
          if (this.wr.getBottom() > 0) {
            break label78;
          }
        }
      }
      for (paramInt = 1;; paramInt = i)
      {
        label78:
        if ((paramInt != 0) && (this.mType != 0)) {
          this.handler.post(new XBubbleAnimation.2(this));
        }
        return;
      }
    }
  }
  
  protected boolean RA()
  {
    if ((this.mView == null) && (this.wr == null)) {
      return false;
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e = null;
    int i = wja.a(this.Il, this.l.getAdapter());
    Object localObject = wja.a(wja.a(this.l, i));
    boolean bool1;
    label371:
    boolean bool2;
    if ((localObject != null) && ((localObject instanceof BaseBubbleBuilder.e)))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e = ((BaseBubbleBuilder.e)localObject);
      if ((this.mType != 0) && ((this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e == null) || (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E == null) || (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.a == null))) {
        bZS();
      }
      if ((this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e == null) || (this.mView == null) || (this.b == null)) {
        break label1455;
      }
      this.bb.top = (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E.getTop() + this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.a.getTop() - this.l.getScrollY());
      this.bb.left = (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E.getLeft() + this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.a.getLeft());
      this.bb.bottom = (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E.getBottom() + this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.a.getTop() - this.l.getScrollY());
      this.bb.right = (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E.getRight() + this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.a.getLeft());
      if (QLog.isColorLevel()) {
        QLog.d("XBubbleAnimation", 2, "bindView bubbleRect top=" + this.bb.top + ",left=" + this.bb.left + ",bottom=" + this.bb.bottom + ",right=" + this.bb.right + ",listView height=" + this.l.getHeight());
      }
      if (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.mMessage.isSend()) {
        break label538;
      }
      bool1 = true;
      if ((this.b == null) || (this.b.g == null) || (this.b.g.mirror)) {
        break label544;
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mReverse = false;
      label409:
      if (this.jdField_c_of_type_Adxp$a != null)
      {
        if (!this.b.key.equals(this.jdField_c_of_type_Adxp$a.key)) {
          break label562;
        }
        localObject = this.d;
        if (bool1) {
          break label556;
        }
        bool2 = true;
      }
    }
    label450:
    for (((VipPngPlayAnimationDrawable)localObject).mReverse = bool2;; this.d.mReverse = bool1)
    {
      if (this.mType != 6) {
        break label574;
      }
      this.mView.layout(this.bb.left, this.bb.top, this.bb.right, this.bb.bottom);
      return true;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.e("XBubbleAnimation", 2, "list view item's tag can not cast to ViewHolder, object:" + localObject);
      break;
      bool1 = false;
      break label371;
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mReverse = bool1;
      break label409;
      bool2 = false;
      break label450;
    }
    label538:
    label544:
    label556:
    label562:
    label574:
    localObject = a(this.b.bkg, this.b.mRect.right, this.b.mRect.bottom, bool1);
    i = localObject[1];
    int n = this.b.mRect.top + i;
    int k;
    int j;
    int m;
    if (!bool1)
    {
      i = localObject[0];
      i = this.b.mRect.left + i;
      k = i;
      if (this.jdField_c_of_type_Adxp$a == null) {
        break label1489;
      }
      localObject = a(this.jdField_c_of_type_Adxp$a.bkg, this.jdField_c_of_type_Adxp$a.mRect.right, this.jdField_c_of_type_Adxp$a.mRect.bottom, bool1);
      j = localObject[0] - this.jdField_c_of_type_Adxp$a.mRect.left - this.jdField_c_of_type_Adxp$a.mRect.right;
      m = localObject[1] + this.jdField_c_of_type_Adxp$a.mRect.top;
      k = i;
      i = m;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("XBubbleAnimation", 2, "bindView mView master_x=" + k + ",master_y=" + n + ",mAttrsFirst.mRect.right=" + this.b.mRect.right + ",mAttrsFirst.mRect.bottom=" + this.b.mRect.bottom + ",listview.Width=" + this.l.getWidth() + ",listview.Height=" + this.l.getHeight());
      }
      if ((k >= -this.b.mRect.right) && (k <= this.l.getWidth()) && (n >= -this.b.mRect.bottom))
      {
        k -= this.mView.getLeft();
        m = n - this.mView.getTop();
        if ((k != 0) || (m != 0))
        {
          this.mView.offsetLeftAndRight(k);
          this.mView.offsetTopAndBottom(m);
          if (QLog.isColorLevel()) {
            QLog.d("XBubbleAnimation", 2, "bindView mView.offsetLeftAndRight " + k + ",mView.offsetTopAndBottom " + m);
          }
        }
      }
      label990:
      for (bool1 = true;; bool1 = false)
      {
        if ((this.jdField_c_of_type_Adxp$a != null) && (this.wr != null) && (bool1))
        {
          if (QLog.isColorLevel()) {
            QLog.d("XBubbleAnimation", 2, "bindView mLinkView x=" + j + ",y=" + i + ",mRect.right=" + this.jdField_c_of_type_Adxp$a.mRect.right + ",mRect.bottom=" + this.jdField_c_of_type_Adxp$a.mRect.bottom + ",listview.Width=" + this.l.getWidth() + ",listview.Height=" + this.l.getHeight());
          }
          if ((j < -this.jdField_c_of_type_Adxp$a.mRect.right) || (j > this.l.getWidth()) || (i < -this.jdField_c_of_type_Adxp$a.mRect.bottom)) {
            break;
          }
          j -= this.wr.getLeft();
          i -= this.wr.getTop();
          if ((j != 0) || (i != 0))
          {
            this.wr.offsetLeftAndRight(j);
            this.wr.offsetTopAndBottom(i);
            if (QLog.isColorLevel()) {
              QLog.d("XBubbleAnimation", 2, "bindView mLinkView.offsetLeftAndRight " + j + ",mLinkView.offsetTopAndBottom " + i);
            }
          }
          for (;;)
          {
            return true;
            m = localObject[0] - this.b.mRect.left - this.b.mRect.right;
            k = m;
            if (this.jdField_c_of_type_Adxp$a == null) {
              break label1489;
            }
            localObject = a(this.jdField_c_of_type_Adxp$a.bkg, this.jdField_c_of_type_Adxp$a.mRect.right, this.jdField_c_of_type_Adxp$a.mRect.bottom, bool1);
            j = localObject[0] + this.jdField_c_of_type_Adxp$a.mRect.left;
            i = localObject[1] + this.jdField_c_of_type_Adxp$a.mRect.top;
            k = m;
            break;
            if (!QLog.isColorLevel()) {
              break label990;
            }
            QLog.d("XBubbleAnimation", 2, "bindView mView dx=" + k + ",dy=" + m);
            break label990;
            if (QLog.isColorLevel()) {
              QLog.d("XBubbleAnimation", 2, "bindView mLinkView dx=" + j + ",dy=" + i);
            }
          }
          if (this.mType == 0) {
            break;
          }
          this.handler.post(new XBubbleAnimation.1(this));
          return false;
        }
        return bool1;
      }
      label1455:
      label1489:
      i = 0;
      j = 0;
    }
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (QLog.isColorLevel()) {
      QLog.d("XBubbleAnimation", 2, "layout changed=" + paramBoolean + ",left=" + paramInt1 + ",top=" + paramInt2 + ",right=" + paramInt3 + ",bottom=" + paramInt4);
    }
    if (this.mIsStart)
    {
      RA();
      return true;
    }
    return false;
  }
  
  public void aZ(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.beH == paramBoolean1) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
        this.beH = paramBoolean1;
      } while (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e == null);
      localDrawable = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E.getBackground();
    } while (!(localDrawable instanceof adyk));
    adye.a locala;
    if (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.b != null)
    {
      locala = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.b.a;
      label62:
      if ((locala != null) && (((this.b != null) && (this.b.g.bRD)) || ((this.jdField_c_of_type_Adxp$a != null) && (this.jdField_c_of_type_Adxp$a.g.bRD))))
      {
        if (!paramBoolean1) {
          break label173;
        }
        ((adyk)localDrawable).GT(true);
      }
    }
    for (;;)
    {
      if (paramBoolean2) {
        ((adyk)localDrawable).GR(paramBoolean1);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("XBubbleAnimation", 2, "background alpha changed:" + String.valueOf(paramBoolean1));
      return;
      locala = null;
      break label62;
      label173:
      ((adyk)localDrawable).GT(false);
    }
  }
  
  public void bZL()
  {
    bZS();
  }
  
  public void bZS()
  {
    if (QLog.isColorLevel()) {
      QLog.i("XBubbleAnimation", 2, "now stop current animation!");
    }
    this.mIsStart = false;
    this.mIsStop = true;
    stop();
    if (this.mView != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.mView);
      this.mView = null;
    }
    if (this.wr != null)
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.removeViewInLayout(this.wr);
      this.wr = null;
    }
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.invalidate();
  }
  
  public boolean c(Object... paramVarArgs)
  {
    ThreadManager.post(new XBubbleAnimation.3(this, paramVarArgs), 8, null, true);
    return true;
  }
  
  public boolean g(Object[] paramArrayOfObject)
  {
    if (paramArrayOfObject.length != 3) {
      return false;
    }
    int i = ((Integer)paramArrayOfObject[0]).intValue();
    if ((((Long)paramArrayOfObject[1]).longValue() != this.Il) || (this.mType != i))
    {
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
      if ((paramArrayOfObject == null) || (paramArrayOfObject.first == null) || (((adxp.a)paramArrayOfObject.first).ez == null)) {
        return false;
      }
      this.b = ((adxp.a)paramArrayOfObject.first);
      this.jdField_c_of_type_Adxp$a = ((adxp.a)paramArrayOfObject.second);
      try
      {
        this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.B(this.b.ez);
        if ((this.jdField_c_of_type_Adxp$a != null) && (this.jdField_c_of_type_Adxp$a.ez != null)) {
          this.d.B(this.jdField_c_of_type_Adxp$a.ez);
        }
        return true;
      }
      catch (IOException paramArrayOfObject)
      {
        QLog.e("XBubbleAnimation", 1, "VipPngPlayAnimationDrawable measure exception", paramArrayOfObject);
      }
    }
    return false;
  }
  
  public boolean gp(int paramInt)
  {
    return paramInt == 0;
  }
  
  public boolean h(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject.length != 3) || (this.mIsStop)) {
      if (QLog.isColorLevel()) {
        QLog.d("XBubbleAnimation", 2, "start XBubbleAnimation failed. args.length=" + paramArrayOfObject.length + ", mIsStop=" + this.mIsStop);
      }
    }
    int j;
    long l;
    int i;
    Object localObject;
    do
    {
      return false;
      j = ((Integer)paramArrayOfObject[0]).intValue();
      l = ((Long)paramArrayOfObject[1]).longValue();
      i = wja.a(l, this.l.getAdapter());
      localObject = wja.a(wja.a(this.l, i));
      if ((localObject == null) || (!(localObject instanceof BaseBubbleBuilder.e))) {
        break;
      }
      this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e = ((BaseBubbleBuilder.e)localObject);
      if ((l == this.Il) && (this.mType == j)) {
        break label532;
      }
      paramArrayOfObject = (Pair)paramArrayOfObject[2];
    } while ((paramArrayOfObject == null) || (paramArrayOfObject.first == null) || (((adxp.a)paramArrayOfObject.first).ez == null));
    bZS();
    this.Il = l;
    this.mType = j;
    this.b = ((adxp.a)paramArrayOfObject.first);
    this.jdField_c_of_type_Adxp$a = ((adxp.a)paramArrayOfObject.second);
    this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.c(this.b.ez, this.b.duration);
    label258:
    label392:
    boolean bool;
    if (j != 0)
    {
      paramArrayOfObject = this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable;
      if (this.b.bRG)
      {
        i = 1;
        paramArrayOfObject.mRepeatCount = i;
      }
    }
    else
    {
      this.mView = new XBubbleAnimation.4(this, this.l.getContext());
      this.mView.setBackgroundDrawable(this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable);
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.mView, -1, AIOAnimationConatiner.i, false);
      this.mView.layout(0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mLayoutWidth, this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mLayoutHeight);
      if ((this.jdField_c_of_type_Adxp$a != null) && (this.jdField_c_of_type_Adxp$a.ez != null))
      {
        this.d.c(this.jdField_c_of_type_Adxp$a.ez, this.jdField_c_of_type_Adxp$a.duration);
        if (j != 0)
        {
          paramArrayOfObject = this.d;
          if (!this.jdField_c_of_type_Adxp$a.bRG) {
            break label521;
          }
          i = 1;
          paramArrayOfObject.mRepeatCount = i;
        }
        this.wr = new XBubbleAnimation.5(this, this.l.getContext());
        this.wr.setBackgroundDrawable(this.d);
        this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addViewInLayout(this.wr, -1, AIOAnimationConatiner.i, false);
        this.wr.layout(0, 0, this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mLayoutWidth, this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.mLayoutHeight);
      }
      bool = RA();
      this.mIsStart = true;
    }
    for (;;)
    {
      return bool;
      QLog.e("XBubbleAnimation", 1, "list view item's tag can not cast to ViewHolder, object:" + localObject);
      break;
      i = this.b.repeatCount;
      break label258;
      label521:
      i = this.jdField_c_of_type_Adxp$a.repeatCount;
      break label392;
      label532:
      bool = false;
    }
  }
  
  public void stop()
  {
    if (this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable != null) {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimVipPngPlayAnimationDrawable.recycle();
    }
    if (this.d != null) {
      this.d.recycle();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wnw
 * JD-Core Version:    0.7.0.1
 */