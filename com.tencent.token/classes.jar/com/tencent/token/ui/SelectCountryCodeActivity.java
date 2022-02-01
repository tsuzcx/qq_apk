package com.tencent.token.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ListView;
import com.tencent.token.ui.base.RightLetterView;
import com.tencent.token.ui.base.RightLetterView.a;
import com.tencent.token.xq;
import com.tencent.token.xs;
import com.tencent.token.xu;
import com.tencent.token.xz;
import com.tencent.token.ya;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SelectCountryCodeActivity
  extends BaseActivity
{
  private xz adapter;
  private xq characterParser;
  private xu pinyinComparator;
  RightLetterView sideBar;
  private ListView sortListView;
  private List<ya> sourceDateList;
  
  private List<ya> filledData(String[][] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      ya localya = new ya();
      localya.a = paramArrayOfString[i][1];
      localya.c = paramArrayOfString[i][0];
      String str = this.characterParser.a(paramArrayOfString[i][1]).substring(0, 1).toUpperCase();
      if (str.matches("[A-Z]")) {
        localya.b = str.toUpperCase();
      } else {
        localya.b = "#";
      }
      localArrayList.add(localya);
      i += 1;
    }
    return localArrayList;
  }
  
  private void init()
  {
    this.characterParser = xq.a();
    this.pinyinComparator = new xu();
    this.sortListView = ((ListView)findViewById(2131165675));
    this.sideBar = ((RightLetterView)findViewById(2131165953));
    this.sideBar.setOnTouchingLetterChangedListener(new a((byte)0));
    this.sourceDateList = filledData(xs.b);
    List localList = filledData(xs.c);
    Collections.sort(localList, this.pinyinComparator);
    this.sourceDateList.addAll(localList);
    this.adapter = new xz(this, this.sourceDateList, new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        int i = ((Integer)paramAnonymousView.getTag()).intValue();
        paramAnonymousView = new Intent();
        paramAnonymousView.putExtra("name", ((ya)SelectCountryCodeActivity.this.sourceDateList.get(i)).a);
        SelectCountryCodeActivity localSelectCountryCodeActivity = SelectCountryCodeActivity.this;
        localSelectCountryCodeActivity.setResult(Integer.parseInt(((ya)localSelectCountryCodeActivity.sourceDateList.get(i)).c), paramAnonymousView);
        SelectCountryCodeActivity.this.finish();
      }
    });
    this.sortListView.setAdapter(this.adapter);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(2131296433);
    init();
  }
  
  final class a
    implements RightLetterView.a
  {
    private a() {}
    
    public final void a(int paramInt)
    {
      xz localxz = SelectCountryCodeActivity.this.adapter;
      String str = xs.a[paramInt];
      paramInt = 10;
      while (paramInt < localxz.getCount())
      {
        if (str.equals(((ya)localxz.a.get(paramInt)).b)) {
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