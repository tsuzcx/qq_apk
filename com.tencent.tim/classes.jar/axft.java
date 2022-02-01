import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.graphics.SurfaceTexture.OnFrameAvailableListener;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.view.RendererUtils;
import dov.com.qq.im.ae.gif.video.PngsCreator.1;
import dov.com.qq.im.ae.gif.video.PngsCreator.2;
import dov.com.qq.im.ae.gif.video.PngsCreator.3;
import dov.com.qq.im.ae.gif.video.PngsCreator.4;
import dov.com.qq.im.ae.gif.video.PngsCreator.5;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class axft
{
  private static String TAG = axft.class.getSimpleName();
  private axft.a jdField_a_of_type_Axft$a;
  private axfv jdField_a_of_type_Axfv;
  private List<List<float[]>> allFaceAngles;
  private List<List<List<PointF>>> allFacePoints;
  private axdh b = new axdh();
  private String cUd;
  private int count;
  private int decodeTexture;
  private double faceDetectScale = 1.0D;
  private BaseFilter g = new SurfaceTextureFilter();
  private Handler handler;
  private Frame n = new Frame();
  private long startTimestamp;
  private SurfaceTexture surfaceTexture;
  
  public axft(String paramString, List<List<List<PointF>>> paramList, List<List<float[]>> paramList1, double paramDouble)
  {
    this.allFacePoints = paramList;
    this.allFaceAngles = paramList1;
    this.faceDetectScale = paramDouble;
    paramList = new HandlerThread("PngCreatorHT");
    paramList.start();
    this.handler = new Handler(paramList.getLooper());
    this.handler.post(new PngsCreator.1(this, paramString));
  }
  
  public void a(axft.a parama)
  {
    this.startTimestamp = System.currentTimeMillis();
    this.cUd = (awtn.c.a.cSV + File.separator + System.currentTimeMillis());
    try
    {
      new File(this.cUd).mkdirs();
      QLog.d(TAG, 4, new Object[] { "pngDir = ", this.cUd });
      this.jdField_a_of_type_Axft$a = parama;
      this.handler.post(new PngsCreator.2(this));
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
  }
  
  public void a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.handler.post(new PngsCreator.4(this, paramString1, paramInt1, paramString2, paramString3, paramInt2, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void acp(String paramString)
  {
    this.handler.post(new PngsCreator.3(this, paramString));
  }
  
  public void release()
  {
    this.count = 0;
    this.handler.post(new PngsCreator.5(this));
  }
  
  public static abstract interface a
  {
    public abstract void acx(String paramString);
  }
  
  public class b
    implements SurfaceTexture.OnFrameAvailableListener
  {
    public b() {}
    
    private List<float[]> bA(List<float[]> paramList)
    {
      LinkedList localLinkedList = new LinkedList();
      int k = paramList.size();
      int i = 0;
      while (i < k)
      {
        float[] arrayOfFloat1 = (float[])paramList.get(i);
        float[] arrayOfFloat2 = new float[arrayOfFloat1.length];
        int j = 0;
        while (j < arrayOfFloat1.length)
        {
          arrayOfFloat2[j] = arrayOfFloat1[j];
          j += 1;
        }
        localLinkedList.add(arrayOfFloat2);
        i += 1;
      }
      return localLinkedList;
    }
    
    private List<List<PointF>> bz(List<List<PointF>> paramList)
    {
      LinkedList localLinkedList1 = new LinkedList();
      int k = paramList.size();
      int i = 0;
      while (i < k)
      {
        List localList = (List)paramList.get(i);
        LinkedList localLinkedList2 = new LinkedList();
        int m = localList.size();
        int j = 0;
        while (j < m)
        {
          PointF localPointF = (PointF)localList.get(j);
          localLinkedList2.add(new PointF(localPointF.x, localPointF.y));
          j += 1;
        }
        localLinkedList1.add(localLinkedList2);
        i += 1;
      }
      return localLinkedList1;
    }
    
    @TargetApi(19)
    public void onFrameAvailable(SurfaceTexture paramSurfaceTexture)
    {
      QLog.d(axft.TAG, 4, "PngsCreator onFrameAvailable()");
      paramSurfaceTexture.updateTexImage();
      axft.a(axft.this).RenderProcess(axft.a(axft.this), 960, 480, -1, 0.0D, axft.a(axft.this));
      axft.a(axft.this).setFaceDetectScale(axft.a(axft.this));
      axdh localaxdh = axft.a(axft.this);
      Frame localFrame = axft.a(axft.this);
      if (axft.b(axft.this) < axft.a(axft.this).size())
      {
        paramSurfaceTexture = bz((List)axft.a(axft.this).get(axft.b(axft.this)));
        if (axft.b(axft.this) >= axft.b(axft.this).size()) {
          break label341;
        }
      }
      label341:
      for (Object localObject = bA((List)axft.b(axft.this).get(axft.b(axft.this)));; localObject = new ArrayList())
      {
        paramSurfaceTexture = RendererUtils.saveTexture(localaxdh.a(localFrame, 480, 480, paramSurfaceTexture, (List)localObject));
        paramSurfaceTexture.setPremultiplied(false);
        awtg.H(String.format(axft.a(axft.this) + "/frame_%03d.png", new Object[] { Integer.valueOf(axft.b(axft.this)) }), paramSurfaceTexture);
        paramSurfaceTexture.recycle();
        axft.c(axft.this);
        if (!axft.a(axft.this).aOw())
        {
          QLog.d(axft.TAG, 4, "pngs create duration = " + (System.currentTimeMillis() - axft.a(axft.this)));
          axft.a(axft.this).acx(axft.a(axft.this));
        }
        return;
        paramSurfaceTexture = new ArrayList();
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axft
 * JD-Core Version:    0.7.0.1
 */