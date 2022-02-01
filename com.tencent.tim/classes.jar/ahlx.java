import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.TextUtils.TruncateAt;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawableDownListener.Adapter;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.miniaio.MiniChatActivity;
import com.tencent.mobileqq.activity.miniaio.MiniMultiForwardFragment;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.mobileqq.structmsg.view.StructMsgItemTitle;
import com.tencent.mobileqq.troop.widget.EllipsizingTextView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import mqq.app.AppActivity;

public class ahlx
  extends ahgq
{
  String bKE = "";
  boolean chg = false;
  AbsShareMsg d;
  private URLDrawableDownListener.Adapter mUrlAdapter = new ahly(this);
  
  public ahlx(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private boolean b(AbsShareMsg paramAbsShareMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramAbsShareMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsShareMsg = ((StructMsgForGeneralShare)paramAbsShareMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsShareMsg != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      Object localObject;
      int j;
      if (i < paramAbsShareMsg.size())
      {
        localObject = (anqu)paramAbsShareMsg.get(i);
        if (!(localObject instanceof antz)) {
          break label139;
        }
        localObject = ((antz)localObject).rz;
        if (localObject == null) {
          break label179;
        }
        j = 0;
        if (j >= ((List)localObject).size()) {
          break label179;
        }
        anqu localanqu = (anqu)((List)localObject).get(j);
        if ((!(localanqu instanceof anvf)) || (((anvf)localanqu).aza())) {
          break label132;
        }
        bool1 = true;
      }
      label132:
      label139:
      do
      {
        do
        {
          return bool1;
          j += 1;
          break;
          if (!(localObject instanceof antd)) {
            break label179;
          }
          paramAbsShareMsg = (antd)localObject;
          bool1 = bool2;
        } while (paramAbsShareMsg.dMi == 1);
        bool1 = bool2;
      } while (paramAbsShareMsg.dMi == 3);
      return true;
      label179:
      i += 1;
    }
  }
  
  private void c(boolean paramBoolean, String paramString, long paramLong)
  {
    String str2 = wo();
    String str1 = str2;
    Intent localIntent;
    if (!TextUtils.isEmpty(str2))
    {
      if (str2.startsWith(acfp.m(2131706540))) {
        str1 = str2.substring(4);
      }
    }
    else
    {
      str2 = this.bf.getString("uin");
      int i = this.bf.getInt("uintype", 0);
      localIntent = new Intent();
      localIntent.setClass(this.mActivity, MiniChatActivity.class);
      localIntent.addFlags(268435456);
      localIntent.putExtra("uin", str2);
      localIntent.putExtra("uintype", i);
      localIntent.putExtra("uinname", str1);
      localIntent.putExtra("public_fragment_window_feature", 1);
      localIntent.putExtra("minaio_scaled_ration", B(0.78F));
      localIntent.putExtra("minaio_height_ration", 0.86F);
      localIntent.putExtra("member_dialog_title", str1);
      if (!paramBoolean) {
        break label228;
      }
      localIntent.putExtra("multi_forward_type", 1);
    }
    for (;;)
    {
      localIntent.putExtra("key_mini_from", 4);
      PublicFragmentActivity.b.start(this.mActivity, localIntent, MiniChatActivity.class, MiniMultiForwardFragment.class);
      return;
      str1 = str2;
      if (!str2.startsWith(acfp.m(2131706511))) {
        break;
      }
      str1 = str2.substring(3);
      break;
      label228:
      localIntent.putExtra("multi_forward_type", 2);
      localIntent.putExtra("multi_forward_title", paramString);
      localIntent.putExtra("structmsg_uniseq", paramLong);
    }
  }
  
  private View cd()
  {
    LinearLayout localLinearLayout = new LinearLayout(this.mActivity);
    localLinearLayout.setOrientation(0);
    localLinearLayout.addView(this.d.getPreDialogView(this.mActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
    int i = 1;
    if (this.d.mMsgServiceID == 32) {
      i = 0;
    }
    for (;;)
    {
      FrameLayout localFrameLayout = new FrameLayout(this.mActivity);
      localFrameLayout.setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      if (i != 0)
      {
        Object localObject = new ImageView(this.mActivity);
        ((ImageView)localObject).setImageResource(2130840498);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqnm.dip2px(8.0F), aqnm.dip2px(14.0F));
        localLayoutParams.setMargins(aqnm.dip2px(7.0F), 0, 0, 0);
        localLayoutParams.gravity = 16;
        localLinearLayout.addView((View)localObject, localLayoutParams);
        localObject = new View(this.mActivity);
        ((View)localObject).setBackgroundResource(2130840508);
        localFrameLayout.addView((View)localObject, new FrameLayout.LayoutParams(-1, aqnm.dip2px(33.0F), 16));
        ((View)localObject).setOnClickListener(new ahlz(this));
        ((View)localObject).setContentDescription(acfp.m(2131706512));
      }
      localFrameLayout.addView(localLinearLayout, new FrameLayout.LayoutParams(-1, -1));
      return localFrameLayout;
      if (TextUtils.isEmpty(this.d.mMsgUrl)) {
        i = 0;
      }
    }
  }
  
  private View cg()
  {
    Object localObject1 = acfp.m(2131706529);
    Object localObject2 = String.format((String)localObject1, new Object[] { Integer.valueOf(this.d.mTSum) });
    int j = this.bf.getInt("forward_msg_from_together", -1);
    if (j == 1) {
      localObject1 = acfp.m(2131706528) + (String)localObject2;
    }
    int i;
    if ((j == 0) || (j == -1))
    {
      localObject1 = (anqu)this.d.mStructMsgItemLists.get(0);
      if ((localObject1 instanceof anqv))
      {
        localObject1 = (anqu)((anqv)localObject1).rz.get(0);
        if ((localObject1 instanceof StructMsgItemTitle))
        {
          localObject1 = ((StructMsgItemTitle)localObject1).text;
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (this.d.hasTSum()) && (((String)localObject1).endsWith(acfp.m(2131706509))))
          {
            i = 1;
            if (i == 0) {
              break label566;
            }
            label183:
            localObject2 = acfp.m(2131706498) + (String)localObject1;
          }
        }
      }
    }
    for (;;)
    {
      Object localObject3 = new LinearLayout(this.mActivity);
      ((LinearLayout)localObject3).setOrientation(0);
      Object localObject4 = new EllipsizingTextView(this.mActivity, null);
      ((EllipsizingTextView)localObject4).setText(new aofk((CharSequence)localObject2, 3, 16));
      ((EllipsizingTextView)localObject4).setMaxLines(2);
      ((EllipsizingTextView)localObject4).setEllipsize(TextUtils.TruncateAt.END);
      ((EllipsizingTextView)localObject4).setTextColor(this.mActivity.getResources().getColorStateList(2131165828));
      ((EllipsizingTextView)localObject4).setTextSize(14.0F);
      localObject2 = new ImageView(this.mActivity);
      ((ImageView)localObject2).setImageResource(2130840498);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2, 1.0F);
      localLayoutParams.gravity = 17;
      ((LinearLayout)localObject3).addView((View)localObject4, localLayoutParams);
      localObject4 = new LinearLayout.LayoutParams(aqnm.dip2px(8.0F), aqnm.dip2px(14.0F));
      ((LinearLayout.LayoutParams)localObject4).gravity = 17;
      ((LinearLayout.LayoutParams)localObject4).setMargins(aqnm.dip2px(3.0F), 0, 0, 0);
      ((LinearLayout)localObject3).addView((View)localObject2, (ViewGroup.LayoutParams)localObject4);
      ((LinearLayout)localObject3).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
      localObject2 = new View(this.mActivity);
      ((View)localObject2).setBackgroundResource(2130840508);
      long l = this.bf.getLong("structmsg_uniseq", 0L);
      boolean bool;
      if (j == 1)
      {
        bool = true;
        label451:
        ((View)localObject2).setOnClickListener(new ahma(this, bool, (String)localObject1, l));
        localObject1 = new FrameLayout(this.mActivity);
        i = aqnm.dip2px(20.0F);
        ((FrameLayout)localObject1).setPadding(0, i, 0, i);
        ((FrameLayout)localObject1).setLayoutParams(new RelativeLayout.LayoutParams(-1, -2));
        ((FrameLayout)localObject1).addView((View)localObject2, new FrameLayout.LayoutParams(-1, -1, 16));
        ((FrameLayout)localObject1).addView((View)localObject3, new FrameLayout.LayoutParams(-1, -2));
        if (j != 1) {
          break label583;
        }
        this.cZS = 2;
      }
      label566:
      label583:
      while ((j != 0) && (j != -1))
      {
        return localObject1;
        i = 0;
        break;
        localObject1 = acfp.m(2131706506);
        break label183;
        bool = false;
        break label451;
      }
      this.cZS = 1;
      return localObject1;
      localObject1 = localObject2;
      break label183;
      localObject3 = localObject2;
      localObject2 = localObject1;
      localObject1 = localObject3;
    }
  }
  
  private void dop()
  {
    if (!TextUtils.isEmpty(this.d.mMsgUrl))
    {
      str = this.d.mMsgUrl.trim();
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "gotoWeb " + str);
      }
      if (aobw.pN(str))
      {
        localObject = new Bundle();
        ((Bundle)localObject).putString("url", str);
        ((Bundle)localObject).putBoolean("doc_from_forward_dialog", true);
        TeamWorkDocEditBrowserActivity.a(this.mActivity, (Bundle)localObject, false);
        dnZ();
      }
    }
    while (!QLog.isColorLevel()) {
      for (;;)
      {
        String str;
        return;
        Object localObject = new Intent(this.mActivity, QQBrowserDelegationActivity.class);
        ((Intent)localObject).putExtra("param_force_internal_browser", true);
        ((Intent)localObject).putExtra("reqType", 7);
        ((Intent)localObject).putExtra("hideRightButton", true);
        ((Intent)localObject).putExtra("hide_more_button", true);
        ((Intent)localObject).putExtra("url", str);
        wgv.c(this.mActivity, (Intent)localObject, str);
      }
    }
    QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "empty url");
  }
  
  private void e(aqju paramaqju)
  {
    paramaqju.setBodyLayoutNoMargin();
    Object localObject1 = new URLImageView(this.mActivity);
    Object localObject2 = new LinearLayout.LayoutParams(-1, wja.dp2px(152.0F, this.mActivity.getResources()));
    if ((this.d.mMsgServiceID == 114) || (this.d.mMsgServiceID == 116))
    {
      ((LinearLayout.LayoutParams)localObject2).leftMargin = wja.dp2px(24.0F, this.mActivity.getResources());
      ((LinearLayout.LayoutParams)localObject2).rightMargin = wja.dp2px(24.0F, this.mActivity.getResources());
    }
    ((URLImageView)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
    ((URLImageView)localObject1).setBackgroundColor(Color.parseColor("#dcdfe4"));
    Object localObject3 = abdy.getStructMsgInfo(this.d, "cover");
    Drawable localDrawable = this.mActivity.getResources().getDrawable(2130851465);
    if (!TextUtils.isEmpty((CharSequence)localObject3))
    {
      localObject3 = URLDrawable.getDrawable((String)localObject3, -1, wja.dp2px(165.0F, this.mActivity.getResources()), localDrawable, localDrawable, true);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 2)) {
        ((URLDrawable)localObject3).restartDownload();
      }
      if ((localObject3 != null) && (((URLDrawable)localObject3).getStatus() == 1))
      {
        ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_CROP);
        ((URLImageView)localObject1).setBackgroundDrawable(null);
        ((URLImageView)localObject1).setImageDrawable((Drawable)localObject3);
      }
    }
    for (;;)
    {
      paramaqju.addView((View)localObject1, (LinearLayout.LayoutParams)localObject2);
      localObject1 = abdy.getStructMsgInfo(this.d, "title");
      localObject2 = new TextView(this.mActivity);
      ((TextView)localObject2).setText((CharSequence)localObject1);
      ((TextView)localObject2).setTextSize(16.0F);
      ((TextView)localObject2).setIncludeFontPadding(false);
      ((TextView)localObject2).setTextColor(-16777216);
      ((TextView)localObject2).setMaxLines(1);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setPadding(wja.dp2px(24.0F, this.mActivity.getResources()), wja.dp2px(8.0F, this.mActivity.getResources()), wja.dp2px(24.0F, this.mActivity.getResources()), wja.dp2px(20.0F, this.mActivity.getResources()));
      paramaqju.addView((View)localObject2);
      return;
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
      ((URLImageView)localObject1).setURLDrawableDownListener(this.mUrlAdapter);
      break;
      ((URLImageView)localObject1).setImageDrawable(localDrawable);
      ((URLImageView)localObject1).setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    }
  }
  
  private boolean h(AbsStructMsg paramAbsStructMsg)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    if ((paramAbsStructMsg instanceof StructMsgForGeneralShare))
    {
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      bool1 = bool2;
      if (paramAbsStructMsg != null) {
        i = 0;
      }
    }
    for (;;)
    {
      bool1 = bool2;
      if (i < paramAbsStructMsg.size())
      {
        anqu localanqu = (anqu)paramAbsStructMsg.get(i);
        if (!(localanqu instanceof antd)) {
          break label95;
        }
        paramAbsStructMsg = (antd)localanqu;
        bool1 = bool2;
        if (paramAbsStructMsg.dMi != 1)
        {
          bool1 = bool2;
          if (paramAbsStructMsg.dMi != 3) {
            bool1 = true;
          }
        }
      }
      return bool1;
      label95:
      i += 1;
    }
  }
  
  protected int EW()
  {
    Object localObject1;
    if ((this.d instanceof StructMsgForImageShare))
    {
      localObject1 = avjj.a((StructMsgForImageShare)this.d);
      if ((localObject1 == null) || (!aviz.b(((ansu)localObject1).cij).a(this.app).b(this.mActivity, this.app.getAccount(), -1, null))) {}
    }
    else
    {
      for (i = 0;; i = 0)
      {
        if (i == 0) {
          avjg.a(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
        }
        return i;
        if (TextUtils.isEmpty(this.d.mMsgActionData)) {
          break;
        }
        String[] arrayOfString1 = this.d.mMsgActionData.split("&");
        int j = arrayOfString1.length;
        i = 0;
        Object localObject4 = null;
        Object localObject3 = null;
        Object localObject2 = null;
        localObject1 = null;
        if (i < j)
        {
          String[] arrayOfString2 = arrayOfString1[i].split("=");
          Object localObject5 = localObject4;
          Object localObject6 = localObject3;
          Object localObject7 = localObject2;
          Object localObject8 = localObject1;
          if (arrayOfString2.length > 1)
          {
            if (!arrayOfString2[0].trim().equals("lat")) {
              break label225;
            }
            localObject8 = arrayOfString2[1];
            localObject7 = localObject2;
            localObject6 = localObject3;
            localObject5 = localObject4;
          }
          for (;;)
          {
            i += 1;
            localObject4 = localObject5;
            localObject3 = localObject6;
            localObject2 = localObject7;
            localObject1 = localObject8;
            break;
            label225:
            if (arrayOfString2[0].trim().equals("lon"))
            {
              localObject7 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject8 = localObject1;
            }
            else if (arrayOfString2[0].trim().equals("loc"))
            {
              localObject6 = arrayOfString2[1];
              localObject5 = localObject4;
              localObject7 = localObject2;
              localObject8 = localObject1;
            }
            else
            {
              localObject5 = localObject4;
              localObject6 = localObject3;
              localObject7 = localObject2;
              localObject8 = localObject1;
              if (arrayOfString2[0].trim().equals("title"))
              {
                localObject5 = arrayOfString2[1];
                localObject6 = localObject3;
                localObject7 = localObject2;
                localObject8 = localObject1;
              }
            }
          }
        }
        if ((this.d.mMsgServiceID != 32) || (TextUtils.isEmpty((CharSequence)localObject1)) || (TextUtils.isEmpty(localObject2)) || (TextUtils.isEmpty(localObject3)) || (!aviz.a(Float.valueOf((String)localObject1).floatValue(), Float.valueOf(localObject2).floatValue(), localObject4, localObject3, null).a(this.app).b(this.mActivity, this.app.getAccount(), -1, null))) {
          break label540;
        }
      }
      localObject1 = avjj.P(this.d.getXmlBytes());
      if (!(this.d instanceof StructMsgForAudioShare)) {
        break label545;
      }
    }
    label540:
    label545:
    for (int i = 2;; i = 0)
    {
      if (aviz.a(i, this.d.mContentTitle, this.d.mMsgUrl, this.d.mSourceName, this.d.mContentSummary, this.d.mContentCover, this.d.mContentSrc, (byte[])localObject1, false, 0L).a(this.app).b(this.mActivity, this.app.getAccount(), -1, null))
      {
        i = 0;
        break;
      }
      i = -1;
      break;
    }
  }
  
  protected boolean a(aqju paramaqju)
  {
    int j = 0;
    int i;
    if (this.d != null)
    {
      boolean bool = b(this.d);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      if ((this.d instanceof StructMsgForGeneralShare)) {
        if ((!bool) && (this.d.mMsgServiceID != 97)) {
          localLayoutParams.setMargins(wja.dp2px(-15.0F, this.mActivity.getResources()), 0, wja.dp2px(-15.0F, this.mActivity.getResources()), wja.dp2px(5.0F, this.mActivity.getResources()));
        }
      }
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardStructingMsgOption", 2, "updateImageView addStructView");
        }
        if (!this.chg) {
          break;
        }
        e(paramaqju);
        return false;
        if ((this.d instanceof StructMsgForAudioShare)) {
          localLayoutParams.setMargins(0, wja.dp2px(5.0F, this.mActivity.getResources()), 0, wja.dp2px(10.0F, this.mActivity.getResources()));
        } else if ((this.d instanceof StructMsgForImageShare)) {
          localLayoutParams.setMargins(wja.dp2px(-10.0F, this.mActivity.getResources()), 0, wja.dp2px(-7.5F, this.mActivity.getResources()), 0);
        }
      }
      paramaqju.addView(this.d.getPreDialogView(this.mActivity, null), localLayoutParams);
      if (((this.d instanceof StructMsgForImageShare)) || (bool) || (!this.mIntent.getBooleanExtra("is_need_show_sources", true))) {
        break label307;
      }
      i = 1;
      if (this.d.mMsgServiceID != 35) {
        break label312;
      }
      i = j;
    }
    label307:
    label312:
    for (;;)
    {
      if (i != 0) {
        b(this.d.mSourceName, paramaqju);
      }
      return true;
      i = 0;
      break;
    }
  }
  
  protected boolean a(LightAppSettingInfo paramLightAppSettingInfo)
  {
    boolean bool2 = true;
    if (paramLightAppSettingInfo == null) {}
    do
    {
      return false;
      paramLightAppSettingInfo = paramLightAppSettingInfo.oA;
    } while ((paramLightAppSettingInfo == null) || (this.d == null));
    boolean bool1 = bool2;
    switch (this.d.mMsgServiceID)
    {
    default: 
      bool1 = false;
    }
    for (;;)
    {
      return bool1;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11005))) {
        break;
      }
      bool1 = bool2;
      continue;
      if (!paramLightAppSettingInfo.contains(Integer.valueOf(11003))) {
        break;
      }
      bool1 = bool2;
    }
  }
  
  public DeviceInfo[] a(DeviceInfo[] paramArrayOfDeviceInfo)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject = (syw)this.app.getBusinessHandler(51);
    localObject = new tao();
    int j = paramArrayOfDeviceInfo.length;
    int i = 0;
    while (i < j)
    {
      DeviceInfo localDeviceInfo = paramArrayOfDeviceInfo[i];
      if (localDeviceInfo != null)
      {
        LightAppSettingInfo localLightAppSettingInfo = ((tao)localObject).a(localDeviceInfo);
        if (QLog.isColorLevel()) {
          QLog.e("ForwardStructingMsgOption", 2, "settingInfo = " + localLightAppSettingInfo);
        }
        if ((e(aa)) && (a(localLightAppSettingInfo))) {
          localArrayList.add(localDeviceInfo);
        }
      }
      i += 1;
    }
    return (DeviceInfo[])localArrayList.toArray(new DeviceInfo[localArrayList.size()]);
  }
  
  public boolean anj()
  {
    super.anj();
    Object localObject = anre.a(this.bf.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.d = ((AbsShareMsg)localObject);
    }
    if (this.d != null)
    {
      if ((this.d.mMsgServiceID != 83) && (this.d.mMsgServiceID != 108) && (this.d.mMsgServiceID != 114) && (this.d.mMsgServiceID != 116) && (this.d.mMsgServiceID != 151) && (this.d.mMsgServiceID != 156)) {
        break label172;
      }
      this.chg = true;
      this.bf.putInt("emoInputType", 3);
    }
    for (;;)
    {
      localObject = Uri.parse(this.d.mMsgUrl);
      try
      {
        this.bKE = ((Uri)localObject).getQueryParameter("article_id");
        if (this.bKE == null) {
          this.bKE = "";
        }
        return true;
        label172:
        if ((!this.d.mMsgUrl.startsWith("http://article.mp.qq.com")) && (!this.d.mMsgUrl.startsWith("https://article.mp.qq.com")) && (!this.d.mMsgUrl.startsWith("http://post.mp.qq.com")) && (!this.d.mMsgUrl.startsWith("https://post.mp.qq.com"))) {
          continue;
        }
        this.bf.putInt("emoInputType", 2);
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
        }
      }
    }
  }
  
  protected boolean anl()
  {
    Intent localIntent = new Intent();
    localIntent.putExtras(this.bf);
    this.bf.putBoolean("isBack2Root", false);
    if ((QLog.isColorLevel()) && (this.d != null)) {
      QLog.d("forward", 2, "ForwardStructingMsgOption realForwardTo  mShareMsg.mMsgServiceID=" + this.d.mMsgServiceID);
    }
    Object localObject1;
    if (anq())
    {
      localObject1 = fg();
      Object localObject2;
      if ((this.d instanceof StructMsgForImageShare))
      {
        localObject2 = ((List)localObject1).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject2).next();
          StructMsgForImageShare.sendAndUploadImageShare(this.app, (StructMsgForImageShare)this.d, localResultRecord.uin, localResultRecord.lk(), null, 0);
        }
        if (!this.bf.getBoolean("k_back", true))
        {
          localObject2 = wja.a(new Intent(this.mActivity, ChatActivity.class), null);
          ((Intent)localObject2).putExtras(this.bf);
          this.mActivity.startActivity((Intent)localObject2);
        }
      }
      if ((this.d != null) && ((this.d.mMsgServiceID == 32) || (this.d.mMsgServiceID == 97)))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          localObject2 = ForwardUtils.a(localIntent, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).lk(), ((ResultRecord)localObject2).QD);
          ForwardUtils.a(this.app, this.mAppContext, (SessionInfo)localObject2, localIntent);
        }
        if (this.d.mMsgServiceID == 97) {
          return false;
        }
      }
      if ((this.bf.getBoolean("forwardDirect", false)) && ((this.mActivity instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.mActivity).getAppRuntime(), this.mActivity, this.mActivity.getApplicationContext(), localIntent, null);
      }
    }
    for (;;)
    {
      localIntent.putExtra("uin", this.bf.getString("uin", ""));
      localIntent.putExtra("uintype", this.bf.getInt("uintype", 0));
      this.mActivity.setResult(-1, localIntent);
      this.mActivity.finish();
      return false;
      if ((this.d instanceof StructMsgForImageShare))
      {
        StructMsgForImageShare.sendAndUploadImageShare(this.app, (StructMsgForImageShare)this.d, this.bf.getString("uin"), this.bf.getInt("uintype"), null, 0);
        if (!this.bf.getBoolean("k_back", true))
        {
          localObject1 = wja.a(new Intent(this.mActivity, ChatActivity.class), null);
          ((Intent)localObject1).putExtras(this.bf);
          this.mActivity.startActivity((Intent)localObject1);
        }
      }
      if ((this.d != null) && ((this.d.mMsgServiceID == 32) || (this.d.mMsgServiceID == 97) || (this.d.mMsgServiceID == 145) || (this.d.mMsgServiceID == 155)))
      {
        localObject1 = ForwardUtils.a(localIntent);
        ForwardUtils.a(this.app, this.mAppContext, (SessionInfo)localObject1, localIntent);
        if (this.d.mMsgServiceID == 97) {
          break;
        }
      }
      if ((this.bf.getBoolean("forwardDirect", false)) && ((this.mActivity instanceof AppActivity))) {
        ForwardUtils.a((QQAppInterface)((AppActivity)this.mActivity).getAppRuntime(), this.mActivity, this.mActivity.getApplicationContext(), localIntent, null);
      }
    }
  }
  
  public boolean ann()
  {
    return true;
  }
  
  protected boolean anr()
  {
    return false;
  }
  
  protected boolean ans()
  {
    if (this.d == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardStructingMsgOption", 2, "msgId = " + this.d.mMsgServiceID);
      }
      if (this.d.mMsgServiceID == 35) {
        return true;
      }
      if (this.d.mMsgServiceID == 33)
      {
        this.cZS = 8;
        return true;
      }
      if (this.d.mMsgServiceID == 95)
      {
        this.cZS = 9;
        return true;
      }
    } while ((this.d.mMsgUrl == null) || (!h(this.d)));
    this.cZS = 8;
    return true;
  }
  
  protected View cc()
  {
    if (this.d == null) {
      return null;
    }
    if (this.d.mMsgServiceID == 35) {
      return cg();
    }
    if (this.d.mMsgServiceID == 33) {
      return cd();
    }
    if (this.d.mMsgServiceID == 95) {
      return cd();
    }
    return cd();
  }
  
  protected void dnO()
  {
    super.dnO();
    anot.a(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
  }
  
  protected void dnU()
  {
    ((szy)this.app.getBusinessHandler(49)).a().a(this.bf.getString("uin"), this.d);
    this.mActivity.finish();
  }
  
  protected void dnr()
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
    if ((this.mIntent.getBooleanExtra("k_smartdevice", true)) && (super.anz())) {
      this.cs.add(aa);
    }
  }
  
  protected void dns()
  {
    super.dns();
    this.e.adjustMessageBottomMargin(17.0F);
    this.e.setMessageTextColor(2131165857);
    this.e.setMessageTextSize(14.0F);
    if ((this.d != null) && (this.d.mMsgServiceID == 97))
    {
      ViewGroup.LayoutParams localLayoutParams = ((LinearLayout)this.e.findViewById(2131363579)).getLayoutParams();
      if ((localLayoutParams instanceof ViewGroup.MarginLayoutParams)) {
        ((ViewGroup.MarginLayoutParams)localLayoutParams).setMargins(0, 0, 0, 0);
      }
    }
  }
  
  protected void dnv()
  {
    int i = this.mIntent.getIntExtra("structmsg_service_id", -1);
    anot.a(this.app, "CliOper", "", "", "0X800567B", "0X800567B", 0, 0, i + "", "", "", "");
    anot.a(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    Object localObject1;
    if ((this.d instanceof StructMsgForGeneralShare))
    {
      localObject1 = (StructMsgForGeneralShare)this.d;
      Iterator localIterator = ((StructMsgForGeneralShare)localObject1).iterator();
      while (localIterator.hasNext())
      {
        Object localObject2 = (anqu)localIterator.next();
        if ((localObject2 instanceof antz))
        {
          localObject2 = ((antz)localObject2).rz.iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject3 = (anqu)((Iterator)localObject2).next();
            if ((localObject3 instanceof anvf))
            {
              localObject3 = (anvf)localObject3;
              if (((anvf)localObject3).aza()) {
                kct.b("0X80065FF", ((StructMsgForGeneralShare)localObject1).uinType, kct.l(((anvf)localObject3).type, ((StructMsgForGeneralShare)localObject1).mSourceName), ((anvf)localObject3).ciu, "");
              }
            }
          }
        }
      }
      Kc("1");
    }
    for (;;)
    {
      i = EU();
      localObject1 = "";
      if (i != 0) {
        localObject1 = this.e.getInputValue();
      }
      this.bf.putString("share_comment_message", (String)localObject1);
      super.dnv();
      return;
      if ((this.d instanceof StructMsgForImageShare))
      {
        if (xtj.hR(this.d.mMsgActionData))
        {
          localObject1 = xtj.j(this.d.mMsgActionData);
          if ((localObject1 != null) && (localObject1.length > 3))
          {
            localObject1 = localObject1[3];
            if ((localObject1 != null) && (((String)localObject1).equals("1")))
            {
              kbp.a(this.app, "", "0X80072A5", "0X80072A5", 0, 0, "", "", "", "");
              kbp.d("0X80072A5", "", "", "", "", "");
            }
          }
        }
        doa();
      }
      else if ((this.d instanceof StructMsgForAudioShare))
      {
        Kc("2");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahlx
 * JD-Core Version:    0.7.0.1
 */