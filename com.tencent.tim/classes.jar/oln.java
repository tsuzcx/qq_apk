import android.os.SystemClock;

public class oln
  implements oll
{
  private olm a = new olm();
  private boolean mHasReported;
  private long mStartPrepareTime;
  
  private void a(olm paramolm)
  {
    ooz.e("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onStop] mReportData:" + paramolm.toString());
    this.mHasReported = true;
    olo.b(paramolm);
  }
  
  public void a(olh paramolh, boolean paramBoolean)
  {
    this.a.aqk = paramolh.lz();
    this.a.yT = paramolh.getFileSize();
    this.a.vF = paramolh.getVideoBitRate();
    this.a.bfo = paramolh.rB();
    this.a.aVX = paramolh.qf();
    this.a.xf = paramolh.dd();
    this.a.aqp = paramolh.ky();
    this.a.yW = paramolh.df();
    this.a.yU = paramolh.dh();
    this.a.yV = paramolh.dg();
    this.a.vH = paramolh.dq();
    this.a.aqj = paramolh.lA();
    a(this.a);
  }
  
  public void b(String paramString1, boolean paramBoolean, String paramString2)
  {
    ooz.bY("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onOpenVideo] ==== start ====");
    this.mHasReported = false;
    if (!paramBoolean) {}
    for (long l = SystemClock.uptimeMillis();; l = 0L)
    {
      this.mStartPrepareTime = l;
      this.a.yc = paramString1;
      this.a.aqb = paramString2;
      this.a.axH = false;
      this.a.bfq = 0;
      this.a.bfr = 0;
      this.a.bfo = 0;
      this.a.yV = 0L;
      this.a.yU = 0L;
      this.a.aqp = "";
      this.a.mErrorCode = "";
      this.a.aqr = "";
      this.a.aqk = "";
      this.a.aqq = "";
      this.a.aqs = "";
      this.a.axI = false;
      return;
    }
  }
  
  public void b(olh paramolh) {}
  
  public void c(olh paramolh)
  {
    this.a.bfq = paramolh.getVideoWidth();
    this.a.bfr = paramolh.getVideoHeight();
  }
  
  public void pg(boolean paramBoolean)
  {
    ooz.bY("WS_VIDEO_REPORT", "[WSPlayerReportImpl.java][onHitPreload] loaded:" + paramBoolean);
    this.mStartPrepareTime = SystemClock.uptimeMillis();
    this.a.axH = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oln
 * JD-Core Version:    0.7.0.1
 */