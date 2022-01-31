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

public class wwj
  extends xvp
{
  public static final String KEY = "PlaceholderSegment";
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private wtq jdField_a_of_type_Wtq;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public wwj(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void W_()
  {
    X_();
  }
  
  protected void X_()
  {
    xvp localxvp = a().a(this.jdField_b_of_type_JavaLangString);
    if ((localxvp == null) || (localxvp.a() == 0))
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
  
  public View a(int paramInt, wtq paramwtq, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramwtq.a(2131373813);
    ImageView localImageView = (ImageView)paramwtq.a(2131373814);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramViewGroup.setText(alud.a(2131708583) + ulg.jdField_a_of_type_JavaLangString + "\n拍摄一段小视频，分享眼前的世界");
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        break label104;
      }
      localImageView.setImageResource(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return paramwtq.a();
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
  
  public wtq a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Wtq = new wtq(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561439, paramViewGroup, false));
    return this.jdField_a_of_type_Wtq;
  }
  
  protected void c()
  {
    X_();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Wtq == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_Wtq.a(2131373814);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wwj
 * JD-Core Version:    0.7.0.1
 */