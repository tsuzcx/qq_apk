import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class vtq
  extends vtn
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public vtq(vtr paramvtr, boolean paramBoolean1, int paramInt, vtp paramvtp, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramvtr, paramBoolean1, paramInt, paramvtp);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, vtr paramvtr, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramvtr.a(paramLong, 0);
    if (paramvtr.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramvtr.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramvtr.a()) && (i < 20))
    {
      long l5 = paramLong - paramvtr.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramvtr.a();
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
    paramvtr.a(l1, 0);
    while (paramvtr.a() != l1) {
      paramvtr.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramvtr.a());
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
  
  protected vto a(vtu paramvtu, long paramLong, vtr paramvtr, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    vto localvto2 = super.a(paramvtu, paramLong, paramvtr, paramMediaCodec);
    if (localvto2 == null)
    {
      paramvtu = null;
      return paramvtu;
    }
    vto localvto1;
    if ((paramvtu.b() == 3) || (paramvtu.b() == 2) || (paramvtu.b() == 0) || (paramvtu.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localvto2.jdField_a_of_type_Long);
      paramLong = l2;
      localvto1 = localvto2;
    }
    for (;;)
    {
      paramvtu = localvto1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localvto1;
      if (paramvtu.b() == 6)
      {
        a(localvto2, false);
        a(paramLong, paramvtr, paramMediaCodec);
        paramvtr = a(true, true);
        if (paramvtr == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramvtr.jdField_a_of_type_Long);
        paramvtu = paramvtr;
        if (paramvtr.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramvtr;
      }
      if (paramvtu.b() != 4)
      {
        localvto1 = localvto2;
        paramLong = l2;
        if (paramvtu.b() != 5) {}
      }
      else
      {
        paramLong = localvto2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localvto1 = localvto2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localvto1.jdField_a_of_type_Long / 1000L;
          }
          if (localvto1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localvto1, false);
            return a(paramvtu, l2, paramvtr, paramMediaCodec);
          }
          l2 = localvto1.jdField_a_of_type_Long;
          a(localvto1, false);
          localvto1 = a(true, true);
          if (localvto1 == null) {
            return null;
          }
          paramLong = localvto1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localvto1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramvtu.b() == 5) && (paramLong > l1))
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
            a(localvto1, false);
            return a(paramvtu, l2, paramvtr, paramMediaCodec);
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
  public void a(vto paramvto, long paramLong)
  {
    a(paramvto, true);
  }
  
  public void a(vto paramvto, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramvto.jdField_a_of_type_Int, paramBoolean);
    c(paramvto);
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
 * Qualified Name:     vtq
 * JD-Core Version:    0.7.0.1
 */