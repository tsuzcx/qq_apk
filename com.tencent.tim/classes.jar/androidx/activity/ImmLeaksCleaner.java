package androidx.activity;

import android.app.Activity;
import android.view.inputmethod.InputMethodManager;
import androidx.annotation.MainThread;
import androidx.annotation.RequiresApi;
import androidx.lifecycle.LifecycleEventObserver;
import java.lang.reflect.Field;

@RequiresApi(19)
final class ImmLeaksCleaner
  implements LifecycleEventObserver
{
  private static final int INIT_FAILED = 2;
  private static final int INIT_SUCCESS = 1;
  private static final int NOT_INITIALIAZED = 0;
  private static Field sHField;
  private static Field sNextServedViewField;
  private static int sReflectedFieldsInitialized = 0;
  private static Field sServedViewField;
  private Activity mActivity;
  
  ImmLeaksCleaner(Activity paramActivity)
  {
    this.mActivity = paramActivity;
  }
  
  @MainThread
  private static void initializeReflectiveFields()
  {
    try
    {
      sReflectedFieldsInitialized = 2;
      sServedViewField = InputMethodManager.class.getDeclaredField("mServedView");
      sServedViewField.setAccessible(true);
      sNextServedViewField = InputMethodManager.class.getDeclaredField("mNextServedView");
      sNextServedViewField.setAccessible(true);
      sHField = InputMethodManager.class.getDeclaredField("mH");
      sHField.setAccessible(true);
      sReflectedFieldsInitialized = 1;
      return;
    }
    catch (NoSuchFieldException localNoSuchFieldException) {}
  }
  
  /* Error */
  public void onStateChanged(@androidx.annotation.NonNull androidx.lifecycle.LifecycleOwner paramLifecycleOwner, @androidx.annotation.NonNull androidx.lifecycle.Lifecycle.Event paramEvent)
  {
    // Byte code:
    //   0: aload_2
    //   1: getstatic 78	androidx/lifecycle/Lifecycle$Event:ON_DESTROY	Landroidx/lifecycle/Lifecycle$Event;
    //   4: if_acmpeq +4 -> 8
    //   7: return
    //   8: getstatic 27	androidx/activity/ImmLeaksCleaner:sReflectedFieldsInitialized	I
    //   11: ifne +6 -> 17
    //   14: invokestatic 80	androidx/activity/ImmLeaksCleaner:initializeReflectiveFields	()V
    //   17: getstatic 27	androidx/activity/ImmLeaksCleaner:sReflectedFieldsInitialized	I
    //   20: iconst_1
    //   21: if_icmpne -14 -> 7
    //   24: aload_0
    //   25: getfield 34	androidx/activity/ImmLeaksCleaner:mActivity	Landroid/app/Activity;
    //   28: ldc 82
    //   30: invokevirtual 88	android/app/Activity:getSystemService	(Ljava/lang/String;)Ljava/lang/Object;
    //   33: checkcast 40	android/view/inputmethod/InputMethodManager
    //   36: astore_2
    //   37: getstatic 64	androidx/activity/ImmLeaksCleaner:sHField	Ljava/lang/reflect/Field;
    //   40: aload_2
    //   41: invokevirtual 92	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   44: astore_1
    //   45: aload_1
    //   46: ifnull -39 -> 7
    //   49: aload_1
    //   50: monitorenter
    //   51: getstatic 50	androidx/activity/ImmLeaksCleaner:sServedViewField	Ljava/lang/reflect/Field;
    //   54: aload_2
    //   55: invokevirtual 92	java/lang/reflect/Field:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   58: checkcast 94	android/view/View
    //   61: astore_3
    //   62: aload_3
    //   63: ifnonnull +19 -> 82
    //   66: aload_1
    //   67: monitorexit
    //   68: return
    //   69: astore_2
    //   70: aload_1
    //   71: monitorexit
    //   72: aload_2
    //   73: athrow
    //   74: astore_2
    //   75: aload_1
    //   76: monitorexit
    //   77: return
    //   78: astore_2
    //   79: aload_1
    //   80: monitorexit
    //   81: return
    //   82: aload_3
    //   83: invokevirtual 98	android/view/View:isAttachedToWindow	()Z
    //   86: ifeq +6 -> 92
    //   89: aload_1
    //   90: monitorexit
    //   91: return
    //   92: getstatic 60	androidx/activity/ImmLeaksCleaner:sNextServedViewField	Ljava/lang/reflect/Field;
    //   95: aload_2
    //   96: aconst_null
    //   97: invokevirtual 102	java/lang/reflect/Field:set	(Ljava/lang/Object;Ljava/lang/Object;)V
    //   100: aload_1
    //   101: monitorexit
    //   102: aload_2
    //   103: invokevirtual 105	android/view/inputmethod/InputMethodManager:isActive	()Z
    //   106: pop
    //   107: return
    //   108: astore_2
    //   109: aload_1
    //   110: monitorexit
    //   111: return
    //   112: astore_1
    //   113: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	this	ImmLeaksCleaner
    //   0	114	1	paramLifecycleOwner	androidx.lifecycle.LifecycleOwner
    //   0	114	2	paramEvent	androidx.lifecycle.Lifecycle.Event
    //   61	22	3	localView	android.view.View
    // Exception table:
    //   from	to	target	type
    //   51	62	69	finally
    //   66	68	69	finally
    //   70	72	69	finally
    //   75	77	69	finally
    //   79	81	69	finally
    //   82	91	69	finally
    //   92	100	69	finally
    //   100	102	69	finally
    //   109	111	69	finally
    //   51	62	74	java/lang/IllegalAccessException
    //   51	62	78	java/lang/ClassCastException
    //   92	100	108	java/lang/IllegalAccessException
    //   37	45	112	java/lang/IllegalAccessException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.activity.ImmLeaksCleaner
 * JD-Core Version:    0.7.0.1
 */