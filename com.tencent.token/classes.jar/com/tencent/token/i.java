package com.tencent.token;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import btmsdkobf.ad;
import btmsdkobf.cp;
import btmsdkobf.z;
import com.tencent.token.ui.DownloadAppActivity;
import com.tencent.token.ui.DownloadQQSecureActivity;
import com.tencent.token.ui.base.GuideQQPimSecureDialog;
import com.tencent.token.ui.base.GuideQQPimSecureTipsView;
import com.tencent.token.ui.gallery.GalleryActivity;
import com.tencent.token.ui.qqpim.QQPimNewActivity;
import com.tencent.token.utils.a;
import com.tmsdk.TMSDKContext;
import com.tmsdk.base.conch.ConchService.ConchPushInfo;
import com.tmsdk.base.conch.ConchService.IConchPushListener;
import com.tmsdk.base.conch.ConchServiceProxy;
import com.tmsdk.common.util.TmsLog;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class i
{
  private h a;
  private h b;
  private h c;
  private h d;
  private String e;
  private String f;
  private String g;
  
  private i()
  {
    a(false);
  }
  
  public static i a()
  {
    return a.a;
  }
  
  private void a(boolean paramBoolean)
  {
    this.a = h.a("key_dialog_cofig_6348", ed.c("key_dialog_cofig_6348", null));
    TmsLog.i("GuideMgr", "dialog config fromCloud(" + paramBoolean + "): " + this.a);
    this.b = h.a("key_tips1_cofig_6348", ed.c("key_tips1_cofig_6348", null));
    TmsLog.i("GuideMgr", "tips1 config fromCloud(" + paramBoolean + "): " + this.b);
    this.c = h.a("key_tips2_cofig_6348", ed.c("key_tips2_cofig_6348", null));
    TmsLog.i("GuideMgr", "tips2 config fromCloud(" + paramBoolean + "): " + this.c);
    this.d = h.a("key_eval_cofig_6348", ed.c("key_eval_cofig_6348", null));
    TmsLog.i("GuideMgr", "eval config fromCloud(" + paramBoolean + "): " + this.d);
  }
  
  static String b(String paramString)
  {
    if ("com.tencent.gallerymanager".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=14&c=102322&vt=1&pf=0";
    }
    if ("com.tencent.qqpimsecure".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=1&c=107013&vt=1&pf=0";
    }
    if ("com.tencent.qqpim".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=11&c=106613&vt=1&pf=0";
    }
    if ("android.lite.clean".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=25&c=107047&vt=1&pf=0";
    }
    if ("com.tencent.gamestick".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=18&c=102798&vt=1&pf=0";
    }
    if ("com.tencent.transfer".equals(paramString)) {
      return "http://qqwx.qq.com/s?aid=index&p=15&c=106613&vt=1&pf=0";
    }
    return "";
  }
  
  public h a(String paramString)
  {
    if ("key_dialog_cofig_6348".equals(paramString)) {
      return this.a;
    }
    if ("key_tips1_cofig_6348".equals(paramString)) {
      return this.b;
    }
    if ("key_tips2_cofig_6348".equals(paramString)) {
      return this.c;
    }
    if ("key_eval_cofig_6348".equals(paramString)) {
      return this.d;
    }
    return null;
  }
  
  public void a(Context paramContext)
  {
    TmsLog.i("GuideMgr", "invoke tryShowGuideDialog()");
    h localh;
    j localj;
    try
    {
      localh = a("key_dialog_cofig_6348");
      if ((localh == null) || (!localh.a()))
      {
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() json data invalid, or time is not ok.");
        return;
      }
      localj = localh.a(paramContext, null);
      if (localj == null)
      {
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() no pkg matched.");
        return;
      }
    }
    catch (Exception paramContext)
    {
      TmsLog.e("GuideMgr", "", paramContext);
      return;
    }
    if (!TextUtils.isEmpty(localj.a))
    {
      if ((TextUtils.isEmpty(localj.b)) || (TextUtils.isEmpty(localj.c)) || (TextUtils.isEmpty(localj.d)) || (TextUtils.isEmpty(localj.f)))
      {
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() ui data illegal.");
        return;
      }
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(localj.d);
      localArrayList.add(localj.e);
      localArrayList.add(localj.f);
      if (!TextUtils.isEmpty(localj.c)) {
        localj.h.add(localj.c);
      }
      paramContext = new GuideQQPimSecureDialog(paramContext, localj.a, localj.b, localArrayList, localj.h);
      try
      {
        paramContext.show();
        localh.a(localj.a);
        this.e = localj.a;
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() show sucess.");
        c();
        TMSDKContext.SaveStringData(1150161, localj.a);
        return;
      }
      catch (Exception paramContext)
      {
        paramContext.printStackTrace();
      }
    }
  }
  
  public void a(Context paramContext, String paramString, ArrayList<String> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 4))
    {
      Intent localIntent = new Intent(paramContext, DownloadAppActivity.class);
      localIntent.putExtra("downloadurl", b(paramString));
      localIntent.putExtra("title", (String)paramArrayList.get(0));
      localIntent.putExtra("des", (String)paramArrayList.get(1));
      localIntent.putExtra("subdes", (String)paramArrayList.get(2));
      localIntent.putExtra("button", (String)paramArrayList.get(3));
      localIntent.putExtra("imgurl", (String)paramArrayList.get(4));
      localIntent.putExtra("pkg", paramString);
      paramContext.startActivity(localIntent);
    }
    do
    {
      return;
      if ("com.tencent.qqpimsecure".equals(paramString))
      {
        paramContext.startActivity(new Intent(paramContext, DownloadQQSecureActivity.class));
        return;
      }
      if ("com.tencent.qqpim".equals(paramString))
      {
        paramContext.startActivity(new Intent(paramContext, QQPimNewActivity.class));
        return;
      }
    } while (!"com.tencent.gallerymanager".equals(paramString));
    paramContext.startActivity(new Intent(paramContext, GalleryActivity.class));
  }
  
  public void a(final View paramView, ImageView paramImageView, TextView paramTextView1, TextView paramTextView2)
  {
    TmsLog.i("GuideMgr", "invoke tryShowEvalGuide()");
    h localh;
    Object localObject;
    try
    {
      localh = a("key_eval_cofig_6348");
      if ((localh == null) || (!localh.a()))
      {
        TmsLog.w("GuideMgr", "@tryShowEvalGuide() json data invalid, or time is not ok.");
        return;
      }
      localObject = new HashSet();
      if (!TextUtils.isEmpty(this.e)) {
        ((HashSet)localObject).add(this.e);
      }
      if (!TextUtils.isEmpty(this.f)) {
        ((HashSet)localObject).add(this.f);
      }
      if (!TextUtils.isEmpty(this.g)) {
        ((HashSet)localObject).add(this.g);
      }
      localObject = localh.a(paramView.getContext(), (HashSet)localObject);
      if (localObject == null)
      {
        TmsLog.w("GuideMgr", "@tryShowEvalGuide() no pkg matched.");
        return;
      }
    }
    catch (Exception paramView)
    {
      TmsLog.e("GuideMgr", "", paramView);
      return;
    }
    if (!TextUtils.isEmpty(((j)localObject).a))
    {
      if ((TextUtils.isEmpty(((j)localObject).d)) || (TextUtils.isEmpty(((j)localObject).e)) || (TextUtils.isEmpty(((j)localObject).b)))
      {
        TmsLog.w("GuideMgr", "@tryShowEvalGuide() ui data illegal.");
        return;
      }
      if ("com.tencent.qqpim".equals(((j)localObject).a)) {
        TMSDKContext.saveActionData(170019);
      }
      if (!TextUtils.isEmpty(((j)localObject).c)) {
        ((j)localObject).h.add(((j)localObject).c);
      }
      paramView.setVisibility(0);
      paramView.setOnClickListener(new View.OnClickListener()
      {
        public void onClick(View paramAnonymousView)
        {
          if ("com.tencent.qqpim".equals(this.a.a)) {
            TMSDKContext.saveActionData(170020);
          }
          i.this.a(paramView.getContext(), this.a.a, this.a.h);
          TMSDKContext.SaveStringData(1150168, this.a.a);
        }
      });
      paramTextView1.setText(((j)localObject).d);
      paramTextView2.setText(((j)localObject).e);
      new a(paramImageView).execute(new String[] { ((j)localObject).b });
      localh.a(((j)localObject).a);
      TmsLog.w("GuideMgr", "@tryShowEvalGuide() show sucess.");
      TMSDKContext.SaveStringData(1150167, ((j)localObject).a);
      c();
    }
  }
  
  public void a(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView)
  {
    TmsLog.i("GuideMgr", "invoke tryShowTips1()");
    h localh;
    j localj;
    try
    {
      localh = a("key_tips1_cofig_6348");
      if ((localh == null) || (!localh.a()))
      {
        TmsLog.w("GuideMgr", "@tryShowTips1() json data invalid, or time is not ok.");
        return;
      }
      localj = localh.a(paramGuideQQPimSecureTipsView.getContext(), null);
      if (localj == null)
      {
        TmsLog.w("GuideMgr", "@tryShowTips1() no pkg matched.");
        return;
      }
    }
    catch (Exception paramGuideQQPimSecureTipsView)
    {
      TmsLog.e("GuideMgr", "", paramGuideQQPimSecureTipsView);
      return;
    }
    if (!TextUtils.isEmpty(localj.a))
    {
      if ((TextUtils.isEmpty(localj.d)) || (TextUtils.isEmpty(localj.e)))
      {
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() ui data illegal.");
        return;
      }
      if (!TextUtils.isEmpty(localj.c)) {
        localj.h.add(localj.c);
      }
      paramGuideQQPimSecureTipsView.a(localj.a, localj.d, localj.e, localj.b, localj.h, false);
      paramGuideQQPimSecureTipsView.setVisibility(0);
      localh.a(localj.a);
      this.f = localj.a;
      TmsLog.w("GuideMgr", "@tryShowTips1() show sucess.");
      c();
      TMSDKContext.SaveStringData(1150163, localj.a);
    }
  }
  
  public void b()
  {
    new Thread(new Runnable()
    {
      /* Error */
      public void run()
      {
        // Byte code:
        //   0: aconst_null
        //   1: astore 4
        //   3: ldc 25
        //   5: ldc 27
        //   7: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   10: ldc 35
        //   12: ldc 37
        //   14: invokestatic 43	com/tencent/token/ed:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   17: astore_1
        //   18: new 45	java/io/File
        //   21: dup
        //   22: new 47	java/lang/StringBuilder
        //   25: dup
        //   26: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   29: invokestatic 54	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   32: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   35: getstatic 62	java/io/File:separator	Ljava/lang/String;
        //   38: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   41: ldc 67
        //   43: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   46: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   49: ldc 73
        //   51: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   54: astore 6
        //   56: aload_1
        //   57: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   60: ifne +136 -> 196
        //   63: ldc 25
        //   65: new 47	java/lang/StringBuilder
        //   68: dup
        //   69: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   72: ldc 83
        //   74: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   77: aload_1
        //   78: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   81: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   84: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   87: new 45	java/io/File
        //   90: dup
        //   91: new 47	java/lang/StringBuilder
        //   94: dup
        //   95: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   98: invokestatic 54	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   101: invokevirtual 58	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   104: getstatic 62	java/io/File:separator	Ljava/lang/String;
        //   107: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   110: ldc 67
        //   112: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   115: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   118: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
        //   121: astore_2
        //   122: aload_2
        //   123: invokevirtual 90	java/io/File:exists	()Z
        //   126: ifne +8 -> 134
        //   129: aload_2
        //   130: invokevirtual 93	java/io/File:mkdirs	()Z
        //   133: pop
        //   134: new 95	com/tencent/token/ez
        //   137: dup
        //   138: invokespecial 96	com/tencent/token/ez:<init>	()V
        //   141: aload_1
        //   142: invokevirtual 99	com/tencent/token/ez:a	(Ljava/lang/String;)[B
        //   145: astore_3
        //   146: aload_3
        //   147: ifnull +49 -> 196
        //   150: new 101	java/io/FileOutputStream
        //   153: dup
        //   154: aload 6
        //   156: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   159: astore_2
        //   160: aload_2
        //   161: astore_1
        //   162: aload_2
        //   163: aload_3
        //   164: iconst_0
        //   165: aload_3
        //   166: arraylength
        //   167: invokevirtual 108	java/io/FileOutputStream:write	([BII)V
        //   170: aload_2
        //   171: astore_1
        //   172: ldc 25
        //   174: ldc 110
        //   176: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   179: aload_2
        //   180: astore_1
        //   181: ldc 35
        //   183: ldc 37
        //   185: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   188: aload_2
        //   189: ifnull +7 -> 196
        //   192: aload_2
        //   193: invokevirtual 115	java/io/FileOutputStream:close	()V
        //   196: new 117	java/util/ArrayList
        //   199: dup
        //   200: invokespecial 118	java/util/ArrayList:<init>	()V
        //   203: astore 7
        //   205: aload 6
        //   207: invokevirtual 90	java/io/File:exists	()Z
        //   210: ifeq +156 -> 366
        //   213: ldc 25
        //   215: ldc 120
        //   217: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   220: new 122	java/io/FileReader
        //   223: dup
        //   224: aload 6
        //   226: invokespecial 123	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   229: astore_3
        //   230: new 125	java/io/BufferedReader
        //   233: dup
        //   234: aload_3
        //   235: invokespecial 128	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   238: astore_2
        //   239: aload_2
        //   240: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   243: astore_1
        //   244: aload_1
        //   245: ifnull +99 -> 344
        //   248: aload 7
        //   250: aload_1
        //   251: invokevirtual 135	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   254: pop
        //   255: ldc 25
        //   257: new 47	java/lang/StringBuilder
        //   260: dup
        //   261: invokespecial 48	java/lang/StringBuilder:<init>	()V
        //   264: ldc 137
        //   266: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   269: aload_1
        //   270: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   273: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   276: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   279: aload_2
        //   280: invokevirtual 131	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   283: astore_1
        //   284: goto -40 -> 244
        //   287: astore_1
        //   288: aload_1
        //   289: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   292: goto -96 -> 196
        //   295: astore_3
        //   296: aconst_null
        //   297: astore_2
        //   298: aload_2
        //   299: astore_1
        //   300: aload_3
        //   301: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   304: aload_2
        //   305: ifnull -109 -> 196
        //   308: aload_2
        //   309: invokevirtual 115	java/io/FileOutputStream:close	()V
        //   312: goto -116 -> 196
        //   315: astore_1
        //   316: aload_1
        //   317: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   320: goto -124 -> 196
        //   323: astore_2
        //   324: aconst_null
        //   325: astore_1
        //   326: aload_1
        //   327: ifnull +7 -> 334
        //   330: aload_1
        //   331: invokevirtual 115	java/io/FileOutputStream:close	()V
        //   334: aload_2
        //   335: athrow
        //   336: astore_1
        //   337: aload_1
        //   338: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   341: goto -7 -> 334
        //   344: aload_3
        //   345: ifnull +7 -> 352
        //   348: aload_3
        //   349: invokevirtual 141	java/io/FileReader:close	()V
        //   352: aload_2
        //   353: ifnull +7 -> 360
        //   356: aload_2
        //   357: invokevirtual 142	java/io/BufferedReader:close	()V
        //   360: aload 6
        //   362: invokevirtual 145	java/io/File:delete	()Z
        //   365: pop
        //   366: aload 7
        //   368: invokevirtual 149	java/util/ArrayList:size	()I
        //   371: iconst_3
        //   372: if_icmple +156 -> 528
        //   375: ldc 151
        //   377: aload 7
        //   379: iconst_0
        //   380: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   383: checkcast 157	java/lang/String
        //   386: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   389: ldc 159
        //   391: aload 7
        //   393: iconst_1
        //   394: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   397: checkcast 157	java/lang/String
        //   400: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   403: ldc 161
        //   405: aload 7
        //   407: iconst_2
        //   408: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   411: checkcast 157	java/lang/String
        //   414: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   417: ldc 163
        //   419: aload 7
        //   421: iconst_3
        //   422: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   425: checkcast 157	java/lang/String
        //   428: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   431: aload_0
        //   432: getfield 17	com/tencent/token/i$1:a	Lcom/tencent/token/i;
        //   435: iconst_1
        //   436: invokestatic 166	com/tencent/token/i:a	(Lcom/tencent/token/i;Z)V
        //   439: return
        //   440: astore_1
        //   441: aload_1
        //   442: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   445: goto -85 -> 360
        //   448: astore_2
        //   449: aconst_null
        //   450: astore_1
        //   451: aload 4
        //   453: astore_3
        //   454: aload_2
        //   455: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   458: aload_1
        //   459: ifnull +7 -> 466
        //   462: aload_1
        //   463: invokevirtual 141	java/io/FileReader:close	()V
        //   466: aload_3
        //   467: ifnull +7 -> 474
        //   470: aload_3
        //   471: invokevirtual 142	java/io/BufferedReader:close	()V
        //   474: aload 6
        //   476: invokevirtual 145	java/io/File:delete	()Z
        //   479: pop
        //   480: goto -114 -> 366
        //   483: astore_1
        //   484: aload_1
        //   485: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   488: goto -14 -> 474
        //   491: astore_1
        //   492: aconst_null
        //   493: astore_2
        //   494: aconst_null
        //   495: astore_3
        //   496: aload_3
        //   497: ifnull +7 -> 504
        //   500: aload_3
        //   501: invokevirtual 141	java/io/FileReader:close	()V
        //   504: aload_2
        //   505: ifnull +7 -> 512
        //   508: aload_2
        //   509: invokevirtual 142	java/io/BufferedReader:close	()V
        //   512: aload 6
        //   514: invokevirtual 145	java/io/File:delete	()Z
        //   517: pop
        //   518: aload_1
        //   519: athrow
        //   520: astore_2
        //   521: aload_2
        //   522: invokevirtual 140	java/lang/Exception:printStackTrace	()V
        //   525: goto -13 -> 512
        //   528: ldc 25
        //   530: ldc 168
        //   532: invokestatic 171	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   535: return
        //   536: astore_1
        //   537: aconst_null
        //   538: astore_2
        //   539: goto -43 -> 496
        //   542: astore_1
        //   543: goto -47 -> 496
        //   546: astore 5
        //   548: aload_1
        //   549: astore 4
        //   551: aload_3
        //   552: astore_2
        //   553: aload 5
        //   555: astore_1
        //   556: aload 4
        //   558: astore_3
        //   559: goto -63 -> 496
        //   562: astore_2
        //   563: aload_3
        //   564: astore_1
        //   565: aload 4
        //   567: astore_3
        //   568: goto -114 -> 454
        //   571: astore 5
        //   573: aload_2
        //   574: astore 4
        //   576: aload_3
        //   577: astore_1
        //   578: aload 5
        //   580: astore_2
        //   581: aload 4
        //   583: astore_3
        //   584: goto -130 -> 454
        //   587: astore_2
        //   588: goto -262 -> 326
        //   591: astore_3
        //   592: goto -294 -> 298
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	595	0	this	1
        //   17	267	1	localObject1	Object
        //   287	2	1	localException1	Exception
        //   299	1	1	localObject2	Object
        //   315	2	1	localException2	Exception
        //   325	6	1	localObject3	Object
        //   336	2	1	localException3	Exception
        //   440	2	1	localException4	Exception
        //   450	13	1	localObject4	Object
        //   483	2	1	localException5	Exception
        //   491	28	1	localObject5	Object
        //   536	1	1	localObject6	Object
        //   542	7	1	localObject7	Object
        //   555	23	1	localObject8	Object
        //   121	188	2	localObject9	Object
        //   323	34	2	localObject10	Object
        //   448	7	2	localException6	Exception
        //   493	16	2	localObject11	Object
        //   520	2	2	localException7	Exception
        //   538	15	2	localObject12	Object
        //   562	12	2	localException8	Exception
        //   580	1	2	localObject13	Object
        //   587	1	2	localObject14	Object
        //   145	90	3	localObject15	Object
        //   295	54	3	localException9	Exception
        //   453	131	3	localObject16	Object
        //   591	1	3	localException10	Exception
        //   1	581	4	localObject17	Object
        //   546	8	5	localObject18	Object
        //   571	8	5	localException11	Exception
        //   54	459	6	localFile	java.io.File
        //   203	217	7	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   192	196	287	java/lang/Exception
        //   150	160	295	java/lang/Exception
        //   308	312	315	java/lang/Exception
        //   150	160	323	finally
        //   330	334	336	java/lang/Exception
        //   348	352	440	java/lang/Exception
        //   356	360	440	java/lang/Exception
        //   220	230	448	java/lang/Exception
        //   462	466	483	java/lang/Exception
        //   470	474	483	java/lang/Exception
        //   220	230	491	finally
        //   500	504	520	java/lang/Exception
        //   508	512	520	java/lang/Exception
        //   230	239	536	finally
        //   239	244	542	finally
        //   248	284	542	finally
        //   454	458	546	finally
        //   230	239	562	java/lang/Exception
        //   239	244	571	java/lang/Exception
        //   248	284	571	java/lang/Exception
        //   162	170	587	finally
        //   172	179	587	finally
        //   181	188	587	finally
        //   300	304	587	finally
        //   162	170	591	java/lang/Exception
        //   172	179	591	java/lang/Exception
        //   181	188	591	java/lang/Exception
      }
    }).start();
  }
  
  public void b(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView)
  {
    TmsLog.i("GuideMgr", "invoke tryShowTips2()");
    h localh;
    j localj;
    try
    {
      localh = a("key_tips2_cofig_6348");
      if ((localh == null) || (!localh.a()))
      {
        TmsLog.w("GuideMgr", "@tryShowTips2() json data invalid, or time is not ok.");
        return;
      }
      localj = localh.a(paramGuideQQPimSecureTipsView.getContext(), null);
      if (localj == null)
      {
        TmsLog.w("GuideMgr", "@tryShowTips2() no pkg matched.");
        return;
      }
    }
    catch (Exception paramGuideQQPimSecureTipsView)
    {
      TmsLog.e("GuideMgr", "", paramGuideQQPimSecureTipsView);
      return;
    }
    if (!TextUtils.isEmpty(localj.a))
    {
      if ((TextUtils.isEmpty(localj.d)) || (TextUtils.isEmpty(localj.e)))
      {
        TmsLog.w("GuideMgr", "@tryShowTips2() ui data illegal.");
        return;
      }
      if (!TextUtils.isEmpty(localj.c)) {
        localj.h.add(localj.c);
      }
      paramGuideQQPimSecureTipsView.a(localj.a, localj.d, localj.e, localj.b, localj.h, true);
      paramGuideQQPimSecureTipsView.setVisibility(0);
      localh.a(localj.a);
      this.g = localj.a;
      TmsLog.w("GuideMgr", "@tryShowTips2() show sucess.");
      c();
      TMSDKContext.SaveStringData(1150165, localj.a);
    }
  }
  
  public void c()
  {
    a(false);
  }
  
  public void d()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Integer.valueOf(6348));
    ConchServiceProxy.getInstance().registerConchPush(localArrayList, new ConchService.IConchPushListener()
    {
      public void onRecvPush(ConchService.ConchPushInfo paramAnonymousConchPushInfo)
      {
        if ((paramAnonymousConchPushInfo == null) || (paramAnonymousConchPushInfo.mConch == null)) {
          return;
        }
        TmsLog.i("GuideMgr", "receive cmd " + paramAnonymousConchPushInfo.mConch.cmdId);
        switch (paramAnonymousConchPushInfo.mConch.cmdId)
        {
        default: 
          return;
        }
        ad localad = (ad)cp.a(paramAnonymousConchPushInfo.mConch.aZ, new ad(), false);
        if ((localad.bm != null) && (localad.bm.size() >= 1))
        {
          ed.b("key_guide_cofig_file_url", (String)localad.bm.get(0));
          i.this.b();
        }
        ConchServiceProxy.getInstance().reportConchResult(paramAnonymousConchPushInfo, 10, 1);
      }
    });
  }
  
  public void e()
  {
    b();
    ConchServiceProxy.getInstance().pullConch(6348);
  }
  
  private static class a
  {
    static i a = new i(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.i
 * JD-Core Version:    0.7.0.1
 */