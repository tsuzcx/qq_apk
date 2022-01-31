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
import com.tencent.widget.Switch;
import java.util.ArrayList;
import java.util.List;

public class wcv
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, uqm, uqw<QQStoryFriendSettings>
{
  protected int a;
  protected QQStoryFriendSettings a;
  protected ulw a;
  protected View[] a;
  
  public wcv()
  {
    this.jdField_a_of_type_Ulw = new wcw(this);
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561367, null);
    ((TextView)localView.findViewById(2131377938)).setText(paramString);
    ((TextView)localView.findViewById(2131368235)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561370, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131368590);
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
    ((TextView)localView.findViewById(2131368318)).setVisibility(8);
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131368590);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.jdField_a_of_type_Ulw);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings = paramQQStoryFriendSettings;
    this.jdField_a_of_type_Int = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838593);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, aepi.a(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    localLinearLayout.addView(a(0, alud.a(2131711240) + ulg.b, 2130839270));
    localLinearLayout.addView(a(1, alud.a(2131711274) + ulg.b, 2130839261));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561382, null));
    paramBundle = (ulu)paramQQStoryFriendSettings.app.getManager(181);
    localLinearLayout.addView(a(2, alud.a(2131711272), 1, paramBundle.a()));
    localLinearLayout.addView(a(3, alud.a(2131711269) + ulg.b + alud.a(2131711256), 2, paramBundle.b()));
    if (paramBundle.d())
    {
      int i = paramBundle.b();
      localLinearLayout.addView(a(5, String.format(alud.a(2131711250), new Object[] { Integer.valueOf(i), alud.a(2131711273) }), 2, paramBundle.c()));
      wxj.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (uvt)uwa.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    wxe.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561382, null));
      localLinearLayout.addView(a(7, alud.a(2131711270) + ulg.a, 0, bool2));
    }
    paramBundle = (uza)paramQQStoryFriendSettings.app.getManager(252);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561382, null));
      localLinearLayout.addView(a(8, alud.a(2131711246) + ulg.b, 1, paramBundle.d));
      if (!paramBundle.d) {
        break label677;
      }
    }
    label677:
    for (paramBundle = "1";; paramBundle = "2")
    {
      wxj.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(ulg.a + alud.a(2131711263));
      paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_Ulw);
      ((ult)paramQQStoryFriendSettings.app.a(98)).d();
      wxj.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
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
      mzy.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new wcx(this, paramBoolean), localReqSetConfig.toByteArray(), ult.b);
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
      mzy.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new wcy(this, paramBoolean), localReqSetConfig.toByteArray(), ult.b);
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
      mzy.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new wcz(this, paramBoolean), localReqSetConfig.toByteArray(), ult.b);
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
      mzy.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new wda(this, paramBoolean), localReqSetConfig.toByteArray(), ult.b);
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
      if (!bdin.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = true;; paramBoolean = false)
        {
          a(2, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692398));
          return;
        }
      }
      a(paramBoolean);
      if (paramBoolean) {}
      for (paramCompoundButton = "1";; paramCompoundButton = "2")
      {
        wxj.a("friend_story_settings", "receive_me", 0, 0, new String[] { paramCompoundButton, "", "", "" });
        return;
      }
    case 3: 
      if (!bdin.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool1;; paramBoolean = false)
        {
          a(3, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692398));
          return;
        }
      }
      b(paramBoolean);
      if (paramBoolean) {}
      for (paramCompoundButton = "1";; paramCompoundButton = "2")
      {
        wxj.a("friend_story_settings", "receive_care", 0, 0, new String[] { paramCompoundButton, "", "", "" });
        return;
      }
    case 5: 
      if (!bdin.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool2;; paramBoolean = false)
        {
          a(5, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692398));
          return;
        }
      }
      c(paramBoolean);
      if (paramBoolean) {}
      for (paramCompoundButton = "1";; paramCompoundButton = "2")
      {
        wxj.a("friend_story_settings", "clk_strange", 0, 0, new String[] { paramCompoundButton });
        return;
      }
    case 7: 
      if (!bdin.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
      {
        if (!paramBoolean) {}
        for (paramBoolean = bool3;; paramBoolean = false)
        {
          a(7, paramBoolean);
          a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131692398));
          return;
        }
      }
      d(paramBoolean);
      wxe.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
      return;
    case 4: 
      ((ulu)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(181)).g(paramBoolean);
      return;
    }
    ((uza)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(252)).a(paramBoolean);
    paramCompoundButton = (ult)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.a(98);
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
      wxj.a("msg_tab", "turn_story", 0, 0, new String[] { "1", paramCompoundButton });
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
      wxj.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      paramView.putExtra("sheild_type", 1);
      wxj.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     wcv
 * JD-Core Version:    0.7.0.1
 */