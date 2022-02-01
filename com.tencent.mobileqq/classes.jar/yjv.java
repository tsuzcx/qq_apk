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

public class yjv
  extends zgz
{
  public static final String KEY = "PlaceholderSegment";
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private yhc jdField_a_of_type_Yhc;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public yjv(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaLangString = paramString1;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
  }
  
  public void P_()
  {
    Q_();
  }
  
  protected void Q_()
  {
    zgz localzgz = a().a(this.jdField_b_of_type_JavaLangString);
    if ((localzgz == null) || (localzgz.a() == 0))
    {
      d_(true);
      return;
    }
    d_(false);
  }
  
  public int a()
  {
    return 1;
  }
  
  public View a(int paramInt, yhc paramyhc, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyhc.a(2131374658);
    ImageView localImageView = (ImageView)paramyhc.a(2131374659);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramViewGroup.setText(anvx.a(2131707647) + vzh.jdField_a_of_type_JavaLangString + "\n拍摄一段小视频，分享眼前的世界");
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        break label104;
      }
      localImageView.setImageResource(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return paramyhc.a();
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
  
  public yhc a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yhc = new yhc(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561663, paramViewGroup, false));
    return this.jdField_a_of_type_Yhc;
  }
  
  protected void c()
  {
    Q_();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Yhc == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_Yhc.a(2131374659);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yjv
 * JD-Core Version:    0.7.0.1
 */