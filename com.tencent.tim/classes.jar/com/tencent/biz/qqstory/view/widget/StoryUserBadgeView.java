package com.tencent.biz.qqstory.view.widget;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.QQUserUIItem;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.specialcare.SpecailCareListActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.HashMap;
import pmi;
import ppg.d;
import psx;
import ptf;
import pxq.c;
import ram;
import rar;
import rom;
import rpq;

public class StoryUserBadgeView
  extends ImageView
  implements View.OnClickListener, IEventReceiver
{
  private boolean Dr;
  private a a;
  private String aBZ;
  private ptf b;
  private int mSource;
  private int mType = 10003;
  
  public StoryUserBadgeView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public StoryUserBadgeView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public StoryUserBadgeView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void init()
  {
    this.b = ((ptf)psx.a(2));
    this.a = new a(this);
    super.setVisibility(8);
  }
  
  private void update()
  {
    if ("-1".equals(this.aBZ))
    {
      ram.e("Q.qqstory.StoryUserBadge", "union id = -1, so ignore update");
      return;
    }
    QQUserUIItem localQQUserUIItem = this.b.b(this.aBZ);
    rpq.p(this);
    if (localQQUserUIItem == null)
    {
      this.mType = 10003;
      super.setVisibility(8);
      super.setOnClickListener(null);
      return;
    }
    String str = localQQUserUIItem.getUserIconUrl();
    if ((!TextUtils.isEmpty(str)) || (localQQUserUIItem.isVipButNoFriend()))
    {
      if (ppg.d.IE())
      {
        if (localQQUserUIItem.isVipButNoFriend()) {}
        for (int i = 10000;; i = 10001)
        {
          this.mType = i;
          super.setVisibility(0);
          super.setOnClickListener(this);
          if (TextUtils.isEmpty(str)) {
            break;
          }
          rpq.a(this, str, 50, 50, null, null);
          return;
        }
        super.setImageResource(2130847706);
        return;
      }
      super.setVisibility(8);
      return;
    }
    if (this.b.fg(localQQUserUIItem.qq))
    {
      this.mType = 10002;
      super.setVisibility(0);
      super.setOnClickListener(this);
      super.setImageResource(2130847704);
      return;
    }
    this.mType = 10003;
    super.setVisibility(8);
    super.setOnClickListener(null);
  }
  
  public void aCG()
  {
    Object localObject = this.b.b(this.aBZ);
    if (localObject == null)
    {
      ram.e("Q.qqstory.StoryUserBadge", "reportExposure the null user item");
      return;
    }
    if (((QQUserUIItem)localObject).isMe()) {}
    for (String str = "1";; str = "2")
    {
      localObject = ((QQUserUIItem)localObject).getUserIconUrlKey();
      rar.a("home_page", "exp_medal", this.mSource, 0, new String[] { str, localObject });
      return;
    }
  }
  
  public boolean isValidate()
  {
    return this.Dr;
  }
  
  public String nf()
  {
    return this.aBZ;
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    this.Dr = true;
    pmi.a().registerSubscriber(this.a);
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = this.b.b(this.aBZ);
    if (localObject2 == null) {
      ram.e("Q.qqstory.StoryUserBadge", this.aBZ + ",userItem is null ! plz fix it!");
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if ((this.mType != 10000) && (this.mType != 10001)) {
        break label186;
      }
      if (!TextUtils.isEmpty(((QQUserUIItem)localObject2).getUserIconJumpURL())) {
        break;
      }
      ram.e("Q.qqstory.StoryUserBadge", ((QQUserUIItem)localObject2).getUnionId() + ",icon jump url is null!!");
    }
    Object localObject1 = new Intent(getContext(), QQBrowserActivity.class);
    ((Intent)localObject1).putExtra("url", ((QQUserUIItem)localObject2).getUserIconJumpURL());
    getContext().startActivity((Intent)localObject1);
    label144:
    if (((QQUserUIItem)localObject2).isMe()) {}
    for (localObject1 = "1";; localObject1 = "2")
    {
      localObject2 = ((QQUserUIItem)localObject2).getIconJumpUrlKey();
      rar.a("home_page", "clk_medal", this.mSource, 0, new String[] { localObject1, localObject2 });
      break;
      label186:
      if (this.mType != 10002) {
        break label144;
      }
      localObject1 = new Intent(getContext(), SpecailCareListActivity.class);
      getContext().startActivity((Intent)localObject1);
      break label144;
    }
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    this.Dr = false;
    pmi.a().unRegisterSubscriber(this.a);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
  }
  
  protected void sJ(@NonNull String paramString)
  {
    setUnionID(paramString, this.mSource);
  }
  
  public void setUnionID(@NonNull String paramString, int paramInt)
  {
    if (TextUtils.isEmpty(paramString))
    {
      rom.assertTrue(false, "It is not allow to set the null union id!!!!!!");
      return;
    }
    this.mSource = paramInt;
    this.aBZ = paramString;
    update();
  }
  
  public static class a
    extends QQUIEventReceiver<StoryUserBadgeView, pxq.c>
  {
    public a(@NonNull StoryUserBadgeView paramStoryUserBadgeView)
    {
      super();
    }
    
    public void a(@NonNull StoryUserBadgeView paramStoryUserBadgeView, @NonNull pxq.c paramc)
    {
      if (paramc.b.isFail()) {}
      while (paramc.fl.get(paramStoryUserBadgeView.nf()) == null) {
        return;
      }
      paramStoryUserBadgeView.sJ(paramStoryUserBadgeView.nf());
    }
    
    public Class acceptEventClass()
    {
      return pxq.c.class;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qqstory.view.widget.StoryUserBadgeView
 * JD-Core Version:    0.7.0.1
 */