package com.tencent.token;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ImageView;
import com.tencent.token.global.RqdApplication;
import java.io.File;
import java.io.FileOutputStream;

public final class aao
  extends AsyncTask<String, Integer, Uri>
{
  private ImageView a;
  
  public aao(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private static Uri a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    try
    {
      xv.b("path".concat(String.valueOf(paramVarArgs)));
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(abt.b(paramVarArgs));
      ((StringBuilder)localObject1).append(paramVarArgs.substring(paramVarArgs.lastIndexOf(".")));
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = RqdApplication.b().getExternalCacheDir();
      aat.a = (File)localObject1;
      if (localObject1 == null) {
        aat.a = new File(Environment.getExternalStorageDirectory(), "cache");
      }
      if (!aat.a.exists()) {
        aat.a.mkdirs();
      }
      if (!aat.a.exists()) {
        return null;
      }
      localObject1 = new File(aat.a, (String)localObject2);
      if (((File)localObject1).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder("exists");
        localStringBuilder.append(paramVarArgs);
        localStringBuilder.append("name");
        localStringBuilder.append((String)localObject2);
        xv.b(localStringBuilder.toString());
        return Uri.fromFile((File)localObject1);
      }
      xv.b("fromnet".concat(String.valueOf(paramVarArgs)));
      paramVarArgs = new akl().a(paramVarArgs);
      if (paramVarArgs != null)
      {
        localObject2 = new FileOutputStream((File)localObject1);
        ((FileOutputStream)localObject2).write(paramVarArgs, 0, paramVarArgs.length);
        ((FileOutputStream)localObject2).close();
        paramVarArgs = Uri.fromFile((File)localObject1);
        return paramVarArgs;
      }
      return null;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aao
 * JD-Core Version:    0.7.0.1
 */