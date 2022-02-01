import android.os.AsyncTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

class ajir
  extends AsyncTask<Void, Void, Void>
{
  ajir(ajiq paramajiq) {}
  
  protected Void doInBackground(Void... paramVarArgs)
  {
    paramVarArgs = ajiq.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    ajiq.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajir
 * JD-Core Version:    0.7.0.1
 */