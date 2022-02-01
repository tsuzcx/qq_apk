import android.os.Message;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.emosm.favroaming.FavroamingManager.8;
import java.util.List;
import mqq.os.MqqHandler;

public class afia
  implements afhf.a
{
  private int cQZ;
  
  public afia(FavroamingManager.8 param8, List paramList) {}
  
  public void ck(int paramInt, String paramString)
  {
    this.zM.add(Integer.valueOf(paramInt));
    this.cQZ += 1;
    if (this.cQZ <= this.a.val$size)
    {
      this.a.this$0.cZE();
      if (this.a.a != null) {
        this.a.a.a(this.cQZ / this.a.val$size, this.zM);
      }
    }
    if (this.cQZ < this.a.val$size) {
      if (!afhv.a(this.a.this$0))
      {
        paramString = (String)this.a.zL.get(this.cQZ);
        afhv.a(this.a.this$0, paramString, afhv.a(this.a.this$0));
      }
    }
    do
    {
      return;
      paramString = afhv.p(this.a.this$0).getHandler(ChatActivity.class);
      if (paramString != null) {
        paramString.obtainMessage(10).sendToTarget();
      }
    } while (this.a.a == null);
    this.a.a.hg(this.zM);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afia
 * JD-Core Version:    0.7.0.1
 */