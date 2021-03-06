package com.tencent.mobileqq.mini.apkg;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.mini.util.DisplayUtil;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class TabBarInfo
  implements Cloneable
{
  public static final String BORDER_STYLE_BLACK = "black";
  public static final String BORDER_STYLE_WHITE = "white";
  public static final String POS_BOTTOM = "bottom";
  public static final String POS_TOP = "top";
  public int backgroundColor;
  public String borderStyle;
  public int color;
  public boolean custom;
  public boolean isShow = true;
  public List<ButtonInfo> list;
  public String position;
  public int selectedColor;
  
  public static TabBarInfo parse(JSONObject paramJSONObject, ApkgInfo paramApkgInfo)
  {
    TabBarInfo localTabBarInfo = null;
    if (paramJSONObject != null)
    {
      localTabBarInfo = new TabBarInfo();
      localTabBarInfo.custom = paramJSONObject.optBoolean("custom", false);
      if (localTabBarInfo.custom) {
        localTabBarInfo.isShow = false;
      }
      localTabBarInfo.color = DisplayUtil.parseColor(paramJSONObject.optString("color"));
      localTabBarInfo.selectedColor = DisplayUtil.parseColor(paramJSONObject.optString("selectedColor"));
      localTabBarInfo.backgroundColor = DisplayUtil.parseColor(paramJSONObject.optString("backgroundColor"));
      localTabBarInfo.borderStyle = paramJSONObject.optString("borderStyle", "black");
      localTabBarInfo.list = parseIconList(paramJSONObject.optJSONArray("list"), paramApkgInfo);
      localTabBarInfo.position = paramJSONObject.optString("position", "bottom");
    }
    return localTabBarInfo;
  }
  
  public static List<ButtonInfo> parseIconList(JSONArray paramJSONArray, ApkgInfo paramApkgInfo)
  {
    LinkedList localLinkedList = new LinkedList();
    if (paramJSONArray != null)
    {
      int i = 0;
      while (i < paramJSONArray.length())
      {
        JSONObject localJSONObject = paramJSONArray.optJSONObject(i);
        if (localJSONObject != null) {
          localLinkedList.add(ButtonInfo.parse(localJSONObject, paramApkgInfo));
        }
        i += 1;
      }
    }
    return localLinkedList;
  }
  
  public static Bitmap transDataToBitmap(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      try
      {
        paramString = Base64.decode(paramString, 0);
        if (paramString != null)
        {
          paramString = BitmapFactory.decodeByteArray(paramString, 0, paramString.length);
          return paramString;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        paramString.printStackTrace();
      }
    }
    return null;
  }
  
  public static Bitmap transPathToBitmap(String paramString, ApkgInfo paramApkgInfo)
  {
    return paramApkgInfo.getBitmap(paramApkgInfo.getFilePath(paramString));
  }
  
  public TabBarInfo clone()
  {
    try
    {
      localTabBarInfo1 = (TabBarInfo)super.clone();
      try
      {
        localTabBarInfo1.list = new LinkedList();
        Iterator localIterator = this.list.iterator();
        for (;;)
        {
          Object localObject = localTabBarInfo1;
          if (!localIterator.hasNext()) {
            break;
          }
          localObject = (ButtonInfo)localIterator.next();
          localTabBarInfo1.list.add(((ButtonInfo)localObject).clone());
        }
        localThrowable1.printStackTrace();
      }
      catch (Throwable localThrowable1) {}
    }
    catch (Throwable localThrowable2)
    {
      for (;;)
      {
        TabBarInfo localTabBarInfo2;
        TabBarInfo localTabBarInfo1 = null;
      }
    }
    localTabBarInfo2 = localTabBarInfo1;
    return localTabBarInfo2;
  }
  
  public boolean isShow()
  {
    return this.isShow;
  }
  
  public void setShow(boolean paramBoolean)
  {
    this.isShow = paramBoolean;
  }
  
  public static class ButtonInfo
    implements Cloneable
  {
    public Bitmap iconBitmap;
    public String iconData;
    public String iconPath;
    public String pagePath;
    public Bitmap selectedBitmap;
    public String selectedIconData;
    public String selectedIconPath;
    public String text;
    
    public static ButtonInfo parse(JSONObject paramJSONObject, ApkgInfo paramApkgInfo)
    {
      ButtonInfo localButtonInfo = new ButtonInfo();
      if (paramJSONObject != null)
      {
        localButtonInfo.pagePath = paramJSONObject.optString("pagePath");
        localButtonInfo.text = paramJSONObject.optString("text");
        localButtonInfo.iconData = paramJSONObject.optString("iconData");
        localButtonInfo.iconPath = paramJSONObject.optString("iconPath");
        localButtonInfo.selectedIconData = paramJSONObject.optString("selectedIconData");
        localButtonInfo.selectedIconPath = paramJSONObject.optString("selectedIconPath");
        if (TextUtils.isEmpty(localButtonInfo.iconPath)) {
          break label118;
        }
      }
      label118:
      for (localButtonInfo.iconBitmap = TabBarInfo.transPathToBitmap(localButtonInfo.iconPath, paramApkgInfo); !TextUtils.isEmpty(localButtonInfo.selectedIconPath); localButtonInfo.iconBitmap = TabBarInfo.transDataToBitmap(localButtonInfo.iconData))
      {
        localButtonInfo.selectedBitmap = TabBarInfo.transPathToBitmap(localButtonInfo.selectedIconPath, paramApkgInfo);
        return localButtonInfo;
      }
      localButtonInfo.selectedBitmap = TabBarInfo.transDataToBitmap(localButtonInfo.selectedIconData);
      return localButtonInfo;
    }
    
    public ButtonInfo clone()
    {
      try
      {
        ButtonInfo localButtonInfo = (ButtonInfo)super.clone();
        return localButtonInfo;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.apkg.TabBarInfo
 * JD-Core Version:    0.7.0.1
 */