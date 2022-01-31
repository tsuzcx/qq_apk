import android.util.LruCache;

class tya
  extends LruCache<String, txs>
{
  tya(txz paramtxz, int paramInt)
  {
    super(paramInt);
  }
  
  protected void a(boolean paramBoolean, String paramString, txs paramtxs1, txs paramtxs2)
  {
    super.entryRemoved(paramBoolean, paramString, paramtxs1, paramtxs2);
    txq.a("story.icon.ShareGroupIconManager", "entryRemoved key = %s" + paramString);
    paramtxs1.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tya
 * JD-Core Version:    0.7.0.1
 */