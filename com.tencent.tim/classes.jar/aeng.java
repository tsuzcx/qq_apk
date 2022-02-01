import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class aeng
{
  public List<aeng.a> yX = new ArrayList();
  
  public static aeng a(String paramString)
  {
    aeng localaeng = new aeng();
    try
    {
      paramString = new JSONObject(paramString);
      if (paramString.has("QRCodeList"))
      {
        paramString = paramString.optJSONArray("QRCodeList");
        Type localType = new aenh().getClass().getGenericSuperclass();
        localaeng.yX.addAll(aiio.convertFromJSONArray(paramString, localType));
        if (localaeng.yX.size() > 0)
        {
          paramString = new aeng.a();
          paramString.bzR = "default_bg";
          paramString.cNX = 1;
          paramString.cNW = 0;
          paramString.cNV = 0;
          paramString.bzS = "";
          localaeng.yX.add(paramString);
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("QrCodeDisplay.QrCodeConfBean", 2, "parse: " + localaeng.yX.size());
      }
      return localaeng;
    }
    catch (JSONException paramString)
    {
      for (;;)
      {
        paramString.printStackTrace();
      }
    }
  }
  
  public static class a
  {
    @aiin("bkgURL")
    public String bzR = "";
    @aiin("logoColor")
    public String bzS = "";
    @aiin("isStatusBarWhite")
    public int cNV;
    @aiin("isNavBarWhite")
    public int cNW;
    @aiin("needShowLogo")
    public int cNX = 1;
    
    public boolean aho()
    {
      return this.cNV == 1;
    }
    
    public boolean ahp()
    {
      return this.cNW == 1;
    }
    
    public boolean ahq()
    {
      return this.cNX == 1;
    }
    
    public String toString()
    {
      return "QrCodeList{bkgURL = " + this.bzR + ", isStatusBarWhite = " + this.cNV + ", isNavBarWhite = " + this.cNW + ", logoColor = " + this.bzS + ", needShowLogo = " + this.cNX + '}';
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aeng
 * JD-Core Version:    0.7.0.1
 */