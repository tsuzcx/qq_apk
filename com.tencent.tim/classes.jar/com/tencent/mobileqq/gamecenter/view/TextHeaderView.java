package com.tencent.mobileqq.gamecenter.view;

import acfp;
import ahtz;
import ahuh;
import ahur;
import ahus;
import ahut;
import ahuu;
import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anug;
import anux;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.data.MessageForStructing;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.web.QQGameMsgInfo;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import wja;

public class TextHeaderView
  extends RelativeLayout
  implements ahuh
{
  private ImageView Ay;
  private TextView TV;
  private RelativeLayout fs;
  private Button gm;
  private TextView mDate;
  private ImageView mIcon;
  private TextView mTitle;
  private String mUrl;
  private TextView tk;
  
  public TextHeaderView(Context paramContext)
  {
    super(paramContext);
  }
  
  public void a(MessageRecord paramMessageRecord, Activity paramActivity)
  {
    if (!(paramMessageRecord instanceof MessageForStructing)) {}
    MessageForStructing localMessageForStructing;
    do
    {
      return;
      localMessageForStructing = (MessageForStructing)paramMessageRecord;
    } while (!(localMessageForStructing.structingMsg instanceof StructMsgForGeneralShare));
    try
    {
      Object localObject1 = (StructMsgForGeneralShare)localMessageForStructing.structingMsg;
      this.mUrl = ((StructMsgForGeneralShare)localObject1).mMsgUrl;
      Object localObject2 = (anug)((ArrayList)((StructMsgForGeneralShare)localObject1).getStructMsgItemLists()).get(1);
      this.fs = new RelativeLayout(getContext());
      localObject1 = new RelativeLayout.LayoutParams(wja.dp2px(355.0F, getResources()), -1);
      ((RelativeLayout.LayoutParams)localObject1).addRule(14);
      this.Ay = new ImageView(getContext());
      Object localObject3 = new RelativeLayout.LayoutParams(-1, wja.dp2px(293.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = wja.dp2px(46.0F, getResources());
      this.Ay.setScaleType(ImageView.ScaleType.FIT_XY);
      this.fs.addView(this.Ay, (ViewGroup.LayoutParams)localObject3);
      localObject3 = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-1, wja.dp2px(283.0F, getResources()));
      localLayoutParams.topMargin = wja.dp2px(46.0F, getResources());
      ((RelativeLayout)localObject3).setPadding(wja.dp2px(20.0F, getResources()), 0, wja.dp2px(20.0F, getResources()), 0);
      this.fs.addView((View)localObject3, localLayoutParams);
      this.mTitle = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = wja.dp2px(60.0F, getResources());
      localLayoutParams.addRule(10);
      localLayoutParams.addRule(14);
      this.mTitle.setTextColor(-16777216);
      this.mTitle.setTextSize(18.0F);
      this.mTitle.setId(2131367859);
      ((RelativeLayout)localObject3).addView(this.mTitle, localLayoutParams);
      this.mDate = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = wja.dp2px(6.0F, getResources());
      localLayoutParams.addRule(14);
      localLayoutParams.addRule(3, 2131367859);
      this.mDate.setTextSize(14.0F);
      this.mDate.setTextColor(-7829368);
      ((RelativeLayout)localObject3).addView(this.mDate, localLayoutParams);
      this.tk = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(3, 2131367859);
      localLayoutParams.topMargin = wja.dp2px(56.0F, getResources());
      this.tk.setTextColor(-16777216);
      this.tk.setTextSize(14.0F);
      ((RelativeLayout)localObject3).addView(this.tk, localLayoutParams);
      this.TV = new TextView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.topMargin = wja.dp2px(106.0F, getResources());
      localLayoutParams.addRule(3, 2131367859);
      this.TV.setTextSize(14.0F);
      this.TV.setTextColor(-7829368);
      ((RelativeLayout)localObject3).addView(this.TV, localLayoutParams);
      this.gm = new Button(getContext());
      localObject3 = new RelativeLayout.LayoutParams(wja.dp2px(188.0F, getResources()), wja.dp2px(51.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).topMargin = wja.dp2px(296.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      this.gm.setText(acfp.m(2131715248));
      this.gm.setTextColor(-1);
      this.gm.setBackgroundResource(2130839524);
      this.fs.addView(this.gm, (ViewGroup.LayoutParams)localObject3);
      this.mIcon = new ImageView(getContext());
      localObject3 = new RelativeLayout.LayoutParams(wja.dp2px(92.0F, getResources()), wja.dp2px(92.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject3).addRule(10);
      ((RelativeLayout.LayoutParams)localObject3).addRule(14);
      this.mIcon.setBackgroundColor(0);
      this.fs.addView(this.mIcon, (ViewGroup.LayoutParams)localObject3);
      localObject3 = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png");
      this.Ay.setBackgroundDrawable((Drawable)localObject3);
      this.mTitle.setText(((anux)((anug)localObject2).rz.get(1)).text);
      this.mDate.setText(((anux)((anug)localObject2).rz.get(0)).text);
      this.tk.setText(((anux)((anug)localObject2).rz.get(2)).text);
      this.TV.setText(((anux)((anug)localObject2).rz.get(3)).text);
      localObject2 = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png");
      this.mIcon.setImageDrawable((Drawable)localObject2);
      this.gm.setBackgroundDrawable(ahtz.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.gm.setOnClickListener(new ahur(this, paramActivity, paramMessageRecord, localMessageForStructing));
      this.fs.setOnClickListener(new ahus(this, paramActivity, paramMessageRecord, localMessageForStructing));
      addView(this.fs, (ViewGroup.LayoutParams)localObject1);
      return;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("TextHeaderView", 2, "textHeader parse error " + paramMessageRecord.toString());
    }
  }
  
  public void a(QQGameMsgInfo paramQQGameMsgInfo, Activity paramActivity, int paramInt)
  {
    try
    {
      this.mUrl = paramQQGameMsgInfo.url;
      this.fs = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(wja.dp2px(355.0F, getResources()), -1);
      localLayoutParams1.addRule(14);
      this.Ay = new ImageView(getContext());
      Object localObject = new RelativeLayout.LayoutParams(-1, wja.dp2px(293.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = wja.dp2px(46.0F, getResources());
      this.Ay.setScaleType(ImageView.ScaleType.FIT_XY);
      this.fs.addView(this.Ay, (ViewGroup.LayoutParams)localObject);
      localObject = new RelativeLayout(getContext());
      RelativeLayout.LayoutParams localLayoutParams2 = new RelativeLayout.LayoutParams(-1, wja.dp2px(283.0F, getResources()));
      localLayoutParams2.topMargin = wja.dp2px(46.0F, getResources());
      ((RelativeLayout)localObject).setPadding(wja.dp2px(20.0F, getResources()), 0, wja.dp2px(20.0F, getResources()), 0);
      this.fs.addView((View)localObject, localLayoutParams2);
      this.mTitle = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = wja.dp2px(60.0F, getResources());
      localLayoutParams2.addRule(10);
      localLayoutParams2.addRule(14);
      this.mTitle.setTextColor(-16777216);
      this.mTitle.setTextSize(18.0F);
      this.mTitle.setId(2131367859);
      ((RelativeLayout)localObject).addView(this.mTitle, localLayoutParams2);
      this.mDate = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = wja.dp2px(6.0F, getResources());
      localLayoutParams2.addRule(14);
      localLayoutParams2.addRule(3, 2131367859);
      this.mDate.setTextSize(14.0F);
      this.mDate.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.mDate, localLayoutParams2);
      this.tk = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.addRule(3, 2131367859);
      localLayoutParams2.topMargin = wja.dp2px(56.0F, getResources());
      this.tk.setTextColor(-16777216);
      this.tk.setTextSize(14.0F);
      ((RelativeLayout)localObject).addView(this.tk, localLayoutParams2);
      this.TV = new TextView(getContext());
      localLayoutParams2 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams2.topMargin = wja.dp2px(106.0F, getResources());
      localLayoutParams2.addRule(3, 2131367859);
      this.TV.setTextSize(14.0F);
      this.TV.setTextColor(-7829368);
      ((RelativeLayout)localObject).addView(this.TV, localLayoutParams2);
      this.gm = new Button(getContext());
      localObject = new RelativeLayout.LayoutParams(wja.dp2px(188.0F, getResources()), wja.dp2px(51.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).topMargin = wja.dp2px(296.0F, getResources());
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.gm.setText(acfp.m(2131715248));
      this.gm.setTextColor(-1);
      this.gm.setBackgroundResource(2130839524);
      this.fs.addView(this.gm, (ViewGroup.LayoutParams)localObject);
      this.mIcon = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(wja.dp2px(92.0F, getResources()), wja.dp2px(92.0F, getResources()));
      ((RelativeLayout.LayoutParams)localObject).addRule(10);
      ((RelativeLayout.LayoutParams)localObject).addRule(14);
      this.mIcon.setBackgroundColor(0);
      this.fs.addView(this.mIcon, (ViewGroup.LayoutParams)localObject);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190412143112_EarvNaW2y5.png");
      this.Ay.setBackgroundDrawable((Drawable)localObject);
      this.mTitle.setText(paramQQGameMsgInfo.title);
      this.mDate.setText(paramQQGameMsgInfo.dateTitle);
      this.tk.setText(paramQQGameMsgInfo.contentText);
      this.TV.setText(paramQQGameMsgInfo.limitText);
      localObject = URLDrawable.getDrawable("https://qzonestyle.gtimg.cn/aoi/sola/20190408192858_cRS59qwdjG.png");
      this.mIcon.setImageDrawable((Drawable)localObject);
      this.gm.setBackgroundDrawable(ahtz.a("https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big_click@2x.png", "https://cmshow.gtimg.cn/client/gameCenter/gameCenter_headerImage_button_big@2x.png", getContext()));
      this.gm.setOnClickListener(new ahut(this, paramActivity, paramQQGameMsgInfo, paramInt));
      this.fs.setOnClickListener(new ahuu(this, paramActivity, paramQQGameMsgInfo, paramInt));
      addView(this.fs, localLayoutParams1);
      return;
    }
    catch (Throwable paramQQGameMsgInfo)
    {
      QLog.e("TextHeaderView", 2, "textHeader parse error " + paramQQGameMsgInfo.toString());
    }
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.view.TextHeaderView
 * JD-Core Version:    0.7.0.1
 */