import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.NinePatchDrawable;
import android.os.Handler;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.qflutter.resource_loader.NativeAppInterface;
import com.qflutter.resource_loader.NativeColorInfo;
import com.qflutter.resource_loader.NativeImageInfo;
import com.qflutter.resource_loader.NinePatchInfo;
import com.qflutter.resource_loader.Utils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.flutter.engine.QFlutterResourceLoaderNativeImp.1;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.theme.SkinnableBitmapDrawable;
import com.tencent.theme.SkinnableNinePatchDrawable;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class ahfq
  implements NativeAppInterface
{
  private static String bKm = "";
  public static HashMap<String, Integer> kZ = new HashMap();
  public static HashMap<String, String> la;
  public static HashMap<String, Integer> lb;
  private Context context;
  private Handler mSubHandler;
  private Handler mUiHandler;
  private ArrayList<ColorStateList> wP = new ArrayList();
  
  static
  {
    kZ.put("skinConversationPageBg", Integer.valueOf(2130851025));
    kZ.put("skinSmallBtnBlueNormal", Integer.valueOf(2130851056));
    kZ.put("skinSmallBtnBluePressed", Integer.valueOf(2130851055));
    kZ.put("skinAIOBubbleNormal", Integer.valueOf(2130850823));
    kZ.put("skinPageTitleBarBg", Integer.valueOf(2130851105));
    kZ.put("skinPageTitleBarBackNormal", Integer.valueOf(2130851119));
    kZ.put("skinPageTitleBarBackPressed", Integer.valueOf(2130851123));
    kZ.put("skinPageBg", Integer.valueOf(2130851023));
    kZ.put("skinFromItemRightArrow", Integer.valueOf(2130851155));
    kZ.put("skinListItemBgNormal", Integer.valueOf(2130851351));
    kZ.put("skinListItemBgPressed", Integer.valueOf(2130851348));
    kZ.put("skinListItemTopBgNormal", Integer.valueOf(2130851371));
    kZ.put("skinListItemTopBgPressed", Integer.valueOf(2130851369));
    kZ.put("skinListItemMiddleBgNormal", Integer.valueOf(2130851365));
    kZ.put("skinListItemMiddleBgPressed", Integer.valueOf(2130851363));
    kZ.put("skinListItemBottomBgNormal", Integer.valueOf(2130851356));
    kZ.put("skinListItemBottomBgPressed", Integer.valueOf(2130851354));
    kZ.put("skinQuiSwitchBgOff", Integer.valueOf(2130851383));
    kZ.put("skinQuiSwitchBgOn", Integer.valueOf(2130851384));
    kZ.put("skinQuiSwitchThumbOff", Integer.valueOf(2130851381));
    kZ.put("skinQuiSwitchThumbOn", Integer.valueOf(2130851379));
    kZ.put("skinQuiSwitchThumbOnPressed", Integer.valueOf(2130851380));
    kZ.put("skinQuiSwitchThumbOffPressed", Integer.valueOf(2130851382));
    kZ.put("skinTipsNew", Integer.valueOf(2130851403));
    kZ.put("qzoneAlbumCategoryLockIcon", Integer.valueOf(2130849435));
    la = new HashMap();
    lb = new HashMap();
    lb.put("skinConversationNickBlack", Integer.valueOf(2131167311));
    lb.put("skinConversationMsgGray", Integer.valueOf(2131167383));
    lb.put("skinBtnBlueTextColor", Integer.valueOf(2131167335));
    lb.put("skinBtnWhiteTextColor", Integer.valueOf(2131167344));
    lb.put("skinPageTitleBarBtnTextColor", Integer.valueOf(2131167298));
    lb.put("skinPageTitleBarTextColor", Integer.valueOf(2131167301));
    lb.put("skinFormItemBlack", Integer.valueOf(2131167304));
    lb.put("skinFormItemGray", Integer.valueOf(2131167380));
  }
  
  public ahfq(Context paramContext)
  {
    this.context = paramContext;
    this.mSubHandler = new Handler(ThreadManagerV2.getFileThreadLooper());
    this.mUiHandler = ThreadManagerV2.getUIHandlerV2();
    dnk();
  }
  
  public static void setNativeLibDir(String paramString)
  {
    bKm = new File(paramString, "libqflutter-resource-loader.so").getAbsolutePath();
  }
  
  public void dnk()
  {
    if (QLog.isColorLevel()) {
      QLog.i("QFlutterResourceLoaderNativeImp", 0, "preCacheColors");
    }
    if (this.context != null)
    {
      Resources localResources = this.context.getResources();
      ThreadManagerV2.executeOnSubThread(new QFlutterResourceLoaderNativeImp.1(this, this.wP, localResources), true);
    }
  }
  
  public Bitmap getBitmapFromDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == null) {}
    do
    {
      return null;
      if ((paramDrawable instanceof SkinnableBitmapDrawable)) {
        return ((SkinnableBitmapDrawable)paramDrawable).getBitmap();
      }
    } while (!(paramDrawable instanceof SkinnableNinePatchDrawable));
    return ((SkinnableNinePatchDrawable)paramDrawable).getBitmap();
  }
  
  public NativeImageInfo getNativeAppImage(String paramString)
  {
    NativeImageInfo localNativeImageInfo = new NativeImageInfo();
    if (TextUtils.isEmpty(paramString)) {
      return localNativeImageInfo;
    }
    if (kZ.containsKey(paramString))
    {
      localNativeImageInfo.drawableId = ((Integer)kZ.get(paramString)).intValue();
      localNativeImageInfo.scale = this.context.getResources().getDisplayMetrics().density;
    }
    for (;;)
    {
      return localNativeImageInfo;
      if (la.containsKey(paramString)) {
        localNativeImageInfo.assetsPath = ((String)la.get(paramString));
      } else if ((paramString.startsWith("https:")) || (paramString.startsWith("http:")) || (paramString.startsWith("HTTPS:")) || (!paramString.startsWith("HTTP:"))) {}
    }
  }
  
  public List<NativeColorInfo> getNativeThemeColors()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = lb.keySet().iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      NativeColorInfo localNativeColorInfo = new NativeColorInfo(str);
      localNativeColorInfo.resId = ((Integer)lb.get(str));
      localArrayList.add(localNativeColorInfo);
    }
    return localArrayList;
  }
  
  public NinePatchInfo getNinePatchInfo(Drawable paramDrawable)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if ((paramDrawable instanceof SkinnableNinePatchDrawable))
    {
      paramDrawable = ((SkinnableNinePatchDrawable)paramDrawable).getBitmap();
      localObject1 = localObject2;
      if (paramDrawable != null) {
        localObject1 = Utils.getNinePatchInfoFromChunk(paramDrawable.getNinePatchChunk());
      }
    }
    return localObject1;
  }
  
  public Handler getSubThreadHandler()
  {
    return this.mSubHandler;
  }
  
  public String getThemeId()
  {
    return ThemeUtil.getCurrentThemeId();
  }
  
  public Handler getUiThreadHandler()
  {
    return this.mUiHandler;
  }
  
  public boolean isNinePatchDrawable(Drawable paramDrawable)
  {
    return ((paramDrawable instanceof SkinnableNinePatchDrawable)) || ((paramDrawable instanceof NinePatchDrawable));
  }
  
  public void loadJniSo()
  {
    System.load(bKm);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfq
 * JD-Core Version:    0.7.0.1
 */