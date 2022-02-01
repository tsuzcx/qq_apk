import android.support.annotation.Nullable;

class rgs
  extends rgp.d
{
  rgs(rgp paramrgp, rgo paramrgo)
  {
    super(paramrgo);
  }
  
  protected void a(@Nullable rgo arg1)
  {
    super.onResult(???);
    ram.d("DoodleEmojiManager", "startDownload again");
    synchronized (this.a.bm)
    {
      this.a.a = null;
      this.a.startDownload();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rgs
 * JD-Core Version:    0.7.0.1
 */