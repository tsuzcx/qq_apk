import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class vra
  extends uyw<vpj>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private vrn jdField_a_of_type_Vrn;
  
  public vra(Context paramContext, vrn paramvrn)
  {
    super(paramContext);
    this.jdField_a_of_type_Vrn = paramvrn;
  }
  
  private boolean a(stVideoTag paramstVideoTag)
  {
    if ((this.jdField_a_of_type_Vrn == null) || (this.jdField_a_of_type_Vrn.a == null)) {}
    while ((paramstVideoTag.tagId != 6) || (!TextUtils.equals(this.jdField_a_of_type_Vrn.a.a(), "recommend_tab")) || (a() != 0)) {
      return false;
    }
    return true;
  }
  
  protected void a()
  {
    vpj localvpj = (vpj)a();
    if ((localvpj != null) && ((localvpj.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localvpj.a());
    }
  }
  
  protected int b()
  {
    return 2131560081;
  }
  
  protected void b()
  {
    stVideoTag localstVideoTag;
    if (this.jdField_a_of_type_UserGrowthStSimpleMetaFeed != null)
    {
      localstVideoTag = this.jdField_a_of_type_UserGrowthStSimpleMetaFeed.videoTag;
      if ((localstVideoTag != null) && (!TextUtils.isEmpty(localstVideoTag.text)) && (!a(localstVideoTag))) {}
    }
    else
    {
      a(8);
      return;
    }
    a(0);
    String str;
    Object localObject;
    label103:
    GradientDrawable localGradientDrawable;
    if ((!TextUtils.isEmpty(localstVideoTag.textColor)) && (localstVideoTag.textColor.startsWith("#")))
    {
      str = localstVideoTag.textColor;
      if ((TextUtils.isEmpty(localstVideoTag.bgColor)) || (!localstVideoTag.bgColor.startsWith("#"))) {
        break label204;
      }
      localObject = localstVideoTag.bgColor;
      localGradientDrawable = new GradientDrawable();
      localGradientDrawable.setCornerRadius(vnc.c);
      if (!vnc.a((String)localObject)) {
        break label230;
      }
      label128:
      localGradientDrawable.setColor(Color.parseColor((String)localObject));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localstVideoTag.text);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!vnc.a(str)) {
        break label236;
      }
    }
    for (;;)
    {
      ((TextView)localObject).setTextColor(Color.parseColor(str));
      this.jdField_a_of_type_AndroidWidgetTextView.setBackgroundDrawable(localGradientDrawable);
      return;
      str = "#" + localstVideoTag.textColor;
      break;
      label204:
      localObject = "#" + localstVideoTag.bgColor;
      break label103;
      label230:
      localObject = "#80000000";
      break label128;
      label236:
      str = "#FFFFFF";
    }
  }
  
  protected void c() {}
  
  protected void e()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380770));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vra
 * JD-Core Version:    0.7.0.1
 */