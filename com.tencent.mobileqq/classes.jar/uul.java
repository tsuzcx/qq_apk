import UserGrowth.stSimpleMetaFeed;
import UserGrowth.stVideoTag;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.biz.pubaccount.weishi_new.verticalvideo.WSVerticalPageFragment;

public class uul
  extends uej<usv>
{
  private stSimpleMetaFeed jdField_a_of_type_UserGrowthStSimpleMetaFeed;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private uuy jdField_a_of_type_Uuy;
  
  public uul(Context paramContext, uuy paramuuy)
  {
    super(paramContext);
    this.jdField_a_of_type_Uuy = paramuuy;
  }
  
  private boolean a(stVideoTag paramstVideoTag)
  {
    if ((this.jdField_a_of_type_Uuy == null) || (this.jdField_a_of_type_Uuy.a == null)) {}
    while ((paramstVideoTag.tagId != 6) || (!TextUtils.equals(this.jdField_a_of_type_Uuy.a.a(), "recommend_tab")) || (a() != 0)) {
      return false;
    }
    return true;
  }
  
  protected void a()
  {
    usv localusv = (usv)a();
    if ((localusv != null) && ((localusv.a() instanceof stSimpleMetaFeed))) {
      this.jdField_a_of_type_UserGrowthStSimpleMetaFeed = ((stSimpleMetaFeed)localusv.a());
    }
  }
  
  protected int b()
  {
    return 2131560031;
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
      localGradientDrawable.setCornerRadius(uqs.c);
      if (!uqs.a((String)localObject)) {
        break label230;
      }
      label128:
      localGradientDrawable.setColor(Color.parseColor((String)localObject));
      this.jdField_a_of_type_AndroidWidgetTextView.setText(localstVideoTag.text);
      localObject = this.jdField_a_of_type_AndroidWidgetTextView;
      if (!uqs.a(str)) {
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
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)a(2131380705));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uul
 * JD-Core Version:    0.7.0.1
 */