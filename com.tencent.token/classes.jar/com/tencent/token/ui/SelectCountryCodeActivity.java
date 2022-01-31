package com.tencent.token.ui;

import android.os.Bundle;
import android.widget.ListView;
import com.tencent.token.global.b;
import com.tencent.token.global.e;
import com.tencent.token.global.g;
import com.tencent.token.global.k;
import com.tencent.token.global.m;
import com.tencent.token.ui.base.RightLetterView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCountryCodeActivity
  extends BaseActivity
{
  private k adapter;
  private b characterParser;
  private g pinyinComparator;
  RightLetterView sideBar;
  private ListView sortListView;
  private List sourceDateList;
  
  private List filledData(String[][] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayOfString.length)
    {
      m localm = new m();
      localm.b(paramArrayOfString[i][1]);
      localm.a(paramArrayOfString[i][0]);
      String str = this.characterParser.b(paramArrayOfString[i][1]).substring(0, 1).toUpperCase();
      if (str.matches("[A-Z]")) {
        localm.c(str.toUpperCase());
      }
      for (;;)
      {
        localArrayList.add(localm);
        i += 1;
        break;
        localm.c("#");
      }
    }
    return localArrayList;
  }
  
  private void init()
  {
    this.characterParser = b.a();
    this.pinyinComparator = new g();
    this.sortListView = ((ListView)findViewById(2131559004));
    this.sideBar = ((RightLetterView)findViewById(2131559005));
    this.sideBar.setOnTouchingLetterChangedListener(new yu(this, null));
    this.sourceDateList = filledData(e.b);
    List localList = filledData(e.c);
    Collections.sort(localList, this.pinyinComparator);
    this.sourceDateList.addAll(localList);
    this.adapter = new k(this, this.sourceDateList, new yt(this));
    this.sortListView.setAdapter(this.adapter);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2130968738);
    init();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SelectCountryCodeActivity
 * JD-Core Version:    0.7.0.1
 */