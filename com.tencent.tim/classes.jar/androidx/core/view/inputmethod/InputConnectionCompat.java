package androidx.core.view.inputmethod;

import android.content.ClipDescription;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public final class InputConnectionCompat
{
  private static final String COMMIT_CONTENT_ACTION = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  private static final String COMMIT_CONTENT_CONTENT_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  private static final String COMMIT_CONTENT_CONTENT_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
  private static final String COMMIT_CONTENT_DESCRIPTION_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  private static final String COMMIT_CONTENT_DESCRIPTION_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
  private static final String COMMIT_CONTENT_FLAGS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  private static final String COMMIT_CONTENT_FLAGS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
  private static final String COMMIT_CONTENT_INTEROP_ACTION = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";
  private static final String COMMIT_CONTENT_LINK_URI_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  private static final String COMMIT_CONTENT_LINK_URI_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
  private static final String COMMIT_CONTENT_OPTS_INTEROP_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  private static final String COMMIT_CONTENT_OPTS_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
  private static final String COMMIT_CONTENT_RESULT_INTEROP_RECEIVER_KEY = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  private static final String COMMIT_CONTENT_RESULT_RECEIVER_KEY = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
  public static final int INPUT_CONTENT_GRANT_READ_URI_PERMISSION = 1;
  
  public static boolean commitContent(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull InputContentInfoCompat paramInputContentInfoCompat, int paramInt, @Nullable Bundle paramBundle)
  {
    int j = 0;
    Object localObject = paramInputContentInfoCompat.getDescription();
    String[] arrayOfString = EditorInfoCompat.getContentMimeTypes(paramEditorInfo);
    int k = arrayOfString.length;
    int i = 0;
    if (i < k) {
      if (!((ClipDescription)localObject).hasMimeType(arrayOfString[i])) {}
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
      i = j;
      switch (EditorInfoCompat.getProtocol(paramEditorInfo))
      {
      default: 
        return false;
      case 2: 
        i = 1;
      }
      localObject = new Bundle();
      if (i != 0)
      {
        paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        ((Bundle)localObject).putParcelable(paramEditorInfo, paramInputContentInfoCompat.getContentUri());
        if (i == 0) {
          break label243;
        }
        paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
        label160:
        ((Bundle)localObject).putParcelable(paramEditorInfo, paramInputContentInfoCompat.getDescription());
        if (i == 0) {
          break label249;
        }
        paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
        label178:
        ((Bundle)localObject).putParcelable(paramEditorInfo, paramInputContentInfoCompat.getLinkUri());
        if (i == 0) {
          break label255;
        }
        paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
        label196:
        ((Bundle)localObject).putInt(paramEditorInfo, paramInt);
        if (i == 0) {
          break label261;
        }
        paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        label211:
        ((Bundle)localObject).putParcelable(paramEditorInfo, paramBundle);
        if (i == 0) {
          break label267;
        }
      }
      label261:
      label267:
      for (paramEditorInfo = "android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT";; paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT")
      {
        return paramInputConnection.performPrivateCommand(paramEditorInfo, (Bundle)localObject);
        paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        break;
        label243:
        paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
        break label160;
        label249:
        paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
        break label178;
        label255:
        paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
        break label196;
        paramEditorInfo = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        break label211;
      }
    }
  }
  
  @NonNull
  public static InputConnection createWrapper(@NonNull InputConnection paramInputConnection, @NonNull EditorInfo paramEditorInfo, @NonNull OnCommitContentListener paramOnCommitContentListener)
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
  
  static boolean handlePerformPrivateCommand(@Nullable String paramString, @NonNull Bundle paramBundle, @NonNull OnCommitContentListener paramOnCommitContentListener)
  {
    int j = 1;
    if (paramBundle == null) {
      return false;
    }
    int i;
    if (TextUtils.equals("androidx.core.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramString))
    {
      i = 0;
      label20:
      if (i == 0) {
        break label189;
      }
      paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
    }
    try
    {
      label27:
      localResultReceiver = (ResultReceiver)paramBundle.getParcelable(paramString);
      if (i != 0) {
        paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_URI";
      }
    }
    finally
    {
      label44:
      Uri localUri1;
      label61:
      ClipDescription localClipDescription;
      label78:
      Uri localUri2;
      label95:
      int k;
      label109:
      paramString = null;
      label152:
      label189:
      label207:
      if (paramString != null) {
        paramString.send(0, null);
      }
    }
    try
    {
      localUri1 = (Uri)paramBundle.getParcelable(paramString);
      if (i == 0) {
        break label240;
      }
      paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
    }
    finally
    {
      paramString = localResultReceiver;
      break label215;
      bool = false;
      break label152;
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_DESCRIPTION";
      break label61;
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
      break label78;
      paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
      break label95;
    }
    localClipDescription = (ClipDescription)paramBundle.getParcelable(paramString);
    if (i != 0)
    {
      paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_LINK_URI";
      localUri2 = (Uri)paramBundle.getParcelable(paramString);
      if (i == 0) {
        break label252;
      }
      paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_FLAGS";
      k = paramBundle.getInt(paramString);
      if (i != 0)
      {
        paramString = "android.support.v13.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        paramString = (Bundle)paramBundle.getParcelable(paramString);
        if ((localUri1 == null) || (localClipDescription == null)) {
          break label234;
        }
        bool = paramOnCommitContentListener.onCommitContent(new InputContentInfoCompat(localUri1, localClipDescription, localUri2), k, paramString);
        if (localResultReceiver != null) {
          if (!bool) {
            break label207;
          }
        }
      }
      for (i = j;; i = 0)
      {
        localResultReceiver.send(i, null);
        return bool;
        if (!TextUtils.equals("android.support.v13.view.inputmethod.InputConnectionCompat.COMMIT_CONTENT", paramString)) {
          break;
        }
        i = 1;
        break label20;
        paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_RESULT_RECEIVER";
        break label27;
        paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_URI";
        break label44;
        paramString = "androidx.core.view.inputmethod.InputConnectionCompat.CONTENT_OPTS";
        break label109;
      }
    }
  }
  
  public static abstract interface OnCommitContentListener
  {
    public abstract boolean onCommitContent(InputContentInfoCompat paramInputContentInfoCompat, int paramInt, Bundle paramBundle);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     androidx.core.view.inputmethod.InputConnectionCompat
 * JD-Core Version:    0.7.0.1
 */