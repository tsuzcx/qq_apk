package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.token.core.bean.b;
import com.tencent.token.global.c;
import java.util.ArrayList;
import java.util.List;

public class EnvirChangeListviewActivity
  extends BaseActivity
{
  List envirDataList = new ArrayList();
  String[] envirHosts = { "http://test.aq.qq.com", "https://w.aq.qq.com", "http://exp.aq.qq.com", "http://gray.aq.qq.com" };
  String[] envirNames = { "测试环境", "正式环境", "201体验环境", "157灰度环境" };
  final long[] mHits = new long[2];
  private AdapterView.OnItemClickListener mItemClickListener = new ei(this);
  private ej maAdapter;
  
  private void initData()
  {
    int i = 0;
    if (i < this.envirNames.length)
    {
      b localb = new b();
      localb.a(this.envirNames[i]);
      localb.b(this.envirHosts[i]);
      if (this.envirHosts[i] == c.e()) {
        localb.a(true);
      }
      for (;;)
      {
        this.envirDataList.add(localb);
        i += 1;
        break;
        localb.a(false);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968642);
    paramBundle = (ListView)findViewById(2131558830);
    initData();
    this.maAdapter = new ej(this, this, this.envirDataList);
    paramBundle.setAdapter(this.maAdapter);
    paramBundle.setOnItemClickListener(this.mItemClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EnvirChangeListviewActivity
 * JD-Core Version:    0.7.0.1
 */