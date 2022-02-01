package com.tencent.mobileqq.robotchat;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import aptw;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.lang.ref.WeakReference;

public class RobotChatTipLayout
  extends RelativeLayout
  implements View.OnClickListener
{
  private TextView Yn;
  private ImageView ij;
  private WeakReference<a> mListenerRef;
  
  public RobotChatTipLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(a parama)
  {
    this.mListenerRef = new WeakReference(parama);
    LayoutInflater.from(getContext()).inflate(2131561747, this);
    setClickable(true);
    this.Yn = ((TextView)findViewById(2131380966));
    this.ij = ((ImageView)findViewById(2131369705));
    if (this.ij != null) {
      this.ij.setOnClickListener(this);
    }
    setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
    if (!ThemeUtil.isNowThemeIsNight(null, false, ThemeUtil.curThemeId)) {
      setBackgroundColor(-1);
    }
    for (;;)
    {
      setVisibility(8);
      return;
      setBackgroundColor(-5066062);
      findViewById(2131369728).setBackgroundColor(-10197916);
    }
  }
  
  public void onClick(View paramView)
  {
    if (this.mListenerRef != null)
    {
      a locala = (a)this.mListenerRef.get();
      if (locala != null) {
        locala.a(this);
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void setRobotName(String paramString)
  {
    String str1 = paramString;
    if (TextUtils.isEmpty(paramString)) {
      str1 = getResources().getString(2131718897);
    }
    paramString = BaseApplicationImpl.getApplication().getRuntime();
    String str2;
    if ((paramString != null) && ((paramString instanceof QQAppInterface)))
    {
      str2 = ((aptw)((QQAppInterface)paramString).getManager(203)).tK();
      paramString = str2;
      if (TextUtils.isEmpty(str2)) {}
    }
    int i;
    do
    {
      for (;;)
      {
        try
        {
          paramString = str2.replace("[name]", "%1$s");
          str2 = paramString;
          if (TextUtils.isEmpty(paramString)) {
            str2 = getResources().getString(2131718892);
          }
          paramString = String.format(str2, new Object[] { str1 });
          if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(paramString))) {
            break;
          }
          return;
        }
        catch (Exception paramString)
        {
          QLog.e("RobotChatTipLayout", 2, "setRobotName exception: " + paramString);
        }
        paramString = null;
      }
      i = paramString.indexOf(str1, 4);
    } while (i < 0);
    paramString = new SpannableString(paramString);
    paramString.setSpan(new ForegroundColorSpan(-11692801), i, str1.length() + i, 33);
    if (this.Yn != null) {
      this.Yn.setText(paramString);
    }
    setVisibility(0);
  }
  
  public void unInit()
  {
    this.Yn = null;
    this.mListenerRef = null;
  }
  
  public static abstract interface a
  {
    public abstract void a(RobotChatTipLayout paramRobotChatTipLayout);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.robotchat.RobotChatTipLayout
 * JD-Core Version:    0.7.0.1
 */