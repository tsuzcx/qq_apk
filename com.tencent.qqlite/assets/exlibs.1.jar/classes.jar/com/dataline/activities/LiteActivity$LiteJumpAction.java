package com.dataline.activities;

import android.content.ContentResolver;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DataLineHandler.EFILETYPE;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class LiteActivity$LiteJumpAction
{
  private LiteActivity b;
  
  public LiteActivity$LiteJumpAction(LiteActivity paramLiteActivity1, LiteActivity paramLiteActivity2)
  {
    this.b = paramLiteActivity2;
  }
  
  private String a(Uri paramUri)
  {
    String str = paramUri.getScheme();
    if (str.equals("file")) {
      return new File(paramUri.getPath()).getAbsolutePath();
    }
    if (str.equals("content")) {
      try
      {
        paramUri = this.b.getContentResolver().query(paramUri, new String[] { "_data" }, null, null, null);
        int i = paramUri.getColumnIndexOrThrow("_data");
        paramUri.moveToFirst();
        str = paramUri.getString(i);
        paramUri.close();
        return str;
      }
      catch (Exception paramUri)
      {
        paramUri.printStackTrace();
        return null;
      }
    }
    return null;
  }
  
  private void a(ArrayList paramArrayList, boolean paramBoolean)
  {
    if (paramArrayList == null)
    {
      LiteActivity.a(this.a);
      return;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      String str = a((Uri)paramArrayList.next());
      if (!TextUtils.isEmpty(str)) {
        localArrayList.add(str);
      }
    }
    if (paramBoolean) {}
    for (paramArrayList = DataLineHandler.EFILETYPE.FILE_TYPE_IMAGE;; paramArrayList = DataLineHandler.EFILETYPE.FILE_TYPE_FILE)
    {
      LiteActivity.a(this.a, localArrayList, paramArrayList);
      return;
    }
  }
  
  public void a(Intent paramIntent)
  {
    Object localObject = paramIntent.getExtras();
    if (paramIntent.getBooleanExtra("dataline_share_finish", false)) {}
    String str1;
    String str2;
    do
    {
      return;
      paramIntent.putExtra("dataline_share_finish", true);
      str1 = ((Bundle)localObject).getString("android.intent.extra.TEXT");
      str2 = paramIntent.getType();
    } while (TextUtils.isEmpty(str2));
    if ((str2.startsWith("text")) && (!((Bundle)localObject).containsKey("android.intent.extra.STREAM")))
    {
      LiteActivity.a(this.b, str1);
      return;
    }
    if (str2.startsWith("message"))
    {
      paramIntent = (SpannableString)((Bundle)localObject).get("android.intent.extra.TEXT");
      LiteActivity.a(this.b, paramIntent.toString());
      return;
    }
    if (str2.startsWith("image"))
    {
      if (paramIntent.getAction().equals("android.intent.action.SEND"))
      {
        paramIntent = (Uri)((Bundle)localObject).get("android.intent.extra.STREAM");
        if (paramIntent == null)
        {
          LiteActivity.a(this.a);
          return;
        }
        localObject = new ArrayList();
        ((ArrayList)localObject).add(paramIntent);
        a((ArrayList)localObject, true);
        return;
      }
      a((ArrayList)((Bundle)localObject).get("android.intent.extra.STREAM"), true);
      return;
    }
    if (paramIntent.getAction().equals("android.intent.action.SEND"))
    {
      paramIntent = (Uri)((Bundle)localObject).get("android.intent.extra.STREAM");
      if (paramIntent == null)
      {
        LiteActivity.a(this.a);
        return;
      }
      localObject = new ArrayList();
      ((ArrayList)localObject).add(paramIntent);
      a((ArrayList)localObject, false);
      return;
    }
    a((ArrayList)((Bundle)localObject).get("android.intent.extra.STREAM"), false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.dataline.activities.LiteActivity.LiteJumpAction
 * JD-Core Version:    0.7.0.1
 */