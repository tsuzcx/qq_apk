import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class twk
  extends ttm
{
  private String jdField_a_of_type_JavaLangString = "";
  private srv jdField_a_of_type_Srv;
  private tnz jdField_a_of_type_Tnz;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, ttn paramttn)
  {
    paramttn.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramttn.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramttn.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramttn.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Ttj.b().getString(2131633733, new Object[] { paramQQUserUIItem }));
    paramttn.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramttn.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    ttj.a(str, paramttn.jdField_a_of_type_AndroidWidgetImageView, paramttn.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramttn.jdField_a_of_type_Int, paramttn.jdField_a_of_type_Int);
    urk.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Srv == null) || (this.jdField_a_of_type_Srv.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Srv.jdField_a_of_type_Srw == null)) {
      this.jdField_a_of_type_Ttj.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    tij.a(this.jdField_a_of_type_Ttj.b(), this.jdField_a_of_type_Srv.jdField_a_of_type_Srw.c, this.jdField_a_of_type_Srv.jdField_a_of_type_Srw.b, 1010);
    urp.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(ttn paramttn, tnz paramtnz)
  {
    urk.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramtnz.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Tnz = paramtnz;
    Object localObject = paramtnz.a().getVideoLinkInfo();
    if ((localObject == null) || (((srv)localObject).jdField_a_of_type_Int != 5) || (((srv)localObject).jdField_a_of_type_Srw == null))
    {
      urk.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Ttj.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramtnz.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Srv = ((srv)localObject);
      paramtnz = (sqs)sqg.a(2);
      localObject = paramtnz.b(this.jdField_a_of_type_Srv.jdField_a_of_type_Srw.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Ttj.j();
      a((QQUserUIItem)localObject, paramttn);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramtnz.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Ttj.k();
    paramtnz.a(this.jdField_a_of_type_Srv.jdField_a_of_type_Srw.jdField_a_of_type_JavaLangString, new twl(this, paramttn));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     twk
 * JD-Core Version:    0.7.0.1
 */