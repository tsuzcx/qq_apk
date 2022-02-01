package com.tencent.mobileqq.troop.logic;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.media.MediaPlayer.OnCompletionListener;
import android.media.MediaPlayer.OnErrorListener;
import android.media.MediaPlayer.OnInfoListener;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troop.TroopMemberApiClient;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.BizTroopHandler;
import com.tencent.mobileqq.app.BizTroopObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.model.TroopInfoManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare.GeneralClickHandler;
import com.tencent.mobileqq.troop.utils.TroopFileUtils;
import com.tencent.mobileqq.troop.widget.MediaControllerX;
import com.tencent.mobileqq.troop.widget.MediaControllerX.MediaControllerListener;
import com.tencent.mobileqq.troop.widget.MessageSubtitleView;
import com.tencent.mobileqq.troop.widget.VideoViewX;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnPlayListener;
import com.tencent.mobileqq.troop.widget.VideoViewX.OnSeekListener;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.util.VersionUtils;
import com.tencent.util.WeakReferenceHandler;
import gws;
import gwv;
import gww;
import gwx;
import gwy;
import gwz;
import gxa;
import gxb;
import gxc;
import gxd;
import java.util.ArrayList;
import java.util.List;

public class VideoPlayLogic
  implements MediaPlayer.OnCompletionListener, MediaPlayer.OnErrorListener, MediaPlayer.OnInfoListener, Handler.Callback, View.OnClickListener, Animation.AnimationListener, MediaControllerX.MediaControllerListener, VideoViewX.OnPlayListener, VideoViewX.OnSeekListener
{
  static int jdField_a_of_type_Int = 0;
  private static final int jdField_b_of_type_Int = 0;
  private static final int jdField_c_of_type_Int = 1;
  private static final int jdField_d_of_type_Int = 2;
  private static final int jdField_e_of_type_Int = 3;
  private Context jdField_a_of_type_AndroidContentContext = null;
  protected final Handler a;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener = new gxb(this);
  private View jdField_a_of_type_AndroidViewView = null;
  private Animation jdField_a_of_type_AndroidViewAnimationAnimation = null;
  private LinearLayout jdField_a_of_type_AndroidWidgetLinearLayout = null;
  private RelativeLayout jdField_a_of_type_AndroidWidgetRelativeLayout = null;
  private TroopMemberApiClient jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = null;
  private SessionInfo jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = null;
  private BaseActivity jdField_a_of_type_ComTencentMobileqqAppBaseActivity = null;
  BizTroopObserver jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver = new gxc(this);
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = null;
  private StructMsgForGeneralShare jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = null;
  private MediaControllerX jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = null;
  private MessageSubtitleView jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView = null;
  private VideoViewX jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX = null;
  private QQProgressDialog jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = null;
  private final Runnable jdField_a_of_type_JavaLangRunnable = new gxa(this);
  private String jdField_a_of_type_JavaLangString;
  private List jdField_a_of_type_JavaUtilList = new ArrayList();
  private boolean jdField_a_of_type_Boolean = false;
  public Handler b;
  private Animation jdField_b_of_type_AndroidViewAnimationAnimation = null;
  private RelativeLayout jdField_b_of_type_AndroidWidgetRelativeLayout = null;
  private String jdField_b_of_type_JavaLangString = null;
  private boolean jdField_b_of_type_Boolean = false;
  private RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout = null;
  private boolean jdField_c_of_type_Boolean = false;
  private boolean jdField_d_of_type_Boolean;
  private boolean jdField_e_of_type_Boolean;
  private int jdField_f_of_type_Int = 0;
  private boolean jdField_f_of_type_Boolean = false;
  private int jdField_g_of_type_Int = 0;
  private boolean jdField_g_of_type_Boolean = false;
  private int jdField_h_of_type_Int = 0;
  private boolean jdField_h_of_type_Boolean = false;
  private int jdField_i_of_type_Int = -1;
  private boolean jdField_i_of_type_Boolean = true;
  private boolean j = false;
  private boolean k = false;
  
  public VideoPlayLogic(Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, TroopMemberApiClient paramTroopMemberApiClient, String paramString)
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.d = false;
    this.e = false;
    this.jdField_b_of_type_JavaLangString = paramString;
    a(paramContext, paramBaseActivity, paramSessionInfo, paramRelativeLayout, paramTroopMemberApiClient);
  }
  
  public VideoPlayLogic(QQAppInterface paramQQAppInterface, Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, LinearLayout paramLinearLayout)
  {
    this.jdField_a_of_type_AndroidOsHandler = new WeakReferenceHandler(Looper.getMainLooper(), this);
    this.d = false;
    this.e = false;
    this.jdField_a_of_type_AndroidWidgetLinearLayout = paramLinearLayout;
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a(paramContext, paramBaseActivity, paramSessionInfo, paramRelativeLayout, null);
  }
  
  private void a(int paramInt)
  {
    if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) || (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX == null)) {
      return;
    }
    if ((paramInt == 0) && ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX == null) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b())))
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
      return;
    }
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.jdField_c_of_type_AndroidWidgetRelativeLayout == null)
    {
      this.jdField_c_of_type_AndroidWidgetRelativeLayout = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, -1, -1);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundDrawable(null);
      if (paramInt != 1) {
        break label407;
      }
      localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
      localObject2 = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130838335);
      ((TextView)localObject1).setCompoundDrawablesWithIntrinsicBounds((Drawable)localObject2, null, null, null);
      ((Animatable)localObject2).start();
      if ((!this.jdField_i_of_type_Boolean) && (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b() == 0)) || (this.j) || (this.jdField_g_of_type_Int != 0)))
      {
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        localObject3 = new RelativeLayout.LayoutParams(-1, -1);
        ((TextView)localObject2).setBackgroundColor(-16777216);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      localObject2 = new RelativeLayout.LayoutParams(-2, -2);
      ((RelativeLayout.LayoutParams)localObject2).addRule(13);
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.f()) || (this.jdField_b_of_type_Boolean))
      {
        localObject1 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject1).setId(2131230859);
        ((ImageView)localObject1).setImageResource(2130838326);
        ((ImageView)localObject1).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131558474));
        ((ImageView)localObject1).setOnClickListener(this);
        ((ImageView)localObject1).setContentDescription("按钮关闭视频");
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(11);
        ((RelativeLayout.LayoutParams)localObject2).addRule(10);
        ((RelativeLayout.LayoutParams)localObject2).rightMargin = 10;
        ((RelativeLayout.LayoutParams)localObject2).topMargin = 10;
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
      }
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.bringToFront();
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      return;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeView(this.jdField_c_of_type_AndroidWidgetRelativeLayout);
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_c_of_type_AndroidWidgetRelativeLayout, -1, -1);
      break;
      label407:
      if (paramInt == 2)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838325);
        if ((!this.jdField_i_of_type_Boolean) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b() == 0))
        {
          localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          ((TextView)localObject1).setBackgroundColor(-16777216);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject3 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject3).setId(2131230856);
        ((TextView)localObject3).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560680));
        ((TextView)localObject3).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560682));
        localObject2 = new TextView(this.jdField_a_of_type_AndroidContentContext);
        ((TextView)localObject2).setId(2131230857);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560681));
        ((TextView)localObject2).setTextColor(this.jdField_a_of_type_AndroidContentContext.getResources().getColor(2131362067));
        ((TextView)localObject2).setContentDescription(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560682));
        ((TextView)localObject2).getPaint().setFlags(8);
        ((TextView)localObject2).setOnClickListener(this);
        ((RelativeLayout)localObject1).addView((View)localObject3, -2, -2);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(1, 2131230856);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
      }
      else if (paramInt == 3)
      {
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.setBackgroundResource(2130838325);
        if ((!this.jdField_i_of_type_Boolean) && (((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b() == 0)) || (this.j)))
        {
          localObject1 = new TextView(this.jdField_a_of_type_AndroidContentContext);
          localObject2 = new RelativeLayout.LayoutParams(-1, -1);
          ((TextView)localObject1).setBackgroundColor(-16777216);
          this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        }
        localObject1 = new RelativeLayout(this.jdField_a_of_type_AndroidContentContext);
        localObject2 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject2).addRule(13);
        this.jdField_c_of_type_AndroidWidgetRelativeLayout.addView((View)localObject1, (ViewGroup.LayoutParams)localObject2);
        localObject2 = new ImageView(this.jdField_a_of_type_AndroidContentContext);
        ((ImageView)localObject2).setId(2131230858);
        ((ImageView)localObject2).setImageResource(2130838329);
        ((ImageView)localObject2).setOnClickListener(this);
        new TextView(this.jdField_a_of_type_AndroidContentContext).setId(2131230857);
        localObject3 = new RelativeLayout.LayoutParams(-2, -2);
        ((RelativeLayout.LayoutParams)localObject3).addRule(14);
        ((RelativeLayout)localObject1).addView((View)localObject2, (ViewGroup.LayoutParams)localObject3);
        new RelativeLayout.LayoutParams(-2, -2).addRule(3, 2131230858);
      }
    }
  }
  
  private void a(Context paramContext, BaseActivity paramBaseActivity, SessionInfo paramSessionInfo, RelativeLayout paramRelativeLayout, TroopMemberApiClient paramTroopMemberApiClient)
  {
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient = paramTroopMemberApiClient;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity = paramBaseActivity;
    this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo = paramSessionInfo;
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = paramRelativeLayout;
    if (this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient == null)
    {
      this.jdField_i_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
    for (;;)
    {
      this.jdField_a_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(0.0F, 1.0F, 0.0F, 1.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_a_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidViewAnimationAnimation = new ScaleAnimation(1.0F, 0.0F, 1.0F, 0.0F, 1, 0.5F, 1, 0.5F);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setDuration(300L);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setFillAfter(true);
      this.jdField_b_of_type_AndroidViewAnimationAnimation.setAnimationListener(this);
      this.jdField_b_of_type_AndroidOsHandler = new Handler(this.jdField_a_of_type_AndroidContentContext.getMainLooper());
      return;
      this.jdField_i_of_type_Boolean = false;
      this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.a(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    l();
    this.jdField_a_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    this.e = false;
    if (this.jdField_a_of_type_JavaUtilList.size() == 0) {
      return;
    }
    if (this.jdField_f_of_type_Int >= this.jdField_a_of_type_JavaUtilList.size()) {
      this.jdField_f_of_type_Int = (this.jdField_a_of_type_JavaUtilList.size() - 1);
    }
    Uri localUri = Uri.parse((String)this.jdField_a_of_type_JavaUtilList.get(this.jdField_f_of_type_Int));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = new MediaControllerX(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setMediaControllerListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setOnSwitchSubTitleBtnClickListener(new gxd(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setonOutLinkBtnClickListener(new gwv(this));
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setMediaController(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX);
    if (!this.jdField_i_of_type_Boolean) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.a();
    }
    this.jdField_g_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnCompletionListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnErrorListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnPlayListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnSeekListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnInfoListener(this);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setVideoURI(localUri);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setOnViewClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a();
    if (this.jdField_i_of_type_Int == 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setProgressVisibility(4);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setLive(true);
    }
    for (;;)
    {
      if ((this.jdField_i_of_type_Int != 0) && (this.jdField_h_of_type_Boolean) && (this.jdField_g_of_type_Int > 0))
      {
        this.k = true;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a(this.jdField_g_of_type_Int);
      }
      o();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      n();
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(128);
      if (!paramBoolean) {
        break;
      }
      this.jdField_f_of_type_Boolean = true;
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationAnimation);
      return;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.setProgressVisibility(0);
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setLive(false);
    }
  }
  
  private boolean d()
  {
    boolean bool = false;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.e())
    {
      this.jdField_a_of_type_Boolean = false;
      this.jdField_c_of_type_Boolean = false;
      this.d = false;
      this.jdField_b_of_type_Boolean = false;
      this.e = false;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.c();
      o();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.clearAnimation();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      n();
      bool = true;
    }
    return bool;
  }
  
  private void k()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getString(2131559311));
    this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
    if (this.jdField_i_of_type_Boolean)
    {
      m();
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_JavaLangString, new gwz(this));
  }
  
  private void l()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a()))
    {
      if (this.jdField_i_of_type_Boolean) {
        ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b(), "", "");
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.d();
    }
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
  }
  
  private void m()
  {
    if (this.jdField_i_of_type_Boolean)
    {
      BizTroopHandler localBizTroopHandler = (BizTroopHandler)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(21);
      if (localBizTroopHandler != null) {
        localBizTroopHandler.f(this.jdField_a_of_type_JavaLangString);
      }
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.b(this.jdField_a_of_type_JavaLangString);
  }
  
  private void n()
  {
    Object localObject1 = null;
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.findViewById(2131231447);
    if (localObject2 != null) {
      localObject1 = (View)((View)localObject2).getParent();
    }
    localObject2 = new DisplayMetrics();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getMetrics((DisplayMetrics)localObject2);
    int m;
    int n;
    if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2)
    {
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(8);
      }
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0))
      {
        if (localObject1 != null) {
          ((View)localObject1).setVisibility(8);
        }
        m = ((DisplayMetrics)localObject2).heightPixels;
        n = m;
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)
        {
          if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.d()) {
            break label279;
          }
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.f();
          n = m;
          if (this.jdField_i_of_type_Boolean)
          {
            ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "full_screen", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
            n = m;
          }
        }
        label197:
        if (this.jdField_b_of_type_AndroidWidgetRelativeLayout == null) {
          break label383;
        }
        localObject1 = this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((ViewGroup.LayoutParams)localObject1).height = n;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject1);
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.requestLayout();
      }
    }
    for (;;)
    {
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() != 0) && (this.jdField_a_of_type_AndroidWidgetLinearLayout != null)) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      return;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      m = 0;
      break;
      label279:
      n = m;
      if (!this.jdField_i_of_type_Boolean) {
        break label197;
      }
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "full_screen", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
      n = m;
      break label197;
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(0);
      }
      n = (int)(180.0F * this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().density + 0.5F);
      break label197;
      label383:
      if (this.jdField_a_of_type_AndroidWidgetLinearLayout != null) {
        this.jdField_a_of_type_AndroidWidgetLinearLayout.setVisibility(0);
      }
    }
  }
  
  private void o()
  {
    if (this.jdField_b_of_type_Boolean)
    {
      this.jdField_f_of_type_Int += 1;
      if ((!this.jdField_a_of_type_Boolean) && (this.jdField_f_of_type_Int < this.jdField_a_of_type_JavaUtilList.size()))
      {
        a(false);
        return;
      }
      a(2);
      return;
    }
    if (this.jdField_c_of_type_Boolean)
    {
      a(3);
      return;
    }
    if ((!this.jdField_a_of_type_Boolean) || (this.d) || (this.e))
    {
      a(1);
      return;
    }
    a(0);
  }
  
  public void a()
  {
    this.j = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null)
    {
      if (!this.jdField_h_of_type_Boolean)
      {
        this.jdField_h_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.d();
        this.jdField_g_of_type_Int = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b();
      }
      l();
      this.jdField_c_of_type_Boolean = true;
      this.jdField_h_of_type_Boolean = true;
      o();
    }
  }
  
  public void a(Configuration paramConfiguration)
  {
    if (paramConfiguration.orientation == 2)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().addFlags(1024);
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(0);
      }
    }
    for (;;)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.a(paramConfiguration);
      }
      if (this.jdField_b_of_type_AndroidOsHandler != null) {
        this.jdField_b_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 10L);
      }
      return;
      if (paramConfiguration.orientation == 1)
      {
        this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(1024);
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView.setVisibility(8);
        }
      }
    }
  }
  
  public void a(MediaPlayer paramMediaPlayer)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.d = false;
    if ((this.jdField_i_of_type_Int == 0) && (this.jdField_h_of_type_Boolean) && (this.jdField_g_of_type_Int > 0))
    {
      this.jdField_g_of_type_Int = 0;
      this.jdField_h_of_type_Boolean = false;
      if (this.jdField_h_of_type_Int == 4)
      {
        this.jdField_h_of_type_Int = 0;
        this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b();
      }
    }
    o();
    if (this.jdField_i_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "suc_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
  }
  
  public void a(CharSequence paramCharSequence1, CharSequence paramCharSequence2)
  {
    if (paramCharSequence2 != null) {
      this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.runOnUiThread(new gwy(this, paramCharSequence1, paramCharSequence2));
    }
  }
  
  public void a(String paramString)
  {
    paramString = paramString.trim();
    Intent localIntent = new Intent(this.jdField_a_of_type_AndroidContentContext, QQBrowserDelegationActivity.class);
    StringBuilder localStringBuilder1 = new StringBuilder(paramString);
    StringBuilder localStringBuilder2;
    if (paramString.indexOf("?") > 0)
    {
      paramString = "";
      localStringBuilder1 = localStringBuilder1.append(paramString).append("&from=androidqq");
      localStringBuilder2 = localStringBuilder1.append("&uin=");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        break label149;
      }
    }
    label149:
    for (paramString = "";; paramString = this.jdField_b_of_type_JavaLangString)
    {
      localStringBuilder2.append(paramString).append("&originuin=");
      localIntent.putExtra("param_force_internal_browser", true);
      localIntent.putExtra("injectrecommend", false);
      localIntent.putExtra("key_isReadModeEnabled", true);
      localIntent.putExtra("url", localStringBuilder1.toString().trim());
      this.jdField_a_of_type_AndroidContentContext.startActivity(localIntent);
      return;
      paramString = "?";
      break;
    }
  }
  
  public void a(String paramString, StructMsgForGeneralShare paramStructMsgForGeneralShare, View paramView)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
    this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare = paramStructMsgForGeneralShare;
    this.jdField_a_of_type_AndroidViewView = paramView;
    d();
    if (this.jdField_i_of_type_Boolean)
    {
      paramString = (TroopInfoManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(35);
      if (paramString != null) {
        paramString.a(this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, 0);
      }
      if ((paramString != null) && (paramString.a()))
      {
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog = new QQProgressDialog(this.jdField_a_of_type_AndroidContentContext);
        }
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.a(this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131559634));
        this.jdField_a_of_type_ComTencentMobileqqWidgetQQProgressDialog.show();
        new gws(this, paramString).execute(new Void[0]);
        return;
      }
    }
    if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
    {
      QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560679), 1).a();
      return;
    }
    if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) != 2)
    {
      DialogUtil.a(this.jdField_a_of_type_AndroidContentContext, 230, this.jdField_a_of_type_AndroidContentContext.getString(2131560332), this.jdField_a_of_type_AndroidContentContext.getString(2131560430), 2131561746, 2131560431, new gww(this), new gwx(this)).show();
      return;
    }
    k();
  }
  
  public boolean a()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null)
    {
      bool1 = bool2;
      if (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0)
      {
        if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation != 2) {
          break label59;
        }
        if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
          this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
        }
      }
    }
    for (;;)
    {
      bool1 = true;
      return bool1;
      label59:
      c();
    }
  }
  
  public void b()
  {
    this.j = false;
    if ((this.jdField_h_of_type_Boolean) && (this.jdField_g_of_type_Int > 0) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null)) {
      a(false);
    }
  }
  
  public boolean b()
  {
    return (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (this.jdField_b_of_type_AndroidWidgetRelativeLayout.getVisibility() == 0);
  }
  
  @TargetApi(8)
  public void c()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    this.jdField_a_of_type_AndroidViewAnimationAnimation.cancel();
    if ((this.jdField_b_of_type_AndroidViewAnimationAnimation.hasStarted()) && (!this.jdField_b_of_type_AndroidViewAnimationAnimation.hasEnded())) {}
    for (int m = 1;; m = 0)
    {
      if ((this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) && (m == 0))
      {
        this.jdField_f_of_type_Boolean = true;
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_b_of_type_AndroidViewAnimationAnimation);
      }
      return;
    }
  }
  
  @TargetApi(8)
  public boolean c()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (VersionUtils.b())
    {
      int m = this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindowManager().getDefaultDisplay().getRotation();
      if (m != 1)
      {
        bool1 = bool2;
        if (m != 3) {}
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null)
    {
      l();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.g();
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.removeAllViews();
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX = null;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMessageSubtitleView = null;
    }
    if (this.jdField_b_of_type_AndroidWidgetRelativeLayout != null) {
      this.jdField_b_of_type_AndroidWidgetRelativeLayout.setVisibility(8);
    }
    n();
    this.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getWindow().clearFlags(128);
  }
  
  public void e()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX != null) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.isShown()) && (this.jdField_i_of_type_Boolean)) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_msg", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "", "", "");
    }
  }
  
  public void f()
  {
    o();
  }
  
  public void g()
  {
    o();
  }
  
  public void h()
  {
    this.jdField_b_of_type_Boolean = false;
    this.d = true;
    if (this.k) {
      this.j = true;
    }
    o();
    this.k = false;
    this.j = false;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    return true;
  }
  
  public void i()
  {
    this.d = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_g_of_type_Int = 0;
    this.jdField_h_of_type_Boolean = false;
    if (this.jdField_h_of_type_Int == 4)
    {
      this.jdField_h_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.b();
    }
    o();
  }
  
  public void j()
  {
    d();
    if (this.jdField_i_of_type_Boolean)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c(this.jdField_a_of_type_ComTencentMobileqqAppBizTroopObserver);
      return;
    }
    this.jdField_a_of_type_ComTencentBizTroopTroopMemberApiClient.d();
  }
  
  public void onAnimationEnd(Animation paramAnimation)
  {
    this.jdField_f_of_type_Boolean = false;
    if (paramAnimation == this.jdField_b_of_type_AndroidViewAnimationAnimation) {
      d();
    }
    while (paramAnimation != this.jdField_a_of_type_AndroidViewAnimationAnimation) {
      return;
    }
  }
  
  public void onAnimationRepeat(Animation paramAnimation) {}
  
  public void onAnimationStart(Animation paramAnimation) {}
  
  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == 2131230858) {
      if (TroopFileUtils.a(this.jdField_a_of_type_AndroidContentContext) == 0)
      {
        QQToast.a(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_AndroidContentContext.getResources().getString(2131560679), 1).a();
        if (this.jdField_i_of_type_Boolean) {
          ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "Clk_play", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
        }
      }
    }
    do
    {
      do
      {
        return;
        a(false);
        break;
        if (m == 2131230857)
        {
          if (this.jdField_i_of_type_Boolean)
          {
            new StructMsgForGeneralShare.GeneralClickHandler(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_AndroidViewView, this.jdField_a_of_type_ComTencentMobileqqStructmsgStructMsgForGeneralShare).a(this.jdField_a_of_type_JavaLangString);
            return;
          }
          a(this.jdField_a_of_type_JavaLangString);
          return;
        }
      } while (m != 2131230859);
      c();
    } while (!this.jdField_i_of_type_Boolean);
    if (this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2)
    {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "1", "", "");
      return;
    }
    ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "close", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "0", "", "");
  }
  
  public void onCompletion(MediaPlayer paramMediaPlayer)
  {
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_Boolean = false;
    if ((this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
    }
    if (this.jdField_i_of_type_Boolean) {
      ReportController.b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "P_CliOper", "Grp_AIO", "", "video", "play_time", 0, 0, this.jdField_a_of_type_ComTencentMobileqqActivityAioSessionInfo.jdField_a_of_type_JavaLangString, "" + this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.a(), "", "");
    }
    o();
  }
  
  public boolean onError(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    this.jdField_b_of_type_Boolean = true;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_a_of_type_Boolean = false;
    this.d = false;
    if ((this.jdField_a_of_type_AndroidContentContext.getResources().getConfiguration().orientation == 2) && (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.b(0);
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetVideoViewX.setMediaController(null);
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.jdField_a_of_type_Boolean = true;
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetMediaControllerX.c();
    }
    o();
    return false;
  }
  
  public boolean onInfo(MediaPlayer paramMediaPlayer, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 701) {
      this.e = true;
    }
    for (;;)
    {
      o();
      return false;
      if (paramInt1 == 702) {
        this.e = false;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.VideoPlayLogic
 * JD-Core Version:    0.7.0.1
 */