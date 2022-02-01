import android.graphics.Bitmap;
import android.graphics.SurfaceTexture;
import android.os.Handler;
import android.os.HandlerThread;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.filter.BaseFilter;
import com.tencent.filter.SurfaceTextureFilter;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.1;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.2;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.3;
import dov.com.qq.im.ae.gif.video.VideoGIFCreator.4;
import dov.com.qq.im.video.GifEncoder;

public class axfx
{
  private static String TAG = axfn.class.getSimpleName();
  private axfl jdField_a_of_type_Axfl = new axfl();
  private axfw jdField_a_of_type_Axfw;
  private axfx.a jdField_a_of_type_Axfx$a;
  private axfx.b jdField_a_of_type_Axfx$b;
  private GifEncoder jdField_a_of_type_DovComQqImVideoGifEncoder = new GifEncoder();
  private BaseFilter d = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private int decodeTexture;
  private BaseFilter e = new BaseFilter("precision highp float;\nvarying vec2 textureCoordinate;\nuniform sampler2D inputImageTexture;\nvoid main() \n{\ngl_FragColor = texture2D (inputImageTexture, textureCoordinate);\n}\n");
  private BaseFilter g = new SurfaceTextureFilter();
  private int gifHeight = 380;
  private int gifWidth = 380;
  private Handler handler;
  private Frame n = new Frame();
  private SurfaceTexture surfaceTexture;
  
  public axfx(String paramString)
  {
    QLog.d(TAG, 4, "input video = " + paramString);
    HandlerThread localHandlerThread = new HandlerThread("GIFCreatorHT");
    localHandlerThread.start();
    this.handler = new Handler(localHandlerThread.getLooper());
    this.handler.post(new VideoGIFCreator.1(this, paramString));
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.handler.post(new VideoGIFCreator.2(this, paramBitmap, paramFloat1, paramFloat2, paramFloat3, paramFloat4));
  }
  
  public void a(axfx.a parama)
  {
    this.jdField_a_of_type_Axfx$a = parama;
    QLog.d(TAG, 4, "start create gif");
    this.handler.post(new VideoGIFCreator.3(this));
  }
  
  public void release()
  {
    this.handler.post(new VideoGIFCreator.4(this));
  }
  
  public static abstract interface a
  {
    public abstract void HS(String paramString);
    
    public abstract void cZr();
  }
  
  public class b
  {
    public int eED;
    public float height;
    public float width;
    public float x;
    public float y;
    
    public b() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axfx
 * JD-Core Version:    0.7.0.1
 */