package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import com.tencent.token.core.bean.c;
import com.tencent.token.global.b;
import java.util.ArrayList;
import java.util.List;

public class EnvirChangeListviewActivity
  extends BaseActivity
{
  List envirDataList = new ArrayList();
  String[] envirHosts = { "http://test.aq.qq.com", "http://w.aq.qq.com", "http://exp.aq.qq.com", "http://gray.aq.qq.com" };
  String[] envirNames = { "测试环境", "正式环境", "201体验环境", "157灰度环境" };
  final long[] mHits = new long[2];
  private AdapterView.OnItemClickListener mItemClickListener = new dn(this);
  private do maAdapter;
  
  private void initData()
  {
    int i = 0;
    if (i < this.envirNames.length)
    {
      c localc = new c();
      localc.a(this.envirNames[i]);
      localc.b(this.envirHosts[i]);
      if (this.envirHosts[i] == b.c()) {
        localc.a(true);
      }
      for (;;)
      {
        this.envirDataList.add(localc);
        i += 1;
        break;
        localc.a(false);
      }
    }
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130903077);
    paramBundle = (ListView)findViewById(2131296544);
    initData();
    this.maAdapter = new do(this, this, this.envirDataList);
    paramBundle.setAdapter(this.maAdapter);
    paramBundle.setOnItemClickListener(this.mItemClickListener);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.EnvirChangeListviewActivity
 * JD-Core Version:    0.7.0.1
 */