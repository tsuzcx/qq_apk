import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Rect;
import android.graphics.RectF;
import android.media.MediaMetadataRetriever;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.biz.troop.VideoCombineHelper.1;
import com.tencent.biz.troop.VideoCombineHelper.2;
import com.tencent.biz.troop.VideoCombineHelper.3;
import com.tencent.biz.troop.VideoCombineHelper.CombineTask.3;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.shortvideo.VideoEnvironment;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import mqq.app.AppRuntime;

public class sli
{
  public static final String aEA = acbn.SDCARD_ROOT + "/Tencent/QQ_business/videocombine";
  Object bA = new Object();
  BaseActivity c;
  HashMap<String, sli.c> fO = new HashMap();
  rqa ffmpeg;
  skj g;
  long gx = 0L;
  
  public sli(BaseActivity paramBaseActivity)
  {
    File localFile = new File(aEA);
    if (!localFile.exists()) {
      localFile.mkdirs();
    }
    this.ffmpeg = rqa.a(BaseApplicationImpl.getApplication());
    this.ffmpeg.bvR();
    this.c = paramBaseActivity;
    this.g = skj.a();
  }
  
  public aqvc a()
  {
    return new aqva(null).a(1);
  }
  
  public String a(sli.c paramc, sli.a parama)
  {
    ??? = UUID.nameUUIDFromBytes(paramc.wording.getBytes());
    String str1 = "combineVideo_" + ((UUID)???).toString();
    String str2 = "prepareVideo_" + ((UUID)???).toString();
    synchronized (this.bA)
    {
      if (this.fO.containsKey(str2))
      {
        ((sli.c)this.fO.get(str2)).isStop = true;
        Looper.prepare();
        new Handler().postDelayed(new VideoCombineHelper.1(this, paramc, parama), 300L);
        return str1;
      }
      this.fO.put(str1, paramc);
      ThreadManager.post(new VideoCombineHelper.2(this, parama, System.currentTimeMillis(), str1), 8, null, false);
      return str1;
    }
  }
  
  public void a(String paramString1, String paramString2, sli.a parama)
  {
    Object localObject1 = new File(paramString1).getParentFile();
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    ArrayList localArrayList1 = new ArrayList();
    this.gx = System.currentTimeMillis();
    Object localObject2 = new rqg();
    Object localObject3 = ((File)localObject1).getAbsolutePath() + File.separator + "vn.m4a";
    Object localObject4 = new ArrayList();
    ((ArrayList)localObject4).add("-y");
    ((ArrayList)localObject4).add("-i");
    ((ArrayList)localObject4).add(paramString1);
    ((ArrayList)localObject4).add("-strict");
    ((ArrayList)localObject4).add("-2");
    ((ArrayList)localObject4).add("-acodec");
    ((ArrayList)localObject4).add("aac");
    ((ArrayList)localObject4).add("-vn");
    ((ArrayList)localObject4).add(localObject3);
    ((rqg)localObject2).cb = ((String[])((ArrayList)localObject4).toArray(new String[0]));
    ((rqg)localObject2).d = new slm(this, parama, paramString1);
    localArrayList1.add(localObject2);
    ((ArrayList)localObject4).clear();
    localObject4 = new rqg();
    localObject2 = ((File)localObject1).getAbsolutePath() + File.separator + "an.ts";
    Object localObject5 = new ArrayList();
    ((ArrayList)localObject5).add("-y");
    ((ArrayList)localObject5).add("-i");
    ((ArrayList)localObject5).add(paramString1);
    ((ArrayList)localObject5).add("-vcodec");
    ((ArrayList)localObject5).add("copy");
    ((ArrayList)localObject5).add("-an");
    ((ArrayList)localObject5).add(localObject2);
    ((rqg)localObject4).cb = ((String[])((ArrayList)localObject5).toArray(new String[0]));
    ((rqg)localObject4).d = new sln(this, parama, paramString1);
    localArrayList1.add(localObject4);
    localObject5 = new rqg();
    localObject4 = ((File)localObject1).getAbsolutePath() + File.separator + "mixed.m4a";
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("-y");
    localArrayList2.add("-i");
    localArrayList2.add(localObject3);
    localArrayList2.add("-i");
    localArrayList2.add(paramString2);
    localArrayList2.add("-filter_complex");
    localArrayList2.add("amix=inputs=2:duration=first:dropout_transition=2");
    localArrayList2.add(localObject4);
    ((rqg)localObject5).cb = ((String[])localArrayList2.toArray(new String[0]));
    ((rqg)localObject5).d = new slo(this, parama, paramString1);
    localArrayList1.add(localObject5);
    paramString2 = new rqg();
    localObject1 = ((File)localObject1).getAbsolutePath() + File.separator + "combine.mp4";
    localObject3 = new ArrayList();
    ((ArrayList)localObject3).add("-y");
    ((ArrayList)localObject3).add("-i");
    ((ArrayList)localObject3).add(localObject2);
    ((ArrayList)localObject3).add("-i");
    ((ArrayList)localObject3).add(localObject4);
    ((ArrayList)localObject3).add("-strict");
    ((ArrayList)localObject3).add("2");
    ((ArrayList)localObject3).add("-vcodec");
    ((ArrayList)localObject3).add("copy");
    ((ArrayList)localObject3).add("-acodec");
    ((ArrayList)localObject3).add("aac");
    ((ArrayList)localObject3).add(localObject1);
    paramString2.cb = ((String[])((ArrayList)localObject3).toArray(new String[0]));
    paramString2.d = new slp(this, parama, (String)localObject1, paramString1);
    localArrayList1.add(paramString2);
    ((ArrayList)localObject3).clear();
    if (this.ffmpeg.LT()) {
      try
      {
        this.ffmpeg.cv(localArrayList1);
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
      catch (IOException paramString1)
      {
        paramString1.printStackTrace();
        return;
      }
    }
    try
    {
      this.ffmpeg.cu(localArrayList1);
      return;
    }
    catch (FFmpegCommandAlreadyRunningException paramString1)
    {
      paramString1.printStackTrace();
      return;
    }
    catch (IOException paramString1)
    {
      paramString1.printStackTrace();
    }
  }
  
  public void a(sli.c paramc, sli.a parama)
  {
    ??? = UUID.nameUUIDFromBytes(paramc.wording.getBytes());
    String str = "prepareVideo_" + ((UUID)???).toString();
    paramc.aLV = true;
    synchronized (this.bA)
    {
      if (this.fO.containsKey(str)) {
        return;
      }
      this.fO.put(str, paramc);
      ThreadManager.post(new VideoCombineHelper.3(this, parama, System.currentTimeMillis(), str), 8, null, false);
      return;
    }
  }
  
  public static abstract interface a
  {
    public abstract void e(String paramString1, boolean paramBoolean, String paramString2);
  }
  
  class b
    extends sli.h
  {
    public b(sli.i parami, String paramString)
    {
      super(parami, paramString);
    }
    
    public void run()
    {
      this.a.b(this);
    }
  }
  
  public class c
  {
    public String Qp;
    public String aEC;
    public String aED;
    boolean aLV;
    boolean isStop = false;
    public int msgTailType;
    public ArrayList<String> oe = new ArrayList();
    public ArrayList<String> of = new ArrayList();
    public ArrayList<File> og = new ArrayList();
    String troopUin;
    public String wording;
    
    public c() {}
  }
  
  public class d
    extends sli.h
  {
    String aEE;
    int count = 0;
    List<String> pu;
    String wording;
    
    public d(String paramString1, List<String> paramList, String paramString2, String paramString3)
    {
      super(paramString1, paramList);
      this.aEE = paramString3;
      Object localObject;
      this.wording = localObject;
      this.pu = paramString2;
      this.jdField_a_of_type_Sli$h = new sli.g(sli.this, paramString1, paramList);
    }
    
    public File a(File paramFile, String paramString, sli.a parama)
    {
      Object localObject = new MediaMetadataRetriever();
      ((MediaMetadataRetriever)localObject).setDataSource(paramFile.getAbsolutePath());
      String str1 = ((MediaMetadataRetriever)localObject).extractMetadata(18);
      String str2 = ((MediaMetadataRetriever)localObject).extractMetadata(19);
      ((MediaMetadataRetriever)localObject).release();
      localObject = paramFile.getParent() + File.separator + "wording.png";
      String str3 = paramFile.getParent() + File.separator + "vmw.mp4";
      try
      {
        int i = Integer.parseInt(str1);
        int j = Integer.parseInt(str2);
        long l = System.currentTimeMillis();
        a(i, j, paramString, (String)localObject);
        if (QLog.isColorLevel()) {
          QLog.d(".troop.trace_video_combine", 2, "createWatermarkPng time = " + (System.currentTimeMillis() - l));
        }
        a().og.add(new File((String)localObject));
        sli.this.ffmpeg.a((String)localObject, paramFile.getAbsolutePath(), str3, i, j, new slw(this, parama, str3));
      }
      catch (Exception paramFile)
      {
        for (;;)
        {
          QLog.e(".troop.VideoCombineHelper", 2, "combineWording failed!", paramFile);
        }
      }
      return null;
    }
    
    public void a(List<String> paramList, String paramString, sli.a parama)
    {
      if ((paramList == null) || (this.pu.size() == 0))
      {
        parama.e(null, false, "videoFiles empty!");
        return;
      }
      if (paramList.size() == 1)
      {
        parama.e((String)this.pu.get(0), true, "combineVideos Success size = 1");
        return;
      }
      try
      {
        long l = System.currentTimeMillis();
        paramList = new File(paramString);
        a(this.pu, paramList.getAbsolutePath(), new slu(this, l, parama, paramList));
        return;
      }
      catch (Exception paramList)
      {
        QLog.e(".troop.VideoCombineHelper", 2, "combineVideos failed", paramList);
      }
    }
    
    public void a(List<String> paramList, String paramString, sli.f paramf)
      throws FFmpegCommandAlreadyRunningException, IOException
    {
      Object localObject1 = new File(paramString);
      if ((((File)localObject1).exists()) && (((File)localObject1).length() > 0L))
      {
        paramf.aB(true);
        return;
      }
      localObject1 = new ArrayList();
      sli.this.gx = System.currentTimeMillis();
      StringBuffer localStringBuffer = new StringBuffer("concat:");
      int i = 0;
      if (i < paramList.size())
      {
        localObject2 = (String)paramList.get(i);
        Object localObject3 = new File((String)localObject2);
        Object localObject4 = ((File)localObject3).getName().split("\\.");
        localObject3 = ((File)localObject3).getAbsoluteFile().getParent() + File.separator + localObject4[0] + ".ts";
        localStringBuffer.append((String)localObject3);
        if (i != paramList.size() - 1) {
          localStringBuffer.append("|");
        }
        localObject4 = new File((String)localObject3);
        if ((((File)localObject4).exists()) && (((File)localObject4).length() > 0L)) {}
        for (;;)
        {
          i += 1;
          break;
          if (!((File)localObject4).getParentFile().exists()) {
            ((File)localObject4).getParentFile().mkdirs();
          }
          localObject4 = new rqg();
          ((rqg)localObject4).cmdType = 5;
          ((rqg)localObject4).nL = new VideoCombineHelper.CombineTask.3(this, (String)localObject2, (String)localObject3);
          ((rqg)localObject4).d = new slv(this, paramf);
          ((ArrayList)localObject1).add(localObject4);
        }
      }
      paramList = new File(paramString);
      paramString = paramList.getName().split("\\.");
      paramList = paramList.getParent() + File.separator + paramString[0] + ".ts";
      paramString = new rqg();
      Object localObject2 = new ArrayList();
      ((ArrayList)localObject2).add("-y");
      ((ArrayList)localObject2).add("-i");
      ((ArrayList)localObject2).add(localStringBuffer.toString());
      ((ArrayList)localObject2).add("-c");
      ((ArrayList)localObject2).add("copy");
      ((ArrayList)localObject2).add(paramList);
      paramString.cb = ((String[])((ArrayList)localObject2).toArray(new String[0]));
      paramString.d = paramf;
      ((ArrayList)localObject1).add(paramString);
      if (sli.this.ffmpeg.LT()) {
        try
        {
          sli.this.ffmpeg.cv((ArrayList)localObject1);
          return;
        }
        catch (FFmpegCommandAlreadyRunningException paramList)
        {
          paramList.printStackTrace();
          return;
        }
        catch (IOException paramList)
        {
          paramList.printStackTrace();
          return;
        }
      }
      try
      {
        sli.this.ffmpeg.cu((ArrayList)localObject1);
        return;
      }
      catch (FFmpegCommandAlreadyRunningException paramList)
      {
        paramList.printStackTrace();
        return;
      }
      catch (IOException paramList)
      {
        paramList.printStackTrace();
      }
    }
    
    public boolean a(int paramInt1, int paramInt2, String paramString1, String paramString2)
    {
      boolean bool = false;
      try
      {
        Bitmap localBitmap = Bitmap.createBitmap(paramInt1, paramInt2, Bitmap.Config.ARGB_8888);
        Canvas localCanvas = new Canvas(localBitmap);
        Paint localPaint1 = new Paint();
        localPaint1.setColor(-1);
        localPaint1.setTextSize(30.0F);
        localPaint1.setTextAlign(Paint.Align.CENTER);
        Rect localRect = new Rect();
        localPaint1.getTextBounds(paramString1, 0, paramString1.length(), localRect);
        Paint localPaint2 = new Paint();
        localPaint2.setColor(-16777216);
        RectF localRectF = new RectF();
        localRectF.top = (paramInt2 - localRect.height() - 15 - 15);
        localRectF.left = ((paramInt1 - localRect.width()) / 2 - 15);
        localRectF.bottom = (localRectF.top + localRect.height() + 15);
        localRectF.right = (localRectF.left + localRect.width() + 30);
        localCanvas.drawRoundRect(localRectF, 8.0F, 8.0F, localPaint2);
        localCanvas.drawText(paramString1, paramInt1 / 2, paramInt2 - 15 - localRect.height() / 2, localPaint1);
        rop.a(localBitmap, Bitmap.CompressFormat.PNG, 100, paramString2);
        rop.f(localBitmap);
        bool = true;
      }
      catch (Throwable paramString1)
      {
        while (!QLog.isColorLevel()) {}
        QLog.e(".troop.VideoCombineHelper", 2, "createWatermarkByWording", paramString1);
      }
      return bool;
      return false;
    }
    
    public void run()
    {
      String str;
      sli.c localc;
      if ((this.pu != null) && (this.pu.size() > 0))
      {
        str = getRootDir() + File.separator + "v.ts";
        localc = a();
        if (localc.isStop) {
          this.jdField_a_of_type_Sli$i.b(this);
        }
      }
      else
      {
        return;
      }
      a(this.pu, str, new slq(this, localc));
    }
  }
  
  public class e
    extends sli.h
  {
    HashMap<String, File> fP = new HashMap();
    ArrayList<String> oh = new ArrayList();
    
    public e(sli.i parami, String paramString)
    {
      super(parami, paramString);
      this$1 = a();
      int i = 0;
      while (i < sli.this.oe.size())
      {
        parami = (String)sli.this.oe.get(i);
        paramString = ao(parami, ".mp4");
        sli.this.of.add(paramString);
        if ((!new File(paramString).exists()) && (!this.oh.contains(parami)))
        {
          this.oh.add(parami);
          this.fP.put(parami, new File(paramString));
        }
        i += 1;
      }
      if (!TextUtils.isEmpty(sli.this.aEC))
      {
        parami = new File(ao(sli.this.aEC, ".m4a"));
        if (!parami.exists())
        {
          this.oh.add(sli.this.aEC);
          this.fP.put(sli.this.aEC, new File(parami.getAbsolutePath()));
        }
        sli.this.Qp = parami.getAbsolutePath();
      }
    }
    
    private String ao(String paramString1, String paramString2)
    {
      paramString1 = UUID.nameUUIDFromBytes(paramString1.getBytes());
      paramString1 = getCacheDir().getAbsolutePath() + File.separator + "v_" + paramString1.toString() + paramString2;
      paramString2 = new File(paramString1);
      if (!paramString2.getParentFile().exists()) {
        paramString2.mkdirs();
      }
      return paramString1;
    }
    
    public void run()
    {
      long l = System.currentTimeMillis();
      Object localObject1 = new Bundle();
      sli.c localc = a();
      if (localc.isStop)
      {
        this.jdField_a_of_type_Sli$i.b(this);
        return;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject2;
      if (this.oh.size() > 0)
      {
        localObject2 = new aquz(this.oh, this.fP, this.key);
        ((aquz)localObject2).retryCount = 3;
        sli.this.a().a((aquz)localObject2, new slx(this, localc, localArrayList, l), (Bundle)localObject1);
        label111:
        if (QLog.isColorLevel()) {
          QLog.d(".troop.VideoCombineHelper", 2, "start Download key = " + this.key);
        }
      }
      else
      {
        try
        {
          localObject1 = localc.of.iterator();
          int i = 1;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (String)((Iterator)localObject1).next();
            File localFile = new File(getRootDir() + File.separator + "v_" + i + ".mp4");
            localArrayList.add(localFile.getAbsolutePath());
            if (localFile.exists())
            {
              i += 1;
            }
            else
            {
              if (!localFile.exists()) {
                localFile.createNewFile();
              }
              rox.copyFile(new File((String)localObject2), localFile);
              i += 1;
            }
          }
          runNext();
        }
        catch (IOException localIOException)
        {
          QLog.e(".troop.VideoCombineHelper", 1, localIOException, new Object[0]);
          this.jdField_a_of_type_Sli$i.a(this);
          localc.of = localArrayList;
          this.jdField_a_of_type_Sli$i.b(this);
          this.jdField_a_of_type_Sli$h = new sli.d(sli.this, this.jdField_a_of_type_Sli$i, this.key, localc.of, localc.Qp, localc.wording);
          if (!VideoEnvironment.r((AppInterface)BaseApplicationImpl.getApplication().getRuntime().getAppRuntime("modular_web"))) {}
        }
      }
      for (;;)
      {
        QLog.d(".troop.trace_video_combine", 2, "downLoadTime = " + (System.currentTimeMillis() - l));
        break label111;
        break;
        if (localc.aLV)
        {
          this.jdField_a_of_type_Sli$i.b(this.jdField_a_of_type_Sli$h);
        }
        else
        {
          this.jdField_a_of_type_Sli$h.msg = "lib not ready";
          this.jdField_a_of_type_Sli$i.a(this.jdField_a_of_type_Sli$h);
        }
      }
    }
  }
  
  public class f
    implements rqi
  {
    f() {}
    
    public void aB(boolean paramBoolean) {}
    
    public void onFailure(String paramString)
    {
      aB(false);
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onFailure" + paramString);
      }
    }
    
    public void onFinish(boolean paramBoolean) {}
    
    public void onProgress(String paramString)
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onProgress" + paramString);
      }
    }
    
    public void onStart()
    {
      if (QLog.isColorLevel()) {
        QLog.d(".troop.VideoCombineHelper", 2, "ffmpeg onStart");
      }
    }
    
    public void onSuccess(String paramString)
    {
      aB(true);
    }
  }
  
  class g
    extends sli.h
  {
    public g(sli.i parami, String paramString)
    {
      super(parami, paramString);
    }
    
    public void run()
    {
      sli.this.g.bzj();
      sli.c localc = a();
      sli.this.g.a(localc.aED, localc.troopUin, localc.msgTailType, new sly(this));
      this.jdField_a_of_type_Sli$i.b(this);
      this.jdField_a_of_type_Sli$h = new sli.b(sli.this, this.jdField_a_of_type_Sli$i, this.key);
      runNext();
    }
  }
  
  public abstract class h
  {
    h jdField_a_of_type_Sli$h;
    sli.i jdField_a_of_type_Sli$i;
    String key;
    String msg;
    
    public h(sli.i parami, String paramString)
    {
      this.jdField_a_of_type_Sli$i = parami;
      this.key = paramString;
    }
    
    public sli.c a()
    {
      synchronized (sli.this.bA)
      {
        sli.c localc = (sli.c)sli.this.fO.get(this.key);
        return localc;
      }
    }
    
    public File getCacheDir()
    {
      File localFile = new File(sli.aEA + File.separator + "cache");
      if (!localFile.exists()) {
        localFile.mkdirs();
      }
      return localFile;
    }
    
    public File getRootDir()
    {
      int i = this.key.indexOf("_");
      Object localObject = this.key.substring(i + 1, this.key.length());
      localObject = new File(sli.aEA + File.separator + (String)localObject);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      return localObject;
    }
    
    public abstract void run();
    
    public void runNext()
    {
      if (this.jdField_a_of_type_Sli$h != null) {
        this.jdField_a_of_type_Sli$h.run();
      }
    }
  }
  
  public class i
  {
    public i() {}
    
    public void a(sli.h paramh) {}
    
    public void b(sli.h paramh) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     sli
 * JD-Core Version:    0.7.0.1
 */