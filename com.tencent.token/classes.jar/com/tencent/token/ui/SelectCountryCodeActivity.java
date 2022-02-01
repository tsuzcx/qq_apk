package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.ui.base.RightLetterView;
import com.tencent.token.ui.base.RightLetterView.a;
import com.tencent.token.xe;
import com.tencent.token.xg;
import com.tencent.token.xi;
import com.tencent.token.xn;
import com.tencent.token.xo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCountryCodeActivity
  extends BaseActivity
{
  private xn adapter;
  private xe characterParser;
  private xi pinyinComparator;
  RightLetterView sideBar;
  private ListView sortListView;
  private List<xo> sourceDateList;
  
  private List<xo> filledData(String[][] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      xo localxo = new xo();
      localxo.a = paramArrayOfString[i][1];
      localxo.c = paramArrayOfString[i][0];
      String str = this.characterParser.a(paramArrayOfString[i][1]).substring(0, 1).toUpperCase();
      if (str.matches("[A-Z]")) {
        localxo.b = str.toUpperCase();
      } else {
        localxo.b = "#";
      }
      localArrayList.add(localxo);
      i += 1;
    }
    return localArrayList;
  }
  
  private void init()
  {
    this.characterParser = xe.a();
    this.pinyinComparator = new xi();
    this.sortListView = ((ListView)findViewById(2131165658));
    this.sideBar = ((RightLetterView)findViewById(2131165919));
    this.sideBar.setOnTouchingLetterChangedListener(new a((byte)0));
    this.sourceDateList = filledData(xg.b);
    List localList = filledData(xg.c);
    Collections.sort(localList, this.pinyinComparator);
    this.sourceDateList.addAll(localList);
    this.adapter = new xn(this, this.sourceDateList, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("name", ((xo)SelectCountryCodeActivity.this.sourceDateList.get(i)).a);
        SelectCountryCodeActivity localSelectCountryCodeActivity = SelectCountryCodeActivity.this;
        localSelectCountryCodeActivity.setResult(Integer.parseInt(((xo)localSelectCountryCodeActivity.sourceDateList.get(i)).c), paramAnonymousView);
        SelectCountryCodeActivity.this.finish();
      }
    });
    this.sortListView.setAdapter(this.adapter);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296420);
    init();
  }
  
  final class a
    implements RightLetterView.a
  {
    private a() {}
    
    public final void a(int paramInt)
    {
      xn localxn = SelectCountryCodeActivity.this.adapter;
      String str = xg.a[paramInt];
      paramInt = 10;
      while (paramInt < localxn.getCount())
      {
        if (str.equals(((xo)localxn.a.get(paramInt)).b)) {
          break label60;
        }
        paramInt += 1;
      }
      paramInt = -1;
      label60:
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