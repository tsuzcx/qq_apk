package com.tencent.token.ui;

import android.content.ClipboardManager;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import btmsdkobf.bw;
import com.tencent.token.aau;
import com.tencent.token.aay;
import com.tencent.token.ajr;
import com.tencent.token.avo;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.ss;
import com.tencent.token.tt;
import com.tencent.token.xw;
import com.tencent.token.yd;

public class DownloadPersonalInfoActivity
  extends BaseActivity
  implements View.OnClickListener
{
  public static final String STYLE_PICK = "sp";
  public static final String STYLE_TITLE = "st";
  static final String TAG = "DownloadPersonalInfoActivity";
  boolean isValidate = false;
  Handler mHandler = new Handler(Looper.getMainLooper())
  {
    public final void handleMessage(Message paramAnonymousMessage)
    {
      super.handleMessage(paramAnonymousMessage);
      StringBuilder localStringBuilder = new StringBuilder("msg:");
      localStringBuilder.append(paramAnonymousMessage.what);
      avo.c(localStringBuilder.toString());
    }
  };
  
  public static void starReplace(TextView paramTextView, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder("****");
    localStringBuilder.append(paramString.substring(paramString.length() - 6));
    paramTextView.setText(localStringBuilder.toString());
    paramTextView.setTag(paramString);
  }
  
  void initAccountPart()
  {
    LinearLayout localLinearLayout = (LinearLayout)findViewById(2131165235);
    int j = tt.a().k.a();
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        getLayoutInflater().inflate(2131296363, localLinearLayout);
      }
      QQUser localQQUser = tt.a().a(i);
      View localView = getLayoutInflater().inflate(2131296364, null);
      TextView localTextView = (TextView)localView.findViewById(2131165794);
      Object localObject1 = (ImageView)localView.findViewById(2131165294);
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localQQUser.mRealUin);
      localObject2 = ((StringBuilder)localObject2).toString();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(localQQUser.mUin);
      ((ImageView)localObject1).setImageDrawable(aau.a((String)localObject2, localStringBuilder.toString()));
      if (localQQUser.mIsBinded) {
        localObject1 = localQQUser.mUinMask;
      } else if ((localQQUser.mUinMask != null) && (localQQUser.mUinMask.length() > 0)) {
        localObject1 = localQQUser.mUinMask;
      } else {
        localObject1 = aay.e(localQQUser.mRealUin);
      }
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(localQQUser.mNickName);
      ((StringBuilder)localObject2).append(" (");
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append(")");
      localTextView.setText(((StringBuilder)localObject2).toString());
      localObject1 = (TextView)localView.findViewById(2131166073);
      if (!localQQUser.mIsBinded) {
        ((TextView)localObject1).setText("未身份验证");
      } else {
        ((TextView)localObject1).setText("已身份验证");
      }
      localLinearLayout.addView(localView);
      i += 1;
    }
    if (j == 0) {
      findViewById(2131165471).setVisibility(0);
    }
  }
  
  void initStarPart()
  {
    starReplace((TextView)findViewById(2131165283), xw.b(this));
    starReplace((TextView)findViewById(2131165583), bw.ah().aj());
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject = new StringBuilder("req:");
    ((StringBuilder)localObject).append(paramInt1);
    ((StringBuilder)localObject).append(", result:");
    ((StringBuilder)localObject).append(paramInt2);
    ((StringBuilder)localObject).append(",data:");
    ((StringBuilder)localObject).append(paramIntent);
    avo.c(((StringBuilder)localObject).toString());
    if (((paramInt1 == 1201) || (paramInt1 == 1202)) && (paramIntent != null))
    {
      localObject = paramIntent.getExtras();
      if (localObject == null)
      {
        Toast.makeText(this, "验证失败", 0).show();
        return;
      }
      if (paramInt1 == 1201) {
        paramIntent = "quicklogin_uin";
      } else {
        paramIntent = "uin";
      }
      paramIntent = ((Bundle)localObject).getString(paramIntent);
      if (TextUtils.isEmpty(paramIntent))
      {
        Toast.makeText(this, "验证失败，请稍后再试", 0).show();
        return;
      }
      paramInt2 = tt.a().k.a();
      paramInt1 = 0;
      while (paramInt1 < paramInt2)
      {
        localObject = tt.a().a(paramInt1);
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(((QQUser)localObject).mRealUin);
        if (paramIntent.equals(localStringBuilder.toString()))
        {
          paramInt1 = 1;
          break label217;
        }
        paramInt1 += 1;
      }
      paramInt1 = 0;
      label217:
      if (paramInt1 != 0)
      {
        this.isValidate = true;
        setToClipboard();
        return;
      }
      Toast.makeText(this, "验证失败，请验证已在QQ安全中心登录的帐号", 0).show();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131165469)
    {
      if (!this.isValidate)
      {
        showUserDialog(0, "下载需要前往QQ验证登录信息", "取消", "允许", new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt) {}
        }, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            paramAnonymousDialogInterface = ss.a(DownloadPersonalInfoActivity.this.getApplicationContext());
            DownloadPersonalInfoActivity localDownloadPersonalInfoActivity = DownloadPersonalInfoActivity.this;
            paramAnonymousDialogInterface.a(localDownloadPersonalInfoActivity, localDownloadPersonalInfoActivity.mHandler);
          }
        });
        return;
      }
      setToClipboard();
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296325);
    initAccountPart();
    DeviceInfo2Activity.setInfo(this, false);
    initStarPart();
    findViewById(2131165469).setOnClickListener(this);
  }
  
  void setToClipboard()
  {
    ClipboardManager localClipboardManager = (ClipboardManager)getSystemService("clipboard");
    if (localClipboardManager != null)
    {
      int j = tt.a().k.a();
      String str = "";
      int i = 0;
      while (i < j)
      {
        QQUser localQQUser = tt.a().a(i);
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("QQ帐号");
        i += 1;
        localStringBuilder.append(i);
        localStringBuilder.append("：");
        localStringBuilder.append(localQQUser.mNickName);
        localStringBuilder.append(" (");
        localStringBuilder.append(localQQUser.mRealUin);
        localStringBuilder.append(") ");
        if (localQQUser.mIsBinded) {
          str = "已";
        } else {
          str = "未";
        }
        localStringBuilder.append(str);
        localStringBuilder.append("身份验证\n");
        str = localStringBuilder.toString();
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("Android ID:\t");
      localStringBuilder.append(xw.b(this));
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("GUID:\t");
      localStringBuilder.append(bw.ah().aj());
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("手机型号:\t");
      localStringBuilder.append(yd.a);
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("系统名称:\t");
      localStringBuilder.append(Build.MANUFACTURER);
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("系统版本:\t");
      localStringBuilder.append(DeviceInfo2Activity.getSystemVersion());
      localStringBuilder.append("\n");
      str = localStringBuilder.toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("存储空间:\t");
      localStringBuilder.append(DeviceInfo2Activity.getTotalInternalMemorySize());
      localStringBuilder.append("\n");
      localClipboardManager.setText(localStringBuilder.toString());
      Toast.makeText(this, "已复制到剪贴板", 0).show();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.DownloadPersonalInfoActivity
 * JD-Core Version:    0.7.0.1
 */