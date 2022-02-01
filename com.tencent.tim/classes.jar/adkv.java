import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.common.app.AppInterface;
import com.tencent.imageboost.ImgProcessScan;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class adkv
  extends adkl
  implements adgw.b, adjh, adjq
{
  private long TA;
  private long UP = 500L;
  private long UQ;
  private long UR;
  private long US = SystemClock.uptimeMillis();
  private long UT;
  private adjp jdField_a_of_type_Adjp;
  private adjw jdField_a_of_type_Adjw;
  private byte[] aw;
  private adjh jdField_b_of_type_Adjh;
  private adjq jdField_b_of_type_Adjq;
  private Rect bA;
  private Rect bB;
  private Rect bC;
  private Rect bD;
  private boolean bNY;
  private boolean bOA;
  private boolean bOB;
  private boolean bOw;
  private boolean bOx;
  private boolean bOy;
  private boolean bOz = true;
  private int cIw;
  private int cIx;
  private byte[] dq;
  private byte[] dr;
  private Handler mHandler;
  private HandlerThread mHandlerThread;
  private int mPreviewHeight;
  private int mPreviewWidth;
  
  public adkv()
  {
    this.mSessionType = 0;
    adkt.a().b(this);
    adkt.a().a(this);
  }
  
  private static float a(Rect paramRect1, Rect paramRect2, Point paramPoint)
  {
    int i2 = paramPoint.x;
    int i3 = paramRect2.left;
    int i4 = paramRect2.right;
    int i5 = paramPoint.x;
    int k = paramPoint.y;
    int m = paramRect2.top;
    int n = paramRect2.bottom;
    int i1 = paramPoint.y;
    int i;
    int j;
    label92:
    float f1;
    label108:
    float f2;
    label125:
    float f5;
    label155:
    label177:
    float f3;
    if (paramRect1.left < paramPoint.x)
    {
      i = paramPoint.x - paramRect1.left;
      if (paramRect1.right <= paramPoint.x) {
        break label395;
      }
      j = paramRect1.right - paramPoint.x;
      if (i <= 0) {
        break label401;
      }
      f1 = (i2 - i3) / i;
      if (j <= 0) {
        break label407;
      }
      f2 = (i4 - i5) / j;
      f5 = Math.min(f1, f2);
      if (paramRect1.top >= paramPoint.y) {
        break label414;
      }
      i = paramPoint.y - paramRect1.top;
      if (paramRect1.bottom <= paramPoint.y) {
        break label420;
      }
      j = paramRect1.bottom - paramPoint.y;
      if (i <= 0) {
        break label426;
      }
      f3 = (k - m) / i;
      label194:
      if (j <= 0) {
        break label433;
      }
    }
    float f8;
    label395:
    label401:
    label407:
    label414:
    label420:
    label426:
    label433:
    for (float f4 = (n - i1) / j;; f4 = 2.147484E+009F)
    {
      f5 = Math.min(f5, Math.min(f3, f4));
      float f6 = paramRect2.width() / paramRect1.width();
      float f7 = paramRect2.height() / paramRect1.height();
      f8 = Math.min(f6, f7);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("calcZoomFactor_ori [codeRect,scanRect,prevCenter]=[%s|%s|%s]", new Object[] { paramRect1.toShortString(), paramRect2.toShortString(), paramPoint.toString() }));
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("calcZoomFactor_calc [ratioLeft,ratioRight]=[%.2f,%.2f], [ratioTop,ratioBot]=[%.2f,%.2f] [wFactor,hFactor]=[%.2f,%.2f]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Float.valueOf(f3), Float.valueOf(f4), Float.valueOf(f6), Float.valueOf(f7) }));
      }
      if ((f5 < 0.0F) || (f8 <= f5)) {
        break label440;
      }
      return f5;
      i = 0;
      break;
      j = 0;
      break label92;
      f1 = 2.147484E+009F;
      break label108;
      f2 = 2.147484E+009F;
      break label125;
      i = 0;
      break label155;
      j = 0;
      break label177;
      f3 = 2.147484E+009F;
      break label194;
    }
    label440:
    return f8;
  }
  
  private void a(Rect paramRect1, Rect paramRect2, boolean paramBoolean)
  {
    Rect localRect = new Rect();
    if ((paramRect1 != null) && (paramRect1.width() > 0) && (paramRect1.height() > 0))
    {
      localRect.set(0, 0, paramRect1.height(), paramRect1.width());
      localRect.offset(this.mPreviewHeight - paramRect1.top - paramRect1.height(), paramRect1.left);
    }
    if ((localRect.width() > 0) && (localRect.height() > 0))
    {
      paramRect2.set(localRect);
      float f1 = adlb.SCREEN_WIDTH / this.mPreviewHeight;
      float f2 = adlb.cIE / this.mPreviewWidth;
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, String.format("getScreenRect [%.2f,%.2f, %d,%d,%d,%d]", new Object[] { Float.valueOf(f1), Float.valueOf(f2), Integer.valueOf(adlb.SCREEN_WIDTH), Integer.valueOf(adlb.cIE), Integer.valueOf(this.mPreviewHeight), Integer.valueOf(this.mPreviewWidth) }));
      }
      paramRect2.left = ((int)(paramRect2.left * f1));
      paramRect2.top = ((int)(paramRect2.top * f2));
      paramRect2.right = ((int)(f1 * paramRect2.right));
      paramRect2.bottom = ((int)(paramRect2.bottom * f2));
    }
    if (QLog.isColorLevel()) {
      QLog.i("QRSession", 2, String.format("[------ detect_point 2 rect=%s previewRect=%s screenRect=%s isQr=%b ------]", new Object[] { paramRect1, localRect, paramRect2, Boolean.valueOf(paramBoolean) }));
    }
  }
  
  private boolean aM(int paramInt1, int paramInt2)
  {
    int j = -1;
    long l1 = System.currentTimeMillis();
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i = j;
    long l2;
    if (this.bOx)
    {
      bool1 = bool2;
      i = j;
      if (l1 - this.UQ > 1000L)
      {
        l2 = System.currentTimeMillis();
        i = h(this.dq, paramInt1, paramInt2);
        if (i >= this.cIw) {
          break label151;
        }
      }
    }
    label151:
    for (bool1 = true;; bool1 = false)
    {
      if (QLog.isColorLevel()) {
        QLog.d("QRSession", 2, String.format("checkAvgLuminance avgLuminance=%s get avg luminance time cost:%sms", new Object[] { Integer.valueOf(i), Long.valueOf(System.currentTimeMillis() - l2) }));
      }
      this.UQ = l1;
      if ((this.jdField_b_of_type_Adjh != null) && (this.cHX == 2) && (i >= 0)) {
        this.jdField_b_of_type_Adjh.KZ(i);
      }
      return bool1;
    }
  }
  
  private void cSA()
  {
    if ((this.mPreviewWidth <= 0) || (this.mPreviewHeight <= 0)) {
      return;
    }
    float f1 = this.mPreviewHeight / adlb.SCREEN_WIDTH;
    float f2 = this.mPreviewWidth / adlb.cIE;
    Rect localRect1 = new Rect((int)(this.bA.left * f1), (int)(this.bA.top * f2), (int)(f1 * this.bA.right), (int)(f2 * this.bA.bottom));
    Rect localRect2 = new Rect(0, 0, (int)(localRect1.width() * 1.5F), (int)(localRect1.height() * 1.5F));
    localRect2.offset(localRect1.centerX() - localRect2.centerX(), localRect1.centerY() - localRect2.centerY());
    localRect2.intersect(0, 0, this.mPreviewHeight, this.mPreviewWidth);
    Rect localRect3 = new Rect(0, 0, localRect1.height(), localRect1.width());
    localRect3.offset(localRect1.top, localRect1.left);
    Rect localRect4 = new Rect(0, 0, (int)(1.3F * localRect3.width()), (int)(1.2F * localRect3.height()));
    localRect4.offset(localRect3.centerX() - localRect4.centerX(), localRect3.centerY() - localRect4.centerY());
    localRect4.intersect(0, 0, this.mPreviewWidth, this.mPreviewHeight);
    if (QLog.isColorLevel()) {
      QLog.d("QRSession", 2, String.format("initScanRect [mScanRect,qRRecogRect,qRRecogRectExt,rotateQRRecogRectExt]=[%s, %s, %s, %s] [w,h]=[%d,%d]", new Object[] { this.bA.toShortString(), localRect1.toShortString(), localRect2.toShortString(), localRect4.toShortString(), Integer.valueOf(adlb.SCREEN_WIDTH), Integer.valueOf(adlb.cIE) }));
    }
    this.bB = localRect1;
    this.bD = localRect2;
    this.bC = localRect4;
  }
  
  private void cSB()
  {
    this.jdField_a_of_type_Adjw.init();
    this.bNY = true;
    this.jdField_a_of_type_Adjp.init();
    this.bOw = true;
  }
  
  private void cSC()
  {
    try
    {
      if (this.bNY)
      {
        this.jdField_a_of_type_Adjw.unInit();
        this.bNY = false;
      }
      if (this.bOw)
      {
        this.jdField_a_of_type_Adjp.unInit();
        this.bOw = false;
      }
      if (this.mHandler != null) {
        this.mHandler.removeMessages(100);
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("QRSession", 2, "unInitQbar fail!", localException);
    }
  }
  
  private void cSD()
  {
    long l1 = System.currentTimeMillis();
    if (QLog.isColorLevel()) {}
    for (StringBuilder localStringBuilder = new StringBuilder("doRecognizeInternal ");; localStringBuilder = null)
    {
      boolean bool1 = false;
      boolean bool2;
      boolean bool3;
      if (d(this.aw, this.mPreviewWidth, this.mPreviewHeight))
      {
        if ((this.bB == null) || (this.bD == null)) {
          cSA();
        }
        this.mHandler.removeMessages(102);
        bool1 = this.jdField_a_of_type_Adjp.aeG();
        if ((this.cIx >= 2) && (bool1)) {
          break label480;
        }
        int i = this.bD.top;
        int j = this.bD.left;
        int k = this.bD.height();
        int m = this.bD.width();
        if ((this.dq == null) || (this.dq.length != k * m * 3 / 2)) {
          this.dq = new byte[k * m * 3 / 2];
        }
        int[] arrayOfInt = new int[2];
        if (ImgProcessScan.gray_rotate_crop_sub(this.dq, arrayOfInt, this.aw, this.mPreviewWidth, this.mPreviewHeight, i, j, k, m, 90, 0) == 0)
        {
          i = arrayOfInt[0];
          j = arrayOfInt[1];
          long l2 = System.currentTimeMillis();
          boolean bool4 = this.jdField_a_of_type_Adjw.b(this.dq, i, j, false);
          long l3 = System.currentTimeMillis();
          if ((bool4) || (!this.jdField_a_of_type_Adjp.b(this.dq, i, j, false))) {
            break label468;
          }
          bool2 = true;
          long l4 = System.currentTimeMillis();
          if ((bool4) || (bool2) || (!aM(i, j))) {
            break label474;
          }
          bool3 = true;
          label289:
          if ((!bool3) && (!bool4) && (!bool2)) {
            this.cIx += 1;
          }
          if ((bool4) || (bool2))
          {
            this.cIx = 0;
            this.UR = 0L;
          }
          adjv.hr((int)(l3 - l2), 0);
          adjv.hr((int)(l4 - l3), 1);
          if (localStringBuilder != null) {
            localStringBuilder.append(String.format("...1 decode qrSuc=%b miniSuc=%b isDark=%b failCnt=%d", new Object[] { Boolean.valueOf(bool4), Boolean.valueOf(bool2), Boolean.valueOf(bool3), Integer.valueOf(this.cIx) }));
          }
        }
      }
      for (;;)
      {
        if ((QLog.isColorLevel()) && (localStringBuilder != null))
        {
          QLog.i("QRSession", 2, localStringBuilder.toString());
          QLog.d("QRSession", 2, String.format("doRecognizeInternal ...end isReady2Detect=%b minicode_timecost=%d", new Object[] { Boolean.valueOf(bool1), Long.valueOf(System.currentTimeMillis() - l1) }));
        }
        return;
        label468:
        bool2 = false;
        break;
        label474:
        bool3 = false;
        break label289;
        label480:
        this.UR = this.jdField_a_of_type_Adjp.a(this.aw, this.mPreviewWidth, this.mPreviewHeight, this.bD);
        this.cIx = 0;
        if (this.UR > 0L) {
          this.mHandler.sendEmptyMessageDelayed(102, 350L);
        }
        if (localStringBuilder != null) {
          localStringBuilder.append(String.format("...2 detect ts=%d", new Object[] { Long.valueOf(this.UR) }));
        }
      }
    }
  }
  
  private boolean d(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    return (paramArrayOfByte != null) && (paramArrayOfByte.length > 0) && (paramArrayOfByte.length == paramInt1 * paramInt2 * 3 / 2);
  }
  
  private boolean e(Rect paramRect)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_Adjp.a(this.aw, this.mPreviewWidth, this.mPreviewHeight, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), true);
      return bool;
    }
    catch (Throwable paramRect)
    {
      if (QLog.isColorLevel()) {
        QLog.i("QRSession", 2, paramRect.getMessage(), paramRect);
      }
    }
    return false;
  }
  
  private boolean f(Rect paramRect)
  {
    boolean bool = false;
    if ((this.dr == null) || (this.dr.length != paramRect.width() * paramRect.height() * 3 / 2)) {
      this.dr = new byte[paramRect.width() * paramRect.height() * 3 / 2];
    }
    int[] arrayOfInt = new int[2];
    if (ImgProcessScan.gray_rotate_crop_sub(this.dr, arrayOfInt, this.aw, this.mPreviewWidth, this.mPreviewHeight, paramRect.left, paramRect.top, paramRect.width(), paramRect.height(), 90, 0) == 0) {
      bool = this.jdField_a_of_type_Adjw.b(this.dr, arrayOfInt[0], arrayOfInt[1], true);
    }
    return bool;
  }
  
  private int h(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    int n = -1;
    int k = n;
    if (paramArrayOfByte.length > paramInt1 * paramInt2)
    {
      k = 0;
      int i = 0;
      int j = 0;
      while (k < paramInt2)
      {
        int m = i;
        int i1 = 0;
        i = j;
        j = m;
        m = i1;
        while (m < paramInt1)
        {
          i += (paramArrayOfByte[(k * paramInt1 + m)] & 0xFF);
          j += 1;
          m += 3;
        }
        m = k + 3;
        k = i;
        i = j;
        j = k;
        k = m;
      }
      k = n;
      if (i > 0) {
        k = j / i;
      }
    }
    return k;
  }
  
  private void jA(List<adjj> paramList)
  {
    if (paramList.size() <= 0) {
      return;
    }
    if (this.US > 0L)
    {
      l1 = SystemClock.uptimeMillis();
      long l2 = this.US;
      this.US = 0L;
      adjv.hw(this.jdField_a_of_type_Adjp.BO(), (int)(l1 - l2));
    }
    Object localObject;
    int i;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder("onGetDetectRect:");
      i = 0;
      while (i < paramList.size())
      {
        ((StringBuilder)localObject).append(((adjj)paramList.get(i)).toString()).append("\n");
        i += 1;
      }
      QLog.i("QRSession", 2, ((StringBuilder)localObject).toString());
    }
    long l1 = System.currentTimeMillis();
    boolean bool2;
    boolean bool7;
    boolean bool5;
    boolean bool6;
    label168:
    boolean bool9;
    boolean bool8;
    boolean bool11;
    boolean bool10;
    Rect localRect;
    boolean bool4;
    boolean bool3;
    boolean bool1;
    label326:
    float f3;
    label392:
    float f4;
    float f2;
    float f1;
    if (d(this.aw, this.mPreviewWidth, this.mPreviewHeight))
    {
      bool2 = false;
      bool7 = false;
      bool5 = false;
      bool6 = false;
      i = 0;
      bool9 = bool6;
      bool8 = bool5;
      bool11 = bool7;
      bool10 = bool2;
      if (i < paramList.size())
      {
        localObject = (adjj)paramList.get(i);
        bool8 = bool6;
        bool9 = bool5;
        bool10 = bool7;
        bool11 = bool2;
        if (((adjj)localObject).rect.width() > 0)
        {
          bool8 = bool6;
          bool9 = bool5;
          bool10 = bool7;
          bool11 = bool2;
          if (((adjj)localObject).rect.height() > 0)
          {
            localRect = ((adjj)localObject).rect;
            if (((adjj)localObject).type == 2)
            {
              bool6 = true;
              bool7 = e(localRect);
              bool4 = bool6;
              bool3 = bool5;
              bool1 = bool7;
              if (!bool7)
              {
                bool2 = f(localRect);
                bool1 = bool7;
                bool3 = bool5;
                bool4 = bool6;
              }
              bool9 = bool4;
              bool8 = bool3;
              bool11 = bool1;
              bool10 = bool2;
              if (bool2) {
                break label1055;
              }
              bool8 = bool4;
              bool9 = bool3;
              bool10 = bool1;
              bool11 = bool2;
              if (!bool1) {
                break label1007;
              }
              bool5 = bool4;
              bool6 = bool3;
              bool4 = bool2;
              bool3 = bool1;
              bool2 = bool6;
              bool1 = bool5;
              f3 = 0.0F;
              f4 = 0.0F;
              f2 = f4;
              f1 = f3;
              if (bool4) {
                break label1044;
              }
              f2 = f4;
              f1 = f3;
              if (bool3) {
                break label1044;
              }
              f2 = f4;
              f1 = f3;
            }
          }
        }
      }
    }
    for (;;)
    {
      float f5;
      try
      {
        if (((adjj)paramList.get(0)).rect.width() <= 0) {
          break label1044;
        }
        f2 = f4;
        f1 = f3;
        if (((adjj)paramList.get(0)).rect.height() <= 0) {
          break label1044;
        }
        if (this.UT != 0L)
        {
          f2 = f4;
          f1 = f3;
          if (SystemClock.uptimeMillis() - this.UT <= 500L) {
            break label1044;
          }
        }
        f4 = ((adjj)paramList.get(0)).rect.width() / this.bC.width();
        f3 = ((adjj)paramList.get(0)).rect.height() / this.bC.height();
        if ((f4 >= 0.7F) || (f3 >= 0.7F)) {
          break label1032;
        }
        bool5 = true;
        if (QLog.isColorLevel()) {
          QLog.i("QRSession", 2, String.format("[wRatio,hRatio,need]=[%.2f %.2f %b]", new Object[] { Float.valueOf(f4), Float.valueOf(f3), Boolean.valueOf(bool5) }));
        }
        f2 = f3;
        f1 = f4;
        if (!bool5) {
          break label1044;
        }
        paramList = new Rect(((adjj)paramList.get(0)).rect);
        localObject = new Point(this.mPreviewWidth / 2, this.mPreviewHeight / 2);
        f5 = a(paramList, this.bC, (Point)localObject);
        f2 = f3;
        f1 = f4;
        if (f5 < 1.2F) {
          break label1044;
        }
        if (f5 <= 25.0F) {
          break label1038;
        }
        f1 = 25.0F;
        bool5 = adkt.a().a(f1, false);
        this.bOB |= bool5;
        if (!bool5) {
          break label1089;
        }
        this.UT = SystemClock.uptimeMillis();
        adkt.a().cRA();
      }
      catch (Throwable paramList) {}
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QRSession", 2, String.format("doRecognizeInternal ...async onGetDetectRect has=[%b,%b] suc=[%b,%b] zoom=%b [%.2f,%.2f] minicode_timecost=%d", new Object[] { Boolean.valueOf(bool2), Boolean.valueOf(bool1), Boolean.valueOf(bool4), Boolean.valueOf(bool3), Boolean.valueOf(bool5), Float.valueOf(f3), Float.valueOf(f1), Long.valueOf(System.currentTimeMillis() - l1) }));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("QRSession", 2, paramList.getMessage(), paramList);
      return;
      if (((adjj)localObject).type == 1)
      {
        bool5 = true;
        bool8 = f(localRect);
        bool4 = bool6;
        bool3 = bool5;
        bool1 = bool7;
        bool2 = bool8;
        if (bool8) {
          break label326;
        }
        bool1 = e(localRect);
        bool4 = bool6;
        bool3 = bool5;
        bool2 = bool8;
        break label326;
      }
      bool4 = bool6;
      bool3 = bool5;
      bool1 = bool7;
      if (((adjj)localObject).type != 3) {
        break label326;
      }
      bool8 = f(localRect);
      bool4 = bool6;
      bool3 = bool5;
      bool1 = bool7;
      bool2 = bool8;
      if (bool8) {
        break label326;
      }
      bool1 = e(localRect);
      bool4 = bool6;
      bool3 = bool5;
      bool2 = bool8;
      break label326;
      label1007:
      i += 1;
      bool6 = bool8;
      bool5 = bool9;
      bool7 = bool10;
      bool2 = bool11;
      break label168;
      label1032:
      bool5 = false;
      continue;
      label1038:
      f1 = f5;
      continue;
      label1044:
      f3 = f1;
      bool5 = false;
      f1 = f2;
      continue;
      label1055:
      bool3 = bool11;
      bool4 = bool10;
      bool1 = bool9;
      bool2 = bool8;
      break label392;
      bool2 = false;
      bool3 = false;
      bool4 = false;
      bool1 = false;
      break label392;
      label1089:
      bool5 = true;
      f1 = f3;
      f3 = f4;
    }
  }
  
  public void G(String paramString1, String paramString2, boolean paramBoolean)
  {
    int i = 2;
    this.US = 0L;
    if ((this.jdField_b_of_type_Adjh != null) && (this.cHX == 2) && (!this.bOA)) {
      this.jdField_b_of_type_Adjh.G(paramString1.toString(), paramString2.toString(), paramBoolean);
    }
    if (paramBoolean) {}
    for (;;)
    {
      adjv.Lc(i);
      return;
      if (this.bOB) {
        i = 6;
      } else {
        i = 1;
      }
    }
  }
  
  public void Gc(boolean paramBoolean)
  {
    if (this.cHX == 2) {
      this.bOy = true;
    }
  }
  
  public void Gp(boolean paramBoolean)
  {
    if (paramBoolean != this.bOA)
    {
      this.bOA = paramBoolean;
      if (paramBoolean) {
        this.mHandler.removeMessages(101);
      }
    }
  }
  
  public void I(boolean paramBoolean, long paramLong)
  {
    this.bOx = paramBoolean;
    if (this.bOx) {
      this.UQ = (System.currentTimeMillis() + paramLong);
    }
  }
  
  public void KZ(int paramInt) {}
  
  public void a(adjh paramadjh, adjq paramadjq)
  {
    this.jdField_b_of_type_Adjh = paramadjh;
    this.jdField_b_of_type_Adjq = paramadjq;
  }
  
  public void a(Context paramContext, AppInterface paramAppInterface)
  {
    super.a(paramContext, paramAppInterface);
    this.mHandlerThread = ThreadManager.newFreeHandlerThread("QRRecognizerController", 0);
    this.mHandlerThread.start();
    this.mHandler = new adkv.a(this.mHandlerThread.getLooper());
    this.jdField_a_of_type_Adjw = new adjw(this.mHandler);
    this.jdField_a_of_type_Adjw.a(this);
    this.jdField_a_of_type_Adjp = new adjp(this.mHandler, paramContext);
    this.jdField_a_of_type_Adjp.a(this);
    this.UP = 250L;
    if (adfw.a().bMG) {
      this.UP = 120L;
    }
    this.cIw = adfw.a().cFa;
    this.mHandler.sendEmptyMessage(100);
    QLog.i("QRSession", 1, String.format("init mQRRecognizeInterval=%s", new Object[] { Long.valueOf(this.UP) }));
  }
  
  public void b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    long l;
    if (((this.bNY) || (this.bOw)) && (this.mHandler != null) && (!this.bOA) && ((paramBoolean) || ((!this.mHandler.hasMessages(101)) && (!this.mHandler.hasMessages(102)))))
    {
      l = System.currentTimeMillis();
      if ((paramBoolean) || (l - this.TA >= this.UP)) {}
    }
    else
    {
      return;
    }
    if (d(paramArrayOfByte, paramInt1, paramInt2))
    {
      if ((this.aw == null) || (this.aw.length != paramArrayOfByte.length)) {
        this.aw = new byte[paramArrayOfByte.length];
      }
      System.arraycopy(paramArrayOfByte, 0, this.aw, 0, paramArrayOfByte.length);
      this.mPreviewWidth = paramInt1;
      this.mPreviewHeight = paramInt2;
    }
    for (this.TA = l;; this.TA = 0L)
    {
      this.mHandler.removeMessages(101);
      this.mHandler.sendEmptyMessage(101);
      return;
      this.mPreviewWidth = 0;
      this.mPreviewHeight = 0;
    }
  }
  
  public void c(boolean paramBoolean, float paramFloat)
  {
    int i;
    if ((this.jdField_a_of_type_Adjp != null) && (this.jdField_a_of_type_Adjp.aeH()))
    {
      i = 1;
      if (QLog.isColorLevel()) {
        if (i == 0) {
          break label204;
        }
      }
    }
    label204:
    for (int j = 1;; j = 0)
    {
      QLog.d("QRSession", 2, String.format("onQRRecognizeFail hasQR=%s qrAreaRatio=%s isMiniRecgReady =%d", new Object[] { Boolean.valueOf(paramBoolean), Float.valueOf(paramFloat), Integer.valueOf(j) }));
      if ((this.jdField_b_of_type_Adjh != null) && (this.cHX == 2))
      {
        if ((paramBoolean) && (paramFloat > 0.003F) && (i == 0))
        {
          float f2 = (float)(Math.sqrt(paramFloat) * 100.0D) * 0.75F;
          float f1 = f2;
          if (f2 >= 1.2F)
          {
            f1 = f2;
            if (f2 > 25.0F) {
              f1 = 25.0F;
            }
            adkt.a().a(f1, false);
          }
          if (QLog.isColorLevel()) {
            QLog.i("QRSession", 2, String.format("onRecognizeFail onGetDetectRect ratio=%.2f", new Object[] { Float.valueOf(f1) }));
          }
        }
        this.jdField_b_of_type_Adjh.c(paramBoolean, paramFloat);
      }
      return;
      i = 0;
      break;
    }
  }
  
  public void d(List<adjj> paramList, long paramLong)
  {
    if ((this.jdField_b_of_type_Adjq != null) && (!this.bOA) && (this.cHX == 2) && (paramLong == this.UR))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      int i = 0;
      while (i < paramList.size())
      {
        adjj localadjj1 = new adjj();
        adjj localadjj2 = new adjj();
        localadjj1.type = ((adjj)paramList.get(i)).type;
        localadjj2.type = ((adjj)paramList.get(i)).type;
        localadjj1.score = ((adjj)paramList.get(i)).score;
        localadjj2.score = ((adjj)paramList.get(i)).score;
        localadjj1.rect = ((adjj)paramList.get(i)).rect;
        Rect localRect = ((adjj)paramList.get(i)).rect;
        if ((localRect.width() > 0) && (localRect.height() > 0)) {
          a(localRect, localadjj2.rect, true);
        }
        localArrayList1.add(localadjj1);
        localArrayList2.add(localadjj2);
        i += 1;
      }
      if (this.jdField_b_of_type_Adjq != null) {
        this.jdField_b_of_type_Adjq.d(localArrayList2, paramLong);
      }
      jA(localArrayList1);
    }
    if (paramLong == this.UR)
    {
      this.mHandler.removeMessages(102);
      adjv.hr((int)(System.currentTimeMillis() - paramLong), 2);
    }
  }
  
  public void h(Rect paramRect)
  {
    if ((paramRect != null) && (!paramRect.equals(this.bA)))
    {
      this.bA = paramRect;
      cSA();
    }
  }
  
  public boolean l(byte[] paramArrayOfByte)
  {
    if (this.cHX == 2)
    {
      b(paramArrayOfByte, adkt.a().fk(), adkt.a().fl(), this.bOy);
      if (adjv.aeJ()) {
        adjv.doFrame();
      }
    }
    this.bOy = false;
    return false;
  }
  
  public void m(boolean paramBoolean1, String paramString, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      this.US = 0L;
    }
    if ((this.jdField_b_of_type_Adjq != null) && (this.cHX == 2) && (!this.bOA)) {
      this.jdField_b_of_type_Adjq.m(paramBoolean1, paramString, paramBoolean2);
    }
    int i;
    if (paramBoolean1)
    {
      if (!paramBoolean2) {
        break label60;
      }
      i = 4;
    }
    for (;;)
    {
      adjv.Lc(i);
      return;
      label60:
      if (this.bOB) {
        i = 5;
      } else {
        i = 3;
      }
    }
  }
  
  public void onSaveImg(long paramLong)
  {
    if (this.jdField_b_of_type_Adjq != null) {
      this.jdField_b_of_type_Adjq.onSaveImg(paramLong);
    }
  }
  
  public void pause()
  {
    super.pause();
    if (this.bOB) {
      adkt.a().cRD();
    }
    if (adjv.aeJ()) {
      adjv.cSh();
    }
  }
  
  public void resume()
  {
    super.resume();
    if (this.bOB) {
      this.bOB = false;
    }
  }
  
  public void uninit()
  {
    super.uninit();
    cSC();
    this.mHandlerThread.quit();
    this.mHandlerThread = null;
    this.mHandler.removeCallbacksAndMessages(null);
    this.mHandler = null;
    adkt.a().c(this);
    adkt.a().b(this);
    adjv.Lc(0);
  }
  
  class a
    extends Handler
  {
    public a(Looper paramLooper)
    {
      super();
    }
    
    public void handleMessage(Message paramMessage)
    {
      switch (paramMessage.what)
      {
      }
      do
      {
        return;
        adkv.a(adkv.this);
        return;
        if (adkv.a(adkv.this))
        {
          adkv.a(adkv.this, false);
          adjv.cSg();
        }
        try
        {
          adkv.b(adkv.this);
          return;
        }
        catch (Throwable paramMessage) {}
      } while (!QLog.isColorLevel());
      QLog.i("QRSession", 2, paramMessage.getMessage(), paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adkv
 * JD-Core Version:    0.7.0.1
 */