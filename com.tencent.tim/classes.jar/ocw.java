import android.content.Context;
import com.tencent.common.app.AppInterface;

final class ocw
  extends adai.a
{
  ocw(acje paramacje, String paramString, AppInterface paramAppInterface, Context paramContext, int paramInt, boolean paramBoolean) {}
  
  public void b(boolean paramBoolean, Object paramObject) {}
  
  public void c(boolean paramBoolean, Object paramObject) {}
  
  public int dI()
  {
    return 4;
  }
  
  public void onSuccess(Object paramObject)
  {
    if (this.a != null) {
      this.a.onUpdate(101, true, this.val$uin);
    }
    ocp.b(this.b, this.val$context, this.val$uin, this.val$source);
  }
  
  public void p(Object paramObject)
  {
    if (this.a != null) {
      this.a.onUpdate(101, false, this.val$uin);
    }
    if (this.awp) {
      ocp.K(this.val$context, 2131697432);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ocw
 * JD-Core Version:    0.7.0.1
 */