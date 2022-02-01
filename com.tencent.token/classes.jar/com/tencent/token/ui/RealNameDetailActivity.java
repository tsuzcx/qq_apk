package com.tencent.token.ui;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.token.core.bean.ZzbIntroItem;
import com.tencent.token.ui.base.ScrollLayout;
import com.tencent.token.ui.base.ScrollLayout.a;
import com.tencent.token.utils.m;
import java.util.ArrayList;

public class RealNameDetailActivity
  extends Activity
{
  TextView desc1;
  TextView desc2;
  TextView desc3;
  TextView desc4;
  ImageView iv1;
  ImageView iv2;
  ImageView iv3;
  ImageView iv4;
  int tab;
  TextView title1;
  TextView title2;
  TextView title3;
  TextView title4;
  
  private String formatText(String paramString)
  {
    return m.a(paramString, getResources().getDimension(2131034251), (int)(IndexActivity.S_RES_WIDTH * IndexActivity.S_DENSITY));
  }
  
  private void initTextInfo()
  {
    this.title1 = ((TextView)findViewById(2131165499).findViewById(2131166106));
    this.title2 = ((TextView)findViewById(2131166178).findViewById(2131166106));
    this.title3 = ((TextView)findViewById(2131166077).findViewById(2131166106));
    this.title4 = ((TextView)findViewById(2131165504).findViewById(2131166106));
    this.desc1 = ((TextView)findViewById(2131165499).findViewById(2131166056));
    this.desc2 = ((TextView)findViewById(2131166178).findViewById(2131166056));
    this.desc3 = ((TextView)findViewById(2131166077).findViewById(2131166056));
    this.desc4 = ((TextView)findViewById(2131165504).findViewById(2131166056));
    ArrayList localArrayList = m.l();
    if ((localArrayList != null) && (localArrayList.size() > 0)) {
      try
      {
        this.title1.setText(((ZzbIntroItem)localArrayList.get(0)).a().toString());
        this.desc1.setText(formatText(((ZzbIntroItem)localArrayList.get(0)).b().toString()));
        this.title2.setText(((ZzbIntroItem)localArrayList.get(1)).a().toString());
        this.desc2.setText(formatText(((ZzbIntroItem)localArrayList.get(1)).b().toString()));
        this.title3.setText(((ZzbIntroItem)localArrayList.get(2)).a().toString());
        this.desc3.setText(formatText(((ZzbIntroItem)localArrayList.get(2)).b().toString()));
        this.title4.setText(((ZzbIntroItem)localArrayList.get(3)).a().toString());
        this.desc4.setText(formatText(((ZzbIntroItem)localArrayList.get(3)).b().toString()));
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
  
  private void initview()
  {
    setContentView(2131296412);
    initTextInfo();
    Object localObject = (ScrollLayout)findViewById(2131165190);
    ((ScrollLayout)localObject).setToScreen(this.tab);
    ((ScrollLayout)localObject).setOnScrollListner(new ScrollLayout.a()
    {
      public void a(int paramAnonymousInt)
      {
        RealNameDetailActivity.this.iv1.setImageResource(2131100009);
        RealNameDetailActivity.this.iv2.setImageResource(2131100009);
        RealNameDetailActivity.this.iv3.setImageResource(2131100009);
        RealNameDetailActivity.this.iv4.setImageResource(2131100009);
        switch (paramAnonymousInt)
        {
        default: 
          return;
        case 3: 
          RealNameDetailActivity.this.iv4.setImageResource(2131100010);
          return;
        case 2: 
          RealNameDetailActivity.this.iv3.setImageResource(2131100010);
          return;
        case 1: 
          RealNameDetailActivity.this.iv2.setImageResource(2131100010);
          return;
        }
        RealNameDetailActivity.this.iv1.setImageResource(2131100010);
      }
    });
    localObject = (Button)findViewById(2131165434);
    this.iv1 = ((ImageView)findViewById(2131165616));
    this.iv2 = ((ImageView)findViewById(2131165617));
    this.iv3 = ((ImageView)findViewById(2131165618));
    this.iv4 = ((ImageView)findViewById(2131165619));
    switch (this.tab)
    {
    default: 
      break;
    case 3: 
      this.iv4.setImageResource(2131100010);
      break;
    case 2: 
      this.iv3.setImageResource(2131100010);
      break;
    case 1: 
      this.iv2.setImageResource(2131100010);
      break;
    case 0: 
      this.iv1.setImageResource(2131100010);
    }
    ((Button)localObject).setOnClickListener(new View.OnClickListener()
    {
      public void onClick(View paramAnonymousView)
      {
        RealNameDetailActivity.this.finish();
      }
    });
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    requestWindowFeature(1);
    setTheme(2131558670);
    this.tab = getIntent().getIntExtra("index", 0);
    initview();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.RealNameDetailActivity
 * JD-Core Version:    0.7.0.1
 */