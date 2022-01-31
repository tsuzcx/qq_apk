package android.support.v4.view.accessibility;

import android.os.Build.VERSION;
import android.view.accessibility.AccessibilityNodeInfo.AccessibilityAction;

public class AccessibilityNodeInfoCompat$AccessibilityActionCompat
{
  public static final AccessibilityActionCompat ACTION_ACCESSIBILITY_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_ACCESSIBILITY_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_FOCUS;
  public static final AccessibilityActionCompat ACTION_CLEAR_SELECTION;
  public static final AccessibilityActionCompat ACTION_CLICK;
  public static final AccessibilityActionCompat ACTION_COLLAPSE;
  public static final AccessibilityActionCompat ACTION_CONTEXT_CLICK;
  public static final AccessibilityActionCompat ACTION_COPY;
  public static final AccessibilityActionCompat ACTION_CUT;
  public static final AccessibilityActionCompat ACTION_DISMISS;
  public static final AccessibilityActionCompat ACTION_EXPAND;
  public static final AccessibilityActionCompat ACTION_FOCUS;
  public static final AccessibilityActionCompat ACTION_LONG_CLICK;
  public static final AccessibilityActionCompat ACTION_NEXT_AT_MOVEMENT_GRANULARITY;
  public static final AccessibilityActionCompat ACTION_NEXT_HTML_ELEMENT;
  public static final AccessibilityActionCompat ACTION_PASTE;
  public static final AccessibilityActionCompat ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY;
  public static final AccessibilityActionCompat ACTION_PREVIOUS_HTML_ELEMENT;
  public static final AccessibilityActionCompat ACTION_SCROLL_BACKWARD;
  public static final AccessibilityActionCompat ACTION_SCROLL_DOWN;
  public static final AccessibilityActionCompat ACTION_SCROLL_FORWARD;
  public static final AccessibilityActionCompat ACTION_SCROLL_LEFT;
  public static final AccessibilityActionCompat ACTION_SCROLL_RIGHT;
  public static final AccessibilityActionCompat ACTION_SCROLL_TO_POSITION;
  public static final AccessibilityActionCompat ACTION_SCROLL_UP;
  public static final AccessibilityActionCompat ACTION_SELECT;
  public static final AccessibilityActionCompat ACTION_SET_PROGRESS;
  public static final AccessibilityActionCompat ACTION_SET_SELECTION;
  public static final AccessibilityActionCompat ACTION_SET_TEXT;
  public static final AccessibilityActionCompat ACTION_SHOW_ON_SCREEN;
  final Object mAction;
  
  static
  {
    Object localObject2 = null;
    ACTION_FOCUS = new AccessibilityActionCompat(1, null);
    ACTION_CLEAR_FOCUS = new AccessibilityActionCompat(2, null);
    ACTION_SELECT = new AccessibilityActionCompat(4, null);
    ACTION_CLEAR_SELECTION = new AccessibilityActionCompat(8, null);
    ACTION_CLICK = new AccessibilityActionCompat(16, null);
    ACTION_LONG_CLICK = new AccessibilityActionCompat(32, null);
    ACTION_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(64, null);
    ACTION_CLEAR_ACCESSIBILITY_FOCUS = new AccessibilityActionCompat(128, null);
    ACTION_NEXT_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(256, null);
    ACTION_PREVIOUS_AT_MOVEMENT_GRANULARITY = new AccessibilityActionCompat(512, null);
    ACTION_NEXT_HTML_ELEMENT = new AccessibilityActionCompat(1024, null);
    ACTION_PREVIOUS_HTML_ELEMENT = new AccessibilityActionCompat(2048, null);
    ACTION_SCROLL_FORWARD = new AccessibilityActionCompat(4096, null);
    ACTION_SCROLL_BACKWARD = new AccessibilityActionCompat(8192, null);
    ACTION_COPY = new AccessibilityActionCompat(16384, null);
    ACTION_PASTE = new AccessibilityActionCompat(32768, null);
    ACTION_CUT = new AccessibilityActionCompat(65536, null);
    ACTION_SET_SELECTION = new AccessibilityActionCompat(131072, null);
    ACTION_EXPAND = new AccessibilityActionCompat(262144, null);
    ACTION_COLLAPSE = new AccessibilityActionCompat(524288, null);
    ACTION_DISMISS = new AccessibilityActionCompat(1048576, null);
    ACTION_SET_TEXT = new AccessibilityActionCompat(2097152, null);
    if (Build.VERSION.SDK_INT >= 23)
    {
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SHOW_ON_SCREEN;
      ACTION_SHOW_ON_SCREEN = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label485;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_TO_POSITION;
      label328:
      ACTION_SCROLL_TO_POSITION = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label490;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_UP;
      label351:
      ACTION_SCROLL_UP = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label495;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_LEFT;
      label374:
      ACTION_SCROLL_LEFT = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label500;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_DOWN;
      label397:
      ACTION_SCROLL_DOWN = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label505;
      }
      localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SCROLL_RIGHT;
      label420:
      ACTION_SCROLL_RIGHT = new AccessibilityActionCompat(localObject1);
      if (Build.VERSION.SDK_INT < 23) {
        break label510;
      }
    }
    label485:
    label490:
    label495:
    label500:
    label505:
    label510:
    for (Object localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_CONTEXT_CLICK;; localObject1 = null)
    {
      ACTION_CONTEXT_CLICK = new AccessibilityActionCompat(localObject1);
      localObject1 = localObject2;
      if (Build.VERSION.SDK_INT >= 24) {
        localObject1 = AccessibilityNodeInfo.AccessibilityAction.ACTION_SET_PROGRESS;
      }
      ACTION_SET_PROGRESS = new AccessibilityActionCompat(localObject1);
      return;
      localObject1 = null;
      break;
      localObject1 = null;
      break label328;
      localObject1 = null;
      break label351;
      localObject1 = null;
      break label374;
      localObject1 = null;
      break label397;
      localObject1 = null;
      break label420;
    }
  }
  
  public AccessibilityNodeInfoCompat$AccessibilityActionCompat(int paramInt, CharSequence paramCharSequence) {}
  
  AccessibilityNodeInfoCompat$AccessibilityActionCompat(Object paramObject)
  {
    this.mAction = paramObject;
  }
  
  public int getId()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getId();
    }
    return 0;
  }
  
  public CharSequence getLabel()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      return ((AccessibilityNodeInfo.AccessibilityAction)this.mAction).getLabel();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.view.accessibility.AccessibilityNodeInfoCompat.AccessibilityActionCompat
 * JD-Core Version:    0.7.0.1
 */