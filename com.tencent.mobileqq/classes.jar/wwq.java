import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class wwq
  extends wwn
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public wwq(wwr paramwwr, boolean paramBoolean1, int paramInt, wwp paramwwp, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramwwr, paramBoolean1, paramInt, paramwwp);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, wwr paramwwr, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramwwr.a(paramLong, 0);
    if (paramwwr.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramwwr.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramwwr.a()) && (i < 20))
    {
      long l5 = paramLong - paramwwr.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramwwr.a();
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
    paramwwr.a(l1, 0);
    while (paramwwr.a() != l1) {
      paramwwr.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramwwr.a());
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
  
  protected wwo a(wwu paramwwu, long paramLong, wwr paramwwr, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    wwo localwwo2 = super.a(paramwwu, paramLong, paramwwr, paramMediaCodec);
    if (localwwo2 == null)
    {
      paramwwu = null;
      return paramwwu;
    }
    wwo localwwo1;
    if ((paramwwu.b() == 3) || (paramwwu.b() == 2) || (paramwwu.b() == 0) || (paramwwu.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localwwo2.jdField_a_of_type_Long);
      paramLong = l2;
      localwwo1 = localwwo2;
    }
    for (;;)
    {
      paramwwu = localwwo1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localwwo1;
      if (paramwwu.b() == 6)
      {
        a(localwwo2, false);
        a(paramLong, paramwwr, paramMediaCodec);
        paramwwr = a(true, true);
        if (paramwwr == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramwwr.jdField_a_of_type_Long);
        paramwwu = paramwwr;
        if (paramwwr.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramwwr;
      }
      if (paramwwu.b() != 4)
      {
        localwwo1 = localwwo2;
        paramLong = l2;
        if (paramwwu.b() != 5) {}
      }
      else
      {
        paramLong = localwwo2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localwwo1 = localwwo2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localwwo1.jdField_a_of_type_Long / 1000L;
          }
          if (localwwo1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localwwo1, false);
            return a(paramwwu, l2, paramwwr, paramMediaCodec);
          }
          l2 = localwwo1.jdField_a_of_type_Long;
          a(localwwo1, false);
          localwwo1 = a(true, true);
          if (localwwo1 == null) {
            return null;
          }
          paramLong = localwwo1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localwwo1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramwwu.b() == 5) && (paramLong > l1))
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
            a(localwwo1, false);
            return a(paramwwu, l2, paramwwr, paramMediaCodec);
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
  public void a(wwo paramwwo, long paramLong)
  {
    a(paramwwo, true);
  }
  
  public void a(wwo paramwwo, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramwwo.jdField_a_of_type_Int, paramBoolean);
    c(paramwwo);
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
 * Qualified Name:     wwq
 * JD-Core Version:    0.7.0.1
 */