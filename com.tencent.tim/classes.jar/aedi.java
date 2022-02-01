import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.colornote.data.ColorNote;
import com.tencent.mobileqq.colornote.settings.HistoryFormItem;
import com.tencent.qphone.base.util.QLog;
import java.net.MalformedURLException;
import java.net.URL;

public class aedi
{
  private int a(ColorNote paramColorNote)
  {
    switch (aebs.gV(paramColorNote.getServiceType()) & 0xFFFF0000)
    {
    default: 
      return 2130845244;
    case 16973824: 
      return 2130845188;
    case 17039360: 
      return 2130839453;
    case 16842752: 
      return 2130839454;
    case 16908288: 
      return 2130839455;
    }
    return 2130844988;
  }
  
  private Drawable a(Context paramContext, ColorNote paramColorNote)
  {
    paramContext = paramContext.getResources();
    int i = a(paramColorNote);
    try
    {
      paramColorNote = new URL(paramColorNote.getPicUrl());
      boolean bool = "resdrawable".equals(paramColorNote.getProtocol());
      if (bool) {
        try
        {
          paramColorNote = paramContext.getDrawable(Integer.parseInt(paramColorNote.getHost()));
          return paramColorNote;
        }
        catch (NumberFormatException paramColorNote)
        {
          return paramContext.getDrawable(i);
        }
      }
      URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
      localURLDrawableOptions.mRequestWidth = wja.dp2px(40.0F, paramContext);
      localURLDrawableOptions.mRequestHeight = wja.dp2px(40.0F, paramContext);
      localURLDrawableOptions.mLoadingDrawable = paramContext.getDrawable(i);
      localURLDrawableOptions.mFailedDrawable = localURLDrawableOptions.mLoadingDrawable;
      paramColorNote = URLDrawable.getDrawable(paramColorNote, localURLDrawableOptions);
      return paramColorNote;
    }
    catch (MalformedURLException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
      return paramContext;
    }
    catch (NullPointerException paramColorNote)
    {
      paramContext = paramContext.getDrawable(i);
      QLog.e("DefaultFormItemBuilder", 1, paramColorNote, new Object[0]);
    }
    return paramContext;
  }
  
  public HistoryFormItem a(Context paramContext, ColorNote paramColorNote)
  {
    HistoryFormItem localHistoryFormItem = new HistoryFormItem(paramContext);
    localHistoryFormItem.setLeftText(paramColorNote.getMainTitle());
    localHistoryFormItem.setLeftIcon(a(paramContext, paramColorNote), paramContext.getResources().getDimensionPixelSize(2131299387), paramContext.getResources().getDimensionPixelSize(2131299386));
    return localHistoryFormItem;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aedi
 * JD-Core Version:    0.7.0.1
 */