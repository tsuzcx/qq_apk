import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.widget.AsyncImageView;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import mqq.os.MqqHandler;

public final class agym
  implements Handler.Callback
{
  private final View Dj;
  private final MqqHandler H;
  private final agyi a;
  private Bitmap fi;
  private arhz m;
  private final MqqHandler q;
  private volatile boolean uU;
  
  public agym(agyi paramagyi, ViewGroup paramViewGroup)
  {
    this.a = paramagyi;
    this.Dj = paramagyi.e().getLayoutInflater().inflate(2131561042, paramViewGroup, false);
    int i = View.MeasureSpec.makeMeasureSpec(0, 0);
    this.Dj.measure(i, i);
    TextView localTextView1 = (TextView)this.Dj.findViewById(2131375309);
    TextView localTextView2 = (TextView)this.Dj.findViewById(2131375307);
    paramViewGroup = (AsyncImageView)this.Dj.findViewById(2131375308);
    String str = paramagyi.getFileName();
    int j = paramagyi.getFileType();
    localTextView1.setText(ahav.a(str, true, localTextView1.getMeasuredWidth(), localTextView1.getPaint(), 2));
    localTextView2.setText(ahbj.g(paramagyi.getFileSize()));
    paramViewGroup.setImageResource(ahav.r(str));
    if ((j == 5) || (j == 0))
    {
      paramagyi = paramagyi.getFilePath();
      if (ahbj.fileExistsAndNotEmpty(paramagyi))
      {
        if (j != 5) {
          break label268;
        }
        paramViewGroup.setApkIconAsyncImage(paramagyi);
      }
    }
    for (;;)
    {
      paramViewGroup.setSupportMaskView(false);
      ((AsyncImageView)this.Dj.findViewById(2131375288)).setSupportMaskView(false);
      this.Dj.measure(i, i);
      this.Dj.layout(0, 0, this.Dj.getMeasuredWidth(), this.Dj.getMeasuredHeight());
      this.q = new aurf(Looper.getMainLooper(), this, true);
      this.H = new aurf(ThreadManagerV2.getFileThreadLooper(), this, false);
      return;
      label268:
      paramViewGroup.setAsyncImage(paramagyi);
    }
  }
  
  private Bitmap a(Bitmap paramBitmap, int paramInt, String paramString)
  {
    if (paramBitmap == null) {
      return null;
    }
    localAsyncImageView = (AsyncImageView)this.Dj.findViewById(2131375288);
    localAsyncImageView.setImageBitmap(paramBitmap);
    TextView localTextView = (TextView)this.Dj.findViewById(2131375311);
    BaseApplicationImpl localBaseApplicationImpl = BaseApplicationImpl.sApplication;
    if (TextUtils.isEmpty(paramString))
    {
      paramBitmap = new StringBuilder().append(BaseApplicationImpl.sApplication.getString(2131700336)).append(":");
      paramString = BaseApplicationImpl.sApplication;
      if (paramInt == 1) {
        paramInt = 2131700334;
      }
    }
    for (paramBitmap = paramString.getString(paramInt);; paramBitmap = BaseApplicationImpl.sApplication.getString(2131700337) + ":" + paramString)
    {
      localTextView.setText(localBaseApplicationImpl.getString(2131700327, new Object[] { paramBitmap }));
      try
      {
        paramBitmap = Bitmap.createBitmap(this.Dj.getMeasuredWidth(), this.Dj.getMeasuredHeight(), Bitmap.Config.ARGB_8888);
        this.Dj.draw(new Canvas(paramBitmap));
        return paramBitmap;
      }
      catch (Throwable paramBitmap)
      {
        QLog.e("WeiyunShareQrController<FileAssistant>", 2, "mergeQrPanel error", paramBitmap);
        return null;
      }
      finally
      {
        localAsyncImageView.setImageDrawable(null);
      }
      if (paramInt == 2)
      {
        paramInt = 2131700333;
        break;
      }
      paramInt = 2131700335;
      break;
    }
  }
  
  private void a(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem, Bitmap paramBitmap, String paramString)
  {
    if (paramActionSheetItem == null) {}
    int i;
    Object localObject;
    do
    {
      return;
      i = paramActionSheetItem.action;
      localObject = this.a.e();
    } while ((localObject == null) || (((BaseActivity)localObject).isFinishing()));
    if (this.m != null) {
      this.m.dismiss();
    }
    if ("".equals(paramString))
    {
      agyj.B(1, 2131698712, true);
      return;
    }
    if (paramString == null)
    {
      if (i == 39) {}
      for (i = 2131717216;; i = 2131698711)
      {
        agyj.B(1, i, true);
        return;
      }
    }
    switch (i)
    {
    default: 
      return;
    case 2: 
      paramActionSheetItem = new Intent();
      paramActionSheetItem.putExtra("isFromShare", true);
      paramActionSheetItem.putExtra("forward_type", 1);
      paramActionSheetItem.putExtra("forward_filepath", paramString);
      paramActionSheetItem.putExtra("forward_thumb", paramString);
      paramActionSheetItem.putExtra("forward_urldrawable_big_url", paramString);
      paramActionSheetItem.putExtra("forward_extra", paramString);
      ahgq.a((Activity)localObject, paramActionSheetItem, 1, -1);
      return;
    case 3: 
      paramActionSheetItem = avpw.d.a();
      paramBitmap = ((BaseActivity)localObject).getAppInterface();
      paramActionSheetItem.cMP = paramBitmap.getAccount();
      paramActionSheetItem.nickname = paramBitmap.getDisplayName(0, paramBitmap.getCurrentAccountUin(), null);
      avpw.a((Activity)localObject, paramActionSheetItem, paramString, ((BaseActivity)localObject).getString(2131693309), ((BaseActivity)localObject).getString(2131700327, new Object[] { "" }), 2);
      return;
    case 9: 
    case 10: 
      paramActionSheetItem = this.a.vS();
      localObject = WXShareHelper.a();
      if (i == 9) {}
      for (i = 0;; i = 1)
      {
        ((WXShareHelper)localObject).a(paramString, paramBitmap, i, true, paramActionSheetItem);
        return;
      }
    case 39: 
      paramActionSheetItem = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      paramActionSheetItem.setData(Uri.parse("file://" + paramString));
      ((BaseActivity)localObject).sendBroadcast(paramActionSheetItem);
      agyj.p(2, ((BaseActivity)localObject).getString(2131717218, new Object[] { paramString }), true);
      return;
    }
    paramBitmap = new Bundle();
    paramBitmap.putInt("key_req", ForwardRecentActivity.bGS);
    paramBitmap.putInt("key_direct_show_uin_type", paramActionSheetItem.uinType);
    paramBitmap.putString("key_direct_show_uin", paramActionSheetItem.uin);
    paramActionSheetItem = new Intent();
    paramActionSheetItem.putExtra("isFromShare", true);
    paramActionSheetItem.putExtra("forward_type", 1);
    paramActionSheetItem.putExtra("forward_filepath", paramString);
    paramActionSheetItem.putExtra("forward_thumb", paramString);
    paramActionSheetItem.putExtra("forward_urldrawable_big_url", paramString);
    paramActionSheetItem.putExtra("forward_extra", paramString);
    paramActionSheetItem.putExtras(paramBitmap);
    ahgq.a((Activity)localObject, paramActionSheetItem, ForwardRecentTranslucentActivity.class, 1, -1, "");
  }
  
  private void ai(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleSaveBitmap: args are invalid");
    }
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)paramArrayOfObject[0];
    Bitmap localBitmap = (Bitmap)paramArrayOfObject[1];
    if (((Boolean)paramArrayOfObject[2]).booleanValue()) {}
    for (paramArrayOfObject = g(localBitmap);; paramArrayOfObject = c(localBitmap))
    {
      Message localMessage = new Message();
      localMessage.what = 2;
      localMessage.obj = new Object[] { localActionSheetItem, localBitmap, paramArrayOfObject };
      this.q.sendMessage(localMessage);
      return;
    }
  }
  
  private void aj(Object[] paramArrayOfObject)
  {
    if ((paramArrayOfObject == null) || (paramArrayOfObject.length < 3)) {
      throw new IllegalArgumentException("handleShareRelay: args are invalid");
    }
    a((ShareActionSheetBuilder.ActionSheetItem)paramArrayOfObject[0], (Bitmap)paramArrayOfObject[1], (String)paramArrayOfObject[2]);
  }
  
  /* Error */
  private static String c(Bitmap paramBitmap)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 6
    //   6: iconst_2
    //   7: istore_1
    //   8: aload_0
    //   9: ifnull +366 -> 375
    //   12: aload_0
    //   13: invokevirtual 456	android/graphics/Bitmap:isRecycled	()Z
    //   16: ifne +359 -> 375
    //   19: new 458	com/tencent/mm/vfs/VFSFile
    //   22: dup
    //   23: getstatic 463	acbn:oM	Ljava/lang/String;
    //   26: invokespecial 464	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   29: astore_3
    //   30: aload_3
    //   31: invokevirtual 467	com/tencent/mm/vfs/VFSFile:mkdirs	()Z
    //   34: pop
    //   35: aload_3
    //   36: invokevirtual 470	com/tencent/mm/vfs/VFSFile:canWrite	()Z
    //   39: ifeq +336 -> 375
    //   42: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   45: invokestatic 479	java/lang/Long:toString	(J)Ljava/lang/String;
    //   48: astore_3
    //   49: new 458	com/tencent/mm/vfs/VFSFile
    //   52: dup
    //   53: new 182	java/lang/StringBuilder
    //   56: dup
    //   57: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   60: getstatic 463	acbn:oM	Ljava/lang/String;
    //   63: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   66: ldc_w 481
    //   69: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: invokestatic 475	java/lang/System:currentTimeMillis	()J
    //   75: invokevirtual 484	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   78: ldc_w 486
    //   81: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   87: invokespecial 464	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   90: astore 5
    //   92: aload 5
    //   94: invokevirtual 489	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   97: ifeq +68 -> 165
    //   100: iload_1
    //   101: ldc_w 490
    //   104: if_icmpge +61 -> 165
    //   107: new 458	com/tencent/mm/vfs/VFSFile
    //   110: dup
    //   111: new 182	java/lang/StringBuilder
    //   114: dup
    //   115: invokespecial 183	java/lang/StringBuilder:<init>	()V
    //   118: getstatic 463	acbn:oM	Ljava/lang/String;
    //   121: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   124: ldc_w 481
    //   127: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   130: aload_3
    //   131: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: ldc_w 492
    //   137: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: iload_1
    //   141: invokevirtual 495	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   144: ldc_w 497
    //   147: invokevirtual 192	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 198	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokespecial 464	com/tencent/mm/vfs/VFSFile:<init>	(Ljava/lang/String;)V
    //   156: astore 5
    //   158: iload_1
    //   159: iconst_1
    //   160: iadd
    //   161: istore_1
    //   162: goto -70 -> 92
    //   165: new 499	java/io/BufferedOutputStream
    //   168: dup
    //   169: new 501	com/tencent/mm/vfs/VFSFileOutputStream
    //   172: dup
    //   173: aload 5
    //   175: invokespecial 504	com/tencent/mm/vfs/VFSFileOutputStream:<init>	(Lcom/tencent/mm/vfs/VFSFile;)V
    //   178: invokespecial 507	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   181: astore_3
    //   182: aload_3
    //   183: astore 4
    //   185: aload_0
    //   186: getstatic 513	android/graphics/Bitmap$CompressFormat:PNG	Landroid/graphics/Bitmap$CompressFormat;
    //   189: bipush 100
    //   191: aload_3
    //   192: invokevirtual 517	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   195: istore_2
    //   196: aload_3
    //   197: ifnull +173 -> 370
    //   200: aload_3
    //   201: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   204: aconst_null
    //   205: astore_0
    //   206: iload_2
    //   207: ifne +121 -> 328
    //   210: aload 5
    //   212: invokevirtual 489	com/tencent/mm/vfs/VFSFile:exists	()Z
    //   215: ifeq +113 -> 328
    //   218: aload 5
    //   220: invokevirtual 523	com/tencent/mm/vfs/VFSFile:delete	()Z
    //   223: pop
    //   224: aload_0
    //   225: areturn
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_0
    //   229: goto -23 -> 206
    //   232: astore_3
    //   233: aload 6
    //   235: astore_0
    //   236: aload_0
    //   237: astore 4
    //   239: ldc 231
    //   241: iconst_2
    //   242: ldc_w 525
    //   245: aload_3
    //   246: invokestatic 528	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   249: ldc_w 258
    //   252: astore_3
    //   253: aload_0
    //   254: ifnull +109 -> 363
    //   257: aload_0
    //   258: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   261: iconst_0
    //   262: istore_2
    //   263: aload_3
    //   264: astore_0
    //   265: goto -59 -> 206
    //   268: astore_0
    //   269: iconst_0
    //   270: istore_2
    //   271: aload_3
    //   272: astore_0
    //   273: goto -67 -> 206
    //   276: astore_0
    //   277: aconst_null
    //   278: astore_3
    //   279: aload_3
    //   280: astore 4
    //   282: ldc 231
    //   284: iconst_2
    //   285: ldc_w 525
    //   288: aload_0
    //   289: invokestatic 238	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   292: aload_3
    //   293: ifnull +63 -> 356
    //   296: aload_3
    //   297: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   300: aconst_null
    //   301: astore_0
    //   302: iconst_0
    //   303: istore_2
    //   304: goto -98 -> 206
    //   307: astore_0
    //   308: aconst_null
    //   309: astore_0
    //   310: iconst_0
    //   311: istore_2
    //   312: goto -106 -> 206
    //   315: astore_0
    //   316: aload 4
    //   318: ifnull +8 -> 326
    //   321: aload 4
    //   323: invokevirtual 520	java/io/BufferedOutputStream:close	()V
    //   326: aload_0
    //   327: athrow
    //   328: aload 5
    //   330: invokevirtual 531	com/tencent/mm/vfs/VFSFile:getAbsolutePath	()Ljava/lang/String;
    //   333: areturn
    //   334: astore_3
    //   335: goto -9 -> 326
    //   338: astore_0
    //   339: goto -23 -> 316
    //   342: astore_0
    //   343: goto -64 -> 279
    //   346: astore 4
    //   348: aload_3
    //   349: astore_0
    //   350: aload 4
    //   352: astore_3
    //   353: goto -117 -> 236
    //   356: aconst_null
    //   357: astore_0
    //   358: iconst_0
    //   359: istore_2
    //   360: goto -154 -> 206
    //   363: iconst_0
    //   364: istore_2
    //   365: aload_3
    //   366: astore_0
    //   367: goto -161 -> 206
    //   370: aconst_null
    //   371: astore_0
    //   372: goto -166 -> 206
    //   375: aconst_null
    //   376: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	377	0	paramBitmap	Bitmap
    //   7	155	1	i	int
    //   195	170	2	bool	boolean
    //   29	172	3	localObject1	Object
    //   232	14	3	localOutOfMemoryError1	OutOfMemoryError
    //   252	45	3	str	String
    //   334	15	3	localThrowable	Throwable
    //   352	14	3	localOutOfMemoryError2	OutOfMemoryError
    //   1	321	4	localObject2	Object
    //   346	5	4	localOutOfMemoryError3	OutOfMemoryError
    //   90	239	5	localVFSFile	com.tencent.mm.vfs.VFSFile
    //   4	230	6	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   200	204	226	java/lang/Throwable
    //   165	182	232	java/lang/OutOfMemoryError
    //   257	261	268	java/lang/Throwable
    //   165	182	276	java/lang/Throwable
    //   296	300	307	java/lang/Throwable
    //   165	182	315	finally
    //   239	249	315	finally
    //   321	326	334	java/lang/Throwable
    //   185	196	338	finally
    //   282	292	338	finally
    //   185	196	342	java/lang/Throwable
    //   185	196	346	java/lang/OutOfMemoryError
  }
  
  private static String g(Bitmap paramBitmap)
  {
    String str = "qfile_qrcode_share_" + System.currentTimeMillis() + ".png";
    try
    {
      paramBitmap = rwt.a(BaseApplicationImpl.sApplication, str, paramBitmap);
      return paramBitmap;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      QLog.w("WeiyunShareQrController<FileAssistant>", 2, "saveTemp error", paramBitmap);
    }
    return "";
  }
  
  private void release()
  {
    if (this.fi != null)
    {
      if (!this.fi.isRecycled()) {
        this.fi.recycle();
      }
      this.fi = null;
    }
  }
  
  public boolean b(Bitmap paramBitmap, int paramInt, String paramString)
  {
    paramBitmap = a(paramBitmap, paramInt, paramString);
    if (paramBitmap == null)
    {
      agyj.p(1, BaseApplicationImpl.sApplication.getResources().getString(2131700321, new Object[] { Integer.valueOf(-2) }), true);
      return false;
    }
    this.a.N(paramBitmap);
    if (paramBitmap != this.fi) {
      release();
    }
    this.fi = paramBitmap;
    return true;
  }
  
  public void g(ShareActionSheetBuilder.ActionSheetItem paramActionSheetItem)
  {
    boolean bool = true;
    if (paramActionSheetItem == null) {}
    int i;
    do
    {
      do
      {
        return;
        i = paramActionSheetItem.action;
        if ((i == 39) || (aqiw.isNetSupport(this.a.e()))) {
          break;
        }
        agyj.B(0, 2131693404, false);
      } while (!QLog.isColorLevel());
      QLog.i("WeiyunShareQrController<FileAssistant>", 2, "toShare: net is not supported");
      return;
    } while ((i != 2) && (i != 3) && (i != 9) && (i != 10) && (i != 72) && (i != 39));
    if (this.m == null)
    {
      this.m = new arhz(this.a.e());
      this.m.setMessage(2131696693);
    }
    if (!this.m.isShowing()) {
      this.m.show();
    }
    Message localMessage = new Message();
    localMessage.what = 1;
    Bitmap localBitmap = this.fi;
    if (i != 39) {}
    for (;;)
    {
      localMessage.obj = new Object[] { paramActionSheetItem, localBitmap, Boolean.valueOf(bool) };
      this.H.sendMessage(localMessage);
      return;
      bool = false;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    if (this.uU) {
      return false;
    }
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      ai((Object[])paramMessage.obj);
      continue;
      aj((Object[])paramMessage.obj);
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> m(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(2));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(3));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(9));
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(10));
    return paramContext;
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem> n(Context paramContext)
  {
    paramContext = new ArrayList();
    paramContext.add(ShareActionSheetBuilder.ActionSheetItem.build(39));
    return paramContext;
  }
  
  public void onDestroy()
  {
    this.uU = true;
    release();
    if (this.m != null)
    {
      this.m.dismiss();
      this.m = null;
    }
    this.q.removeCallbacksAndMessages(null);
    this.H.removeCallbacksAndMessages(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     agym
 * JD-Core Version:    0.7.0.1
 */