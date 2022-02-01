import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class txp
  extends AsyncTask<Void, Void, Void>
{
  txp(txo paramtxo) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = txo.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    txo.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txp
 * JD-Core Version:    0.7.0.1
 */