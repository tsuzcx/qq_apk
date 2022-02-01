import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.TextView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import java.util.List;
import org.json.JSONObject;
import pb.unify.search.UnifySearchCommon.ResultItem;
import pb.unite.search.DynamicSearch.ResultItem;

public class amqn
  extends amql
{
  public static final String TAG = amqn.class.getSimpleName();
  public boolean cDX;
  public boolean cDY;
  public String desc;
  public String jumpUrl;
  public String title;
  
  protected amqn(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, UnifySearchCommon.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
  }
  
  protected amqn(String paramString, long paramLong, List<String> paramList, int paramInt1, JSONObject paramJSONObject, int paramInt2, DynamicSearch.ResultItem paramResultItem)
  {
    super(paramString, paramLong, paramList, paramInt1, paramJSONObject, paramInt2, paramResultItem);
  }
  
  public void a(amyk paramamyk)
  {
    if (!(paramamyk instanceof amym)) {
      return;
    }
    int i = paramamyk.getView().getLayoutParams().width - aqcx.dip2px(paramamyk.getView().getContext(), 3.0F);
    if (this.jdField_a_of_type_Amqg$a != null) {
      amtn.a(this, paramamyk, true, i);
    }
    if (ThemeUtil.isNowThemeIsNight(BaseApplicationImpl.getApplication().getRuntime(), false, null))
    {
      paramamyk.getTitleView().setTextColor(Color.parseColor("#737373"));
      paramamyk.N().setTextColor(Color.parseColor("#4A4A4A"));
      if (!TextUtils.isEmpty(this.title)) {
        break label192;
      }
      paramamyk.getTitleView().setVisibility(8);
      label104:
      if (!TextUtils.isEmpty(this.desc)) {
        break label254;
      }
      paramamyk.N().setVisibility(8);
      label123:
      if (!this.cDX) {
        break label276;
      }
      paramamyk.getTitleView().setGravity(1);
      paramamyk.N().setGravity(1);
    }
    for (;;)
    {
      if (!TextUtils.isEmpty(this.jumpUrl)) {
        break label295;
      }
      paramamyk.getView().setOnClickListener(null);
      return;
      paramamyk.getTitleView().setTextColor(Color.parseColor("#262626"));
      paramamyk.N().setTextColor(Color.parseColor("#737373"));
      break;
      label192:
      paramamyk.getTitleView().setVisibility(0);
      if (this.cDY)
      {
        paramamyk.getTitleView().setText(amxk.a(paramamyk.getTitleView(), i, 2, this.title, this.jdField_a_of_type_Amxa.words, false, false));
        break label104;
      }
      paramamyk.getTitleView().setText(this.title);
      break label104;
      label254:
      paramamyk.N().setVisibility(0);
      paramamyk.N().setText(this.desc);
      break label123;
      label276:
      paramamyk.getTitleView().setGravity(3);
      paramamyk.N().setGravity(3);
    }
    label295:
    paramamyk.getView().setOnClickListener(this);
  }
  
  public void bx(JSONObject paramJSONObject)
  {
    boolean bool2 = true;
    this.title = paramJSONObject.optString("title");
    this.desc = paramJSONObject.optString("desc");
    if (paramJSONObject.optInt("needCenter") == 1)
    {
      bool1 = true;
      this.cDX = bool1;
      this.jumpUrl = paramJSONObject.optString("jumpUrl");
      if (paramJSONObject.optInt("highlightTitle", 1) != 1) {
        break label109;
      }
    }
    label109:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      this.cDY = bool1;
      this.cbr = paramJSONObject.optString("result_id");
      this.cbP = paramJSONObject.optString("extra_report_info");
      paramJSONObject = paramJSONObject.optJSONObject("imageInfo");
      if (paramJSONObject == null) {
        break label114;
      }
      bw(paramJSONObject);
      return;
      bool1 = false;
      break;
    }
    label114:
    this.jdField_a_of_type_Amqg$a = null;
  }
  
  public void cR(View paramView)
  {
    super.cR(paramView);
    amxk.g((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime(), paramView.getContext(), this.jumpUrl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amqn
 * JD-Core Version:    0.7.0.1
 */