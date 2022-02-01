package com.tencent.biz.pubaccount.weishi_new.player;

import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import java.util.Set;
import olj;
import olj.a;
import ooz;

public class WSVideoPreDownloadManager
  implements olj.a
{
  private a jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$a;
  private olj jdField_a_of_type_Olj;
  private Set<String> ah;
  private final String aqn = "2";
  private String aqo;
  private List<b> jI;
  public Context mContext;
  
  public WSVideoPreDownloadManager(Context paramContext)
  {
    this.mContext = paramContext;
    this.jdField_a_of_type_Olj = new olj();
    this.jdField_a_of_type_Olj.a(this);
    if (!this.jdField_a_of_type_Olj.EU())
    {
      this.jdField_a_of_type_Olj.installPlugin();
      return;
    }
    aTV();
    aTW();
  }
  
  private void aTV() {}
  
  private void aTW() {}
  
  private void aTY()
  {
    List localList = this.jI;
    if ((localList != null) && (localList.size() > 0)) {}
    label64:
    while (!QLog.isColorLevel())
    {
      for (;;)
      {
        try
        {
          localb1 = (b)localList.get(0);
          localb2 = localb1;
        }
        catch (Exception localException1)
        {
          try
          {
            localList.remove(0);
            localb2 = localb1;
            if ((localb2 != null) && (!TextUtils.isEmpty(localb2.videoUrl))) {
              break;
            }
            aTY();
            return;
          }
          catch (Exception localException2)
          {
            b localb1;
            b localb2;
            int i;
            break label64;
          }
          localException1 = localException1;
          localb1 = null;
        }
        if (QLog.isColorLevel())
        {
          ooz.e("WS_VIDEO_WSVideoPreDownloadManager", 2, "preDownloadVideoNotAlreadyList.remove(0) ERROR = " + localException1.getMessage());
          localb2 = localb1;
        }
      }
      this.aqo = localb2.videoUrl;
      i = localb2.duration;
      if (eG(this.aqo))
      {
        if (QLog.isColorLevel()) {
          ooz.i("WS_VIDEO_WSVideoPreDownloadManager", 2, "innerDoPreDownload() 缓冲已存在，跳过, videoUrl=" + localb2.videoUrl);
        }
        this.aqo = null;
        aTY();
        return;
      }
      s(localb2.videoUrl, i, localb2.videoVid);
      return;
    }
    ooz.i("WS_VIDEO_WSVideoPreDownloadManager", 2, "已完成预下载，队列为空");
  }
  
  private void bfK() {}
  
  private void s(String paramString1, int paramInt, String paramString2) {}
  
  public void a(a parama)
  {
    this.jdField_a_of_type_ComTencentBizPubaccountWeishi_newPlayerWSVideoPreDownloadManager$a = parama;
  }
  
  public void aTZ() {}
  
  public void destroy()
  {
    if (QLog.isColorLevel()) {
      ooz.d("WS_VIDEO_WSVideoPreDownloadManager", 2, "destroy()");
    }
    ThreadManager.post(new WSVideoPreDownloadManager.1(this), 5, null, true);
    if (this.jdField_a_of_type_Olj != null)
    {
      this.jdField_a_of_type_Olj.destroy();
      this.jdField_a_of_type_Olj = null;
    }
  }
  
  public boolean eG(String paramString)
  {
    return false;
  }
  
  public void ns(boolean paramBoolean)
  {
    aTV();
    aTW();
  }
  
  class PreDownloadNotAlreadyVideoTask
    implements Runnable
  {
    private boolean mIsSuccess;
    
    public void run()
    {
      if ((this.mIsSuccess) && (WSVideoPreDownloadManager.a(this.this$0) != null)) {
        WSVideoPreDownloadManager.a(this.this$0).add(WSVideoPreDownloadManager.a(this.this$0));
      }
      WSVideoPreDownloadManager.a(this.this$0, null);
      WSVideoPreDownloadManager.c(this.this$0);
    }
  }
  
  class PreDownloadSerialTask
    implements Runnable
  {
    public void run() {}
  }
  
  public static abstract interface a {}
  
  public static class b
  {
    public int duration;
    public String videoUrl;
    public String videoVid;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.weishi_new.player.WSVideoPreDownloadManager
 * JD-Core Version:    0.7.0.1
 */