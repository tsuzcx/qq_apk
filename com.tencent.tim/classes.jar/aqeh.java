import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.nearby.NearbyAppInterface;
import com.tencent.mobileqq.util.FaceDecodeTask;
import com.tencent.mobileqq.util.FaceInfo;
import com.tencent.qphone.base.util.QLog;

public class aqeh
  extends aqdj
{
  acpq a = null;
  NearbyAppInterface d;
  
  public aqeh(AppInterface paramAppInterface, int paramInt1, int paramInt2, String paramString, byte paramByte, int paramInt3, boolean paramBoolean1, Drawable paramDrawable1, Drawable paramDrawable2, aqdj.a parama, boolean paramBoolean2)
  {
    super(paramAppInterface, paramInt1, paramInt2, paramString, paramByte, paramInt3, 100, paramBoolean1, paramDrawable1, paramDrawable2, parama, paramBoolean2);
    this.d = ((NearbyAppInterface)paramAppInterface);
  }
  
  protected boolean aBV()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "requestDecode.faceInfo=" + this.c);
    }
    if (this.c == null) {
      return false;
    }
    FaceDecodeTask.a(FaceDecodeTask.a(this.d, this.c, this));
    return true;
  }
  
  protected Bitmap aG()
  {
    if (this.c == null) {
      return null;
    }
    String str = FaceInfo.a(this.c.aRY, this.c.uin, this.c.idType, this.c.shape);
    return ((aqdm)this.d.getManager(216)).O(str);
  }
  
  public void cancel()
  {
    if ((this.a != null) && (this.d != null))
    {
      this.d.removeObserver(this.a);
      this.a = null;
    }
    this.d = null;
    super.cancel();
  }
  
  protected Bitmap d(boolean paramBoolean)
  {
    return aG();
  }
  
  protected void edv()
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.c);
    }
    Bitmap localBitmap = aG();
    if (localBitmap != null)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqhead.NearByFaceDrawable", 2, "onNeedDownload.faceInfo=" + this.c + ",bitmap is already in cache...");
      }
      a(this.c, localBitmap);
      return;
    }
    if (this.a == null)
    {
      this.a = new aqei(this);
      this.d.addObserver(this.a);
    }
    ((acpp)this.d.getBusinessHandler(4)).c(this.c);
  }
  
  protected void setApp(AppInterface paramAppInterface)
  {
    this.d = ((NearbyAppInterface)paramAppInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqeh
 * JD-Core Version:    0.7.0.1
 */