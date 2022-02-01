import android.os.AsyncTask;
import com.tencent.tim.filemanager.activity.FMLocalFileActivity;
import java.util.Iterator;
import java.util.List;

public class atoa
  extends AsyncTask<Void, Void, Integer>
{
  public atoa(FMLocalFileActivity paramFMLocalFileActivity) {}
  
  protected Integer a(Void... paramVarArgs)
  {
    return Integer.valueOf(audt.au(this.a));
  }
  
  protected void onPostExecute(Integer paramInteger)
  {
    super.onPostExecute(paramInteger);
    this.a.stopTitleProgress();
    Iterator localIterator = this.a.AO.iterator();
    while (localIterator.hasNext())
    {
      atwd localatwd = (atwd)localIterator.next();
      if (localatwd.category == 4)
      {
        localatwd.num = paramInteger.intValue();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atoa
 * JD-Core Version:    0.7.0.1
 */