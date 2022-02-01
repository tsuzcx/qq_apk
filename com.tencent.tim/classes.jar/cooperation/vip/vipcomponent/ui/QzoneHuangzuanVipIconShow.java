package cooperation.vip.vipcomponent.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.text.TextUtils;
import android.util.LruCache;
import aqnm;
import awau;
import awmz;
import awna;
import awnc;
import awnd;
import awne;
import awni;
import cooperation.vip.vipcomponent.util.VipResourcesListener;

public class QzoneHuangzuanVipIconShow
{
  public static int ANUAL_ICON_MARGIN_LEFT = 0;
  public static final int HIGHEST_LEVEL = 8;
  public static int ICON_ADJUST_ANNUALVIP_MARGIN_TOP = (int)(aqnm.getDensity() * 9.0F);
  public static int ICON_ANNUALVIP_HEIGHT = 0;
  public static int ICON_ANNUALVIP_WIDTH = (int)(aqnm.getDensity() * 21.0F);
  public static int ICON_DEFAULT_SIZE = awnc.yT;
  public static final int LOWEST_LEVEL = 1;
  public static int LV9_GUAN_ICON_HEIGHT = 0;
  public static int LV9_GUAN_ICON_MARGIN_LEFT = 0;
  public static int LV9_GUAN_ICON_MARGIN_TOP = 0;
  public static int LV9_GUAN_ICON_WIDTH = 0;
  public static int LV9_WINDS_HEIGHT = 0;
  public static int LV9_WINDS_MARGIN_LEFT = 0;
  public static int LV9_WINDS_MARGIN_TOP = 0;
  public static int LV9_WINDS_WIDTH = 0;
  public static int PERSONALIZED_ICON_ANUAL_LEFT = 0;
  public static int PERSONALIZED_ICON_AVATAR_TOP = 0;
  public static int PERSONALIZED_ICON_HEAD_HEIGHT = 0;
  public static int PERSONALIZED_ICON_HEAD_WIDTH = 0;
  public static int PERSONALIZED_ICON_LV_HEIGHT = 0;
  public static int PERSONALIZED_ICON_LV_MARGIN_TOP = 0;
  public static int PERSONALIZED_ICON_LV_WIDTH = (int)(26.0F * aqnm.getDensity());
  public static int PERSONALIZED_ICON_YEAR_HEIGHT = 0;
  public static int PERSONALIZED_ICON_YEAR_WIDTH = 0;
  private static final int RES_BG = 1;
  private static final int RES_CUSTOM_DIAMOND = 10;
  private static final int RES_KINGBG = 9;
  private static final int RES_LEVEL = 2;
  private static final int RES_LV9_GUAN = 7;
  private static final int RES_LV9_WINDS = 8;
  private static final int RES_NORMAL_ANNUAL = 5;
  private static final int RES_PERSONALIZED_ANNUAL = 6;
  private static final int RES_PERSONALIZED_HEAD = 0;
  private static final int RES_PERSONALIZED_LEVEL = 4;
  private static final int RES_RIBBON_LEVEL = 3;
  public static int RIBBON_ICON_BG_MARGIN_LEFT;
  public static final int RIBBON_ICON_LEVEL_MARGIN_TOP;
  private static final awau<QzoneHuangzuanVipIconShow, Context> sSingleton = new awna();
  private Context context;
  private LruCache<String, Drawable.ConstantState> layerCache;
  private int[] mAnunalGrayVipIdListInAvatar = { 9, 10, 11, 12, 13, 14, 15, 16, 17 };
  private int[] mAnunalVipIdListInAvatar = { 27, 28, 29, 30, 31, 32, 33, 34, 35 };
  private int[] mAnunalVipIdListInRibbon = { 85, 86, 87, 88, 89, 90, 91, 92, 93 };
  private int[] mNormalGrayVipIdListInAvatar = { 18, 19, 20, 21, 22, 23, 24, 25, 26 };
  private int[] mNormalVipIdListInAvatar = { 36, 37, 38, 39, 40, 41, 42, 43, 44 };
  private int[] mNormalVipIdListInRibbon = { 94, 95, 96, 97, 98, 99, 100, 101, 102 };
  
  static
  {
    PERSONALIZED_ICON_LV_HEIGHT = (int)(aqnm.getDensity() * 9.0F);
    PERSONALIZED_ICON_HEAD_HEIGHT = (int)(23.0F * aqnm.getDensity());
    PERSONALIZED_ICON_HEAD_WIDTH = (int)(11.0F * aqnm.getDensity());
    PERSONALIZED_ICON_YEAR_WIDTH = (int)(aqnm.getDensity() * 40.0F);
    PERSONALIZED_ICON_YEAR_HEIGHT = (int)(24.0F * aqnm.getDensity());
    PERSONALIZED_ICON_LV_MARGIN_TOP = (int)(aqnm.getDensity() * 21.0F);
    RIBBON_ICON_BG_MARGIN_LEFT = (int)(aqnm.getDensity() * 1.0F);
    ANUAL_ICON_MARGIN_LEFT = (int)(2.0F * aqnm.getDensity());
    PERSONALIZED_ICON_AVATAR_TOP = (int)(aqnm.getDensity() * 1.0F);
    LV9_GUAN_ICON_MARGIN_LEFT = (int)(aqnm.getDensity() * 1.0F);
    LV9_GUAN_ICON_MARGIN_TOP = (int)(-3.0F * aqnm.getDensity());
    LV9_GUAN_ICON_WIDTH = (int)(22.0F * aqnm.getDensity());
    LV9_GUAN_ICON_HEIGHT = (int)(10.5D * aqnm.getDensity());
    LV9_WINDS_MARGIN_TOP = (int)(4.5D * aqnm.getDensity());
    LV9_WINDS_MARGIN_LEFT = (int)(-8.0F * aqnm.getDensity());
    LV9_WINDS_HEIGHT = (int)(9.5D * aqnm.getDensity());
    LV9_WINDS_WIDTH = (int)(aqnm.getDensity() * 40.0F);
    PERSONALIZED_ICON_ANUAL_LEFT = (int)(10.0F * aqnm.getDensity());
    RIBBON_ICON_LEVEL_MARGIN_TOP = (int)(6.0F * aqnm.getDensity());
    ICON_ANNUALVIP_HEIGHT = (int)(12.0F * aqnm.getDensity());
  }
  
  public QzoneHuangzuanVipIconShow(Context paramContext)
  {
    if (paramContext != null) {
      this.context = paramContext.getApplicationContext();
    }
    this.layerCache = new LruCache(5120);
  }
  
  private void addToCache(awmz paramawmz, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    paramString = new StringBuilder().append(paramInt1).append("_").append(paramInt2).append("_").append(paramInt3).append("_").append(paramBoolean1).append("_").append(paramString).append("_").append(paramInt4).append("_");
    if (paramBoolean2) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      paramString = paramInt1 + "_" + paramInt5;
      if (paramawmz != null) {
        this.layerCache.put(paramString, paramawmz.a());
      }
      return;
    }
  }
  
  private static Drawable getBackground(int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString, awni paramawni, int paramInt5)
  {
    switch (paramInt1)
    {
    default: 
      if ((paramInt4 != 6) && (paramInt4 != 7) && (paramInt4 != 8)) {
        break;
      }
    }
    do
    {
      return null;
      if ((!TextUtils.isEmpty(paramString)) && (paramInt4 == 4)) {
        return awne.a(2, paramInt3, paramawni);
      }
      if (8 == paramInt2)
      {
        if (paramInt5 != 1) {
          return awne.a(3, paramInt3, paramawni);
        }
        return awne.a(2, paramInt3, paramawni);
      }
      return awne.a(2, paramInt3, paramawni);
      if ((!TextUtils.isEmpty(paramString)) && (paramInt4 == 4)) {
        return awne.a(1, paramInt3, paramawni);
      }
      if (8 == paramInt2)
      {
        if (paramInt5 != 1) {
          return awne.a(4, paramInt3, paramawni);
        }
        return awne.a(1, paramInt3, paramawni);
      }
      return awne.a(1, paramInt3, paramawni);
      if (8 == paramInt2) {
        return awne.a(5, paramInt3, paramawni);
      }
      if (paramInt2 != 0) {
        break;
      }
      if ((paramInt4 == 4) || (paramInt4 == 6)) {
        return null;
      }
    } while (paramInt4 != 5);
    return awne.a(6, paramInt3, paramawni);
    return awne.a(6, paramInt3, paramawni);
  }
  
  private Drawable getDefaultDrawable(int paramInt, awni paramawni)
  {
    awmz localawmz = new awmz();
    paramawni = awne.a(1, 1, paramawni);
    paramawni.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt), getRealSize(ICON_DEFAULT_SIZE, paramInt));
    localawmz.am(paramawni);
    return localawmz;
  }
  
  private boolean getDefaultDrawableFromUrl(int paramInt1, boolean paramBoolean1, int paramInt2, int paramInt3, String paramString, awmz paramawmz, awni paramawni, boolean paramBoolean2, boolean paramBoolean3, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (handlePersonalized(paramInt1, paramInt2, paramInt3, paramString, paramawmz, paramawni, paramBoolean2, paramBoolean3, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4)) {
        return true;
      }
    }
    else if (paramBoolean1)
    {
      if (handleAnunalVip(paramInt3, paramawmz, paramawni, paramBoolean2, paramBoolean3, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4)) {
        return true;
      }
    }
    else if ((paramDrawable3 == null) || (paramDrawable4 == null) || ((paramBoolean3) && (paramDrawable1 == null)) || ((paramBoolean2) && (paramDrawable2 == null))) {
      return true;
    }
    return false;
  }
  
  private Drawable getFromCache(int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean1, String paramString, int paramInt4, boolean paramBoolean2, int paramInt5)
  {
    paramString = new StringBuilder().append(paramInt1).append("_").append(paramInt2).append("_").append(paramInt3).append("_").append(paramBoolean1).append("_").append(paramString).append("_").append(paramInt4).append("_");
    if (paramBoolean2) {}
    for (paramInt1 = 1;; paramInt1 = 2)
    {
      paramString = paramInt1 + "_" + paramInt5;
      paramString = (Drawable.ConstantState)this.layerCache.get(paramString);
      if (paramString == null) {
        break;
      }
      return paramString.newDrawable();
    }
    return null;
  }
  
  public static QzoneHuangzuanVipIconShow getInstance()
  {
    return (QzoneHuangzuanVipIconShow)sSingleton.get(null);
  }
  
  private Drawable getLevelDrawable(int paramInt1, int paramInt2, boolean paramBoolean1, int paramInt3, boolean paramBoolean2, awni paramawni)
  {
    if ((paramInt3 <= 0) || (paramInt3 > 9)) {
      return null;
    }
    if (paramBoolean2)
    {
      if ((paramBoolean1) && (paramInt1 == 4)) {
        return awne.a(this.mAnunalGrayVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramawni);
      }
      return awne.a(this.mNormalGrayVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramawni);
    }
    if ((paramBoolean1) && (paramInt1 == 7)) {
      return awne.a(this.mAnunalVipIdListInRibbon[(paramInt3 - 1)], paramInt2, paramawni);
    }
    if ((!paramBoolean1) && (paramInt1 == 7)) {
      return awne.a(this.mNormalVipIdListInRibbon[(paramInt3 - 1)], paramInt2, paramawni);
    }
    if ((paramBoolean1) && (paramInt1 == 4)) {
      return awne.a(this.mAnunalVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramawni);
    }
    return awne.a(this.mNormalVipIdListInAvatar[(paramInt3 - 1)], paramInt2, paramawni);
  }
  
  private static Drawable getLv9Guan(int paramInt1, int paramInt2, int paramInt3, int paramInt4, awni paramawni)
  {
    switch (paramInt1)
    {
    default: 
      return null;
    case 1: 
    case 2: 
      return awne.a(121, paramInt4, paramawni);
    }
    return awne.a(122, paramInt4, paramawni);
  }
  
  private static int getRealSize(int paramInt1, int paramInt2)
  {
    return (int)(paramInt2 / 100.0D * paramInt1);
  }
  
  private static Drawable getWindsDrawalbe(int paramInt1, int paramInt2, int paramInt3, awni paramawni)
  {
    if (paramInt2 != 9) {
      return null;
    }
    switch (paramInt1)
    {
    default: 
      return null;
    case 0: 
      return awne.a(120, paramInt3, paramawni);
    }
    return awne.a(119, paramInt3, paramawni);
  }
  
  private boolean handleAnunalVip(int paramInt, awmz paramawmz, awni paramawni, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramawni = awne.a(7, 5, paramawni);
    if (paramawni != null)
    {
      paramawni.setBounds(getRealSize(ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT, paramInt), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, paramInt), getRealSize(ICON_ANNUALVIP_WIDTH + ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT, paramInt), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, paramInt));
      paramawmz.ao(paramawni);
    }
    if ((paramDrawable3 == null) || (paramDrawable4 == null) || (paramawni == null) || ((paramBoolean2) && (paramDrawable1 == null)) || ((paramBoolean1) && (paramDrawable2 == null)))
    {
      awnd.e("vipIconShow", "nameplateDrawable is null");
      return true;
    }
    return false;
  }
  
  private Drawable handleCustomDiamond(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString, int paramInt3, int paramInt4, int paramInt5, awmz paramawmz, awni paramawni)
  {
    Drawable localDrawable = awne.a(paramString, paramInt2, 10, paramInt1, paramBoolean1, paramInt3, paramawni);
    if (localDrawable != null)
    {
      localDrawable.setBounds(0, 0, getRealSize(localDrawable.getIntrinsicWidth(), paramInt4), getRealSize(localDrawable.getIntrinsicHeight(), paramInt4));
      paramawmz.as(localDrawable);
      addToCache(paramawmz, paramInt5, paramInt4, paramInt1, paramBoolean2, paramString, paramInt3, paramBoolean1, paramInt2);
      return paramawmz;
    }
    return getDefaultDrawable(paramInt4, paramawni);
  }
  
  private void handleDownloadSuccess(int paramInt1, Drawable paramDrawable, int paramInt2, awmz paramawmz)
  {
    if (paramDrawable == null) {
      return;
    }
    switch (paramInt1)
    {
    default: 
      return;
    case 0: 
      paramDrawable.setBounds(getRealSize(ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth(), paramInt2) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, paramInt2), getRealSize(ICON_DEFAULT_SIZE + paramDrawable.getIntrinsicWidth(), paramInt2) / 2, getRealSize(paramDrawable.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, paramInt2));
      paramawmz.ap(paramDrawable);
      return;
    case 1: 
      paramDrawable.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramawmz.am(paramDrawable);
      return;
    case 2: 
      paramDrawable.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramawmz.an(paramDrawable);
      return;
    case 3: 
      paramDrawable.setBounds(0, getRealSize(RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2), getRealSize(ICON_DEFAULT_SIZE + RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt2));
      paramawmz.an(paramDrawable);
      return;
    case 5: 
      paramDrawable.setBounds(getRealSize(ICON_DEFAULT_SIZE / 2, paramInt2), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP, paramInt2), getRealSize(ICON_ANNUALVIP_WIDTH + ICON_DEFAULT_SIZE / 2 + ANUAL_ICON_MARGIN_LEFT, paramInt2), getRealSize(ICON_ADJUST_ANNUALVIP_MARGIN_TOP + ICON_ANNUALVIP_HEIGHT, paramInt2));
      paramawmz.ao(paramDrawable);
      return;
    case 6: 
      paramDrawable.setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, paramInt2), getRealSize(ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicHeight(), paramInt2), getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT + paramDrawable.getIntrinsicWidth(), paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramawmz.ao(paramDrawable);
      awnd.d("@vipIcon", "left" + ICON_DEFAULT_SIZE / 2 + " width = " + paramDrawable.getIntrinsicWidth() + " defualt_width =" + ICON_DEFAULT_SIZE + " height = " + paramDrawable.getIntrinsicHeight());
      return;
    case 4: 
      paramDrawable.setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt2), getRealSize(PERSONALIZED_ICON_LV_WIDTH, paramInt2), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt2));
      paramawmz.an(paramDrawable);
      return;
    case 7: 
      paramDrawable.setBounds(getRealSize(LV9_GUAN_ICON_MARGIN_LEFT, paramInt2), getRealSize(LV9_GUAN_ICON_MARGIN_TOP, paramInt2), getRealSize(LV9_GUAN_ICON_WIDTH + LV9_GUAN_ICON_MARGIN_LEFT, paramInt2), getRealSize(LV9_GUAN_ICON_HEIGHT + LV9_GUAN_ICON_MARGIN_TOP, paramInt2));
      paramawmz.ap(paramDrawable);
      return;
    case 8: 
      paramDrawable.setBounds(getRealSize(LV9_WINDS_MARGIN_LEFT, paramInt2), getRealSize(LV9_WINDS_MARGIN_TOP, paramInt2), getRealSize(LV9_WINDS_WIDTH + LV9_WINDS_MARGIN_LEFT, paramInt2), getRealSize(LV9_WINDS_HEIGHT + LV9_WINDS_MARGIN_TOP, paramInt2));
      paramawmz.aq(paramDrawable);
      return;
    case 9: 
      paramDrawable.setBounds(getRealSize((ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth()) / 2, paramInt2), getRealSize(ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicHeight(), paramInt2), getRealSize((ICON_DEFAULT_SIZE + paramDrawable.getIntrinsicWidth()) / 2, paramInt2), getRealSize(ICON_DEFAULT_SIZE, paramInt2));
      paramawmz.ar(paramDrawable);
      awnd.d("@vipIcon KINGBG", "left=" + (ICON_DEFAULT_SIZE - paramDrawable.getIntrinsicWidth()) / 2 + " width = " + paramDrawable.getIntrinsicWidth() + " defualt_width =" + ICON_DEFAULT_SIZE + " height = " + paramDrawable.getIntrinsicHeight() + " bitmapwith =" + (int)(((BitmapDrawable)paramDrawable).getBitmap().getWidth() / 2 * aqnm.getDensity()) + "bitmapheight =" + (int)(((BitmapDrawable)paramDrawable).getBitmap().getHeight() / 2 * aqnm.getDensity()));
      return;
    }
    paramDrawable.setBounds(0, 0, getRealSize(paramDrawable.getIntrinsicWidth(), paramInt2), getRealSize(paramDrawable.getIntrinsicHeight(), paramInt2));
    paramawmz.as(paramDrawable);
  }
  
  private Drawable handleLocationAvatar(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, awmz paramawmz, awni paramawni, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, boolean paramBoolean5, Drawable paramDrawable4)
  {
    Object localObject = paramawmz;
    if (paramInt3 == 4)
    {
      if (paramDrawable3 != null)
      {
        paramDrawable3.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
        paramawmz.am(paramDrawable3);
      }
      if (paramDrawable4 != null)
      {
        paramDrawable4.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
        paramawmz.an(paramDrawable4);
      }
      if (paramBoolean5)
      {
        paramString2 = awne.a(paramString2, 0, paramInt1, paramInt3, paramawni);
        if (paramString2 != null)
        {
          paramString2.setBounds(getRealSize(ICON_DEFAULT_SIZE - paramString2.getIntrinsicWidth(), paramInt4) / 2, getRealSize(-PERSONALIZED_ICON_AVATAR_TOP, paramInt4), getRealSize(ICON_DEFAULT_SIZE + paramString2.getIntrinsicWidth(), paramInt4) / 2, getRealSize(paramString2.getIntrinsicHeight() - PERSONALIZED_ICON_AVATAR_TOP, paramInt4));
          paramawmz.ap(paramString2);
        }
        if ((paramDrawable3 != null) && (paramDrawable4 != null) && (paramString2 != null) && ((!paramBoolean4) || (paramDrawable1 != null)) && ((!paramBoolean3) || (paramDrawable2 != null))) {
          break label257;
        }
        localObject = getDefaultDrawable(paramInt4, paramawni);
      }
    }
    else
    {
      return localObject;
    }
    if ((paramDrawable3 == null) || (paramDrawable4 == null) || ((paramBoolean4) && (paramDrawable1 == null)) || ((paramBoolean3) && (paramDrawable2 == null))) {
      return getDefaultDrawable(paramInt4, paramawni);
    }
    label257:
    addToCache(paramawmz, paramInt5, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
    return paramawmz;
  }
  
  private Drawable handleLocationRibbon(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, awmz paramawmz, awni paramawni, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    Drawable localDrawable2 = getBackground(paramInt2, paramInt1, 1, paramInt3, paramString2, paramawni, paramInt5);
    if (localDrawable2 != null)
    {
      localDrawable2.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramawmz.am(localDrawable2);
    }
    Drawable localDrawable1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localDrawable1 = awne.a(paramString2, 4, paramInt1, paramInt3, paramawni);
      paramString2 = localDrawable1;
      if (localDrawable1 != null)
      {
        localDrawable1.setBounds(0, getRealSize(PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt4), getRealSize(PERSONALIZED_ICON_LV_WIDTH, paramInt4), getRealSize(PERSONALIZED_ICON_LV_HEIGHT + PERSONALIZED_ICON_LV_MARGIN_TOP, paramInt4));
        paramawmz.an(localDrawable1);
        paramString2 = localDrawable1;
      }
      if ((paramString2 == null) || (localDrawable2 == null) || ((paramBoolean4) && (paramDrawable1 == null)) || ((paramBoolean3) && (paramDrawable2 == null))) {
        return getDefaultDrawable(paramInt4, paramawni);
      }
    }
    else
    {
      if ((paramInt1 == 0) || (paramInt2 == 0)) {}
      for (boolean bool = true;; bool = false)
      {
        localDrawable1 = getLevelDrawable(paramInt3, 3, paramBoolean1, paramInt1, bool, paramawni);
        paramString2 = localDrawable1;
        if (localDrawable1 == null) {
          break;
        }
        localDrawable1.setBounds(0, getRealSize(RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE + RIBBON_ICON_LEVEL_MARGIN_TOP, paramInt4));
        paramawmz.an(localDrawable1);
        paramString2 = localDrawable1;
        break;
      }
    }
    addToCache(paramawmz, paramInt6, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
    return paramawmz;
  }
  
  private Drawable handleNotLocationAvatar(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, awmz paramawmz, awni paramawni, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    awnd.d("vipIcon", "come to annual vip icon show");
    if ((paramInt5 == 1) && (!TextUtils.isEmpty(paramString2)))
    {
      Drawable localDrawable = awne.a(paramString2, 9, paramInt1, paramInt3, paramawni, paramInt5);
      awnd.d("@vipIcon", "get is kingtype  url = " + paramString2);
      if (localDrawable != null)
      {
        localDrawable.setBounds(getRealSize((ICON_DEFAULT_SIZE - localDrawable.getIntrinsicWidth()) / 2, paramInt4), getRealSize(ICON_DEFAULT_SIZE - localDrawable.getIntrinsicHeight(), paramInt4), getRealSize((ICON_DEFAULT_SIZE + localDrawable.getIntrinsicWidth()) / 2, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
        paramawmz.ar(localDrawable);
      }
    }
    if (paramDrawable3 != null)
    {
      paramDrawable3.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramawmz.am(paramDrawable3);
    }
    if (paramDrawable4 != null)
    {
      paramDrawable4.setBounds(0, 0, getRealSize(ICON_DEFAULT_SIZE, paramInt4), getRealSize(ICON_DEFAULT_SIZE, paramInt4));
      paramawmz.an(paramDrawable4);
    }
    if (getDefaultDrawableFromUrl(paramInt1, paramBoolean1, paramInt3, paramInt4, paramString2, paramawmz, paramawni, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, paramDrawable3, paramDrawable4)) {
      return getDefaultDrawable(paramInt4, paramawni);
    }
    addToCache(paramawmz, paramInt6, paramInt4, paramInt1, paramBoolean2, paramString1, paramInt3, paramBoolean1, paramInt2);
    return paramawmz;
  }
  
  private Drawable handleNotRibbon(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, int paramInt5, int paramInt6, awmz paramawmz, awni paramawni, boolean paramBoolean3, boolean paramBoolean4, Drawable paramDrawable1, Drawable paramDrawable2)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(paramString2))
    {
      bool1 = bool2;
      if (paramInt3 == 4) {
        bool1 = true;
      }
    }
    Drawable localDrawable1 = getBackground(paramInt2, paramInt1, 1, paramInt3, paramString2, paramawni, paramInt5);
    if ((paramInt1 == 0) || (paramInt2 == 0)) {}
    Drawable localDrawable2;
    for (bool2 = true;; bool2 = false)
    {
      localDrawable2 = getLevelDrawable(paramInt3, 2, paramBoolean1, paramInt1, bool2, paramawni);
      if ((paramInt3 != 6) && (paramInt3 != 5) && (paramInt3 != 8)) {
        break;
      }
      return handleNotLocationAvatar(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramInt5, paramInt6, paramawmz, paramawni, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, localDrawable1, localDrawable2);
    }
    return handleLocationAvatar(paramInt1, paramInt2, paramBoolean1, paramBoolean2, paramString1, paramInt3, paramInt4, paramString2, paramInt6, paramawmz, paramawni, paramBoolean3, paramBoolean4, paramDrawable1, paramDrawable2, localDrawable1, bool1, localDrawable2);
  }
  
  private boolean handlePersonalized(int paramInt1, int paramInt2, int paramInt3, String paramString, awmz paramawmz, awni paramawni, boolean paramBoolean1, boolean paramBoolean2, Drawable paramDrawable1, Drawable paramDrawable2, Drawable paramDrawable3, Drawable paramDrawable4)
  {
    paramawni = awne.a(paramString, 6, paramInt1, paramInt2, paramawni);
    awnd.d("@vipIcon", "feeds personalized  url = " + paramString);
    if (paramawni != null)
    {
      paramawni.setBounds(getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT, paramInt3), getRealSize(ICON_DEFAULT_SIZE - paramawni.getIntrinsicHeight(), paramInt3), getRealSize(ICON_DEFAULT_SIZE - PERSONALIZED_ICON_ANUAL_LEFT + paramawni.getIntrinsicWidth(), paramInt3), getRealSize(ICON_DEFAULT_SIZE, paramInt3));
      paramawmz.ao(paramawni);
    }
    if ((paramDrawable3 == null) || (paramDrawable4 == null) || (paramawni == null) || ((paramBoolean2) && (paramDrawable1 == null)) || ((paramBoolean1) && (paramDrawable2 == null)))
    {
      awnd.e("vipIconShow", "personalized Drawable is null");
      return true;
    }
    return false;
  }
  
  private boolean isVipIcon(int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool2 = false;
    boolean bool1;
    if ((1 == paramInt1) || (2 == paramInt1)) {
      bool1 = true;
    }
    do
    {
      do
      {
        do
        {
          do
          {
            return bool1;
            bool1 = bool2;
          } while (6 == paramInt2);
          bool1 = bool2;
        } while (7 == paramInt2);
        bool1 = bool2;
      } while (8 == paramInt2);
      if (paramInt3 != 0) {
        break;
      }
      bool1 = bool2;
    } while (4 == paramInt2);
    return true;
  }
  
  private static boolean showCustomDiamond(int paramInt, boolean paramBoolean, String paramString)
  {
    return ((paramInt == 1) || (paramInt == 2)) && (paramBoolean) && (!TextUtils.isEmpty(paramString));
  }
  
  public float getDensity()
  {
    return aqnm.getDensity();
  }
  
  public Drawable getLayers(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, int paramInt4, String paramString, VipResourcesListener paramVipResourcesListener, int paramInt5)
  {
    try
    {
      paramString = getLayers(paramInt1, paramInt2, paramBoolean, false, null, paramInt3, paramInt4, paramString, paramVipResourcesListener, paramInt5);
      return paramString;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  /* Error */
  public Drawable getLayers(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString1, int paramInt3, int paramInt4, String paramString2, VipResourcesListener paramVipResourcesListener, int paramInt5)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: iload_2
    //   4: iload 6
    //   6: iload_1
    //   7: invokespecial 412	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:isVipIcon	(III)Z
    //   10: istore 12
    //   12: iload 12
    //   14: ifne +11 -> 25
    //   17: aconst_null
    //   18: astore 16
    //   20: aload_0
    //   21: monitorexit
    //   22: aload 16
    //   24: areturn
    //   25: aload 8
    //   27: invokestatic 418	awmy:getIdFromZipUrl	(Ljava/lang/String;)I
    //   30: istore 11
    //   32: aload_0
    //   33: iload 11
    //   35: iload 7
    //   37: iload_1
    //   38: iload 4
    //   40: aload 5
    //   42: iload 6
    //   44: iload_3
    //   45: iload_2
    //   46: invokespecial 420	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getFromCache	(IIIZLjava/lang/String;IZI)Landroid/graphics/drawable/Drawable;
    //   49: astore 17
    //   51: aload 17
    //   53: astore 16
    //   55: aload 17
    //   57: ifnonnull -37 -> 20
    //   60: new 218	awmz
    //   63: dup
    //   64: invokespecial 242	awmz:<init>	()V
    //   67: astore 19
    //   69: new 422	awnb
    //   72: dup
    //   73: aload_0
    //   74: aload 9
    //   76: iload 7
    //   78: aload 19
    //   80: iload 11
    //   82: iload_1
    //   83: iload 4
    //   85: aload 5
    //   87: iload 6
    //   89: iload_3
    //   90: iload_2
    //   91: invokespecial 425	awnb:<init>	(Lcooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow;Lcooperation/vip/vipcomponent/util/VipResourcesListener;ILawmz;IIZLjava/lang/String;IZI)V
    //   94: astore 20
    //   96: iload_2
    //   97: iload 4
    //   99: aload 5
    //   101: invokestatic 427	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:showCustomDiamond	(IZLjava/lang/String;)Z
    //   104: ifeq +29 -> 133
    //   107: aload_0
    //   108: iload_1
    //   109: iload_2
    //   110: iload_3
    //   111: iload 4
    //   113: aload 5
    //   115: iload 6
    //   117: iload 7
    //   119: iload 11
    //   121: aload 19
    //   123: aload 20
    //   125: invokespecial 429	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:handleCustomDiamond	(IIZZLjava/lang/String;IIILawmz;Lawni;)Landroid/graphics/drawable/Drawable;
    //   128: astore 16
    //   130: goto -110 -> 20
    //   133: iconst_0
    //   134: istore 13
    //   136: iconst_0
    //   137: istore 14
    //   139: iconst_0
    //   140: istore 15
    //   142: aconst_null
    //   143: astore 16
    //   145: aconst_null
    //   146: astore 18
    //   148: aconst_null
    //   149: astore 17
    //   151: iload_1
    //   152: bipush 9
    //   154: if_icmpne +231 -> 385
    //   157: aload 8
    //   159: invokestatic 234	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   162: ifne +17 -> 179
    //   165: iload 15
    //   167: istore 12
    //   169: aload 18
    //   171: astore 9
    //   173: iload 6
    //   175: iconst_4
    //   176: if_icmpeq +106 -> 282
    //   179: iload 15
    //   181: istore 12
    //   183: aload 18
    //   185: astore 9
    //   187: iload 10
    //   189: iconst_1
    //   190: if_icmpeq +92 -> 282
    //   193: iconst_1
    //   194: istore 13
    //   196: iload_2
    //   197: iload_1
    //   198: iload 6
    //   200: bipush 7
    //   202: aload 20
    //   204: invokestatic 431	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getLv9Guan	(IIIILawni;)Landroid/graphics/drawable/Drawable;
    //   207: astore 16
    //   209: iload 13
    //   211: istore 12
    //   213: aload 16
    //   215: astore 9
    //   217: aload 16
    //   219: ifnull +63 -> 282
    //   222: aload 16
    //   224: getstatic 114	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_GUAN_ICON_MARGIN_LEFT	I
    //   227: iload 7
    //   229: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   232: getstatic 117	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_GUAN_ICON_MARGIN_TOP	I
    //   235: iload 7
    //   237: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   240: getstatic 120	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_GUAN_ICON_WIDTH	I
    //   243: getstatic 114	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_GUAN_ICON_MARGIN_LEFT	I
    //   246: iadd
    //   247: iload 7
    //   249: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   252: getstatic 124	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_GUAN_ICON_HEIGHT	I
    //   255: getstatic 117	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_GUAN_ICON_MARGIN_TOP	I
    //   258: iadd
    //   259: iload 7
    //   261: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   264: invokevirtual 252	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   267: aload 19
    //   269: aload 16
    //   271: invokevirtual 324	awmz:ap	(Landroid/graphics/drawable/Drawable;)V
    //   274: aload 16
    //   276: astore 9
    //   278: iload 13
    //   280: istore 12
    //   282: iconst_1
    //   283: istore 15
    //   285: iload_2
    //   286: iload_1
    //   287: bipush 8
    //   289: aload 20
    //   291: invokestatic 433	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getWindsDrawalbe	(IIILawni;)Landroid/graphics/drawable/Drawable;
    //   294: astore 18
    //   296: iload 15
    //   298: istore 13
    //   300: iload 12
    //   302: istore 14
    //   304: aload 9
    //   306: astore 16
    //   308: aload 18
    //   310: astore 17
    //   312: aload 18
    //   314: ifnull +71 -> 385
    //   317: aload 18
    //   319: getstatic 131	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_WINDS_MARGIN_LEFT	I
    //   322: iload 7
    //   324: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   327: getstatic 128	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_WINDS_MARGIN_TOP	I
    //   330: iload 7
    //   332: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   335: getstatic 137	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_WINDS_WIDTH	I
    //   338: getstatic 131	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_WINDS_MARGIN_LEFT	I
    //   341: iadd
    //   342: iload 7
    //   344: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   347: getstatic 135	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_WINDS_HEIGHT	I
    //   350: getstatic 128	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:LV9_WINDS_MARGIN_TOP	I
    //   353: iadd
    //   354: iload 7
    //   356: invokestatic 246	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:getRealSize	(II)I
    //   359: invokevirtual 252	android/graphics/drawable/Drawable:setBounds	(IIII)V
    //   362: aload 19
    //   364: aload 18
    //   366: invokevirtual 343	awmz:aq	(Landroid/graphics/drawable/Drawable;)V
    //   369: aload 18
    //   371: astore 17
    //   373: aload 9
    //   375: astore 16
    //   377: iload 12
    //   379: istore 14
    //   381: iload 15
    //   383: istore 13
    //   385: iload 6
    //   387: bipush 7
    //   389: if_icmpne +41 -> 430
    //   392: aload_0
    //   393: iload_1
    //   394: iload_2
    //   395: iload_3
    //   396: iload 4
    //   398: aload 5
    //   400: iload 6
    //   402: iload 7
    //   404: aload 8
    //   406: iload 10
    //   408: iload 11
    //   410: aload 19
    //   412: aload 20
    //   414: iload 13
    //   416: iload 14
    //   418: aload 16
    //   420: aload 17
    //   422: invokespecial 435	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:handleLocationRibbon	(IIZZLjava/lang/String;IILjava/lang/String;IILawmz;Lawni;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   425: astore 16
    //   427: goto -407 -> 20
    //   430: aload_0
    //   431: iload_1
    //   432: iload_2
    //   433: iload_3
    //   434: iload 4
    //   436: aload 5
    //   438: iload 6
    //   440: iload 7
    //   442: aload 8
    //   444: iload 10
    //   446: iload 11
    //   448: aload 19
    //   450: aload 20
    //   452: iload 13
    //   454: iload 14
    //   456: aload 16
    //   458: aload 17
    //   460: invokespecial 437	cooperation/vip/vipcomponent/ui/QzoneHuangzuanVipIconShow:handleNotRibbon	(IIZZLjava/lang/String;IILjava/lang/String;IILawmz;Lawni;ZZLandroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;
    //   463: astore 16
    //   465: goto -445 -> 20
    //   468: astore 5
    //   470: aload_0
    //   471: monitorexit
    //   472: aload 5
    //   474: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	475	0	this	QzoneHuangzuanVipIconShow
    //   0	475	1	paramInt1	int
    //   0	475	2	paramInt2	int
    //   0	475	3	paramBoolean1	boolean
    //   0	475	4	paramBoolean2	boolean
    //   0	475	5	paramString1	String
    //   0	475	6	paramInt3	int
    //   0	475	7	paramInt4	int
    //   0	475	8	paramString2	String
    //   0	475	9	paramVipResourcesListener	VipResourcesListener
    //   0	475	10	paramInt5	int
    //   30	417	11	i	int
    //   10	368	12	bool1	boolean
    //   134	319	13	bool2	boolean
    //   137	318	14	bool3	boolean
    //   140	242	15	bool4	boolean
    //   18	446	16	localObject1	Object
    //   49	410	17	localObject2	Object
    //   146	224	18	localDrawable	Drawable
    //   67	382	19	localawmz	awmz
    //   94	357	20	localawnb	awnb
    // Exception table:
    //   from	to	target	type
    //   2	12	468	finally
    //   25	51	468	finally
    //   60	130	468	finally
    //   157	165	468	finally
    //   196	209	468	finally
    //   222	274	468	finally
    //   285	296	468	finally
    //   317	369	468	finally
    //   392	427	468	finally
    //   430	465	468	finally
  }
  
  public void releaseResources()
  {
    this.context = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.vip.vipcomponent.ui.QzoneHuangzuanVipIconShow
 * JD-Core Version:    0.7.0.1
 */