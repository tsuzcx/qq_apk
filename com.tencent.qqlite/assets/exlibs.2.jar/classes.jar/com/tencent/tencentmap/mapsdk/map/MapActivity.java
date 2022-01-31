package com.tencent.tencentmap.mapsdk.map;

import android.app.Activity;
import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

public abstract class MapActivity
  extends Activity
{
  private List<h> a = new ArrayList();
  
  final void a(h paramh)
  {
    this.a.add(paramh);
  }
  
  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.a.get(0);
      if (localh != null)
      {
        localh.onDestroy();
        this.a.remove(0);
      }
      i += 1;
    }
    System.gc();
  }
  
  protected void onPause()
  {
    super.onPause();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh != null) {
        localh.onPause();
      }
      i += 1;
    }
  }
  
  protected void onRestart()
  {
    super.onPause();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh != null) {
        localh.onRestart();
      }
      i += 1;
    }
  }
  
  protected void onResume()
  {
    super.onResume();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh != null) {
        localh.onResume();
      }
      i += 1;
    }
  }
  
  protected void onStop()
  {
    super.onStop();
    int j = this.a.size();
    int i = 0;
    while (i < j)
    {
      h localh = (h)this.a.get(i);
      if (localh != null) {
        localh.onStop();
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tencentmap.mapsdk.map.MapActivity
 * JD-Core Version:    0.7.0.1
 */