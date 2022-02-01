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
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.FormSwitchItem;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class xbm
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, vpk, vpu<QQStoryFriendSettings>
{
  protected int a;
  protected QQStoryFriendSettings a;
  protected vlc a;
  protected View[] a;
  
  public xbm()
  {
    this.jdField_a_of_type_Vlc = new xbn(this);
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561522, null);
    ((TextView)localView.findViewById(2131378707)).setText(paramString);
    ((TextView)localView.findViewById(2131368660)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561525, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131369032);
    ((FormSwitchItem)localObject).a().setTextSize(1, 18.0F);
    ((FormSwitchItem)localObject).setText(paramString);
    ((FormSwitchItem)localObject).setContentDescription(paramString);
    ((FormSwitchItem)localObject).setBgType(paramInt2);
    localObject = ((FormSwitchItem)localObject).a();
    ((Switch)localObject).setTag(Integer.valueOf(paramInt1));
    ((Switch)localObject).setOnCheckedChangeListener(null);
    ((Switch)localObject).setChecked(paramBoolean);
    ((Switch)localObject).setOnCheckedChangeListener(this);
    ((Switch)localObject).setContentDescription(paramString);
    ((TextView)localView.findViewById(2131368723)).setVisibility(8);
    return localView;
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.isResume()) {
      QQToast.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, paramInt, paramString, 0).b(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131369032);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.jdField_a_of_type_Vlc);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings = paramQQStoryFriendSettings;
    this.jdField_a_of_type_Int = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838892);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, AIOUtils.dp2px(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    localLinearLayout.addView(a(0, amtj.a(2131709957) + vkm.b, 2130839491));
    localLinearLayout.addView(a(1, amtj.a(2131709991) + vkm.b, 2130839482));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561537, null));
    paramBundle = (vla)paramQQStoryFriendSettings.app.getManager(181);
    localLinearLayout.addView(a(2, amtj.a(2131709989), 1, paramBundle.a()));
    localLinearLayout.addView(a(3, amtj.a(2131709986) + vkm.b + amtj.a(2131709973), 2, paramBundle.b()));
    if (paramBundle.d())
    {
      int i = paramBundle.b();
      localLinearLayout.addView(a(5, String.format(amtj.a(2131709967), new Object[] { Integer.valueOf(i), amtj.a(2131709990) }), 2, paramBundle.c()));
      xwa.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (vuq)vux.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    xvv.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561537, null));
      localLinearLayout.addView(a(7, amtj.a(2131709987) + vkm.a, 0, bool2));
    }
    paramBundle = (vxx)paramQQStoryFriendSettings.app.getManager(252);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561537, null));
      localLinearLayout.addView(a(8, amtj.a(2131709963) + vkm.b, 1, paramBundle.d));
      if (!paramBundle.d) {
        break label678;
      }
    }
    label678:
    for (paramBundle = "1";; paramBundle = "2")
    {
      xwa.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(vkm.a + amtj.a(2131709980));
      paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_Vlc);
      ((vkz)paramQQStoryFriendSettings.app.getBusinessHandler(98)).d();
      xwa.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
      return;
    }
  }
  
  public void a(boolean paramBoolean)
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
      nmb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xbo(this, paramBoolean), localReqSetConfig.toByteArray(), vkz.b);
      return;
    }
  }
  
  public void b(boolean paramBoolean)
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
      nmb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xbp(this, paramBoolean), localReqSetConfig.toByteArray(), vkz.b);
      return;
    }
  }
  
  public void c(boolean paramBoolean)
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
      nmb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xbq(this, paramBoolean), localReqSetConfig.toByteArray(), vkz.b);
      return;
    }
  }
  
  public void d(boolean paramBoolean)
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
      nmb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xbr(this, paramBoolean), localReqSetConfig.toByteArray(), vkz.b);
      return;
    }
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
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = true;; bool1 = false)
          {
            a(2, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692035));
            break;
          }
        }
        a(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          xwa.a("friend_story_settings", "receive_me", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 3: 
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            a(3, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692035));
            break;
            bool1 = false;
          }
        }
        b(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          xwa.a("friend_story_settings", "receive_care", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 5: 
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool2;; bool1 = false)
          {
            a(5, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692035));
            break;
          }
        }
        c(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          xwa.a("friend_story_settings", "clk_strange", 0, 0, new String[] { localObject });
          break;
        }
      case 7: 
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool3;; bool1 = false)
          {
            a(7, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692035));
            break;
          }
        }
        d(paramBoolean);
        xvv.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
        break;
      case 4: 
        ((vla)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(181)).g(paramBoolean);
      }
    }
    ((vxx)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(252)).a(paramBoolean);
    localObject = (vkz)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getBusinessHandler(98);
    int i;
    if (paramBoolean)
    {
      i = 2;
      label538:
      ((vkz)localObject).b(i);
      if (!paramBoolean) {
        break label587;
      }
    }
    label587:
    for (localObject = "1";; localObject = "2")
    {
      xwa.a("msg_tab", "turn_story", 0, 0, new String[] { "1", localObject });
      break;
      i = 1;
      break label538;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    Intent localIntent = new Intent(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, QQStoryShieldListActivity.class);
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.startActivity(localIntent);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      localIntent.putExtra("sheild_type", 2);
      xwa.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      localIntent.putExtra("sheild_type", 1);
      xwa.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xbm
 * JD-Core Version:    0.7.0.1
 */