package com.tencent.trackrecordlib.d;

import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.View;
import com.tencent.trackrecordlib.core.RecordManager;
import com.tencent.trackrecordlib.d.a.e;
import com.tencent.trackrecordlib.g.i;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class a
{
  private c a = c.a.a();
  
  public static a b()
  {
    return a.a();
  }
  
  private boolean b(View paramView)
  {
    return (e(paramView)) && (d(paramView));
  }
  
  private boolean b(@Nullable com.tencent.trackrecordlib.d.a.b paramb)
  {
    return (paramb == null) || (TextUtils.isEmpty(com.tencent.trackrecordlib.d.a.c.a(paramb)));
  }
  
  private void c() {}
  
  private boolean c(View paramView)
  {
    if (paramView == null) {
      return false;
    }
    paramView = (String)e.d(paramView, "element_exposure_page_id");
    if ((paramView != null) && (paramView.equals(com.tencent.trackrecordlib.g.b.b()))) {}
    for (boolean bool = true;; bool = false) {
      return bool;
    }
  }
  
  private boolean d(View paramView)
  {
    if (paramView == null) {}
    Rect localRect;
    do
    {
      return false;
      localRect = new Rect();
    } while ((!paramView.isShown()) || (!paramView.getGlobalVisibleRect(localRect)) || (!i.h(paramView)));
    return true;
  }
  
  private boolean e(View paramView)
  {
    return !this.a.b(paramView);
  }
  
  public void a()
  {
    if ((!RecordManager.getInstance().isEnableExposure()) || (this.a.d().isEmpty())) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.d().iterator();
    while (localIterator.hasNext())
    {
      View localView = (View)localIterator.next();
      if ((!c(localView)) || (!d(localView)))
      {
        localArrayList.add(localView);
        long l = System.currentTimeMillis();
        int i = (int)(l - ((Long)e.d(localView, "element_exposure_start_time")).longValue());
        e.b(localView, "element_exposure_end_time", Long.valueOf(l));
        e.b(localView, "element_exposure_duration", Integer.valueOf(i));
        String str1 = (String)e.d(localView, "element_exposure_page_id");
        String str2 = (String)e.d(localView, "element_exposure_page");
        com.tencent.trackrecordlib.core.c.a().a(localView, i, str1, str2);
      }
    }
    this.a.a(localArrayList);
  }
  
  public void a(View paramView)
  {
    if (!RecordManager.getInstance().isEnableExposure()) {}
    while ((!a(com.tencent.trackrecordlib.d.a.a.a(paramView))) || (!b(paramView))) {
      return;
    }
    e.b(paramView, "element_exposure_start_time", Long.valueOf(System.currentTimeMillis()));
    e.b(paramView, "element_exposure_page_id", com.tencent.trackrecordlib.g.b.b());
    e.b(paramView, "element_exposure_page", com.tencent.trackrecordlib.g.b.c());
    this.a.a(paramView);
  }
  
  public boolean a(@Nullable com.tencent.trackrecordlib.d.a.b paramb)
  {
    return !b(paramb);
  }
  
  static class a
  {
    private static final a a = new a(null);
    
    static
    {
      a.a(a);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.trackrecordlib.d.a
 * JD-Core Version:    0.7.0.1
 */