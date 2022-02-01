import com.tencent.gdtad.aditem.GdtAd;
import com.tencent.gdtad.views.video.GdtVideoData;

public class tmn
{
  private int playScene = -1;
  private long startPositionMillis = -1L;
  
  public tmn(int paramInt)
  {
    this.playScene = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong)
  {
    if (paramGdtVideoData == null)
    {
      tkw.e("GdtVideoStatistics", "return data == null error");
      return;
    }
    if ((this.startPositionMillis == -1L) || (paramLong == 0L))
    {
      tkw.e("GdtVideoStatistics", "return startPositionMillis =-1");
      return;
    }
    if (this.startPositionMillis > paramLong)
    {
      tkw.e("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
      this.startPositionMillis = 0L;
    }
    long l = this.startPositionMillis;
    if (paramLong == paramGdtVideoData.getDurationMillis()) {}
    for (boolean bool = true;; bool = false)
    {
      String str = tle.a(l, paramLong, bool, this.playScene);
      tkw.i("GdtVideoStatistics", "report start:" + this.startPositionMillis + " end:" + paramLong);
      tle.a((GdtAd)paramGdtVideoData.getAd(), str);
      this.startPositionMillis = -1L;
      return;
    }
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    this.startPositionMillis = paramLong;
    tkw.i("GdtVideoStatistics", "onStarted start:" + this.startPositionMillis);
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong)
  {
    tkw.i("GdtVideoStatistics", "onStopped start:" + this.startPositionMillis + " end:" + paramLong);
    c(paramGdtVideoData, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tmn
 * JD-Core Version:    0.7.0.1
 */