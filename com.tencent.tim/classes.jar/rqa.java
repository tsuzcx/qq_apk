import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.media.MediaMetadataRetriever;
import android.text.TextUtils;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.3;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpeg.5;
import com.tencent.biz.qqstory.utils.ffmpeg.FFmpegCommandAlreadyRunningException;
import com.tencent.common.config.AppSetting;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class rqa
{
  protected static volatile rqa b;
  public rqg a;
  public rqh a;
  public String aBJ;
  protected boolean aJl;
  public boolean aJm;
  public BroadcastReceiver ap = new rqf(this);
  public int bub = -9999;
  public final Context context;
  public ArrayList<rqg> mA = new ArrayList();
  public ArrayList<String> nJ = new ArrayList();
  protected long timeout = 9223372036854775807L;
  
  private rqa(Context paramContext)
  {
    this.context = paramContext.getApplicationContext();
    paramContext = new IntentFilter();
    paramContext.addAction("android.intent.action.SCREEN_OFF");
    paramContext.addAction("android.intent.action.SCREEN_ON");
    this.context.registerReceiver(this.ap, paramContext);
    rqx.v(new File(rqs.am(this.context)));
  }
  
  public static rqa a(Context paramContext)
  {
    return a(paramContext, false);
  }
  
  public static rqa a(Context paramContext, boolean paramBoolean)
  {
    if (b == null) {}
    try
    {
      if (b == null) {
        b = new rqa(paramContext);
      }
      b.aJl = paramBoolean;
      return b;
    }
    finally {}
  }
  
  private void a(String paramString1, String paramString2, String paramString3, float paramFloat1, float paramFloat2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    localArrayList.add("[0:a]volume=" + paramFloat1 + "[a0];[1:a]volume=" + paramFloat2 + "[a1];[a0][a1]amix=inputs=2:duration=first:dropout_transition=3");
    localArrayList.add("-strict");
    localArrayList.add("-2");
    localArrayList.add("-vn");
    localArrayList.add(paramString3);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  private void a(String paramString, rpz paramrpz)
    throws FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString);
    localArrayList.add("-filter_complex");
    localArrayList.add("volumedetect");
    localArrayList.add("-c:v");
    localArrayList.add("copy");
    localArrayList.add("-f");
    localArrayList.add("null");
    localArrayList.add("/dev/null");
    a((String[])localArrayList.toArray(new String[0]), paramrpz);
  }
  
  public static rqa b(Context paramContext, boolean paramBoolean)
  {
    paramContext = new rqa(paramContext);
    paramContext.aJl = paramBoolean;
    return paramContext;
  }
  
  private String cj(int paramInt)
  {
    return String.format("%02d:%02d:%02d.%03d", new Object[] { Integer.valueOf((int)Math.floor(paramInt / 3600000)), Integer.valueOf((int)Math.floor(paramInt % 3600000) / 60000), Integer.valueOf((int)Math.floor(paramInt % 60000 / 1000)), Integer.valueOf((int)Math.floor(paramInt % 1000)) });
  }
  
  private void g(String paramString1, String paramString2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-vn");
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  private void h(String paramString1, String paramString2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-an");
    localArrayList.add("-vcodec");
    localArrayList.add("copy");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public boolean LT()
  {
    return (this.jdField_a_of_type_Rqh != null) && (!this.jdField_a_of_type_Rqh.LU());
  }
  
  public rpx a(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, int paramInt, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    paramString4 = new rpx(paramString4);
    paramString4.videoCodec = paramString3;
    return a(paramString1, paramString2, paramBoolean, paramString4, paramInt, paramrqi);
  }
  
  public rpx a(String paramString1, String paramString2, boolean paramBoolean, rpx paramrpx, int paramInt, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "combineAudioAndVideo arguments: \n inVideo" + paramString1 + "\n inAudio:" + paramString2 + "\n outMedia:" + paramrpx);
    if (!rox.fileExistsAndNotEmpty(paramString1))
    {
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inVideo file is not exist");
      paramrqi.onFailure(String.valueOf(941002));
      paramrqi.onFinish(false);
      return paramrpx;
    }
    if (!rox.fileExistsAndNotEmpty(paramString2))
    {
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramrqi.onFailure(String.valueOf(941002));
      paramrqi.onFinish(false);
      return paramrpx;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    String str;
    long l1;
    if (paramBoolean)
    {
      paramString1 = new MediaMetadataRetriever();
      paramString1.setDataSource(paramString2);
      str = paramString1.extractMetadata(9);
      paramString1.release();
      l1 = paramInt;
    }
    label822:
    label833:
    try
    {
      long l2 = Long.parseLong(str);
      l1 = l2;
    }
    catch (Exception paramString1)
    {
      label205:
      int i;
      StringBuilder localStringBuilder;
      label453:
      break label205;
    }
    i = (int)Math.ceil(paramInt / (float)l1);
    if (i > 1)
    {
      paramString1 = new File(paramString2).getCanonicalPath();
      str = new File(paramString2).getParent() + "/catAudioFile.txt";
      localStringBuilder = new StringBuilder();
      paramInt = 0;
      while (paramInt < i)
      {
        if (paramInt > 0) {
          localStringBuilder.append("\n");
        }
        localStringBuilder.append("file '").append(paramString1).append("'");
        paramInt += 1;
      }
      aqhq.writeFile(str, localStringBuilder.toString());
      localArrayList.add("-f");
      localArrayList.add("concat");
      localArrayList.add("-safe");
      localArrayList.add("0");
      localArrayList.add("-i");
      localArrayList.add(str);
      localArrayList.add("-map_chapters");
      localArrayList.add("-1");
      localArrayList.add("-strict");
      localArrayList.add("-2");
      localArrayList.add("-vcodec");
      if (paramrpx.videoCodec == null) {
        break label822;
      }
      localArrayList.add(paramrpx.videoCodec);
      localArrayList.add("-acodec");
      if (paramrpx.audioCodec == null) {
        break label833;
      }
      localArrayList.add(paramrpx.audioCodec);
    }
    for (;;)
    {
      rqj.gr(paramString2);
      localArrayList.add("-bsf:a");
      localArrayList.add("aac_adtstoasc");
      if (paramrpx.btZ != -1)
      {
        localArrayList.add("-b:v");
        localArrayList.add(paramrpx.btZ + "k");
      }
      if (paramrpx.aBH != null)
      {
        localArrayList.add("-r");
        localArrayList.add(paramrpx.aBH);
      }
      if (paramrpx.bua != -1)
      {
        localArrayList.add("-b:a");
        localArrayList.add(paramrpx.bua + "k");
      }
      if (paramrpx.width > 0)
      {
        localArrayList.add("-s");
        localArrayList.add(paramrpx.width + "x" + paramrpx.height);
      }
      if (paramrpx.format != null)
      {
        localArrayList.add("-f");
        localArrayList.add(paramrpx.format);
      }
      paramString1 = new File(paramrpx.path);
      if (paramBoolean) {
        localArrayList.add("-shortest");
      }
      localArrayList.add(paramString1.getCanonicalPath());
      a((String[])localArrayList.toArray(new String[0]), paramrqi);
      return paramrpx;
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      break;
      localArrayList.add("-i");
      localArrayList.add(new File(paramString2).getCanonicalPath());
      break;
      localArrayList.add("copy");
      break label453;
      localArrayList.add("aac");
    }
  }
  
  public void a(String paramString1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean, String paramString2, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    Object localObject = rpv.h(paramString1);
    if (localObject == null)
    {
      paramrqi.onFailure("input path is null");
      paramrqi.onFinish(false);
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", "compressVideo input path is null");
      return;
    }
    int k = localObject[1];
    int n = localObject[2];
    int m = -1;
    int i = -1;
    int j;
    if ((k > 960) || (n > 960))
    {
      if (n >= k) {
        break label640;
      }
      i = 540;
      j = 540 * k / n;
    }
    for (;;)
    {
      if (k <= n)
      {
        j = 540;
        i = 540 * n / k;
      }
      k = i;
      if (i % 2 != 0) {
        k = i + 1;
      }
      i = j;
      m = k;
      if (j % 2 != 0)
      {
        i = j + 1;
        m = k;
      }
      k = 1;
      long l = rox.getFileSize(paramString1);
      j = k;
      if (l != -1L)
      {
        j = k;
        if (l < 2202009.6000000001D) {
          j = 0;
        }
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add("-y");
      if (paramInt2 != 0)
      {
        ((ArrayList)localObject).add("-ss");
        ((ArrayList)localObject).add(String.valueOf(paramInt1 / 1000) + "." + String.valueOf(paramInt1 % 1000));
        ((ArrayList)localObject).add("-accurate_seek");
      }
      ((ArrayList)localObject).add("-i");
      ((ArrayList)localObject).add(new File(paramString1).getCanonicalPath());
      if (paramInt2 != 0)
      {
        ((ArrayList)localObject).add("-t");
        ((ArrayList)localObject).add(String.valueOf(paramInt2 / 1000) + "." + String.valueOf(paramInt2 % 1000));
      }
      if ((i > 0) && (m > 0))
      {
        ((ArrayList)localObject).add("-vf");
        ((ArrayList)localObject).add("scale=" + i + ":" + m);
      }
      if (paramBoolean) {
        ((ArrayList)localObject).add("-an");
      }
      for (;;)
      {
        ((ArrayList)localObject).add("-vcodec");
        ((ArrayList)localObject).add("libx264");
        if (j != 0)
        {
          ((ArrayList)localObject).add("-b:v");
          ((ArrayList)localObject).add("" + paramInt3);
        }
        ((ArrayList)localObject).add("-bufsize");
        ((ArrayList)localObject).add("800k");
        ((ArrayList)localObject).add("-r");
        ((ArrayList)localObject).add("25");
        ((ArrayList)localObject).add("-metadata");
        ((ArrayList)localObject).add("title=" + System.currentTimeMillis());
        ((ArrayList)localObject).add("-movflags");
        ((ArrayList)localObject).add("faststart");
        ((ArrayList)localObject).add(new File(paramString2).getCanonicalPath());
        a((String[])((ArrayList)localObject).toArray(new String[0]), paramrqi);
        return;
        ((ArrayList)localObject).add("-acodec");
        ((ArrayList)localObject).add("aac");
      }
      label640:
      j = k;
      i = n;
    }
  }
  
  public void a(String paramString1, String paramString2, int paramInt1, int paramInt2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio arguments: \n inAudio" + paramString1 + "\n outAudio:" + paramString2 + "\n start:" + paramInt1 + "\n duration:" + paramInt2);
    if (!rox.fileExistsAndNotEmpty(paramString1))
    {
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", "clipAudio but inAudio file is not exist");
      paramrqi.onFailure(String.valueOf(941001));
      paramrqi.onFinish(false);
      return;
    }
    String str1 = cj(paramInt1);
    String str2 = cj(paramInt2);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-ss");
    localArrayList.add(str1);
    localArrayList.add("-t");
    localArrayList.add(str2);
    localArrayList.add("-acodec");
    localArrayList.add("copy");
    localArrayList.add("-vn");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void a(String paramString1, String paramString2, int paramInt, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    paramString1 = new StringBuilder();
    paramString1.append("dev=").append(aqgz.getDeviceModel()).append("/").append("os=").append(aqgz.getDeviceOSVersion()).append("/").append("appVer=").append(AppSetting.nT());
    localArrayList.add("-metadata");
    localArrayList.add("comment=" + paramString1.toString());
    if (paramInt != -1)
    {
      localArrayList.add("-metadata:s:v:0");
      localArrayList.add("rotate=" + paramInt);
    }
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-codec");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "watermark arguments: \n inImage" + paramString1 + "\n inMedia:" + paramString2 + "\n outMedia:" + paramString3 + "\n videoWidth:" + paramInt1 + "\n videoHeight:" + paramInt2);
    if ((paramString2 == null) || (paramString3 == null))
    {
      paramrqi.onFailure("input path is null");
      paramrqi.onFinish(false);
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "watermark input path is null");
      return;
    }
    if (paramString1 == null)
    {
      boolean bool = rox.saveVideoToAlbum(this.context, paramString2, paramString3);
      if (bool) {
        paramrqi.onSuccess("copy_success");
      }
      for (;;)
      {
        paramrqi.onFinish(bool);
        ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "watermark inImage == null, copy to DCIM result is " + bool);
        return;
        paramrqi.onFailure("copy_fail");
      }
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("movie=" + paramString1 + " [watermark]; [watermark]scale=" + paramInt1 + ":" + paramInt2 + " [watermark]; [in][watermark] overlay=(main_w-overlay_w)/2:(main_h-overlay_h)/2 [out] ");
    localArrayList.add("-max_muxing_queue_size");
    localArrayList.add("9999");
    localArrayList.add(new File(paramString3).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void a(String paramString1, String paramString2, String paramString3, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    int i = Integer.valueOf(paramString2).intValue();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    switch (i % 360)
    {
    default: 
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "unSupport orientation:%s", new Object[] { paramString2 });
      return;
    case 0: 
      ram.d("Q.qqstory.ffmpeg.FFmpegCmd", "no need rotate.");
      return;
    case 90: 
      localArrayList.add("transpose=1");
    }
    for (;;)
    {
      localArrayList.add("-c:a");
      localArrayList.add("copy");
      localArrayList.add(new File(paramString3).getCanonicalPath());
      a((String[])localArrayList.toArray(new String[0]), paramrqi);
      return;
      localArrayList.add("transpose=1,transpose=1");
      continue;
      localArrayList.add("transpose=1,transpose=1,transpose=1");
    }
  }
  
  public void a(String paramString1, String paramString2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "mp4Tots arguments: \n input:" + paramString1 + "\n outputPath:" + paramString2);
    this.nJ.add(paramString2);
    if (rox.fileExistsAndNotEmpty(paramString2))
    {
      paramrqi.onSuccess("TS file exists");
      paramrqi.onFinish(true);
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "TS file exists");
      return;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-c");
    localArrayList.add("copy");
    localArrayList.add("-bsf:v");
    localArrayList.add("h264_mp4toannexb");
    localArrayList.add("-f");
    localArrayList.add("mpegts");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void a(List<String> paramList, String paramString, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "concatDifferentCodingMedia arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < paramList.size())
    {
      localArrayList.add("-i");
      localArrayList.add(new File((String)paramList.get(i)).getCanonicalPath());
      localStringBuilder.append("[" + i + ":0]");
      localStringBuilder.append(" ");
      localStringBuilder.append("[" + i + ":1]");
      localStringBuilder.append(" ");
      i += 1;
    }
    localStringBuilder.append("concat=n=" + paramList.size() + ":v=1:a=1 [v] [a]");
    localArrayList.add("-filter_complex");
    localArrayList.add(localStringBuilder.toString());
    localArrayList.add("-map");
    localArrayList.add("[v]");
    localArrayList.add("-map");
    localArrayList.add("[a]");
    localArrayList.add(new File(paramString).getCanonicalPath());
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void a(List<String> paramList, String paramString, rqi paramrqi, boolean paramBoolean)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "concatMedia arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    new File(paramString);
    File localFile = new File(plr.ath + "temp.txt");
    if (localFile.exists()) {
      localFile.delete();
    }
    if (!localFile.getParentFile().exists()) {
      localFile.getParentFile().mkdirs();
    }
    localFile.createNewFile();
    for (;;)
    {
      try
      {
        localBufferedWriter = new BufferedWriter(new FileWriter(localFile, true));
        int i = 0;
        if (paramString == null) {
          break label364;
        }
      }
      finally
      {
        try
        {
          if (i < paramList.size())
          {
            localBufferedWriter.write("file '" + new File((String)paramList.get(i)).getCanonicalPath() + "'");
            localBufferedWriter.newLine();
            i += 1;
            continue;
          }
          localBufferedWriter.flush();
          if (localBufferedWriter != null) {
            localBufferedWriter.close();
          }
          paramList = new ArrayList();
          paramList.add("-y");
          paramList.add("-f");
          paramList.add("concat");
          paramList.add("-i");
          paramList.add(localFile.getCanonicalPath());
          if (!paramBoolean) {
            break label366;
          }
          paramList.add("-c:v");
          paramList.add("libx264");
          paramList.add("-bsf:a");
          paramList.add("aac_adtstoasc");
          paramList.add(new File(paramString).getCanonicalPath());
          a((String[])paramList.toArray(new String[0]), new rqc(this, paramrqi, localFile));
          return;
        }
        finally
        {
          for (;;)
          {
            BufferedWriter localBufferedWriter;
            paramString = localBufferedWriter;
          }
        }
        paramList = finally;
        paramString = null;
      }
      paramString.close();
      label364:
      throw paramList;
      label366:
      paramList.add("-c");
      paramList.add("copy");
    }
  }
  
  public void a(String[] paramArrayOfString, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException
  {
    if ((this.jdField_a_of_type_Rqh != null) && (!this.jdField_a_of_type_Rqh.LU()))
    {
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg command is already running");
      throw new FFmpegCommandAlreadyRunningException("FFmpeg command is already running, you are only allowed to run single command at a time");
    }
    if (paramArrayOfString.length != 0)
    {
      Object localObject = paramArrayOfString[(paramArrayOfString.length - 1)];
      this.jdField_a_of_type_Rqg = new rqg(paramArrayOfString, (String)localObject, paramrqi);
      int i = ((String)localObject).lastIndexOf("/");
      if ((i > -1) && (i < ((String)localObject).length() - 1))
      {
        localObject = new File(((String)localObject).substring(0, i + 1));
        if (!((File)localObject).exists()) {
          ((File)localObject).mkdir();
        }
      }
      paramrqi = new rqb(this, paramrqi);
      paramArrayOfString = (String[])rqx.a((String[])rqx.a(new String[] { rqs.am(this.context) }, paramArrayOfString), new String[] { rqs.an(this.context) });
      this.jdField_a_of_type_Rqh = new rqh(this.context, paramArrayOfString, this.timeout, this.aJl, paramrqi);
      this.jdField_a_of_type_Rqh.execute(new Void[0]);
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "command execute: " + TextUtils.join(" ", paramArrayOfString));
      return;
    }
    throw new IllegalArgumentException("shell command cannot be empty");
  }
  
  public void b(String paramString1, String paramString2, String paramString3, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-loop");
    localArrayList.add("1");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-pix_fmt");
    localArrayList.add("yuv420p");
    localArrayList.add("-t");
    localArrayList.add(paramString3);
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "convertPicToVideoWithTime args: %s", new Object[] { Arrays.toString(paramString1) });
    a(paramString1, paramrqi);
  }
  
  public void b(String paramString1, String paramString2, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-analyzeduration");
    localArrayList.add("2147483647");
    localArrayList.add("-probesize");
    localArrayList.add("2147483647");
    localArrayList.add("-framerate");
    localArrayList.add("1/3");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vcodec");
    localArrayList.add("libx264");
    localArrayList.add("-preset");
    localArrayList.add("veryslow");
    localArrayList.add("-bufsize");
    localArrayList.add("800k");
    localArrayList.add("-metadata");
    localArrayList.add("title=" + System.currentTimeMillis());
    localArrayList.add("-movflags");
    localArrayList.add("faststart");
    localArrayList.add("-r");
    localArrayList.add("25");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "convertPicToVideo args: %s", new Object[] { Arrays.toString(paramString1) });
    a(paramString1, paramrqi);
  }
  
  public void b(List<String> paramList, String paramString, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "concatMediaByTs arguments: \n inMedias:" + paramList + "\n outMedia:" + paramString);
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramList.size())
    {
      localObject1 = (String)paramList.get(i);
      Object localObject2 = new File((String)localObject1).getName().split("\\.");
      localObject2 = plr.ath + localObject2[0] + ".ts";
      Object localObject3 = new File((String)localObject2);
      if (!((File)localObject3).getParentFile().exists()) {
        ((File)localObject3).getParentFile().mkdirs();
      }
      localObject3 = new rqg();
      ((rqg)localObject3).cmdType = 5;
      ((rqg)localObject3).nL = new FFmpeg.3(this, (String)localObject1, (String)localObject2);
      ((rqg)localObject3).d = new rqd(this, paramrqi);
      localArrayList.add(localObject3);
      i += 1;
    }
    paramList = new rqg();
    Object localObject1 = this.nJ;
    paramList.cmdType = 2;
    paramList.nL = new FFmpeg.5(this, (ArrayList)localObject1, paramString);
    paramList.d = paramrqi;
    localArrayList.add(paramList);
    cu(localArrayList);
  }
  
  public void bvR()
  {
    rqx.v(new File(rqs.am(this.context)));
  }
  
  public void c(String paramString1, String paramString2, String paramString3, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-i");
    localArrayList.add(paramString2);
    localArrayList.add("-filter_complex");
    localArrayList.add("[1:v]scale=iw:ih[s];[0:v][s]overlay=0:0");
    localArrayList.add(paramString3);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void c(String paramString1, String paramString2, rqi paramrqi)
  {
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "fake ffmeng command. arguments: \n inMedia:" + paramString1 + "\n outMedia:" + paramString2);
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)))
    {
      paramrqi.onFailure("input path is null");
      ram.e("Q.qqstory.ffmpeg.FFmpegCmd", "fake ffmeng command. input path is null");
      paramrqi.onFinish(false);
      return;
    }
    boolean bool = rox.saveVideoToAlbum(this.context, paramString1, paramString2);
    if (bool) {
      paramrqi.onSuccess("copy_success");
    }
    for (;;)
    {
      paramrqi.onFinish(bool);
      ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "copy video to album result is " + bool);
      return;
      paramrqi.onFailure("copy_fail");
    }
  }
  
  public void c(List<String> paramList, String paramString, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("\"concat:");
    int i = 0;
    while (i < paramList.size())
    {
      localStringBuffer.append((String)paramList.get(i));
      if (i != paramList.size() - 1) {
        localStringBuffer.append("|");
      }
      i += 1;
    }
    localStringBuffer.append("\"");
    this.nJ = new ArrayList();
    paramList = new ArrayList();
    paramList.add("-y");
    paramList.add("-i");
    paramList.add(new String(localStringBuffer));
    paramList.add("-c");
    paramList.add("copy");
    paramList.add("-bsf:a");
    paramList.add("aac_adtstoasc");
    paramList.add(paramString);
    a((String[])paramList.toArray(new String[0]), paramrqi);
  }
  
  public void cu(ArrayList<rqg> paramArrayList)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    this.mA = paramArrayList;
    if (this.mA.size() <= 0) {
      return;
    }
    paramArrayList = (rqg)this.mA.remove(0);
    ArrayList localArrayList = paramArrayList.nL;
    String[] arrayOfString = paramArrayList.cb;
    rqe localrqe = new rqe(this, paramArrayList.d, arrayOfString, this.mA);
    if (arrayOfString != null)
    {
      a(arrayOfString, localrqe);
      return;
    }
    switch (paramArrayList.cmdType)
    {
    default: 
      return;
    case 1: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Integer)localArrayList.get(3)).intValue(), ((Integer)localArrayList.get(4)).intValue(), localrqe);
      return;
    case 3: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), localrqe);
      return;
    case 4: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), (String)localArrayList.get(3), ((Boolean)localArrayList.get(4)).booleanValue(), ((Integer)localArrayList.get(5)).intValue(), localrqe);
      return;
    case 2: 
      a((List)localArrayList.get(0), (String)localArrayList.get(1), localrqe, ((Boolean)localArrayList.get(2)).booleanValue());
      return;
    case 7: 
      b((List)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 8: 
      a((List)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 5: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 6: 
      c((List)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 9: 
      b((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 10: 
      f((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 11: 
      a((String)localArrayList.get(0), ((Integer)localArrayList.get(1)).intValue(), ((Integer)localArrayList.get(2)).intValue(), ((Integer)localArrayList.get(3)).intValue(), ((Boolean)localArrayList.get(4)).booleanValue(), (String)localArrayList.get(5), localrqe);
      return;
    case 12: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), localrqe);
      return;
    case 13: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), ((Integer)localArrayList.get(2)).intValue(), localrqe);
      return;
    case 14: 
      c((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 15: 
      c((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), localrqe);
      return;
    case 16: 
      d((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 17: 
      a((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), ((Float)localArrayList.get(3)).floatValue(), ((Float)localArrayList.get(4)).floatValue(), localrqe);
      return;
    case 21: 
      e((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 18: 
      g((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 19: 
      h((String)localArrayList.get(0), (String)localArrayList.get(1), localrqe);
      return;
    case 20: 
      b((String)localArrayList.get(0), (String)localArrayList.get(1), (String)localArrayList.get(2), localrqe);
      return;
    }
    a((String)localArrayList.get(0), localrqe);
  }
  
  public void cv(ArrayList<rqg> paramArrayList)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ue(false);
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "[insertFFmpegQueue][old] " + TextUtils.join(" ", paramArrayList.toArray()));
    if (this.jdField_a_of_type_Rqg != null) {
      this.mA.add(0, this.jdField_a_of_type_Rqg);
    }
    this.mA.addAll(0, paramArrayList);
    cu(this.mA);
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "[insertFFmpegQueue][new] " + TextUtils.join(" ", paramArrayList.toArray()));
  }
  
  public void d(String paramString1, String paramString2, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vn");
    localArrayList.add("-c:a");
    localArrayList.add("copy");
    localArrayList.add(new File(paramString2).getCanonicalPath());
    paramString1 = (String[])localArrayList.toArray(new String[0]);
    ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "extractAudioFromMp4 args: %s", new Object[] { Arrays.toString(paramString1) });
    a(paramString1, paramrqi);
  }
  
  public void e(String paramString1, String paramString2, rqi paramrqi)
    throws IOException, FFmpegCommandAlreadyRunningException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-i");
    localArrayList.add(paramString1);
    localArrayList.add("-ab");
    localArrayList.add("96k");
    localArrayList.add("-ar");
    localArrayList.add("44100");
    localArrayList.add("-ac");
    localArrayList.add("1");
    localArrayList.add("-vn");
    localArrayList.add("-acodec");
    localArrayList.add("aac");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public void f(String paramString1, String paramString2, rqi paramrqi)
    throws FFmpegCommandAlreadyRunningException, IOException
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add("-y");
    localArrayList.add("-i");
    localArrayList.add(new File(paramString1).getCanonicalPath());
    localArrayList.add("-vf");
    localArrayList.add("transpose=1");
    localArrayList.add("-metadata:s:v");
    localArrayList.add("rotate=0");
    localArrayList.add(paramString2);
    a((String[])localArrayList.toArray(new String[0]), paramrqi);
  }
  
  public boolean fF(String paramString)
  {
    return (this.aBJ != null) && (paramString != null) && (paramString.equals(this.aBJ));
  }
  
  public void sH(String paramString)
  {
    this.aBJ = paramString;
  }
  
  public void ue(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rqh != null) && (!this.jdField_a_of_type_Rqh.LU()))
    {
      rqx.a(this.jdField_a_of_type_Rqh);
      this.jdField_a_of_type_Rqh = null;
      this.bub = -9999;
      if (this.jdField_a_of_type_Rqg != null)
      {
        if (this.jdField_a_of_type_Rqg.aBI != null)
        {
          File localFile = new File(this.jdField_a_of_type_Rqg.aBI);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        if ((paramBoolean) && (this.jdField_a_of_type_Rqg.d != null))
        {
          this.jdField_a_of_type_Rqg.d.onFailure("FFmpeg任务被强制Kill掉");
          this.jdField_a_of_type_Rqg.d.onFinish(false);
          ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
      ram.d("Q.qqstory.ffmpeg.FFmpegCmd", "KillFFmpeg!");
    }
  }
  
  public void uf(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_Rqh != null) && (!this.jdField_a_of_type_Rqh.LU()))
    {
      rqx.a(this.jdField_a_of_type_Rqh);
      this.jdField_a_of_type_Rqh = null;
      this.bub = -9999;
      if (this.jdField_a_of_type_Rqg != null)
      {
        if (this.jdField_a_of_type_Rqg.aBI != null)
        {
          File localFile = new File(this.jdField_a_of_type_Rqg.aBI);
          if (localFile.exists()) {
            localFile.delete();
          }
        }
        if (this.jdField_a_of_type_Rqg.d != null)
        {
          this.jdField_a_of_type_Rqg.d.onFailure("FFmpeg任务被强制Kill掉");
          this.jdField_a_of_type_Rqg.d.onFinish(false);
          ram.w("Q.qqstory.ffmpeg.FFmpegCmd", "FFmpeg任务被强制Kill掉");
        }
      }
      ram.d("Q.qqstory.ffmpeg.FFmpegCmd", "KillFFmpeg!");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rqa
 * JD-Core Version:    0.7.0.1
 */