import com.tencent.mobileqq.app.ClubContentUpdateHandler.ClubContentUpdateListener;
import com.tencent.mobileqq.emoticonview.EmoticonMainPanel;
import java.util.HashMap;

public class dfr
  implements ClubContentUpdateHandler.ClubContentUpdateListener
{
  public dfr(EmoticonMainPanel paramEmoticonMainPanel) {}
  
  public void a(HashMap paramHashMap)
  {
    if ((paramHashMap == null) || (paramHashMap.size() == 0)) {}
    while ((!this.a.b) || (this.a.getVisibility() != 0) || (EmoticonMainPanel.g != 2)) {
      return;
    }
    this.a.post(new dfs(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     dfr
 * JD-Core Version:    0.7.0.1
 */