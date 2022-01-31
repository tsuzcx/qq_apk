import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ujg
  extends ugi
{
  private String jdField_a_of_type_JavaLangString = "";
  private ter jdField_a_of_type_Ter;
  private uav jdField_a_of_type_Uav;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, ugj paramugj)
  {
    paramugj.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramugj.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramugj.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramugj.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ugf.b().getString(2131699515, new Object[] { paramQQUserUIItem }));
    paramugj.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramugj.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    ugf.a(str, paramugj.jdField_a_of_type_AndroidWidgetImageView, paramugj.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugj.jdField_a_of_type_Int, paramugj.jdField_a_of_type_Int);
    veg.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Ter == null) || (this.jdField_a_of_type_Ter.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Ter.jdField_a_of_type_Tes == null)) {
      this.jdField_a_of_type_Ugf.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    tvf.a(this.jdField_a_of_type_Ugf.b(), this.jdField_a_of_type_Ter.jdField_a_of_type_Tes.c, this.jdField_a_of_type_Ter.jdField_a_of_type_Tes.b, 1010);
    vel.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(ugj paramugj, uav paramuav)
  {
    veg.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramuav.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Uav = paramuav;
    Object localObject = paramuav.a().getVideoLinkInfo();
    if ((localObject == null) || (((ter)localObject).jdField_a_of_type_Int != 5) || (((ter)localObject).jdField_a_of_type_Tes == null))
    {
      veg.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Ugf.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuav.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Ter = ((ter)localObject);
      paramuav = (tdo)tdc.a(2);
      localObject = paramuav.b(this.jdField_a_of_type_Ter.jdField_a_of_type_Tes.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Ugf.j();
      a((QQUserUIItem)localObject, paramugj);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramuav.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Ugf.k();
    paramuav.a(this.jdField_a_of_type_Ter.jdField_a_of_type_Tes.jdField_a_of_type_JavaLangString, new ujh(this, paramugj));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujg
 * JD-Core Version:    0.7.0.1
 */