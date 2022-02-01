package me.ele.uetool;

import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.os.Build.VERSION;
import android.text.Layout;
import android.util.Pair;
import android.view.View;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.ele.uetool.base.DimenUtil;
import me.ele.uetool.base.Element;
import me.ele.uetool.base.IAttrs;
import me.ele.uetool.base.item.AddMinusEditItem;
import me.ele.uetool.base.item.BitmapItem;
import me.ele.uetool.base.item.EditTextItem;
import me.ele.uetool.base.item.Item;
import me.ele.uetool.base.item.SwitchItem;
import me.ele.uetool.base.item.TextItem;
import me.ele.uetool.base.item.TitleItem;
import me.ele.uetool.util.AccessibilityUtil;
import me.ele.uetool.util.Util;
import me.ele.uetool.util.ViewKnife;

public class UETCore
  implements IAttrs
{
  private static final String TAG = "UETCore";
  private static boolean devFlag = false;
  public static List<String> reason;
  
  public static boolean getDevFlag()
  {
    return devFlag;
  }
  
  public static void setDevFlag(boolean paramBoolean)
  {
    devFlag = paramBoolean;
  }
  
  public List<Item> getAttrs(Element paramElement)
  {
    ArrayList localArrayList = new ArrayList();
    View localView = paramElement.getView();
    localArrayList.add(new SwitchItem("移动模式", paramElement, 2));
    localArrayList.add(new SwitchItem("多选模式", paramElement, 6));
    boolean bool;
    if (localView.getVisibility() == 0) {
      bool = false;
    }
    for (;;)
    {
      localArrayList.add(new SwitchItem("移除", paramElement, 7, bool));
      try
      {
        if (Build.VERSION.SDK_INT >= 16)
        {
          localObject1 = new SwitchItem("背景色板", paramElement, 0);
          ((SwitchItem)localObject1).setCallBack(new UETCore.1(this, localView));
          localArrayList.add(localObject1);
        }
        localArrayList.add(new TextItem("数据摘要", "发送好友", new UETCore.2(this)));
        localArrayList.add(new TextItem("数据摘要", "删除修改缓存", new UETCore.3(this)));
        Object localObject1 = AttrsManager.createAttrs(localView);
        if (localObject1 != null) {
          localArrayList.addAll(((IAttrs)localObject1).getAttrs(paramElement));
        }
        localObject1 = ViewKnife.getMargin(paramElement);
        localArrayList.add(new AddMinusEditItem("上外边距（dp）", paramElement, 10, DimenUtil.px2dip(localObject1[1])));
        localArrayList.add(new AddMinusEditItem("左外边距（dp）", paramElement, 11, DimenUtil.px2dip(localObject1[0])));
        localObject1 = new EditTextItem("透明度", paramElement, -1, String.valueOf(localView.getAlpha()));
        ((EditTextItem)localObject1).setCallBack(new UETCore.4(this));
        localArrayList.add(localObject1);
        try
        {
          localObject3 = Util.getBackground(localView);
          if ((localObject3 instanceof String)) {
            break label650;
          }
          if (localObject3 != null) {
            break label609;
          }
        }
        catch (Exception localException2)
        {
          for (;;)
          {
            Object localObject3;
            localException2.printStackTrace();
            continue;
            Object localObject2 = localObject3;
            if (localObject3 == null) {
              localObject2 = "null";
            }
          }
        }
        localObject1 = new EditTextItem("背景颜色", paramElement, -1, (String)localObject1);
        ((EditTextItem)localObject1).setCallBack(new UETCore.5(this));
        localArrayList.add(localObject1);
        localArrayList.add(new AddMinusEditItem("宽（dp）", paramElement, 4, DimenUtil.px2dip(localView.getWidth())));
        localArrayList.add(new AddMinusEditItem("高（dp）", paramElement, 5, DimenUtil.px2dip(localView.getHeight())));
        localArrayList.add(new AddMinusEditItem("左内边距（dp）", paramElement, 6, DimenUtil.px2dip(localView.getPaddingLeft())));
        localArrayList.add(new AddMinusEditItem("右内边距（dp）", paramElement, 7, DimenUtil.px2dip(localView.getPaddingRight())));
        localArrayList.add(new AddMinusEditItem("上内边距（dp）", paramElement, 8, DimenUtil.px2dip(localView.getPaddingTop())));
        localArrayList.add(new AddMinusEditItem("下内边距（dp）", paramElement, 9, DimenUtil.px2dip(localView.getPaddingBottom())));
        localObject1 = new SwitchItem("开发者属性", paramElement, 0, devFlag);
        ((SwitchItem)localObject1).setCallBack(null);
        localArrayList.add(localObject1);
        if (devFlag) {
          localArrayList.addAll(new DevAttrs().getAttrs(paramElement));
        }
        return localArrayList;
        bool = true;
      }
      catch (Exception localException1)
      {
        for (;;)
        {
          localException1.printStackTrace();
          continue;
          label609:
          if ((localObject3 instanceof Bitmap)) {
            localArrayList.add(new BitmapItem("背景图片", (Bitmap)localObject3));
          }
        }
      }
    }
  }
  
  static class AttrsManager
  {
    public static IAttrs createAttrs(View paramView)
    {
      if ((paramView instanceof TextView)) {
        return new UETCore.UETTextView();
      }
      if ((paramView instanceof ImageView)) {
        return new UETCore.UETImageView();
      }
      if ((paramView instanceof WebView)) {}
      return null;
    }
  }
  
  public static class DevAttrs
    implements IAttrs
  {
    public List<Item> getAttrs(Element paramElement)
    {
      View localView = paramElement.getView();
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new TitleItem("Dev"));
      localArrayList.add(new SwitchItem("ValidViews", paramElement, 3));
      localArrayList.add(new TextItem("Class", localView.getClass().getName()));
      try
      {
        localArrayList.add(new TextItem("ViewRes", Util.getResourceName(Util.getImageBgName(localView))));
        localArrayList.add(new SwitchItem("show on layers", paramElement, 5));
        localArrayList.add(new TextItem("Fragment", Util.getCurrentFragmentName(paramElement.getView()), new UETCore.DevAttrs.1(this)));
        localArrayList.add(new TextItem("Id", Util.getResId(localView)));
        if (Build.VERSION.SDK_INT >= 23) {
          localArrayList.add(new TextItem("AccessibilityClassName", localView.getAccessibilityClassName().toString()));
        }
        localArrayList.add(new TextItem("ContentDescription", (String)localView.getContentDescription()));
        if (!AccessibilityUtil.getIgnored(localView))
        {
          bool = true;
          localArrayList.add(new TextItem("AccessibilityFocus", String.valueOf(bool).toUpperCase()));
          if (!bool) {
            break label384;
          }
          paramElement = AccessibilityUtil.getFocusableReasons(localView);
          localArrayList.add(new TextItem("AccessibilityFocus reason", paramElement));
          localArrayList.add(new TextItem("ResName", Util.getResourceName(localView.getId())));
          localArrayList.add(new TextItem("Clickable", Boolean.toString(localView.isClickable()).toUpperCase()));
          localArrayList.add(new TextItem("Focused", Boolean.toString(localView.isFocused()).toUpperCase()));
          return localArrayList;
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          localException.printStackTrace();
          continue;
          boolean bool = false;
          continue;
          label384:
          paramElement = AccessibilityUtil.getIgnoredReasons(localView);
        }
      }
    }
  }
  
  static class UETImageView
    implements IAttrs
  {
    public List<Item> getAttrs(Element paramElement)
    {
      ArrayList localArrayList = new ArrayList();
      localArrayList.add(new BitmapItem("图片", Util.getImageViewBitmap((ImageView)paramElement.getView())));
      return localArrayList;
    }
  }
  
  static class UETTextView
    implements IAttrs
  {
    public List<Item> getAttrs(Element paramElement)
    {
      ArrayList localArrayList = new ArrayList();
      TextView localTextView = (TextView)paramElement.getView();
      localArrayList.add(new EditTextItem("文本内容", paramElement, 1, localTextView.getText().toString()));
      Object localObject = localTextView.getLayout();
      if (localObject != null)
      {
        localArrayList.add(new TextItem("文本框下内边距（dp）", "" + ((Layout)localObject).getBottomPadding()));
        localArrayList.add(new TextItem("文本框上内边距（dp）", "" + ((Layout)localObject).getTopPadding()));
      }
      localObject = new AddMinusEditItem("字号（px）", paramElement, 2, localTextView.getTextSize() + "");
      ((AddMinusEditItem)localObject).setAddMin(new UETCore.UETTextView.1(this));
      localArrayList.add(localObject);
      localArrayList.add(new EditTextItem("文字颜色", paramElement, 3, Util.intToHexColor(localTextView.getCurrentTextColor())));
      localObject = Util.getTextViewBitmap(localTextView).iterator();
      while (((Iterator)localObject).hasNext())
      {
        Pair localPair = (Pair)((Iterator)localObject).next();
        localArrayList.add(new BitmapItem((String)localPair.first, (Bitmap)localPair.second));
      }
      if (localTextView.getTypeface() != null) {}
      for (boolean bool = localTextView.getTypeface().isBold();; bool = false)
      {
        localArrayList.add(new SwitchItem("文字加粗", paramElement, 1, bool));
        return localArrayList;
      }
    }
  }
  
  static class UETWebView
    implements IAttrs
  {
    final String toolUrl = "javascript:(function () { var script = document.createElement('script'); script.src=\"https://cdn.jsdelivr.net/npm/eruda\"; document.body.appendChild(script); script.onload = function () { eruda.init() } })();\n";
    
    public List<Item> getAttrs(Element paramElement)
    {
      ArrayList localArrayList = new ArrayList();
      WebView localWebView = (WebView)paramElement.getView();
      paramElement = new SwitchItem("WebView调试", paramElement, 0);
      paramElement.setCallBack(new UETCore.UETWebView.1(this, localWebView));
      localArrayList.add(paramElement);
      return localArrayList;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     me.ele.uetool.UETCore
 * JD-Core Version:    0.7.0.1
 */