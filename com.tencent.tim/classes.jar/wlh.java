import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.FontMetrics;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.text.Layout;
import android.text.Layout.Alignment;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
import android.widget.AdapterView.OnItemClickListener;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.1;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.3;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6;
import com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.7;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.IntimateInfo;
import com.tencent.mobileqq.data.IntimateInfo.DNAInfo;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;
import mqq.os.MqqHandler;

public class wlh
{
  private static String aSZ;
  private aqmh jdField_a_of_type_Aqmh;
  private IntimateInfo jdField_a_of_type_ComTencentMobileqqDataIntimateInfo;
  private WXShareHelper.a jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a;
  private List<ShareActionSheetBuilder.ActionSheetItem>[] c;
  private Bitmap dw;
  private Bitmap dx;
  private Bitmap dy;
  AdapterView.OnItemClickListener f = new wli(this);
  private arhz m;
  private FragmentActivity mActivity;
  private QQAppInterface mApp;
  private Bitmap mBitmap;
  
  public wlh(FragmentActivity paramFragmentActivity, QQAppInterface paramQQAppInterface, IntimateInfo paramIntimateInfo, Bitmap paramBitmap1, Bitmap paramBitmap2, Bitmap paramBitmap3)
  {
    this.mActivity = paramFragmentActivity;
    this.mApp = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo = paramIntimateInfo;
    this.dx = paramBitmap1;
    this.dy = paramBitmap2;
    this.dw = paramBitmap3;
    if ((this.dx == null) || (this.dx.isRecycled())) {
      this.dx = BitmapFactory.decodeResource(this.mActivity.getResources(), 2130847273);
    }
    if ((this.dy == null) || (this.dy.isRecycled())) {
      this.dy = BitmapFactory.decodeResource(this.mActivity.getResources(), 2130847273);
    }
    aSZ = this.mActivity.getResources().getString(2131695105) + this.mActivity.getResources().getString(2131695106) + this.mActivity.getResources().getString(2131695107);
  }
  
  private void A(Bitmap paramBitmap)
  {
    paramBitmap = d(paramBitmap);
    bpm();
    if (TextUtils.isEmpty(paramBitmap)) {
      ez(1, 2131695091);
    }
    for (;;)
    {
      return;
      Object localObject = BaseApplicationImpl.getContext().getPackageManager();
      try
      {
        localObject = ((PackageManager)localObject).getApplicationInfo("com.sina.weibo", 8192);
        if (QLog.isColorLevel()) {
          QLog.d("IntimateInfoShareHelper", 2, "shareMsgToSina installSinaWeibo:true");
        }
        Intent localIntent = new Intent("android.intent.action.SEND");
        localIntent.setFlags(268435456);
        localIntent.setType("image/*");
        localIntent.putExtra("android.intent.extra.TEXT", aSZ);
        localIntent.putExtra("android.intent.extra.STREAM", Uri.fromFile(new File(paramBitmap)));
        FileProvider7Helper.intentCompatForN(BaseApplicationImpl.getContext(), localIntent);
        localIntent.setPackage(((ApplicationInfo)localObject).packageName);
        this.mActivity.startActivity(localIntent);
        if (QLog.isColorLevel())
        {
          QLog.d("IntimateInfoShareHelper", 2, "shareMsgToSina start weibo!");
          return;
        }
      }
      catch (PackageManager.NameNotFoundException paramBitmap)
      {
        ez(0, 2131695101);
      }
    }
  }
  
  private void B(Bitmap paramBitmap)
  {
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (this.mActivity.checkSelfPermission("android.permission.WRITE_EXTERNAL_STORAGE") != 0)
      {
        this.mActivity.requestPermissions(new wlk(this, paramBitmap), 1, new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" });
        return;
      }
      C(paramBitmap);
      return;
    }
    C(paramBitmap);
  }
  
  private void Sa()
  {
    if (this.m == null)
    {
      this.m = new arhz(this.mActivity, this.mActivity.getTitleBarHeight());
      this.m.setBackAndSearchFilter(true);
    }
    this.m.setMessage(2131695695);
    if ((this.m != null) && (!this.m.isShowing()) && (!this.mActivity.isFinishing())) {
      this.m.show();
    }
  }
  
  private void a(Canvas paramCanvas, Paint paramPaint, float paramFloat1, float paramFloat2, String paramString)
  {
    paramCanvas.drawText(paramString, paramFloat1, paramFloat2 - paramPaint.getFontMetrics().top, paramPaint);
  }
  
  private void bpm()
  {
    if ((this.m != null) && (this.m.isShowing())) {}
    try
    {
      this.m.dismiss();
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  private void d(Bitmap paramBitmap, int paramInt)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = new wlj(this);
      WXShareHelper.a().a(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
    }
    String str = d(paramBitmap);
    bpm();
    if (TextUtils.isEmpty(str)) {
      ez(1, 2131695091);
    }
    do
    {
      return;
      if (paramInt == 3)
      {
        WXShareHelper.a().b(str, paramBitmap, 0);
        return;
      }
    } while (paramInt != 4);
    WXShareHelper.a().b(str, paramBitmap, 1);
  }
  
  private void ez(int paramInt1, int paramInt2)
  {
    ThreadManager.getUIHandler().post(new IntimateInfoShareHelper.7(this, paramInt1, paramInt2));
  }
  
  private void gr()
  {
    this.jdField_a_of_type_Aqmh = new aqmh(this.mActivity);
    this.c = a(this.mActivity);
    this.jdField_a_of_type_Aqmh.setActionSheetItems(this.c);
    this.jdField_a_of_type_Aqmh.setItemClickListener(this.f);
  }
  
  private Bitmap h(Bitmap paramBitmap, int paramInt1, int paramInt2)
  {
    if (paramBitmap == null) {
      return null;
    }
    int i = paramBitmap.getHeight();
    int j = paramBitmap.getWidth();
    float f1 = paramInt1 / j;
    float f2 = paramInt2 / i;
    Matrix localMatrix = new Matrix();
    localMatrix.postScale(f1, f2);
    return Bitmap.createBitmap(paramBitmap, 0, 0, j, i, localMatrix, false);
  }
  
  private void y(Bitmap paramBitmap)
  {
    paramBitmap = d(paramBitmap);
    bpm();
    if (TextUtils.isEmpty(paramBitmap))
    {
      ez(1, 2131695091);
      return;
    }
    avpw.d locald = avpw.d.a();
    locald.cMP = this.mApp.getAccount();
    avpw.a(this.mActivity, locald, paramBitmap, this.mActivity.getResources().getString(2131695109), "", 20001);
  }
  
  private void z(Bitmap paramBitmap)
  {
    try
    {
      Object localObject = d(paramBitmap);
      bpm();
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        ez(1, 2131695091);
        return;
      }
      paramBitmap = new Bundle();
      paramBitmap.putInt("forward_type", 1);
      paramBitmap.putString("forward_filepath", (String)localObject);
      paramBitmap.putString("forward_thumb", (String)localObject);
      paramBitmap.putString("forward_urldrawable_big_url", (String)localObject);
      paramBitmap.putString("forward_extra", "intimate_share");
      localObject = new Intent();
      ((Intent)localObject).putExtras(paramBitmap);
      ahgq.f(this.mActivity, (Intent)localObject, 21);
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      ez(1, 2131695096);
    }
  }
  
  public void C(Bitmap paramBitmap)
  {
    ThreadManager.executeOnFileThread(new IntimateInfoShareHelper.6(this, paramBitmap));
  }
  
  public Bitmap D(Bitmap paramBitmap)
  {
    paramBitmap = paramBitmap.copy(Bitmap.Config.ARGB_8888, true);
    Object localObject = Bitmap.createBitmap(h(this.dw, 750, 1272), 0, 1100, 750, 172);
    Canvas localCanvas = new Canvas(paramBitmap);
    localCanvas.drawBitmap((Bitmap)localObject, 0.0F, 1100.0F, null);
    localCanvas.drawBitmap(ag(), 40.0F, 1125.0F, null);
    localObject = new TextPaint(1);
    ((TextPaint)localObject).setTextSize(24.0F);
    ((TextPaint)localObject).setTextAlign(Paint.Align.LEFT);
    ((TextPaint)localObject).setColor(Color.parseColor("#878B99"));
    localObject = new StaticLayout(aSZ.replace("，", "，\r\n"), (TextPaint)localObject, 350, Layout.Alignment.ALIGN_NORMAL, 1.2F, 0.0F, true);
    localCanvas.save();
    localCanvas.translate(152.0F, 1125.0F);
    ((StaticLayout)localObject).draw(localCanvas);
    localCanvas.restore();
    localCanvas.drawBitmap(h(BitmapFactory.decodeResource(this.mActivity.getResources(), 2130841196), 194, 40), 512.0F, 1185.0F, null);
    return paramBitmap;
  }
  
  public Bitmap a(IntimateInfo paramIntimateInfo)
  {
    Bitmap localBitmap2 = Bitmap.createBitmap(750, 1272, Bitmap.Config.ARGB_8888);
    Canvas localCanvas = new Canvas(localBitmap2);
    localCanvas.drawBitmap(h(this.dw, 750, 1272), 0.0F, 0.0F, null);
    Object localObject = h(this.dx, 140, 140);
    Bitmap localBitmap1 = h(this.dy, 140, 140);
    localCanvas.drawBitmap((Bitmap)localObject, 248.0F, 180.0F, null);
    localObject = new Paint(1);
    ((Paint)localObject).setColor(-1);
    localCanvas.drawCircle(223.0F, 250.0F, 75.0F, (Paint)localObject);
    localCanvas.drawBitmap(localBitmap1, 153.0F, 180.0F, null);
    int j;
    int i;
    TextPaint localTextPaint;
    StringBuilder localStringBuilder;
    switch (paramIntimateInfo.maskType)
    {
    default: 
      localObject = this.mActivity.getResources().getString(2131695097);
      j = Color.parseColor("#03081A");
      i = Color.parseColor("#878B99");
      localBitmap1 = BitmapFactory.decodeResource(this.mActivity.getResources(), 2130841192);
      localTextPaint = new TextPaint(1);
      localTextPaint.setColor(j);
      localTextPaint.setTextSize(80.0F);
      localTextPaint.setTextAlign(Paint.Align.LEFT);
      a(localCanvas, localTextPaint, 146.0F, 364.0F, String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays));
      float f1 = Layout.getDesiredWidth(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.beFriendDays), localTextPaint);
      localTextPaint.setTextSize(34.0F);
      a(localCanvas, localTextPaint, 8.0F + (f1 + 146.0F), 410.0F, this.mActivity.getResources().getString(2131695041, new Object[] { "" }));
      a(localCanvas, localTextPaint, 152.0F, 468.0F, (String)localObject);
      localObject = this.mActivity.getResources();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Resources)localObject).getString(2131695092));
      localStringBuilder.append("\r\n");
      localStringBuilder.append(((Resources)localObject).getString(2131695093));
      localStringBuilder.append("\r\n");
      j = 2;
      if ((paramIntimateInfo.commonTroopInfoList != null) && (paramIntimateInfo.commonTroopInfoList.size() > 0))
      {
        localStringBuilder.append(((Resources)localObject).getString(2131695065));
        localStringBuilder.append(this.jdField_a_of_type_ComTencentMobileqqDataIntimateInfo.commonTroopInfoList.size());
        localStringBuilder.append(((Resources)localObject).getString(2131695052));
        localStringBuilder.append("\r\n");
        label494:
        if (paramIntimateInfo.dnaInfoList.size() >= j) {
          break label857;
        }
        j = paramIntimateInfo.dnaInfoList.size();
      }
      break;
    }
    label857:
    for (;;)
    {
      int k = 0;
      for (;;)
      {
        if (k < j)
        {
          localStringBuilder.append(((IntimateInfo.DNAInfo)paramIntimateInfo.dnaInfoList.get(k)).wording.replaceAll("，", "，\r\n"));
          localStringBuilder.append("\r\n");
          k += 1;
          continue;
          localObject = this.mActivity.getResources().getString(2131695100);
          j = Color.parseColor("#FF6FA3");
          i = Color.parseColor("#FF8AB5");
          localBitmap1 = BitmapFactory.decodeResource(this.mActivity.getResources(), 2130841195);
          break;
          localObject = this.mActivity.getResources().getString(2131695098);
          j = Color.parseColor("#FF8A2D");
          i = Color.parseColor("#FF9F40");
          localBitmap1 = BitmapFactory.decodeResource(this.mActivity.getResources(), 2130841193);
          break;
          localObject = this.mActivity.getResources().getString(2131695099);
          j = Color.parseColor("#2493FF");
          i = Color.parseColor("#4DA7FF");
          localBitmap1 = BitmapFactory.decodeResource(this.mActivity.getResources(), 2130841194);
          break;
          j = 3;
          break label494;
        }
      }
      localStringBuilder.append(((Resources)localObject).getString(2131695094));
      localStringBuilder.append("\r\n");
      localStringBuilder.append(((Resources)localObject).getString(2131695095));
      localTextPaint.setColor(i);
      localTextPaint.setTextSize(24.0F);
      paramIntimateInfo = new StaticLayout(localStringBuilder, localTextPaint, 300, Layout.Alignment.ALIGN_NORMAL, 1.7F, 0.0F, true);
      localCanvas.save();
      localCanvas.translate(152.0F, 560.0F);
      paramIntimateInfo.draw(localCanvas);
      localCanvas.restore();
      localCanvas.drawBitmap(h(localBitmap1, 254, 40), 248.0F, 1163.0F, null);
      return localBitmap2;
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698630);
    localActionSheetItem.icon = 2130839252;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 1;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698643);
    localActionSheetItem.icon = 2130839253;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 2;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698652);
    localActionSheetItem.icon = 2130839256;
    localActionSheetItem.action = 3;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131698633);
    localActionSheetItem.icon = 2130839249;
    localActionSheetItem.action = 4;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    localActionSheetItem = new ShareActionSheetBuilder.ActionSheetItem();
    localActionSheetItem.label = paramContext.getString(2131695112);
    localActionSheetItem.icon = 2130840535;
    localActionSheetItem.iconNeedBg = true;
    localActionSheetItem.action = 0;
    localActionSheetItem.argus = "";
    localArrayList.add(localActionSheetItem);
    return new ArrayList[] { localArrayList };
  }
  
  public Bitmap ag()
  {
    Object localObject1 = "https://ti.qq.com/open_qq/newIndex.html?url=mqqapi%3A%2F%2Fuserprofile%2Ffriend_profile_card%3Fsrc_type%3Dweb%26version%3D1.0%26source%3D1%26uin%3D" + this.mApp.getCurrentUin();
    Object localObject2 = new Hashtable();
    ((Hashtable)localObject2).put(EncodeHintType.MARGIN, Integer.valueOf(0));
    ((Hashtable)localObject2).put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
    int n;
    int i;
    int j;
    try
    {
      localObject2 = new lo().b((String)localObject1, 100, 100, (Map)localObject2);
      k = ((lk)localObject2).getWidth();
      n = ((lk)localObject2).getHeight();
      localObject1 = new int[k * n];
      i = 0;
    }
    catch (WriterException localWriterException)
    {
      int k;
      if (!QLog.isColorLevel()) {
        break label182;
      }
      QLog.d("IntimateInfoShareHelper", 2, "Create QRCode fail");
      label182:
      return null;
    }
    if (j < k) {
      if (((lk)localObject2).get(j, i)) {
        localObject1[(i * k + j)] = -16777216;
      }
    }
    label207:
    for (;;)
    {
      localObject2 = Bitmap.createBitmap(k, n, Bitmap.Config.ARGB_8888);
      ((Bitmap)localObject2).setPixels((int[])localObject1, 0, k, 0, 0, k, n);
      return localObject2;
      for (;;)
      {
        if (i >= n) {
          break label207;
        }
        j = 0;
        break;
        j += 1;
        break;
        i += 1;
      }
    }
  }
  
  public void b(int paramInt, Bitmap paramBitmap)
  {
    if ((paramInt == 3) || (paramInt == 4))
    {
      if (WXShareHelper.a().isWXinstalled()) {
        break label70;
      }
      QQToast.a(this.mActivity, this.mActivity.getString(2131695102), 0).show(this.mActivity.getTitleBarHeight());
    }
    for (;;)
    {
      Sa();
      ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.3(this, paramBitmap, paramInt));
      return;
      label70:
      if (!WXShareHelper.a().isWXsupportApi()) {
        QQToast.a(this.mActivity, this.mActivity.getString(2131695110), 0).show(this.mActivity.getTitleBarHeight());
      }
    }
  }
  
  /* Error */
  public String d(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: new 71	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 72	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 779
    //   10: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: invokestatic 785	java/lang/System:currentTimeMillis	()J
    //   16: invokevirtual 788	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   19: aload_0
    //   20: getfield 42	wlh:mApp	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   23: invokevirtual 791	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   26: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: ldc_w 793
    //   32: invokevirtual 83	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: invokevirtual 89	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: astore 4
    //   40: new 174	java/io/File
    //   43: dup
    //   44: new 174	java/io/File
    //   47: dup
    //   48: getstatic 798	acbn:SDCARD_PATH	Ljava/lang/String;
    //   51: ldc_w 800
    //   54: invokespecial 802	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   57: invokevirtual 805	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   60: invokestatic 811	aqul:getSDKPrivatePath	(Ljava/lang/String;)Ljava/lang/String;
    //   63: invokespecial 175	java/io/File:<init>	(Ljava/lang/String;)V
    //   66: astore_3
    //   67: aload_3
    //   68: invokevirtual 814	java/io/File:mkdirs	()Z
    //   71: pop
    //   72: aload_3
    //   73: astore_2
    //   74: aload_3
    //   75: ifnonnull +11 -> 86
    //   78: aload_0
    //   79: getfield 40	wlh:mActivity	Landroid/support/v4/app/FragmentActivity;
    //   82: invokevirtual 818	android/support/v4/app/FragmentActivity:getCacheDir	()Ljava/io/File;
    //   85: astore_2
    //   86: aload_2
    //   87: ifnull +141 -> 228
    //   90: aload_2
    //   91: invokevirtual 821	java/io/File:canWrite	()Z
    //   94: ifeq +134 -> 228
    //   97: new 174	java/io/File
    //   100: dup
    //   101: aload_2
    //   102: invokevirtual 805	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   105: aload 4
    //   107: invokespecial 802	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: astore_2
    //   111: aload_2
    //   112: invokevirtual 805	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   115: astore 4
    //   117: aload_2
    //   118: invokevirtual 824	java/io/File:exists	()Z
    //   121: ifeq +8 -> 129
    //   124: aload_2
    //   125: invokevirtual 827	java/io/File:delete	()Z
    //   128: pop
    //   129: new 829	java/io/BufferedOutputStream
    //   132: dup
    //   133: new 831	java/io/FileOutputStream
    //   136: dup
    //   137: aload_2
    //   138: invokespecial 834	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   141: invokespecial 837	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   144: astore_3
    //   145: aload_3
    //   146: astore_2
    //   147: aload_1
    //   148: getstatic 843	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   151: bipush 100
    //   153: aload_3
    //   154: invokevirtual 847	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   157: pop
    //   158: aload_3
    //   159: astore_2
    //   160: aload_3
    //   161: invokevirtual 850	java/io/BufferedOutputStream:flush	()V
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 853	java/io/BufferedOutputStream:close	()V
    //   172: aload 4
    //   174: areturn
    //   175: astore_1
    //   176: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   179: ifeq -7 -> 172
    //   182: ldc 141
    //   184: iconst_2
    //   185: aload_1
    //   186: invokevirtual 856	java/io/IOException:getMessage	()Ljava/lang/String;
    //   189: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   192: aload 4
    //   194: areturn
    //   195: astore 4
    //   197: aconst_null
    //   198: astore_1
    //   199: aload_1
    //   200: astore_2
    //   201: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   204: ifeq +16 -> 220
    //   207: aload_1
    //   208: astore_2
    //   209: ldc 141
    //   211: iconst_2
    //   212: aload 4
    //   214: invokevirtual 857	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   217: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   220: aload_1
    //   221: ifnull +7 -> 228
    //   224: aload_1
    //   225: invokevirtual 853	java/io/BufferedOutputStream:close	()V
    //   228: aconst_null
    //   229: areturn
    //   230: astore_1
    //   231: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   234: ifeq -6 -> 228
    //   237: ldc 141
    //   239: iconst_2
    //   240: aload_1
    //   241: invokevirtual 856	java/io/IOException:getMessage	()Ljava/lang/String;
    //   244: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   247: goto -19 -> 228
    //   250: astore_1
    //   251: aconst_null
    //   252: astore_2
    //   253: aload_2
    //   254: ifnull +7 -> 261
    //   257: aload_2
    //   258: invokevirtual 853	java/io/BufferedOutputStream:close	()V
    //   261: aload_1
    //   262: athrow
    //   263: astore_2
    //   264: invokestatic 139	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   267: ifeq -6 -> 261
    //   270: ldc 141
    //   272: iconst_2
    //   273: aload_2
    //   274: invokevirtual 856	java/io/IOException:getMessage	()Ljava/lang/String;
    //   277: invokestatic 146	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   280: goto -19 -> 261
    //   283: astore_1
    //   284: goto -31 -> 253
    //   287: astore 4
    //   289: aload_3
    //   290: astore_1
    //   291: goto -92 -> 199
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	294	0	this	wlh
    //   0	294	1	paramBitmap	Bitmap
    //   73	185	2	localObject1	Object
    //   263	11	2	localIOException	java.io.IOException
    //   66	224	3	localObject2	Object
    //   38	155	4	str	String
    //   195	18	4	localException1	Exception
    //   287	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   168	172	175	java/io/IOException
    //   129	145	195	java/lang/Exception
    //   224	228	230	java/io/IOException
    //   129	145	250	finally
    //   257	261	263	java/io/IOException
    //   147	158	283	finally
    //   160	164	283	finally
    //   201	207	283	finally
    //   209	220	283	finally
    //   147	158	287	java/lang/Exception
    //   160	164	287	java/lang/Exception
  }
  
  public void onDestroy()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a != null)
    {
      WXShareHelper.a().b(this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a);
      this.jdField_a_of_type_ComTencentMobileqqWxapiWXShareHelper$a = null;
    }
    if (this.jdField_a_of_type_Aqmh != null) {
      this.jdField_a_of_type_Aqmh.dismiss();
    }
  }
  
  public void show()
  {
    if (this.jdField_a_of_type_Aqmh == null) {
      gr();
    }
    if ((this.mBitmap == null) || (this.mBitmap.isRecycled()))
    {
      ThreadManager.getFileThreadHandler().post(new IntimateInfoShareHelper.1(this));
      return;
    }
    this.jdField_a_of_type_Aqmh.ai(this.mBitmap);
    this.jdField_a_of_type_Aqmh.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wlh
 * JD-Core Version:    0.7.0.1
 */