import com.tencent.mobileqq.activity.contact.troop.ShowExternalTroopListActivity.a;
import com.tencent.mobileqq.activity.contact.troop.TroopActivity;
import java.util.HashMap;

public class ywv
  implements ShowExternalTroopListActivity.a
{
  public ywv(TroopActivity paramTroopActivity) {}
  
  public void bf(String paramString, boolean paramBoolean)
  {
    if ((this.this$0.hi.containsKey(paramString)) && (((Boolean)this.this$0.hi.get(paramString)).booleanValue() != paramBoolean))
    {
      this.this$0.hi.remove(paramString);
      return;
    }
    this.this$0.hi.put(paramString, Boolean.valueOf(paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     ywv
 * JD-Core Version:    0.7.0.1
 */