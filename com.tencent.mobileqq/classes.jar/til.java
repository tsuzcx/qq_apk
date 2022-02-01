import android.view.ViewGroup;
import org.json.JSONObject;

public class til
{
  public int a;
  public ViewGroup a;
  private rwf a;
  public sab a;
  public tih a;
  public boolean a;
  public int b;
  public boolean b;
  public int c;
  public boolean c;
  public int d;
  public boolean d;
  public int e;
  public boolean e;
  public int f;
  public boolean f;
  
  public til(ViewGroup paramViewGroup, JSONObject paramJSONObject)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Int = 1000;
    this.jdField_e_of_type_Int = -1;
    this.jdField_f_of_type_Int = 0;
    this.jdField_a_of_type_AndroidViewViewGroup = paramViewGroup;
    this.jdField_b_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = -1;
    this.jdField_c_of_type_Int = -1;
    this.jdField_a_of_type_Tih = new tih(paramJSONObject.getJSONObject("video_info"));
    if (paramJSONObject.has("autoplay")) {
      this.jdField_b_of_type_Boolean = paramJSONObject.getBoolean("autoplay");
    }
    if (paramJSONObject.has("muted")) {
      this.jdField_a_of_type_Boolean = paramJSONObject.getBoolean("muted");
    }
    if (paramJSONObject.has("start_position")) {
      this.jdField_a_of_type_Int = paramJSONObject.getInt("start_position");
    }
    if (paramJSONObject.has("width")) {
      this.jdField_b_of_type_Int = paramJSONObject.getInt("width");
    }
    if (paramJSONObject.has("height")) {
      this.jdField_c_of_type_Int = paramJSONObject.getInt("height");
    }
    if (paramJSONObject.has("controls")) {
      this.jdField_c_of_type_Boolean = paramJSONObject.getBoolean("controls");
    }
    if (paramJSONObject.has("resize")) {
      a(paramJSONObject.getString("resize"));
    }
    if (paramJSONObject.has("timeupdateRate")) {
      this.jdField_d_of_type_Int = paramJSONObject.getInt("timeupdateRate");
    }
    if (paramJSONObject.has("barBottomMargin")) {
      this.jdField_e_of_type_Int = paramJSONObject.getInt("barBottomMargin");
    }
    if (paramJSONObject.has("disableFullScreen")) {
      this.jdField_d_of_type_Boolean = paramJSONObject.getBoolean("disableFullScreen");
    }
    if (paramJSONObject.has("disableSeek")) {
      this.jdField_e_of_type_Boolean = paramJSONObject.getBoolean("disableSeek");
    }
    if (paramJSONObject.has("endWithLastFrame")) {
      this.jdField_f_of_type_Boolean = paramJSONObject.getBoolean("endWithLastFrame");
    }
  }
  
  void a(String paramString)
  {
    if (paramString.equals("contain")) {
      this.jdField_f_of_type_Int = 0;
    }
    while (!paramString.equals("cover")) {
      return;
    }
    this.jdField_f_of_type_Int = 2;
  }
  
  public String toString()
  {
    return "VideoPlayParam{videoInfo=" + this.jdField_a_of_type_Tih + ", startPosition=" + this.jdField_a_of_type_Int + ", muted=" + this.jdField_a_of_type_Boolean + ", autoPlay=" + this.jdField_b_of_type_Boolean + ", width=" + this.jdField_b_of_type_Int + ", height=" + this.jdField_c_of_type_Int + ", controls=" + this.jdField_c_of_type_Boolean + ", timeupdateRate=" + this.jdField_d_of_type_Int + ", barBottomMargin=" + this.jdField_e_of_type_Int + ", disableFullScreen=" + this.jdField_d_of_type_Boolean + ", disableSeek=" + this.jdField_e_of_type_Boolean + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     til
 * JD-Core Version:    0.7.0.1
 */