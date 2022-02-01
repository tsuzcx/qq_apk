import android.annotation.TargetApi;
import android.media.MediaMetadataRetriever;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.database.PublishVideoEntry;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.a;
import com.tencent.biz.qqstory.model.item.StoryVideoItem.b;
import com.tencent.mobileqq.shortvideo.util.AudioEncoder;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

@TargetApi(14)
public class poj
  extends prz
{
  private pom a = new pom();
  protected AtomicBoolean aH = new AtomicBoolean(false);
  protected final ConcurrentHashMap<String, poj.a> bS = new ConcurrentHashMap(3);
  protected final Object bn = new Object();
  protected final Object mDataLock = new Object();
  protected final ArrayList<String> mz = new ArrayList(3);
  
  private void a(String paramString, long paramLong, poj.a parama)
  {
    long l = SystemClock.elapsedRealtime();
    PublishVideoEntry localPublishVideoEntry = pog.a(paramString);
    if (TextUtils.isEmpty(localPublishVideoEntry.backgroundMusicPath)) {}
    for (paramString = "0";; paramString = "1")
    {
      rar.b("publish_story", "video_composite_wait", b(localPublishVideoEntry), parama.b.errorCode, new String[] { parama.b.errorMsg, String.valueOf(l - paramLong), String.valueOf(localPublishVideoEntry.videoDuration), paramString });
      return;
    }
  }
  
  private void a(poj.b paramb, PublishVideoEntry paramPublishVideoEntry, long paramLong)
  {
    paramLong = System.currentTimeMillis() - paramLong;
    label96:
    boolean bool;
    if (TextUtils.isEmpty(paramPublishVideoEntry.backgroundMusicPath))
    {
      str = "0";
      j = b(paramPublishVideoEntry);
      rar.b("publish_story", "video_composite", j, paramb.b.errorCode, new String[] { paramb.b.errorMsg, String.valueOf(paramLong), String.valueOf(paramPublishVideoEntry.videoDuration), str });
      if (!paramPublishVideoEntry.isPicture)
      {
        if (!paramPublishVideoEntry.hwEncodeRecordVideo) {
          break label253;
        }
        i = 1;
        rar.b("publish_story", "video_encode", 0, i, new String[] { paramPublishVideoEntry.videoMaxrate + "", paramPublishVideoEntry.videoMinrate + "" });
      }
      a(j, paramb.videoUrl, paramPublishVideoEntry);
      bool = paramb.b.isSuccess();
      if (!paramb.b.isSuccess()) {
        break label259;
      }
    }
    label259:
    for (String str = "1";; str = "0")
    {
      rar.a("StoryMergeVideoSuc", bool, 0L, new String[] { str });
      if (!paramb.b.isFail()) {
        break label266;
      }
      rar.a("StoryMergeVideoError", true, 0L, new String[] { String.valueOf(paramb.b.errorCode) });
      return;
      str = "1";
      break;
      label253:
      i = 0;
      break label96;
    }
    label266:
    int i = paramPublishVideoEntry.getIntExtra("composite_key_capturemode", 0);
    int j = paramPublishVideoEntry.getIntExtra("composite_key_entrance", 0);
    int k;
    long l1;
    if (paramPublishVideoEntry.businessId == 1)
    {
      bool = paramPublishVideoEntry.isPicture;
      k = (int)paramLong;
      str = rar.bY(i);
      l1 = paramPublishVideoEntry.videoDuration;
      if (!bool) {
        break label610;
      }
    }
    label610:
    for (paramb = "2";; paramb = "0")
    {
      rar.a("time_composite", 10002, k, new String[] { str, String.valueOf(l1), paramb, String.valueOf(j) });
      if ((axvu.dwO) && (!paramPublishVideoEntry.isPicture) && (axvu.g.isEnabled()))
      {
        l1 = axvu.g.t[0];
        long l2 = axvu.g.t[1];
        long l3 = axvu.g.t[2];
        long l4 = axvu.g.t[3];
        long l5 = axvu.g.t[4];
        if ((rar.d(paramLong, 0L, 120000L)) && (rar.d(l1, 0L, 120000L)) && (rar.d(l2, 0L, 120000L)) && (rar.d(l3, 0L, 10000L)) && (rar.d(l4, 0L, 120000L)) && (rar.d(l5, 0L, 120000L))) {
          rar.a("MergeVideoCost", true, paramLong, new String[] { String.valueOf(l1), String.valueOf(l2), String.valueOf(l3), String.valueOf(l4), String.valueOf(l5) });
        }
        axvu.g.stopMonitor();
      }
      l1 = paramPublishVideoEntry.getLongExtra("composite_key_merge_thumb_cost", -1L);
      if ((!axvu.dwO) || (l1 <= 0L)) {
        break;
      }
      axvu.h.startMonitor();
      axvu.h.ay(0, l1);
      axvu.h.ay(1, paramLong);
      return;
    }
  }
  
  public static int bc(String paramString)
  {
    long l = System.currentTimeMillis();
    String str = paramString + ".temp.mp4";
    ram.d("Q.qqstory.publish.upload.VideoCompositeManager", "reEncodeVideoWithFFmpeg start!");
    int i = ankf.h(paramString, str, 0);
    if (i != 0) {
      QLog.e("Q.qqstory.publish.upload.VideoCompositeManager", 2, "[NewVersion]HwVideoMerge->merge: errcode=" + i);
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.i("Q.qqstory.publish.upload.VideoCompositeManager", 2, "reEncodeVideoWithFFmpeg cost=" + (System.currentTimeMillis() - l));
      }
      return i;
      aqhq.deleteFile(paramString);
      aqhq.rename(str, paramString);
      i = 0;
    }
  }
  
  /* Error */
  public poj.a a(String paramString)
  {
    // Byte code:
    //   0: invokestatic 68	android/os/SystemClock:elapsedRealtime	()J
    //   3: lstore_3
    //   4: aload_0
    //   5: getfield 46	poj:mDataLock	Ljava/lang/Object;
    //   8: astore 6
    //   10: aload 6
    //   12: monitorenter
    //   13: aload_0
    //   14: getfield 41	poj:bS	Ljava/util/concurrent/ConcurrentHashMap;
    //   17: aload_1
    //   18: invokevirtual 310	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   21: checkcast 6	poj$a
    //   24: astore 7
    //   26: aload 6
    //   28: monitorexit
    //   29: aload 7
    //   31: ifnull +44 -> 75
    //   34: aload 7
    //   36: getfield 311	poj$a:videoUrl	Ljava/lang/String;
    //   39: invokestatic 316	rox:checkFileExist	(Ljava/lang/String;)Z
    //   42: ifeq +20 -> 62
    //   45: aload_0
    //   46: aload_1
    //   47: lload_3
    //   48: aload 7
    //   50: invokespecial 318	poj:a	(Ljava/lang/String;JLpoj$a;)V
    //   53: aload 7
    //   55: areturn
    //   56: astore_1
    //   57: aload 6
    //   59: monitorexit
    //   60: aload_1
    //   61: athrow
    //   62: aload_0
    //   63: getfield 41	poj:bS	Ljava/util/concurrent/ConcurrentHashMap;
    //   66: aload 7
    //   68: getfield 321	poj$a:vid	Ljava/lang/String;
    //   71: invokevirtual 324	java/util/concurrent/ConcurrentHashMap:remove	(Ljava/lang/Object;)Ljava/lang/Object;
    //   74: pop
    //   75: aload_0
    //   76: aload_1
    //   77: invokevirtual 328	poj:rc	(Ljava/lang/String;)V
    //   80: iconst_0
    //   81: istore_2
    //   82: aload_0
    //   83: getfield 48	poj:bn	Ljava/lang/Object;
    //   86: astore 6
    //   88: aload 6
    //   90: monitorenter
    //   91: ldc_w 262
    //   94: ldc_w 330
    //   97: iconst_1
    //   98: anewarray 43	java/lang/Object
    //   101: dup
    //   102: iconst_0
    //   103: aload_1
    //   104: aastore
    //   105: invokestatic 334	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   108: aload_0
    //   109: getfield 48	poj:bn	Ljava/lang/Object;
    //   112: ldc2_w 232
    //   115: invokevirtual 338	java/lang/Object:wait	(J)V
    //   118: ldc_w 262
    //   121: ldc_w 340
    //   124: iconst_1
    //   125: anewarray 43	java/lang/Object
    //   128: dup
    //   129: iconst_0
    //   130: aload_1
    //   131: aastore
    //   132: invokestatic 334	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   135: aload 6
    //   137: monitorexit
    //   138: aload_0
    //   139: getfield 46	poj:mDataLock	Ljava/lang/Object;
    //   142: astore 6
    //   144: aload 6
    //   146: monitorenter
    //   147: aload_0
    //   148: getfield 36	poj:mz	Ljava/util/ArrayList;
    //   151: aload_1
    //   152: invokevirtual 344	java/util/ArrayList:contains	(Ljava/lang/Object;)Z
    //   155: istore 5
    //   157: aload_0
    //   158: getfield 41	poj:bS	Ljava/util/concurrent/ConcurrentHashMap;
    //   161: aload_1
    //   162: invokevirtual 310	java/util/concurrent/ConcurrentHashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   165: checkcast 6	poj$a
    //   168: astore 7
    //   170: aload 6
    //   172: monitorexit
    //   173: aload 7
    //   175: ifnull +60 -> 235
    //   178: ldc_w 262
    //   181: ldc_w 346
    //   184: iconst_1
    //   185: anewarray 43	java/lang/Object
    //   188: dup
    //   189: iconst_0
    //   190: aload 7
    //   192: aastore
    //   193: invokestatic 334	ram:w	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   196: aload_0
    //   197: aload_1
    //   198: lload_3
    //   199: aload 7
    //   201: invokespecial 318	poj:a	(Ljava/lang/String;JLpoj$a;)V
    //   204: aload 7
    //   206: areturn
    //   207: astore 7
    //   209: ldc_w 262
    //   212: ldc_w 348
    //   215: aload 7
    //   217: invokestatic 351	ram:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   220: goto -85 -> 135
    //   223: astore_1
    //   224: aload 6
    //   226: monitorexit
    //   227: aload_1
    //   228: athrow
    //   229: astore_1
    //   230: aload 6
    //   232: monitorexit
    //   233: aload_1
    //   234: athrow
    //   235: iload 5
    //   237: ifne +59 -> 296
    //   240: new 6	poj$a
    //   243: dup
    //   244: aload_0
    //   245: invokespecial 354	poj$a:<init>	(Lpoj;)V
    //   248: astore 6
    //   250: aload 6
    //   252: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   255: dup
    //   256: ldc_w 355
    //   259: ldc_w 357
    //   262: invokespecial 360	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   265: putfield 97	poj$a:b	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   268: ldc_w 262
    //   271: ldc_w 362
    //   274: iconst_1
    //   275: anewarray 43	java/lang/Object
    //   278: dup
    //   279: iconst_0
    //   280: aload_1
    //   281: aastore
    //   282: invokestatic 364	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   285: aload_0
    //   286: aload_1
    //   287: lload_3
    //   288: aload 6
    //   290: invokespecial 318	poj:a	(Ljava/lang/String;JLpoj$a;)V
    //   293: aload 6
    //   295: areturn
    //   296: iload_2
    //   297: bipush 40
    //   299: if_icmple +94 -> 393
    //   302: new 6	poj$a
    //   305: dup
    //   306: aload_0
    //   307: invokespecial 354	poj$a:<init>	(Lpoj;)V
    //   310: astore 7
    //   312: aload 7
    //   314: new 99	com/tencent/biz/qqstory/base/ErrorMessage
    //   317: dup
    //   318: ldc_w 365
    //   321: ldc_w 367
    //   324: invokespecial 360	com/tencent/biz/qqstory/base/ErrorMessage:<init>	(ILjava/lang/String;)V
    //   327: putfield 97	poj$a:b	Lcom/tencent/biz/qqstory/base/ErrorMessage;
    //   330: ldc_w 262
    //   333: ldc_w 369
    //   336: iconst_1
    //   337: anewarray 43	java/lang/Object
    //   340: dup
    //   341: iconst_0
    //   342: aload_1
    //   343: aastore
    //   344: invokestatic 364	ram:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   347: aload_0
    //   348: aload_1
    //   349: lload_3
    //   350: aload 7
    //   352: invokespecial 318	poj:a	(Ljava/lang/String;JLpoj$a;)V
    //   355: aload_0
    //   356: getfield 46	poj:mDataLock	Ljava/lang/Object;
    //   359: astore 6
    //   361: aload 6
    //   363: monitorenter
    //   364: aload_0
    //   365: getfield 36	poj:mz	Ljava/util/ArrayList;
    //   368: aload_1
    //   369: invokevirtual 371	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   372: pop
    //   373: aload_0
    //   374: getfield 55	poj:aH	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   377: iconst_0
    //   378: invokevirtual 374	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   381: aload 6
    //   383: monitorexit
    //   384: aload 7
    //   386: areturn
    //   387: astore_1
    //   388: aload 6
    //   390: monitorexit
    //   391: aload_1
    //   392: athrow
    //   393: iload_2
    //   394: iconst_1
    //   395: iadd
    //   396: istore_2
    //   397: goto -315 -> 82
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	400	0	this	poj
    //   0	400	1	paramString	String
    //   81	316	2	i	int
    //   3	347	3	l	long
    //   155	81	5	bool	boolean
    //   24	181	7	locala1	poj.a
    //   207	9	7	localInterruptedException	java.lang.InterruptedException
    //   310	75	7	locala2	poj.a
    // Exception table:
    //   from	to	target	type
    //   13	29	56	finally
    //   57	60	56	finally
    //   91	135	207	java/lang/InterruptedException
    //   91	135	223	finally
    //   135	138	223	finally
    //   209	220	223	finally
    //   224	227	223	finally
    //   147	173	229	finally
    //   230	233	229	finally
    //   364	384	387	finally
    //   388	391	387	finally
  }
  
  protected void a(int paramInt, String paramString, PublishVideoEntry paramPublishVideoEntry)
  {
    try
    {
      int i = (int)aqhq.getFileSizes(paramString);
      if (i <= 0) {
        return;
      }
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramString);
      paramString = ((MediaMetadataRetriever)localObject).extractMetadata(9);
      String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(20);
      String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str3 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      ((MediaMetadataRetriever)localObject).release();
      localObject = str2 + "*" + str3;
      rar.b("publish_story", "video_info", paramInt, i, new String[] { localObject, paramString, String.valueOf(paramPublishVideoEntry.recordFrames), str1 });
      ram.d("Q.qqstory.publish.upload.VideoCompositeManager", "video info size:%d, duration:%s, framesCount:%d, bitRate:%s, picSize:%s", new Object[] { Integer.valueOf(i), paramString, Integer.valueOf(paramPublishVideoEntry.recordFrames), str1, localObject });
      return;
    }
    catch (Exception paramString)
    {
      ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "exception ", paramString);
    }
  }
  
  public void a(PublishVideoEntry paramPublishVideoEntry, String arg2, int paramInt, String arg4, String paramString3, long paramLong)
  {
    poj.b localb = new poj.b();
    localb.b = new ErrorMessage(paramInt, ???);
    localb.vid = ???;
    localb.videoUrl = paramString3;
    if ((paramInt == 0) && ((TextUtils.isEmpty(paramString3)) || (!rox.checkFileExist(paramString3)) || (aqhq.getFileSizes(paramString3) < 100L))) {
      localb.b = new ErrorMessage(940007, String.format("vid:%s file:%s", new Object[] { ???, paramString3 }));
    }
    long l1;
    synchronized (this.mDataLock)
    {
      if (this.mz.remove(???)) {
        this.aH.set(false);
      }
      this.bS.put(???, localb);
      l1 = 0L;
      ??? = "";
    }
    label1156:
    for (;;)
    {
      try
      {
        if (!localb.b.isFail()) {
          continue;
        }
        if (!new File(paramPublishVideoEntry.mLocalRawVideoDir).isDirectory()) {
          continue;
        }
        localObject1 = aqhq.ag(paramPublishVideoEntry.mLocalRawVideoDir).iterator();
        if (((Iterator)localObject1).hasNext())
        {
          localObject2 = (String)((Iterator)localObject1).next();
          l1 += aqhq.getFileSizes((String)localObject2);
          ??? = ??? + (String)localObject2;
          continue;
          paramPublishVideoEntry = finally;
          throw paramPublishVideoEntry;
        }
        if (!TextUtils.isEmpty(???)) {
          break label1156;
        }
        ??? = paramPublishVideoEntry.mLocalRawVideoDir;
      }
      catch (Exception ???)
      {
        synchronized (this.bn)
        {
          Object localObject1;
          Object localObject2;
          long l2;
          boolean bool2;
          int i;
          this.bn.notifyAll();
          ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "end composite result:%s", new Object[] { localb });
          bma();
          a(localb, paramPublishVideoEntry, paramLong);
          return;
          l1 = aqhq.getFileSizes(paramPublishVideoEntry.mLocalRawVideoDir);
          ??? = "" + paramPublishVideoEntry.mLocalRawVideoDir;
          continue;
          ??? = ???;
          ram.e("Q.qqstory.publish.upload.VideoCompositeManager", "", ???);
          continue;
          ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s not all success", new Object[] { paramPublishVideoEntry.multiFragmentGroupId });
          continue;
          paramInt = 0;
          continue;
          boolean bool1 = false;
          continue;
          bool1 = false;
          continue;
          ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "failed to composite. let's save original video to album.");
          if ((paramPublishVideoEntry.hasFragments) && (!this.a.fb(paramPublishVideoEntry.multiFragmentGroupId))) {
            continue;
          }
          ??? = paramPublishVideoEntry.videoUploadTempDir + "mc_audio.mp4";
          paramString3 = AudioEncoder.a(null, null, 0);
          paramString3.cez = ???;
          paramString3.cey = paramPublishVideoEntry.mAudioFilePath;
          paramInt = AudioEncoder.a(paramString3);
          if (paramInt != 0) {
            continue;
          }
          ??? = qem.k(???, false);
          paramInt = ankf.c(paramPublishVideoEntry.mLocalRawVideoDir, ???, ???, 0);
          if (paramInt != 0) {
            continue;
          }
          ram.d("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: success.");
          rox.broadcastCarmera(BaseApplication.getContext(), new File(???));
          continue;
          ram.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. HwVideoMerge->merge: errcode=%s", new Object[] { Integer.valueOf(paramInt) });
          continue;
          ram.e("Q.qqstory.publish.upload.VideoCompositeManager", "save original video. AudioEncoder.encodeSafely: errcode=%s" + paramInt);
          continue;
          this.a.bmb();
        }
      }
      l2 = rox.dY();
      localb.b.errorMsg = String.format("errorCode:%d, sdcard free size:%d, vf dir size:%d, vf filename:%s, oMsg:%s", new Object[] { Integer.valueOf(localb.b.errorCode), Long.valueOf(l2), Long.valueOf(l1), ???, localb.b.errorMsg });
      if (l1 < 100L) {
        localb.b.errorCode = 940018;
      }
      ram.e("Q.qqstory.publish.upload.VideoCompositeManager", localb.b.errorMsg);
      if ((localb.b.isSuccess()) && (paramPublishVideoEntry.hasFragments))
      {
        pog.p(???, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC);
        l1 = rox.dY();
        ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "sdcard free size %d MB", new Object[] { Long.valueOf(l1 / 1024L / 1024L) });
        if (l1 < 104857600L)
        {
          if (!pog.q(paramPublishVideoEntry.multiFragmentGroupId, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_SUC)) {
            continue;
          }
          rox.fA(paramPublishVideoEntry.mLocalRawVideoDir);
          ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "groupId=%s all success so delete file:%s", new Object[] { paramPublishVideoEntry.multiFragmentGroupId, paramPublishVideoEntry.mLocalRawVideoDir });
        }
      }
      if ((localb.b.isFail()) && (paramPublishVideoEntry.hasFragments)) {
        pog.p(???, PublishVideoEntry.VIDEO_PROCESS_STATE_COMPOSITE_FAILED);
      }
      bool2 = paramPublishVideoEntry.getBooleanExtra("isEdited", false);
      if ((paramPublishVideoEntry.isLocalPublish) && (bool2))
      {
        paramInt = 1;
        if (((paramPublishVideoEntry.businessId != 1) && (paramPublishVideoEntry.businessId != 14)) || (paramPublishVideoEntry.isPicture)) {
          continue;
        }
        bool1 = true;
        if (QLog.isColorLevel()) {
          QLog.d("Q.qqstory.publish.upload.VideoCompositeManager", 2, "save from: story " + bool2 + " " + paramPublishVideoEntry.isLocalPublish + " " + bool1);
        }
        if ((bool1) || (paramInt != 0))
        {
          if (!localb.b.isSuccess()) {
            continue;
          }
          ram.d("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task.");
          ??? = this.a.fP(???);
          this.a.O(paramString3, ???);
          l1 = paramPublishVideoEntry.getLongExtra("groupUin", -1L);
          paramString3 = paramPublishVideoEntry.getStringExtra("pl", "");
          localObject1 = paramPublishVideoEntry.getStringExtra("i_l", "");
          ram.b("Q.qqstory.publish.upload.VideoCompositeManager", "composite successfully. add save to album task. pl: %s", String.valueOf(paramString3));
          localObject2 = this.a;
          paramInt = paramPublishVideoEntry.videoWidth;
          i = paramPublishVideoEntry.videoHeight;
          if (l1 <= 0L) {
            continue;
          }
          bool1 = true;
          ((pom)localObject2).a(???, ???, null, paramInt, i, bool1, StoryVideoItem.b.a(paramString3), StoryVideoItem.a.a((String)localObject1));
          if (!paramPublishVideoEntry.hasFragments) {
            continue;
          }
          if (this.a.fa(paramPublishVideoEntry.multiFragmentGroupId)) {
            this.a.bmb();
          }
        }
        pmi.a().dispatch(localb);
      }
    }
  }
  
  protected int b(PublishVideoEntry paramPublishVideoEntry)
  {
    if (!paramPublishVideoEntry.isLocalPublish)
    {
      if (!paramPublishVideoEntry.isPicture) {
        return 1;
      }
      return 2;
    }
    if (!paramPublishVideoEntry.isPicture) {
      return 3;
    }
    return 4;
  }
  
  protected void bma()
  {
    if (this.aH.getAndSet(true))
    {
      ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "video composite ing");
      return;
    }
    String str1 = "";
    synchronized (this.mDataLock)
    {
      if (this.mz.size() > 0) {
        str1 = (String)this.mz.get(0);
      }
      if (TextUtils.isEmpty(str1))
      {
        this.aH.set(false);
        ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "no video to composite");
        return;
      }
    }
    ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "will composite vid:%s", new Object[] { str2 });
    long l = System.currentTimeMillis();
    if (axvu.dwO) {
      axvu.g.startMonitor();
    }
    Bosses.get().postJob(new pok(this, "Q.qqstory.publish.upload.VideoCompositeManager", str2, l));
  }
  
  public void rc(String paramString)
  {
    synchronized (this.mDataLock)
    {
      if (!this.mz.contains(paramString))
      {
        this.mz.add(paramString);
        ram.w("Q.qqstory.publish.upload.VideoCompositeManager", "add composite vid:%s", new Object[] { paramString });
      }
      bma();
      return;
    }
  }
  
  public class a
    extends plt
  {
    public String vid;
    public String videoUrl;
    
    public a() {}
    
    public String toString()
    {
      return "CompositeVideoEvent{vid='" + this.vid + '\'' + ", errorInfo='" + this.b + '\'' + ", videoUrl='" + this.videoUrl + '\'' + '}';
    }
  }
  
  public class b
    extends poj.a
  {
    public b()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     poj
 * JD-Core Version:    0.7.0.1
 */