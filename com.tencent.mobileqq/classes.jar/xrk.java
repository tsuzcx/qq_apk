import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class xrk
  extends xrh
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public xrk(xrl paramxrl, boolean paramBoolean1, int paramInt, xrj paramxrj, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramxrl, paramBoolean1, paramInt, paramxrj);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, xrl paramxrl, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramxrl.a(paramLong, 0);
    if (paramxrl.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramxrl.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramxrl.a()) && (i < 20))
    {
      long l5 = paramLong - paramxrl.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramxrl.a();
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
    paramxrl.a(l1, 0);
    while (paramxrl.a() != l1) {
      paramxrl.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramxrl.a());
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
  
  protected xri a(xro paramxro, long paramLong, xrl paramxrl, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    xri localxri2 = super.a(paramxro, paramLong, paramxrl, paramMediaCodec);
    if (localxri2 == null)
    {
      paramxro = null;
      return paramxro;
    }
    xri localxri1;
    if ((paramxro.b() == 3) || (paramxro.b() == 2) || (paramxro.b() == 0) || (paramxro.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localxri2.jdField_a_of_type_Long);
      paramLong = l2;
      localxri1 = localxri2;
    }
    for (;;)
    {
      paramxro = localxri1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localxri1;
      if (paramxro.b() == 6)
      {
        a(localxri2, false);
        a(paramLong, paramxrl, paramMediaCodec);
        paramxrl = a(true, true);
        if (paramxrl == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramxrl.jdField_a_of_type_Long);
        paramxro = paramxrl;
        if (paramxrl.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramxrl;
      }
      if (paramxro.b() != 4)
      {
        localxri1 = localxri2;
        paramLong = l2;
        if (paramxro.b() != 5) {}
      }
      else
      {
        paramLong = localxri2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localxri1 = localxri2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localxri1.jdField_a_of_type_Long / 1000L;
          }
          if (localxri1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localxri1, false);
            return a(paramxro, l2, paramxrl, paramMediaCodec);
          }
          l2 = localxri1.jdField_a_of_type_Long;
          a(localxri1, false);
          localxri1 = a(true, true);
          if (localxri1 == null) {
            return null;
          }
          paramLong = localxri1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localxri1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramxro.b() == 5) && (paramLong > l1))
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
            a(localxri1, false);
            return a(paramxro, l2, paramxrl, paramMediaCodec);
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
  public void a(xri paramxri, long paramLong)
  {
    a(paramxri, true);
  }
  
  public void a(xri paramxri, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramxri.jdField_a_of_type_Int, paramBoolean);
    c(paramxri);
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
 * Qualified Name:     xrk
 * JD-Core Version:    0.7.0.1
 */