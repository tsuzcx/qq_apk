package com.tencent.biz.pubaccount.readinjoy.rebuild.cmp;

import android.content.Context;
import android.content.res.Resources;
import android.text.SpannableString;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import aqgv;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.widget.StatableSpanTextView.StatableForegroundColorSpan;
import java.util.List;
import kxm;
import lie;
import lwl;
import lwm.a;
import mas;
import mau;
import mav;
import ndi;
import tencent.im.oidb.articlesummary.articlesummary.CommentInfo;

public class ComponentComment
  extends FrameLayout
  implements lwl
{
  mas a;
  View mDivider;
  TextView qe;
  TextView qf;
  
  public ComponentComment(Context paramContext)
  {
    super(paramContext);
    bY(paramContext);
  }
  
  public ComponentComment(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    bY(paramContext);
  }
  
  public ComponentComment(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    bY(paramContext);
  }
  
  private void bY(Context paramContext)
  {
    this.a = new mas();
    init(paramContext);
    aHq();
  }
  
  public void P(Object paramObject)
  {
    int i;
    ArticleInfo localArticleInfo;
    long l;
    String str2;
    String str1;
    if ((paramObject instanceof lie))
    {
      this.a.setModel((lie)paramObject);
      aNf();
      if (!this.a.a.Cs()) {
        break label313;
      }
      i = 0;
      setVisibility(i);
      if (this.a.a.Cs())
      {
        localArticleInfo = this.a.a.a();
        paramObject = (articlesummary.CommentInfo)localArticleInfo.mCommentsObj.get(0);
        l = paramObject.uint64_uin.get();
        str2 = paramObject.str_content.get();
        str1 = paramObject.str_jump_url.get();
        if (!kxm.AI()) {
          break label319;
        }
        paramObject = aqgv.A((QQAppInterface)kxm.getAppRuntime(), String.valueOf(l));
        label134:
        String str3 = kxm.ew(paramObject);
        if (str3 == null) {
          break label339;
        }
        paramObject = new SpannableString(str3 + ":  " + str2);
        paramObject.setSpan(new StatableSpanTextView.StatableForegroundColorSpan(getContext().getResources().getColor(2131167595)), 0, str3.length(), 33);
        this.qe.setVisibility(0);
        this.qe.setText(str3 + ":  ");
      }
    }
    for (;;)
    {
      this.qf.setText(paramObject);
      this.qf.setOnClickListener(new mau(this, str1, localArticleInfo));
      this.qe.setOnClickListener(new mav(this, l, localArticleInfo));
      if (!this.a.a.Cu()) {
        break label361;
      }
      this.mDivider.setVisibility(0);
      return;
      label313:
      i = 8;
      break;
      label319:
      paramObject = this.a.a.b().az(l);
      break label134;
      label339:
      paramObject = new SpannableString(str2);
      this.qe.setVisibility(8);
    }
    label361:
    this.mDivider.setVisibility(8);
  }
  
  public void a(lwm.a parama)
  {
    this.a.b(parama);
  }
  
  public void aHq() {}
  
  public void aNf() {}
  
  public void init(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131560246, this, true);
    this.mDivider = paramContext.findViewById(2131365008);
    this.qe = ((TextView)paramContext.findViewById(2131365049));
    this.qf = ((TextView)paramContext.findViewById(2131365047));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment
 * JD-Core Version:    0.7.0.1
 */