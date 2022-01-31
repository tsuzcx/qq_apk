import android.view.View;
import android.widget.FrameLayout;
import com.tencent.mobileqq.gamecenter.media.GameCenterVideoViewController;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class yoi
{
  public int a;
  public FrameLayout a;
  public GameCenterVideoViewController a;
  public String a;
  public Map<Integer, View> a;
  public boolean a;
  public int b;
  public String b;
  public boolean b;
  public int c;
  public String c;
  public boolean c;
  public int d;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public String i;
  
  public yoi(GameCenterVideoViewController paramGameCenterVideoViewController, FrameLayout paramFrameLayout, Map<Integer, View> paramMap)
  {
    this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController = paramGameCenterVideoViewController;
    this.jdField_a_of_type_AndroidWidgetFrameLayout = paramFrameLayout;
    this.jdField_a_of_type_JavaUtilMap = paramMap;
  }
  
  public String a()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("id", this.jdField_a_of_type_Int);
      localJSONObject.put("x", this.jdField_c_of_type_Int);
      localJSONObject.put("y", this.jdField_b_of_type_Int);
      localJSONObject.put("vid", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("url", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("streamType", this.d);
      localJSONObject.put("protocol", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("mute", this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.b());
      localJSONObject.put("total", this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.b());
      localJSONObject.put("current", this.jdField_a_of_type_ComTencentMobileqqGamecenterMediaGameCenterVideoViewController.a());
      localJSONObject.put("autoPlay", this.jdField_b_of_type_Boolean);
      localJSONObject.put("isFullScreen", this.jdField_c_of_type_Boolean);
      return localJSONObject.toString();
    }
    catch (JSONException localJSONException)
    {
      for (;;)
      {
        localJSONException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yoi
 * JD-Core Version:    0.7.0.1
 */