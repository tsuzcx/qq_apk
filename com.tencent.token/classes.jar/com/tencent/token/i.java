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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dialog config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.a);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.b = h.a("key_tips1_cofig_6348", ed.c("key_tips1_cofig_6348", null));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tips1 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.b);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.c = h.a("key_tips2_cofig_6348", ed.c("key_tips2_cofig_6348", null));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("tips2 config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.c);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
    this.d = h.a("key_eval_cofig_6348", ed.c("key_eval_cofig_6348", null));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("eval config fromCloud(");
    localStringBuilder.append(paramBoolean);
    localStringBuilder.append("): ");
    localStringBuilder.append(this.d);
    TmsLog.i("GuideMgr", localStringBuilder.toString());
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
    try
    {
      h localh = a("key_dialog_cofig_6348");
      if ((localh != null) && (localh.a()))
      {
        j localj = localh.a(paramContext, null);
        if (localj == null)
        {
          TmsLog.w("GuideMgr", "@tryShowGuideDialog() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(localj.a)) {
          return;
        }
        if ((!TextUtils.isEmpty(localj.b)) && (!TextUtils.isEmpty(localj.c)) && (!TextUtils.isEmpty(localj.d)) && (!TextUtils.isEmpty(localj.f)))
        {
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
            return;
          }
        }
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowGuideDialog() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramContext)
    {
      TmsLog.e("GuideMgr", "", paramContext);
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
      return;
    }
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
    if ("com.tencent.gallerymanager".equals(paramString))
    {
      paramContext.startActivity(new Intent(paramContext, GalleryActivity.class));
      return;
    }
  }
  
  public void a(final View paramView, ImageView paramImageView, TextView paramTextView1, TextView paramTextView2)
  {
    TmsLog.i("GuideMgr", "invoke tryShowEvalGuide()");
    try
    {
      h localh = a("key_eval_cofig_6348");
      if ((localh != null) && (localh.a()))
      {
        Object localObject = new HashSet();
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
        if (TextUtils.isEmpty(((j)localObject).a)) {
          return;
        }
        if ((!TextUtils.isEmpty(((j)localObject).d)) && (!TextUtils.isEmpty(((j)localObject).e)) && (!TextUtils.isEmpty(((j)localObject).b)))
        {
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
          return;
        }
        TmsLog.w("GuideMgr", "@tryShowEvalGuide() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowEvalGuide() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramView)
    {
      TmsLog.e("GuideMgr", "", paramView);
    }
  }
  
  public void a(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView)
  {
    TmsLog.i("GuideMgr", "invoke tryShowTips1()");
    try
    {
      h localh = a("key_tips1_cofig_6348");
      if ((localh != null) && (localh.a()))
      {
        j localj = localh.a(paramGuideQQPimSecureTipsView.getContext(), null);
        if (localj == null)
        {
          TmsLog.w("GuideMgr", "@tryShowTips1() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(localj.a)) {
          return;
        }
        if ((!TextUtils.isEmpty(localj.d)) && (!TextUtils.isEmpty(localj.e)))
        {
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
          return;
        }
        TmsLog.w("GuideMgr", "@tryShowGuideDialog() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowTips1() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramGuideQQPimSecureTipsView)
    {
      TmsLog.e("GuideMgr", "", paramGuideQQPimSecureTipsView);
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
        //   0: ldc 25
        //   2: ldc 27
        //   4: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   7: ldc 35
        //   9: ldc 37
        //   11: invokestatic 43	com/tencent/token/ed:c	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
        //   14: astore_1
        //   15: new 45	java/lang/StringBuilder
        //   18: dup
        //   19: invokespecial 46	java/lang/StringBuilder:<init>	()V
        //   22: astore_2
        //   23: aload_2
        //   24: invokestatic 52	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   27: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   30: pop
        //   31: aload_2
        //   32: getstatic 62	java/io/File:separator	Ljava/lang/String;
        //   35: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   38: pop
        //   39: aload_2
        //   40: ldc 67
        //   42: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   45: pop
        //   46: new 58	java/io/File
        //   49: dup
        //   50: aload_2
        //   51: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   54: ldc 73
        //   56: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;Ljava/lang/String;)V
        //   59: astore 7
        //   61: aload_1
        //   62: invokestatic 81	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
        //   65: ifne +210 -> 275
        //   68: new 45	java/lang/StringBuilder
        //   71: dup
        //   72: invokespecial 46	java/lang/StringBuilder:<init>	()V
        //   75: astore_2
        //   76: aload_2
        //   77: ldc 83
        //   79: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   82: pop
        //   83: aload_2
        //   84: aload_1
        //   85: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   88: pop
        //   89: ldc 25
        //   91: aload_2
        //   92: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   95: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   98: new 45	java/lang/StringBuilder
        //   101: dup
        //   102: invokespecial 46	java/lang/StringBuilder:<init>	()V
        //   105: astore_2
        //   106: aload_2
        //   107: invokestatic 52	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
        //   110: invokevirtual 56	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   113: pop
        //   114: aload_2
        //   115: getstatic 62	java/io/File:separator	Ljava/lang/String;
        //   118: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   121: pop
        //   122: aload_2
        //   123: ldc 67
        //   125: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   128: pop
        //   129: new 58	java/io/File
        //   132: dup
        //   133: aload_2
        //   134: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   137: invokespecial 86	java/io/File:<init>	(Ljava/lang/String;)V
        //   140: astore_2
        //   141: aload_2
        //   142: invokevirtual 90	java/io/File:exists	()Z
        //   145: ifne +8 -> 153
        //   148: aload_2
        //   149: invokevirtual 93	java/io/File:mkdirs	()Z
        //   152: pop
        //   153: new 95	com/tencent/token/ez
        //   156: dup
        //   157: invokespecial 96	com/tencent/token/ez:<init>	()V
        //   160: aload_1
        //   161: invokevirtual 99	com/tencent/token/ez:a	(Ljava/lang/String;)[B
        //   164: astore_3
        //   165: aload_3
        //   166: ifnull +109 -> 275
        //   169: new 101	java/io/FileOutputStream
        //   172: dup
        //   173: aload 7
        //   175: invokespecial 104	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
        //   178: astore_2
        //   179: aload_2
        //   180: astore_1
        //   181: aload_2
        //   182: aload_3
        //   183: iconst_0
        //   184: aload_3
        //   185: arraylength
        //   186: invokevirtual 108	java/io/FileOutputStream:write	([BII)V
        //   189: aload_2
        //   190: astore_1
        //   191: ldc 25
        //   193: ldc 110
        //   195: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   198: aload_2
        //   199: astore_1
        //   200: ldc 35
        //   202: ldc 37
        //   204: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   207: aload_2
        //   208: invokevirtual 115	java/io/FileOutputStream:close	()V
        //   211: goto +64 -> 275
        //   214: astore_3
        //   215: goto +12 -> 227
        //   218: astore_1
        //   219: aconst_null
        //   220: astore_2
        //   221: goto +36 -> 257
        //   224: astore_3
        //   225: aconst_null
        //   226: astore_2
        //   227: aload_2
        //   228: astore_1
        //   229: aload_3
        //   230: invokevirtual 118	java/lang/Exception:printStackTrace	()V
        //   233: aload_2
        //   234: ifnull +41 -> 275
        //   237: aload_2
        //   238: invokevirtual 115	java/io/FileOutputStream:close	()V
        //   241: goto +34 -> 275
        //   244: astore_1
        //   245: aload_1
        //   246: invokevirtual 118	java/lang/Exception:printStackTrace	()V
        //   249: goto +26 -> 275
        //   252: astore_3
        //   253: aload_1
        //   254: astore_2
        //   255: aload_3
        //   256: astore_1
        //   257: aload_2
        //   258: ifnull +15 -> 273
        //   261: aload_2
        //   262: invokevirtual 115	java/io/FileOutputStream:close	()V
        //   265: goto +8 -> 273
        //   268: astore_2
        //   269: aload_2
        //   270: invokevirtual 118	java/lang/Exception:printStackTrace	()V
        //   273: aload_1
        //   274: athrow
        //   275: new 120	java/util/ArrayList
        //   278: dup
        //   279: invokespecial 121	java/util/ArrayList:<init>	()V
        //   282: astore 8
        //   284: aload 7
        //   286: invokevirtual 90	java/io/File:exists	()Z
        //   289: ifeq +278 -> 567
        //   292: ldc 25
        //   294: ldc 123
        //   296: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   299: new 125	java/io/FileReader
        //   302: dup
        //   303: aload 7
        //   305: invokespecial 126	java/io/FileReader:<init>	(Ljava/io/File;)V
        //   308: astore_1
        //   309: new 128	java/io/BufferedReader
        //   312: dup
        //   313: aload_1
        //   314: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
        //   317: astore 6
        //   319: aload_1
        //   320: astore_2
        //   321: aload 6
        //   323: astore_3
        //   324: aload 6
        //   326: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   329: astore 4
        //   331: aload 4
        //   333: ifnull +86 -> 419
        //   336: aload_1
        //   337: astore_2
        //   338: aload 6
        //   340: astore_3
        //   341: aload 8
        //   343: aload 4
        //   345: invokevirtual 138	java/util/ArrayList:add	(Ljava/lang/Object;)Z
        //   348: pop
        //   349: aload_1
        //   350: astore_2
        //   351: aload 6
        //   353: astore_3
        //   354: new 45	java/lang/StringBuilder
        //   357: dup
        //   358: invokespecial 46	java/lang/StringBuilder:<init>	()V
        //   361: astore 5
        //   363: aload_1
        //   364: astore_2
        //   365: aload 6
        //   367: astore_3
        //   368: aload 5
        //   370: ldc 140
        //   372: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   375: pop
        //   376: aload_1
        //   377: astore_2
        //   378: aload 6
        //   380: astore_3
        //   381: aload 5
        //   383: aload 4
        //   385: invokevirtual 65	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   388: pop
        //   389: aload_1
        //   390: astore_2
        //   391: aload 6
        //   393: astore_3
        //   394: ldc 25
        //   396: aload 5
        //   398: invokevirtual 71	java/lang/StringBuilder:toString	()Ljava/lang/String;
        //   401: invokestatic 33	com/tmsdk/common/util/TmsLog:i	(Ljava/lang/String;Ljava/lang/String;)V
        //   404: aload_1
        //   405: astore_2
        //   406: aload 6
        //   408: astore_3
        //   409: aload 6
        //   411: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
        //   414: astore 4
        //   416: goto -85 -> 331
        //   419: aload_1
        //   420: invokevirtual 141	java/io/FileReader:close	()V
        //   423: aload 6
        //   425: invokevirtual 142	java/io/BufferedReader:close	()V
        //   428: goto +89 -> 517
        //   431: astore_1
        //   432: goto +81 -> 513
        //   435: astore 5
        //   437: aload_1
        //   438: astore 4
        //   440: aload 6
        //   442: astore_1
        //   443: goto +36 -> 479
        //   446: astore_2
        //   447: aconst_null
        //   448: astore_3
        //   449: goto +84 -> 533
        //   452: astore 5
        //   454: aconst_null
        //   455: astore_2
        //   456: aload_1
        //   457: astore 4
        //   459: aload_2
        //   460: astore_1
        //   461: goto +18 -> 479
        //   464: astore_2
        //   465: aconst_null
        //   466: astore_1
        //   467: aload_1
        //   468: astore_3
        //   469: goto +64 -> 533
        //   472: astore 5
        //   474: aconst_null
        //   475: astore_1
        //   476: aload_1
        //   477: astore 4
        //   479: aload 4
        //   481: astore_2
        //   482: aload_1
        //   483: astore_3
        //   484: aload 5
        //   486: invokevirtual 118	java/lang/Exception:printStackTrace	()V
        //   489: aload 4
        //   491: ifnull +11 -> 502
        //   494: aload 4
        //   496: invokevirtual 141	java/io/FileReader:close	()V
        //   499: goto +3 -> 502
        //   502: aload_1
        //   503: ifnull +14 -> 517
        //   506: aload_1
        //   507: invokevirtual 142	java/io/BufferedReader:close	()V
        //   510: goto +7 -> 517
        //   513: aload_1
        //   514: invokevirtual 118	java/lang/Exception:printStackTrace	()V
        //   517: aload 7
        //   519: invokevirtual 145	java/io/File:delete	()Z
        //   522: pop
        //   523: goto +44 -> 567
        //   526: astore 4
        //   528: aload_2
        //   529: astore_1
        //   530: aload 4
        //   532: astore_2
        //   533: aload_1
        //   534: ifnull +10 -> 544
        //   537: aload_1
        //   538: invokevirtual 141	java/io/FileReader:close	()V
        //   541: goto +3 -> 544
        //   544: aload_3
        //   545: ifnull +14 -> 559
        //   548: aload_3
        //   549: invokevirtual 142	java/io/BufferedReader:close	()V
        //   552: goto +7 -> 559
        //   555: aload_1
        //   556: invokevirtual 118	java/lang/Exception:printStackTrace	()V
        //   559: aload 7
        //   561: invokevirtual 145	java/io/File:delete	()Z
        //   564: pop
        //   565: aload_2
        //   566: athrow
        //   567: aload 8
        //   569: invokevirtual 149	java/util/ArrayList:size	()I
        //   572: iconst_3
        //   573: if_icmple +68 -> 641
        //   576: ldc 151
        //   578: aload 8
        //   580: iconst_0
        //   581: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   584: checkcast 157	java/lang/String
        //   587: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   590: ldc 159
        //   592: aload 8
        //   594: iconst_1
        //   595: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   598: checkcast 157	java/lang/String
        //   601: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   604: ldc 161
        //   606: aload 8
        //   608: iconst_2
        //   609: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   612: checkcast 157	java/lang/String
        //   615: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   618: ldc 163
        //   620: aload 8
        //   622: iconst_3
        //   623: invokevirtual 155	java/util/ArrayList:get	(I)Ljava/lang/Object;
        //   626: checkcast 157	java/lang/String
        //   629: invokestatic 112	com/tencent/token/ed:b	(Ljava/lang/String;Ljava/lang/String;)V
        //   632: aload_0
        //   633: getfield 17	com/tencent/token/i$1:a	Lcom/tencent/token/i;
        //   636: iconst_1
        //   637: invokestatic 166	com/tencent/token/i:a	(Lcom/tencent/token/i;Z)V
        //   640: return
        //   641: ldc 25
        //   643: ldc 168
        //   645: invokestatic 171	com/tmsdk/common/util/TmsLog:w	(Ljava/lang/String;Ljava/lang/String;)V
        //   648: return
        //   649: astore_1
        //   650: goto -137 -> 513
        //   653: astore_1
        //   654: goto -99 -> 555
        // Local variable table:
        //   start	length	slot	name	signature
        //   0	657	0	this	1
        //   14	186	1	localObject1	Object
        //   218	1	1	localObject2	Object
        //   228	1	1	localObject3	Object
        //   244	10	1	localException1	Exception
        //   256	164	1	localObject4	Object
        //   431	7	1	localException2	Exception
        //   442	114	1	localObject5	Object
        //   649	1	1	localException3	Exception
        //   653	1	1	localException4	Exception
        //   22	240	2	localObject6	Object
        //   268	2	2	localException5	Exception
        //   320	86	2	localObject7	Object
        //   446	1	2	localObject8	Object
        //   455	5	2	localObject9	Object
        //   464	1	2	localObject10	Object
        //   481	85	2	localObject11	Object
        //   164	21	3	arrayOfByte	byte[]
        //   214	1	3	localException6	Exception
        //   224	6	3	localException7	Exception
        //   252	4	3	localObject12	Object
        //   323	226	3	localObject13	Object
        //   329	166	4	localObject14	Object
        //   526	5	4	localObject15	Object
        //   361	36	5	localStringBuilder	StringBuilder
        //   435	1	5	localException8	Exception
        //   452	1	5	localException9	Exception
        //   472	13	5	localException10	Exception
        //   317	124	6	localBufferedReader	java.io.BufferedReader
        //   59	501	7	localFile	java.io.File
        //   282	339	8	localArrayList	ArrayList
        // Exception table:
        //   from	to	target	type
        //   181	189	214	java/lang/Exception
        //   191	198	214	java/lang/Exception
        //   200	207	214	java/lang/Exception
        //   169	179	218	finally
        //   169	179	224	java/lang/Exception
        //   207	211	244	java/lang/Exception
        //   237	241	244	java/lang/Exception
        //   181	189	252	finally
        //   191	198	252	finally
        //   200	207	252	finally
        //   229	233	252	finally
        //   261	265	268	java/lang/Exception
        //   419	428	431	java/lang/Exception
        //   324	331	435	java/lang/Exception
        //   341	349	435	java/lang/Exception
        //   354	363	435	java/lang/Exception
        //   368	376	435	java/lang/Exception
        //   381	389	435	java/lang/Exception
        //   394	404	435	java/lang/Exception
        //   409	416	435	java/lang/Exception
        //   309	319	446	finally
        //   309	319	452	java/lang/Exception
        //   299	309	464	finally
        //   299	309	472	java/lang/Exception
        //   324	331	526	finally
        //   341	349	526	finally
        //   354	363	526	finally
        //   368	376	526	finally
        //   381	389	526	finally
        //   394	404	526	finally
        //   409	416	526	finally
        //   484	489	526	finally
        //   494	499	649	java/lang/Exception
        //   506	510	649	java/lang/Exception
        //   537	541	653	java/lang/Exception
        //   548	552	653	java/lang/Exception
      }
    }).start();
  }
  
  public void b(GuideQQPimSecureTipsView paramGuideQQPimSecureTipsView)
  {
    TmsLog.i("GuideMgr", "invoke tryShowTips2()");
    try
    {
      h localh = a("key_tips2_cofig_6348");
      if ((localh != null) && (localh.a()))
      {
        j localj = localh.a(paramGuideQQPimSecureTipsView.getContext(), null);
        if (localj == null)
        {
          TmsLog.w("GuideMgr", "@tryShowTips2() no pkg matched.");
          return;
        }
        if (TextUtils.isEmpty(localj.a)) {
          return;
        }
        if ((!TextUtils.isEmpty(localj.d)) && (!TextUtils.isEmpty(localj.e)))
        {
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
          return;
        }
        TmsLog.w("GuideMgr", "@tryShowTips2() ui data illegal.");
        return;
      }
      TmsLog.w("GuideMgr", "@tryShowTips2() json data invalid, or time is not ok.");
      return;
    }
    catch (Exception paramGuideQQPimSecureTipsView)
    {
      TmsLog.e("GuideMgr", "", paramGuideQQPimSecureTipsView);
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
        if (paramAnonymousConchPushInfo != null)
        {
          if (paramAnonymousConchPushInfo.mConch == null) {
            return;
          }
          Object localObject = new StringBuilder();
          ((StringBuilder)localObject).append("receive cmd ");
          ((StringBuilder)localObject).append(paramAnonymousConchPushInfo.mConch.cmdId);
          TmsLog.i("GuideMgr", ((StringBuilder)localObject).toString());
          if (paramAnonymousConchPushInfo.mConch.cmdId != 6348) {
            return;
          }
          localObject = (ad)cp.a(paramAnonymousConchPushInfo.mConch.aZ, new ad(), false);
          if ((((ad)localObject).bm != null) && (((ad)localObject).bm.size() >= 1))
          {
            ed.b("key_guide_cofig_file_url", (String)((ad)localObject).bm.get(0));
            i.this.b();
          }
          ConchServiceProxy.getInstance().reportConchResult(paramAnonymousConchPushInfo, 10, 1);
          return;
        }
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