package com.tencent.mobileqq.emoticonview;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.widget.EditText;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.text.TextUtils;
import java.util.ArrayList;
import java.util.List;

public class SystemAndEmojiEmoticonInfo
  extends EmoticonInfo
{
  public static final int a = 1;
  private static final int[] a = { 23, 40, 19, 43, 21, 9, 20, 106, 35, 10, 25, 24, 1, 0, 33, 32, 12, 27, 13, 22, 3, 18, 30, 31, 81, 82, 26, 2, 37, 50, 42, 83, 34, 11, 49, 84, 39, 78, 5, 4, 6, 85, 86, 87, 46, 88, 44, 89, 48, 14, 90, 41, 36, 91, 51, 17, 60, 61, 92, 93, 66, 58, 7, 8, 57, 29, 28, 74, 59, 80, 16, 70, 77, 62, 15, 68, 75, 76, 45, 52, 53, 54, 55, 56, 63, 73, 72, 65, 94, 64, 38, 47, 95, 71, 96, 97, 98, 99, 100, 79, 101, 102, 103, 104, 105, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 123, 124, 125, 126, 127, 128, 129, 130, 131, 132, 133, 134, 135, 136, 137, 138, 139, 140, 141, 142 };
  public static final int d = 2;
  public static final int g = -1;
  public static final int h;
  public static final int i;
  private static final int j = 165;
  public int e;
  public int f;
  
  static
  {
    int m = a.length / 20;
    if (a.length % 20 == 0) {}
    for (int k = 0;; k = 1)
    {
      h = k + m;
      i = 9;
      return;
    }
  }
  
  public SystemAndEmojiEmoticonInfo(int paramInt1, int paramInt2, int paramInt3)
  {
    this.b = paramInt1;
    this.e = paramInt2;
    this.f = paramInt3;
  }
  
  public static List a()
  {
    ArrayList localArrayList = new ArrayList(a.length + 165);
    int k = 0;
    while (k < a.length)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 1, a[k]));
      k += 1;
    }
    k = a.length;
    while (k <= a.length + 165)
    {
      localArrayList.add(new SystemAndEmojiEmoticonInfo(7, 2, k - a.length));
      k += 1;
    }
    return localArrayList;
  }
  
  public Drawable a(Context paramContext, float paramFloat)
  {
    Object localObject2 = null;
    Object localObject1;
    if (this.e == 1) {
      localObject1 = TextUtils.a(this.f, true);
    }
    do
    {
      do
      {
        return localObject1;
        localObject1 = localObject2;
      } while (this.e != 2);
      localObject1 = localObject2;
    } while (this.f == -1);
    return super.a(paramContext, paramFloat);
  }
  
  public void a(QQAppInterface paramQQAppInterface, Context paramContext, EditText paramEditText, SessionInfo paramSessionInfo)
  {
    if ((this.e == 2) && (this.f == -1)) {
      return;
    }
    int k = paramEditText.getSelectionStart();
    int m = paramEditText.getSelectionEnd();
    paramContext = paramEditText.getEditableText();
    if (this.e == 1) {}
    for (paramQQAppInterface = TextUtils.b(this.f);; paramQQAppInterface = TextUtils.a(this.f))
    {
      paramContext.replace(k, m, paramQQAppInterface);
      paramEditText.requestFocus();
      return;
    }
  }
  
  public Drawable b(Context paramContext, float paramFloat)
  {
    Object localObject = null;
    if (this.e == 1) {
      paramContext = TextUtils.a(this.f, false);
    }
    do
    {
      do
      {
        return paramContext;
        paramContext = localObject;
      } while (this.e != 2);
      paramContext = localObject;
    } while (this.f == -1);
    return TextUtils.a(this.f);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.SystemAndEmojiEmoticonInfo
 * JD-Core Version:    0.7.0.1
 */