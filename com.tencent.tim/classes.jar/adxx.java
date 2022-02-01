import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TypeEvaluator;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.1;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.3;
import com.tencent.mobileqq.bubble.BubbleNewAIOAnim.7;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.VersionUtils;
import com.tencent.widget.ListView;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

@TargetApi(11)
public class adxx
  extends AIOAnimationConatiner.a
{
  public View Bn;
  public View Bo;
  public View Bp;
  private adxx.a a;
  private int aYL = -1;
  public QQAppInterface app;
  public adxm b;
  public BubbleManager b;
  public int bLf;
  public boolean bRI = true;
  private boolean beH = true;
  private int bwY;
  public String bwd = "";
  public String bwf = "";
  public BaseBubbleBuilder.e c;
  public int cKS;
  public int cKX;
  public int cKY;
  public int cKZ;
  public int cLa;
  public ConcurrentHashMap<String, Bitmap> eQ = new ConcurrentHashMap();
  public adxk h;
  public View jq;
  private int mDefaultHeight;
  private int mMinHeight;
  private int mMinWidth;
  public long mMsgId = -1L;
  public int mPosition;
  private final Resources mResources;
  private int mScreenWidth;
  private final Handler sHandler = new Handler(Looper.getMainLooper());
  public ArrayList<adyc> vb = new ArrayList();
  public View wb;
  public AnimatorSet z;
  
  public adxx(int paramInt, AIOAnimationConatiner paramAIOAnimationConatiner, ListView paramListView)
  {
    super(paramInt, paramAIOAnimationConatiner, paramListView);
    this.mResources = paramListView.getResources();
    this.cKS = wja.dp2px(12.0F, paramListView.getContext().getResources());
    this.mMinWidth = wja.dp2px(50.0F, paramListView.getContext().getResources());
    this.mMinHeight = wja.dp2px(45.0F, paramListView.getContext().getResources());
  }
  
  private int a(Animator paramAnimator, String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      int i = 0;
      if (i < this.vb.size()) {
        if (!((adyc)this.vb.get(i)).key.equals(paramString)) {}
      }
      for (;;)
      {
        if (i != -1)
        {
          paramString = (adyc)this.vb.get(i);
          if (!(paramString instanceof adyc.b)) {
            break label113;
          }
        }
        label113:
        for (paramString = f((adyc.b)paramString);; paramString = null)
        {
          if ((paramAnimator != null) && (paramString != null))
          {
            paramString.setDuration(paramAnimator.getDuration());
            paramAnimator.addListener(new adxz(this, paramString));
          }
          return i;
          i += 1;
          break;
        }
        i = -1;
      }
    }
    return -1;
  }
  
  private ObjectAnimator a(adyc.b paramb)
  {
    if (paramb == null) {
      return null;
    }
    File localFile = new File(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.bLf, false), this.h.zipName);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramb.cLb)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramb.bwg + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      adxx.a locala = new adxx.a();
      locala.filePath = str;
      locala.cacheKey = (paramb.key + str);
      boolean bool;
      if (this.bRI) {
        bool = paramb.bRL;
      }
      for (;;)
      {
        locala.at = Boolean.valueOf(bool);
        localArrayList.add(locala);
        i += 1;
        break;
        if (!paramb.bRL) {
          bool = true;
        } else {
          bool = false;
        }
      }
    }
    return a(localArrayList);
  }
  
  private ObjectAnimator a(adyc.c paramc)
  {
    File localFile = new File(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.bLf, false), this.h.zipName);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramc.cLb)
    {
      String str = localFile.getAbsolutePath() + File.separatorChar + paramc.bwg + String.format("%04d.png", new Object[] { Integer.valueOf(i + 1) });
      adxx.a locala = new adxx.a();
      locala.filePath = str;
      locala.cacheKey = (paramc.key + str);
      if (this.bRI) {}
      for (boolean bool = false;; bool = true)
      {
        locala.at = Boolean.valueOf(bool);
        localArrayList.add(locala);
        i += 1;
        break;
      }
    }
    return b(localArrayList);
  }
  
  private ObjectAnimator a(List<adxx.a> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.a);
    int i = 0;
    if (i < paramList.size())
    {
      if (i != paramList.size() - 1) {
        localObject[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject[(i + 1)] = Keyframe.ofObject(1.0F, paramList.get(i));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("bitmapData", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new adxx.b());
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private Interpolator a(adyc.b paramb)
  {
    switch (paramb.cLd)
    {
    case 0: 
    default: 
      return null;
    case 1: 
      return new AccelerateInterpolator();
    }
    return new DecelerateInterpolator();
  }
  
  private ObjectAnimator b(adyc.b paramb)
  {
    int j = q(paramb.startX);
    int k = r(paramb.startY);
    int m = q(paramb.aH);
    int n = r(paramb.aI);
    if (this.bRI) {}
    for (int i = 1;; i = -1)
    {
      Object localObject = new ArrayList();
      adyi localadyi = adyi.b(j, k);
      localadyi.rotate = (paramb.cLg * i);
      localadyi.alpha = (paramb.cLe / 100.0F);
      ((ArrayList)localObject).add(localadyi);
      localadyi = adyi.a(m, n);
      localadyi.rotate = (i * paramb.cLh);
      localadyi.alpha = (paramb.cLf / 100.0F);
      ((ArrayList)localObject).add(localadyi);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new adyi.a(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramb));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.mMinWidth * (float)paramb.duration));
      return localObject;
    }
  }
  
  private ObjectAnimator b(adyc.c paramc)
  {
    ObjectAnimator localObjectAnimator = a(paramc);
    if (localObjectAnimator != null) {
      localObjectAnimator.addListener(new adyb(this, paramc));
    }
    return localObjectAnimator;
  }
  
  private ObjectAnimator b(List<adxx.a> paramList)
  {
    if (paramList.size() <= 0) {
      return null;
    }
    Object localObject = new Keyframe[paramList.size() + 1];
    float f = 1.0F / paramList.size();
    localObject[0] = Keyframe.ofObject(0.0F, this.a);
    int i = 0;
    if (i < paramList.size())
    {
      if (i != paramList.size() - 1) {
        localObject[(i + 1)] = Keyframe.ofObject((i + 1) * f, paramList.get(i));
      }
      for (;;)
      {
        i += 1;
        break;
        localObject[(i + 1)] = Keyframe.ofObject(1.0F, paramList.get(i));
      }
    }
    localObject = PropertyValuesHolder.ofKeyframe("pendantBitmap", (Keyframe[])localObject);
    ((PropertyValuesHolder)localObject).setEvaluator(new adxx.b());
    return ObjectAnimator.ofPropertyValuesHolder(this, new PropertyValuesHolder[] { localObject }).setDuration(paramList.size() * 125);
  }
  
  private ObjectAnimator c(adyc.b paramb)
  {
    int j = q(paramb.startX);
    int k = r(paramb.startY);
    int m = q(paramb.aH);
    int n = r(paramb.aI);
    int i1 = q(paramb.vv);
    int i2 = r(paramb.vw);
    int i3 = q(paramb.vx);
    int i4 = r(paramb.vy);
    if (this.bRI) {}
    for (int i = 1;; i = -1)
    {
      Object localObject = new ArrayList();
      adyi localadyi = adyi.b(j, k);
      localadyi.alpha = paramb.cLe;
      localadyi.rotate = (paramb.cLg * i);
      ((ArrayList)localObject).add(localadyi);
      localadyi = adyi.a(i1, i2, i3, i4, m, n);
      log("play circle points: " + adyi.a(i1, i2, i3, i4, m, n).toString());
      localadyi.rotate = (paramb.cLh * i);
      localadyi.alpha = (paramb.cLf / 100.0F);
      ((ArrayList)localObject).add(localadyi);
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new adyi.a(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramb));
      ((ObjectAnimator)localObject).setDuration(((Math.abs(j - m) + Math.abs(k - n)) * 1.0F / this.mMinWidth * (float)paramb.duration * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private void cUX()
  {
    ViewGroup localViewGroup;
    int i;
    if ((this.Bn != null) && ((this.Bn instanceof ViewGroup)))
    {
      localViewGroup = (ViewGroup)this.Bn;
      i = 0;
    }
    for (;;)
    {
      if (i < localViewGroup.getChildCount())
      {
        View localView = localViewGroup.getChildAt(i);
        if ((localView.getId() == 2131364523) && (localView.getVisibility() == 0))
        {
          this.Bp = localView;
          this.jq = new View(this.l.getContext());
          this.jq.layout(0, 0, wja.dp2px(50.0F, this.mResources), wja.dp2px(59.0F, this.mResources));
          this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView(this.jq);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  private void cUY()
  {
    this.cKX = (this.wb.getLeft() + BaseChatItemLayout.bNX);
    this.cKY = (this.wb.getRight() - BaseChatItemLayout.bNX);
    this.cKZ = (this.wb.getTop() + BaseChatItemLayout.bNV);
    this.cLa = (this.wb.getBottom() - BaseChatItemLayout.bNW);
    this.cKZ += this.h.cKF / 2;
    this.cLa -= this.h.cKG / 2;
    this.cKX += this.h.cKD / 2;
    this.cKY -= this.h.cKE / 2;
    if (this.cLa <= this.cKZ)
    {
      this.cKZ = (this.wb.getTop() + BaseChatItemLayout.bNV);
      this.cLa = (this.wb.getBottom() - BaseChatItemLayout.bNW);
    }
    if (this.cKY <= this.cKX)
    {
      this.cKX = (this.wb.getLeft() + BaseChatItemLayout.bNX);
      this.cKY = (this.wb.getRight() - BaseChatItemLayout.bNX);
    }
    if (this.bLf == 160)
    {
      this.cKX = (this.wb.getLeft() + BaseChatItemLayout.bNX - this.bwY / 3);
      this.cKY = (this.wb.getRight() - BaseChatItemLayout.bNX + this.bwY / 3);
      this.cKZ = (this.wb.getTop() + BaseChatItemLayout.bNV - this.mDefaultHeight / 3);
      this.cLa = (this.wb.getBottom() - BaseChatItemLayout.bNW + this.mDefaultHeight / 3);
    }
  }
  
  private void cUZ()
  {
    boolean bool = false;
    int i = 0;
    if (i < this.vb.size())
    {
      localObject1 = (adyc)this.vb.get(i);
      if (!(localObject1 instanceof adyc.b)) {}
    }
    for (Object localObject1 = (adyc.b)localObject1;; localObject1 = null)
    {
      if (localObject1 == null)
      {
        return;
        i += 1;
        break;
      }
      Object localObject2 = new File(this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.bLf, false), this.h.zipName);
      localObject2 = ((File)localObject2).getAbsolutePath() + File.separatorChar + ((adyc.b)localObject1).bwg + String.format("%04d.png", new Object[] { Integer.valueOf(1) });
      Object localObject3 = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject3).inJustDecodeBounds = true;
      BubbleManager.decodeFile((String)localObject2, (BitmapFactory.Options)localObject3);
      this.bwY = aqft.scaleFromDensity(((BitmapFactory.Options)localObject3).outWidth, 320, this.mResources.getDisplayMetrics().densityDpi);
      this.mDefaultHeight = aqft.scaleFromDensity(((BitmapFactory.Options)localObject3).outHeight, 320, this.mResources.getDisplayMetrics().densityDpi);
      if (this.bwY > BaseChatItemLayout.bNX * 2)
      {
        i = BaseChatItemLayout.bNX * 2;
        this.mDefaultHeight = ((int)(this.mDefaultHeight * i * 1.0F / this.bwY));
        this.bwY = i;
      }
      localObject3 = new View(this.l.getContext());
      ((View)localObject3).layout(0, 0, this.bwY, this.mDefaultHeight);
      ((View)localObject3).setVisibility(4);
      this.a = new adxx.a();
      this.a.filePath = ((String)localObject2);
      this.a.cacheKey = (((adyc.b)localObject1).key + (String)localObject2);
      localObject2 = this.a;
      if (this.bRI) {
        bool = ((adyc.b)localObject1).bRL;
      }
      for (;;)
      {
        ((adxx.a)localObject2).at = Boolean.valueOf(bool);
        this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.addView((View)localObject3);
        this.Bo = ((View)localObject3);
        return;
        if (!((adyc.b)localObject1).bRL) {
          bool = true;
        }
      }
    }
  }
  
  private void cVa()
  {
    this.z = new AnimatorSet();
    ArrayList localArrayList = new ArrayList();
    int i;
    if (this.l.getFirstVisiblePosition() == 0)
    {
      i = 0;
      if (i >= this.vb.size()) {
        break label328;
      }
      localObject = (adyc)this.vb.get(i);
      if (!(localObject instanceof adyc.b)) {
        break label134;
      }
    }
    label134:
    label273:
    label319:
    label328:
    for (Object localObject = (adyc.b)localObject;; localObject = null)
    {
      localObject = a((adyc.b)localObject);
      if (localObject != null)
      {
        ((ObjectAnimator)localObject).setDuration(200L);
        localArrayList.add(localObject);
      }
      int j = 0;
      i = -1;
      int k;
      for (;;)
      {
        if (j < this.vb.size())
        {
          if (j == i)
          {
            k = i;
            j += 1;
            i = k;
            continue;
            i += 1;
            break;
          }
          localObject = (adyc)this.vb.get(j);
          if ((localObject instanceof adyc.b)) {
            localObject = f((adyc.b)localObject);
          }
        }
      }
      for (;;)
      {
        k = i;
        if (localObject == null) {
          break;
        }
        localArrayList.add(localObject);
        k = i;
        break;
        if ((localObject instanceof adyc.c))
        {
          adyc.c localc = (adyc.c)localObject;
          localObject = b(localc);
          if (localObject != null) {
            if (localc.repeatCount - 1 < 0) {
              break label273;
            }
          }
          for (k = localc.repeatCount - 1;; k = 0)
          {
            ((ObjectAnimator)localObject).setRepeatCount(k);
            if (TextUtils.isEmpty(localc.bwj)) {
              break label319;
            }
            i = a((Animator)localObject, localc.bwj);
            break;
          }
          this.z.playSequentially(localArrayList);
          this.z.addListener(new adxy(this));
          this.sHandler.post(new BubbleNewAIOAnim.3(this));
          return;
        }
        else
        {
          localObject = null;
        }
      }
    }
  }
  
  private void cVb()
  {
    ThreadManager.post(new BubbleNewAIOAnim.7(this), 5, null, true);
  }
  
  private ObjectAnimator d(adyc.b paramb)
  {
    int k = q(paramb.startX);
    int m = r(paramb.startY);
    int j = q(paramb.aH);
    if (m != r(paramb.aI)) {
      return null;
    }
    int i;
    int n;
    int i1;
    if (j > k)
    {
      i = 1;
      n = this.mMinWidth;
      n = paramb.cLi * n;
      i1 = Math.abs(k - j);
      j = (int)(Math.abs(k - j) * 1.0F / n + 0.5F);
      if (j != 0) {
        break label558;
      }
      j = 1;
    }
    label558:
    for (;;)
    {
      log("playPeriodicalCircleAnim, periodLen: " + n + ", period: " + j + ", resize periodLen: " + i1 / j);
      n = i1 / j;
      i1 = (int)(k + n * paramb.vv * i);
      int i2 = (int)(m + n * paramb.vw);
      int i3 = (int)(k + n * paramb.vx * i);
      int i4 = (int)(m + n * paramb.vy);
      int i5 = k + n * i;
      Object localObject = new ArrayList();
      ((ArrayList)localObject).add(adyi.b(k, m));
      ((ArrayList)localObject).add(adyi.a(i1, i2, i3, i4, i5, m));
      log("next points: " + adyi.a(i1, i2, i3, i4, i5, m).toString());
      k = 1;
      for (;;)
      {
        if (k < j)
        {
          int i6 = i * k * n + i1;
          int i7 = i * k * n + i3;
          int i8 = i * k * n + i5;
          ((ArrayList)localObject).add(adyi.a(i6, i2, i7, i4, i8, m));
          log("next points: " + adyi.a(i6, i2, i7, i4, i8, m).toString());
          k += 1;
          continue;
          i = -1;
          break;
        }
      }
      localObject = ObjectAnimator.ofObject(this, "pathLocation", new adyi.a(), ((ArrayList)localObject).toArray());
      ((ObjectAnimator)localObject).setInterpolator(a(paramb));
      log("duration: " + paramb.duration * j * 3.141592653589793D * 0.4000000059604645D);
      ((ObjectAnimator)localObject).setDuration((paramb.duration * j * 3.141592653589793D * 0.4000000059604645D));
      return localObject;
    }
  }
  
  private ObjectAnimator e(adyc.b paramb)
  {
    int i = q(paramb.startX);
    int j = r(paramb.startY);
    int k = q(paramb.aH);
    int m = r(paramb.aI);
    if ((i == k) || (j == m)) {
      if (j == m) {
        i = 1;
      }
    }
    while (i != 0)
    {
      return d(paramb);
      i = 0;
      continue;
      return null;
    }
    return null;
  }
  
  private ObjectAnimator f(adyc.b paramb)
  {
    ObjectAnimator localObjectAnimator1;
    if ((paramb.vv == 0.0F) && (paramb.vw == 0.0F) && (paramb.vx == 0.0F) && (paramb.vy == 0.0F)) {
      localObjectAnimator1 = b(paramb);
    }
    ObjectAnimator localObjectAnimator2;
    for (;;)
    {
      localObjectAnimator2 = a(paramb);
      if ((localObjectAnimator1 != null) && (localObjectAnimator2 != null)) {
        break;
      }
      return null;
      if (paramb.bRN) {
        localObjectAnimator1 = e(paramb);
      } else {
        localObjectAnimator1 = c(paramb);
      }
    }
    int i;
    if ((paramb.startX == paramb.aH) && (paramb.startY == paramb.aI))
    {
      localObjectAnimator1.setDuration(localObjectAnimator2.getDuration());
      if (paramb.repeatCount - 1 >= 0)
      {
        i = paramb.repeatCount - 1;
        localObjectAnimator1.setRepeatCount(i);
      }
    }
    for (;;)
    {
      localObjectAnimator1.addListener(new adya(this, localObjectAnimator2));
      return localObjectAnimator1;
      i = 0;
      break;
      localObjectAnimator2.setRepeatCount(-1);
    }
  }
  
  private int q(float paramFloat)
  {
    int i = Math.abs(this.cKY - this.cKX);
    if (paramFloat == 0.1F)
    {
      if (this.bRI) {}
      for (i = this.cKY - this.cKS;; i = this.cKX + this.cKS) {
        return i - this.bwY / 2;
      }
    }
    if (paramFloat == 0.9F)
    {
      if (this.bRI) {}
      for (paramFloat = this.cKX + this.cKS;; paramFloat = this.cKY - this.cKS)
      {
        i = (int)paramFloat;
        break;
      }
    }
    paramFloat = i * paramFloat;
    if (this.bRI) {}
    for (paramFloat = this.cKY - paramFloat;; paramFloat += this.cKX)
    {
      i = (int)paramFloat;
      break;
    }
  }
  
  private int r(float paramFloat)
  {
    int i = Math.abs(this.cKZ - this.cLa);
    if (paramFloat == 0.1F) {
      i = this.cKZ + this.cKS;
    }
    for (;;)
    {
      return i - this.mDefaultHeight / 2;
      if (paramFloat == 0.9F)
      {
        i = this.cLa - this.cKS;
      }
      else
      {
        float f = this.cKZ;
        i = (int)(i * paramFloat + f);
      }
    }
  }
  
  public void Cp(int paramInt)
  {
    if (this.Bo != null) {
      this.Bo.setTranslationY(this.Bo.getTranslationY() + paramInt);
    }
    if ((this.jq != null) && (this.Bp != null))
    {
      paramInt = (int)(this.jq.getTranslationY() + paramInt);
      this.jq.setTranslationY(paramInt);
    }
  }
  
  public void GN(boolean paramBoolean)
  {
    if (this.beH == paramBoolean) {}
    Object localObject;
    label90:
    for (;;)
    {
      return;
      this.beH = paramBoolean;
      if (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e != null)
      {
        if (this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.b != null) {}
        for (localObject = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.b.a;; localObject = null)
        {
          if ((localObject == null) || (!this.h.bRD)) {
            break label90;
          }
          localObject = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E.getBackground();
          if (!(localObject instanceof adyk)) {
            break;
          }
          if (!paramBoolean) {
            break label92;
          }
          ((adyk)localObject).GT(true);
          return;
        }
      }
    }
    label92:
    ((adyk)localObject).GT(false);
  }
  
  public boolean a(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this.mPosition = wja.a(this.mMsgId, this.l.getAdapter());
    Object localObject1 = wja.a(wja.a(this.l, this.mPosition));
    Object localObject2;
    if ((localObject1 != null) && ((localObject1 instanceof BaseBubbleBuilder.e)))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e = ((BaseBubbleBuilder.e)localObject1);
      this.wb = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E;
      this.Bn = ((View)this.wb.getParent());
      if ((this.Bn != null) && ((this.Bn instanceof ViewGroup)))
      {
        localObject2 = (ViewGroup)this.Bn;
        paramInt1 = 0;
        if (paramInt1 < ((ViewGroup)localObject2).getChildCount())
        {
          View localView = ((ViewGroup)localObject2).getChildAt(paramInt1);
          if (localView.getId() != 2131364523) {
            break label193;
          }
          this.Bp = localView;
        }
      }
      label143:
      localObject2 = new StringBuilder().append("relayout children,  p : ").append(this.mPosition).append(", get object: ");
      if (localObject1 == null) {
        break label207;
      }
    }
    label193:
    label207:
    for (paramBoolean = true;; paramBoolean = false)
    {
      log(paramBoolean);
      return false;
      paramInt1 += 1;
      break;
      stop();
      break label143;
    }
  }
  
  public boolean c(Object... paramVarArgs)
  {
    if ((this.z != null) && (this.z.isRunning())) {
      return false;
    }
    if (!VersionUtils.isHoneycomb()) {
      return false;
    }
    this.aYL = ((Integer)paramVarArgs[0]).intValue();
    this.mMsgId = ((Long)paramVarArgs[1]).longValue();
    this.bLf = ((Integer)paramVarArgs[2]).intValue();
    this.app = ((QQAppInterface)paramVarArgs[3]);
    log("start msg id " + this.mMsgId);
    if (this.app == null) {
      return false;
    }
    this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager = ((BubbleManager)this.app.getManager(44));
    if ((this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager == null) || (this.mMsgId == 0L)) {
      return false;
    }
    this.jdField_b_of_type_Adxm = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.bLf, false);
    if (this.jdField_b_of_type_Adxm == null) {
      return false;
    }
    this.h = this.jdField_b_of_type_ComTencentMobileqqBubbleBubbleManager.a(this.bLf, this.aYL);
    if (this.h == null) {
      return false;
    }
    this.vb = this.h.uX;
    if ((this.vb == null) || (this.vb.size() == 0)) {
      return false;
    }
    this.mPosition = wja.a(this.mMsgId, this.l.getAdapter());
    paramVarArgs = wja.a(wja.a(this.l, this.mPosition));
    if ((paramVarArgs != null) && ((paramVarArgs instanceof BaseBubbleBuilder.e)))
    {
      this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e = ((BaseBubbleBuilder.e)paramVarArgs);
      this.bRI = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.mMessage.isSend();
      this.wb = this.jdField_c_of_type_ComTencentMobileqqActivityAioBaseBubbleBuilder$e.E;
      this.Bn = ((View)this.wb.getParent());
      this.mScreenWidth = this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
      cVb();
      cUZ();
      cUY();
      cUX();
      cVa();
      return true;
    }
    return false;
  }
  
  public boolean gp(int paramInt)
  {
    return true;
  }
  
  public void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleNewAIOAnim", 4, paramString);
    }
  }
  
  public void setBitmapData(adxx.a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.wb == null) || (this.Bo == null))
          {
            stop();
            return;
          }
        } while (this.bwd.equalsIgnoreCase(parama.cacheKey));
        if (parama.bitmap != null)
        {
          localObject = new adxl(parama.bitmap);
          ((adxl)localObject).bRE = parama.at.booleanValue();
          this.Bo.setBackgroundDrawable((Drawable)localObject);
          this.bwd = parama.cacheKey;
          log("set bitmap path:" + parama.cacheKey);
          this.Bo.invalidate();
          return;
        }
      } while (!this.eQ.containsKey(parama.cacheKey));
      log("get cache bitmap path:" + parama.cacheKey);
      localObject = (Bitmap)this.eQ.get(parama.cacheKey);
    } while (localObject == null);
    Object localObject = new adxl((Bitmap)localObject);
    ((adxl)localObject).bRE = parama.at.booleanValue();
    this.Bo.setBackgroundDrawable((Drawable)localObject);
    this.bwd = parama.cacheKey;
    this.Bo.invalidate();
  }
  
  public void setPathLocation(adyi paramadyi)
  {
    if ((this.wb == null) || (this.Bo == null))
    {
      stop();
      return;
    }
    this.Bn = ((View)this.wb.getParent());
    int i = this.jdField_c_of_type_ComTencentMobileqqActivityAioAnimAIOAnimationConatiner.getWidth();
    if (this.bRI) {
      f1 = paramadyi.mX;
    }
    float f2;
    for (float f1 = i - this.mScreenWidth + f1;; f1 = paramadyi.mX)
    {
      f2 = paramadyi.mY + this.Bn.getTop() - this.l.getScrollY();
      if (f2 >= this.l.getTop() - this.Bo.getHeight()) {
        break;
      }
      log("setPathLocation: now scroll over sreen, stop bubble animatorset!");
      log("now listview firstVisible postion: " + this.l.getFirstVisiblePosition() + ", last postion: " + this.l.getLastVisiblePosition() + ", now msg pos: " + this.mPosition);
      stop();
      return;
    }
    this.Bo.setTranslationX(f1);
    this.Bo.setTranslationY(f2);
    this.Bo.setAlpha(paramadyi.alpha);
    this.Bo.setRotation(paramadyi.rotate);
  }
  
  public void setPendantBitmap(adxx.a parama)
  {
    if (parama == null) {}
    do
    {
      do
      {
        do
        {
          return;
          if ((this.jq == null) || (this.Bp == null))
          {
            stop();
            return;
          }
          int i = this.Bp.getLeft();
          this.jq.setTranslationX(i);
          i = this.Bp.getTop();
          int j = this.Bn.getTop();
          int k = this.l.getScrollY();
          this.jq.setTranslationY(i + j - k);
          if ((this.mPosition > this.l.getLastVisiblePosition()) || (this.mPosition < this.l.getFirstVisiblePosition()))
          {
            log("setPendantBitmap: now scroll over sreen, stop pendant animatorset!");
            stop();
            return;
          }
        } while (this.bwf.equalsIgnoreCase(parama.cacheKey));
        if (parama.bitmap != null)
        {
          localObject = new adxl(parama.bitmap);
          this.bwf = parama.cacheKey;
          ((adxl)localObject).bRE = parama.at.booleanValue();
          this.jq.setBackgroundDrawable((Drawable)localObject);
          this.jq.invalidate();
          return;
        }
      } while (!this.eQ.containsKey(parama.cacheKey));
      localObject = (Bitmap)this.eQ.get(parama.cacheKey);
    } while (localObject == null);
    Object localObject = new adxl((Bitmap)localObject);
    this.bwf = parama.cacheKey;
    ((adxl)localObject).bRE = parama.at.booleanValue();
    this.jq.setBackgroundDrawable((Drawable)localObject);
    this.jq.invalidate();
  }
  
  public void stop()
  {
    log("now stop new bubble animation conf!");
    this.sHandler.post(new BubbleNewAIOAnim.1(this));
  }
  
  public static class a
  {
    Boolean at = Boolean.valueOf(false);
    Bitmap bitmap;
    String cacheKey = "";
    String filePath = "";
  }
  
  @TargetApi(11)
  public class b
    implements TypeEvaluator<adxx.a>
  {
    public b() {}
    
    public adxx.a a(float paramFloat, adxx.a parama1, adxx.a parama2)
    {
      return parama2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxx
 * JD-Core Version:    0.7.0.1
 */