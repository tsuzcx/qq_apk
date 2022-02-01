import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.Hashtable;
import java.util.LinkedList;

public abstract class aqdg
{
  aqdg.a a = null;
  LinkedList<FaceInfo> am = new LinkedList();
  boolean cTF = false;
  boolean cTG = false;
  int dYv = 10;
  protected int dYw;
  boolean mPause = false;
  Hashtable<String, FaceInfo> s = new Hashtable();
  Hashtable<String, FaceInfo> x = new Hashtable();
  
  public abstract void F(AppInterface paramAppInterface);
  
  public abstract Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte);
  
  public void a(aqdg.a parama)
  {
    this.a = parama;
  }
  
  public final boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3, 100, false);
  }
  
  public abstract boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3, int paramInt4, boolean paramBoolean3);
  
  public abstract void c(int paramInt1, String paramString, int paramInt2, long paramLong);
  
  protected abstract void cUQ();
  
  protected void d(FaceInfo paramFaceInfo)
  {
    if (paramFaceInfo == null) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.e("FaceDecoderBase", 2, "enqueueDecode, iRunningRequests=" + this.dYw + ", pause=" + this.mPause + ",faceinfo=" + paramFaceInfo.toString());
      }
      try
      {
        this.am.remove(paramFaceInfo);
        if (paramFaceInfo.cTI)
        {
          this.am.addLast(paramFaceInfo);
          paramFaceInfo.Xq(FaceInfo.dYC);
          if ((this.dYw >= this.dYv) || (this.mPause)) {
            continue;
          }
          cUQ();
          return;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          if (QLog.isColorLevel())
          {
            QLog.e("FaceDecoderBase", 2, "enqueueDecode", localException);
            continue;
            this.am.addFirst(paramFaceInfo);
          }
        }
      }
    }
  }
  
  public void destory()
  {
    if (QLog.isColorLevel()) {
      ajrk.log(2, "FaceDecoderBase", "destory", new Object[0]);
    }
    edu();
    this.dYw = 0;
    this.a = null;
    this.mPause = false;
  }
  
  public void edu()
  {
    if (QLog.isColorLevel()) {
      ajrk.log(2, "FaceDecoderBase", "cancelPendingRequests", new Object[0]);
    }
    this.x.clear();
    this.am.clear();
  }
  
  public boolean isPausing()
  {
    return this.mPause;
  }
  
  public void pause()
  {
    if (QLog.isColorLevel()) {
      ajrk.log(2, "FaceDecoderBase", "cancelPendingRequests", new Object[0]);
    }
    this.mPause = true;
  }
  
  public void resume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("FaceDecoderBase", 2, "resume");
    }
    this.mPause = false;
    while ((this.dYw < this.dYv) && (!this.am.isEmpty())) {
      cUQ();
    }
  }
  
  static abstract interface a
  {
    public abstract void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqdg
 * JD-Core Version:    0.7.0.1
 */