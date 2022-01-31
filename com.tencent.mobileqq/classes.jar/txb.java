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
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class txb
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, sks, slc<QQStoryFriendSettings>
{
  protected int a;
  protected QQStoryFriendSettings a;
  protected sgc a;
  protected View[] a;
  
  public txb()
  {
    this.jdField_a_of_type_Sgc = new txc(this);
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131495572, null);
    ((TextView)localView.findViewById(2131311534)).setText(paramString);
    ((TextView)localView.findViewById(2131302466)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131495575, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131302772);
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
    ((TextView)localView.findViewById(2131302541)).setVisibility(8);
    return localView;
  }
  
  protected void a(int paramInt, String paramString)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.isResume()) {
      bbmy.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, paramInt, paramString, 0).b(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getTitleBarHeight());
    }
  }
  
  protected void a(int paramInt, boolean paramBoolean)
  {
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131302772);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.jdField_a_of_type_Sgc);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings = paramQQStoryFriendSettings;
    this.jdField_a_of_type_Int = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838504);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, aciy.a(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    localLinearLayout.addView(a(0, ajjy.a(2131645057) + sfm.b, 2130839160));
    localLinearLayout.addView(a(1, ajjy.a(2131645091) + sfm.b, 2130839151));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131495587, null));
    paramBundle = (sga)paramQQStoryFriendSettings.app.getManager(181);
    localLinearLayout.addView(a(2, ajjy.a(2131645089), 1, paramBundle.a()));
    localLinearLayout.addView(a(3, ajjy.a(2131645086) + sfm.b + ajjy.a(2131645073), 2, paramBundle.b()));
    if (paramBundle.d())
    {
      int i = paramBundle.b();
      localLinearLayout.addView(a(5, String.format(ajjy.a(2131645067), new Object[] { Integer.valueOf(i), ajjy.a(2131645090) }), 2, paramBundle.c()));
      urp.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (spz)sqg.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    urk.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131495587, null));
      localLinearLayout.addView(a(7, ajjy.a(2131645087) + sfm.a, 0, bool2));
    }
    paramBundle = (stg)paramQQStoryFriendSettings.app.getManager(252);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131495587, null));
      localLinearLayout.addView(a(8, ajjy.a(2131645063) + sfm.b, 1, paramBundle.d));
      if (!paramBundle.d) {
        break label677;
      }
    }
    label677:
    for (paramBundle = "1";; paramBundle = "2")
    {
      urp.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(sfm.a + ajjy.a(2131645080));
      paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_Sgc);
      ((sfz)paramQQStoryFriendSettings.app.a(98)).d();
      urp.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
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
      mmj.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new txd(this, paramBoolean), localReqSetConfig.toByteArray(), sfz.b);
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
      mmj.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new txe(this, paramBoolean), localReqSetConfig.toByteArray(), sfz.b);
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
      mmj.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new txf(this, paramBoolean), localReqSetConfig.toByteArray(), sfz.b);
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
      mmj.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new txg(this, paramBoolean), localReqSetConfig.toByteArray(), sfz.b);
      return;
    }
  }
  
  public void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    boolean bool2 = true;
    boolean bool3 = true;
    boolean bool1 = true;
    paramCompoundButton = paramCompoundButton.getTag();
    if (!(paramCompoundButton instanceof Integer)) {
      return;
    }
    switch (((Integer)paramCompoundButton).intValue())
    {
    case 6: 
    default: 
      return;
    case 2: 
      if (!badq.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a(2, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131626719));
          return;
        }
      }
      a(paramBoolean);
      if (paramBoolean) {}
      for (paramCompoundButton = "1";; paramCompoundButton = "2")
      {
        urp.a("friend_story_settings", "receive_me", 0, 0, new String[] { paramCompoundButton, "", "", "" });
        return;
      }
    case 3: 
      if (!badq.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          a(3, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131626719));
          return;
        }
      }
      b(paramBoolean);
      if (paramBoolean) {}
      for (paramCompoundButton = "1";; paramCompoundButton = "2")
      {
        urp.a("friend_story_settings", "receive_care", 0, 0, new String[] { paramCompoundButton, "", "", "" });
        return;
      }
    case 5: 
      if (!badq.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          a(5, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131626719));
          return;
        }
      }
      c(paramBoolean);
      if (paramBoolean) {}
      for (paramCompoundButton = "1";; paramCompoundButton = "2")
      {
        urp.a("friend_story_settings", "clk_strange", 0, 0, new String[] { paramCompoundButton });
        return;
      }
    case 7: 
      if (!badq.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool3;; paramBoolean = false)
        {
          a(7, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131626719));
          return;
        }
      }
      d(paramBoolean);
      urk.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    case 4: 
      ((sga)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(181)).g(paramBoolean);
      return;
    }
    ((stg)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(252)).a(paramBoolean);
    paramCompoundButton = (sfz)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.a(98);
    int i;
    if (paramBoolean)
    {
      i = 2;
      paramCompoundButton.b(i);
      if (!paramBoolean) {
        break label532;
      }
    }
    label532:
    for (paramCompoundButton = "1";; paramCompoundButton = "2")
    {
      urp.a("msg_tab", "turn_story", 0, 0, new String[] { "1", paramCompoundButton });
      return;
      i = 1;
      break;
    }
  }
  
  public void onClick(View paramView)
  {
    int i = ((Integer)paramView.getTag()).intValue();
    paramView = new Intent(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, QQStoryShieldListActivity.class);
    switch (i)
    {
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.startActivity(paramView);
      return;
      paramView.putExtra("sheild_type", 2);
      urp.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      paramView.putExtra("sheild_type", 1);
      urp.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     txb
 * JD-Core Version:    0.7.0.1
 */