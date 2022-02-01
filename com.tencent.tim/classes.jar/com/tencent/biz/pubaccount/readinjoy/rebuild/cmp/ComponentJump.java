package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.Iterator;
import java.util.List;
import lie;
import lkg;
import lwl;
import lwm.a;
import mas;
import mcp;
import mcq;
import mcr;
import mcs;
import tencent.im.oidb.articlesummary.articlesummary.PackJumpInfo;

public class ComponentJump
  extends RelativeLayout
  implements lwl
{
  mas a;
  public View[] k;
  public View kP;
  public TextView[] n;
  
  public ComponentJump(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentJump(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentJump(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo)
  {
    int i = 0;
    while (i < 4)
    {
      this.n[i].setOnClickListener(null);
      i += 1;
    }
    this.kP.setOnClickListener(null);
    switch (paramInt)
    {
    }
    List localList;
    int j;
    for (;;)
    {
      localList = null;
      for (;;)
      {
        if ((localList != null) && (localList.size() == 1)) {
          a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
        }
        if ((localList == null) || (localList.size() <= 1)) {
          break label209;
        }
        j = 1;
        i = 0;
        while (i < localList.size())
        {
          if (((articlesummary.PackJumpInfo)localList.get(i)).enum_style.get() != 2) {
            j = 0;
          }
          i += 1;
        }
        localList = lkg.a(paramArticleInfo);
        continue;
        localList = lkg.b(paramArticleInfo);
      }
      a(paramInt, paramArticleInfo, null);
    }
    if (j != 0)
    {
      a(paramInt, paramArticleInfo, (articlesummary.PackJumpInfo)localList.get(0));
      label209:
      return;
    }
    a(paramInt, paramArticleInfo, localList);
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, List<articlesummary.PackJumpInfo> paramList)
  {
    this.kP.setOnClickListener(null);
    paramInt = 0;
    while (paramInt < 3)
    {
      this.n[paramInt].setVisibility(8);
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.k[(paramInt - 1)].setVisibility(8);
      }
      paramInt += 1;
    }
    this.n[3].setVisibility(8);
    paramArticleInfo = paramList.iterator();
    Object localObject1;
    int i;
    for (paramInt = 0; paramArticleInfo.hasNext(); paramInt = i)
    {
      localObject1 = (articlesummary.PackJumpInfo)paramArticleInfo.next();
      i = paramInt;
      if (((articlesummary.PackJumpInfo)localObject1).enum_style.get() == 2)
      {
        i = paramInt;
        if (paramInt == 0)
        {
          Object localObject2 = (RelativeLayout.LayoutParams)this.n[3].getLayoutParams();
          ((RelativeLayout.LayoutParams)localObject2).addRule(11, -1);
          ((RelativeLayout.LayoutParams)localObject2).addRule(9, 0);
          this.n[3].setLayoutParams((ViewGroup.LayoutParams)localObject2);
          this.n[3].setVisibility(0);
          this.n[3].setText(((articlesummary.PackJumpInfo)localObject1).str_wording.get());
          localObject2 = ((articlesummary.PackJumpInfo)localObject1).str_url.get();
          localObject1 = ((articlesummary.PackJumpInfo)localObject1).str_wording.get();
          this.n[3].setOnClickListener(new mcr(this, (String)localObject1, (String)localObject2));
          i = 1;
        }
        paramArticleInfo.remove();
      }
    }
    paramInt = 0;
    while (paramInt < Math.min(3, paramList.size()))
    {
      this.n[paramInt].setVisibility(0);
      this.n[paramInt].setText(((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get());
      paramArticleInfo = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_url.get();
      localObject1 = ((articlesummary.PackJumpInfo)paramList.get(paramInt)).str_wording.get();
      this.n[paramInt].setOnClickListener(new mcs(this, (String)localObject1, paramArticleInfo));
      if ((paramInt - 1 >= 0) && (paramInt - 1 <= 1)) {
        this.k[(paramInt - 1)].setVisibility(0);
      }
      paramInt += 1;
    }
  }
  
  private void a(int paramInt, ArticleInfo paramArticleInfo, articlesummary.PackJumpInfo paramPackJumpInfo)
  {
    int i = 0;
    while (i < 3)
    {
      this.n[i].setVisibility(8);
      if ((i - 1 >= 0) && (i - 1 <= 1)) {
        this.k[(i - 1)].setVisibility(8);
      }
      i += 1;
    }
    this.n[3].setVisibility(8);
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
    case 3: 
      paramArticleInfo = new mcp(this, paramPackJumpInfo);
      if (paramPackJumpInfo.enum_style.get() == 2)
      {
        localLayoutParams = (RelativeLayout.LayoutParams)this.n[3].getLayoutParams();
        localLayoutParams.addRule(11, 0);
        localLayoutParams.addRule(9, -1);
        this.n[3].setLayoutParams(localLayoutParams);
        this.n[3].setVisibility(0);
        this.n[3].setText(paramPackJumpInfo.str_wording.get());
        this.n[3].setOnClickListener(paramArticleInfo);
        this.kP.setOnClickListener(paramArticleInfo);
        return;
      }
      this.n[0].setVisibility(0);
      this.n[0].setText(paramPackJumpInfo.str_wording.get());
      this.n[0].setOnClickListener(paramArticleInfo);
      this.kP.setOnClickListener(paramArticleInfo);
      return;
    }
    paramPackJumpInfo = new mcq(this, paramArticleInfo);
    RelativeLayout.LayoutParams localLayoutParams = (RelativeLayout.LayoutParams)this.n[3].getLayoutParams();
    localLayoutParams.addRule(11, 0);
    localLayoutParams.addRule(9, -1);
    this.n[3].setLayoutParams(localLayoutParams);
    this.n[3].setVisibility(0);
    this.n[3].setText(paramArticleInfo.mChannelInfoDisplayName);
    this.n[3].setOnClickListener(paramPackJumpInfo);
    this.kP.setOnClickListener(paramPackJumpInfo);
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    this.n = new TextView[4];
    this.k = new View[2];
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      aNf();
      if (!this.a.a.Cq()) {
        break label88;
      }
    }
    label88:
    for (int i = 0;; i = 8)
    {
      setVisibility(i);
      if (this.a.a.Cq()) {
        a(this.a.a.getJumpType(), this.a.a.a());
      }
      return;
    }
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf() {}
  
  public void init(Context paramContext)
  {
    this.kP = LayoutInflater.from(paramContext).inflate(2131560251, this, true);
    this.n[0] = ((TextView)this.kP.findViewById(2131369996));
    this.n[1] = ((TextView)this.kP.findViewById(2131369998));
    this.n[2] = ((TextView)this.kP.findViewById(2131370000));
    this.n[3] = ((TextView)this.kP.findViewById(2131370001));
    this.k[0] = this.kP.findViewById(2131369997);
    this.k[1] = this.kP.findViewById(2131369999);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentJump
 * JD-Core Version:    0.7.0.1
 */