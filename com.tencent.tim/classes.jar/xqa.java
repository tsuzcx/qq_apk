import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.biz.troopgift.TroopGiftPanel;
import com.tencent.common.config.AppSetting;
import com.tencent.image.RegionDrawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder;
import com.tencent.mobileqq.activity.aio.BaseBubbleBuilder.e;
import com.tencent.mobileqq.activity.aio.BaseChatItemLayout;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.aio.anim.AIOAnimationConatiner;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.2;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.3;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.4;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.8;
import com.tencent.mobileqq.activity.aio.item.TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import com.tencent.mobileqq.data.MessageForTroopGift;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.widget.BubbleImageView;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XEditTextEx;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.NotNull;

public abstract class xqa
  extends BaseBubbleBuilder
{
  public static String aVR = "TroopGiftMsgItemBuilder";
  private static int bWk = 101;
  private static int bWl = 102;
  public static List<MessageForTroopGift> sg = new LinkedList();
  BaseChatPie a;
  AtomicInteger aF = new AtomicInteger(0);
  Handler bU = new xqb(this);
  Map<String, Boolean> hP = new HashMap();
  public Map<String, ArrayList<Runnable>> hQ = new HashMap();
  
  public xqa(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
  {
    super(paramQQAppInterface, paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner);
    this.a = paramBaseChatPie;
  }
  
  @NotNull
  private Bitmap a(Bitmap paramBitmap, BubbleImageView paramBubbleImageView, int paramInt)
  {
    Object localObject1 = this.app.getApp().getResources().getDisplayMetrics();
    Object localObject2 = new Matrix();
    ((Matrix)localObject2).postScale(1.0F, 1.0F);
    int i = paramBitmap.getWidth();
    int j = paramBitmap.getHeight();
    paramBitmap = Bitmap.createBitmap(paramBitmap, (int)(i * 0.357D), (int)(j * 0.357D), (int)((i - 1) * 0.642D), (int)((j - 1) * 0.642D), (Matrix)localObject2, true);
    i = paramBubbleImageView.getLayoutParams().width;
    j = (int)(150.0F * ((DisplayMetrics)localObject1).density);
    paramBubbleImageView = Bitmap.createBitmap(i, j, Bitmap.Config.ARGB_4444);
    localObject2 = new Canvas(paramBubbleImageView);
    localObject1 = new Paint();
    ((Paint)localObject1).setColor(-1);
    ((Canvas)localObject2).drawRect(0.0F, 0.0F, i, j, (Paint)localObject1);
    if (paramInt != 0)
    {
      localObject2 = new Canvas(paramBubbleImageView);
      ((Canvas)localObject2).drawBitmap(paramBitmap, new Rect(0, 0, paramBitmap.getWidth(), paramBitmap.getHeight()), new Rect(0, 0, i, j), (Paint)localObject1);
      ((Paint)localObject1).setColor(paramInt);
      ((Canvas)localObject2).drawRect(0.0F, 0.0F, paramBubbleImageView.getWidth(), paramBubbleImageView.getHeight(), (Paint)localObject1);
      aqmp.fastblur(paramBubbleImageView, 60);
    }
    return paramBubbleImageView;
  }
  
  @NotNull
  private MessageForTroopGift a(MessageForTroopGift paramMessageForTroopGift, xqa.b paramb)
  {
    boolean bool = jof.a().dd(this.sessionInfo.aTl);
    if (paramMessageForTroopGift.senderUin != this.app.getLongAccountUin())
    {
      if (paramMessageForTroopGift.receiverUin != this.app.getLongAccountUin()) {
        break label306;
      }
      paramb.dt.setVisibility(8);
      paramb.ds.setVisibility(0);
      paramb.du.setVisibility(8);
    }
    for (;;)
    {
      if ((paramMessageForTroopGift.btFlag == 0) || (bool))
      {
        paramb.dt.setVisibility(8);
        paramb.ds.setVisibility(8);
      }
      if (paramMessageForTroopGift.btFlag == 1) {
        paramb.dt.setVisibility(8);
      }
      if (paramMessageForTroopGift.btFlag == 2) {
        paramb.ds.setVisibility(8);
      }
      if (((paramMessageForTroopGift.receiverUin != this.app.getLongAccountUin()) || (paramMessageForTroopGift.senderUin == this.app.getLongAccountUin()) || ((paramMessageForTroopGift.receiverUin == this.app.getLongAccountUin()) && (paramMessageForTroopGift.btFlag == 0))) && (paramMessageForTroopGift.is_activity_gift == 1) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_text_color)) && (!TextUtils.isEmpty(paramMessageForTroopGift.activity_url)))
      {
        paramb.du.setVisibility(0);
        paramb.dt.setVisibility(8);
        paramb.ds.setVisibility(8);
        paramb.dV.setText(paramMessageForTroopGift.activity_text);
        paramb.dV.setTextColor(Color.parseColor(paramMessageForTroopGift.activity_text_color));
      }
      return paramMessageForTroopGift;
      paramb.dt.setVisibility(8);
      paramb.ds.setVisibility(8);
      paramb.du.setVisibility(8);
      continue;
      label306:
      paramb.dt.setVisibility(0);
      paramb.ds.setVisibility(8);
      paramb.du.setVisibility(8);
    }
  }
  
  private void a(MessageForTroopGift paramMessageForTroopGift)
  {
    int i;
    if (!paramMessageForTroopGift.isReported)
    {
      paramMessageForTroopGift.isReported = true;
      sg.add(paramMessageForTroopGift);
      if (!this.app.getCurrentUin().equals(paramMessageForTroopGift.senderuin)) {
        break label85;
      }
      i = 0;
    }
    for (;;)
    {
      if (paramMessageForTroopGift.istroop == 0) {
        anot.a(this.app, "dc00899", "Grp_flower", "", "C2C", "exp_obj", 0, 0, "", "", "", "");
      }
      label85:
      do
      {
        return;
        if (!this.app.getCurrentUin().equals(Long.valueOf(paramMessageForTroopGift.receiverUin))) {
          break label489;
        }
        i = 1;
        break;
        if (paramMessageForTroopGift.istroop == 3000)
        {
          anot.a(this.app, "dc00899", "Grp_flower", "", "discuss_grp", "exp_obj", 0, 0, "", "", "", "");
          return;
        }
        if ((paramMessageForTroopGift.istroop == 1000) || (paramMessageForTroopGift.istroop == 1004))
        {
          anot.a(this.app, "dc00899", "Grp_flower", "", "temp_c2c", "exp_obj", 0, 0, "", "", "", "");
          return;
        }
        if (!paramMessageForTroopGift.isFromNearby) {
          break label313;
        }
        acie.i("gift_aio", "exp_obj", this.sessionInfo.aTl, i + "", "", "");
      } while (!aptj.c(paramMessageForTroopGift));
      acie.i("gift_aio", "exp_play", this.sessionInfo.aTl, i + "", "", "");
      return;
      label313:
      if (jof.a(paramMessageForTroopGift)) {}
      for (int j = 2;; j = 1)
      {
        anot.a(this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_obj", j, 0, this.sessionInfo.aTl, i + "", paramMessageForTroopGift.giftPicId + "", "");
        if (!aptj.c(paramMessageForTroopGift)) {
          break;
        }
        anot.a(this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "exp_play", j, 0, this.sessionInfo.aTl, i + "", paramMessageForTroopGift.giftPicId + "", "");
        return;
      }
      label489:
      i = 2;
    }
  }
  
  private void a(BubbleImageView paramBubbleImageView, int paramInt, String paramString)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = new ColorDrawable(paramInt);
    localURLDrawableOptions.mLoadingDrawable = new ColorDrawable(paramInt);
    paramBubbleImageView.setImageDrawable(URLDrawable.getDrawable(new File(W(paramString, paramInt)), localURLDrawableOptions));
  }
  
  private void a(BubbleImageView paramBubbleImageView, String paramString, int paramInt)
  {
    if (paramBubbleImageView.getTag(2131374463).equals(paramString)) {
      a(paramBubbleImageView, paramInt, paramString);
    }
  }
  
  private void a(String paramString1, int paramInt, Bitmap paramBitmap, BubbleImageView paramBubbleImageView, String paramString2, SharedPreferences paramSharedPreferences, long paramLong)
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.i("arendgx_createGiftBg", 2, "path:" + W(paramString1, paramInt));
      }
      if (a(a(paramBitmap, paramBubbleImageView, paramInt), paramString1, paramInt, paramString2))
      {
        paramSharedPreferences.edit().putLong(paramString2, paramLong);
        paramSharedPreferences.edit().commit();
      }
      sHandler.post(new TroopGiftMsgItemBuilder.4(this, paramString2, paramBubbleImageView, paramString1, paramInt));
      return;
    }
    catch (Exception paramString1)
    {
      paramSharedPreferences.edit().putLong(paramString2, 0L);
      paramSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
      return;
    }
    catch (OutOfMemoryError paramString1)
    {
      paramSharedPreferences.edit().putLong(paramString2, 0L);
      paramSharedPreferences.edit().commit();
      if (QLog.isColorLevel()) {
        QLog.d("ChatItemBuilder", 2, paramString1.getMessage());
      }
      return;
    }
    finally
    {
      this.hP.put(paramString2, Boolean.valueOf(false));
    }
  }
  
  private void a(xqa.b paramb)
  {
    if (((paramb.ds.getVisibility() == 8) && (paramb.dt.getVisibility() == 8) && (paramb.du.getVisibility() == 8)) || (this.bdn)) {}
    for (paramb.l.getLayoutParams().height = ((int)(100.0F * this.mDensity));; paramb.l.getLayoutParams().height = ((int)(142.0F * this.mDensity)))
    {
      if (this.bdn)
      {
        paramb.dt.setVisibility(8);
        paramb.ds.setVisibility(8);
        paramb.dt.setVisibility(8);
      }
      return;
    }
  }
  
  private void a(xqa.b paramb, MessageForTroopGift paramMessageForTroopGift)
  {
    if ((AppSetting.enableTalkBack) && (!TextUtils.isEmpty(paramMessageForTroopGift.title)))
    {
      String str = paramMessageForTroopGift.title;
      paramMessageForTroopGift = str;
      if (paramb.Ka != null)
      {
        paramMessageForTroopGift = str;
        if (!TextUtils.isEmpty(paramb.Ka.getText())) {
          paramMessageForTroopGift = str + paramb.Ka.getText().toString();
        }
      }
      paramb.l.setContentDescription(paramMessageForTroopGift);
    }
  }
  
  private void a(xqa.b paramb, MessageForTroopGift paramMessageForTroopGift, URLDrawable paramURLDrawable)
  {
    if ((paramURLDrawable != null) && (paramURLDrawable.getStatus() == 2)) {
      paramURLDrawable.restartDownload();
    }
    label140:
    label141:
    for (;;)
    {
      return;
      if (paramURLDrawable != null)
      {
        int i;
        if ((paramURLDrawable.getCurrDrawable() instanceof RegionDrawable))
        {
          i = paramMessageForTroopGift.objColor;
          if (i != 0) {
            break label140;
          }
          i = -2138570752;
        }
        for (;;)
        {
          if (!TextUtils.isEmpty(paramMessageForTroopGift.interactId)) {
            break label141;
          }
          a(((RegionDrawable)paramURLDrawable.getCurrDrawable()).getBitmap(), i, paramb.l, paramMessageForTroopGift.giftPicId + "");
          return;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.e("TroopGiftMsgItemBuilder", 2, "drawable.getCurrDrawable() instanceof  RegionDrawable = " + (paramURLDrawable.getCurrDrawable() instanceof RegionDrawable));
          return;
        }
      }
    }
  }
  
  /* Error */
  private boolean a(Bitmap paramBitmap, String paramString1, int paramInt, String paramString2)
  {
    // Byte code:
    //   0: new 389	java/io/File
    //   3: dup
    //   4: new 336	java/lang/StringBuilder
    //   7: dup
    //   8: invokespecial 337	java/lang/StringBuilder:<init>	()V
    //   11: getstatic 582	acbn:SDCARD_PATH	Ljava/lang/String;
    //   14: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: ldc_w 584
    //   20: invokevirtual 344	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   23: invokevirtual 347	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: invokestatic 590	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   29: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   32: invokevirtual 593	java/io/File:mkdirs	()Z
    //   35: pop
    //   36: new 389	java/io/File
    //   39: dup
    //   40: aload_0
    //   41: aload_2
    //   42: iload_3
    //   43: invokevirtual 393	xqa:W	(Ljava/lang/String;I)Ljava/lang/String;
    //   46: invokespecial 396	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 9
    //   51: aload 9
    //   53: invokevirtual 596	java/io/File:exists	()Z
    //   56: ifne +9 -> 65
    //   59: aload 9
    //   61: invokevirtual 599	java/io/File:createNewFile	()Z
    //   64: pop
    //   65: aconst_null
    //   66: astore 7
    //   68: aconst_null
    //   69: astore 8
    //   71: new 601	java/io/BufferedOutputStream
    //   74: dup
    //   75: new 603	java/io/FileOutputStream
    //   78: dup
    //   79: aload 9
    //   81: invokespecial 606	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   84: sipush 8192
    //   87: invokespecial 609	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;I)V
    //   90: astore_2
    //   91: aload_2
    //   92: astore 7
    //   94: aload_1
    //   95: getstatic 615	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   98: bipush 100
    //   100: aload_2
    //   101: invokevirtual 619	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   104: istore 6
    //   106: aload_0
    //   107: getfield 81	xqa:hP	Ljava/util/Map;
    //   110: aload 4
    //   112: iconst_0
    //   113: invokestatic 474	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   116: invokeinterface 480 3 0
    //   121: pop
    //   122: iload 6
    //   124: istore 5
    //   126: aload_2
    //   127: ifnull +11 -> 138
    //   130: aload_2
    //   131: invokevirtual 622	java/io/BufferedOutputStream:close	()V
    //   134: iload 6
    //   136: istore 5
    //   138: iload 5
    //   140: ifne +56 -> 196
    //   143: aload 9
    //   145: invokevirtual 596	java/io/File:exists	()Z
    //   148: ifeq +48 -> 196
    //   151: aload 9
    //   153: invokevirtual 625	java/io/File:delete	()Z
    //   156: pop
    //   157: aload_0
    //   158: getfield 629	xqa:mContext	Landroid/content/Context;
    //   161: getstatic 53	xqa:aVR	Ljava/lang/String;
    //   164: iconst_0
    //   165: invokevirtual 635	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   168: astore_1
    //   169: aload_1
    //   170: invokeinterface 446 1 0
    //   175: aload 4
    //   177: lconst_0
    //   178: invokeinterface 452 4 0
    //   183: pop
    //   184: aload_1
    //   185: invokeinterface 446 1 0
    //   190: invokeinterface 455 1 0
    //   195: pop
    //   196: iload 5
    //   198: ireturn
    //   199: astore_2
    //   200: aload_2
    //   201: invokevirtual 638	java/io/IOException:printStackTrace	()V
    //   204: goto -139 -> 65
    //   207: astore_1
    //   208: iload 6
    //   210: istore 5
    //   212: invokestatic 428	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   215: ifeq -77 -> 138
    //   218: ldc_w 482
    //   221: iconst_2
    //   222: aload_1
    //   223: invokevirtual 639	java/io/IOException:getMessage	()Ljava/lang/String;
    //   226: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   229: iload 6
    //   231: istore 5
    //   233: goto -95 -> 138
    //   236: astore_1
    //   237: aconst_null
    //   238: astore_2
    //   239: aload_2
    //   240: astore 7
    //   242: aload_0
    //   243: getfield 629	xqa:mContext	Landroid/content/Context;
    //   246: getstatic 53	xqa:aVR	Ljava/lang/String;
    //   249: iconst_0
    //   250: invokevirtual 635	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   253: astore 8
    //   255: aload_2
    //   256: astore 7
    //   258: aload 8
    //   260: invokeinterface 446 1 0
    //   265: aload 4
    //   267: lconst_0
    //   268: invokeinterface 452 4 0
    //   273: pop
    //   274: aload_2
    //   275: astore 7
    //   277: aload 8
    //   279: invokeinterface 446 1 0
    //   284: invokeinterface 455 1 0
    //   289: pop
    //   290: aload_2
    //   291: astore 7
    //   293: invokestatic 428	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   296: ifeq +17 -> 313
    //   299: aload_2
    //   300: astore 7
    //   302: ldc_w 482
    //   305: iconst_2
    //   306: aload_1
    //   307: invokevirtual 485	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   310: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   313: aload_0
    //   314: getfield 81	xqa:hP	Ljava/util/Map;
    //   317: aload 4
    //   319: iconst_0
    //   320: invokestatic 474	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   323: invokeinterface 480 3 0
    //   328: pop
    //   329: aload_2
    //   330: ifnull +237 -> 567
    //   333: aload_2
    //   334: invokevirtual 622	java/io/BufferedOutputStream:close	()V
    //   337: iconst_0
    //   338: istore 5
    //   340: goto -202 -> 138
    //   343: astore_1
    //   344: invokestatic 428	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   347: ifeq +14 -> 361
    //   350: ldc_w 482
    //   353: iconst_2
    //   354: aload_1
    //   355: invokevirtual 639	java/io/IOException:getMessage	()Ljava/lang/String;
    //   358: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   361: iconst_0
    //   362: istore 5
    //   364: goto -226 -> 138
    //   367: astore_2
    //   368: aload 8
    //   370: astore_1
    //   371: aload_1
    //   372: astore 7
    //   374: aload_0
    //   375: getfield 629	xqa:mContext	Landroid/content/Context;
    //   378: getstatic 53	xqa:aVR	Ljava/lang/String;
    //   381: iconst_0
    //   382: invokevirtual 635	android/content/Context:getSharedPreferences	(Ljava/lang/String;I)Landroid/content/SharedPreferences;
    //   385: astore 8
    //   387: aload_1
    //   388: astore 7
    //   390: aload 8
    //   392: invokeinterface 446 1 0
    //   397: aload 4
    //   399: lconst_0
    //   400: invokeinterface 452 4 0
    //   405: pop
    //   406: aload_1
    //   407: astore 7
    //   409: aload 8
    //   411: invokeinterface 446 1 0
    //   416: invokeinterface 455 1 0
    //   421: pop
    //   422: aload_1
    //   423: astore 7
    //   425: invokestatic 428	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   428: ifeq +17 -> 445
    //   431: aload_1
    //   432: astore 7
    //   434: ldc_w 482
    //   437: iconst_2
    //   438: aload_2
    //   439: invokevirtual 488	java/lang/OutOfMemoryError:getMessage	()Ljava/lang/String;
    //   442: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   445: aload_0
    //   446: getfield 81	xqa:hP	Ljava/util/Map;
    //   449: aload 4
    //   451: iconst_0
    //   452: invokestatic 474	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   455: invokeinterface 480 3 0
    //   460: pop
    //   461: aload_1
    //   462: ifnull +105 -> 567
    //   465: aload_1
    //   466: invokevirtual 622	java/io/BufferedOutputStream:close	()V
    //   469: iconst_0
    //   470: istore 5
    //   472: goto -334 -> 138
    //   475: astore_1
    //   476: invokestatic 428	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   479: ifeq +14 -> 493
    //   482: ldc_w 482
    //   485: iconst_2
    //   486: aload_1
    //   487: invokevirtual 639	java/io/IOException:getMessage	()Ljava/lang/String;
    //   490: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   493: iconst_0
    //   494: istore 5
    //   496: goto -358 -> 138
    //   499: astore_1
    //   500: aload_0
    //   501: getfield 81	xqa:hP	Ljava/util/Map;
    //   504: aload 4
    //   506: iconst_0
    //   507: invokestatic 474	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   510: invokeinterface 480 3 0
    //   515: pop
    //   516: aload 7
    //   518: ifnull +8 -> 526
    //   521: aload 7
    //   523: invokevirtual 622	java/io/BufferedOutputStream:close	()V
    //   526: aload_1
    //   527: athrow
    //   528: astore_2
    //   529: invokestatic 428	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   532: ifeq -6 -> 526
    //   535: ldc_w 482
    //   538: iconst_2
    //   539: aload_2
    //   540: invokevirtual 639	java/io/IOException:getMessage	()Ljava/lang/String;
    //   543: invokestatic 487	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   546: goto -20 -> 526
    //   549: astore_1
    //   550: goto -50 -> 500
    //   553: astore 7
    //   555: aload_2
    //   556: astore_1
    //   557: aload 7
    //   559: astore_2
    //   560: goto -189 -> 371
    //   563: astore_1
    //   564: goto -325 -> 239
    //   567: iconst_0
    //   568: istore 5
    //   570: goto -432 -> 138
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	573	0	this	xqa
    //   0	573	1	paramBitmap	Bitmap
    //   0	573	2	paramString1	String
    //   0	573	3	paramInt	int
    //   0	573	4	paramString2	String
    //   124	445	5	bool1	boolean
    //   104	126	6	bool2	boolean
    //   66	456	7	localObject	Object
    //   553	5	7	localOutOfMemoryError	OutOfMemoryError
    //   69	341	8	localSharedPreferences	SharedPreferences
    //   49	103	9	localFile	File
    // Exception table:
    //   from	to	target	type
    //   59	65	199	java/io/IOException
    //   130	134	207	java/io/IOException
    //   71	91	236	java/lang/Exception
    //   333	337	343	java/io/IOException
    //   71	91	367	java/lang/OutOfMemoryError
    //   465	469	475	java/io/IOException
    //   71	91	499	finally
    //   374	387	499	finally
    //   390	406	499	finally
    //   409	422	499	finally
    //   425	431	499	finally
    //   434	445	499	finally
    //   521	526	528	java/io/IOException
    //   94	106	549	finally
    //   242	255	549	finally
    //   258	274	549	finally
    //   277	290	549	finally
    //   293	299	549	finally
    //   302	313	549	finally
    //   94	106	553	java/lang/OutOfMemoryError
    //   94	106	563	java/lang/Exception
  }
  
  public static void aV(QQAppInterface paramQQAppInterface)
  {
    if (!sg.isEmpty()) {
      ThreadManager.post(new TroopGiftMsgItemBuilder.8(paramQQAppInterface.a().createEntityManager()), 5, null, true);
    }
  }
  
  private void b(xqa.b paramb, MessageForTroopGift paramMessageForTroopGift)
  {
    if (paramb.ds.getVisibility() == 0)
    {
      new anov(this.app).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_tks").a(0).a(new String[] { paramMessageForTroopGift.frienduin + "", "" }).report();
      new anov(this.app).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_return").a(0).a(new String[] { paramMessageForTroopGift.frienduin + "", "" }).report();
    }
    if (paramb.dt.getVisibility() == 0) {
      new anov(this.app).a("dc00899").b("Grp_flower").c("grp_aio").d("exp_ask").a(0).a(new String[] { paramMessageForTroopGift.frienduin + "", "" }).report();
    }
  }
  
  private void c(xqa.b paramb, MessageForTroopGift paramMessageForTroopGift)
  {
    if (TextUtils.isEmpty(paramMessageForTroopGift.charmHeroism)) {}
    String[] arrayOfString1;
    String[] arrayOfString2;
    do
    {
      do
      {
        do
        {
          return;
          paramb.Ka.setVisibility(0);
          localObject = paramMessageForTroopGift.charmHeroism.replace("<", "").replace(">", "").split("\\$s");
        } while ((localObject == null) || (localObject.length != 2));
        arrayOfString1 = localObject[0].split("\\#");
      } while ((arrayOfString1 == null) || (arrayOfString1.length != 3));
      arrayOfString2 = localObject[1].split("\\#");
    } while ((arrayOfString2 == null) || (arrayOfString2.length != 3));
    Object localObject = "";
    if (paramMessageForTroopGift.senderUin == this.app.getLongAccountUin())
    {
      if (paramMessageForTroopGift.sendScore >= 0) {
        localObject = "+";
      }
      localObject = acfp.m(2131715766) + arrayOfString1[0] + (String)localObject + paramMessageForTroopGift.sendScore + "" + arrayOfString2[0];
      if (paramMessageForTroopGift.sendScore == 0) {
        localObject = "";
      }
    }
    for (;;)
    {
      paramb.Ka.setText((CharSequence)localObject);
      return;
      if (paramMessageForTroopGift.receiverUin == this.app.getLongAccountUin())
      {
        if (paramMessageForTroopGift.recvScore >= 0) {
          localObject = "+";
        }
        localObject = acfp.m(2131715750) + arrayOfString1[1] + (String)localObject + paramMessageForTroopGift.recvScore + "" + arrayOfString2[1];
        if (paramMessageForTroopGift.recvScore == 0) {
          localObject = "";
        }
      }
      else
      {
        if (paramMessageForTroopGift.recvScore >= 0) {
          localObject = "+";
        }
        localObject = acfp.m(2131715765) + arrayOfString1[2] + (String)localObject + paramMessageForTroopGift.recvScore + "" + arrayOfString2[2];
        if (paramMessageForTroopGift.recvScore == 0) {
          localObject = "";
        }
      }
    }
  }
  
  private void cej()
  {
    Object localObject = acfp.m(2131715782);
    String str = aqmj.Z(this.mContext, "thxWord");
    if (!TextUtils.isEmpty(str)) {
      localObject = str;
    }
    for (;;)
    {
      this.a.a.setText((CharSequence)localObject);
      this.a.a.setSelection(this.a.a.length());
      if ((this.a instanceof xzp)) {
        ((xzp)this.a).cgs();
      }
      return;
    }
  }
  
  public String W(String paramString, int paramInt)
  {
    return aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".gift/" + "troopGift_" + paramString + "_" + paramInt + ".png");
  }
  
  public int a(ChatMessage paramChatMessage)
  {
    return 0;
  }
  
  public abstract View a(BaseChatItemLayout paramBaseChatItemLayout);
  
  public View a(ChatMessage paramChatMessage, BaseBubbleBuilder.e parame, View paramView, BaseChatItemLayout paramBaseChatItemLayout, wlz paramwlz)
  {
    xqa.b localb = (xqa.b)parame;
    if (paramView == null)
    {
      paramView = a(paramBaseChatItemLayout);
      localb.layout = ((LinearLayout)paramView);
      localb.titleText = ((TextView)localb.layout.findViewById(2131380282));
      localb.Ka = ((TextView)localb.layout.findViewById(2131380281));
      localb.dU = ((Button)localb.layout.findViewById(2131380279));
      localb.oC = ((ImageView)localb.layout.findViewById(2131368047));
      localb.l = ((BubbleImageView)localb.layout.findViewById(2131363410));
      localb.itemView = localb.layout.findViewById(2131369468);
      localb.loadingView = localb.layout.findViewById(2131380280);
      localb.dW = ((Button)localb.layout.findViewById(2131368038));
      localb.dX = ((Button)localb.layout.findViewById(2131368037));
      localb.dY = ((Button)localb.layout.findViewById(2131368033));
      localb.ds = ((ViewGroup)localb.layout.findViewById(2131368039));
      localb.dt = ((ViewGroup)localb.layout.findViewById(2131368034));
      localb.du = ((ViewGroup)localb.layout.findViewById(2131368036));
      localb.dV = ((Button)localb.layout.findViewById(2131368035));
      int i = (int)(220.0F * this.mDensity);
      int j = (int)(i - 10.0F * this.mDensity);
      parame = (RelativeLayout.LayoutParams)localb.layout.findViewById(2131368039).getLayoutParams();
      parame.width = j;
      localb.layout.findViewById(2131368039).setLayoutParams(parame);
      parame = (LinearLayout.LayoutParams)localb.layout.findViewById(2131368038).getLayoutParams();
      parame.width = ((int)(j / 2 - 1.0F * this.mDensity));
      localb.layout.findViewById(2131368038).setLayoutParams(parame);
      parame = (LinearLayout.LayoutParams)localb.layout.findViewById(2131368037).getLayoutParams();
      parame.width = (j / 2);
      localb.layout.findViewById(2131368037).setLayoutParams(parame);
      parame = (RelativeLayout.LayoutParams)localb.layout.findViewById(2131368034).getLayoutParams();
      parame.width = j;
      localb.layout.findViewById(2131368034).setLayoutParams(parame);
      parame = (LinearLayout.LayoutParams)localb.layout.findViewById(2131368033).getLayoutParams();
      parame.width = j;
      localb.layout.findViewById(2131368033).setLayoutParams(parame);
      parame = (RelativeLayout.LayoutParams)localb.layout.findViewById(2131363410).getLayoutParams();
      parame.width = i;
      localb.layout.findViewById(2131363410).setLayoutParams(parame);
      localb.l.TD(false);
      localb.l.setRadius(13.0F);
      localb.l.setScaleType(ImageView.ScaleType.CENTER_CROP);
      localb.l.TE(true);
      localb.l.setFocusable(false);
      localb.l.setFocusableInTouchMode(false);
      localb.l.setClickable(false);
    }
    for (;;)
    {
      localb.l.mIsSend = g(paramChatMessage);
      MessageForTroopGift localMessageForTroopGift = a((MessageForTroopGift)paramChatMessage, localb);
      b(localb, localMessageForTroopGift);
      a(localb);
      localb.c = localMessageForTroopGift;
      if (!localMessageForTroopGift.isInteract())
      {
        paramChatMessage = new aofe(localMessageForTroopGift.title + localMessageForTroopGift.subtitle, 16).k();
        localb.titleText.setText(paramChatMessage);
        localb.Ka.setVisibility(8);
        localb.Ka.setTextColor(-1);
        c(localb, localMessageForTroopGift);
        localb.dU.setText(localMessageForTroopGift.comefrom);
        localb.dU.setContentDescription(localMessageForTroopGift.comefrom);
        localb.l.setTag(2131374463, localMessageForTroopGift.giftPicId + "");
        if (localMessageForTroopGift.isInteract()) {
          break label1219;
        }
        localb.l.setImageDrawable(new ColorDrawable(localMessageForTroopGift.objColor));
        localb.titleText.setTextColor(-1);
      }
      for (;;)
      {
        try
        {
          paramChatMessage = URLDrawable.URLDrawableOptions.obtain();
          paramChatMessage.mFailedDrawable = this.mContext.getResources().getDrawable(2130851809);
          paramChatMessage.mLoadingDrawable = this.mContext.getResources().getDrawable(2130851809);
          paramChatMessage = URLDrawable.getDrawable(localMessageForTroopGift.makeGiftIconUrl(), paramChatMessage);
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          parame = null;
          paramChatMessage = parame;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ChatItemBuilder", 2, paramBaseChatItemLayout.getMessage());
          paramChatMessage = parame;
          continue;
        }
        catch (Exception paramBaseChatItemLayout)
        {
          label1219:
          parame = null;
          paramChatMessage = parame;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("ChatItemBuilder", 2, paramBaseChatItemLayout.getMessage());
          paramChatMessage = parame;
          continue;
          localb.loadingView.setVisibility(8);
          paramChatMessage.e(localb);
          continue;
        }
        try
        {
          paramChatMessage.setDownloadListener(new xqc(this, paramChatMessage, localMessageForTroopGift, localb));
          a(localb, localMessageForTroopGift, paramChatMessage);
          localb.oC.setImageDrawable(paramChatMessage);
          paramChatMessage = new xqa.a(localMessageForTroopGift, localb);
          localb.dW.setOnClickListener(paramChatMessage);
          localb.dX.setOnClickListener(paramChatMessage);
          localb.dY.setOnClickListener(paramChatMessage);
          localb.du.setOnClickListener(paramChatMessage);
          localb.dU.setOnClickListener(paramChatMessage);
          localb.l.setOnClickListener(paramChatMessage);
          localb.l.setOnLongClickListener(paramwlz);
          localb.l.setOnTouchListener(new xqd(this, paramwlz));
          localb.itemView.setOnClickListener(paramChatMessage);
          localb.itemView.setOnLongClickListener(paramwlz);
          localb.itemView.setOnTouchListener(new xqe(this, paramwlz));
          paramChatMessage = (apqk)this.app.getManager(223);
          if ((!localMessageForTroopGift.isLoading) || (!paramChatMessage.nU(aptj.b(localMessageForTroopGift)))) {
            continue;
          }
          paramChatMessage.d(localb);
          if (QLog.isColorLevel()) {
            QLog.d("ChatItemBuilder", 2, "VISIBLE uniseq = " + localMessageForTroopGift.uniseq);
          }
          localb.loadingView.setVisibility(0);
          a(localMessageForTroopGift);
          a(localb, localMessageForTroopGift);
          return paramView;
        }
        catch (Exception paramBaseChatItemLayout)
        {
          parame = paramChatMessage;
          continue;
        }
        catch (OutOfMemoryError paramBaseChatItemLayout)
        {
          parame = paramChatMessage;
          continue;
        }
        localb.titleText.setText(localMessageForTroopGift.title);
        localb.Ka.setVisibility(0);
        localb.Ka.setText(localMessageForTroopGift.subtitle);
        localb.Ka.setTextColor(-7829368);
        break;
        localb.l.setImageResource(2130851810);
        localb.titleText.setTextColor(-16777216);
      }
    }
  }
  
  public void a(int paramInt, Context paramContext, ChatMessage paramChatMessage)
  {
    switch (paramInt)
    {
    default: 
      super.a(paramInt, paramContext, paramChatMessage);
      return;
    }
    ujt.b(this.mContext, this.app, paramChatMessage);
  }
  
  public void a(Bitmap paramBitmap, int paramInt, BubbleImageView paramBubbleImageView, String paramString)
  {
    if ((paramBitmap == null) || (paramBubbleImageView == null) || (paramString == null)) {
      return;
    }
    Object localObject = new File(W(paramString, paramInt));
    String str = "troopGift_" + paramString + "_" + paramInt + ".png";
    SharedPreferences localSharedPreferences = this.mContext.getSharedPreferences(aVR, 0);
    long l1 = localSharedPreferences.getLong(str, 0L);
    long l2 = NetConnInfoCenter.getServerTimeMillis();
    if ((l1 != 0L) && (l2 - l1 < 259200000L)) {}
    for (int i = 1;; i = 0)
    {
      if (this.hP.get(str) != null) {}
      for (boolean bool = ((Boolean)this.hP.get(str)).booleanValue();; bool = false)
      {
        if ((localObject != null) && (((File)localObject).exists()) && (i != 0))
        {
          a(paramBubbleImageView, paramInt, paramString);
          return;
        }
        if (bool)
        {
          localObject = (ArrayList)this.hQ.get(str);
          paramBitmap = (Bitmap)localObject;
          if (localObject == null)
          {
            paramBitmap = new ArrayList();
            this.hQ.put(str, paramBitmap);
          }
          paramBitmap.add(new TroopGiftMsgItemBuilder.2(this, paramBubbleImageView, paramString, paramInt));
          return;
        }
        this.hP.put(str, Boolean.valueOf(true));
        paramBubbleImageView.setImageDrawable(new ColorDrawable(paramInt));
        this.aF.incrementAndGet();
        ThreadManager.post(new TroopGiftMsgItemBuilder.3(this, paramString, paramInt, paramBitmap, paramBubbleImageView, str, localSharedPreferences, l2), 8, null, false);
        return;
      }
    }
  }
  
  public void a(View paramView, ChatMessage paramChatMessage)
  {
    paramView.setPadding(0, 0, 0, BaseChatItemLayout.bNW);
  }
  
  public aqob[] a(View paramView)
  {
    aqoa localaqoa = new aqoa();
    paramView = wja.a(paramView);
    a(paramView, localaqoa);
    ujt.a(localaqoa, this.mContext, this.sessionInfo.cZ);
    b(paramView, localaqoa);
    super.e(localaqoa, this.mContext);
    return localaqoa.a();
  }
  
  public String b(ChatMessage paramChatMessage)
  {
    return ((MessageForTroopGift)paramChatMessage).title;
  }
  
  public boolean g(ChatMessage paramChatMessage)
  {
    return paramChatMessage.isSend();
  }
  
  class a
    implements View.OnClickListener
  {
    private MessageForTroopGift jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift;
    private xqa.b jdField_b_of_type_Xqa$b;
    
    public a(MessageForTroopGift paramMessageForTroopGift, xqa.b paramb)
    {
      this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift = paramMessageForTroopGift;
      this.jdField_b_of_type_Xqa$b = paramb;
    }
    
    private void Dl(int paramInt)
    {
      Intent localIntent = new Intent(xqa.this.mContext, QQBrowserActivity.class);
      String str = this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.activity_url;
      localIntent.putExtra("url", str);
      localIntent.putExtra("key_isReadModeEnabled", true);
      ocp.a(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift, localIntent, str);
      xqa.this.mContext.startActivity(localIntent);
      anot.a(null, "dc00899", "grp_lbs", "", "qq_gift", "popup_click", paramInt, 0, String.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.giftId), "", "", "");
    }
    
    private void Dm(int paramInt)
    {
      Object localObject;
      if (!TextUtils.isEmpty(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl))
      {
        localObject = new Intent(xqa.this.mContext, QQBrowserActivity.class);
        ((Intent)localObject).putExtra("url", this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.jumpUrl);
        ((Intent)localObject).putExtra("key_isReadModeEnabled", true);
        xqa.this.mContext.startActivity((Intent)localObject);
      }
      while (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
      {
        anot.a(xqa.this.app, "dc00899", "Grp_flower", "", "C2C", "Clk_objtail", 0, 0, "", "", "", "");
        return;
        localObject = ((FragmentActivity)xqa.this.mContext).getChatFragment();
        if ((localObject != null) && (((ChatFragment)localObject).a() != null))
        {
          localObject = ((ChatFragment)localObject).a();
          if ((this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) || (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isToAll())) {}
          for (int i = TroopGiftPanel.byo;; i = TroopGiftPanel.byn)
          {
            ((BaseChatPie)localObject).aj(true, i);
            break;
          }
        }
      }
      if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
      {
        anot.a(xqa.this.app, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_objtail", 0, 0, "", "", "", "");
        return;
      }
      if ((this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
      {
        anot.a(xqa.this.app, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_objtail", 0, 0, "", "", "", "");
        return;
      }
      if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby) {
        if (xqa.this.app.getCurrentUin().equals(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
          paramInt = 0;
        }
      }
      for (;;)
      {
        acie.i("gift_aio", "clk_tail", xqa.this.sessionInfo.aTl, paramInt + "", "", "");
        return;
        if (xqa.this.app.getCurrentUin().equals(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin)))
        {
          paramInt = 1;
          continue;
          anot.a(xqa.this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_objtail", paramInt, 0, xqa.this.sessionInfo.aTl, "", "", "");
        }
        else
        {
          paramInt = 2;
        }
      }
    }
    
    private void Dn(int paramInt)
    {
      Object localObject1;
      Object localObject2;
      int i;
      if (aptj.c(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift))
      {
        localObject1 = (apqk)xqa.this.app.getManager(223);
        if ((localObject1 != null) && (((apqk)localObject1).aBt()))
        {
          localObject2 = ((FragmentActivity)xqa.this.mContext).getChatFragment();
          if ((localObject2 != null) && (((ChatFragment)localObject2).a() != null)) {
            ((apqk)localObject1).B(((ChatFragment)localObject2).a());
          }
          this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading = false;
          ((apqk)localObject1).d(this.jdField_b_of_type_Xqa$b);
          ((apqk)localObject1).b(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift);
          if (!this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isLoading) {
            ((apqk)localObject1).e(this.jdField_b_of_type_Xqa$b);
          }
          if (!this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isInteract()) {
            ((apqk)localObject1).ebq();
          }
        }
        if (!xqa.this.app.getCurrentUin().equals(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin)) {
          break label332;
        }
        i = 0;
      }
      for (;;)
      {
        if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 0)
        {
          anot.a(xqa.this.app, "dc00899", "Grp_flower", "", "C2C", "Clk_obj", 0, 0, "", "", "", "");
          return;
          localObject1 = new Intent(xqa.this.mContext, QQBrowserActivity.class);
          localObject2 = this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderuin;
          localObject2 = "https://qun.qq.com/qunpay/gifts/index.html?troopUin=" + xqa.this.sessionInfo.aTl + "&uin=" + (String)localObject2 + "&name=" + aqgo.encodeToString(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.subtitle.getBytes(), 2) + "&from=obj&_wv=1031&_bid=2204";
          ((Intent)localObject1).putExtra("url", (String)localObject2);
          ((Intent)localObject1).putExtra("key_isReadModeEnabled", true);
          ocp.a(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift, (Intent)localObject1, (String)localObject2);
          xqa.this.mContext.startActivity((Intent)localObject1);
          break;
          label332:
          if (!xqa.this.app.getCurrentUin().equals(Long.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.receiverUin))) {
            break label595;
          }
          i = 1;
          continue;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 3000)
        {
          anot.a(xqa.this.app, "dc00899", "Grp_flower", "", "discuss_grp", "Clk_obj", 0, 0, "", "", "", "");
          return;
        }
        if ((this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1000) || (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.istroop == 1004))
        {
          anot.a(xqa.this.app, "dc00899", "Grp_flower", "", "temp_c2c", "Clk_obj", 0, 0, "", "", "", "");
          return;
        }
        if (this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.isFromNearby)
        {
          acie.i("gift_aio", "clk_obj", xqa.this.sessionInfo.aTl, i + "", "", "");
          return;
        }
        anot.a(xqa.this.app, "P_CliOper", "Grp_flower", "", "grp_aio", "Clk_obj", paramInt, 0, xqa.this.sessionInfo.aTl, i + "", this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.giftPicId + "", "");
        return;
        label595:
        i = 2;
      }
    }
    
    private void cek()
    {
      if ((xqa.this.a instanceof xzp))
      {
        ((xzp)xqa.this.a).yv(String.valueOf(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin));
        return;
      }
      new anov(xqa.this.app).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_return").a(0).a(new String[] { this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).report();
      String str = aqmj.Z(xqa.this.mContext, "url");
      if (!TextUtils.isEmpty(str)) {}
      for (;;)
      {
        str = str.replace("{troopUin}", "" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin).replace("{uin}", "" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderUin).replace("{from}", "28");
        Intent localIntent = new Intent(xqa.this.mContext, QQBrowserActivity.class);
        localIntent.putExtra("url", str);
        xqa.this.mContext.startActivity(localIntent);
        return;
        str = "https://qun.qq.com/qunpay/gifts/index.html?_bid=2204&troopUin={troopUin}&uin={uin}&from={from}&_wv=1031";
      }
    }
    
    private void cel()
    {
      new anov(xqa.this.app).a("dc00899").b("Grp_flower").c("grp_aio").d("clk_ask").a(0).a(new String[] { this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.frienduin + "", "28" }).report();
      String str1 = "@" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + acfp.m(2131715772);
      String str2 = aqmj.Z(xqa.this.mContext, "wantWord");
      if (!TextUtils.isEmpty(str2)) {
        str1 = "@" + this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift.senderName + str2;
      }
      xqa.this.a.a.setText(str1);
      xqa.this.a.a.setTag(2131374485, this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift);
      xqa.this.a.a.setSelection(xqa.this.a.a.length());
      xqa.this.a.bt.getAndSet(true);
      if ((xqa.this.a instanceof xzp)) {
        ((xzp)xqa.this.a).cgs();
      }
      xqa.this.a.a.addTextChangedListener(new xqf(this));
    }
    
    public void onClick(View paramView)
    {
      if (xqa.this.a == null) {}
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        if (jof.a(this.jdField_b_of_type_ComTencentMobileqqDataMessageForTroopGift)) {}
        for (int i = 2;; i = 1)
        {
          if (paramView.getId() != 2131368033) {
            break label52;
          }
          cel();
          break;
        }
        label52:
        if (paramView.getId() == 2131368038) {
          xqa.a(xqa.this);
        } else if (paramView.getId() == 2131368037) {
          cek();
        } else if (paramView.getId() == 2131363410) {
          Dn(i);
        } else if (paramView.getId() == 2131380279) {
          Dm(i);
        } else if (paramView.getId() == 2131368036) {
          Dl(i);
        }
      }
    }
  }
  
  public static abstract class b
    extends BaseBubbleBuilder.e
    implements Observer
  {
    public TextView Ka;
    public MessageForTroopGift c;
    public Button dU;
    public Button dV;
    public Button dW;
    public Button dX;
    public Button dY;
    public ViewGroup ds;
    public ViewGroup dt;
    public ViewGroup du;
    public View itemView;
    public BubbleImageView l;
    public LinearLayout layout;
    public View loadingView;
    private QQAppInterface mApp;
    public ImageView oC;
    public TextView titleText;
    
    public b(QQAppInterface paramQQAppInterface)
    {
      this.mApp = paramQQAppInterface;
    }
    
    public void update(Observable paramObservable, Object paramObject)
    {
      paramObservable = (apqk.a)paramObject;
      if ((paramObservable.cqv.equals(aptj.b(this.c))) && (this.c.isLoading)) {
        this.loadingView.post(new TroopGiftMsgItemBuilder.TroopGiftMsgHolder.1(this, paramObservable));
      }
    }
  }
  
  public static class c
    extends xqa
  {
    public c(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
    {
      super(paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    }
    
    public View a(BaseChatItemLayout paramBaseChatItemLayout)
    {
      return LayoutInflater.from(this.mContext).inflate(2131563248, paramBaseChatItemLayout, false);
    }
    
    public BaseBubbleBuilder.e a()
    {
      return new xqa.e(this.app);
    }
  }
  
  public static class d
    extends xqa
  {
    public d(QQAppInterface paramQQAppInterface, BaseAdapter paramBaseAdapter, Context paramContext, SessionInfo paramSessionInfo, AIOAnimationConatiner paramAIOAnimationConatiner, BaseChatPie paramBaseChatPie)
    {
      super(paramBaseAdapter, paramContext, paramSessionInfo, paramAIOAnimationConatiner, paramBaseChatPie);
    }
    
    public View a(BaseChatItemLayout paramBaseChatItemLayout)
    {
      return LayoutInflater.from(this.mContext).inflate(2131563249, paramBaseChatItemLayout, false);
    }
    
    public BaseBubbleBuilder.e a()
    {
      return new xqa.f(this.app);
    }
  }
  
  static class e
    extends xqa.b
  {
    public e(QQAppInterface paramQQAppInterface)
    {
      super();
    }
  }
  
  static class f
    extends xqa.b
  {
    public f(QQAppInterface paramQQAppInterface)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     xqa
 * JD-Core Version:    0.7.0.1
 */