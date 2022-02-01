import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.app.TroopManager.g;

public class wkf
  implements TroopManager.g
{
  public wkf(BaseBubbleBuilder paramBaseBubbleBuilder, Intent paramIntent) {}
  
  public void onResult(Object paramObject)
  {
    if ((paramObject instanceof String))
    {
      this.N.putExtra("troop_uin", (String)paramObject);
      this.N.putExtra("cSpecialFlag", 0);
      this.this$0.mContext.startActivity(this.N);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wkf
 * JD-Core Version:    0.7.0.1
 */