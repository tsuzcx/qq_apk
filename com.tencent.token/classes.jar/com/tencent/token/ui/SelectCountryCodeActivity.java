package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.global.b;
import com.tencent.token.global.d;
import com.tencent.token.global.f;
import com.tencent.token.global.i;
import com.tencent.token.global.j;
import com.tencent.token.ui.base.RightLetterView;
import com.tencent.token.ui.base.RightLetterView.a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCountryCodeActivity
  extends BaseActivity
{
  private i adapter;
  private b characterParser;
  private f pinyinComparator;
  RightLetterView sideBar;
  private ListView sortListView;
  private List<j> sourceDateList;
  
  private List<j> filledData(String[][] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      j localj = new j();
      localj.b(paramArrayOfString[i][1]);
      localj.a(paramArrayOfString[i][0]);
      String str = this.characterParser.b(paramArrayOfString[i][1]).substring(0, 1).toUpperCase();
      if (str.matches("[A-Z]")) {
        localj.c(str.toUpperCase());
      } else {
        localj.c("#");
      }
      localArrayList.add(localj);
      i += 1;
    }
    return localArrayList;
  }
  
  private void init()
  {
    this.characterParser = b.a();
    this.pinyinComparator = new f();
    this.sortListView = ((ListView)findViewById(2131165654));
    this.sideBar = ((RightLetterView)findViewById(2131165914));
    this.sideBar.setOnTouchingLetterChangedListener(new a(null));
    this.sourceDateList = filledData(d.b);
    List localList = filledData(d.c);
    Collections.sort(localList, this.pinyinComparator);
    this.sourceDateList.addAll(localList);
    this.adapter = new i(this, this.sourceDateList, new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("name", ((j)SelectCountryCodeActivity.this.sourceDateList.get(i)).b());
        SelectCountryCodeActivity localSelectCountryCodeActivity = SelectCountryCodeActivity.this;
        localSelectCountryCodeActivity.setResult(Integer.parseInt(((j)localSelectCountryCodeActivity.sourceDateList.get(i)).a()), paramAnonymousView);
        SelectCountryCodeActivity.this.finish();
      }
    });
    this.sortListView.setAdapter(this.adapter);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296419);
    init();
  }
  
  private class a
    implements RightLetterView.a
  {
    private a() {}
    
    public void a(int paramInt)
    {
      paramInt = SelectCountryCodeActivity.this.adapter.a(d.a[paramInt]);
      if (paramInt != -1) {
        SelectCountryCodeActivity.this.sortListView.setSelection(paramInt);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.SelectCountryCodeActivity
 * JD-Core Version:    0.7.0.1
 */