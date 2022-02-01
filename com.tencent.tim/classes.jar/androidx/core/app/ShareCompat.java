package androidx.core.app;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;
import android.util.Log;
import android.view.ActionProvider;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ShareActionProvider;
import androidx.annotation.StringRes;
import java.util.ArrayList;

public final class ShareCompat
{
  public static final String EXTRA_CALLING_ACTIVITY = "androidx.core.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_ACTIVITY_INTEROP = "android.support.v4.app.EXTRA_CALLING_ACTIVITY";
  public static final String EXTRA_CALLING_PACKAGE = "androidx.core.app.EXTRA_CALLING_PACKAGE";
  public static final String EXTRA_CALLING_PACKAGE_INTEROP = "android.support.v4.app.EXTRA_CALLING_PACKAGE";
  private static final String HISTORY_FILENAME_PREFIX = ".sharecompat_";
  
  public static void configureMenuItem(Menu paramMenu, int paramInt, IntentBuilder paramIntentBuilder)
  {
    paramMenu = paramMenu.findItem(paramInt);
    if (paramMenu == null) {
      throw new IllegalArgumentException("Could not find menu item with id " + paramInt + " in the supplied menu");
    }
    configureMenuItem(paramMenu, paramIntentBuilder);
  }
  
  public static void configureMenuItem(MenuItem paramMenuItem, IntentBuilder paramIntentBuilder)
  {
    Object localObject = paramMenuItem.getActionProvider();
    if (!(localObject instanceof ShareActionProvider)) {}
    for (localObject = new ShareActionProvider(paramIntentBuilder.getActivity());; localObject = (ShareActionProvider)localObject)
    {
      ((ShareActionProvider)localObject).setShareHistoryFileName(".sharecompat_" + paramIntentBuilder.getActivity().getClass().getName());
      ((ShareActionProvider)localObject).setShareIntent(paramIntentBuilder.getIntent());
      paramMenuItem.setActionProvider((ActionProvider)localObject);
      if ((Build.VERSION.SDK_INT < 16) && (!paramMenuItem.hasSubMenu())) {
        paramMenuItem.setIntent(paramIntentBuilder.createChooserIntent());
      }
      return;
    }
  }
  
  public static ComponentName getCallingActivity(Activity paramActivity)
  {
    ComponentName localComponentName2 = paramActivity.getCallingActivity();
    ComponentName localComponentName1 = localComponentName2;
    if (localComponentName2 == null)
    {
      localComponentName2 = (ComponentName)paramActivity.getIntent().getParcelableExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY");
      localComponentName1 = localComponentName2;
      if (localComponentName2 == null) {
        localComponentName1 = (ComponentName)paramActivity.getIntent().getParcelableExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY");
      }
    }
    return localComponentName1;
  }
  
  public static String getCallingPackage(Activity paramActivity)
  {
    String str2 = paramActivity.getCallingPackage();
    String str1 = str2;
    if (str2 == null)
    {
      str2 = paramActivity.getIntent().getStringExtra("androidx.core.app.EXTRA_CALLING_PACKAGE");
      str1 = str2;
      if (str2 == null) {
        str1 = paramActivity.getIntent().getStringExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE");
      }
    }
    return str1;
  }
  
  public static class IntentBuilder
  {
    private Activity mActivity;
    private ArrayList<String> mBccAddresses;
    private ArrayList<String> mCcAddresses;
    private CharSequence mChooserTitle;
    private Intent mIntent;
    private ArrayList<Uri> mStreams;
    private ArrayList<String> mToAddresses;
    
    private IntentBuilder(Activity paramActivity)
    {
      this.mActivity = paramActivity;
      this.mIntent = new Intent().setAction("android.intent.action.SEND");
      this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_PACKAGE", paramActivity.getPackageName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_PACKAGE", paramActivity.getPackageName());
      this.mIntent.putExtra("androidx.core.app.EXTRA_CALLING_ACTIVITY", paramActivity.getComponentName());
      this.mIntent.putExtra("android.support.v4.app.EXTRA_CALLING_ACTIVITY", paramActivity.getComponentName());
      this.mIntent.addFlags(524288);
    }
    
    private void combineArrayExtra(String paramString, ArrayList<String> paramArrayList)
    {
      String[] arrayOfString1 = this.mIntent.getStringArrayExtra(paramString);
      if (arrayOfString1 != null) {}
      for (int i = arrayOfString1.length;; i = 0)
      {
        String[] arrayOfString2 = new String[paramArrayList.size() + i];
        paramArrayList.toArray(arrayOfString2);
        if (arrayOfString1 != null) {
          System.arraycopy(arrayOfString1, 0, arrayOfString2, paramArrayList.size(), i);
        }
        this.mIntent.putExtra(paramString, arrayOfString2);
        return;
      }
    }
    
    private void combineArrayExtra(String paramString, String[] paramArrayOfString)
    {
      Intent localIntent = getIntent();
      String[] arrayOfString1 = localIntent.getStringArrayExtra(paramString);
      if (arrayOfString1 != null) {}
      for (int i = arrayOfString1.length;; i = 0)
      {
        String[] arrayOfString2 = new String[paramArrayOfString.length + i];
        if (arrayOfString1 != null) {
          System.arraycopy(arrayOfString1, 0, arrayOfString2, 0, i);
        }
        System.arraycopy(paramArrayOfString, 0, arrayOfString2, i, paramArrayOfString.length);
        localIntent.putExtra(paramString, arrayOfString2);
        return;
      }
    }
    
    public static IntentBuilder from(Activity paramActivity)
    {
      return new IntentBuilder(paramActivity);
    }
    
    public IntentBuilder addEmailBcc(String paramString)
    {
      if (this.mBccAddresses == null) {
        this.mBccAddresses = new ArrayList();
      }
      this.mBccAddresses.add(paramString);
      return this;
    }
    
    public IntentBuilder addEmailBcc(String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.BCC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder addEmailCc(String paramString)
    {
      if (this.mCcAddresses == null) {
        this.mCcAddresses = new ArrayList();
      }
      this.mCcAddresses.add(paramString);
      return this;
    }
    
    public IntentBuilder addEmailCc(String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.CC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder addEmailTo(String paramString)
    {
      if (this.mToAddresses == null) {
        this.mToAddresses = new ArrayList();
      }
      this.mToAddresses.add(paramString);
      return this;
    }
    
    public IntentBuilder addEmailTo(String[] paramArrayOfString)
    {
      combineArrayExtra("android.intent.extra.EMAIL", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder addStream(Uri paramUri)
    {
      Uri localUri = (Uri)this.mIntent.getParcelableExtra("android.intent.extra.STREAM");
      if ((this.mStreams == null) && (localUri == null)) {
        return setStream(paramUri);
      }
      if (this.mStreams == null) {
        this.mStreams = new ArrayList();
      }
      if (localUri != null)
      {
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        this.mStreams.add(localUri);
      }
      this.mStreams.add(paramUri);
      return this;
    }
    
    public Intent createChooserIntent()
    {
      return Intent.createChooser(getIntent(), this.mChooserTitle);
    }
    
    Activity getActivity()
    {
      return this.mActivity;
    }
    
    public Intent getIntent()
    {
      if (this.mToAddresses != null)
      {
        combineArrayExtra("android.intent.extra.EMAIL", this.mToAddresses);
        this.mToAddresses = null;
      }
      if (this.mCcAddresses != null)
      {
        combineArrayExtra("android.intent.extra.CC", this.mCcAddresses);
        this.mCcAddresses = null;
      }
      if (this.mBccAddresses != null)
      {
        combineArrayExtra("android.intent.extra.BCC", this.mBccAddresses);
        this.mBccAddresses = null;
      }
      int i;
      if ((this.mStreams != null) && (this.mStreams.size() > 1))
      {
        i = 1;
        boolean bool = this.mIntent.getAction().equals("android.intent.action.SEND_MULTIPLE");
        if ((i == 0) && (bool))
        {
          this.mIntent.setAction("android.intent.action.SEND");
          if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
            break label219;
          }
          this.mIntent.putExtra("android.intent.extra.STREAM", (Parcelable)this.mStreams.get(0));
          label155:
          this.mStreams = null;
        }
        if ((i != 0) && (!bool))
        {
          this.mIntent.setAction("android.intent.action.SEND_MULTIPLE");
          if ((this.mStreams == null) || (this.mStreams.isEmpty())) {
            break label231;
          }
          this.mIntent.putParcelableArrayListExtra("android.intent.extra.STREAM", this.mStreams);
        }
      }
      for (;;)
      {
        return this.mIntent;
        i = 0;
        break;
        label219:
        this.mIntent.removeExtra("android.intent.extra.STREAM");
        break label155;
        label231:
        this.mIntent.removeExtra("android.intent.extra.STREAM");
      }
    }
    
    public IntentBuilder setChooserTitle(@StringRes int paramInt)
    {
      return setChooserTitle(this.mActivity.getText(paramInt));
    }
    
    public IntentBuilder setChooserTitle(CharSequence paramCharSequence)
    {
      this.mChooserTitle = paramCharSequence;
      return this;
    }
    
    public IntentBuilder setEmailBcc(String[] paramArrayOfString)
    {
      this.mIntent.putExtra("android.intent.extra.BCC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder setEmailCc(String[] paramArrayOfString)
    {
      this.mIntent.putExtra("android.intent.extra.CC", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder setEmailTo(String[] paramArrayOfString)
    {
      if (this.mToAddresses != null) {
        this.mToAddresses = null;
      }
      this.mIntent.putExtra("android.intent.extra.EMAIL", paramArrayOfString);
      return this;
    }
    
    public IntentBuilder setHtmlText(String paramString)
    {
      this.mIntent.putExtra("android.intent.extra.HTML_TEXT", paramString);
      if (!this.mIntent.hasExtra("android.intent.extra.TEXT")) {
        setText(Html.fromHtml(paramString));
      }
      return this;
    }
    
    public IntentBuilder setStream(Uri paramUri)
    {
      if (!this.mIntent.getAction().equals("android.intent.action.SEND")) {
        this.mIntent.setAction("android.intent.action.SEND");
      }
      this.mStreams = null;
      this.mIntent.putExtra("android.intent.extra.STREAM", paramUri);
      return this;
    }
    
    public IntentBuilder setSubject(String paramString)
    {
      this.mIntent.putExtra("android.intent.extra.SUBJECT", paramString);
      return this;
    }
    
    public IntentBuilder setText(CharSequence paramCharSequence)
    {
      this.mIntent.putExtra("android.intent.extra.TEXT", paramCharSequence);
      return this;
    }
    
    public IntentBuilder setType(String paramString)
    {
      this.mIntent.setType(paramString);
      return this;
    }
    
    public void startChooser()
    {
      this.mActivity.startActivity(createChooserIntent());
    }
  }
  
  public static class IntentReader
  {
    private static final String TAG = "IntentReader";
    private Activity mActivity;
    private ComponentName mCallingActivity;
    private String mCallingPackage;
    private Intent mIntent;
    private ArrayList<Uri> mStreams;
    
    private IntentReader(Activity paramActivity)
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.app.ShareCompat
 * JD-Core Version:    0.7.0.1
 */