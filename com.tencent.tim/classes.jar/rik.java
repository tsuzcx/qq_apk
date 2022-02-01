import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class rik
{
  public Drawable C;
  public String aAD;
  private int amount = 5;
  private String config;
  public final String id;
  public String logoUrl;
  public String name;
  private float spacing = 0.1F;
  
  public rik(@NonNull String paramString)
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
          break label237;
        }
        if (!"1".equals(this.id)) {
          break label223;
        }
        this.amount = 5;
        this.spacing = 0.1F;
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
          if ((this.amount < 1) || (this.spacing < 0.0F) || (this.spacing >= 0.5D))
          {
            ram.e("FacePackage", "config json is illegal : %s", new Object[] { paramString });
            i = 0;
            break;
          }
          this.config = paramString;
          ram.b("FacePackage", "parse config json success : %s", paramString);
          i = 1;
        }
        catch (Exception localException)
        {
          ram.e("FacePackage", "parse config json error : " + paramString + ", exception : " + localException.toString());
          i = 0;
        }
      }
      break;
      label223:
      this.amount = 3;
      this.spacing = 0.05F;
      continue;
      label237:
      if (!"LocationFacePackage".equals(getType())) {
        break label263;
      }
      this.amount = 2;
      this.spacing = 0.1F;
    }
    label263:
    throw new IllegalStateException("unknown face package, type:" + getType());
  }
  
  public int tu()
  {
    return this.amount;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rik
 * JD-Core Version:    0.7.0.1
 */