package com.tencent.qqmail.activity.compose;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.app.ActivityCompat;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.utilities.bitmap.BitmapUtil;
import com.tencent.qqmail.utilities.ui.QMUIKit;

public class AudioUtils
{
  public static final String AUDIO_TAG_TEMPLATE = "<audio src=\"$src\" qmtitle=\"$qmtitle\" qmsize=\"$qmsize\" class=\"ios-upload-audio\" controls=\"true\" preload=\"metadata\" qmduration=\"0\"></audio>";
  public static final String IMG_TAG_TEMPLATE = "<img audiostart=\"true\" qmpath=\"$qmpath\" src=\"data:image/jpeg;base64,$base64\" qmtitle=\"$qmtitle\" qmsize=\"$qmsize\" width=\"$width\" height=\"$height\" audioend=\"true\">";
  public static final String TAG = "AudioUtils";
  public static Bitmap leftAudioPart;
  public static Bitmap midAudioPart;
  public static Bitmap rightAudioPart;
  
  public static Bitmap drawAudioBitmap(Context paramContext, String paramString1, String paramString2, String paramString3)
  {
    paramString3 = new Paint();
    paramString3.setColor(-16777216);
    paramString3.setTextSize(48.0F);
    Paint localPaint = new Paint();
    localPaint.setColor(-7829368);
    localPaint.setStyle(Paint.Style.FILL);
    int j = QMUIKit.getScreenWidth();
    int i = QMUIKit.dpToPx(64);
    int k = QMUIKit.dpToPx(20);
    Bitmap localBitmap = Bitmap.createBitmap(j, i, Bitmap.Config.RGB_565);
    Canvas localCanvas = new Canvas(localBitmap);
    localCanvas.drawColor(ActivityCompat.getColor(paramContext, 2131167654));
    initAudioBitmaps(paramContext);
    paramContext = new Rect();
    Rect localRect = new Rect();
    int m = QMUIKit.dpToPx(16);
    paramContext.left = 0;
    paramContext.top = 0;
    paramContext.right = leftAudioPart.getWidth();
    paramContext.bottom = leftAudioPart.getHeight();
    localRect.left = 0;
    localRect.top = 0;
    localRect.right = m;
    localRect.bottom = i;
    localCanvas.drawBitmap(leftAudioPart, paramContext, localRect, null);
    paramContext.left = 0;
    paramContext.top = 0;
    paramContext.right = midAudioPart.getWidth();
    paramContext.bottom = midAudioPart.getHeight();
    localRect.left = m;
    localRect.top = 0;
    localRect.right = (j - m);
    localRect.bottom = i;
    localCanvas.drawBitmap(midAudioPart, paramContext, localRect, null);
    paramContext.left = 0;
    paramContext.top = 0;
    paramContext.right = rightAudioPart.getWidth();
    paramContext.bottom = rightAudioPart.getHeight();
    localRect.left = (j - m);
    localRect.top = 0;
    localRect.right = j;
    localRect.bottom = i;
    localCanvas.drawBitmap(rightAudioPart, paramContext, localRect, null);
    paramContext = new Path();
    paramContext.reset();
    paramContext.moveTo(k, k);
    float f1 = k + 1.73F * (i / 2.0F - k);
    paramContext.lineTo(f1, i / 2.0F);
    paramContext.lineTo(k, i - k);
    paramContext.close();
    localCanvas.drawPath(paramContext, localPaint);
    j = QMUIKit.dpToPx(16);
    paramString3.setTypeface(Typeface.create(Typeface.DEFAULT, 1));
    localCanvas.drawText(paramString1, j + f1, i / 2, paramString3);
    paramContext = new Rect();
    paramString3.getTextBounds(paramString2, 0, paramString2.length(), paramContext);
    paramString3.setTextSize(36.0F);
    paramString3.setColor(-7829368);
    paramString3.setTypeface(Typeface.create(Typeface.DEFAULT, 0));
    float f2 = j;
    i /= 2;
    localCanvas.drawText(paramString2, f2 + f1, paramContext.height() + (i + 10), paramString3);
    return localBitmap;
  }
  
  public static String filterAudioToImg(String paramString)
  {
    int j = paramString.indexOf("<audio");
    for (int i = paramString.indexOf("</audio>") + "</audio>".length(); (j >= 0) && (i >= 0); i = paramString.indexOf("</audio>") + "</audio>".length())
    {
      String str1 = paramString.substring(j, i);
      String str2 = getAttributeValue(str1, "qmtitle");
      String str3 = getAttributeValue(str1, "src");
      paramString = replaceStringPart(paramString, generateImgHtml(str2, getAttributeValue(str1, "qmsize"), str3), j, i);
      j = paramString.indexOf("<audio");
    }
    return paramString;
  }
  
  public static String filterImgToAudio(String paramString)
  {
    String str1;
    if (TextUtils.isEmpty(paramString))
    {
      str1 = "";
      return str1;
    }
    int i = paramString.indexOf("<img audiostart=\"true\"");
    int j = paramString.indexOf("audioend=\"true\">");
    int k = "audioend=\"true\">".length();
    j += k;
    for (;;)
    {
      str1 = paramString;
      if (i < 0) {
        break;
      }
      str1 = paramString;
      if (i >= j) {
        break;
      }
      str1 = paramString.substring(i, j);
      String str2 = getAttributeValue(str1, "qmtitle");
      String str3 = getAttributeValue(str1, "qmpath");
      paramString = replaceStringPart(paramString, generateAudioHtml(str2, getAttributeValue(str1, "qmsize"), str3), i, j);
      i = paramString.indexOf("<img audiostart=\"true\"");
      j = paramString.indexOf("audioend=\"true\">");
      k = "audioend=\"true\">".length();
      j += k;
    }
  }
  
  public static String generateAudioHtml(String paramString1, String paramString2, String paramString3)
  {
    return "<audio src=\"$src\" qmtitle=\"$qmtitle\" qmsize=\"$qmsize\" class=\"ios-upload-audio\" controls=\"true\" preload=\"metadata\" qmduration=\"0\"></audio>".replace("$qmtitle", paramString1).replace("$src", paramString3).replace("$qmsize", paramString2);
  }
  
  public static String generateImgHtml(String paramString1, String paramString2, String paramString3)
  {
    int i = QMUIKit.getScreenWidth();
    int j = QMUIKit.dpToPx(64);
    String str = Base64.encodeToString(BitmapUtil.bmpToBytes(drawAudioBitmap(QMApplicationContext.sharedInstance(), paramString1, paramString2, paramString3), Bitmap.CompressFormat.JPEG, 100), 0);
    return "<img audiostart=\"true\" qmpath=\"$qmpath\" src=\"data:image/jpeg;base64,$base64\" qmtitle=\"$qmtitle\" qmsize=\"$qmsize\" width=\"$width\" height=\"$height\" audioend=\"true\">".replace("$qmtitle", paramString1).replace("$base64", str).replace("$width", i + "").replace("$height", j + "").replace("$qmpath", paramString3).replace("$qmsize", paramString2);
  }
  
  private static String getAttributeValue(String paramString1, String paramString2)
  {
    int i = paramString1.indexOf(paramString2 + "=\"");
    if (i < 0) {}
    int j;
    do
    {
      return "";
      i = paramString1.indexOf("\"", i);
      j = paramString1.indexOf("\"", i + 1);
    } while (i >= j - 1);
    return paramString1.substring(i + 1, j);
  }
  
  private static void initAudioBitmaps(Context paramContext)
  {
    if (leftAudioPart == null) {
      leftAudioPart = BitmapFactory.decodeResource(paramContext.getResources(), 2130842229);
    }
    if (midAudioPart == null) {
      midAudioPart = BitmapFactory.decodeResource(paramContext.getResources(), 2130842227);
    }
    if (rightAudioPart == null) {
      rightAudioPart = BitmapFactory.decodeResource(paramContext.getResources(), 2130842231);
    }
  }
  
  private static String replaceStringPart(String paramString1, String paramString2, int paramInt1, int paramInt2)
  {
    return paramString1.replace(paramString1.substring(paramInt1, paramInt2), paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.AudioUtils
 * JD-Core Version:    0.7.0.1
 */