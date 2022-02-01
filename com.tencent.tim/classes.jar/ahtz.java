import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.StateListDrawable;
import android.graphics.drawable.shapes.RoundRectShape;
import android.graphics.drawable.shapes.Shape;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.common.app.AppInterface;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.gamecenter.data.FeedsItemData.RedInfo;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import org.json.JSONObject;

public class ahtz
{
  public static Queue<String> H = new ArrayDeque(100);
  public static final String bLK = acfp.m(2131711700);
  public static final String bLL = acfp.m(2131711699);
  public static final String bLM = acfp.m(2131711701);
  public static boolean cij = true;
  public static Map<String, String> lk = new HashMap();
  
  public static void KJ(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    if (H == null) {
      H = new ArrayDeque(100);
    }
    if (H.size() >= 100) {
      H.poll();
    }
    H.add(paramString);
  }
  
  public static StateListDrawable a(Context paramContext)
  {
    Object localObject1 = new Drawable[3];
    float f1 = wja.dp2px(4.0F, paramContext.getResources());
    float f2 = wja.dp2px(4.0F, paramContext.getResources());
    float f3 = wja.dp2px(4.0F, paramContext.getResources());
    float f4 = wja.dp2px(4.0F, paramContext.getResources());
    int i = 0;
    while (i < 2)
    {
      localObject2 = new RoundRectShape(new float[] { f1, f1, f2, f2, f3, f3, f4, f4 }, null, null);
      localShapeDrawable = new ShapeDrawable();
      localShapeDrawable.setPadding(wja.dp2px(2.0F, paramContext.getResources()), wja.dp2px(0.0F, paramContext.getResources()), wja.dp2px(2.0F, paramContext.getResources()), wja.dp2px(2.0F, paramContext.getResources()));
      localShapeDrawable.setShape((Shape)localObject2);
      localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
      localShapeDrawable.getPaint().setColor(83886080);
      localObject1[i] = localShapeDrawable;
      i += 1;
    }
    Object localObject2 = new float[8];
    localObject2[0] = f1;
    localObject2[1] = f1;
    localObject2[2] = f2;
    localObject2[3] = f2;
    localObject2[4] = f3;
    localObject2[5] = f3;
    localObject2[6] = f4;
    localObject2[7] = f4;
    paramContext = new RoundRectShape((float[])localObject2, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(paramContext);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-1);
    localObject1[2] = localShapeDrawable;
    paramContext = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new RoundRectShape((float[])localObject2, null, null);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape((Shape)localObject2);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-526345);
    localObject1[2] = localShapeDrawable;
    localObject1 = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, paramContext);
    return localObject2;
  }
  
  public static StateListDrawable a(Context paramContext, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    Object localObject1 = new Drawable[5];
    paramFloat1 = wja.dp2px(paramFloat1, paramContext.getResources());
    paramFloat2 = wja.dp2px(paramFloat2, paramContext.getResources());
    paramFloat3 = wja.dp2px(paramFloat3, paramContext.getResources());
    float f = wja.dp2px(paramFloat4, paramContext.getResources());
    int i = 0;
    if (i < 4)
    {
      localObject2 = new RoundRectShape(new float[] { paramFloat1, paramFloat1, paramFloat2, paramFloat2, paramFloat3, paramFloat3, f, f }, null, null);
      localShapeDrawable = new ShapeDrawable();
      if (paramFloat4 == 0.0F) {
        localShapeDrawable.setPadding(wja.dp2px(2.0F, paramContext.getResources()), wja.dp2px(0.0F, paramContext.getResources()), wja.dp2px(2.0F, paramContext.getResources()), 0);
      }
      for (;;)
      {
        localShapeDrawable.setShape((Shape)localObject2);
        localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
        localShapeDrawable.getPaint().setColor(634178764);
        localObject1[i] = localShapeDrawable;
        i += 1;
        break;
        localShapeDrawable.setPadding(wja.dp2px(2.0F, paramContext.getResources()), wja.dp2px(0.0F, paramContext.getResources()), wja.dp2px(2.0F, paramContext.getResources()), wja.dp2px(2.0F, paramContext.getResources()));
      }
    }
    Object localObject2 = new float[8];
    localObject2[0] = (paramFloat1 / 2.0F);
    localObject2[1] = (paramFloat1 / 2.0F);
    localObject2[2] = (paramFloat2 / 2.0F);
    localObject2[3] = (paramFloat2 / 2.0F);
    localObject2[4] = (paramFloat3 / 2.0F);
    localObject2[5] = (paramFloat3 / 2.0F);
    localObject2[6] = (f / 2.0F);
    localObject2[7] = (f / 2.0F);
    paramContext = new RoundRectShape((float[])localObject2, null, null);
    ShapeDrawable localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape(paramContext);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-1);
    localObject1[4] = localShapeDrawable;
    paramContext = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new RoundRectShape((float[])localObject2, null, null);
    localShapeDrawable = new ShapeDrawable();
    localShapeDrawable.setShape((Shape)localObject2);
    localShapeDrawable.getPaint().setStyle(Paint.Style.FILL);
    localShapeDrawable.getPaint().setColor(-526345);
    localObject1[4] = localShapeDrawable;
    localObject1 = new LayerDrawable((Drawable[])localObject1);
    localObject2 = new StateListDrawable();
    ((StateListDrawable)localObject2).addState(new int[] { 16842919 }, (Drawable)localObject1);
    ((StateListDrawable)localObject2).addState(new int[] { 16842910 }, paramContext);
    return localObject2;
  }
  
  public static StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2, String paramString1, String paramString2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mLoadingDrawable = paramDrawable1;
    localURLDrawableOptions.mFailedDrawable = paramDrawable1;
    paramDrawable1 = URLDrawable.getDrawable(paramString1, localURLDrawableOptions);
    paramString1 = URLDrawable.URLDrawableOptions.obtain();
    paramString1.mLoadingDrawable = paramDrawable2;
    paramString1.mFailedDrawable = paramDrawable2;
    paramDrawable2 = URLDrawable.getDrawable(paramString2, paramString1);
    paramString1 = new StateListDrawable();
    paramString1.addState(new int[] { 16842919 }, paramDrawable2);
    paramString1.addState(new int[] { 16842910 }, paramDrawable1);
    return paramString1;
  }
  
  public static StateListDrawable a(String paramString1, String paramString2, Context paramContext)
  {
    paramString1 = URLDrawable.getDrawable(paramString1, paramContext.getResources().getDrawable(2130851044), paramContext.getResources().getDrawable(2130851044));
    paramString2 = URLDrawable.getDrawable(paramString2);
    paramContext = new StateListDrawable();
    paramContext.addState(new int[] { 16842919 }, paramString1);
    paramContext.addState(new int[] { 16842908 }, paramString2);
    paramContext.addState(new int[] { 16842910 }, paramString2);
    paramContext.addState(new int[0], paramString2);
    return paramContext;
  }
  
  public static Object a(QQAppInterface paramQQAppInterface, String paramString)
    throws IOException, ClassNotFoundException
  {
    paramQQAppInterface = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0).getString(paramString + paramQQAppInterface.getCurrentAccountUin(), "");
    if (TextUtils.isEmpty(paramQQAppInterface)) {
      return null;
    }
    paramQQAppInterface = new ByteArrayInputStream(Base64.decode(paramQQAppInterface.getBytes(), 0));
    paramString = new ObjectInputStream(paramQQAppInterface);
    Object localObject = paramString.readObject();
    paramQQAppInterface.close();
    paramString.close();
    return localObject;
  }
  
  public static boolean a(FeedsItemData.RedInfo paramRedInfo)
  {
    if ((paramRedInfo == null) || (TextUtils.isEmpty(paramRedInfo.redPointId))) {}
    long l;
    do
    {
      return false;
      if (H == null) {
        H = new ArrayDeque(100);
      }
      l = System.currentTimeMillis() / 1000L;
    } while ((paramRedInfo.redPointStartTime >= l) || (paramRedInfo.redPointEndTime <= l) || (H.contains(paramRedInfo.redPointId)));
    return true;
  }
  
  /* Error */
  public static String b(MessageRecord paramMessageRecord, int paramInt)
  {
    // Byte code:
    //   0: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   3: ifeq +30 -> 33
    //   6: ldc_w 283
    //   9: iconst_1
    //   10: new 197	java/lang/StringBuilder
    //   13: dup
    //   14: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   17: ldc_w 285
    //   20: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: iload_1
    //   24: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   27: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   30: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   33: aload_0
    //   34: ifnonnull +10 -> 44
    //   37: ldc 211
    //   39: astore 7
    //   41: aload 7
    //   43: areturn
    //   44: ldc 211
    //   46: astore 8
    //   48: ldc 211
    //   50: astore 11
    //   52: ldc 211
    //   54: astore 9
    //   56: aload_0
    //   57: invokestatic 296	ahtz:t	(Lcom/tencent/mobileqq/data/MessageRecord;)Ljava/lang/String;
    //   60: astore 12
    //   62: iload_1
    //   63: ifne +565 -> 628
    //   66: new 197	java/lang/StringBuilder
    //   69: dup
    //   70: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   73: aload 12
    //   75: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: ldc_w 298
    //   81: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: astore 7
    //   89: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   92: aload 7
    //   94: invokeinterface 303 2 0
    //   99: ifeq +74 -> 173
    //   102: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   105: aload 7
    //   107: invokeinterface 307 2 0
    //   112: checkcast 221	java/lang/String
    //   115: astore 10
    //   117: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   120: ifeq +41 -> 161
    //   123: ldc_w 283
    //   126: iconst_1
    //   127: new 197	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 309
    //   137: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_1
    //   141: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 311
    //   147: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: aload 10
    //   152: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   155: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   158: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   161: aload 10
    //   163: astore 7
    //   165: aload 10
    //   167: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   170: ifeq -129 -> 41
    //   173: aload_0
    //   174: getfield 316	com/tencent/mobileqq/data/MessageRecord:extStr	Ljava/lang/String;
    //   177: astore 7
    //   179: aload 7
    //   181: astore 10
    //   183: aload 7
    //   185: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   188: ifeq +12 -> 200
    //   191: aload_0
    //   192: getfield 320	com/tencent/mobileqq/data/MessageRecord:mExJsonObject	Lorg/json/JSONObject;
    //   195: invokevirtual 323	org/json/JSONObject:toString	()Ljava/lang/String;
    //   198: astore 10
    //   200: aload 8
    //   202: astore 7
    //   204: aload 10
    //   206: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   209: ifne +702 -> 911
    //   212: aload 8
    //   214: astore 7
    //   216: new 322	org/json/JSONObject
    //   219: dup
    //   220: aload 10
    //   222: invokespecial 325	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   225: ldc_w 327
    //   228: ldc 211
    //   230: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   233: astore 10
    //   235: aload 8
    //   237: astore 7
    //   239: aload 10
    //   241: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   244: ifne +499 -> 743
    //   247: aload 8
    //   249: astore 7
    //   251: new 322	org/json/JSONObject
    //   254: dup
    //   255: aload 10
    //   257: invokespecial 325	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   260: ldc_w 332
    //   263: ldc 211
    //   265: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   268: astore 10
    //   270: aload 8
    //   272: astore 7
    //   274: aload 10
    //   276: invokestatic 58	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   279: ifne +950 -> 1229
    //   282: aload 8
    //   284: astore 7
    //   286: new 322	org/json/JSONObject
    //   289: dup
    //   290: aload 10
    //   292: invokespecial 325	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   295: astore 11
    //   297: aload 8
    //   299: astore 7
    //   301: aload 11
    //   303: ldc_w 334
    //   306: invokevirtual 338	org/json/JSONObject:optJSONArray	(Ljava/lang/String;)Lorg/json/JSONArray;
    //   309: astore 10
    //   311: aload 10
    //   313: ifnull +909 -> 1222
    //   316: aload 8
    //   318: astore 7
    //   320: aload 10
    //   322: invokevirtual 341	org/json/JSONArray:toString	()Ljava/lang/String;
    //   325: astore 9
    //   327: aload 8
    //   329: astore 7
    //   331: aload 10
    //   333: iconst_0
    //   334: invokevirtual 345	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   337: ldc_w 347
    //   340: ldc 211
    //   342: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   345: astore 8
    //   347: aload 8
    //   349: astore 7
    //   351: aload 10
    //   353: iconst_1
    //   354: invokevirtual 345	org/json/JSONArray:optJSONObject	(I)Lorg/json/JSONObject;
    //   357: ldc_w 349
    //   360: ldc 211
    //   362: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   365: astore 10
    //   367: aload 8
    //   369: astore 7
    //   371: aload 11
    //   373: ldc_w 351
    //   376: ldc 211
    //   378: invokevirtual 330	org/json/JSONObject:optString	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   381: astore 11
    //   383: aload 8
    //   385: astore 7
    //   387: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   390: new 197	java/lang/StringBuilder
    //   393: dup
    //   394: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   397: aload 12
    //   399: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   402: ldc_w 298
    //   405: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   411: aload 8
    //   413: invokeinterface 355 3 0
    //   418: pop
    //   419: aload 8
    //   421: astore 7
    //   423: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   426: new 197	java/lang/StringBuilder
    //   429: dup
    //   430: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   433: aload 12
    //   435: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   438: ldc_w 357
    //   441: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   444: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   447: aload 10
    //   449: invokeinterface 355 3 0
    //   454: pop
    //   455: aload 8
    //   457: astore 7
    //   459: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   462: new 197	java/lang/StringBuilder
    //   465: dup
    //   466: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   469: aload 12
    //   471: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   474: ldc_w 359
    //   477: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: aload 11
    //   485: invokeinterface 355 3 0
    //   490: pop
    //   491: aload 8
    //   493: astore 7
    //   495: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   498: new 197	java/lang/StringBuilder
    //   501: dup
    //   502: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   505: aload 12
    //   507: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   510: ldc_w 361
    //   513: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   516: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   519: aload 9
    //   521: invokeinterface 355 3 0
    //   526: pop
    //   527: aload 8
    //   529: astore 7
    //   531: aload 10
    //   533: astore 8
    //   535: aload 11
    //   537: astore 10
    //   539: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   542: ifeq +74 -> 616
    //   545: ldc_w 283
    //   548: iconst_1
    //   549: new 197	java/lang/StringBuilder
    //   552: dup
    //   553: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   556: ldc_w 363
    //   559: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   562: iload_1
    //   563: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   566: ldc_w 365
    //   569: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   572: aload 7
    //   574: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   577: ldc_w 367
    //   580: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   583: aload 8
    //   585: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: ldc_w 369
    //   591: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   594: aload 10
    //   596: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   599: ldc_w 371
    //   602: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   605: aload 9
    //   607: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   610: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   613: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   616: iload_1
    //   617: ifeq -576 -> 41
    //   620: iload_1
    //   621: iconst_1
    //   622: if_icmpne +102 -> 724
    //   625: aload 8
    //   627: areturn
    //   628: iload_1
    //   629: iconst_1
    //   630: if_icmpne +29 -> 659
    //   633: new 197	java/lang/StringBuilder
    //   636: dup
    //   637: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   640: aload 12
    //   642: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   645: ldc_w 357
    //   648: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   651: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   654: astore 7
    //   656: goto -567 -> 89
    //   659: iload_1
    //   660: iconst_2
    //   661: if_icmpne +29 -> 690
    //   664: new 197	java/lang/StringBuilder
    //   667: dup
    //   668: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   671: aload 12
    //   673: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   676: ldc_w 359
    //   679: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   682: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   685: astore 7
    //   687: goto -598 -> 89
    //   690: iload_1
    //   691: iconst_4
    //   692: if_icmpne +29 -> 721
    //   695: new 197	java/lang/StringBuilder
    //   698: dup
    //   699: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   702: aload 12
    //   704: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   707: ldc_w 361
    //   710: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   713: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   716: astore 7
    //   718: goto -629 -> 89
    //   721: ldc 211
    //   723: areturn
    //   724: iload_1
    //   725: iconst_2
    //   726: if_icmpne +6 -> 732
    //   729: aload 10
    //   731: areturn
    //   732: iload_1
    //   733: iconst_4
    //   734: if_icmpne +6 -> 740
    //   737: aload 9
    //   739: areturn
    //   740: ldc 211
    //   742: areturn
    //   743: ldc 211
    //   745: astore 7
    //   747: iload_1
    //   748: ifne +423 -> 1171
    //   751: aload_0
    //   752: instanceof 373
    //   755: ifeq +197 -> 952
    //   758: aload_0
    //   759: checkcast 373	com/tencent/mobileqq/data/MessageForArkApp
    //   762: astore_0
    //   763: aload_0
    //   764: getfield 377	com/tencent/mobileqq/data/MessageForArkApp:ark_app_message	Lcom/tencent/mobileqq/data/ArkAppMessage;
    //   767: getfield 382	com/tencent/mobileqq/data/ArkAppMessage:mSourceName	Ljava/lang/String;
    //   770: astore 8
    //   772: getstatic 32	ahtz:lk	Ljava/util/Map;
    //   775: new 197	java/lang/StringBuilder
    //   778: dup
    //   779: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   782: aload 12
    //   784: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   787: ldc_w 298
    //   790: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   793: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   796: aload 8
    //   798: invokeinterface 355 3 0
    //   803: pop
    //   804: aload 8
    //   806: astore 7
    //   808: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   811: ifeq -770 -> 41
    //   814: ldc_w 283
    //   817: iconst_1
    //   818: new 197	java/lang/StringBuilder
    //   821: dup
    //   822: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   825: ldc_w 384
    //   828: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   831: iload_1
    //   832: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   835: ldc_w 365
    //   838: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   841: aload 8
    //   843: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   846: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   849: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   852: aload 8
    //   854: areturn
    //   855: astore 9
    //   857: aload 7
    //   859: astore 8
    //   861: aload 9
    //   863: invokevirtual 387	java/lang/Throwable:printStackTrace	()V
    //   866: aload 8
    //   868: astore 7
    //   870: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   873: ifeq +38 -> 911
    //   876: ldc_w 283
    //   879: iconst_1
    //   880: new 197	java/lang/StringBuilder
    //   883: dup
    //   884: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   887: ldc_w 389
    //   890: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   893: aload 9
    //   895: invokevirtual 392	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   898: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   901: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   904: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   907: aload 8
    //   909: astore 7
    //   911: goto -164 -> 747
    //   914: astore_0
    //   915: ldc_w 283
    //   918: iconst_1
    //   919: new 197	java/lang/StringBuilder
    //   922: dup
    //   923: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   926: ldc_w 394
    //   929: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   932: aload_0
    //   933: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   936: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   939: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   942: invokestatic 398	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   945: aload 7
    //   947: astore 8
    //   949: goto -177 -> 772
    //   952: aload 7
    //   954: astore 8
    //   956: aload_0
    //   957: instanceof 400
    //   960: ifeq -188 -> 772
    //   963: aload_0
    //   964: checkcast 400	com/tencent/mobileqq/data/MessageForStructing
    //   967: getfield 404	com/tencent/mobileqq/data/MessageForStructing:structingMsg	Lcom/tencent/mobileqq/structmsg/AbsStructMsg;
    //   970: checkcast 406	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare
    //   973: astore_0
    //   974: aload_0
    //   975: invokevirtual 410	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:getStructMsgItemLists	()Ljava/util/List;
    //   978: checkcast 412	java/util/ArrayList
    //   981: astore 7
    //   983: aload 7
    //   985: ifnonnull +259 -> 1244
    //   988: ldc 211
    //   990: areturn
    //   991: iload 5
    //   993: aload 7
    //   995: invokevirtual 413	java/util/ArrayList:size	()I
    //   998: if_icmpge +120 -> 1118
    //   1001: aload 7
    //   1003: iload 5
    //   1005: invokevirtual 416	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1008: instanceof 418
    //   1011: ifeq +254 -> 1265
    //   1014: aload 7
    //   1016: iload 5
    //   1018: invokevirtual 416	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1021: checkcast 418	anqv
    //   1024: checkcast 418	anqv
    //   1027: getfield 422	anqv:rz	Ljava/util/ArrayList;
    //   1030: astore 8
    //   1032: iload_1
    //   1033: istore_3
    //   1034: iload_2
    //   1035: istore_1
    //   1036: iconst_0
    //   1037: istore 6
    //   1039: iload_3
    //   1040: istore_2
    //   1041: iload_2
    //   1042: istore_3
    //   1043: iload_1
    //   1044: istore 4
    //   1046: iload 6
    //   1048: aload 8
    //   1050: invokevirtual 413	java/util/ArrayList:size	()I
    //   1053: if_icmpge +217 -> 1270
    //   1056: aload 8
    //   1058: iload 6
    //   1060: invokevirtual 416	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1063: instanceof 424
    //   1066: ifeq +30 -> 1096
    //   1069: iconst_1
    //   1070: istore_3
    //   1071: iload_3
    //   1072: ifeq +182 -> 1254
    //   1075: iload_2
    //   1076: ifeq +178 -> 1254
    //   1079: aload 7
    //   1081: iload 5
    //   1083: invokevirtual 416	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1086: checkcast 426	anqu
    //   1089: getfield 429	anqu:ku	Ljava/lang/String;
    //   1092: invokestatic 433	ahtz:lr	(Ljava/lang/String;)Ljava/lang/String;
    //   1095: areturn
    //   1096: iload_1
    //   1097: istore_3
    //   1098: aload 8
    //   1100: iload 6
    //   1102: invokevirtual 416	java/util/ArrayList:get	(I)Ljava/lang/Object;
    //   1105: instanceof 435
    //   1108: ifeq -37 -> 1071
    //   1111: iconst_1
    //   1112: istore_2
    //   1113: iload_1
    //   1114: istore_3
    //   1115: goto -44 -> 1071
    //   1118: aload 7
    //   1120: invokevirtual 413	java/util/ArrayList:size	()I
    //   1123: iconst_2
    //   1124: if_icmpne +44 -> 1168
    //   1127: aload_0
    //   1128: getfield 438	com/tencent/mobileqq/structmsg/StructMsgForGeneralShare:mMsgUrl	Ljava/lang/String;
    //   1131: invokestatic 433	ahtz:lr	(Ljava/lang/String;)Ljava/lang/String;
    //   1134: astore_0
    //   1135: aload_0
    //   1136: areturn
    //   1137: astore_0
    //   1138: ldc_w 283
    //   1141: iconst_1
    //   1142: new 197	java/lang/StringBuilder
    //   1145: dup
    //   1146: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1149: ldc_w 440
    //   1152: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1155: aload_0
    //   1156: invokevirtual 395	java/lang/Throwable:toString	()Ljava/lang/String;
    //   1159: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1162: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1165: invokestatic 398	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   1168: ldc 211
    //   1170: areturn
    //   1171: invokestatic 281	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   1174: ifeq +36 -> 1210
    //   1177: ldc_w 283
    //   1180: iconst_1
    //   1181: new 197	java/lang/StringBuilder
    //   1184: dup
    //   1185: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   1188: ldc_w 384
    //   1191: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1194: iload_1
    //   1195: invokevirtual 288	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1198: ldc_w 442
    //   1201: invokevirtual 202	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1204: invokevirtual 209	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1207: invokestatic 292	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   1210: ldc 211
    //   1212: areturn
    //   1213: astore 9
    //   1215: aload 7
    //   1217: astore 8
    //   1219: goto -358 -> 861
    //   1222: ldc 211
    //   1224: astore 10
    //   1226: goto -859 -> 367
    //   1229: ldc 211
    //   1231: astore 7
    //   1233: ldc 211
    //   1235: astore 8
    //   1237: aload 11
    //   1239: astore 10
    //   1241: goto -702 -> 539
    //   1244: iconst_0
    //   1245: istore 5
    //   1247: iconst_0
    //   1248: istore_1
    //   1249: iconst_0
    //   1250: istore_2
    //   1251: goto -260 -> 991
    //   1254: iload 6
    //   1256: iconst_1
    //   1257: iadd
    //   1258: istore 6
    //   1260: iload_3
    //   1261: istore_1
    //   1262: goto -221 -> 1041
    //   1265: iload_2
    //   1266: istore 4
    //   1268: iload_1
    //   1269: istore_3
    //   1270: iload 5
    //   1272: iconst_1
    //   1273: iadd
    //   1274: istore 5
    //   1276: iload 4
    //   1278: istore_2
    //   1279: iload_3
    //   1280: istore_1
    //   1281: goto -290 -> 991
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1284	0	paramMessageRecord	MessageRecord
    //   0	1284	1	paramInt	int
    //   1034	245	2	i	int
    //   1033	247	3	j	int
    //   1044	233	4	k	int
    //   991	284	5	m	int
    //   1037	222	6	n	int
    //   39	1193	7	localObject1	Object
    //   46	1190	8	localObject2	Object
    //   54	684	9	str1	String
    //   855	39	9	localThrowable1	Throwable
    //   1213	1	9	localThrowable2	Throwable
    //   115	1125	10	localObject3	Object
    //   50	1188	11	localObject4	Object
    //   60	723	12	str2	String
    // Exception table:
    //   from	to	target	type
    //   216	235	855	java/lang/Throwable
    //   239	247	855	java/lang/Throwable
    //   251	270	855	java/lang/Throwable
    //   274	282	855	java/lang/Throwable
    //   286	297	855	java/lang/Throwable
    //   301	311	855	java/lang/Throwable
    //   320	327	855	java/lang/Throwable
    //   331	347	855	java/lang/Throwable
    //   351	367	855	java/lang/Throwable
    //   371	383	855	java/lang/Throwable
    //   387	419	855	java/lang/Throwable
    //   423	455	855	java/lang/Throwable
    //   459	491	855	java/lang/Throwable
    //   495	527	855	java/lang/Throwable
    //   763	772	914	java/lang/Throwable
    //   963	983	1137	java/lang/Throwable
    //   991	1032	1137	java/lang/Throwable
    //   1046	1069	1137	java/lang/Throwable
    //   1079	1096	1137	java/lang/Throwable
    //   1098	1111	1137	java/lang/Throwable
    //   1118	1135	1137	java/lang/Throwable
    //   539	616	1213	java/lang/Throwable
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, Object paramObject)
    throws IOException
  {
    if (paramObject == null) {
      return;
    }
    Object localObject = new ByteArrayOutputStream();
    ObjectOutputStream localObjectOutputStream = new ObjectOutputStream((OutputStream)localObject);
    localObjectOutputStream.writeObject(paramObject);
    paramObject = new String(Base64.encode(((ByteArrayOutputStream)localObject).toByteArray(), 0));
    ((ByteArrayOutputStream)localObject).close();
    localObjectOutputStream.close();
    localObject = paramQQAppInterface.getApp().getSharedPreferences("game_center_sp", 0);
    paramQQAppInterface = paramString + paramQQAppInterface.getCurrentAccountUin();
    ((SharedPreferences)localObject).edit().putString(paramQQAppInterface, paramObject).commit();
  }
  
  public static void b(String paramString1, String paramString2, String paramString3, Context paramContext)
  {
    if (TextUtils.isEmpty(paramString3))
    {
      QLog.e("QQGameConstant", 1, "[launchAppWithTokens] ticket is null");
      QQToast.a(paramContext, 1, acfp.m(2131711698), 0).show(0);
      return;
    }
    paramString3 = "big_brother_source_key=biz_src_zf_games&platform=qq_m&current_uin=$OPID$&user_openid=$OPID$&openid=$OPID$&launchfrom=sq_gamecenter&gamedata=&platformdata=&" + paramString3;
    anan localanan = new anan();
    AppInterface localAppInterface = abmt.getAppInterface();
    localanan.a(localAppInterface, paramContext, paramString1, paramString3, paramString2, 536870912);
    ((aqrb)localAppInterface.getBusinessHandler(71)).ab(paramString1, localAppInterface.getCurrentAccountUin(), 1);
  }
  
  public static void bA(Context paramContext, String paramString)
  {
    apuh.a(paramContext, TroopInfoActivity.c(paramString, 3001), 2);
  }
  
  public static ColorStateList c(int paramInt1, int paramInt2)
  {
    int[] arrayOfInt = { 16842910 };
    return new ColorStateList(new int[][] { { 16842919 }, arrayOfInt }, new int[] { paramInt2, paramInt1 });
  }
  
  public static String lr(String paramString)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (!TextUtils.isEmpty(paramString))
    {
      localObject1 = localObject2;
      if (!paramString.contains("pubAccountAppid")) {}
    }
    try
    {
      localObject1 = Uri.parse(paramString).getQueryParameter("pubAccountAppid");
      return localObject1;
    }
    catch (Exception paramString)
    {
      QLog.e("QQGameConstant", 1, "getappid error=" + paramString.toString());
    }
    return null;
  }
  
  public static String t(MessageRecord paramMessageRecord)
  {
    String str2 = "";
    String str1 = str2;
    try
    {
      Object localObject = paramMessageRecord.extStr;
      paramMessageRecord = str2;
      str1 = str2;
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        str1 = str2;
        localObject = new JSONObject((String)localObject);
        str1 = str2;
        str2 = ((JSONObject)localObject).optString("public_account_msg_id", "");
        paramMessageRecord = str2;
        str1 = str2;
        if (TextUtils.isEmpty(str2))
        {
          str1 = str2;
          paramMessageRecord = ((JSONObject)localObject).optString("pa_msgId", "");
        }
      }
      return paramMessageRecord;
    }
    catch (Throwable paramMessageRecord)
    {
      QLog.e("QQGameConstant", 1, "getPAMsgId error =" + paramMessageRecord.toString());
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahtz
 * JD-Core Version:    0.7.0.1
 */