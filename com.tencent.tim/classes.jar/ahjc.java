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
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.PublicAccountHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Emoticon;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardPluginShareStructMsgOption.2;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahjc
  extends ahgq
{
  String bKE = "";
  int cZW;
  boolean chg = false;
  AbsShareMsg d;
  String mPluginName;
  int mShareType;
  private URLDrawableDownListener.Adapter mUrlAdapter = new ahjd(this);
  
  public ahjc(Intent paramIntent)
  {
    super(paramIntent);
  }
  
  private void Kf(String paramString)
  {
    ThreadManager.post(new ForwardPluginShareStructMsgOption.2(this, paramString), 5, null, true);
  }
  
  private View cd()
  {
    Object localObject1 = new LinearLayout(this.mActivity);
    ((LinearLayout)localObject1).setOrientation(0);
    ((LinearLayout)localObject1).addView(this.d.getPreDialogView(this.mActivity, null), new LinearLayout.LayoutParams(0, -2, 1.0F));
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
        Object localObject2 = new ImageView(this.mActivity);
        ((ImageView)localObject2).setImageResource(2130840498);
        LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(aqnm.dip2px(8.0F), aqnm.dip2px(14.0F));
        localLayoutParams.setMargins(aqnm.dip2px(7.0F), 0, 0, 0);
        localLayoutParams.gravity = 16;
        ((LinearLayout)localObject1).addView((View)localObject2, localLayoutParams);
        localObject2 = new View(this.mActivity);
        ((View)localObject2).setBackgroundResource(2130840508);
        localFrameLayout.addView((View)localObject2, new FrameLayout.LayoutParams(-1, aqnm.dip2px(33.0F), 16));
        ((View)localObject2).setOnClickListener(new ahje(this));
        ((View)localObject2).setContentDescription(acfp.m(2131706473));
      }
      localFrameLayout.addView((View)localObject1, new FrameLayout.LayoutParams(-1, -1));
      localObject1 = this.mIntent.getStringExtra("key_send_tips");
      if ((localObject1 != null) && ((this.e instanceof ahio))) {
        ((ahio)this.e).Ke((String)localObject1);
      }
      return localFrameLayout;
      if (TextUtils.isEmpty(this.d.mMsgUrl)) {
        i = 0;
      }
    }
  }
  
  private void doo()
  {
    int i = 1;
    if (EU() != 0) {}
    for (Object localObject1 = this.e.getInputValue();; localObject1 = "")
    {
      this.mIntent.getAction();
      Object localObject2 = Boolean.valueOf(this.mIntent.getBooleanExtra("key_flag_from_plugin", false));
      Object localObject3 = Boolean.valueOf(this.mIntent.getBooleanExtra("k_back", false));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + localObject2 + "iskeyBack=" + localObject3 + "isNOneedJumpToAIO=" + this.cgR);
      }
      Object localObject4 = fg();
      int j;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject2 = wja.a(new Intent(this.mActivity, SplashActivity.class), new int[] { 2 });
        this.bf.putString("share_comment_message", (String)localObject1);
        ((Intent)localObject2).putExtras(this.bf);
        aa((Intent)localObject2);
        if (((Boolean)localObject3).booleanValue())
        {
          localObject3 = anre.a(((Intent)localObject2).getExtras());
          Object localObject5;
          Object localObject6;
          if ((this.cZW == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
          {
            localObject5 = (StructMsgForGeneralShare)localObject3;
            localObject6 = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
            ((StringBuilder)localObject6).append("&msg=").append(((Intent)localObject2).getStringExtra("title")).append("&toUin=").append(this.bf.getString("uin"));
            ((StructMsgForGeneralShare)localObject5).mMsgActionData = ((StringBuilder)localObject6).toString();
          }
          if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116)) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          localObject4 = ((List)localObject4).iterator();
          while (((Iterator)localObject4).hasNext())
          {
            localObject5 = (ResultRecord)((Iterator)localObject4).next();
            localObject6 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject5).uin, ((ResultRecord)localObject5).lk(), ((ResultRecord)localObject5).QD);
            j = wte.a().we();
            ((AbsStructMsg)localObject3).forwardID = j;
            wte.a().a((SessionInfo)localObject6, (String)localObject1, j);
            aqmf.a(this.app, ((ResultRecord)localObject5).uin, ((SessionInfo)localObject6).troopUin, ((ResultRecord)localObject5).lk(), (AbsStructMsg)localObject3, null);
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              jof.a().aaQ = true;
            }
          }
        }
        localObject1 = ((List)localObject4).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject3 = (ResultRecord)((Iterator)localObject1).next();
          if (this.cgR)
          {
            localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).QD);
            ForwardUtils.a(this.app, this.mAppContext, (SessionInfo)localObject3, (Intent)localObject2);
          }
          else if (ahiy.ab((Intent)localObject2))
          {
            localObject3 = ForwardUtils.a((Intent)localObject2, ((ResultRecord)localObject3).uin, ((ResultRecord)localObject3).lk(), ((ResultRecord)localObject3).QD);
            ForwardUtils.a(this.app, this.mAppContext, (SessionInfo)localObject3, (Intent)localObject2);
          }
        }
        localObject1 = new Intent();
        ((Intent)localObject1).putExtras(this.bf);
        this.mActivity.setResult(-1, (Intent)localObject1);
        if ("public_account".equals(this.mPluginName))
        {
          localObject1 = this.bf.getString("pubUin");
          if (localObject1 != null) {
            break label971;
          }
          localObject1 = "";
        }
      }
      label971:
      for (;;)
      {
        switch (this.bf.getInt("uintype"))
        {
        default: 
          i = -1;
          j = 0;
          if (this.mIntent.getBooleanExtra("k_struct_forward", false))
          {
            if (this.mIntent.getStringExtra("struct_uin") == null) {}
            localObject3 = this.mIntent.getStringExtra("strurt_msgid");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject4 = this.mIntent.getStringExtra("detail_url");
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            localObject4 = StructingMsgItemBuilder.pv();
            anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, (String)localObject4, (String)localObject2, (String)localObject3, "" + i);
          }
          PublicAccountHandler.a(this.app, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", j);
        }
        for (;;)
        {
          this.mActivity.finish();
          return;
          j = 1001;
          break;
          i = 2;
          j = 1002;
          break;
          i = 3;
          j = 1003;
          break;
          if ("struct_msg_from_h5".equals(this.mPluginName))
          {
            localObject1 = this.bf.getString("pubUin");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              PublicAccountHandler.a(this.app, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
            }
          }
          else if (ahiy.ab((Intent)localObject2))
          {
            anot.b(this.app, "CliOper", "", this.bf.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
          }
        }
        dnT();
        return;
      }
    }
  }
  
  private void dop()
  {
    if (!TextUtils.isEmpty(this.d.mMsgUrl))
    {
      str = this.d.mMsgUrl.trim();
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "gotoWeb " + str);
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
    QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "empty url");
  }
  
  private void e(aqju paramaqju)
  {
    int j = 1;
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
      localObject3 = URLDrawable.getDrawable((String)localObject3, (int)this.mActivity.getResources().getDimension(2131297117), wja.dp2px(165.0F, this.mActivity.getResources()), localDrawable, localDrawable, true);
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
      int i = j;
      if (this.bf != null)
      {
        i = j;
        if (this.bf.getInt("title_max_line", -1) > 0) {
          i = this.bf.getInt("title_max_line", 1);
        }
      }
      ((TextView)localObject2).setMaxLines(i);
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
    String str = this.mIntent.getStringExtra("detail_url");
    if ((!TextUtils.isEmpty(str)) && (aviz.a(str).b(this.mActivity, this.app.getAccount(), -1, null))) {}
    for (int i = 0;; i = -1)
    {
      if (i == 0) {
        avjg.a(this.app, "User_AddFav", -1, 0, 69, 0, "", "");
      }
      return i;
    }
  }
  
  public void H(int paramInt, Bundle paramBundle)
  {
    if (this.mIntent.getBooleanExtra("isWebCompShare", false))
    {
      Bundle localBundle = new Bundle();
      localBundle.putString("report_type", "102");
      localBundle.putString("act_type", "81");
      localBundle.putString("intext_1", "" + artv.b.kK(this.cZW));
      localBundle.putString("intext_2", "" + artv.b.u(paramBundle.getInt("uintype"), paramBundle.getString("uin")));
      localBundle.putString("intext_3", "1");
      arts.a().a(localBundle, "", this.app.getCurrentAccountUin(), false);
    }
    super.H(paramInt, paramBundle);
  }
  
  public void a(AbsStructMsg paramAbsStructMsg)
  {
    if ((paramAbsStructMsg == null) || (!(paramAbsStructMsg instanceof StructMsgForGeneralShare))) {}
    label454:
    label460:
    label461:
    label466:
    for (;;)
    {
      return;
      paramAbsStructMsg = ((StructMsgForGeneralShare)paramAbsStructMsg).getStructMsgItemLists();
      if ((paramAbsStructMsg != null) && (paramAbsStructMsg.size() != 0))
      {
        paramAbsStructMsg = paramAbsStructMsg.iterator();
        Object localObject1;
        do
        {
          if (!paramAbsStructMsg.hasNext()) {
            break;
          }
          localObject1 = (anqu)paramAbsStructMsg.next();
        } while (!(localObject1 instanceof antd));
        for (paramAbsStructMsg = (antd)localObject1;; paramAbsStructMsg = null)
        {
          if (paramAbsStructMsg == null) {
            break label466;
          }
          paramAbsStructMsg = paramAbsStructMsg.rz;
          if ((paramAbsStructMsg == null) || (paramAbsStructMsg.size() == 0)) {
            break;
          }
          localObject1 = paramAbsStructMsg.iterator();
          paramAbsStructMsg = null;
          label102:
          Object localObject2;
          if (((Iterator)localObject1).hasNext())
          {
            localObject2 = (anqu)((Iterator)localObject1).next();
            if (!(localObject2 instanceof anux)) {
              break label460;
            }
            paramAbsStructMsg = (anux)localObject2;
          }
          for (;;)
          {
            break label102;
            if (paramAbsStructMsg == null) {
              break label461;
            }
            localObject1 = paramAbsStructMsg.getText();
            if (TextUtils.isEmpty((CharSequence)localObject1)) {
              break;
            }
            ajdg localajdg = (ajdg)this.app.getManager(14);
            StringBuilder localStringBuilder = new StringBuilder((String)localObject1);
            int i = 0;
            int j;
            int[] arrayOfInt;
            if (i < localStringBuilder.length())
            {
              j = i;
              if ('ÿ' == localStringBuilder.charAt(i))
              {
                j = i;
                if (i + 3 < localStringBuilder.length())
                {
                  localObject1 = new char[4];
                  localObject1[0] = localStringBuilder.charAt(i + 3);
                  localObject1[1] = localStringBuilder.charAt(i + 2);
                  localObject1[2] = localStringBuilder.charAt(i + 1);
                  localObject1[3] = localStringBuilder.charAt(i);
                  j = 0;
                  if (j < 4)
                  {
                    if (localObject1[j] == 'ú') {
                      localObject1[j] = 10;
                    }
                    for (;;)
                    {
                      j += 1;
                      break;
                      if (localObject1[j] == 'þ') {
                        localObject1[j] = 13;
                      } else if (localObject1[j] == 'ý') {
                        localObject1[j] = 20;
                      }
                    }
                  }
                  arrayOfInt = afgc.a((char[])localObject1);
                  localObject2 = aofk.ckA;
                  if (localajdg == null) {
                    break label454;
                  }
                }
              }
            }
            for (localObject1 = localajdg.a(Integer.toString(arrayOfInt[0]), Integer.toString(arrayOfInt[1]));; localObject1 = null)
            {
              if (localObject1 != null) {}
              for (localObject1 = ((Emoticon)localObject1).character;; localObject1 = localObject2)
              {
                localStringBuilder.replace(i, i + 3, (String)localObject1);
                j = i + ((String)localObject1).length();
                i = j + 1;
                break;
                Kf(Integer.toString(arrayOfInt[0]));
              }
              if (TextUtils.isEmpty(localStringBuilder)) {
                break;
              }
              paramAbsStructMsg.setText(localStringBuilder.toString());
              return;
            }
          }
          break;
        }
      }
    }
  }
  
  protected boolean a(aqju paramaqju)
  {
    Object localObject = this.mIntent.getByteArrayExtra("stuctmsg_bytes");
    if (localObject != null)
    {
      localObject = anre.a((byte[])localObject);
      LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -2);
      a((AbsStructMsg)localObject);
      boolean bool = h((AbsStructMsg)localObject);
      if ((localObject instanceof StructMsgForAudioShare)) {
        localLayoutParams.setMargins(0, wja.dp2px(5.0F, this.mActivity.getResources()), 0, wja.dp2px(10.0F, this.mActivity.getResources()));
      }
      while (this.chg)
      {
        e(paramaqju);
        return false;
        if (bool)
        {
          localLayoutParams.setMargins(0, 0, 0, 0);
          paramaqju.adjustMessageTopBottomMargin(0.0F, 0.0F);
        }
        else
        {
          localLayoutParams.setMargins(wja.dp2px(-15.0F, this.mActivity.getResources()), 0, wja.dp2px(-15.0F, this.mActivity.getResources()), wja.dp2px(5.0F, this.mActivity.getResources()));
        }
      }
      paramaqju.addView(((AbsStructMsg)localObject).getPreDialogView(this.mActivity, null), localLayoutParams);
      if (!bool) {
        b(((AbsStructMsg)localObject).getSourceName(), paramaqju);
      }
    }
    return true;
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
        if ((e(aa)) && (super.a(localLightAppSettingInfo))) {
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
    if ((this.cZW == 13) || ("public_account".equals(this.mPluginName)) || ("web_share".equals(this.mPluginName)) || ("struct_msg_from_h5".equals(this.mPluginName)) || ("struct_favorite".equals(this.mPluginName)))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        RecentUser localRecentUser = (RecentUser)paramList.next();
        if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() == 0) && (e(S))) || ((localRecentUser.getType() == 1) && (!kj(localRecentUser.uin)) && (e(T))) || ((localRecentUser.getType() == 3000) && (e(U)) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))))) {
          localArrayList.add(localRecentUser);
        }
      }
    }
    return localArrayList;
  }
  
  public boolean anj()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption preloadData");
    }
    super.anj();
    this.cZW = this.mIntent.getIntExtra("req_type", 2147483647);
    this.mPluginName = this.bf.getString("pluginName");
    this.cgR = this.mIntent.getBooleanExtra("forward _key_nojump", false);
    Object localObject = anre.a(this.bf.getByteArray("stuctmsg_bytes"));
    if ((localObject != null) && ((localObject instanceof AbsShareMsg))) {
      this.d = ((AbsShareMsg)localObject);
    }
    if (this.d == null) {}
    for (;;)
    {
      return true;
      if ((this.d.mMsgServiceID == 83) || (this.d.mMsgServiceID == 108) || (this.d.mMsgServiceID == 114) || (this.d.mMsgServiceID == 116) || (this.d.mMsgServiceID == 151) || (this.d.mMsgServiceID == 156))
      {
        this.chg = true;
        this.bf.putInt("emoInputType", 3);
        this.mShareType = 2;
        label203:
        localObject = Uri.parse(this.d.mMsgUrl);
      }
      try
      {
        this.bKE = ((Uri)localObject).getQueryParameter("article_id");
        if (this.bKE == null) {
          this.bKE = "";
        }
        if (!this.mIntent.getBooleanExtra("isWebCompShare", false)) {
          continue;
        }
        localObject = new Bundle();
        ((Bundle)localObject).putString("report_type", "102");
        ((Bundle)localObject).putString("act_type", "80");
        ((Bundle)localObject).putString("intext_1", "" + artv.b.kK(this.cZW));
        ((Bundle)localObject).putString("intext_3", "1");
        arts.a().a((Bundle)localObject, "", this.app.getCurrentAccountUin(), false);
        return true;
        if ((!this.d.mMsgUrl.startsWith("http://article.mp.qq.com")) && (!this.d.mMsgUrl.startsWith("https://article.mp.qq.com")) && (!this.d.mMsgUrl.startsWith("http://post.mp.qq.com")) && (!this.d.mMsgUrl.startsWith("https://post.mp.qq.com"))) {
          break label203;
        }
        this.mShareType = 1;
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
  
  protected boolean ans()
  {
    if (this.d == null) {}
    do
    {
      return false;
      if (QLog.isColorLevel()) {
        QLog.e("ForwardOption.ForwardPluginShareStructMsgOption", 2, "msgId = " + this.d.mMsgServiceID);
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
    if (this.d.mMsgServiceID == 33)
    {
      this.cZS = 8;
      return cd();
    }
    if (this.d.mMsgServiceID == 95)
    {
      this.cZS = 9;
      return cd();
    }
    return cd();
  }
  
  protected void dnO()
  {
    super.dnO();
    anot.a(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "1", "", "", "");
    if (this.mIntent.getBooleanExtra("k_struct_forward", false)) {
      anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005457", "0X8005457", 0, 0, "", "", "android", "");
    }
    if ((this.d.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.d.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.d.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.d.mMsgUrl.startsWith("https://post.mp.qq.com")))
    {
      String str = this.bf.getString("uin");
      kbp.a(null, "", "0X8007235", "0X8007235", 0, 0, this.bKE, "" + this.mShareType, str, "");
    }
  }
  
  protected void dnU()
  {
    AbsStructMsg localAbsStructMsg = anre.a(this.bf);
    if (localAbsStructMsg != null) {
      ((szy)this.app.getBusinessHandler(49)).a().a(this.bf.getString("uin"), localAbsStructMsg);
    }
    this.mActivity.finish();
  }
  
  protected void dnr()
  {
    int i = this.mIntent.getIntExtra("shareQQType", 13);
    if (((i & 0x8) != 0) && (anv())) {
      this.cs.add(U);
    }
    if (((i & 0x4) != 0) && (anw())) {
      this.cs.add(T);
    }
    if (((i & 0x1) != 0) && (anx())) {
      this.cs.add(S);
    }
    if (super.anz()) {
      this.cs.add(aa);
    }
  }
  
  protected void dnv()
  {
    if (QLog.isColorLevel()) {
      QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm");
    }
    anot.a(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
    ccu();
    if (anq())
    {
      doo();
      return;
    }
    if (this.bf.getInt("uintype") == 1)
    {
      localObject1 = this.bf.getString("uin");
      if (((apsw)this.app.getManager(48)).bg((String)localObject1, this.app.getCurrentUin()))
      {
        QQToast.a(this.app.getApp(), 2131699615, 0).show(this.mActivity.getResources().getDimensionPixelSize(2131299627));
        return;
      }
    }
    if (this.mIntent.getBooleanExtra("isWebCompShare", false))
    {
      localObject1 = new Bundle();
      ((Bundle)localObject1).putString("report_type", "102");
      ((Bundle)localObject1).putString("act_type", "82");
      ((Bundle)localObject1).putString("intext_1", "" + artv.b.kK(this.cZW));
      ((Bundle)localObject1).putString("intext_2", "" + artv.b.u(this.bf.getInt("uintype"), this.bf.getString("uin")));
      ((Bundle)localObject1).putString("intext_3", "1");
      arts.a().a((Bundle)localObject1, "", this.app.getCurrentAccountUin(), false);
    }
    if (this.cgQ)
    {
      anot.a(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
      this.cgQ = false;
    }
    if (EU() != 0) {}
    for (Object localObject1 = this.e.getInputValue();; localObject1 = "")
    {
      if ((this.d.mMsgUrl.startsWith("http://article.mp.qq.com")) || (this.d.mMsgUrl.startsWith("https://article.mp.qq.com")) || (this.d.mMsgUrl.startsWith("http://post.mp.qq.com")) || (this.d.mMsgUrl.startsWith("https://post.mp.qq.com")))
      {
        localObject2 = this.bf.getString("uin");
        kbp.a(null, "", "0X8007236", "0X8007236", 0, 0, this.bKE, "" + this.mShareType, (String)localObject2, "");
        kbp.d("0X8007236", "", this.bKE, "" + this.mShareType, (String)localObject2, "");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) || (!"".equals(localObject1))) {
          kbp.a(null, "", "0X8007237", "0X8007237", 0, 0, this.bKE, "" + this.mShareType, (String)localObject2, "");
        }
      }
      this.mIntent.getAction();
      Object localObject2 = Boolean.valueOf(this.mIntent.getBooleanExtra("key_flag_from_plugin", false));
      Object localObject3 = Boolean.valueOf(this.mIntent.getBooleanExtra("k_back", false));
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "ForwardPluginShareStructMsgOption forwardOnConfirm isFromPlugin=" + localObject2 + "iskeyBack=" + localObject3 + "isNOneedJumpToAIO=" + this.cgR);
      }
      Object localObject4;
      int i;
      if (((Boolean)localObject2).booleanValue())
      {
        localObject2 = wja.a(new Intent(this.mActivity, SplashActivity.class), new int[] { 2 });
        this.bf.putString("share_comment_message", (String)localObject1);
        ((Intent)localObject2).putExtras(this.bf);
        aa((Intent)localObject2);
        if (((Boolean)localObject3).booleanValue())
        {
          localObject3 = anre.a(((Intent)localObject2).getExtras());
          if ((this.cZW == 13) && ((localObject3 instanceof StructMsgForGeneralShare)))
          {
            localObject4 = (StructMsgForGeneralShare)localObject3;
            StringBuilder localStringBuilder = new StringBuilder(((Intent)localObject2).getStringExtra("struct_share_key_content_action_DATA"));
            localStringBuilder.append("&msg=").append(((Intent)localObject2).getStringExtra("title")).append("&toUin=").append(this.bf.getString("uin"));
            ((StructMsgForGeneralShare)localObject4).mMsgActionData = localStringBuilder.toString();
          }
          if (((AbsStructMsg)localObject3).mMsgServiceID == 83) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          if ((((AbsStructMsg)localObject3).mMsgServiceID == 108) || (((AbsStructMsg)localObject3).mMsgServiceID == 114) || (((AbsStructMsg)localObject3).mMsgServiceID == 116)) {
            ((AbsStructMsg)localObject3).mMsgActionData = "";
          }
          localObject4 = ForwardUtils.a((Intent)localObject2);
          i = wte.a().we();
          ((AbsStructMsg)localObject3).forwardID = i;
          wte.a().a((SessionInfo)localObject4, (String)localObject1, i);
          aqmf.a(this.app, this.bf.getString("uin"), ((SessionInfo)localObject4).troopUin, this.bf.getInt("uintype"), (AbsStructMsg)localObject3, null);
          if (!TextUtils.isEmpty((CharSequence)localObject1)) {
            jof.a().aaQ = true;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtras(this.bf);
          this.mActivity.setResult(-1, (Intent)localObject1);
          if (!"public_account".equals(this.mPluginName)) {
            break label1470;
          }
          localObject1 = this.bf.getString("pubUin");
          if (localObject1 != null) {
            break label1576;
          }
          localObject1 = "";
        }
      }
      label1576:
      for (;;)
      {
        int j;
        switch (this.bf.getInt("uintype"))
        {
        default: 
          i = -1;
          j = 0;
          label1068:
          if (this.mIntent.getBooleanExtra("k_struct_forward", false))
          {
            if (this.mIntent.getStringExtra("struct_uin") == null) {}
            localObject3 = this.mIntent.getStringExtra("strurt_msgid");
            localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "";
            }
            localObject4 = this.mIntent.getStringExtra("detail_url");
            localObject3 = localObject4;
            if (localObject4 == null) {
              localObject3 = "";
            }
            localObject4 = StructingMsgItemBuilder.pv();
            anot.a(this.app, "P_CliOper", "Pb_account_lifeservice", "", "0X8005456", "0X8005456", 0, 0, (String)localObject4, (String)localObject2, (String)localObject3, "" + i);
          }
          PublicAccountHandler.a(this.app, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_11", "pbshare_success", j);
        }
        for (;;)
        {
          if (this.mIntent.getBooleanExtra("isWebCompShare", false))
          {
            localObject1 = new Bundle();
            ((Bundle)localObject1).putString("report_type", "102");
            ((Bundle)localObject1).putString("act_type", "83");
            ((Bundle)localObject1).putString("intext_1", "" + artv.b.kK(this.cZW));
            ((Bundle)localObject1).putString("intext_2", "" + artv.b.u(this.bf.getInt("uintype"), this.bf.getString("uin")));
            ((Bundle)localObject1).putString("intext_3", "1");
            arts.a().a((Bundle)localObject1, "", this.app.getCurrentAccountUin(), false);
          }
          this.mActivity.finish();
          return;
          if (this.cgR)
          {
            localObject1 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a(this.app, this.mAppContext, (SessionInfo)localObject1, (Intent)localObject2);
            break;
          }
          if (ahiy.ab((Intent)localObject2))
          {
            localObject1 = ForwardUtils.a((Intent)localObject2);
            ForwardUtils.a(this.app, this.mAppContext, (SessionInfo)localObject1, (Intent)localObject2);
          }
          this.mActivity.startActivity((Intent)localObject2);
          break;
          i = 1;
          j = 1001;
          break label1068;
          i = 2;
          j = 1002;
          break label1068;
          i = 3;
          j = 1003;
          break label1068;
          label1470:
          if ("struct_msg_from_h5".equals(this.mPluginName))
          {
            localObject1 = this.bf.getString("pubUin");
            if (!TextUtils.isEmpty((CharSequence)localObject1)) {
              PublicAccountHandler.a(this.app, (String)localObject1, "Pb_account_lifeservice", "mp_msg_sys_31", "share_succ");
            }
          }
          else if (ahiy.ab((Intent)localObject2))
          {
            anot.b(this.app, "CliOper", "", this.bf.getString("uin"), "Music_gene", "Music_gene_send", 0, 1, 0, "", "", "", "");
          }
        }
        dnT();
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahjc
 * JD-Core Version:    0.7.0.1
 */