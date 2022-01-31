import com.tencent.gdtad.views.video.GdtVideoData;

public class zbk
{
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = -1L;
  
  public zbk(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  private void c(GdtVideoData paramGdtVideoData, long paramLong)
  {
    if (paramGdtVideoData == null)
    {
      yxp.d("GdtVideoStatistics", "return data == null error");
      return;
    }
    if ((this.jdField_a_of_type_Long == -1L) || (paramLong == 0L))
    {
      yxp.d("GdtVideoStatistics", "return startPositionMillis =-1");
      return;
    }
    if (this.jdField_a_of_type_Long > paramLong)
    {
      yxp.d("GdtVideoStatistics", "startPositionMillis > currentPositionMillis reset startPositionMillis = 0");
      this.jdField_a_of_type_Long = 0L;
    }
    long l = this.jdField_a_of_type_Long;
    if (paramLong == paramGdtVideoData.getDurationMillis()) {}
    for (boolean bool = true;; bool = false)
    {
      String str = yya.a(l, paramLong, bool, this.jdField_a_of_type_Int);
      yxp.b("GdtVideoStatistics", "report start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
      yya.a(paramGdtVideoData.getAd(), str);
      this.jdField_a_of_type_Long = -1L;
      return;
    }
  }
  
  public void a(GdtVideoData paramGdtVideoData)
  {
    yxp.b("GdtVideoStatistics", "onError");
    c(paramGdtVideoData, -1L);
  }
  
  public void a(GdtVideoData paramGdtVideoData, long paramLong)
  {
    this.jdField_a_of_type_Long = paramLong;
    yxp.b("GdtVideoStatistics", "onStarted start:" + this.jdField_a_of_type_Long);
  }
  
  public void b(GdtVideoData paramGdtVideoData)
  {
    yxp.b("GdtVideoStatistics", "onCompleted start:" + this.jdField_a_of_type_Long);
    if (paramGdtVideoData == null) {}
    do
    {
      return;
      c(paramGdtVideoData, paramGdtVideoData.getDurationMillis());
    } while (!paramGdtVideoData.isLoop());
    this.jdField_a_of_type_Long = 0L;
  }
  
  public void b(GdtVideoData paramGdtVideoData, long paramLong)
  {
    yxp.b("GdtVideoStatistics", "onStopped start:" + this.jdField_a_of_type_Long + " end:" + paramLong);
    c(paramGdtVideoData, paramLong);
  }
  
  public void c(GdtVideoData paramGdtVideoData)
  {
    if (paramGdtVideoData == null)
    {
      yxp.d("GdtVideoStatistics", "805 reportLoadError data == null return");
      return;
    }
    yxp.b("GdtVideoStatistics", "reportLoadError:" + paramGdtVideoData.getPlayScene());
    String str = yya.a(paramGdtVideoData.getPlayScene());
    yya.a(paramGdtVideoData.getAd(), str);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     zbk
 * JD-Core Version:    0.7.0.1
 */