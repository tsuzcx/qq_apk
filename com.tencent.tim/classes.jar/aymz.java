import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class aymz
{
  public Drawable C;
  public String aAD;
  private int amount = 5;
  public String cXe;
  private String config;
  public boolean dzZ;
  @Deprecated
  public int hide;
  public String id;
  public String logoUrl;
  public int mask;
  public String name;
  public double scale = 1.0D;
  private float spacing = 0.05F;
  
  public aymz(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("FacePackage'id can not be null.");
    }
    this.id = paramString;
  }
  
  public float az()
  {
    return this.spacing;
  }
  
  public abstract String cc(int paramInt);
  
  public abstract int getFaceCount();
  
  public abstract String getType();
  
  public void sz(String paramString)
  {
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      ram.e("FacePackage", "config json is empty.");
      i = 0;
      if (i == 0)
      {
        ram.e("FacePackage", "config json is illegal, use default value, type : %s", new Object[] { getType() });
        if (!"NormalFacePackage".equals(getType())) {
          break label240;
        }
        if (!"1".equals(this.id)) {
          break label226;
        }
        this.amount = 5;
        this.spacing = 0.05F;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.config = null;
        return;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          this.amount = localJSONObject.getInt("amount");
          this.spacing = Float.valueOf(localJSONObject.getString("spacing")).floatValue();
          this.scale = localJSONObject.optDouble("scale", 1.0D);
          if ((this.amount < 1) || (this.spacing < 0.0F) || (this.spacing >= 0.5D))
          {
            ram.e("FacePackage", "config json is illegal : %s", new Object[] { paramString });
            i = 0;
            break;
          }
          this.config = paramString;
          i = 1;
        }
        catch (Exception localException)
        {
          ram.e("FacePackage", "parse config json error : " + paramString + ", exception : " + localException.toString());
          i = 0;
        }
      }
      break;
      label226:
      this.amount = 5;
      this.spacing = 0.05F;
      continue;
      label240:
      if (!"LocationFacePackage".equals(getType())) {
        break label266;
      }
      this.amount = 4;
      this.spacing = 0.1F;
    }
    label266:
    throw new IllegalStateException("unknown face package, type:" + getType());
  }
  
  public int tu()
  {
    return this.amount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     aymz
 * JD-Core Version:    0.7.0.1
 */