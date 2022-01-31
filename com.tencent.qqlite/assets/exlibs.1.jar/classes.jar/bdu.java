import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.common.util.SubString;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.QQMapActivity;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsShareMsg.Builder;
import com.tencent.mobileqq.structmsg.AbsStructMsgElement;
import com.tencent.mobileqq.structmsg.AbsStructMsgItem;
import com.tencent.mobileqq.structmsg.StructMsgElementFactory;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;

public class bdu
  implements View.OnClickListener
{
  public bdu(QQMapActivity paramQQMapActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = SubString.a(this.a.o, 45, "UTF-8", "...");
    String str1 = SubString.a(this.a.l, 90, "UTF-8", "...");
    Object localObject1 = "我在这里，点击查看：http://maps.google.com/maps?q=" + this.a.a + "," + this.a.b + "&iwloc=A&hl=zh-CN (" + str1 + ")";
    Object localObject2 = this.a.getResources().getString(2131363820);
    String str2 = "mqqapi://app/action?pkg=com.tencent.qqlite&cmp=com.tencent.biz.PoiMapActivity&type=sharedmap&lat=" + this.a.a + "&lon=" + this.a.b + "&title=" + paramView + "&loc=" + str1;
    localObject1 = new AbsShareMsg.Builder(StructMsgForGeneralShare.class).c(32).a((String)localObject2).d((String)localObject1).a("plugin", str2, str2, str2, str2).a();
    localObject2 = StructMsgElementFactory.a(2);
    ((AbsStructMsgItem)localObject2).a("http://pub.idqqimg.com/pc/misc/lbsshare_icon.jpg", paramView, str1);
    ((AbsShareMsg)localObject1).addItem((AbsStructMsgElement)localObject2);
    paramView = new Intent(this.a, ForwardRecentActivity.class);
    paramView.putExtra("forward_type", -3);
    paramView.putExtra("stuctmsg_bytes", ((AbsShareMsg)localObject1).getBytes());
    QQMapActivity.b(this.a, paramView, 0);
    ReportController.b(null, "P_CliOper", "Pb_account_lifeservice", "", "sdk_locate", "click_send", 0, 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bdu
 * JD-Core Version:    0.7.0.1
 */