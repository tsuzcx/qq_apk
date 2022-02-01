import android.view.View;
import com.tencent.qphone.base.util.QLog;

class suh
  implements ausj.a
{
  suh(sug paramsug) {}
  
  public void OnClick(View paramView, int paramInt)
  {
    this.a.N.dismiss();
    switch (paramInt)
    {
    default: 
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMailJsPlugin", 2, String.format("Unknow button %d", new Object[] { Integer.valueOf(paramInt) }));
      }
      return;
    case 0: 
      sug.a(this.a);
      return;
    case 1: 
      sug.b(this.a);
      return;
    case 2: 
      sug.c(this.a);
      return;
    }
    sug.d(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     suh
 * JD-Core Version:    0.7.0.1
 */