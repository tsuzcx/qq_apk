import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.tencent.biz.pubaccount.readinjoy.video.LikeAnimationInfo;
import com.tencent.biz.pubaccount.readinjoy.video.VideoFeedsLikeAnimate;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;
import mqq.app.AppRuntime;

public class mvn
{
  private static int aUW;
  private LikeAnimationInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo;
  private mvm jdField_a_of_type_Mvm;
  private mvn.a jdField_a_of_type_Mvn$a;
  private URLDrawable[] jdField_a_of_type_ArrayOfComTencentImageURLDrawable;
  private boolean aoI;
  private int[] dq;
  private ViewGroup mParentView;
  private Random mRandom;
  
  public mvn(Activity paramActivity, int paramInt)
  {
    if ((paramActivity == null) || (paramActivity.getWindow() == null) || (paramActivity.getWindow().getDecorView() == null)) {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateManager", 2, "activity in a invalid state");
      }
    }
    label236:
    do
    {
      do
      {
        do
        {
          do
          {
            return;
            this.mParentView = ((ViewGroup)paramActivity.getWindow().getDecorView().findViewById(16908290));
          } while (this.mParentView == null);
          this.dq = new int[2];
          aUW = wja.dp2px(28.0F, paramActivity.getResources());
          this.mParentView.getLocationInWindow(this.dq);
          this.mRandom = new Random();
          paramActivity = getApp();
          if (paramActivity != null)
          {
            this.jdField_a_of_type_Mvm = ((mvm)paramActivity.getBusinessHandler(138));
            this.jdField_a_of_type_Mvn$a = new mvn.a();
            paramActivity.addObserver(this.jdField_a_of_type_Mvn$a);
          }
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo = awit.a();
          if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo == null) {
            break label236;
          }
          if ((this.jdField_a_of_type_Mvm == null) || (!awit.nK(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo.aTU))) {
            break;
          }
          this.jdField_a_of_type_Mvm.sD(paramInt);
          awit.nQ(System.currentTimeMillis());
        } while (!QLog.isColorLevel());
        QLog.d("VideoFeedsLikeAnimateManager", 2, "fetch icon list");
        return;
        a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyVideoLikeAnimationInfo);
      } while (!QLog.isColorLevel());
      QLog.d("VideoFeedsLikeAnimateManager", 2, "use local icon list");
      return;
    } while (this.jdField_a_of_type_Mvm == null);
    this.jdField_a_of_type_Mvm.sD(paramInt);
    awit.nQ(System.currentTimeMillis());
  }
  
  private boolean EC()
  {
    boolean bool2;
    if ((this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable == null) || (this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable.length == 0))
    {
      bool2 = false;
      return bool2;
    }
    URLDrawable[] arrayOfURLDrawable = this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable;
    int m = arrayOfURLDrawable.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      URLDrawable localURLDrawable = arrayOfURLDrawable[i];
      k = j;
      if (localURLDrawable != null)
      {
        k = j;
        if (localURLDrawable.getStatus() == 1) {
          k = j + 1;
        }
      }
      i += 1;
    }
    if (j == this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable.length) {}
    for (boolean bool1 = true;; bool1 = false)
    {
      bool2 = bool1;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("VideoFeedsLikeAnimateManager", 2, "isHit: " + bool1);
      return bool1;
    }
  }
  
  private void a(LikeAnimationInfo paramLikeAnimationInfo)
  {
    if ((paramLikeAnimationInfo == null) || (paramLikeAnimationInfo.bA == null) || (paramLikeAnimationInfo.bA.length == 0)) {
      return;
    }
    if (this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable != null) {
      this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable = null;
    }
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mRequestWidth = aUW;
    localURLDrawableOptions.mRequestHeight = aUW;
    this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable = new URLDrawable[paramLikeAnimationInfo.bA.length];
    int i = 0;
    while (i < paramLikeAnimationInfo.bA.length)
    {
      String str = paramLikeAnimationInfo.bA[i];
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        URLDrawable localURLDrawable = URLDrawable.getDrawable(new URL(str), localURLDrawableOptions);
        localURLDrawable.startDownload();
        this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable[i] = localURLDrawable;
        i += 1;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("VideoFeedsLikeAnimateManager", 2, "illegal url format: " + str);
          }
        }
      }
    }
  }
  
  private QQAppInterface getApp()
  {
    AppRuntime localAppRuntime = kxm.getAppRuntime();
    if ((localAppRuntime != null) && ((localAppRuntime instanceof QQAppInterface))) {
      return (QQAppInterface)localAppRuntime;
    }
    return null;
  }
  
  public void onDestroy()
  {
    this.mParentView = null;
    this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable = null;
    QQAppInterface localQQAppInterface = getApp();
    if (localQQAppInterface != null) {
      localQQAppInterface.removeObserver(this.jdField_a_of_type_Mvn$a);
    }
  }
  
  public int pV()
  {
    if (this.aoI) {
      return 1;
    }
    return 0;
  }
  
  public void y(float paramFloat1, float paramFloat2)
  {
    if (this.mParentView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("VideoFeedsLikeAnimateManager", 2, "parent view is null");
      }
      return;
    }
    VideoFeedsLikeAnimate localVideoFeedsLikeAnimate = new VideoFeedsLikeAnimate(this.mParentView, paramFloat1 - this.dq[0], paramFloat2 - this.dq[1], this.mRandom);
    if (EC()) {
      localVideoFeedsLikeAnimate.a(this.jdField_a_of_type_ArrayOfComTencentImageURLDrawable, 4, aUW);
    }
    for (this.aoI = true;; this.aoI = false)
    {
      localVideoFeedsLikeAnimate.startAnimate();
      return;
      localVideoFeedsLikeAnimate.sC(5);
    }
  }
  
  public class a
    implements acci
  {
    public a() {}
    
    public void onUpdate(int paramInt, boolean paramBoolean, Object paramObject)
    {
      if ((paramObject == null) || (!(paramObject instanceof Bundle))) {}
      while (!paramBoolean) {
        return;
      }
      paramObject = (Bundle)paramObject;
      mvn.a(mvn.this, (LikeAnimationInfo)paramObject.getParcelable("key_like_animation_info"));
      awit.eDI();
      awit.b(mvn.a(mvn.this));
      mvn.a(mvn.this, mvn.a(mvn.this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     mvn
 * JD-Core Version:    0.7.0.1
 */