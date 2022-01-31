package android.support.v4.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import java.util.ArrayList;

public class ShareCompat$IntentReader
{
  private static final String TAG = "IntentReader";
  private Activity mActivity;
  private ComponentName mCallingActivity;
  private String mCallingPackage;
  private Intent mIntent;
  private ArrayList mStreams;
  
  private ShareCompat$IntentReader(Activity paramActivity)
  {
    this.mActivity = paramActivity;
    this.mIntent = paramActivity.getIntent();
    this.mCallingPackage = ShareCompat.getCallingPackage(paramActivity);
    this.mCallingActivity = ShareCompat.getCallingActivity(paramActivity);
  }
  
  public static IntentReader from(Activity paramActivity)
  {
    return new IntentReader(paramActivity);
  }
  
  private static void withinStyle(StringBuilder paramStringBuilder, CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (paramInt1 < paramInt2)
    {
      char c = paramCharSequence.charAt(paramInt1);
      if (c == '<') {
        paramStringBuilder.append("&lt;");
      }
      for (;;)
      {
        paramInt1 += 1;
        break;
        if (c == '>')
        {
          paramStringBuilder.append("&gt;");
        }
        else if (c == '&')
        {
          paramStringBuilder.append("&amp;");
        }
        else if ((c > '~') || (c < ' '))
        {
          paramStringBuilder.append("&#" + c + ";");
        }
        else if (c == ' ')
        {
          while ((paramInt1 + 1 < paramInt2) && (paramCharSequence.charAt(paramInt1 + 1) == ' '))
          {
            paramStringBuilder.append("&nbsp;");
            paramInt1 += 1;
          }
          paramStringBuilder.append(' ');
        }
        else
        {
          paramStringBuilder.append(c);
        }
      }
    }
  }
  
  public ComponentName getCallingActivity()
  {
    return this.mCallingActivity;
  }
  
  public Drawable getCallingActivityIcon()
  {
    if (this.mCallingActivity == null) {
      return null;
    }
    Object localObject = this.mActivity.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getActivityIcon(this.mCallingActivity);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve icon for calling activity", localNameNotFoundException);
    }
    return null;
  }
  
  public Drawable getCallingApplicationIcon()
  {
    if (this.mCallingPackage == null) {
      return null;
    }
    Object localObject = this.mActivity.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationIcon(this.mCallingPackage);
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve icon for calling application", localNameNotFoundException);
    }
    return null;
  }
  
  public CharSequence getCallingApplicationLabel()
  {
    if (this.mCallingPackage == null) {
      return null;
    }
    Object localObject = this.mActivity.getPackageManager();
    try
    {
      localObject = ((PackageManager)localObject).getApplicationLabel(((PackageManager)localObject).getApplicationInfo(this.mCallingPackage, 0));
      return localObject;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      Log.e("IntentReader", "Could not retrieve label for calling application", localNameNotFoundException);
    }
    return null;
  }
  
  public String getCallingPackage()
  {
    return this.mCallingPackage;
  }
  
  public String[] getEmailBcc()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.BCC");
  }
  
  public String[] getEmailCc()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.CC");
  }
  
  public String[] getEmailTo()
  {
    return this.mIntent.getStringArrayExtra("android.intent.extra.EMAIL");
  }
  
  public String getHtmlText()
  {
    Object localObject = this.mIntent.getStringExtra("android.intent.extra.HTML_TEXT");
    if (localObject == null)
    {
      CharSequence localCharSequence = getText();
      if ((localCharSequence instanceof Spanned)) {
        return Html.toHtml((Spanned)localCharSequence);
      }
      if (localCharSequence != null)
      {
        if (Build.VERSION.SDK_INT >= 16) {
          return Html.escapeHtml(localCharSequence);
        }
        localObject = new StringBuilder();
        withinStyle((StringBuilder)localObject, localCharSequence, 0, localCharSequence.length());
        return ((StringBuilder)localObject).toString();
      }
    }
    return localObject;
  }
  
  public Uri getStream()
  {
    return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
  }
  
  public Uri getStream(int paramInt)
  {
    if ((this.mStreams == null) && (isMultipleShare())) {
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }
    if (this.mStreams != null) {
      return (Uri)this.mStreams.get(paramInt);
    }
    if (paramInt == 0) {
      return (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
    }
    throw new IndexOutOfBoundsException("Stream items available: " + getStreamCount() + " index requested: " + paramInt);
  }
  
  public int getStreamCount()
  {
    if ((this.mStreams == null) && (isMultipleShare())) {
      this.mStreams = this.mIntent.getParcelableArrayListExtra("android.intent.extra.STREAM");
    }
    if (this.mStreams != null) {
      return this.mStreams.size();
    }
    if (this.mIntent.hasExtra("android.intent.extra.STREAM")) {
      return 1;
    }
    return 0;
  }
  
  public String getSubject()
  {
    return this.mIntent.getStringExtra("android.intent.extra.SUBJECT");
  }
  
  public CharSequence getText()
  {
    return this.mIntent.getCharSequenceExtra("android.intent.extra.TEXT");
  }
  
  public String getType()
  {
    return this.mIntent.getType();
  }
  
  public boolean isMultipleShare()
  {
    return "android.intent.action.SEND_MULTIPLE".equals(this.mIntent.getAction());
  }
  
  public boolean isShareIntent()
  {
    String str = this.mIntent.getAction();
    return ("android.intent.action.SEND".equals(str)) || ("android.intent.action.SEND_MULTIPLE".equals(str));
  }
  
  public boolean isSingleShare()
  {
    return "android.intent.action.SEND".equals(this.mIntent.getAction());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ShareCompat.IntentReader
 * JD-Core Version:    0.7.0.1
 */