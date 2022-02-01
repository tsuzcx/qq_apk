import android.content.Context;
import android.os.AsyncTask;

final class ahbx
  extends ci.a
{
  ahbx(Context paramContext) {}
  
  protected void a(AsyncTask<Integer, Integer, String> paramAsyncTask, int paramInt)
  {
    try
    {
      ci.a(this.I, paramAsyncTask, paramInt, new ahby(this));
      super.a(paramAsyncTask, paramInt);
      return;
    }
    catch (Exception paramAsyncTask)
    {
      paramAsyncTask.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahbx
 * JD-Core Version:    0.7.0.1
 */