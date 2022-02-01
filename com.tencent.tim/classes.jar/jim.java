import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Handler;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.av.app.VideoAppInterface;
import com.tencent.av.redpacket.AVRedPacketManager;
import com.tencent.av.redpacket.ui.RedPacketRollNumberView;
import com.tencent.av.redpacket.ui.RedPacketShareFragment;
import com.tencent.av.ui.AVActivity;
import com.tencent.av.ui.redbag.ResultUI.2;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicFragmentActivityForVideo;
import com.tencent.mobileqq.portal.StrokeTextView;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;
import java.util.List;

public class jim
  extends jit
  implements View.OnClickListener
{
  public boolean Zy;
  public boolean Zz;
  public jim.a a;
  public iya b;
  public jil b;
  public Bitmap bA;
  public Bitmap bB;
  public Bitmap bC;
  public Bitmap bD;
  private Bitmap bE;
  private Bitmap bF;
  public Bitmap bi;
  public Bitmap mBackground;
  
  jim(jht paramjht)
  {
    super(paramjht);
  }
  
  private String a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    paramContext = paramContext.getString(paramInt1);
    return paramContext + paramInt2 + "/" + paramInt3;
  }
  
  RelativeLayout a(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = (RelativeLayout)paramAVActivity.findViewById(2131377210);
    if (localRelativeLayout != null) {
      return localRelativeLayout;
    }
    paramAVActivity = (RelativeLayout)paramAVActivity.getLayoutInflater().inflate(2131559962, (RelativeLayout)paramAVActivity.findViewById(2131373916)).findViewById(2131377210);
    n(paramAVActivity);
    return paramAVActivity;
  }
  
  com.tencent.util.Pair<String, String> a(jil paramjil)
  {
    acfp.m(2131713928);
    String str2;
    String str1;
    switch (paramjil.aAj)
    {
    case 7: 
    case 9: 
    default: 
      str2 = "网络异常，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      str3 = str1;
      if (TextUtils.isEmpty(str1)) {
        if (!TextUtils.isEmpty(paramjil.Ss)) {
          break label290;
        }
      }
      break;
    }
    label290:
    for (String str3 = "请到消息窗口点击红包补领。\n";; str3 = paramjil.Ss)
    {
      QLog.w(this.TAG, 1, "getErrorTips, resultCode[" + paramjil.Sp + "], js_state[" + paramjil.Sq + "], mRedbagErrorType[" + paramjil.aAj + "], defMsg[" + paramjil.Ss + "], title[" + str2 + "], err[" + str3 + "]");
      return new com.tencent.util.Pair(str2, str3);
      if (this.jdField_b_of_type_Jil.Zx)
      {
        str2 = acfp.m(2131713927);
        str1 = acfp.m(2131713925);
        break;
      }
      str2 = "未同意服务协议，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
      if (this.jdField_b_of_type_Jil.Zx)
      {
        str2 = acfp.m(2131713926);
        str1 = acfp.m(2131713931);
        break;
      }
      str2 = "因政策要求，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
      if (this.jdField_b_of_type_Jil.Zx)
      {
        str2 = "对方未实名认证，\n红包金额无法到账。";
        str1 = acfp.m(2131713921);
        break;
      }
      str2 = "未作实名认证，\n无法领取红包。";
      str1 = acfp.m(2131713924);
      break;
      str2 = "因收起到悬浮窗，\n无法领取红包。";
      str1 = "请到消息窗口点击红包补领。\n";
      break;
    }
  }
  
  void a(AVActivity paramAVActivity, RelativeLayout paramRelativeLayout)
  {
    View localView = paramRelativeLayout.findViewById(2131374192);
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)this.mApp.a(6);
    if (this.bi == null) {
      this.bi = localAVRedPacketManager.o("qav_redpacket_result_close.png");
    }
    if (this.bi != null) {
      localView.setBackgroundDrawable(jlg.a(paramAVActivity.getResources(), this.bi, 2131166288));
    }
    localView.setOnClickListener(this);
    paramRelativeLayout.findViewById(2131374196).setOnTouchListener(new jio(this));
  }
  
  void a(jil paramjil, jim.a parama)
  {
    this.jdField_b_of_type_Jil = paramjil;
    paramjil = this.mApp.getCurrentAccountUin();
    this.jdField_b_of_type_Jil.Zx = TextUtils.equals(paramjil, this.jdField_b_of_type_Jil.Sl);
    this.a = parama;
    paramjil = getAVActivity();
    QLog.w(this.TAG, 1, "show, mStarter[" + this.jdField_b_of_type_Jil.Zx + "], mGotMoney[" + this.jdField_b_of_type_Jil.St + "], avActivity[" + paramjil + "]");
    awT();
  }
  
  void awB()
  {
    if (this.jdField_b_of_type_Iya != null)
    {
      this.mApp.deleteObserver(this.jdField_b_of_type_Iya);
      this.jdField_b_of_type_Iya = null;
    }
  }
  
  public void awC()
  {
    if (this.jdField_b_of_type_Iya != null) {
      return;
    }
    QLog.w(this.TAG, 1, "listenOnActivityEvent,  mStarter[" + this.jdField_b_of_type_Jil.Zx + "], mPlayUin[" + this.jdField_b_of_type_Jil.Sm + "], mStartUin[" + this.jdField_b_of_type_Jil.Sl + "]");
    this.jdField_b_of_type_Iya = new jin(this);
    this.mApp.addObserver(this.jdField_b_of_type_Iya);
  }
  
  void awT()
  {
    this.mApp.getHandler().post(new ResultUI.2(this));
  }
  
  public void b(AVActivity paramAVActivity, jil paramjil)
  {
    Object localObject1 = (RelativeLayout)paramAVActivity.findViewById(2131377210);
    if ((localObject1 == null) || (paramjil == null))
    {
      paramAVActivity = this.TAG;
      localObject1 = new StringBuilder().append("showNormal_Result, result_root is null, ResultData[");
      if (paramjil != null)
      {
        bool = true;
        QLog.w(paramAVActivity, 1, bool + "]");
      }
    }
    int i;
    for (;;)
    {
      return;
      bool = false;
      break;
      localObject1 = (RelativeLayout)((RelativeLayout)localObject1).findViewById(2131374196);
      localObject2 = (AVRedPacketManager)this.mApp.a(6);
      localObject3 = ((RelativeLayout)localObject1).findViewById(2131374199);
      ((View)localObject3).setAnimation(null);
      ((View)localObject3).setVisibility(8);
      paramAVActivity = paramAVActivity.getResources();
      i = wja.dp2px(4.0F, paramAVActivity);
      if (paramjil.aAj == 0)
      {
        StrokeTextView localStrokeTextView = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131374198);
        localObject3 = (RedPacketRollNumberView)((RelativeLayout)localObject1).findViewById(2131374200);
        localObject4 = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131374204);
        localObject5 = (TextView)((RelativeLayout)localObject1).findViewById(2131374203);
        localStrokeTextView.setVisibility(0);
        localStrokeTextView.setStrokeEnable(true);
        localStrokeTextView.setStrokeColor(-3109366);
        localStrokeTextView.setInnerTextColor(-1);
        localStrokeTextView.setStrokeSize(i);
        i = wja.dp2px(6.0F, paramAVActivity);
        try
        {
          f = Float.parseFloat(dA(paramjil.St));
          ((RedPacketRollNumberView)localObject3).reset(f);
          ((RedPacketRollNumberView)localObject3).roll();
          ((StrokeTextView)localObject4).setVisibility(0);
          ((StrokeTextView)localObject4).setStrokeEnable(true);
          ((StrokeTextView)localObject4).setStrokeColor(-1);
          ((StrokeTextView)localObject4).setStrokeSize(i);
          ((StrokeTextView)localObject4).setInnerTextColor(-2094274);
          ((TextView)localObject5).setText(hp());
          if (xx())
          {
            if (this.bA == null) {
              this.bA = ((AVRedPacketManager)localObject2).o("qav_redpacket_result_bqd.png");
            }
            if (this.bA != null) {
              ((RelativeLayout)localObject1).findViewById(2131374190).setBackgroundDrawable(new BitmapDrawable(paramAVActivity, this.bA));
            }
          }
          if (this.bC == null) {
            this.bC = ((AVRedPacketManager)localObject2).o("qav_redpacket_result_button_normal.png");
          }
          if (this.bD == null) {
            this.bD = ((AVRedPacketManager)localObject2).o("qav_redpacket_result_button_pressed.png");
          }
          if ((this.bC != null) && (this.bD != null))
          {
            paramjil = ((RelativeLayout)localObject1).findViewById(2131374191);
            paramjil.setVisibility(0);
            localObject3 = new StateListDrawable();
            localObject4 = new BitmapDrawable(paramAVActivity, this.bD);
            ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject4);
            localObject4 = new BitmapDrawable(paramAVActivity, this.bC);
            ((StateListDrawable)localObject3).addState(new int[] { -16842919 }, (Drawable)localObject4);
            paramjil.setOnClickListener(this);
            paramjil.setBackgroundDrawable((Drawable)localObject3);
          }
          if (this.bE == null) {
            this.bE = ((AVRedPacketManager)localObject2).o("qav_redpacket_result_share_normal.png");
          }
          if (this.bF == null) {
            this.bF = ((AVRedPacketManager)localObject2).o("qav_redpacket_result_share_pressed.png");
          }
          if ((this.bE != null) && (this.bF != null))
          {
            paramjil = ((RelativeLayout)localObject1).findViewById(2131374202);
            paramjil.setVisibility(0);
            localObject1 = new StateListDrawable();
            localObject2 = new BitmapDrawable(paramAVActivity, this.bF);
            ((StateListDrawable)localObject1).addState(new int[] { 16842919 }, (Drawable)localObject2);
            paramAVActivity = new BitmapDrawable(paramAVActivity, this.bE);
            ((StateListDrawable)localObject1).addState(new int[] { -16842919 }, paramAVActivity);
            paramjil.setOnClickListener(this);
            paramjil.setBackgroundDrawable((Drawable)localObject1);
            return;
          }
        }
        catch (NumberFormatException paramjil)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.e(this.TAG, 2, "showNormal_Result e = " + paramjil);
            }
            float f = 0.0F;
          }
        }
      }
    }
    Object localObject2 = a(paramjil);
    Object localObject3 = paramjil.Sr;
    Object localObject4 = (String)((com.tencent.util.Pair)localObject2).second;
    Object localObject5 = new ForegroundColorSpan(-7447805);
    if ((!TextUtils.isEmpty((CharSequence)localObject3)) && (paramjil.aAj == 8)) {
      paramAVActivity = acfp.m(2131713929);
    }
    for (boolean bool = true;; bool = false)
    {
      paramjil = new SpannableString((String)localObject4 + paramAVActivity);
      int j = ((String)localObject4).length();
      int k = paramAVActivity.length() + j;
      paramjil.setSpan(new jir(this, bool, paramAVActivity, (String)localObject3), j, k, 33);
      paramjil.setSpan(localObject5, j, k, 17);
      paramAVActivity = (StrokeTextView)((RelativeLayout)localObject1).findViewById(2131374194);
      paramAVActivity.setText((CharSequence)((com.tencent.util.Pair)localObject2).first);
      paramAVActivity.setStrokeEnable(true);
      paramAVActivity.setStrokeColor(-3109366);
      paramAVActivity.setInnerTextColor(-1);
      paramAVActivity.setStrokeSize(i);
      paramAVActivity = (TextView)((RelativeLayout)localObject1).findViewById(2131374193);
      paramAVActivity.setVisibility(0);
      paramAVActivity.setText(paramjil);
      paramjil = (irw)irw.getInstance();
      paramjil.asR = -10864125;
      paramjil.asS = -7447805;
      paramAVActivity.setMovementMethod(paramjil);
      paramAVActivity.setHighlightColor(0);
      return;
      paramAVActivity = acfp.m(2131713923);
    }
  }
  
  public boolean cH(String paramString)
  {
    awB();
    AVActivity localAVActivity = getAVActivity();
    if (localAVActivity != null)
    {
      RelativeLayout localRelativeLayout = (RelativeLayout)localAVActivity.findViewById(2131377210);
      if (localRelativeLayout != null)
      {
        localRelativeLayout.setOnTouchListener(null);
        ((RelativeLayout)localAVActivity.findViewById(2131373916)).removeView(localRelativeLayout);
      }
    }
    for (boolean bool = true;; bool = false)
    {
      QLog.w(this.TAG, 1, "closeUI[" + paramString + "], bret[" + bool + "]");
      if (this.a != null)
      {
        this.a.onClose();
        this.a = null;
      }
      if (this.mBackground != null)
      {
        this.mBackground.recycle();
        this.mBackground = null;
      }
      if (this.bA != null)
      {
        this.bA.recycle();
        this.bA = null;
      }
      if (this.bi != null)
      {
        this.bi.recycle();
        this.bi = null;
      }
      if (this.bB != null)
      {
        this.bB.recycle();
        this.bB = null;
      }
      if (this.bC != null)
      {
        this.bC.recycle();
        this.bC = null;
      }
      if (this.bD != null)
      {
        this.bD.recycle();
        this.bD = null;
      }
      if (this.bE != null)
      {
        this.bE.recycle();
        this.bE = null;
      }
      if (this.bF != null)
      {
        this.bF.recycle();
        this.bF = null;
      }
      return bool;
    }
  }
  
  public void d(AVActivity paramAVActivity)
  {
    RelativeLayout localRelativeLayout = a(paramAVActivity);
    paramAVActivity = jik.getResPath();
    if (this.jdField_b_of_type_Jil.Zx) {}
    for (paramAVActivity = paramAVActivity + "avredbag_error_sender.png";; paramAVActivity = paramAVActivity + "avredbag_error_player.png")
    {
      paramAVActivity = aqcu.decodeFile(paramAVActivity);
      ((ImageView)localRelativeLayout.findViewById(2131377204)).setImageBitmap(paramAVActivity);
      ((RelativeLayout)localRelativeLayout.findViewById(2131370193)).setVisibility(0);
      return;
    }
  }
  
  String dA(String paramString)
  {
    String str1 = "-.--";
    if (!TextUtils.isEmpty(paramString))
    {
      if (paramString.length() != 1) {
        break label91;
      }
      str1 = "0.0" + paramString;
    }
    for (;;)
    {
      if (QLog.isDevelopLevel()) {
        QLog.w(this.TAG, 1, "formatShowMoney, src[" + paramString + "], dest[" + str1 + "]");
      }
      return str1;
      label91:
      if (paramString.length() == 2)
      {
        str1 = "0." + paramString;
      }
      else
      {
        str1 = paramString.substring(paramString.length() - 2);
        String str2 = paramString.substring(0, paramString.length() - 2);
        str1 = str2 + "." + str1;
      }
    }
  }
  
  public void e(AVActivity paramAVActivity)
  {
    int j = 0;
    Object localObject2 = null;
    AVRedPacketManager localAVRedPacketManager = (AVRedPacketManager)this.mApp.a(6);
    Object localObject3;
    Object localObject1;
    int i;
    Object localObject4;
    if (this.jdField_b_of_type_Jil.xw()) {
      if (this.jdField_b_of_type_Jil.aAj == 0)
      {
        localObject3 = (dA(this.jdField_b_of_type_Jil.St) + '$').toCharArray();
        localObject1 = localObject2;
        i = j;
        if (localObject3 != null)
        {
          localObject1 = localObject2;
          i = j;
          if (localObject3.length > 0)
          {
            localObject2 = new ArrayList();
            j = localObject3.length;
            i = 0;
            if (i < j)
            {
              localObject4 = Character.valueOf(localObject3[i]);
              localObject1 = "";
              if (((Character)localObject4).charValue() == '.') {
                localObject1 = "qav_redpacket_result_starter_" + "dot.png";
              }
              for (;;)
              {
                ((List)localObject2).add(new android.util.Pair(localObject4, localObject1));
                i += 1;
                break;
                if (((Character)localObject4).charValue() == '$') {
                  localObject1 = "qav_redpacket_result_starter_" + "yuan.png";
                } else if (Character.isDigit(((Character)localObject4).charValue())) {
                  localObject1 = "qav_redpacket_result_starter_" + localObject4 + ".png";
                }
              }
            }
            localObject1 = localObject2;
            i = 1;
          }
        }
        if (this.jdField_b_of_type_Jil.aAf * 1.0F / this.jdField_b_of_type_Jil.aAg >= 0.5F)
        {
          j = 1;
          if (j == 0) {
            break label572;
          }
          localObject2 = "avredbag_suc1_sender.png";
        }
      }
    }
    for (;;)
    {
      label313:
      localObject3 = a(paramAVActivity);
      ((RelativeLayout)localObject3).findViewById(2131370266).setOnTouchListener(new jiq(this));
      localObject4 = (ViewGroup)((RelativeLayout)localObject3).findViewById(2131377208);
      ((ViewGroup)localObject4).removeAllViews();
      ((ImageView)((RelativeLayout)localObject3).findViewById(2131377212)).setImageBitmap(localAVRedPacketManager.o((String)localObject2));
      localObject2 = (ImageView)((RelativeLayout)localObject3).findViewById(2131377213);
      ((ImageView)localObject2).setImageBitmap(localAVRedPacketManager.o("qav_redpacket_result_close.png"));
      ((ImageView)localObject2).setOnClickListener(this);
      label415:
      label437:
      android.util.Pair localPair;
      if (i != 0)
      {
        i = 0;
        ((ViewGroup)localObject4).setVisibility(i);
        if ((localObject1 == null) || ("qav_redpacket_result_starter_".isEmpty())) {
          break label772;
        }
        j = 0;
        if (j >= ((List)localObject1).size()) {
          break label772;
        }
        localPair = (android.util.Pair)((List)localObject1).get(j);
        localObject2 = (Character)localPair.first;
        if (((Character)localObject2).charValue() != '.') {
          break label646;
        }
        localObject2 = new LinearLayout.LayoutParams(wja.dp2px(12.0F, paramAVActivity.getResources()), wja.dp2px(12.0F, paramAVActivity.getResources()));
        ((LinearLayout.LayoutParams)localObject2).gravity = 80;
        i = 1;
      }
      for (;;)
      {
        if (i != 0)
        {
          ImageView localImageView = new ImageView(paramAVActivity);
          localImageView.setImageBitmap(localAVRedPacketManager.o((String)localPair.second));
          ((ViewGroup)localObject4).addView(localImageView, (ViewGroup.LayoutParams)localObject2);
        }
        j += 1;
        break label437;
        j = 0;
        break;
        label572:
        localObject2 = "avredbag_suc2_sender.png";
        break label313;
        localObject1 = null;
        localObject2 = "avredbag_error2_sender.png";
        i = 0;
        break label313;
        if (this.jdField_b_of_type_Jil.xv())
        {
          localObject1 = null;
          localObject2 = "avredbag_error_sender.png";
          i = 0;
          break label313;
        }
        if (this.jdField_b_of_type_Jil.aAk != 4) {
          break label788;
        }
        localObject1 = null;
        localObject2 = "avredbag_error2_sender.png";
        i = 0;
        break label313;
        i = 8;
        break label415;
        label646:
        if (((Character)localObject2).charValue() == '$')
        {
          localObject2 = new LinearLayout.LayoutParams(wja.dp2px(22.0F, paramAVActivity.getResources()), wja.dp2px(20.0F, paramAVActivity.getResources()));
          ((LinearLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(5.0F, paramAVActivity.getResources());
          ((LinearLayout.LayoutParams)localObject2).gravity = 80;
          i = 1;
        }
        else if (Character.isDigit(((Character)localObject2).charValue()))
        {
          localObject2 = new LinearLayout.LayoutParams(wja.dp2px(27.0F, paramAVActivity.getResources()), wja.dp2px(37.0F, paramAVActivity.getResources()));
          ((LinearLayout.LayoutParams)localObject2).gravity = 16;
          i = 1;
        }
        else
        {
          i = 0;
          localObject2 = null;
        }
      }
      label772:
      ((RelativeLayout)((RelativeLayout)localObject3).findViewById(2131370266)).setVisibility(0);
      return;
      label788:
      localObject1 = null;
      localObject2 = "";
      i = 0;
    }
  }
  
  public void f(AVActivity paramAVActivity)
  {
    Object localObject2 = a(paramAVActivity);
    a(paramAVActivity, (RelativeLayout)localObject2);
    RelativeLayout localRelativeLayout = (RelativeLayout)((RelativeLayout)localObject2).findViewById(2131374196);
    localRelativeLayout.setVisibility(0);
    Object localObject1 = (AVRedPacketManager)this.mApp.a(6);
    if (this.mBackground == null) {
      this.mBackground = ((AVRedPacketManager)localObject1).o("qav_redpacket_result_background.png");
    }
    if (this.mBackground != null) {
      localRelativeLayout.findViewById(2131374197).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.mBackground));
    }
    ((TextView)localRelativeLayout.findViewById(2131374201)).setText(a(paramAVActivity, 2131698051, this.jdField_b_of_type_Jil.aAh, this.jdField_b_of_type_Jil.aAi) + "\n" + a(paramAVActivity, 2131698053, this.jdField_b_of_type_Jil.aAf, this.jdField_b_of_type_Jil.aAg));
    ((RelativeLayout)localObject2).findViewById(2131374195).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.mApp.a(0, this.jdField_b_of_type_Jil.Sm, null, true, true)));
    localObject2 = localRelativeLayout.findViewById(2131374199);
    if (this.bB == null) {
      this.bB = ((AVRedPacketManager)localObject1).o("qav_redpacket_result_loading.png");
    }
    if (this.bB != null) {
      ((View)localObject2).setBackgroundDrawable(new BitmapDrawable(paramAVActivity.getResources(), this.bB));
    }
    localObject1 = new RotateAnimation(0.0F, -360.0F, 1, 0.5F, 1, 0.5F);
    ((RotateAnimation)localObject1).setInterpolator(new LinearInterpolator());
    ((RotateAnimation)localObject1).setDuration(1800L);
    ((RotateAnimation)localObject1).setRepeatCount(-1);
    ((RotateAnimation)localObject1).setRepeatMode(1);
    ((View)localObject2).setAnimation((Animation)localObject1);
    if (this.jdField_b_of_type_Jil.Zx)
    {
      b(paramAVActivity, this.jdField_b_of_type_Jil);
      return;
    }
    if ((this.jdField_b_of_type_Jil.aAj != 1) && (this.jdField_b_of_type_Jil.aAj != -1))
    {
      QLog.w(this.TAG, 1, "showNormal_Result, 抢红包回调早就来了");
      b(paramAVActivity, this.jdField_b_of_type_Jil);
      return;
    }
    this.Zz = true;
  }
  
  void f(jil paramjil)
  {
    AVActivity localAVActivity = getAVActivity();
    if (localAVActivity == null)
    {
      QLog.w(this.TAG, 1, "onGetResult, AVActivity为空");
      return;
    }
    if (this.Zz)
    {
      QLog.w(this.TAG, 1, "onGetResult, 显示结果");
      b(localAVActivity, paramjil);
      return;
    }
    this.jdField_b_of_type_Jil = paramjil;
    QLog.w(this.TAG, 1, "onGetResult, 窗口还没显示");
  }
  
  String hp()
  {
    if (xx())
    {
      if (this.jdField_b_of_type_Jil.Zx) {
        return "对方演技爆棚，\n领到了你的红包。";
      }
      return acfp.m(2131713922);
    }
    if (this.jdField_b_of_type_Jil.Zx) {
      return acfp.m(2131713920);
    }
    return acfp.m(2131713930);
  }
  
  void n(RelativeLayout paramRelativeLayout)
  {
    paramRelativeLayout.setOnTouchListener(new jip(this));
  }
  
  public void onClick(View paramView)
  {
    long l = AudioHelper.hG();
    QLog.w(this.TAG, 1, "onClick, seq[" + l + "]");
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      cH("qav_result_close");
      continue;
      cH("result_starter_close");
      continue;
      cH("qav_result_button");
      this.mApp.l(new Object[] { Integer.valueOf(126), Boolean.valueOf(true), Integer.valueOf(7), Long.valueOf(l) });
      jij.awQ();
      continue;
      AVActivity localAVActivity = getAVActivity();
      if (localAVActivity != null)
      {
        Intent localIntent = new Intent();
        localIntent.addFlags(603979776);
        localIntent.putExtra("score", this.jdField_b_of_type_Jil.aAf);
        localIntent.putExtra("count", this.jdField_b_of_type_Jil.aAh);
        localIntent.putExtra("isGoodScore", xx());
        PublicFragmentActivity.b.start(localAVActivity, localIntent, PublicFragmentActivityForVideo.class, RedPacketShareFragment.class);
        localAVActivity.finish();
        RedPacketShareFragment.iF("0X8008CF4");
      }
      cH("qav_result_share");
    }
  }
  
  public String toString()
  {
    return "mResultData[" + this.jdField_b_of_type_Jil + "]";
  }
  
  boolean xx()
  {
    return this.jdField_b_of_type_Jil.aAg - this.jdField_b_of_type_Jil.aAf <= this.jdField_b_of_type_Jil.aAf;
  }
  
  static abstract interface a
  {
    public abstract void onClose();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jim
 * JD-Core Version:    0.7.0.1
 */