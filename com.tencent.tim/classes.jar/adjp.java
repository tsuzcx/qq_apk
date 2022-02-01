import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Rect;
import android.os.Handler;
import android.os.SystemClock;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.1;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.2;
import com.tencent.mobileqq.ar.codeEngine.MiniRecog.3;
import com.tencent.mobileqq.minicode.RecogUtil;
import com.tencent.mobileqq.minicode.recog.RecogCallback;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class adjp
  extends adjl
  implements adjn.c, RecogCallback
{
  public static boolean DEBUG = true;
  long Uk;
  long Ul;
  adjn a;
  public adjq a;
  public volatile boolean bNU = false;
  boolean bNV = false;
  Rect bz;
  int cHm;
  int cHn;
  int cHo = -2147483648;
  int[] kx;
  Context mContext;
  Handler mHandler;
  public boolean mIsDetecting;
  
  public adjp(Handler paramHandler, Context paramContext)
  {
    this.mHandler = paramHandler;
    this.mContext = paramContext;
  }
  
  private boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    boolean bool1;
    if (!adjn.aeD()) {
      bool1 = false;
    }
    boolean bool2;
    do
    {
      return bool1;
      long l = System.currentTimeMillis();
      paramArrayOfByte = this.jdField_a_of_type_Adjn.decode(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, 0);
      bool2 = adjn.kX(paramArrayOfByte);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("------>recognizeDecode Mini suc=%b result=%s minicode_timecost=%d", new Object[] { Boolean.valueOf(bool2), paramArrayOfByte, Long.valueOf(System.currentTimeMillis() - l) }));
      }
      bool1 = bool2;
    } while (this.jdField_a_of_type_Adjq == null);
    this.jdField_a_of_type_Adjq.m(bool2, paramArrayOfByte, paramBoolean);
    return bool2;
  }
  
  public int BO()
  {
    return this.cHo;
  }
  
  public void La(int paramInt) {}
  
  public void Lb(int paramInt) {}
  
  public long a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, Rect paramRect)
  {
    boolean bool1 = this.jdField_a_of_type_Adjn.aeF();
    if ((this.mIsDetecting) || (!this.bNV) || (!bool1))
    {
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini exec=return bDetectReady=%b mIsDetecting=%b mIsSupportDetecting=%d", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(this.mIsDetecting), Boolean.valueOf(this.bNV) }));
      }
      return -1L;
    }
    if ((paramInt1 != this.cHm) || (paramInt2 != this.cHn) || (this.bz == null))
    {
      this.cHm = paramInt1;
      this.cHn = paramInt2;
      this.bz = new Rect(0, 0, paramRect.height(), paramRect.width());
      this.bz.offset(paramRect.top, paramRect.left);
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini [preW,preH]=[%d,%d] scanRect=%s rotateScanRect=%s", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramRect, this.bz }));
      }
    }
    long l = System.currentTimeMillis();
    try
    {
      paramArrayOfByte = a(paramArrayOfByte, this.cHm, this.cHn);
      if (paramArrayOfByte == null) {
        return 0L;
      }
    }
    catch (Throwable paramArrayOfByte)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.i("QRSession.MiniRecog", 2, paramArrayOfByte.getMessage(), paramArrayOfByte);
        }
        paramArrayOfByte = null;
      }
      boolean bool2 = false;
      bool1 = bool2;
      try
      {
        paramRect = Bitmap.createBitmap(paramArrayOfByte, this.bz.left, this.bz.top, this.bz.width(), this.bz.height());
        bool1 = bool2;
        paramArrayOfByte.recycle();
        bool1 = bool2;
        this.Uk = l;
        bool1 = bool2;
        bool2 = this.jdField_a_of_type_Adjn.detect(paramRect, this.Uk);
        bool3 = bool2;
        if (!bool2)
        {
          bool1 = bool2;
          paramRect.recycle();
          bool3 = bool2;
        }
      }
      catch (Throwable paramArrayOfByte)
      {
        for (;;)
        {
          boolean bool3 = bool1;
          if (QLog.isColorLevel())
          {
            QLog.i("QRSession.MiniRecog", 2, "recognizeDetect exception", paramArrayOfByte);
            bool3 = bool1;
          }
        }
      }
      if (bool3) {
        this.mIsDetecting = true;
      }
      if (QLog.isColorLevel()) {
        QLog.i("QRSession.MiniRecog", 2, String.format("-----> recognizeDetect Mini exec=%b ts=%s minicode_timecost=%d", new Object[] { Boolean.valueOf(bool3), Long.valueOf(this.Uk), Long.valueOf(System.currentTimeMillis() - l) }));
      }
      if (bool3) {
        return this.Uk;
      }
    }
    return 0L;
  }
  
  public Bitmap a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (this.kx == null) {}
    while (adjn.b(this.kx, paramArrayOfByte, this.cHm, this.cHn) != 0) {
      try
      {
        this.kx = new int[paramInt1 * paramInt2];
        if (this.kx == null) {
          return null;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.i("QRSession.MiniRecog", 2, "recognizeDetect OutOfMemoryError e");
          }
          System.gc();
          try
          {
            this.kx = new int[paramInt1 * paramInt2];
          }
          catch (OutOfMemoryError localOutOfMemoryError2) {}
          if (QLog.isColorLevel()) {
            QLog.i("QRSession.MiniRecog", 2, "recognizeDetect OutOfMemoryError e2");
          }
        }
      }
    }
    return Bitmap.createBitmap(this.kx, this.cHm, this.cHn, Bitmap.Config.ARGB_8888);
  }
  
  public void a(adjm paramadjm)
  {
    this.jdField_a_of_type_Adjq = ((adjq)paramadjm);
  }
  
  public boolean a(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, boolean paramBoolean)
  {
    return b(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, paramBoolean);
  }
  
  public boolean aeG()
  {
    return (this.jdField_a_of_type_Adjn.aeF()) && (this.bNV) && (!this.mIsDetecting);
  }
  
  public boolean aeH()
  {
    return this.bNU;
  }
  
  public boolean b(byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    return b(paramArrayOfByte, paramInt1, paramInt2, 0, 0, 0, 0, paramBoolean);
  }
  
  public void cSf() {}
  
  public int init()
  {
    this.Ul = SystemClock.uptimeMillis();
    this.jdField_a_of_type_Adjn = adjn.a();
    this.jdField_a_of_type_Adjn.a(this);
    this.jdField_a_of_type_Adjn.addRecogCallback(this);
    this.jdField_a_of_type_Adjn.h(this.mContext, hashCode(), "MiniRecog");
    this.cHo = RecogUtil.getSupportDetectType();
    if (this.cHo >= 0) {}
    for (boolean bool = true;; bool = false)
    {
      this.bNV = bool;
      return 0;
    }
  }
  
  public void onDetectReady(int paramInt)
  {
    long l = SystemClock.uptimeMillis() - this.Ul;
    if ((QLog.isColorLevel()) || (adjv.aeJ())) {
      QLog.i("QRSession.MiniRecog", 1, String.format("base_test_scan mini_detect_init consume=%d", new Object[] { Long.valueOf(l) }));
    }
    this.mHandler.post(new MiniRecog.3(this));
    adjv.hu(this.cHo, (int)l);
  }
  
  public void onDetectResult(List<adjj> paramList, long paramLong)
  {
    if (this.Uk != paramLong) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      if ((((adjj)paramList.get(i)).rect.width() > 0) && (((adjj)paramList.get(i)).rect.height() > 0))
      {
        Rect localRect = new Rect(((adjj)paramList.get(i)).rect);
        localRect.offset(this.bz.left, this.bz.top);
        adjj localadjj = new adjj();
        localadjj.rect.set(localRect);
        localadjj.type = ((adjj)paramList.get(i)).type;
        localadjj.score = ((adjj)paramList.get(i)).score;
        localArrayList.add(localadjj);
      }
      i += 1;
    }
    this.mHandler.post(new MiniRecog.1(this, localArrayList, paramLong));
  }
  
  public void onSaveImg(long paramLong)
  {
    this.mHandler.post(new MiniRecog.2(this, paramLong));
  }
  
  public void unInit()
  {
    if (this.jdField_a_of_type_Adjn != null)
    {
      this.jdField_a_of_type_Adjn.a(this);
      this.jdField_a_of_type_Adjn.removeRecogCallback(this);
      this.jdField_a_of_type_Adjn.ak(hashCode(), "MiniRecog");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adjp
 * JD-Core Version:    0.7.0.1
 */