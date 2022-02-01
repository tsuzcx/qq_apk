package com.huawei.hianalytics.ab.bc.de;

import android.text.TextUtils;
import com.huawei.hianalytics.ab.bc.cd.bc.de;
import com.huawei.hianalytics.ab.bc.ef.ab;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

public class bc
{
  private List<de> ab;
  private String bc;
  private String cd;
  private String de;
  
  public bc(List<de> paramList, String paramString1, String paramString2, String paramString3)
  {
    this.ab = paramList;
    this.bc = paramString1;
    this.cd = paramString2;
    this.de = paramString3;
  }
  
  private void ab(List<de> paramList, String paramString1, String paramString2)
  {
    if (paramList.isEmpty()) {
      return;
    }
    int j = paramList.size() / 500;
    int i = 0;
    label25:
    if (i < j + 1)
    {
      int k = i * 500;
      Object localObject = paramList.subList(k, Math.min(paramList.size(), k + 500));
      String str = UUID.randomUUID().toString().replace("-", "");
      long l1 = System.currentTimeMillis();
      long l2 = com.huawei.hianalytics.ab.ab.cd.gh(paramString2, paramString1);
      ArrayList localArrayList = new ArrayList();
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        de localde = (de)((Iterator)localObject).next();
        if (!com.huawei.hianalytics.ab.bc.kl.bc.ab(localde.bc(), l1, l2 * 86400000L)) {
          localArrayList.add(localde);
        }
      }
      if (localArrayList.size() <= 0) {
        break label206;
      }
      new cd(paramString2, paramString1, this.de, localArrayList, str).ab();
    }
    for (;;)
    {
      i += 1;
      break label25;
      break;
      label206:
      ab.cd("DataOrganizeHandler", "No data to report handler");
    }
  }
  
  public void ab()
  {
    if ("_default_config_tag".equals(this.cd))
    {
      ArrayList localArrayList1 = new ArrayList();
      ArrayList localArrayList2 = new ArrayList();
      ArrayList localArrayList3 = new ArrayList();
      ArrayList localArrayList4 = new ArrayList();
      Iterator localIterator = this.ab.iterator();
      while (localIterator.hasNext())
      {
        de localde = (de)localIterator.next();
        String str = localde.ab();
        if ((TextUtils.isEmpty(str)) || ("oper".equals(str))) {
          localArrayList4.add(localde);
        } else if ("maint".equals(str)) {
          localArrayList1.add(localde);
        } else if ("preins".equals(str)) {
          localArrayList2.add(localde);
        } else if ("diffprivacy".equals(str)) {
          localArrayList3.add(localde);
        }
      }
      ab(localArrayList4, "oper", "_default_config_tag");
      ab(localArrayList1, "maint", "_default_config_tag");
      ab(localArrayList2, "preins", "_default_config_tag");
      ab(localArrayList3, "diffprivacy", "_default_config_tag");
      return;
    }
    ab(this.ab, this.cd, this.bc);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hianalytics.ab.bc.de.bc
 * JD-Core Version:    0.7.0.1
 */