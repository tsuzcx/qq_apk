import android.os.AsyncTask;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import java.util.Iterator;
import java.util.List;

public class agbl
  extends AsyncTask<Void, Void, Integer>
{
  public agbl(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(ahap.au(this.a));
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.AO.iterator();
    while (localIterator.hasNext())
    {
      agnc localagnc = (agnc)localIterator.next();
      if (localagnc.category == 4)
      {
        localagnc.num = paramInteger.intValue();
        this.a.a.notifyDataSetChanged();
      }
    }
  }
  
  protected void onPreExecute()
  {
    super.onPreExecute();
    this.a.startTitleProgress();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agbl
 * JD-Core Version:    0.7.0.1
 */