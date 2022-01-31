import android.database.DataSetObserver;

class wcm
  extends DataSetObserver
{
  wcm(wcl paramwcl) {}
  
  public void onChanged()
  {
    wcl.a(this.a, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     wcm
 * JD-Core Version:    0.7.0.1
 */