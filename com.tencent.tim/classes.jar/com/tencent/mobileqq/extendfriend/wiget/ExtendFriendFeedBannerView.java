package com.tencent.mobileqq.extendfriend.wiget;

import aepf.a;
import afsi;
import aftf;
import aftg;
import afth;
import afth.a;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public class ExtendFriendFeedBannerView
  extends TabLayout
{
  private aftf a;
  private afth b;
  private QQAppInterface mApp;
  
  public ExtendFriendFeedBannerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public ExtendFriendFeedBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public ExtendFriendFeedBannerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(afth.a parama)
  {
    if (this.b == null) {
      this.b = new afth(this, parama);
    }
    this.b.a(this.a, 0);
  }
  
  private void ddS()
  {
    label130:
    aepf.a locala;
    aftg localaftg;
    if (this.a == null)
    {
      this.a = new aftf();
      this.a.wt = new ArrayList();
      Object localObject = new aftg();
      ((aftg)localObject).type = 0;
      ((aftg)localObject).title = getResources().getString(2131701147);
      ((aftg)localObject).cUj = -20771;
      ((aftg)localObject).cUk = -31578;
      ((aftg)localObject).wu = new ArrayList(10);
      this.a.wt.add(localObject);
      localObject = ((afsi)this.mApp.getManager(264)).cX();
      if ((localObject == null) || (((ArrayList)localObject).isEmpty())) {
        return;
      }
      localObject = ((ArrayList)localObject).iterator();
      if (!((Iterator)localObject).hasNext()) {
        return;
      }
      locala = (aepf.a)((Iterator)localObject).next();
      localaftg = new aftg();
      if (!"0".equals(locala.type)) {
        break label286;
      }
      localaftg.type = 0;
    }
    for (;;)
    {
      localaftg.title = locala.title;
      localaftg.appId = locala.id;
      localaftg.subTitle = locala.subTitle;
      localaftg.jumpUrl = locala.bAt;
      localaftg.iconUrl = locala.iconUrl;
      localaftg.bv = locala.bv;
      try
      {
        if (locala.bAr != null) {
          localaftg.cUj = Color.parseColor(locala.bAr);
        }
        if (locala.bAs != null) {
          localaftg.cUk = Color.parseColor(locala.bAs);
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          QLog.e("TabLayout", 1, "loadFeedBannerData fail.", localException);
        }
      }
      this.a.wt.add(localaftg);
      break label130;
      this.a.wt.clear();
      break;
      label286:
      if ("1".equals(locala.type)) {
        localaftg.type = 1;
      } else if ("2".equals(locala.type)) {
        localaftg.type = 2;
      } else if ("3".equals(locala.type)) {
        localaftg.type = 3;
      } else {
        localaftg.type = -1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, afth.a parama)
  {
    this.mApp = paramQQAppInterface;
    ddS();
    a(parama);
  }
  
  public void destroy()
  {
    if (this.b != null) {
      this.b.destroy();
    }
  }
  
  public void p(int paramInt, ArrayList<String> paramArrayList)
  {
    aftg localaftg = new aftg();
    localaftg.subTitle = (paramInt + getResources().getString(2131701170));
    localaftg.wu = paramArrayList;
    this.b.a(localaftg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.extendfriend.wiget.ExtendFriendFeedBannerView
 * JD-Core Version:    0.7.0.1
 */