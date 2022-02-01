package com.tencent.token.utils;

import android.net.Uri;
import android.os.AsyncTask;
import android.widget.ImageView;

public final class a
  extends AsyncTask<String, Integer, Uri>
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
      paramVarArgs = f.a(paramVarArgs[0]);
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
    ImageView localImageView = this.a;
    if ((localImageView != null) && (paramUri != null)) {
      localImageView.setImageURI(paramUri);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.utils.a
 * JD-Core Version:    0.7.0.1
 */