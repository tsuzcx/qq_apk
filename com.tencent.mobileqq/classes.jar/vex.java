import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.activity.aio.item.RichStatItemBuilder;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;

public class vex
  extends VasQuickUpdateManager.CallBacker
{
  public vex(RichStatItemBuilder paramRichStatItemBuilder) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, VasQuickUpdateManager paramVasQuickUpdateManager)
  {
    if ((paramLong == 9L) && (paramString1.startsWith("signature.sticker.")) && (paramInt1 == 0))
    {
      paramString1 = paramString1.substring("signature.sticker.".length(), paramString1.length());
      paramString1 = paramString1.substring(0, paramString1.length() - 4);
      if (TextUtils.isDigitsOnly(paramString1))
      {
        paramInt1 = Integer.parseInt(paramString1);
        this.a.b.post(new vey(this, paramInt1));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     vex
 * JD-Core Version:    0.7.0.1
 */