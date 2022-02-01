import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticonview.EmotionInvalidPanelLinearLayout;
import com.tencent.mobileqq.vaswebviewplugin.EmojiHomeUiPlugin;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XPanelContainer;
import java.util.List;
import mqq.os.MqqHandler;

public class afnx
  extends afoi
  implements Handler.Callback, View.OnClickListener
{
  private boolean bZS;
  protected int cSH;
  protected int cSI;
  protected EmoticonPackage d;
  protected Button ga;
  protected LinearLayout iG;
  private MqqHandler q = new aurf(Looper.getMainLooper(), this, true);
  
  public afnx(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt1, int paramInt2, int paramInt3, EmoticonPackage paramEmoticonPackage, afmf paramafmf)
  {
    super(paramQQAppInterface, paramContext, paramInt1, paramInt2, paramInt3, paramafmf);
    this.d = paramEmoticonPackage;
    this.cSH = (XPanelContainer.aLe - (int)paramContext.getResources().getDimension(2131297202));
    if (paramEmoticonPackage.jobType == 4) {}
    for (boolean bool = true;; bool = false)
    {
      this.bZS = bool;
      if (paramEmoticonPackage.mobileFeetype != 4) {
        break;
      }
      this.cSI = 1;
      return;
    }
    this.cSI = 2;
  }
  
  private LinearLayout a(afnx.a parama)
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setBackgroundColor(-16777216);
    localLinearLayout.getBackground().setAlpha(178);
    localLinearLayout.setGravity(16);
    localLinearLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, this.cSH));
    TextView localTextView = new TextView(this.mContext);
    Object localObject = new LinearLayout.LayoutParams(-2, -2);
    ((LinearLayout.LayoutParams)localObject).gravity = 1;
    localTextView.setGravity(1);
    localLinearLayout.addView(localTextView, (ViewGroup.LayoutParams)localObject);
    localObject = new Button(this.mContext);
    ((Button)localObject).setId(2131365570);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-2, (int)(25.0F * this.density));
    ((Button)localObject).setGravity(17);
    localLayoutParams.topMargin = ((int)(10.0F * this.density));
    localLayoutParams.gravity = 1;
    ((Button)localObject).setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839559));
    ((Button)localObject).setTextColor(-14894864);
    ((Button)localObject).setPadding((int)(this.density * 30.0F), 0, (int)(this.density * 30.0F), 0);
    localLinearLayout.addView((View)localObject, localLayoutParams);
    parama.iG = localLinearLayout;
    parama.tips = localTextView;
    parama.gb = ((Button)localObject);
    return localLinearLayout;
  }
  
  private void b(View paramView, afom paramafom)
  {
    if ((paramView == null) || (paramafom == null))
    {
      QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI contentView or info = null");
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "updateUI");
    }
    if (this.bZS)
    {
      paramView.setVisibility(0);
      if (!(paramafom instanceof afmi)) {
        break label107;
      }
    }
    label107:
    for (paramafom = (afmi)paramafom;; paramafom = null)
    {
      if (paramafom == null)
      {
        QLog.e("EmotionCompleteInvalidAdapter", 1, "updateUI emotionInfo = null");
        return;
      }
      paramView = (URLImageView)paramView.findViewById(2131366331);
      paramView.setImageDrawable(paramafom.b(this.mContext, this.density));
      paramView.setVisibility(0);
      return;
      super.a(paramView, paramafom);
      return;
    }
  }
  
  public void MQ(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmotionCompleteInvalidAdapter", 2, "payBack");
    }
    if (18 == paramInt) {
      this.q.sendEmptyMessage(100);
    }
  }
  
  public afll.a a()
  {
    return new afnx.a();
  }
  
  public View a(afll.a parama, int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (afnx.a)parama;
    paramViewGroup = paramView;
    label104:
    int i;
    label261:
    int j;
    label308:
    int m;
    int n;
    if (paramView == null)
    {
      paramViewGroup = new FrameLayout(this.mContext);
      LinearLayout localLinearLayout = a((afnx.a)localObject);
      if (!this.bZS) {
        break label380;
      }
      paramView = afos.a().getView(11);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from inflater");
        }
        parama = new EmotionInvalidPanelLinearLayout(this.mContext, this.d, 7, this.TL);
        if (!this.bZS) {
          break label500;
        }
        recycleView(11, parama);
        paramViewGroup.addView(parama, new FrameLayout.LayoutParams(-1, this.cSH));
        paramViewGroup.addView(localLinearLayout);
        ((afnx.a)localObject).a = ((EmotionInvalidPanelLinearLayout)parama);
        paramViewGroup.setTag(localObject);
      }
    }
    else
    {
      this.ga = ((afnx.a)localObject).gb;
      this.iG = ((afnx.a)localObject).iG;
      paramView = acfp.m(2131705867);
      parama = acfp.m(2131705869);
      if (this.cSI == 2) {
        parama = acfp.m(2131705870);
      }
      parama = acfp.m(2131705863) + parama + "专享,\n开通" + parama + acfp.m(2131705866);
      if (this.d.mobileFeetype != 6) {
        break label510;
      }
      parama = acfp.m(2131705865);
      paramView = acfp.m(2131705860);
      ((afnx.a)localObject).tips.setText(parama);
      ((afnx.a)localObject).gb.setText(paramView);
      ((afnx.a)localObject).gb.setOnClickListener(this);
      i = 0;
      paramInt = 0;
      parama = ((afnx.a)localObject).a;
      int i1 = parama.getChildCount();
      j = 0;
      if (j >= i1) {
        break label666;
      }
      paramView = (LinearLayout)parama.getChildAt(j);
      if (paramInt == 0) {
        break label566;
      }
      paramView.setVisibility(8);
      m = i;
      n = paramInt;
    }
    label380:
    label510:
    int i2;
    label500:
    int k;
    label566:
    do
    {
      j += 1;
      paramInt = n;
      i = m;
      break label308;
      parama = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView smallemotion view from cache");
      parama = paramView;
      break;
      paramView = afos.a().getView(10);
      if (paramView == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from inflater");
        }
        parama = new EmotionInvalidPanelLinearLayout(this.mContext, this.d, 4, this.TL);
        break;
      }
      parama = paramView;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("EmotionCompleteInvalidAdapter", 2, "getEmotionView positon = " + paramInt + ";bigemotion view from cache");
      parama = paramView;
      break;
      recycleView(10, parama);
      break label104;
      if (this.d.mobileFeetype == 2)
      {
        parama = acfp.m(2131705862);
        paramView = acfp.m(2131705864);
        break label261;
      }
      if (this.d.mobileFeetype != 3) {
        break label261;
      }
      parama = acfp.m(2131705861);
      paramView = acfp.m(2131705868);
      break label261;
      i2 = paramView.getChildCount();
      k = 0;
      n = paramInt;
      m = i;
    } while (k >= i2);
    localObject = paramView.getChildAt(k);
    if (i > this.data.size() - 1)
    {
      ((View)localObject).setVisibility(8);
      paramInt = 1;
    }
    for (;;)
    {
      k += 1;
      break;
      ((View)localObject).setVisibility(0);
      b((View)localObject, (afom)this.data.get(i));
      i += 1;
    }
    label666:
    return paramViewGroup;
  }
  
  public EmoticonPackage a()
  {
    return this.d;
  }
  
  public int getCount()
  {
    return 1;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      if (this.iG != null) {
        this.iG.setVisibility(8);
      }
      paramMessage = this.app.getHandler(ChatActivity.class);
      if (paramMessage != null) {
        paramMessage.obtainMessage(41).sendToTarget();
      }
    }
  }
  
  public void onClick(View paramView)
  {
    boolean bool = true;
    if (paramView.getId() == 2131365570)
    {
      if (this.d != null) {
        break label35;
      }
      QLog.e("EmotionCompleteInvalidAdapter", 1, "onClick EP = NULL");
    }
    label35:
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if ((this.d.mobileFeetype != 4) && (this.d.mobileFeetype != 5)) {
          break;
        }
        Object localObject = "mvip.gexinghua.android.sbp_" + this.d.epId;
        String str = "!vip";
        if (this.d.mobileFeetype == 5) {
          str = "!svip";
        }
        str = "https://mc.vip.qq.com/qqwallet/index?aid=" + (String)localObject + "&type=" + str + "&send=0&return_url=jsbridge://qw_charge/emojiPayResultOk";
        localObject = new Intent(this.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", str);
        if ((this.mContext instanceof Activity)) {
          ((Activity)this.mContext).startActivityForResult((Intent)localObject, 4813);
        }
        if (!this.bZS) {
          anot.a(this.app, "CliOper", "", "", "ep_mall", "0X80057B3", 0, 0, this.d.epId, "", "", "");
        }
      }
    } while (this.d.valid);
    if (this.d.jobType == 4) {}
    for (;;)
    {
      EmojiHomeUiPlugin.openEmojiDetailPage((Activity)this.mContext, this.app.getAccount(), 8, String.valueOf(this.d.epId), false, bool);
      break;
      bool = false;
    }
  }
  
  public static class a
    extends afll.a
  {
    public EmotionInvalidPanelLinearLayout a;
    public Button gb;
    public LinearLayout iG;
    public TextView tips;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afnx
 * JD-Core Version:    0.7.0.1
 */