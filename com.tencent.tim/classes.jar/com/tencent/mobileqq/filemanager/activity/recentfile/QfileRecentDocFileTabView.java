package com.tencent.mobileqq.filemanager.activity.recentfile;

import aeub;
import aeuc;
import agdq;
import aggv;
import aggw;
import ahav;
import ahbj;
import ahbk;
import ahbo;
import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.filemanager.activity.BaseFileAssistantActivity;
import com.tencent.mobileqq.filemanager.data.FileManagerEntity;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class QfileRecentDocFileTabView
  extends QfileBaseRecentFileTabView
{
  private ahbk b;
  private HashMap<String, String> kG;
  
  public QfileRecentDocFileTabView(Context paramContext)
  {
    super(paramContext);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  public QfileRecentDocFileTabView(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
    dgj();
    setEditbarButton(false, true, true, true, true);
  }
  
  private void Nx()
  {
    if (this.a.akI()) {
      this.a.a().dlD();
    }
    while (this.b != null)
    {
      this.a.a(this.b);
      return;
      this.a.a().dlI();
    }
    this.b = new aggv(this);
    this.a.a(this.b);
  }
  
  private void dgl()
  {
    if (this.kG == null)
    {
      String str = aeuc.a().ue();
      if (!TextUtils.isEmpty(str)) {
        this.kG = ahav.t(str);
      }
      if (this.kG == null) {
        this.kG = new HashMap();
      }
      if (!this.kG.containsKey("WORD")) {
        this.kG.put("WORD", ".doc|.docx|.wps|.pages|");
      }
      if (!this.kG.containsKey("PPT")) {
        this.kG.put("PPT", ".ppt|.pptx.|.dps|.keynote|");
      }
      if (!this.kG.containsKey("EXCEL")) {
        this.kG.put("EXCEL", ".xls|.xlsx|.et|.numbers|");
      }
      if (!this.kG.containsKey("PDF")) {
        this.kG.put("PDF", ".pdf|");
      }
    }
  }
  
  private List<String> eQ()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.kG == null) {
      dgl();
    }
    if (this.kG != null)
    {
      Iterator localIterator = this.kG.keySet().iterator();
      while (localIterator.hasNext()) {
        localArrayList.add((String)localIterator.next());
      }
    }
    return localArrayList;
  }
  
  private String kO(String paramString)
  {
    if (paramString == null) {}
    do
    {
      do
      {
        do
        {
          return null;
          paramString = ahbj.getExtension(paramString).toLowerCase();
        } while ((paramString == null) || (paramString.length() == 0));
        if (!ahav.bm(this.a)) {
          break;
        }
        paramString = kP(paramString);
      } while (TextUtils.isEmpty(paramString));
      return paramString;
      if (".doc|.docx|.wps|.pages|".indexOf(paramString) >= 0) {
        return "WORD";
      }
      if (".ppt|.pptx.|.dps|.keynote|".indexOf(paramString) >= 0) {
        return "PPT";
      }
      if (".xls|.xlsx|.et|.numbers|".indexOf(paramString) >= 0) {
        return "EXCEL";
      }
    } while (".pdf|".indexOf(paramString) < 0);
    return "PDF";
  }
  
  private String kP(String paramString)
  {
    if (this.kG == null) {
      dgl();
    }
    if (this.kG != null)
    {
      Iterator localIterator = this.kG.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        String str = (String)localEntry.getValue();
        if ((!TextUtils.isEmpty(str)) && (str.indexOf(paramString) >= 0)) {
          return (String)localEntry.getKey();
        }
      }
    }
    return null;
  }
  
  protected agdq a()
  {
    return new aggw(a(), this.R, a(), this.m, this.n, this.g, this.eX);
  }
  
  protected void dfD()
  {
    this.R.clear();
    LinkedHashMap localLinkedHashMap = new LinkedHashMap();
    localLinkedHashMap.put("WORD", new ArrayList());
    localLinkedHashMap.put("EXCEL", new ArrayList());
    localLinkedHashMap.put("PDF", new ArrayList());
    localLinkedHashMap.put("PPT", new ArrayList());
    Object localObject2;
    if (ahav.bm(this.a))
    {
      localObject1 = eQ();
      if ((localObject1 != null) && (((List)localObject1).size() > 0))
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          if ((!TextUtils.isEmpty((CharSequence)localObject2)) && (!((String)localObject2).equals("WORD")) && (!((String)localObject2).equals("EXCEL")) && (!((String)localObject2).equals("PDF")) && (!((String)localObject2).equals("PPT"))) {
            localLinkedHashMap.put(localObject2, new ArrayList());
          }
        }
      }
    }
    Object localObject1 = this.AT.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (FileManagerEntity)((Iterator)localObject1).next();
      if (!((FileManagerEntity)localObject2).bDelInFM)
      {
        String str = kO(((FileManagerEntity)localObject2).fileName);
        if ((str != null) || (localLinkedHashMap.containsKey(str))) {
          ((List)localLinkedHashMap.get(str)).add(localObject2);
        }
      }
    }
    localObject1 = localLinkedHashMap.keySet().iterator();
    while (((Iterator)localObject1).hasNext()) {
      if (((List)localLinkedHashMap.get((String)((Iterator)localObject1).next())).size() == 0) {
        ((Iterator)localObject1).remove();
      }
    }
    this.R.putAll(localLinkedHashMap);
    refreshUI();
    setSelect(0);
    IU(true);
    this.cdo = false;
  }
  
  protected boolean e(FileManagerEntity paramFileManagerEntity)
  {
    Object localObject = kO(paramFileManagerEntity.fileName);
    if (!this.R.containsKey(localObject))
    {
      QLog.e(TAG, 1, "delRecentFileRecords, fileEntities find, but recentRecords not find!");
      return false;
    }
    synchronized (this.R)
    {
      localObject = ((List)this.R.get(localObject)).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (paramFileManagerEntity == (FileManagerEntity)((Iterator)localObject).next()) {
          ((Iterator)localObject).remove();
        }
      }
      refreshUI();
      return true;
    }
  }
  
  public void ej(ArrayList<FileManagerEntity> paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.size() == 0)) {}
    for (;;)
    {
      return;
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext()) {
        e((FileManagerEntity)paramArrayList.next());
      }
    }
  }
  
  public void g(FileManagerEntity paramFileManagerEntity)
  {
    if (!this.AT.contains(paramFileManagerEntity)) {
      if ((this.mUin == null) || (this.mUin.trim().length() == 0) || (this.mUin.equals(paramFileManagerEntity.peerUin))) {}
    }
    String str;
    do
    {
      return;
      this.AT.add(paramFileManagerEntity);
      Collections.sort(this.AT, this.comparator);
      str = kO(paramFileManagerEntity.fileName);
    } while (str == null);
    runOnUiThread(new QfileRecentDocFileTabView.2(this, str, paramFileManagerEntity));
  }
  
  public void onStart()
  {
    super.onStart();
    this.a.setDocsCheck(true);
    setEditbarButton(false, true, true, true, true);
    Nx();
  }
  
  public void onStop()
  {
    super.onStop();
    this.a.setDocsCheck(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.activity.recentfile.QfileRecentDocFileTabView
 * JD-Core Version:    0.7.0.1
 */