import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextPaint;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import com.tencent.biz.pubaccount.readinjoy.view.pullrefresh.RefreshAnimView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.AbstractGifImage;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.mobileqq.emoticon.QQSysFaceUtil;
import com.tencent.mobileqq.text.QQText;
import com.tencent.mobileqq.transfile.URLDrawableHelper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.qphone.base.util.QLog;
import com.tencent.viola.adapter.VComponentAdapter;
import com.tencent.viola.commons.ImageAdapterHolder;
import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.ui.component.image.ImageAction;
import com.tencent.viola.ui.view.VImageView;
import com.tencent.viola.ui.view.VRefreshLayout;
import com.tencent.viola.utils.ViolaLogUtils;
import java.io.File;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class tuv
  implements VComponentAdapter
{
  private Set<URLDrawable> jdField_a_of_type_JavaUtilSet = new HashSet();
  private boolean jdField_a_of_type_Boolean;
  
  private Bundle a(URLDrawable paramURLDrawable)
  {
    Bundle localBundle = new Bundle();
    if (paramURLDrawable == null) {}
    do
    {
      return null;
      paramURLDrawable = paramURLDrawable.getFileInLocal();
    } while ((paramURLDrawable == null) || (!paramURLDrawable.exists()));
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramURLDrawable.getAbsolutePath(), localOptions);
    localBundle.putInt(ImageAdapterHolder.BUNDLE_WIDTH, localOptions.outWidth);
    localBundle.putInt(ImageAdapterHolder.BUNDLE_HEIGHT, localOptions.outHeight);
    return localBundle;
  }
  
  public static URLDrawable.URLDrawableOptions a(boolean paramBoolean, int paramInt1, int paramInt2)
  {
    URLDrawable.URLDrawableOptions localURLDrawableOptions = URLDrawable.URLDrawableOptions.obtain();
    localURLDrawableOptions.mFailedDrawable = URLDrawableHelper.TRANSPARENT;
    localURLDrawableOptions.mRequestWidth = paramInt1;
    localURLDrawableOptions.mRequestHeight = paramInt2;
    if (paramBoolean)
    {
      AbstractGifImage.resumeAll();
      localURLDrawableOptions.mPlayGifImage = true;
      return localURLDrawableOptions;
    }
    localURLDrawableOptions.mPlayGifImage = false;
    return localURLDrawableOptions;
  }
  
  private static StringBuilder a(String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    if (i < paramString.length())
    {
      if ((paramString.charAt(i) == '\024') && (i + 2 < paramString.length()))
      {
        int j = (paramString.charAt(i + 1) - 'A') * 128 + paramString.charAt(i + 2) - 65;
        if (QLog.isColorLevel()) {
          QLog.d("ComponentAdapter", 2, "faceIndex:" + j);
        }
        j = QQSysFaceUtil.convertToLocal(j);
        if (j >= 0)
        {
          localStringBuilder.append(paramString.charAt(i));
          localStringBuilder.append((char)j);
        }
        i = i + 1 + 1;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder;
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if ((paramImageAction == null) || (paramImageAction.getTarget() == null) || (paramURLDrawable == null) || (!NetworkUtil.isNetworkAvailable(paramImageAction.getTarget().getContext()))) {}
    do
    {
      return;
      localObject = paramURLDrawable.getTag();
    } while (!(localObject instanceof Integer));
    StringBuilder localStringBuilder1 = new StringBuilder();
    int i = ((Integer)localObject).intValue();
    if (i < 3)
    {
      i += 1;
      paramURLDrawable.setTag(Integer.valueOf(i));
      paramURLDrawable.restartDownload();
      localObject = localStringBuilder1.append("hit restart download, retryCounts: ").append(i).append(", url: ");
      if (paramURLDrawable.getURL() != null) {}
      for (paramImageAction = paramURLDrawable.getURL().toString();; paramImageAction = "null")
      {
        ((StringBuilder)localObject).append(paramImageAction).append(", errorMsg: ").append(paramThrowable.getMessage());
        ViolaLogUtils.d("ComponentAdapter", localStringBuilder1.toString());
        return;
      }
    }
    StringBuilder localStringBuilder2 = localStringBuilder1.append("reach max restart count, ").append(", url: ");
    if (paramURLDrawable.getURL() != null) {}
    for (Object localObject = paramURLDrawable.getURL().toString();; localObject = "null")
    {
      localStringBuilder2.append((String)localObject).append(", errorMsg: ").append(paramThrowable.getMessage());
      paramImageAction.onError();
      this.jdField_a_of_type_JavaUtilSet.remove(paramURLDrawable);
      break;
    }
  }
  
  private void a(ImageAction paramImageAction, URLDrawable paramURLDrawable, boolean paramBoolean)
  {
    String str = null;
    if (paramImageAction == null) {
      return;
    }
    if (paramBoolean) {}
    for (Bundle localBundle = a(paramURLDrawable);; localBundle = null)
    {
      if (paramURLDrawable.getURL() != null) {
        str = paramURLDrawable.getURL().toString();
      }
      paramImageAction.onSuccess(paramURLDrawable, str, localBundle);
      return;
    }
  }
  
  private void a(ImageAction paramImageAction, String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2)
  {
    if ((paramImageAction == null) || (TextUtils.isEmpty(paramString)) || (paramImageAction.getTarget() == null)) {}
    do
    {
      return;
      localObject = paramString;
      if (paramString.startsWith("//")) {
        localObject = "https:" + paramString;
      }
    } while ((!((String)localObject).startsWith("http")) || (a(paramImageAction, (String)localObject, paramBoolean1)));
    paramString = URLDrawable.getDrawable((String)localObject, a(paramBoolean2, paramInt1, paramInt2));
    this.jdField_a_of_type_JavaUtilSet.add(paramString);
    if (QLog.isColorLevel()) {
      QLog.d("ComponentAdapter", 2, "enqueue action, url: " + (String)localObject + ", " + paramImageAction.getTarget().hashCode());
    }
    Object localObject = paramString.getFileInLocal();
    if ((localObject != null) && (((File)localObject).exists()))
    {
      a(paramImageAction, paramString, paramBoolean1);
      this.jdField_a_of_type_JavaUtilSet.remove(paramString);
      return;
    }
    paramString.startDownload();
    paramString.setTag(Integer.valueOf(0));
    paramString.setURLDrawableListener(new tux(this, paramBoolean1, paramImageAction));
  }
  
  private boolean a(ImageAction paramImageAction, String paramString, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return false;
      if (paramString.contains("item_image_width"))
      {
        Object localObject2 = Uri.parse(paramString);
        Object localObject1 = ((Uri)localObject2).getQueryParameter("item_image_width");
        String str = ((Uri)localObject2).getQueryParameter("item_image_height");
        if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (!TextUtils.isEmpty(str))) {
          try
          {
            int j = paramString.indexOf("?item_image_width");
            int i = j;
            if (j == -1) {
              i = paramString.indexOf("&item_image_width");
            }
            localObject2 = paramString.substring(0, i);
            i = Integer.parseInt((String)localObject1);
            j = Integer.parseInt(str);
            localObject1 = new tlw();
            ((tlw)localObject1).jdField_a_of_type_JavaNetURL = new URL((String)localObject2);
            ((tlw)localObject1).jdField_a_of_type_Int = i;
            ((tlw)localObject1).b = j;
            localObject2 = tlv.a().a((tlw)localObject1);
            if ((localObject2 != null) && (((tls)localObject2).a() != null))
            {
              localObject1 = null;
              if (paramBoolean)
              {
                localObject1 = new Bundle();
                ((Bundle)localObject1).putInt(ImageAdapterHolder.BUNDLE_WIDTH, i);
                ((Bundle)localObject1).putInt(ImageAdapterHolder.BUNDLE_HEIGHT, j);
              }
              paramImageAction.onSuccess(((tls)localObject2).a(), paramString, (Bundle)localObject1);
              return true;
            }
          }
          catch (Exception paramImageAction)
          {
            ViolaLogUtils.e("ComponentAdapter", "parse view width and height error: " + paramImageAction.getMessage());
          }
        }
      }
    }
    return false;
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_JavaUtilSet != null) && (!this.jdField_a_of_type_JavaUtilSet.isEmpty())) {
      this.jdField_a_of_type_JavaUtilSet.clear();
    }
  }
  
  public void initKdRefresh(VRefreshLayout paramVRefreshLayout)
  {
    PullRefreshHeader localPullRefreshHeader = (PullRefreshHeader)LayoutInflater.from(paramVRefreshLayout.getContext()).inflate(2131562746, paramVRefreshLayout, false);
    RefreshAnimView localRefreshAnimView = (RefreshAnimView)localPullRefreshHeader.findViewById(2131376452);
    paramVRefreshLayout.addView(localPullRefreshHeader);
    paramVRefreshLayout.setonRefreshStateChangeListener(new tuw(this, localRefreshAnimView, paramVRefreshLayout));
  }
  
  public void onClick(View paramView, Object paramObject)
  {
    tzz.a(paramView, paramObject);
  }
  
  public void onDoubleClick(View paramView, Object paramObject)
  {
    tzz.a(paramView, paramObject);
  }
  
  public void onVRParamsChange(View paramView, Object paramObject)
  {
    tzz.a(paramView, paramObject);
  }
  
  public void requestImage(String paramString, int paramInt1, int paramInt2, boolean paramBoolean1, ImageAction paramImageAction, boolean paramBoolean2)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramImageAction == null) || (paramImageAction.getTarget() == null)) {
      return;
    }
    if ((paramInt2 == 0) || (paramInt1 == 0)) {
      ViolaLogUtils.d("ComponentAdapter", "width: " + paramInt1 + ", height: " + paramInt2 + ", url: " + paramString);
    }
    a(paramImageAction, paramString, paramInt1, paramInt2, paramBoolean1, paramBoolean2);
  }
  
  public CharSequence setEmoticonText(@NonNull CharSequence paramCharSequence, int paramInt1, int paramInt2)
  {
    if (TextUtils.isEmpty(paramCharSequence)) {
      return "";
    }
    for (;;)
    {
      try
      {
        paramCharSequence = a(paramCharSequence.toString());
        if (paramInt2 != -1.0F)
        {
          paramCharSequence = new QQText(paramCharSequence, 2, paramInt2);
          return paramCharSequence;
        }
      }
      catch (Throwable paramCharSequence)
      {
        QLog.e("ComponentAdapter", 1, "setEmoticonTextError: " + paramCharSequence.getMessage());
        return "";
      }
      paramInt2 = (int)(paramInt1 / 2.5D);
    }
  }
  
  public void setImage(String paramString, VImageView paramVImageView, ImageAdapterHolder paramImageAdapterHolder, ViolaInstance paramViolaInstance, boolean paramBoolean) {}
  
  public void setImgSpan(String paramString, int paramInt1, int paramInt2, ImageAdapterHolder paramImageAdapterHolder) {}
  
  public boolean useCustomFont(TextPaint paramTextPaint, String paramString, int paramInt)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramTextPaint == null)) {}
    label94:
    for (;;)
    {
      return false;
      String str = null;
      if (paramString.equals("DIN")) {
        str = "fonts/DIN Alternate.ttf";
      }
      for (;;)
      {
        if (str == null) {
          break label94;
        }
        paramString = Typeface.createFromAsset(BaseApplicationImpl.getApplication().getAssets(), str);
        if (paramString == null) {
          break;
        }
        paramTextPaint.setTypeface(paramString);
        return true;
        if (paramString.equals("bebas")) {
          str = "fonts/readinjoy_operation_bar_number.ttf";
        } else if ("din-black".equals(paramString)) {
          str = "fonts/DINBlack.ttf";
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tuv
 * JD-Core Version:    0.7.0.1
 */