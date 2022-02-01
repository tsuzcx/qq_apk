package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import kbp;
import kxm;
import lie;
import lwk;
import lwm.a;
import mas;
import ndi;

public class ComponentContentUgcSource
  extends LinearLayout
  implements View.OnClickListener, lwk
{
  private LinearLayout E;
  mas a;
  private String businessUrl;
  TextView qt;
  
  public ComponentContentUgcSource(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentContentUgcSource(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  private void aNc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ComponentContentUgcSource", 2, "business url is " + this.businessUrl);
    }
    if (TextUtils.isEmpty(this.businessUrl)) {}
    Object localObject;
    do
    {
      return;
      localObject = new Intent(getContext(), PublicAccountBrowser.class);
      ((Intent)localObject).putExtra("url", this.businessUrl);
      getContext().startActivity((Intent)localObject);
      localObject = this.a.a.a();
    } while (localObject == null);
    kbp.a((ArticleInfo)localObject);
    ndi.g((ArticleInfo)localObject, this.a.a.nh());
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    if ((paramObject instanceof lie))
    {
      paramObject = (lie)paramObject;
      this.a.setModel(paramObject);
      paramObject = paramObject.a();
      if (paramObject != null) {
        break label46;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ComponentContentUgcSource", 2, "article info is null");
      }
    }
    return;
    label46:
    if ((ndi.ak(paramObject)) || ((ndi.S(paramObject)) && (!ndi.W(paramObject))) || (kxm.n(paramObject)) || ((kxm.o(paramObject)) && (!ndi.V(paramObject))) || (ndi.N(paramObject)))
    {
      localObject = (LinearLayout.LayoutParams)this.E.getLayoutParams();
      ((LinearLayout.LayoutParams)localObject).topMargin = 0;
      this.E.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
    Object localObject = paramObject.businessName;
    SpannableStringBuilder localSpannableStringBuilder = new SpannableStringBuilder();
    if (!TextUtils.isEmpty(paramObject.businessNamePrefix))
    {
      localSpannableStringBuilder.append(paramObject.businessNamePrefix);
      localSpannableStringBuilder.setSpan(new ForegroundColorSpan(Color.parseColor("#07D0B0")), 0, localSpannableStringBuilder.length(), 33);
    }
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      this.qt.setText("");
      setVisibility(8);
    }
    for (;;)
    {
      this.businessUrl = paramObject.businessUrl;
      return;
      localSpannableStringBuilder.append((CharSequence)localObject);
      this.qt.setText(localSpannableStringBuilder);
      setVisibility(0);
    }
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq()
  {
    this.E.setOnClickListener(this);
  }
  
  public void cG(View paramView)
  {
    this.qt = ((TextView)paramView.findViewById(2131381191));
    this.qt.getPaint().setFakeBoldText(true);
    this.E = ((LinearLayout)paramView.findViewById(2131381192));
  }
  
  public View f(Context paramContext)
  {
    return LayoutInflater.from(paramContext).inflate(2131560491, this, true);
  }
  
  public void init(Context paramContext)
  {
    cG(f(paramContext));
  }
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aNc();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentContentUgcSource
 * JD-Core Version:    0.7.0.1
 */