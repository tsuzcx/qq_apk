package com.tencent.qqmail.utilities.richeditor;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.SpannableStringBuilder;
import android.text.style.ImageSpan;
import android.util.AttributeSet;
import android.widget.EditText;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMUrlUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QMEditText
  extends EditText
{
  private static final int ID_COPY = 16908321;
  private static final int ID_CUT = 16908320;
  private static final int ID_PASTE = 16908322;
  public static final int MINI_IMAGE_SIZE = 290;
  private QMEditTextCallback callback = null;
  private int mRequestAccoutnId;
  
  public QMEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void filterEditTextAudio(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = 0;
    QMAudioSpan[] arrayOfQMAudioSpan = (QMAudioSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), QMAudioSpan.class);
    int j = arrayOfQMAudioSpan.length;
    while (i < j)
    {
      QMAudioSpan localQMAudioSpan = arrayOfQMAudioSpan[i];
      paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(localQMAudioSpan), paramSpannableStringBuilder.getSpanEnd(localQMAudioSpan), " audio:name=" + localQMAudioSpan.getName() + ",size=" + localQMAudioSpan.getSize() + ",src=" + localQMAudioSpan.getSource() + "; ");
      i += 1;
    }
  }
  
  private void filterEditTextImage(SpannableStringBuilder paramSpannableStringBuilder)
  {
    int i = 0;
    ImageSpan[] arrayOfImageSpan = (ImageSpan[])paramSpannableStringBuilder.getSpans(0, paramSpannableStringBuilder.length(), ImageSpan.class);
    int j = arrayOfImageSpan.length;
    while (i < j)
    {
      ImageSpan localImageSpan = arrayOfImageSpan[i];
      paramSpannableStringBuilder.replace(paramSpannableStringBuilder.getSpanStart(localImageSpan), paramSpannableStringBuilder.getSpanEnd(localImageSpan), " image:" + localImageSpan.getSource() + "; ");
      i += 1;
    }
  }
  
  private String getSrc(String paramString)
  {
    if (QMUrlUtil.isViewFile(paramString)) {
      return CGIManager.removeSid(paramString);
    }
    return FileUtil.filterLocalPath(paramString);
  }
  
  private String setEditTextAudio(SpannableStringBuilder paramSpannableStringBuilder)
  {
    Matcher localMatcher1 = Pattern.compile(" audio:.*?; ").matcher(paramSpannableStringBuilder);
    StringBuffer localStringBuffer = new StringBuffer();
    for (boolean bool = localMatcher1.find(); bool; bool = localMatcher1.find())
    {
      String str2 = localMatcher1.group();
      String str1 = "";
      Object localObject1 = Pattern.compile("(?<=src=).*?(?=;)").matcher(str2);
      if (((Matcher)localObject1).find()) {
        str1 = ((Matcher)localObject1).group();
      }
      localObject1 = "";
      Object localObject2 = Pattern.compile("(?<=name=).*?(?=,)").matcher(str2);
      if (((Matcher)localObject2).find()) {
        localObject1 = ((Matcher)localObject2).group();
      }
      localObject2 = "";
      Matcher localMatcher2 = Pattern.compile("(?<=size=).*?(?=,)").matcher(str2);
      if (localMatcher2.find()) {
        localObject2 = localMatcher2.group();
      }
      if ((!str1.equals("")) && (!((String)localObject1).equals("")) && (!((String)localObject2).equals("")))
      {
        int i = paramSpannableStringBuilder.toString().indexOf(str2);
        int j = str2.length();
        addAudioSpan((String)localObject1, Long.parseLong((String)localObject2), str1, i, i + j, false);
      }
      localMatcher1.appendReplacement(localStringBuffer, "audio");
    }
    localMatcher1.appendTail(localStringBuffer);
    return localStringBuffer.toString();
  }
  
  public void addAudioSpan(String paramString1, long paramLong, String paramString2, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    ((SpannableStringBuilder)getText()).setSpan(new QMAudioSpan(paramString1, paramLong, paramString2, (int)(QMUIKit.getScreenWidth() - 2.0F * getResources().getDimension(2131297032))), paramInt1, paramInt2, 33);
    if ((this.callback != null) && (!paramBoolean)) {
      this.callback.onPasteMediaFile(paramInt2 + 1, 0);
    }
  }
  
  public void addDefaultImg(String paramString, int paramInt1, int paramInt2)
  {
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)getText();
    if (paramString.equals("file:///android_asset/pic_text.png")) {}
    for (;;)
    {
      try
      {
        Drawable localDrawable1 = Drawable.createFromStream(QMApplicationContext.sharedInstance().getAssets().open("mail/pic_text.png"), null);
        localDrawable1.setBounds(0, 0, localDrawable1.getIntrinsicWidth(), localDrawable1.getIntrinsicHeight());
        localSpannableStringBuilder.setSpan(new ImageSpan(localDrawable1, paramString), paramInt1, paramInt2, 33);
        return;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
        localDrawable2 = Resources.getSystem().getDrawable(17301606);
        continue;
      }
      Drawable localDrawable2 = Resources.getSystem().getDrawable(17301606);
    }
  }
  
  public void addLocalImg(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    String str = StringExtention.replaceBackIllegalUrl(paramString);
    SpannableStringBuilder localSpannableStringBuilder = (SpannableStringBuilder)getText();
    if (str.startsWith("cid:")) {}
    Object localObject;
    for (paramString = str;; paramString = "file://localhost" + str)
    {
      localObject = Resources.getSystem().getDrawable(17301606);
      ((Drawable)localObject).setBounds(0, 0, ((Drawable)localObject).getIntrinsicWidth(), ((Drawable)localObject).getIntrinsicHeight());
      localObject = new ImageSpan((Drawable)localObject, paramString);
      localSpannableStringBuilder.setSpan(localObject, paramInt1, paramInt2, 33);
      if (!paramString.startsWith("cid:")) {
        break;
      }
      return;
    }
    WeakReference localWeakReference = new WeakReference(localSpannableStringBuilder);
    ImageDownloadManager.shareInstance().getImageBitmap(str, new QMEditText.1(this, localSpannableStringBuilder, localWeakReference, paramString, (ImageSpan)localObject, paramBoolean));
  }
  
  public void addProtocolInlineImg(String paramString, int paramInt1, int paramInt2)
  {
    paramString = StringExtention.replaceBackIllegalUrl(paramString);
    if (paramString.startsWith("cid:")) {
      addDefaultImg(paramString, paramInt1, paramInt2);
    }
  }
  
  public void addWebImg(String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    addWebImgWithRequestAccountId(0, paramString, paramInt1, paramInt2, paramBoolean);
  }
  
  public void addWebImgWithRequestAccountId(int paramInt1, String paramString, int paramInt2, int paramInt3, boolean paramBoolean)
  {
    Object localObject2 = (SpannableStringBuilder)getText();
    Object localObject1 = Resources.getSystem().getDrawable(17301606);
    ((Drawable)localObject1).setBounds(0, 0, ((Drawable)localObject1).getIntrinsicWidth(), ((Drawable)localObject1).getIntrinsicHeight());
    localObject1 = new ImageSpan((Drawable)localObject1, paramString);
    ((SpannableStringBuilder)localObject2).setSpan(localObject1, paramInt2, paramInt3, 33);
    localObject2 = new WeakReference(localObject2);
    DownloadInfo localDownloadInfo = new DownloadInfo();
    localDownloadInfo.setAccountId(paramInt1);
    localDownloadInfo.setUrl(getSrc(paramString));
    localDownloadInfo.setImageDownloadListener(new QMEditText.2(this, (WeakReference)localObject2, (ImageSpan)localObject1, paramString, paramBoolean, paramInt3));
    ImageDownloadManager.shareInstance().fetchImage(localDownloadInfo);
  }
  
  public QMEditTextCallback getCallback()
  {
    return this.callback;
  }
  
  public int getRequestAccountId()
  {
    return this.mRequestAccoutnId;
  }
  
  public void setCallback(QMEditTextCallback paramQMEditTextCallback)
  {
    this.callback = paramQMEditTextCallback;
  }
  
  public void setRequestAccountId(int paramInt)
  {
    this.mRequestAccoutnId = paramInt;
  }
  
  public static abstract interface QMEditTextCallback
  {
    public abstract void onPasteMediaFile(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditText
 * JD-Core Version:    0.7.0.1
 */