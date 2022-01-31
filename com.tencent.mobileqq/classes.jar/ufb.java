import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;

@TargetApi(16)
public class ufb
  extends uey
{
  private Surface jdField_a_of_type_AndroidViewSurface;
  private boolean jdField_a_of_type_Boolean;
  
  public ufb(ufc paramufc, boolean paramBoolean1, int paramInt, ufa paramufa, Surface paramSurface, boolean paramBoolean2)
  {
    super(paramufc, paramBoolean1, paramInt, paramufa);
    this.jdField_a_of_type_AndroidViewSurface = paramSurface;
    this.jdField_a_of_type_Boolean = paramBoolean2;
    a();
  }
  
  @TargetApi(16)
  private long a(long paramLong, ufc paramufc, MediaCodec paramMediaCodec)
  {
    paramMediaCodec.flush();
    paramufc.a(paramLong, 0);
    if (paramufc.a() == paramLong)
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "skip fastseek, already there");
      return paramLong;
    }
    b();
    a(false);
    paramufc.a(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramufc.a()) && (i < 20))
    {
      long l5 = paramLong - paramufc.a();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramufc.a();
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
    paramufc.a(l1, 0);
    while (paramufc.a() != l1) {
      paramufc.a();
    }
    Log.d(this.jdField_a_of_type_JavaLangString, "exact fastseek match:       " + paramufc.a());
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
  
  protected uez a(uff paramuff, long paramLong, ufc paramufc, MediaCodec paramMediaCodec)
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    uez localuez2 = super.a(paramuff, paramLong, paramufc, paramMediaCodec);
    if (localuez2 == null)
    {
      paramuff = null;
      return paramuff;
    }
    uez localuez1;
    if ((paramuff.b() == 3) || (paramuff.b() == 2) || (paramuff.b() == 0) || (paramuff.b() == 1))
    {
      Log.d(this.jdField_a_of_type_JavaLangString, "fast seek to " + paramLong + " arrived at " + localuez2.jdField_a_of_type_Long);
      paramLong = l2;
      localuez1 = localuez2;
    }
    for (;;)
    {
      paramuff = localuez1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.jdField_a_of_type_JavaLangString, "exact seek match!");
      return localuez1;
      if (paramuff.b() == 6)
      {
        a(localuez2, false);
        a(paramLong, paramufc, paramMediaCodec);
        paramufc = a(true, true);
        if (paramufc == null) {
          return null;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "fast_exact seek to " + paramLong + " arrived at " + paramufc.jdField_a_of_type_Long);
        paramuff = paramufc;
        if (paramufc.jdField_a_of_type_Long >= paramLong) {
          break;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "presentation is behind...");
        return paramufc;
      }
      if (paramuff.b() != 4)
      {
        localuez1 = localuez2;
        paramLong = l2;
        if (paramuff.b() != 5) {}
      }
      else
      {
        paramLong = localuez2.jdField_a_of_type_Long / 1000L;
        int i = 0;
        localuez1 = localuez2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.jdField_a_of_type_JavaLangString, "skipping frames...");
          }
          i += 1;
          if (b()) {
            l1 = localuez1.jdField_a_of_type_Long / 1000L;
          }
          if (localuez1.jdField_a_of_type_Boolean)
          {
            Log.d(this.jdField_a_of_type_JavaLangString, "end of stream reached, seeking to last frame");
            a(localuez1, false);
            return a(paramuff, l2, paramufc, paramMediaCodec);
          }
          l2 = localuez1.jdField_a_of_type_Long;
          a(localuez1, false);
          localuez1 = a(true, true);
          if (localuez1 == null) {
            return null;
          }
          paramLong = localuez1.jdField_a_of_type_Long / 1000L;
        }
        Log.d(this.jdField_a_of_type_JavaLangString, "frame new position:         " + localuez1.jdField_a_of_type_Long);
        Log.d(this.jdField_a_of_type_JavaLangString, "seeking finished, skipped " + i + " frames");
        if ((paramuff.b() == 5) && (paramLong > l1))
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
            a(localuez1, false);
            return a(paramuff, l2, paramufc, paramMediaCodec);
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
  public void a(uez paramuez, long paramLong)
  {
    a(paramuez, true);
  }
  
  public void a(uez paramuez, boolean paramBoolean)
  {
    a().releaseOutputBuffer(paramuez.jdField_a_of_type_Int, paramBoolean);
    c(paramuez);
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
 * Qualified Name:     ufb
 * JD-Core Version:    0.7.0.1
 */