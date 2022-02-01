import android.os.AsyncTask;
import android.text.TextUtils;

final class jpt
  extends AsyncTask<Void, Void, Void>
{
  String TV = "";
  
  jpt(jps.a parama, String paramString) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this.TV = jps.dQ(this.TW);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    super.onPostExecute(paramVoid);
    if (TextUtils.isEmpty(this.TV))
    {
      this.a.ayW();
      return;
    }
    this.a.lc(this.TV);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jpt
 * JD-Core Version:    0.7.0.1
 */