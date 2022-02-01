import android.animation.ValueAnimator;
import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Message;
import android.support.annotation.NonNull;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import dov.com.tencent.biz.qqstory.takevideo.EditLocalVideoSource;
import dov.com.tencent.biz.qqstory.takevideo.EditVideoParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.widget.ElasticImageView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(13)
public class aygg
  extends aygy
{
  public static final int[] dZ = { 2131367575, 2131367576, 2131367577, 2131367578, 2131367579, 2131367580 };
  public static final int[] ea = { 2131367555, 2131367556, 2131367557, 2131367558, 2131367559, 2131367560 };
  private aygg.b a;
  protected ElasticImageView a;
  private boolean aGS = true;
  private AtomicBoolean aY = new AtomicBoolean(false);
  private int bpZ;
  private int bqa;
  private RelativeLayout[] f;
  private RelativeLayout fS;
  protected RelativeLayout fT;
  private ImageView[] l;
  private List<aygg.c> oB = new ArrayList();
  private ViewStub y;
  
  public aygg(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  private void T(List<? extends ayjg> paramList, boolean paramBoolean)
  {
    int j = 0;
    if (paramList == null)
    {
      ram.i("Q.qqstory.record.EditVideoFragment", "updateValidFragmentThumb error. fragmentInfos=null.");
      return;
    }
    if (this.jdField_a_of_type_Aygg$b == null) {
      this.jdField_a_of_type_Aygg$b = new aygg.b();
    }
    int i;
    if (paramBoolean)
    {
      i = 0;
      label40:
      if (i >= paramList.size()) {
        break label338;
      }
      if (((ayjg)paramList.get(i)).bqJ != this.bqa) {}
    }
    for (;;)
    {
      if (i < 0)
      {
        ram.e("Q.qqstory.record.EditVideoFragment", "can't find new fragment data to update.");
        return;
        i += 1;
        break label40;
      }
      do
      {
        j += 1;
        if (j >= this.oB.size()) {
          break;
        }
      } while (((aygg.c)this.oB.get(j)).bqJ != this.bqa);
      ram.d("Q.qqstory.record.EditVideoFragment", "update the %d fragment's thumb.", Integer.valueOf(j));
      this.jdField_a_of_type_Aygg$b.a((ayjg)paramList.get(i), (aygg.c)this.oB.get(j));
      return;
      i = 0;
      while (i < paramList.size())
      {
        j = 0;
        if (j < this.oB.size())
        {
          if ((paramList.get(i) == null) || (this.oB.get(j) == null)) {
            ram.d("Q.qqstory.record.EditVideoFragment", "updateValidFragmentThumb error. fragmentInfos.get(%d) == null or mValidFragmentInfo.get(%d) == null.", Integer.valueOf(i), Integer.valueOf(j));
          }
          while (((ayjg)paramList.get(i)).bqJ != ((aygg.c)this.oB.get(j)).bqJ)
          {
            j += 1;
            break;
          }
          ram.d("Q.qqstory.record.EditVideoFragment", "updateValidFragmentThumb. update mValidFragmentInfo.get(%d)", Integer.valueOf(j));
          this.jdField_a_of_type_Aygg$b.a((ayjg)paramList.get(i), (aygg.c)this.oB.get(j));
        }
        i += 1;
      }
      break;
      label338:
      i = -1;
    }
  }
  
  private void eN(List<? extends ayjg> paramList)
  {
    int i;
    int j;
    if (paramList == null)
    {
      i = 0;
      j = this.b.a.ti();
      ram.d("Q.qqstory.record.EditVideoFragment", "initValidFragmentInfo.fragmentCount=%d. expectFragmentCount = %d. ", Integer.valueOf(i), Integer.valueOf(j));
      if (i <= j) {
        break label428;
      }
      i = j;
    }
    label428:
    for (;;)
    {
      if ((i < 1) || (i > 6))
      {
        throw new IllegalStateException("initValidFragmentInfo error. fragments's count is illegal.");
        i = paramList.size();
        break;
      }
      this.oB.clear();
      if (i == 1)
      {
        this.oB.add(new aygg.c((ayjg)paramList.get(0), null, null));
        return;
      }
      if (this.b.a.Ld()) {}
      int k;
      int m;
      qwh localqwh;
      ayjg localayjg;
      for (Object localObject = "0";; localObject = "1")
      {
        rar.a("video_edit", "edit_over", 0, 0, new String[] { String.valueOf(i), localObject });
        if ((this.b.a.Ld()) && ((this.b.a.a instanceof EditLocalVideoSource)))
        {
          localObject = (EditLocalVideoSource)this.b.a.a;
          rar.a("video_edit", "edit_spilt", 0, 0, new String[] { String.valueOf(Math.ceil((((EditLocalVideoSource)localObject).endTime - ((EditLocalVideoSource)localObject).startTime) / 1000.0F)) });
        }
        j = wja.dp2px(15.0F, getResources());
        k = wja.dp2px(12.0F, getResources());
        m = wja.dp2px(2.0F, getResources());
        k = (azbx.SCREEN_WIDTH - j * 2 - k * 5) / 6 - m * 2;
        m = k * 8 / 5;
        localqwh = new qwh(wja.dp2px(3.0F, getResources()), 0, m * 1.0F / k, null, null);
        j = 0;
        while (j < i)
        {
          localayjg = (ayjg)paramList.get(j);
          if (localayjg != null) {
            break label368;
          }
          j += 1;
        }
        break;
      }
      label368:
      localObject = rop.b(localayjg.cE, k, m, false);
      if (localObject != null) {}
      for (localObject = localqwh.z((Bitmap)localObject);; localObject = null)
      {
        this.oB.add(new aygg.c(localayjg, (Bitmap)localObject, null));
        break;
      }
    }
  }
  
  private void eO(List<aygg.c> paramList)
  {
    int j = 0;
    if (paramList == null) {}
    for (int i = 0; (i < 2) || (i > 6); i = paramList.size())
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "initViewStub error. fragmentCount=%d.", new Object[] { Integer.valueOf(i) });
      return;
    }
    if (!this.aY.compareAndSet(false, true))
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "initViewStub error. hasInitViewStub=%s.", new Object[] { Boolean.valueOf(this.aY.get()) });
      return;
    }
    ram.d("Q.qqstory.record.EditVideoFragment", "initViewStub. fragmentCount = %d.", Integer.valueOf(i));
    if (this.fS == null)
    {
      this.y = ((ViewStub)y(2131367568));
      this.fS = ((RelativeLayout)this.y.inflate());
    }
    this.fT = ((RelativeLayout)this.fS.findViewById(2131377609));
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleUiWidgetElasticImageView = ((ElasticImageView)this.fS.findViewById(2131369885));
    this.f = new RelativeLayout[6];
    i = 0;
    while (i < this.f.length)
    {
      this.f[i] = ((RelativeLayout)y(ea[i]));
      i += 1;
    }
    this.l = new ImageView[6];
    i = j;
    while (i < this.l.length)
    {
      this.l[i] = ((ImageView)y(dZ[i]));
      i += 1;
    }
    eP(paramList);
    eQ(paramList);
  }
  
  private void eP(List<aygg.c> paramList)
  {
    if (paramList == null) {}
    for (int i = 0; (i < 2) || (i > 6); i = paramList.size())
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "initFragmentButton error. fragmentCount is invalid.");
      return;
    }
    int k = wja.dp2px(15.0F, getResources());
    int m = wja.dp2px(12.0F, getResources());
    int j = wja.dp2px(2.0F, getResources());
    int n = (azbx.SCREEN_WIDTH - k * 2 - m * 5) / 6;
    int i1 = (n - j * 2) * 8 / 5 + j * 2;
    int i2 = wja.dp2px(102.0F, getResources());
    j = 0;
    while (j < this.f.length)
    {
      paramList = (RelativeLayout.LayoutParams)this.f[j].getLayoutParams();
      paramList.width = n;
      paramList.height = i1;
      paramList.bottomMargin = i2;
      paramList.leftMargin = k;
      this.f[j].setLayoutParams(paramList);
      k += n + m;
      j += 1;
    }
    ram.b("Q.qqstory.record.EditVideoFragment", "initFragmentButton. fragmentCount = %d, fragmentWidth = %d, fragmentHeight = %d.", Integer.valueOf(i), Integer.valueOf(n), Integer.valueOf(i1));
  }
  
  private void eQ(List<aygg.c> paramList)
  {
    int j = 0;
    if (!this.aY.get()) {
      ram.e("Q.qqstory.record.EditVideoFragment", "setFragmentListener error. hasInitViewStub = %s.", new Object[] { Boolean.valueOf(this.aY.get()) });
    }
    for (;;)
    {
      return;
      if (paramList == null) {}
      for (int i = 0; (i < 2) || (i > 6); i = paramList.size())
      {
        ram.e("Q.qqstory.record.EditVideoFragment", "setFragmentListener error. fragmentCount is invalid.");
        return;
      }
      ram.d("Q.qqstory.record.EditVideoFragment", "setFragmentListener. fragmentCount = %d.", Integer.valueOf(i));
      i = j;
      while (i < paramList.size())
      {
        this.f[i].setOnTouchListener(new aygg.a(i));
        i += 1;
      }
    }
  }
  
  private void eR(List<aygg.c> paramList)
  {
    if (!this.aY.get())
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "updateFragmentVisibility error. hasInitViewStub = %s.", new Object[] { Boolean.valueOf(this.aY.get()) });
      return;
    }
    if (paramList == null) {}
    for (int i = 0;; i = paramList.size())
    {
      ram.d("Q.qqstory.record.EditVideoFragment", "updateFragmentVisibility. list.size() = %d.", Integer.valueOf(i));
      if (paramList != null) {
        break;
      }
      this.fS.setVisibility(8);
      return;
    }
    if (paramList.size() <= 1)
    {
      this.f[0].setVisibility(8);
      this.f[1].setVisibility(8);
      this.fS.setVisibility(8);
      return;
    }
    this.fS.setVisibility(0);
    i = 0;
    label130:
    if (i < this.f.length)
    {
      if (i >= paramList.size()) {
        break label217;
      }
      this.l[i].setBackgroundDrawable(new BitmapDrawable(((aygg.c)paramList.get(i)).cB));
      this.l[i].setImageBitmap(((aygg.c)paramList.get(i)).cA);
      this.f[i].setVisibility(0);
    }
    for (;;)
    {
      i += 1;
      break label130;
      break;
      label217:
      this.l[i].setBackgroundColor(0);
      this.l[i].setImageBitmap(null);
      this.f[i].setVisibility(8);
      this.f[i].setOnTouchListener(null);
    }
  }
  
  private void wV(int paramInt)
  {
    if (this.jdField_a_of_type_Aygg$b == null) {
      this.jdField_a_of_type_Aygg$b = new aygg.b();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.oB.size())
      {
        if (paramInt == ((aygg.c)this.oB.get(i)).bqJ)
        {
          ram.d("Q.qqstory.record.EditVideoFragment", "updateValidFragmentDoodleByBlockIndex. update mValidFragmentInfo.get(%d)", Integer.valueOf(i));
          ((aygg.c)this.oB.get(i)).cA = this.jdField_a_of_type_Aygg$b.g(paramInt);
        }
      }
      else {
        return;
      }
      i += 1;
    }
  }
  
  protected void ab(int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 >= this.oB.size()) || (paramInt1 < 0))
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "deleteFragment error. cardIndex=%d.", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    Object localObject = (RelativeLayout.LayoutParams)this.f[paramInt1].getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).bottomMargin = paramInt3;
    ((RelativeLayout.LayoutParams)localObject).leftMargin = paramInt2;
    this.f[paramInt1].setLayoutParams((ViewGroup.LayoutParams)localObject);
    localObject = (ayjg)this.oB.get(paramInt1);
    if (localObject == null)
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "deleteFragment error. VideoFragmentInfo = null.");
      return;
    }
    paramInt2 = ((ayjg)localObject).bqJ;
    this.oB.remove(paramInt1);
    eR(this.oB);
    ram.d("Q.qqstory.record.EditVideoFragment", "send message. deleted card index = %d. deleted fragment index = %d.", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
    this.b.a(Message.obtain(null, 7, paramInt2, 0));
    aygz localaygz = this.b;
    if (this.b.a.Ld()) {}
    for (localObject = "0";; localObject = "1")
    {
      localaygz.d("clk_del", 0, 0, new String[] { "", localObject });
      return;
    }
  }
  
  public void ar(int paramInt, boolean paramBoolean)
  {
    if (this.oB.size() > 6)
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "setOthersVisibility error. mValidFragmentInfo's size is out of bound!");
      return;
    }
    int i = 0;
    label25:
    RelativeLayout localRelativeLayout;
    if (i < this.oB.size()) {
      if (i != paramInt)
      {
        localRelativeLayout = this.f[i];
        if (!paramBoolean) {
          break label72;
        }
      }
    }
    label72:
    for (int j = 0;; j = 4)
    {
      localRelativeLayout.setVisibility(j);
      i += 1;
      break label25;
      break;
    }
  }
  
  public List<? extends ayjg> cb()
  {
    return this.oB;
  }
  
  public void d(int paramInt1, int paramInt2, Object paramObject)
  {
    switch (paramInt2)
    {
    case 5: 
    case 11: 
    case 18: 
    case 19: 
    case 20: 
    case 21: 
    case 22: 
    case 23: 
    case 25: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 35: 
    case 36: 
    default: 
    case 0: 
    case 10: 
    case 13: 
    case 14: 
    case 15: 
    case 16: 
    case 17: 
    case 24: 
    case 1: 
    case 2: 
    case 3: 
    case 4: 
    case 6: 
    case 9: 
    case 12: 
    case 34: 
    case 37: 
      do
      {
        do
        {
          return;
        } while (this.fS == null);
        this.fS.setVisibility(0);
        return;
      } while (this.fS == null);
      this.fS.setVisibility(4);
      return;
    case 7: 
      if (paramInt1 == 8)
      {
        if ((paramObject != null) && ((paramObject instanceof Boolean)))
        {
          o(true, true, ((Boolean)paramObject).booleanValue());
          return;
        }
        o(true, true, true);
        return;
      }
      o(true, false, true);
      return;
    }
    if ((paramObject != null) && ((paramObject instanceof Boolean)))
    {
      o(false, ((Boolean)paramObject).booleanValue(), true);
      return;
    }
    o(false, true, true);
  }
  
  public void dP(View paramView)
  {
    ram.i("Q.qqstory.record.EditVideoFragment", "startClickAnimation.");
    ScaleAnimation localScaleAnimation1 = new ScaleAnimation(1.0F, 0.85F, 1.0F, 0.85F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation1.setDuration(100L);
    ScaleAnimation localScaleAnimation2 = new ScaleAnimation(1.0F, 1.176471F, 1.0F, 1.176471F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation2.setStartOffset(100L);
    localScaleAnimation2.setDuration(100L);
    AnimationSet localAnimationSet = new AnimationSet(true);
    localAnimationSet.setInterpolator(new LinearInterpolator());
    localAnimationSet.addAnimation(localScaleAnimation1);
    localAnimationSet.addAnimation(localScaleAnimation2);
    localAnimationSet.setFillAfter(false);
    paramView.startAnimation(localAnimationSet);
  }
  
  public void dQ(View paramView)
  {
    ram.i("Q.qqstory.record.EditVideoFragment", "startDargAnimator.");
    paramView.clearAnimation();
    ScaleAnimation localScaleAnimation = new ScaleAnimation(1.0F, 1.2F, 1.0F, 1.2F, 1, 0.5F, 1, 0.5F);
    localScaleAnimation.setDuration(100L);
    localScaleAnimation.setInterpolator(new LinearInterpolator());
    localScaleAnimation.setFillAfter(true);
    paramView.startAnimation(localScaleAnimation);
  }
  
  protected boolean e(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    case 9: 
    case 10: 
    default: 
      return super.e(paramMessage);
    case 8: 
      ram.i("Q.qqstory.record.EditVideoFragment", "receive message.");
      paramMessage = (ayhm)a(ayhm.class);
      if (paramMessage == null) {
        break;
      }
    }
    for (paramMessage = paramMessage.ca();; paramMessage = null)
    {
      if (!this.aY.get())
      {
        eN(paramMessage);
        eO(this.oB);
        eR(this.oB);
        wW(0);
        return true;
      }
      if (!this.b.a.Ld()) {}
      for (boolean bool = true;; bool = false)
      {
        T(paramMessage, bool);
        eR(this.oB);
        return true;
      }
      this.BK = ((Long)paramMessage.obj).longValue();
      return true;
    }
  }
  
  @TargetApi(11)
  public void g(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    ram.b("Q.qqstory.record.EditVideoFragment", "startResetAnimaton. sMarginLeft=%d, sMarginBottom=%d, dMarginLeft=%d, dMarginBottom=%d.", Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(paramInt3), Integer.valueOf(paramInt4));
    ValueAnimator localValueAnimator = ValueAnimator.ofFloat(new float[] { 0.0F, 1.0F });
    localValueAnimator.setDuration(200L);
    localValueAnimator.setInterpolator(new DecelerateInterpolator());
    localValueAnimator.addListener(new aygh(this, paramView));
    localValueAnimator.addUpdateListener(new aygi(this, paramInt3, paramInt1, paramInt4, paramInt2, paramView));
    localValueAnimator.start();
  }
  
  public void o(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (this.fS != null)
    {
      if (!paramBoolean2) {
        break label33;
      }
      if (paramBoolean1) {
        ayjd.t(this.fS, paramBoolean3);
      }
    }
    else
    {
      return;
    }
    ayjd.s(this.fS, paramBoolean3);
    return;
    label33:
    this.fS.setAnimation(null);
    RelativeLayout localRelativeLayout = this.fS;
    if (paramBoolean1) {}
    for (int i = 0;; i = 8)
    {
      localRelativeLayout.setVisibility(i);
      return;
    }
  }
  
  public void onCreate()
  {
    super.onCreate();
  }
  
  public int tf()
  {
    return this.bpZ;
  }
  
  protected void wW(int paramInt)
  {
    if (!this.aY.get())
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. hasInitViewStub = %s.", new Object[] { Boolean.valueOf(this.aY.get()) });
      return;
    }
    if ((paramInt < 0) || (paramInt >= this.oB.size()))
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. invalid index.");
      return;
    }
    if (this.oB.get(paramInt) == null)
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. fragmentInfo is null!");
      return;
    }
    if ((this.bpZ == ((aygg.c)this.oB.get(paramInt)).bqJ) && (!this.aGS))
    {
      ram.e("Q.qqstory.record.EditVideoFragment", "selectFragment error. the same index!");
      return;
    }
    int i = 0;
    if (i < this.f.length)
    {
      if (i == paramInt) {
        this.f[i].setBackgroundResource(2130847743);
      }
      for (;;)
      {
        i += 1;
        break;
        this.f[i].setBackgroundResource(0);
      }
    }
    this.bqa = this.bpZ;
    this.bpZ = ((aygg.c)this.oB.get(paramInt)).bqJ;
    if (!this.aGS)
    {
      ram.b("Q.qqstory.record.EditVideoFragment", "send message. selected card index = %d. selected fragment index change form %d to %d.", Integer.valueOf(paramInt), Integer.valueOf(this.bqa), Integer.valueOf(this.bpZ));
      this.b.a(Message.obtain(null, 6, this.bqa, this.bpZ));
      wV(this.bqa);
      eR(this.oB);
    }
    this.aGS = false;
  }
  
  protected void wX(int paramInt)
  {
    int i = paramInt;
    if (paramInt >= this.oB.size()) {
      i = 0;
    }
    ram.d("Q.qqstory.record.EditVideoFragment", "selectNextFragment. nextCardIndex = %d.", Integer.valueOf(i));
    wW(i);
  }
  
  class a
    implements View.OnTouchListener
  {
    private final int PADDING = wja.dp2px(40.0F, aygg.this.getResources());
    private Rect aE;
    private boolean aGT;
    private boolean aGU;
    private boolean aGV;
    private int beW;
    private final int bqf = 5;
    private int bqg;
    private int bqh;
    private int bqi;
    private int bqj;
    private int bqk;
    private int mMarginLeft;
    private int mOffsetX;
    private int mOffsetY;
    private int mPointerId;
    private int mStartX = -1;
    private int mStartY = -1;
    
    public a(int paramInt)
    {
      this.bqg = paramInt;
      this.aE = new Rect();
    }
    
    public boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      int i = (int)paramMotionEvent.getRawX();
      int j = (int)paramMotionEvent.getRawY();
      switch (paramMotionEvent.getAction())
      {
      }
      do
      {
        do
        {
          for (;;)
          {
            return true;
            if ((paramView.getTag() != null) && (((Boolean)paramView.getTag()).booleanValue()))
            {
              ram.d("Q.qqstory.record.EditVideoFragment", "discard event. action down while doing reset animation.");
              return false;
            }
            if (aygg.this.BK > System.currentTimeMillis()) {
              return false;
            }
            this.mStartX = i;
            this.mStartY = j;
            this.bqh = paramView.getLeft();
            this.beW = (azbx.aC(aygg.this.getContext()) - paramView.getBottom());
            this.bqj = 0;
            this.bqk = 0;
            this.mPointerId = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            this.aGT = false;
            this.aGV = false;
            aygg.this.dP(paramView);
            aygg.this.wW(this.bqg);
            continue;
            int k = paramMotionEvent.getPointerId(paramMotionEvent.getActionIndex());
            if (k == this.mPointerId) {
              break;
            }
            this.mStartX = i;
            this.mStartY = j;
            this.bqj = (paramView.getLeft() - this.bqh);
            this.bqk = (azbx.aC(aygg.this.getContext()) - paramView.getBottom() - this.beW);
            this.mPointerId = k;
          }
          this.mOffsetX = (i - this.mStartX);
          this.mOffsetY = (this.mStartY - j);
        } while ((Math.abs(this.mOffsetX) <= 5) && (Math.abs(this.mOffsetY) <= 5));
        this.aGT = true;
        if (!this.aGV)
        {
          this.aGV = true;
          aygg.this.dQ(paramView);
        }
        aygg.this.ar(this.bqg, false);
        this.mMarginLeft = (this.bqh + this.bqj + this.mOffsetX);
        this.bqi = (this.beW + this.bqk + this.mOffsetY);
        if (this.mMarginLeft < 0) {
          this.mMarginLeft = 0;
        }
        if (this.mMarginLeft + paramView.getWidth() > azbx.SCREEN_WIDTH) {
          this.mMarginLeft = (azbx.SCREEN_WIDTH - paramView.getWidth());
        }
        if (this.bqi < 0) {
          this.bqi = 0;
        }
        if (this.bqi + paramView.getHeight() > azbx.aC(aygg.this.getContext())) {
          this.bqi = (azbx.aC(aygg.this.getContext()) - paramView.getHeight());
        }
        paramMotionEvent = (RelativeLayout.LayoutParams)paramView.getLayoutParams();
        paramMotionEvent.leftMargin = this.mMarginLeft;
        paramMotionEvent.bottomMargin = this.bqi;
        paramView.setLayoutParams(paramMotionEvent);
        paramView.invalidate();
        aygg.this.fT.setVisibility(0);
        aygg.this.a.getGlobalVisibleRect(this.aE);
        paramView = this.aE;
        paramView.left -= this.PADDING;
        paramView = this.aE;
        paramView.top -= this.PADDING;
        paramView = this.aE;
        paramView.right += this.PADDING;
        paramView = this.aE;
        paramView.bottom += this.PADDING;
        if (this.aE.contains(i, j))
        {
          this.aGU = true;
          aygg.this.a.ag(1.5F);
          aygg.this.a.getDrawable().setColorFilter(Color.parseColor("#F31919"), PorterDuff.Mode.MULTIPLY);
        }
        for (;;)
        {
          aygg.this.b.changeState(23);
          break;
          if (this.aGU)
          {
            this.aGU = false;
            aygg.this.a.ag(1.0F);
            aygg.this.a.getDrawable().clearColorFilter();
          }
        }
      } while (!this.aGT);
      paramView.clearAnimation();
      if ((this.aE != null) && (this.aE.contains(i, j)))
      {
        ram.i("Q.qqstory.record.EditVideoFragment", "remove fragment.");
        aygg.this.a.ag(1.0F);
        aygg.this.a.getDrawable().clearColorFilter();
        aygg.this.ab(this.bqg, this.bqh, this.beW);
        aygg.this.wX(this.bqg);
      }
      for (;;)
      {
        aygg.this.fT.setVisibility(4);
        aygg.this.b.changeState(0);
        break;
        aygg.this.g(paramView, paramView.getLeft(), azbx.aC(aygg.this.getContext()) - paramView.getBottom(), this.bqh, this.beW);
        aygg.this.ar(this.bqg, true);
      }
    }
  }
  
  class b
  {
    int AD = wja.dp2px(15.0F, aygg.this.getResources());
    aydg jdField_a_of_type_Aydg = (aydg)aygg.this.a(aydg.class);
    aydh jdField_a_of_type_Aydh = (aydh)aygg.this.a(aydh.class);
    qwh b = new qwh(wja.dp2px(3.0F, aygg.this.getResources()), 0, this.thumbHeight * 1.0F / this.thumbWidth, null, null);
    int bql = (azbx.SCREEN_WIDTH - this.AD * 2 - this.gap * 5) / 6;
    int gap = wja.dp2px(12.0F, aygg.this.getResources());
    int padding = wja.dp2px(2.0F, aygg.this.getResources());
    int thumbHeight = this.thumbWidth * 8 / 5;
    int thumbWidth = this.bql - this.padding * 2;
    
    public b() {}
    
    public void a(ayjg paramayjg, aygg.c paramc)
    {
      Bitmap localBitmap = rop.b(paramayjg.cE, this.thumbWidth, this.thumbHeight, false);
      paramayjg = null;
      if (localBitmap != null) {
        paramayjg = this.b.z(localBitmap);
      }
      paramc.cB = paramayjg;
    }
    
    public Bitmap g(int paramInt)
    {
      Object localObject2 = null;
      Object localObject1 = localObject2;
      if (this.jdField_a_of_type_Aydg != null) {
        if (this.jdField_a_of_type_Aydg.y(paramInt))
        {
          localObject1 = localObject2;
          if (this.jdField_a_of_type_Aydh != null)
          {
            localObject1 = localObject2;
            if (!this.jdField_a_of_type_Aydh.eL(paramInt)) {}
          }
        }
        else
        {
          Bitmap localBitmap1 = this.jdField_a_of_type_Aydg.a(paramInt, false);
          localObject1 = localObject2;
          if (localBitmap1 != null)
          {
            if (this.jdField_a_of_type_Aydh != null) {
              this.jdField_a_of_type_Aydh.a(paramInt, new Canvas(localBitmap1), localBitmap1.getWidth(), localBitmap1.getHeight());
            }
            Bitmap localBitmap2 = rop.b(localBitmap1, this.thumbWidth, this.thumbHeight, false);
            this.jdField_a_of_type_Aydg.s(localBitmap1);
            localObject1 = localObject2;
            if (localBitmap2 != null) {
              localObject1 = this.b.z(localBitmap2);
            }
          }
        }
      }
      return localObject1;
    }
  }
  
  static class c
    extends ayjg
  {
    public Bitmap cA;
    public Bitmap cB;
    
    public c(int paramInt, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
    {
      super(paramBitmap1);
      this.cB = paramBitmap2;
      this.cA = paramBitmap3;
    }
    
    public c(ayjg paramayjg, Bitmap paramBitmap1, Bitmap paramBitmap2)
    {
      this(paramayjg.bqJ, paramayjg.cE, paramBitmap1, paramBitmap2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aygg
 * JD-Core Version:    0.7.0.1
 */