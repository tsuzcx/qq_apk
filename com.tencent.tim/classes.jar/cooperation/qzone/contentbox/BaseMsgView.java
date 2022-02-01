package cooperation.qzone.contentbox;

import aimd;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import aqnm;
import com.tencent.image.ApngImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.contentbox.model.MQMsg;
import cooperation.qzone.contentbox.model.MQMsgBody;
import cooperation.qzone.contentbox.model.MQPhotoCell;
import java.io.File;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;
import java.net.URL;
import java.util.ArrayList;
import mqq.app.AppRuntime;

public abstract class BaseMsgView
  extends FrameLayout
{
  private static final int IMAGE_HEIGHT = aqnm.dpToPx(230.0F);
  private static final int IMAGE_WIDTH = aqnm.getScreenWidth() - aqnm.dpToPx(24.0F);
  protected b a;
  protected QzoneMsgPagerAdapter a;
  protected QzoneMsgViewPager a;
  public MQMsg a;
  protected QQAppInterface app;
  private WeakReference<ViewPager> co;
  protected int eyr;
  public Context mContext;
  protected int position;
  
  public BaseMsgView(@NonNull Context paramContext)
  {
    super(paramContext);
  }
  
  public BaseMsgView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public BaseMsgView(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public static URLDrawable a(AppRuntime paramAppRuntime, String paramString1, String paramString2, Drawable paramDrawable, int[] paramArrayOfInt, String paramString3, Bundle paramBundle)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return null;
    }
    paramAppRuntime = paramBundle;
    if (paramBundle == null) {}
    try
    {
      paramAppRuntime = new Bundle();
      boolean bool = paramAppRuntime.getBoolean("key_play_apng", true);
      int i = paramAppRuntime.getInt("key_loop");
      paramBundle = URLDrawable.URLDrawableOptions.obtain();
      paramBundle.mUseApngImage = bool;
      paramBundle.mUseMemoryCache = true;
      paramBundle.mMemoryCacheKeySuffix = (bool + "," + i);
      i = paramAppRuntime.getInt("key_width", 0);
      int j = paramAppRuntime.getInt("key_height", 0);
      if ((i > 0) && (j > 0)) {
        paramBundle.mRequestWidth = i;
      }
      for (paramBundle.mRequestHeight = j;; paramBundle.mRequestHeight = IMAGE_HEIGHT)
      {
        paramBundle.mLoadingDrawable = paramDrawable;
        paramBundle.mFailedDrawable = paramDrawable;
        paramAppRuntime.putIntArray("key_tagId_arr", paramArrayOfInt);
        paramAppRuntime.putString("key_name", paramString3);
        paramBundle.mExtraInfo = paramAppRuntime;
        paramAppRuntime = URLDrawable.getDrawable(new URL("qzonecontentboxdownloader", paramString1, paramString2), paramBundle);
        if (!QLog.isColorLevel()) {
          break;
        }
        QLog.d("QZoneMsgManager.BaseMsgView", 2, "getApngDrawable ApngImage ok path:" + paramString1 + ", name=" + paramString3);
        break;
        paramBundle.mRequestWidth = IMAGE_WIDTH;
      }
      return paramAppRuntime;
    }
    catch (Exception paramAppRuntime)
    {
      QLog.e("QZoneMsgManager.BaseMsgView", 1, "getApngDrawable ApngImage err:" + paramAppRuntime.toString() + ", path:" + paramString1 + ", name=" + paramString3);
      return null;
    }
  }
  
  public boolean aLD()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg == null) {}
    while (this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.msgType == 6) {
      return false;
    }
    return true;
  }
  
  protected URLDrawable e(String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = IMAGE_WIDTH;
    localURLDrawableOptions.mRequestHeight = IMAGE_HEIGHT;
    return URLDrawable.getDrawable(paramString, localURLDrawableOptions);
  }
  
  protected URLDrawable g()
  {
    String str1 = this.mContext.getFilesDir() + "/qzone_msg_content_box/";
    Object localObject = new File(str1);
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdir();
    }
    localObject = ((MQPhotoCell)this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg.msgBody.photolist.get(0)).coverUrl;
    String str2 = MD5.toMD5((String)localObject).substring(0, 20);
    this.eyr = (this.position + 10000);
    return a(this.app, str1 + str2, (String)localObject, null, new int[] { this.eyr }, "content-box", null);
  }
  
  protected void initViewPager()
  {
    try
    {
      Field localField = Class.forName("android.support.v4.view.ViewPager").getDeclaredField("mScroller");
      a locala = new a(this.mContext, new aimd(0.25D, 0.1000000014901161D, 0.25D, 1.0D));
      locala.abX(400);
      localField.setAccessible(true);
      localField.set(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager, locala);
      return;
    }
    catch (Exception localException)
    {
      QLog.e("QZoneMsgManager.BaseMsgView", 1, "initViewPager error:", localException);
    }
  }
  
  protected boolean r(Message paramMessage)
  {
    return false;
  }
  
  public void recycle()
  {
    stopAll();
    this.mContext = null;
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager = null;
    this.co = null;
    this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter = null;
    this.app = null;
    this.jdField_a_of_type_CooperationQzoneContentboxModelMQMsg = null;
  }
  
  public void setApp(QQAppInterface paramQQAppInterface)
  {
    this.app = paramQQAppInterface;
  }
  
  public void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  public void startPlay()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b == null) {
      return;
    }
    if ((this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager != null) && (this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager.getVisibility() == 0) && (this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter != null) && (this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter.getCount() > 1))
    {
      this.co = new WeakReference(this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgViewPager);
      Message localMessage = this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b.obtainMessage(10000, this.jdField_a_of_type_CooperationQzoneContentboxQzoneMsgPagerAdapter.getCount(), 0, this.co);
      this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b.removeMessages(10000);
      this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b.sendMessageDelayed(localMessage, 3000L);
      return;
    }
    ApngImage.playByTag(this.eyr);
  }
  
  public void stopAll()
  {
    if (this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b == null) {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b.removeMessages(10000);
  }
  
  public void stopPlay()
  {
    if ((this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b == null) || (this.co == null)) {
      return;
    }
    this.jdField_a_of_type_CooperationQzoneContentboxBaseMsgView$b.removeMessages(10000, this.co);
    ApngImage.pauseByTag(this.eyr);
  }
  
  static class a
    extends Scroller
  {
    public int mDuration;
    
    public a(Context paramContext, Interpolator paramInterpolator)
    {
      super(paramInterpolator);
    }
    
    public void abX(int paramInt)
    {
      this.mDuration = paramInt;
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
    }
    
    public void startScroll(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
    {
      super.startScroll(paramInt1, paramInt2, paramInt3, paramInt4, this.mDuration);
    }
  }
  
  public static class b
    extends Handler
  {
    private WeakReference<BaseMsgView> jd;
    
    public b(BaseMsgView paramBaseMsgView)
    {
      this.jd = new WeakReference(paramBaseMsgView);
    }
    
    public void handleMessage(Message paramMessage)
    {
      super.handleMessage(paramMessage);
      BaseMsgView localBaseMsgView = (BaseMsgView)this.jd.get();
      if (localBaseMsgView == null) {}
      ViewPager localViewPager;
      do
      {
        return;
        switch (paramMessage.what)
        {
        default: 
          localBaseMsgView.r(paramMessage);
          return;
        }
        localViewPager = (ViewPager)((WeakReference)paramMessage.obj).get();
      } while (localViewPager == null);
      int i = paramMessage.arg1;
      localViewPager.setCurrentItem((localViewPager.getCurrentItem() + 1) % i, true);
      localBaseMsgView.startPlay();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.BaseMsgView
 * JD-Core Version:    0.7.0.1
 */