package com.tencent.wework.api.model;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.wework.api.util.ReflecterHelper;

public abstract class BaseMessage
{
  protected static final int SDK_VER = 1;
  public static final int TYPE_SHARE_MESSAGE = 0;
  
  public static Bundle pack(BaseMessage paramBaseMessage)
  {
    if (paramBaseMessage == null) {
      return null;
    }
    Bundle localBundle = new Bundle();
    paramBaseMessage.toBundle(localBundle);
    localBundle.putString("_wwobject_identifier_", paramBaseMessage.getClass().getName());
    return localBundle;
  }
  
  public static BaseMessage parse(Bundle paramBundle)
  {
    try
    {
      Object localObject = paramBundle.getString("_wwobject_identifier_");
      if (!TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = (BaseMessage)ReflecterHelper.newInstance((String)localObject);
        ((BaseMessage)localObject).fromBundle(paramBundle);
        return localObject;
      }
    }
    catch (Throwable paramBundle)
    {
      paramBundle.printStackTrace();
    }
    return null;
  }
  
  public abstract boolean checkArgs();
  
  public abstract void fromBundle(Bundle paramBundle);
  
  public abstract int getType();
  
  public abstract void toBundle(Bundle paramBundle);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.wework.api.model.BaseMessage
 * JD-Core Version:    0.7.0.1
 */