import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import com.tencent.mobileqq.vas.PendantInfo;
import com.tencent.mobileqq.vas.PendantInfo.AnimationLruCache;
import com.tencent.qphone.base.util.QLog;
import java.util.Collection;
import java.util.Iterator;

public class aqql
  extends aurf
{
  public aqql(PendantInfo paramPendantInfo, Looper paramLooper, Handler.Callback paramCallback)
  {
    super(paramLooper, paramCallback);
  }
  
  public void handleMessage(Message paramMessage)
  {
    long l;
    Object localObject;
    if (paramMessage.what == 16)
    {
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.ebQ == l)
      {
        paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Drawable)paramMessage.next();
          if (localObject != null) {
            ((Drawable)localObject).invalidateSelf();
          }
        }
      }
      paramMessage = (Drawable)this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if (paramMessage != null) {
        paramMessage.invalidateSelf();
      }
    }
    Bitmap localBitmap;
    for (;;)
    {
      return;
      if (paramMessage.what != 17) {
        break label527;
      }
      this.this$0.mDecodeNextFrameEnd = true;
      this.this$0.mCurFrameIndex = this.this$0.ce(this.this$0.mCurFrameIndex);
      if (!(paramMessage.obj instanceof Bitmap)) {
        break label489;
      }
      localObject = (Bitmap)paramMessage.obj;
      if ((localObject != null) && (this.this$0.aQ() != localObject))
      {
        localBitmap = this.this$0.getCurrentBitmap();
        if (localBitmap != null)
        {
          if ((!localBitmap.isMutable()) || (Build.VERSION.SDK_INT <= 11)) {
            break label435;
          }
          this.this$0.dD = localBitmap;
        }
        label217:
        this.this$0.aj((Bitmap)localObject);
      }
      l = paramMessage.getData().getLong("targetId");
      try
      {
        if (PendantInfo.ebQ != l) {
          break label451;
        }
        paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Drawable)paramMessage.next();
          if (localObject != null) {
            ((Drawable)localObject).invalidateSelf();
          }
        }
        if (2 != this.this$0.ebX) {}
      }
      catch (Exception paramMessage)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PendantInfo", 2, "handleMessage, exception:" + paramMessage.getMessage());
        }
      }
    }
    label329:
    if (this.this$0.cVH)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PendantInfo", 2, "cancel decode pendant in market:" + this.this$0.atD);
      }
      this.this$0.cVH = false;
      l = PendantInfo.ebQ;
      this.this$0.mCurFrameIndex = 0;
      this.this$0.mRepeatCount = 3;
    }
    for (;;)
    {
      if (this.this$0.mRepeatCount == 0)
      {
        this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$a = null;
        return;
        label435:
        localBitmap.recycle();
        this.this$0.dD = null;
        break label217;
        label451:
        paramMessage = (Drawable)this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage == null) {
          break label329;
        }
        paramMessage.invalidateSelf();
        break label329;
      }
      this.this$0.mc(l);
      return;
      label489:
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PendantInfo", 2, "wrong type , msg.obj = " + paramMessage.obj.getClass());
      return;
      label527:
      if (paramMessage.what == 18)
      {
        if ((!this.this$0.mIsPause) && (this.this$0.ebX == 2) && (this.this$0.mRepeatCount > 0))
        {
          this.this$0.mc(paramMessage.getData().getLong("targetId"));
          return;
        }
        if ((this.this$0.mIsPause) || (this.this$0.ebX != 1)) {
          break;
        }
        this.this$0.eeZ();
        return;
      }
      if (paramMessage.what == 19)
      {
        l = paramMessage.getData().getLong("targetId");
        if (PendantInfo.ebQ == l)
        {
          paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
          while (paramMessage.hasNext())
          {
            localObject = (Drawable)paramMessage.next();
            if (localObject != null) {
              this.this$0.a((Drawable)localObject, true, 0L);
            }
          }
          break;
        }
        paramMessage = (Drawable)this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
        if (paramMessage == null) {
          break;
        }
        this.this$0.a(paramMessage, false, 0L);
        return;
      }
      if (paramMessage.what != 20) {
        break;
      }
      l = paramMessage.getData().getLong("targetId");
      if (PendantInfo.ebQ == l)
      {
        paramMessage = this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.values().iterator();
        while (paramMessage.hasNext())
        {
          localObject = (Drawable)paramMessage.next();
          if ((localObject != null) && ((localObject instanceof wnu))) {
            this.this$0.a((wnu)localObject, l);
          }
        }
        break;
      }
      paramMessage = (Drawable)this.this$0.jdField_a_of_type_ComTencentMobileqqVasPendantInfo$AnimationLruCache.get(Long.valueOf(l));
      if ((paramMessage == null) || (!(paramMessage instanceof wnu))) {
        break;
      }
      this.this$0.a((wnu)paramMessage, l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqql
 * JD-Core Version:    0.7.0.1
 */