package com.tencent.mobileqq.activity;

import alk;
import alm;
import aln;
import alo;
import alp;
import alq;
import alr;
import als;
import alt;
import alu;
import alv;
import alw;
import alx;
import aly;
import alz;
import ama;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.activity.aio.MediaPlayerManager;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.EmoticonPackage;
import com.tencent.mobileqq.emoticon.EmojiManager;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
import com.tencent.mobileqq.utils.StartupTracker;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.widget.MyGridView;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

public class EmosmDetailActivity
  extends IphoneTitleBarActivity
{
  public static final int a = 4;
  public static final String a = "Q.emoji.EmosmDetailActivity";
  public static final int b = 15;
  public static final int c = 10;
  public static ImageView e;
  public static ImageView f;
  ama jdField_a_of_type_Ama;
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new als(this);
  public Emoticon a;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = null;
  public PicEmoticonInfo a;
  private DownloadListener jdField_a_of_type_ComTencentMobileqqVipDownloadListener = new alk(this, "param_WIFIEmojiStoreDownloadFlow", "param_XGEmojiStoreDownloadFlow");
  MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  boolean jdField_a_of_type_Boolean;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  public boolean b;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  public boolean c;
  public int d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  public boolean d;
  public int e;
  TextView e;
  public int f;
  TextView f;
  public int g;
  TextView g;
  public int h;
  public int i;
  
  public EmosmDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = null;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_c_of_type_Boolean = false;
    this.jdField_d_of_type_Boolean = false;
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo)
  {
    if (((EmoticonManager)paramQQAppInterface.getManager(13)).a(paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).mobileFeetype == 1)
    {
      b(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, 0, null, paramQQProgressDialog, paramSessionInfo);
      return;
    }
    if ((!NetworkUtil.f(paramContext)) || (paramInt > 1000))
    {
      b(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, -404, "网络异常，请稍后再试", paramQQProgressDialog, paramSessionInfo);
      return;
    }
    EmosmHandler localEmosmHandler = (EmosmHandler)paramQQAppInterface.a(11);
    localEmosmHandler.a(new alz(localEmosmHandler, paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, paramQQProgressDialog, paramSessionInfo));
    localEmosmHandler.a(paramInt, Integer.valueOf(paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).intValue(), paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3, int paramInt)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", paramString2, paramString3, paramInt, 0, "", "", "", "");
  }
  
  private static void b(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, Emoticon paramEmoticon, String paramString1, String paramString2)
  {
    try
    {
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131362794, 2131363134, new alq(paramContext, paramQQAppInterface, paramEmoticon, paramInt), new alr()).show();
      return;
    }
    catch (Exception paramContext)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("EmosmDetailActivity.showCustomMarketFaceTips", 2, paramContext.getMessage());
    }
  }
  
  private static void b(int paramInt1, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, int paramInt2, String paramString, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo)
  {
    Handler localHandler = new Handler(Looper.getMainLooper());
    paramQQProgressDialog.dismiss();
    if (paramInt2 == 0)
    {
      if (7 == paramInt1 % 1000) {}
      do
      {
        do
        {
          try
          {
            paramQQAppInterface = new Bundle();
            paramQQAppInterface.putInt("forward_type", 9);
            paramPicEmoticonInfo = new Intent(paramContext, ForwardRecentActivity.class);
            paramPicEmoticonInfo.putExtras(paramQQAppInterface);
            ((BaseActivity)paramContext).startActivityForResult(paramPicEmoticonInfo, 21);
            return;
          }
          catch (Exception paramContext)
          {
            while (!QLog.isColorLevel()) {}
            QLog.e("EmosmDetailActivity.operateMarketFaceFromDownLoad", 2, paramContext.getMessage());
            return;
          }
          if (6 != paramInt1 % 1000) {
            break;
          }
          paramString = paramQQAppInterface.a().createEntityManager();
          paramQQProgressDialog = paramString.a(CustomEmotionData.class, false, null, null, null, null, null, null);
          if (paramQQProgressDialog != null)
          {
            paramInt1 = 1;
            paramInt2 = 0;
            for (;;)
            {
              j = paramInt1;
              if (paramInt2 >= paramQQProgressDialog.size()) {
                break;
              }
              paramSessionInfo = (CustomEmotionData)paramQQProgressDialog.get(paramInt2);
              if ((paramSessionInfo.isMarkFace) && (paramSessionInfo.emoPath.equals(paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) && (paramSessionInfo.eId.equals(paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId)))
              {
                localHandler.post(new alm(paramContext));
                return;
              }
              j = paramInt1;
              if (paramInt1 < paramSessionInfo.emoId) {
                j = paramSessionInfo.emoId;
              }
              paramInt2 += 1;
              paramInt1 = j;
            }
          }
          int j = 1;
          paramQQProgressDialog = new CustomEmotionData();
          paramQQProgressDialog.uin = paramQQAppInterface.a();
          paramQQProgressDialog.emoId = (j + 1);
          paramQQProgressDialog.isMarkFace = true;
          paramQQProgressDialog.emoPath = paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
          paramQQProgressDialog.eId = paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId;
          paramString.a(paramQQProgressDialog);
          paramString.a();
          ChatActivityFacade.a(paramQQAppInterface, paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon);
          a(paramQQAppInterface, MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage.frienduin, "ep_mall", "Clk_collect_suc", 0);
          localHandler.post(new aln(paramContext));
          if (paramImageView != null) {
            paramImageView.setEnabled(false);
          }
          paramContext = paramQQAppInterface.a(ChatActivity.class);
        } while (paramContext == null);
        paramContext.obtainMessage(10).sendToTarget();
        return;
      } while (107 != paramInt1 % 1000);
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "ep_mall", "Ep_follow_send_aio", 0, 0, "", paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId, "", "");
      paramPicEmoticonInfo.a(paramQQAppInterface, paramContext, null, paramSessionInfo);
      return;
    }
    if (paramInt2 < 0)
    {
      localHandler.post(new alo(paramContext, paramString));
      return;
    }
    localHandler.post(new alp(paramInt1, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramString));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.jdField_a_of_type_AndroidContentContext, 17432582));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new alw(this));
  }
  
  public void a()
  {
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298623));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298625));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298627));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298624));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298626));
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131364088);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new alu(this));
  }
  
  public void a(EmoticonPackage paramEmoticonPackage)
  {
    if (this.jdField_c_of_type_Boolean == true)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.EmosmDetailActivity", 2, "initData has executed");
      }
      return;
    }
    this.jdField_c_of_type_Boolean = true;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = paramEmoticonPackage;
    Object localObject1 = paramEmoticonPackage.name;
    Object localObject2 = localObject1;
    if (((String)localObject1).length() > 5) {
      localObject2 = ((String)localObject1).substring(0, 5) + "...";
    }
    setTitle((CharSequence)localObject2);
    int j = paramEmoticonPackage.downloadCount / 10000;
    if (j < 1)
    {
      localObject1 = "1万人在用";
      label101:
      if (!this.jdField_a_of_type_Boolean) {
        break label398;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131364092));
      this.jdField_e_of_type_AndroidWidgetTextView.setText((CharSequence)localObject2);
      this.jdField_f_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramEmoticonPackage.mark);
      localObject1 = this.jdField_d_of_type_AndroidWidgetImageView;
      label158:
      j = paramEmoticonPackage.mobileFeetype;
      if ((j == 4) || (j == 5)) {
        ((ImageView)localObject1).setVisibility(0);
      }
      switch (j)
      {
      default: 
        label200:
        paramEmoticonPackage = (ArrayList)((EmoticonManager)this.app.getManager(13)).a(this.jdField_b_of_type_JavaLangString);
        if ((paramEmoticonPackage != null) && (!this.jdField_a_of_type_Boolean))
        {
          if (QLog.isColorLevel()) {
            QLog.i("Q.emoji.EmosmDetailActivity", 2, "emoticon size:" + paramEmoticonPackage.size());
          }
          this.jdField_a_of_type_Ama = new ama(this, paramEmoticonPackage);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(15);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVerticalSpacing(10);
          this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Ama);
        }
        break;
      }
    }
    for (;;)
    {
      if (!this.jdField_d_of_type_Boolean) {
        e();
      }
      if (this.jdField_b_of_type_Boolean != true) {
        break;
      }
      d();
      return;
      if (j > 9999)
      {
        j /= 10000;
        localObject1 = j + "亿人在用";
        break label101;
      }
      localObject1 = j + "万人在用";
      break label101;
      label398:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(MessageFormat.format(getResources().getString(2131364091), new Object[] { paramEmoticonPackage.name }));
      this.jdField_d_of_type_AndroidWidgetTextView.setText((CharSequence)localObject1);
      localObject1 = this.jdField_c_of_type_AndroidWidgetImageView;
      break label158;
      ((ImageView)localObject1).setImageResource(2130839448);
      break label200;
      ((ImageView)localObject1).setImageResource(2130839371);
      break label200;
      ((RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams()).height = ((int)(BaseApplication.getContext().getResources().getDisplayMetrics().density * 120.0F));
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVisibility(8);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      if (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
      {
        this.jdField_a_of_type_AndroidWidgetProgressBar = new ProgressBar(this.jdField_a_of_type_AndroidContentContext);
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130837906));
        j = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(j, j);
        localLayoutParams.bottomMargin = j;
        localLayoutParams.addRule(1, 2131296338);
        localLayoutParams.addRule(13);
        this.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(this.jdField_a_of_type_AndroidWidgetProgressBar, localLayoutParams);
      }
      this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(0);
    }
    while (this.jdField_a_of_type_AndroidWidgetProgressBar == null)
    {
      int j;
      RelativeLayout.LayoutParams localLayoutParams;
      return;
    }
    this.jdField_a_of_type_AndroidWidgetProgressBar.setVisibility(8);
  }
  
  public void b()
  {
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298617));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298620));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298618));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)super.findViewById(2131298619));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new alv(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298610));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)super.findViewById(2131298611));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298612));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)super.findViewById(2131298613));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131296966));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298615));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131298621));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)super.findViewById(2131298628));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)super.findViewById(2131297259));
    jdField_e_of_type_AndroidWidgetImageView = (ImageView)super.findViewById(2131296333);
    jdField_f_of_type_AndroidWidgetImageView = (ImageView)super.findViewById(2131296334);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a();
    }
    Object localObject;
    for (;;)
    {
      int j = super.getResources().getDimensionPixelSize(2131492999);
      this.jdField_d_of_type_Int = ((((WindowManager)super.getSystemService("window")).getDefaultDisplay().getWidth() - j * 2 - 45) / 4);
      this.jdField_e_of_type_Int = this.jdField_d_of_type_Int;
      if (!this.jdField_a_of_type_Boolean)
      {
        localObject = (RelativeLayout.LayoutParams)this.jdField_b_of_type_AndroidWidgetRelativeLayout.getLayoutParams();
        ((RelativeLayout.LayoutParams)localObject).height = (this.jdField_e_of_type_Int * 2 + (int)(BaseApplication.getContext().getResources().getDisplayMetrics().density * 75.0F));
        this.jdField_b_of_type_AndroidWidgetRelativeLayout.setLayoutParams((ViewGroup.LayoutParams)localObject);
      }
      localObject = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.name;
      if (localObject != null)
      {
        String str = ((String)localObject).trim();
        localObject = str;
        if (str.length() >= 2)
        {
          localObject = str;
          if (str.charAt(0) == '[')
          {
            localObject = str;
            if (str.charAt(str.length() - 1) == ']') {
              localObject = str.substring(1, str.length() - 1);
            }
          }
        }
        if (((String)localObject).indexOf("null") <= -1) {
          break;
        }
        this.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
      }
      return;
      this.jdField_c_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      b();
    }
    this.jdField_a_of_type_AndroidWidgetTextView.setText((CharSequence)localObject);
  }
  
  public void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage == null) {
      return;
    }
    this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new alx(this, this));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    List localList = this.app.a().createEntityManager().a(CustomEmotionData.class, false, null, null, null, null, null, null);
    if (localList != null)
    {
      int j = 0;
      while (j < localList.size())
      {
        CustomEmotionData localCustomEmotionData = (CustomEmotionData)localList.get(j);
        if ((localCustomEmotionData.isMarkFace) && (localCustomEmotionData.emoPath.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId)) && (localCustomEmotionData.eId.equals(this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId)))
        {
          this.jdField_b_of_type_AndroidWidgetImageView.setEnabled(false);
          return;
        }
        j += 1;
      }
    }
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new aly(this, this));
  }
  
  protected void doOnPause()
  {
    super.doOnPause();
    AbstractGifImage.pauseAll();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    StartupTracker.a(null, "AIO_emosmDetailActivity_onCreate");
    super.onCreate(paramBundle);
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo;
    if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo == null)
    {
      finish();
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon;
    this.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId;
    boolean bool;
    if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.jobType == 2)
    {
      bool = true;
      this.jdField_a_of_type_Boolean = bool;
      super.setLeftViewName(2131364492);
      super.setContentView(2130903579);
      this.jdField_a_of_type_AndroidContentContext = super.getApplicationContext();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.h = 320;
      this.i = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
      c();
      paramBundle = this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.a(true);
      paramBundle.setURLDrawableListener(this.jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener);
      if (paramBundle != null)
      {
        if (paramBundle.getStatus() == 1) {
          break label219;
        }
        a(true);
      }
    }
    for (;;)
    {
      jdField_e_of_type_AndroidWidgetImageView.setImageDrawable(paramBundle);
      if (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound)
      {
        jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
        jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new alt(this));
      }
      StartupTracker.a("AIO_emosmDetailActivity_onCreate", null);
      return;
      bool = false;
      break;
      label219:
      this.jdField_b_of_type_Boolean = true;
      if (this.jdField_c_of_type_Boolean == true) {
        d();
      }
      if (this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo.h != 3)
      {
        int j = paramBundle.getIntrinsicWidth();
        int k = paramBundle.getIntrinsicHeight();
        this.jdField_f_of_type_Int = ((j * this.i + (this.h >> 1)) / this.h);
        this.jdField_g_of_type_Int = ((this.i * k + (this.h >> 1)) / this.h);
        RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)jdField_e_of_type_AndroidWidgetImageView.getLayoutParams();
        localLayoutParams.height = this.jdField_g_of_type_Int;
        localLayoutParams.width = this.jdField_f_of_type_Int;
        localLayoutParams.addRule(14, -1);
        jdField_e_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      }
    }
  }
  
  public void onDestroy()
  {
    jdField_e_of_type_AndroidWidgetImageView = null;
    jdField_f_of_type_AndroidWidgetImageView = null;
    super.onDestroy();
  }
  
  public void onResume()
  {
    StartupTracker.a(null, "AIO_emosmDetailActivity_onResume");
    super.onResume();
    AbstractGifImage.resumeAll();
    EmoticonPackage localEmoticonPackage = ((EmoticonManager)this.app.getManager(13)).a(this.jdField_b_of_type_JavaLangString);
    if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.EmosmDetailActivity", 2, "emoPackage is exist: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
      int j = this.app.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int k = (int)(System.currentTimeMillis() / 1000L);
      if ((k - j > 86400) || (k < j))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.EmosmDetailActivity", 2, "emosm json is expired: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        }
        ((EmojiManager)this.app.getManager(39)).a(this.jdField_b_of_type_JavaLangString, EmojiManager.c, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
        StartupTracker.a("AIO_emosmDetailActivity_onResume", null);
        return;
      }
      a(localEmoticonPackage);
    }
    for (;;)
    {
      StartupTracker.a("AIO_emosmDetailActivity_onResume", null);
      return;
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.EmosmDetailActivity", 2, "emoPackage is not exist: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
      }
      ((EmojiManager)this.app.getManager(39)).a(this.jdField_b_of_type_JavaLangString, EmojiManager.c, this.jdField_a_of_type_ComTencentMobileqqVipDownloadListener);
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    MediaPlayerManager.a(this.app).a(true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (!this.jdField_d_of_type_Boolean))
    {
      if (this.app.d()) {
        QQToast.a(this.app.a(), 2131363140, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131492887));
      }
    }
    else {
      return;
    }
    MediaPlayerManager.a(this.app).a(MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmDetailActivity
 * JD-Core Version:    0.7.0.1
 */