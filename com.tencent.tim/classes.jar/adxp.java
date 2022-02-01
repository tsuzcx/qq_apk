import android.content.Context;
import android.content.res.Resources;
import android.graphics.NinePatch;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.StateListDrawable;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.view.View;
import android.view.View.MeasureSpec;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class adxp
{
  @Deprecated
  public adye.a a;
  public boolean bRF;
  public int bubbleId;
  public String bvW = "";
  public String bvX = "";
  public String bvY = "";
  public String bvZ = "";
  public String bwa = "";
  public String bwb;
  public int cKO;
  public int cKP;
  private int cKQ;
  private int cKR;
  public double cs;
  public adxp.a d;
  public adxp.a e;
  public String[] ew;
  public String[] ey;
  public NinePatch g;
  public NinePatch h;
  public boolean hasStroke;
  public HashMap<String, adye> jN = new HashMap(4);
  public HashMap<String, String> jP;
  public int mLinkColor;
  public int mStrokeColor;
  public int mTextColor;
  public List<Pair<adxp.a, adxp.a>> yu;
  List<View> yv = new ArrayList();
  List<View> yw = new ArrayList();
  
  public adxp(int paramInt)
  {
    this.bubbleId = paramInt;
  }
  
  public adxp(int paramInt1, int paramInt2, int paramInt3)
  {
    this.bubbleId = paramInt1;
    this.cKQ = paramInt2;
    this.cKR = paramInt3;
  }
  
  public adxp(int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, adye.a parama, int paramInt2, int paramInt3, int paramInt4, boolean paramBoolean1, boolean paramBoolean2, double paramDouble, String[] paramArrayOfString, adxp.a parama1, int paramInt5, int paramInt6, adxp.a parama2, List<Pair<adxp.a, adxp.a>> paramList, HashMap<String, String> paramHashMap)
  {
    this.bubbleId = paramInt1;
    this.bvZ = paramString3;
    this.bvW = paramString1;
    this.bvX = paramString2;
    this.bwa = paramString4;
    this.a = parama;
    this.mTextColor = paramInt2;
    this.mLinkColor = paramInt3;
    this.mStrokeColor = paramInt4;
    this.hasStroke = paramBoolean1;
    this.bRF = paramBoolean2;
    this.cs = paramDouble;
    this.cKO = paramInt5;
    this.cKP = paramInt6;
    this.ey = paramArrayOfString;
    paramString1 = paramList;
    if (paramList == null) {
      paramString1 = new ArrayList();
    }
    this.yu = paramString1;
    this.d = parama1;
    this.e = parama2;
    paramString1 = paramHashMap;
    if (paramHashMap == null) {
      paramString1 = new HashMap();
    }
    this.jP = paramString1;
  }
  
  private Drawable a(Context paramContext, int paramInt1, boolean paramBoolean1, boolean paramBoolean2, int paramInt2, int paramInt3)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("bubbleinfo_").append(paramInt1).append("_bg_").append(paramBoolean1).append("_").append(paramBoolean2);
    Object localObject = (Pair)BaseApplicationImpl.sImageCache.get(localStringBuffer.toString());
    if ((localObject != null) && (((Pair)localObject).first != null)) {
      paramContext = ((Drawable.ConstantState)((Pair)localObject).first).newDrawable(paramContext.getResources());
    }
    do
    {
      return paramContext;
      Drawable localDrawable = paramContext.getResources().getDrawable(paramInt2);
      paramContext = paramContext.getResources().getDrawable(paramInt3);
      localObject = new StateListDrawable();
      if (localDrawable != null) {
        ((StateListDrawable)localObject).addState(new int[] { 16842919, 16842910 }, localDrawable);
      }
      if (paramContext != null)
      {
        ((StateListDrawable)localObject).addState(new int[] { 16842910 }, paramContext);
        ((StateListDrawable)localObject).addState(new int[] { -16842910 }, paramContext);
      }
      paramInt1 = aqff.c(localDrawable) + aqff.c(paramContext);
      paramContext = (Context)localObject;
    } while (paramInt1 <= 0);
    BaseApplicationImpl.sImageCache.put(localStringBuffer.toString(), new Pair(((StateListDrawable)localObject).getConstantState(), Integer.valueOf(paramInt1)));
    return localObject;
  }
  
  private Pair<adxp.a, adxp.a> d(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    Pair localPair;
    if (this.yu != null)
    {
      Iterator localIterator = this.yu.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localPair = (Pair)localIterator.next();
      } while (!paramString.equals(((adxp.a)localPair.first).key));
    }
    for (paramString = localPair;; paramString = null) {
      return paramString;
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, String paramString, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BubbleInfo", 2, "getBubbleDrawable, bubbleId=" + this.bubbleId + ", isUser=" + paramBoolean1 + ", needVipBubble=" + paramBoolean2 + ", useAnimationBg=" + paramBoolean3 + ", senderUin=" + paramString);
    }
    Object localObject2 = null;
    Object localObject1 = localObject2;
    boolean bool;
    if (paramBoolean2)
    {
      if ((TextUtils.isEmpty(this.bvW)) || (TextUtils.isEmpty(this.bvX))) {
        break label656;
      }
      localObject2 = new adyk(paramQQAppInterface.getApp().getResources(), this.g, this.h, this.bubbleId);
      if (paramBoolean1) {
        break label650;
      }
      bool = true;
      ((adyk)localObject2).bQ(bool, paramBoolean3);
      if (QLog.isColorLevel()) {
        QLog.d("BubbleInfo", 2, "getBubbleDrawable, bubbleId=" + this.bubbleId + ", vipBubbleDrawable=" + localObject2);
      }
      localObject1 = localObject2;
      if (!BubbleManager.bRK)
      {
        localObject1 = localObject2;
        if (this.bubbleId != 0)
        {
          BubbleManager.bRK = true;
          localObject1 = localObject2;
        }
      }
    }
    label227:
    label241:
    Object localObject3;
    if (localObject1 == null) {
      if (paramBoolean1)
      {
        localObject2 = "bubblebg://default_mine";
        if (BaseApplicationImpl.sImageCache == null) {
          break label866;
        }
        localObject3 = (Drawable.ConstantState)BaseApplicationImpl.sImageCache.get(localObject2);
        if (localObject3 == null) {
          break label866;
        }
        if (QLog.isColorLevel()) {
          QLog.d("BubbleInfo", 2, "getBubbleDrawable, get Default from imageCache, key=" + (String)localObject2 + ", bubbleId=" + this.bubbleId);
        }
        localObject1 = ((Drawable.ConstantState)localObject3).newDrawable();
      }
    }
    label345:
    label734:
    label866:
    for (;;)
    {
      localObject2 = localObject1;
      int i;
      if (localObject1 == null)
      {
        localObject2 = paramQQAppInterface.getApp().getResources();
        if (!paramBoolean1) {
          break label726;
        }
        i = 2130851001;
        localObject1 = ((Resources)localObject2).getDrawable(i);
        if (!paramBoolean1) {
          break label734;
        }
        i = 2130851000;
        label363:
        localObject2 = ((Resources)localObject2).getDrawable(i);
        localObject3 = new StateListDrawable();
        ((StateListDrawable)localObject3).addState(new int[] { 16842919 }, (Drawable)localObject1);
        ((StateListDrawable)localObject3).addState(new int[] { 16842910 }, (Drawable)localObject2);
        localObject2 = localObject3;
        if (BaseApplicationImpl.sImageCache != null)
        {
          if (!paramBoolean1) {
            break label742;
          }
          localObject1 = "bubblebg://default_mine";
          if (QLog.isColorLevel()) {
            QLog.d("BubbleInfo", 2, "getBubbleDrawable, put default bubble to imageCache, key=" + (String)localObject1 + ", bubbleId=" + this.bubbleId);
          }
          BaseApplicationImpl.sImageCache.put(localObject1, ((StateListDrawable)localObject3).getConstantState());
          localObject2 = localObject3;
        }
      }
      int j;
      if (((localObject2 instanceof adyk)) && (!TextUtils.isEmpty(this.bwa)))
      {
        if ((this.a == null) || (paramView == null)) {
          break label838;
        }
        j = paramView.getWidth();
        if (this.a.cKH == 0) {
          ((adyk)localObject2).a(true, this.bwa, this.a.kK, this.a.bvU);
        }
      }
      else if (((localObject2 instanceof adyk)) && (paramBoolean2) && (!paramBoolean3) && (paramInt > 0))
      {
        paramString = paramString + "_" + paramInt;
        localObject1 = (adyk)localObject2;
        if (paramBoolean1) {
          break label861;
        }
      }
      for (paramBoolean1 = true;; paramBoolean1 = false)
      {
        ((adyk)localObject1).h(paramQQAppInterface, paramString, paramBoolean1);
        a(paramView, (Drawable)localObject2);
        return localObject2;
        bool = false;
        break;
        if (this.bubbleId != 100000)
        {
          localObject1 = localObject2;
          if (this.bubbleId != 100001) {
            break label227;
          }
        }
        if (paramBoolean1) {}
        for (localObject1 = null;; localObject1 = a(paramQQAppInterface.getApp(), this.bubbleId, paramBoolean1, paramBoolean3, this.cKQ, this.cKR)) {
          break;
        }
        localObject2 = "bubblebg://default_friend";
        break label241;
        i = 2130850824;
        break label345;
        i = 2130850823;
        break label363;
        label742:
        localObject1 = "bubblebg://default_friend";
        break label430;
        i = j;
        if (j == 0)
        {
          paramView.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
          i = paramView.getMeasuredWidth();
        }
        if (i > this.a.cKH)
        {
          ((adyk)localObject2).a(true, this.bwa, this.a.kK, this.a.bvU);
          break label568;
        }
        ((adyk)localObject2).a(false, null, null, null);
        break label568;
        if (!(localObject2 instanceof adyk)) {
          break label568;
        }
        ((adyk)localObject2).a(false, null, null, null);
        break label568;
      }
    }
  }
  
  public Drawable a(QQAppInterface paramQQAppInterface, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, View paramView, boolean paramBoolean4)
  {
    adye.a locala = this.a;
    if (!paramBoolean4) {
      this.a = null;
    }
    paramQQAppInterface = a(paramQQAppInterface, paramBoolean1, paramBoolean2, paramBoolean3, paramView, "", 0);
    this.a = locala;
    return paramQQAppInterface;
  }
  
  public Pair<adxp.a, adxp.a> a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    Object localObject3 = null;
    Object localObject1;
    if (paramQQAppInterface != null)
    {
      localObject1 = (BubbleManager)paramQQAppInterface.getManager(44);
      localObject2 = localObject3;
      if (localObject1 != null)
      {
        localObject2 = ((BubbleManager)localObject1).a(this.bubbleId, true);
        if (localObject2 != null) {
          break label53;
        }
        localObject2 = localObject3;
      }
    }
    label53:
    label102:
    do
    {
      do
      {
        return localObject2;
        localObject1 = null;
        break;
        switch (paramInt)
        {
        case 4: 
        case 5: 
        default: 
          paramQQAppInterface = null;
          localObject2 = localObject3;
        }
      } while (TextUtils.isEmpty(paramQQAppInterface));
      localObject2 = d(paramQQAppInterface);
      localObject1 = ((BubbleManager)localObject1).a(this.bubbleId, paramQQAppInterface, (Pair)localObject2);
      localObject2 = localObject1;
    } while (!QLog.isDevelopLevel());
    Object localObject2 = new StringBuilder().append("getAttrs|key=").append(paramQQAppInterface).append(", animAttrs=");
    if (localObject1 == null) {}
    for (paramQQAppInterface = "null";; paramQQAppInterface = "first:" + ((Pair)localObject1).first + ",second:" + ((Pair)localObject1).second)
    {
      QLog.w("BubbleInfo", 4, paramQQAppInterface);
      return localObject1;
      if (((adxm)localObject2).a == null) {
        break;
      }
      paramQQAppInterface = ((adxm)localObject2).a.bvS;
      break label102;
      if (((adxm)localObject2).b == null) {
        break;
      }
      paramQQAppInterface = ((adxm)localObject2).b.bvS;
      break label102;
      paramQQAppInterface = "width";
      if (((adxm)localObject2).c == null) {
        break label102;
      }
      paramQQAppInterface = ((adxm)localObject2).c.bvS;
      break label102;
      if ((this.jP == null) || (this.jP.size() <= 0) || (this.bwb == null)) {
        break;
      }
      paramQQAppInterface = (String)this.jP.get(this.bwb);
      break label102;
      if (((adxm)localObject2).d == null) {
        break;
      }
      paramQQAppInterface = ((adxm)localObject2).d.bvS;
      break label102;
      if (((adxm)localObject2).e == null) {
        break;
      }
      paramQQAppInterface = ((adxm)localObject2).e.bvS;
      break label102;
    }
  }
  
  public void a(View paramView, Drawable paramDrawable)
  {
    if ((paramDrawable == null) || (paramView == null)) {
      return;
    }
    Rect localRect = new Rect();
    paramDrawable.getPadding(localRect);
    int i = paramView.getPaddingTop();
    int j = localRect.top;
    int k = paramView.getPaddingLeft();
    int m = localRect.left;
    int n = paramView.getPaddingRight();
    int i1 = localRect.right;
    int i2 = paramView.getPaddingBottom();
    int i3 = localRect.bottom;
    paramView.setBackgroundDrawable(paramDrawable);
    paramView.setPadding(k + m, i + j, n + i1, i3 + i2);
  }
  
  public void cUW()
  {
    synchronized (this.yv)
    {
      this.yv.clear();
    }
    synchronized (this.yw)
    {
      this.yw.clear();
      return;
      localObject1 = finally;
      throw localObject1;
    }
  }
  
  public boolean iT(int paramInt)
  {
    return (this.cKO > 0) && (this.cKP > this.cKO) && (paramInt >= this.cKO) && (paramInt <= this.cKP);
  }
  
  public boolean isLoaded()
  {
    return (!TextUtils.isEmpty(this.bvW)) && (!TextUtils.isEmpty(this.bvX));
  }
  
  public String ka(String paramString)
  {
    if ((this.ey != null) && (!TextUtils.isEmpty(paramString)))
    {
      String[] arrayOfString = this.ey;
      int j = arrayOfString.length;
      int i = 0;
      while (i < j)
      {
        String str = arrayOfString[i];
        if (paramString.indexOf(str.toLowerCase()) != -1)
        {
          this.bwb = str;
          return str;
        }
        i += 1;
      }
    }
    return null;
  }
  
  public void m(View arg1, View paramView2)
  {
    synchronized (this.yv)
    {
      this.yv.remove(???);
    }
    synchronized (this.yw)
    {
      this.yw.remove(paramView2);
      return;
      ??? = finally;
      throw ???;
    }
  }
  
  public String toString()
  {
    return "BubbleInfo [bubbleId=" + this.bubbleId + ",aioUserBgNorResPath=" + this.bvW + ",aioUserPicNorResPath=" + this.bvX + ",bubbleThumbnailResPath=" + this.bvZ + ",bubbleChartletResPath=" + this.bwa + ", mTextColor=" + this.mTextColor + ", mKeyWords=" + Arrays.toString(this.ey) + ", currKeyWord=" + this.bwb + ", mBubbleHeightBegin=" + this.cKO + ", mBubbleHeightEnd=" + this.cKP + ", pttAttrs=" + this.d + ", heightAttrs=" + this.e + ", keywordAttrs=" + this.yu + ", keyWorsAnimMap=" + this.jP + "]";
  }
  
  public static class a
  {
    public boolean bRG = true;
    public boolean bRH = true;
    public int bkg = -1;
    public String bwc = "";
    public int cKC = 1;
    public int duration = 50;
    public String[] ez = new String[0];
    public adxk g;
    public String key;
    public Rect mRect = new Rect();
    public int repeatCount = 1;
    public int size;
    
    public String toString()
    {
      return "CommonAttrs [key=" + this.key + ", mRect=" + this.mRect + ", count=" + this.size + ", duration=" + this.duration + ", align=" + this.bkg + ", mBigImgPath=" + this.bwc + ", repeatCount=" + this.repeatCount + ", mAnimationPath=" + Arrays.toString(this.ez) + "]";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adxp
 * JD-Core Version:    0.7.0.1
 */