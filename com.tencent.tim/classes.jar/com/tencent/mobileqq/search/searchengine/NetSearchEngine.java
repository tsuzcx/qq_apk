package com.tencent.mobileqq.search.searchengine;

import acfd;
import ampw;
import amro;
import amrq;
import amwd;
import amwe;
import amwi;
import amwj;
import amwk;
import amwt;
import android.os.Bundle;
import aqoj;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.profilecard.SummaryCardBusiEntry.comm;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import yob;

public class NetSearchEngine
  implements amwd<ampw>
{
  public static double bG;
  public static double bo;
  private NetSearchRunnalbe jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe;
  yob jdField_a_of_type_Yob;
  private QQAppInterface app;
  private int fromType = -1;
  private Future l;
  private ThreadPoolExecutor n;
  
  public NetSearchEngine(QQAppInterface paramQQAppInterface, ThreadPoolExecutor paramThreadPoolExecutor, int paramInt)
  {
    this.app = paramQQAppInterface;
    this.n = paramThreadPoolExecutor;
    this.fromType = paramInt;
    if (paramThreadPoolExecutor == null) {
      this.n = new ThreadPoolExecutor(3, 5, 5L, TimeUnit.SECONDS, new LinkedBlockingQueue(128));
    }
    SosoInterface.a(new amwi(this, 0, true, false, 60000L, false, false, "SearchContacts"));
    this.jdField_a_of_type_Yob = new yob(paramQQAppInterface);
  }
  
  private int[] p(int paramInt)
  {
    if (paramInt < 0) {}
    ArrayList localArrayList;
    int i;
    do
    {
      return null;
      localArrayList = new ArrayList(5);
      if ((paramInt & 0x2) >= 1) {
        localArrayList.add(Integer.valueOf(80000000));
      }
      if ((paramInt & 0x4) >= 1) {
        localArrayList.add(Integer.valueOf(80000001));
      }
      if ((paramInt & 0x8) >= 1) {
        localArrayList.add(Integer.valueOf(80000002));
      }
      if ((paramInt & 0x10) >= 1) {
        localArrayList.add(Integer.valueOf(80000003));
      }
      i = localArrayList.size();
    } while (i <= 0);
    int[] arrayOfInt = new int[i];
    paramInt = 0;
    while (paramInt < i)
    {
      arrayOfInt[paramInt] = ((Integer)localArrayList.get(paramInt)).intValue();
      paramInt += 1;
    }
    return arrayOfInt;
  }
  
  public List<ampw> a(amwt paramamwt)
  {
    Object localObject = paramamwt.extra;
    int i = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
    int j = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    int[] arrayOfInt = p(i);
    if (arrayOfInt == null) {
      return null;
    }
    localObject = new ArrayList();
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe = new NetSearchRunnalbe(paramamwt.keyword, arrayOfInt, j, new amwj(this, (List)localObject));
    this.l = this.n.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe);
    try
    {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe.latch.await();
      return localObject;
    }
    catch (InterruptedException paramamwt)
    {
      for (;;)
      {
        paramamwt.printStackTrace();
      }
    }
  }
  
  List<ampw> a(String paramString, int paramInt, SummaryCardBusiEntry.comm paramcomm, byte[] paramArrayOfByte)
  {
    amro localamro = amrq.a(paramInt);
    if (localamro != null) {
      return localamro.a(new Object[] { paramcomm, paramArrayOfByte, paramString });
    }
    return null;
  }
  
  public void a(amwt paramamwt, amwe<ampw> paramamwe)
  {
    Object localObject = paramamwt.extra;
    int i = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_SEARCH_TYPE", -1);
    int j = ((Bundle)localObject).getInt("SEARCH_REQUEST_EXTRA_PAGE", 0);
    localObject = p(i);
    if (localObject == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe = new NetSearchRunnalbe(paramamwt.keyword, (int[])localObject, j, paramamwe);
    this.l = this.n.submit(this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe);
  }
  
  public void cancel()
  {
    if (this.l != null)
    {
      this.l.cancel(true);
      if ((this.l instanceof Runnable)) {
        this.n.remove((Runnable)this.l);
      }
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe != null) {
      this.jdField_a_of_type_ComTencentMobileqqSearchSearchengineNetSearchEngine$NetSearchRunnalbe.cancel();
    }
  }
  
  public void destroy() {}
  
  public void init() {}
  
  public void pause() {}
  
  public void resume() {}
  
  public class NetSearchRunnalbe
    implements Runnable
  {
    public acfd c = new amwk(this);
    private boolean canceled;
    private amwe f;
    private String keyword;
    public CountDownLatch latch;
    private int[] nh;
    private int page;
    
    public NetSearchRunnalbe(String paramString, int[] paramArrayOfInt, int paramInt, amwe paramamwe)
    {
      this.nh = paramArrayOfInt;
      this.f = paramamwe;
      this.keyword = paramString;
      this.page = paramInt;
      this.latch = new CountDownLatch(1);
    }
    
    public void cancel()
    {
      this.canceled = true;
      this.f = null;
      NetSearchEngine.a(NetSearchEngine.this).removeObserver(this.c);
      this.c = null;
      this.latch.countDown();
    }
    
    public void run()
    {
      NetSearchEngine.a(NetSearchEngine.this).addObserver(this.c);
      NetSearchEngine.this.a.El(this.page);
      if (NetSearchEngine.a(NetSearchEngine.this) == 12)
      {
        NetSearchEngine.this.a.a(this.keyword, this.nh, NetSearchEngine.bG, NetSearchEngine.bo, false, 1);
        return;
      }
      NetSearchEngine.this.a.a(this.keyword, this.nh, NetSearchEngine.bG, NetSearchEngine.bo, false, 0);
    }
  }
  
  public class ParseTask
    implements Runnable
  {
    private WeakReference<amwe> cQ;
    private ArrayList<byte[]> data;
    private String searchKey;
    
    public ParseTask(ArrayList<byte[]> paramArrayList, amwe paramamwe)
    {
      this.searchKey = paramArrayList;
      this.data = paramamwe;
      Object localObject;
      if (localObject != null) {
        this.cQ = new WeakReference(localObject);
      }
    }
    
    private List<ampw> b(String paramString, ArrayList<byte[]> paramArrayList)
    {
      if ((paramArrayList == null) || (paramArrayList.size() <= 0)) {
        return null;
      }
      ArrayList localArrayList = new ArrayList(12);
      StringBuilder localStringBuilder = new StringBuilder(paramArrayList.size() * 64);
      int k = paramArrayList.size();
      int i = 0;
      if (i < k)
      {
        Object localObject = (byte[])paramArrayList.get(i);
        int j;
        if (localObject == null)
        {
          j = 0;
          label72:
          if (j > 10) {
            break label94;
          }
        }
        for (;;)
        {
          i += 1;
          break;
          j = localObject.length;
          break label72;
          label94:
          int n = (int)aqoj.getLongData((byte[])localObject, 1);
          int m = (int)aqoj.getLongData((byte[])localObject, 5);
          if ((n > 0) && (n + 9 < j))
          {
            byte[] arrayOfByte = new byte[n];
            aqoj.copyData(arrayOfByte, 0, (byte[])localObject, 9, n);
            j = n + 9;
            SummaryCardBusiEntry.comm localcomm = new SummaryCardBusiEntry.comm();
            try
            {
              localcomm.mergeFrom(arrayOfByte);
              n = localcomm.result.get();
              if (n != 0) {
                break label278;
              }
              n = localcomm.service.get();
              arrayOfByte = new byte[m];
              aqoj.copyData(arrayOfByte, 0, (byte[])localObject, j, m);
              localObject = NetSearchEngine.this.a(paramString, n, localcomm, arrayOfByte);
              if ((localObject == null) || (((List)localObject).size() <= 0)) {
                continue;
              }
              localArrayList.addAll((Collection)localObject);
            }
            catch (Exception localException) {}
            if (QLog.isColorLevel())
            {
              QLog.i("Q.uniteSearch.NetSearchEngine", 2, localException.toString());
              continue;
              label278:
              localStringBuilder.append(" |busi entry, [").append(localcomm.service.get()).append(",").append(n).append(",").append(localcomm.err_msg.get());
            }
          }
        }
      }
      if (QLog.isDevelopLevel()) {
        QLog.i("Q.uniteSearch.NetSearchEngine", 4, localStringBuilder.toString());
      }
      return localArrayList;
    }
    
    public void run()
    {
      List localList = b(this.searchKey, this.data);
      if (this.cQ != null)
      {
        amwe localamwe = (amwe)this.cQ.get();
        if (localamwe != null) {
          localamwe.s(localList, 1);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.searchengine.NetSearchEngine
 * JD-Core Version:    0.7.0.1
 */