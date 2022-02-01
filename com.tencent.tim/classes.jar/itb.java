import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.opengl.ui.GLRootView;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.AVRedPacketManager.LocalEmojiInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalFrameSyncInfo;
import com.tencent.av.redpacket.AVRedPacketManager.LocalHitInfo;
import com.tencent.av.redpacket.ui.RedPacketGameScore.1;
import com.tencent.av.redpacket.ui.RedPacketGameView;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.VideoLayerUI;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;
import java.util.List;

public class itb
  implements View.OnClickListener
{
  public static final float[] ad = { 0.0F, 0.0F, 7.0F, -7.0F, 0.0F, -4.0F, 7.0F, 3.0F };
  public boolean UJ = true;
  public int ZY;
  public RedPacketGameView a;
  public isx a;
  public isx[] a;
  public float[] ae = new float[8];
  public int atA;
  public int atB;
  public int atu;
  public int atv;
  public int atw;
  public int atx;
  public int aty;
  public int atz;
  public isx b = new isx();
  public Bitmap bi;
  public Bitmap bj;
  public Bitmap bk;
  public Runnable bw = new RedPacketGameScore.1(this);
  private WeakReference<AVActivity> bx;
  public isx c;
  public itc[] c;
  public float hy;
  public float hz;
  public int mHeight;
  public boolean mIsSend;
  public int mMaxProgress = 10;
  public int mScore;
  public int mWidth;
  public long mZ;
  public Path n = new Path();
  public long na;
  
  public itb(RedPacketGameView paramRedPacketGameView, AVActivity paramAVActivity)
  {
    this.jdField_a_of_type_ArrayOfIsx = new isx[4];
    this.jdField_a_of_type_Isx = new isx();
    this.jdField_c_of_type_Isx = new isx();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView = paramRedPacketGameView;
    this.bx = new WeakReference(paramAVActivity);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIsx.length)
    {
      this.jdField_a_of_type_ArrayOfIsx[i] = new isx();
      this.jdField_a_of_type_ArrayOfIsx[i].LEFT = (i * 37 + 30);
      this.jdField_a_of_type_ArrayOfIsx[i].TOP = 30;
      this.jdField_a_of_type_ArrayOfIsx[i].WIDTH = 37;
      this.jdField_a_of_type_ArrayOfIsx[i].HEIGHT = 46;
      this.jdField_a_of_type_ArrayOfIsx[i].setAlpha(255);
      i += 1;
    }
    this.jdField_a_of_type_Isx.TOP = 36;
    this.jdField_a_of_type_Isx.WIDTH = 200;
    this.jdField_a_of_type_Isx.HEIGHT = 28;
    this.jdField_a_of_type_Isx.setAlpha(255);
    this.b.TOP = 36;
    this.b.WIDTH = 200;
    this.b.HEIGHT = 28;
    this.b.setAlpha(255);
    this.jdField_c_of_type_Isx.TOP = 36;
    this.jdField_c_of_type_Isx.WIDTH = 200;
    this.jdField_c_of_type_Isx.HEIGHT = 28;
    this.jdField_c_of_type_Isx.setAlpha(255);
    paramRedPacketGameView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.getContext();
    paramAVActivity = new View(paramRedPacketGameView);
    paramAVActivity.setId(2131374183);
    paramAVActivity.setOnClickListener(this);
    paramAVActivity.setVisibility(8);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.addView(paramAVActivity, localLayoutParams);
    paramRedPacketGameView = new View(paramRedPacketGameView);
    paramRedPacketGameView.setId(2131374184);
    paramRedPacketGameView.setOnClickListener(this);
    paramRedPacketGameView.setVisibility(8);
    paramAVActivity = new RelativeLayout.LayoutParams(-2, -2);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.addView(paramRedPacketGameView, paramAVActivity);
  }
  
  private void aqo()
  {
    aqq();
  }
  
  private void aqq()
  {
    View localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374183);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = ((int)(this.aty + this.ZY + this.hz));
    localLayoutParams.leftMargin = ((int)(this.atz + this.hy));
    localView.setLayoutParams(localLayoutParams);
    localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374184);
    localLayoutParams = (RelativeLayout.LayoutParams)localView.getLayoutParams();
    localLayoutParams.topMargin = ((int)(this.atA + this.ZY + this.hz));
    localLayoutParams.leftMargin = ((int)(this.atB + this.hy));
    localView.setLayoutParams(localLayoutParams);
  }
  
  private void aqr()
  {
    int i;
    if (this.mIsSend)
    {
      i = 520;
      if (!this.mIsSend) {
        break label106;
      }
    }
    label106:
    for (int j = 348;; j = 276)
    {
      this.jdField_a_of_type_Isx.LEFT = i;
      this.b.LEFT = i;
      this.jdField_c_of_type_Isx.LEFT = i;
      this.jdField_a_of_type_Isx.onSizeChanged(this.mWidth, this.mHeight, 0, 0);
      this.b.onSizeChanged(this.mWidth, this.mHeight, 0, 0);
      this.atv = (this.mWidth * j / 750);
      aqn();
      return;
      i = 448;
      break;
    }
  }
  
  public void a(boolean paramBoolean, AVRedPacketManager paramAVRedPacketManager)
  {
    this.mIsSend = paramBoolean;
    View localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374183);
    if (!paramBoolean)
    {
      this.bi = paramAVRedPacketManager.o("qav_redpacket_close.png");
      this.bj = paramAVRedPacketManager.o("qav_redpacket_close_normal.png");
      this.bk = paramAVRedPacketManager.o("qav_redpacket_close_pressed.png");
      paramAVRedPacketManager = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.getResources();
      if (this.bi != null) {
        localView.setBackgroundDrawable(jlg.a(paramAVRedPacketManager, this.bi, 2131166288));
      }
      if ((this.bj != null) && (this.bk != null))
      {
        localView = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374184);
        StateListDrawable localStateListDrawable = new StateListDrawable();
        BitmapDrawable localBitmapDrawable = new BitmapDrawable(paramAVRedPacketManager, this.bk);
        localStateListDrawable.addState(new int[] { 16842919 }, localBitmapDrawable);
        paramAVRedPacketManager = new BitmapDrawable(paramAVRedPacketManager, this.bj);
        localStateListDrawable.addState(new int[] { -16842919 }, paramAVRedPacketManager);
        localView.setBackgroundDrawable(new ClipDrawable(localStateListDrawable, 5, 1));
      }
    }
    aqr();
  }
  
  public void aqn()
  {
    Object localObject = this.jdField_a_of_type_Isx.getBounds();
    int j = this.atw * this.atu / this.mMaxProgress + this.atv;
    int i = ((Rect)localObject).width() + j;
    this.jdField_c_of_type_Isx.setBounds(j, ((Rect)localObject).top, i, ((Rect)localObject).bottom);
    this.n.reset();
    j = ((Rect)localObject).height() / 2 - this.atx;
    localObject = new RectF(((Rect)localObject).left + j, ((Rect)localObject).top + j, i - j, ((Rect)localObject).bottom - j);
    this.n.addRoundRect((RectF)localObject, this.atx, this.atx, Path.Direction.CCW);
  }
  
  public void aqp()
  {
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374183).getLayoutParams();
    localLayoutParams.width = (this.mWidth * 52 / 750);
    localLayoutParams.height = (this.mWidth * 52 / 750);
    localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374184).getLayoutParams();
    localLayoutParams.width = (this.mWidth * 252 / 750);
    localLayoutParams.height = (this.mWidth * 72 / 750);
    aqq();
  }
  
  public void c(AVRedPacketManager paramAVRedPacketManager, itc[] paramArrayOfitc)
  {
    this.jdField_a_of_type_Isx.b = new itc(paramAVRedPacketManager.o("qav_redpacket_progressbar_bg.png"));
    this.b.b = new itc(paramAVRedPacketManager.o("qav_redpacket_progressbar_red.png"));
    this.jdField_c_of_type_Isx.b = new itc(paramAVRedPacketManager.o("qav_redpacket_progressbar_yellow.png"));
    this.jdField_c_of_type_ArrayOfItc = paramArrayOfitc;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIsx.length)
    {
      this.jdField_a_of_type_ArrayOfIsx[i].b = this.jdField_c_of_type_ArrayOfItc[0];
      i += 1;
    }
  }
  
  public void c(boolean paramBoolean, AVRedPacketManager.LocalFrameSyncInfo paramLocalFrameSyncInfo)
  {
    setScore(paramLocalFrameSyncInfo.curScore);
    if ((paramLocalFrameSyncInfo.localEmojiInfos.size() > 0) && (paramBoolean)) {
      setProgress(((AVRedPacketManager.LocalEmojiInfo)paramLocalFrameSyncInfo.localEmojiInfos.get(0)).emojiId + 1);
    }
    for (;;)
    {
      if (paramLocalFrameSyncInfo.localHitInfo.topWordTipType != 3) {
        this.mZ = paramLocalFrameSyncInfo.localHitInfo.hitStartTime;
      }
      return;
      if (!paramBoolean) {
        setProgress(paramLocalFrameSyncInfo.localHitInfo.emojiId + 1);
      }
    }
  }
  
  public void draw(Canvas paramCanvas, Paint paramPaint)
  {
    paramCanvas.save();
    paramCanvas.translate(this.hy, this.hz + this.ZY);
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIsx.length)
    {
      this.jdField_a_of_type_ArrayOfIsx[i].draw(paramCanvas, paramPaint);
      i += 1;
    }
    this.jdField_a_of_type_Isx.draw(paramCanvas, paramPaint);
    paramCanvas.save();
    paramCanvas.clipPath(this.n);
    this.b.draw(paramCanvas, paramPaint);
    this.jdField_c_of_type_Isx.draw(paramCanvas, paramPaint);
    paramCanvas.restore();
    paramCanvas.restore();
  }
  
  public void lH(int paramInt)
  {
    if (paramInt > 0)
    {
      this.mMaxProgress = paramInt;
      aqn();
    }
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.na = System.currentTimeMillis();
      this.UJ = false;
      this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.postDelayed(this.bw, 5000L);
      jij.awR();
      continue;
      ((AVRedPacketManager)((VideoAppInterface)BaseApplicationImpl.getApplication().getRuntime()).a(6)).aqb();
      jij.awS();
    }
  }
  
  public void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    int j = 0;
    int i = 0;
    while (i < this.jdField_a_of_type_ArrayOfIsx.length)
    {
      this.jdField_a_of_type_ArrayOfIsx[i].onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      i += 1;
    }
    this.mWidth = paramInt1;
    this.mHeight = paramInt2;
    this.atw = (paramInt1 * 172 / 750);
    this.atx = (paramInt1 * 10 / 750);
    aqr();
    paramInt2 = j;
    while (paramInt2 < ad.length)
    {
      this.ae[paramInt2] = (ad[paramInt2] * paramInt1 / 750.0F);
      paramInt2 += 1;
    }
    this.aty = (paramInt1 * 24 / 750);
    this.atz = (paramInt1 * 668 / 750);
    this.atA = (paramInt1 * 24 / 750);
    this.atB = (paramInt1 * 468 / 750);
    aqp();
  }
  
  public void recycle()
  {
    this.jdField_a_of_type_Isx.recycle();
    this.b.recycle();
    this.jdField_c_of_type_Isx.recycle();
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.removeCallbacks(this.bw);
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.removeAllViews();
    Object localObject = (AVActivity)this.bx.get();
    if ((localObject != null) && (((AVActivity)localObject).b != null))
    {
      localObject = ((AVActivity)localObject).b.a();
      if (localObject != null)
      {
        ((GLRootView)localObject).setX(0.0F);
        ((GLRootView)localObject).setY(0.0F);
      }
    }
    this.jdField_c_of_type_ArrayOfItc = null;
    this.jdField_a_of_type_ArrayOfIsx = null;
    this.jdField_a_of_type_Isx = null;
    this.b = null;
    this.jdField_c_of_type_Isx = null;
    this.n = null;
    this.ae = null;
    this.bw = null;
    this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView = null;
    if (this.bi != null)
    {
      this.bi.recycle();
      this.bi = null;
    }
    if (this.bj != null)
    {
      this.bj.recycle();
      this.bj = null;
    }
    if (this.bk != null)
    {
      this.bk.recycle();
      this.bk = null;
    }
  }
  
  public void setMarginTop(int paramInt)
  {
    if (this.ZY != paramInt)
    {
      this.ZY = paramInt;
      aqo();
    }
  }
  
  public void setProgress(int paramInt)
  {
    if (this.atu != paramInt)
    {
      this.atu = paramInt;
      aqn();
    }
  }
  
  public void setScore(int paramInt)
  {
    if (this.mScore != paramInt)
    {
      this.mScore = paramInt;
      int i = 1000;
      int k = 0;
      int j = paramInt;
      paramInt = k;
      while (paramInt < this.jdField_a_of_type_ArrayOfIsx.length)
      {
        k = j / i;
        if (this.jdField_c_of_type_ArrayOfItc != null) {
          this.jdField_a_of_type_ArrayOfIsx[paramInt].b = this.jdField_c_of_type_ArrayOfItc[k];
        }
        j %= i;
        i /= 10;
        paramInt += 1;
      }
    }
  }
  
  public void update(long paramLong)
  {
    boolean bool2 = false;
    paramLong -= this.mZ;
    this.hy = 0.0F;
    this.hz = 0.0F;
    int i = 0;
    float f1;
    float f2;
    Object localObject;
    label313:
    label324:
    boolean bool3;
    label414:
    boolean bool1;
    label447:
    label491:
    int k;
    if (i < 8)
    {
      if ((paramLong >= i * 25) && (paramLong < (i + 1) * 25))
      {
        this.hy = ((this.ae[((i * 2 + 2) % 8)] - this.ae[(i * 2 % 8)]) * (float)paramLong / 25.0F + (this.ae[(i * 2 % 8)] * (i + 1) - this.ae[((i * 2 + 2) % 8)] * i));
        f1 = this.ae[((i * 2 + 3) % 8)];
        f2 = this.ae[((i * 2 + 1) % 8)];
        f1 = (float)paramLong * (f1 - f2) / 25.0F;
        f2 = this.ae[((i * 2 + 1) % 8)];
        float f3 = i + 1;
        float f4 = this.ae[((i * 2 + 3) % 8)];
        this.hz = (f2 * f3 - i * f4 + f1);
      }
    }
    else
    {
      localObject = (AVActivity)this.bx.get();
      if ((localObject != null) && (((AVActivity)localObject).b != null))
      {
        localObject = ((AVActivity)localObject).b.a();
        if (localObject != null)
        {
          ((GLRootView)localObject).setX(this.hy);
          ((GLRootView)localObject).setY(this.hz);
        }
      }
      if (!this.mIsSend)
      {
        aqq();
        paramLong = this.na;
        if (!this.UJ) {
          break label596;
        }
        f1 = 1.0F;
        if (Float.compare(f1, 0.0F) >= 0) {
          break label601;
        }
        f2 = 0.0F;
        i = (int)(255.0F * f2) & 0xFF;
        this.jdField_a_of_type_Isx.setAlpha(i);
        this.b.setAlpha(i);
        this.jdField_c_of_type_Isx.setAlpha(i);
        localObject = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374183);
        if (Float.compare(f2, ((View)localObject).getAlpha()) != 0) {
          ((View)localObject).setAlpha(f2);
        }
        j = ((View)localObject).getVisibility();
        if (Float.compare(f2, 0.0F) <= 0) {
          break label618;
        }
        i = 0;
        if (i != j) {
          ((View)localObject).setVisibility(i);
        }
        bool3 = ((View)localObject).isClickable();
        if (Float.compare(f2, 1.0F) < 0) {
          break label625;
        }
        bool1 = true;
        if (bool1 != bool3) {
          ((View)localObject).setClickable(bool1);
        }
        localObject = this.jdField_a_of_type_ComTencentAvRedpacketUiRedPacketGameView.findViewById(2131374184);
        j = (int)((1.0F - f2) * 10000.0F);
        if (j >= 0) {
          break label631;
        }
        i = 0;
        Drawable localDrawable = ((View)localObject).getBackground();
        if ((localDrawable != null) && (i != localDrawable.getLevel())) {
          localDrawable.setLevel(i);
        }
        k = ((View)localObject).getVisibility();
        if (i <= 0) {
          break label651;
        }
      }
    }
    label651:
    for (int j = 0;; j = 8)
    {
      if (j != k) {
        ((View)localObject).setVisibility(j);
      }
      bool3 = ((View)localObject).isClickable();
      bool1 = bool2;
      if (i >= 10000) {
        bool1 = true;
      }
      if (bool1 != bool3) {
        ((View)localObject).setClickable(bool1);
      }
      return;
      i += 1;
      break;
      label596:
      f1 = 0.0F;
      break label313;
      label601:
      f2 = f1;
      if (Float.compare(f1, 1.0F) <= 0) {
        break label324;
      }
      f2 = 1.0F;
      break label324;
      label618:
      i = 8;
      break label414;
      label625:
      bool1 = false;
      break label447;
      label631:
      i = j;
      if (j <= 10000) {
        break label491;
      }
      i = 10000;
      break label491;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     itb
 * JD-Core Version:    0.7.0.1
 */