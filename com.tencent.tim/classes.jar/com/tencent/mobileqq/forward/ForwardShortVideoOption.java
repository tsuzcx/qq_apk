package com.tencent.mobileqq.forward;

import aaqi;
import acbn;
import acfp;
import ahgg.a;
import ahgq;
import ahiy;
import ahlv;
import akxo;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import anfr;
import angi;
import angt;
import ankt;
import anot;
import aomz;
import aqff;
import aqft;
import aqhq;
import aqju;
import aqnm;
import auqv;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.datadef.ProductInfo;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.ChatThumbView;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity;
import com.tencent.mobileqq.app.HotChatManager;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import jqs;
import rar;
import syw;
import sza;
import wja;

public class ForwardShortVideoOption
  extends ahgq
{
  private a a;
  
  public ForwardShortVideoOption(Intent paramIntent)
  {
    super(paramIntent);
    this.cgP = true;
    this.cZS = 7;
  }
  
  private void doH()
  {
    Intent localIntent = new Intent(this.mActivity, ShortVideoPlayActivity.class);
    Object localObject;
    if (this.bf.getParcelable("key_message_for_shortvideo") != null)
    {
      localObject = (MessageForShortVideo)this.bf.getParcelable("key_message_for_shortvideo");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview msg " + ((MessageForShortVideo)localObject).videoFileName);
      }
      localIntent.putExtras(this.bf);
      localIntent.putExtra("video_play_caller", 5);
      localIntent.putExtra("message_click_start", System.currentTimeMillis());
      this.mActivity.startActivity(localIntent);
      dnZ();
    }
    do
    {
      return;
      localObject = this.bf.getString("file_send_path");
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file " + (String)localObject);
      }
      if (aqhq.fileExists((String)localObject))
      {
        localIntent.putExtra("file_send_path", (String)localObject);
        localIntent.putExtra("video_play_caller", 6);
        localIntent.putExtra("message_click_start", System.currentTimeMillis());
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("ForwardOption.ForwardShortVideoOption", 2, "enterVideoPreview file not exit ");
  }
  
  private void don()
  {
    Object localObject1;
    if (this.bf.getBoolean("isFromFavorite", false))
    {
      localObject1 = acbn.bmf + "pic/" + this.mIntent.getStringExtra("thumbfile_md5") + "_0";
      String str = this.bKv;
      if ((!TextUtils.isEmpty(str)) && (!TextUtils.isEmpty((CharSequence)localObject1)) && (!new File(str).exists()) && (new File((String)localObject1).exists())) {
        aqhq.copyFile((String)localObject1, str);
      }
    }
    if (!TextUtils.isEmpty(this.bKv)) {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage " + this.bKv);
      }
    }
    for (;;)
    {
      try
      {
        localObject1 = aomz.a(this.bKv, ankt.dip2px(100.0F), ankt.dip2px(300.0F));
        if (localObject1 == null) {
          break label275;
        }
        localObject1 = ((URL)localObject1).toString();
        localObject1 = URLDrawable.getDrawable((String)localObject1);
        ((URLDrawable)localObject1).setBounds(0, 0, ankt.dip2px(248.0F), ankt.dip2px(248.0F));
        this.mIntent.getBooleanExtra("forward_is_long_video", false);
        this.mIntent.getIntExtra("file_send_size", 0);
        this.mIntent.getIntExtra("file_send_duration", 0);
        ThreadManager.excute(new ForwardShortVideoOption.3(this, (URLDrawable)localObject1), 16, null, false);
        return;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "initPreviewImage omm!", localOutOfMemoryError);
        this.a.V(null);
        return;
      }
      this.a.V(null);
      return;
      label275:
      Object localObject2 = null;
    }
  }
  
  public int EU()
  {
    int i = this.bf.getInt("key_forward_ability_type");
    boolean bool = this.mIntent.getBooleanExtra("forward_ability_entrence_show_in_share", false);
    if ((i == V.intValue()) && (bool)) {
      return 2;
    }
    return super.EU();
  }
  
  public void Ka(String paramString)
  {
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    localIntent.putExtras(this.bf);
    localIntent.putExtra("set_user_callback", "cooperation.qzone.video.VideoComponentCallback");
    localIntent.putExtra("forward_to_qzone_to_enable_edit", true);
    localIntent.putExtra("forward_source_to_qzone", "source_from_quick_shoot");
    localIntent.putExtra("key_content", paramString);
    localIntent.setFlags(67108864);
    localIntent.putExtra("main_tab_id", 4);
    localIntent.putExtra("fragment_id", 1);
    localIntent.putExtra("switch_anim", true);
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1002);
    anot.a(this.app, "CliOper", "", "", "0X800780F", "0X800780F", 0, 0, "", "", "", "");
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
  }
  
  public boolean a(aqju paramaqju)
  {
    String str1 = null;
    if (this.bf.getBoolean("is_forward_ptv", false))
    {
      if (!TextUtils.isEmpty(this.bKv)) {}
      try
      {
        paramaqju.setPreviewImage(ahiy.d(aqff.getDrawableBitmap(new BitmapDrawable(this.mActivity.getResources(), this.bKv))), true, 1);
        return false;
      }
      catch (OutOfMemoryError paramaqju)
      {
        for (;;)
        {
          QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get ptv drawable omm!", paramaqju);
        }
      }
    }
    Object localObject;
    if (this.bf.getBoolean("isFromFavorite", false))
    {
      localObject = acbn.bmf + "pic/" + this.mIntent.getStringExtra("thumbfile_md5") + "_0";
      String str2 = this.bKv;
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject)) && (!new File(str2).exists()) && (new File((String)localObject).exists())) {
        aqhq.copyFile((String)localObject, str2);
      }
    }
    if (!TextUtils.isEmpty(this.bKv)) {
      try
      {
        localObject = aomz.a(this.bKv, ankt.dip2px(100.0F), ankt.dip2px(300.0F));
        if (localObject != null) {
          str1 = ((URL)localObject).toString();
        }
        ThreadManager.post(new ForwardShortVideoOption.1(this, URLDrawable.getDrawable(str1), paramaqju, this.mIntent.getBooleanExtra("forward_is_long_video", false), this.mIntent.getIntExtra("file_send_size", 0), this.mIntent.getIntExtra("file_send_duration", 0)), 8, null, false);
        return false;
      }
      catch (OutOfMemoryError paramaqju)
      {
        QLog.e("ForwardOption.ForwardShortVideoOption", 2, "get shortvideo drawable omm!", paramaqju);
        return true;
      }
    }
    return true;
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    syw localsyw = (syw)this.app.getBusinessHandler(51);
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        ProductInfo localProductInfo = localsyw.a(localDeviceInfo.productId);
        if ((localProductInfo != null) && (localProductInfo.isSupportFuncMsgType(2)) && (e(aa))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public List<RecentUser> aD(List<RecentUser> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    HotChatManager localHotChatManager = (HotChatManager)this.app.getManager(60);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if (localRecentUser != null) {
        if ((!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 10004) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && ((localRecentUser.getType() == 0) || (localRecentUser.getType() == 1) || (localRecentUser.getType() == 3000)))
        {
          if ((localHotChatManager != null) && (localHotChatManager.kj(localRecentUser.uin))) {}
          for (int i = 1;; i = 0)
          {
            if (i != 0) {
              break label171;
            }
            localArrayList.add(localRecentUser);
            break;
          }
        }
        else
        {
          label171:
          if ((localRecentUser.uin.equalsIgnoreCase(acbn.bkw)) && (e(ahgg.a.W)) && (anA())) {
            localArrayList.add(localRecentUser);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public boolean anl()
  {
    boolean bool1 = this.bf.getBoolean("isFromFavorite", false);
    boolean bool2 = this.bf.getBoolean("forward_need_sendmsg", false);
    boolean bool3 = this.mIntent.getBooleanExtra("forward_source_from_shoot_quick", false);
    boolean bool4 = this.mIntent.getBooleanExtra("forward_source_from_pre_guide", false);
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "forwardShortvideo realForwardTo isNeedSendMsg=" + bool2 + "isFromFavorite=" + bool1);
    }
    int j;
    int i;
    Intent localIntent;
    if (anq())
    {
      fg();
      if (this.bf.getInt("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
      {
        j = this.bf.getInt("uintype", -1);
        i = 3;
        if (j == 1)
        {
          i = 1;
          aaqi.ao("", "0X80088E4", String.valueOf(i));
        }
      }
      else
      {
        localObject = new Intent(this.mActivity, SplashActivity.class);
        ((Intent)localObject).putExtras(this.bf);
        localIntent = wja.a((Intent)localObject, null);
        localIntent.putExtra("isBack2Root", true);
        if (!bool2) {
          break label249;
        }
        ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
      }
      for (;;)
      {
        this.mActivity.setResult(-1, localIntent);
        return true;
        if (j != 3000) {
          break;
        }
        i = 2;
        break;
        label249:
        if ((bool3) || (bool4))
        {
          localSessionInfo = new SessionInfo();
          localSessionInfo.aTl = this.bf.getString("uin");
          localSessionInfo.cZ = this.bf.getInt("uintype");
          localSessionInfo.troopUin = this.bf.getString("troop_uin");
          localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo);
          localObject = "";
          if (localSessionInfo.cZ == 0) {
            localObject = "0X800780C";
          }
          for (;;)
          {
            anot.a(this.app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
            break;
            if (localSessionInfo.cZ == 1) {
              localObject = "0X800780D";
            } else if (localSessionInfo.cZ == 3000) {
              localObject = "0X800780E";
            }
          }
        }
        this.mActivity.startActivity(localIntent);
      }
    }
    if (this.bf.getInt("param_key_redbag_type", 0) == LocalMediaInfo.REDBAG_TYPE_GET)
    {
      j = this.bf.getInt("uintype", -1);
      i = 3;
      if (j == 1)
      {
        i = 1;
        aaqi.ao("", "0X80088E4", String.valueOf(i));
      }
    }
    else
    {
      localObject = new Intent(this.mActivity, SplashActivity.class);
      ((Intent)localObject).putExtras(this.bf);
      localIntent = wja.a((Intent)localObject, null);
      localIntent.putExtra("isBack2Root", true);
      if (!bool2) {
        break label577;
      }
      ForwardUtils.a(this.app, this.mActivity, this.mAppContext, localIntent, null);
    }
    label577:
    while ((!bool3) && (!bool4))
    {
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
      return true;
      if (j != 3000) {
        break;
      }
      i = 2;
      break;
    }
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.aTl = this.bf.getString("uin");
    localSessionInfo.cZ = this.bf.getInt("uintype");
    localSessionInfo.troopUin = this.bf.getString("troop_uin");
    localIntent.putExtra("PhotoConst.SEND_SESSION_INFO", localSessionInfo);
    Object localObject = "";
    if (localSessionInfo.cZ == 0) {
      localObject = "0X800780C";
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", (String)localObject, (String)localObject, 0, 0, "", "", "", "");
      break;
      if (localSessionInfo.cZ == 1) {
        localObject = "0X800780D";
      } else if (localSessionInfo.cZ == 3000) {
        localObject = "0X800780E";
      }
    }
  }
  
  public boolean ann()
  {
    return true;
  }
  
  public boolean ans()
  {
    if (this.bf.getBoolean("is_forward_ptv", false))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardShortVideoOption", 2, "isFromPtv use old");
      }
      return false;
    }
    return true;
  }
  
  public View cc()
  {
    View localView = LayoutInflater.from(this.mActivity).inflate(2131559147, null);
    int i = aqnm.dip2px(15.0F);
    localView.setPadding(0, i, 0, i);
    this.a = new a(null);
    this.a.zV = ((ImageView)localView.findViewById(2131367585));
    ((ChatThumbView)this.a.zV).bgJ = false;
    this.a.a = new PressDarkImageView(this.mActivity);
    this.a.a.setImageDrawable(this.mActivity.getResources().getDrawable(2130840500));
    this.a.a.zW = this.a.zV;
    RelativeLayout localRelativeLayout = (RelativeLayout)localView.findViewById(2131367584);
    i = aqnm.dip2px(40.0F);
    RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(i, i);
    localLayoutParams.addRule(13);
    localRelativeLayout.addView(this.a.a, localLayoutParams);
    localView.findViewById(2131367584).setVisibility(0);
    don();
    this.a.a.setContentDescription(acfp.m(2131706535));
    this.a.a.setOnClickListener(new ahlv(this));
    return localView;
  }
  
  public void dnO()
  {
    super.dnO();
    int i = getExtras().getInt("key_forward_ability_type");
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardShortVideoOption", 2, "-->getCancelListener--onClick--type = " + i);
    }
    if (i == ad.intValue()) {
      rar.a("plus_shoot", "nosend_tip", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  public void dnU()
  {
    Object localObject2 = new Intent();
    ((Intent)localObject2).putExtra("uin", this.bf.getString("uin"));
    ((Intent)localObject2).putExtra("troop_uin", this.bf.getString("troop_uin"));
    ((Intent)localObject2).putExtra("uintype", this.bf.getInt("uintype", 9501));
    ((Intent)localObject2).putExtra("file_send_size", this.bf.getInt("file_send_size", 0));
    ((Intent)localObject2).putExtra("file_send_business_type", this.bf.getInt("file_send_business_type", -1));
    ((Intent)localObject2).putExtra("file_send_duration", this.bf.getInt("file_send_duration", -1));
    ((Intent)localObject2).putExtra("file_send_path", this.bf.getString("file_send_path"));
    ((Intent)localObject2).putExtra("thumbfile_send_path", this.bf.getString("thumbfile_send_path"));
    ((Intent)localObject2).putExtra("file_shortvideo_md5", this.bf.getString("file_shortvideo_md5"));
    ((Intent)localObject2).putExtra("thumbfile_send_width", this.bf.getInt("thumbfile_send_width", 0));
    ((Intent)localObject2).putExtra("thumbfile_send_height", this.bf.getInt("thumbfile_send_height", 0));
    ((Intent)localObject2).putExtra("thumbfile_md5", this.bf.getString("thumbfile_md5"));
    ((Intent)localObject2).putExtra("file_source", this.bf.getString("file_source"));
    ((Intent)localObject2).putExtra("file_video_source_dir", this.bf.getString("file_video_source_dir"));
    Object localObject1 = anfr.a(0, 4);
    localObject2 = anfr.a(localObject2, (angi)localObject1);
    ((angi)localObject1).c((angt)localObject2);
    sza localsza = new sza(this.app);
    MessageRecord localMessageRecord = localsza.a((angt)localObject2);
    localsza.ar(localMessageRecord);
    ((angt)localObject2).message = localMessageRecord;
    ((angi)localObject1).c((angt)localObject2);
    anfr.a((angi)localObject1, this.app);
    localObject1 = new Intent(this.mActivity, SplashActivity.class);
    ((Intent)localObject1).putExtras(this.bf);
    localObject1 = wja.a((Intent)localObject1, null);
    ((Intent)localObject1).putExtra("isBack2Root", true);
    this.mActivity.startActivity((Intent)localObject1);
    this.mActivity.finish();
  }
  
  public void dnV()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(getExtras());
    localIntent.putExtra("forward_to_someplace_from_shoot_quick", 1003);
    this.mActivity.setResult(-1, localIntent);
    this.mActivity.finish();
    anot.a(this.app, "CliOper", "", "", "0X8007810", "0X8007810", 0, 0, "", "", "", "");
    rar.a("plus_shoot", "send_tip", 0, 0, new String[] { "", "", "", "" });
  }
  
  public void dnr()
  {
    if (anv()) {
      this.cs.add(U);
    }
    if (anw()) {
      this.cs.add(T);
    }
    if (anx()) {
      this.cs.add(S);
    }
    boolean bool = this.mIntent.getBooleanExtra("k_smartdevice", true);
    if ((anz()) && (bool)) {
      this.cs.add(aa);
    }
    if (this.mIntent.getBooleanExtra("k_qzone", false)) {
      this.cs.add(V);
    }
    if (this.mIntent.getBooleanExtra("k_qqstory", false)) {
      this.cs.add(ad);
    }
    if (this.mIntent.getBooleanExtra("k_dataline", false))
    {
      this.cs.add(W);
      this.cs.add(ab);
    }
  }
  
  public void dnv()
  {
    super.dnv();
    int i;
    String str;
    if (this.bf.getBoolean("NeedReportForwardShortVideo", false))
    {
      i = akxo.b(this.app, this.bf.getInt("uintype"), this.bf.getString("uin"));
      if (i != 3) {
        break label90;
      }
      str = "1";
    }
    for (;;)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005622", "0X8005622", 0, 0, str, "", "", "");
      return;
      label90:
      if (i == 2) {
        str = "2";
      } else if (i == 0) {
        str = "3";
      } else {
        str = "4";
      }
    }
  }
  
  public void du(Intent paramIntent)
  {
    paramIntent.putExtra("dataline_forward_type", 100);
    Object localObject2 = this.bf.getString("forward_extra");
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.mIntent.getStringExtra("forward_extra");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.mIntent.getStringExtra("forward_filepath");
    }
    localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = this.bf.getString("forward_filepath");
    }
    localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = this.bf.getString("GALLERY.FORWORD_LOCAL_PATH");
    }
    QLog.d("ForwardOption.ForwardShortVideoOption", 1, "sendDatalineSingle filePath: " + (String)localObject2);
    paramIntent.putExtra("dataline_forward_path", (String)localObject2);
    auqv.aX(true, (String)localObject2);
  }
  
  static class PressDarkImageView
    extends ImageView
  {
    public static ColorFilter d = new PorterDuffColorFilter(167970842, PorterDuff.Mode.SRC_ATOP);
    ImageView zW;
    
    public PressDarkImageView(Context paramContext)
    {
      super();
    }
    
    public PressDarkImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
    {
      super(paramAttributeSet);
    }
    
    public PressDarkImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
    {
      super(paramAttributeSet, paramInt);
    }
    
    protected void drawableStateChanged()
    {
      super.drawableStateChanged();
      Drawable localDrawable;
      if (isPressed()) {
        if (Build.VERSION.SDK_INT >= 11)
        {
          super.setAlpha(0.5F);
          if (this.zW != null)
          {
            localDrawable = this.zW.getDrawable();
            if (localDrawable != null) {
              localDrawable.setColorFilter(BaseBubbleBuilder.d);
            }
          }
        }
      }
      do
      {
        do
        {
          do
          {
            return;
          } while (Build.VERSION.SDK_INT < 11);
          super.setAlpha(1.0F);
        } while (this.zW == null);
        localDrawable = this.zW.getDrawable();
      } while (localDrawable == null);
      localDrawable.setColorFilter(null);
    }
  }
  
  static class a
  {
    public ForwardShortVideoOption.PressDarkImageView a;
    public ImageView zV;
    
    public void V(Drawable paramDrawable)
    {
      this.a.setVisibility(0);
      this.zV.setVisibility(0);
      if (paramDrawable == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardShortVideoOption", 2, "setPreviewImage null");
        }
        this.zV.setImageResource(2130838159);
        return;
      }
      RelativeLayout.LayoutParams localLayoutParams = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams.addRule(13);
      this.zV.setLayoutParams(localLayoutParams);
      this.zV.setAdjustViewBounds(true);
      this.zV.setMaxHeight(aqnm.dip2px(140.0F));
      this.zV.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.zV.setImageDrawable(paramDrawable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.forward.ForwardShortVideoOption
 * JD-Core Version:    0.7.0.1
 */