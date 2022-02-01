import android.content.Context;
import android.graphics.Bitmap;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceDecoder.1;
import com.tencent.mobileqq.util.FaceInfo;

public class aqdf
{
  aqdg a;
  
  public aqdf(Context paramContext, AppInterface paramAppInterface)
  {
    this(paramAppInterface);
  }
  
  public aqdf(AppInterface paramAppInterface)
  {
    if ((paramAppInterface instanceof QQAppInterface)) {
      this.a = new aqdh((QQAppInterface)paramAppInterface);
    }
    while (this.a == null)
    {
      throw new NullPointerException("can not Instantiation FaceDecoder");
      if ((paramAppInterface instanceof NearbyAppInterface)) {
        this.a = new aqej((NearbyAppInterface)paramAppInterface);
      }
    }
  }
  
  protected static void a(QQAppInterface paramQQAppInterface, FaceInfo paramFaceInfo)
  {
    if ((paramQQAppInterface == null) || (paramFaceInfo == null)) {
      return;
    }
    ThreadManager.post(new FaceDecoder.1(paramFaceInfo, paramQQAppInterface), 10, null, true);
  }
  
  private byte c(int paramInt)
  {
    byte b = 1;
    if (paramInt == 115) {
      b = 2;
    }
    return b;
  }
  
  public void F(AppInterface paramAppInterface)
  {
    this.a.F(paramAppInterface);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2)
  {
    return a(paramInt1, paramString, paramInt2, (byte)1);
  }
  
  public Bitmap a(int paramInt1, String paramString, int paramInt2, byte paramByte)
  {
    return this.a.a(paramInt1, paramString, paramInt2, paramByte);
  }
  
  public void a(aqdf.a parama)
  {
    this.a.a(parama);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean, byte paramByte)
  {
    return this.a.a(paramString, 200, false, paramInt, paramBoolean, paramByte, c(paramInt));
  }
  
  public boolean a(String paramString, int paramInt1, boolean paramBoolean1, int paramInt2, boolean paramBoolean2, byte paramByte, int paramInt3)
  {
    return this.a.a(paramString, paramInt1, paramBoolean1, paramInt2, paramBoolean2, paramByte, paramInt3);
  }
  
  public boolean a(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 32, paramBoolean2, (byte)1, 1);
  }
  
  public Bitmap b(int paramInt, String paramString)
  {
    if (paramInt == 32) {
      return null;
    }
    byte b = c(paramInt);
    if ((paramInt == 101) || (paramInt == 1001)) {
      b = 1;
    }
    return this.a.a(paramInt, paramString, 0, b);
  }
  
  public Bitmap b(int paramInt1, String paramString, int paramInt2)
  {
    return b(paramInt1, paramString);
  }
  
  public boolean b(String paramString, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    return this.a.a(paramString, paramInt, paramBoolean1, 16, paramBoolean2, (byte)1, 1);
  }
  
  public void c(int paramInt1, String paramString, int paramInt2, long paramLong)
  {
    this.a.c(paramInt1, paramString, paramInt2, paramLong);
  }
  
  public void destory()
  {
    this.a.destory();
  }
  
  public void edu()
  {
    this.a.edu();
  }
  
  public boolean i(String paramString, int paramInt, boolean paramBoolean)
  {
    return this.a.a(paramString, 200, false, paramInt, paramBoolean, (byte)0, c(paramInt));
  }
  
  public boolean isPausing()
  {
    return this.a.isPausing();
  }
  
  public void pause()
  {
    this.a.pause();
  }
  
  public void resume()
  {
    this.a.resume();
  }
  
  public static abstract interface a
    extends aqdg.a
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aqdf
 * JD-Core Version:    0.7.0.1
 */