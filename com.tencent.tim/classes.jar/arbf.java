import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.qrcode.activity.ScannerActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.TeamWorkDocEditBrowserActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.1;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.4;
import com.tencent.mobileqq.webview.swift.component.SwiftBrowserLongClickHandler.7;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.export.external.extension.interfaces.IX5WebViewExtension;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult;
import com.tencent.smtt.export.external.interfaces.IX5WebViewBase.HitTestResult.ImageAnchorData;
import com.tencent.smtt.sdk.CookieManager;

public class arbf
  extends araz.a
{
  public CookieManager a;
  public int baA = 0;
  public String czd;
  public ausj d;
  public int eec = -1;
  public int eed;
  public Object fC = new Object();
  String imgUrl;
  public arhz m;
  public String mTempPath;
  public final Activity s;
  
  public arbf(Activity paramActivity)
  {
    this.s = paramActivity;
    if ((this.s instanceof QQBrowserActivity)) {
      this.baA = ((QQBrowserActivity)this.s).getTitleBarHeight();
    }
    ThreadManager.postImmediately(new SwiftBrowserLongClickHandler.1(this, paramActivity), null, true);
  }
  
  private void VU(String paramString)
  {
    if (this.s.isFinishing()) {
      return;
    }
    ThreadManager.excute(new SwiftBrowserLongClickHandler.4(this, paramString), 64, null, true);
  }
  
  public void P(int paramInt, Bundle paramBundle)
  {
    switch (paramInt)
    {
    default: 
      return;
    }
    if ((this.d != null) && (this.d.isShowing())) {
      this.d.dismiss();
    }
    adjn.a().ak(hashCode(), "SwiftBrowserLongClickHandler");
  }
  
  public boolean U(View paramView)
  {
    int k = 0;
    boolean bool1 = false;
    if ((this.s == null) || (this.s.isFinishing()))
    {
      bool1 = true;
      return bool1;
    }
    Object localObject;
    int i;
    if ((this.a != null) && (this.a.getWebView() != null))
    {
      localObject = this.a.getWebView();
      paramView = ((com.tencent.smtt.sdk.WebView)localObject).getX5HitTestResult();
      if (paramView != null)
      {
        i = paramView.getType();
        if (i == 8)
        {
          if (!(paramView.getData() instanceof IX5WebViewBase.HitTestResult.ImageAnchorData)) {
            break label514;
          }
          paramView = ((IX5WebViewBase.HitTestResult.ImageAnchorData)paramView.getData()).mPicUrl;
        }
      }
    }
    for (;;)
    {
      label101:
      localObject = ((com.tencent.smtt.sdk.WebView)localObject).getX5WebViewExtension();
      boolean bool2;
      label149:
      int j;
      if (localObject != null)
      {
        localObject = (Boolean)((IX5WebViewExtension)localObject).invokeMiscMethod("supportImageQuery", new Bundle());
        if (localObject != null)
        {
          bool2 = ((Boolean)localObject).booleanValue();
          bool1 = bool2;
          localObject = paramView;
          j = i;
          if (QLog.isColorLevel())
          {
            QLog.d("SwiftBrowserLongClickHandler", 2, "isSupportImageQuery:" + bool2);
            j = i;
            localObject = paramView;
            bool1 = bool2;
          }
        }
      }
      for (;;)
      {
        if ((j != 8) && (j != 5))
        {
          QLog.e("SwiftBrowserLongClickHandler", 1, "the type of HitTestResult is not image type.");
          return false;
          paramView = paramView.getExtra();
          break label101;
          paramView = ((com.tencent.smtt.sdk.WebView)localObject).getHitTestResult();
          if (paramView == null) {
            break;
          }
          i = paramView.getType();
          paramView = paramView.getExtra();
          break label101;
          QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView supportImageQuery invoke result is null.");
          bool2 = false;
          break label149;
          QLog.e("SwiftBrowserLongClickHandler", 1, "X5WebView extension is null. can't get ability of supportImageQuery");
          bool1 = false;
          localObject = paramView;
          j = i;
          continue;
          if (!(paramView instanceof android.webkit.WebView)) {
            break label501;
          }
          paramView = ((android.webkit.WebView)paramView).getHitTestResult();
          if (paramView == null) {
            break;
          }
          j = paramView.getType();
          localObject = paramView.getExtra();
          bool1 = false;
          continue;
        }
        if (TextUtils.isEmpty((CharSequence)localObject))
        {
          QLog.e("SwiftBrowserLongClickHandler", 1, "the image url of HitTestResult is empty.");
          return false;
        }
        if (QLog.isColorLevel()) {
          QLog.d("SwiftBrowserLongClickHandler", 2, "showActionSheet");
        }
        this.imgUrl = ((String)localObject);
        i = k;
        if ((this.s instanceof TeamWorkDocEditBrowserActivity)) {
          i = 1;
        }
        this.d = ausj.d(this.s);
        if (bool1) {
          this.d.addButton(2131691027);
        }
        this.d.addButton(2131691025);
        this.d.addButton(2131691024);
        if (i != 0) {
          this.d.addButton(2131694750);
        }
        this.d.addCancelButton(2131721058);
        VU(this.imgUrl);
        this.d.a(new arbg(this));
        this.d.setOnDismissListener(new arbh(this));
        this.d.setCanceledOnTouchOutside(true);
        try
        {
          this.d.show();
          return true;
        }
        catch (Exception paramView)
        {
          for (;;)
          {
            paramView.printStackTrace();
          }
        }
        label501:
        localObject = "";
        j = 0;
        bool1 = false;
      }
      label514:
      paramView = "";
    }
  }
  
  /* Error */
  public void VV(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: new 268	java/io/File
    //   6: dup
    //   7: aload_1
    //   8: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   11: astore 8
    //   13: new 272	java/io/FileInputStream
    //   16: dup
    //   17: aload 8
    //   19: invokespecial 275	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   22: astore 5
    //   24: aload 5
    //   26: invokevirtual 280	java/io/InputStream:read	()I
    //   29: istore_2
    //   30: aload 5
    //   32: invokevirtual 280	java/io/InputStream:read	()I
    //   35: istore_3
    //   36: aload 5
    //   38: invokevirtual 280	java/io/InputStream:read	()I
    //   41: istore 4
    //   43: iload_2
    //   44: bipush 66
    //   46: if_icmpne +182 -> 228
    //   49: iload_3
    //   50: bipush 77
    //   52: if_icmpne +176 -> 228
    //   55: ldc_w 282
    //   58: astore_1
    //   59: aload 5
    //   61: ifnull +337 -> 398
    //   64: aload 5
    //   66: invokevirtual 285	java/io/InputStream:close	()V
    //   69: aload_1
    //   70: ifnull +294 -> 364
    //   73: aload_0
    //   74: getfield 217	arbf:imgUrl	Ljava/lang/String;
    //   77: invokestatic 291	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   80: invokevirtual 294	android/net/Uri:getLastPathSegment	()Ljava/lang/String;
    //   83: astore 6
    //   85: aload 6
    //   87: invokestatic 211	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   90: ifeq +212 -> 302
    //   93: ldc_w 296
    //   96: astore 5
    //   98: new 268	java/io/File
    //   101: dup
    //   102: getstatic 301	acbn:oM	Ljava/lang/String;
    //   105: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   108: invokevirtual 304	java/io/File:mkdirs	()Z
    //   111: pop
    //   112: new 159	java/lang/StringBuilder
    //   115: dup
    //   116: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   119: getstatic 301	acbn:oM	Ljava/lang/String;
    //   122: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   125: aload 5
    //   127: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_1
    //   131: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   137: astore 7
    //   139: new 268	java/io/File
    //   142: dup
    //   143: aload 7
    //   145: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   148: astore 6
    //   150: iconst_2
    //   151: istore_2
    //   152: aload 6
    //   154: invokevirtual 307	java/io/File:exists	()Z
    //   157: ifeq +179 -> 336
    //   160: iload_2
    //   161: ldc_w 308
    //   164: if_icmpge +172 -> 336
    //   167: new 159	java/lang/StringBuilder
    //   170: dup
    //   171: invokespecial 160	java/lang/StringBuilder:<init>	()V
    //   174: getstatic 301	acbn:oM	Ljava/lang/String;
    //   177: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: aload 5
    //   182: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: ldc_w 310
    //   188: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   191: iload_2
    //   192: invokevirtual 313	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   195: ldc_w 315
    //   198: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_1
    //   202: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   205: invokevirtual 173	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: astore 7
    //   210: new 268	java/io/File
    //   213: dup
    //   214: aload 7
    //   216: invokespecial 270	java/io/File:<init>	(Ljava/lang/String;)V
    //   219: astore 6
    //   221: iload_2
    //   222: iconst_1
    //   223: iadd
    //   224: istore_2
    //   225: goto -73 -> 152
    //   228: iload_2
    //   229: sipush 137
    //   232: if_icmpne +169 -> 401
    //   235: iload_3
    //   236: bipush 80
    //   238: if_icmpne +163 -> 401
    //   241: ldc_w 317
    //   244: astore_1
    //   245: goto -186 -> 59
    //   248: ldc_w 319
    //   251: astore_1
    //   252: goto -193 -> 59
    //   255: astore 5
    //   257: goto -188 -> 69
    //   260: astore_1
    //   261: aconst_null
    //   262: astore 5
    //   264: aload 5
    //   266: ifnull +127 -> 393
    //   269: aload 5
    //   271: invokevirtual 285	java/io/InputStream:close	()V
    //   274: aconst_null
    //   275: astore_1
    //   276: goto -207 -> 69
    //   279: astore_1
    //   280: aconst_null
    //   281: astore_1
    //   282: goto -213 -> 69
    //   285: astore_1
    //   286: aload 6
    //   288: astore 5
    //   290: aload 5
    //   292: ifnull +8 -> 300
    //   295: aload 5
    //   297: invokevirtual 285	java/io/InputStream:close	()V
    //   300: aload_1
    //   301: athrow
    //   302: aload 6
    //   304: astore 5
    //   306: aload 6
    //   308: aload_1
    //   309: invokevirtual 325	java/lang/String:endsWith	(Ljava/lang/String;)Z
    //   312: ifeq -214 -> 98
    //   315: aload 6
    //   317: iconst_0
    //   318: aload 6
    //   320: invokevirtual 328	java/lang/String:length	()I
    //   323: aload_1
    //   324: invokevirtual 328	java/lang/String:length	()I
    //   327: isub
    //   328: invokevirtual 332	java/lang/String:substring	(II)Ljava/lang/String;
    //   331: astore 5
    //   333: goto -235 -> 98
    //   336: aload 8
    //   338: aload 6
    //   340: invokevirtual 336	java/io/File:renameTo	(Ljava/io/File;)Z
    //   343: ifeq +21 -> 364
    //   346: aload_0
    //   347: getfield 38	arbf:s	Landroid/app/Activity;
    //   350: new 338	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$5
    //   353: dup
    //   354: aload_0
    //   355: aload 7
    //   357: invokespecial 339	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$5:<init>	(Larbf;Ljava/lang/String;)V
    //   360: invokevirtual 343	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   363: return
    //   364: aload_0
    //   365: getfield 38	arbf:s	Landroid/app/Activity;
    //   368: new 345	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$6
    //   371: dup
    //   372: aload_0
    //   373: invokespecial 346	com/tencent/mobileqq/webview/swift/component/SwiftBrowserLongClickHandler$6:<init>	(Larbf;)V
    //   376: invokevirtual 343	android/app/Activity:runOnUiThread	(Ljava/lang/Runnable;)V
    //   379: return
    //   380: astore 5
    //   382: goto -82 -> 300
    //   385: astore_1
    //   386: goto -96 -> 290
    //   389: astore_1
    //   390: goto -126 -> 264
    //   393: aconst_null
    //   394: astore_1
    //   395: goto -326 -> 69
    //   398: goto -329 -> 69
    //   401: iload_2
    //   402: bipush 71
    //   404: if_icmpne +16 -> 420
    //   407: iload_3
    //   408: bipush 73
    //   410: if_icmpne +10 -> 420
    //   413: ldc_w 348
    //   416: astore_1
    //   417: goto -358 -> 59
    //   420: iload_2
    //   421: sipush 255
    //   424: if_icmpne +17 -> 441
    //   427: iload_3
    //   428: sipush 216
    //   431: if_icmpne +10 -> 441
    //   434: ldc_w 350
    //   437: astore_1
    //   438: goto -379 -> 59
    //   441: bipush 82
    //   443: iload_2
    //   444: if_icmpne -196 -> 248
    //   447: bipush 73
    //   449: iload_3
    //   450: if_icmpne -202 -> 248
    //   453: bipush 70
    //   455: iload 4
    //   457: if_icmpne -209 -> 248
    //   460: ldc_w 352
    //   463: astore_1
    //   464: goto -405 -> 59
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	467	0	this	arbf
    //   0	467	1	paramString	String
    //   29	416	2	i	int
    //   35	416	3	j	int
    //   41	417	4	k	int
    //   22	159	5	localObject1	Object
    //   255	1	5	localIOException1	java.io.IOException
    //   262	70	5	localObject2	Object
    //   380	1	5	localIOException2	java.io.IOException
    //   1	338	6	localObject3	Object
    //   137	219	7	str	String
    //   11	326	8	localFile	java.io.File
    // Exception table:
    //   from	to	target	type
    //   64	69	255	java/io/IOException
    //   13	24	260	java/io/IOException
    //   269	274	279	java/io/IOException
    //   13	24	285	finally
    //   295	300	380	java/io/IOException
    //   24	43	385	finally
    //   24	43	389	java/io/IOException
  }
  
  public void VW(String paramString)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", paramString);
    localBundle.putString("forward_extra", paramString);
    localBundle.putBoolean("not_forward", true);
    localBundle.putString("forward_thumb", paramString);
    localBundle.putBoolean("isFromShare", true);
    localBundle.putBoolean("isJumpAIO", true);
    paramString = new Intent();
    paramString.putExtras(localBundle);
    ahgq.f(this.s, paramString, 21);
  }
  
  public void VX(String paramString)
  {
    if (this.a == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. mComponentContext is null");
      return;
    }
    Object localObject = this.a.getWebView();
    if (localObject == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. x5WebView is null");
      return;
    }
    localObject = ((com.tencent.smtt.sdk.WebView)localObject).getX5WebViewExtension();
    if (localObject == null)
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. extension is null");
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      QLog.e("SwiftBrowserLongClickHandler", 1, "x5QueryImage. filePath is null");
      return;
    }
    ThreadManager.excute(new SwiftBrowserLongClickHandler.7(this, paramString, (IX5WebViewExtension)localObject), 64, null, true);
  }
  
  public boolean aGd()
  {
    if ((this.m != null) && (this.m.isShowing())) {
      this.m.dismiss();
    }
    for (;;)
    {
      synchronized (this.fC)
      {
        if ((TextUtils.isEmpty(this.czd)) || (!this.czd.equals(this.mTempPath)) || (this.eed <= 0)) {
          break label142;
        }
        bool2 = rvx.fa(this.eed);
        bool1 = rvx.fb(this.eed);
        if (bool2)
        {
          gw(this.mTempPath, 1);
          return true;
        }
      }
      if (bool1)
      {
        gw(this.mTempPath, 2);
        return true;
      }
      QQToast.a(this.s.getApplicationContext(), 1, 2131690460, 1).show(this.baA);
      return false;
      label142:
      boolean bool1 = false;
      boolean bool2 = false;
    }
  }
  
  void gw(String paramString, int paramInt)
  {
    Intent localIntent = new Intent(this.s, ScannerActivity.class);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("detectType", paramInt);
    localIntent.putExtra("QRDecode", true);
    localIntent.putExtra("QRDecodeResult", paramString);
    String str = this.imgUrl;
    paramString = str;
    if (!TextUtils.isEmpty(str))
    {
      paramString = str;
      if (str.startsWith("data:")) {
        paramString = "";
      }
    }
    localIntent.putExtra("report_params", rvx.a(null, paramString, null, null, null, 5));
    this.s.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arbf
 * JD-Core Version:    0.7.0.1
 */