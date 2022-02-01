import android.annotation.TargetApi;
import android.opengl.EGLContext;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.HandlerThread;
import android.os.Message;
import android.os.SystemClock;
import com.tencent.maxvideo.common.AVIOStruct;
import com.tencent.mobileqq.activity.richmedia.view.CameraFilterGLView.SharedMemWriteFile;
import com.tencent.mobileqq.shortvideo.hwcodec.SVHwEncoder;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreateContextException;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLCreatePbufferSurfaceException;
import com.tencent.mobileqq.shortvideo.util.OffScreenInputSurface.EGLMakeCurrentException;
import com.tencent.mobileqq.shortvideo.util.PtvFilterUtils;
import com.tencent.mobileqq.shortvideo.util.SVOpenglFlipFilter;
import com.tencent.mobileqq.shortvideo.util.SVOpenglFlipFilter.EGLCreateProgramException;
import com.tencent.qphone.base.util.QLog;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class anke
  implements Handler.Callback
{
  private HandlerThread X;
  public anke.b a;
  private SVOpenglFlipFilter a;
  private AtomicBoolean dL = new AtomicBoolean(false);
  private Handler mQueueHandler;
  
  public anke()
  {
    this.jdField_a_of_type_Anke$b = new anke.b();
  }
  
  @TargetApi(17)
  private anks.a a(anke.a parama, int paramInt)
  {
    anks.a locala = parama.jdField_b_of_type_Anks.a();
    if (locala == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[writeSharedMemtoFileDegree]memoryCache=null");
      }
      return null;
    }
    if (locala.p(parama.mVideoWidth, parama.mVideoHeight, parama.dIJ))
    {
      long l1 = SystemClock.elapsedRealtimeNanos();
      if (PtvFilterUtils.a(paramInt, parama.mVideoWidth, parama.mVideoHeight, parama.dIJ, locala.w, parama.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct) != 0)
      {
        locala.dRn();
        return null;
      }
      long l2 = SystemClock.elapsedRealtime();
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory= old time " + parama.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime + ", new time = " + l2 + ", diff=" + (l2 - parama.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime));
      }
      parama.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.vFrameTime = l2;
      l1 = (SystemClock.elapsedRealtimeNanos() - l1) / 1000L;
      if (QLog.isColorLevel()) {
        QLog.d("PtvFilterUtils", 2, "FilterProcessRender_showPreview[getPixelDataToSharedMemory=" + l1 + "us]");
      }
      return locala;
    }
    locala.dRn();
    return null;
  }
  
  public static CameraFilterGLView.SharedMemWriteFile a(anks.a parama)
  {
    if (parama.a == null) {
      parama.a = new CameraFilterGLView.SharedMemWriteFile();
    }
    return parama.a;
  }
  
  private void a(anke.a parama, anks.a parama1, int paramInt1, boolean paramBoolean, AVIOStruct paramAVIOStruct, int paramInt2, anir paramanir)
  {
    CameraFilterGLView.SharedMemWriteFile localSharedMemWriteFile = a(parama1);
    localSharedMemWriteFile.mVideoWidth = parama.mVideoWidth;
    localSharedMemWriteFile.mVideoHeight = parama.mVideoHeight;
    localSharedMemWriteFile.mDegree = paramInt1;
    localSharedMemWriteFile.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct = paramAVIOStruct;
    localSharedMemWriteFile.jdField_b_of_type_Anks$a = parama1;
    localSharedMemWriteFile.bAc = paramBoolean;
    localSharedMemWriteFile.bAd = parama.cHA;
    localSharedMemWriteFile.jdField_b_of_type_Anks = parama.jdField_b_of_type_Anks;
    localSharedMemWriteFile.jdField_b_of_type_ComTencentMobileqqActivityRichmediaViewCameraFilterGLView$a = null;
    localSharedMemWriteFile.mOrientationDegree = paramInt2;
    localSharedMemWriteFile.mEncodeRef = parama.mEncodeRef;
    localSharedMemWriteFile.jdField_a_of_type_Anir = paramanir;
    parama.jdField_b_of_type_Anks.aj(localSharedMemWriteFile);
  }
  
  public boolean axE()
  {
    return (this.dL.get()) && (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null);
  }
  
  public void dQZ()
  {
    if (this.X == null)
    {
      this.X = new HandlerThread("glAsyncPostThread");
      this.X.start();
      this.mQueueHandler = new Handler(this.X.getLooper(), this);
    }
  }
  
  public void dRa()
  {
    if (this.mQueueHandler != null) {
      this.mQueueHandler.removeCallbacksAndMessages(null);
    }
  }
  
  public void dRb()
  {
    if (this.X != null)
    {
      PtvFilterUtils.a(this.X);
      this.X = null;
      this.mQueueHandler = null;
    }
  }
  
  public boolean handleMessage(Message arg1)
  {
    switch (???.what)
    {
    }
    do
    {
      anks.a locala;
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return true;
                synchronized (this.jdField_a_of_type_Anke$b.mSync)
                {
                  if ((this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter != null) && (!this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.a(this.jdField_a_of_type_Anke$b.mVideoWidth, this.jdField_a_of_type_Anke$b.mVideoHeight, this.jdField_a_of_type_Anke$b.b)))
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.releaseContext();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("face", 2, "checkIsCanReusedPbuffer = false [release]");
                    }
                  }
                  if (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null)
                  {
                    this.dL.getAndSet(false);
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = new SVOpenglFlipFilter(this.jdField_a_of_type_Anke$b.mVideoWidth, this.jdField_a_of_type_Anke$b.mVideoHeight, this.jdField_a_of_type_Anke$b.b);
                  }
                }
                try
                {
                  this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.dRo();
                  this.dL.getAndSet(true);
                  return true;
                  localObject = finally;
                  throw localObject;
                }
                catch (OffScreenInputSurface.EGLMakeCurrentException localEGLMakeCurrentException)
                {
                  for (;;)
                  {
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLMakeCurrentException);
                    }
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.releaseContext();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                  }
                }
                catch (OffScreenInputSurface.EGLCreateContextException localEGLCreateContextException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLCreateContextException);
                    }
                  }
                }
                catch (OffScreenInputSurface.EGLCreatePbufferSurfaceException localEGLCreatePbufferSurfaceException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[initPbbufferSurfaceMakeCurrent]" + localEGLCreatePbufferSurfaceException);
                    }
                  }
                }
                catch (SVOpenglFlipFilter.EGLCreateProgramException localEGLCreateProgramException)
                {
                  for (;;)
                  {
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.releaseContext();
                    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
                    if (QLog.isColorLevel()) {
                      QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[EGLCreateProgramException]" + localEGLCreateProgramException);
                    }
                  }
                }
                ??? = (anke.a)???.obj;
                if (anit.cHa) {
                  break;
                }
              } while (!QLog.isColorLevel());
              QLog.d("PtvFilterUtils", 2, "PtvFilterUtils_onDrawFrame[FILTER_FLIP_GL_DRAW] ignore because stop capture, frame index = " + ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct.pFrameIndex);
              return true;
            } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
            if (???.mOrientation != 180) {
              break;
            }
            locala = a(???, ???.mTextureId);
          } while (locala == null);
          a(???, locala, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, 0, ???.jdField_a_of_type_Anir);
          return true;
          if ((!this.dL.get()) || (!anko.cHE)) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.bc(???.mTextureId, ???.mVideoWidth, ???.mVideoHeight);
          locala = a(???, 0);
        } while (locala == null);
        a(???, locala, 0, false, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.mOrientation, ???.jdField_a_of_type_Anir);
        return true;
        locala = a(???, ???.mTextureId);
      } while (locala == null);
      a(???, locala, 180, true, ???.jdField_a_of_type_ComTencentMaxvideoCommonAVIOStruct, ???.mOrientation, ???.jdField_a_of_type_Anir);
      return true;
      this.dL.getAndSet(false);
    } while (this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter == null);
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter.releaseContext();
    this.jdField_a_of_type_ComTencentMobileqqShortvideoUtilSVOpenglFlipFilter = null;
    return true;
  }
  
  public void sendMessage(Message paramMessage)
  {
    if (this.mQueueHandler != null) {
      this.mQueueHandler.sendMessage(paramMessage);
    }
  }
  
  public static class a
  {
    public anir a;
    public AVIOStruct a;
    public anks b;
    public boolean cHA;
    public int dIJ;
    public AtomicReference<SVHwEncoder> mEncodeRef;
    public int mOrientation;
    public int mTextureId;
    public int mVideoHeight;
    public int mVideoWidth;
  }
  
  public static class b
  {
    EGLContext b;
    Object mSync = new Object();
    int mVideoHeight;
    int mVideoWidth;
    
    public void a(EGLContext paramEGLContext, int paramInt1, int paramInt2)
    {
      synchronized (this.mSync)
      {
        this.b = paramEGLContext;
        this.mVideoWidth = paramInt1;
        this.mVideoHeight = paramInt2;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anke
 * JD-Core Version:    0.7.0.1
 */