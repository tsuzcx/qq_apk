package cooperation.qlink;

import acfp;
import agmz;
import ahbj;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import aqha;
import aqju;
import aurf;
import avhc;
import avhu;
import avhv;
import avhw;
import avhx;
import avhy;
import avhz;
import avia;
import com.tencent.mobileqq.activity.GesturePWDUnlockActivity;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.gesturelock.GesturePWDUtils;
import com.tencent.mobileqq.utils.kapalaiadapter.FileProvider7Helper;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.os.MqqHandler;

public class QlinkShareJumpActivity
  extends BaseActivity
  implements Handler.Callback
{
  private boolean aS;
  private aqju c;
  private String mAction;
  private String mErrMsg = acfp.m(2131711432);
  private Bundle mExtra;
  private ArrayList<String> rL = new ArrayList();
  MqqHandler uiHandler = new aurf(Looper.getMainLooper(), this);
  
  private void F(String paramString)
  {
    aqju localaqju = new aqju(this, 2131756467);
    localaqju.setContentView(2131559151);
    localaqju.setTitle(getString(2131721103));
    localaqju.setMessage(paramString);
    localaqju.setCanceledOnTouchOutside(false);
    localaqju.setCancelable(false);
    localaqju.setNegativeButton(getString(2131691039), new avhx(this));
    localaqju.show();
  }
  
  private static void G(String paramString)
  {
    paramString = new File(paramString);
    if (!paramString.exists()) {}
    for (;;)
    {
      return;
      paramString = paramString.listFiles();
      int j = paramString.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramString[i];
        if (System.currentTimeMillis() - localObject.lastModified() > 86400000L) {
          localObject.delete();
        }
        i += 1;
      }
    }
  }
  
  private void WB(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (String str = getString(2131700537);; str = getString(2131700538))
    {
      aqha.a(this, 230, getString(2131700493), str, 2131700486, 2131700486, new avhv(this), null).show();
      return;
    }
  }
  
  /* Error */
  private String a(Uri paramUri)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 145	cooperation/qlink/QlinkShareJumpActivity:getContentResolver	()Landroid/content/ContentResolver;
    //   4: astore 7
    //   6: aload 7
    //   8: aload_1
    //   9: aconst_null
    //   10: aconst_null
    //   11: aconst_null
    //   12: aconst_null
    //   13: invokestatic 151	alld:query	(Landroid/content/ContentResolver;Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   16: astore 6
    //   18: aload 6
    //   20: ifnonnull +31 -> 51
    //   23: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   26: ifeq +11 -> 37
    //   29: ldc 158
    //   31: iconst_2
    //   32: ldc 160
    //   34: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   37: aload 6
    //   39: ifnull +10 -> 49
    //   42: aload 6
    //   44: invokeinterface 169 1 0
    //   49: aconst_null
    //   50: areturn
    //   51: aload 6
    //   53: ldc 171
    //   55: invokeinterface 175 2 0
    //   60: istore_2
    //   61: aload 6
    //   63: ldc 177
    //   65: invokeinterface 180 2 0
    //   70: istore_3
    //   71: aload 6
    //   73: invokeinterface 183 1 0
    //   78: pop
    //   79: aload 6
    //   81: iload_3
    //   82: invokeinterface 187 2 0
    //   87: lstore 4
    //   89: lload 4
    //   91: l2f
    //   92: invokestatic 193	aqhq:bB	()F
    //   95: fcmpl
    //   96: ifle +27 -> 123
    //   99: aload_0
    //   100: aload_0
    //   101: ldc 194
    //   103: invokevirtual 69	cooperation/qlink/QlinkShareJumpActivity:getString	(I)Ljava/lang/String;
    //   106: putfield 33	cooperation/qlink/QlinkShareJumpActivity:mErrMsg	Ljava/lang/String;
    //   109: aload 6
    //   111: ifnull +10 -> 121
    //   114: aload 6
    //   116: invokeinterface 169 1 0
    //   121: aconst_null
    //   122: areturn
    //   123: aload 6
    //   125: iload_2
    //   126: invokeinterface 195 2 0
    //   131: astore 8
    //   133: new 197	java/lang/StringBuilder
    //   136: dup
    //   137: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   140: aload_0
    //   141: invokevirtual 202	cooperation/qlink/QlinkShareJumpActivity:getExternalCacheDir	()Ljava/io/File;
    //   144: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   147: ldc 208
    //   149: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   152: ldc 213
    //   154: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: ldc 208
    //   159: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   165: astore 9
    //   167: aload 9
    //   169: invokestatic 219	cooperation/qlink/QlinkShareJumpActivity:G	(Ljava/lang/String;)V
    //   172: new 197	java/lang/StringBuilder
    //   175: dup
    //   176: invokespecial 198	java/lang/StringBuilder:<init>	()V
    //   179: aload 9
    //   181: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: aload 9
    //   186: iconst_1
    //   187: anewarray 221	java/lang/String
    //   190: dup
    //   191: iconst_0
    //   192: aload 8
    //   194: aastore
    //   195: iconst_0
    //   196: aaload
    //   197: invokestatic 225	aqhq:bY	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   200: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: invokevirtual 217	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   206: astore 8
    //   208: new 100	java/io/File
    //   211: dup
    //   212: aload 9
    //   214: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   217: astore 9
    //   219: aload 9
    //   221: invokevirtual 106	java/io/File:exists	()Z
    //   224: ifne +34 -> 258
    //   227: aload 9
    //   229: invokevirtual 228	java/io/File:mkdirs	()Z
    //   232: ifne +26 -> 258
    //   235: aload_0
    //   236: ldc 229
    //   238: invokestatic 31	acfp:m	(I)Ljava/lang/String;
    //   241: putfield 33	cooperation/qlink/QlinkShareJumpActivity:mErrMsg	Ljava/lang/String;
    //   244: aload 6
    //   246: ifnull +10 -> 256
    //   249: aload 6
    //   251: invokeinterface 169 1 0
    //   256: aconst_null
    //   257: areturn
    //   258: aload 7
    //   260: aload_1
    //   261: invokevirtual 235	android/content/ContentResolver:openInputStream	(Landroid/net/Uri;)Ljava/io/InputStream;
    //   264: astore_1
    //   265: aload_1
    //   266: ifnonnull +40 -> 306
    //   269: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   272: ifeq +11 -> 283
    //   275: ldc 158
    //   277: iconst_2
    //   278: ldc 237
    //   280: invokestatic 164	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;)V
    //   283: aload_0
    //   284: ldc 238
    //   286: invokestatic 31	acfp:m	(I)Ljava/lang/String;
    //   289: putfield 33	cooperation/qlink/QlinkShareJumpActivity:mErrMsg	Ljava/lang/String;
    //   292: aload 6
    //   294: ifnull +10 -> 304
    //   297: aload 6
    //   299: invokeinterface 169 1 0
    //   304: aconst_null
    //   305: areturn
    //   306: lload 4
    //   308: ldc2_w 239
    //   311: lcmp
    //   312: ifle +30 -> 342
    //   315: aload_0
    //   316: ldc 241
    //   318: invokestatic 31	acfp:m	(I)Ljava/lang/String;
    //   321: putfield 33	cooperation/qlink/QlinkShareJumpActivity:mErrMsg	Ljava/lang/String;
    //   324: aload_1
    //   325: invokevirtual 244	java/io/InputStream:close	()V
    //   328: aload 6
    //   330: ifnull +10 -> 340
    //   333: aload 6
    //   335: invokeinterface 169 1 0
    //   340: aconst_null
    //   341: areturn
    //   342: aload_0
    //   343: aload 8
    //   345: aload_1
    //   346: lload 4
    //   348: invokespecial 247	cooperation/qlink/QlinkShareJumpActivity:a	(Ljava/lang/String;Ljava/io/InputStream;J)V
    //   351: aload 6
    //   353: ifnull +10 -> 363
    //   356: aload 6
    //   358: invokeinterface 169 1 0
    //   363: aload 8
    //   365: areturn
    //   366: astore 6
    //   368: aconst_null
    //   369: astore_1
    //   370: aload_0
    //   371: iconst_0
    //   372: putfield 249	cooperation/qlink/QlinkShareJumpActivity:aS	Z
    //   375: invokestatic 156	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   378: ifeq +13 -> 391
    //   381: ldc 158
    //   383: iconst_2
    //   384: ldc 251
    //   386: aload 6
    //   388: invokestatic 254	com/tencent/qphone/base/util/QLog:w	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   391: aload_1
    //   392: ifnull +9 -> 401
    //   395: aload_1
    //   396: invokeinterface 169 1 0
    //   401: aconst_null
    //   402: areturn
    //   403: astore_1
    //   404: aconst_null
    //   405: astore 6
    //   407: aload 6
    //   409: ifnull +10 -> 419
    //   412: aload 6
    //   414: invokeinterface 169 1 0
    //   419: aload_1
    //   420: athrow
    //   421: astore_1
    //   422: goto -94 -> 328
    //   425: astore_1
    //   426: goto -19 -> 407
    //   429: astore 7
    //   431: aload_1
    //   432: astore 6
    //   434: aload 7
    //   436: astore_1
    //   437: goto -30 -> 407
    //   440: astore 7
    //   442: aload 6
    //   444: astore_1
    //   445: aload 7
    //   447: astore 6
    //   449: goto -79 -> 370
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	452	0	this	QlinkShareJumpActivity
    //   0	452	1	paramUri	Uri
    //   60	66	2	i	int
    //   70	12	3	j	int
    //   87	260	4	l	long
    //   16	341	6	localCursor	android.database.Cursor
    //   366	21	6	localException1	Exception
    //   405	43	6	localObject1	Object
    //   4	255	7	localContentResolver	android.content.ContentResolver
    //   429	6	7	localObject2	Object
    //   440	6	7	localException2	Exception
    //   131	233	8	str	String
    //   165	63	9	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   6	18	366	java/lang/Exception
    //   6	18	403	finally
    //   324	328	421	java/lang/Exception
    //   23	37	425	finally
    //   51	109	425	finally
    //   123	244	425	finally
    //   258	265	425	finally
    //   269	283	425	finally
    //   283	292	425	finally
    //   315	324	425	finally
    //   324	328	425	finally
    //   342	351	425	finally
    //   370	391	429	finally
    //   23	37	440	java/lang/Exception
    //   51	109	440	java/lang/Exception
    //   123	244	440	java/lang/Exception
    //   258	265	440	java/lang/Exception
    //   269	283	440	java/lang/Exception
    //   283	292	440	java/lang/Exception
    //   315	324	440	java/lang/Exception
    //   342	351	440	java/lang/Exception
  }
  
  private void a(String paramString, InputStream paramInputStream, long paramLong)
  {
    this.aS = true;
    ThreadManager.post(new QlinkShareJumpActivity.5(this, paramString, paramInputStream, paramLong), 5, null, true);
    if (this.c == null)
    {
      this.c = aqha.a(this, getString(2131692335), acfp.m(2131711435), new avhy(this));
      this.c.setOnDismissListener(new avhz(this));
    }
    this.c.show();
  }
  
  private boolean aKG()
  {
    Intent localIntent1 = getIntent();
    if (localIntent1.getExtras() == null) {
      new Bundle();
    }
    if (!this.app.isLogin())
    {
      Intent localIntent2 = new Intent(this, LoginActivity.class);
      localIntent2.addFlags(67371008);
      if ((this.rL != null) && (this.rL.size() > 0)) {
        localIntent1.putStringArrayListExtra("qlink_share_filepaths", this.rL);
      }
      localIntent2.putExtra("qlink_share_intent_data", localIntent1);
      localIntent2.putExtra("from_register_guide", true);
      startActivity(localIntent2);
      finish();
      overridePendingTransition(0, 0);
      return true;
    }
    return false;
  }
  
  private String b(Uri paramUri)
  {
    return FileProvider7Helper.getRealPathFromContentURI(this, paramUri);
  }
  
  private void bF()
  {
    if (this.c != null) {
      this.c.dismiss();
    }
  }
  
  private boolean bM(boolean paramBoolean)
  {
    Intent localIntent = getIntent();
    Object localObject2 = localIntent.getExtras();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = new Bundle();
    }
    if ((GesturePWDUtils.getJumpLock(this, this.app.getCurrentAccountUin())) && ((paramBoolean) || (!GesturePWDUtils.getAppForground(this))))
    {
      localObject2 = new Intent(getActivity(), GesturePWDUnlockActivity.class);
      ((Intent)localObject2).putExtra("key_gesture_from_jumpactivity", true);
      ((Intent)localObject2).setAction(localIntent.getAction());
      ((Intent)localObject2).putExtra("isActionSend", true);
      ((Intent)localObject2).putExtras((Bundle)localObject1);
      ((Intent)localObject2).putExtras(localIntent);
      startActivityForResult((Intent)localObject2, 4097);
      return true;
    }
    return false;
  }
  
  private void eAj()
  {
    int j = 0;
    if (this.mExtra == null)
    {
      WB(false);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    Object localObject2;
    Object localObject1;
    int i;
    if (this.mAction.equals("android.intent.action.SEND"))
    {
      localObject2 = (Uri)this.mExtra.get("android.intent.extra.STREAM");
      if (localObject2 == null) {
        break label262;
      }
      localObject1 = b((Uri)localObject2);
      if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (ahbj.isFileExists((String)localObject1)) && (new File((String)localObject1).canRead())) {
        break label257;
      }
      localObject1 = a((Uri)localObject2);
      i = 1;
      label106:
      j = i;
      if (!TextUtils.isEmpty((CharSequence)localObject1)) {
        localArrayList.add(localObject1);
      }
    }
    label257:
    label262:
    for (j = i;; j = 0)
    {
      boolean bool2 = false;
      i = j;
      for (;;)
      {
        if (localArrayList.size() == 0)
        {
          WB(bool2);
          return;
          localObject1 = (ArrayList)this.mExtra.get("android.intent.extra.STREAM");
          if (localObject1 != null)
          {
            localObject1 = ((ArrayList)localObject1).iterator();
            boolean bool1 = false;
            bool2 = bool1;
            i = j;
            if (!((Iterator)localObject1).hasNext()) {
              continue;
            }
            localObject2 = b((Uri)((Iterator)localObject1).next());
            if (ahbj.isFileExists((String)localObject2)) {
              localArrayList.add(localObject2);
            }
            for (;;)
            {
              break;
              bool1 = true;
            }
          }
        }
        else
        {
          this.rL.addAll(localArrayList);
          if (i != 0) {
            break;
          }
          eAk();
          return;
        }
        bool2 = false;
        i = j;
      }
      i = 0;
      break label106;
    }
  }
  
  private void eAk()
  {
    if (this.rL.size() > 50) {
      aqha.a(this, 230, getString(2131700493), getString(2131700497), 2131700486, 2131700486, new avhw(this), null).show();
    }
    while ((aKG()) || (bM(false))) {
      return;
    }
    eAl();
  }
  
  private void eAl()
  {
    Bundle localBundle;
    ArrayList localArrayList;
    if ((this.rL != null) && (this.rL.size() > 0))
    {
      this.app.a().gK("0X8004F47", this.rL.size());
      localBundle = new Bundle();
      localBundle.putStringArrayList("string_filepaths", this.rL);
      localArrayList = new ArrayList();
      localArrayList.addAll(agmz.D());
      if (localArrayList == null) {
        break label137;
      }
    }
    label137:
    for (int i = localArrayList.size();; i = 0)
    {
      localBundle.putInt("string_beforeshare_selectedfile_count", i);
      avhc.c(this, 10, localBundle);
      finish();
      return;
      aqha.a(this, 230, getString(2131700493), getString(2131700538), 2131700486, 2131700486, new avia(this), null).show();
      return;
    }
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.doOnActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt2 == -1)
    {
      if (paramInt1 == 4097)
      {
        eAl();
        return;
      }
      finish();
      return;
    }
    finish();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    paramBundle = getIntent();
    if (paramBundle != null)
    {
      try
      {
        this.mAction = paramBundle.getAction();
        this.mExtra = paramBundle.getExtras();
        if ((TextUtils.isEmpty(this.mAction)) || ((!this.mAction.equals("android.intent.action.SEND")) && (!this.mAction.equals("android.intent.action.SEND_MULTIPLE")))) {
          break label222;
        }
        if (!paramBundle.getBooleanExtra("qlink_share_login_suc_flag", false)) {
          break label215;
        }
        paramBundle = paramBundle.getStringArrayListExtra("qlink_share_filepaths");
        if ((paramBundle != null) && (paramBundle.size() > 0))
        {
          paramBundle = paramBundle.iterator();
          while (paramBundle.hasNext())
          {
            String str = (String)paramBundle.next();
            if (ahbj.isFileExists(str))
            {
              if (this.rL == null) {
                this.rL = new ArrayList();
              }
              this.rL.add(str);
            }
          }
        }
        if (bM(true)) {
          break label234;
        }
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        aqha.a(this, 230, getString(2131700493), getString(2131700538), 2131700486, 2131700486, new avhu(this), null).show();
        return false;
      }
      eAl();
      break label234;
      label215:
      eAj();
    }
    else
    {
      label222:
      finish();
      overridePendingTransition(0, 0);
      return false;
    }
    label234:
    return true;
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      bF();
      if ((paramMessage.obj != null) && ((paramMessage.obj instanceof String))) {}
      for (paramMessage = (String)paramMessage.obj;; paramMessage = null)
      {
        Object localObject = paramMessage;
        if (TextUtils.isEmpty(paramMessage)) {
          localObject = this.mErrMsg;
        }
        F((String)localObject);
        break;
      }
      bF();
      eAk();
      continue;
      this.c.setProgress(paramMessage.arg1);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    requestWindowFeature(1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     cooperation.qlink.QlinkShareJumpActivity
 * JD-Core Version:    0.7.0.1
 */