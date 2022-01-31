import com.tencent.mobileqq.app.ClubContentUpdateHandler.ClubContentUpdateListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import java.util.HashMap;

public class fsu
  implements ClubContentUpdateHandler.ClubContentUpdateListener
{
  public fsu(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void a(HashMap paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() == 0)) {}
    while ((!EmoticonMainPanel.a(this.a)) || (this.a.getVisibility() != 0) || (EmoticonMainPanel.b() != 2)) {
      return;
    }
    this.a.post(new fsv(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     fsu
 * JD-Core Version:    0.7.0.1
 */