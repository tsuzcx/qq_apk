package android.support.v4.content.pm;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.graphics.drawable.IconCompat;
import android.text.TextUtils;

public class ShortcutInfoCompat$Builder
{
  private final ShortcutInfoCompat mInfo = new ShortcutInfoCompat(null);
  
  public ShortcutInfoCompat$Builder(@NonNull Context paramContext, @NonNull String paramString)
  {
    ShortcutInfoCompat.access$102(this.mInfo, paramContext);
    ShortcutInfoCompat.access$202(this.mInfo, paramString);
  }
  
  @NonNull
  public ShortcutInfoCompat build()
  {
    if (TextUtils.isEmpty(ShortcutInfoCompat.access$300(this.mInfo))) {
      throw new IllegalArgumentException("Shortcut much have a non-empty label");
    }
    if ((ShortcutInfoCompat.access$600(this.mInfo) == null) || (ShortcutInfoCompat.access$600(this.mInfo).length == 0)) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.content.pm.ShortcutInfoCompat.Builder
 * JD-Core Version:    0.7.0.1
 */