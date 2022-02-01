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

public class ytp
  extends zsv
{
  public static final String KEY = "PlaceholderSegment";
  private int jdField_a_of_type_Int;
  private String jdField_a_of_type_JavaLangString;
  private yqw jdField_a_of_type_Yqw;
  private int jdField_b_of_type_Int;
  private String jdField_b_of_type_JavaLangString;
  
  public ytp(Context paramContext, String paramString1, String paramString2, int paramInt1, int paramInt2)
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
    zsv localzsv = a().a(this.jdField_b_of_type_JavaLangString);
    if ((localzsv == null) || (localzsv.a() == 0))
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
  
  public View a(int paramInt, yqw paramyqw, ViewGroup paramViewGroup)
  {
    paramViewGroup = (TextView)paramyqw.a(2131374652);
    ImageView localImageView = (ImageView)paramyqw.a(2131374653);
    if (TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
    {
      paramViewGroup.setText(anzj.a(2131707068) + win.jdField_a_of_type_JavaLangString + "\n拍摄一段小视频，分享眼前的世界");
      QQStoryContext.a();
      if (!ThemeUtil.isNowThemeIsNight(QQStoryContext.a(), false, null)) {
        break label104;
      }
      localImageView.setImageResource(this.jdField_b_of_type_Int);
    }
    for (;;)
    {
      return paramyqw.a();
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
  
  public yqw a(int paramInt, ViewGroup paramViewGroup)
  {
    this.jdField_a_of_type_Yqw = new yqw(LayoutInflater.from(this.jdField_a_of_type_AndroidContentContext).inflate(2131561716, paramViewGroup, false));
    return this.jdField_a_of_type_Yqw;
  }
  
  protected void c()
  {
    U_();
  }
  
  public void e()
  {
    super.e();
    if (this.jdField_a_of_type_Yqw == null) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.jdField_a_of_type_Yqw.a(2131374653);
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
 * Qualified Name:     ytp
 * JD-Core Version:    0.7.0.1
 */