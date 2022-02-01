package com.tencent.qqmail.activity.setting.feedback;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.tencent.qqmail.BaseActivityEx;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.uitableview.UITableItemView;
import com.tencent.qqmail.utilities.uitableview.UITableView;
import com.tencent.qqmail.utilities.uitableview.UITableView.ClickListener;
import com.tencent.qqmail.view.QMBaseView;
import com.tencent.qqmail.view.QMTopBar;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SettingFeedbackSceneActivity
  extends BaseActivityEx
{
  private static final String ARG_SCENE = "ARG_SCENE";
  private List<HashMap<String, Object>> detailMap;
  private QMBaseView mSettingView;
  private final UITableView.ClickListener sceneTableOnClickListener = new SettingFeedbackSceneActivity.2(this);
  private UITableView sceneTableView;
  private List<Map<String, Object>> scenelist;
  
  public static Intent createIntent(JSONArray paramJSONArray)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), SettingFeedbackSceneActivity.class);
    localIntent.putExtra("ARG_SCENE", paramJSONArray);
    return localIntent;
  }
  
  public static JSONArray parseFeedbackAssets()
  {
    return ((JSONObject)JSONReader.parse(QMApplicationContext.sharedInstance().getFromAssets("mail/feedback"))).getJSONArray("scenelist");
  }
  
  public void initDataSource()
  {
    this.detailMap = new ArrayList();
  }
  
  public void initDom()
  {
    Object localObject1 = getTopBar();
    ((QMTopBar)localObject1).setTitle(getString(2131691897));
    ((QMTopBar)localObject1).setButtonLeftIcon(2130841088);
    ((QMTopBar)localObject1).getButtonLeft().setOnClickListener(new SettingFeedbackSceneActivity.1(this));
    this.sceneTableView = new UITableView(getActivity());
    this.mSettingView.addContentView(this.sceneTableView);
    this.sceneTableView.setCaption(2131719840);
    this.sceneTableView.setClickListener(this.sceneTableOnClickListener);
    try
    {
      this.scenelist = ((List)getIntent().getExtras().getSerializable("ARG_SCENE"));
      int i = 0;
      while (i < this.scenelist.size())
      {
        localObject1 = (Map)this.scenelist.get(i);
        Object localObject2 = (String)((Map)localObject1).get("title");
        String str = (String)((Map)localObject1).get("describe");
        localObject2 = this.sceneTableView.addItem((String)localObject2);
        if (!TextUtils.isEmpty(str)) {
          ((UITableItemView)localObject2).setDetail(str, UITableItemView.STYLE_GRAY);
        }
        localObject1 = (HashMap)((Map)localObject1).get("detail");
        this.detailMap.add(localObject1);
        i += 1;
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        this.scenelist = new ArrayList();
      }
      this.sceneTableView.addItem(getString(2131719839));
      this.sceneTableView.commit();
    }
  }
  
  public void initUI()
  {
    overridePendingTransition(2130772401, 2130772423);
    this.mSettingView = initScrollView(this);
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    overridePendingTransition(0, 2130772402);
  }
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.feedback.SettingFeedbackSceneActivity
 * JD-Core Version:    0.7.0.1
 */