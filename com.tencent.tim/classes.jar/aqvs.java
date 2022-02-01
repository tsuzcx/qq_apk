import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import com.tencent.mobileqq.vip.diy.ProfileTemplateNickNameContainer;
import com.tencent.mobileqq.vip.diy.TemplateLikeView;
import com.tencent.mobileqq.vip.diy.common.DIYImageView;
import com.tencent.mobileqq.widget.ProfileNameView;
import java.util.HashMap;
import org.json.JSONObject;

public class aqvs
  extends awma
{
  private View Cp;
  private TemplateLikeView a;
  private String bWn = "";
  private ProfileNameView d;
  private HashMap<String, View> pr;
  private HashMap<String, awlz> ps;
  
  public aqvs(HashMap<String, View> paramHashMap, String paramString)
  {
    if (paramHashMap == null) {
      throw new RuntimeException("create the QVipProfileJsonInflaterFactory with null profileHeaderViewsMap");
    }
    this.ps = new HashMap();
    this.pr = paramHashMap;
    this.bWn = paramString;
  }
  
  public View a(Context paramContext, String paramString)
  {
    if ("pf_name".equals(paramString))
    {
      if (this.d != null) {
        throw new RuntimeException("It have duplicate " + paramString);
      }
      ram.d("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了昵称控件");
      this.d = new ProfileNameView(paramContext);
      paramContext = new ProfileTemplateNickNameContainer(paramContext, this.d);
      this.pr.put("map_key_profile_nick_name", this.d);
      return paramContext;
    }
    if ("pf_avatar".equals(paramString))
    {
      if (this.Cp != null) {
        throw new RuntimeException("It have duplicate " + paramString);
      }
      ram.d("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了头像控件");
      paramContext = LayoutInflater.from(paramContext).inflate(2131562211, null);
      this.Cp = paramContext.findViewById(2131375405);
      this.pr.put("map_key_profile_diy_nick_container", this.Cp);
      return paramContext;
    }
    if ("pf_like".equals(paramString))
    {
      if (this.a != null) {
        throw new RuntimeException("It have duplicate " + paramString);
      }
      ram.d("DIYProfileTemplate.QVipProfileJsonInflaterFactory", "创建了点赞控件");
      this.a = new TemplateLikeView(paramContext);
      this.a.tA(0);
      this.pr.put("map_key_like", this.a);
      return this.a;
    }
    if ("image_view".equals(paramString)) {
      return new DIYImageView(paramContext);
    }
    return super.a(paramContext, paramString);
  }
  
  public awlz a(String paramString, View paramView)
  {
    if ("pf_name".equals(paramString)) {
      return new aqvq(paramString, paramView, this.bWn);
    }
    if ("pf_avatar".equals(paramString)) {
      return new aqvo(paramString, paramView, this.ps);
    }
    if ("pf_like".equals(paramString)) {
      return new aqvp(paramString, paramView, this.bWn);
    }
    if ("image_view".equals(paramString)) {
      return new aqvu(paramString, paramView, this.bWn);
    }
    return super.a(paramString, paramView);
  }
  
  public void a(awlz paramawlz, JSONObject paramJSONObject)
  {
    Object localObject = paramJSONObject.optString("id");
    if ((!TextUtils.isEmpty((CharSequence)localObject)) && (paramawlz != null)) {
      this.ps.put(localObject, paramawlz);
    }
    if ("pf_avatar".equals(paramJSONObject.optString("type")))
    {
      localObject = paramJSONObject.optString("border", "");
      localObject = (awlz)this.ps.get(localObject);
      if (localObject != null) {
        this.pr.put("map_key_profile_diy_avatar_sticker", ((awlz)localObject).getView());
      }
    }
    super.a(paramawlz, paramJSONObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqvs
 * JD-Core Version:    0.7.0.1
 */