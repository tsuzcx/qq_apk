import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class vxz
  extends vxw
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public vxz(vya paramvya, boolean paramBoolean1, int paramInt, vxy paramvxy, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramvya, paramBoolean1, paramInt, paramvxy);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, vya paramvya, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramvya.a(paramLong, 0);
    if (paramvya.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramvya.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramvya.a()) && (i < 20))
    {
      long l5 = paramLong - paramvya.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramvya.a();
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
    paramvya.a(l1, 0);
    while (paramvya.a() != l1) {
      paramvya.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramvya.a());
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
  
  protected vxx a(vyd paramvyd, long paramLong, vya paramvya, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    vxx localvxx2 = super.a(paramvyd, paramLong, paramvya, paramMediaCodec);
    if (localvxx2 == null)
    {
      paramvyd = null;
      return paramvyd;
    }
    vxx localvxx1;
    if ((paramvyd.b() == 3) || (paramvyd.b() == 2) || (paramvyd.b() == 0) || (paramvyd.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localvxx2.jdField_a_of_type_Long);
      paramLong = l2;
      localvxx1 = localvxx2;
    }
    for (;;)
    {
      paramvyd = localvxx1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localvxx1;
      if (paramvyd.b() == 6)
      {
        a(localvxx2, false);
        a(paramLong, paramvya, paramMediaCodec);
        paramvya = a(true, true);
        if (paramvya == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramvya.jdField_a_of_type_Long);
        paramvyd = paramvya;
        if (paramvya.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramvya;
      }
      if (paramvyd.b() != 4)
      {
        localvxx1 = localvxx2;
        paramLong = l2;
        if (paramvyd.b() != 5) {}
      }
      else
      {
        paramLong = localvxx2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localvxx1 = localvxx2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localvxx1.jdField_a_of_type_Long / 1000L;
          }
          if (localvxx1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localvxx1, false);
            return a(paramvyd, l2, paramvya, paramMediaCodec);
          }
          l2 = localvxx1.jdField_a_of_type_Long;
          a(localvxx1, false);
          localvxx1 = a(true, true);
          if (localvxx1 == null) {
            return null;
          }
          paramLong = localvxx1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localvxx1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramvyd.b() == 5) && (paramLong > l1))
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
            a(localvxx1, false);
            return a(paramvyd, l2, paramvya, paramMediaCodec);
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
  public void a(vxx paramvxx, long paramLong)
  {
    a(paramvxx, true);
  }
  
  public void a(vxx paramvxx, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramvxx.jdField_a_of_type_Int, paramBoolean);
    c(paramvxx);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxz
 * JD-Core Version:    0.7.0.1
 */