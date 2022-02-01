import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.a;
import com.tencent.mobileqq.jsp.UiApiPlugin;

public final class aikr
  implements kqd.a
{
  public aikr(BridgeModule.a parama, String paramString1, String paramString2, String paramString3, String paramString4) {}
  
  public void b(kqf paramkqf)
  {
    if ((this.a != null) && (!TextUtils.isEmpty(this.val$callBackId))) {
      this.a.j(this.val$callBackId, UiApiPlugin.b(paramkqf, this.bOL, this.bOM, this.bON));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     aikr
 * JD-Core Version:    0.7.0.1
 */