import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class qoa
  extends qmm.b
{
  private boolean aEu;
  private String axL = "";
  private pty jdField_c_of_type_Pty;
  private qjq jdField_c_of_type_Qjq;
  
  private void a(QQUserUIItem paramQQUserUIItem, qmm.c paramc)
  {
    paramc.xj.setVisibility(8);
    paramc.mJ.setVisibility(0);
    String str = paramQQUserUIItem.headUrl;
    paramQQUserUIItem = paramQQUserUIItem.nickName;
    paramc.content.setVisibility(0);
    paramc.content.setText(this.b.getActivity().getString(2131701751, new Object[] { paramQQUserUIItem }));
    paramc.content.setContentDescription(null);
    paramc.imageView.setVisibility(0);
    qmm.a(str, paramc.imageView, paramc.defaultDrawable, paramc.bnm, paramc.bnm);
    ram.b("VipForwardVideoInfoController", "updateUI, nickName:%s,  avatarURL:%s", paramQQUserUIItem, str);
  }
  
  public boolean F(View paramView)
  {
    if ((this.jdField_c_of_type_Pty == null) || (this.jdField_c_of_type_Pty.styleType != 5) || (this.jdField_c_of_type_Pty.a == null)) {
      this.b.hide();
    }
    while (!super.F(paramView)) {
      return false;
    }
    qgg.b(this.b.getActivity(), this.jdField_c_of_type_Pty.a.vid, this.jdField_c_of_type_Pty.a.feedID, 1010);
    rar.a("play_video", "clk_transmit", 0, 0, new String[0]);
    return true;
  }
  
  public void b(qmm.c paramc, qjq paramqjq)
  {
    ram.b("VipForwardVideoInfoController", "doOnBind, forward video:%s", paramqjq.vid);
    this.jdField_c_of_type_Qjq = paramqjq;
    Object localObject = paramqjq.b().getVideoLinkInfo();
    if ((localObject == null) || (((pty)localObject).styleType != 5) || (((pty)localObject).a == null))
    {
      ram.d("VipForwardVideoInfoController", "something error, hide()");
      this.b.hide();
      return;
    }
    if (TextUtils.equals(this.axL, paramqjq.vid)) {
      this.aEu = false;
    }
    for (;;)
    {
      this.jdField_c_of_type_Pty = ((pty)localObject);
      paramqjq = (ptf)psx.a(2);
      localObject = paramqjq.b(this.jdField_c_of_type_Pty.a.avo);
      if ((localObject == null) || (TextUtils.isEmpty(((QQUserUIItem)localObject).nickName))) {
        break;
      }
      this.b.show();
      a((QQUserUIItem)localObject, paramc);
      return;
      this.aEu = true;
      this.axL = paramqjq.vid;
    }
    this.b.hide();
    paramqjq.a(this.jdField_c_of_type_Pty.a.avo, new qob(this, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoa
 * JD-Core Version:    0.7.0.1
 */