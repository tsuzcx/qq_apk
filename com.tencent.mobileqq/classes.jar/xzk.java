import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class xzk
  extends xwm
{
  private String jdField_a_of_type_JavaLangString = "";
  private wuw jdField_a_of_type_Wuw;
  private xqz jdField_a_of_type_Xqz;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, xwn paramxwn)
  {
    paramxwn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramxwn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramxwn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxwn.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Xwj.b().getString(2131698447, new Object[] { paramQQUserUIItem }));
    paramxwn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramxwn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    xwj.a(str, paramxwn.jdField_a_of_type_AndroidWidgetImageView, paramxwn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxwn.jdField_a_of_type_Int, paramxwn.jdField_a_of_type_Int);
    yuk.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Wuw == null) || (this.jdField_a_of_type_Wuw.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Wuw.jdField_a_of_type_Wux == null)) {
      this.jdField_a_of_type_Xwj.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    xlj.a(this.jdField_a_of_type_Xwj.b(), this.jdField_a_of_type_Wuw.jdField_a_of_type_Wux.c, this.jdField_a_of_type_Wuw.jdField_a_of_type_Wux.b, 1010);
    yup.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(xwn paramxwn, xqz paramxqz)
  {
    yuk.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramxqz.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xqz = paramxqz;
    Object localObject = paramxqz.a().getVideoLinkInfo();
    if ((localObject == null) || (((wuw)localObject).jdField_a_of_type_Int != 5) || (((wuw)localObject).jdField_a_of_type_Wux == null))
    {
      yuk.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Xwj.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxqz.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Wuw = ((wuw)localObject);
      paramxqz = (wtt)wth.a(2);
      localObject = paramxqz.b(this.jdField_a_of_type_Wuw.jdField_a_of_type_Wux.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Xwj.j();
      a((QQUserUIItem)localObject, paramxwn);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxqz.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Xwj.k();
    paramxqz.a(this.jdField_a_of_type_Wuw.jdField_a_of_type_Wux.jdField_a_of_type_JavaLangString, new xzl(this, paramxwn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xzk
 * JD-Core Version:    0.7.0.1
 */