package com.tencent.open.agent;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewStub;
import android.view.ViewStub.OnInflateListener;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import artl;
import artp;
import artp.a;
import artr;
import arwt;
import com.tencent.open.agent.datamodel.Friend;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.HashMap;

public class RecommendListManager
  extends LinearLayout
  implements View.OnClickListener, ViewStub.OnInflateListener, artp.a
{
  protected artl b = artl.a();
  protected FriendChooser c;
  protected Handler handler;
  protected HashMap<String, View> pO = new HashMap();
  
  public RecommendListManager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void a(String paramString1, Bitmap paramBitmap, String paramString2)
  {
    this.handler.post(new RecommendListManager.1(this, paramString1, paramBitmap));
  }
  
  public void notifyDataSetChanged()
  {
    int j = this.b.Nf();
    arwt.d("RecommendListManager", "-->notifyDataSetChanged() count = " + j);
    int i = j;
    if (j > 5) {
      i = 5;
    }
    j = 0;
    if (j < i)
    {
      Object localObject = super.getChildAt(j);
      if ((localObject instanceof ViewStub)) {
        ((View)localObject).setVisibility(0);
      }
      for (;;)
      {
        j += 1;
        break;
        localObject = (CheckBox)((View)localObject).findViewById(2131364587);
        Friend localFriend = this.b.a(j);
        if (this.b.so(localFriend.openId)) {
          ((CheckBox)localObject).setChecked(true);
        } else {
          ((CheckBox)localObject).setChecked(false);
        }
      }
    }
  }
  
  public void onClick(View paramView)
  {
    int i;
    CheckBox localCheckBox;
    switch (paramView.getId())
    {
    default: 
      i = -1;
      arwt.d("RecommendListManager", "-->onClick() position = " + i + " v.getId() = " + paramView.getId());
      if ((i != -1) && (i < this.b.Nf()))
      {
        localCheckBox = (CheckBox)paramView.findViewById(2131364587);
        Friend localFriend = this.b.a(i);
        this.c.a(localFriend);
        if (!this.b.so(localFriend.openId)) {
          break label176;
        }
        localCheckBox.setChecked(true);
      }
      break;
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      label176:
      localCheckBox.setChecked(false);
    }
  }
  
  public void onCreate()
  {
    this.handler = new Handler();
    int j = super.getChildCount();
    int i = 0;
    while (i < j)
    {
      ViewStub localViewStub = (ViewStub)super.getChildAt(i);
      localViewStub.setOnInflateListener(this);
      localViewStub.setOnClickListener(this);
      i += 1;
    }
    arwt.d("RecommendListManager", "-->onCreate()");
  }
  
  public void onInflate(ViewStub paramViewStub, View paramView)
  {
    int i = -1;
    Object localObject;
    ImageView localImageView;
    switch (paramView.getId())
    {
    default: 
      arwt.d("RecommendListManager", "-->onInflate() position = " + i);
      paramView.setOnClickListener(this);
      paramViewStub = this.b.a(i);
      if ((paramViewStub.cCh == null) || ("".equals(paramViewStub.cCh))) {
        paramViewStub.cCh = artr.cg(this.c.getAppid(), paramViewStub.openId);
      }
      this.pO.put(paramViewStub.cCh, paramView);
      localObject = (CheckBox)paramView.findViewById(2131364587);
      localImageView = (ImageView)paramView.findViewById(2131368698);
      paramView = (TextView)paramView.findViewById(2131372190);
      if (this.b.so(paramViewStub.openId))
      {
        ((CheckBox)localObject).setChecked(true);
        label180:
        localObject = artp.a().Q(paramViewStub.cCh);
        if (localObject != null) {
          break label277;
        }
        localImageView.setImageResource(2130840645);
        artp.a().a(paramViewStub.cCh, this);
      }
      break;
    }
    for (;;)
    {
      if ((paramViewStub.label != null) && (!"".equals(paramViewStub.label))) {
        break label287;
      }
      paramView.setText(paramViewStub.nickName);
      return;
      i = 0;
      break;
      i = 1;
      break;
      i = 2;
      break;
      i = 3;
      break;
      i = 4;
      break;
      ((CheckBox)localObject).setChecked(false);
      break label180;
      label277:
      localImageView.setImageBitmap((Bitmap)localObject);
    }
    label287:
    paramView.setText(paramViewStub.label);
  }
  
  public void setActivity(FriendChooser paramFriendChooser)
  {
    this.c = paramFriendChooser;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.RecommendListManager
 * JD-Core Version:    0.7.0.1
 */