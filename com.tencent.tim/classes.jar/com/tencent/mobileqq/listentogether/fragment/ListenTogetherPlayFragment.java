package com.tencent.mobileqq.listentogether.fragment;

import acfp;
import agql;
import aink;
import ainv;
import aiob;
import aios;
import aiot;
import aiou;
import aipd;
import aiwn;
import aiwv;
import aixd;
import ajmq;
import ajmq.a;
import ajms;
import ajni;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.ShapeDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import ankt;
import anot;
import aoop;
import aqdj;
import aqft;
import aqgv;
import aqhu;
import aqiw;
import aqnm;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.PublicFragmentActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.dynamicavatar.DynamicAvatarView;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.mobileqq.listentogether.ListenTogetherManager;
import com.tencent.mobileqq.listentogether.ListenTogetherSession;
import com.tencent.mobileqq.listentogether.data.ISong;
import com.tencent.mobileqq.listentogether.data.MusicInfo;
import com.tencent.mobileqq.lyric.widget.LyricViewDetail;
import com.tencent.mobileqq.lyric.widget.LyricViewInternal;
import com.tencent.mobileqq.vas.avatar.AvatarLayout;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.fragment.V4FragmentCollector;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import wja;

public class ListenTogetherPlayFragment
  extends PublicBaseFragment
  implements View.OnClickListener
{
  ImageView AM;
  ImageView AN;
  ImageView AO;
  ImageView AP;
  ImageView AQ;
  View DI;
  View DJ;
  View DK;
  TextView Uj;
  TextView Uk;
  TextView Ul;
  TextView Um;
  public aink a;
  ainv jdField_a_of_type_Ainv = new aiot(this);
  aixd jdField_a_of_type_Aixd;
  ajmq.a jdField_a_of_type_Ajmq$a = new aios(this);
  public ListenTogetherSession a;
  public ISong a;
  LyricViewDetail jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail;
  QQAppInterface app;
  agql b;
  URLImageView bm;
  ListenTogetherManager c;
  boolean ckT = false;
  AvatarLayout e;
  boolean isAdmin;
  ImageView ivBack;
  public String lyric;
  View rootView;
  View.OnTouchListener t = new aiou(this);
  ImageView[] u = new ImageView[5];
  
  private void D(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Object localObject = getActivity();
    if ((localObject == null) || (((Activity)localObject).isFinishing()) || (!isAdded())) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("onGetColors [0x%x 0x%x]", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) }));
    }
    int i = Color.argb(0, Color.red(paramInt1), Color.green(paramInt1), Color.blue(paramInt1));
    localObject = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, i, i, i, i, i, paramInt1 });
    this.AQ.setBackgroundDrawable((Drawable)localObject);
    this.rootView.setBackgroundColor(paramInt1);
    if (paramBoolean)
    {
      this.bm.setBackgroundColor(paramInt1);
      this.AQ.setImageResource(2130841330);
      this.AQ.setScaleType(ImageView.ScaleType.CENTER);
    }
    for (;;)
    {
      paramInt1 = Color.argb(128, Color.red(paramInt2), Color.green(paramInt2), Color.blue(paramInt2));
      this.Uj.setTextColor(paramInt2);
      this.Uk.setTextColor(paramInt2);
      this.Um.setTextColor(paramInt2);
      this.Ul.setTextColor(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setLyricHilightColor(paramInt2);
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().setLyricColor(paramInt1);
      this.AM.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.AN.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.AO.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.AP.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      this.ivBack.setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      if (this.e != null) {
        g(((DynamicAvatarView)this.e.findViewById(2131363324)).getBackground(), paramInt2);
      }
      paramInt1 = 0;
      while (paramInt1 < this.u.length)
      {
        localObject = this.u[paramInt1];
        g(((ImageView)localObject).getBackground(), paramInt2);
        ((ImageView)localObject).setTag(Integer.valueOf(paramInt2));
        paramInt1 += 1;
      }
      this.bm.setBackgroundColor(0);
      this.AQ.setImageDrawable(null);
    }
    localObject = getResources().getDrawable(2130841331);
    ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
    this.Ul.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type == 1) {
      this.Um.setCompoundDrawablesWithIntrinsicBounds(null, null, (Drawable)localObject, null);
    }
    for (;;)
    {
      localObject = this.Ul.getBackground();
      if (localObject == null) {
        break;
      }
      ((Drawable)localObject).setColorFilter(paramInt2, PorterDuff.Mode.SRC_IN);
      return;
      this.Um.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
    }
  }
  
  private void S(String paramString1, int paramInt, String paramString2)
  {
    String str = (String)this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.getTag();
    if (TextUtils.isEmpty(paramString2))
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(4);
      this.jdField_a_of_type_Aixd.stop();
      if (paramInt == 1)
      {
        this.AM.setImageResource(2130841334);
        label49:
        if (apk()) {
          break label356;
        }
        this.AM.setAlpha(0.2F);
        this.AN.setVisibility(4);
        this.AP.setVisibility(4);
        this.AO.setVisibility(4);
      }
    }
    else
    {
      label90:
      switch (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.playMode)
      {
      default: 
        return;
        if ((this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.a().d() == null) || (!aqft.equalsWithNullCheck(str, paramString1)))
        {
          a(paramString2, this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
          this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setTag(paramString1);
        }
        break;
      }
    }
    for (int i = 1;; i = 0)
    {
      this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail.setVisibility(0);
      long l = this.c.FH();
      int j = (int)l;
      if (paramInt == 1)
      {
        boolean bool = this.jdField_a_of_type_Aixd.isPlaying();
        if (!bool) {
          this.jdField_a_of_type_Aixd.start();
        }
        QLog.i("ListenTogetherPlayFragment", 1, "updateLyricPosition() try to seek! playPosition:" + l + " seekPosition:" + j + " isPlaying:" + bool);
        if ((j < 0) && (i == 0)) {
          break;
        }
        paramString1 = this.jdField_a_of_type_Aixd;
        if (j >= 0) {}
        for (i = j;; i = 0)
        {
          paramString1.seek(i);
          break;
        }
      }
      if (2 == paramInt)
      {
        if (j >= 0) {
          this.jdField_a_of_type_Aixd.seek(j);
        }
        this.jdField_a_of_type_Aixd.pause();
        break;
      }
      this.jdField_a_of_type_Aixd.stop();
      break;
      this.AM.setImageResource(2130841335);
      break label49;
      label356:
      this.AM.setAlpha(1.0F);
      this.AN.setVisibility(0);
      this.AP.setVisibility(0);
      this.AO.setVisibility(0);
      break label90;
      this.AN.setImageResource(2130841341);
      this.AN.setContentDescription("切换播放模式 当前为单曲循环");
      return;
      this.AN.setImageResource(2130841337);
      this.AN.setContentDescription("切换播放模式 当前为顺序播放");
      return;
      this.AN.setImageResource(2130841340);
      this.AN.setContentDescription("切换播放模式 当前为随机播放");
      return;
    }
  }
  
  public static void a(Context paramContext, ListenTogetherSession paramListenTogetherSession, ISong paramISong, boolean paramBoolean, Intent paramIntent)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    localIntent.putExtra("session", paramListenTogetherSession);
    localIntent.putExtra("song", paramISong);
    localIntent.putExtra("isAdmin", paramBoolean);
    PublicFragmentActivity.b.start(paramContext, localIntent, PublicFragmentActivity.class, ListenTogetherPlayFragment.class);
  }
  
  private void a(String paramString, LyricViewDetail paramLyricViewDetail)
  {
    if (TextUtils.isEmpty(paramString)) {}
    aiwn localaiwn1;
    do
    {
      return;
      aiwn localaiwn2 = aiwv.a(paramString, true);
      localaiwn1 = localaiwn2;
      if (localaiwn2 == null) {
        localaiwn1 = aiwv.a(paramString, false);
      }
    } while (localaiwn1 == null);
    this.jdField_a_of_type_Aixd.stop();
    paramLyricViewDetail.a().setHighlightCurrentLine(true);
    paramLyricViewDetail.a().setHighlightLineNumber(2);
    this.jdField_a_of_type_Aixd.a(paramLyricViewDetail);
    this.jdField_a_of_type_Aixd.a(localaiwn1, localaiwn1, null);
  }
  
  private boolean apj()
  {
    Bundle localBundle = getArguments();
    this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong = ((ISong)localBundle.getParcelable("song"));
    this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession = ((ListenTogetherSession)localBundle.getParcelable("session"));
    this.isAdmin = localBundle.getBoolean("isAdmin");
    return (this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong != null) && (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession != null);
  }
  
  private boolean apk()
  {
    return (this.isAdmin) || (this.app.getCurrentAccountUin().equalsIgnoreCase(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.ckN));
  }
  
  private void d(ISong paramISong)
  {
    boolean bool = true;
    this.Uj.setText(paramISong.getTitle());
    Object localObject1 = paramISong.wY();
    Object localObject2;
    Object localObject3;
    int i;
    if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (Patterns.WEB_URL.matcher((CharSequence)localObject1).matches()))
    {
      localObject2 = URLDrawable.URLDrawableOptions.obtain();
      ((URLDrawable.URLDrawableOptions)localObject2).mLoadingDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mFailedDrawable = aoop.TRANSPARENT;
      ((URLDrawable.URLDrawableOptions)localObject2).mMemoryCacheKeySuffix = "original";
      localObject2 = URLDrawable.getDrawable(paramISong.wY(), (URLDrawable.URLDrawableOptions)localObject2);
      localObject3 = ajmq.aD(paramISong.wY());
      if (localObject3 != null)
      {
        D(((Integer)((List)localObject3).get(0)).intValue(), ((Integer)((List)localObject3).get(1)).intValue(), false);
        i = 1;
        this.bm.setImageDrawable((Drawable)localObject2);
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("ListenTogetherPlayFragment", 2, String.format("updateSongInfo type=%d album=%s", new Object[] { Integer.valueOf(i), localObject1 }));
      }
      localObject1 = MusicInfo.ev(paramISong.FK());
      i = MusicInfo.ie(paramISong.FK());
      if (paramISong.gl() > 0L)
      {
        paramISong = MusicInfo.a(this.app, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, paramISong.gl());
        this.Ul.setVisibility(4);
        i = 0;
        label251:
        localObject1 = this.Ul;
        if (this.Ul.getVisibility() != 0) {
          break label398;
        }
      }
      for (;;)
      {
        ((TextView)localObject1).setClickable(bool);
        this.Uk.setText(paramISong);
        if (i == 0) {
          break label403;
        }
        this.Uk.setCompoundDrawablesWithIntrinsicBounds(getResources().getDrawable(i), null, null, null);
        return;
        localObject3 = new ajmq((String)localObject1, this.jdField_a_of_type_Ajmq$a, null);
        if (((URLDrawable)localObject2).getStatus() == 1)
        {
          Drawable localDrawable = ((URLDrawable)localObject2).getCurrDrawable();
          if ((localDrawable instanceof RegionDrawable)) {
            ThreadManager.postImmediately(new ListenTogetherPlayFragment.2(this, (ajmq)localObject3, ((RegionDrawable)localDrawable).getBitmap()), null, true);
          }
          i = 2;
          break;
        }
        i = 3;
        ((URLDrawable)localObject2).setDecodeHandler((DownloadParams.DecodeHandler)localObject3);
        break;
        this.Ul.setVisibility(4);
        paramISong = (ISong)localObject1;
        break label251;
        label398:
        bool = false;
      }
      label403:
      this.Uk.setCompoundDrawablesWithIntrinsicBounds(null, null, null, null);
      return;
      i = 0;
    }
  }
  
  private void d(String paramString, ImageView paramImageView)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (this.app == null) {
        break label130;
      }
      Drawable localDrawable = aqhu.c(true);
      paramString = aqdj.a(this.app, 1, paramString, 4, localDrawable, localDrawable);
      localDrawable = paramImageView.getDrawable();
      if ((localDrawable != null) && (localDrawable != paramString) && ((localDrawable instanceof aqdj))) {
        ((aqdj)localDrawable).cancel();
      }
      paramImageView.setImageDrawable(paramString);
      paramImageView.setVisibility(0);
      if ((paramImageView.getBackground() != null) && ((paramImageView.getBackground() instanceof ShapeDrawable)))
      {
        paramString = paramImageView.getTag();
        if ((paramString instanceof Integer))
        {
          int i = ((Integer)paramString).intValue();
          ((ShapeDrawable)paramImageView.getBackground()).getPaint().setColor(i);
        }
      }
    }
    return;
    label130:
    paramImageView.setImageDrawable(aqhu.c(true));
    paramImageView.setVisibility(0);
  }
  
  private void dtj()
  {
    int i = aqnm.getScreenWidth();
    int j = aqnm.getScreenHeight();
    if ((j > 0) && (i > 0))
    {
      i = j - i - aqnm.dip2px(312.0F);
      if (i < 0)
      {
        if (i <= aqnm.dip2px(50.0F) * -1) {
          break label58;
        }
        ((RelativeLayout.LayoutParams)this.DI.getLayoutParams()).topMargin = i;
      }
    }
    return;
    label58:
    ((RelativeLayout.LayoutParams)this.DI.getLayoutParams()).topMargin = (i + aqnm.dip2px(34.0F));
  }
  
  private String ew(int paramInt)
  {
    if (paramInt == 1) {
      return "Grp_AIO";
    }
    if (paramInt == 2) {
      return "c2c_AIO";
    }
    return "";
  }
  
  private List<String> fp()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.FI();
    if (QLog.isColorLevel()) {
      QLog.i("ListenTogetherPlayFragment", 2, String.format("getC2CUins status=%d msg=%s", new Object[] { Integer.valueOf(i), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.bPm }));
    }
    ArrayList localArrayList = new ArrayList();
    switch (i)
    {
    default: 
      return localArrayList;
    case 3: 
      localArrayList.add(this.app.getCurrentAccountUin());
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
      return localArrayList;
    case 2: 
      localArrayList.add(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
      return localArrayList;
    }
    localArrayList.add(this.app.getCurrentAccountUin());
    return localArrayList;
  }
  
  private void g(Drawable paramDrawable, int paramInt)
  {
    if ((paramDrawable instanceof ShapeDrawable)) {
      ((ShapeDrawable)paramDrawable).getPaint().setColor(paramInt);
    }
    for (;;)
    {
      if (paramDrawable != null) {
        paramDrawable.invalidateSelf();
      }
      return;
      if ((paramDrawable instanceof GradientDrawable)) {
        ((GradientDrawable)paramDrawable).setColor(paramInt);
      }
    }
  }
  
  private void gV(View paramView)
  {
    this.Uj = ((TextView)paramView.findViewById(2131378562));
    this.Uk = ((TextView)paramView.findViewById(2131378587));
    this.AM = ((ImageView)paramView.findViewById(2131373396));
    this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail = ((LyricViewDetail)paramView.findViewById(2131370955));
    this.bm = ((URLImageView)paramView.findViewById(2131372117));
    this.AQ = ((ImageView)paramView.findViewById(2131372108));
    this.ivBack = ((ImageView)paramView.findViewById(2131372107));
    this.DI = paramView.findViewById(2131369232);
    this.rootView = paramView.findViewById(2131377565);
    this.Um = ((TextView)paramView.findViewById(2131379978));
    this.DJ = paramView.findViewById(2131379972);
    this.DK = paramView.findViewById(2131370705);
    this.AN = ((ImageView)paramView.findViewById(2131373391));
    this.AO = ((ImageView)paramView.findViewById(2131373384));
    this.AP = ((ImageView)paramView.findViewById(2131373383));
    int i = 0;
    while (i < 5)
    {
      ImageView localImageView = (ImageView)this.DJ.findViewWithTag("head" + i);
      this.u[i] = localImageView;
      i += 1;
    }
    this.Ul = ((TextView)paramView.findViewById(2131366097));
    ((ViewGroup.MarginLayoutParams)this.ivBack.getLayoutParams()).topMargin = wja.dp2px(31.0F, getResources());
    this.ivBack.setImageResource(2130846273);
    this.ivBack.setBackgroundResource(2130838772);
    g(this.ivBack.getBackground(), 1275068416);
    if (!apk())
    {
      this.AM.setAlpha(0.2F);
      this.AN.setVisibility(4);
      this.AP.setVisibility(4);
      this.AO.setVisibility(4);
    }
    this.AM.setOnClickListener(this);
    this.AN.setOnClickListener(this);
    this.AP.setOnClickListener(this);
    this.AO.setOnClickListener(this);
    this.ivBack.setOnClickListener(this);
    this.Ul.setOnClickListener(this);
    this.DJ.setOnClickListener(this);
    this.AM.setOnTouchListener(this.t);
    this.AN.setOnTouchListener(this.t);
    this.AP.setOnTouchListener(this.t);
    this.AO.setOnTouchListener(this.t);
    this.ivBack.setOnTouchListener(this.t);
    this.Ul.setOnTouchListener(this.t);
    this.DJ.setOnTouchListener(this.t);
    this.jdField_a_of_type_Aixd = new aixd(this.jdField_a_of_type_ComTencentMobileqqLyricWidgetLyricViewDetail);
    if (ankt.SCREEN_WIDTH > 0) {
      paramView.findViewById(2131372106).getLayoutParams().height = ankt.SCREEN_WIDTH;
    }
    dtj();
  }
  
  private void gW(View paramView)
  {
    int i = 1;
    this.e = ((AvatarLayout)paramView.findViewById(2131368375));
    this.e.setOnTouchListener(this.t);
    paramView = paramView.findViewById(2131368392);
    paramView.setVisibility(0);
    ((ViewGroup.MarginLayoutParams)paramView.getLayoutParams()).topMargin = wja.dp2px(28.0F, getResources());
    paramView = aqhu.c(true);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type == 2) {}
    for (;;)
    {
      Object localObject = aqdj.a(this.app, i, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, 4, paramView, paramView);
      paramView = (DynamicAvatarView)this.e.findViewById(2131363324);
      paramView.setImageDrawable((Drawable)localObject);
      i = wja.dp2px(1.5F, getResources());
      paramView.setPadding(i, i, i, i);
      paramView.setBackgroundResource(2130838772);
      localObject = (ImageView)((View)this.e.getParent()).findViewById(2131368417);
      this.b = new agql(this.app, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
      this.b.z((View)localObject);
      this.e.c(0, paramView, false);
      this.e.setOnClickListener(this);
      return;
      i = 4;
    }
  }
  
  private void i(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    if (paramInt == 1) {}
    anot.a(null, "dc00899", ew(paramInt), "", paramString2, paramString3, 0, 0, paramString1, "", "", "");
  }
  
  private void init()
  {
    this.c = ((ListenTogetherManager)this.app.getManager(331));
    this.jdField_a_of_type_Aink = ((aink)this.app.getBusinessHandler(156));
    this.app.addObserver(this.jdField_a_of_type_Ainv);
    int[] arrayOfInt = ajms.l(-1315339);
    D(arrayOfInt[0], arrayOfInt[1], true);
    d(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong);
    this.lyric = this.c.lC(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.getId());
    S(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.getId(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status, this.lyric);
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type == 1) {
      this.jdField_a_of_type_Aink.LM(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
    }
    y(fp(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.bPm);
    ListenTogetherManager.a(this.app).a().Lm(true);
    this.ckT = true;
  }
  
  private void y(List<String> paramList, String paramString)
  {
    int i;
    int j;
    if (paramList == null)
    {
      i = 0;
      j = 0;
      label9:
      if (j >= 5) {
        break label99;
      }
      if (j >= i) {
        break label73;
      }
      this.u[j].setVisibility(0);
      d((String)paramList.get(j), this.u[j]);
    }
    for (;;)
    {
      j += 1;
      break label9;
      i = paramList.size();
      break;
      label73:
      this.u[j].setVisibility(8);
      this.u[j].setImageDrawable(null);
    }
    label99:
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type == 1)
    {
      this.DJ.setClickable(true);
      this.DJ.setOnTouchListener(this.t);
    }
    for (;;)
    {
      this.Um.setText(paramString);
      return;
      this.DJ.setClickable(true);
      this.DJ.setOnTouchListener(null);
    }
  }
  
  public void initWindowStyleAndAnimation(Activity paramActivity)
  {
    super.initWindowStyleAndAnimation(paramActivity);
    paramActivity.getWindow().addFlags(256);
    paramActivity.overridePendingTransition(2130772009, 2130772002);
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public boolean needImmersive()
  {
    return false;
  }
  
  public boolean needStatusTrans()
  {
    return true;
  }
  
  public void onClick(View paramView)
  {
    int j = 1;
    int i = 1;
    if ((getActivity() == null) || (getActivity().isFinishing()) || (!isAdded())) {}
    boolean bool;
    Object localObject;
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      bool = aqiw.isNetworkAvailable(getActivity());
      switch (paramView.getId())
      {
      default: 
        break;
      case 2131366097: 
        if (!ajni.U(getActivity(), "com.tencent.qqmusic")) {
          break label844;
        }
        localObject = new Intent("android.intent.action.VIEW", Uri.parse("qqmusic://qq.com/ui/myTab?p=%7B%22tab%22%3A%22home%22%7D&source=https%3A%2F%2Fy.qq.com%2Fm%2Findex.html%3FADTAG%3DYIQITING"));
        ((Intent)localObject).putExtra("big_brother_source_key", "biz_src_qqmusic");
        getActivity().startActivity((Intent)localObject);
        i(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, "music_tab", "clk_openmusic");
        break;
      case 2131373396: 
        if (!apk())
        {
          QQToast.a(getActivity(), acfp.m(2131707811), 1).show();
        }
        else
        {
          if (bool) {
            break label265;
          }
          QQToast.a(getActivity(), 1, getActivity().getString(2131696664), 0).show();
        }
        break;
      }
    }
    label265:
    if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status == 1)
    {
      ListenTogetherManager.a(this.app).cN(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
      this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status = 2;
    }
    while (i != 0)
    {
      S(this.jdField_a_of_type_ComTencentMobileqqListentogetherDataISong.getId(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status, this.lyric);
      break;
      if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status == 2)
      {
        ListenTogetherManager.a(this.app).cO(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
        this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.status = 1;
        continue;
        if (!apk()) {
          break;
        }
        if (!bool)
        {
          QQToast.a(getActivity(), 1, getActivity().getString(2131696664), 0).show();
          break;
        }
        i = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.playMode + 1;
        if (i > 3) {
          i = 1;
        }
        for (;;)
        {
          ListenTogetherManager.a(this.app).O(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, i);
          anot.a(null, "dc00899", ew(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type), "", "music_tab", "clk_mode", 0, 0, "", "", "" + i, "");
          break;
          if (!apk()) {
            break;
          }
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131696664), 0).show();
            break;
          }
          ListenTogetherManager.a(this.app).N(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, 2);
          anot.a(null, "dc00899", ew(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          break;
          if (!apk()) {
            break;
          }
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131696664), 0).show();
            break;
          }
          ListenTogetherManager.a(this.app).N(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, 1);
          anot.a(null, "dc00899", ew(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type), "", "music_tab", "clk_cut", 0, 0, "", "", "", "");
          break;
          getActivity().finish();
          break;
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131696664), 0).show();
            break;
          }
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type == 1) {
            aiob.a(this.app, getActivity(), this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin);
          }
          i(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, "music_tab", "clk_member");
          break;
          label844:
          if (!bool)
          {
            QQToast.a(getActivity(), 1, getActivity().getString(2131696664), 0).show();
            break;
          }
          startActivity(new Intent(getActivity(), QQBrowserActivity.class).putExtra("url", "https://ct.y.qq.com/y.qq.com/m/download/index.html"));
          i(this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type, this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin, "music_tab", "clk_downloadmusic");
          break;
          localObject = this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.uin;
          if (this.jdField_a_of_type_ComTencentMobileqqListentogetherListenTogetherSession.type == 1) {}
          for (i = j;; i = 0)
          {
            if (this.b != null) {
              this.b.djl();
            }
            String str = aqgv.e(this.app, (String)localObject, i);
            MiniChatActivity.a(getActivity(), i, (String)localObject, str);
            break;
          }
        }
      }
      i = 0;
    }
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.app = getActivity().app;
    View localView = paramLayoutInflater.inflate(2131561430, paramViewGroup, false);
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    if (!apj()) {
      getActivity().finish();
    }
    for (;;)
    {
      V4FragmentCollector.onV4FragmentViewCreated(this, localView);
      return localView;
      localView.setClickable(true);
      gV(localView);
      init();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    if (this.app != null) {
      this.app.removeObserver(this.jdField_a_of_type_Ainv);
    }
    if (this.jdField_a_of_type_Aixd != null) {
      this.jdField_a_of_type_Aixd.stop();
    }
    if ((this.ckT) && (this.app != null))
    {
      ListenTogetherManager.a(this.app).a().Ln(false);
      this.ckT = false;
    }
    if (this.b != null) {
      this.b.onDestroy();
    }
  }
  
  public void onFinish()
  {
    super.onFinish();
    getActivity().overridePendingTransition(2130772002, 2130772013);
    if (this.ckT)
    {
      ListenTogetherManager.a(this.app).a().Ln(false);
      this.ckT = false;
    }
  }
  
  public void onPause()
  {
    super.onPause();
    if (this.b != null) {
      this.b.onPause();
    }
  }
  
  public void onResume()
  {
    super.onResume();
    boolean bool2 = ajni.bs(getActivity());
    boolean bool1;
    if (!bool2)
    {
      bool1 = true;
      localObject = this.Ul.getTag();
      if ((localObject instanceof Boolean)) {
        bool1 = ((Boolean)localObject).booleanValue();
      }
      if (bool1 != bool2) {
        if (!bool2) {
          break label96;
        }
      }
    }
    label96:
    for (Object localObject = acfp.m(2131707809);; localObject = acfp.m(2131707812))
    {
      this.Ul.setText((CharSequence)localObject);
      this.Ul.setTag(Boolean.valueOf(bool2));
      if (this.b != null) {
        this.b.onResume();
      }
      return;
      bool1 = false;
      break;
    }
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    super.onViewCreated(paramView, paramBundle);
    gW(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.listentogether.fragment.ListenTogetherPlayFragment
 * JD-Core Version:    0.7.0.1
 */