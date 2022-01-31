import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class tsf
  extends tsc
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public tsf(tsg paramtsg, boolean paramBoolean1, int paramInt, tse paramtse, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramtsg, paramBoolean1, paramInt, paramtse);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, tsg paramtsg, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramtsg.a(paramLong, 0);
    if (paramtsg.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramtsg.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramtsg.a()) && (i < 20))
    {
      long l5 = paramLong - paramtsg.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramtsg.a();
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
    paramtsg.a(l1, 0);
    while (paramtsg.a() != l1) {
      paramtsg.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramtsg.a());
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
  
  protected tsd a(tsj paramtsj, long paramLong, tsg paramtsg, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    tsd localtsd2 = super.a(paramtsj, paramLong, paramtsg, paramMediaCodec);
    if (localtsd2 == null)
    {
      paramtsj = null;
      return paramtsj;
    }
    tsd localtsd1;
    if ((paramtsj.b() == 3) || (paramtsj.b() == 2) || (paramtsj.b() == 0) || (paramtsj.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localtsd2.jdField_a_of_type_Long);
      paramLong = l2;
      localtsd1 = localtsd2;
    }
    for (;;)
    {
      paramtsj = localtsd1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localtsd1;
      if (paramtsj.b() == 6)
      {
        a(localtsd2, false);
        a(paramLong, paramtsg, paramMediaCodec);
        paramtsg = a(true, true);
        if (paramtsg == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramtsg.jdField_a_of_type_Long);
        paramtsj = paramtsg;
        if (paramtsg.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramtsg;
      }
      if (paramtsj.b() != 4)
      {
        localtsd1 = localtsd2;
        paramLong = l2;
        if (paramtsj.b() != 5) {}
      }
      else
      {
        paramLong = localtsd2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localtsd1 = localtsd2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localtsd1.jdField_a_of_type_Long / 1000L;
          }
          if (localtsd1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localtsd1, false);
            return a(paramtsj, l2, paramtsg, paramMediaCodec);
          }
          l2 = localtsd1.jdField_a_of_type_Long;
          a(localtsd1, false);
          localtsd1 = a(true, true);
          if (localtsd1 == null) {
            return null;
          }
          paramLong = localtsd1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localtsd1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramtsj.b() == 5) && (paramLong > l1))
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
            a(localtsd1, false);
            return a(paramtsj, l2, paramtsg, paramMediaCodec);
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
  public void a(tsd paramtsd, long paramLong)
  {
    a(paramtsd, true);
  }
  
  public void a(tsd paramtsd, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramtsd.jdField_a_of_type_Int, paramBoolean);
    c(paramtsd);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tsf
 * JD-Core Version:    0.7.0.1
 */