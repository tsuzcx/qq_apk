import android.text.TextUtils;
import com.tencent.mobileqq.emoticonview.EmoticonPanelController;
import com.tencent.mobileqq.model.QueryTask.a;

public class afmu
  implements QueryTask.a<String, Integer>
{
  public afmu(EmoticonPanelController paramEmoticonPanelController, int paramInt) {}
  
  public Integer d(String paramString)
  {
    this.this$0.HX(this.this$0.bYX);
    int i = this.cSj;
    if (!TextUtils.isEmpty(paramString)) {
      i = EmoticonPanelController.a(this.this$0, paramString);
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afmu
 * JD-Core Version:    0.7.0.1
 */