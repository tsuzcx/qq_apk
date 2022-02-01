package androidx.core.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutInfo.Builder;
import android.graphics.drawable.Drawable;
import android.os.PersistableBundle;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.core.app.Person;
import androidx.core.graphics.drawable.IconCompat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ShortcutInfoCompat
{
  private static final String EXTRA_LONG_LIVED = "extraLongLived";
  private static final String EXTRA_PERSON_ = "extraPerson_";
  private static final String EXTRA_PERSON_COUNT = "extraPersonCount";
  ComponentName mActivity;
  Set<String> mCategories;
  Context mContext;
  CharSequence mDisabledMessage;
  IconCompat mIcon;
  String mId;
  Intent[] mIntents;
  boolean mIsAlwaysBadged;
  boolean mIsLongLived;
  CharSequence mLabel;
  CharSequence mLongLabel;
  Person[] mPersons;
  
  @RequiresApi(22)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  private PersistableBundle buildExtrasBundle()
  {
    PersistableBundle localPersistableBundle = new PersistableBundle();
    if ((this.mPersons != null) && (this.mPersons.length > 0))
    {
      localPersistableBundle.putInt("extraPersonCount", this.mPersons.length);
      int i = 0;
      while (i < this.mPersons.length)
      {
        localPersistableBundle.putPersistableBundle("extraPerson_" + (i + 1), this.mPersons[i].toPersistableBundle());
        i += 1;
      }
    }
    localPersistableBundle.putBoolean("extraLongLived", this.mIsLongLived);
    return localPersistableBundle;
  }
  
  @Nullable
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static boolean getLongLivedFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    if ((paramPersistableBundle == null) || (!paramPersistableBundle.containsKey("extraLongLived"))) {
      return false;
    }
    return paramPersistableBundle.getBoolean("extraLongLived");
  }
  
  @Nullable
  @RequiresApi(25)
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  @VisibleForTesting
  static Person[] getPersonsFromExtra(@NonNull PersistableBundle paramPersistableBundle)
  {
    Object localObject;
    if ((paramPersistableBundle == null) || (!paramPersistableBundle.containsKey("extraPersonCount")))
    {
      localObject = null;
      return localObject;
    }
    int j = paramPersistableBundle.getInt("extraPersonCount");
    Person[] arrayOfPerson = new Person[j];
    int i = 0;
    for (;;)
    {
      localObject = arrayOfPerson;
      if (i >= j) {
        break;
      }
      arrayOfPerson[i] = Person.fromPersistableBundle(paramPersistableBundle.getPersistableBundle("extraPerson_" + (i + 1)));
      i += 1;
    }
  }
  
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
      this.mIcon.addToShortcutIntent(paramIntent, (Drawable)localObject3, this.mContext);
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
  public Set<String> getCategories()
  {
    return this.mCategories;
  }
  
  @Nullable
  public CharSequence getDisabledMessage()
  {
    return this.mDisabledMessage;
  }
  
  @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
  public IconCompat getIcon()
  {
    return this.mIcon;
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
    if (this.mCategories != null) {
      localBuilder.setCategories(this.mCategories);
    }
    localBuilder.setExtras(buildExtrasBundle());
    return localBuilder.build();
  }
  
  public static class Builder
  {
    private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat();
    
    @RequiresApi(25)
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Builder(@NonNull Context paramContext, @NonNull ShortcutInfo paramShortcutInfo)
    {
      this.mInfo.mContext = paramContext;
      this.mInfo.mId = paramShortcutInfo.getId();
      paramContext = paramShortcutInfo.getIntents();
      this.mInfo.mIntents = ((Intent[])Arrays.copyOf(paramContext, paramContext.length));
      this.mInfo.mActivity = paramShortcutInfo.getActivity();
      this.mInfo.mLabel = paramShortcutInfo.getShortLabel();
      this.mInfo.mLongLabel = paramShortcutInfo.getLongLabel();
      this.mInfo.mDisabledMessage = paramShortcutInfo.getDisabledMessage();
      this.mInfo.mCategories = paramShortcutInfo.getCategories();
      this.mInfo.mPersons = ShortcutInfoCompat.getPersonsFromExtra(paramShortcutInfo.getExtras());
    }
    
    public Builder(@NonNull Context paramContext, @NonNull String paramString)
    {
      this.mInfo.mContext = paramContext;
      this.mInfo.mId = paramString;
    }
    
    @RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public Builder(@NonNull ShortcutInfoCompat paramShortcutInfoCompat)
    {
      this.mInfo.mContext = paramShortcutInfoCompat.mContext;
      this.mInfo.mId = paramShortcutInfoCompat.mId;
      this.mInfo.mIntents = ((Intent[])Arrays.copyOf(paramShortcutInfoCompat.mIntents, paramShortcutInfoCompat.mIntents.length));
      this.mInfo.mActivity = paramShortcutInfoCompat.mActivity;
      this.mInfo.mLabel = paramShortcutInfoCompat.mLabel;
      this.mInfo.mLongLabel = paramShortcutInfoCompat.mLongLabel;
      this.mInfo.mDisabledMessage = paramShortcutInfoCompat.mDisabledMessage;
      this.mInfo.mIcon = paramShortcutInfoCompat.mIcon;
      this.mInfo.mIsAlwaysBadged = paramShortcutInfoCompat.mIsAlwaysBadged;
      this.mInfo.mIsLongLived = paramShortcutInfoCompat.mIsLongLived;
      if (paramShortcutInfoCompat.mPersons != null) {
        this.mInfo.mPersons = ((Person[])Arrays.copyOf(paramShortcutInfoCompat.mPersons, paramShortcutInfoCompat.mPersons.length));
      }
      if (paramShortcutInfoCompat.mCategories != null) {
        this.mInfo.mCategories = new HashSet(paramShortcutInfoCompat.mCategories);
      }
    }
    
    @NonNull
    public ShortcutInfoCompat build()
    {
      if (TextUtils.isEmpty(this.mInfo.mLabel)) {
        throw new IllegalArgumentException("Shortcut must have a non-empty label");
      }
      if ((this.mInfo.mIntents == null) || (this.mInfo.mIntents.length == 0)) {
        throw new IllegalArgumentException("Shortcut must have an intent");
      }
      return this.mInfo;
    }
    
    @NonNull
    public Builder setActivity(@NonNull ComponentName paramComponentName)
    {
      this.mInfo.mActivity = paramComponentName;
      return this;
    }
    
    @NonNull
    public Builder setAlwaysBadged()
    {
      this.mInfo.mIsAlwaysBadged = true;
      return this;
    }
    
    @NonNull
    public Builder setCategories(@NonNull Set<String> paramSet)
    {
      this.mInfo.mCategories = paramSet;
      return this;
    }
    
    @NonNull
    public Builder setDisabledMessage(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mDisabledMessage = paramCharSequence;
      return this;
    }
    
    @NonNull
    public Builder setIcon(IconCompat paramIconCompat)
    {
      this.mInfo.mIcon = paramIconCompat;
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
      this.mInfo.mIntents = paramArrayOfIntent;
      return this;
    }
    
    @NonNull
    public Builder setLongLabel(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mLongLabel = paramCharSequence;
      return this;
    }
    
    @NonNull
    public Builder setLongLived()
    {
      this.mInfo.mIsLongLived = true;
      return this;
    }
    
    @NonNull
    public Builder setPerson(@NonNull Person paramPerson)
    {
      return setPersons(new Person[] { paramPerson });
    }
    
    @NonNull
    public Builder setPersons(@NonNull Person[] paramArrayOfPerson)
    {
      this.mInfo.mPersons = paramArrayOfPerson;
      return this;
    }
    
    @NonNull
    public Builder setShortLabel(@NonNull CharSequence paramCharSequence)
    {
      this.mInfo.mLabel = paramCharSequence;
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.content.pm.ShortcutInfoCompat
 * JD-Core Version:    0.7.0.1
 */