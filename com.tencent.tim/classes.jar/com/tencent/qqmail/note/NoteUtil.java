package com.tencent.qqmail.note;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.BitmapFactory.Options;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.QMComposeNote;
import com.tencent.qqmail.utilities.common.CommUtils;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.io.File;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NoteUtil
{
  public static String COMPRESS_TOKEN = "_compress_";
  public static final int JPEG_COMPRESS_RATIO = 85;
  public static final String LOCAL_TOKEN = "file://localhost";
  
  public static String addProtocal(String paramString)
  {
    if (paramString.startsWith("file://localhost")) {
      return paramString;
    }
    if (!paramString.startsWith("/")) {
      QMLog.log(4, "alger", "caller should start with root path !!!! originalPath :" + paramString);
    }
    return "file://localhost" + StringExtention.replaceIllegalUrl(paramString);
  }
  
  public static String compressLocalFile(String paramString1, String paramString2, float paramFloat)
  {
    Object localObject1 = Pattern.compile("([^\\\\/\\.]*)$").matcher(paramString1);
    String str = "";
    if (((Matcher)localObject1).find()) {
      str = ((Matcher)localObject1).group(1);
    }
    localObject1 = new File(paramString1);
    if ((!((File)localObject1).exists()) || (paramString1.contains(COMPRESS_TOKEN)) || (!FileUtil.isImageSuffix(str))) {
      return ((File)localObject1).getAbsolutePath();
    }
    localObject1 = ((File)localObject1).getAbsolutePath();
    float f2 = getMaxWidthWithScale(paramFloat);
    Object localObject2 = String.valueOf(String.valueOf(paramString1.hashCode()).replace("-", "") + COMPRESS_TOKEN + (int)paramFloat + "." + str);
    localObject2 = new File(paramString2 + (String)localObject2);
    if (!((File)localObject2).exists())
    {
      paramFloat = ImageUtil.getImageOpts(paramString1).outWidth;
      if (paramFloat != 0.0F) {
        break label295;
      }
      paramFloat = f2;
    }
    label286:
    label295:
    for (;;)
    {
      float f1 = 1.0F;
      if (paramFloat > f2) {
        f1 = f2 / paramFloat;
      }
      paramString2 = ImageUtil.memSafeScaleImageWithFactor(paramString1, 1, f1);
      if (paramString2 != null)
      {
        boolean bool;
        if ("png".equals(str))
        {
          bool = ImageUtil.writeBitmapToLocation(paramString2, Bitmap.CompressFormat.JPEG, 85, ((File)localObject2).getAbsolutePath());
          if (!bool) {
            break label286;
          }
        }
        for (paramString1 = ((File)localObject2).getAbsolutePath();; paramString1 = (String)localObject1)
        {
          paramString2.recycle();
          return paramString1;
          bool = ImageUtil.writeBitmapToLocation(paramString2, Bitmap.CompressFormat.JPEG, 85, ((File)localObject2).getAbsolutePath());
          break;
          return ((File)localObject2).getAbsolutePath();
        }
      }
      return localObject1;
    }
  }
  
  public static void compressNoteAttach(QMComposeNote paramQMComposeNote)
  {
    Object localObject = paramQMComposeNote.addAttachInfoList;
    if ((localObject == null) || (((List)localObject).size() == 0)) {
      return;
    }
    float f4 = paramQMComposeNote.imageScale;
    float f3 = getMaxWidthWithScale(f4);
    String str = paramQMComposeNote.composeCacheFilePath + File.separator + CommUtils.COMPOSE_CACHE + File.separator;
    localObject = ((List)localObject).iterator();
    label80:
    AttachInfo localAttachInfo;
    File localFile;
    label206:
    Bitmap localBitmap;
    boolean bool;
    while (((Iterator)localObject).hasNext())
    {
      paramQMComposeNote = ((Iterator)localObject).next();
      if ((paramQMComposeNote instanceof AttachInfo))
      {
        localAttachInfo = (AttachInfo)paramQMComposeNote;
        if (!localAttachInfo.isImage()) {
          break label366;
        }
        paramQMComposeNote = localAttachInfo.hashAttachPath() + "_compress" + (int)f4;
        localFile = new File(str + paramQMComposeNote);
        if (localFile.exists()) {
          break label381;
        }
        float f1 = ImageUtil.getImageOpts(localAttachInfo.getAttachPath()).outWidth;
        if (f1 != 0.0F) {
          break label378;
        }
        f1 = f3;
        float f2 = 1.0F;
        if (f1 > f3) {
          f2 = f3 / f1;
        }
        localBitmap = ImageUtil.memSafeScaleImageWithFactor(localAttachInfo.getAttachPath(), 1, f2);
        if (localBitmap == null) {
          break label357;
        }
        if (!"png".equals(localAttachInfo.getAttachPostFix())) {
          break label337;
        }
        bool = ImageUtil.writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 85, localFile.getAbsolutePath());
        label265:
        if (bool) {
          break label375;
        }
        paramQMComposeNote = localAttachInfo.getAttachName();
        label276:
        localBitmap.recycle();
      }
    }
    label337:
    label357:
    label366:
    label375:
    label378:
    label381:
    for (;;)
    {
      localAttachInfo.uploadDataPath = (str + paramQMComposeNote);
      QMLog.log(4, "algercompress", "path:" + localAttachInfo.uploadDataPath);
      break label80;
      break;
      bool = ImageUtil.writeBitmapToLocation(localBitmap, Bitmap.CompressFormat.JPEG, 85, localFile.getAbsolutePath());
      break label265;
      paramQMComposeNote = localAttachInfo.getAttachName();
      continue;
      paramQMComposeNote = localAttachInfo.getAttachName();
      continue;
      break label276;
      break label206;
    }
  }
  
  private static float getMaxWidthWithScale(float paramFloat)
  {
    switch ((int)paramFloat)
    {
    default: 
      return 2.147484E+009F;
    case 3: 
      return 1280.0F;
    case 2: 
      return 960.0F;
    }
    return 320.0F;
  }
  
  public static String removeProtocol(String paramString)
  {
    return StringExtention.replaceBackIllegalUrl(paramString.replaceAll("(?i)file://localhost", ""));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.note.NoteUtil
 * JD-Core Version:    0.7.0.1
 */