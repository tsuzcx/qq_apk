import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.LinearLayout.LayoutParams;
import com.dataline.activities.LiteActivity;
import com.tencent.biz.qqstory.storyHome.QQStoryMainActivity;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.activity.aio.ForwardUtils;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ArkAppMessage;
import com.tencent.mobileqq.data.OpenID;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.forward.ForwardSdkShareOption.2;
import com.tencent.mobileqq.forward.ForwardSdkShareOption.3;
import com.tencent.mobileqq.forward.ForwardSdkShareOption.6;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.structmsg.AbsShareMsg;
import com.tencent.mobileqq.structmsg.AbsStructMsg;
import com.tencent.mobileqq.structmsg.StructMsgForAudioShare;
import com.tencent.mobileqq.structmsg.StructMsgForGeneralShare;
import com.tencent.mobileqq.structmsg.StructMsgForImageShare;
import com.tencent.open.agent.AgentActivity;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqprotect.qsec.QSecFramework;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.json.JSONException;
import org.json.JSONObject;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ImageInfo;
import tencent.im.oidb.cmd0xb77.oidb_cmd0xb77.ReqBody;

public class ahkr
  extends ahki
{
  private static final String bKK = acfp.m(2131706502);
  private ahhh.a jdField_a_of_type_Ahhh$a = new ahks(this);
  private ahij jdField_a_of_type_Ahij = new ahij(this.bf);
  protected jqk a;
  @SuppressLint({"HandlerLeak"})
  private Handler cS = new ahky(this);
  private boolean cho;
  private boolean chp;
  private long uy = -1L;
  protected aqju x;
  
  public ahkr(Intent paramIntent)
  {
    super(paramIntent);
    this.jdField_a_of_type_Jqk = new ahla(this);
  }
  
  private void a(long paramLong, String paramString1, String paramString2, int paramInt, String paramString3, boolean paramBoolean)
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "-->handleMessage--appid = ", Long.valueOf(paramLong), ", pkgNmae = ", paramString1 });
    int i = this.bf.getInt("forward_type", -1);
    Intent localIntent = new Intent(this.mActivity, SplashActivity.class);
    localIntent.putExtra("k_from_login", true);
    if (i == 11)
    {
      ForwardUtils.a(this.mActivity, paramString1, localIntent, this.bf.getLong("req_share_id"));
      paramString1 = this.bf.getString("video_url");
      localObject = this.bf.getString("detail_url");
      if ((!TextUtils.isEmpty(paramString1)) && (!TextUtils.isEmpty((CharSequence)localObject)))
      {
        paramString1 = anqx.getDomain((String)localObject);
        if (!TextUtils.isEmpty(paramString1)) {
          anot.a(null, "CliOper", "", "", "0X8005F53", "0X8005F53", 0, 0, anqx.jv(paramInt) + "", "", paramString1, "");
        }
      }
    }
    paramString1 = Long.toString(System.currentTimeMillis());
    Object localObject = anre.a(this.bf);
    if ((localObject != null) && (this.app != null))
    {
      if (!(localObject instanceof StructMsgForImageShare)) {
        break label426;
      }
      if ((!ahlj.anP()) || (i != 11)) {
        break label402;
      }
      localIntent.putExtra("key_share_image_by_server", paramString1);
      paramString3 = ForwardUtils.cx(paramInt);
      String str = ((AbsShareMsg)localObject).mContentTitle;
      anot.a(null, "dc00898", "", "", "0X8009C93", "0X8009C93", 0, 0, "", "4", paramString3, str);
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, new Object[] { "分享大图=0X8009C93, fileType=4 + , toType=", paramString3 });
      ThreadManager.post(new ForwardSdkShareOption.2(this, (AbsStructMsg)localObject, paramString2, paramInt, paramString3, paramString1, str), 8, null, false);
      localIntent.putExtra("stuctmsg_bytes", ((AbsStructMsg)localObject).getBytes());
      if (this.bf.getBoolean("share_from_aio", false)) {
        break label501;
      }
      paramString1 = wja.a(localIntent, new int[] { 2 });
      this.bf.remove("share_from_aio");
    }
    for (;;)
    {
      paramString1.putExtras(this.bf);
      if (paramBoolean) {
        this.mActivity.startActivity(paramString1);
      }
      return;
      label402:
      ThreadManager.post(new ForwardSdkShareOption.3(this, (AbsStructMsg)localObject, paramString2, paramInt), 8, null, false);
      break;
      label426:
      if (i == 11)
      {
        this.bf.putBoolean("share_send_msg_by_server", true);
        localIntent.putExtra("key_b77_sdk_share", paramString1);
        new ahkd().a(this.app, (AbsShareMsg)localObject, this.mActivity, this.bf, paramString1);
        break;
      }
      a((AbsStructMsg)localObject, paramString2, paramInt, paramString3);
      break;
      label501:
      paramString1 = wja.a(localIntent, null);
      paramString1.putExtra("share_from_aio", true);
    }
  }
  
  private void a(Bundle paramBundle, akyf.a parama, String paramString1, String paramString2, String paramString3)
  {
    Object localObject;
    if ((parama.data instanceof int[]))
    {
      int[] arrayOfInt = (int[])parama.data;
      if (arrayOfInt.length == 5)
      {
        localObject = new oidb_cmd0xb77.ImageInfo();
        ((oidb_cmd0xb77.ImageInfo)localObject).md5.set(parama.md5);
        ((oidb_cmd0xb77.ImageInfo)localObject).uuid.set(parama.uuid);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_size.set(arrayOfInt[0]);
        ((oidb_cmd0xb77.ImageInfo)localObject).img_type.set(arrayOfInt[1]);
        ((oidb_cmd0xb77.ImageInfo)localObject).width.set(arrayOfInt[2]);
        ((oidb_cmd0xb77.ImageInfo)localObject).height.set(arrayOfInt[3]);
        ((oidb_cmd0xb77.ImageInfo)localObject).original.set(arrayOfInt[4]);
        ((oidb_cmd0xb77.ImageInfo)localObject).file_id.set((int)parama.groupFileID);
      }
    }
    for (parama = (akyf.a)localObject;; parama = null)
    {
      paramBundle = ahlj.a(paramBundle, null, null, parama);
      parama = BaseApplicationImpl.getApplication().getRuntime();
      if (parama == null)
      {
        QLog.e("ForwardOption.ForwardSdkShareOption", 1, "send runtime = null ");
        ga(bKK, paramString2);
        return;
      }
      localObject = new Bundle();
      this.uy = System.currentTimeMillis();
      ((Bundle)localObject).putLong("0xb77_9_sendTime", this.uy);
      if (QLog.isColorLevel()) {
        QLog.i("ForwardOption.ForwardSdkShareOption", 2, "sendOIDBRequest ");
      }
      ahlw.Kj("KEY_STAGE_2_IMAGE_B77");
      jnm.a(parama, new ahkx(this, paramString2, paramString1, paramString3), paramBundle.toByteArray(), "OidbSvc.0xb77_9", 2935, 9, (Bundle)localObject, 0L);
      return;
    }
  }
  
  private boolean anL()
  {
    this.mShareAppId = this.bf.getLong("req_share_id");
    ahhh localahhh = ((ahlc)this.app.getManager(350)).a();
    if (localahhh.anD())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> isForbid");
      ck(localahhh.wm(), true);
      return true;
    }
    if (localahhh.anE())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> usedCachedAppInfo");
      this.jdField_b_of_type_Ahgf = localahhh.a(this.mShareAppId);
      return false;
    }
    if (localahhh.anC())
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> hasValidAppInfo");
      this.jdField_b_of_type_Ahgf = localahhh.a();
      dox();
      return false;
    }
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "--> waiting d55 back");
    localahhh.a(this.jdField_a_of_type_Ahhh$a);
    am(2131719010);
    return true;
  }
  
  private boolean anM()
  {
    if (this.cZW == 5) {
      return !ahlj.anP();
    }
    return TextUtils.isEmpty(this.bf.getString("image_url_remote"));
  }
  
  private boolean anN()
  {
    return !this.bf.getBoolean("forward_mini_program_ark_from_sdk");
  }
  
  private boolean anO()
  {
    boolean bool = false;
    if (this.mActivity != null) {
      bool = this.mActivity.getSharedPreferences("mobileQQ", 0).getBoolean("favorites_first_share_" + this.app.getAccount(), true);
    }
    return bool;
  }
  
  private void av(long paramLong, String paramString)
  {
    a(paramLong, paramString, this.bf.getString("uin"), this.bf.getInt("uintype"), this.bf.getString("troop_uin"), true);
    ForwardUtils.bz(this.mActivity);
  }
  
  private String c(Bundle paramBundle, String paramString)
  {
    Object localObject = "";
    String str2 = paramBundle.getString("title");
    String str1 = paramBundle.getString("desc");
    paramBundle = (Bundle)localObject;
    if (!TextUtils.isEmpty(str2)) {
      paramBundle = "" + str2;
    }
    localObject = paramBundle;
    if (!TextUtils.isEmpty(str1))
    {
      if (TextUtils.isEmpty(paramBundle)) {
        break label168;
      }
      paramBundle = paramBundle + "\n";
    }
    label168:
    for (localObject = paramBundle + str1; !TextUtils.isEmpty(paramString); localObject = str1)
    {
      paramBundle = paramString;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        paramBundle = (String)localObject + "\n";
        paramBundle = paramBundle + paramString;
      }
      return paramBundle;
    }
    return localObject;
  }
  
  private void checkAccount()
  {
    String str2 = String.valueOf(this.mShareAppId);
    int i = 0;
    label157:
    Object localObject;
    if (!this.chj) {
      if ((!TextUtils.isEmpty(this.apc)) && (!this.apc.equals(this.app.getAccount())))
      {
        if (QLog.isColorLevel()) {
          QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--share uin doesn't equal current uin");
        }
        bFG();
        if ((i != 0) && (this.chp))
        {
          this.bf.putString("uin", String.valueOf("-1010"));
          this.bf.putInt("uintype", -1);
          this.bf.putInt("key_forward_ability_type", V.intValue());
          dnB();
        }
        i = Fb();
        if (this.cZW != 5) {
          break label432;
        }
        jqo.a(this.app, null, "connect_sharepic", "pageview", this.mShareAppId, i, "");
        anpc.a(BaseApplication.getContext()).a(this.app, "sha_pageview", 1, "", "", str2);
        if (this.cZW != 1) {
          break label454;
        }
        localObject = "1";
      }
    }
    for (;;)
    {
      arts.a().a(this.app.getAccount(), this.aMl, str2, "10", "11", "0", (String)localObject, "0", "0", false, true);
      anot.a(this.app, "CliOper", "", "", "0X8005A0F", "0X8005A0F", 0, 0, "1", "", "", "");
      return;
      if (!TextUtils.isEmpty(this.aMl))
      {
        localObject = this.app.a().a(str2);
        if (localObject == null)
        {
          am(2131720190);
          this.bJ = new Handler();
          this.bJ.postDelayed(new ForwardSdkShareOption.6(this), 3000L);
        }
        for (;;)
        {
          try
          {
            long l = Long.parseLong(this.app.getCurrentAccountUin());
            this.app.a().a(l, this.aMl, this.mShareAppId, new ahkz(this));
            i = 0;
          }
          catch (Exception localException)
          {
            i = 0;
            continue;
          }
          if (!this.aMl.equals(localException.openID))
          {
            if (QLog.isColorLevel()) {
              QLog.w("ForwardOption.ForwardSdkShareOption", 2, "-->preForward--openid doesn't equal current local openid");
            }
            bFG();
            i = 0;
          }
          else
          {
            i = 1;
          }
        }
      }
      i = 1;
      break;
      i = 1;
      break;
      label432:
      jqo.a(this.app, null, "pageview", this.mShareAppId, i, "");
      break label157;
      label454:
      String str1;
      if (this.cZW == 2) {
        str1 = "3";
      } else if (this.cZW == 5) {
        str1 = "2";
      } else {
        str1 = "4";
      }
    }
  }
  
  private void doE()
  {
    if (anr())
    {
      String str = this.bf.getString("uin");
      int i = this.bf.getInt("uintype");
      h(str, this.bf.getString("troop_uin"), i);
    }
  }
  
  private void ga(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action_notify_aio_activity");
    localIntent.putExtra("key_share_image_by_server", paramString2);
    this.mActivity.sendBroadcast(localIntent);
    ahic.a().ga(paramString2, paramString1);
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
  
  private int q(ArrayList<String> paramArrayList)
  {
    if (paramArrayList == null) {
      return 1;
    }
    if (paramArrayList.size() > 5)
    {
      if (QLog.isColorLevel()) {
        QLog.e("qqfav", 2, "gotoQfavShareMsg|image type.more than 5");
      }
      return 3;
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = (String)paramArrayList.next();
      if (avjj.K(str, -1L))
      {
        if (QLog.isColorLevel()) {
          QLog.i("qqfav", 2, "gotoQfavShareMsg|image type.picture too big [" + str + "]");
        }
        avjg.a(null, "Net_AddFav", 8, 3, -3);
        return 2;
      }
    }
    return 0;
  }
  
  private String ws()
  {
    List localList = ff();
    if (localList != null) {}
    for (int i = localList.size();; i = 0) {
      return Integer.toString(i);
    }
  }
  
  public int ES()
  {
    if ((this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131721058;
    }
    return super.ES();
  }
  
  public int ET()
  {
    if ((this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return 2131700208;
    }
    return super.ET();
  }
  
  protected int EU()
  {
    int i = this.bf.getInt("key_forward_ability_type");
    if (i == X.intValue()) {
      return 0;
    }
    if (i == V.intValue()) {
      return 1;
    }
    return 2;
  }
  
  protected int EW()
  {
    k = -1;
    l1 = 0L;
    try
    {
      l2 = Long.valueOf(this.app.getAccount()).longValue();
      l1 = l2;
      localObject1 = this.app.getCurrentNickname();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Object localObject2;
        Object localObject3;
        int m;
        localException.printStackTrace();
        String str = "";
        long l2 = l1;
        continue;
        this.bf.getString("qqfav_extra_richmedia_title");
        continue;
        boolean bool = false;
        continue;
        if ((this.d instanceof StructMsgForImageShare))
        {
          gd("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--image share");
          localObject3 = avjj.a((StructMsgForImageShare)this.d);
          m = k;
          ArrayList localArrayList;
          if (localObject3 != null)
          {
            localArrayList = new ArrayList();
            localArrayList.add(((ansu)localObject3).cij);
            m = q(localArrayList);
            if (m == 0) {
              break label367;
            }
          }
          for (;;)
          {
            j = 1;
            i = 3;
            k = m;
            break;
            m = k;
            if (aviz.a(localArrayList, true, this.mIntent.getStringExtra("qqfav_extra_richmedia_title"), this.mIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.mShareAppId, (String)localObject2).a(l2, str).b(this.mActivity, this.app.getAccount(), -1, null)) {
              m = 0;
            }
          }
        }
        if (this.mIntent.getBooleanExtra("qqfav_extra_pic_share", false))
        {
          gd("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--extra pic share");
          j = 8;
          localObject3 = this.bf.getStringArrayList("qqfav_extra_multi_pic_path_list");
          bool = this.mIntent.getBooleanExtra("qqfav_extra_only_pic", true);
          if ((localObject3 == null) || (((ArrayList)localObject3).isEmpty())) {
            break label755;
          }
          i = q((ArrayList)localObject3);
          if (i != 0) {
            k = i;
          }
        }
        for (;;)
        {
          i = j;
          if (bool)
          {
            i = j;
            if (1 == ((ArrayList)localObject3).size()) {
              i = 3;
            }
          }
          for (j = ((ArrayList)localObject3).size();; j = 0)
          {
            break;
            if (!aviz.a((ArrayList)localObject3, bool, this.mIntent.getStringExtra("qqfav_extra_richmedia_title"), this.mIntent.getStringExtra("qqfav_extra_mixed_msg"), true, this.mShareAppId, (String)localObject2).a(l2, str).b(this.mActivity, this.app.getAccount(), -1, null)) {
              break label761;
            }
            k = 0;
            break label512;
            if (this.d != null)
            {
              gd("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--default share");
              i = 2;
              localObject2 = avjj.P(this.d.getXmlBytes());
              m = 0;
              if ((this.d instanceof StructMsgForAudioShare))
              {
                m = 2;
                i = 10;
              }
              j = i;
              if (aviz.a(m, this.d.mContentTitle, this.d.mMsgUrl, this.d.mSourceName, this.d.mContentSummary, this.d.mContentCover, this.d.mContentSrc, (byte[])localObject2, true, this.mShareAppId).a(l2, str).b(this.mActivity, this.app.getAccount(), -1, null))
              {
                k = 0;
                j = 0;
                break;
              }
            }
            m = 0;
            i = j;
            j = m;
            break;
            i = 8;
          }
        }
        int i = -1;
        continue;
        int j = 0;
        i = 1;
      }
    }
    localObject2 = this.bf.getString("app_name");
    j = -1;
    if (this.bf.getBoolean("key_sdk_share_pure_text"))
    {
      gd("ForwardOption.ForwardSdkShareOption", "-->realShareToQfav--pure text share");
      if ((TextUtils.isEmpty(this.bf.getString("qqfav_extra_richmedia_title"))) && (TextUtils.isEmpty(this.bf.getString("qqfav_extra_mixed_msg")))) {
        break label768;
      }
      if (TextUtils.isEmpty(this.bf.getString("qqfav_extra_richmedia_title")))
      {
        this.bf.getString("qqfav_extra_mixed_msg");
        localObject1 = aviz.a(null, false, this.bf.getString("qqfav_extra_richmedia_title"), this.bf.getString("qqfav_extra_mixed_msg"), true, this.mShareAppId, (String)localObject2).a(l2, (String)localObject1);
        localObject2 = this.mActivity;
        localObject3 = this.app.getAccount();
        if (anO()) {
          break label279;
        }
        bool = true;
        if (!((aviz)localObject1).a((Activity)localObject2, (String)localObject3, -1, null, bool)) {
          break label763;
        }
        i = 0;
        j = 0;
        m = 1;
        k = i;
        i = m;
        if (k == 0) {
          avjg.a(this.app, "User_AddFav", i, 0, 69, j, "", "");
        }
        return k;
      }
    }
  }
  
  public int Fb()
  {
    if (this.d != null) {
      return this.d.mMsgServiceID;
    }
    return 0;
  }
  
  public void Kk(String paramString)
  {
    Object localObject = new Intent();
    ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.mShareAppId), "shareToQQ" })));
    ((Intent)localObject).setPackage(this.bf.getString("pkg_name"));
    localObject = PendingIntent.getActivity(this.mActivity, 0, (Intent)localObject, 268435456);
    Intent localIntent = new Intent();
    localIntent.putExtra("activity_finish_run_pendingIntent", (Parcelable)localObject);
    localIntent.putExtra("is_from_share", true);
    localIntent.putExtra("struct_share_key_source_name", this.bf.getString("struct_share_key_source_name"));
    if (ppf.IC())
    {
      localIntent.setClass(this.mActivity, SplashActivity.class);
      localIntent.putExtra("fragment_id", 1);
      localIntent.putExtra("main_tab_id", 6);
      localIntent.putExtra("open_now_tab_fragment", true);
      localIntent.putExtra("extra_from_share", true);
      localIntent.putExtra("new_video_extra_info", paramString);
      localIntent.setFlags(335544320);
      this.mActivity.startActivity(localIntent);
      return;
    }
    localIntent.setClass(this.mActivity, QQStoryMainActivity.class);
    localIntent.putExtra("new_video_extra_info", paramString);
    this.mActivity.startActivity(localIntent);
  }
  
  public void Kp(boolean paramBoolean)
  {
    a(this.mActivity, paramBoolean, "shareToQQ", this.mShareAppId);
  }
  
  public void Pa(int paramInt)
  {
    String str1 = this.bf.getString("detail_url");
    String str3 = this.bf.getString("pkg_name");
    String str4 = this.bf.getString("app_name");
    String str5 = this.bf.getString("audio_url");
    String str6 = this.bf.getString("image_url");
    String str2 = this.bf.getString("image_url_remote");
    Intent localIntent = new Intent(this.mActivity, LiteActivity.class);
    boolean bool1 = this.bf.getBoolean("qqfav_extra_multi_pic");
    Object localObject = this.bf.getString("qqfav_extra_multi_pic_path_list");
    boolean bool2 = this.bf.getBoolean("qdshare_file");
    if (paramInt == ab.intValue())
    {
      localIntent.putExtra("targetUin", acbn.bkx);
      localIntent.putExtra("device_type", 1);
      if (!(this.mActivity instanceof LiteActivity)) {
        break label834;
      }
      switch (this.bf.getInt("req_type"))
      {
      case 3: 
      case 4: 
      default: 
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", acfp.m(2131706504));
      }
    }
    for (;;)
    {
      localObject = new Bundle(this.bf);
      ((Bundle)localObject).putBoolean("isBack2Root", false);
      ((Bundle)localObject).putBoolean("is_share_flag", true);
      ((Bundle)localObject).putLong("res_share_id", aqgb.W(this.mShareAppId));
      ((Bundle)localObject).putString("res_pkg_name", str3);
      ((Bundle)localObject).putString("res_detail_url", str1);
      ((Bundle)localObject).putString("app_name", str4);
      ((Bundle)localObject).putString("image_url_remote", str2);
      ((Bundle)localObject).putString("image_url", str6);
      if (!TextUtils.isEmpty(str5)) {
        ((Bundle)localObject).putString("audio_url", str5);
      }
      a(localIntent, (Bundle)localObject, str3);
      return;
      localIntent.putExtra("targetUin", acbn.bkw);
      localIntent.putExtra("device_type", 0);
      break;
      if (bool2)
      {
        localIntent.putExtra("dataline_forward_type", 100);
        if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject))) {
          localIntent.putExtra("dataline_forward_path", (String)localObject);
        } else {
          localIntent.putExtra("dataline_forward_path", str6);
        }
      }
      else
      {
        localObject = c(this.bf, "");
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject);
        anot.a(this.app, "CliOper", "", "", "0X8004931", "0X8004931", 0, 0, "", "", "", "");
        gd("qqdataline", "shareFromMigSdk|report send text:0X8004931.");
        continue;
        localIntent.putExtra("dataline_forward_type", 101);
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 1 filePath: " + str6);
        localIntent.putExtra("dataline_forward_path", str6);
        continue;
        localObject = c(this.bf, str5);
        localIntent.putExtra("dataline_forward_type", 102);
        localIntent.putExtra("dataline_forward_text", (String)localObject);
        anot.a(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
        gd("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
        continue;
        if (bool1)
        {
          localIntent.putExtra("dataline_forward_type", 101);
          if ((localObject != null) && (!TextUtils.isEmpty((CharSequence)localObject)))
          {
            localIntent.putExtra("dataline_forward_path", (String)localObject);
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 2 filePath: " + (String)localObject);
          }
          else
          {
            localIntent.putExtra("dataline_forward_path", str6);
            QLog.d("ForwardOption.ForwardSdkShareOption", 1, "forwardToDataline 3 filePath: " + str6);
          }
        }
        else
        {
          localObject = c(this.bf, str1);
          localIntent.putExtra("dataline_forward_type", 102);
          localIntent.putExtra("dataline_forward_text", (String)localObject);
          anot.a(this.app, "CliOper", "", "", "0X800492E", "0X800492E", 0, 0, "", "", "", "");
          gd("qqdataline", "shareFromMigSdk|report send link:0X800492E.");
          continue;
          label834:
          if (this.bf.getInt("req_type") != 5) {
            break label873;
          }
          localIntent.putExtra("dataline_forward_type", 101);
          localIntent.putExtra("dataline_forward_path", str6);
        }
      }
    }
    label873:
    if (TextUtils.isEmpty(str1))
    {
      if (jqc.isValidUrl(str2)) {
        break label929;
      }
      localObject = acfp.m(2131706496);
    }
    for (;;)
    {
      localIntent.putExtra("dataline_forward_type", 102);
      localIntent.putExtra("dataline_forward_text", (String)localObject);
      break;
      localObject = str1;
      continue;
      label929:
      localObject = str2;
    }
  }
  
  protected void Pc(int paramInt)
  {
    boolean bool = false;
    if ((!this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) && (!this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      super.Pc(paramInt);
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->showQfavResultDialog--ret = " + paramInt);
      }
      Object localObject;
      String str;
      if (paramInt == 0)
      {
        localObject = this.mActivity.getSharedPreferences("mobileQQ", 0);
        str = "favorites_first_share_" + this.app.getAccount();
        bool = ((SharedPreferences)localObject).getBoolean(str, true);
        if (!bool) {
          avjj.z(this.mActivity, 2131700282, 2);
        }
      }
      while (!bool)
      {
        a(this.mActivity, true, "addToQQFavorites", this.mShareAppId);
        return;
        ((SharedPreferences)localObject).edit().putBoolean(str, false).commit();
        localObject = this.mActivity.getString(2131700281);
        str = this.bf.getString("app_name");
        StringBuilder localStringBuilder = new StringBuilder().append((String)localObject);
        localObject = str;
        if (TextUtils.isEmpty(str)) {
          localObject = this.mActivity.getString(2131700273);
        }
        localObject = (String)localObject;
        localObject = aqha.a(this.mActivity, 230, this.mActivity.getResources().getString(2131720179), this.mActivity.getResources().getString(2131700275), (String)localObject, this.mActivity.getResources().getString(2131696652), new ahkt(this), new ahku(this));
        ((aqju)localObject).setOnDismissListener(new ahkv(this));
        if (!this.mActivity.isFinishing())
        {
          this.jdField_e_of_type_Aqju.setOnDismissListener(null);
          ((aqju)localObject).show();
          continue;
          if (2 == paramInt) {
            avjj.z(this.mActivity, 2131696989, 1);
          } else if (3 == paramInt) {
            avjj.z(this.mActivity, 2131700280, 1);
          } else {
            avjj.z(this.mActivity, 2131700274, 1);
          }
        }
      }
    }
  }
  
  public void a(Intent paramIntent, Bundle paramBundle, String paramString)
  {
    Object localObject;
    if (this.jdField_b_of_type_Ahgf != null)
    {
      if (this.jdField_b_of_type_Ahgf.getSourceUrl() == null)
      {
        localObject = "";
        paramBundle.putString("struct_share_key_source_url", (String)localObject);
        if (this.jdField_b_of_type_Ahgf.wk() != null) {
          break label301;
        }
        localObject = "";
        label44:
        paramBundle.putString("struct_share_key_source_icon", (String)localObject);
        if (this.jdField_b_of_type_Ahgf.getAppName() != null) {
          break label313;
        }
        localObject = "";
        label67:
        paramBundle.putString("struct_share_key_source_name", (String)localObject);
        if (this.jdField_b_of_type_Ahgf.getPkgName() != null) {
          break label325;
        }
        localObject = "";
        label90:
        paramBundle.putString("struct_share_key_source_a_action_data", (String)localObject);
      }
    }
    else
    {
      localObject = new Intent();
      ((Intent)localObject).setData(Uri.parse(String.format("tencent%1$d://tauth.qq.com/?#action=%2$s&result=complete&response={\"ret\":0}", new Object[] { Long.valueOf(this.mShareAppId), "shareToQQ" })));
      ((Intent)localObject).setPackage(paramString);
      paramIntent.putExtra("activity_finish_run_pendingIntent", PendingIntent.getActivity(this.mActivity, 0, (Intent)localObject, 268435456));
      if (((this.mActivity instanceof IphoneTitleBarActivity)) && (!(this.mActivity instanceof LiteActivity))) {
        ((IphoneTitleBarActivity)this.mActivity).setTitle(null);
      }
      paramIntent.setFlags(67108864);
      paramIntent.addFlags(268435456);
      if (!(this.mActivity instanceof LiteActivity)) {
        break label337;
      }
      paramBundle.putBoolean("MigSdkShareNotDone", false);
      paramBundle.putBoolean("isMigSdkShare", true);
      paramString = (LiteActivity)this.mActivity;
      paramIntent.putExtras(paramBundle);
      paramString.l(paramIntent);
    }
    for (;;)
    {
      paramIntent = this.bf.getString("uin");
      if (!TextUtils.isEmpty(paramIntent)) {
        a(paramBundle, paramIntent, null);
      }
      return;
      localObject = this.jdField_b_of_type_Ahgf.getSourceUrl();
      break;
      label301:
      localObject = this.jdField_b_of_type_Ahgf.wk();
      break label44;
      label313:
      localObject = this.jdField_b_of_type_Ahgf.getAppName();
      break label67;
      label325:
      localObject = this.jdField_b_of_type_Ahgf.getPkgName();
      break label90;
      label337:
      paramIntent.putExtras(paramBundle);
      this.mActivity.startActivity(paramIntent);
      P(0, "", "");
    }
  }
  
  protected boolean a(aqju paramaqju)
  {
    Object localObject;
    if (this.d == null)
    {
      if (!(this.mActivity instanceof LiteActivity)) {
        doy();
      }
      localObject = new Bundle(this.bf);
      String str = this.bf.getString("image_url");
      if (!TextUtils.isEmpty(str)) {
        ((Bundle)localObject).putString("image_url_remote", str);
      }
      localObject = anre.a((Bundle)localObject);
      if (!AbsShareMsg.class.isInstance(localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkShareOption", 2, "-->preloadData--structMsg is not an instance of AbsShareMsg");
        }
        P(-1, acfp.m(2131706499), acfp.m(2131706526));
      }
    }
    try
    {
      aryb.a().b(1, "SHARE_CHECK_AGENT", this.app.getCurrentAccountUin(), String.valueOf(this.mShareAppId), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, "类型错误");
      label144:
      return false;
      this.d = ((AbsShareMsg)localObject);
      boolean bool = h(this.d);
      if (!this.bf.getBoolean("key_sdk_share_pure_text"))
      {
        localObject = new LinearLayout.LayoutParams(-1, -2);
        if (!(this.d instanceof StructMsgForGeneralShare)) {
          break label399;
        }
        if (bool) {
          break label356;
        }
        ((LinearLayout.LayoutParams)localObject).setMargins(wja.dp2px(-15.0F, this.mActivity.getResources()), 0, wja.dp2px(-15.0F, this.mActivity.getResources()), wja.dp2px(5.0F, this.mActivity.getResources()));
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "updateImageView addStructView");
        }
        this.jdField_a_of_type_Ahki$b = new ahki.b(this, this.mActivity);
        if (((this.bf.getBoolean("is_ark_display_share")) && (this.bf.getBoolean("forward_ark_from_sdk"))) || (this.bf.getBoolean("forward_mini_program_ark_from_sdk"))) {
          break label489;
        }
        paramaqju.addView(this.jdField_a_of_type_Ahki$b.ce(), (LinearLayout.LayoutParams)localObject);
        if ((!(this.d instanceof StructMsgForImageShare)) && (!bool)) {
          b(this.d.mSourceName, paramaqju);
        }
      }
      for (;;)
      {
        return true;
        label356:
        ((LinearLayout.LayoutParams)localObject).setMargins(0, 0, 0, 0);
        if ((this.bf.getBoolean("is_ark_display_share")) && (this.bf.getBoolean("forward_ark_from_sdk"))) {
          break;
        }
        paramaqju.adjustMessageTopBottomMargin(0.0F, 0.0F);
        break;
        label399:
        if ((this.d instanceof StructMsgForAudioShare))
        {
          ((LinearLayout.LayoutParams)localObject).setMargins(0, wja.dp2px(5.0F, this.mActivity.getResources()), 0, wja.dp2px(10.0F, this.mActivity.getResources()));
          break;
        }
        if (!(this.d instanceof StructMsgForImageShare)) {
          break;
        }
        ((LinearLayout.LayoutParams)localObject).setMargins(wja.dp2px(-10.0F, this.mActivity.getResources()), 0, wja.dp2px(-7.5F, this.mActivity.getResources()), 0);
        break;
        label489:
        if (this.bf.getInt("req_type") == 5)
        {
          paramaqju.addView(this.jdField_a_of_type_Ahki$b.ce(), (LinearLayout.LayoutParams)localObject);
          if ((!(this.d instanceof StructMsgForImageShare)) && (!bool)) {
            b(this.d.mSourceName, paramaqju);
          }
        }
      }
    }
    catch (Exception paramaqju)
    {
      break label144;
    }
  }
  
  protected boolean a(AbsStructMsg paramAbsStructMsg, String paramString1, int paramInt, String paramString2)
  {
    SessionInfo localSessionInfo = new SessionInfo();
    localSessionInfo.cZ = paramInt;
    localSessionInfo.aTl = paramString1;
    localSessionInfo.troopUin = paramString2;
    if ((localSessionInfo.cZ < 0) || (TextUtils.isEmpty(localSessionInfo.aTl)))
    {
      if (this.bf.getBoolean("forward_ark_app_direct")) {
        arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
      }
      return false;
    }
    paramString1 = this.bf.getString("forward_ark_app_name");
    paramString2 = this.bf.getString("forward_ark_app_view");
    Object localObject1 = this.bf.getString("forward_ark_app_desc");
    Object localObject2 = this.bf.getString("forward_ark_app_ver");
    String str1 = this.bf.getString("forward_ark_app_prompt");
    String str2 = this.bf.getString("forward_ark_app_meta");
    String str3 = this.bf.getString("forward_ark_app_config");
    String str4 = this.bf.getString("forward_ark_app_compat");
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      if (this.bf.getBoolean("forward_ark_app_direct")) {
        arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "1", false, true);
      }
      return false;
    }
    if (this.bf.getBoolean("forward_ark_app_direct")) {
      arts.a().a(this.app.getCurrentAccountUin(), "", "0", "2000", "2006", "0", false, true);
    }
    localObject1 = new ArkAppMessage(str1, paramString1, (String)localObject1, paramString2, (String)localObject2, str2, str3, str4);
    paramString1 = (ArkAppMessage)adqq.a(2, paramString1, this.bf, localObject1);
    if (paramString1 == null) {
      paramString1 = (String)localObject1;
    }
    for (;;)
    {
      paramString2 = this.bf.getString("forward_appId_ark_from_sdk");
      localObject2 = this.bf.getString("struct_share_key_source_name");
      str1 = this.bf.getString("struct_share_key_source_action_data");
      str2 = this.bf.getString("struct_share_key_source_a_action_data");
      str3 = this.bf.getString("struct_share_key_source_url");
      if (!TextUtils.isEmpty(paramString2))
      {
        paramString1.appId = paramString2;
        paramString1.mSourceName = ((String)localObject2);
        paramString1.mSourceActionData = str1;
        paramString1.mSource_A_ActionData = str2;
        paramString1.mSourceUrl = str3;
      }
      if (paramAbsStructMsg != null) {
        switch (localSessionInfo.cZ)
        {
        }
      }
      for (paramString2 = this.app.getCurrentAccountUin();; paramString2 = localSessionInfo.troopUin)
      {
        localObject2 = this.app;
        str1 = this.app.getCurrentAccountUin();
        str2 = localSessionInfo.aTl;
        paramInt = localSessionInfo.cZ;
        int i = amzo.seq;
        amzo.seq = i + 1;
        paramString1.containStructMsg = anbi.a((QQAppInterface)localObject2, str1, str2, paramString2, paramInt, i, paramAbsStructMsg);
        if ((!TextUtils.isEmpty(((ArkAppMessage)localObject1).appName)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).appView)) && (!TextUtils.isEmpty(((ArkAppMessage)localObject1).metaList))) {
          adqu.a(this.app, ((ArkAppMessage)localObject1).appName, "AIOArkSdkSendMessage", 1, 0, 0L, 0L, 0L, ((ArkAppMessage)localObject1).appView, "");
        }
        ujt.a(this.app, localSessionInfo, paramString1);
        return true;
      }
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
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      RecentUser localRecentUser = (RecentUser)paramList.next();
      if ((localRecentUser != null) && (!aqft.ri(localRecentUser.uin)) && (localRecentUser.getType() != 1020) && (localRecentUser.getType() != 1008) && (localRecentUser.getType() != 1005) && (localRecentUser.getType() != 1009) && (localRecentUser.getType() != 1021) && (localRecentUser.getType() != 1001) && (localRecentUser.getType() != 10002) && (localRecentUser.getType() != 10004) && (localRecentUser.getType() != 1022) && (localRecentUser.getType() != 7000) && (localRecentUser.getType() != 6004) && ((localRecentUser.getType() != 1) || (!kj(localRecentUser.uin))) && ((localRecentUser.getType() != 1006) || (e(ahgg.a.Y))) && (localRecentUser.getType() != 9501) && (localRecentUser.getType() != 8001) && ((localRecentUser.getType() != 0) || (!jqs.d(this.app, localRecentUser.uin, localRecentUser.getType()))) && (((localRecentUser.getType() != 1004) && (localRecentUser.getType() != 1000)) || (this.cgP))) {
        localArrayList.add(localRecentUser);
      }
    }
    return localArrayList;
  }
  
  protected boolean anK()
  {
    for (;;)
    {
      synchronized (dZ)
      {
        if (this.chl)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, checkAppinfoLocked, getappinfo already executing...");
          }
          try
          {
            dZ.wait(20000L);
            if ((this.jdField_b_of_type_Ahgf == null) && (QLog.isColorLevel())) {
              QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, response is null.");
            }
            return true;
          }
          catch (InterruptedException localInterruptedException1)
          {
            if (!QLog.isColorLevel()) {
              continue;
            }
            QLog.e("ForwardOption.ForwardSdkShareOption", 2, "check app info locked ex", localInterruptedException1);
            continue;
          }
        }
      }
      if (this.jdField_b_of_type_Ahgf == null)
      {
        this.chl = true;
        long l = System.currentTimeMillis() / 1000L;
        String str1 = this.bf.getString("pkg_name");
        String str2 = AgentActivity.q(this.mActivity, str1, l + "");
        if (QLog.isColorLevel()) {
          QLog.d("ForwardOption.ForwardSdkShareOption", 2, "-->sdk_share, checkAppinfoLocked, sign: " + str2 + ", appinfo is null.");
        }
        ahlw.Kj("KEY_GET_APP_INFO");
        svi.a(this.app, this.mActivity, this.app.getCurrentAccountUin(), this.mShareAppId, str2, l, this.jdField_e_of_type_MqqObserverBusinessObserver, str1);
        try
        {
          dZ.wait(20000L);
        }
        catch (InterruptedException localInterruptedException2) {}
        if (QLog.isColorLevel()) {
          QLog.e("ForwardOption.ForwardSdkShareOption", 2, "check app info locked ex", localInterruptedException2);
        }
      }
    }
  }
  
  public boolean anj()
  {
    if ((this.bf.getBoolean("enable_d55", false)) && (anL())) {
      return false;
    }
    boolean bool2 = super.anj();
    this.cho = this.mIntent.getBooleanExtra("k_qzone", false);
    boolean bool1;
    if ((this.cho) && (this.mIntent.getBooleanExtra("k_send", true))) {
      bool1 = true;
    }
    for (;;)
    {
      this.chp = bool1;
      if (anM())
      {
        doz();
        if (bool2) {
          aryb.a().b(0, "SHARE_CHECK_AGENT", this.app.getCurrentAccountUin(), String.valueOf(this.mShareAppId), null, Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
        }
      }
      try
      {
        this.bf.putInt("emoInputType", 1);
        checkAccount();
        x("KEY_STAGE_1_TOTAL", true);
        return bool2;
        bool1 = false;
        continue;
        QLog.d("ForwardOption.ForwardSdkShareOption", 1, "preloadData skip getQQAccountSkey");
      }
      catch (ArrayIndexOutOfBoundsException localArrayIndexOutOfBoundsException)
      {
        for (;;)
        {
          QLog.e("ForwardOption.ForwardSdkShareOption", 1, "preloadData mExtraData.putInt error : ", localArrayIndexOutOfBoundsException);
        }
      }
    }
  }
  
  protected boolean anl()
  {
    int j = this.bf.getInt("uintype");
    String str3 = this.bf.getString("uin");
    doA();
    int i;
    switch (j)
    {
    default: 
      i = 1;
    }
    try
    {
      aryb.a().b(0, "SHARE_TO_QQ", this.app.getCurrentAccountUin(), String.valueOf(this.mShareAppId), String.valueOf(i), Long.valueOf(SystemClock.elapsedRealtime()), 0, 1, null);
      label103:
      String str1;
      label115:
      String str2;
      label129:
      String str4;
      if (this.cZW == 1)
      {
        str1 = "1";
        str2 = "1";
        if (j != 0) {
          break label365;
        }
        str2 = "1";
        arts.a().a(this.app.getAccount(), "", this.mShareAppId + "", "10", "12", "0", str1, str3, str2, false, true);
        if ((QSecFramework.a().c(1003).booleanValue()) && (this.isSdkShare))
        {
          i = this.bf.getInt("uintype");
          str1 = this.bf.getString("uin");
          str2 = this.bf.getString("pkg_name");
          str3 = this.bf.getString("detail_url");
          str4 = this.bf.getString("image_url");
          if ((!TextUtils.isEmpty(str2)) && (!arnv.a().aGW())) {
            arnv.a().j(null, str2);
          }
          if (this.cZW != 1) {
            break label393;
          }
          arnv.a().n(2, str3, i, str1);
        }
      }
      for (;;)
      {
        arnv.a().report();
        return true;
        i = 1;
        break;
        i = 2;
        break;
        i = 3;
        break;
        if (this.cZW == 2)
        {
          str1 = "3";
          break label115;
        }
        if (this.cZW == 5)
        {
          str1 = "2";
          break label115;
        }
        str1 = "4";
        break label115;
        label365:
        if (1 == j)
        {
          str2 = "2";
          break label129;
        }
        if (3000 != j) {
          break label129;
        }
        str2 = "3";
        break label129;
        label393:
        if (this.cZW == 5) {
          arnv.a().n(3, str4, i, str1);
        }
      }
    }
    catch (Exception localException)
    {
      break label103;
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
  
  public boolean ant()
  {
    return false;
  }
  
  protected boolean any()
  {
    return this.cho;
  }
  
  public void b(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    super.b(paramQQAppInterface, paramActivity);
    this.jdField_a_of_type_Ahij.b(paramQQAppInterface, paramActivity);
  }
  
  protected void bFG()
  {
    QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm");
    anpc.a(BaseApplication.getContext()).a(this.app, this.app.getAccount(), "", "multi_account", "push_login_window", 0, 1, 0);
    if (this.x != null)
    {
      if (!this.x.isShowing()) {
        this.x.show();
      }
      return;
    }
    if ((this.mActivity == null) || (this.mActivity.isFinishing()))
    {
      QLog.d("ForwardOption.ForwardSdkShareOption", 1, "showAccountConfirm-->(mActivity == null || mActivity.isFinishing())");
      return;
    }
    this.x = aqha.a(this.mActivity, 230);
    this.x.setMessage(2131697425);
    this.x.setTitle(2131693317);
    ahlb localahlb = new ahlb(this);
    this.x.setNegativeButton(2131721058, localahlb);
    this.x.setPositiveButton(2131720034, localahlb);
    this.x.show();
  }
  
  public void cph()
  {
    super.cph();
    if (anq()) {
      ForwardUtils.a(this.app, "0X800A734", new String[] { ws() });
    }
  }
  
  protected void dnO()
  {
    super.dnO();
    String str1 = this.bf.getString("shareArkInfo");
    if (!TextUtils.isEmpty(str1)) {}
    try
    {
      Object localObject = new JSONObject(str1);
      str1 = ((JSONObject)localObject).optString("app");
      String str2 = ((JSONObject)localObject).optString("view");
      localObject = ((JSONObject)localObject).optString("meta");
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty((CharSequence)localObject))) {
        adqu.a(this.app, str1, "AIOArkSdkSendClosed", 1, 0, 0L, 0L, 0L, str2, "");
      }
      label95:
      if (anq()) {
        ForwardUtils.a(this.app, "0X800A736", new String[] { ws() });
      }
      anot.a(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
      if (this.mIntent.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        anot.a(this.app, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "2", "", "", "");
      }
      if ((this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
        a(this.mActivity, false, "addToQQFavorites", this.mShareAppId);
      }
      do
      {
        return;
        super.dnO();
      } while ((!(this.mActivity instanceof LiteActivity)) || (this.mShareAppId == 0L));
      a(this.mActivity, false, "sendToMyComputer", this.mShareAppId);
      return;
    }
    catch (JSONException localJSONException)
    {
      break label95;
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
  
  public void dnV()
  {
    rnq localrnq = rnq.a();
    Bundle localBundle = new Bundle();
    localBundle.putInt("entrance_type", 107);
    String str1 = this.bf.getString("detail_url");
    String str2 = this.bf.getString("title");
    String str3 = this.bf.getString("desc");
    String str4 = this.bf.getString("struct_share_key_source_name");
    String str5 = this.bf.getString("struct_share_key_source_icon");
    String str6 = this.bf.getString("image_url_remote");
    localBundle.putString("share_url_target_url", str1);
    if (!TextUtils.isEmpty(str2)) {
      localBundle.putString("share_url_name", str2);
    }
    if (!TextUtils.isEmpty(str3)) {
      localBundle.putString("share_url_text", str3);
    }
    if ((!TextUtils.isEmpty(str6)) && (3 == this.bf.getByte("struct_share_key_image_url_status", (byte)4).byteValue())) {
      localBundle.putString("share_url_thumb_url", str6);
    }
    if (!TextUtils.isEmpty(str4)) {
      localBundle.putString("struct_share_key_source_name", str4);
    }
    if (!TextUtils.isEmpty(str5)) {
      localBundle.putString("struct_share_key_source_icon", str5);
    }
    localBundle.putInt("capture_intent_mode", 4);
    localBundle.putString("text_filter_default_screen_touch_tips", acfp.m(2131706515));
    localrnq.a(this.mActivity, localBundle, 20004);
    this.mActivity.overridePendingTransition(2130772306, 2130772079);
    rar.a("share", "clk_videoclips", 0, 0, new String[0]);
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
    if (anu()) {
      this.cs.add(Y);
    }
    if (any()) {
      this.cs.add(V);
    }
    if (anN())
    {
      this.cs.add(W);
      this.cs.add(ab);
    }
    dnA();
    if (super.anz()) {
      this.cs.add(aa);
    }
    if (!TextUtils.isEmpty(this.bf.getString("detail_url"))) {
      this.cs.add(ad);
    }
  }
  
  public void dnt() {}
  
  protected void dnv()
  {
    ccu();
    ahlw.Kj("KEY_STAGE_2_TOTAL");
    long l = this.bf.getLong("req_share_id");
    String str = this.bf.getString("pkg_name");
    Object localObject1 = this.bf.getString("detail_url");
    this.bf.putBoolean("isBack2Root", false);
    this.bf.putLong("res_share_id", l);
    this.bf.putString("res_pkg_name", str);
    Object localObject2 = this.jdField_e_of_type_Aqju.getInputValue();
    this.bf.putString("share_comment_message_for_server", (String)localObject2);
    this.bf.putString("share_msg_input_value", (String)localObject2);
    this.bf.putString("res_detail_url", (String)localObject1);
    boolean bool = anre.a(this.bf) instanceof StructMsgForImageShare;
    if (bool)
    {
      this.bf.putString("share_comment_message", this.jdField_e_of_type_Aqju.getInputValue());
      this.mIntent.putExtra("req_type", 147);
    }
    int i;
    label244:
    int j;
    if (anq()) {
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = "2";
        ForwardUtils.a(this.app, "0X800A735", new String[] { ws(), localObject1 });
        if (this.bf.getInt("forward_type", -1) != 11) {
          break label351;
        }
        if ((!bool) || (!ahlj.anP())) {
          break label323;
        }
        i = 1;
        if (bool) {
          break label328;
        }
        j = 1;
        label251:
        if ((i == 0) && (j == 0)) {
          break label333;
        }
        this.jdField_a_of_type_Ahij.kR(fg());
      }
    }
    for (;;)
    {
      if (this.mIntent.getBooleanExtra("forward_mini_program_ark_from_sdk", false)) {
        anot.a(this.app, "dc00898", "", "", "0X8009F7B", "0X8009F7B", 0, 0, "1", "", "", "");
      }
      return;
      localObject1 = "1";
      break;
      label323:
      i = 0;
      break label244;
      label328:
      j = 0;
      break label251;
      label333:
      this.bKL = this.jdField_e_of_type_Aqju.getInputValue();
      super.dnv();
      continue;
      label351:
      if (this.bf.getBoolean("forward_ark_from_sdk"))
      {
        localObject1 = this.bf.getParcelableArrayList("forward_multi_target").iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ResultRecord)((Iterator)localObject1).next();
          if (anr()) {
            h(((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).QD, ((ResultRecord)localObject2).lk());
          }
          a(l, str, ((ResultRecord)localObject2).uin, ((ResultRecord)localObject2).lk(), ((ResultRecord)localObject2).QD, false);
        }
      }
      else
      {
        this.bKL = this.jdField_e_of_type_Aqju.getInputValue();
        super.dnv();
        continue;
        if (this.bf.getBoolean("forward_ark_from_sdk"))
        {
          doE();
          av(l, str);
        }
        else
        {
          anot.a(this.app, "dc00898", "", "", "0X8007C3A", "0X8007C3A", 0, 0, "2", "", "", "");
          if (this.cgQ)
          {
            anot.a(this.app, "CliOper", "", "", "0X8005793", "0X8005793", 0, 0, "", "", "", "");
            this.cgQ = false;
          }
          this.bKL = this.jdField_e_of_type_Aqju.getInputValue();
          super.dnT();
          if (this.bf.getBoolean("forward_mini_program_ark_from_sdk")) {
            doE();
          }
          localObject1 = new Bundle();
          ((Bundle)localObject1).putString("report_type", "102");
          ((Bundle)localObject1).putString("act_type", "82");
          ((Bundle)localObject1).putString("intext_1", "" + artv.b.kK(this.cZW));
          ((Bundle)localObject1).putString("intext_2", "" + artv.b.u(this.bf.getInt("uintype"), this.bf.getString("uin")));
          ((Bundle)localObject1).putString("intext_3", "0");
          arts.a().a((Bundle)localObject1, "", this.app.getCurrentAccountUin(), false, true);
        }
      }
    }
  }
  
  void doC()
  {
    super.doC();
    if ((anq()) && (this.isSdkShare)) {
      ForwardUtils.bz(this.mActivity);
    }
  }
  
  public void dol()
  {
    QQAppInterface localQQAppInterface;
    if ((anq()) && (this.isSdkShare))
    {
      localQQAppInterface = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
      if (fg() != null) {
        break label52;
      }
    }
    label52:
    for (int i = 0;; i = fg().size())
    {
      ForwardUtils.a(localQQAppInterface, "0X800A739", new String[] { Integer.toString(i) });
      return;
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    this.app.removeObserver(this.jdField_a_of_type_Jqk);
    if ((this.jdField_b_of_type_Swh != null) && (this.jdField_b_of_type_Swh.isShowing())) {
      this.jdField_b_of_type_Swh.dismiss();
    }
    if ((this.c != null) && (this.c.isShowing())) {
      this.c.dismiss();
    }
    if (this.bJ != null) {
      this.bJ.removeCallbacksAndMessages(null);
    }
    if (this.cS != null)
    {
      this.cS.removeMessages(0);
      this.cS = null;
    }
  }
  
  public String wn()
  {
    String str2 = this.bKu;
    String str1 = str2;
    if (!TextUtils.isEmpty(str2))
    {
      str1 = str2;
      if (jqn.j(str2, "UTF-8") > 105) {
        str1 = jqn.a(str2, 105, "UTF-8", "...");
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("ForwardOption.ForwardSdkShareOption", 2, "DialogContent:mForwardText=" + str1);
    }
    return str1;
  }
  
  public String wo()
  {
    if ((this.mIntent.getBooleanExtra("qqfav_extra_from_sdk_share", false)) || (this.mIntent.getBooleanExtra("qqfav_extra_from_system_share", false))) {
      return this.mActivity.getResources().getString(2131700191);
    }
    if (this.mShareAppId == 55901189L) {
      return null;
    }
    return super.wo();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahkr
 * JD-Core Version:    0.7.0.1
 */