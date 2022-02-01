package com.tencent.mobileqq.facetoface;

import acfp;
import agav;
import agaw;
import agay;
import agba;
import agbb;
import agbc;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import aqdj;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class Face2FaceFriendBubbleView
  extends FrameLayout
{
  private static final int[] ll = { 2131367720, 2131367701 };
  private View CK;
  private TextView Sa;
  private Animation aE;
  private Animation aF;
  private ProgressBar aa;
  private String bGf = "";
  private int bKa;
  private int cWl;
  private LinearLayout gh;
  private HashMap<View, Integer> kB;
  private int mStatus = 1;
  private String mUin;
  private int mUinType = 1;
  private Animation.AnimationListener v = new agav(this);
  private Animation.AnimationListener w = new agaw(this);
  private ImageView zA;
  private ImageView zB;
  private ImageView zC;
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public Face2FaceFriendBubbleView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, 0);
    ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(2131559322, this);
    this.gh = ((LinearLayout)findViewById(2131367717));
    this.zA = ((ImageView)findViewById(2131367680));
    this.zB = ((ImageView)findViewById(2131380284));
    this.CK = findViewById(2131367720);
    this.zC = ((ImageView)findViewById(2131367719));
    this.aa = ((ProgressBar)findViewById(2131378728));
    this.Sa = ((TextView)findViewById(2131367703));
    this.Sa.setContentDescription("");
    this.aE = AnimationUtils.loadAnimation(paramContext, 2130772076);
    this.aF = AnimationUtils.loadAnimation(paramContext, 2130772075);
    this.aE.setAnimationListener(this.v);
    this.aF.setAnimationListener(this.w);
  }
  
  public void a(QQAppInterface paramQQAppInterface, agba paramagba)
  {
    if (paramagba == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.TAG, 2, "bindFriendInfo Face2FaceUserData is Null~~~~~");
      }
      return;
    }
    setTag(paramagba);
    this.mUin = paramagba.bGh;
    this.mUinType = paramagba.type;
    this.bGf = paramagba.bGh;
    if ((paramagba instanceof agay)) {
      this.bGf = (paramagba.bGh + "_" + ((agay)paramagba).bGg);
    }
    String str = paramagba.bGh;
    int j = this.mUinType;
    Object localObject;
    int i;
    if (this.mUinType == 1)
    {
      paramagba = (agbc)paramagba;
      if (TextUtils.isEmpty(paramagba.remark))
      {
        localObject = paramagba.nick;
        this.Sa.setLines(1);
        this.zB.setVisibility(8);
        i = j;
        label153:
        if (localObject != null) {
          break label422;
        }
        paramagba = this.mUin;
      }
    }
    for (;;)
    {
      this.Sa.setText(paramagba);
      x(paramQQAppInterface, this.mUin, i);
      return;
      localObject = paramagba.remark;
      break;
      localObject = str;
      i = j;
      if (this.mUinType != 2) {
        break label153;
      }
      if ((paramagba instanceof agbb))
      {
        localObject = ((agbb)paramagba).userNick;
        this.Sa.setLines(1);
        this.zB.setVisibility(8);
        i = 1;
        break label153;
      }
      localObject = str;
      i = j;
      if (!(paramagba instanceof agay)) {
        break label153;
      }
      paramagba = ((agay)paramagba).troopName;
      this.zB.setVisibility(0);
      if (this.cWl < 1)
      {
        this.bKa = BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131297212);
        this.cWl = BaseApplicationImpl.getContext().getResources().getDrawable(2130840395).getIntrinsicWidth();
      }
      this.Sa.setLines(2);
      this.Sa.setMaxWidth(this.bKa - this.cWl);
      localObject = paramagba;
      i = j;
      if (!QLog.isColorLevel()) {
        break label153;
      }
      QLog.e("zivonchen", 2, "nickMaxWidth = " + this.bKa + ", flagWidth = " + this.cWl + ", realWidth = " + (this.bKa - this.cWl));
      localObject = paramagba;
      i = j;
      break label153;
      label422:
      paramagba = (agba)localObject;
      if (TextUtils.isEmpty(((String)localObject).trim())) {
        paramagba = this.mUin;
      }
    }
  }
  
  public void deH()
  {
    int j = ll.length;
    if (this.kB == null) {
      this.kB = new HashMap(j);
    }
    for (;;)
    {
      int i = 0;
      while (i < j)
      {
        View localView = findViewById(ll[i]);
        int k = localView.getVisibility();
        this.kB.put(localView, Integer.valueOf(k));
        if (k == 0)
        {
          Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772073);
          localAnimation.setAnimationListener(new a(1, localView));
          localView.startAnimation(localAnimation);
        }
        i += 1;
      }
      if (!this.kB.isEmpty()) {
        this.kB.clear();
      }
    }
  }
  
  public void deI()
  {
    int j = ll.length;
    if ((this.kB == null) || (this.kB.size() != j))
    {
      if (this.kB != null) {
        this.kB.clear();
      }
      if (QLog.isColorLevel()) {
        QLog.e(Face2FaceAddFriendActivity.TAG, 2, "restoreAndHideLables error: ids.size not equals cache.size~~~~~");
      }
      return;
    }
    int i = 0;
    while (i < j)
    {
      View localView = findViewById(ll[i]);
      if ((((Integer)this.kB.get(localView)).intValue() == 0) && (localView.getVisibility() == 4))
      {
        Animation localAnimation = AnimationUtils.loadAnimation(BaseApplicationImpl.getContext(), 2130772074);
        localAnimation.setAnimationListener(new a(0, localView));
        localView.startAnimation(localAnimation);
      }
      i += 1;
    }
    this.kB.clear();
  }
  
  public agba g()
  {
    if (getTag() != null) {
      return (agba)getTag();
    }
    return null;
  }
  
  public String getDisplayName()
  {
    String str2 = this.Sa.getText().toString();
    String str1 = str2;
    if (TextUtils.isEmpty(str2.trim())) {
      str1 = this.mUin;
    }
    return str1;
  }
  
  public int getStatus()
  {
    return this.mStatus;
  }
  
  public String getUin()
  {
    return this.mUin;
  }
  
  public int lk()
  {
    return this.mUinType;
  }
  
  public void setStatusWithAnimation(int paramInt)
  {
    String str2;
    String str1;
    switch (paramInt)
    {
    default: 
      str2 = getDisplayName();
      if (paramInt == 2) {
        str1 = str2 + acfp.m(2131706018);
      }
      break;
    }
    for (;;)
    {
      this.zA.setContentDescription(str1);
      this.gh.setContentDescription(str1);
      return;
      this.mStatus = paramInt;
      if (this.CK.getVisibility() != 0) {
        break;
      }
      this.CK.startAnimation(this.aF);
      break;
      this.mStatus = paramInt;
      if (this.CK.getVisibility() == 0)
      {
        this.CK.startAnimation(this.aF);
        break;
      }
      if (this.CK.getVisibility() == 8) {
        this.CK.setVisibility(4);
      }
      this.CK.startAnimation(this.aE);
      break;
      if (paramInt == 3)
      {
        str1 = str2 + acfp.m(2131706016);
      }
      else
      {
        str1 = str2;
        if (paramInt == 4) {
          str1 = str2 + acfp.m(2131706020);
        }
      }
    }
  }
  
  public void setStatusWithoutAnimation(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 1: 
      this.mStatus = paramInt;
      this.CK.setVisibility(8);
      return;
    case 2: 
      this.mStatus = paramInt;
      this.aa.setVisibility(8);
      this.zC.setImageResource(2130840376);
      this.zC.setVisibility(0);
      this.CK.setVisibility(0);
      return;
    case 3: 
      this.mStatus = paramInt;
      this.aa.setVisibility(8);
      this.zC.setImageResource(2130840377);
      this.zC.setVisibility(0);
      this.CK.setVisibility(0);
      return;
    }
    this.mStatus = paramInt;
    this.aa.setVisibility(0);
    this.zC.setImageResource(2130840378);
    this.zC.setVisibility(0);
    this.CK.setVisibility(0);
  }
  
  public String uU()
  {
    return this.bGf;
  }
  
  public void vD(String paramString)
  {
    this.Sa.setText(paramString);
  }
  
  public void x(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    if (paramInt == 1)
    {
      paramQQAppInterface = aqdj.a(paramQQAppInterface, 1, paramString);
      this.zA.setImageDrawable(paramQQAppInterface);
    }
    while (paramInt != 2) {
      return;
    }
    paramQQAppInterface = aqdj.a(paramQQAppInterface, 4, paramString);
    this.zA.setImageDrawable(paramQQAppInterface);
  }
  
  class a
    implements Animation.AnimationListener
  {
    private int aYL = 0;
    private View mView;
    
    public a(int paramInt, View paramView)
    {
      this.aYL = paramInt;
      this.mView = paramView;
    }
    
    public void onAnimationEnd(Animation paramAnimation)
    {
      if (this.mView == null) {}
      do
      {
        return;
        if (this.aYL == 0)
        {
          this.mView.setVisibility(0);
          return;
        }
      } while (this.aYL != 1);
      this.mView.setVisibility(4);
    }
    
    public void onAnimationRepeat(Animation paramAnimation) {}
    
    public void onAnimationStart(Animation paramAnimation) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.facetoface.Face2FaceFriendBubbleView
 * JD-Core Version:    0.7.0.1
 */