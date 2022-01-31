import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class wce
  extends vzg
{
  private String jdField_a_of_type_JavaLangString = "";
  private uxp jdField_a_of_type_Uxp;
  private vtt jdField_a_of_type_Vtt;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, vzh paramvzh)
  {
    paramvzh.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramvzh.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramvzh.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvzh.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vzd.b().getString(2131699893, new Object[] { paramQQUserUIItem }));
    paramvzh.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramvzh.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    vzd.a(str, paramvzh.jdField_a_of_type_AndroidWidgetImageView, paramvzh.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvzh.jdField_a_of_type_Int, paramvzh.jdField_a_of_type_Int);
    wxe.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Uxp == null) || (this.jdField_a_of_type_Uxp.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxq == null)) {
      this.jdField_a_of_type_Vzd.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    vod.a(this.jdField_a_of_type_Vzd.b(), this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxq.c, this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxq.b, 1010);
    wxj.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(vzh paramvzh, vtt paramvtt)
  {
    wxe.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramvtt.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Vtt = paramvtt;
    Object localObject = paramvtt.a().getVideoLinkInfo();
    if ((localObject == null) || (((uxp)localObject).jdField_a_of_type_Int != 5) || (((uxp)localObject).jdField_a_of_type_Uxq == null))
    {
      wxe.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Vzd.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvtt.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Uxp = ((uxp)localObject);
      paramvtt = (uwm)uwa.a(2);
      localObject = paramvtt.b(this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxq.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Vzd.j();
      a((QQUserUIItem)localObject, paramvzh);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramvtt.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Vzd.k();
    paramvtt.a(this.jdField_a_of_type_Uxp.jdField_a_of_type_Uxq.jdField_a_of_type_JavaLangString, new wcf(this, paramvzh));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wce
 * JD-Core Version:    0.7.0.1
 */