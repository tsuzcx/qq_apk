import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.PopupWindow;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.RoundImageView;
import com.tencent.qphone.base.util.QLog;

public class aawb
  implements aawf
{
  private static final int Di = azbx.dip2px(4.0F);
  private static final int HEIGHT;
  private static final int QC = azbx.dip2px(172.0F);
  private static final int QD = azbx.dip2px(31.5F);
  private static final int WIDTH = QC + azbx.dip2px(16.0F);
  private static final int clZ;
  private static final int cma;
  private static final int cmb;
  private static final int cmc;
  private static final int cme;
  private static final int cmf;
  private int cmg = -1;
  private int cmh = -1;
  private int cmi = -1;
  private RoundImageView d;
  private Bitmap ez;
  private Canvas mCanvas;
  private boolean mIsShow;
  private PopupWindow mPopupWindow;
  private final Rect mSrcRect = new Rect();
  private long mTimeStamp;
  
  static
  {
    HEIGHT = QD + azbx.dip2px(14.0F);
    clZ = WIDTH / 2;
    cma = azbx.dip2px(65.0F);
    cmb = azbx.dip2px(10.0F);
    cmc = aqnm.dpToPx(30.0F);
    cme = aqnm.dpToPx(8.0F);
    cmf = aqnm.dpToPx(12.0F);
  }
  
  private void AW(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QMagnifier", 2, paramString + (System.currentTimeMillis() - this.mTimeStamp));
    }
    this.mTimeStamp = System.currentTimeMillis();
  }
  
  public static RectF a(View paramView)
  {
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    return new RectF(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
  }
  
  private int ap(int paramInt1, int paramInt2)
  {
    this.cmh = this.cmg;
    this.cmg = paramInt1;
    int i;
    if ((paramInt2 == 0) && (this.cmi != -1)) {
      if (this.cmi > paramInt1) {
        if (this.cmi - paramInt1 < cme) {
          i = this.cmi;
        }
      }
    }
    while (paramInt2 == 0)
    {
      return i - cmc;
      this.cmi = paramInt1;
      i = paramInt1;
      continue;
      i = paramInt1;
      if (this.cmi < paramInt1) {
        if (paramInt1 - this.cmi < cme)
        {
          i = this.cmi;
        }
        else
        {
          this.cmi = paramInt1;
          i = paramInt1;
          continue;
          this.cmi = paramInt1;
          i = paramInt1;
        }
      }
    }
    if (paramInt2 == 1) {
      return (int)(i - cmc * 1.5F);
    }
    return (int)(i - cmc * 0.5F);
  }
  
  private int fQ(int paramInt)
  {
    int j = 0;
    int i = j;
    if (this.cmg != -1)
    {
      i = j;
      if (this.cmh != -1)
      {
        if ((paramInt <= this.cmh + cmf) || (this.cmg <= this.cmh + cmf)) {
          break label53;
        }
        i = 2;
      }
    }
    label53:
    do
    {
      do
      {
        return i;
        i = j;
      } while (cmf + paramInt >= this.cmh);
      i = j;
    } while (this.cmg + cmf >= this.cmh);
    return 1;
  }
  
  private void u(View paramView, int paramInt1, int paramInt2)
  {
    this.mCanvas.setBitmap(this.ez);
    RectF localRectF = a(paramView);
    AW("start update ");
    f(paramInt1 - localRectF.left, paramInt2 - localRectF.top, 1.5F);
    this.mCanvas.drawColor(-1);
    this.mCanvas.scale(1.5F, 1.5F);
    this.mCanvas.translate(-this.mSrcRect.left, -this.mSrcRect.top);
    paramView.draw(this.mCanvas);
    AW("get Drawing cache ");
    this.mCanvas.setBitmap(null);
    this.d.setImageBitmap(this.ez);
  }
  
  public void a(@NonNull View paramView1, int paramInt1, int paramInt2, @NonNull View paramView2, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT < 23) {
      return;
    }
    if (this.mPopupWindow == null)
    {
      this.mTimeStamp = System.currentTimeMillis();
      this.mPopupWindow = new PopupWindow(BaseApplicationImpl.getContext());
      this.mPopupWindow.setClippingEnabled(false);
      AW("create popWindow ");
      paramView2 = ((LayoutInflater)paramView1.getContext().getSystemService("layout_inflater")).inflate(2131559462, null, false);
      this.d = ((RoundImageView)paramView2.findViewById(2131362465));
      this.d.setmRadius(Di, false);
      this.mPopupWindow.setContentView(paramView2);
      this.mPopupWindow.setWidth(WIDTH);
      this.mPopupWindow.setHeight(HEIGHT);
      this.mPopupWindow.setBackgroundDrawable(null);
      this.ez = Bitmap.createBitmap(QC, QD, Bitmap.Config.ARGB_8888);
      this.mCanvas = new Canvas();
      AW("create magnifier bitmap and canvas");
    }
    if ((paramBoolean) || (!this.mIsShow)) {
      u(paramView1, paramInt1, paramInt2);
    }
    paramInt2 = ap(paramInt2, fQ(paramInt2));
    if (this.mIsShow) {
      this.mPopupWindow.update(paramInt1 - clZ, paramInt2 - cma, WIDTH, HEIGHT);
    }
    for (;;)
    {
      this.mIsShow = true;
      return;
      this.mPopupWindow.showAtLocation(paramView1, 0, paramInt1 - clZ, paramInt2 - cma);
    }
  }
  
  public void dismiss()
  {
    this.mPopupWindow.dismiss();
    this.mIsShow = false;
    this.cmg = -1;
    this.cmh = -1;
    this.cmi = -1;
  }
  
  public void f(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    paramFloat2 -= cmb;
    this.mSrcRect.set((int)(paramFloat1 - QC / 2 / paramFloat3), (int)(paramFloat2 - QD / 2 / paramFloat3), (int)(QC / 2 / paramFloat3 + paramFloat1), (int)(paramFloat2 + QD / 2 / paramFloat3));
  }
  
  public boolean isShow()
  {
    return this.mIsShow;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aawb
 * JD-Core Version:    0.7.0.1
 */