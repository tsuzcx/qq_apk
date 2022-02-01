import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.ui.RefreshView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.mobileqq.widget.WebViewProgressBar;
import org.json.JSONObject;

public class avdx
  extends aqzl
{
  private boolean dmL = true;
  private boolean dmM = true;
  private boolean dmN = true;
  
  public avdx(arcd paramarcd)
  {
    super(paramarcd);
    paramarcd = paramarcd.s.getIntent();
    int i = paramarcd.getIntExtra("key_subtab", 0);
    paramarcd.removeExtra("key_subtab");
    if (this.jdField_a_of_type_Arcd$a.eet != i) {
      Yk(i);
    }
  }
  
  public void Tc(boolean paramBoolean)
  {
    super.Tc(paramBoolean);
    if (paramBoolean)
    {
      if (this.dmL) {
        Yj(-1);
      }
      if (this.dmM) {
        Yh(-1);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130851906, 2130851907, 2130851908);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167643);
        this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(14);
      }
    }
    do
    {
      return;
      if (this.dmL) {
        Yj(-16777216);
      }
      if (this.dmM) {
        Yh(-16777216);
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView == null);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonBackgroundResource(2130851920, 2130851921, 2130851922);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setButtonTextColorStateList(2131167651);
    this.jdField_a_of_type_ComTencentMobileqqWebviewUiWebViewTopTabView.setLeftAndRightPaddingByDp(14);
  }
  
  public void bla()
  {
    super.bla();
    if ((this.jdField_a_of_type_Arcd.eQ instanceof RefreshView)) {
      ((RefreshView)this.jdField_a_of_type_Arcd.eQ).uW(false);
    }
    if (this.jdField_a_of_type_Arcd.eG != null) {
      this.jdField_a_of_type_Arcd.eG.setVisibility(8);
    }
    this.jdField_a_of_type_Arcd$a.cYp = true;
    boolean bool;
    if (this.jdField_a_of_type_Arcd$a.ce != null)
    {
      if (!this.jdField_a_of_type_Arcd$a.ce.has("txtclr"))
      {
        bool = true;
        this.dmL = bool;
        if (this.jdField_a_of_type_Arcd$a.ce.has("titleclr")) {
          break label579;
        }
        bool = true;
        label113:
        this.dmM = bool;
        if (this.jdField_a_of_type_Arcd$a.ce.has("bgclr")) {
          break label585;
        }
        bool = true;
        label137:
        this.dmN = bool;
      }
    }
    else
    {
      if (this.dmN)
      {
        int i = this.aK.getPaddingTop();
        int j = this.aK.getPaddingBottom();
        int k = this.aK.getPaddingLeft();
        int m = this.aK.getPaddingRight();
        this.aK.setBackgroundColor(-1);
        this.aK.setPadding(k, i, m, j);
        if (this.jdField_a_of_type_Arcd.c != null)
        {
          this.jdField_a_of_type_Arcd.c.mNeedStatusTrans = true;
          this.jdField_a_of_type_Arcd.c.mActNeedImmersive = true;
          if (this.jdField_a_of_type_Arcd.c.Js == null) {
            this.jdField_a_of_type_Arcd.c.setImmersiveStatus();
          }
          if (this.jdField_a_of_type_Arcd.c.Js != null)
          {
            this.jdField_a_of_type_Arcd.c.Js.setBackgroundColor(-4210753);
            this.jdField_a_of_type_Arcd$a.cYs = true;
          }
        }
      }
      if ((!this.dmN) || (!this.dmM) || (!this.dmL)) {
        this.jdField_a_of_type_Arcd.d(this.jdField_a_of_type_Arcd$a.ce, true);
      }
      if ((this.jdField_a_of_type_Arcd$a.Io & 0x20) != 0L)
      {
        this.leftView.setVisibility(4);
        a("", this.rightViewText.getResources().getString(2131721059), "", false, 0, 0, null, null, null);
        this.rightViewText.setOnClickListener(new avdy(this));
      }
      if ((this.jdField_a_of_type_Arcd$a.Io & 0x40) != 0L)
      {
        this.leftView.setVisibility(4);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.mx.getLayoutParams();
        localLayoutParams.addRule(15);
        localLayoutParams.addRule(9);
        localLayoutParams.leftMargin = aqcx.dip2px(this.mx.getContext(), 15.0F);
        this.mx.setLayoutParams(localLayoutParams);
      }
      if (this.jdField_a_of_type_Arcd$a.eeu != -1) {
        break label601;
      }
      if (((this.jdField_a_of_type_Arcd$a.gK & 0x1000000) <= 0L) && ((this.jdField_a_of_type_Arcd$a.Io & 1L) <= 0L)) {
        break label591;
      }
      dx(0);
    }
    for (;;)
    {
      this.leftView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.centerView.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      this.rightViewText.setShadowLayer(0.0F, 0.0F, 0.0F, 0);
      if (this.jdField_a_of_type_Arcd.mLoadingProgressBar != null) {
        this.jdField_a_of_type_Arcd.mLoadingProgressBar.setVisibility(8);
      }
      return;
      bool = false;
      break;
      label579:
      bool = false;
      break label113;
      label585:
      bool = false;
      break label137;
      label591:
      dx(255);
      continue;
      label601:
      dx(this.jdField_a_of_type_Arcd$a.eeu);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avdx
 * JD-Core Version:    0.7.0.1
 */