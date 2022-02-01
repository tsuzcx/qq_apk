package com.tencent.biz.qqstory.storyHome;

import acfp;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.playvideo.dataprovider.MsgTabPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.HomeFeedPlayInfo;
import com.tencent.biz.qqstory.playvideo.entrance.OpenPlayerBuilder.Data;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.shortvideo.mediadevice.EncodeThread;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import plr;
import pog;
import qgn;
import qri;
import ram;
import rnq;

public class VideoEncodeActivity
  extends QQStoryBaseActivity
{
  private static final DateFormat f = new SimpleDateFormat("MM-dd-HHmmSS");
  private EditText Z;
  private EditText ab;
  private EditText ac;
  private EditText ad;
  private EditText ae;
  private String ayi;
  private String ayj;
  qgn b = new qgn();
  private Button cn;
  private LinearLayout eV;
  
  private static int a(String paramString1, byte[] paramArrayOfByte, int paramInt, boolean paramBoolean, String paramString2)
  {
    paramString1 = new EncodeThread(null, new Handler(Looper.getMainLooper()), paramString1, paramString2, null);
    paramString1.PW(false);
    paramString1.CN(false);
    paramString1.PY(paramBoolean);
    if (paramArrayOfByte != null) {
      paramString1.q(paramArrayOfByte, paramInt);
    }
    paramString1.run();
    return paramString1.errorCode;
  }
  
  private List<PublishVideoEntry> bR()
  {
    Object localObject = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    new PublishVideoEntry();
    localObject = pog.a((EntityManager)localObject, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), null, null);
    if (localObject == null) {
      return new ArrayList();
    }
    Iterator localIterator = ((List)localObject).iterator();
    while (localIterator.hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)localIterator.next();
      if (TextUtils.isEmpty(localPublishVideoEntry.name)) {
        localIterator.remove();
      } else {
        ram.i("Q.qqstory:VideoEncodeActivity", "user scene " + localPublishVideoEntry);
      }
    }
    return localObject;
  }
  
  private void bpT()
  {
    Button localButton = (Button)findViewById(2131365710);
    if (TextUtils.isEmpty(this.ayj))
    {
      localButton.setEnabled(false);
      return;
    }
    localButton.setEnabled(true);
  }
  
  private void bpU()
  {
    this.eV.removeAllViewsInLayout();
    Object localObject = bR();
    if (((List)localObject).size() == 0) {
      return;
    }
    RadioGroup localRadioGroup = new RadioGroup(this);
    localRadioGroup.setOrientation(1);
    localRadioGroup.setOnCheckedChangeListener(new qri(this));
    this.eV.addView(localRadioGroup);
    RadioButton localRadioButton = null;
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
      localRadioButton = new RadioButton(this);
      localRadioGroup.addView(localRadioButton);
      localRadioButton.setText(localPublishVideoEntry.name);
      localRadioButton.setTag(localPublishVideoEntry.fakeVid);
      localRadioButton.setTextColor(getResources().getColor(2131165381));
    }
    if (localRadioButton != null) {
      localRadioButton.setChecked(true);
    }
    bpT();
  }
  
  /* Error */
  private void d(PublishVideoEntry paramPublishVideoEntry)
  {
    // Byte code:
    //   0: aload_1
    //   1: getfield 264	com/tencent/biz/qqstory/database/PublishVideoEntry:recordTime	D
    //   4: d2i
    //   5: putstatic 269	aniq:bQi	I
    //   8: aload_1
    //   9: getfield 272	com/tencent/biz/qqstory/database/PublishVideoEntry:recordFrames	I
    //   12: putstatic 275	aniq:dHk	I
    //   15: aload_1
    //   16: getfield 278	com/tencent/biz/qqstory/database/PublishVideoEntry:saveMode	I
    //   19: putstatic 281	aniq:bsT	I
    //   22: iconst_0
    //   23: putstatic 284	aniq:dFO	I
    //   26: iconst_0
    //   27: putstatic 287	aniq:dHo	I
    //   30: aload_1
    //   31: getfield 290	com/tencent/biz/qqstory/database/PublishVideoEntry:videoMaxrate	I
    //   34: putstatic 293	aniq:dFI	I
    //   37: aload_1
    //   38: getfield 296	com/tencent/biz/qqstory/database/PublishVideoEntry:videoMinrate	I
    //   41: putstatic 299	aniq:dFJ	I
    //   44: bipush 10
    //   46: invokestatic 304	psx:a	(I)Lpsj;
    //   49: checkcast 306	psr
    //   52: ldc_w 308
    //   55: bipush 23
    //   57: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   60: invokevirtual 318	psr:c	(Ljava/lang/String;Ljava/lang/Object;)Ljava/lang/Object;
    //   63: checkcast 310	java/lang/Integer
    //   66: invokevirtual 321	java/lang/Integer:intValue	()I
    //   69: putstatic 324	aniq:dHm	I
    //   72: iconst_0
    //   73: putstatic 327	aniq:dHt	I
    //   76: getstatic 33	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:f	Ljava/text/DateFormat;
    //   79: new 329	java/util/Date
    //   82: dup
    //   83: invokespecial 330	java/util/Date:<init>	()V
    //   86: invokevirtual 336	java/text/DateFormat:format	(Ljava/util/Date;)Ljava/lang/String;
    //   89: astore 7
    //   91: aload_0
    //   92: getfield 338	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:ae	Landroid/widget/EditText;
    //   95: invokevirtual 344	android/widget/EditText:getText	()Landroid/text/Editable;
    //   98: invokevirtual 347	java/lang/Object:toString	()Ljava/lang/String;
    //   101: invokevirtual 352	java/lang/String:trim	()Ljava/lang/String;
    //   104: invokevirtual 355	java/lang/String:length	()I
    //   107: ifle +18 -> 125
    //   110: aload_0
    //   111: getfield 338	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:ae	Landroid/widget/EditText;
    //   114: invokevirtual 344	android/widget/EditText:getText	()Landroid/text/Editable;
    //   117: invokevirtual 347	java/lang/Object:toString	()Ljava/lang/String;
    //   120: invokevirtual 352	java/lang/String:trim	()Ljava/lang/String;
    //   123: astore 7
    //   125: new 357	java/io/File
    //   128: dup
    //   129: new 162	java/lang/StringBuilder
    //   132: dup
    //   133: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   136: getstatic 362	acbn:SDCARD_PATH	Ljava/lang/String;
    //   139: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   142: ldc_w 364
    //   145: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   148: aload 7
    //   150: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   153: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   156: invokespecial 365	java/io/File:<init>	(Ljava/lang/String;)V
    //   159: astore 7
    //   161: aload 7
    //   163: invokevirtual 368	java/io/File:mkdirs	()Z
    //   166: pop
    //   167: ldc 160
    //   169: new 162	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   176: ldc_w 370
    //   179: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: aload 7
    //   184: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 373	ram:w	(Ljava/lang/String;Ljava/lang/String;)V
    //   193: aload_0
    //   194: getfield 375	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:ac	Landroid/widget/EditText;
    //   197: invokevirtual 344	android/widget/EditText:getText	()Landroid/text/Editable;
    //   200: invokevirtual 347	java/lang/Object:toString	()Ljava/lang/String;
    //   203: invokestatic 378	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   206: invokevirtual 321	java/lang/Integer:intValue	()I
    //   209: istore_2
    //   210: aload_0
    //   211: getfield 380	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:ad	Landroid/widget/EditText;
    //   214: invokevirtual 344	android/widget/EditText:getText	()Landroid/text/Editable;
    //   217: invokevirtual 347	java/lang/Object:toString	()Ljava/lang/String;
    //   220: invokestatic 378	java/lang/Integer:valueOf	(Ljava/lang/String;)Ljava/lang/Integer;
    //   223: invokevirtual 321	java/lang/Integer:intValue	()I
    //   226: istore_3
    //   227: iload_2
    //   228: iload_3
    //   229: if_icmpge +196 -> 425
    //   232: invokestatic 386	java/lang/System:currentTimeMillis	()J
    //   235: lstore 5
    //   237: iconst_0
    //   238: putstatic 327	aniq:dHt	I
    //   241: bipush 23
    //   243: putstatic 324	aniq:dHm	I
    //   246: iload_2
    //   247: bipush 30
    //   249: iadd
    //   250: putstatic 389	aniq:dFK	I
    //   253: new 162	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   260: ldc_w 391
    //   263: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   266: getstatic 324	aniq:dHm	I
    //   269: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   272: ldc_w 396
    //   275: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: getstatic 389	aniq:dFK	I
    //   281: invokevirtual 394	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   284: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   287: astore 8
    //   289: new 162	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 163	java/lang/StringBuilder:<init>	()V
    //   296: aload 7
    //   298: invokevirtual 172	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   301: getstatic 399	java/io/File:separator	Ljava/lang/String;
    //   304: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: aload 8
    //   309: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc_w 401
    //   315: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 175	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: astore 9
    //   323: aload_1
    //   324: getfield 404	com/tencent/biz/qqstory/database/PublishVideoEntry:mLocalRawVideoDir	Ljava/lang/String;
    //   327: aload_1
    //   328: getfield 408	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicMask	[B
    //   331: aload_1
    //   332: getfield 411	com/tencent/biz/qqstory/database/PublishVideoEntry:mMosaicSize	I
    //   335: aload_1
    //   336: getfield 414	com/tencent/biz/qqstory/database/PublishVideoEntry:isMuteRecordVoice	Z
    //   339: aload 9
    //   341: invokestatic 416	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:a	(Ljava/lang/String;[BIZLjava/lang/String;)I
    //   344: istore 4
    //   346: ldc 160
    //   348: ldc_w 418
    //   351: iload 4
    //   353: invokestatic 314	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   356: aload 8
    //   358: aload 9
    //   360: invokestatic 424	aqhq:getFileSizes	(Ljava/lang/String;)J
    //   363: invokestatic 429	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   366: invokestatic 432	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V
    //   369: iload 4
    //   371: ifeq +19 -> 390
    //   374: aload_0
    //   375: getfield 434	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity:cn	Landroid/widget/Button;
    //   378: new 436	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity$2
    //   381: dup
    //   382: aload_0
    //   383: invokespecial 437	com/tencent/biz/qqstory/storyHome/VideoEncodeActivity$2:<init>	(Lcom/tencent/biz/qqstory/storyHome/VideoEncodeActivity;)V
    //   386: invokevirtual 441	android/widget/Button:post	(Ljava/lang/Runnable;)Z
    //   389: pop
    //   390: ldc 160
    //   392: ldc_w 443
    //   395: aload 8
    //   397: invokestatic 386	java/lang/System:currentTimeMillis	()J
    //   400: lload 5
    //   402: lsub
    //   403: invokestatic 429	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   406: invokestatic 446	ram:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V
    //   409: iload_2
    //   410: iconst_1
    //   411: iadd
    //   412: istore_2
    //   413: goto -186 -> 227
    //   416: astore 8
    //   418: iconst_0
    //   419: istore_2
    //   420: iconst_0
    //   421: istore_3
    //   422: goto -195 -> 227
    //   425: bipush 31
    //   427: putstatic 389	aniq:dFK	I
    //   430: bipush 23
    //   432: putstatic 324	aniq:dHm	I
    //   435: return
    //   436: astore 8
    //   438: goto -18 -> 420
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	441	0	this	VideoEncodeActivity
    //   0	441	1	paramPublishVideoEntry	PublishVideoEntry
    //   209	211	2	i	int
    //   226	196	3	j	int
    //   344	26	4	k	int
    //   235	166	5	l	long
    //   89	208	7	localObject	Object
    //   287	109	8	str1	String
    //   416	1	8	localException1	java.lang.Exception
    //   436	1	8	localException2	java.lang.Exception
    //   321	38	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   193	210	416	java/lang/Exception
    //   210	227	436	java/lang/Exception
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    OpenPlayerBuilder.Data localData = (OpenPlayerBuilder.Data)getIntent().getExtras().getSerializable("story_data");
    super.doOnCreate(paramBundle);
    setContentView(2131562003);
    super.setTitle(acfp.m(2131716375));
    this.cn = ((Button)findViewById(2131363979));
    this.cn.setEnabled(false);
    this.Z = ((EditText)findViewById(2131377686));
    this.eV = ((LinearLayout)findViewById(2131377685));
    this.ab = ((EditText)findViewById(2131372852));
    this.ac = ((EditText)findViewById(2131372853));
    this.ad = ((EditText)findViewById(2131372854));
    this.ae = ((EditText)findViewById(2131366451));
    bpU();
    if ((localData != null) && ((localData.mInfo instanceof HomeFeedPlayInfo))) {
      this.b.a((HomeFeedPlayInfo)localData.mInfo);
    }
    for (;;)
    {
      return true;
      if ((localData != null) && ((localData.mInfo instanceof MsgTabPlayInfo))) {
        this.b.a((MsgTabPlayInfo)localData.mInfo);
      }
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject;
    if (paramInt1 == 20000)
    {
      paramIntent = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
      localObject = paramIntent.query(PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), false, "publishState=1 and businessId=?", new String[] { "1" }, null, null, null, null, null);
      if ((localObject != null) && (((List)localObject).size() > 0)) {
        break label73;
      }
      ram.w("Q.qqstory:VideoEncodeActivity", "createStoryVideo: 0");
    }
    for (;;)
    {
      return;
      label73:
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        PublishVideoEntry localPublishVideoEntry = (PublishVideoEntry)((Iterator)localObject).next();
        ram.w("Q.qqstory:VideoEncodeActivity", "createStoryVideo: fakeVid=%s, state=%s, label=%s, description=%s, duration=%d, locationDesc=%s", new Object[] { localPublishVideoEntry.fakeVid, Integer.valueOf(localPublishVideoEntry.publishState), localPublishVideoEntry.videoLabel, localPublishVideoEntry.videoDoodleDescription, Long.valueOf(localPublishVideoEntry.videoDuration), localPublishVideoEntry.videoLocationDescription });
        localPublishVideoEntry.publishState = 0;
        localPublishVideoEntry.setStatus(1000);
        paramIntent.persistOrReplace(localPublishVideoEntry);
        this.ayi = localPublishVideoEntry.fakeVid;
        this.cn.setEnabled(true);
      }
    }
  }
  
  public void onClickDeleteSence(View paramView)
  {
    paramView = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    new PublishVideoEntry();
    Object localObject = pog.a(paramView, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.ayj });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PublishVideoEntry)((List)localObject).get(0);
      ((PublishVideoEntry)localObject).setStatus(1001);
      paramView.remove((Entity)localObject);
      bpU();
    }
  }
  
  public void onClickSaveScene(View paramView)
  {
    if (TextUtils.isEmpty(this.Z.getText().toString())) {
      QQToast.a(this, acfp.m(2131716377), 0).show();
    }
    paramView = QQStoryContext.a().getEntityManagerFactory().createEntityManager();
    new PublishVideoEntry();
    Object localObject = pog.a(paramView, PublishVideoEntry.class, PublishVideoEntry.class.getSimpleName(), PublishVideoEntry.getVidSelectionNoArgs(), new String[] { this.ayi });
    if ((localObject != null) && (((List)localObject).size() > 0))
    {
      localObject = (PublishVideoEntry)((List)localObject).get(0);
      ((PublishVideoEntry)localObject).name = this.Z.getText().toString().trim();
      ((PublishVideoEntry)localObject).setStatus(1000);
      paramView.persistOrReplace((Entity)localObject);
      bpU();
    }
    this.ayi = "";
    this.cn.setEnabled(false);
    this.Z.setText("");
  }
  
  public void onClickStartCompress(View paramView)
  {
    g(acfp.m(2131716376));
    new File(plr.atc).mkdirs();
    new StringBuilder().append(plr.atc).append(System.currentTimeMillis()).append(".mp4").toString();
    paramView = pog.a(this.ayj);
    new pog();
    ThreadManager.newFreeThread(new VideoEncodeActivity.1(this, paramView), "VideoComposite", 5).start();
  }
  
  public void onClickTakePic(View paramView)
  {
    rnq.a().a(this, null, 20000);
  }
  
  public void onClickTestDown(View paramView)
  {
    this.b.onClickTestDown(paramView);
  }
  
  public void onClickTestInit(View paramView) {}
  
  public void onClickTestUp(View paramView)
  {
    this.b.onClickTestUp(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.storyHome.VideoEncodeActivity
 * JD-Core Version:    0.7.0.1
 */