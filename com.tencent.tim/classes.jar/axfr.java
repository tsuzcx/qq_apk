import android.content.Context;
import android.graphics.PointF;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.qphone.base.util.QLog;
import com.tencent.ttpic.baseutils.device.DeviceUtils;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.1;
import dov.com.qq.im.ae.gif.video.PngsCreateWorkingQueue.3;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Semaphore;

public class axfr
{
  private static String TAG = "PngsCreateWorkingQueue";
  private axfq jdField_a_of_type_Axfq = new axfq();
  private axfr.a jdField_a_of_type_Axfr$a;
  private axft jdField_a_of_type_Axft;
  private Context context;
  private Handler handler;
  
  public axfr(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble, Context paramContext)
  {
    this.jdField_a_of_type_Axft = new axft(paramString, paramList, paramList1, paramDouble);
    paramString = new HandlerThread("PngsCreateWorkingQueue");
    paramString.start();
    this.handler = new Handler(paramString.getLooper());
    this.context = paramContext;
  }
  
  private void Wi()
  {
    Iterator localIterator = this.jdField_a_of_type_Axfq.FD.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      QLog.d(TAG, 4, "clear frame files, dir = " + str);
      aqhq.cn(str);
    }
  }
  
  private void b(axfp paramaxfp)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = "";
    Semaphore localSemaphore = new Semaphore(0);
    axdl.a locala = (axdl.a)axdl.colorList.get(axdl.tO[(paramaxfp.index % axdl.tO.length)]);
    float f1 = 0.81F;
    float f2 = 0.16F;
    if (paramaxfp.text.contains("\n"))
    {
      f1 = 0.67F;
      f2 = 0.3F;
    }
    int i;
    if (this.context != null)
    {
      j = (int)(DeviceUtils.getScreenWidth(this.context) * 0.44F) + 1;
      if (this.context == null) {
        break label242;
      }
      i = aqcx.dip2px(this.context, 2.0F) * 320 / j;
      label119:
      if (this.context == null) {
        break label248;
      }
    }
    label242:
    label248:
    for (int j = aqcx.sp2px(this.context, 23.0F) * 320 / j;; j = 19)
    {
      this.jdField_a_of_type_Axft.a(paramaxfp.text, j, locala.textColor, locala.cTQ, i, 0.0F, f1, 1.0F, f2);
      this.jdField_a_of_type_Axft.acp(paramaxfp.materialPath);
      this.jdField_a_of_type_Axft.a(new axfs(this, paramaxfp, arrayOfString, localSemaphore));
      try
      {
        localSemaphore.acquire();
        if (this.jdField_a_of_type_Axfr$a != null) {
          this.jdField_a_of_type_Axfr$a.onComplete(paramaxfp.index, arrayOfString[0]);
        }
        return;
      }
      catch (InterruptedException paramaxfp)
      {
        paramaxfp.printStackTrace();
      }
      j = 1920;
      break;
      i = 5;
      break label119;
    }
  }
  
  public axfq a()
  {
    return this.jdField_a_of_type_Axfq;
  }
  
  public void a(axfp paramaxfp)
  {
    this.handler.post(new PngsCreateWorkingQueue.1(this, paramaxfp));
  }
  
  public void a(axfr.a parama)
  {
    this.jdField_a_of_type_Axfr$a = parama;
  }
  
  public void stop(boolean paramBoolean)
  {
    QLog.d(TAG, 4, "stop, clearFiles = " + paramBoolean);
    this.handler.removeCallbacksAndMessages(null);
    this.handler.post(new PngsCreateWorkingQueue.3(this, paramBoolean));
    this.context = null;
  }
  
  public static abstract interface a
  {
    public abstract void onComplete(int paramInt, String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfr
 * JD-Core Version:    0.7.0.1
 */