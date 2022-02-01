package com.tencent.mobileqq.activity.qwallet.redpacket.specify;

import aafh;
import aagd;
import acfp;
import android.content.Context;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anyo.a;
import aqcx;
import aqdj;
import aqgv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForQQWalletMsg;
import com.tencent.mobileqq.data.QQWalletRedPacketMsg;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteVideoView;
import java.util.Iterator;
import java.util.List;

public class SpecifyGiftView
  extends RelativeLayout
{
  private SpriteVideoView a;
  private boolean bvn = true;
  private MessageForQQWalletMsg c;
  private ImageView mCloseBtn;
  private int mVideoHeight;
  private int mVideoWidth;
  private View zu;
  
  public SpecifyGiftView(Context paramContext, MessageForQQWalletMsg paramMessageForQQWalletMsg)
  {
    super(paramContext);
    this.c = paramMessageForQQWalletMsg;
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    addView(localLinearLayout);
    localLinearLayout.setOrientation(1);
    Object localObject = (RelativeLayout.LayoutParams)localLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject).width = -2;
    ((RelativeLayout.LayoutParams)localObject).height = -2;
    ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
    this.a = new SpriteVideoView(paramContext, true);
    this.mVideoWidth = aqcx.dip2px(paramContext, 325.0F);
    this.mVideoHeight = aqcx.dip2px(paramContext, 350.0F);
    this.a.setPivotX(this.mVideoWidth / 2);
    this.a.setPivotY(this.mVideoHeight / 2);
    paramContext = new RelativeLayout(paramContext);
    paramContext.addView(this.a);
    localLinearLayout.addView(paramContext);
    localObject = (LinearLayout.LayoutParams)paramContext.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject).width = this.mVideoWidth;
    ((LinearLayout.LayoutParams)localObject).height = this.mVideoHeight;
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    this.a.setId(2131375520);
    this.zu = a(paramMessageForQQWalletMsg, localLinearLayout);
    paramMessageForQQWalletMsg = new ImageView(getContext());
    paramContext.addView(paramMessageForQQWalletMsg);
    paramContext = (RelativeLayout.LayoutParams)paramMessageForQQWalletMsg.getLayoutParams();
    paramContext.width = aqcx.dip2px(getContext(), 40.0F);
    paramContext.height = aqcx.dip2px(getContext(), 40.0F);
    paramContext.topMargin = aqcx.dip2px(getContext(), 20.0F);
    paramContext.addRule(7, 2131375520);
    paramContext.addRule(6, 2131375520);
    paramMessageForQQWalletMsg.setScaleType(ImageView.ScaleType.FIT_XY);
    int i = aqcx.dip2px(getContext(), 16.0F);
    paramMessageForQQWalletMsg.setPadding(i, 0, 0, i);
    paramMessageForQQWalletMsg.setImageResource(2130848048);
    this.mCloseBtn = paramMessageForQQWalletMsg;
  }
  
  private View a(MessageForQQWalletMsg paramMessageForQQWalletMsg, LinearLayout paramLinearLayout)
  {
    QQAppInterface localQQAppInterface = aagd.getQQAppInterface();
    if (localQQAppInterface == null) {
      return null;
    }
    int i = aqcx.dip2px(getContext(), 15.0F);
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramLinearLayout.addView(localRelativeLayout);
    paramLinearLayout = (LinearLayout.LayoutParams)localRelativeLayout.getLayoutParams();
    paramLinearLayout.width = -2;
    paramLinearLayout.height = (aqcx.dip2px(getContext(), 100.0F) + i);
    paramLinearLayout.gravity = 1;
    paramLinearLayout = new LinearLayout(getContext());
    localRelativeLayout.addView(paramLinearLayout);
    paramLinearLayout.setBackgroundResource(2130848230);
    paramLinearLayout.setOrientation(1);
    Object localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = (aqcx.dip2px(getContext(), 70.0F) + i * 2);
    ((RelativeLayout.LayoutParams)localObject1).addRule(12, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    paramLinearLayout.setPadding(aqcx.dip2px(getContext(), 30.0F), i, aqcx.dip2px(getContext(), 30.0F), i);
    TextView localTextView1 = new TextView(getContext());
    localTextView1.setTextColor(-16777216);
    localTextView1.setTextSize(1, 11.0F);
    paramLinearLayout.addView(localTextView1);
    localObject1 = (LinearLayout.LayoutParams)localTextView1.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = -2;
    ((LinearLayout.LayoutParams)localObject1).height = -2;
    ((LinearLayout.LayoutParams)localObject1).gravity = 1;
    ((LinearLayout.LayoutParams)localObject1).topMargin = aqcx.dip2px(getContext(), 20.0F);
    TextView localTextView2 = new TextView(getContext());
    localTextView2.setTextColor(-16777216);
    localTextView2.setTextSize(1, 18.0F);
    paramLinearLayout.addView(localTextView2);
    paramLinearLayout = (LinearLayout.LayoutParams)localTextView2.getLayoutParams();
    paramLinearLayout.width = -2;
    paramLinearLayout.height = -2;
    paramLinearLayout.gravity = 1;
    paramLinearLayout = new LinearLayout(getContext());
    paramLinearLayout.setOrientation(0);
    localRelativeLayout.addView(paramLinearLayout);
    localObject1 = (RelativeLayout.LayoutParams)paramLinearLayout.getLayoutParams();
    ((RelativeLayout.LayoutParams)localObject1).width = -2;
    ((RelativeLayout.LayoutParams)localObject1).height = -2;
    ((RelativeLayout.LayoutParams)localObject1).addRule(14, -1);
    i = aqcx.dip2px(getContext(), 1.0F);
    ImageView localImageView = new ImageView(getContext());
    paramLinearLayout.addView(localImageView);
    localObject1 = (LinearLayout.LayoutParams)localImageView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = aqcx.dip2px(getContext(), 40.0F);
    ((LinearLayout.LayoutParams)localObject1).height = aqcx.dip2px(getContext(), 40.0F);
    localImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    localImageView.setPadding(i, i, i, i);
    localImageView.setBackgroundResource(2130848229);
    View localView = new View(getContext());
    paramLinearLayout.addView(localView);
    localObject1 = (LinearLayout.LayoutParams)localView.getLayoutParams();
    ((LinearLayout.LayoutParams)localObject1).width = aqcx.dip2px(getContext(), 13.0F);
    ((LinearLayout.LayoutParams)localObject1).height = aqcx.dip2px(getContext(), 10.0F);
    ((LinearLayout.LayoutParams)localObject1).leftMargin = aqcx.dip2px(getContext(), 13.0F);
    ((LinearLayout.LayoutParams)localObject1).rightMargin = aqcx.dip2px(getContext(), 23.0F);
    ((LinearLayout.LayoutParams)localObject1).gravity = 16;
    localObject1 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
    long l;
    while (((Iterator)localObject1).hasNext())
    {
      l = ((Long)((Iterator)localObject1).next()).longValue();
      localObject2 = new ImageView(getContext());
      paramLinearLayout.addView((View)localObject2);
      localObject3 = (LinearLayout.LayoutParams)((ImageView)localObject2).getLayoutParams();
      ((LinearLayout.LayoutParams)localObject3).width = aqcx.dip2px(getContext(), 40.0F);
      ((LinearLayout.LayoutParams)localObject3).height = aqcx.dip2px(getContext(), 40.0F);
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      ((LinearLayout.LayoutParams)localObject3).leftMargin = (-aqcx.dip2px(getContext(), 10.0F));
      ((ImageView)localObject2).setImageDrawable(aqdj.a(localQQAppInterface, String.valueOf(l), (byte)3));
      ((ImageView)localObject2).setBackgroundResource(2130848229);
      ((ImageView)localObject2).setPadding(i, i, i, i);
    }
    paramLinearLayout = aqgv.b(localQQAppInterface, paramMessageForQQWalletMsg.senderuin, true);
    Object localObject3 = aagd.b(getContext(), paramLinearLayout, 90.0F, localTextView1.getPaint());
    Object localObject2 = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.iterator();
    paramLinearLayout = "";
    i = 0;
    localObject1 = paramLinearLayout;
    String str;
    if (((Iterator)localObject2).hasNext())
    {
      l = ((Long)((Iterator)localObject2).next()).longValue();
      str = aqgv.b(localQQAppInterface, l + "", true);
      if (i <= 0) {
        break label1166;
      }
    }
    label1166:
    for (localObject1 = paramLinearLayout + "、";; localObject1 = paramLinearLayout)
    {
      localObject1 = (String)localObject1 + str;
      if ((i > 0) && (((String)localObject1).length() > 13)) {}
      for (;;)
      {
        i += 1;
        if (i >= 2)
        {
          localObject1 = paramLinearLayout;
          localObject2 = (String)localObject3 + acfp.m(2131714696) + (String)localObject1;
          i = paramMessageForQQWalletMsg.mQQWalletRedPacketMsg.specifyUinList.size();
          paramLinearLayout = (LinearLayout)localObject2;
          if (i >= 2) {
            paramLinearLayout = (String)localObject2 + acfp.m(2131714693) + i + acfp.m(2131714694);
          }
          paramLinearLayout = new SpannableStringBuilder(paramLinearLayout);
          paramLinearLayout.setSpan(new ForegroundColorSpan(-1694379), 0, ((String)localObject3).length(), 33);
          paramLinearLayout.setSpan(new StyleSpan(1), 0, ((String)localObject3).length(), 33);
          paramLinearLayout.setSpan(new ForegroundColorSpan(-1694379), ((String)localObject3).length() + 2, ((String)localObject3).length() + 3 + ((String)localObject1).length(), 33);
          localObject2 = new StyleSpan(1);
          i = ((String)localObject3).length();
          int j = ((String)localObject3).length();
          paramLinearLayout.setSpan(localObject2, i + 2, ((String)localObject1).length() + (j + 3), 33);
          localTextView1.setText(paramLinearLayout);
          localTextView1.setMaxLines(1);
          localTextView2.setText(acfp.m(2131714695));
          localImageView.setImageDrawable(aqdj.a(localQQAppInterface, String.valueOf(paramMessageForQQWalletMsg.senderuin), (byte)3));
          localView.setBackgroundResource(2130848228);
          return localRelativeLayout;
        }
        break;
        paramLinearLayout = (LinearLayout)localObject1;
      }
    }
  }
  
  public void a(String paramString, anyo.a parama, View.OnClickListener paramOnClickListener)
  {
    if (this.bvn)
    {
      this.a.a(paramString, parama);
      if (this.zu != null)
      {
        this.zu.setAlpha(0.0F);
        this.zu.animate().alpha(1.0F).setDuration(500L).start();
      }
    }
    for (;;)
    {
      this.mCloseBtn.setOnClickListener(new aafh(this, parama, paramOnClickListener));
      aagd.k(this.mCloseBtn, 0.6F);
      return;
      if (parama != null) {
        parama.byj();
      }
    }
  }
  
  public void stop()
  {
    if (this.a != null) {
      this.a.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.redpacket.specify.SpecifyGiftView
 * JD-Core Version:    0.7.0.1
 */