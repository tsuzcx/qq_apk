package com.tencent.biz.pubaccount;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import androidx.annotation.RequiresApi;
import aqnm;
import ausj;
import auss;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.mp.mobileqq_mp.ButtonInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.widget.VerticalCenterImageSpan;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kaw;
import kbm;
import kbn;
import kbo;
import mqq.os.MqqHandler;
import soo;

public class PublicAccountMenuBar
  extends LinearLayout
{
  private boolean adu;
  private MqqHandler f;
  private QQAppInterface mAppInterface;
  private Context mContext;
  private String mUin;
  
  public PublicAccountMenuBar(Context paramContext)
  {
    super(paramContext);
    init(paramContext);
  }
  
  public PublicAccountMenuBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PublicAccountMenuBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  @RequiresApi(api=21)
  public PublicAccountMenuBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt1, int paramInt2)
  {
    super(paramContext, paramAttributeSet, paramInt1, paramInt2);
    init(paramContext);
  }
  
  private List<mobileqq_mp.ButtonInfo> E(List<mobileqq_mp.ButtonInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        mobileqq_mp.ButtonInfo localButtonInfo = (mobileqq_mp.ButtonInfo)paramList.next();
        if ((localButtonInfo.url.has()) || (localButtonInfo.sub_button.has())) {
          localArrayList.add(localButtonInfo);
        }
      }
    }
    return localArrayList;
  }
  
  private CharSequence a(soo paramsoo)
  {
    if (paramsoo == null) {
      return "";
    }
    Object localObject = this.mContext.getResources().getDrawable(2130842469);
    paramsoo = new SpannableStringBuilder("[]" + paramsoo.getTitle());
    ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
    localObject = new VerticalCenterImageSpan((Drawable)localObject, 0);
    ((VerticalCenterImageSpan)localObject).setPadding(aqnm.dip2px(6.0F), aqnm.dip2px(6.0F));
    paramsoo.setSpan(localObject, 0, "[]".length(), 18);
    return paramsoo;
  }
  
  private void a(mobileqq_mp.ButtonInfo paramButtonInfo)
  {
    if (paramButtonInfo == null) {}
    label42:
    label60:
    label98:
    Object localObject3;
    label119:
    Object localObject4;
    label161:
    label181:
    label234:
    label241:
    label246:
    label251:
    do
    {
      return;
      if (paramButtonInfo.key.has())
      {
        localObject1 = paramButtonInfo.key.get();
        if (!paramButtonInfo.name.has()) {
          break label234;
        }
        localObject2 = paramButtonInfo.name.get();
        if (!paramButtonInfo.id.has()) {
          break label241;
        }
        i = paramButtonInfo.id.get();
        localObject2 = new soo((String)localObject1, (String)localObject2, null, i);
        ((soo)localObject2).b(paramButtonInfo);
        if (!paramButtonInfo.sub_button.has()) {
          break label246;
        }
        paramButtonInfo = paramButtonInfo.sub_button.get();
        if ((paramButtonInfo == null) || (paramButtonInfo.size() <= 0)) {
          break label268;
        }
        localObject3 = paramButtonInfo.iterator();
        if (!((Iterator)localObject3).hasNext()) {
          break label268;
        }
        localObject4 = (mobileqq_mp.ButtonInfo)((Iterator)localObject3).next();
        if (!((mobileqq_mp.ButtonInfo)localObject4).key.has()) {
          break label251;
        }
        paramButtonInfo = ((mobileqq_mp.ButtonInfo)localObject4).key.get();
        if (!((mobileqq_mp.ButtonInfo)localObject4).name.has()) {
          break label257;
        }
        localObject1 = ((mobileqq_mp.ButtonInfo)localObject4).name.get();
        if (!((mobileqq_mp.ButtonInfo)localObject4).id.has()) {
          break label263;
        }
      }
      for (int i = ((mobileqq_mp.ButtonInfo)localObject4).id.get();; i = 0)
      {
        paramButtonInfo = new soo(paramButtonInfo, (String)localObject1, null, i);
        paramButtonInfo.b((mobileqq_mp.ButtonInfo)localObject4);
        ((soo)localObject2).b(paramButtonInfo);
        break label119;
        localObject1 = "";
        break;
        localObject2 = "";
        break label42;
        i = 0;
        break label60;
        paramButtonInfo = null;
        break label98;
        paramButtonInfo = "";
        break label161;
        localObject1 = "";
        break label181;
      }
      paramButtonInfo = ((soo)localObject2).co();
    } while ((paramButtonInfo == null) || (paramButtonInfo.size() <= 0));
    label257:
    label263:
    label268:
    Object localObject1 = (ausj)auss.a(this.mContext, null);
    ((ausj)localObject1).Wc(true);
    Object localObject2 = paramButtonInfo.iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = (soo)((Iterator)localObject2).next();
      if (localObject3 != null)
      {
        localObject4 = ((soo)localObject3).nE();
        if (!TextUtils.isEmpty((CharSequence)localObject4)) {
          ((ausj)localObject1).jm(((soo)localObject3).getTitle(), (String)localObject4);
        } else {
          ((ausj)localObject1).addButton(((soo)localObject3).getTitle());
        }
      }
    }
    ((ausj)localObject1).addCancelButton(2131691246);
    ((ausj)localObject1).a(new kbn(this, paramButtonInfo, (ausj)localObject1));
    ((ausj)localObject1).setOnDismissListener(new kbo(this));
    ((ausj)localObject1).show();
  }
  
  private void a(soo paramsoo)
  {
    if (paramsoo != null) {}
    try
    {
      String str = paramsoo.eo();
      int i = paramsoo.hF();
      if ((this.mAppInterface != null) && (this.mUin != null) && (this.f != null)) {
        kaw.a().a(str, this.mContext, this.mAppInterface, this.mUin, i, null, this.f, 2, new SessionInfo());
      }
      return;
    }
    catch (Exception paramsoo)
    {
      paramsoo.printStackTrace();
    }
  }
  
  private void a(soo paramsoo, mobileqq_mp.ButtonInfo paramButtonInfo, boolean paramBoolean)
  {
    if (paramsoo == null) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(this.mContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -1);
    localLayoutParams.weight = 1.0F;
    Object localObject = new TextView(this.mContext);
    boolean bool = paramButtonInfo.sub_button.has();
    if (bool) {
      ((TextView)localObject).setText(a(paramsoo));
    }
    for (;;)
    {
      ((TextView)localObject).setTextSize(16.0F);
      ((TextView)localObject).setTextColor(-16777216);
      RelativeLayout.LayoutParams localLayoutParams1 = new RelativeLayout.LayoutParams(-2, -2);
      localLayoutParams1.addRule(13, -1);
      localRelativeLayout.addView((View)localObject, localLayoutParams1);
      if (!paramBoolean)
      {
        localObject = new View(this.mContext);
        ((View)localObject).setBackgroundResource(2130850700);
        localLayoutParams1 = new RelativeLayout.LayoutParams(aqnm.dip2px(0.5F), aqnm.dip2px(10.0F));
        localLayoutParams1.addRule(11, -1);
        localLayoutParams1.addRule(15, -1);
        localRelativeLayout.addView((View)localObject, localLayoutParams1);
      }
      localRelativeLayout.setOnClickListener(new kbm(this, bool, paramButtonInfo, paramsoo));
      addView(localRelativeLayout, localLayoutParams);
      return;
      ((TextView)localObject).setText(paramsoo.getTitle());
    }
  }
  
  private void init(Context paramContext)
  {
    this.mContext = paramContext;
    setVisibility(8);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString, MqqHandler paramMqqHandler)
  {
    this.mAppInterface = paramQQAppInterface;
    this.mUin = paramString;
    this.f = paramMqqHandler;
  }
  
  public void setData(List<mobileqq_mp.ButtonInfo> paramList)
  {
    List localList = E(paramList);
    if ((localList == null) || (localList.size() <= 0)) {
      return;
    }
    setVisibility(0);
    int k = localList.size();
    removeAllViews();
    int i = 0;
    label43:
    mobileqq_mp.ButtonInfo localButtonInfo;
    label82:
    String str;
    label103:
    int j;
    if (i < k)
    {
      localButtonInfo = (mobileqq_mp.ButtonInfo)localList.get(i);
      if (!localButtonInfo.key.has()) {
        break label169;
      }
      paramList = localButtonInfo.key.get();
      if (!localButtonInfo.name.has()) {
        break label175;
      }
      str = localButtonInfo.name.get();
      if (!localButtonInfo.id.has()) {
        break label182;
      }
      j = localButtonInfo.id.get();
      label123:
      paramList = new soo(paramList, str, null, j);
      paramList.b(localButtonInfo);
      if (i != k - 1) {
        break label187;
      }
    }
    label169:
    label175:
    label182:
    label187:
    for (boolean bool = true;; bool = false)
    {
      a(paramList, localButtonInfo, bool);
      i += 1;
      break label43;
      break;
      paramList = "";
      break label82;
      str = "";
      break label103;
      j = 0;
      break label123;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.PublicAccountMenuBar
 * JD-Core Version:    0.7.0.1
 */