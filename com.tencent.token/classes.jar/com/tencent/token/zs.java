package com.tencent.token;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.widget.ImageView;
import java.io.File;
import java.io.FileOutputStream;

public final class zs
  extends AsyncTask<String, Integer, Uri>
{
  private ImageView a;
  
  public zs(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private static Uri a(String... paramVarArgs)
  {
    paramVarArgs = paramVarArgs[0];
    try
    {
      xa.b("path".concat(String.valueOf(paramVarArgs)));
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(aax.b(paramVarArgs));
      ((StringBuilder)localObject1).append(paramVarArgs.substring(paramVarArgs.lastIndexOf(".")));
      Object localObject2 = ((StringBuilder)localObject1).toString();
      localObject1 = new File(Environment.getExternalStorageDirectory(), "cache");
      zx.a = (File)localObject1;
      if (!((File)localObject1).exists()) {
        zx.a.mkdirs();
      }
      if (!zx.a.exists()) {
        return null;
      }
      localObject1 = new File(zx.a, (String)localObject2);
      if (((File)localObject1).exists())
      {
        StringBuilder localStringBuilder = new StringBuilder("exists");
        localStringBuilder.append(paramVarArgs);
        localStringBuilder.append("name");
        localStringBuilder.append((String)localObject2);
        xa.b(localStringBuilder.toString());
        return Uri.fromFile((File)localObject1);
      }
      xa.b("fromnet".concat(String.valueOf(paramVarArgs)));
      paramVarArgs = new ahq().a(paramVarArgs);
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
 * Qualified Name:     com.tencent.token.zs
 * JD-Core Version:    0.7.0.1
 */