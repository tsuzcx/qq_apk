import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class jux
  implements View.OnClickListener
{
  jux(juk paramjuk, int paramInt) {}
  
  public void onClick(View paramView)
  {
    String str;
    if (this.b.abR)
    {
      this.b.abS = true;
      if (this.aDB == 0)
      {
        anot.a(this.b.app, "P_CliOper", "Grp_public", "", "connect", "Clk_num", 0, 0, "", "", "", this.b.a.uin);
        str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qun2pub.html?_wv=1027&scode=" + this.b.mUin;
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PubAccountMoreInfoActivity.bindTroop", 2, "jumpTo:" + str);
      }
      juk.c(this.b, str);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      anot.a(this.b.app, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.b.a.uin);
      str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&power=1&scode=" + this.b.mUin;
      continue;
      anot.a(this.b.app, "P_CliOper", "Grp_public", "", "connect", "Clk_grp", 0, 0, "", "", "", this.b.a.uin);
      str = "https://qun.qq.com/qqweb/m/qun/qun_pub_bind/qunlist.html?_wv=1027&scode=" + this.b.mUin;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jux
 * JD-Core Version:    0.7.0.1
 */