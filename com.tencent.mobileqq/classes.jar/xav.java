import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class xav
  extends wxx
{
  private String jdField_a_of_type_JavaLangString = "";
  private vwm jdField_a_of_type_Vwm;
  private wsk jdField_a_of_type_Wsk;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, wxy paramwxy)
  {
    paramwxy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramwxy.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramwxy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramwxy.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Wxu.b().getString(2131698616, new Object[] { paramQQUserUIItem }));
    paramwxy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramwxy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    wxu.a(str, paramwxy.jdField_a_of_type_AndroidWidgetImageView, paramwxy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramwxy.jdField_a_of_type_Int, paramwxy.jdField_a_of_type_Int);
    xvv.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Vwm == null) || (this.jdField_a_of_type_Vwm.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwn == null)) {
      this.jdField_a_of_type_Wxu.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    wmu.a(this.jdField_a_of_type_Wxu.b(), this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwn.c, this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwn.b, 1010);
    xwa.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(wxy paramwxy, wsk paramwsk)
  {
    xvv.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramwsk.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Wsk = paramwsk;
    Object localObject = paramwsk.a().getVideoLinkInfo();
    if ((localObject == null) || (((vwm)localObject).jdField_a_of_type_Int != 5) || (((vwm)localObject).jdField_a_of_type_Vwn == null))
    {
      xvv.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Wxu.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramwsk.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Vwm = ((vwm)localObject);
      paramwsk = (vvj)vux.a(2);
      localObject = paramwsk.b(this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwn.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Wxu.j();
      a((QQUserUIItem)localObject, paramwxy);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramwsk.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Wxu.k();
    paramwsk.a(this.jdField_a_of_type_Vwm.jdField_a_of_type_Vwn.jdField_a_of_type_JavaLangString, new xaw(this, paramwxy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xav
 * JD-Core Version:    0.7.0.1
 */