import android.database.DataSetObserver;

class auur
  extends DataSetObserver
{
  auur(auuq paramauuq) {}
  
  public void onChanged()
  {
    this.b.notifyDataSetChanged();
  }
  
  public void onInvalidated()
  {
    this.b.notifyDataSetInvalidated();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     auur
 * JD-Core Version:    0.7.0.1
 */