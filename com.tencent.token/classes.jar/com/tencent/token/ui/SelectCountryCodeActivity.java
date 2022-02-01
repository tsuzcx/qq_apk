package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.ui.base.RightLetterView;
import com.tencent.token.ui.base.RightLetterView.a;
import com.tencent.token.ww;
import com.tencent.token.wy;
import com.tencent.token.xa;
import com.tencent.token.xd;
import com.tencent.token.xe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCountryCodeActivity
  extends BaseActivity
{
  private xd adapter;
  private ww characterParser;
  private xa pinyinComparator;
  RightLetterView sideBar;
  private ListView sortListView;
  private List<xe> sourceDateList;
  
  private List<xe> filledData(String[][] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      xe localxe = new xe();
      localxe.a = paramArrayOfString[i][1];
      localxe.c = paramArrayOfString[i][0];
      String str = this.characterParser.a(paramArrayOfString[i][1]).substring(0, 1).toUpperCase();
      if (str.matches("[A-Z]")) {
        localxe.b = str.toUpperCase();
      } else {
        localxe.b = "#";
      }
      localArrayList.add(localxe);
      i += 1;
    }
    return localArrayList;
  }
  
  private void init()
  {
    this.characterParser = ww.a();
    this.pinyinComparator = new xa();
    this.sortListView = ((ListView)findViewById(2131165658));
    this.sideBar = ((RightLetterView)findViewById(2131165918));
    this.sideBar.setOnTouchingLetterChangedListener(new a((byte)0));
    this.sourceDateList = filledData(wy.b);
    List localList = filledData(wy.c);
    Collections.sort(localList, this.pinyinComparator);
    this.sourceDateList.addAll(localList);
    this.adapter = new xd(this, this.sourceDateList, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("name", ((xe)SelectCountryCodeActivity.this.sourceDateList.get(i)).a);
        SelectCountryCodeActivity localSelectCountryCodeActivity = SelectCountryCodeActivity.this;
        localSelectCountryCodeActivity.setResult(Integer.parseInt(((xe)localSelectCountryCodeActivity.sourceDateList.get(i)).c), paramAnonymousView);
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
      xd localxd = SelectCountryCodeActivity.this.adapter;
      String str = wy.a[paramInt];
      paramInt = 10;
      while (paramInt < localxd.getCount())
      {
        if (str.equals(((xe)localxd.a.get(paramInt)).b)) {
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