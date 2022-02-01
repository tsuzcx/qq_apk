package com.tencent.mobileqq.activity;

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
import ckl;
import ckn;
import cko;
import ckp;
import ckq;
import ckr;
import cks;
import ckt;
import cku;
import ckv;
import ckw;
import ckx;
import cky;
import ckz;
import cla;
import clb;
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
import com.tencent.mobileqq.emoticon.EmoticonController;
import com.tencent.mobileqq.emoticon.EmoticonPackageDownloadListener;
import com.tencent.mobileqq.emoticonview.PicEmoticonInfo;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.DialogUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.QQCustomDialog;
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
  public Context a;
  Handler jdField_a_of_type_AndroidOsHandler;
  private TranslateAnimation jdField_a_of_type_AndroidViewAnimationTranslateAnimation;
  Button jdField_a_of_type_AndroidWidgetButton;
  ImageView jdField_a_of_type_AndroidWidgetImageView;
  ProgressBar jdField_a_of_type_AndroidWidgetProgressBar;
  public RelativeLayout a;
  TextView jdField_a_of_type_AndroidWidgetTextView;
  clb jdField_a_of_type_Clb;
  URLDrawable.URLDrawableListener jdField_a_of_type_ComTencentImageURLDrawable$URLDrawableListener = new ckt(this);
  public Emoticon a;
  private EmoticonPackage jdField_a_of_type_ComTencentMobileqqDataEmoticonPackage = null;
  private EmoticonPackageDownloadListener jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener = new ckl(this);
  public PicEmoticonInfo a;
  MyGridView jdField_a_of_type_ComTencentMobileqqWidgetMyGridView;
  boolean jdField_a_of_type_Boolean;
  Button jdField_b_of_type_AndroidWidgetButton;
  public ImageView b;
  public RelativeLayout b;
  TextView jdField_b_of_type_AndroidWidgetTextView;
  private String jdField_b_of_type_JavaLangString;
  private boolean jdField_b_of_type_Boolean = false;
  ImageView jdField_c_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_c_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_c_of_type_AndroidWidgetTextView;
  private boolean jdField_c_of_type_Boolean = false;
  public int d;
  ImageView jdField_d_of_type_AndroidWidgetImageView;
  RelativeLayout jdField_d_of_type_AndroidWidgetRelativeLayout;
  TextView jdField_d_of_type_AndroidWidgetTextView;
  private boolean jdField_d_of_type_Boolean = false;
  public int e;
  TextView e;
  private int jdField_f_of_type_Int;
  TextView jdField_f_of_type_AndroidWidgetTextView;
  private int jdField_g_of_type_Int;
  TextView jdField_g_of_type_AndroidWidgetTextView;
  private int h;
  private int i;
  
  public EmosmDetailActivity()
  {
    this.jdField_a_of_type_ComTencentMobileqqEmoticonviewPicEmoticonInfo = null;
    this.jdField_a_of_type_ComTencentMobileqqDataEmoticon = null;
  }
  
  public static void a(int paramInt, Context paramContext, QQAppInterface paramQQAppInterface, PicEmoticonInfo paramPicEmoticonInfo, ImageView paramImageView, QQProgressDialog paramQQProgressDialog, SessionInfo paramSessionInfo)
  {
    if (((EmoticonManager)paramQQAppInterface.getManager(12)).a(paramPicEmoticonInfo.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId).mobileFeetype == 1)
    {
      b(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, 0, null, paramQQProgressDialog, paramSessionInfo);
      return;
    }
    if ((!NetworkUtil.f(paramContext)) || (paramInt > 1000))
    {
      b(paramInt, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, -404, paramContext.getString(2131559060), paramQQProgressDialog, paramSessionInfo);
      return;
    }
    EmosmHandler localEmosmHandler = (EmosmHandler)paramQQAppInterface.a(11);
    localEmosmHandler.a(new cla(localEmosmHandler, paramContext, paramInt, paramQQAppInterface, paramPicEmoticonInfo, paramImageView, paramQQProgressDialog, paramSessionInfo));
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
      DialogUtil.a(paramContext, 230, paramString1, paramString2, 2131561746, 2131561940, new ckr(), new cks()).show();
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
                localHandler.post(new ckn(paramContext));
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
          localHandler.post(new cko(paramContext));
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
      localHandler.post(new ckp(paramContext, paramString));
      return;
    }
    localHandler.post(new ckq(paramInt1, paramContext, paramQQAppInterface, paramPicEmoticonInfo, paramString));
  }
  
  private void e()
  {
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, this.jdField_b_of_type_AndroidWidgetRelativeLayout.getHeight(), 0.0F);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setInterpolator(AnimationUtils.loadInterpolator(this.jdField_a_of_type_AndroidContentContext, 17432582));
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setDuration(300L);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setFillAfter(true);
    this.jdField_b_of_type_AndroidWidgetRelativeLayout.startAnimation(this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation);
    this.jdField_a_of_type_AndroidViewAnimationTranslateAnimation.setAnimationListener(new ckx(this));
  }
  
  public void a()
  {
    this.jdField_e_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233315));
    this.jdField_f_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233317));
    this.jdField_g_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233319));
    this.jdField_d_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233316));
    this.jdField_b_of_type_AndroidWidgetButton = ((Button)findViewById(2131233318));
    this.jdField_b_of_type_AndroidWidgetButton.setText(2131563178);
    this.jdField_b_of_type_AndroidWidgetButton.setOnClickListener(new ckv(this));
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
    String str1 = paramEmoticonPackage.name;
    String str2 = str1;
    if (str1.length() > 5) {
      str2 = str1.substring(0, 5) + "...";
    }
    setTitle(str2);
    int j = paramEmoticonPackage.downloadCount / 10000;
    if (j < 1)
    {
      str1 = getResources().getString(2131559057);
      label108:
      if (!this.jdField_a_of_type_Boolean) {
        break label365;
      }
      this.jdField_b_of_type_AndroidWidgetTextView.setText(getResources().getString(2131562152));
      this.jdField_e_of_type_AndroidWidgetTextView.setText(str2);
      this.jdField_f_of_type_AndroidWidgetTextView.setText(str1);
      this.jdField_g_of_type_AndroidWidgetTextView.setText(paramEmoticonPackage.mark);
      paramEmoticonPackage = this.jdField_d_of_type_AndroidWidgetImageView;
      label165:
      paramEmoticonPackage = (ArrayList)((EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a(this.jdField_b_of_type_JavaLangString);
      if ((paramEmoticonPackage == null) || (this.jdField_a_of_type_Boolean)) {
        break label412;
      }
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.EmosmDetailActivity", 2, "emoticon size:" + paramEmoticonPackage.size());
      }
      this.jdField_a_of_type_Clb = new clb(this, paramEmoticonPackage);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setHorizontalSpacing(15);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setVerticalSpacing(10);
      this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView.setAdapter(this.jdField_a_of_type_Clb);
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
        str1 = getResources().getString(2131559058, new Object[] { Integer.valueOf(j) });
        break label108;
      }
      str1 = getResources().getString(2131559059, new Object[] { Integer.valueOf(j) });
      break label108;
      label365:
      this.jdField_b_of_type_AndroidWidgetTextView.setText(MessageFormat.format(getResources().getString(2131562151), new Object[] { paramEmoticonPackage.name }));
      this.jdField_d_of_type_AndroidWidgetTextView.setText(str1);
      paramEmoticonPackage = this.jdField_c_of_type_AndroidWidgetImageView;
      break label165;
      label412:
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
        this.jdField_a_of_type_AndroidWidgetProgressBar.setIndeterminateDrawable(getResources().getDrawable(2130837856));
        j = AIOUtils.a(16.0F, this.jdField_a_of_type_AndroidContentContext.getResources());
        localLayoutParams = new RelativeLayout.LayoutParams(j, j);
        localLayoutParams.bottomMargin = j;
        localLayoutParams.addRule(1, 2131230810);
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
    this.jdField_c_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233309));
    this.jdField_d_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233312));
    this.jdField_c_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233310));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131233311));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ckw(this));
  }
  
  public void c()
  {
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233302));
    this.jdField_b_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131233303));
    this.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233304));
    this.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)findViewById(2131233305));
    this.jdField_a_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131231518));
    this.jdField_c_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233307));
    this.jdField_d_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131233313));
    this.jdField_a_of_type_ComTencentMobileqqWidgetMyGridView = ((MyGridView)findViewById(2131233320));
    this.jdField_b_of_type_AndroidWidgetRelativeLayout = ((RelativeLayout)findViewById(2131232054));
    jdField_e_of_type_AndroidWidgetImageView = (ImageView)findViewById(2131230805);
    jdField_f_of_type_AndroidWidgetImageView = (ImageView)findViewById(2131230806);
    if (this.jdField_a_of_type_Boolean)
    {
      this.jdField_d_of_type_AndroidWidgetRelativeLayout.setVisibility(0);
      a();
    }
    Object localObject;
    for (;;)
    {
      int j = getResources().getDimensionPixelSize(2131427502);
      this.jdField_d_of_type_Int = ((((WindowManager)getSystemService("window")).getDefaultDisplay().getWidth() - j * 2 - 45) / 4);
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
    this.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new cky(this, this));
    this.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
    List localList = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager().a(CustomEmotionData.class, false, null, null, null, null, null, null);
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
    this.jdField_b_of_type_AndroidWidgetImageView.setOnClickListener(new ckz(this, this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
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
      label60:
      this.jdField_a_of_type_Boolean = bool;
      h(2131560958);
      setContentView(2130903663);
      this.jdField_a_of_type_AndroidContentContext = getApplicationContext();
      this.jdField_a_of_type_AndroidOsHandler = new Handler();
      this.h = 320;
      this.i = BaseApplication.getContext().getResources().getDisplayMetrics().densityDpi;
      c();
      EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
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
      if (!this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) {
        break;
      }
      jdField_f_of_type_AndroidWidgetImageView.setVisibility(0);
      jdField_f_of_type_AndroidWidgetImageView.setOnClickListener(new cku(this));
      return;
      bool = false;
      break label60;
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
    EmoticonController localEmoticonController = EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface);
    if (localEmoticonController != null) {
      localEmoticonController.b(this.jdField_a_of_type_ComTencentMobileqqEmoticonEmoticonPackageDownloadListener);
    }
    jdField_e_of_type_AndroidWidgetImageView = null;
    jdField_f_of_type_AndroidWidgetImageView = null;
    super.onDestroy();
  }
  
  public void onResume()
  {
    super.onResume();
    EmoticonPackage localEmoticonPackage = ((EmoticonManager)this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getManager(12)).a(this.jdField_b_of_type_JavaLangString);
    if ((localEmoticonPackage != null) && (localEmoticonPackage.name != null) && ((localEmoticonPackage.mobileFeetype != 0) || (localEmoticonPackage.downloadCount != 0)))
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.emoji.EmosmDetailActivity", 2, "emoPackage is exist: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
      }
      int j = this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getInt("emosm_json_last_download_timestamp", 0);
      int k = (int)(System.currentTimeMillis() / 1000L);
      if ((k - j > 86400) || (k < j))
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.emoji.EmosmDetailActivity", 2, "emosm json is expired: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.epId);
        }
        EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_b_of_type_JavaLangString);
        return;
      }
      a(localEmoticonPackage);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.emoji.EmosmDetailActivity", 2, "emoPackage is not exist: " + this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.eId);
    }
    EmoticonController.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).b(this.jdField_b_of_type_JavaLangString);
  }
  
  protected void onStop()
  {
    super.onStop();
    MediaPlayerManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(true);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.jdField_a_of_type_ComTencentMobileqqDataEmoticon.isSound) && (!this.jdField_d_of_type_Boolean))
    {
      if (this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.d()) {
        QQToast.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface.a(), 2131561724, 0).b(this.jdField_a_of_type_AndroidContentContext.getResources().getDimensionPixelSize(2131427376));
      }
    }
    else {
      return;
    }
    MediaPlayerManager.a(this.jdField_b_of_type_ComTencentMobileqqAppQQAppInterface).a(MarketFaceItemBuilder.jdField_a_of_type_ComTencentMobileqqDataChatMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EmosmDetailActivity
 * JD-Core Version:    0.7.0.1
 */