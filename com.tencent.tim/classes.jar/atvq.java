import android.os.AsyncTask;

class atvq
  extends AsyncTask<String, Void, String>
{
  String cIc;
  
  atvq(atvp paramatvp) {}
  
  protected String doInBackground(String... paramVarArgs)
  {
    this.cIc = paramVarArgs[0];
    return atvp.a(this.this$0, this.cIc);
  }
  
  protected void onPostExecute(String paramString)
  {
    this.this$0.jg(this.cIc, paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atvq
 * JD-Core Version:    0.7.0.1
 */