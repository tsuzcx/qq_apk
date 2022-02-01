import android.database.DataSetObserver;

class nld
  extends DataSetObserver
{
  nld(nlc paramnlc) {}
  
  public void onChanged()
  {
    super.onChanged();
    this.b.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nld
 * JD-Core Version:    0.7.0.1
 */