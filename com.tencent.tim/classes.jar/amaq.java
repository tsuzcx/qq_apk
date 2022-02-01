import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import android.media.MediaMuxer;
import com.tencent.qphone.base.util.QLog;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@TargetApi(18)
public class amaq
{
  private final List<amaq.a> FA = new ArrayList();
  private MediaFormat a;
  private int azv;
  private int azw;
  private MediaFormat jdField_b_of_type_AndroidMediaMediaFormat;
  public final MediaMuxer b;
  private final ayyj jdField_b_of_type_Ayyj;
  private final amal d;
  private int dBh;
  private int dBk = 1;
  private MediaFormat g;
  private final String mOutputPath;
  private boolean mStarted;
  private ByteBuffer v;
  
  public amaq(ayyj paramayyj, String paramString, amal paramamal)
    throws IOException
  {
    this.jdField_b_of_type_Ayyj = paramayyj;
    this.d = paramamal;
    this.mOutputPath = paramString;
    this.jdField_b_of_type_AndroidMediaMediaMuxer = new MediaMuxer(paramString, 0);
  }
  
  private void dLY()
  {
    if (this.jdField_b_of_type_AndroidMediaMediaFormat == null) {}
    while (((this.a == null) && (this.dBk > 0)) || ((this.dBk == 2) && (this.g == null))) {
      return;
    }
    this.azv = this.jdField_b_of_type_AndroidMediaMediaMuxer.addTrack(this.jdField_b_of_type_AndroidMediaMediaFormat);
    QLog.d("MediaMuxerWrapper", 1, "Added track #" + this.azv + " with " + this.jdField_b_of_type_AndroidMediaMediaFormat.getString("mime") + " to muxer");
    if (this.a != null)
    {
      this.azw = this.jdField_b_of_type_AndroidMediaMediaMuxer.addTrack(this.a);
      QLog.d("MediaMuxerWrapper", 1, "Added track #" + this.azw + " with " + this.a.getString("mime") + " to muxer");
    }
    if (this.g != null)
    {
      this.dBh = this.jdField_b_of_type_AndroidMediaMediaMuxer.addTrack(this.a);
      QLog.d("MediaMuxerWrapper", 1, new Object[] { "Added second audiotrack #", Integer.valueOf(this.azw), " with ", this.g.getString("mime"), " to muxer" });
    }
    this.jdField_b_of_type_AndroidMediaMediaMuxer.start();
    this.mStarted = true;
    if (this.v == null) {
      this.v = ByteBuffer.allocate(0);
    }
    this.v.flip();
    QLog.d("MediaMuxerWrapper", 1, "Output format determined, writing " + this.FA.size() + " samples / " + this.v.limit() + " bytes to muxer.");
    MediaCodec.BufferInfo localBufferInfo = new MediaCodec.BufferInfo();
    Iterator localIterator = this.FA.iterator();
    amaq.a locala;
    for (int i = 0; localIterator.hasNext(); i = amaq.a.b(locala) + i)
    {
      locala = (amaq.a)localIterator.next();
      amaq.a.a(locala, localBufferInfo, i);
      this.jdField_b_of_type_AndroidMediaMediaMuxer.writeSampleData(iW(amaq.a.a(locala)), this.v, localBufferInfo);
    }
    this.FA.clear();
    this.v = null;
  }
  
  private int iW(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      throw new AssertionError();
    case 0: 
      return this.azv;
    case 1: 
      return this.azw;
    }
    return this.dBh;
  }
  
  public void Uj(int paramInt)
  {
    this.dBk = paramInt;
  }
  
  public void a(int paramInt, MediaFormat paramMediaFormat)
  {
    QLog.d("MediaMuxerWrapper", 1, "setOutputFormat " + paramInt);
    switch (paramInt)
    {
    default: 
      throw new AssertionError();
    case 0: 
      this.jdField_b_of_type_AndroidMediaMediaFormat = paramMediaFormat;
    }
    for (;;)
    {
      dLY();
      return;
      this.a = paramMediaFormat;
      continue;
      this.g = paramMediaFormat;
    }
  }
  
  public void release()
  {
    try
    {
      QLog.d("MediaMuxerWrapper", 1, "release");
      if (this.jdField_b_of_type_Ayyj.isFinished())
      {
        QLog.d("MediaMuxerWrapper", 1, "release indeed");
        if (this.mStarted)
        {
          this.mStarted = false;
          this.jdField_b_of_type_AndroidMediaMediaMuxer.stop();
        }
        this.jdField_b_of_type_AndroidMediaMediaMuxer.release();
        if (this.d != null) {
          this.d.kf(this.mOutputPath);
        }
      }
      return;
    }
    finally {}
  }
  
  public void writeSampleData(int paramInt, ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    try
    {
      if (this.mStarted)
      {
        this.jdField_b_of_type_AndroidMediaMediaMuxer.writeSampleData(iW(paramInt), paramByteBuffer, paramBufferInfo);
        return;
      }
      paramByteBuffer.limit(paramBufferInfo.offset + paramBufferInfo.size);
      paramByteBuffer.position(paramBufferInfo.offset);
      if (this.v == null) {
        this.v = ByteBuffer.allocateDirect(65536).order(ByteOrder.nativeOrder());
      }
      this.v.put(paramByteBuffer);
      this.FA.add(new amaq.a(paramInt, paramBufferInfo.size, paramBufferInfo, null));
      return;
    }
    catch (Exception paramByteBuffer)
    {
      QLog.e("MediaMuxerWrapper", 1, "writeSampleData error, ", paramByteBuffer);
    }
  }
  
  static class a
  {
    private final int dBl;
    private final int mFlags;
    private final long mPresentationTimeUs;
    private final int mSize;
    
    private a(int paramInt1, int paramInt2, MediaCodec.BufferInfo paramBufferInfo)
    {
      this.dBl = paramInt1;
      this.mSize = paramInt2;
      this.mPresentationTimeUs = paramBufferInfo.presentationTimeUs;
      this.mFlags = paramBufferInfo.flags;
    }
    
    private void a(MediaCodec.BufferInfo paramBufferInfo, int paramInt)
    {
      paramBufferInfo.set(paramInt, this.mSize, this.mPresentationTimeUs, this.mFlags);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amaq
 * JD-Core Version:    0.7.0.1
 */