import android.widget.TextView;
import com.tencent.mobileqq.activity.QQIdentiferActivity;

public class vnu
  implements alxi.b
{
  public vnu(QQIdentiferActivity paramQQIdentiferActivity) {}
  
  public void onGetValue(float paramFloat)
  {
    if (paramFloat < 0.0F)
    {
      this.this$0.i(this.this$0.getString(2131696080));
      return;
    }
    if (paramFloat > 175.0F)
    {
      this.this$0.i(this.this$0.getString(2131696079));
      return;
    }
    QQIdentiferActivity.a(this.this$0).setText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vnu
 * JD-Core Version:    0.7.0.1
 */