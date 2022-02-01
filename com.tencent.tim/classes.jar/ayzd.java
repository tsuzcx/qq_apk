import com.tencent.qphone.base.util.QLog;

final class ayzd
  implements aypj.a<Boolean, aypl.d>
{
  ayzd(Object paramObject) {}
  
  public Void a(Boolean arg1, aypl.d paramd)
  {
    QLog.e(ayzc.access$000(), 2, "MediaCodecThumbnailGenerator finished().");
    synchronized (this.gq)
    {
      this.gq.notifyAll();
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayzd
 * JD-Core Version:    0.7.0.1
 */