import android.widget.DatePicker;
import android.widget.EditText;
import dov.com.qq.im.ae.camera.ui.watermark.WatermarkEditView;

public class axbe
  implements axaw.b
{
  public axbe(WatermarkEditView paramWatermarkEditView) {}
  
  public void a(int paramInt, String paramString, EditText paramEditText)
  {
    paramString = paramString.split("-");
    WatermarkEditView.a(this.this$0).init(Integer.parseInt(paramString[0]), Integer.parseInt(paramString[1]) - 1, Integer.parseInt(paramString[2]), WatermarkEditView.a(this.this$0));
    WatermarkEditView.a(this.this$0).setVisibility(0);
  }
  
  public void eIw()
  {
    WatermarkEditView.a(this.this$0).setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     axbe
 * JD-Core Version:    0.7.0.1
 */