import android.os.Handler;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.1;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.2;
import com.tencent.biz.pubaccount.readinjoy.ReadInJoyNaviController.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyNavigationGridview;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.app.AppRuntime;
import org.json.JSONObject;

public class kgk
{
  public static int aIE;
  public static int aIF;
  public static int aIG = 7;
  private ReadInJoyNavigationGridview a;
  public int aID;
  public final int aIH = aqnm.dip2px(5.0F);
  private boolean aeQ = true;
  private ImageView hV;
  protected lce mObserver = new kgo(this);
  private ViewGroup mRootView;
  
  public kgk(ViewGroup paramViewGroup, ReadInJoyNavigationGridview paramReadInJoyNavigationGridview, ImageView paramImageView)
  {
    this.mRootView = paramViewGroup;
    this.a = paramReadInJoyNavigationGridview;
    this.hV = paramImageView;
    this.a.setChannelButtonListener(new kgk.a(this));
    lcc.a().b(this.mObserver);
    aCn();
  }
  
  private List<ChannelCoverInfo> H(List<ChannelCoverInfo> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramList != null)
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)paramList.next();
        if (!localChannelCoverInfo.isExternalExposure) {
          localArrayList.add(localChannelCoverInfo);
        }
      }
    }
    QLog.d("ReadInJoyNaviController", 2, "filtered channel list size: " + localArrayList.size());
    return localArrayList;
  }
  
  public static String a(int paramInt, ChannelCoverInfo paramChannelCoverInfo)
  {
    JSONObject localJSONObject = kxm.w();
    switch (paramInt)
    {
    }
    for (;;)
    {
      return localJSONObject.toString();
      if (paramChannelCoverInfo != null) {
        for (;;)
        {
          try
          {
            localJSONObject.put("channel_id", paramChannelCoverInfo.mChannelCoverId);
            if (!TextUtils.isEmpty(paramChannelCoverInfo.mChannelJumpUrl)) {
              break label89;
            }
            paramInt = 1;
            localJSONObject.put("content_type", paramInt);
            localJSONObject.put("channel_index", aIF);
          }
          catch (Exception paramChannelCoverInfo)
          {
            paramChannelCoverInfo.printStackTrace();
          }
          break;
          label89:
          paramInt = 2;
        }
      }
      localJSONObject.put("channel_id", -1);
      localJSONObject.put("content_type", -1);
      localJSONObject.put("channel_index", -1);
    }
  }
  
  public static void ao(int paramInt, String paramString)
  {
    String str = "";
    switch (paramInt)
    {
    }
    for (;;)
    {
      kbp.a(null, "CliOper", "", "", str, str, 0, 0, "", "", "", paramString, false);
      return;
      str = "0X8008B81";
      continue;
      str = "0X8008B83";
    }
  }
  
  private void ej(long paramLong)
  {
    kxm.p().postDelayed(new ReadInJoyNaviController.4(this), paramLong);
  }
  
  public void a(ChannelCoverInfo paramChannelCoverInfo)
  {
    Iterator localIterator;
    int i;
    if (isShow()) {
      if (paramChannelCoverInfo != null)
      {
        localIterator = this.a.getChannels().iterator();
        i = 0;
      }
    }
    for (;;)
    {
      if (localIterator.hasNext())
      {
        ChannelCoverInfo localChannelCoverInfo = (ChannelCoverInfo)localIterator.next();
        if ((localChannelCoverInfo != null) && (localChannelCoverInfo.mChannelCoverId == paramChannelCoverInfo.mChannelCoverId)) {
          aIF = i;
        }
      }
      else
      {
        kxm.p().postDelayed(new ReadInJoyNaviController.2(this, paramChannelCoverInfo), 0L);
        return;
      }
      i += 1;
    }
  }
  
  public void aCn()
  {
    try
    {
      lcd locallcd = (lcd)kxm.getAppRuntime().getManager(163);
      List localList = locallcd.b().r(0);
      if ((localList == null) || (localList.size() == 0))
      {
        locallcd.b().qq(0);
        if (QLog.isColorLevel()) {
          QLog.d("ReadInJoyNaviController", 2, "No channel Cache info.");
        }
      }
      for (;;)
      {
        locallcd.b().qo(0);
        return;
        bL(localList);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public void bL(List<ChannelCoverInfo> paramList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyNaviController", 2, "setAdapterData.");
    }
    this.a.setNaviBarAdapterDataSet(H(paramList));
  }
  
  public void destroy()
  {
    if (this.a != null) {
      this.a.destroy();
    }
    lcc.a().c(this.mObserver);
  }
  
  public boolean isShow()
  {
    return this.mRootView.findViewWithTag("mReadInJoyNavigation") != null;
  }
  
  public void show(int paramInt)
  {
    if (this.a.qA() <= 0)
    {
      aCn();
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyNaviController", 2, "No channel info.");
      }
    }
    do
    {
      return;
      aIE = paramInt;
    } while (this.mRootView.findViewWithTag("mReadInJoyNavigation") != null);
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 48;
    localLayoutParams.topMargin = this.aID;
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.getChannels().iterator();
    int i = 0;
    if (localIterator.hasNext())
    {
      ChannelCoverInfo localChannelCoverInfo = ((ChannelCoverInfo)localIterator.next()).clone();
      if (localChannelCoverInfo != null) {
        if (paramInt != localChannelCoverInfo.mChannelCoverId) {
          break label176;
        }
      }
      label176:
      for (boolean bool = true;; bool = false)
      {
        localChannelCoverInfo.isSelected = bool;
        if (paramInt == localChannelCoverInfo.mChannelCoverId) {
          aIF = i;
        }
        localArrayList.add(localChannelCoverInfo);
        i += 1;
        break;
      }
    }
    bL(localArrayList);
    this.a.setAlpha(0.0F);
    this.mRootView.addView(this.a, localLayoutParams);
    this.a.setTag("mReadInJoyNavigation");
    kxm.p().postDelayed(new ReadInJoyNaviController.1(this), 0L);
  }
  
  static class a
    implements ngj.a
  {
    private WeakReference<kgk> cc;
    
    a(kgk paramkgk)
    {
      this.cc = new WeakReference(paramkgk);
    }
    
    public void b(ChannelCoverInfo paramChannelCoverInfo)
    {
      kgk localkgk = (kgk)this.cc.get();
      if (((localkgk == null) || (kgk.a(localkgk).isDestroy())) && (QLog.isColorLevel()))
      {
        QLog.d("ReadInJoyNaviController", 2, "ChannelButtonListenerImpl. ReadInJoyNavigationGridview has destoryed");
        return;
      }
      localkgk.a(paramChannelCoverInfo);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kgk
 * JD-Core Version:    0.7.0.1
 */