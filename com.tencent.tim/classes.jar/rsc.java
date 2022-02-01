import android.database.DataSetObserver;

class rsc
  extends DataSetObserver
{
  rsc(rsb paramrsb) {}
  
  public void onChanged()
  {
    rsb.a(this.b, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rsc
 * JD-Core Version:    0.7.0.1
 */