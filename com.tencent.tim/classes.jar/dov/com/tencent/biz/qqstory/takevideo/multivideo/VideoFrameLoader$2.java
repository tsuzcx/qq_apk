package dov.com.tencent.biz.qqstory.takevideo.multivideo;

import android.graphics.Bitmap;
import aypq;
import aypq.a;
import ayym;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.List;
import rop;

public class VideoFrameLoader$2
  implements Runnable
{
  public VideoFrameLoader$2(aypq paramaypq, int paramInt, Bitmap paramBitmap) {}
  
  public void run()
  {
    if ((this.eMz != aypq.a(this.this$0).size()) && (QLog.isColorLevel())) {
      QLog.d("VideoFrameLoader", 2, "onloadframe index error!");
    }
    Bitmap localBitmap = this.val$bitmap;
    Object localObject;
    if (aypq.a(this.this$0))
    {
      localObject = localBitmap;
      if (aypq.b(this.this$0)) {
        localObject = rop.rotateBitmap(localBitmap, -aypq.a(this.this$0));
      }
      if (aypq.a(this.this$0) == null)
      {
        aypq.a(this.this$0, new ayym());
        aypq.a(this.this$0).init(((Bitmap)localObject).getWidth(), ((Bitmap)localObject).getHeight());
      }
      localBitmap = aypq.a(this.this$0, aypq.a(this.this$0), (Bitmap)localObject, aypq.b(this.this$0));
    }
    for (;;)
    {
      aypq.a(this.this$0).add(localBitmap);
      localObject = null;
      if (aypq.a(this.this$0) != null) {
        localObject = (aypq.a)aypq.a(this.this$0).get();
      }
      if (localObject != null) {
        ((aypq.a)localObject).g(this.eMz, localBitmap);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.multivideo.VideoFrameLoader.2
 * JD-Core Version:    0.7.0.1
 */