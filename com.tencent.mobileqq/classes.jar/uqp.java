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

public class uqp
  extends vpv
{
  public static final String KEY = "PlaceholderSegment";
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private unw jdField_a_of_type_Unw;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public uqp(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void T_()
  {
    U_();
  }
  
  protected void U_()
  {
    vpv localvpv = a().a(this.jdField_b_of_type_JavaLangString);
    if ((localvpv == null) || (localvpv.a() == 0))
    {
      f_(true);
      return;
    }
    f_(false);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, unw paramunw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramunw.a(2131307598);
    ImageView localImageView = (ImageView)paramunw.a(2131307599);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramViewGroup.setText(ajjy.a(2131642403) + sfm.jdField_a_of_type_JavaLangString + "\n拍摄一段小视频，分享眼前的世界");
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        break label104;
      }
      localImageView.setImageResource(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return paramunw.a();
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
  
  public unw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Unw = new unw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131495641, paramViewGroup, false));
    return this.jdField_a_of_type_Unw;
  }
  
  protected void c()
  {
    U_();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Unw == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_Unw.a(2131307599);
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
 * Qualified Name:     uqp
 * JD-Core Version:    0.7.0.1
 */