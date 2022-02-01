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
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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

public class xqh
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, wef, wep<QQStoryFriendSettings>
{
  protected int a;
  protected QQStoryFriendSettings a;
  protected vzx a;
  protected View[] a;
  
  public xqh()
  {
    this.jdField_a_of_type_Vzx = new xqi(this);
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561585, null);
    ((TextView)localView.findViewById(2131379001)).setText(paramString);
    ((TextView)localView.findViewById(2131368819)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561588, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131369195);
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
    ((TextView)localView.findViewById(2131368882)).setVisibility(8);
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131369195);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.jdField_a_of_type_Vzx);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings = paramQQStoryFriendSettings;
    this.jdField_a_of_type_Int = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838912);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, AIOUtils.dp2px(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    localLinearLayout.addView(a(0, anvx.a(2131710304) + vzh.b, 2130839512));
    localLinearLayout.addView(a(1, anvx.a(2131710338) + vzh.b, 2130839503));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561603, null));
    paramBundle = (vzv)paramQQStoryFriendSettings.app.getManager(QQManagerFactory.QQSTORY_MANAGER);
    localLinearLayout.addView(a(2, anvx.a(2131710336), 1, paramBundle.a()));
    localLinearLayout.addView(a(3, anvx.a(2131710333) + vzh.b + anvx.a(2131710320), 2, paramBundle.b()));
    if (paramBundle.d())
    {
      int i = paramBundle.b();
      localLinearLayout.addView(a(5, String.format(anvx.a(2131710314), new Object[] { Integer.valueOf(i), anvx.a(2131710337) }), 2, paramBundle.c()));
      ykv.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (wjl)wjs.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    ykq.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561603, null));
      localLinearLayout.addView(a(7, anvx.a(2131710334) + vzh.a, 0, bool2));
    }
    paramBundle = (wms)paramQQStoryFriendSettings.app.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561603, null));
      localLinearLayout.addView(a(8, anvx.a(2131710310) + vzh.b, 1, paramBundle.d));
      if (!paramBundle.d) {
        break label680;
      }
    }
    label680:
    for (paramBundle = "1";; paramBundle = "2")
    {
      ykv.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(vzh.a + anvx.a(2131710327));
      paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_Vzx);
      ((vzu)paramQQStoryFriendSettings.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER)).d();
      ykv.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
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
      ntb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xqj(this, paramBoolean), localReqSetConfig.toByteArray(), vzu.b);
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
      ntb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xqk(this, paramBoolean), localReqSetConfig.toByteArray(), vzu.b);
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
      ntb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xql(this, paramBoolean), localReqSetConfig.toByteArray(), vzu.b);
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
      ntb.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new xqm(this, paramBoolean), localReqSetConfig.toByteArray(), vzu.b);
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
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692125));
            break;
          }
        }
        a(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          ykv.a("friend_story_settings", "receive_me", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 3: 
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            a(3, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692125));
            break;
            bool1 = false;
          }
        }
        b(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          ykv.a("friend_story_settings", "receive_care", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 5: 
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool2;; bool1 = false)
          {
            a(5, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692125));
            break;
          }
        }
        c(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          ykv.a("friend_story_settings", "clk_strange", 0, 0, new String[] { localObject });
          break;
        }
      case 7: 
        if (!NetworkUtil.isNetSupport(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool3;; bool1 = false)
          {
            a(7, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692125));
            break;
          }
        }
        d(paramBoolean);
        ykq.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
        break;
      case 4: 
        ((vzv)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(QQManagerFactory.QQSTORY_MANAGER)).g(paramBoolean);
      }
    }
    ((wms)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(QQManagerFactory.MSG_TAB_STORY_CONFIG_MANAGER)).a(paramBoolean);
    localObject = (vzu)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getBusinessHandler(BusinessHandlerFactory.QQSTORY_HANDLER);
    int i;
    if (paramBoolean)
    {
      i = 2;
      label539:
      ((vzu)localObject).b(i);
      if (!paramBoolean) {
        break label588;
      }
    }
    label588:
    for (localObject = "1";; localObject = "2")
    {
      ykv.a("msg_tab", "turn_story", 0, 0, new String[] { "1", localObject });
      break;
      i = 1;
      break label539;
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
      ykv.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      localIntent.putExtra("sheild_type", 1);
      ykv.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xqh
 * JD-Core Version:    0.7.0.1
 */