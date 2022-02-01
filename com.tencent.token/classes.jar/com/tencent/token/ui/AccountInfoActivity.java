package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.token.aau;
import com.tencent.token.aay;
import com.tencent.token.ajr;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.tt;

public class AccountInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String STYLE_PICK = "sp";
  public static final String STYLE_TITLE = "st";
  
  public void onClick(View paramView) {}
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296286);
    setTitle(getIntent().getStringExtra("st"));
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131165222);
    int j = getIntent().getIntExtra("sp", 1);
    int k = tt.a().k.a();
    int i = 0;
    while (i < k)
    {
      if (i > 0) {
        getLayoutInflater().inflate(2131296363, localLinearLayout);
      }
      QQUser localQQUser = tt.a().a(i);
      View localView = getLayoutInflater().inflate(2131296364, null);
      TextView localTextView = (TextView)localView.findViewById(2131165794);
      paramBundle = (ImageView)localView.findViewById(2131165294);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localQQUser.mRealUin);
      localObject = ((StringBuilder)localObject).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQUser.mUin);
      paramBundle.setImageDrawable(aau.a((String)localObject, localStringBuilder.toString()));
      if (localQQUser.mIsBinded) {
        paramBundle = localQQUser.mUinMask;
      } else if ((localQQUser.mUinMask != null) && (localQQUser.mUinMask.length() > 0)) {
        paramBundle = localQQUser.mUinMask;
      } else {
        paramBundle = aay.e(localQQUser.mRealUin);
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(localQQUser.mNickName);
      ((StringBuilder)localObject).append(" (");
      ((StringBuilder)localObject).append(paramBundle);
      ((StringBuilder)localObject).append(")");
      localTextView.setText(((StringBuilder)localObject).toString());
      paramBundle = (TextView)localView.findViewById(2131166073);
      if (j == 1) {
        paramBundle.setVisibility(4);
      }
      if (!localQQUser.mIsBinded)
      {
        if (j == 2) {
          paramBundle.setText("未验证");
        } else {
          paramBundle.setText("未开启");
        }
      }
      else if (j == 2) {
        paramBundle.setText("已验证");
      } else {
        paramBundle.setText("已开启");
      }
      localLinearLayout.addView(localView);
      i += 1;
    }
    if (k == 0) {
      findViewById(2131165471).setVisibility(0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.AccountInfoActivity
 * JD-Core Version:    0.7.0.1
 */