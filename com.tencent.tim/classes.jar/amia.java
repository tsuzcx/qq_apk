import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.TextView;
import com.etrump.mixlayout.ETTextView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.richstatus.RichStatus;
import com.tencent.mobileqq.richstatus.sign.BoxShadowLayout;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;

public class amia
  extends amib
{
  public int count;
  public String feedsId;
  public int istroop;
  public String title;
  public int titleColor;
  public int tplId;
  TextView tvTitle;
  public long uniseq;
  
  public amia(Context paramContext, AppInterface paramAppInterface, View paramView, String paramString)
  {
    super(paramContext, paramAppInterface, paramView, paramString);
    this.type = 2;
    this.dCa = 2130847024;
    VasWebviewUtil.reportCommercialDrainage(paramAppInterface.getCurrentAccountUin(), "signature_aio", "show", "", 0, 0, 0, "", "", "", "", "", "", "", 0, 0, 0, 0);
  }
  
  protected int IJ()
  {
    return 3;
  }
  
  public View a(RichStatus paramRichStatus)
  {
    paramRichStatus = super.a(paramRichStatus);
    this.tvTitle.setText(this.title);
    this.tvTitle.setTextColor(this.titleColor);
    this.l.mMsgId = this.uniseq;
    dNF();
    return paramRichStatus;
  }
  
  protected boolean avR()
  {
    return true;
  }
  
  protected void initViews()
  {
    this.dBZ = wja.dp2px(16.0F, this.context.getResources());
    super.initViews();
    this.tvTitle = new TextView(this.context);
    this.titleColor = this.context.getResources().getColor(2131166732);
    this.tvTitle.setTextColor(this.titleColor);
    this.tvTitle.setTextSize(1, 12.0F);
    this.tvTitle.setGravity(17);
    int i = wja.dp2px(36.0F, this.context.getResources());
    Object localObject = new FrameLayout.LayoutParams(-1, i);
    this.a.addView(this.tvTitle, (ViewGroup.LayoutParams)localObject);
    this.a.setYOffset(i + wja.dp2px(10.0F, this.context.getResources()));
    i = (int)(ankt.SCREEN_WIDTH * 0.11F);
    this.a.Ut(i);
    localObject = (ViewGroup.MarginLayoutParams)this.GG.getLayoutParams();
    localObject = (ViewGroup.MarginLayoutParams)this.l.getLayoutParams();
    ((ViewGroup.MarginLayoutParams)localObject).bottomMargin = wja.dp2px(12.0F, this.context.getResources());
    ((ViewGroup.MarginLayoutParams)localObject).topMargin = wja.dp2px(12.0F, this.context.getResources());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amia
 * JD-Core Version:    0.7.0.1
 */