import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.InputLinearLayout;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.widget.MixedMsgLinearLayout;
import com.tencent.widget.immersive.ImmersiveUtils;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class aavp
  implements aawe, Handler.Callback
{
  private static final int clA = aqnm.dpToPx(30.0F);
  private static final int clB = aqnm.dpToPx(28.0F);
  private static final int clC = aqnm.dpToPx(72.0F);
  private static final int clD = aqnm.dpToPx(63.0F);
  protected long MM = -1L;
  private aawc jdField_a_of_type_Aawc;
  private aawd jdField_a_of_type_Aawd;
  private aawf jdField_a_of_type_Aawf;
  protected aawg a;
  private aawd b;
  private boolean bAv = true;
  private int bOL;
  private int bOM = -1;
  private int clE = -1;
  private int clF = -1;
  private int clG = -1;
  private int clH;
  private WeakReference<aavr> eZ;
  private final int[] jM = new int[2];
  private int mEndIndex = -1;
  private final Handler mHandler = new Handler(Looper.getMainLooper(), this);
  private boolean mHasSelected;
  private List<WeakReference<aawa>> mListeners = new ArrayList();
  private int mStartIndex = -1;
  ChatMessage p;
  
  private boolean XC()
  {
    return this.jdField_a_of_type_Aawc != null;
  }
  
  private boolean XD()
  {
    return this.jdField_a_of_type_Aawg != null;
  }
  
  public static aavp a()
  {
    return aavp.a.a;
  }
  
  private void czE()
  {
    this.jdField_a_of_type_Aawc.highlightBackgroundColor(this.clH);
    this.jdField_a_of_type_Aawc.selectContent(this.mStartIndex, this.mEndIndex);
    this.jdField_a_of_type_Aawc.highlightContent();
    this.jdField_a_of_type_Aawd.Ci(this.bOL);
    this.b.Ci(this.bOL);
    this.jdField_a_of_type_Aawc.locationByIndex(this.mStartIndex, this.jM, true);
    this.jdField_a_of_type_Aawd.aq(this.jM[0], this.jM[1], 1);
    this.jdField_a_of_type_Aawc.locationByIndex(this.mEndIndex, this.jM, false);
    this.b.aq(this.jM[0], this.jM[1], 2);
  }
  
  private void czF()
  {
    if ((this.jdField_a_of_type_Aawd == null) || (this.b == null)) {
      throw new IllegalStateException("Has not bound cursors.");
    }
  }
  
  private void czG()
  {
    if (this.jdField_a_of_type_Aawf == null) {
      throw new IllegalStateException("Has no magnifier.");
    }
  }
  
  private void czH()
  {
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
    {
      aawa localaawa = (aawa)((WeakReference)localIterator.next()).get();
      if (localaawa != null) {
        localaawa.a(this);
      }
    }
  }
  
  public void Ci(int paramInt)
  {
    this.bOL = paramInt;
  }
  
  public void Di(boolean paramBoolean)
  {
    this.bAv = paramBoolean;
  }
  
  public void GF(int paramInt)
  {
    this.clE = paramInt;
  }
  
  public void GG(int paramInt)
  {
    this.clH = paramInt;
  }
  
  void GH(int paramInt)
  {
    int m = 0;
    if (!XC()) {}
    while (!XD()) {
      return;
    }
    int i;
    int k;
    label61:
    Object localObject;
    if ((this.jdField_a_of_type_Aawg instanceof aavv))
    {
      i = ((aavv)this.jdField_a_of_type_Aawg).clW;
      if (!(this.jdField_a_of_type_Aawg instanceof aavv)) {
        break label326;
      }
      k = ((aavv)this.jdField_a_of_type_Aawg).clV;
      localObject = this.jdField_a_of_type_Aawc.view();
      if (((View)localObject).getId() == 2131364503) {
        break label592;
      }
      View localView = ((View)localObject).findViewById(2131364503);
      if (localView == null) {
        break label592;
      }
      localObject = localView;
    }
    label326:
    label592:
    for (;;)
    {
      ((View)localObject).getLocationInWindow(this.jM);
      int n = this.jM[1];
      int i1 = this.jM[1] + ((View)localObject).getHeight();
      int i2 = this.jM[0];
      int i3 = this.jdField_a_of_type_Aawc.view().getPaddingLeft();
      this.jdField_a_of_type_Aawc.locationByIndex(this.mStartIndex, this.jM, true);
      int i4 = this.jM[0];
      this.jdField_a_of_type_Aawc.locationByIndex(this.mEndIndex, this.jM, false);
      int j = this.jM[0];
      if (this.clE == 2) {
        if ((j - i > clA) || (j - i < 0)) {
          if (j - clA < i3 + i2)
          {
            label240:
            if (n - clB >= clC + ImmersiveUtils.statusHeight) {
              break label570;
            }
            if (i1 + 0 >= clC + ImmersiveUtils.statusHeight) {
              break label441;
            }
            if ((k == 0) || (k - clB <= clC + ImmersiveUtils.statusHeight)) {
              break label386;
            }
            paramInt = clB;
            j = i;
            paramInt = k - paramInt;
            i = m;
          }
        }
      }
      for (;;)
      {
        az(j, paramInt, i);
        return;
        i = this.jdField_a_of_type_Aawg.zp();
        break;
        k = this.jdField_a_of_type_Aawg.zq();
        break label61;
        j -= clA;
        break label240;
        j = i;
        break label240;
        if ((i - i4 > clA) || (i - i4 < 0))
        {
          j = clA + i4;
          break label240;
        }
        j = i;
        break label240;
        if ((k != 0) && (clD + k - clB < paramInt))
        {
          paramInt = clB;
          m = 1;
          paramInt = k - paramInt;
          j = i;
          i = m;
        }
        else
        {
          paramInt = clC;
          paramInt = ImmersiveUtils.statusHeight + paramInt;
          i = m;
        }
      }
      m = i1 + 0;
      if (clD + m > paramInt) {
        if ((k != 0) && (k - clB > clC + ImmersiveUtils.statusHeight))
        {
          paramInt = clB;
          k -= paramInt;
          paramInt = 0;
          j = i;
          i = k;
        }
      }
      for (;;)
      {
        k = paramInt;
        paramInt = i;
        i = k;
        break;
        if ((k != 0) && (clD + k - clB < paramInt))
        {
          paramInt = clB;
          j = i;
          i = k - paramInt;
          paramInt = 1;
        }
        else
        {
          i = clC + ImmersiveUtils.statusHeight + clD + clB;
          paramInt = 0;
          continue;
          paramInt = 1;
          i = m;
        }
      }
      if (n > paramInt) {}
      for (;;)
      {
        i = m;
        break;
        paramInt = n - clB;
      }
    }
  }
  
  public void O(ChatMessage paramChatMessage)
  {
    XC();
    this.mStartIndex = 0;
    this.mEndIndex = this.jdField_a_of_type_Aawc.contentLength();
    if (this.mStartIndex >= this.mEndIndex)
    {
      this.mHasSelected = false;
      return;
    }
    this.MM = System.currentTimeMillis();
    this.p = paramChatMessage;
    this.mHasSelected = true;
    this.jdField_a_of_type_Aawc.highlightBackgroundColor(this.clH);
    this.jdField_a_of_type_Aawc.selectContent(this.mStartIndex, this.mEndIndex);
    this.jdField_a_of_type_Aawc.highlightContent();
    czF();
    this.bOM = -1;
    this.clE = -1;
    this.clF = -1;
    this.clG = -1;
    this.jdField_a_of_type_Aawd.Ci(this.bOL);
    this.b.Ci(this.bOL);
    this.jdField_a_of_type_Aawc.locationByIndex(this.mStartIndex, this.jM, true);
    this.jdField_a_of_type_Aawd.aq(this.jM[0], this.jM[1], 1);
    this.jdField_a_of_type_Aawc.locationByIndex(this.mEndIndex, this.jM, false);
    this.b.aq(this.jM[0], this.jM[1], 2);
    czz();
    if (this.jdField_a_of_type_Aawf == null) {
      this.jdField_a_of_type_Aawf = new aawb();
    }
    for (;;)
    {
      czH();
      return;
      if (this.jdField_a_of_type_Aawf.isShow()) {
        this.jdField_a_of_type_Aawf.dismiss();
      }
    }
  }
  
  public boolean XA()
  {
    return (this.b != null) && (this.b.go(2));
  }
  
  public boolean XB()
  {
    return (Xz()) && (XA());
  }
  
  public boolean Xy()
  {
    if (this.jdField_a_of_type_Aawg != null) {
      return this.jdField_a_of_type_Aawg.isShow();
    }
    return false;
  }
  
  public boolean Xz()
  {
    return (this.jdField_a_of_type_Aawd != null) && (this.jdField_a_of_type_Aawd.go(1));
  }
  
  @Nullable
  aavr a()
  {
    if (this.eZ != null) {
      return (aavr)this.eZ.get();
    }
    return null;
  }
  
  void a(@Nullable aavr paramaavr)
  {
    if (this.eZ != null) {
      this.eZ.clear();
    }
    this.eZ = new WeakReference(paramaavr);
  }
  
  public void a(@NonNull aawa paramaawa)
  {
    Iterator localIterator = this.mListeners.iterator();
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
    } while (paramaawa != (aawa)((WeakReference)localIterator.next()).get());
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        this.mListeners.add(new WeakReference(paramaawa));
      }
      return;
    }
  }
  
  public void a(@NonNull aawc paramaawc)
  {
    this.jdField_a_of_type_Aawc = paramaawc;
  }
  
  public void a(@NonNull aawd paramaawd1, @NonNull aawd paramaawd2)
  {
    this.jdField_a_of_type_Aawd = paramaawd1;
    this.b = paramaawd2;
  }
  
  public void a(@NonNull aawg paramaawg)
  {
    this.jdField_a_of_type_Aawg = paramaawg;
  }
  
  public boolean aC(int paramInt1, int paramInt2)
  {
    if (!isSelected()) {}
    int i;
    int j;
    int k;
    int m;
    do
    {
      do
      {
        return false;
      } while (this.jdField_a_of_type_Aawc == null);
      View localView = this.jdField_a_of_type_Aawc.view();
      localView.getLocationInWindow(this.jM);
      i = this.jM[0];
      j = this.jM[1];
      k = localView.getMeasuredWidth();
      m = localView.getMeasuredHeight();
    } while ((paramInt1 < i) || (paramInt1 > k + i) || (paramInt2 < j) || (paramInt2 > m + j));
    return true;
  }
  
  public void az(int paramInt1, int paramInt2, int paramInt3)
  {
    XC();
    XD();
    Message localMessage = Message.obtain();
    localMessage.what = 1;
    localMessage.arg1 = paramInt1;
    localMessage.arg2 = paramInt2;
    localMessage.obj = Integer.valueOf(paramInt3);
    this.mHandler.sendMessageDelayed(localMessage, 10L);
  }
  
  public int b(float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((paramInt1 == 1) && (this.jdField_a_of_type_Aawd != null) && (Xz())) {
      return this.jdField_a_of_type_Aawd.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    if ((paramInt1 == 2) && (this.b != null) && (XA())) {
      return this.b.a(paramFloat1, paramFloat2, paramInt1, paramInt2);
    }
    return -1;
  }
  
  public void b(@NonNull aawa paramaawa)
  {
    Iterator localIterator = this.mListeners.iterator();
    WeakReference localWeakReference;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localWeakReference = (WeakReference)localIterator.next();
    } while (paramaawa != (aawa)localWeakReference.get());
    for (paramaawa = localWeakReference;; paramaawa = null)
    {
      if (paramaawa != null) {
        this.mListeners.remove(paramaawa);
      }
      return;
    }
  }
  
  @Nullable
  public View bK()
  {
    if (this.jdField_a_of_type_Aawc != null) {
      return this.jdField_a_of_type_Aawc.view();
    }
    return null;
  }
  
  public void bg(int paramInt, boolean paramBoolean)
  {
    this.bOM = paramInt;
    if (!paramBoolean) {
      this.clE = paramInt;
    }
  }
  
  public void czA()
  {
    XD();
    this.jdField_a_of_type_Aawg.dismiss();
  }
  
  public void czB()
  {
    czH();
  }
  
  void czC()
  {
    XC();
    czF();
    this.mHandler.sendEmptyMessage(4);
  }
  
  void czD()
  {
    if (this.jdField_a_of_type_Aawg != null)
    {
      this.mHandler.removeMessages(1);
      if (this.jdField_a_of_type_Aawg.isShow()) {
        this.jdField_a_of_type_Aawg.dismiss();
      }
    }
    if (this.jdField_a_of_type_Aawc != null)
    {
      this.jdField_a_of_type_Aawc.selectContent(-1, -1);
      this.jdField_a_of_type_Aawc.clearHighlightContent();
      this.jdField_a_of_type_Aawc = null;
    }
    if (this.jdField_a_of_type_Aawd != null)
    {
      if (this.jdField_a_of_type_Aawd.go(1)) {
        this.jdField_a_of_type_Aawd.Ch(1);
      }
      this.jdField_a_of_type_Aawd = null;
    }
    if (this.b != null)
    {
      if (this.b.go(2)) {
        this.b.Ch(2);
      }
      this.b = null;
    }
    a(null);
  }
  
  public void czz()
  {
    gf((View)null);
  }
  
  public void detach()
  {
    this.p = null;
    if (this.jdField_a_of_type_Aawf != null)
    {
      if (this.jdField_a_of_type_Aawf.isShow()) {
        this.jdField_a_of_type_Aawf.dismiss();
      }
      this.jdField_a_of_type_Aawf = null;
    }
    czD();
    this.jdField_a_of_type_Aawg = null;
    this.mHasSelected = false;
    this.mStartIndex = -1;
    this.mEndIndex = -1;
    this.bOM = -1;
    this.clE = -1;
    this.clF = -1;
    this.clG = -1;
    this.MM = -1L;
    czH();
  }
  
  public int endIndex()
  {
    XC();
    return this.mEndIndex;
  }
  
  void gf(View paramView)
  {
    if (paramView != null) {
      paramView.getLocationInWindow(this.jM);
    }
    for (int i = this.jM[1];; i = aqnm.getScreenHeight())
    {
      GH(i);
      return;
    }
  }
  
  public void gy(int paramInt1, int paramInt2)
  {
    this.clF = paramInt1;
    this.clG = paramInt2;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (paramMessage.what == 1)
    {
      this.mHandler.removeMessages(1);
      if ((this.jdField_a_of_type_Aawc != null) && (this.jdField_a_of_type_Aawg != null))
      {
        this.jdField_a_of_type_Aawg.b(this.jdField_a_of_type_Aawc.view(), paramMessage.arg1, paramMessage.arg2, ((Integer)paramMessage.obj).intValue());
        if ((this.jdField_a_of_type_Aawf != null) && (this.jdField_a_of_type_Aawf.isShow())) {
          this.jdField_a_of_type_Aawf.dismiss();
        }
      }
      return true;
    }
    aawd localaawd;
    if (paramMessage.what == 2)
    {
      this.mHandler.removeMessages(2);
      this.mHandler.removeMessages(3);
      if (this.jdField_a_of_type_Aawf != null)
      {
        if (((Integer)paramMessage.obj).intValue() != 1) {
          break label192;
        }
        localaawd = this.jdField_a_of_type_Aawd;
        if ((localaawd != null) && (this.jdField_a_of_type_Aawc != null)) {
          this.jdField_a_of_type_Aawf.a(localaawd.view(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Aawc.view(), true);
        }
      }
    }
    for (;;)
    {
      return false;
      label192:
      localaawd = this.b;
      break;
      if (paramMessage.what == 3)
      {
        this.mHandler.removeMessages(2);
        this.mHandler.removeMessages(3);
        if (this.jdField_a_of_type_Aawf != null)
        {
          if (((Integer)paramMessage.obj).intValue() == 1) {}
          for (localaawd = this.jdField_a_of_type_Aawd;; localaawd = this.b)
          {
            if ((localaawd == null) || (this.jdField_a_of_type_Aawc == null)) {
              break label303;
            }
            this.jdField_a_of_type_Aawf.a(localaawd.view(), paramMessage.arg1, paramMessage.arg2, this.jdField_a_of_type_Aawc.view(), false);
            break;
          }
        }
      }
      else
      {
        label303:
        if (paramMessage.what == 4)
        {
          this.mHandler.removeMessages(4);
          if ((this.jdField_a_of_type_Aawc != null) && (this.jdField_a_of_type_Aawd != null) && (this.b != null))
          {
            czE();
            czz();
          }
        }
      }
    }
  }
  
  public boolean isSelectable()
  {
    return true;
  }
  
  public boolean isSelected()
  {
    return this.mHasSelected;
  }
  
  void j(BaseChatPie paramBaseChatPie)
  {
    BaseChatPie localBaseChatPie = paramBaseChatPie;
    if (paramBaseChatPie == null)
    {
      localBaseChatPie = paramBaseChatPie;
      if ((this.jdField_a_of_type_Aawg instanceof aavo)) {
        localBaseChatPie = ((aavo)this.jdField_a_of_type_Aawg).f;
      }
    }
    if ((localBaseChatPie != null) && (localBaseChatPie.a != null) && (localBaseChatPie.a.getVisibility() == 0)) {
      localBaseChatPie.a.getLocationInWindow(this.jM);
    }
    for (int i = this.jM[1];; i = aqnm.getScreenHeight())
    {
      GH(i);
      return;
    }
  }
  
  public int length()
  {
    XC();
    if (this.jdField_a_of_type_Aawc != null) {
      return this.jdField_a_of_type_Aawc.contentLength();
    }
    return 0;
  }
  
  @Nullable
  public String qK()
  {
    XC();
    if (this.jdField_a_of_type_Aawc != null)
    {
      CharSequence localCharSequence = this.jdField_a_of_type_Aawc.content();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return "";
    }
    return "";
  }
  
  @Nullable
  public String qL()
  {
    XC();
    CharSequence localCharSequence = this.jdField_a_of_type_Aawc.selectContent();
    if (localCharSequence != null) {
      return localCharSequence.toString();
    }
    return null;
  }
  
  public String qM()
  {
    if ((this.jdField_a_of_type_Aawc instanceof MixedMsgLinearLayout))
    {
      XC();
      CharSequence localCharSequence = ((MixedMsgLinearLayout)this.jdField_a_of_type_Aawc).z();
      if (localCharSequence != null) {
        return localCharSequence.toString();
      }
      return null;
    }
    return qL();
  }
  
  public void selectContent(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) || (paramInt2 == -1))
    {
      this.mStartIndex = -1;
      this.mEndIndex = -1;
      this.mHasSelected = false;
    }
    label191:
    for (;;)
    {
      XC();
      this.jdField_a_of_type_Aawc.selectContent(this.mStartIndex, this.mEndIndex);
      this.jdField_a_of_type_Aawc.highlightContent();
      czF();
      this.jdField_a_of_type_Aawc.locationByIndex(this.mStartIndex, this.jM, true);
      this.jdField_a_of_type_Aawd.aq(this.jM[0], this.jM[1], 1);
      this.jdField_a_of_type_Aawc.locationByIndex(this.mEndIndex, this.jM, false);
      this.b.aq(this.jM[0], this.jM[1], 2);
      czH();
      return;
      if (paramInt1 > paramInt2) {
        this.mStartIndex = paramInt2;
      }
      for (this.mEndIndex = paramInt1;; this.mEndIndex = paramInt2)
      {
        if (this.mEndIndex - this.mStartIndex <= 0) {
          break label191;
        }
        this.mHasSelected = true;
        break;
        this.mStartIndex = paramInt1;
      }
    }
  }
  
  public int startIndex()
  {
    XC();
    return this.mStartIndex;
  }
  
  public int touchIndex(int paramInt1, int paramInt2)
  {
    XC();
    return this.jdField_a_of_type_Aawc.touchIndex(paramInt1, paramInt2);
  }
  
  public void u(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    XC();
    czG();
    if (this.bOM == -1) {}
    while (!this.bAv) {
      return;
    }
    Message localMessage = Message.obtain();
    if (paramBoolean) {}
    for (int i = 2;; i = 3)
    {
      localMessage.what = i;
      localMessage.arg1 = paramInt1;
      localMessage.arg2 = paramInt2;
      localMessage.obj = Integer.valueOf(this.bOM);
      this.mHandler.sendMessageDelayed(localMessage, 10L);
      return;
    }
  }
  
  public int zo()
  {
    return this.bOM;
  }
  
  static final class a
  {
    public static final aavp a = new aavp(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aavp
 * JD-Core Version:    0.7.0.1
 */