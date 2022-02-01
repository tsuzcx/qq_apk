import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.activity.ProfileActivity.AllInOne;
import com.tencent.mobileqq.vip.diy.template.QZoneLayoutTemplate1;
import com.tencent.mobileqq.widget.ProfileCardFavorShowView;
import java.util.HashMap;
import org.json.JSONObject;

public class aqvz
  extends aqvx
{
  public aqvz(Activity paramActivity, JSONObject paramJSONObject, alcn paramalcn)
  {
    super(paramActivity, paramJSONObject, paramalcn);
    this.mBorderWidth = rpq.dip2px(paramActivity, 4.0F);
  }
  
  public void O(HashMap<String, View> paramHashMap)
  {
    paramHashMap.put("map_key_qzone", this.mInflater.inflate(2131562214, null));
  }
  
  public View a(JSONObject paramJSONObject, View paramView)
  {
    Object localObject = (QZoneLayoutTemplate1)paramView.findViewById(2131369207);
    if (localObject != null)
    {
      ((QZoneLayoutTemplate1)localObject).setBorderWidth(h(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setItemBg(a(paramJSONObject, dip2px(100.0F), dip2px(100.0F)), g(paramJSONObject));
      ((QZoneLayoutTemplate1)localObject).setLeftView(paramJSONObject.optString("ph"));
      ((QZoneLayoutTemplate1)localObject).setRightView(paramJSONObject.optString("ph"));
    }
    localObject = paramView.findViewById(2131368698);
    TextView localTextView = (TextView)paramView.findViewById(2131379562);
    ImageView localImageView = (ImageView)paramView.findViewById(2131368865);
    String str = localTextView.getText().toString();
    if ((this.c.e.pa != 0) && (str.length() > 4) && (str.substring(str.length() - 4, str.length()).equals("QQ空间"))) {
      localTextView.setText(str.substring(0, str.length() - 4) + acfp.m(2131715209));
    }
    a(paramJSONObject, (View)localObject, localTextView, localImageView);
    return paramView;
  }
  
  public ProfileCardFavorShowView a(Activity paramActivity)
  {
    return new ProfileCardFavorShowView(paramActivity, null, 2131562205);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvz
 * JD-Core Version:    0.7.0.1
 */