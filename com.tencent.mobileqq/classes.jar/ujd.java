import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ujd
  extends ugf
{
  private String jdField_a_of_type_JavaLangString = "";
  private teo jdField_a_of_type_Teo;
  private uas jdField_a_of_type_Uas;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, ugg paramugg)
  {
    paramugg.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramugg.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramugg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramugg.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ugc.b().getString(2131699526, new Object[] { paramQQUserUIItem }));
    paramugg.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramugg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    ugc.a(str, paramugg.jdField_a_of_type_AndroidWidgetImageView, paramugg.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramugg.jdField_a_of_type_Int, paramugg.jdField_a_of_type_Int);
    ved.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Teo == null) || (this.jdField_a_of_type_Teo.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Teo.jdField_a_of_type_Tep == null)) {
      this.jdField_a_of_type_Ugc.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    tvc.a(this.jdField_a_of_type_Ugc.b(), this.jdField_a_of_type_Teo.jdField_a_of_type_Tep.c, this.jdField_a_of_type_Teo.jdField_a_of_type_Tep.b, 1010);
    vei.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(ugg paramugg, uas paramuas)
  {
    ved.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramuas.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Uas = paramuas;
    Object localObject = paramuas.a().getVideoLinkInfo();
    if ((localObject == null) || (((teo)localObject).jdField_a_of_type_Int != 5) || (((teo)localObject).jdField_a_of_type_Tep == null))
    {
      ved.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Ugc.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramuas.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Teo = ((teo)localObject);
      paramuas = (tdl)tcz.a(2);
      localObject = paramuas.b(this.jdField_a_of_type_Teo.jdField_a_of_type_Tep.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Ugc.j();
      a((QQUserUIItem)localObject, paramugg);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramuas.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Ugc.k();
    paramuas.a(this.jdField_a_of_type_Teo.jdField_a_of_type_Tep.jdField_a_of_type_JavaLangString, new uje(this, paramugg));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     ujd
 * JD-Core Version:    0.7.0.1
 */