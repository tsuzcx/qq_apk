import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class xvp
  extends xsr
{
  private String jdField_a_of_type_JavaLangString = "";
  private wrb jdField_a_of_type_Wrb;
  private xne jdField_a_of_type_Xne;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, xss paramxss)
  {
    paramxss.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramxss.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramxss.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxss.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Xso.b().getString(2131698345, new Object[] { paramQQUserUIItem }));
    paramxss.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramxss.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    xso.a(str, paramxss.jdField_a_of_type_AndroidWidgetImageView, paramxss.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxss.jdField_a_of_type_Int, paramxss.jdField_a_of_type_Int);
    yqp.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Wrb == null) || (this.jdField_a_of_type_Wrb.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Wrb.jdField_a_of_type_Wrc == null)) {
      this.jdField_a_of_type_Xso.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    xho.a(this.jdField_a_of_type_Xso.b(), this.jdField_a_of_type_Wrb.jdField_a_of_type_Wrc.c, this.jdField_a_of_type_Wrb.jdField_a_of_type_Wrc.b, 1010);
    yqu.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(xss paramxss, xne paramxne)
  {
    yqp.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramxne.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xne = paramxne;
    Object localObject = paramxne.a().getVideoLinkInfo();
    if ((localObject == null) || (((wrb)localObject).jdField_a_of_type_Int != 5) || (((wrb)localObject).jdField_a_of_type_Wrc == null))
    {
      yqp.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Xso.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxne.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Wrb = ((wrb)localObject);
      paramxne = (wpy)wpm.a(2);
      localObject = paramxne.b(this.jdField_a_of_type_Wrb.jdField_a_of_type_Wrc.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Xso.j();
      a((QQUserUIItem)localObject, paramxss);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxne.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Xso.k();
    paramxne.a(this.jdField_a_of_type_Wrb.jdField_a_of_type_Wrc.jdField_a_of_type_JavaLangString, new xvq(this, paramxss));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xvp
 * JD-Core Version:    0.7.0.1
 */