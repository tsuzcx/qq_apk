import android.content.Context;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import com.tencent.theme.TextHook;

final class aqse
  extends anll
{
  protected void b(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, int paramInt)
  {
    paramInt = 0;
    Object localObject1;
    if (paramBoolean1)
    {
      localObject1 = BaseApplicationImpl.getApplication().getApplicationContext();
      if (!anlm.ayn()) {
        break label48;
      }
      localObject2 = TextHook.getFontPath((Context)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        aqsd.cV((Context)localObject1, (String)localObject2);
        aqsd.SS(false);
      }
    }
    label48:
    do
    {
      return;
      localObject1 = aqsd.bz((Context)localObject1);
    } while (TextUtils.isEmpty((CharSequence)localObject1));
    Object localObject2 = ahav.getFileName((String)localObject1).split("\\.");
    try
    {
      int i = Integer.parseInt(localObject2[0]);
      if (localObject2.length > 2) {
        paramInt = Integer.parseInt(localObject2[1]);
      }
      aqsd.kp(i, paramInt);
      return;
    }
    catch (NumberFormatException localNumberFormatException)
    {
      QLog.e("ThemeFontAdapter", 1, "switchFont  prePath:" + (String)localObject1, localNumberFormatException);
      localNumberFormatException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqse
 * JD-Core Version:    0.7.0.1
 */