import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView;
import com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class shq
{
  private static shq jdField_a_of_type_Shq;
  private int LR;
  private final String TAG = "SubscribePlayerManager";
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private int aDp;
  private boolean aLn;
  private boolean aLo;
  private Set<xaf.a> ay = new HashSet();
  private int bwK = -1;
  private int bwL = -1;
  private int bwM = -1;
  private Runnable dB;
  private Map<Integer, xaf.a> gr = new HashMap();
  private Map<Integer, Integer> gs = new HashMap();
  private Map<Integer, String> gt = new HashMap();
  private int mFirstPosition = -1;
  private Handler mHandler = new Handler(Looper.getMainLooper());
  
  public static shq a()
  {
    if (jdField_a_of_type_Shq == null) {
      jdField_a_of_type_Shq = new shq();
    }
    return jdField_a_of_type_Shq;
  }
  
  private void a(xaf.a parama)
  {
    if (parama != null) {
      while ((parama.hy.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        View localView = parama.hy.getChildAt(0);
        parama.hy.removeView(localView);
        if (((VideoPlayerView)localView).isPlaying()) {
          ((VideoPlayerView)localView).pause();
        }
        ((VideoPlayerView)localView).release();
        a(parama, false);
        QLog.d("SubscribePlayerManager", 4, "release videoPlayer position:" + parama.pos);
      }
    }
  }
  
  private void a(xaf.a parama, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      parama.as.setVisibility(8);
      parama.sR.setVisibility(8);
      parama.IU.setVisibility(0);
      return;
    }
    parama.as.setVisibility(0);
    parama.sR.setVisibility(0);
    parama.IU.setVisibility(8);
  }
  
  private void b(xaf.a parama, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      if (!jqi.isNetworkAvailable(BaseApplicationImpl.context))
      {
        arxa.a().showToast(acfp.m(2131715070));
        QLog.d("SubscribePlayerManager", 4, "network not available");
      }
    }
    else {
      return;
    }
    Object localObject;
    CleanVideoPlayerView localCleanVideoPlayerView;
    int i;
    if (!TextUtils.isEmpty(parama.videoUrl))
    {
      a(parama);
      localObject = ad(parama.videoUrl, "vid");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localCleanVideoPlayerView = new CleanVideoPlayerView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
        localCleanVideoPlayerView.setLoopBack(true);
        localCleanVideoPlayerView.setOutPutMute(true);
        localCleanVideoPlayerView.setWifiAutoPlay(true);
        if (this.gs == null) {
          break label300;
        }
        if (this.gs.get(Integer.valueOf(parama.pos)) == null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      localCleanVideoPlayerView.setVideoPath((String)localObject, "", i);
      localCleanVideoPlayerView.setBaseVideoViewListenerSets(new shs(this, parama));
      localCleanVideoPlayerView.setRevertProgress(true);
      i = ankt.dip2px(180.0F);
      localObject = new RelativeLayout.LayoutParams((int)(i * (parama.videoWidth / parama.videoHeight)), i);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      parama.hy.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
      this.LR = paramInt;
      bjG();
      QLog.d("SubscribePlayerManager", 4, "playInner mCurrentPlayPosition: " + this.LR);
      return;
      i = ((Integer)this.gs.get(Integer.valueOf(parama.pos))).intValue();
      continue;
      QLog.d("SubscribePlayerManager", 4, "vid is empty");
      return;
      QLog.d("SubscribePlayerManager", 4, "url is empty");
      return;
      label300:
      i = 0;
    }
  }
  
  private void bjG()
  {
    xaf.a locala1 = (xaf.a)this.gr.get(Integer.valueOf(this.LR));
    Iterator localIterator = this.ay.iterator();
    while (localIterator.hasNext())
    {
      xaf.a locala2 = (xaf.a)localIterator.next();
      if (locala2 != locala1) {
        a(locala2);
      }
    }
  }
  
  private void byu()
  {
    if (this.dB == null) {
      this.dB = new SubscribePlayerManager.2(this);
    }
    if (!this.aLn) {
      this.mHandler.postDelayed(this.dB, 1000L);
    }
  }
  
  private boolean fj(int paramInt)
  {
    return paramInt == this.bwK;
  }
  
  private boolean fk(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      xaf.a locala = (xaf.a)this.gr.get(Integer.valueOf(paramInt));
      if (locala != null)
      {
        Object localObject = locala.hy;
        Rect localRect = new Rect();
        locala.hy.getLocalVisibleRect(localRect);
        int i = locala.hy.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).isPlaying())
            {
              ((CleanVideoPlayerView)localObject).start();
              QLog.d("SubscribePlayerManager", 4, "play by old player position:" + locala.pos);
            }
            QLog.d("SubscribePlayerManager", 4, "is playing now position:" + locala.pos);
            a(locala, true);
          }
          for (;;)
          {
            return true;
            b(locala, paramInt);
          }
        }
      }
    }
    return false;
  }
  
  private void uD(boolean paramBoolean)
  {
    if (jqi.getNetworkType(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    for (;;)
    {
      return;
      if ((this.LR > this.mFirstPosition) && (this.LR < this.bwL))
      {
        QLog.d("SubscribePlayerManager", 4, "mCurrentPosition:" + this.LR + "is play in screen");
        return;
      }
      QLog.d("SubscribePlayerManager", 4, "mFirstPosition:" + this.mFirstPosition + ",mLastPosition:" + this.bwL);
      int i;
      if (paramBoolean)
      {
        i = this.mFirstPosition;
        while ((i <= this.bwL) && (!fk(i))) {
          i += 1;
        }
      }
      else
      {
        i = this.bwL;
        while ((i >= this.mFirstPosition) && (!fk(i))) {
          i -= 1;
        }
      }
    }
  }
  
  private int uk()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0) == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
  }
  
  public void a(xaf.a parama, int paramInt)
  {
    if ((xaf.a)this.gr.get(Integer.valueOf(paramInt)) == parama) {
      return;
    }
    byu();
    this.gr.put(Integer.valueOf(paramInt), parama);
    this.ay.add(parama);
    View localView = parama.hy.getChildAt(0);
    if ((localView instanceof CleanVideoPlayerView))
    {
      parama.hy.removeView(localView);
      if (((VideoPlayerView)localView).isPlaying()) {
        ((VideoPlayerView)localView).pause();
      }
      ((VideoPlayerView)localView).release();
    }
    a(parama, false);
    parama.sR.setOnClickListener(new shr(this, parama));
    QLog.d("SubscribePlayerManager", 4, "bindViewHolder:" + paramInt + "  HolderSize:" + this.ay.size());
  }
  
  public String ad(String paramString1, String paramString2)
  {
    String str = "";
    String[] arrayOfString = paramString1.substring(paramString1.indexOf("?") + 1).split("&");
    int j = arrayOfString.length;
    int i = 0;
    for (;;)
    {
      paramString1 = str;
      if (i < j)
      {
        paramString1 = arrayOfString[i];
        if (paramString1.contains(paramString2)) {
          paramString1 = paramString1.replace(paramString2 + "=", "");
        }
      }
      else
      {
        return paramString1;
      }
      i += 1;
    }
  }
  
  public void b(xaf.a parama)
  {
    View localView = parama.hy.getChildAt(0);
    a(parama, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      parama.hy.removeView(localView);
      if (((VideoPlayerView)localView).isPlaying())
      {
        ((VideoPlayerView)localView).pause();
        QLog.d("SubscribePlayerManager", 4, "handleScrollOutScreen:" + parama.pos);
      }
      ((CleanVideoPlayerView)localView).release();
      this.LR = -1;
    }
  }
  
  public void c(xaf.a parama, int paramInt)
  {
    if (parama != null)
    {
      this.gr.remove(Integer.valueOf(parama.pos));
      View localView = parama.hy.getChildAt(0);
      if ((localView instanceof CleanVideoPlayerView))
      {
        parama.hy.removeView(localView);
        if (((VideoPlayerView)localView).isPlaying()) {
          ((VideoPlayerView)localView).pause();
        }
        ((VideoPlayerView)localView).release();
        a(parama, false);
        QLog.d("SubscribePlayerManager", 4, "unbind view position:" + paramInt);
      }
    }
  }
  
  public void onResume()
  {
    xaf.a locala = (xaf.a)this.gr.get(Integer.valueOf(this.LR));
    if (locala != null)
    {
      View localView = locala.hy.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (!((VideoPlayerView)localView).isPlaying()))
      {
        ((VideoPlayerView)localView).start();
        QLog.d("SubscribePlayerManager", 4, "onResume play video position:" + locala.pos);
      }
    }
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    if (fj(paramInt1))
    {
      int i = uk();
      if (Math.abs(this.aDp - i) > 0)
      {
        paramInt3 = 1;
        if (paramInt3 != 0) {
          if (this.aDp <= i) {
            break label130;
          }
        }
      }
      label130:
      for (this.aLo = true;; this.aLo = false)
      {
        this.aDp = i;
        paramInt3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        this.mFirstPosition = (paramInt1 - i);
        this.bwM = paramInt2;
        this.bwL = (this.mFirstPosition + paramInt2 - paramInt3 - i);
        return;
        paramInt3 = 0;
        break;
      }
    }
    if (paramInt1 > this.bwK) {}
    for (this.aLo = true;; this.aLo = false)
    {
      this.aDp = uk();
      this.bwK = paramInt1;
      break;
    }
  }
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.mHandler.removeCallbacks(this.dB);
    this.aLn = true;
    QLog.d("SubscribePlayerManager", 4, "mPerFirstVisible:" + this.bwK + "  mFiresVisible:" + this.mFirstPosition);
    if (!this.aLo)
    {
      uD(true);
      QLog.d("SubscribePlayerManager", 4, "begin start");
      return;
    }
    uD(false);
    QLog.d("SubscribePlayerManager", 4, "begin end");
  }
  
  public void onStop()
  {
    xaf.a locala = (xaf.a)this.gr.get(Integer.valueOf(this.LR));
    if (locala != null)
    {
      View localView = locala.hy.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (((VideoPlayerView)localView).isPlaying()))
      {
        ((VideoPlayerView)localView).pause();
        QLog.d("SubscribePlayerManager", 4, "onStop pause video position:" + locala.pos);
      }
    }
  }
  
  public void release()
  {
    this.aLn = false;
    this.bwK = -1;
    this.LR = -1;
    bjG();
    this.mFirstPosition = -1;
    this.bwL = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.gr.clear();
    this.ay.clear();
    this.gs.clear();
    this.gt.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shq
 * JD-Core Version:    0.7.0.1
 */