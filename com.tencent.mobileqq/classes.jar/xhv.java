import android.graphics.drawable.Drawable;
import org.json.JSONArray;
import org.json.JSONObject;

public class xhv
{
  public Drawable a;
  public String a;
  public xhw a;
  public String b;
  public String c;
  public String d;
  public String e;
  
  public xhv()
  {
    this.jdField_a_of_type_Xhw = new xhw();
  }
  
  public boolean a()
  {
    if (this.jdField_a_of_type_Xhw == null) {
      this.jdField_a_of_type_Xhw = new xhw();
    }
    try
    {
      JSONObject localJSONObject = new JSONObject(this.e);
      int i = localJSONObject.getInt("align");
      Object localObject = localJSONObject.getJSONArray("picture_margin");
      int j = ((JSONArray)localObject).getInt(0);
      int k = ((JSONArray)localObject).getInt(1);
      int m = ((JSONArray)localObject).getInt(2);
      int n = ((JSONArray)localObject).getInt(3);
      localObject = localJSONObject.getString("text_color");
      int i1 = localJSONObject.getInt("text_size");
      int i2 = localJSONObject.getInt("picture_width");
      int i3 = localJSONObject.getInt("picture_height");
      int i4 = localJSONObject.getInt("standard_width");
      int i5 = localJSONObject.getInt("standard_height");
      this.jdField_a_of_type_Xhw.jdField_a_of_type_Int = i;
      this.jdField_a_of_type_Xhw.jdField_a_of_type_ArrayOfInt = new int[] { j, k, m, n };
      this.jdField_a_of_type_Xhw.jdField_a_of_type_JavaLangString = ((String)localObject);
      this.jdField_a_of_type_Xhw.b = i1;
      this.jdField_a_of_type_Xhw.c = i2;
      this.jdField_a_of_type_Xhw.d = i3;
      this.jdField_a_of_type_Xhw.e = i4;
      this.jdField_a_of_type_Xhw.f = i5;
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return false;
  }
  
  public String toString()
  {
    return "Item{thumbUrl='" + this.jdField_a_of_type_JavaLangString + '\'' + ", name='" + this.b + '\'' + ", desc='" + this.c + '\'' + ", imageUrl='" + this.d + '\'' + ", imageDrawable=" + this.jdField_a_of_type_AndroidGraphicsDrawableDrawable + ", layoutJson='" + this.e + '\'' + ", params=" + this.jdField_a_of_type_Xhw + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     xhv
 * JD-Core Version:    0.7.0.1
 */