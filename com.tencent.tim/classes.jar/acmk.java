import android.content.Context;
import android.os.Bundle;
import com.tencent.qphone.base.util.QLog;

class acmk
  implements aqqm
{
  acmk(acmi paramacmi, aogy paramaogy, Context paramContext, Bundle paramBundle) {}
  
  public void I(int paramInt, String paramString1, String paramString2)
  {
    QLog.e("Theme.ThemeHandler", 1, "onQueryItemVer: " + paramInt + "," + paramString1 + "," + paramString2);
    if (paramInt == 0)
    {
      this.a.a(this.val$context, paramString1, paramString2);
      this.ay.putString("themePath", this.a.AH());
      acmi.a(this.this$0, this.ay);
      return;
    }
    this.ay.putString("themeId", "1000");
    this.ay.remove("themePath");
    acmi.a(this.this$0, this.ay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acmk
 * JD-Core Version:    0.7.0.1
 */