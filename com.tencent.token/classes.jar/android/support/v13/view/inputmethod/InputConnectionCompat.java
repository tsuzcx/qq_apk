package android.support.v13.view.inputmethod;

import android.content.ClipDescription;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;

public final class InputConnectionCompat
{
  private static final String COMMIT_CONTENT_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  private static final String COMMIT_CONTENT_FLAGS_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  private static final String COMMIT_CONTENT_LINK_URI_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  private static final String COMMIT_CONTENT_OPTS_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  private static final String COMMIT_CONTENT_RESULT_RECEIVER = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  public static int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
  
  public static boolean commitContent(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull InputContentInfoCompat paramInputContentInfoCompat, int paramInt, @Nullable Bundle paramBundle)
  {
    ClipDescription localClipDescription = paramInputContentInfoCompat.getDescription();
    paramEditorInfo = EditorInfoCompat.getContentMimeTypes(paramEditorInfo);
    int j = paramEditorInfo.length;
    int i = 0;
    if (i < j) {
      if (!localClipDescription.hasMimeType(paramEditorInfo[i])) {}
    }
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        return false;
        i += 1;
        break;
      }
      if (Build.VERSION.SDK_INT >= 25) {
        return paramInputConnection.commitContent((InputContentInfo)paramInputContentInfoCompat.unwrap(), paramInt, paramBundle);
      }
      paramEditorInfo = new Bundle();
      paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI", paramInputContentInfoCompat.getContentUri());
      paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION", paramInputContentInfoCompat.getDescription());
      paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI", paramInputContentInfoCompat.getLinkUri());
      paramEditorInfo.putInt("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS", paramInt);
      paramEditorInfo.putParcelable("android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS", paramBundle);
      return paramInputConnection.performPrivateCommand("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramEditorInfo);
    }
  }
  
  @NonNull
  public static InputConnection createWrapper(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull InputConnectionCompat.OnCommitContentListener paramOnCommitContentListener)
  {
    if (paramInputConnection == null) {
      throw new IllegalArgumentException("inputConnection must be non-null");
    }
    if (paramEditorInfo == null) {
      throw new IllegalArgumentException("editorInfo must be non-null");
    }
    if (paramOnCommitContentListener == null) {
      throw new IllegalArgumentException("onCommitContentListener must be non-null");
    }
    Object localObject;
    if (Build.VERSION.SDK_INT >= 25) {
      localObject = new InputConnectionCompat.1(paramInputConnection, false, paramOnCommitContentListener);
    }
    do
    {
      return localObject;
      localObject = paramInputConnection;
    } while (EditorInfoCompat.getContentMimeTypes(paramEditorInfo).length == 0);
    return new InputConnectionCompat.2(paramInputConnection, false, paramOnCommitContentListener);
  }
  
  /* Error */
  static boolean handlePerformPrivateCommand(@Nullable String paramString, @NonNull Bundle paramBundle, @NonNull InputConnectionCompat.OnCommitContentListener paramOnCommitContentListener)
  {
    // Byte code:
    //   0: ldc 8
    //   2: aload_0
    //   3: invokestatic 127	android/text/TextUtils:equals	(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z
    //   6: ifne +5 -> 11
    //   9: iconst_0
    //   10: ireturn
    //   11: aload_1
    //   12: ifnull -3 -> 9
    //   15: aload_1
    //   16: ldc 26
    //   18: invokevirtual 131	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   21: checkcast 133	android/os/ResultReceiver
    //   24: astore_0
    //   25: aload_1
    //   26: ldc 11
    //   28: invokevirtual 131	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   31: checkcast 135	android/net/Uri
    //   34: astore 5
    //   36: aload_1
    //   37: ldc 14
    //   39: invokevirtual 131	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   42: checkcast 54	android/content/ClipDescription
    //   45: astore 6
    //   47: aload_1
    //   48: ldc 20
    //   50: invokevirtual 131	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   53: checkcast 135	android/net/Uri
    //   56: astore 7
    //   58: aload_1
    //   59: ldc 17
    //   61: invokevirtual 139	android/os/Bundle:getInt	(Ljava/lang/String;)I
    //   64: istore_3
    //   65: aload_1
    //   66: ldc 23
    //   68: invokevirtual 131	android/os/Bundle:getParcelable	(Ljava/lang/String;)Landroid/os/Parcelable;
    //   71: checkcast 76	android/os/Bundle
    //   74: astore_1
    //   75: aload_2
    //   76: new 42	android/support/v13/view/inputmethod/InputContentInfoCompat
    //   79: dup
    //   80: aload 5
    //   82: aload 6
    //   84: aload 7
    //   86: invokespecial 142	android/support/v13/view/inputmethod/InputContentInfoCompat:<init>	(Landroid/net/Uri;Landroid/content/ClipDescription;Landroid/net/Uri;)V
    //   89: iload_3
    //   90: aload_1
    //   91: invokeinterface 148 4 0
    //   96: istore 4
    //   98: aload_0
    //   99: ifnull +16 -> 115
    //   102: iload 4
    //   104: ifeq +14 -> 118
    //   107: iconst_1
    //   108: istore_3
    //   109: aload_0
    //   110: iload_3
    //   111: aconst_null
    //   112: invokevirtual 152	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   115: iload 4
    //   117: ireturn
    //   118: iconst_0
    //   119: istore_3
    //   120: goto -11 -> 109
    //   123: astore_1
    //   124: aconst_null
    //   125: astore_0
    //   126: aload_0
    //   127: ifnull +9 -> 136
    //   130: aload_0
    //   131: iconst_0
    //   132: aconst_null
    //   133: invokevirtual 152	android/os/ResultReceiver:send	(ILandroid/os/Bundle;)V
    //   136: aload_1
    //   137: athrow
    //   138: astore_1
    //   139: goto -13 -> 126
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	paramString	String
    //   0	142	1	paramBundle	Bundle
    //   0	142	2	paramOnCommitContentListener	InputConnectionCompat.OnCommitContentListener
    //   64	56	3	i	int
    //   96	20	4	bool	boolean
    //   34	47	5	localUri1	android.net.Uri
    //   45	38	6	localClipDescription	ClipDescription
    //   56	29	7	localUri2	android.net.Uri
    // Exception table:
    //   from	to	target	type
    //   15	25	123	finally
    //   25	98	138	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v13.view.inputmethod.InputConnectionCompat
 * JD-Core Version:    0.7.0.1
 */