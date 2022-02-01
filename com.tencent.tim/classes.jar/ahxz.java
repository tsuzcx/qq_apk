import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.etrump.mixlayout.EMEmoticon;
import com.etrump.mixlayout.ETEngine;
import com.etrump.mixlayout.ETFont;
import com.tencent.commonsdk.cache.QQLruCache;
import com.tencent.mobileqq.hiboom.HiBoomTextView;
import com.tencent.mobileqq.hiboom.HiBoomTextView.b;
import com.tencent.mobileqq.hiboom.HiBoomTextView.c;
import java.lang.ref.WeakReference;

public final class ahxz
  extends Handler
{
  public ahxz(Looper paramLooper)
  {
    super(paramLooper);
  }
  
  public void handleMessage(Message arg1)
  {
    HiBoomTextView.b localb;
    int i;
    ETEngine localETEngine;
    Object localObject1;
    switch (???.what)
    {
    case 259: 
    default: 
    case 258: 
      do
      {
        do
        {
          return;
          localb = (HiBoomTextView.b)???.obj;
        } while (localb == null);
        i = HiBoomTextView.b.a(localb).getWidth();
        int j = HiBoomTextView.b.a(localb).getHeight();
        if ((HiBoomTextView.aw() != null) && ((HiBoomTextView.aw().getWidth() < i) || (HiBoomTextView.aw().getHeight() < j)))
        {
          HiBoomTextView.aw().recycle();
          HiBoomTextView.I(null);
        }
        if (HiBoomTextView.aw() != null) {
          break;
        }
        HiBoomTextView.I(Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_8888));
        localETEngine = ahxo.a().f;
        String str = HiBoomTextView.b.a(localb) + HiBoomTextView.b.a(localb).getId() + HiBoomTextView.b.a(localb) + HiBoomTextView.b.a(localb).getSize();
        localObject1 = (EMEmoticon)HiBoomTextView.a().get(str);
        ??? = (Message)localObject1;
        if (localObject1 == null)
        {
          localObject1 = EMEmoticon.createEmoticon(localETEngine, HiBoomTextView.b.a(localb), HiBoomTextView.b.a(localb), HiBoomTextView.b.a(localb));
          ??? = (Message)localObject1;
          if (localObject1 != null)
          {
            HiBoomTextView.a().put(str, localObject1);
            ??? = (Message)localObject1;
          }
        }
      } while (??? == null);
      ???.gotoFrame(HiBoomTextView.b.b(localb));
      ???.drawFrame(HiBoomTextView.aw());
      localObject1 = HiBoomTextView.b.a(localb);
      if (HiBoomTextView.b.a(localb).get() == null) {
        break;
      }
    }
    for (;;)
    {
      synchronized (((HiBoomTextView)HiBoomTextView.b.a(localb).get()).jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$a)
      {
        if ((((Bitmap)localObject1).isRecycled()) || (HiBoomTextView.a((HiBoomTextView)HiBoomTextView.b.a(localb).get()) != HiBoomTextView.b.a(localb))) {
          break label417;
        }
        ((Bitmap)localObject1).eraseColor(0);
        localETEngine.native_cloneBitmap(HiBoomTextView.aw(), (Bitmap)localObject1);
        i = 1;
        if (i == 0) {
          break;
        }
        new Message().what = 259;
        HiBoomTextView.jdField_a_of_type_ComTencentMobileqqHiboomHiBoomTextView$c.obtainMessage(259, localb).sendToTarget();
        return;
        HiBoomTextView.aw().eraseColor(0);
      }
      if (HiBoomTextView.aw() == null) {
        break;
      }
      HiBoomTextView.aw().recycle();
      HiBoomTextView.I(null);
      return;
      label417:
      i = 0;
      continue;
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahxz
 * JD-Core Version:    0.7.0.1
 */