import android.content.Context;
import com.tencent.qphone.base.util.QLog;

public class adfd
{
  public akqe a;
  public aqju ai;
  Context context;
  
  public adfd(Context paramContext, akqe paramakqe)
  {
    this.context = paramContext;
    this.a = paramakqe;
    this.ai = aqha.a(this.context, 230);
    paramContext = new adfe(this);
    this.ai.setPositiveButton(2131690460, paramContext);
    this.ai.setNegativeButton(2131690459, paramContext);
    this.ai.setMessage(2131690462);
  }
  
  public void cRc()
  {
    if (!this.ai.isShowing()) {
      this.ai.show();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FaceUIController", 2, "doOnClickFeedBack");
    }
    anot.a(null, "dc00898", "", "", "0X8008352", "0X8008352", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adfd
 * JD-Core Version:    0.7.0.1
 */