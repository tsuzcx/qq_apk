import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.qqstory.network.pb.qqstory_service.ReqSetConfig;
import com.tencent.biz.qqstory.network.pb.qqstory_struct.UserConfig;
import com.tencent.biz.qqstory.settings.QQStoryFriendSettings;
import com.tencent.biz.qqstory.settings.QQStoryShieldListActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class qoo
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, ppe, ppi<QQStoryFriendSettings>
{
  protected QQStoryFriendSettings a;
  protected pmd c = new qop(this);
  protected int mFrom;
  protected View[] p;
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.a, 2131561760, null);
    ((TextView)localView.findViewById(2131379769)).setText(paramString);
    ((TextView)localView.findViewById(2131369154)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.a, 2131561763, null);
    this.p[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131369545);
    ((FormSwitchItem)localObject).getTextView().setTextSize(1, 18.0F);
    ((FormSwitchItem)localObject).setText(paramString);
    ((FormSwitchItem)localObject).setContentDescription(paramString);
    ((FormSwitchItem)localObject).setBgType(paramInt2);
    localObject = ((FormSwitchItem)localObject).a();
    ((Switch)localObject).setTag(Integer.valueOf(paramInt1));
    ((Switch)localObject).setOnCheckedChangeListener(null);
    ((Switch)localObject).setChecked(paramBoolean);
    ((Switch)localObject).setOnCheckedChangeListener(this);
    ((Switch)localObject).setContentDescription(paramString);
    ((TextView)localView.findViewById(2131369251)).setVisibility(8);
    return localView;
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.c);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.a = paramQQStoryFriendSettings;
    this.mFrom = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.a);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838901);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, wja.dp2px(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.p = new View[9];
    localLinearLayout.addView(a(0, acfp.m(2131712250) + plr.asZ, 2130839701));
    localLinearLayout.addView(a(1, acfp.m(2131712282) + plr.asZ, 2130839689));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561775, null));
    paramBundle = (pmb)paramQQStoryFriendSettings.app.getManager(181);
    localLinearLayout.addView(a(2, acfp.m(2131712280), 1, paramBundle.Ij()));
    localLinearLayout.addView(a(3, acfp.m(2131712277) + plr.asZ + acfp.m(2131712266), 2, paramBundle.Ik()));
    if (paramBundle.Im())
    {
      int i = paramBundle.sm();
      localLinearLayout.addView(a(5, String.format(acfp.m(2131712260), new Object[] { Integer.valueOf(i), acfp.m(2131712281) }), 2, paramBundle.Il()));
      rar.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (psr)psx.a(10);
    boolean bool1 = ((Boolean)paramBundle.c("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.c("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    ram.w("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.a, 2131561775, null));
      localLinearLayout.addView(a(7, acfp.m(2131712278) + plr.asY, 0, bool2));
    }
    paramBundle = (puz)paramQQStoryFriendSettings.app.getManager(252);
    if ((paramBundle.aBU) && (paramBundle.aBV))
    {
      localLinearLayout.addView(View.inflate(this.a, 2131561775, null));
      localLinearLayout.addView(a(8, acfp.m(2131712256) + plr.asZ, 1, paramBundle.aBW));
      if (!paramBundle.aBW) {
        break label674;
      }
    }
    label674:
    for (paramBundle = "1";; paramBundle = "2")
    {
      rar.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(plr.asY + acfp.m(2131712272));
      paramQQStoryFriendSettings.app.addObserver(this.c);
      ((pma)paramQQStoryFriendSettings.app.getBusinessHandler(98)).blO();
      rar.a("friend_story_settings", "exp_set", this.mFrom, 0, new String[] { "1", "", "", "" });
      return;
    }
  }
  
  protected void aL(int paramInt, String paramString)
  {
    if (this.a.isResume()) {
      QQToast.a(this.a, paramInt, paramString, 0).show(this.a.getTitleBarHeight());
    }
  }
  
  protected void ao(int paramInt, boolean paramBoolean)
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.p[paramInt].findViewById(2131369545);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    Object localObject = paramCompoundButton.getTag();
    if (!(localObject instanceof Integer)) {}
    for (;;)
    {
      EventCollector.getInstance().onCheckedChanged(paramCompoundButton, paramBoolean);
      return;
      switch (((Integer)localObject).intValue())
      {
      case 6: 
      default: 
        break;
      case 2: 
        if (!aqiw.isNetSupport(this.a))
        {
          if (!paramBoolean) {}
          for (bool1 = true;; bool1 = false)
          {
            ao(2, bool1);
            aL(0, this.a.getString(2131693404));
            break;
          }
        }
        sR(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          rar.a("friend_story_settings", "receive_me", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 3: 
        if (!aqiw.isNetSupport(this.a))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            ao(3, bool1);
            aL(0, this.a.getString(2131693404));
            break;
            bool1 = false;
          }
        }
        sS(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          rar.a("friend_story_settings", "receive_care", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 5: 
        if (!aqiw.isNetSupport(this.a))
        {
          if (!paramBoolean) {}
          for (bool1 = bool2;; bool1 = false)
          {
            ao(5, bool1);
            aL(0, this.a.getString(2131693404));
            break;
          }
        }
        sT(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          rar.a("friend_story_settings", "clk_strange", 0, 0, new String[] { localObject });
          break;
        }
      case 7: 
        if (!aqiw.isNetSupport(this.a))
        {
          if (!paramBoolean) {}
          for (bool1 = bool3;; bool1 = false)
          {
            ao(7, bool1);
            aL(0, this.a.getString(2131693404));
            break;
          }
        }
        sU(paramBoolean);
        ram.w("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
        break;
      case 4: 
        ((pmb)this.a.app.getManager(181)).rN(paramBoolean);
      }
    }
    ((puz)this.a.app.getManager(252)).sq(paramBoolean);
    localObject = (pma)this.a.app.getBusinessHandler(98);
    int i;
    if (paramBoolean)
    {
      i = 2;
      label535:
      ((pma)localObject).vH(i);
      if (!paramBoolean) {
        break label584;
      }
    }
    label584:
    for (localObject = "1";; localObject = "2")
    {
      rar.a("msg_tab", "turn_story", 0, 0, new String[] { "1", localObject });
      break;
      i = 1;
      break label535;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Intent localIntent = new Intent(this.a, QQStoryShieldListActivity.class);
    switch (i)
    {
    }
    for (;;)
    {
      this.a.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra("sheild_type", 2);
      rar.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      localIntent.putExtra("sheild_type", 1);
      rar.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
  
  public void sR(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("self_notify"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      jnm.a(this.a.app, new qoq(this, paramBoolean), localReqSetConfig.toByteArray(), pma.atx);
      return;
    }
  }
  
  public void sS(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("special_notify"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      jnm.a(this.a.app, new qor(this, paramBoolean), localReqSetConfig.toByteArray(), pma.atx);
      return;
    }
  }
  
  public void sT(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("allow_stranger_state"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      jnm.a(this.a.app, new qos(this, paramBoolean), localReqSetConfig.toByteArray(), pma.atx);
      return;
    }
  }
  
  public void sU(boolean paramBoolean)
  {
    qqstory_service.ReqSetConfig localReqSetConfig = new qqstory_service.ReqSetConfig();
    qqstory_struct.UserConfig localUserConfig = new qqstory_struct.UserConfig();
    localUserConfig.config_key.set(ByteStringMicro.copyFromUtf8("story_publish_flag_compress"));
    Object localObject = localUserConfig.config_value;
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      ((PBUInt32Field)localObject).set(i);
      localObject = new ArrayList();
      ((List)localObject).add(localUserConfig);
      localReqSetConfig.user_config.set((List)localObject);
      jnm.a(this.a.app, new qot(this, paramBoolean), localReqSetConfig.toByteArray(), pma.atx);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qoo
 * JD-Core Version:    0.7.0.1
 */