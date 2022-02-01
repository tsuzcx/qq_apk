import android.text.TextUtils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class lan
{
  private HashMap<String, String> dA = new HashMap();
  private HashMap<String, String> dz = new HashMap();
  private List<lan.a> gW = new ArrayList();
  
  public lan.a a(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramInt >= 0)
    {
      localObject1 = localObject2;
      if (paramInt < this.gW.size()) {
        localObject1 = (lan.a)this.gW.get(paramInt);
      }
    }
    return localObject1;
  }
  
  public String eF(String paramString)
  {
    return (String)this.dz.get(paramString);
  }
  
  public String eG(String paramString)
  {
    return (String)this.dA.get(paramString);
  }
  
  public String k(int paramInt, String paramString)
  {
    String str2 = "";
    lan.a locala = a(paramInt);
    String str1 = str2;
    if (locala != null)
    {
      str1 = str2;
      if (!TextUtils.isEmpty(paramString))
      {
        if (!"style_ID".equalsIgnoreCase(paramString)) {
          break label46;
        }
        str1 = locala.adW;
      }
    }
    return str1;
    label46:
    return (String)locala.dB.get(paramString);
  }
  
  public int of()
  {
    return this.gW.size();
  }
  
  public class a
  {
    public String adW;
    public String adX;
    public HashMap<String, String> dB;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lan
 * JD-Core Version:    0.7.0.1
 */