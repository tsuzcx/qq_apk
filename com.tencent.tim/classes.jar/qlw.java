import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaFormat;
import android.util.Log;
import android.view.Surface;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.b;
import java.io.IOException;

@TargetApi(16)
public class qlw
  extends qlv
{
  private boolean aEh;
  private Surface mVideoSurface;
  
  public qlw(qlx paramqlx, boolean paramBoolean1, int paramInt, qlv.b paramb, Surface paramSurface, boolean paramBoolean2)
    throws IOException
  {
    super(paramqlx, paramBoolean1, paramInt, paramb);
    this.mVideoSurface = paramSurface;
    this.aEh = paramBoolean2;
    boY();
  }
  
  @TargetApi(16)
  private long a(long paramLong, qlx paramqlx, MediaCodec paramMediaCodec)
    throws IOException
  {
    paramMediaCodec.flush();
    paramqlx.seekTo(paramLong, 0);
    if (paramqlx.getSampleTime() == paramLong)
    {
      Log.d(this.TAG, "skip fastseek, already there");
      return paramLong;
    }
    boZ();
    W(false);
    paramqlx.seekTo(paramLong, 0);
    long l1 = 0L;
    long l3 = 9223372036854775807L;
    int i = 0;
    while ((paramqlx.advance()) && (i < 20))
    {
      long l5 = paramLong - paramqlx.getSampleTime();
      long l4 = l3;
      long l2 = l1;
      if (l5 >= 0L)
      {
        l4 = l3;
        l2 = l1;
        if (l5 < l3)
        {
          l2 = paramqlx.getSampleTime();
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
    paramqlx.seekTo(l1, 0);
    while (paramqlx.getSampleTime() != l1) {
      paramqlx.advance();
    }
    Log.d(this.TAG, "exact fastseek match:       " + paramqlx.getSampleTime());
    return l1;
  }
  
  protected qlv.a a(MediaPlayer.b paramb, long paramLong, qlx paramqlx, MediaCodec paramMediaCodec)
    throws IOException
  {
    long l1 = -1L;
    long l2 = paramLong / 1000L;
    qlv.a locala2 = super.a(paramb, paramLong, paramqlx, paramMediaCodec);
    if (locala2 == null)
    {
      paramb = null;
      return paramb;
    }
    qlv.a locala1;
    if ((paramb.sM() == 3) || (paramb.sM() == 2) || (paramb.sM() == 0) || (paramb.sM() == 1))
    {
      Log.d(this.TAG, "fast seek to " + paramLong + " arrived at " + locala2.presentationTimeUs);
      paramLong = l2;
      locala1 = locala2;
    }
    for (;;)
    {
      paramb = locala1;
      if (l1 != paramLong) {
        break;
      }
      Log.d(this.TAG, "exact seek match!");
      return locala1;
      if (paramb.sM() == 6)
      {
        a(locala2, false);
        a(paramLong, paramqlx, paramMediaCodec);
        paramqlx = a(true, true);
        if (paramqlx == null) {
          return null;
        }
        Log.d(this.TAG, "fast_exact seek to " + paramLong + " arrived at " + paramqlx.presentationTimeUs);
        paramb = paramqlx;
        if (paramqlx.presentationTimeUs >= paramLong) {
          break;
        }
        Log.d(this.TAG, "presentation is behind...");
        return paramqlx;
      }
      if (paramb.sM() != 4)
      {
        locala1 = locala2;
        paramLong = l2;
        if (paramb.sM() != 5) {}
      }
      else
      {
        paramLong = locala2.presentationTimeUs / 1000L;
        int i = 0;
        locala1 = locala2;
        l1 = l2;
        l2 = -1L;
        while (paramLong < l1)
        {
          if (i == 0) {
            Log.d(this.TAG, "skipping frames...");
          }
          i += 1;
          if (JW()) {
            l1 = locala1.presentationTimeUs / 1000L;
          }
          if (locala1.endOfStream)
          {
            Log.d(this.TAG, "end of stream reached, seeking to last frame");
            a(locala1, false);
            return a(paramb, l2, paramqlx, paramMediaCodec);
          }
          l2 = locala1.presentationTimeUs;
          a(locala1, false);
          locala1 = a(true, true);
          if (locala1 == null) {
            return null;
          }
          paramLong = locala1.presentationTimeUs / 1000L;
        }
        Log.d(this.TAG, "frame new position:         " + locala1.presentationTimeUs);
        Log.d(this.TAG, "seeking finished, skipped " + i + " frames");
        if ((paramb.sM() == 5) && (paramLong > l1))
        {
          if (i == 0)
          {
            Log.w(this.TAG, "this should never happen");
            l2 = paramLong;
            paramLong = l1;
            l1 = l2;
          }
          else
          {
            Log.d(this.TAG, "exact seek: repeat seek for previous frame at " + l2);
            a(locala1, false);
            return a(paramb, l2, paramqlx, paramMediaCodec);
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
    paramMediaCodec.configure(paramMediaFormat, this.mVideoSurface, null, 0);
  }
  
  @SuppressLint({"NewApi"})
  public void a(qlv.a parama, long paramLong)
  {
    a(parama, true);
  }
  
  public void a(qlv.a parama, boolean paramBoolean)
  {
    getCodec().releaseOutputBuffer(parama.bni, paramBoolean);
    c(parama);
  }
  
  public void c(Surface paramSurface)
  {
    if (paramSurface == null) {
      throw new RuntimeException("surface must not be null");
    }
    this.mVideoSurface = paramSurface;
    boY();
  }
  
  public int getVideoHeight()
  {
    MediaFormat localMediaFormat = getFormat();
    if (localMediaFormat != null) {
      return localMediaFormat.getInteger("height");
    }
    return 0;
  }
  
  public int getVideoWidth()
  {
    MediaFormat localMediaFormat = getFormat();
    if (localMediaFormat != null)
    {
      float f = localMediaFormat.getInteger("height");
      return (int)(localMediaFormat.getFloat("mpx-dar") * f);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlw
 * JD-Core Version:    0.7.0.1
 */