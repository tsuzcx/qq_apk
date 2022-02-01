import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class xpq
  extends xms
{
  private String jdField_a_of_type_JavaLangString = "";
  private wlh jdField_a_of_type_Wlh;
  private xhf jdField_a_of_type_Xhf;
  private boolean c;
  
  private void a(QQUserUIItem paramQQUserUIItem, xmt paramxmt)
  {
    paramxmt.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
    paramxmt.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramxmt.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
    paramxmt.jdField_a_of_type_AndroidWidgetTextView.setText(this.jdField_a_of_type_Xmp.b().getString(2131698913, new Object[] { paramQQUserUIItem }));
    paramxmt.jdField_a_of_type_AndroidWidgetTextView.setContentDescription(null);
    paramxmt.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    xmp.a(str, paramxmt.jdField_a_of_type_AndroidWidgetImageView, paramxmt.jdField_a_of_type_AndroidGraphicsDrawableDrawable, paramxmt.jdField_a_of_type_Int, paramxmt.jdField_a_of_type_Int);
    ykq.a("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean a(View paramView)
  {
    if ((this.jdField_a_of_type_Wlh == null) || (this.jdField_a_of_type_Wlh.jdField_a_of_type_Int != 5) || (this.jdField_a_of_type_Wlh.jdField_a_of_type_Wli == null)) {
      this.jdField_a_of_type_Xmp.k();
    }
    while (!super.a(paramView)) {
      return false;
    }
    xbp.a(this.jdField_a_of_type_Xmp.b(), this.jdField_a_of_type_Wlh.jdField_a_of_type_Wli.c, this.jdField_a_of_type_Wlh.jdField_a_of_type_Wli.b, 1010);
    ykv.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(xmt paramxmt, xhf paramxhf)
  {
    ykq.a("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramxhf.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_Xhf = paramxhf;
    Object localObject = paramxhf.a().getVideoLinkInfo();
    if ((localObject == null) || (((wlh)localObject).jdField_a_of_type_Int != 5) || (((wlh)localObject).jdField_a_of_type_Wli == null))
    {
      ykq.b("VipForwardVideoInfoController", "something error, hide()");
      this.jdField_a_of_type_Xmp.k();
      return;
    }
    if (TextUtils.equals(this.jdField_a_of_type_JavaLangString, paramxhf.jdField_a_of_type_JavaLangString)) {
      this.c = false;
    }
    for (;;)
    {
      this.jdField_a_of_type_Wlh = ((wlh)localObject);
      paramxhf = (wke)wjs.a(2);
      localObject = paramxhf.b(this.jdField_a_of_type_Wlh.jdField_a_of_type_Wli.jdField_a_of_type_JavaLangString);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.jdField_a_of_type_Xmp.j();
      a((QQUserUIItem)localObject, paramxmt);
      return;
      this.c = true;
      this.jdField_a_of_type_JavaLangString = paramxhf.jdField_a_of_type_JavaLangString;
    }
    this.jdField_a_of_type_Xmp.k();
    paramxhf.a(this.jdField_a_of_type_Wlh.jdField_a_of_type_Wli.jdField_a_of_type_JavaLangString, new xpr(this, paramxmt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xpq
 * JD-Core Version:    0.7.0.1
 */