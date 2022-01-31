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

public class wet
{
  private static wet jdField_a_of_type_Wet;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "SubscribePlayerManager";
  private Map<Integer, adcg> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<adcg> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Map<Integer, Long> jdField_b_of_type_JavaUtilMap = new HashMap();
  private boolean jdField_b_of_type_Boolean;
  private int jdField_c_of_type_Int = -1;
  private Map<Integer, String> jdField_c_of_type_JavaUtilMap = new HashMap();
  private int d = -1;
  private int e = -1;
  private int f;
  
  private int a()
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) || (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0) == null)) {
      return 0;
    }
    return this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getChildAt(0).getTop();
  }
  
  public static wet a()
  {
    if (jdField_a_of_type_Wet == null) {
      jdField_a_of_type_Wet = new wet();
    }
    return jdField_a_of_type_Wet;
  }
  
  private void a(adcg paramadcg, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramadcg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramadcg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramadcg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramadcg.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    paramadcg.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramadcg.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (mpq.a(BaseApplicationImpl.context) != 1) {
      QLog.d("SubscribePlayerManager", 4, "not wifi autoPlay return");
    }
    for (;;)
    {
      return;
      if ((this.f > this.jdField_c_of_type_Int) && (this.f < this.d))
      {
        QLog.d("SubscribePlayerManager", 4, "mCurrentPosition:" + this.f + "is play in screen");
        return;
      }
      QLog.d("SubscribePlayerManager", 4, "mFirstPosition:" + this.jdField_c_of_type_Int + ",mLastPosition:" + this.d);
      int i;
      if (paramBoolean)
      {
        i = this.jdField_c_of_type_Int;
        while ((i <= this.d) && (!b(i))) {
          i += 1;
        }
      }
      else
      {
        i = this.d;
        while ((i >= this.jdField_c_of_type_Int) && (!b(i))) {
          i -= 1;
        }
      }
    }
  }
  
  private boolean a(int paramInt)
  {
    return paramInt == this.jdField_b_of_type_Int;
  }
  
  private void b(adcg paramadcg)
  {
    if (paramadcg != null) {
      while ((paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        View localView = paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).c()) {
          ((VideoPlayerView)localView).a();
        }
        ((VideoPlayerView)localView).g();
        a(paramadcg, false);
        QLog.d("SubscribePlayerManager", 4, "release videoPlayer position:" + paramadcg.jdField_b_of_type_Int);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      adcg localadcg = (adcg)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localadcg != null)
      {
        Object localObject = localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout;
        Rect localRect = new Rect();
        localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocalVisibleRect(localRect);
        int i = localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).c())
            {
              ((CleanVideoPlayerView)localObject).d();
              QLog.d("SubscribePlayerManager", 4, "play by old player position:" + localadcg.jdField_b_of_type_Int);
            }
            QLog.d("SubscribePlayerManager", 4, "is playing now position:" + localadcg.jdField_b_of_type_Int);
            a(localadcg, true);
          }
          for (;;)
          {
            return true;
            c(localadcg, paramInt);
          }
        }
      }
    }
    return false;
  }
  
  private void c(adcg paramadcg, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      if (!mpq.a(BaseApplicationImpl.context))
      {
        bcec.a().a(ajjy.a(2131648860));
        QLog.d("SubscribePlayerManager", 4, "network not available");
      }
    }
    else {
      return;
    }
    if (!TextUtils.isEmpty(paramadcg.jdField_b_of_type_JavaLangString))
    {
      b(paramadcg);
      Object localObject = a(paramadcg.jdField_b_of_type_JavaLangString, "vid");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        CleanVideoPlayerView localCleanVideoPlayerView = new CleanVideoPlayerView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
        localCleanVideoPlayerView.setLoopBack(true);
        localCleanVideoPlayerView.setOutPutMute(true);
        localCleanVideoPlayerView.setWifiAutoPlay(true);
        localCleanVideoPlayerView.setVideoPath((String)localObject, "", "", 0, 0, 0);
        localCleanVideoPlayerView.setOnProgressListener(new wev(this, paramadcg));
        localCleanVideoPlayerView.setOnPrepareListener(new wew(this, paramadcg, localCleanVideoPlayerView));
        localCleanVideoPlayerView.setDarkFrameCheckListener(new wex(this, paramadcg));
        localCleanVideoPlayerView.setRevertProgress(true);
        int i = awmc.a(180.0F);
        localObject = new RelativeLayout.LayoutParams((int)(i * (paramadcg.e / paramadcg.f)), i);
        ((RelativeLayout.LayoutParams)localObject).addRule(13);
        paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
        this.f = paramInt;
        e();
        QLog.d("SubscribePlayerManager", 4, "playInner mCurrentPlayPosition: " + this.f);
        return;
      }
      QLog.d("SubscribePlayerManager", 4, "vid is empty");
      return;
    }
    QLog.d("SubscribePlayerManager", 4, "url is empty");
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_JavaLangRunnable == null) {
      this.jdField_a_of_type_JavaLangRunnable = new SubscribePlayerManager.2(this);
    }
    if (!this.jdField_a_of_type_Boolean) {
      this.jdField_a_of_type_AndroidOsHandler.postDelayed(this.jdField_a_of_type_JavaLangRunnable, 1000L);
    }
  }
  
  private void e()
  {
    adcg localadcg1 = (adcg)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      adcg localadcg2 = (adcg)localIterator.next();
      if (localadcg2 != localadcg1) {
        b(localadcg2);
      }
    }
  }
  
  public String a(String paramString1, String paramString2)
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
  
  public void a()
  {
    adcg localadcg = (adcg)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localadcg != null)
    {
      View localView = localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (!((VideoPlayerView)localView).c()))
      {
        ((VideoPlayerView)localView).d();
        QLog.d("SubscribePlayerManager", 4, "onResume play video position:" + localadcg.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(adcg paramadcg)
  {
    View localView = paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    a(paramadcg, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).c())
      {
        ((VideoPlayerView)localView).a();
        QLog.d("SubscribePlayerManager", 4, "handleScrollOutScreen:" + paramadcg.jdField_b_of_type_Int);
      }
      ((CleanVideoPlayerView)localView).g();
      this.f = -1;
    }
  }
  
  public void a(adcg paramadcg, int paramInt)
  {
    if ((adcg)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == paramadcg) {
      return;
    }
    d();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramadcg);
    this.jdField_a_of_type_JavaUtilSet.add(paramadcg);
    View localView = paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).c()) {
        ((VideoPlayerView)localView).a();
      }
      ((VideoPlayerView)localView).g();
    }
    a(paramadcg, false);
    paramadcg.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new weu(this, paramadcg));
    QLog.d("SubscribePlayerManager", 4, "bindViewHolder:" + paramInt + "  HolderSize:" + this.jdField_a_of_type_JavaUtilSet.size());
  }
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    switch (paramInt)
    {
    default: 
      return;
    }
    this.jdField_a_of_type_AndroidOsHandler.removeCallbacks(this.jdField_a_of_type_JavaLangRunnable);
    this.jdField_a_of_type_Boolean = true;
    QLog.d("SubscribePlayerManager", 4, "mPerFirstVisible:" + this.jdField_b_of_type_Int + "  mFiresVisible:" + this.jdField_c_of_type_Int);
    if (!this.jdField_b_of_type_Boolean)
    {
      a(true);
      QLog.d("SubscribePlayerManager", 4, "begin start");
      return;
    }
    a(false);
    QLog.d("SubscribePlayerManager", 4, "begin end");
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramInt3 == 0) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView == null) {
      this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = ((ChatXListView)paramAbsListView);
    }
    if (a(paramInt1))
    {
      int i = a();
      if (Math.abs(this.jdField_a_of_type_Int - i) > 0)
      {
        paramInt3 = 1;
        if (paramInt3 != 0) {
          if (this.jdField_a_of_type_Int <= i) {
            break label130;
          }
        }
      }
      label130:
      for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
      {
        this.jdField_a_of_type_Int = i;
        paramInt3 = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getFooterViewsCount();
        i = this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getHeaderViewsCount();
        this.jdField_c_of_type_Int = (paramInt1 - i);
        this.e = paramInt2;
        this.d = (this.jdField_c_of_type_Int + paramInt2 - paramInt3 - i);
        return;
        paramInt3 = 0;
        break;
      }
    }
    if (paramInt1 > this.jdField_b_of_type_Int) {}
    for (this.jdField_b_of_type_Boolean = true;; this.jdField_b_of_type_Boolean = false)
    {
      this.jdField_a_of_type_Int = a();
      this.jdField_b_of_type_Int = paramInt1;
      break;
    }
  }
  
  public void b()
  {
    adcg localadcg = (adcg)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localadcg != null)
    {
      View localView = localadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (((VideoPlayerView)localView).c()))
      {
        ((VideoPlayerView)localView).a();
        QLog.d("SubscribePlayerManager", 4, "onStop pause video position:" + localadcg.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(adcg paramadcg, int paramInt)
  {
    if (paramadcg != null)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramadcg.jdField_b_of_type_Int));
      View localView = paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localView instanceof CleanVideoPlayerView))
      {
        paramadcg.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).c()) {
          ((VideoPlayerView)localView).a();
        }
        ((VideoPlayerView)localView).g();
        a(paramadcg, false);
        QLog.d("SubscribePlayerManager", 4, "unbind view position:" + paramInt);
      }
    }
  }
  
  public void c()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Int = -1;
    this.f = -1;
    e();
    this.jdField_c_of_type_Int = -1;
    this.d = -1;
    this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView = null;
    this.jdField_a_of_type_JavaUtilMap.clear();
    this.jdField_a_of_type_JavaUtilSet.clear();
    this.jdField_b_of_type_JavaUtilMap.clear();
    this.jdField_c_of_type_JavaUtilMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wet
 * JD-Core Version:    0.7.0.1
 */