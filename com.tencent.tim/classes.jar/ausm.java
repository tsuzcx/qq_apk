import android.os.Handler;
import android.util.Pair;
import android.widget.TextView;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet.3.1;

public class ausm
  implements URLDrawable.URLDrawableListener
{
  ausm(ausj paramausj, TextView paramTextView, Pair paramPair) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable)
  {
    QLog.i("ActionSheet", 1, "onLoadCanceled");
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("ActionSheet", 1, "onLoadFialed ", paramThrowable);
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt)
  {
    QLog.i("ActionSheet", 1, "onLoadProgressed " + paramInt);
  }
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    try
    {
      QLog.i("ActionSheet", 1, "onLoadSuccessed " + paramURLDrawable);
      if (paramURLDrawable != null) {
        ausj.a(this.this$0).post(new ActionSheet.3.1(this, paramURLDrawable));
      }
      return;
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     ausm
 * JD-Core Version:    0.7.0.1
 */