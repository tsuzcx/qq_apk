import org.json.JSONObject;

public class kjy
{
  public String ZE = "#12B7F5";
  public String ZF = "#F2F2F2";
  public String ZG = "#F2F2F2";
  public String ZH = "#12B7F5";
  public String ZI = "#CCE5E5E5";
  public int aJn = 2;
  public int aJo = 270;
  public int aJp = 0;
  public boolean afV = true;
  public int height = 20;
  public float iB = 2.0F;
  public float iC = 2.0F;
  public float iD = 1.5F;
  public float iE = 1.5F;
  public float iF = 7.0F;
  public int max = 100;
  public int maxHeight = 22;
  public int maxTextSize = 16;
  public int minTextSize = 10;
  public int minWidth = 82;
  public int style;
  public String textColor = "#ffffff";
  public int textSize = 12;
  public int width = 82;
  
  public kjy(int paramInt)
  {
    this.style = paramInt;
  }
  
  public static void a(int paramInt, kjy paramkjy, JSONObject paramJSONObject)
  {
    if (paramJSONObject == null) {
      return;
    }
    paramkjy.style = paramInt;
    paramkjy.width = jzp.o(paramJSONObject.optString("width"), 82);
    paramkjy.minWidth = jzp.o(paramJSONObject.optString("minWidth"), 82);
    if (paramkjy.width < paramkjy.minWidth)
    {
      paramkjy.width = paramkjy.minWidth;
      paramkjy.height = jzp.o(paramJSONObject.optString("height"), 20);
      paramkjy.maxHeight = jzp.o(paramJSONObject.optString("maxHeight"), 22);
      if (paramkjy.height >= 18) {
        break label256;
      }
      paramkjy.height = 18;
      label104:
      paramkjy.iB = jzp.b(paramJSONObject.optString("corner"), 2.0F);
      if (paramkjy.iB >= 2.0F) {
        break label278;
      }
      paramkjy.iB = 2.0F;
    }
    for (;;)
    {
      paramkjy.ZF = paramJSONObject.optString("progressBg", "#F2F2F2");
      paramkjy.ZG = paramJSONObject.optString("secondaryProgressBg", "#F2F2F2");
      paramkjy.ZE = paramJSONObject.optString("progressColor", "#12B7F5");
      paramkjy.textColor = paramJSONObject.optString("textColor", "#ffffff");
      paramkjy.textSize = paramJSONObject.optInt("textSize", 12);
      paramkjy.minTextSize = 10;
      paramkjy.maxTextSize = 16;
      paramkjy.ZH = paramJSONObject.optString("buttonBorderColor", "#12B7F5");
      paramkjy.iC = jzp.b(paramJSONObject.optString("buttonBorderSize", "0"), 0.0F);
      paramkjy.aJn = 2;
      return;
      if (paramkjy.width <= 100) {
        break;
      }
      paramkjy.width = 100;
      break;
      label256:
      if (paramkjy.height <= paramkjy.maxHeight) {
        break label104;
      }
      paramkjy.height = paramkjy.maxHeight;
      break label104;
      label278:
      if (paramkjy.iB > 20.0F) {
        paramkjy.iB = 20.0F;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kjy
 * JD-Core Version:    0.7.0.1
 */