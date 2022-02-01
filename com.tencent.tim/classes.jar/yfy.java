import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.commonsdk.cache.Sizeable;
import com.tencent.mobileqq.activity.aio.stickerbubble.StickerBubbleAnimationView.a;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class yfy
{
  private static String aXy;
  private static Animation at;
  private static int bYO;
  private static int bYP;
  private static Set<Object> bt = new HashSet();
  private static Drawable dY;
  private static int[] iH;
  private static Random sRandom = new Random();
  
  private static boolean Ty()
  {
    return bYP > 3;
  }
  
  private static Animation a(Context paramContext)
  {
    int i = wja.dp2px(8.0F, paramContext.getResources());
    paramContext = new TranslateAnimation(-i, i, 0.0F, 0.0F);
    paramContext.setDuration(100L);
    paramContext.setInterpolator(new AccelerateInterpolator());
    paramContext.setRepeatCount(-1);
    paramContext.setRepeatMode(2);
    return paramContext;
  }
  
  public static StickerBubbleAnimationView.a a(int paramInt1, String paramString, int paramInt2, int[] paramArrayOfInt)
  {
    boolean bool = b(paramInt2, paramArrayOfInt);
    paramArrayOfInt = new Point(paramInt1 / 2, 0);
    double d1;
    if (bool)
    {
      d1 = -sRandom.nextInt(2000) + 1000;
      if (!bool) {
        break label114;
      }
    }
    label114:
    for (double d2 = sRandom.nextInt(500);; d2 = sRandom.nextInt(2000))
    {
      return new StickerBubbleAnimationView.a(paramArrayOfInt, paramString, bool, new yfu.b(d1, d2), new yfu.a(0.0D, 200.0D), 49);
      d1 = -sRandom.nextInt(8000) + 4000;
      break;
    }
  }
  
  public static StickerBubbleAnimationView.a a(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = gH(paramInt);
    double d1;
    if (bool)
    {
      d1 = -sRandom.nextInt(1500) + 750;
      if (!bool) {
        break label102;
      }
    }
    label102:
    for (double d2 = -1000 - sRandom.nextInt(500);; d2 = -2000 - sRandom.nextInt(1000))
    {
      return new StickerBubbleAnimationView.a(paramPoint, paramString, bool, new yfu.b(d1, d2), new yfu.a(0.0D, 200.0D), 85);
      d1 = -sRandom.nextInt(6000) + 3000;
      break;
    }
  }
  
  @Nullable
  public static yfy.a a(String paramString)
  {
    return (yfy.a)aqgs.a("StickerBubbleGifCache_" + paramString);
  }
  
  public static void a(Object paramObject, View paramView)
  {
    bt.remove(paramObject);
    if ((bt.isEmpty()) && (at != null) && (at.hasStarted()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleHelper", 2, "cancelShakeWindowAnim");
      }
      at.cancel();
      at.reset();
      paramView.clearAnimation();
    }
  }
  
  public static void a(String paramString, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
  {
    if (Ty())
    {
      if (QLog.isColorLevel()) {
        QLog.d("StickerBubbleHelper", 2, "putFramesToCache: " + paramString + " / " + paramArrayOfBitmapDrawable);
      }
      String str = "StickerBubbleGifCache_" + paramString;
      if (aqgs.a(str) == null) {
        aqgs.a(str, new yfy.a(paramString, paramArrayOfBitmapDrawable, paramInt));
      }
    }
  }
  
  public static void a(@NonNull yfw paramyfw, @NonNull String paramString)
  {
    try
    {
      bYO = paramyfw.pokeemoId;
      dY = yfx.p(bYO);
      aqmj.dU(paramyfw.pokeemoId, paramString);
      aXy = paramString;
      return;
    }
    finally
    {
      paramyfw = finally;
      throw paramyfw;
    }
  }
  
  public static int[] a(QQAppInterface paramQQAppInterface)
  {
    if (iH == null)
    {
      paramQQAppInterface = xks.f(paramQQAppInterface, 7);
      if (paramQQAppInterface != null) {
        paramQQAppInterface = paramQQAppInterface.split(",");
      }
    }
    try
    {
      int[] arrayOfInt = new int[paramQQAppInterface.length];
      int i = 0;
      while (i < arrayOfInt.length)
      {
        arrayOfInt[i] = Integer.parseInt(paramQQAppInterface[i]);
        i += 1;
      }
      iH = arrayOfInt;
    }
    catch (NumberFormatException paramQQAppInterface)
    {
      for (;;)
      {
        QLog.e("StickerBubbleHelper", 1, "PE_SWITCH_TYPE_SURPRISE_INDEXS is illegal to parse, " + paramQQAppInterface);
      }
    }
    if (iH == null) {
      return new int[] { 10, 20, 30 };
    }
    return iH;
  }
  
  public static StickerBubbleAnimationView.a b(@NonNull Point paramPoint, @NonNull String paramString, int paramInt)
  {
    boolean bool = gH(paramInt);
    double d1;
    if (bool)
    {
      d1 = -sRandom.nextInt(1500) + 750;
      if (!bool) {
        break label102;
      }
    }
    label102:
    for (double d2 = -1000 - sRandom.nextInt(500);; d2 = -2000 - sRandom.nextInt(1000))
    {
      return new StickerBubbleAnimationView.a(paramPoint, paramString, bool, new yfu.b(d1, d2), new yfu.a(0.0D, 200.0D), 81);
      d1 = -sRandom.nextInt(6000) + 3000;
      break;
    }
  }
  
  public static void b(Object paramObject, View paramView)
  {
    bt.add(paramObject);
    if (at == null)
    {
      at = a(paramView.getContext());
      at.setAnimationListener(new yfz());
    }
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "start to shake");
    }
    if (paramView != null) {
      paramView.startAnimation(at);
    }
  }
  
  private static boolean b(int paramInt, int[] paramArrayOfInt)
  {
    boolean bool2 = false;
    int j = paramArrayOfInt.length;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < j)
      {
        if (paramArrayOfInt[i] == paramInt) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public static int bO(@NonNull String paramString)
  {
    try
    {
      if (!paramString.equals(aXy))
      {
        bYO = aqmj.fm(paramString);
        dY = null;
        aXy = paramString;
      }
      int i = bYO;
      return i;
    }
    finally {}
  }
  
  public static void chX()
  {
    bYP += 1;
  }
  
  public static void fC(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("StickerBubbleHelper", 2, "stopAndClean");
    }
    ygb.a().chZ();
  }
  
  private static boolean gH(int paramInt)
  {
    int[] arrayOfInt = a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime());
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      if (arrayOfInt[i] == paramInt) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static class a
    implements Sizeable
  {
    private String aXz;
    private BitmapDrawable[] c;
    private int mFrameDelay;
    private int mSize;
    
    public a(String paramString, BitmapDrawable[] paramArrayOfBitmapDrawable, int paramInt)
    {
      this.aXz = paramString;
      this.c = paramArrayOfBitmapDrawable;
      this.mFrameDelay = paramInt;
      chY();
    }
    
    private void chY()
    {
      int i = 0;
      this.mSize = 0;
      BitmapDrawable[] arrayOfBitmapDrawable = this.c;
      int j = arrayOfBitmapDrawable.length;
      while (i < j)
      {
        BitmapDrawable localBitmapDrawable = arrayOfBitmapDrawable[i];
        if ((localBitmapDrawable != null) && (localBitmapDrawable.getBitmap() != null))
        {
          int k = this.mSize;
          this.mSize = (localBitmapDrawable.getBitmap().getByteCount() + k);
        }
        i += 1;
      }
    }
    
    public BitmapDrawable[] a()
    {
      return this.c;
    }
    
    public int getByteSize()
    {
      return this.mSize;
    }
    
    public int getFrameDelay()
    {
      return this.mFrameDelay;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes16.jar
 * Qualified Name:     yfy
 * JD-Core Version:    0.7.0.1
 */