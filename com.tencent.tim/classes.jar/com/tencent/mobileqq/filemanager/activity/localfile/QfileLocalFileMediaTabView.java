package com.tencent.mobileqq.filemanager.activity.localfile;

import agdq;
import agga;
import ahaf;
import ahap;
import ahbo;
import android.content.Context;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileInfo;
import com.tencent.mobileqq.filemanager.widget.QfileTabBarView.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class QfileLocalFileMediaTabView
  extends QfileBaseLocalFileTabView
{
  private int cWS = 3;
  
  public QfileLocalFileMediaTabView(Context paramContext, int paramInt, List<QfileTabBarView.a> paramList, boolean paramBoolean)
  {
    super(paramContext, paramList, paramBoolean);
    setEditbarButton(false, false, true, true, true);
    this.cWS = paramInt;
  }
  
  private HashMap<String, List<FileInfo>> G()
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (this.cdi) {
      str = ahaf.a().vY();
    }
    while ((this.cWS & 0x1) > 0)
    {
      Iterator localIterator = this.AS.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ahap.a(true, ((QfileTabBarView.a)localIterator.next()).wd(), ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap, null);
          continue;
          str = null;
          break;
        }
      }
      if (str != null) {
        ahap.a(true, str, ".mp3|.wav|.m4a|.wave|.midi|.wma|.ogg|.ape|.acc|.aac|.aiff|.mid|.xmf|.rtttl|.flac|.amr|.mp2|.m3u|.m4b|.m4p.mpga|", ".mpg", localHashMap, null);
      }
      ahap.ai(localHashMap);
    }
    return localHashMap;
  }
  
  private HashMap<String, List<FileInfo>> H()
  {
    HashMap localHashMap = new HashMap();
    String str;
    if (this.cdi) {
      str = ahaf.a().vY();
    }
    while ((this.cWS & 0x2) > 0)
    {
      Iterator localIterator = this.AS.iterator();
      for (;;)
      {
        if (localIterator.hasNext())
        {
          ahap.a(true, ((QfileTabBarView.a)localIterator.next()).wd(), ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap, null);
          continue;
          str = null;
          break;
        }
      }
      if (str != null) {
        ahap.a(true, str, ".swf|.mov|.mp4|.3gp|.avi|.rmvb|.wmf|.mpg|.rm|.asf|.mpeg|.mkv|.wmv|.flv|.f4v|.webm|.mod|.mpe|.fla|.m4r|.m4u|.m4v|.vob|", "", localHashMap, null);
      }
      ahap.ai(localHashMap);
    }
    return localHashMap;
  }
  
  private void el(ArrayList<FileInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((this.cdi) && ((this.cWS & 0x1) > 0))
      {
        Map localMap = ahap.j(this.a);
        if (localMap == null) {
          break;
        }
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!"TIMfile_recv".equalsIgnoreCase(str)) {
            paramArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
  }
  
  private void em(ArrayList<FileInfo> paramArrayList)
  {
    if (paramArrayList == null) {
      break label4;
    }
    for (;;)
    {
      label4:
      return;
      if ((this.cdi) && ((this.cWS & 0x2) > 0))
      {
        Map localMap = ahap.i(this.a);
        if (localMap == null) {
          break;
        }
        Iterator localIterator = localMap.keySet().iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!"TIMfile_recv".equalsIgnoreCase(str)) {
            paramArrayList.addAll((List)localMap.get(str));
          }
        }
      }
    }
  }
  
  protected agdq a()
  {
    return new agga(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected void b(FileInfo paramFileInfo)
  {
    if (!this.wB.contains(paramFileInfo)) {
      this.wB.add(paramFileInfo);
    }
    runOnUiThread(new QfileLocalFileMediaTabView.2(this, paramFileInfo));
  }
  
  protected boolean c(FileInfo paramFileInfo)
  {
    String str = paramFileInfo.getGroupName();
    if (!this.R.containsKey(str))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    ((List)this.R.get(str)).remove(paramFileInfo);
    refreshUI();
    return true;
  }
  
  protected void dfD()
  {
    this.runnable = new QfileLocalFileMediaTabView.1(this);
    ThreadManagerV2.excute(this.runnable, 64, null, true);
  }
  
  public void m(Set<FileInfo> paramSet)
  {
    if ((paramSet == null) || (paramSet.size() == 0)) {}
    for (;;)
    {
      return;
      paramSet = paramSet.iterator();
      while (paramSet.hasNext()) {
        c((FileInfo)paramSet.next());
      }
    }
  }
  
  public void onStart()
  {
    super.onStart();
    setEditbarButton(false, false, true, true, true);
    if (!this.a.akQ())
    {
      if (!this.a.akI()) {
        break label50;
      }
      this.a.a().dlN();
    }
    for (;;)
    {
      Nx();
      return;
      label50:
      this.a.a().dlS();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.localfile.QfileLocalFileMediaTabView
 * JD-Core Version:    0.7.0.1
 */