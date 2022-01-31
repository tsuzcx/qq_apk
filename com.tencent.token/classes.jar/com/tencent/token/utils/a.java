package com.tencent.token.utils;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;

public final class a
  extends AsyncTask
{
  private ImageView a;
  
  public a(ImageView paramImageView)
  {
    this.a = paramImageView;
  }
  
  private static Uri a(String... paramVarArgs)
  {
    try
    {
      paramVarArgs = j.a(paramVarArgs[0]);
      return paramVarArgs;
    }
    catch (Exception paramVarArgs)
    {
      paramVarArgs.printStackTrace();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.a
 * JD-Core Version:    0.7.0.1
 */