import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class xll
  extends xli
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public xll(xlm paramxlm, boolean paramBoolean1, int paramInt, xlk paramxlk, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramxlm, paramBoolean1, paramInt, paramxlk);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, xlm paramxlm, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramxlm.a(paramLong, 0);
    if (paramxlm.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramxlm.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramxlm.a()) && (i < 20))
    {
      long l5 = paramLong - paramxlm.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramxlm.a();
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
    paramxlm.a(l1, 0);
    while (paramxlm.a() != l1) {
      paramxlm.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramxlm.a());
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
  
  protected xlj a(xlp paramxlp, long paramLong, xlm paramxlm, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    xlj localxlj2 = super.a(paramxlp, paramLong, paramxlm, paramMediaCodec);
    if (localxlj2 == null)
    {
      paramxlp = null;
      return paramxlp;
    }
    xlj localxlj1;
    if ((paramxlp.b() == 3) || (paramxlp.b() == 2) || (paramxlp.b() == 0) || (paramxlp.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localxlj2.jdField_a_of_type_Long);
      paramLong = l2;
      localxlj1 = localxlj2;
    }
    for (;;)
    {
      paramxlp = localxlj1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localxlj1;
      if (paramxlp.b() == 6)
      {
        a(localxlj2, false);
        a(paramLong, paramxlm, paramMediaCodec);
        paramxlm = a(true, true);
        if (paramxlm == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramxlm.jdField_a_of_type_Long);
        paramxlp = paramxlm;
        if (paramxlm.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramxlm;
      }
      if (paramxlp.b() != 4)
      {
        localxlj1 = localxlj2;
        paramLong = l2;
        if (paramxlp.b() != 5) {}
      }
      else
      {
        paramLong = localxlj2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localxlj1 = localxlj2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localxlj1.jdField_a_of_type_Long / 1000L;
          }
          if (localxlj1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localxlj1, false);
            return a(paramxlp, l2, paramxlm, paramMediaCodec);
          }
          l2 = localxlj1.jdField_a_of_type_Long;
          a(localxlj1, false);
          localxlj1 = a(true, true);
          if (localxlj1 == null) {
            return null;
          }
          paramLong = localxlj1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localxlj1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramxlp.b() == 5) && (paramLong > l1))
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
            a(localxlj1, false);
            return a(paramxlp, l2, paramxlm, paramMediaCodec);
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
  public void a(xlj paramxlj, long paramLong)
  {
    a(paramxlj, true);
  }
  
  public void a(xlj paramxlj, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramxlj.jdField_a_of_type_Int, paramBoolean);
    c(paramxlj);
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
 * Qualified Name:     xll
 * JD-Core Version:    0.7.0.1
 */