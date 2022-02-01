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

public class yab
  implements View.OnClickListener, CompoundButton.OnCheckedChangeListener, wnt, wod<QQStoryFriendSettings>
{
  protected int a;
  protected QQStoryFriendSettings a;
  protected wjd a;
  protected View[] a;
  
  public yab()
  {
    this.jdField_a_of_type_Wjd = new yac(this);
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561643, null);
    ((TextView)localView.findViewById(2131378936)).setText(paramString);
    ((TextView)localView.findViewById(2131368636)).setText("");
    localView.setTag(Integer.valueOf(paramInt1));
    localView.setOnClickListener(this);
    localView.setBackgroundResource(paramInt2);
    return localView;
  }
  
  protected View a(int paramInt1, String paramString, int paramInt2, boolean paramBoolean)
  {
    View localView = View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561646, null);
    this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt1] = localView;
    Object localObject = (FormSwitchItem)localView.findViewById(2131369006);
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
    ((TextView)localView.findViewById(2131368699)).setVisibility(8);
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
    FormSwitchItem localFormSwitchItem = (FormSwitchItem)this.jdField_a_of_type_ArrayOfAndroidViewView[paramInt].findViewById(2131369006);
    localFormSwitchItem.setOnCheckedChangeListener(null);
    localFormSwitchItem.setChecked(paramBoolean);
    localFormSwitchItem.setOnCheckedChangeListener(this);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings)
  {
    paramQQStoryFriendSettings.app.removeObserver(this.jdField_a_of_type_Wjd);
  }
  
  public void a(QQStoryFriendSettings paramQQStoryFriendSettings, Bundle paramBundle)
  {
    this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings = paramQQStoryFriendSettings;
    this.jdField_a_of_type_Int = paramQQStoryFriendSettings.getIntent().getIntExtra("from", 1);
    LinearLayout localLinearLayout = new LinearLayout(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings);
    paramBundle = new LinearLayout.LayoutParams(-1, -1);
    localLinearLayout.setBackgroundResource(2130838779);
    localLinearLayout.setLayoutParams(paramBundle);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setPadding(0, agej.a(20.0F, paramQQStoryFriendSettings.getResources()), 0, 0);
    this.jdField_a_of_type_ArrayOfAndroidViewView = new View[9];
    localLinearLayout.addView(a(0, anzj.a(2131709725) + win.b, 2130839456));
    localLinearLayout.addView(a(1, anzj.a(2131709759) + win.b, 2130839447));
    localLinearLayout.addView(View.inflate(paramQQStoryFriendSettings, 2131561658, null));
    paramBundle = (wjb)paramQQStoryFriendSettings.app.getManager(181);
    localLinearLayout.addView(a(2, anzj.a(2131709757), 1, paramBundle.a()));
    localLinearLayout.addView(a(3, anzj.a(2131709754) + win.b + anzj.a(2131709741), 2, paramBundle.b()));
    if (paramBundle.d())
    {
      int i = paramBundle.b();
      localLinearLayout.addView(a(5, String.format(anzj.a(2131709735), new Object[] { Integer.valueOf(i), anzj.a(2131709758) }), 2, paramBundle.c()));
      yup.a("friend_story_settings", "exp_strange", 0, 0, new String[0]);
    }
    paramBundle = (wta)wth.a(10);
    boolean bool1 = ((Boolean)paramBundle.b("story_publish_flag_compress_configurable", Boolean.valueOf(false))).booleanValue();
    boolean bool2 = ((Boolean)paramBundle.b("story_publish_flag_compress", Boolean.valueOf(false))).booleanValue();
    yuk.d("QQStoryFriendSettingDelegate", "skipEncodeVisible=%s, skipEncodeEnable=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) });
    if (bool1)
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561658, null));
      localLinearLayout.addView(a(7, anzj.a(2131709755) + win.a, 0, bool2));
    }
    paramBundle = (wwh)paramQQStoryFriendSettings.app.getManager(252);
    if ((paramBundle.b) && (paramBundle.c))
    {
      localLinearLayout.addView(View.inflate(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings, 2131561658, null));
      localLinearLayout.addView(a(8, anzj.a(2131709731) + win.b, 1, paramBundle.d));
      if (!paramBundle.d) {
        break label677;
      }
    }
    label677:
    for (paramBundle = "1";; paramBundle = "2")
    {
      yup.a("msg_tab", "exp_set", 0, 0, new String[] { "1", paramBundle });
      paramQQStoryFriendSettings.setContentView(localLinearLayout);
      paramQQStoryFriendSettings.setTitle(win.a + anzj.a(2131709748));
      paramQQStoryFriendSettings.app.addObserver(this.jdField_a_of_type_Wjd);
      ((wja)paramQQStoryFriendSettings.app.a(98)).d();
      yup.a("friend_story_settings", "exp_set", this.jdField_a_of_type_Int, 0, new String[] { "1", "", "", "" });
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
      nkm.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new yad(this, paramBoolean), localReqSetConfig.toByteArray(), wja.b);
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
      nkm.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new yae(this, paramBoolean), localReqSetConfig.toByteArray(), wja.b);
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
      nkm.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new yaf(this, paramBoolean), localReqSetConfig.toByteArray(), wja.b);
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
      nkm.a(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app, new yag(this, paramBoolean), localReqSetConfig.toByteArray(), wja.b);
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
        if (!bhnv.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = true;; bool1 = false)
          {
            a(2, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131691989));
            break;
          }
        }
        a(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          yup.a("friend_story_settings", "receive_me", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 3: 
        if (!bhnv.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (;;)
          {
            a(3, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131691989));
            break;
            bool1 = false;
          }
        }
        b(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          yup.a("friend_story_settings", "receive_care", 0, 0, new String[] { localObject, "", "", "" });
          break;
        }
      case 5: 
        if (!bhnv.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool2;; bool1 = false)
          {
            a(5, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131691989));
            break;
          }
        }
        c(paramBoolean);
        if (paramBoolean) {}
        for (localObject = "1";; localObject = "2")
        {
          yup.a("friend_story_settings", "clk_strange", 0, 0, new String[] { localObject });
          break;
        }
      case 7: 
        if (!bhnv.d(this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings))
        {
          if (!paramBoolean) {}
          for (bool1 = bool3;; bool1 = false)
          {
            a(7, bool1);
            a(0, this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.getString(2131691989));
            break;
          }
        }
        d(paramBoolean);
        yuk.d("QQStoryFriendSettingDelegate", "VIEW_ID_ALLOW_SKIP_ENCODE_THREAD %s", new Object[] { Boolean.valueOf(paramBoolean) });
        break;
      case 4: 
        ((wjb)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(181)).g(paramBoolean);
      }
    }
    ((wwh)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.getManager(252)).a(paramBoolean);
    localObject = (wja)this.jdField_a_of_type_ComTencentBizQqstorySettingsQQStoryFriendSettings.app.a(98);
    int i;
    if (paramBoolean)
    {
      i = 2;
      label538:
      ((wja)localObject).b(i);
      if (!paramBoolean) {
        break label587;
      }
    }
    label587:
    for (localObject = "1";; localObject = "2")
    {
      yup.a("msg_tab", "turn_story", 0, 0, new String[] { "1", localObject });
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
      yup.a("friend_story_settings", "clk_notletsee", 0, 0, new String[] { "", "", "", "" });
      continue;
      localIntent.putExtra("sheild_type", 1);
      yup.a("friend_story_settings", "clk_notsee", 0, 0, new String[] { "", "", "", "" });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     yab
 * JD-Core Version:    0.7.0.1
 */