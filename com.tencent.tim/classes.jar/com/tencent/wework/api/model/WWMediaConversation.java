package com.tencent.wework.api.model;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.util.Log;
import java.io.ByteArrayOutputStream;

public class WWMediaConversation
  extends WWMediaMessage.WWMediaObject
{
  private static final int CONTENT_LENGTH_LIMIT = 10485760;
  private static final int PATH_LENGTH_LIMIT = 10240;
  private static final String TAG = "WWAPI.WWMediaConv";
  public byte[] avatarData;
  public String avatarPath;
  public long date;
  public WWMediaMessage.WWMediaObject message;
  public String name;
  
  public WWMediaConversation() {}
  
  public WWMediaConversation(Bitmap paramBitmap)
  {
    try
    {
      ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
      paramBitmap.compress(Bitmap.CompressFormat.JPEG, 85, localByteArrayOutputStream);
      this.avatarData = localByteArrayOutputStream.toByteArray();
      localByteArrayOutputStream.close();
      return;
    }
    catch (Exception paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public WWMediaConversation(byte[] paramArrayOfByte) {}
  
  public boolean checkArgs()
  {
    if (!super.checkArgs()) {}
    do
    {
      return false;
      if ((this.avatarData != null) && (this.avatarData.length > 10485760))
      {
        Log.d("WWAPI.WWMediaConv", "checkArgs fail, content is too large");
        return false;
      }
      if ((this.avatarPath != null) && (this.avatarPath.length() > 10240))
      {
        Log.d("WWAPI.WWMediaConv", "checkArgs fail, path is invalid");
        return false;
      }
      if ((this.avatarPath != null) && (getFileSize(this.avatarPath) > 10485760))
      {
        Log.d("WWAPI.WWMediaConv", "checkArgs fail, image content is too large");
        return false;
      }
    } while ((this.message == null) || (!this.message.checkArgs()));
    return true;
  }
  
  public void fromBundle(Bundle paramBundle)
  {
    super.fromBundle(paramBundle);
    this.name = paramBundle.getString("_wwconvobject_name");
    this.date = paramBundle.getLong("_wwconvobject_date");
    this.avatarData = paramBundle.getByteArray("_wwconvobject_avatarData");
    this.avatarPath = paramBundle.getString("_wwconvobject_avatarPath");
    try
    {
      this.message = ((WWMediaMessage.WWMediaObject)BaseMessage.parse(paramBundle.getBundle("_wwconvobject_message")));
      return;
    }
    catch (Throwable paramBundle)
    {
      Log.d("WWAPI.WWMediaConv", "fromBundle", paramBundle);
    }
  }
  
  public int getType()
  {
    return 8;
  }
  
  public void toBundle(Bundle paramBundle)
  {
    super.toBundle(paramBundle);
    paramBundle.putString("_wwconvobject_name", this.name);
    paramBundle.putLong("_wwconvobject_date", this.date);
    paramBundle.putByteArray("_wwconvobject_avatarData", this.avatarData);
    paramBundle.putString("_wwconvobject_avatarPath", this.avatarPath);
    paramBundle.putBundle("_wwconvobject_message", BaseMessage.pack(this.message));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.WWMediaConversation
 * JD-Core Version:    0.7.0.1
 */