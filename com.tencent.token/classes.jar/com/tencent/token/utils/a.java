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
  
  protected Uri a(String... paramVarArgs)
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
  
  protected void a(Uri paramUri)
  {
    super.onPostExecute(paramUri);
    if ((this.a != null) && (paramUri != null)) {
      this.a.setImageURI(paramUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.a
 * JD-Core Version:    0.7.0.1
 */