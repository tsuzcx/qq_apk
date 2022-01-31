import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class vxv
  extends vux
{
  private String jdField_a_of_type_JavaLangString = "";
  private utg jdField_a_of_type_Utg;
  private vpk jdField_a_of_type_Vpk;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, vuy paramvuy)
  {
    paramvuy.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramvuy.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramvuy.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramvuy.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Vuu.b().getString(2131699881, new Object[] { paramQQUserUIItem }));
    paramvuy.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramvuy.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    vuu.a(str, paramvuy.jdField_a_of_type_AndroidWidgetImageView, paramvuy.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramvuy.jdField_a_of_type_Int, paramvuy.jdField_a_of_type_Int);
    wsv.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Utg == null) || (this.jdField_a_of_type_Utg.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Utg.jdField_a_of_type_Uth == null)) {
      this.jdField_a_of_type_Vuu.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    vju.a(this.jdField_a_of_type_Vuu.b(), this.jdField_a_of_type_Utg.jdField_a_of_type_Uth.c, this.jdField_a_of_type_Utg.jdField_a_of_type_Uth.b, 1010);
    wta.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(vuy paramvuy, vpk paramvpk)
  {
    wsv.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramvpk.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Vpk = paramvpk;
    Object localObject = paramvpk.a().getVideoLinkInfo();
    if ((localObject == null) || (((utg)localObject).jdField_a_of_type_Int != 5) || (((utg)localObject).jdField_a_of_type_Uth == null))
    {
      wsv.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Vuu.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramvpk.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Utg = ((utg)localObject);
      paramvpk = (usd)urr.a(2);
      localObject = paramvpk.b(this.jdField_a_of_type_Utg.jdField_a_of_type_Uth.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Vuu.j();
      a((QQUserUIItem)localObject, paramvuy);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramvpk.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Vuu.k();
    paramvpk.a(this.jdField_a_of_type_Utg.jdField_a_of_type_Uth.jdField_a_of_type_JavaLangString, new vxw(this, paramvuy));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vxv
 * JD-Core Version:    0.7.0.1
 */