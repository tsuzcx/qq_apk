import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.view.segment.SegmentList;
import com.tencent.mobileqq.theme.ThemeUtil;

public class vdi
  extends wco
{
  public static final String KEY = "PlaceholderSegment";
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private vap jdField_a_of_type_Vap;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public vdi(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void R_()
  {
    S_();
  }
  
  protected void S_()
  {
    wco localwco = a().a(this.jdField_b_of_type_JavaLangString);
    if ((localwco == null) || (localwco.a() == 0))
    {
      e_(true);
      return;
    }
    e_(false);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, vap paramvap, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramvap.a(2131373313);
    ImageView localImageView = (ImageView)paramvap.a(2131373314);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramViewGroup.setText(ajya.a(2131708199) + ssf.jdField_a_of_type_JavaLangString + "\n拍摄一段小视频，分享眼前的世界");
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        break label104;
      }
      localImageView.setImageResource(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return paramvap.a();
      paramViewGroup.setText(this.jdField_a_of_type_JavaLangString);
      break;
      label104:
      localImageView.setImageResource(this.jdField_a_of_type_Int);
    }
  }
  
  public String a()
  {
    return "PlaceholderSegment";
  }
  
  public vap a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Vap = new vap(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561231, paramViewGroup, false));
    return this.jdField_a_of_type_Vap;
  }
  
  protected void c()
  {
    S_();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Vap == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_Vap.a(2131373314);
    } while (localImageView == null);
    QQStoryContext.a();
    if (ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null))
    {
      localImageView.setImageResource(this.jdField_b_of_type_Int);
      return;
    }
    localImageView.setImageResource(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     vdi
 * JD-Core Version:    0.7.0.1
 */