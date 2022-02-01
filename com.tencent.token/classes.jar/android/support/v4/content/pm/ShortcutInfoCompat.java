package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.annotation.VisibleForTesting;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;
import java.util.Arrays;

public class ShortcutInfoCompat
{
  private ComponentName mActivity;
  private Context mContext;
  private CharSequence mDisabledMessage;
  private IconCompat mIcon;
  private String mId;
  private Intent[] mIntents;
  private boolean mIsAlwaysBadged;
  private CharSequence mLabel;
  private CharSequence mLongLabel;
  
  @VisibleForTesting
  Intent addToIntent(Intent paramIntent)
  {
    paramIntent.putExtra("android.intent.extra.shortcut.INTENT", this.mIntents[(this.mIntents.length - 1)]).putExtra("android.intent.extra.shortcut.NAME", this.mLabel.toString());
    Object localObject3;
    Object localObject4;
    PackageManager localPackageManager;
    Object localObject1;
    if (this.mIcon != null)
    {
      localObject3 = null;
      localObject4 = null;
      if (this.mIsAlwaysBadged)
      {
        localPackageManager = this.mContext.getPackageManager();
        localObject1 = localObject4;
        if (this.mActivity == null) {}
      }
    }
    try
    {
      localObject1 = localPackageManager.getActivityIcon(this.mActivity);
      localObject3 = localObject1;
      if (localObject1 == null) {
        localObject3 = this.mContext.getApplicationInfo().loadIcon(localPackageManager);
      }
      this.mIcon.addToShortcutIntent(paramIntent, (Drawable)localObject3);
      return paramIntent;
    }
    catch (PackageManager.NameNotFoundException localNameNotFoundException)
    {
      for (;;)
      {
        Object localObject2 = localObject4;
      }
    }
  }
  
  @Nullable
  public ComponentName getActivity()
  {
    return this.mActivity;
  }
  
  @Nullable
  public CharSequence getDisabledMessage()
  {
    return this.mDisabledMessage;
  }
  
  @NonNull
  public String getId()
  {
    return this.mId;
  }
  
  @NonNull
  public Intent getIntent()
  {
    return this.mIntents[(this.mIntents.length - 1)];
  }
  
  @NonNull
  public Intent[] getIntents()
  {
    return (Intent[])Arrays.copyOf(this.mIntents, this.mIntents.length);
  }
  
  @Nullable
  public CharSequence getLongLabel()
  {
    return this.mLongLabel;
  }
  
  @NonNull
  public CharSequence getShortLabel()
  {
    return this.mLabel;
  }
  
  @RequiresApi(25)
  public ShortcutInfo toShortcutInfo()
  {
    ShortcutInfo.Builder localBuilder = new ShortcutInfo.Builder(this.mContext, this.mId).setShortLabel(this.mLabel).setIntents(this.mIntents);
    if (this.mIcon != null) {
      localBuilder.setIcon(this.mIcon.toIcon());
    }
    if (!TextUtils.isEmpty(this.mLongLabel)) {
      localBuilder.setLongLabel(this.mLongLabel);
    }
    if (!TextUtils.isEmpty(this.mDisabledMessage)) {
      localBuilder.setDisabledMessage(this.mDisabledMessage);
    }
    if (this.mActivity != null) {
      localBuilder.setActivity(this.mActivity);
    }
    return localBuilder.build();
  }
  
  public static class Builder
  {
    private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat(null);
    
    public Builder(@NonNull Context paramContext, @NonNull String paramString)
    {
      ShortcutInfoCompat.access$102(this.mInfo, paramContext);
      ShortcutInfoCompat.access$202(this.mInfo, paramString);
    }
    
    @NonNull
    public ShortcutInfoCompat build()
    {
      if (TextUtils.isEmpty(this.mInfo.mLabel)) {
        throw new IllegalArgumentException("Shortcut much have a non-empty label");
      }
      if ((this.mInfo.mIntents == null) || (this.mInfo.mIntents.length == 0)) {
        throw new IllegalArgumentException("Shortcut much have an intent");
      }
      return this.mInfo;
    }
    
    @NonNull
    public Builder setActivity(@NonNull ComponentName paramComponentName)
    {
      ShortcutInfoCompat.access$802(this.mInfo, paramComponentName);
      return this;
    }
    
    public Builder setAlwaysBadged()
    {
      ShortcutInfoCompat.access$902(this.mInfo, true);
      return this;
    }
    
    @NonNull
    public Builder setDisabledMessage(@NonNull CharSequence paramCharSequence)
    {
      ShortcutInfoCompat.access$502(this.mInfo, paramCharSequence);
      return this;
    }
    
    @NonNull
    public Builder setIcon(IconCompat paramIconCompat)
    {
      ShortcutInfoCompat.access$702(this.mInfo, paramIconCompat);
      return this;
    }
    
    @NonNull
    public Builder setIntent(@NonNull Intent paramIntent)
    {
      return setIntents(new Intent[] { paramIntent });
    }
    
    @NonNull
    public Builder setIntents(@NonNull Intent[] paramArrayOfIntent)
    {
      ShortcutInfoCompat.access$602(this.mInfo, paramArrayOfIntent);
      return this;
    }
    
    @NonNull
    public Builder setLongLabel(@NonNull CharSequence paramCharSequence)
    {
      ShortcutInfoCompat.access$402(this.mInfo, paramCharSequence);
      return this;
    }
    
    @NonNull
    public Builder setShortLabel(@NonNull CharSequence paramCharSequence)
    {
      ShortcutInfoCompat.access$302(this.mInfo, paramCharSequence);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.pm.ShortcutInfoCompat
 * JD-Core Version:    0.7.0.1
 */