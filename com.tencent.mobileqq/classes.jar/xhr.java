import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import org.json.JSONObject;

public abstract class xhr
{
  private float jdField_a_of_type_Float = 0.1F;
  private int jdField_a_of_type_Int = 5;
  public Drawable a;
  public final String a;
  public String b;
  public String c;
  public String d;
  private String e;
  
  public xhr(@NonNull String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      throw new IllegalStateException("FacePackage'id can not be null.");
    }
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public abstract String a();
  
  public void a(String paramString)
  {
    int i;
    if (TextUtils.isEmpty(paramString))
    {
      wxe.e("FacePackage", "config json is empty.");
      i = 0;
      if (i == 0)
      {
        wxe.e("FacePackage", "config json is illegal, use default value, type : %s", new Object[] { a() });
        if (!"NormalFacePackage".equals(a())) {
          break label237;
        }
        if (!"1".equals(this.jdField_a_of_type_JavaLangString)) {
          break label223;
        }
        this.jdField_a_of_type_Int = 5;
        this.jdField_a_of_type_Float = 0.1F;
      }
    }
    for (;;)
    {
      for (;;)
      {
        this.e = null;
        return;
        try
        {
          JSONObject localJSONObject = new JSONObject(paramString);
          this.jdField_a_of_type_Int = localJSONObject.getInt("amount");
          this.jdField_a_of_type_Float = Float.valueOf(localJSONObject.getString("spacing")).floatValue();
          if ((this.jdField_a_of_type_Int < 1) || (this.jdField_a_of_type_Float < 0.0F) || (this.jdField_a_of_type_Float >= 0.5D))
          {
            wxe.e("FacePackage", "config json is illegal : %s", new Object[] { paramString });
            i = 0;
            break;
          }
          this.e = paramString;
          wxe.a("FacePackage", "parse config json success : %s", paramString);
          i = 1;
        }
        catch (Exception localException)
        {
          wxe.e("FacePackage", "parse config json error : " + paramString + ", exception : " + localException.toString());
          i = 0;
        }
      }
      break;
      label223:
      this.jdField_a_of_type_Int = 3;
      this.jdField_a_of_type_Float = 0.05F;
      continue;
      label237:
      if (!"LocationFacePackage".equals(a())) {
        break label263;
      }
      this.jdField_a_of_type_Int = 2;
      this.jdField_a_of_type_Float = 0.1F;
    }
    label263:
    throw new IllegalStateException("unknown face package, type:" + a());
  }
  
  public abstract int b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhr
 * JD-Core Version:    0.7.0.1
 */