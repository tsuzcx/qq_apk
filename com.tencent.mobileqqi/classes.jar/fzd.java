import android.os.AsyncTask;
import com.tencent.mobileqq.fpsreport.FPSCalculator;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class fzd
  extends AsyncTask
{
  public fzd(FPSCalculator paramFPSCalculator) {}
  
  protected Void a(Void... paramVarArgs)
  {
    paramVarArgs = FPSCalculator.a(this.a).iterator();
    while (paramVarArgs.hasNext()) {
      QLog.d("Q.PerfTrace", 2, (String)paramVarArgs.next());
    }
    FPSCalculator.a(this.a).clear();
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fzd
 * JD-Core Version:    0.7.0.1
 */