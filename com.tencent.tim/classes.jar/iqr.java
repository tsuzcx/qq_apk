import android.content.Context;
import android.text.TextUtils;
import com.tencent.av.VideoController;
import com.tencent.av.opengl.program.TextureProgram;
import com.tencent.av.opengl.texture.YUVTexture;
import java.util.List;

public class iqr
  extends YUVTexture
{
  private static String PO;
  private static boolean Uc;
  private static boolean Ud;
  public static int asb = 480;
  private static int asc = 1;
  private static String versionName;
  private iqn jdField_a_of_type_Iqn;
  private izm jdField_a_of_type_Izm;
  
  public iqr(Context paramContext, izm paramizm, String paramString, long paramLong)
  {
    super(paramContext, paramString, paramLong);
    this.jdField_a_of_type_Izm = paramizm;
  }
  
  private static void bs(Context paramContext)
  {
    int i = 0;
    if (Uc) {}
    for (;;)
    {
      return;
      Uc = true;
      if (versionName == null) {
        versionName = aqgz.getQQVersion();
      }
      paramContext = iol.a();
      Ud = false;
      if ((paramContext == null) || (paramContext.aqS != 1)) {
        continue;
      }
      asb = paramContext.width;
      asc = paramContext.level;
      PO = paramContext.versionName;
      try
      {
        if ((TextUtils.isEmpty(PO)) || (TextUtils.isEmpty(versionName))) {
          continue;
        }
        paramContext = PO.split("\\.");
        String[] arrayOfString = versionName.split("\\.");
        while ((i < 3) && (i < paramContext.length) && (i < arrayOfString.length))
        {
          if (Integer.valueOf(arrayOfString[i]).intValue() > Integer.valueOf(paramContext[i]).intValue())
          {
            Ud = true;
            return;
          }
          if (Integer.valueOf(arrayOfString[i]).intValue() < Integer.valueOf(paramContext[i]).intValue())
          {
            Ud = false;
            return;
          }
          if (i == 2) {
            Ud = true;
          }
          i += 1;
        }
        return;
      }
      catch (Exception paramContext) {}
    }
  }
  
  public iqi[] a(ipm paramipm)
  {
    if (getViewWidth() > getViewHeight())
    {
      i = getViewWidth();
      bs(this.mContext);
      if ((!Ud) || (getImgWidth() > asb) || (i <= ((ipn)paramipm).lq() / 3 * 2) || (getImgWidth() >= i) || (getImgWidth() == 0) || (this.jdField_a_of_type_Izm.al().size() != 0) || (VideoController.a().b().amI != 2)) {
        break label211;
      }
    }
    label211:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        if (this.jdField_a_of_type_Iqn == null) {
          this.jdField_a_of_type_Iqn = iqn.a();
        }
        super.a(paramipm);
        if (super.getId() != null) {
          this.jdField_a_of_type_Iqn.a(paramipm, getImgWidth(), getImgHeight(), ((ipn)paramipm).lq(), ((ipn)paramipm).lr(), getId()[0], getId()[1], getId()[2], this.ac, this.arZ, asc);
        }
        return iqg.a(0).a();
        i = getViewHeight();
        break;
      }
      return super.a(paramipm);
    }
  }
  
  public void yield()
  {
    super.yield();
    if (this.jdField_a_of_type_Iqn != null) {
      this.jdField_a_of_type_Iqn.release();
    }
    Uc = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     iqr
 * JD-Core Version:    0.7.0.1
 */