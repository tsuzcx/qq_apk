import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.richmedia.mediacodec.decoder.flow.VideoFlowDecodeTask;

public class amab
{
  private VideoFlowDecodeTask a;
  private Thread decodeThread;
  private int threadIndex;
  
  public void a(alzj paramalzj, alzd paramalzd, alzk paramalzk)
  {
    Thread localThread;
    if (this.decodeThread != null)
    {
      ram.d("FlowEdit_VideoFlowDecoder", "stopDecode before startDecode, current thread : %s", this.decodeThread.getName());
      localThread = this.decodeThread;
      stopDecode();
    }
    try
    {
      localThread.join();
      ram.i("FlowEdit_VideoFlowDecoder", "startDecode, create decode runnable");
      this.a = new VideoFlowDecodeTask(paramalzj.inputFilePath, paramalzd, paramalzk);
      this.a.a(paramalzj);
      paramalzj = this.a;
      paramalzd = new StringBuilder().append("HWVideoDecoder-Thread-");
      int i = this.threadIndex;
      this.threadIndex = (i + 1);
      this.decodeThread = ThreadManager.newFreeThread(paramalzj, i, 8);
      this.decodeThread.start();
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
      for (;;)
      {
        localInterruptedException.printStackTrace();
      }
    }
  }
  
  public void pauseDecode()
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.a;
    if (localVideoFlowDecodeTask != null)
    {
      localVideoFlowDecodeTask.cuB = true;
      ram.d("FlowEdit_VideoFlowDecoder", "pauseDecode");
      return;
    }
    ram.w("FlowEdit_VideoFlowDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void resumeDecode()
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.a;
    if (localVideoFlowDecodeTask != null)
    {
      localVideoFlowDecodeTask.cuB = false;
      synchronized (localVideoFlowDecodeTask.pauseLock)
      {
        localVideoFlowDecodeTask.pauseLock.notifyAll();
        ram.d("FlowEdit_VideoFlowDecoder", "pauseDecode");
        return;
      }
    }
    ram.w("FlowEdit_VideoFlowDecoder", "pauseDecode failed, can not find DecodeRunnable");
  }
  
  public void setPlayRange(long paramLong1, long paramLong2)
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.a;
    if (localVideoFlowDecodeTask != null)
    {
      ram.w("FlowEdit_VideoFlowDecoder", "setPlayRange [" + paramLong1 + " ms, " + paramLong2 + " ms]");
      localVideoFlowDecodeTask.setPlayRange(paramLong1, paramLong2);
      return;
    }
    ram.w("FlowEdit_VideoFlowDecoder", "setPlayRange failed, can not find DecodeRunnable");
  }
  
  public void setSpeedType(int paramInt)
  {
    VideoFlowDecodeTask localVideoFlowDecodeTask = this.a;
    if (localVideoFlowDecodeTask != null)
    {
      localVideoFlowDecodeTask.setSpeedType(paramInt);
      ram.d("FlowEdit_VideoFlowDecoder", "setSpeedType:" + paramInt);
      return;
    }
    ram.w("FlowEdit_VideoFlowDecoder", "setSpeedType:" + paramInt + " failed, can not find DecodeRunnable");
  }
  
  public void stopDecode()
  {
    if (this.decodeThread != null) {
      this.decodeThread.interrupt();
    }
    this.decodeThread = null;
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amab
 * JD-Core Version:    0.7.0.1
 */