import android.database.DataSetObserver;

class wcp
  extends DataSetObserver
{
  wcp(wco paramwco) {}
  
  public void onChanged()
  {
    wco.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wcp
 * JD-Core Version:    0.7.0.1
 */