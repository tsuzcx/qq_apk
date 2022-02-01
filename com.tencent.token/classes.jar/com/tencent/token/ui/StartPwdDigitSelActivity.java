package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Bundle;
import android.widget.ListView;
import com.tencent.token.yh;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StartPwdDigitSelActivity
  extends BaseActivity
{
  private List<Map<String, Object>> mData;
  ListView mListView;
  
  private List<Map<String, Object>> getData()
  {
    ArrayList localArrayList = new ArrayList();
    HashMap localHashMap = new HashMap();
    localHashMap.put("setting_op_name", getResources().getString(2131493640));
    localArrayList.add(localHashMap);
    localHashMap = new HashMap();
    localHashMap.put("setting_op_name", getResources().getString(2131493639));
    localArrayList.add(localHashMap);
    return localArrayList;
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296465);
    this.mListView = ((ListView)findViewById(2131166127));
    this.mData = getData();
    paramBundle = new yh(this, this.mData);
    this.mListView.setAdapter(paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.StartPwdDigitSelActivity
 * JD-Core Version:    0.7.0.1
 */