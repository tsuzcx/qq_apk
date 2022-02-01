import android.content.DialogInterface.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public final class ulf
  implements aqux.b
{
  public ulf(DialogInterface.OnClickListener paramOnClickListener1, DialogInterface.OnClickListener paramOnClickListener2) {}
  
  public void callback(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ChatActivityUtils", 2, "showDlgWithCuOpenCheck type = " + paramInt);
    }
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
    case 2: 
      this.p.onClick(null, 0);
      return;
    }
    this.o.onClick(null, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     ulf
 * JD-Core Version:    0.7.0.1
 */