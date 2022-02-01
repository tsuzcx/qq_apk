package com.tencent.mobileqq.troop.utils;

import android.os.Bundle;
import apbr;
import apcy;
import apsf;
import apsf.a;
import apsk;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

public class TroopFileManager$5$1
  implements Runnable
{
  public TroopFileManager$5$1(apsk paramapsk, Bundle paramBundle, int paramInt1, ByteStringMicro paramByteStringMicro, boolean paramBoolean1, List paramList, boolean paramBoolean2, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    int m;
    boolean bool;
    String str;
    long l;
    apsf.a locala;
    synchronized (this.a.c)
    {
      m = this.val$bundle.getInt("reqFor");
      bool = this.val$bundle.getBoolean("isFirstPage");
      str = this.val$bundle.getString("parentFileId");
      l = this.val$bundle.getLong("uin_filter");
      locala = (apsf.a)this.a.c.nQ.get(str + l);
      if (locala == null) {
        return;
      }
      if (m != 1) {}
    }
    int i;
    try
    {
      i = this.val$errorCode;
      if (i == -1000)
      {
        if (this.val$isSuccess) {
          break label2767;
        }
        if (!QLog.isDevelopLevel()) {
          break label2734;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        break label2734;
        for (;;)
        {
          return;
          localObject1 = finally;
          throw localObject1;
          locala.arU = 0L;
          this.a.c.a(null, false, str, l);
          continue;
          locala.cSg = false;
          this.a.c.a(null, false, str, l);
          continue;
          if (locala.BE != null) {
            if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
            {
              locala.mRequestCount += 1;
              this.a.c.G(str, l);
            }
            else
            {
              locala.mRequestCount = 0;
              this.a.c.a(locala.BE, locala.mIsEnd, str, l);
              continue;
              if (locala.BE != null) {
                if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
                {
                  locala.mRequestCount += 1;
                  locala.cSg = false;
                  this.a.c.G(str, l);
                }
                else
                {
                  locala.cSg = false;
                  locala.mRequestCount = 0;
                  this.a.c.a(locala.BE, locala.mIsEnd, str, l);
                }
              }
            }
          }
        }
      }
      locala.a = this.g;
      if (this.val$isSuccess)
      {
        localObject2 = this.val$fileList;
        if (localObject2 != null) {}
      }
      else
      {
        if (this.val$isSuccess) {
          break label2831;
        }
        if (!QLog.isDevelopLevel()) {
          break label2799;
        }
        QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        break label2799;
        for (;;)
        {
          label514:
          return;
          locala.arU = 0L;
          this.a.c.a(null, false, str, l);
          continue;
          locala.cSg = false;
          this.a.c.a(null, false, str, l);
          continue;
          if (locala.BE != null) {
            if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
            {
              locala.mRequestCount += 1;
              this.a.c.G(str, l);
            }
            else
            {
              locala.mRequestCount = 0;
              this.a.c.a(locala.BE, locala.mIsEnd, str, l);
              continue;
              if (locala.BE != null) {
                if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
                {
                  locala.mRequestCount += 1;
                  locala.cSg = false;
                  this.a.c.G(str, l);
                }
                else
                {
                  locala.cSg = false;
                  locala.mRequestCount = 0;
                  this.a.c.a(locala.BE, locala.mIsEnd, str, l);
                }
              }
            }
          }
        }
      }
      locala.mIsEnd = this.aBN;
      locala.mStartIndex = this.YI;
      if (!bool) {
        break label977;
      }
      locala.bxJ = this.cdq;
      Object localObject2 = this.a.c.gD();
      locala.BE.clear();
      locala.nR.clear();
      localObject2 = ((Collection)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        ??? = (apbr)((Iterator)localObject2).next();
        this.a.c.nP.put(((apbr)???).Id, ???);
        this.a.c.nO.put(((apbr)???).mFileId, ???);
      }
      if (!QLog.isDevelopLevel()) {
        break label2863;
      }
    }
    finally
    {
      if (this.val$isSuccess) {
        break label2967;
      }
    }
    QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
    for (;;)
    {
      label974:
      throw localObject3;
      label977:
      Object localObject6;
      Object localObject7;
      switch (m)
      {
      case 2: 
      default: 
        localObject6 = this.a.c.d.gE();
        localObject7 = this.val$fileList.iterator();
      }
      Object localObject4;
      label1548:
      label1746:
      for (;;)
      {
        if (!((Iterator)localObject7).hasNext()) {
          break label1748;
        }
        localObject4 = (apbr)((Iterator)localObject7).next();
        if (((apbr)localObject4).cPN)
        {
          if (((apbr)localObject4).mFileId == null) {
            continue;
          }
          ??? = (apbr)this.a.c.nO.get(((apbr)localObject4).mFileId);
          if (??? == null)
          {
            ((apbr)localObject4).Id = UUID.randomUUID();
            this.a.c.nO.put(((apbr)localObject4).mFileId, localObject4);
            Iterator localIterator = ((List)localObject6).iterator();
            for (;;)
            {
              ??? = localObject4;
              if (!localIterator.hasNext()) {
                break;
              }
              ??? = (apcy)localIterator.next();
              if (((apbr)localObject4).mFileId.equals(((apcy)???).mParentId))
              {
                apbr localapbr2 = new apbr();
                localapbr2.Id = ((apcy)???).Id;
                localapbr2.mFileId = ((apcy)???).FilePath;
                localapbr2.mParentId = ((apcy)???).mParentId;
                localapbr2.a((apcy)???, this.a.c.mApp);
                ((apbr)localObject4).a(localapbr2);
              }
            }
            locala.mIsEnd = this.aBN;
            break;
          }
          ((apbr)???).b((apbr)localObject4);
          this.a.c.nP.put(((apbr)???).Id, ???);
          if (locala.nR.get(((apbr)???).mFileId) == null)
          {
            locala.BE.add(???);
            locala.nR.put(((apbr)???).mFileId, ???);
          }
          this.a.c.nO.put(((apbr)???).mFileId, ???);
          continue;
        }
        if (QLog.isColorLevel()) {
          QLog.e("TroopFileManager", 2, "onRspFileListV2: fileName = " + ((apbr)localObject4).str_file_name + ", filePath = " + ((apbr)localObject4).mFileId + ", sha = " + ((apbr)localObject4).coa);
        }
        ??? = this.a.c.d.a(((apbr)localObject4).mFileId);
        if (??? == null)
        {
          ((apbr)localObject4).Id = UUID.randomUUID();
          ((apbr)localObject4).ProgressValue = ((apbr)localObject4).uint64_uploaded_size;
        }
        for (;;)
        {
          if ((((apbr)localObject4).Status == 1) || (((apbr)localObject4).Status == 3) || (((apbr)localObject4).Status == 2) || (((apbr)localObject4).Status == 12)) {
            break label1746;
          }
          ??? = (apbr)this.a.c.nO.get(((apbr)localObject4).mFileId);
          if (??? == null) {
            break label2895;
          }
          ((apbr)???).b((apbr)localObject4);
          localObject4 = ???;
          ((apbr)localObject4).x(this.a.c.mApp, this.a.c.mTroopUin);
          this.a.c.nP.put(((apbr)localObject4).Id, localObject4);
          if (locala.nR.get(((apbr)localObject4).mFileId) == null)
          {
            locala.BE.add(localObject4);
            locala.nR.put(((apbr)localObject4).mFileId, localObject4);
          }
          this.a.c.nO.put(((apbr)localObject4).mFileId, localObject4);
          break;
          ((apbr)localObject4).Id = ((apcy)???).Id;
          ((apbr)localObject4).a((apcy)???, this.a.c.mApp);
          if (((apbr)localObject4).Status == 9)
          {
            ??? = (apbr)this.a.c.nO.get(((apcy)???).mParentId);
            if (??? != null) {
              ((apbr)???).a((apbr)localObject4);
            }
          }
        }
      }
      label1748:
      int k;
      if (!"/".equals(str))
      {
        localObject4 = (apbr)this.a.c.nO.get(str);
        if (localObject4 != null)
        {
          ??? = ((apbr)localObject4).nA.keySet();
          localObject6 = new ArrayList();
          ??? = ((Set)???).iterator();
          while (((Iterator)???).hasNext()) {
            ((List)localObject6).add((String)((Iterator)???).next());
          }
          int n = locala.BE.size();
          synchronized (this.a.c.d)
          {
            localObject6 = ((List)localObject6).iterator();
            while (((Iterator)localObject6).hasNext())
            {
              localObject7 = (String)((Iterator)localObject6).next();
              int j = 0;
              i = 0;
              localObject7 = (apbr)((apbr)localObject4).nA.get(localObject7);
              if (localObject7 != null)
              {
                if ((n <= 0) || (locala.BE.get(n - 1) == null)) {
                  break label2729;
                }
                int i1 = ((apbr)locala.BE.get(n - 1)).Lg();
                if (((apbr)localObject7).Lg() >= i1)
                {
                  k = 0;
                  label1987:
                  j = i;
                  if (k < n)
                  {
                    if ((localObject7 == null) || (((apbr)localObject7).mFileId == null) || (locala.BE.get(k) == null) || (!((apbr)localObject7).mFileId.equals(((apbr)locala.BE.get(k)).mFileId))) {
                      break label2726;
                    }
                    i = 1;
                    break label2898;
                  }
                }
                i = j;
                if (((apbr)localObject7).Lg() <= i1)
                {
                  i = j;
                  if (!this.aBN) {
                    i = 1;
                  }
                }
                label2078:
                if (i == 0)
                {
                  ((apbr)localObject4).nA.remove(((apbr)localObject7).mFileId);
                  this.a.c.d.a(((apbr)localObject7).Id, true);
                }
              }
            }
          }
          this.a.c.k(localapbr1);
        }
      }
      if (!this.val$isSuccess) {
        if (QLog.isDevelopLevel()) {
          QLog.d("TroopFileManager", 4, "onRspFileListV2 failed, req for:" + m);
        }
      }
      for (;;)
      {
        return;
        locala.arU = 0L;
        this.a.c.a(null, false, str, l);
        continue;
        locala.cSg = false;
        this.a.c.a(null, false, str, l);
        continue;
        if (locala.BE != null) {
          if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
          {
            locala.mRequestCount += 1;
            this.a.c.G(str, l);
          }
          else
          {
            locala.mRequestCount = 0;
            this.a.c.a(locala.BE, locala.mIsEnd, str, l);
            continue;
            if (locala.BE != null) {
              if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
              {
                locala.mRequestCount += 1;
                locala.cSg = false;
                this.a.c.G(str, l);
              }
              else
              {
                locala.cSg = false;
                locala.mRequestCount = 0;
                this.a.c.a(locala.BE, locala.mIsEnd, str, l);
                continue;
                locala.arU = 0L;
                this.a.c.a(null, false, str, l);
                break label974;
                locala.cSg = false;
                this.a.c.a(null, false, str, l);
                break label974;
                if (locala.BE == null) {
                  break label974;
                }
                if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
                {
                  locala.mRequestCount += 1;
                  this.a.c.G(str, l);
                  break label974;
                }
                locala.mRequestCount = 0;
                this.a.c.a(locala.BE, locala.mIsEnd, str, l);
                break label974;
                if (locala.BE == null) {
                  break label974;
                }
                if ((locala.BE.size() < 15) && (!locala.mIsEnd) && (locala.mRequestCount <= 3))
                {
                  locala.mRequestCount += 1;
                  locala.cSg = false;
                  this.a.c.G(str, l);
                  break label974;
                }
                locala.cSg = false;
                locala.mRequestCount = 0;
                this.a.c.a(locala.BE, locala.mIsEnd, str, l);
                break label974;
                label2726:
                break label2898;
                label2729:
                i = 0;
                break label2078;
                label2734:
                switch (m)
                {
                }
                break;
                label2767:
                switch (m)
                {
                }
                break;
                label2799:
                switch (m)
                {
                }
                break label514;
                label2831:
                switch (m)
                {
                }
                break label514;
                label2863:
                switch (m)
                {
                }
                break label974;
                label2895:
                break label1548;
                label2898:
                k += 1;
                break label1987;
                switch (m)
                {
                }
                continue;
                switch (m)
                {
                }
              }
            }
          }
        }
      }
      label2967:
      switch (m)
      {
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopFileManager.5.1
 * JD-Core Version:    0.7.0.1
 */