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
import com.tencent.biz.common.util.NetworkUtil;
import com.tencent.biz.subscribe.videoplayer.CleanVideoPlayerView;
import com.tencent.biz.subscribe.videoplayer.SubscribePlayerManager.2;
import com.tencent.biz.subscribe.videoplayer.VideoPlayerView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.bubble.ChatXListView;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AbsListView;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class zzu
{
  private static zzu jdField_a_of_type_Zzu;
  private int jdField_a_of_type_Int;
  private Handler jdField_a_of_type_AndroidOsHandler = new Handler(Looper.getMainLooper());
  private ChatXListView jdField_a_of_type_ComTencentMobileqqBubbleChatXListView;
  private Runnable jdField_a_of_type_JavaLangRunnable;
  private final String jdField_a_of_type_JavaLangString = "SubscribePlayerManager";
  private Map<Integer, agqf> jdField_a_of_type_JavaUtilMap = new HashMap();
  private Set<agqf> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  private int jdField_b_of_type_Int = -1;
  private Map<Integer, Integer> jdField_b_of_type_JavaUtilMap = new HashMap();
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
  
  public static zzu a()
  {
    if (jdField_a_of_type_Zzu == null) {
      jdField_a_of_type_Zzu = new zzu();
    }
    return jdField_a_of_type_Zzu;
  }
  
  private void a(agqf paramagqf, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      paramagqf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      paramagqf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
      paramagqf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(0);
      return;
    }
    paramagqf.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
    paramagqf.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
    paramagqf.jdField_a_of_type_AndroidWidgetTextView.setVisibility(8);
  }
  
  private void a(boolean paramBoolean)
  {
    if (NetworkUtil.getNetworkType(BaseApplicationImpl.context) != 1) {
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
  
  private void b(agqf paramagqf)
  {
    if (paramagqf != null) {
      while ((paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0) instanceof CleanVideoPlayerView))
      {
        View localView = paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
        paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).f()) {
          ((VideoPlayerView)localView).f();
        }
        ((VideoPlayerView)localView).i();
        a(paramagqf, false);
        QLog.d("SubscribePlayerManager", 4, "release videoPlayer position:" + paramagqf.jdField_b_of_type_Int);
      }
    }
  }
  
  private boolean b(int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      agqf localagqf = (agqf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt));
      if (localagqf != null)
      {
        Object localObject = localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout;
        Rect localRect = new Rect();
        localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getLocalVisibleRect(localRect);
        int i = localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getHeight();
        if ((localRect.top == 0) && (localRect.bottom == i))
        {
          localObject = ((RelativeLayout)localObject).getChildAt(0);
          if ((localObject instanceof CleanVideoPlayerView))
          {
            localObject = (CleanVideoPlayerView)localObject;
            if (!((CleanVideoPlayerView)localObject).f())
            {
              ((CleanVideoPlayerView)localObject).e();
              QLog.d("SubscribePlayerManager", 4, "play by old player position:" + localagqf.jdField_b_of_type_Int);
            }
            QLog.d("SubscribePlayerManager", 4, "is playing now position:" + localagqf.jdField_b_of_type_Int);
            a(localagqf, true);
          }
          for (;;)
          {
            return true;
            c(localagqf, paramInt);
          }
        }
      }
    }
    return false;
  }
  
  private void c(agqf paramagqf, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView != null)
    {
      if (!NetworkUtil.isNetworkAvailable(BaseApplicationImpl.context))
      {
        bjkv.a().a(anvx.a(2131714033));
        QLog.d("SubscribePlayerManager", 4, "network not available");
      }
    }
    else {
      return;
    }
    Object localObject;
    CleanVideoPlayerView localCleanVideoPlayerView;
    int i;
    if (!TextUtils.isEmpty(paramagqf.jdField_b_of_type_JavaLangString))
    {
      b(paramagqf);
      localObject = a(paramagqf.jdField_b_of_type_JavaLangString, "vid");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localCleanVideoPlayerView = new CleanVideoPlayerView(this.jdField_a_of_type_ComTencentMobileqqBubbleChatXListView.getContext());
        localCleanVideoPlayerView.setLoopBack(true);
        localCleanVideoPlayerView.setOutPutMute(true);
        localCleanVideoPlayerView.setWifiAutoPlay(true);
        if (this.jdField_b_of_type_JavaUtilMap == null) {
          break label301;
        }
        if (this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramagqf.jdField_b_of_type_Int)) == null) {
          i = 0;
        }
      }
    }
    for (;;)
    {
      localCleanVideoPlayerView.setVideoPath((String)localObject, "", i);
      localCleanVideoPlayerView.setBaseVideoViewListenerSets(new zzw(this, paramagqf));
      localCleanVideoPlayerView.setRevertProgress(true);
      i = ScreenUtil.dip2px(180.0F);
      localObject = new RelativeLayout.LayoutParams((int)(i * (paramagqf.e / paramagqf.f)), i);
      ((RelativeLayout.LayoutParams)localObject).addRule(13);
      paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.addView(localCleanVideoPlayerView, 0, (ViewGroup.LayoutParams)localObject);
      this.f = paramInt;
      e();
      QLog.d("SubscribePlayerManager", 4, "playInner mCurrentPlayPosition: " + this.f);
      return;
      i = ((Integer)this.jdField_b_of_type_JavaUtilMap.get(Integer.valueOf(paramagqf.jdField_b_of_type_Int))).intValue();
      continue;
      QLog.d("SubscribePlayerManager", 4, "vid is empty");
      return;
      QLog.d("SubscribePlayerManager", 4, "url is empty");
      return;
      label301:
      i = 0;
    }
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
    agqf localagqf1 = (agqf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    Iterator localIterator = this.jdField_a_of_type_JavaUtilSet.iterator();
    while (localIterator.hasNext())
    {
      agqf localagqf2 = (agqf)localIterator.next();
      if (localagqf2 != localagqf1) {
        b(localagqf2);
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
    agqf localagqf = (agqf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localagqf != null)
    {
      View localView = localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (!((VideoPlayerView)localView).f()))
      {
        ((VideoPlayerView)localView).e();
        QLog.d("SubscribePlayerManager", 4, "onResume play video position:" + localagqf.jdField_b_of_type_Int);
      }
    }
  }
  
  public void a(agqf paramagqf)
  {
    View localView = paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    a(paramagqf, false);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).f())
      {
        ((VideoPlayerView)localView).f();
        QLog.d("SubscribePlayerManager", 4, "handleScrollOutScreen:" + paramagqf.jdField_b_of_type_Int);
      }
      ((CleanVideoPlayerView)localView).i();
      this.f = -1;
    }
  }
  
  public void a(agqf paramagqf, int paramInt)
  {
    if ((agqf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(paramInt)) == paramagqf) {
      return;
    }
    d();
    this.jdField_a_of_type_JavaUtilMap.put(Integer.valueOf(paramInt), paramagqf);
    this.jdField_a_of_type_JavaUtilSet.add(paramagqf);
    View localView = paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
    if ((localView instanceof CleanVideoPlayerView))
    {
      paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
      if (((VideoPlayerView)localView).f()) {
        ((VideoPlayerView)localView).f();
      }
      ((VideoPlayerView)localView).i();
    }
    a(paramagqf, false);
    paramagqf.jdField_a_of_type_AndroidWidgetImageView.setOnClickListener(new zzv(this, paramagqf));
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
    agqf localagqf = (agqf)this.jdField_a_of_type_JavaUtilMap.get(Integer.valueOf(this.f));
    if (localagqf != null)
    {
      View localView = localagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if (((localView instanceof CleanVideoPlayerView)) && (((VideoPlayerView)localView).f()))
      {
        ((VideoPlayerView)localView).f();
        QLog.d("SubscribePlayerManager", 4, "onStop pause video position:" + localagqf.jdField_b_of_type_Int);
      }
    }
  }
  
  public void b(agqf paramagqf, int paramInt)
  {
    if (paramagqf != null)
    {
      this.jdField_a_of_type_JavaUtilMap.remove(Integer.valueOf(paramagqf.jdField_b_of_type_Int));
      View localView = paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.getChildAt(0);
      if ((localView instanceof CleanVideoPlayerView))
      {
        paramagqf.jdField_a_of_type_AndroidWidgetRelativeLayout.removeView(localView);
        if (((VideoPlayerView)localView).f()) {
          ((VideoPlayerView)localView).f();
        }
        ((VideoPlayerView)localView).i();
        a(paramagqf, false);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzu
 * JD-Core Version:    0.7.0.1
 */