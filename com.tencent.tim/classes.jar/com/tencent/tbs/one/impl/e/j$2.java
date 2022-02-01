package com.tencent.tbs.one.impl.e;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.tbs.one.impl.a.f;
import com.tencent.tbs.one.impl.common.c;
import java.io.File;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

final class j$2
  extends c<e<File>>
{
  j$2(j paramj, String paramString1, String paramString2, String paramString3, int paramInt) {}
  
  public final void a(int paramInt, String paramString, Throwable paramThrowable)
  {
    if (paramInt == 322)
    {
      Object localObject = this.e.b;
      String str = this.c;
      f.c("deleteInUseComponentNames", new Object[] { str });
      HashSet localHashSet = new HashSet(Arrays.asList(((i)localObject).m()));
      localHashSet.remove(str);
      localObject = ((i)localObject).q.edit();
      ((SharedPreferences.Editor)localObject).putStringSet("in_use_component_names", localHashSet);
      ((SharedPreferences.Editor)localObject).apply();
    }
    f.c("[%s] Failed to update component %s#%d, error: [%d] %s", new Object[] { this.a, this.b, Integer.valueOf(this.d), Integer.valueOf(paramInt), paramString, paramThrowable });
    this.e.a(paramInt, "Failed to update component " + this.b + ", error: " + paramString, paramThrowable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tbs.one.impl.e.j.2
 * JD-Core Version:    0.7.0.1
 */