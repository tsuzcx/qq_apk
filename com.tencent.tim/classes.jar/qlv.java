import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.os.SystemClock;
import android.util.Log;
import com.tencent.biz.qqstory.playvideo.player.mediaplayer.MediaPlayer.b;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(16)
public abstract class qlv
{
  private long Bb;
  protected String TAG = qlv.class.getSimpleName();
  private qlv.a jdField_a_of_type_Qlv$a;
  private qlv.b jdField_a_of_type_Qlv$b;
  private qlx jdField_a_of_type_Qlx;
  private ByteBuffer[] jdField_a_of_type_ArrayOfJavaNioByteBuffer;
  private boolean aEb;
  private boolean aEc;
  private boolean aEd;
  private boolean aEe;
  private boolean aEf;
  private ByteBuffer[] b;
  private MediaCodec c;
  private MediaCodec.BufferInfo mBufferInfo;
  private MediaFormat mFormat;
  private int mTrackIndex;
  private List<qlv.a> nV;
  
  public qlv(qlx paramqlx, boolean paramBoolean, int paramInt, qlv.b paramb)
    throws IllegalStateException, IOException
  {
    if ((paramqlx == null) || (paramInt == -1)) {
      throw new IllegalArgumentException("no track specified");
    }
    this.jdField_a_of_type_Qlx = paramqlx;
    this.aEf = paramBoolean;
    this.mTrackIndex = paramInt;
    this.mFormat = paramqlx.getTrackFormat(this.mTrackIndex);
    this.jdField_a_of_type_Qlv$b = paramb;
    this.c = MediaCodec.createDecoderByType(this.mFormat.getString("mime"));
    this.Bb = -9223372036854775808L;
  }
  
  protected boolean JV()
  {
    return true;
  }
  
  protected final boolean JW()
  {
    return this.aEc;
  }
  
  protected final boolean JX()
  {
    return this.aEf;
  }
  
  public final boolean W(boolean paramBoolean)
  {
    int j = 4;
    long l = 0L;
    if ((this.aEb) || (!JV())) {}
    int k;
    Object localObject;
    do
    {
      do
      {
        do
        {
          return false;
          if ((this.jdField_a_of_type_Qlx.getSampleTrackIndex() == -1) || (this.jdField_a_of_type_Qlx.getSampleTrackIndex() == this.mTrackIndex)) {
            break;
          }
        } while (!paramBoolean);
        return this.jdField_a_of_type_Qlx.advance();
        k = this.c.dequeueInputBuffer(0L);
      } while (k < 0);
      localObject = this.jdField_a_of_type_ArrayOfJavaNioByteBuffer[k];
      if (!this.jdField_a_of_type_Qlx.JY()) {
        break;
      }
      this.aEd = true;
      this.c.queueInputBuffer(k, 0, 0, 0L, 4);
    } while ((this.jdField_a_of_type_Qlx.getCachedDuration() <= -1L) || (this.jdField_a_of_type_Qlv$b == null));
    this.jdField_a_of_type_Qlv$b.b(this);
    return false;
    if ((this.jdField_a_of_type_Qlx.getCachedDuration() > -1L) && (this.jdField_a_of_type_Qlv$b != null)) {
      this.jdField_a_of_type_Qlv$b.b(this);
    }
    int i = this.jdField_a_of_type_Qlx.readSampleData((ByteBuffer)localObject, 0);
    if (i < 0)
    {
      Log.d(this.TAG, "EOS input");
      this.aEb = true;
      i = 0;
      paramBoolean = false;
      localObject = this.c;
      if (!this.aEb) {
        break label264;
      }
    }
    for (;;)
    {
      ((MediaCodec)localObject).queueInputBuffer(k, 0, i, l, j);
      if (!this.aEb) {
        this.jdField_a_of_type_Qlx.advance();
      }
      return paramBoolean;
      l = this.jdField_a_of_type_Qlx.getSampleTime();
      paramBoolean = true;
      break;
      label264:
      j = 0;
    }
  }
  
  public final qlv.a a()
  {
    if (this.aEc) {
      return null;
    }
    int i = this.c.dequeueOutputBuffer(this.mBufferInfo, 0L);
    boolean bool;
    if ((i >= 0) && ((this.mBufferInfo.flags & 0x4) != 0))
    {
      bool = true;
      this.aEc = bool;
      if ((!this.aEc) || (!this.aEd)) {
        break label85;
      }
      boY();
      this.aEc = false;
      this.aEd = false;
      this.aEe = true;
    }
    for (;;)
    {
      return null;
      bool = false;
      break;
      label85:
      Object localObject;
      if (i >= 0)
      {
        localObject = this.b[i];
        if ((localObject != null) && (this.mBufferInfo.size != 0))
        {
          ((ByteBuffer)localObject).position(this.mBufferInfo.offset);
          ((ByteBuffer)localObject).limit(this.mBufferInfo.offset + this.mBufferInfo.size);
        }
        qlv.a locala = (qlv.a)this.nV.get(0);
        locala.bni = i;
        locala.data = ((ByteBuffer)localObject);
        locala.presentationTimeUs = this.mBufferInfo.presentationTimeUs;
        locala.endOfStream = this.aEc;
        if (this.aEe)
        {
          this.aEe = false;
          locala.aEg = true;
        }
        if (locala.endOfStream)
        {
          Log.d(this.TAG, "EOS output");
          return locala;
        }
        this.Bb = locala.presentationTimeUs;
        return locala;
      }
      if (i == -3)
      {
        this.b = this.c.getOutputBuffers();
        Log.d(this.TAG, "output buffers have changed.");
      }
      else if (i == -2)
      {
        localObject = this.c.getOutputFormat();
        Log.d(this.TAG, "output format has changed to " + localObject);
        b((MediaFormat)localObject);
      }
      else if (i != -1) {}
    }
  }
  
  protected qlv.a a(MediaPlayer.b paramb, long paramLong, qlx paramqlx, MediaCodec paramMediaCodec)
    throws IOException
  {
    if (this.aEf)
    {
      this.aEb = false;
      this.aEc = false;
      paramMediaCodec.flush();
      return null;
    }
    Log.d(this.TAG, "seeking to:                 " + paramLong);
    Log.d(this.TAG, "extractor current position: " + paramqlx.getSampleTime());
    paramqlx.seekTo(paramLong, paramb.sL());
    Log.d(this.TAG, "extractor new position:     " + paramqlx.getSampleTime());
    this.aEb = false;
    this.aEc = false;
    paramMediaCodec.flush();
    if (paramqlx.JY())
    {
      boY();
      this.aEe = true;
    }
    return a(true, true);
  }
  
  public final qlv.a a(boolean paramBoolean1, boolean paramBoolean2)
  {
    while (!this.aEc)
    {
      qlv.a locala = a();
      while (W(paramBoolean1)) {}
      if (locala != null) {
        return locala;
      }
      if (!paramBoolean2) {
        return null;
      }
    }
    Log.d(this.TAG, "EOS NULL");
    return null;
  }
  
  protected void a(MediaCodec paramMediaCodec, MediaFormat paramMediaFormat)
  {
    paramMediaCodec.configure(paramMediaFormat, null, null, 0);
  }
  
  public final void a(MediaPlayer.b paramb, long paramLong)
    throws IOException
  {
    this.Bb = -9223372036854775808L;
    this.jdField_a_of_type_Qlv$a = a(paramb, paramLong, this.jdField_a_of_type_Qlx, this.c);
  }
  
  public void a(qlv.a parama)
  {
    b(parama);
  }
  
  public void a(qlv.a parama, long paramLong)
  {
    b(parama);
  }
  
  protected void b(MediaFormat paramMediaFormat) {}
  
  public void b(qlv.a parama)
  {
    this.c.releaseOutputBuffer(parama.bni, false);
    c(parama);
  }
  
  protected final void boY()
  {
    int i = 0;
    try
    {
      long l = SystemClock.elapsedRealtime();
      this.mFormat = this.jdField_a_of_type_Qlx.getTrackFormat(this.mTrackIndex);
      this.c.stop();
      a(this.c, this.mFormat);
      this.c.start();
      this.jdField_a_of_type_ArrayOfJavaNioByteBuffer = this.c.getInputBuffers();
      this.b = this.c.getOutputBuffers();
      this.mBufferInfo = new MediaCodec.BufferInfo();
      this.aEb = false;
      this.aEc = false;
      this.nV = new ArrayList();
      while (i < this.b.length)
      {
        this.nV.add(new qlv.a());
        i += 1;
      }
      Log.d(this.TAG, "reinitCodec " + (SystemClock.elapsedRealtime() - l) + "ms");
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      this.c.release();
      Log.e(this.TAG, "reinitCodec: invalid surface or format");
      throw localIllegalArgumentException;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      this.c.release();
      Log.e(this.TAG, "reinitCodec: illegal state");
      throw localIllegalStateException;
    }
  }
  
  public final void boZ()
  {
    if (this.aEf) {
      return;
    }
    for (;;)
    {
      int i = this.jdField_a_of_type_Qlx.getSampleTrackIndex();
      if ((i == -1) || (i == this.mTrackIndex) || (this.aEb)) {
        break;
      }
      this.jdField_a_of_type_Qlx.advance();
    }
  }
  
  public void bpa()
  {
    if (this.jdField_a_of_type_Qlv$a != null) {
      a(this.jdField_a_of_type_Qlv$a, 0L);
    }
  }
  
  public void bpb()
  {
    if (this.jdField_a_of_type_Qlv$a != null) {
      a(this.jdField_a_of_type_Qlv$a);
    }
  }
  
  protected final void c(qlv.a parama)
  {
    parama.clear();
    this.nV.add(parama);
  }
  
  public long dR()
  {
    return this.Bb;
  }
  
  public long getCachedDuration()
  {
    return this.jdField_a_of_type_Qlx.getCachedDuration();
  }
  
  protected final MediaCodec getCodec()
  {
    return this.c;
  }
  
  protected final MediaFormat getFormat()
  {
    return this.mFormat;
  }
  
  public boolean hasCacheReachedEndOfStream()
  {
    return this.jdField_a_of_type_Qlx.hasCacheReachedEndOfStream();
  }
  
  public void release()
  {
    this.c.stop();
    this.c.release();
    Log.d(this.TAG, "decoder released");
  }
  
  public static class a
  {
    public boolean aEg;
    int bni;
    ByteBuffer data;
    public boolean endOfStream;
    public long presentationTimeUs;
    
    public a()
    {
      clear();
    }
    
    public void clear()
    {
      this.bni = -1;
      this.data = null;
      this.presentationTimeUs = -1L;
      this.endOfStream = false;
      this.aEg = false;
    }
    
    public String toString()
    {
      return "FrameInfo{buffer=" + this.bni + ", data=" + this.data + ", presentationTimeUs=" + this.presentationTimeUs + ", endOfStream=" + this.endOfStream + ", representationChanged=" + this.aEg + '}';
    }
  }
  
  public static abstract interface b
  {
    public abstract void b(qlv paramqlv);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qlv
 * JD-Core Version:    0.7.0.1
 */