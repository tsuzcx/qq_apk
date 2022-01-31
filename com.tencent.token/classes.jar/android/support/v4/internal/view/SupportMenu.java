package android.support.v4.internal.view;

import android.support.annotation.RestrictTo;
import android.view.Menu;

@RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
public abstract interface SupportMenu
  extends Menu
{
  public static final int CATEGORY_MASK = -65536;
  public static final int CATEGORY_SHIFT = 16;
  public static final int FLAG_KEEP_OPEN_ON_SUBMENU_OPENED = 4;
  public static final int SUPPORTED_MODIFIERS_MASK = 69647;
  public static final int USER_MASK = 65535;
  public static final int USER_SHIFT = 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.internal.view.SupportMenu
 * JD-Core Version:    0.7.0.1
 */