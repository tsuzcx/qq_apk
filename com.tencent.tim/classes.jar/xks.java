import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.aio.PokePanel.a;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.item.PokeItemHelper.1;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForPoke;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.dinifly.DiniFlyAnimationView;
import com.tencent.mobileqq.dinifly.LottieComposition.Factory;
import com.tencent.mobileqq.vas.VasQuickUpdateManager;
import com.tencent.mobileqq.vas.VasQuickUpdateManager.CallBacker;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;
import java.util.Vector;
import mqq.app.AppRuntime;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class xks
{
  public static final String SDCARD_ROOT;
  public static String TAG = "PokeItemHelper";
  private static String aVi;
  public static final String aVj;
  public static final String aVk;
  public static final String aVl;
  public static final String aVm;
  private static String aVn = "";
  private static String aVo = "";
  private static String aVp = "";
  private static String aVq = "";
  private static String aVr = "";
  public static String aVs;
  public static String aVt;
  public static String aVu;
  public static String aVv;
  private static int bTF;
  private static int bTG;
  private static int bTH;
  private static int bTI;
  public static int bTJ;
  public static int bTK = -1;
  public static int bTL = -1;
  public static int bTM = 10;
  public static int bTN = 60;
  public static int bTO = -1;
  public static int bTP = -1;
  public static int bTQ = 10;
  public static int bTR = 60;
  public static int bTS;
  public static int bTT;
  public static int bTU = 50;
  private static int bTV;
  private static int bTW;
  public static int bTX;
  public static boolean bhd;
  private static boolean bhe;
  private static boolean bhf;
  private static boolean bhg;
  private static boolean bhh;
  private static boolean bhi;
  public static volatile boolean bhj;
  public static volatile boolean bhk;
  public static boolean bhl;
  private static final String[] cG = { "chuo_icon", "bixin_icon", "zan_icon", "xinsui_icon", "666_icon", "dazhao_icon", "chuo_motion", "bixin_motion", "zan_motion", "xinsui_motion", "666_motion", "dazhao_motion" };
  private static BitSet e;
  public static int entryType;
  private static final int[] ht = { 22, 22, 22, 22, 22, 22, 35, 99, 25, 60, 0, 0 };
  public static android.graphics.Bitmap[] k = new android.graphics.Bitmap[6];
  public static android.graphics.Bitmap[] l = new android.graphics.Bitmap[6];
  public static android.graphics.Bitmap[] m = new android.graphics.Bitmap[6];
  private static int mTargetDensity = BaseApplicationImpl.getContext().getResources().getDisplayMetrics().densityDpi;
  public static android.graphics.Bitmap[] n = new android.graphics.Bitmap[6];
  public static final Vector<Integer> q;
  static ArrayList<android.graphics.Bitmap> qG;
  public static final Vector<Integer> r;
  public static final Vector<Integer> s;
  public static final Vector<Integer> t;
  public static int viewType;
  
  static
  {
    SDCARD_ROOT = Environment.getExternalStorageDirectory().getAbsolutePath();
    aVj = SDCARD_ROOT + "/Tencent/MobileQQ/";
    aVk = aqul.getSDKPrivatePath(aVj);
    aVl = aqul.getSDKPrivatePath(aVj + ".vaspoke/");
    aVm = aVl + "vasPokeMarket.json";
    q = new Vector();
    r = new Vector();
    s = new Vector();
    t = new Vector();
    bTJ = -1;
  }
  
  public static boolean A(QQAppInterface paramQQAppInterface)
  {
    return bTT == 1;
  }
  
  public static boolean B(QQAppInterface paramQQAppInterface)
  {
    if (QLog.isColorLevel()) {
      QLog.d("PokeEmo", 2, "checkPEResDownloaded mIsPeResDownloaded =  " + bhj);
    }
    return false;
  }
  
  public static void D(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    bhe = true;
    bTK = paramInt1;
    bTL = paramInt2;
    bTM = paramInt3;
    bTN = paramInt4;
  }
  
  public static void Dg(int paramInt)
  {
    bhh = true;
    bTH = paramInt;
  }
  
  public static void Dh(int paramInt)
  {
    bTT = paramInt;
  }
  
  public static void Di(int paramInt)
  {
    bhi = true;
    bTI = paramInt;
  }
  
  public static android.graphics.Bitmap G(android.graphics.Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = android.graphics.Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if ((QLog.isColorLevel()) && (paramBitmap != null)) {
        Log.d("test", "convertBmp w=" + paramBitmap.getWidth());
      }
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "get pokeFriendPokeImage oom" + paramBitmap);
        }
        paramBitmap = null;
      }
    }
  }
  
  public static boolean G(String paramString, int paramInt)
  {
    ayzc.adK(aVl);
    if (("bubble".equals(paramString)) || ("fullscreen".equals(paramString)) || ("view_aio".equals(paramString))) {
      return new File(aVl + paramInt + File.separator + paramString + File.separator + paramString + ".json").exists();
    }
    return new File(aVl + paramInt + "/" + paramString).exists();
  }
  
  public static boolean Sz()
  {
    boolean bool2 = false;
    Object localObject = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.vip_individuation.name());
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      localObject = ((String)localObject).split("\\|");
      bool1 = bool2;
      if (localObject != null)
      {
        bool1 = bool2;
        if (localObject.length >= 7)
        {
          bool1 = bool2;
          if (!"0".equals(localObject[6])) {
            bool1 = true;
          }
        }
      }
    }
    return bool1;
  }
  
  public static Drawable a(int paramInt, boolean paramBoolean, Resources paramResources)
  {
    int i1 = 2130845735;
    int i2 = 2130845734;
    if ((paramInt < 0) || (paramInt > 6)) {
      paramInt = 1;
    }
    for (;;)
    {
      if (paramInt == 0) {}
      for (int j = 1;; j = paramInt)
      {
        paramInt = i2;
        int i = i1;
        switch (j)
        {
        default: 
          i = i1;
          paramInt = i2;
        case 0: 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
        case 6: 
          for (;;)
          {
            j -= 1;
            a(m, k, j, paramResources, paramInt, i);
            if (!paramBoolean)
            {
              if ((m[j] != null) && (n[j] == null)) {
                n[j] = G(m[j]);
              }
              if ((l[j] != null) && (l[j] == null)) {
                l[j] = G(l[j]);
              }
            }
            if (!paramBoolean) {
              break;
            }
            return auqy.a(paramResources, m[j], k[j]);
            paramInt = 2130845676;
            i = 2130845677;
            continue;
            paramInt = 2130845660;
            i = 2130845661;
            continue;
            paramInt = 2130845681;
            i = 2130845682;
            continue;
            paramInt = 2130845678;
            i = 2130845679;
          }
        }
        if (paramBoolean)
        {
          a(m, k, j - 1, paramResources, 2130845685, 2130845686);
          return auqy.a(paramResources, m[(j - 1)], k[(j - 1)]);
        }
        a(n, l, j - 1, paramResources, 2130845683, 2130845684);
        return auqy.a(paramResources, n[(j - 1)], l[(j - 1)]);
        return auqy.a(paramResources, n[j], l[j]);
      }
    }
  }
  
  public static ArrayList<PokePanel.a> a(AppRuntime paramAppRuntime, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    ArrayList localArrayList = new ArrayList();
    Object localObject1 = new File(aVm);
    if (((File)localObject1).exists()) {}
    for (;;)
    {
      int i;
      try
      {
        localObject1 = new JSONObject(aqhq.readFileContent((File)localObject1));
        try
        {
          if (!((JSONObject)localObject1).optBoolean("lottieEnable", true))
          {
            if (!QLog.isColorLevel()) {
              break label644;
            }
            QLog.d(TAG, 2, "lottie disable");
            break label644;
          }
          localObject1 = ((JSONObject)localObject1).optJSONArray("itemList");
          i = 0;
          if (i < ((JSONArray)localObject1).length())
          {
            localObject2 = (JSONObject)((JSONArray)localObject1).get(i);
            Object localObject3 = ((JSONObject)localObject2).optString("id");
            Object localObject4 = ((JSONObject)localObject2).optString("name");
            int j = ((JSONObject)localObject2).optInt("feeType", 0);
            int i1 = ((JSONObject)localObject2).optInt("status", 0);
            int i2 = ((JSONObject)localObject2).optInt("isShow", 0);
            String str = ((JSONObject)localObject2).optString("minVersion");
            if (!isSupported(str))
            {
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "curr ver: 3.4.4, config qqVer:" + str);
              }
            }
            else if ((i1 == 1) && (i2 == 1))
            {
              localObject2 = new PokePanel.a();
              ((PokePanel.a)localObject2).bPs = 126;
              ((PokePanel.a)localObject2).resId = Integer.parseInt((String)localObject3);
              ((PokePanel.a)localObject2).name = ((String)localObject4);
              ((PokePanel.a)localObject2).feeType = j;
              ((PokePanel.a)localObject2).contentDescription = ((String)localObject4);
              ((PokePanel.a)localObject2).minVersion = str;
              localObject3 = (VasQuickUpdateManager)paramAppRuntime.getManager(184);
              if (!G("effect.gif", ((PokePanel.a)localObject2).resId))
              {
                ((PokePanel.a)localObject2).bep = true;
                ((VasQuickUpdateManager)localObject3).downloadItem(21L, "poke.item.effect." + ((PokePanel.a)localObject2).resId, "parseVasPokeConfig");
                ((VasQuickUpdateManager)localObject3).addCallBacker(paramCallBacker);
              }
              localObject4 = URLDrawable.URLDrawableOptions.obtain();
              ((URLDrawable.URLDrawableOptions)localObject4).mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130848277);
              ((URLDrawable.URLDrawableOptions)localObject4).mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130848277);
              ((URLDrawable.URLDrawableOptions)localObject4).mPlayGifImage = true;
              ((URLDrawable.URLDrawableOptions)localObject4).mGifRoundCorner = 0.0F;
              ((PokePanel.a)localObject2).drawable = URLDrawable.getDrawable(new File(aVl + ((PokePanel.a)localObject2).resId + "/" + "effect.gif"), (URLDrawable.URLDrawableOptions)localObject4);
              if (QLog.isColorLevel()) {
                QLog.i(TAG, 2, "name: " + ((PokePanel.a)localObject2).name + " resId: " + ((PokePanel.a)localObject2).resId + " feeType: " + ((PokePanel.a)localObject2).feeType);
              }
              localArrayList.add(localObject2);
              if (!G("bubble", ((PokePanel.a)localObject2).resId))
              {
                ((PokePanel.a)localObject2).beo = true;
                if (!afnu.isWifi()) {
                  break label647;
                }
                ((VasQuickUpdateManager)localObject3).downloadItem(21L, "poke.item.res." + ((PokePanel.a)localObject2).resId, "parseVasPokeConfig");
                ((VasQuickUpdateManager)localObject3).addCallBacker(paramCallBacker);
              }
            }
          }
        }
        catch (Exception paramAppRuntime)
        {
          QLog.e("PokeItemHelper", 1, "parse json config fail", paramAppRuntime);
        }
      }
      catch (Throwable paramAppRuntime)
      {
        Object localObject2;
        QLog.e(TAG, 1, "getJsonOOM,json_name:vasPoke", paramAppRuntime);
        continue;
      }
      return localArrayList;
      ((PokePanel.a)localObject2).beo = false;
      break label647;
      a(paramAppRuntime, paramCallBacker);
      continue;
      label644:
      return localArrayList;
      label647:
      i += 1;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, int paramInt2, String paramString2, int paramInt3)
  {
    ((aqrb)paramQQAppInterface.getBusinessHandler(71)).b(paramInt1, paramString1, paramInt2, paramString2, paramInt3);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, int paramInt2, int paramInt3, int paramInt4)
  {
    entryType = paramInt1;
    viewType = paramInt4;
    aVs = paramString1;
    aVt = paramString2;
    aVu = paramString3;
    aVv = paramString4;
    bTS = paramInt2;
    bTU = paramInt3;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "setPokeEmoPanelConfig|entryType: " + entryType + ",peSurpriseIndexs: " + aVu + ",peOders: " + paramString4);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    paramQQAppInterface = new xkv(paramQQAppInterface, paramInt2, paramActivity, paramInt1);
    paramQQAppInterface = aqha.a(paramActivity, 0, acfp.m(2131709795), paramString1, acfp.m(2131709794), paramString2, paramQQAppInterface, paramQQAppInterface);
    if (paramQQAppInterface != null) {
      paramQQAppInterface.show();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, @NonNull DiniFlyAnimationView paramDiniFlyAnimationView, @Nullable xbu.a parama, int paramInt, String paramString)
  {
    if (Sz()) {
      ThreadManager.postImmediately(new PokeItemHelper.1(paramInt), null, true);
    }
    paramQQAppInterface = aVl + paramInt + "/" + paramString + "/";
    paramQQAppInterface = new File(paramQQAppInterface + paramString + ".json");
    try
    {
      parama = new xkt(paramDiniFlyAnimationView, parama, paramString);
      Bundle localBundle = new Bundle();
      localBundle.putString("key", "lottie_vaspoke_" + String.valueOf(paramInt) + paramString);
      localBundle.putString("path", aVl + paramInt + "/" + paramString + "/images/");
      LottieComposition.Factory.fromInputStreamWithCacheBitmap(paramContext, new FileInputStream(paramQQAppInterface), paramDiniFlyAnimationView.getLottieDrawable(), parama, localBundle, BaseApplicationImpl.sImageCache);
      return;
    }
    catch (FileNotFoundException paramQQAppInterface)
    {
      QLog.e("PokeItemHelper", 2, "vaspoke, file not found. id: " + paramInt + " ,category: " + paramString, paramQQAppInterface);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      QLog.e("PokeItemHelper", 2, "vaspoke, exception occur, id: " + paramInt + " ,category: " + paramString, paramQQAppInterface);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, String paramString3)
  {
    if (!bhl) {}
    do
    {
      do
      {
        return;
        if (QLog.isColorLevel()) {
          QLog.d("PokeEmo", 2, "startDownloadPERes resUrl " + paramString1 + ",resMD5" + paramString2);
        }
        if (!bhk) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("PokeEmo", 2, "other request is downloading ");
      return;
      if (bTX <= 15) {
        break;
      }
    } while (!QLog.isColorLevel());
    QLog.d("PokeEmo", 2, "pe res download exceed limit 5 ");
    return;
    bhk = true;
    String str = paramString3 + "pe.zip";
    paramString2 = new xkw(paramString3, paramString2);
    paramQQAppInterface = paramQQAppInterface.getNetEngine(0);
    paramString3 = new aoll();
    paramString3.f = paramString2;
    paramString3.mHttpMethod = 0;
    paramString3.bZ = paramString1;
    paramString3.atY = str;
    paramString3.dPo = 0;
    paramQQAppInterface.a(paramString3);
  }
  
  public static void a(AppRuntime paramAppRuntime, VasQuickUpdateManager.CallBacker paramCallBacker)
  {
    if (VasQuickUpdateManager.getFileFromLocal(paramAppRuntime, 21L, "poke.effectList", aVm, true, paramCallBacker) != null)
    {
      paramAppRuntime = (afem)paramAppRuntime.getManager(77);
      if (paramAppRuntime != null)
      {
        paramAppRuntime = (affc)paramAppRuntime.a("qq.android.poke.res_0625");
        if ((paramAppRuntime != null) && (!paramAppRuntime.isSuccess()))
        {
          paramAppRuntime.cYO();
          if (QLog.isColorLevel()) {
            QLog.d(TAG, 2, "vas poke config exists, do not download, set ready");
          }
        }
      }
    }
  }
  
  public static void a(android.graphics.Bitmap[] paramArrayOfBitmap1, android.graphics.Bitmap[] paramArrayOfBitmap2, int paramInt1, Resources paramResources, int paramInt2, int paramInt3)
  {
    if (paramArrayOfBitmap1[paramInt1] == null)
    {
      android.graphics.Bitmap localBitmap = aqhu.g(paramResources, paramInt2);
      if (localBitmap != null) {
        paramArrayOfBitmap1[paramInt1] = localBitmap;
      }
    }
    if (paramArrayOfBitmap2[paramInt1] == null)
    {
      paramArrayOfBitmap1 = aqhu.g(paramResources, paramInt3);
      if (paramArrayOfBitmap1 != null) {
        paramArrayOfBitmap2[paramInt1] = paramArrayOfBitmap1;
      }
    }
  }
  
  private static void aU(QQAppInterface paramQQAppInterface)
  {
    String str;
    if (paramQQAppInterface != null)
    {
      str = paramQQAppInterface.getAccount();
      if ((!bhe) || (!aVn.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (!paramQQAppInterface.contains(str + "_" + "poke_bar_config_version")) {
          break label659;
        }
        bTK = paramQQAppInterface.getInt(str + "_" + "poke_bar_switch", bTO);
        bTL = paramQQAppInterface.getInt(str + "_" + "poke_pad_switch", bTP);
        bTN = paramQQAppInterface.getInt(str + "_" + "aio_poke_unittime", bTR);
        bTM = paramQQAppInterface.getInt(str + "_" + "aio_poke_unitcount", bTQ);
        entryType = paramQQAppInterface.getInt(str + "_" + "aio_poke_entry_type", 0);
        viewType = paramQQAppInterface.getInt(str + "_" + "aio_pe_view_type", 0);
        aVs = paramQQAppInterface.getString(str + "_" + "poke_emo_res_url", "");
        aVt = paramQQAppInterface.getString(str + "_" + "poke_emo_res_md5", "");
        aVu = paramQQAppInterface.getString(str + "_" + "poke_emo_surprice_indexs", "");
        aVv = paramQQAppInterface.getString(str + "_" + "poke_emo_order", "");
        bTS = paramQQAppInterface.getInt(str + "_" + "aio_pe_input_switch", 0);
        bTT = paramQQAppInterface.getInt(str + "_" + "aio_pe_feed_back_switch", 0);
        bTU = paramQQAppInterface.getInt(str + "_" + "aio_pe_bubble_limit_count", 50);
        bTJ = paramQQAppInterface.getInt(str + "_" + "pe_last_tab_index", -1);
      }
    }
    for (;;)
    {
      aVn = str;
      bhe = true;
      if (QLog.isColorLevel()) {
        QLog.d("pokeMsg", 2, String.format("getPokeSwitch, first init, bar switch: %d, pad switch: %d, uin: %s ,limited count:%d,limited time:%d", new Object[] { Integer.valueOf(bTK), Integer.valueOf(bTL), aVn, Integer.valueOf(bTM), Integer.valueOf(bTN) }));
      }
      return;
      label659:
      bTK = bTO;
      bTL = bTP;
      entryType = 0;
      viewType = 0;
      bTS = 0;
      bTT = 0;
      bTU = 50;
    }
  }
  
  public static int b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    String str = paramQQAppInterface.getAccount();
    if ((!bhg) || (!aVp.equals(str)))
    {
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version"))
      {
        bTF = paramQQAppInterface.getInt(str + "_" + "aio_unique_poke_show", 0);
        bTG = paramQQAppInterface.getInt(str + "_" + "aio_unique_poke_type", 0);
      }
      aVp = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("uniquepoke show %d type %d", new Object[] { Integer.valueOf(bTF), Integer.valueOf(bTG) }));
    }
    bhe = true;
    if (paramInt == 1) {
      return bTF;
    }
    if (paramInt == 2) {
      return bTG;
    }
    return -1;
  }
  
  public static void b(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    if (paramInt1 == 126)
    {
      File localFile = new File(aVl + paramInt2 + "/pressed.png");
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mLoadingDrawable = BaseApplication.getContext().getResources().getDrawable(2130848277);
      localURLDrawableOptions.mFailedDrawable = BaseApplication.getContext().getResources().getDrawable(2130848277);
      paramImageView.setImageDrawable(URLDrawable.getDrawable(localFile, localURLDrawableOptions));
      return;
    }
    paramImageView.setImageResource(paramInt2);
  }
  
  public static boolean b(SharedPreferences paramSharedPreferences)
  {
    if (bTV == 0) {
      if (paramSharedPreferences.getBoolean("sp_aio_panel_unique_clicked", false)) {
        bTV = 1;
      }
    }
    while ((bTV == 1) || (bTV != 2))
    {
      return false;
      bTV = 2;
      return true;
    }
    return true;
  }
  
  public static int bI(String paramString)
    throws JSONException
  {
    return new JSONObject(paramString).getInt("comboNum");
  }
  
  public static int bJ(String paramString)
    throws JSONException
  {
    return new JSONObject(paramString).getInt("TouchFeelingEntrance");
  }
  
  public static int bK(String paramString)
    throws JSONException
  {
    return new JSONObject(paramString).getInt("IndependentEntrance");
  }
  
  public static int bL(String paramString)
  {
    try
    {
      int i = new JSONObject(paramString).getInt("IndependentEntranceType");
      return i;
    }
    catch (JSONException paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, paramString.toString());
      }
    }
    return 0;
  }
  
  public static int c(QQAppInterface paramQQAppInterface, int paramInt)
  {
    aU(paramQQAppInterface);
    switch (paramInt)
    {
    case 5: 
    case 6: 
    case 7: 
    case 8: 
    default: 
      return -1;
    case 1: 
      return bTK;
    case 0: 
      return bTL;
    case 2: 
      return bTM;
    case 3: 
      return bTN;
    case 4: 
      return entryType;
    case 11: 
      return viewType;
    case 9: 
      return bTS;
    }
    return bTU;
  }
  
  public static Drawable c(android.graphics.Bitmap paramBitmap)
  {
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(-1.0F, 1.0F);
    try
    {
      paramBitmap = android.graphics.Bitmap.createBitmap(paramBitmap, 0, 0, i, j, localMatrix, true);
      if ((QLog.isColorLevel()) && (paramBitmap != null)) {
        Log.d("test", "convertBmp w=" + paramBitmap.getWidth());
      }
      paramBitmap = new BitmapDrawable(paramBitmap);
      ((BitmapDrawable)paramBitmap).setTargetDensity(mTargetDensity);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      for (;;)
      {
        if (QLog.isColorLevel()) {
          QLog.d(TAG, 2, "get pokeFriendPokeImage oom" + paramBitmap);
        }
        paramBitmap = null;
      }
    }
  }
  
  public static boolean c(SharedPreferences paramSharedPreferences)
  {
    if (bTW == 0) {
      if (paramSharedPreferences.getBoolean("sp_aio_panel_poke_clicked", false)) {
        bTW = 2;
      }
    }
    do
    {
      return true;
      bTW = 1;
      return false;
      if (bTW == 1) {
        return false;
      }
    } while (bTW == 2);
    return false;
  }
  
  public static void cC(String paramString, int paramInt)
  {
    SharedPreferences.Editor localEditor = PreferenceManager.getDefaultSharedPreferences(BaseApplicationImpl.getContext()).edit();
    localEditor.putInt(paramString + "_" + "pe_last_tab_index", paramInt);
    localEditor.apply();
  }
  
  public static void cdQ()
  {
    if (qG != null) {
      qG.clear();
    }
    qG = null;
  }
  
  public static void cdR()
  {
    android.graphics.Bitmap[][] arrayOfBitmap; = new android.graphics.Bitmap[4][];
    arrayOfBitmap;[0] = l;
    arrayOfBitmap;[1] = n;
    arrayOfBitmap;[2] = m;
    arrayOfBitmap;[3] = k;
    int i = 0;
    while (i < arrayOfBitmap;.length)
    {
      [Landroid.graphics.Bitmap localBitmap; = arrayOfBitmap;[i];
      int j = 0;
      while (j < localBitmap;.length)
      {
        if (localBitmap;[j] != null)
        {
          localBitmap;[j].recycle();
          localBitmap;[j] = null;
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  private static void dD(String paramString1, String paramString2)
  {
    int i = 0;
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[res checking]" + paramString1 + paramString2);
    }
    if (paramString2.equals("dazhao_motion")) {
      e.set(11, false);
    }
    for (;;)
    {
      return;
      if (paramString2.equals("666_motion"))
      {
        e.set(10, false);
        return;
      }
      while (i < 12)
      {
        if (cG[i].equals(paramString2))
        {
          Object localObject = new File(paramString1 + paramString2);
          if (((File)localObject).isDirectory())
          {
            localObject = ((File)localObject).list();
            if ((localObject != null) && (localObject.length == ht[i]))
            {
              e.set(i, true);
              if (QLog.isColorLevel()) {
                QLog.d(TAG, 2, "[res checked]" + paramString2);
              }
            }
          }
        }
        i += 1;
      }
    }
  }
  
  public static String f(QQAppInterface paramQQAppInterface, int paramInt)
  {
    aU(paramQQAppInterface);
    switch (paramInt)
    {
    default: 
      return null;
    case 5: 
      return aVs;
    case 6: 
      return aVt;
    case 7: 
      return aVu;
    }
    return aVv;
  }
  
  public static void fJ(int paramInt1, int paramInt2)
  {
    bhg = true;
    bTF = paramInt1;
    bTG = paramInt2;
  }
  
  public static boolean g(QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    long l1 = anaz.gQ();
    paramSessionInfo = paramQQAppInterface.b().k(paramSessionInfo.aTl, paramSessionInfo.cZ);
    int i;
    MessageRecord localMessageRecord;
    boolean bool;
    if ((paramSessionInfo != null) && (paramSessionInfo.size() > 0))
    {
      int j = paramSessionInfo.size() - 1;
      i = 0;
      for (;;)
      {
        if (j >= 0)
        {
          localMessageRecord = (MessageRecord)paramSessionInfo.get(j);
          if (!localMessageRecord.isSend()) {
            j -= 1;
          } else if (l1 - localMessageRecord.time > c(paramQQAppInterface, 3)) {
            bool = true;
          }
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "isCanSendPoke, isCansend= " + bool);
      }
      return bool;
      if ((localMessageRecord instanceof MessageForPoke))
      {
        int i1 = i + 1;
        i = i1;
        if (i1 < c(paramQQAppInterface, 2)) {
          break;
        }
        bool = false;
        continue;
      }
      break;
      bool = true;
    }
  }
  
  public static boolean gw(int paramInt)
  {
    boolean bool2 = true;
    boolean bool1;
    if ((paramInt < 0) || (paramInt > 6)) {
      bool1 = false;
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
            if (paramInt != 6) {
              break;
            }
            if (e == null)
            {
              e = new BitSet(12);
              e.clear();
              e.set(6);
            }
            bool1 = bool2;
          } while (e.get(11));
          Object localObject = aVk + "/poke/dazhao_motion/";
          File localFile1 = new File((String)localObject, "dazhao_move.png");
          File localFile2 = new File((String)localObject, "dazhao_motion");
          localObject = new File((String)localObject, "dazhao2_motion");
          if ((localFile1.exists()) && (localFile2.exists()) && (localFile2.isDirectory()) && (localFile2.list().length == 34) && (((File)localObject).exists()) && (((File)localObject).isDirectory()) && (((File)localObject).list().length == 22))
          {
            e.set(11, true);
            return true;
          }
          return false;
          bool1 = bool2;
        } while (paramInt == 5);
        bool1 = bool2;
      } while (paramInt == 0);
      bool1 = bool2;
    } while (paramInt == 1);
    return gy(paramInt + 6 - 1);
  }
  
  public static boolean gx(int paramInt)
  {
    if ((paramInt < 0) || (paramInt > 6)) {
      return false;
    }
    if (paramInt == 0) {
      return true;
    }
    return gy(paramInt - 1);
  }
  
  public static boolean gy(int paramInt)
  {
    if (e == null)
    {
      e = new BitSet(12);
      e.clear();
      e.set(6);
    }
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[res check] type:" + paramInt);
    }
    boolean bool2 = e.get(paramInt);
    boolean bool1 = bool2;
    if (!bool2)
    {
      Object localObject = new File(aVk + "poke/" + cG[paramInt]);
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "[res dir]" + aVk + "poke/" + cG[paramInt]);
      }
      bool1 = bool2;
      if (((File)localObject).exists())
      {
        bool1 = bool2;
        if (((File)localObject).isDirectory())
        {
          localObject = ((File)localObject).list();
          if (localObject == null) {
            break label225;
          }
          bool1 = bool2;
          if (localObject.length == ht[paramInt])
          {
            if (QLog.isColorLevel()) {
              QLog.d(TAG, 2, "[res checked]");
            }
            bool1 = true;
          }
        }
      }
    }
    return bool1;
    label225:
    return false;
  }
  
  public static String hw(String paramString)
    throws JSONException
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramString = new JSONObject(paramString);
    if (paramString.getInt("isShowPanel") == 1)
    {
      paramString = paramString.getJSONArray("panel_source");
      int i = 0;
      while (i < paramString.length())
      {
        localStringBuilder.append(paramString.getInt(i));
        i += 1;
      }
      return localStringBuilder.toString();
    }
    return null;
  }
  
  public static String i(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface != null)
    {
      String str = paramQQAppInterface.getAccount();
      if ((!bhf) || (!aVo.equals(str)))
      {
        paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
        if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version"))
        {
          aVi = paramQQAppInterface.getString(str + "_" + "aio_poke_panel_config", "".toString());
          if (aVi == null) {
            aVi = "";
          }
        }
        aVo = str;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, "PokePanelPlaceInfo:" + aVi);
    }
    bhf = true;
    return aVi;
  }
  
  public static boolean isSupported(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (AppSetting.bs(paramString) < 0))
    {
      if (QLog.isColorLevel()) {
        QLog.d(TAG, 2, "curr ver: 3.4.4, config qqVer:" + paramString);
      }
      return false;
    }
    return true;
  }
  
  public static int n(QQAppInterface paramQQAppInterface)
  {
    return b(paramQQAppInterface, 1);
  }
  
  public static void n(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((paramBoolean == true) && (bTV != 2)) || ((!paramBoolean) && (bTV != 1)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putBoolean("sp_aio_panel_unique_clicked", true).commit();
      }
      if (paramBoolean) {
        bTV = 2;
      }
    }
    else
    {
      return;
    }
    bTV = 1;
  }
  
  public static int o(QQAppInterface paramQQAppInterface)
  {
    return b(paramQQAppInterface, 2);
  }
  
  public static void o(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    if (((paramBoolean == true) && (bTW != 2)) || ((!paramBoolean) && (bTW != 1)))
    {
      paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences(paramQQAppInterface.getCurrentAccountUin(), 0);
      if (paramQQAppInterface != null) {
        paramQQAppInterface.edit().putBoolean("sp_aio_panel_poke_clicked", true).commit();
      }
      if (paramBoolean) {
        bTW = 2;
      }
    }
    else
    {
      return;
    }
    bTW = 1;
  }
  
  public static int p(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return 0;
    }
    String str = paramQQAppInterface.getAccount();
    if ((!bhh) || (!aVq.equals(str)))
    {
      paramQQAppInterface = PreferenceManager.getDefaultSharedPreferences(paramQQAppInterface.getApp());
      if (paramQQAppInterface.contains(str + "_" + "poke_bar_config_version")) {
        bTH = paramQQAppInterface.getInt(str + "_" + "aio_poke_touch_effect", 0);
      }
      aVq = str;
    }
    if (QLog.isColorLevel()) {
      QLog.d("pokeMsg", 2, String.format("touchEffect apply:%d", new Object[] { Integer.valueOf(bTH) }));
    }
    bhh = true;
    return bTH;
  }
  
  public static String pt()
  {
    return aqul.getSDKPrivatePath(acbn.bmx);
  }
  
  public static void xW(String paramString)
  {
    bhf = true;
    aVi = paramString;
  }
  
  public static void xX(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d(TAG, 2, "[all res checking]  dir" + paramString);
    }
    if (e == null)
    {
      e = new BitSet(12);
      e.clear();
      e.set(7);
    }
    Object localObject = new File(paramString);
    if ((((File)localObject).exists()) && (((File)localObject).isDirectory()))
    {
      localObject = ((File)localObject).list();
      if (localObject != null)
      {
        int j = localObject.length;
        int i = 0;
        while (i < j)
        {
          dD(paramString, localObject[i]);
          i += 1;
        }
      }
    }
  }
  
  public static boolean z(QQAppInterface paramQQAppInterface)
  {
    return p(paramQQAppInterface) == 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xks
 * JD-Core Version:    0.7.0.1
 */