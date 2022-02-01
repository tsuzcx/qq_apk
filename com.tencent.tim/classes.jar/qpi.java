import android.util.LruCache;

class qpi
  extends LruCache<String, qpd>
{
  qpi(qph paramqph, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, qpd paramqpd1, qpd paramqpd2)
  {
    super.entryRemoved(paramBoolean, paramString, paramqpd1, paramqpd2);
    qpb.d("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramqpd1.recycle();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qpi
 * JD-Core Version:    0.7.0.1
 */