package com.tencent.token.widget;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.token.aay;
import com.tencent.token.core.bean.QQUser;

public class CloseAccountDialog
  extends Dialog
{
  private QQUser a;
  private Context b;
  private View.OnClickListener c;
  private View.OnClickListener d;
  
  public CloseAccountDialog(Context paramContext, QQUser paramQQUser, View.OnClickListener paramOnClickListener1, final View.OnClickListener paramOnClickListener2)
  {
    super(paramContext, 2131558763);
    this.a = paramQQUser;
    this.b = paramContext;
    this.c = paramOnClickListener1;
    this.d = paramOnClickListener2;
    setContentView(2131296310);
    paramQQUser = (TextView)findViewById(2131166154);
    paramOnClickListener1 = (TextView)findViewById(2131165764);
    paramOnClickListener2 = (CheckBox)findViewById(2131165393);
    TextView localTextView1 = (TextView)findViewById(2131165802);
    TextView localTextView2 = (TextView)findViewById(2131165364);
    ImageView localImageView = (ImageView)findViewById(2131165599);
    paramContext = (TextView)findViewById(2131165394);
    paramQQUser.setText("帐号退出或注销");
    if (this.a.mIsBinded) {
      paramOnClickListener1.setText("温馨提示：注销QQ安全中心帐号后，该QQ号下绑定的QQ安全中心全部数据将被全部清空，QQ登录保护、QQ邮箱保护、游戏保护状态均被关闭，且清空后无法恢复，请谨慎操作。\n");
    } else {
      paramOnClickListener1.setText("温馨提示：注销QQ安全中心帐号后，该QQ号下绑定的QQ安全中心全部数据将被全部清空。清空后无法恢复，请谨慎操作。\n");
    }
    localTextView1.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        CloseAccountDialog.this.dismiss();
        if (CloseAccountDialog.a(CloseAccountDialog.this) == null) {
          return;
        }
        CloseAccountDialog.a(CloseAccountDialog.this).onClick(paramAnonymousView);
      }
    });
    localTextView2.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        if (!paramOnClickListener2.isChecked())
        {
          Toast.makeText(CloseAccountDialog.b(CloseAccountDialog.this), "请先阅读并同意帐号注销协议", 0).show();
          return;
        }
        CloseAccountDialog.this.dismiss();
        if (CloseAccountDialog.c(CloseAccountDialog.this) == null) {
          return;
        }
        CloseAccountDialog.c(CloseAccountDialog.this).onClick(paramAnonymousView);
      }
    });
    localImageView.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        CloseAccountDialog.this.dismiss();
      }
    });
    paramQQUser = new ClickableSpan()
    {
      public final void onClick(View paramAnonymousView)
      {
        aay.a((Activity)CloseAccountDialog.b(CloseAccountDialog.this), "https://sdi.3g.qq.com/v/2021080215070611137");
      }
      
      public final void updateDrawState(TextPaint paramAnonymousTextPaint)
      {
        paramAnonymousTextPaint.setColor(-16740609);
      }
    };
    paramOnClickListener1 = new SpannableString("同意《QQ安全中心帐号注销协议》");
    paramOnClickListener1.setSpan(paramQQUser, 2, 15, 33);
    paramContext.setMovementMethod(LinkMovementMethod.getInstance());
    paramContext.setText(paramOnClickListener1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.widget.CloseAccountDialog
 * JD-Core Version:    0.7.0.1
 */