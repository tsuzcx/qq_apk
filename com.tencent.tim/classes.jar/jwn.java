import android.os.AsyncTask;
import com.tencent.biz.pubaccount.AccountDetailActivity.b;

public class jwn
  extends AsyncTask<Void, Void, Void>
{
  public jwn(AccountDetailActivity.b paramb, vbi.b paramb1) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    this.b.a.e(this.a);
    return null;
  }
  
  protected void onPostExecute(Void paramVoid)
  {
    this.b.a.setCurrentIndex(-1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jwn
 * JD-Core Version:    0.7.0.1
 */