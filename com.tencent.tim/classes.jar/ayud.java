import android.os.Message;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;

public class ayud
  extends ayec
{
  private View Ns;
  
  public ayud(@NonNull aygz paramaygz)
  {
    super(paramaygz);
  }
  
  protected boolean e(Message paramMessage)
  {
    if (paramMessage.arg1 == 1) {
      this.Ns.setVisibility(8);
    }
    return super.e(paramMessage);
  }
  
  public void onCreate()
  {
    super.onCreate();
    this.Ns = y(2131376006);
    ((Button)y(2131367288)).setOnClickListener(new ayue(this));
  }
  
  public void p(int paramInt, Object paramObject)
  {
    super.p(paramInt, paramObject);
    paramObject = this.Ns;
    if ((paramInt == 0) || (paramInt == 7)) {}
    for (paramInt = 0;; paramInt = 8)
    {
      paramObject.setVisibility(paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     ayud
 * JD-Core Version:    0.7.0.1
 */