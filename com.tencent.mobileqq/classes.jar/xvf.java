import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class xvf
  extends xvc
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public xvf(xvg paramxvg, boolean paramBoolean1, int paramInt, xve paramxve, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramxvg, paramBoolean1, paramInt, paramxve);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, xvg paramxvg, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramxvg.a(paramLong, 0);
    if (paramxvg.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramxvg.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramxvg.a()) && (i < 20))
    {
      long l5 = paramLong - paramxvg.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramxvg.a();
          l4 = l5;
        }
      }
      l3 = l4;
      l1 = l2;
      if (l5 < 0L)
      {
        i += 1;
        l3 = l4;
        l1 = l2;
      }
    }
    paramxvg.a(l1, 0);
    while (paramxvg.a() != l1) {
      paramxvg.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramxvg.a());
    return l1;
  }
  
  public int a()
  {
    MediaFormat localMediaFormat = a();
    if (localMediaFormat != null)
    {
      float f = localMediaFormat.getInteger("height");
      return (int)(localMediaFormat.getFloat("mpx-dar") * f);
    }
    return 0;
  }
  
  protected xvd a(xvj paramxvj, long paramLong, xvg paramxvg, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    xvd localxvd2 = super.a(paramxvj, paramLong, paramxvg, paramMediaCodec);
    if (localxvd2 == null)
    {
      paramxvj = null;
      return paramxvj;
    }
    xvd localxvd1;
    if ((paramxvj.b() == 3) || (paramxvj.b() == 2) || (paramxvj.b() == 0) || (paramxvj.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localxvd2.jdField_a_of_type_Long);
      paramLong = l2;
      localxvd1 = localxvd2;
    }
    for (;;)
    {
      paramxvj = localxvd1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localxvd1;
      if (paramxvj.b() == 6)
      {
        a(localxvd2, false);
        a(paramLong, paramxvg, paramMediaCodec);
        paramxvg = a(true, true);
        if (paramxvg == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramxvg.jdField_a_of_type_Long);
        paramxvj = paramxvg;
        if (paramxvg.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramxvg;
      }
      if (paramxvj.b() != 4)
      {
        localxvd1 = localxvd2;
        paramLong = l2;
        if (paramxvj.b() != 5) {}
      }
      else
      {
        paramLong = localxvd2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localxvd1 = localxvd2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localxvd1.jdField_a_of_type_Long / 1000L;
          }
          if (localxvd1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localxvd1, false);
            return a(paramxvj, l2, paramxvg, paramMediaCodec);
          }
          l2 = localxvd1.jdField_a_of_type_Long;
          a(localxvd1, false);
          localxvd1 = a(true, true);
          if (localxvd1 == null) {
            return null;
          }
          paramLong = localxvd1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localxvd1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramxvj.b() == 5) && (paramLong > l1))
        {
          if (i == 0)
          {
            Log.w(this.jdField_a_of_type_JavaLangString, "this should never happen");
            l2 = paramLong;
            paramLong = l1;
            l1 = l2;
          }
          else
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "exact seek: repeat seek for previous frame at " + l2);
            a(localxvd1, false);
            return a(paramxvj, l2, paramxvg, paramMediaCodec);
          }
        }
        else
        {
          l2 = paramLong;
          paramLong = l1;
          l1 = l2;
        }
      }
    }
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, this.jdField_a_of_type_AndroidViewSurface, null, 0);
  }
  
  public void a(Surface paramSurface)
  {
    if (paramSurface == null) {
      throw new RuntimeException("surface must not be null");
    }
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    a();
  }
  
  @SuppressLint({"NewApi"})
  public void a(xvd paramxvd, long paramLong)
  {
    a(paramxvd, true);
  }
  
  public void a(xvd paramxvd, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramxvd.jdField_a_of_type_Int, paramBoolean);
    c(paramxvd);
  }
  
  public int b()
  {
    MediaFormat localMediaFormat = a();
    if (localMediaFormat != null) {
      return localMediaFormat.getInteger("height");
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvf
 * JD-Core Version:    0.7.0.1
 */