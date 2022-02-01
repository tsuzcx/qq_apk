import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class addn
  extends addc
{
  public String bsg;
  public String bsh;
  
  public addn(String paramString1, int paramInt1, int paramInt2, int paramInt3, float paramFloat1, float paramFloat2, float paramFloat3, String paramString2, String paramString3)
  {
    super(paramString1, paramInt1, paramInt2, paramInt3, paramFloat1, paramFloat2, paramFloat3);
    if (!TextUtils.isEmpty(paramString2))
    {
      paramString1 = paramString2.split("\\|");
      if (paramString1.length > 0) {
        this.bsg = paramString1[0];
      }
    }
    this.bsh = paramString3;
    QLog.d("GreetingCardResourceInfo", 2, String.format("GreetingCardResourceInfo mLuaScriptPath=%s mResourceDirPath=%s", new Object[] { this.bsg, this.bsh }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     addn
 * JD-Core Version:    0.7.0.1
 */