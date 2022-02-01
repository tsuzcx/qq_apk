import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.media.ThumbnailUtils;
import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.troop.homework.xmediaeditor.XMediaEditor;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.CompressVideoSegment.1;
import com.tencent.mobileqq.troop.homework.xmediaeditor.model.VideoInfo.GenerateVideoPosterSegment.1;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.JobContext;
import com.tribe.async.async.JobSegment;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;
import com.tribe.async.reactive.UIThreadOffFunction;
import java.io.File;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;
import mqq.os.MqqHandler;
import org.json.JSONException;
import org.json.JSONObject;

public class apkv
  extends apks
{
  public String cpS;
  public String mVideoPath;
  public String mVideoUrl;
  
  public apkv(String paramString)
  {
    this.mVideoPath = paramString;
    eaz();
    this.cpR = String.valueOf(hashCode());
  }
  
  public apkv(JSONObject paramJSONObject)
    throws JSONException
  {
    bN(paramJSONObject);
    this.cpR = String.valueOf(hashCode());
  }
  
  /* Error */
  private void eaz()
  {
    // Byte code:
    //   0: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   3: lstore_2
    //   4: aload_0
    //   5: getfield 21	apkv:mVideoPath	Ljava/lang/String;
    //   8: invokestatic 61	ahbj:fileExistsAndNotEmpty	(Ljava/lang/String;)Z
    //   11: ifeq +386 -> 397
    //   14: aconst_null
    //   15: astore 4
    //   17: new 63	android/media/MediaMetadataRetriever
    //   20: dup
    //   21: invokespecial 64	android/media/MediaMetadataRetriever:<init>	()V
    //   24: astore 5
    //   26: aload 5
    //   28: astore 4
    //   30: aload 5
    //   32: aload_0
    //   33: getfield 21	apkv:mVideoPath	Ljava/lang/String;
    //   36: invokevirtual 67	android/media/MediaMetadataRetriever:setDataSource	(Ljava/lang/String;)V
    //   39: aload 5
    //   41: astore 4
    //   43: aload_0
    //   44: aload 5
    //   46: bipush 18
    //   48: invokevirtual 70	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   51: invokestatic 75	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   54: invokevirtual 78	java/lang/Integer:intValue	()I
    //   57: putfield 82	apkv:mWidth	I
    //   60: aload 5
    //   62: astore 4
    //   64: aload_0
    //   65: aload 5
    //   67: bipush 19
    //   69: invokevirtual 70	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   72: invokestatic 75	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   75: invokevirtual 78	java/lang/Integer:intValue	()I
    //   78: putfield 85	apkv:mHeight	I
    //   81: aload 5
    //   83: astore 4
    //   85: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   88: bipush 17
    //   90: if_icmplt +104 -> 194
    //   93: aload 5
    //   95: astore 4
    //   97: aload 5
    //   99: bipush 24
    //   101: invokevirtual 70	android/media/MediaMetadataRetriever:extractMetadata	(I)Ljava/lang/String;
    //   104: invokestatic 75	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   107: invokevirtual 78	java/lang/Integer:intValue	()I
    //   110: istore_1
    //   111: aload 5
    //   113: astore 4
    //   115: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   118: ifeq +347 -> 465
    //   121: aload 5
    //   123: astore 4
    //   125: ldc 98
    //   127: iconst_2
    //   128: iconst_4
    //   129: anewarray 26	java/lang/Object
    //   132: dup
    //   133: iconst_0
    //   134: ldc 100
    //   136: aastore
    //   137: dup
    //   138: iconst_1
    //   139: getstatic 90	android/os/Build$VERSION:SDK_INT	I
    //   142: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   145: aastore
    //   146: dup
    //   147: iconst_2
    //   148: ldc 105
    //   150: aastore
    //   151: dup
    //   152: iconst_3
    //   153: iload_1
    //   154: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   157: aastore
    //   158: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   161: goto +304 -> 465
    //   164: aload 5
    //   166: astore 4
    //   168: aload_0
    //   169: getfield 82	apkv:mWidth	I
    //   172: istore_1
    //   173: aload 5
    //   175: astore 4
    //   177: aload_0
    //   178: aload_0
    //   179: getfield 85	apkv:mHeight	I
    //   182: putfield 82	apkv:mWidth	I
    //   185: aload 5
    //   187: astore 4
    //   189: aload_0
    //   190: iload_1
    //   191: putfield 85	apkv:mHeight	I
    //   194: aload 5
    //   196: astore 4
    //   198: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   201: ifeq +78 -> 279
    //   204: aload 5
    //   206: astore 4
    //   208: ldc 98
    //   210: iconst_2
    //   211: bipush 8
    //   213: anewarray 26	java/lang/Object
    //   216: dup
    //   217: iconst_0
    //   218: ldc 111
    //   220: aastore
    //   221: dup
    //   222: iconst_1
    //   223: aload_0
    //   224: getfield 21	apkv:mVideoPath	Ljava/lang/String;
    //   227: aastore
    //   228: dup
    //   229: iconst_2
    //   230: ldc 113
    //   232: aastore
    //   233: dup
    //   234: iconst_3
    //   235: aload_0
    //   236: getfield 82	apkv:mWidth	I
    //   239: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   242: aastore
    //   243: dup
    //   244: iconst_4
    //   245: ldc 115
    //   247: aastore
    //   248: dup
    //   249: iconst_5
    //   250: aload_0
    //   251: getfield 85	apkv:mHeight	I
    //   254: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   257: aastore
    //   258: dup
    //   259: bipush 6
    //   261: ldc 117
    //   263: aastore
    //   264: dup
    //   265: bipush 7
    //   267: invokestatic 55	java/lang/System:currentTimeMillis	()J
    //   270: lload_2
    //   271: lsub
    //   272: invokestatic 122	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   275: aastore
    //   276: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   279: aload 5
    //   281: astore 4
    //   283: aload_0
    //   284: getfield 82	apkv:mWidth	I
    //   287: ifle +14 -> 301
    //   290: aload 5
    //   292: astore 4
    //   294: aload_0
    //   295: getfield 85	apkv:mHeight	I
    //   298: ifgt +89 -> 387
    //   301: aload 5
    //   303: astore 4
    //   305: aload_0
    //   306: aload_0
    //   307: getfield 125	apkv:mMaxWidth	I
    //   310: putfield 82	apkv:mWidth	I
    //   313: aload 5
    //   315: astore 4
    //   317: aload_0
    //   318: aload_0
    //   319: getfield 125	apkv:mMaxWidth	I
    //   322: bipush 9
    //   324: imul
    //   325: i2f
    //   326: ldc 126
    //   328: fdiv
    //   329: f2i
    //   330: putfield 85	apkv:mHeight	I
    //   333: aload 5
    //   335: astore 4
    //   337: invokestatic 96	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +47 -> 387
    //   343: aload 5
    //   345: astore 4
    //   347: ldc 98
    //   349: iconst_2
    //   350: iconst_4
    //   351: anewarray 26	java/lang/Object
    //   354: dup
    //   355: iconst_0
    //   356: ldc 128
    //   358: aastore
    //   359: dup
    //   360: iconst_1
    //   361: aload_0
    //   362: getfield 82	apkv:mWidth	I
    //   365: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   368: aastore
    //   369: dup
    //   370: iconst_2
    //   371: ldc 115
    //   373: aastore
    //   374: dup
    //   375: iconst_3
    //   376: aload_0
    //   377: getfield 85	apkv:mHeight	I
    //   380: invokestatic 103	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   383: aastore
    //   384: invokestatic 109	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   387: aload 5
    //   389: ifnull +8 -> 397
    //   392: aload 5
    //   394: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   397: return
    //   398: astore 4
    //   400: aconst_null
    //   401: astore 5
    //   403: aload 5
    //   405: astore 4
    //   407: ldc 98
    //   409: iconst_1
    //   410: iconst_2
    //   411: anewarray 26	java/lang/Object
    //   414: dup
    //   415: iconst_0
    //   416: ldc 133
    //   418: aastore
    //   419: dup
    //   420: iconst_1
    //   421: aload_0
    //   422: getfield 21	apkv:mVideoPath	Ljava/lang/String;
    //   425: aastore
    //   426: invokestatic 136	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;I[Ljava/lang/Object;)V
    //   429: aload 5
    //   431: ifnull -34 -> 397
    //   434: aload 5
    //   436: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   439: return
    //   440: astore 5
    //   442: aload 4
    //   444: ifnull +8 -> 452
    //   447: aload 4
    //   449: invokevirtual 131	android/media/MediaMetadataRetriever:release	()V
    //   452: aload 5
    //   454: athrow
    //   455: astore 5
    //   457: goto -15 -> 442
    //   460: astore 4
    //   462: goto -59 -> 403
    //   465: iload_1
    //   466: bipush 90
    //   468: if_icmpeq -304 -> 164
    //   471: iload_1
    //   472: sipush 270
    //   475: if_icmpne -281 -> 194
    //   478: goto -314 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	481	0	this	apkv
    //   110	366	1	i	int
    //   3	268	2	l	long
    //   15	331	4	localObject1	Object
    //   398	1	4	localException1	Exception
    //   405	43	4	localObject2	Object
    //   460	1	4	localException2	Exception
    //   24	411	5	localMediaMetadataRetriever	MediaMetadataRetriever
    //   440	13	5	localObject3	Object
    //   455	1	5	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   17	26	398	java/lang/Exception
    //   17	26	440	finally
    //   30	39	455	finally
    //   43	60	455	finally
    //   64	81	455	finally
    //   85	93	455	finally
    //   97	111	455	finally
    //   115	121	455	finally
    //   125	161	455	finally
    //   168	173	455	finally
    //   177	185	455	finally
    //   189	194	455	finally
    //   198	204	455	finally
    //   208	279	455	finally
    //   283	290	455	finally
    //   294	301	455	finally
    //   305	313	455	finally
    //   317	333	455	finally
    //   337	343	455	finally
    //   347	387	455	finally
    //   407	429	455	finally
    //   30	39	460	java/lang/Exception
    //   43	60	460	java/lang/Exception
    //   64	81	460	java/lang/Exception
    //   85	93	460	java/lang/Exception
    //   97	111	460	java/lang/Exception
    //   115	121	460	java/lang/Exception
    //   125	161	460	java/lang/Exception
    //   168	173	460	java/lang/Exception
    //   177	185	460	java/lang/Exception
    //   189	194	460	java/lang/Exception
    //   198	204	460	java/lang/Exception
    //   208	279	460	java/lang/Exception
    //   283	290	460	java/lang/Exception
    //   294	301	460	java/lang/Exception
    //   305	313	460	java/lang/Exception
    //   317	333	460	java/lang/Exception
    //   337	343	460	java/lang/Exception
    //   347	387	460	java/lang/Exception
  }
  
  public String Bq()
  {
    if (TextUtils.isEmpty(this.mVideoPath)) {
      return this.mVideoUrl;
    }
    return this.mVideoPath;
  }
  
  public String Bs()
  {
    if (TextUtils.isEmpty(this.mVideoPath)) {
      return this.mVideoUrl;
    }
    return this.mVideoPath;
  }
  
  public void SZ(String paramString)
  {
    try
    {
      this.n = new URL(paramString);
      this.mImageUrl = paramString;
      return;
    }
    catch (MalformedURLException paramString)
    {
      QLog.e("VideoInfo", 1, "Video setURLFromContentUrl exception.");
    }
  }
  
  public Stream<apks> a(XMediaEditor paramXMediaEditor)
  {
    Object localObject2 = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
    Object localObject1 = localObject2;
    if (!ahbj.fileExistsAndNotEmpty(this.cpS))
    {
      if (this.mUploadStatus >= 0) {
        this.mUploadStatus = -2147483646;
      }
      localObject1 = ((Stream)localObject2).map(new apkv.a(paramXMediaEditor));
    }
    String str = paramXMediaEditor.oG("troopuin");
    localObject2 = localObject1;
    if (TextUtils.isEmpty(this.mVideoUrl))
    {
      if (this.mUploadStatus >= 0) {
        this.mUploadStatus = -2147483647;
      }
      localObject2 = ((Stream)localObject1).map(new apks.b(1, paramXMediaEditor, str));
    }
    if (TextUtils.isEmpty(this.mImageUrl)) {
      if (this.mUploadStatus >= 0) {
        this.mUploadStatus = -2147483648;
      }
    }
    for (localObject1 = ((Stream)localObject2).map(new apks.b(2, paramXMediaEditor, str));; localObject1 = localObject2)
    {
      localObject2 = paramXMediaEditor.findViewHolderForLayoutPosition(this.mPosition);
      if ((localObject2 instanceof aplq.a))
      {
        localObject2 = (aplq.a)localObject2;
        if (this.cpR.equals(((aplq.a)localObject2).d.getTag())) {
          ((aplq)((apkk)paramXMediaEditor.getAdapter()).a.a(2)).a((aple.a)localObject2, this, 0);
        }
      }
      return ((Stream)localObject1).map(new UIThreadOffFunction(null));
    }
  }
  
  public boolean aBi()
  {
    return !TextUtils.isEmpty(this.mVideoUrl);
  }
  
  public boolean aBj()
  {
    return (TextUtils.isEmpty(this.mVideoUrl)) || (TextUtils.isEmpty(this.mImageUrl));
  }
  
  public JSONObject af()
  {
    JSONObject localJSONObject = new JSONObject();
    try
    {
      localJSONObject.put("type", "video");
      localJSONObject.put("url", this.mVideoUrl);
      localJSONObject.put("width", this.mWidth);
      localJSONObject.put("height", this.mHeight);
      localJSONObject.put("poster", this.mImageUrl);
      return localJSONObject;
    }
    catch (JSONException localJSONException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("VideoInfo", 2, "VideoInfo getContent exception.");
    }
    return localJSONObject;
  }
  
  public Stream<apkv> b(XMediaEditor paramXMediaEditor)
  {
    this.mUploadStatus = 1;
    Object localObject;
    if (ahbj.fileExistsAndNotEmpty(this.cpQ)) {
      localObject = null;
    }
    Stream localStream;
    do
    {
      return localObject;
      localStream = Stream.of(this).map(new ThreadOffFunction("VideoInfo", 2));
      localObject = localStream;
    } while (ahbj.fileExistsAndNotEmpty(this.cpQ));
    this.mUploadStatus = -2147483645;
    return localStream.map(new apkv.b(paramXMediaEditor, this.mMaxWidth)).map(new UIThreadOffFunction(null));
  }
  
  public void bN(JSONObject paramJSONObject)
    throws JSONException
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoInfo", 2, new Object[] { "VideoInfo createFrom json: ", paramJSONObject });
    }
    this.mData = paramJSONObject;
    SZ(paramJSONObject.optString("poster"));
    this.mWidth = paramJSONObject.optInt("width");
    this.mHeight = paramJSONObject.optInt("height");
    this.mVideoUrl = paramJSONObject.optString("url");
    if (!TextUtils.isEmpty(this.mVideoUrl)) {
      this.mVideoUrl = this.mVideoUrl.replace("https://", "http://");
    }
  }
  
  public int getType()
  {
    return 2;
  }
  
  public int sz()
  {
    switch (this.mUploadStatus)
    {
    default: 
      return this.mUploadStatus;
    }
    return 1;
  }
  
  public static class a
    extends JobSegment<apks, apks>
  {
    private boolean cRe;
    private WeakReference<XMediaEditor> ie;
    
    public a(XMediaEditor paramXMediaEditor)
    {
      this.ie = new WeakReference(paramXMediaEditor);
    }
    
    protected void a(JobContext paramJobContext, apks paramapks)
    {
      apkv localapkv = (apkv)paramapks;
      if (QLog.isColorLevel()) {
        QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment start. info status=", Integer.valueOf(localapkv.mUploadStatus) });
      }
      String str = apks.Br();
      XMediaEditor localXMediaEditor;
      int i;
      for (;;)
      {
        try
        {
          localXMediaEditor = (XMediaEditor)this.ie.get();
          if (localXMediaEditor == null) {
            continue;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment sourceVideoPath=", localapkv.mVideoPath });
          }
          str = aqul.getSDKPrivatePath(str + localapkv.mVideoPath.substring(localapkv.mVideoPath.lastIndexOf("/") + 1, localapkv.mVideoPath.lastIndexOf(".")) + System.currentTimeMillis() + ahbj.getExtension(localapkv.mVideoPath));
          i = awjs.f(localXMediaEditor.getContext(), localapkv.mVideoPath, str);
          if (QLog.isColorLevel()) {
            QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideo ret:", Integer.valueOf(i) });
          }
          if (i != 1) {
            break label414;
          }
          str = localapkv.mVideoPath;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          label217:
          QLog.e("CompressVideoSegment", 1, "CompressVideoSegment error. OutOfMemoryError");
          URLDrawable.clearMemoryCache();
          System.gc();
          if (this.cRe) {
            continue;
          }
          this.cRe = true;
          a(paramJobContext, paramapks);
          return;
          notifyError(new Error("-200"));
          return;
          notifyError(new Error("0"));
          return;
          notifyError(new Error("-1"));
          return;
        }
        if (ahbj.fileExistsAndNotEmpty(str))
        {
          if (ahbj.getFileSize(str) > 104857600L)
          {
            notifyError(new Error("200"));
            return;
          }
          localapkv.cpS = str;
          ThreadManager.getUIHandler().post(new VideoInfo.CompressVideoSegment.1(this, localapkv, localXMediaEditor));
          if (isCanceled()) {
            return;
          }
          if (QLog.isColorLevel()) {
            QLog.d("CompressVideoSegment", 2, new Object[] { "CompressVideoSegment notifyResult. mVideoCompressedPath=", localapkv.cpS, ", info status=", Integer.valueOf(localapkv.mUploadStatus) });
          }
          notifyResult(localapkv);
          return;
        }
        label414:
        if (i != 0) {
          if (i != 1) {
            break label217;
          }
        }
      }
    }
    
    public void onCancel()
    {
      notifyError(new Error("c_2001"));
    }
  }
  
  public static class b
    extends JobSegment<apkv, apkv>
  {
    private boolean cRe;
    private WeakReference<XMediaEditor> ie;
    private int mMaxWidth;
    
    public b(XMediaEditor paramXMediaEditor, int paramInt)
    {
      this.ie = new WeakReference(paramXMediaEditor);
      this.mMaxWidth = paramInt;
    }
    
    protected void a(JobContext paramJobContext, apkv paramapkv)
    {
      if (QLog.isColorLevel()) {
        QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment start. info status=", Integer.valueOf(paramapkv.mUploadStatus) });
      }
      String str2 = apks.Br();
      MediaMetadataRetriever localMediaMetadataRetriever = new MediaMetadataRetriever();
      String str1 = null;
      Object localObject4 = null;
      Bitmap localBitmap2 = null;
      Bitmap localBitmap1 = localBitmap2;
      Object localObject3 = str1;
      Object localObject1 = localObject4;
      for (;;)
      {
        try
        {
          localMediaMetadataRetriever.setDataSource(paramapkv.mVideoPath);
          localBitmap1 = localBitmap2;
          localObject3 = str1;
          localObject1 = localObject4;
          localBitmap3 = localMediaMetadataRetriever.getFrameAtTime(-1L);
          if (localBitmap3 == null)
          {
            localBitmap1 = localBitmap2;
            localObject3 = str1;
            localObject1 = localObject4;
            notifyError(new Error("-201"));
          }
        }
        catch (Exception paramJobContext)
        {
          Bitmap localBitmap3;
          int[] arrayOfInt;
          localObject1 = localBitmap1;
          QLog.e("GenerateVideoPosterSegment", 1, "error retrieve video info" + paramJobContext.getMessage());
          localObject1 = localBitmap1;
          notifyError(new Error("-201"));
          try
          {
            localMediaMetadataRetriever.release();
            if (localBitmap1 == null) {
              continue;
            }
            localBitmap1.recycle();
            return;
          }
          catch (RuntimeException paramJobContext)
          {
            return;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localObject2 = localObject3;
          QLog.e("GenerateVideoPosterSegment", 1, "GenerateVideoPosterSegment error. OutOfMemoryError");
          localObject2 = localObject3;
          URLDrawable.clearMemoryCache();
          localObject2 = localObject3;
          System.gc();
          localObject2 = localObject3;
          if (!this.cRe)
          {
            localObject2 = localObject3;
            this.cRe = true;
            localObject2 = localObject3;
            a(paramJobContext, paramapkv);
            try
            {
              localMediaMetadataRetriever.release();
              if (localObject3 == null) {
                continue;
              }
              ((Bitmap)localObject3).recycle();
              return;
            }
            catch (RuntimeException paramJobContext)
            {
              return;
            }
          }
          localObject2 = localObject3;
          notifyError(new Error("-1"));
          continue;
        }
        finally
        {
          try
          {
            Object localObject2;
            localMediaMetadataRetriever.release();
            if (localObject2 != null) {
              localObject2.recycle();
            }
          }
          catch (RuntimeException paramapkv)
          {
            continue;
          }
        }
        try
        {
          localMediaMetadataRetriever.release();
          if (0 != 0) {
            throw new NullPointerException();
          }
          return;
        }
        catch (RuntimeException paramJobContext) {}
        localBitmap1 = localBitmap2;
        localObject3 = str1;
        localObject1 = localObject4;
        arrayOfInt = aple.a(this.mMaxWidth, 200, 300, paramapkv.mWidth, paramapkv.mHeight);
        localBitmap1 = localBitmap2;
        localObject3 = str1;
        localObject1 = localObject4;
        localBitmap2 = ThumbnailUtils.extractThumbnail(localBitmap3, arrayOfInt[0], arrayOfInt[1]);
        if (localBitmap2 == null)
        {
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          notifyError(new Error("-201"));
          try
          {
            localMediaMetadataRetriever.release();
            if (localBitmap2 == null) {
              continue;
            }
            localBitmap2.recycle();
            return;
          }
          catch (RuntimeException paramJobContext) {}
        }
        else
        {
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          str1 = aqul.getSDKPrivatePath(str2 + "videoThumb_" + System.currentTimeMillis() + ".jpg");
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          aqhu.saveBitmapToFile(localBitmap2, new File(str1));
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          paramapkv.cpQ = str1;
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          ThreadManager.getUIHandler().post(new VideoInfo.GenerateVideoPosterSegment.1(this, paramapkv, str1));
          localBitmap1 = localBitmap2;
          localObject3 = localBitmap2;
          localObject1 = localBitmap2;
          if (!isCanceled())
          {
            localBitmap1 = localBitmap2;
            localObject3 = localBitmap2;
            localObject1 = localBitmap2;
            if (QLog.isColorLevel())
            {
              localBitmap1 = localBitmap2;
              localObject3 = localBitmap2;
              localObject1 = localBitmap2;
              QLog.d("GenerateVideoPosterSegment", 2, new Object[] { "GenerateVideoPosterSegment notifyResult. info status=", Integer.valueOf(paramapkv.mUploadStatus) });
            }
            localBitmap1 = localBitmap2;
            localObject3 = localBitmap2;
            localObject1 = localBitmap2;
            notifyResult(paramapkv);
          }
          try
          {
            localMediaMetadataRetriever.release();
            if (localBitmap2 != null)
            {
              localBitmap2.recycle();
              return;
            }
          }
          catch (RuntimeException paramJobContext) {}
        }
      }
    }
    
    public void onCancel()
    {
      notifyError(new Error("c_2000"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apkv
 * JD-Core Version:    0.7.0.1
 */