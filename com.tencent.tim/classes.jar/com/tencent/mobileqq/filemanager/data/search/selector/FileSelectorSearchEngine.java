package com.tencent.mobileqq.filemanager.data.search.selector;

import agkf;
import agog;
import agol;
import agon;
import ahaf;
import ahap;
import amjz;
import amka;
import amkg.a;
import amwd;
import amwe;
import amwt;
import amxk;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class FileSelectorSearchEngine
  implements amkg.a, amwd<agog>
{
  private SearchRunnable a = new SearchRunnable(null);
  private Bundle aZ;
  private int cYl = 0;
  private boolean cdk;
  private boolean cdl;
  private QQAppInterface mApp;
  private Context mContext;
  
  public FileSelectorSearchEngine(QQAppInterface paramQQAppInterface, Context paramContext, int paramInt)
  {
    this.mApp = paramQQAppInterface;
    this.mContext = paramContext;
    this.cYl = paramInt;
  }
  
  private List<agog> b(amwt paramamwt)
  {
    Map localMap = this.mApp.a().p(paramamwt.keyword);
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localMap.keySet().iterator();
    while (localIterator.hasNext())
    {
      Object localObject = (String)localIterator.next();
      agon localagon = new agon(paramamwt.keyword, this.cYl);
      localObject = (List)localMap.get(localObject);
      localagon.cA(this.aZ);
      localagon.kI((List)localObject);
      if (localagon.Ey() > 0) {
        localArrayList.add(localagon);
      }
    }
    return localArrayList;
  }
  
  private List<agog> c(amwt paramamwt)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject2 = new HashMap();
    Object localObject1 = ahaf.a().vZ();
    if (!TextUtils.isEmpty((CharSequence)localObject1)) {
      ahap.a(true, (String)localObject1, "", ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
    }
    if (ala())
    {
      localObject1 = ahap.a(this.mContext, null);
      if ((localObject1 != null) && (!((List)localObject1).isEmpty())) {
        ((HashMap)localObject2).put("installedApk", localObject1);
      }
    }
    localObject1 = ahaf.a().vY();
    if (localObject1 != null) {
      ahap.a(true, (String)localObject1, "", ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|.mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|.jpg|.bmp|.jpeg|.gif|.png|.ico|", (HashMap)localObject2, null);
    }
    localObject1 = new HashMap();
    if ((localObject2 != null) && (!((HashMap)localObject2).isEmpty()))
    {
      Object localObject3 = new ArrayList();
      localObject2 = ((HashMap)localObject2).values().iterator();
      Object localObject4;
      while (((Iterator)localObject2).hasNext())
      {
        localObject4 = (List)((Iterator)localObject2).next();
        if ((localObject4 != null) && (!((List)localObject4).isEmpty())) {
          ((List)localObject3).addAll((Collection)localObject4);
        }
      }
      if (!((List)localObject3).isEmpty())
      {
        localObject2 = ((List)localObject3).iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (FileInfo)((Iterator)localObject2).next();
          localObject4 = ((FileInfo)localObject3).getName();
          if (((String)localObject4).indexOf(paramamwt.keyword) >= 0)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
          else if (amxk.b(paramamwt.keyword, (String)localObject4, amjz.aiT) > -9223372036854775808L)
          {
            if (!((Map)localObject1).containsKey(localObject4)) {
              ((Map)localObject1).put(localObject4, new ArrayList());
            }
            ((List)((Map)localObject1).get(localObject4)).add(localObject3);
          }
        }
      }
      if (!((Map)localObject1).isEmpty())
      {
        localObject2 = ((Map)localObject1).keySet().iterator();
        while (((Iterator)localObject2).hasNext())
        {
          localObject3 = (String)((Iterator)localObject2).next();
          localObject4 = new agol(paramamwt.keyword, this.cYl);
          ((agol)localObject4).kH((List)((Map)localObject1).get(localObject3));
          ((agol)localObject4).cA(this.aZ);
          localArrayList.add(localObject4);
        }
      }
    }
    return localArrayList;
  }
  
  private List<agog> d(amwt paramamwt)
  {
    return new ArrayList();
  }
  
  public void M(int paramInt, List<? extends amka> paramList) {}
  
  public List<agog> a(amwt paramamwt)
  {
    List localList = null;
    if (this.cYl == 16) {
      localList = b(paramamwt);
    }
    for (;;)
    {
      paramamwt = localList;
      if (localList == null) {
        paramamwt = new ArrayList();
      }
      return paramamwt;
      if (this.cYl == 17) {
        localList = c(paramamwt);
      } else if (this.cYl == 18) {
        localList = d(paramamwt);
      }
    }
  }
  
  public void a(amwt paramamwt, amwe<agog> paramamwe)
  {
    if ((paramamwt == null) || (paramamwt.keyword == null) || (TextUtils.isEmpty(paramamwt.keyword.trim()))) {
      return;
    }
    synchronized (this.a)
    {
      this.a.a = paramamwt;
      this.a.b = paramamwe;
      ThreadManager.removeJobFromThreadPool(this.a, 64);
      ThreadManager.executeOnFileThread(this.a);
      return;
    }
  }
  
  protected boolean ala()
  {
    if (this.cdl) {
      return this.cdk;
    }
    this.cdk = this.mContext.getSharedPreferences("qfile_permission", 0).getBoolean("qfile_permission_access_apps", false);
    this.cdl = true;
    return this.cdk;
  }
  
  public void cA(Bundle paramBundle)
  {
    this.aZ = paramBundle;
  }
  
  public void cancel()
  {
    synchronized (this.a)
    {
      this.a.a = null;
      this.a.b = null;
      ThreadManager.removeJobFromThreadPool(this.a, 64);
      return;
    }
  }
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause() {}
  
  public void resume() {}
  
  class SearchRunnable
    implements Runnable
  {
    amwt a;
    amwe<agog> b;
    
    private SearchRunnable() {}
    
    public void run()
    {
      try
      {
        if (this.a == null)
        {
          this.b.s(new ArrayList(), 6);
          return;
        }
        amwt localamwt = this.a;
        String str = this.a.keyword;
        List localList = FileSelectorSearchEngine.this.a(localamwt);
        try
        {
          if ((this.b != null) && (localamwt == this.a) && (str.equals(this.a.keyword))) {
            this.b.s(localList, 1);
          }
          return;
        }
        finally {}
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.data.search.selector.FileSelectorSearchEngine
 * JD-Core Version:    0.7.0.1
 */