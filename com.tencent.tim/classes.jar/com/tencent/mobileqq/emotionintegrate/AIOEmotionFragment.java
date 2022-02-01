package com.tencent.mobileqq.emotionintegrate;

import acea;
import acfp;
import afkd;
import afke;
import afko;
import afmi;
import afnu;
import afpu;
import afrd;
import afre;
import afrf;
import afrg;
import afrh;
import afrl;
import afrm;
import afrn;
import afro;
import afro.a;
import afrp.a;
import afrr;
import afrs;
import afrt;
import afru;
import ahgq;
import aixi;
import ajdg;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import anot;
import anpc;
import anqz;
import aoiz;
import aoop;
import aqly;
import aqmj;
import arhz;
import auru;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.utils.Base64;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.Utils;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatHistory;
import com.tencent.mobileqq.activity.EditActivity;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.activity.MultiForwardActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.AudioDeviceManager;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase;
import com.tencent.mobileqq.activity.aio.AudioPlayerBase.a;
import com.tencent.mobileqq.activity.aio.CommonAudioPlayer;
import com.tencent.mobileqq.activity.aio.CommonAudioPlayer.a;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.activity.aio.item.PttAudioPlayView;
import com.tencent.mobileqq.activity.aio.item.PttAudioWaveView;
import com.tencent.mobileqq.activity.chathistory.ChatHistoryBubbleListForTroopFragment;
import com.tencent.mobileqq.activity.contact.connections.TriangleView;
import com.tencent.mobileqq.activity.history.ChatHistoryActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.data.MessageForMarketFace;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.PicMessageExtraData;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.mobileqq.utils.AudioHelper;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.mobileqq.widget.share.ShareActionSheetFactory;
import com.tencent.mobileqq.widget.share.ShareActionSheetV2.Param;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.d;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.DragView;
import com.tencent.widget.DragView.a;
import com.tencent.widget.DragView.b;
import com.tencent.widget.Gallery.b;
import com.tencent.widget.immersive.ImmersiveUtils;
import ija;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import jof;
import jof.a;
import mqq.app.AppRuntime;
import stj;
import syd;
import wja;
import xkl;
import xsi;
import xsi.a;
import xsk;
import xtm;

public class AIOEmotionFragment
  extends AIOEmotionBaseFragment
  implements afro.a, afrp.a, Handler.Callback, View.OnClickListener, AudioPlayerBase.a, CommonAudioPlayer.a, EmotionGallery.a, AdapterView.d, AdapterView.e, DragView.a, DragView.b, Gallery.b, xsi.a
{
  public static afrl a;
  public static afpu f;
  private static int mDataSourceType;
  private List<URLDrawable> As = new ArrayList();
  View BZ;
  TextView RC;
  TextView RD;
  TextView RE;
  private acea jdField_a_of_type_Acea = new afrh(this);
  afrm jdField_a_of_type_Afrm;
  private afro jdField_a_of_type_Afro;
  private CommonAudioPlayer jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer;
  private a jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a;
  EmotionGallery jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery;
  DragView jdField_a_of_type_ComTencentWidgetDragView;
  private Rect aU;
  PttAudioPlayView b;
  private int bYV;
  private TextView bs;
  TriangleView jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView;
  syd jdField_c_of_type_Syd;
  private int cTx = -1;
  private boolean caw;
  PttAudioWaveView d;
  public ShareActionSheet d;
  RelativeLayout dR;
  private float density;
  private boolean dx = true;
  private boolean dy;
  final auru e = new auru(Looper.getMainLooper(), this);
  Emoticon f;
  public afpu g;
  private WeakReference<URLDrawable> gL;
  Button gd;
  private boolean hasScrolled;
  View jP;
  RelativeLayout jZ;
  RelativeLayout ka;
  RelativeLayout kb;
  private RelativeLayout kc;
  private HashMap<Long, Float> ku = new HashMap();
  public SessionInfo mSessionInfo;
  private ImageView py;
  protected View rE;
  private float wj = 1.0F;
  ImageView yG;
  ImageView yX;
  ImageView yY;
  ImageView yZ;
  
  private void Ih(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Bundle localBundle = new Bundle();
      localBundle.putInt("forward_type", 9);
      localBundle.putBoolean("forward_emotion_from_preview", true);
      Intent localIntent = new Intent();
      localIntent.putExtras(localBundle);
      this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity(localIntent);
    }
    this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
  }
  
  private void a(int paramInt, afrl paramafrl)
  {
    paramafrl = paramafrl.a();
    float f2;
    if (paramafrl != null)
    {
      f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb();
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "updateEmotionOcr scale=" + f2 + "originalScale=" + f2);
      }
      if (!this.ku.containsKey(this.jdField_a_of_type_Afrm.b(paramInt))) {
        break label373;
      }
    }
    label342:
    label373:
    for (float f1 = ((Float)this.ku.get(this.jdField_a_of_type_Afrm.b(paramInt))).floatValue();; f1 = f2)
    {
      if (((f1 <= 0.0F) || (f2 > f1)) || (!TextUtils.isEmpty(paramafrl.modifyWord)))
      {
        paramafrl = paramafrl.modifyWord;
        if (!TextUtils.isEmpty(paramafrl)) {
          break label342;
        }
        this.RC.setTextColor(this.mContext.getResources().getColor(2131167393));
        this.RC.setText(this.mContext.getResources().getString(2131693103));
      }
      for (;;)
      {
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
        if ((ajN()) && (aqmj.aU(this.mContext, getApp().getCurrentUin())))
        {
          aqmj.F(this.mContext, getApp().getCurrentUin(), false);
          Object localObject = new LinearLayout(this.mContext);
          ((LinearLayout)localObject).setOrientation(1);
          ((LinearLayout)localObject).setGravity(1);
          paramafrl = new ImageView(this.mContext);
          paramafrl.setImageDrawable(this.mContext.getResources().getDrawable(2130839068));
          ((LinearLayout)localObject).addView(paramafrl);
          localObject = (LinearLayout.LayoutParams)paramafrl.getLayoutParams();
          ((LinearLayout.LayoutParams)localObject).bottomMargin = (-wja.dp2px(7.0F, this.mContext.getResources()));
          ((LinearLayout.LayoutParams)localObject).topMargin = wja.dp2px(3.0F, this.mContext.getResources());
          paramafrl.setLayoutParams((ViewGroup.LayoutParams)localObject);
        }
        return;
        paramafrl = paramafrl.ocrWord;
        break;
        this.RC.setTextColor(this.mContext.getResources().getColor(2131165381));
        this.RC.setText(paramafrl);
      }
    }
  }
  
  private void a(afrt paramafrt)
  {
    report("0X800A7E6");
    paramafrt = (MessageForPic)paramafrt.messageRecord;
    int i = paramafrt.picExtraData.from;
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
    if (!TextUtils.isEmpty(paramafrt.picExtraData.source))
    {
      if (paramafrt.picExtraData.source.length() > 11) {
        this.RD.setText(paramafrt.picExtraData.source.substring(0, 10) + "...");
      }
    }
    else
    {
      if (i != 1) {
        break label261;
      }
      if (!((ajdg)getApp().getManager(14)).np(paramafrt.picExtraData.emojiPkgId)) {
        break label294;
      }
    }
    label261:
    label294:
    for (i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.RE.setText(this.mContext.getResources().getString(2131690127));
        this.RE.setTextColor(-7829368);
      }
      for (;;)
      {
        paramafrt = xkl.a(paramafrt);
        URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
        localURLDrawableOptions.mLoadingDrawable = aoop.TRANSPARENT;
        localURLDrawableOptions.mGifRoundCorner = this.bYV;
        localURLDrawableOptions.mPlayGifImage = true;
        paramafrt = URLDrawable.getDrawable(paramafrt, localURLDrawableOptions);
        this.yX.setImageDrawable(paramafrt);
        return;
        this.RD.setText(paramafrt.picExtraData.source);
        break;
        this.RE.setText(this.mContext.getResources().getString(2131690128));
        this.RE.setTextColor(-16777216);
        continue;
        this.RE.setText(this.mContext.getResources().getString(2131690129));
        this.RE.setTextColor(-16777216);
      }
    }
  }
  
  public static void a(Context paramContext, afmi paramafmi, Rect paramRect)
  {
    Intent localIntent = new Intent();
    if (paramRect != null)
    {
      paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
      paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
      localIntent.putExtra("KEY_THUMBNAL_BOUND", paramRect);
    }
    dbD();
    if (QLog.isColorLevel()) {
      QLog.i("AIOEmotionFragment", 2, "enterEmotionPreview, type: FAV");
    }
    mDataSourceType = 1;
    jdField_a_of_type_Afrl = new afrr(paramafmi);
    localIntent.putExtra("from_chat_history", false);
    localIntent.putExtra("public_fragment_window_feature", 1);
    PublicFragmentActivity.b.a(localIntent, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect)
  {
    a(paramContext, paramMessageRecord, paramSessionInfo, paramRect, true, true);
  }
  
  public static void a(Context paramContext, MessageRecord paramMessageRecord, SessionInfo paramSessionInfo, Rect paramRect, boolean paramBoolean1, boolean paramBoolean2)
  {
    mDataSourceType = 0;
    boolean bool;
    if (((paramContext instanceof ChatHistoryActivity)) || ((paramContext instanceof ChatHistory))) {
      bool = true;
    }
    for (;;)
    {
      dbD();
      if (paramRect != null)
      {
        paramRect.top -= ImmersiveUtils.getStatusBarHeight(paramContext);
        paramRect.bottom -= ImmersiveUtils.getStatusBarHeight(paramContext);
      }
      Object localObject;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder().append("enterEmotionPreview, type:");
        if (MessageForMarketFace.class.isInstance(paramMessageRecord))
        {
          localObject = "Emotion";
          label90:
          QLog.i("AIOEmotionFragment", 2, (String)localObject);
        }
      }
      else
      {
        jdField_a_of_type_Afrl = new afrt(paramMessageRecord);
        localObject = new Intent();
        ((Intent)localObject).putExtra("session_info", paramSessionInfo);
        ((Intent)localObject).putExtra("from_chat_history", bool);
        ((Intent)localObject).putExtra("hide_emo_position", paramBoolean1);
        ((Intent)localObject).putExtra("need_reload_data", paramBoolean2);
        ((Intent)localObject).putExtra("public_fragment_window_feature", 1);
        if (paramRect != null) {
          ((Intent)localObject).putExtra("KEY_THUMBNAL_BOUND", paramRect);
        }
        if (!(paramContext instanceof ChatHistory)) {
          break label304;
        }
        ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistory.class.getName());
      }
      for (;;)
      {
        if ((paramContext instanceof ChatHistoryActivity)) {
          ((Intent)localObject).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatHistoryActivity.class.getName());
        }
        if ((!ChatHistoryActivity.b(paramContext, (Intent)localObject)) || (!(paramContext instanceof Activity))) {
          break label364;
        }
        PublicFragmentActivity.b.startForResult((Activity)paramContext, (Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class, 38);
        return;
        if ((!(paramContext instanceof PublicFragmentActivity)) || (!(((PublicFragmentActivity)paramContext).b() instanceof ChatHistoryBubbleListForTroopFragment))) {
          break label375;
        }
        bool = true;
        break;
        localObject = "GIF";
        break label90;
        label304:
        if (((paramContext instanceof MultiForwardActivity)) && (paramMessageRecord.isMultiMsg) && (((MultiForwardActivity)paramContext).getIntent() != null))
        {
          ((Intent)localObject).putExtra("key_multi_forward_seq", ((MultiForwardActivity)paramContext).getIntent().getLongExtra("origin_merge_structing_msg_uniseq", 0L));
          ((Intent)localObject).putExtra("key_is_multi_forward_msg", true);
        }
      }
      label364:
      PublicFragmentActivity.b.a((Intent)localObject, PublicTransFragmentActivity.class, AIOEmotionFragment.class);
      return;
      label375:
      bool = false;
    }
  }
  
  private boolean a(afpu paramafpu)
  {
    if ((paramafpu == null) || (!paramafpu.isNewSoundType())) {}
    while (paramafpu.P() == null) {
      return false;
    }
    this.ka.setVisibility(0);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.getLayoutParams();
    QLog.d("AIOEmotionFragment", 2, "tryUpdateNewAudioEmoAudioInfo");
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setMaxTopBottomPadding(4);
    localLayoutParams.width = wja.dp2px(39.0F, this.mContext.getResources());
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setAudioData(paramafpu.P(), wja.dp2px(39.0F, this.mContext.getResources()), paramafpu.Ds());
    hR(paramafpu.Dt(), paramafpu.Du());
    return true;
  }
  
  private boolean ajN()
  {
    float f1 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb();
    if ((this.ku.containsKey(this.jdField_a_of_type_Afrm.b(this.cTx))) && (f1 != ((Float)this.ku.get(this.jdField_a_of_type_Afrm.b(this.cTx))).floatValue())) {
      return true;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if ((localObject instanceof ImageView))
    {
      localObject = ((ImageView)localObject).getDrawable();
      if (localObject != null)
      {
        int i;
        if ((localObject instanceof aixi))
        {
          i = wja.dp2px(100.0F, this.mContext.getResources());
          this.wj = f1;
          localObject = (RelativeLayout.LayoutParams)this.jZ.getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject).topMargin = ((int)(i * f1 / 2.0F) + wja.dp2px(5.0F, getResources()));
          this.jZ.setLayoutParams((ViewGroup.LayoutParams)localObject);
          if (QLog.isColorLevel()) {
            QLog.d("AIOEmotionFragment", 2, new Object[] { "updateEmotionNameLayout scale:", Float.valueOf(f1), " topMargin:", Integer.valueOf(((RelativeLayout.LayoutParams)localObject).topMargin) });
          }
          if (i <= 0) {
            break label226;
          }
        }
        label226:
        for (boolean bool = true;; bool = false)
        {
          return bool;
          i = ((Drawable)localObject).getIntrinsicHeight();
          break;
        }
      }
    }
    return false;
  }
  
  private void b(afrt paramafrt)
  {
    this.BZ.setVisibility(8);
  }
  
  private static void dbD()
  {
    Object localObject = BaseApplicationImpl.getApplication().getRuntime();
    if ((localObject instanceof QQAppInterface)) {}
    for (localObject = (QQAppInterface)localObject;; localObject = null)
    {
      if (localObject != null)
      {
        localObject = MediaPlayerManager.a((QQAppInterface)localObject);
        if (((((MediaPlayerManager)localObject).a() instanceof MessageForMarketFace)) && (((MediaPlayerManager)localObject).isPlaying())) {
          ((MediaPlayerManager)localObject).stop(true);
        }
      }
      return;
    }
  }
  
  private void dbF()
  {
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
    this.b.setPlayState(false);
    aF(false, false);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity != null) {
      localFragmentActivity.getWindow().clearFlags(128);
    }
  }
  
  private void e(afmi paramafmi)
  {
    label60:
    Object localObject;
    if ((this.jdField_f_of_type_ComTencentMobileqqDataEmoticon != null) && (this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.jobType != 2))
    {
      i = 1;
      if ((i == 0) || (paramafmi == null)) {
        break label280;
      }
      report("0X800997E");
      if ((!(paramafmi instanceof afpu)) || (!((afpu)paramafmi).isNewSoundType())) {
        break label224;
      }
      this.yY.setVisibility(0);
      paramafmi = paramafmi.b(getActivity(), getResources().getDisplayMetrics().density);
      this.yX.setImageDrawable(paramafmi);
      paramafmi = null;
      localObject = afrn.a(this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.epId);
      if (localObject != null) {
        paramafmi = ((EmoticonPackage)localObject).name;
      }
      localObject = getApp();
      if (localObject == null) {
        break label289;
      }
      if (TextUtils.isEmpty(paramafmi)) {
        break label247;
      }
      if (paramafmi.length() <= 11) {
        break label236;
      }
      this.RD.setText(paramafmi.substring(0, 10) + "...");
      label167:
      if (!((ajdg)((QQAppInterface)localObject).getManager(14)).np(this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.epId)) {
        break label289;
      }
    }
    label280:
    label289:
    for (int i = 1;; i = 0)
    {
      if (i != 0)
      {
        this.RE.setText(acfp.m(2131702188));
        this.RE.setTextColor(-7829368);
        return;
        i = 0;
        break;
        label224:
        this.yY.setVisibility(8);
        break label60;
        label236:
        this.RD.setText(paramafmi);
        break label167;
        label247:
        y((QQAppInterface)localObject, 4);
        break label167;
      }
      this.RE.setText(acfp.m(2131702187));
      this.RE.setTextColor(-16777216);
      return;
      this.BZ.setVisibility(4);
      return;
    }
  }
  
  private void hR(int paramInt1, int paramInt2)
  {
    this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView.setDrawColor(paramInt1);
    anqz localanqz = new anqz(paramInt1, 1, 1, wja.dp2px(22.0F, this.mContext.getResources()));
    this.kb.setBackgroundDrawable(localanqz);
    this.b.setThemeColor(paramInt2);
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgressColor(paramInt2);
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.postInvalidate();
  }
  
  private boolean isAudioPlaying()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer == null) {
      return false;
    }
    return this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.isPlaying();
  }
  
  private void playAudio()
  {
    Object localObject1;
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer = new CommonAudioPlayer(this.mContext, this);
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.init();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.a(this);
      localObject1 = getApp();
      if (localObject1 != null) {
        AudioDeviceManager.a((QQAppInterface)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
      }
    }
    this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.stop();
    Object localObject2;
    if (this.g != null)
    {
      localObject2 = afnu.bEr.replace("[epId]", this.g.e.epId).replace("[eId]", this.g.e.eId);
      this.dy = false;
      localObject1 = getApp();
      if (localObject1 != null)
      {
        this.dx = ((QQAppInterface)localObject1).getLoudSpeakerState();
        MediaPlayerManager localMediaPlayerManager = MediaPlayerManager.a((QQAppInterface)localObject1);
        if (localMediaPlayerManager.isPlaying()) {
          localMediaPlayerManager.stop(true);
        }
      }
      boolean bool3 = ija.Y(BaseApplicationImpl.getContext());
      boolean bool2 = AudioHelper.bL(BaseApplicationImpl.getContext());
      if (!this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.play((String)localObject2)) {
        break label409;
      }
      bool1 = bool2;
      if (bool2)
      {
        bool1 = bool2;
        if (bool3) {
          bool1 = AudioHelper.bM(BaseApplicationImpl.getContext());
        }
      }
      BaseChatPie.b(getActivity(), this.dx, bool3, bool1);
      if ((bool3) || (bool1)) {
        break label396;
      }
      bool1 = true;
      aF(bool1, this.dx);
      localObject2 = getActivity();
      if (localObject2 != null) {
        ((Activity)localObject2).getWindow().addFlags(128);
      }
      if (this.gL != null)
      {
        localObject2 = (URLDrawable)this.gL.get();
        if (localObject2 != null) {
          afpu.o((URLDrawable)localObject2);
        }
      }
      this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setProgress(0.0F);
      this.b.setPlayState(true);
    }
    label396:
    label409:
    for (boolean bool1 = true;; bool1 = false)
    {
      if (!bool1) {
        ajdg.e((QQAppInterface)localObject1, "0X800A935", -1, this.g.e.epId);
      }
      localObject2 = new HashMap();
      if (bool1) {}
      for (localObject1 = "0";; localObject1 = "1")
      {
        ((HashMap)localObject2).put("playResult", localObject1);
        ((HashMap)localObject2).put("playType", "2");
        anpc.a(BaseApplication.getContext()).collectPerformance(BaseApplicationImpl.getApplication().getRuntime().getAccount(), "NewAudioEmoticonVoicePlay", bool1, 0L, 0L, (HashMap)localObject2, null);
        return;
        bool1 = false;
        break;
      }
    }
  }
  
  private void stopAudio()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null)
    {
      dbF();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.stop();
    }
  }
  
  private void y(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a == null) {
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a = new a();
    }
    if ((this.g == null) || (this.jdField_f_of_type_ComTencentMobileqqDataEmoticon == null))
    {
      QLog.d("AIOEmotionFragment", 1, "error in json downloading");
      if (paramInt == 32) {}
      Ih(false);
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a.a(paramInt, paramQQAppInterface, getActivity(), this.g, this.mSessionInfo, null);
    afkd.a().a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a);
    ((afke)paramQQAppInterface.getManager(43)).ex(this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.epId, afke.cRu);
  }
  
  public void a(int paramInt, MessageForPic paramMessageForPic)
  {
    this.jdField_c_of_type_Syd.start(paramInt / 100);
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase)
  {
    dbF();
  }
  
  public void a(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    QLog.e("AIOEmotionFragment", 2, "AudioPlayer on onError, errorCode = " + paramInt);
    QQToast.a(this.mContext, 1, 2131690147, 0).show();
    dbF();
  }
  
  public void a(List<afrl> paramList, afrl paramafrl)
  {
    if ((paramList != null) && (!paramList.isEmpty())) {
      this.e.post(new AIOEmotionFragment.8(this, paramList, paramafrl));
    }
  }
  
  public void a(boolean paramBoolean, MessageForPic paramMessageForPic)
  {
    if (paramBoolean)
    {
      this.jdField_a_of_type_Afrm.notifyDataSetChanged();
      this.yZ.setVisibility(0);
    }
    for (;;)
    {
      this.jdField_c_of_type_Syd.hide();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(true);
      return;
      QQToast.a(this.mContext, this.mContext.getString(2131697153), 0).show();
    }
  }
  
  public boolean a(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    report("0X8009980");
    if (this.jdField_a_of_type_Afro.ajS()) {
      dbC();
    }
    return false;
  }
  
  protected void aF(boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramBoolean1) && (!wja.Rc())) {
      if (this.rE == null)
      {
        localFragmentActivity = getActivity();
        if (localFragmentActivity != null) {}
      }
    }
    while (this.rE == null)
    {
      FragmentActivity localFragmentActivity;
      return;
      ((LayoutInflater)localFragmentActivity.getSystemService("layout_inflater")).inflate(2131558690, this.kc);
      this.rE = this.kc.findViewById(2131362513);
      this.bs = ((TextView)this.kc.findViewById(2131362514));
      this.py = ((ImageView)this.kc.findViewById(2131362512));
      this.rE.setOnClickListener(this);
      ((RelativeLayout.LayoutParams)this.rE.getLayoutParams()).addRule(2, 2131366376);
      this.rE.bringToFront();
      this.rE.setVisibility(0);
      if (ThemeUtil.isNowThemeIsNight(getApp(), false, null)) {
        this.bs.setTextColor(Color.parseColor("#FF737373"));
      }
      if (paramBoolean2)
      {
        this.bs.setText(2131690245);
        this.py.setBackgroundResource(2130850969);
        return;
      }
      this.bs.setText(2131690244);
      this.py.setBackgroundResource(2130850968);
      return;
    }
    this.rE.setVisibility(8);
  }
  
  public void aK(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onScaleEnd scale:" + paramFloat);
    }
    Message localMessage = this.e.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Afrm.b(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f1;
    if (this.ku.containsKey(localLong))
    {
      f1 = ((Float)this.ku.get(localLong)).floatValue();
      if (paramFloat <= f1) {
        break label124;
      }
    }
    label124:
    for (int i = 4;; i = 0)
    {
      localMessage.arg1 = i;
      this.e.sendMessage(localMessage);
      return;
      f1 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb();
      break;
    }
  }
  
  public void aL(float paramFloat)
  {
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 2, "onDoubleTap currScale:" + paramFloat);
    }
    Message localMessage = this.e.obtainMessage(1002);
    Long localLong = this.jdField_a_of_type_Afrm.b(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    float f1;
    if (this.ku.containsKey(localLong))
    {
      f1 = ((Float)this.ku.get(localLong)).floatValue();
      if (paramFloat <= f1) {
        break label138;
      }
    }
    label138:
    for (int i = 0;; i = 4)
    {
      localMessage.arg1 = i;
      this.e.sendMessage(localMessage);
      return;
      f1 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb();
      this.ku.put(localLong, Float.valueOf(f1));
      break;
    }
  }
  
  public boolean ajM()
  {
    return mDataSourceType == 0;
  }
  
  public void b(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void c(int paramInt, ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    Object localObject1 = getApp();
    if (localObject1 == null) {
      QLog.d("AIOEmotionFragment", 1, "error runtime");
    }
    Object localObject2;
    Object localObject3;
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            if (QLog.isColorLevel()) {
              QLog.d("AIOEmotionFragment", 1, "handleClickMenuItem, action:" + paramInt);
            }
            localObject2 = (afrl)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
          } while (!(localObject2 instanceof afrt));
          localObject2 = ((afrt)localObject2).messageRecord;
          int i;
          if ((localObject2 instanceof MessageForMarketFace)) {
            i = 0;
          }
          boolean bool;
          switch (paramInt)
          {
          default: 
            return;
          case 2: 
          case 73: 
            report("0X8009981");
            if ((localObject2 instanceof MessageForPic)) {
              xkl.c((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3D", "");
            }
            if (i == 0)
            {
              if ((this.jdField_f_of_type_ComTencentMobileqqDataEmoticon == null) || (this.g == null))
              {
                paramActionSheetItem = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_f_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                  i = 1;
                  break;
                }
              }
              jdField_f_of_type_Afpu = this.g;
              ((ajdg)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.epId, new afrf(this, (QQAppInterface)localObject1));
              return;
            }
            paramActionSheetItem = xkl.a((MessageForPic)localObject2, this.mSessionInfo, (QQAppInterface)localObject1, this.mContext);
            paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            ahgq.a(super.getActivity(), paramActionSheetItem, 1, 100500, "biz_src_jc_gif");
            return;
          case 72: 
            localObject3 = new Bundle();
            ((Bundle)localObject3).putInt("key_req", ForwardRecentActivity.bGS);
            ((Bundle)localObject3).putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
            ((Bundle)localObject3).putString("key_direct_show_uin", paramActionSheetItem.uin);
            if (i == 0)
            {
              if (this.g == null)
              {
                QLog.e("AIOEmotionFragment", 2, "ACTION_SEND_TO_SPECIFIED_FRIEND mPicEmotionInfo is null");
                return;
              }
              jdField_f_of_type_Afpu = this.g;
              paramActionSheetItem = new Intent();
              localObject1 = new Bundle();
              ((Bundle)localObject1).putInt("forward_type", 9);
              ((Bundle)localObject1).putBoolean("forward_emotion_from_preview", true);
              paramActionSheetItem.putExtras((Bundle)localObject1);
              paramActionSheetItem.putExtras((Bundle)localObject3);
              ahgq.a(super.getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gif");
              return;
            }
            ((Bundle)localObject3).putBoolean("key_help_forward_pic", true);
            paramActionSheetItem = xkl.a((MessageForPic)localObject2, this.mSessionInfo, (QQAppInterface)localObject1, this.mContext);
            paramActionSheetItem.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
            paramActionSheetItem.putExtras((Bundle)localObject3);
            ahgq.a(super.getActivity(), paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, 100500, "biz_src_jc_gif");
            return;
          case 48: 
            report("0X8009982");
            if ((localObject2 instanceof MessageForPic)) {
              xkl.c((QQAppInterface)localObject1, ((MessageForPic)localObject2).senderuin, ((MessageForPic)localObject2).md5, "0X8009F3E", "");
            }
            if (i == 0)
            {
              if ((this.jdField_f_of_type_ComTencentMobileqqDataEmoticon == null) || (this.g == null))
              {
                paramActionSheetItem = new StringBuilder().append("error mEmoticon, ");
                if (this.jdField_f_of_type_ComTencentMobileqqDataEmoticon == null) {}
                for (bool = true;; bool = false)
                {
                  QLog.d("AIOEmotionFragment", 1, bool);
                  return;
                }
              }
              ((ajdg)((QQAppInterface)localObject1).getManager(14)).a(this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.epId, new afrg(this, (QQAppInterface)localObject1));
              afnu.c((QQAppInterface)localObject1, 2, null, this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.eId);
              return;
            }
            paramActionSheetItem = aoop.getDrawable(aoop.a((MessageForPic)localObject2, 1), -1, -1, null, null, false);
            paramActionSheetItem.setTag(localObject2);
            this.As.add(paramActionSheetItem);
            xtm.a(this.mContext, (QQAppInterface)localObject1, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, getActivity().getResources().getDimensionPixelSize(2131299627), null, ((MessageForPic)localObject2).picExtraData);
            afnu.c((QQAppInterface)localObject1, 2, ((MessageForPic)localObject2).md5, null);
            return;
          case 39: 
            report("0X8009983");
            paramActionSheetItem = aoiz.getFile(aoop.a((MessageForPic)localObject2, 1).toString());
          }
        } while (paramActionSheetItem == null);
        xtm.a(getActivity(), paramActionSheetItem, Utils.Crc64String(paramActionSheetItem.getAbsolutePath() + NetConnInfoCenter.getServerTime()));
        return;
        if ((this.mSessionInfo.cZ == 1) || (this.mSessionInfo.cZ == 3000)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          anot.a(null, "dc00898", "", "", "0X8009EA7", "0X8009EA7", paramInt, 0, "", "", "", "");
          ChatHistoryActivity.a(getActivity(), this.mSessionInfo.aTl, this.mSessionInfo.cZ, this.mSessionInfo.aTn, ((MessageRecord)localObject2).uniseq);
          return;
        }
        if (getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {}
        for (paramInt = 2;; paramInt = 1)
        {
          anot.a(null, "dc00898", "", "", "0X8009EA8", "0X8009EA8", paramInt, 0, "", "", "", "");
          localObject1 = this.mSessionInfo.troopUin;
          paramActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)localObject1;
          if (TextUtils.isEmpty((CharSequence)localObject1)) {
            paramActionSheetItem = this.mSessionInfo.aTl;
          }
          xsk.a(getActivity(), this.mSessionInfo.cZ, this.mSessionInfo.aTl, paramActionSheetItem, ((MessageRecord)localObject2).time, ((MessageRecord)localObject2).shmsgseq, ((MessageRecord)localObject2).istroop, true);
          return;
        }
        if (!jof.a((MessageRecord)localObject2)) {
          break label1223;
        }
        paramActionSheetItem = jof.a((MessageRecord)localObject2);
        if ((paramActionSheetItem.TF != null) || (paramActionSheetItem.flags == 2)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("AIOEmotionFragment", 2, "Anonymous report : an_id is null");
      return;
      localObject3 = paramActionSheetItem.B();
    } while ((localObject3 == null) || (paramActionSheetItem.flags == 2));
    paramActionSheetItem = URLEncoder.encode(Base64.encodeToString((byte[])localObject3, 2));
    jof.a().a(((MessageRecord)localObject2).frienduin, paramActionSheetItem, (MessageRecord)localObject2);
    stj.b((QQAppInterface)localObject1, ((MessageRecord)localObject2).frienduin, paramActionSheetItem, ((QQAppInterface)localObject1).getCurrentAccountUin(), jof.a().I(((MessageRecord)localObject2).frienduin, paramActionSheetItem));
    return;
    label1223:
    paramActionSheetItem = ((MessageRecord)localObject2).senderuin;
    stj.a((BaseActivity)this.mContext, paramActionSheetItem, ((MessageRecord)localObject2).frienduin, ((QQAppInterface)localObject1).getCurrentAccountUin(), stj.es(this.mSessionInfo.cZ), null);
  }
  
  public void c(AudioPlayerBase paramAudioPlayerBase, int paramInt) {}
  
  public void d(AudioPlayerBase paramAudioPlayerBase, int paramInt)
  {
    if ((this.g != null) && (this.g.isNewSoundType()))
    {
      String str1 = afnu.bEr.replace("[epId]", this.g.e.epId).replace("[eId]", this.g.e.eId);
      String str2 = paramAudioPlayerBase.getSourcePath();
      this.e.post(new AIOEmotionFragment.9(this, str2, str1, paramInt, paramAudioPlayerBase));
    }
  }
  
  public void d(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4)
  {
    paramBoolean4 = paramBoolean2;
    if (paramBoolean2)
    {
      paramBoolean4 = paramBoolean2;
      if (paramBoolean1) {
        paramBoolean4 = AudioHelper.bM(BaseApplicationImpl.getContext());
      }
    }
    BaseChatPie.b(getActivity(), paramBoolean3, paramBoolean1, paramBoolean4);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.isPlaying()) && (!paramBoolean1) && (!paramBoolean4)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      aF(paramBoolean1, paramBoolean3);
      return;
    }
  }
  
  protected void dbC()
  {
    boolean bool = false;
    Object localObject1 = (afrl)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    Object localObject2;
    int i;
    if ((localObject1 instanceof afrt))
    {
      localObject2 = ((afrt)localObject1).messageRecord;
      if (((localObject2 instanceof MessageForPic)) && (((MessageForPic)localObject2).picExtraData != null)) {
        if ((((MessageForPic)localObject2).picExtraData.isZhitu()) && (!((MessageRecord)localObject2).isSend())) {
          i = 1;
        }
      }
    }
    for (;;)
    {
      if (this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet == null)
      {
        localObject2 = new ShareActionSheetV2.Param();
        ((ShareActionSheetV2.Param)localObject2).context = this.mContext;
        this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet = ShareActionSheetFactory.create((ShareActionSheetV2.Param)localObject2);
        this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetTitle(this.mContext.getString(2131694193));
      }
      localObject2 = new ArrayList();
      ArrayList localArrayList = new ArrayList();
      aqly.a(2, (ArrayList)localObject2);
      aqly.a(48, localArrayList);
      if (!getActivity().getIntent().getBooleanExtra("from_chat_history", false)) {
        aqly.a(65, localArrayList);
      }
      if (!((afrl)localObject1).ajO()) {
        aqly.a(39, localArrayList);
      }
      if (getActivity().getIntent().getBooleanExtra("hide_emo_position", true)) {
        aqly.a(54, localArrayList);
      }
      if (i != 0) {
        aqly.a(66, localArrayList);
      }
      this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setItemClickListenerV2(new afrd(this));
      this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setActionSheetItems((List)localObject2, localArrayList);
      if (getActivity() != null) {
        getActivity().getIntent().putExtra("big_brother_source_key", "biz_src_jc_gif");
      }
      localObject2 = getApp();
      if (((localObject1 instanceof afrt)) && (localObject2 != null))
      {
        localObject1 = ((afrt)localObject1).messageRecord;
        if ((localObject1 instanceof MessageForMarketFace)) {
          i = 0;
        }
        for (;;)
        {
          if (i == 0)
          {
            if ((this.jdField_f_of_type_ComTencentMobileqqDataEmoticon != null) && (this.g != null))
            {
              jdField_f_of_type_Afpu = this.g;
              ((ajdg)((QQAppInterface)localObject2).getManager(14)).a(this.jdField_f_of_type_ComTencentMobileqqDataEmoticon.epId, new afre(this, (QQAppInterface)localObject2));
              return;
              i = 0;
              break;
              i = 1;
              continue;
            }
            localObject1 = new StringBuilder().append("error mEmoticon, ");
            if (this.jdField_f_of_type_ComTencentMobileqqDataEmoticon == null) {
              bool = true;
            }
            QLog.d("AIOEmotionFragment", 1, bool);
          }
        }
      }
      for (;;)
      {
        this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.show();
        return;
        localObject1 = xkl.a((MessageForPic)localObject1, this.mSessionInfo, (QQAppInterface)localObject2, this.mContext);
        ((Intent)localObject1).putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", super.getActivity().getClass().getName());
        ((Intent)localObject1).putExtra("key_new_img_shareactionsheet", 1);
        ((Intent)localObject1).putExtra("k_dataline", true);
        this.jdField_d_of_type_ComTencentMobileqqWidgetShareShareActionSheet.setIntentForStartForwardRecentActivity((Intent)localObject1);
      }
      i = 0;
    }
  }
  
  public void dbE()
  {
    Object localObject = this.jdField_a_of_type_Afrm.b(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition());
    if (!this.ku.containsKey(localObject)) {
      this.ku.put(localObject, Float.valueOf(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb()));
    }
    localObject = this.e.obtainMessage(1002);
    ((Message)localObject).arg1 = 4;
    this.e.sendMessage((Message)localObject);
  }
  
  public void dbG()
  {
    this.e.post(new AIOEmotionFragment.10(this));
  }
  
  public void dbH()
  {
    if (jdField_a_of_type_Afrl == null)
    {
      QLog.d("AIOEmotionFragment", 1, "initDataResource fail");
      return;
    }
    if (mDataSourceType == 0) {
      this.jdField_a_of_type_Afro = new afru(getActivity().getIntent(), (afrt)jdField_a_of_type_Afrl, this.mSessionInfo);
    }
    for (;;)
    {
      this.jdField_a_of_type_Afrm = new afrm(getActivity(), this.e, jdField_a_of_type_Afrl);
      return;
      if (mDataSourceType == 1) {
        this.jdField_a_of_type_Afro = new afrs(getApp(), (afrr)jdField_a_of_type_Afrl);
      }
    }
  }
  
  public View f(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup)
  {
    return paramLayoutInflater.inflate(2131558651, paramViewGroup, false);
  }
  
  public void fG(long paramLong)
  {
    if ((this.jdField_a_of_type_Afro instanceof afru)) {
      ((afru)this.jdField_a_of_type_Afro).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.jdField_a_of_type_Afrm, paramLong, this);
    }
  }
  
  public void g(boolean paramBoolean1, boolean paramBoolean2)
  {
    paramBoolean1 = ija.Y(BaseApplicationImpl.getContext());
    boolean bool = AudioHelper.bL(BaseApplicationImpl.getContext());
    BaseChatPie.b(getActivity(), paramBoolean2, paramBoolean1, bool);
    if ((this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.isPlaying()) && (!paramBoolean1) && (!bool)) {}
    for (paramBoolean1 = true;; paramBoolean1 = false)
    {
      aF(paramBoolean1, paramBoolean2);
      return;
    }
  }
  
  protected void gw(View paramView)
  {
    Intent localIntent = getActivity().getIntent();
    this.aU = ((Rect)localIntent.getParcelableExtra("KEY_THUMBNAL_BOUND"));
    this.mSessionInfo = ((SessionInfo)localIntent.getParcelableExtra("session_info"));
    dbH();
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery = ((EmotionGallery)paramView.findViewById(2131367833));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setAdapter(this.jdField_a_of_type_Afrm);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScaleChangeListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnScollListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setSpacing(this.mContext.getResources().getDimensionPixelSize(2131297406));
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemLongClickListener(this);
    this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.setOnItemSelectedListener(this);
    this.dR = ((RelativeLayout)paramView.findViewById(2131379791));
    this.jP = paramView.findViewById(2131363236);
    this.jdField_a_of_type_ComTencentWidgetDragView = ((DragView)paramView.findViewById(2131366139));
    this.jdField_a_of_type_ComTencentWidgetDragView.init();
    this.jdField_a_of_type_ComTencentWidgetDragView.setGestureChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setDragChangeListener(this);
    this.jdField_a_of_type_ComTencentWidgetDragView.setRatioModify(false);
    this.RC = ((TextView)paramView.findViewById(2131362398));
    this.gd = ((Button)paramView.findViewById(2131362399));
    this.RD = ((TextView)paramView.findViewById(2131365766));
    this.RE = ((TextView)paramView.findViewById(2131365764));
    this.BZ = paramView.findViewById(2131366376);
    this.BZ.setVisibility(8);
    this.yX = ((ImageView)paramView.findViewById(2131365765));
    this.yY = ((ImageView)paramView.findViewById(2131365767));
    getApp().addObserver(this.jdField_a_of_type_Acea);
    this.yZ = ((ImageView)this.mRootView.findViewById(2131369594));
    this.yG = ((ImageView)paramView.findViewById(2131362394));
    this.jdField_c_of_type_Syd = new syd();
    this.jdField_c_of_type_Syd.init(super.getActivity(), this.yG);
    this.jZ = ((RelativeLayout)paramView.findViewById(2131362397));
    this.ka = ((RelativeLayout)paramView.findViewById(2131363090));
    this.jdField_c_of_type_ComTencentMobileqqActivityContactConnectionsTriangleView = ((TriangleView)paramView.findViewById(2131373411));
    this.kb = ((RelativeLayout)paramView.findViewById(2131363091));
    this.b = ((PttAudioPlayView)paramView.findViewById(2131363092));
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView = ((PttAudioWaveView)paramView.findViewById(2131363094));
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setCanSupportSlide(false);
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setShowProgressLine(false);
    this.b.setPttPauseOrStopDrawable(2130838309);
    hR(afpu.cTb, afpu.cTc);
    this.b.setOnClickListener(this);
    this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.setOnClickListener(this);
    this.ka.setVisibility(8);
    this.kc = ((RelativeLayout)paramView.findViewById(2131372824));
    xsi.a().a(this);
    this.density = getResources().getDisplayMetrics().density;
    this.bYV = ((int)(this.density * 6.0F));
    if ((getActivity().getIntent().getBooleanExtra("need_reload_data", true)) && (this.jdField_a_of_type_Afro != null))
    {
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, " initData dataSource=" + this.jdField_a_of_type_Afro);
      }
      this.jdField_a_of_type_Afro.a(this, jdField_a_of_type_Afrl, false);
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    int j;
    int i;
    do
    {
      do
      {
        return true;
      } while ((paramMessage.obj == null) || (!(paramMessage.obj instanceof String)));
      paramMessage = (String)paramMessage.obj;
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "update album name:" + paramMessage);
      }
      this.RD.setText(paramMessage);
      return true;
      j = paramMessage.arg1;
      i = paramMessage.arg2;
    } while ((j == this.cTx) && (i == 0));
    if (j != this.cTx)
    {
      i = 1;
      label139:
      this.cTx = j;
      this.gL = null;
      this.g = null;
      if (j == -1) {
        break label257;
      }
    }
    label257:
    for (Object localObject = this.jdField_a_of_type_Afrm.a(j);; localObject = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem())
    {
      localObject = (afrl)localObject;
      if ((!this.caw) && (!this.jdField_a_of_type_Afrm.jz(j))) {
        break;
      }
      if (!this.hasScrolled) {
        break label269;
      }
      if ((i != 0) && (isAudioPlaying()))
      {
        QLog.d("AIOEmotionFragment", 2, "MSG_UPDATE_EMOTION_UI stopAudio");
        stopAudio();
      }
      this.jZ.setVisibility(4);
      this.BZ.setVisibility(4);
      return true;
      i = 0;
      break label139;
    }
    label269:
    this.ka.setVisibility(8);
    float f2;
    afmi localafmi;
    afpu localafpu;
    if ((((afrl)localObject).ajO()) && (j != -1))
    {
      f2 = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb();
      localafmi = ((afrl)localObject).a();
      if (localafmi != null) {
        if ((localafmi instanceof afpu))
        {
          localafpu = (afpu)localafmi;
          if (localafpu.e != null) {
            if (!this.ku.containsKey(this.jdField_a_of_type_Afrm.b(j))) {
              break label701;
            }
          }
        }
      }
    }
    label701:
    for (float f1 = ((Float)this.ku.get(this.jdField_a_of_type_Afrm.b(j))).floatValue();; f1 = f2)
    {
      if ((f1 > 0.0F) && (f2 <= f1)) {}
      this.g = localafpu;
      this.jdField_f_of_type_ComTencentMobileqqDataEmoticon = localafpu.e;
      this.RC.setText(localafpu.e.name);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bringToFront();
      QLog.d("AIOEmotionFragment", 1, "getView emotion name:" + localafpu.e.name);
      if (a(localafpu))
      {
        paramMessage = (Drawable)paramMessage.obj;
        if ((paramMessage != null) && ((paramMessage instanceof URLDrawable))) {
          this.gL = new WeakReference((URLDrawable)paramMessage);
        }
      }
      ajN();
      e(localafmi);
      while (((localObject instanceof afrt)) && (!((afrl)localObject).ajO()) && (!((afru)this.jdField_a_of_type_Afro).b((afrl)localObject)))
      {
        this.yZ.setVisibility(8);
        this.jdField_c_of_type_Syd.show();
        this.jdField_c_of_type_Syd.start(0);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(false);
        this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(false);
        ((afru)this.jdField_a_of_type_Afro).a(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery, this.e, (afrl)localObject, this);
        return true;
        this.jZ.setVisibility(4);
        this.BZ.setVisibility(4);
        if (((afrl)localObject).ajQ()) {
          a((afrt)localObject);
        }
        if (((afrl)localObject).ajR()) {
          b((afrt)localObject);
        }
        a(j, (afrl)localObject);
      }
      this.yZ.setVisibility(0);
      this.jdField_c_of_type_Syd.hide();
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableDoubleTap(true);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.enableScaleGesture(true);
      return true;
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((paramInt2 == -1) && (paramInt1 == 1))
    {
      paramIntent.putExtra("selfSet_leftViewText", this.mContext.getString(2131720735));
      paramIntent = new Bundle(paramIntent.getExtras());
      localIntent = new Intent();
      localIntent.putExtras(paramIntent);
      if (super.getApp() != null) {
        ForwardUtils.a(super.getApp(), super.getActivity(), this.mContext, localIntent, ThreadManager.getUIHandler());
      }
    }
    while ((paramInt2 != -1) || (paramInt1 != 2))
    {
      Intent localIntent;
      return;
    }
    this.e.removeMessages(1001);
    this.e.obtainMessage(1001, -1, 1).sendToTarget();
  }
  
  public void onClick(View paramView)
  {
    boolean bool2 = true;
    if ((paramView.getId() == 2131362399) || (paramView.getId() == 2131362398)) {
      if (this.gd.getVisibility() == 0) {}
    }
    Object localObject;
    do
    {
      do
      {
        for (;;)
        {
          EventCollector.getInstance().onViewClicked(paramView);
          return;
          CustomEmotionData localCustomEmotionData = ((afrl)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem()).a();
          if (localCustomEmotionData != null)
          {
            if (!TextUtils.isEmpty(localCustomEmotionData.modifyWord)) {}
            for (localObject = localCustomEmotionData.modifyWord;; localObject = localCustomEmotionData.ocrWord)
            {
              Intent localIntent = new Intent(getActivity(), EditActivity.class);
              localIntent.putExtra("title", 2131693107);
              localIntent.putExtra("limit", 30);
              localIntent.putExtra("action", 105);
              localIntent.putExtra("key_emo_id", localCustomEmotionData.emoId);
              localIntent.putExtra("key_input_tip", getResources().getString(2131693108));
              localIntent.putExtra("current", (String)localObject);
              localIntent.putExtra("canPostNull", false);
              localIntent.putExtra("multiLine", false);
              anot.a(null, "dc00898", "", "", "0X800A7C1", "0X800A7C1", this.jdField_a_of_type_Afro.Dw(), 0, "", "", "", "");
              startActivityForResult(localIntent, 2);
              break;
            }
            if ((paramView.getId() != 2131363092) && (paramView.getId() != 2131363094)) {
              break;
            }
            if (isAudioPlaying())
            {
              stopAudio();
              if ((this.g != null) && (this.g.e != null)) {
                ajdg.e(getApp(), "0X800A9E1", -1, this.g.e.epId);
              }
            }
            else
            {
              playAudio();
              if ((this.g != null) && (this.g.e != null)) {
                ajdg.e(getApp(), "0X800A9E0", -1, this.g.e.epId);
              }
            }
          }
        }
      } while (paramView.getId() != 2131362513);
      localObject = getApp();
    } while (localObject == null);
    boolean bool3 = ija.Y(BaseApplicationImpl.getContext());
    boolean bool4 = AudioHelper.bL(BaseApplicationImpl.getContext());
    if (!this.dx)
    {
      bool1 = true;
      label414:
      this.dx = bool1;
      ((QQAppInterface)localObject).setLoudSpeakerState(bool1);
      bool1 = isAudioPlaying();
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.aM(1, this.dx);
      BaseChatPie.b(getActivity(), this.dx, bool3, bool4);
      if ((bool3) || (bool4) || (!bool1)) {
        break label490;
      }
    }
    label490:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      aF(bool1, this.dx);
      break;
      bool1 = false;
      break label414;
    }
  }
  
  public void onClickDragView() {}
  
  public void onContentMove(float paramFloat)
  {
    this.jP.setAlpha(paramFloat);
    if (paramFloat < 0.9F)
    {
      this.dR.setVisibility(4);
      this.BZ.setVisibility(4);
      this.yG.setVisibility(4);
      this.jZ.setVisibility(4);
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    boolean bool = false;
    super.onCreate(paramBundle);
    if (jdField_a_of_type_Afrl == null) {
      bool = true;
    }
    QLog.d("AIOEmotionFragment", 1, new Object[] { "onCreate, mCurDataIsNull:", Boolean.valueOf(bool) });
    if (jdField_a_of_type_Afrl == null) {}
    try
    {
      jdField_a_of_type_Afrl = afrl.a(paramBundle);
      return;
    }
    catch (Exception paramBundle)
    {
      QLog.d("AIOEmotionFragment", 1, "onCreate exception:", paramBundle);
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    int i = 1;
    if (QLog.isColorLevel()) {
      QLog.d("AIOEmotionFragment", 1, "onCreateView");
    }
    if ((jdField_a_of_type_Afrl != null) && (jdField_a_of_type_Afrl.ajO())) {}
    for (;;)
    {
      this.cTw = i;
      paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
      V4FragmentCollector.onV4FragmentViewCreated(this, paramLayoutInflater);
      return paramLayoutInflater;
      i = 2;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.e.removeCallbacksAndMessages(null);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a != null)
    {
      afkd.a().b(this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a);
      this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateAIOEmotionFragment$a = null;
    }
    getApp().removeObserver(this.jdField_a_of_type_Acea);
    if (this.jdField_a_of_type_Afro != null) {
      this.jdField_a_of_type_Afro.onDestroy();
    }
    Object localObject;
    if (!this.As.isEmpty())
    {
      localObject = this.As.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((URLDrawable)((Iterator)localObject).next()).setTag(null);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer != null)
    {
      if (this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.isPlaying()) {
        this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.stop();
      }
      localObject = getApp();
      if (localObject != null) {
        AudioDeviceManager.a((QQAppInterface)localObject).b(this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer);
      }
      this.jdField_a_of_type_ComTencentMobileqqActivityAioCommonAudioPlayer.doOnDestory();
    }
    if (this.rE != null)
    {
      this.rE.setVisibility(4);
      this.rE = null;
    }
    this.gL = null;
    if (this.b != null) {
      this.b.destory();
    }
    if (this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView != null) {
      this.jdField_d_of_type_ComTencentMobileqqActivityAioItemPttAudioWaveView.destory();
    }
    xsi.a().b(this);
  }
  
  public void onGestureFinish()
  {
    FragmentActivity localFragmentActivity = getActivity();
    if ((localFragmentActivity != null) && (!localFragmentActivity.isFinishing()))
    {
      localFragmentActivity.finish();
      localFragmentActivity.overridePendingTransition(0, 0);
    }
  }
  
  public void onItemSelected(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (this.jdField_a_of_type_Afrm.jz(paramInt))
    {
      this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(this.aU);
      return;
    }
    this.jdField_a_of_type_ComTencentWidgetDragView.setOriginRect(null);
  }
  
  public int[] onModifyCurViewSize()
  {
    Object localObject = (ImageView)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedView();
    if (localObject == null) {
      return null;
    }
    localObject = ((ImageView)localObject).getDrawable();
    if (localObject == null) {
      return null;
    }
    return new int[] { (int)(((Drawable)localObject).getIntrinsicWidth() * this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb()), (int)(((Drawable)localObject).getIntrinsicHeight() * this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb()) };
  }
  
  public void onNothingSelected(AdapterView<?> paramAdapterView) {}
  
  public void onPause()
  {
    super.onPause();
    if (isAudioPlaying()) {
      stopAudio();
    }
  }
  
  public void onResetPosition()
  {
    afrl localafrl = (afrl)this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItem();
    this.dR.setVisibility(0);
    if (localafrl.ajO()) {
      return;
    }
    this.BZ.setVisibility(4);
    if (localafrl.a() != null) {}
    this.jZ.setVisibility(4);
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSaveInstanceState(Bundle paramBundle)
  {
    super.onSaveInstanceState(paramBundle);
    if (jdField_a_of_type_Afrl != null)
    {
      QLog.d("AIOEmotionFragment", 1, "onSaveInstanceState");
      jdField_a_of_type_Afrl.b(paramBundle, mDataSourceType);
    }
  }
  
  public void onScrollEnd(int paramInt)
  {
    if (!this.hasScrolled) {
      return;
    }
    int i = this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition();
    QLog.d("AIOEmotionFragment", 1, "getView onScrollEnd:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " selectPos: " + i + " hasScrolled: " + this.hasScrolled);
    if (this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.bb() == this.wj) {}
    for (paramInt = 0;; paramInt = 1)
    {
      this.hasScrolled = false;
      this.caw = true;
      this.e.removeMessages(1001);
      this.e.obtainMessage(1001, i, paramInt).sendToTarget();
      return;
    }
  }
  
  public void onScrollStart(int paramInt)
  {
    QLog.d("AIOEmotionFragment", 1, "getView onScrollStart:" + paramInt + " currentPosition:" + this.jdField_a_of_type_ComTencentMobileqqEmotionintegrateEmotionGallery.getSelectedItemPosition() + " hasScrolled: " + this.hasScrolled);
    this.caw = true;
    if (!this.hasScrolled)
    {
      this.hasScrolled = true;
      this.e.removeMessages(1001);
      this.e.obtainMessage(1001, -1, 0).sendToTarget();
    }
  }
  
  public class a
    extends afko
  {
    private QQAppInterface app;
    private afpu c;
    private Context context;
    private int opType;
    private arhz progressDialog;
    private SessionInfo sessionInfo;
    
    public a() {}
    
    public void a(int paramInt, QQAppInterface paramQQAppInterface, Context paramContext, afpu paramafpu, SessionInfo paramSessionInfo, arhz paramarhz)
    {
      this.opType = paramInt;
      this.app = paramQQAppInterface;
      this.context = paramContext;
      this.c = paramafpu;
      this.sessionInfo = paramSessionInfo;
      this.progressDialog = paramarhz;
    }
    
    public void a(EmoticonPackage paramEmoticonPackage, int paramInt, Bundle paramBundle)
    {
      boolean bool = true;
      if (QLog.isColorLevel()) {
        QLog.d("AIOEmotionFragment", 2, "onJsonComplete:" + paramEmoticonPackage.epId + " ,currEpid:" + this.c.e.epId);
      }
      if (this.opType == 32) {
        if ((paramInt == 0) && (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.c.e.epId))) {
          AIOEmotionFragment.a(AIOEmotionFragment.this, bool);
        }
      }
      do
      {
        return;
        bool = false;
        break;
        if (paramInt != 0) {
          break label233;
        }
      } while (Long.parseLong(paramEmoticonPackage.epId) != Long.parseLong(this.c.e.epId));
      this.app.getPreferences().edit().putInt("emosm_json_last_download_timestamp", (int)(System.currentTimeMillis() / 1000L)).commit();
      MarketFaceItemBuilder.a(this.opType, this.context, this.app, paramEmoticonPackage, this.c, this.sessionInfo, this.progressDialog, true);
      paramBundle = AIOEmotionFragment.this.e.obtainMessage(1000);
      paramBundle.obj = paramEmoticonPackage.name;
      AIOEmotionFragment.this.e.sendMessage(paramBundle);
      return;
      label233:
      MarketFaceItemBuilder.a(this.opType + 1000, this.context, this.app, paramEmoticonPackage, this.c, this.sessionInfo, this.progressDialog, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment
 * JD-Core Version:    0.7.0.1
 */