import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class uey
  extends uev
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public uey(uez paramuez, boolean paramBoolean1, int paramInt, uex paramuex, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramuez, paramBoolean1, paramInt, paramuex);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, uez paramuez, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramuez.a(paramLong, 0);
    if (paramuez.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramuez.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramuez.a()) && (i < 20))
    {
      long l5 = paramLong - paramuez.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramuez.a();
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
    paramuez.a(l1, 0);
    while (paramuez.a() != l1) {
      paramuez.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramuez.a());
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
  
  protected uew a(ufc paramufc, long paramLong, uez paramuez, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    uew localuew2 = super.a(paramufc, paramLong, paramuez, paramMediaCodec);
    if (localuew2 == null)
    {
      paramufc = null;
      return paramufc;
    }
    uew localuew1;
    if ((paramufc.b() == 3) || (paramufc.b() == 2) || (paramufc.b() == 0) || (paramufc.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localuew2.jdField_a_of_type_Long);
      paramLong = l2;
      localuew1 = localuew2;
    }
    for (;;)
    {
      paramufc = localuew1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localuew1;
      if (paramufc.b() == 6)
      {
        a(localuew2, false);
        a(paramLong, paramuez, paramMediaCodec);
        paramuez = a(true, true);
        if (paramuez == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramuez.jdField_a_of_type_Long);
        paramufc = paramuez;
        if (paramuez.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramuez;
      }
      if (paramufc.b() != 4)
      {
        localuew1 = localuew2;
        paramLong = l2;
        if (paramufc.b() != 5) {}
      }
      else
      {
        paramLong = localuew2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localuew1 = localuew2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localuew1.jdField_a_of_type_Long / 1000L;
          }
          if (localuew1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localuew1, false);
            return a(paramufc, l2, paramuez, paramMediaCodec);
          }
          l2 = localuew1.jdField_a_of_type_Long;
          a(localuew1, false);
          localuew1 = a(true, true);
          if (localuew1 == null) {
            return null;
          }
          paramLong = localuew1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localuew1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramufc.b() == 5) && (paramLong > l1))
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
            a(localuew1, false);
            return a(paramufc, l2, paramuez, paramMediaCodec);
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
  public void a(uew paramuew, long paramLong)
  {
    a(paramuew, true);
  }
  
  public void a(uew paramuew, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramuew.jdField_a_of_type_Int, paramBoolean);
    c(paramuew);
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
 * Qualified Name:     uey
 * JD-Core Version:    0.7.0.1
 */